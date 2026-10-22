package com.android.contacts.voicemail;

import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.common.io.MoreCloseables;
import com.android.contacts.CallDetailActivity;
import com.android.contacts.ProximitySensorAware;
import com.android.contacts.R;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class VoicemailPlaybackFragment extends Fragment {
    private static final String[] HAS_CONTENT_PROJECTION = null;
    private static final int NUMBER_OF_THREADS_IN_POOL = 2;
    private static final String TAG = "VoicemailPlayback";
    private View mPlaybackLayout;
    private ScheduledExecutorService mScheduledExecutorService;

    /* JADX INFO: renamed from: com.android.contacts.voicemail.VoicemailPlaybackFragment$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class ActivityReference {
        final /* synthetic */ VoicemailPlaybackFragment this$0;

        private ActivityReference(VoicemailPlaybackFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ActivityReference(VoicemailPlaybackFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        public final Activity get() {
            return this.this$0.getActivity();
        }
    }

    public interface PlaybackView {
        void disableProximitySensor();

        void disableUiElements();

        void enableProximitySensor();

        void enableUiElements();

        void finish();

        Context getDataSourceContext();

        int getDesiredClipPosition();

        boolean isSpeakerPhoneOn();

        void playbackError(Exception r1);

        void playbackStarted();

        void playbackStopped();

        boolean queryHasContent(Uri r1);

        void registerContentObserver(Uri r1, ContentObserver r2);

        void runOnUiThread(Runnable r1);

        void sendFetchVoicemailRequest(Uri r1);

        void setClipPosition(int r1, int r2);

        void setFetchContentTimeout();

        void setIsBuffering();

        void setIsFetchingContent();

        void setPositionSeekListener(SeekBar.OnSeekBarChangeListener r1);

        void setRateDecreaseButtonListener(View.OnClickListener r1);

        void setRateDisplay(float r1, int r2);

        void setRateIncreaseButtonListener(View.OnClickListener r1);

        void setSpeakerPhoneOn(boolean r1);

        void setSpeakerphoneListener(View.OnClickListener r1);

        void setStartStopListener(View.OnClickListener r1);

        void setVolumeControlStream(int r1);

        void unregisterContentObserver(ContentObserver r1);
    }

    private static final class PlaybackViewImpl implements PlaybackView {
        private final ActivityReference mActivityReference;
        private final Context mApplicationContext;
        private final SeekBar mPlaybackSeek;
        private final ImageButton mPlaybackSpeakerphone;
        private final ImageButton mRateDecreaseButton;
        private final ImageButton mRateIncreaseButton;
        private final ImageButton mStartStopButton;
        private final TextViewWithMessagesController mTextController;

        public PlaybackViewImpl(ActivityReference r2, Context r3, View r4) {
            Preconditions.checkNotNull(r2);
            Preconditions.checkNotNull(r3);
            Preconditions.checkNotNull(r4);
            this.mActivityReference = r2;
            this.mApplicationContext = r3;
            this.mPlaybackSeek = (SeekBar) r4.findViewById(R.id.playback_seek);
            this.mStartStopButton = (ImageButton) r4.findViewById(R.id.playback_start_stop);
            this.mPlaybackSpeakerphone = (ImageButton) r4.findViewById(R.id.playback_speakerphone);
            this.mRateDecreaseButton = (ImageButton) r4.findViewById(R.id.rate_decrease_button);
            this.mRateIncreaseButton = (ImageButton) r4.findViewById(R.id.rate_increase_button);
            this.mTextController = new TextViewWithMessagesController((TextView) r4.findViewById(R.id.playback_position_text), (TextView) r4.findViewById(R.id.playback_speed_text));
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public void finish() {
            Activity r0 = this.mActivityReference.get();
            if (r0 == null) goto L6;
            r0.finish();
            return;
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public void runOnUiThread(Runnable r1) {
            Activity r0 = this.mActivityReference.get();
            if (r0 == null) goto L6;
            r0.runOnUiThread(r1);
            return;
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public Context getDataSourceContext() {
            return this.mApplicationContext;
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public void setRateDecreaseButtonListener(View.OnClickListener r1) {
            this.mRateDecreaseButton.setOnClickListener(r1);
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public void setRateIncreaseButtonListener(View.OnClickListener r1) {
            this.mRateIncreaseButton.setOnClickListener(r1);
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public void setStartStopListener(View.OnClickListener r1) {
            this.mStartStopButton.setOnClickListener(r1);
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public void setSpeakerphoneListener(View.OnClickListener r1) {
            this.mPlaybackSpeakerphone.setOnClickListener(r1);
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public void setRateDisplay(float r3, int r4) {
            this.mTextController.setTemporaryText(this.mApplicationContext.getString(r4), 1, TimeUnit.SECONDS);
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public void setPositionSeekListener(SeekBar.OnSeekBarChangeListener r1) {
            this.mPlaybackSeek.setOnSeekBarChangeListener(r1);
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public void playbackStarted() {
            this.mStartStopButton.setImageResource(R.drawable.ic_hold_pause_holo_dark);
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public void playbackStopped() {
            this.mStartStopButton.setImageResource(R.drawable.ic_play);
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public void enableProximitySensor() {
            ComponentCallbacks2 r1 = this.mActivityReference.get();
            if (r1 != null) goto L5;
            return;
        L5:
            if ((r1 instanceof ProximitySensorAware) == false) goto L9;
            ((ProximitySensorAware) r1).enableProximitySensor();
            return;
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public void disableProximitySensor() {
            ComponentCallbacks2 r1 = this.mActivityReference.get();
            if (r1 != null) goto L5;
            return;
        L5:
            if ((r1 instanceof ProximitySensorAware) == false) goto L9;
            ((ProximitySensorAware) r1).disableProximitySensor(true);
            return;
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public void registerContentObserver(Uri r2, ContentObserver r3) {
            this.mApplicationContext.getContentResolver().registerContentObserver(r2, false, r3);
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public void unregisterContentObserver(ContentObserver r1) {
            this.mApplicationContext.getContentResolver().unregisterContentObserver(r1);
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public void setClipPosition(int r2, int r3) {
            int r4 = Math.max(0, r2);
            int r5 = Math.max(r4, r3);
            if (this.mPlaybackSeek.getMax() == r5) goto L5;
            this.mPlaybackSeek.setMax(r5);
        L5:
            this.mPlaybackSeek.setProgress(r4);
            this.mTextController.setPermanentText(VoicemailPlaybackFragment.access$100(r5 - r4));
        }

        private String getString(int r1) {
            return this.mApplicationContext.getString(r1);
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public void setIsBuffering() {
            disableUiElements();
            this.mTextController.setPermanentText(getString(R.string.voicemail_buffering));
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public void setIsFetchingContent() {
            disableUiElements();
            this.mTextController.setPermanentText(getString(R.string.voicemail_fetching_content));
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public void setFetchContentTimeout() {
            disableUiElements();
            this.mTextController.setPermanentText(getString(R.string.voicemail_fetching_timout));
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public int getDesiredClipPosition() {
            return this.mPlaybackSeek.getProgress();
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public void disableUiElements() {
            this.mRateIncreaseButton.setEnabled(false);
            this.mRateDecreaseButton.setEnabled(false);
            this.mStartStopButton.setEnabled(false);
            this.mPlaybackSpeakerphone.setEnabled(false);
            this.mPlaybackSeek.setProgress(0);
            this.mPlaybackSeek.setEnabled(false);
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public void playbackError(Exception r3) {
            disableUiElements();
            this.mTextController.setPermanentText(getString(R.string.voicemail_playback_error));
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(VoicemailPlaybackFragment.TAG, "Could not play voicemail", r3);
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public void enableUiElements() {
            this.mRateIncreaseButton.setEnabled(true);
            this.mRateDecreaseButton.setEnabled(true);
            this.mStartStopButton.setEnabled(true);
            this.mPlaybackSpeakerphone.setEnabled(true);
            this.mPlaybackSeek.setEnabled(true);
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public void sendFetchVoicemailRequest(Uri r3) {
            Intent r0 = new Intent("android.intent.action.FETCH_VOICEMAIL", r3);
            this.mApplicationContext.sendBroadcast(r0);
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public boolean queryHasContent(Uri r7) {
            Cursor r6 = this.mApplicationContext.getContentResolver().query(r7, VoicemailPlaybackFragment.access$200(), null, null, null);
            boolean r8 = false;
            if (r6 != null) goto L17;
        L15:
            MoreCloseables.closeQuietly(r6);
            return false;
        L17:
        L12:
            th = move-exception;
            MoreCloseables.closeQuietly(r6);
            throw th;
        L5:
            if (r6.moveToNext() == false) goto L15;
            if (r6.getInt(r6.getColumnIndexOrThrow("has_content")) != 1) goto L10;
            r8 = true;
        L10:
            MoreCloseables.closeQuietly(r6);
            return r8;
        }

        private AudioManager getAudioManager() {
            return (AudioManager) this.mApplicationContext.getSystemService("audio");
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public boolean isSpeakerPhoneOn() {
            return getAudioManager().isSpeakerphoneOn();
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public void setSpeakerPhoneOn(boolean r2) {
            getAudioManager().setSpeakerphoneOn(r2);
            if (r2 == false) goto L5;
            this.mPlaybackSpeakerphone.setImageResource(R.drawable.ic_speakerphone_on);
            return;
        L5:
            this.mPlaybackSpeakerphone.setImageResource(R.drawable.ic_speakerphone_off);
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackFragment.PlaybackView
        public void setVolumeControlStream(int r1) {
            Activity r0 = this.mActivityReference.get();
            if (r0 == null) goto L6;
            r0.setVolumeControlStream(r1);
            return;
        }
    }

    private static final class TextViewWithMessagesController {
        private static final float INVISIBLE = 0.0f;
        private static final long LONG_ANIMATION_MS = 400;
        private static final long SHORT_ANIMATION_MS = 200;
        private static final float VISIBLE = 1.0f;
        private final Object mLock;
        private final TextView mPermanentTextView;
        private Runnable mRunnable;
        private final TextView mTemporaryTextView;

        static /* synthetic */ Object access$300(TextViewWithMessagesController r0) {
            return r0.mLock;
        }

        static /* synthetic */ Runnable access$400(TextViewWithMessagesController r0) {
            return r0.mRunnable;
        }

        static /* synthetic */ Runnable access$402(TextViewWithMessagesController r0, Runnable r1) {
            r0.mRunnable = r1;
            return r1;
        }

        static /* synthetic */ TextView access$500(TextViewWithMessagesController r0) {
            return r0.mTemporaryTextView;
        }

        static /* synthetic */ TextView access$600(TextViewWithMessagesController r0) {
            return r0.mPermanentTextView;
        }

        public TextViewWithMessagesController(TextView r2, TextView r3) {
            this.mLock = new Object();
            this.mPermanentTextView = r2;
            this.mTemporaryTextView = r3;
        }

        public void setPermanentText(String r1) {
            this.mPermanentTextView.setText(r1);
        }

        public void setTemporaryText(String r5, long r6, TimeUnit r8) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mTemporaryTextView.setText(r5);     // Catch: Throwable -> L7
            this.mTemporaryTextView.animate().alpha(1.0f).setDuration(200);     // Catch: Throwable -> L7
            this.mPermanentTextView.animate().alpha(0.0f).setDuration(200);     // Catch: Throwable -> L7
            Runnable r7 = new AnonymousClass1(this);     // Catch: Throwable -> L7
            this.mRunnable = r7;     // Catch: Throwable -> L7
            this.mTemporaryTextView.postDelayed(r7, r8.toMillis(r6));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public VoicemailPlaybackFragment() {
    }

    static /* synthetic */ String access$100(int r0) {
        return formatAsMinutesAndSeconds(r0);
    }

    static /* synthetic */ String[] access$200() {
        return HAS_CONTENT_PROJECTION;
    }

    static {
        HAS_CONTENT_PROJECTION = new String[]{"has_content"};
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        View r4 = r1.inflate(R.layout.playback_layout, null);
        this.mPlaybackLayout = r4;
        return r4;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        this.mScheduledExecutorService = createScheduledExecutorService();
        Bundle r4 = getArguments();
        Preconditions.checkNotNull(r4, "fragment must be started with arguments");
        Preconditions.checkNotNull((Uri) r4.getParcelable(CallDetailActivity.EXTRA_VOICEMAIL_URI), "fragment must contain EXTRA_VOICEMAIL_URI");
        r4.getBoolean(CallDetailActivity.EXTRA_VOICEMAIL_START_PLAYBACK, false);
        ((PowerManager) getActivity().getSystemService("power")).newWakeLock(6, getClass().getSimpleName());
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle r1) {
        super.onSaveInstanceState(r1);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        this.mScheduledExecutorService.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
    }

    private PlaybackViewImpl createPlaybackViewImpl() {
        return new PlaybackViewImpl(new ActivityReference(this, null), getActivity().getApplicationContext(), this.mPlaybackLayout);
    }

    private ScheduledExecutorService createScheduledExecutorService() {
        return Executors.newScheduledThreadPool(2);
    }

    private static String formatAsMinutesAndSeconds(int r3) {
        int r4 = r3 / 1000;
        int r0 = r4 / 60;
        int r5 = r4 - (r0 * 60);
        if (r0 <= 99) goto L6;
        r0 = 99;
    L6:
        return String.format("%02d:%02d", new Object[]{Integer.valueOf(r0), Integer.valueOf(r5)});
    }
}
