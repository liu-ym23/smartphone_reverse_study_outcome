package com.obric.agent.intents.findphone;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.VibrationAttributes;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ai;
import androidx.core.view.al;
import androidx.core.view.am;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: FindPhoneActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FindPhoneActivity extends AppCompatActivity {
    private static final int AUDIO_ATTR_FLAG_BYPASS_INTERRUPTION_POLICY = 64;
    private static final int BATTERY_CRITERIA_LEVEL = 20;
    private static final int BATTERY_DEFAULT_SCALE = 100;
    public static final a Companion = null;
    private static final long DELTA_TIME_FOR_RESUMED_AND_PAUSED = 200;
    private static final int HANDLE_MSG_CLOSE_TORCH = 23;
    private static final int HANDLE_MSG_OPEN_TORCH = 22;
    private static final int HANDLE_MSG_STOP_NOTIFICATION = 25;
    private static final int HANDLE_MSG_VIBRATOR = 24;
    private static final int HANDLE_MSG_VOLUME_STAGE_2 = 20;
    private static final int HANDLE_MSG_VOLUME_STAGE_3 = 21;
    private static final int MESSAGE_DELAY_IN_MILLS = 1000;
    private static final int NOTIFICATION_LAST_TIME_IN_MILLS = 60000;
    private static final int PERCENT_BASE = 100;
    private static final float PLAYBACK_VOLUME_MAX = 1.0f;
    private static final long VIBRATOR_FREQUENCY = 800;
    private static final int VOLUME_PERCENT_STAGE_1 = 40;
    private static final int VOLUME_PERCENT_STAGE_2 = 70;
    private static final int VOLUME_PERCENT_STAGE_3 = 100;
    private static final long VOLUME_STAGE_2_DELAY_IN_MILLS = 5460;
    private static final long VOLUME_STAGE_3_DELAY_IN_MILLS = 21840;
    private static WeakReference<FindPhoneActivity> aliveRef;
    private AudioFocusRequest audioFocusRequest;
    private AudioManager audioManager;
    private boolean isStopped;
    private AsyncTask<Void, Void, Void> loadTask;
    private int maxAlarmVolume;
    private MediaPlayer mediaPlayer;
    private CountDownTimer notificationEventTimer;
    private PowerManager powerManager;
    private PluginBroadcastReceiver receiver;
    private long resumeTime;
    private com.obric.agent.intents.findphone.b ringManager;
    private int savedAlarmVolume;
    private VaHandler vaHandler;
    private Vibrator vaVibrator;

    /* JADX INFO: compiled from: FindPhoneActivity.kt */
    private final class NotificationEventTimer extends CountDownTimer {
        final /* synthetic */ FindPhoneActivity this$0;

        @Override // android.os.CountDownTimer
        public void onTick(long r1) {
        }

        public NotificationEventTimer(FindPhoneActivity r3, long r4, long r6) {
            this.this$0 = (FindPhoneActivity) ZeusTransformUtils.wrapperContextForParams(r3, FindPhoneActivity.class, "com.obric.aiagent.plugin");
            super(r4, r6);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.this$0.finish();
        }
    }

    /* JADX INFO: compiled from: FindPhoneActivity.kt */
    private final class PlaySoundTask extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ FindPhoneActivity this$0;

        public PlaySoundTask(FindPhoneActivity r3) {
            this.this$0 = (FindPhoneActivity) ZeusTransformUtils.wrapperContextForParams(r3, FindPhoneActivity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.AsyncTask
        public /* synthetic */ Void doInBackground(Void[] r3) {
            return doInBackground2((Void[]) ZeusTransformUtils.preCheckCast(r3, Void[].class, "com.obric.aiagent.plugin"));
        }

        @Override // android.os.AsyncTask
        public /* synthetic */ void onPostExecute(Void r3) {
            onPostExecute2((Void) ZeusTransformUtils.preCheckCast(r3, Void.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        public Void doInBackground2(Void... r7) {
            o.e(r7, "params");
            com.obric.agent.intents.findphone.b r8 = FindPhoneActivity.access$getRingManager$p(this.this$0);
            if (r8 == null) goto L11;
            int r9 = r8.a(0);
            if (r9 != 0) goto L7;
            return null;
        L7:
            AudioAttributes r2 = new AudioAttributes.Builder().setUsage(4).setLegacyStreamType(4).setContentType(4).setFlags(64).build();
            MediaPlayer r10 = MediaPlayer.create((Context) ZeusTransformUtils.preCheckCast(this.this$0, Context.class, "com.obric.aiagent.plugin"), r9, r2, 0);
            if (r10 != null) goto L10;
            return null;
        L10:
            r10.setLooping(true);
            r10.setVolume(FindPhoneActivity.PLAYBACK_VOLUME_MAX, FindPhoneActivity.PLAYBACK_VOLUME_MAX);
            FindPhoneActivity.access$forceSpeakerOutput(this.this$0, r10);
            FindPhoneActivity.access$setMediaPlayer$p(this.this$0, r10);
        L11:
            return null;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        public void onPostExecute2(Void r4) {
            MediaPlayer r5 = FindPhoneActivity.access$getMediaPlayer$p(this.this$0);
            if (r5 != null) goto L5;
            return;
        L5:
            FindPhoneActivity.access$applyAlarmVolumePercent(this.this$0, 40);
            INVOKEVIRTUAL_com_obric_agent_intents_findphone_FindPhoneActivity$PlaySoundTask_com_obric_performance_power_monitor_audio_MediaPlayerLancet_start(r5);
            VaHandler r6 = FindPhoneActivity.access$getVaHandler$p(this.this$0);
            if (r6 == null) goto L8;
            r6.sendEmptyMessageDelayed(20, FindPhoneActivity.VOLUME_STAGE_2_DELAY_IN_MILLS);
        L8:
            VaHandler r3 = FindPhoneActivity.access$getVaHandler$p(this.this$0);
            if (r3 == null) goto L12;
            r3.sendEmptyMessageDelayed(21, FindPhoneActivity.VOLUME_STAGE_3_DELAY_IN_MILLS);
            return;
        }

        public static void INVOKEVIRTUAL_com_obric_agent_intents_findphone_FindPhoneActivity$PlaySoundTask_com_obric_performance_power_monitor_audio_MediaPlayerLancet_start(MediaPlayer r1) {
            if (com.obric.performance.power.monitor.a.f36932a.a() == true) goto L6;
            r1.start();
            return;
        L6:
            r1.start();
            if (ZeusTransformUtils.instanceOf(r1, MediaPlayer.class) == false) goto L10;
            com.obric.performance.power.monitor.a.a.a(r1.hashCode());
            return;
        }
    }

    /* JADX INFO: compiled from: FindPhoneActivity.kt */
    private final class VaHandler extends Handler {
        final /* synthetic */ FindPhoneActivity this$0;

        public VaHandler(FindPhoneActivity r3) {
            this.this$0 = (FindPhoneActivity) ZeusTransformUtils.wrapperContextForParams(r3, FindPhoneActivity.class, "com.obric.aiagent.plugin");
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            o.e(r3, "msg");
            switch(r3.what) {
                case 20: goto L18;
                case 21: goto L17;
                case 22: goto L14;
                case 23: goto L11;
                case 24: goto L7;
                case 25: goto L5;
                default: goto L29;
            };
        L5:
            this.this$0.finish();
            return;
        L11:
            FindPhoneActivity.access$closeFlashLight(this.this$0);
            VaHandler r2 = FindPhoneActivity.access$getVaHandler$p(this.this$0);
            if (r2 == null) goto L24;
            r2.sendEmptyMessageDelayed(22, 1000);
            return;
        L24:
            return;
        L14:
            FindPhoneActivity.access$openFlashLight(this.this$0);
            VaHandler r4 = FindPhoneActivity.access$getVaHandler$p(this.this$0);
            if (r4 == null) goto L26;
            r4.sendEmptyMessageDelayed(23, 1000);
            return;
        L26:
            return;
        L17:
            FindPhoneActivity.access$applyAlarmVolumePercent(this.this$0, 100);
            return;
        L18:
            FindPhoneActivity.access$applyAlarmVolumePercent(this.this$0, 70);
            return;
        L29:
            return;
        L7:
            if (FindPhoneActivity.access$isStopped$p(this.this$0) == true) goto L21;
            FindPhoneActivity.access$startVibrator(this.this$0);
            VaHandler r5 = FindPhoneActivity.access$getVaHandler$p(this.this$0);
            if (r5 == null) goto L22;
            r5.sendEmptyMessageDelayed(24, 1000);
            return;
        L22:
            return;
        }
    }

    /* JADX INFO: compiled from: FindPhoneActivity.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        public static /* synthetic */ void lambda$JStZSwIlweXYEtEIBqF0hR1lK3M() {
            b();
        }

        private a() {
        }

        public final void a() {
            new Handler(Looper.getMainLooper()).post($$Lambda$FindPhoneActivity$a$JStZSwIlweXYEtEIBqF0hR1lK3M.INSTANCE);
        }

        private static final void b() {
            WeakReference r0 = FindPhoneActivity.access$getAliveRef$cp();
            if (r0 == null) goto L5;
            FindPhoneActivity r1 = (FindPhoneActivity) ZeusTransformUtils.preCheckCast(r0.get(), FindPhoneActivity.class, "com.obric.aiagent.plugin");
        L6:
            if (r1 != null) goto L8;
        L10:
            a r2 = FindPhoneActivity.Companion;
            FindPhoneActivity.access$setAliveRef$cp(null);
            return;
        L8:
            if (r1.isFinishing() == true) goto L10;
            r1.finish();
            goto L10
        L5:
            r1 = null;
            goto L6
        }

        public final boolean a(Context r4) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            o.e(r3, "context");
            Intent r5 = ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), 2, "com.obric.aiagent.plugin");
            if (r5 != null) goto L5;
            return false;
        L5:
            int r0 = r5.getIntExtra("scale", -1);
            int r6 = r5.getIntExtra("level", -1);
            if (r0 != 0) goto L9;
            return false;
        L9:
            if (((r6 / r0) * 100) < 20.0f) goto L12;
            return true;
        L12:
            return false;
        }
    }

    /* JADX INFO: compiled from: FindPhoneActivity.kt */
    public static final class b extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FindPhoneActivity f14682a;

        b(FindPhoneActivity r3) {
            this.f14682a = (FindPhoneActivity) ZeusTransformUtils.wrapperContextForParams(r3, FindPhoneActivity.class, "com.obric.aiagent.plugin");
        }

        public void onReceive(Context r3, Intent r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L5;
            return;
        L5:
            String r6 = r4.getAction();
            if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L9;
            return;
        L9:
            if (o.a("android.intent.action.SCREEN_OFF", r6) == false) goto L12;
            this.f14682a.finish();
            return;
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ void lambda$kIbZPmhbURxQgITqXomC8tcCBEw(int r0) {
        onCreate$lambda$1(r0);
    }

    private static final void onCreate$lambda$1(int r0) {
    }

    public FindPhoneActivity() {
        this.savedAlarmVolume = -1;
        this.receiver = (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(new b(this), PluginBroadcastReceiver.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void access$applyAlarmVolumePercent(FindPhoneActivity r2, int r3) {
        ((FindPhoneActivity) ZeusTransformUtils.wrapperContextForParams(r2, FindPhoneActivity.class, "com.obric.aiagent.plugin")).applyAlarmVolumePercent(r3);
    }

    public static final /* synthetic */ void access$closeFlashLight(FindPhoneActivity r2) {
        ((FindPhoneActivity) ZeusTransformUtils.wrapperContextForParams(r2, FindPhoneActivity.class, "com.obric.aiagent.plugin")).closeFlashLight();
    }

    public static final /* synthetic */ void access$forceSpeakerOutput(FindPhoneActivity r2, MediaPlayer r3) {
        ((FindPhoneActivity) ZeusTransformUtils.wrapperContextForParams(r2, FindPhoneActivity.class, "com.obric.aiagent.plugin")).forceSpeakerOutput(r3);
    }

    public static final /* synthetic */ WeakReference access$getAliveRef$cp() {
        return aliveRef;
    }

    public static final /* synthetic */ MediaPlayer access$getMediaPlayer$p(FindPhoneActivity r2) {
        return ((FindPhoneActivity) ZeusTransformUtils.wrapperContextForParams(r2, FindPhoneActivity.class, "com.obric.aiagent.plugin")).mediaPlayer;
    }

    public static final /* synthetic */ com.obric.agent.intents.findphone.b access$getRingManager$p(FindPhoneActivity r2) {
        return ((FindPhoneActivity) ZeusTransformUtils.wrapperContextForParams(r2, FindPhoneActivity.class, "com.obric.aiagent.plugin")).ringManager;
    }

    public static final /* synthetic */ VaHandler access$getVaHandler$p(FindPhoneActivity r2) {
        return ((FindPhoneActivity) ZeusTransformUtils.wrapperContextForParams(r2, FindPhoneActivity.class, "com.obric.aiagent.plugin")).vaHandler;
    }

    public static final /* synthetic */ boolean access$isStopped$p(FindPhoneActivity r2) {
        return ((FindPhoneActivity) ZeusTransformUtils.wrapperContextForParams(r2, FindPhoneActivity.class, "com.obric.aiagent.plugin")).isStopped;
    }

    public static final /* synthetic */ void access$openFlashLight(FindPhoneActivity r2) {
        ((FindPhoneActivity) ZeusTransformUtils.wrapperContextForParams(r2, FindPhoneActivity.class, "com.obric.aiagent.plugin")).openFlashLight();
    }

    public static final /* synthetic */ void access$setAliveRef$cp(WeakReference r0) {
        aliveRef = r0;
    }

    public static final /* synthetic */ void access$setMediaPlayer$p(FindPhoneActivity r2, MediaPlayer r3) {
        ((FindPhoneActivity) ZeusTransformUtils.wrapperContextForParams(r2, FindPhoneActivity.class, "com.obric.aiagent.plugin")).mediaPlayer = r3;
    }

    public static final /* synthetic */ void access$startVibrator(FindPhoneActivity r2) {
        ((FindPhoneActivity) ZeusTransformUtils.wrapperContextForParams(r2, FindPhoneActivity.class, "com.obric.aiagent.plugin")).startVibrator();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r11) {
        super.onCreate(r11);
        a r12 = Companion;
        aliveRef = new WeakReference(this);
        setShowWhenLocked(true);
        Window r1 = getWindow();
        o.c(r1, "getWindow(...)");
        r1.requestFeature(1);
        ai.a(r1, false);
        r1.addFlags(Integer.MIN_VALUE);
        r1.clearFlags(67108864);
        r1.clearFlags(134217728);
        r1.setStatusBarColor(0);
        r1.setNavigationBarColor(0);
        if (Build.VERSION.SDK_INT < 28) goto L5;
        WindowManager.LayoutParams r3 = r1.getAttributes();
        r3.layoutInDisplayCutoutMode = 1;
        r1.setAttributes(r3);
    L5:
        hideSystemBars(r1);
        initScreen((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"));
        saveAlarmVolume();
        $$Lambda$FindPhoneActivity$kIbZPmhbURxQgITqXomC8tcCBEw r2 = $$Lambda$FindPhoneActivity$kIbZPmhbURxQgITqXomC8tcCBEw.INSTANCE;
        this.vaHandler = new VaHandler(this);
        PlaySoundTask r4 = new PlaySoundTask(this);
        r4.execute(new Void[0]);
        this.loadTask = (AsyncTask) ZeusTransformUtils.preCheckCast(r4, AsyncTask.class, "com.obric.aiagent.plugin");
        AudioAttributes r5 = new AudioAttributes.Builder().setUsage(4).setLegacyStreamType(4).build();
        AudioFocusRequest r6 = new AudioFocusRequest.Builder(2).setAudioAttributes(r5).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(r2).build();
        this.audioFocusRequest = r6;
        if (r6 == null) goto L10;
        AudioManager r7 = this.audioManager;
        if (r7 == null) goto L10;
        r7.requestAudioFocus(r6);
    L10:
        loadMainView();
        registerScreenOffReceiver();
        keepScreenOn();
        if (r12.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin")) == true) goto L13;
    L20:
        NotificationEventTimer r13 = new NotificationEventTimer(this, 60000, 60000);
        r13.start();
        this.notificationEventTimer = (CountDownTimer) ZeusTransformUtils.preCheckCast(r13, CountDownTimer.class, "com.obric.aiagent.plugin");
        return;
    L13:
        if (com.obric.agent.intents.findphone.a.f14693a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == 1) goto L17;
        VaHandler r14 = this.vaHandler;
        if (r14 == null) goto L17;
        r14.sendEmptyMessage(22);
    L17:
        VaHandler r15 = this.vaHandler;
        if (r15 == null) goto L20;
        r15.sendEmptyMessage(24);
        goto L20
    }

    private final void forceSpeakerOutput(MediaPlayer r8) {
        AudioManager r7 = this.audioManager;
        if (r7 != null) goto L5;
        return;
    L5:
        AudioDeviceInfo[] r9 = r7.getDevices(2);
        o.c(r9, "getDevices(...)");
        Object[] r10 = (Object[]) ZeusTransformUtils.preCheckCast(r9, Object[].class, "com.obric.aiagent.plugin");
        int r1 = r10.length;
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L14;
        Object r5 = r10[r4];
        if (((AudioDeviceInfo) ZeusTransformUtils.preCheckCast(r5, AudioDeviceInfo.class, "com.obric.aiagent.plugin")).getType() != 2) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == true) goto L15;
        r4 = r4 + 1;
    L15:
        AudioDeviceInfo r11 = (AudioDeviceInfo) ZeusTransformUtils.preCheckCast(r5, AudioDeviceInfo.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L21;
        r8.setPreferredDevice(r11);
        return;
    L21:
        return;
    L10:
        r6 = false;
        goto L11
    L14:
        r5 = null;
        goto L15
    }

    public boolean onTouchEvent(MotionEvent r2) {
        o.e(r2, "event");
        finish();
        return super.onTouchEvent(r2);
    }

    private final void loadMainView() {
        setContentView(ZeusTransformUtils.mapRes(R.layout.activity_find_phone, "layout", "activity_find_phone"));
        setupDynamicBackground();
        loadAvatar();
    }

    private final void setupDynamicBackground() {
        FrameLayout r0 = (FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.find_phone_bg_container, DbHelper.COL_ID, "find_phone_bg_container")), FrameLayout.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        FluidColorfulBlobView r1 = new FluidColorfulBlobView((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), null, 0, 6, null);
        r1.setSpeed(0.7f);
        r1.setTargetFrameRate(30);
        if (isNightMode() == false) goto L8;
        FluidColorfulBlobShader.a r9 = FluidColorfulBlobShader.Companion.b();
    L9:
        r1.setColorTheme(r9);
        r1.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r0.removeAllViews();
        r0.addView((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"));
        return;
    L8:
        r9 = FluidColorfulBlobShader.Companion.a();
        goto L9
    }

    private final boolean isNightMode() {
        if ((ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    private final void loadAvatar() {
        ImageView r2 = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.find_phone_pic, DbHelper.COL_ID, "find_phone_pic")), ImageView.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L14;
        return;
    L14:
        ImageDecoder.Source r5 = ImageDecoder.createSource(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.find_phone_avatar, "drawable", "find_phone_avatar"));     // Catch: Exception -> L12
        o.c(r5, "createSource(...)");     // Catch: Exception -> L12
        Drawable r6 = ImageDecoder.decodeDrawable(r5);     // Catch: Exception -> L12
        o.c(r6, "decodeDrawable(...)");     // Catch: Exception -> L12
        r2.setImageDrawable(r6);     // Catch: Exception -> L12
        if (ZeusTransformUtils.instanceOf(r6, AnimatedImageDrawable.class) == false) goto L8;
        AnimatedImageDrawable r7 = (AnimatedImageDrawable) ZeusTransformUtils.preCheckCast(r6, AnimatedImageDrawable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12
    L9:
        if (r7 == null) goto L16;
        r7.setRepeatCount(-1);     // Catch: Exception -> L12
        r7.start();     // Catch: Exception -> L12
        return;
    L16:
        return;
    L8:
        r7 = null;
    L12:
        r2.setImageResource(ZeusTransformUtils.mapRes(R.drawable.find_phone_avatar, "drawable", "find_phone_avatar"));
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        this.resumeTime = System.currentTimeMillis();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onPause() {
        PowerManager r0 = this.powerManager;
        if ((System.currentTimeMillis() - this.resumeTime) >= DELTA_TIME_FOR_RESUMED_AND_PAUSED) goto L9;
        if (r0 == null) goto L9;
        if (r0.isInteractive() == false) goto L9;
        super.onPause();
        return;
    L9:
        stopNotification();
        super.onPause();
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        WeakReference<FindPhoneActivity> r0 = aliveRef;
        if (r0 == null) goto L5;
        FindPhoneActivity r1 = (FindPhoneActivity) ZeusTransformUtils.preCheckCast(r0.get(), FindPhoneActivity.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 != this) goto L8;
        aliveRef = null;
    L8:
        unregisterScreenOffReceiver();
        if (this.isStopped == true) goto L11;
        stopNotification();
    L11:
        this.isStopped = false;
        CountDownTimer r2 = this.notificationEventTimer;
        if (r2 == null) goto L14;
        r2.cancel();
    L14:
        super.onDestroy();
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void openFlashLight() {
        com.obric.agent.intents.findphone.a.f14693a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 1);
    }

    private final void closeFlashLight() {
        com.obric.agent.intents.findphone.a.f14693a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 0);
    }

    private final void stopVibrator() {
        Vibrator r0 = this.vaVibrator;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    private final void startVibrator() {
        vibrate(VIBRATOR_FREQUENCY);
    }

    private final void stopNotification() {
        exitActivity();
    }

    private final void stopFlashLightAndVibrator() {
        VaHandler r0 = this.vaHandler;
        if (r0 == null) goto L5;
        r0.removeMessages(22);
        r0.removeMessages(23);
        r0.removeMessages(24);
    L5:
        closeFlashLight();
        stopVibrator();
        keepScreenOff();
        this.isStopped = true;
    }

    private final void exitActivity() {
        stopFlashLightAndVibrator();
        VaHandler r0 = this.vaHandler;
        if (r0 == null) goto L5;
        r0.removeMessages(20);
        r0.removeMessages(21);
    L5:
        AsyncTask<Void, Void, Void> r1 = this.loadTask;
        if (r1 != null) goto L8;
    L10:
        this.loadTask = null;
        MediaPlayer r2 = this.mediaPlayer;
        if (r2 != null) goto L13;
    L16:
        this.mediaPlayer = null;
        AudioManager r3 = this.audioManager;
        AudioFocusRequest r4 = this.audioFocusRequest;
        if (r3 == null) goto L20;
        if (r4 == null) goto L20;
        r3.abandonAudioFocusRequest(r4);
    L20:
        restoreAlarmVolume();
        return;
    L13:
        if (r2.isPlaying() == false) goto L15;
        INVOKEVIRTUAL_com_obric_agent_intents_findphone_FindPhoneActivity_com_obric_performance_power_monitor_audio_MediaPlayerLancet_stop(r2);
    L15:
        r2.release();
        goto L16
    L8:
        if (r1.getStatus() != AsyncTask.Status.RUNNING) goto L10;
        r1.cancel(true);
        goto L10
    }

    private final void initScreen(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        Object r0 = r6.getSystemService("power");
        AudioManager r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, PowerManager.class) == false) goto L5;
        PowerManager r1 = (PowerManager) ZeusTransformUtils.preCheckCast(r0, PowerManager.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L8;
        this.powerManager = r1;
    L8:
        Object r2 = r6.getSystemService("vibrator");
        if (ZeusTransformUtils.instanceOf(r2, Vibrator.class) == false) goto L11;
        Vibrator r4 = (Vibrator) ZeusTransformUtils.preCheckCast(r2, Vibrator.class, "com.obric.aiagent.plugin");
    L12:
        if (r4 == null) goto L14;
        this.vaVibrator = r4;
    L14:
        Object r7 = r6.getSystemService("audio");
        if (ZeusTransformUtils.instanceOf(r7, AudioManager.class) == false) goto L17;
        r3 = (AudioManager) ZeusTransformUtils.preCheckCast(r7, AudioManager.class, "com.obric.aiagent.plugin");
    L17:
        if (r3 == null) goto L19;
        this.audioManager = r3;
    L19:
        this.ringManager = com.obric.agent.intents.findphone.b.f14695a.a(r6, 4, false);
        return;
    L11:
        r4 = null;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    private final void registerScreenOffReceiver() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.SCREEN_OFF");
        ZeusTransformUtils.registerReceiver(this, this.receiver, r0, 2, "com.obric.aiagent.plugin");
    }

    private final void unregisterScreenOffReceiver() {
        ZeusTransformUtils.unregisterReceiver(this, this.receiver, "com.obric.aiagent.plugin");     // Catch: IllegalArgumentException -> L5
    L3:
        this.receiver = null;
    }

    private final void vibrate(long r2) {
        Vibrator r1 = this.vaVibrator;
        if (r1 != null) goto L5;
        return;
    L5:
        VibrationEffect r3 = VibrationEffect.createOneShot(r2, -1);
        if (Build.VERSION.SDK_INT < 33) goto L8;
        VibrationAttributes r4 = new VibrationAttributes.Builder().setUsage(17).build();
        o.c(r4, "build(...)");
        r1.vibrate(r3, r4);
        return;
    L8:
        r1.vibrate(r3, new AudioAttributes.Builder().setUsage(4).setContentType(4).build());
    }

    private final void saveAlarmVolume() {
        AudioManager r0 = this.audioManager;
        if (r0 == null) goto L6;
        this.maxAlarmVolume = r0.getStreamMaxVolume(4);
        this.savedAlarmVolume = r0.getStreamVolume(4);
        return;
    }

    private final void restoreAlarmVolume() {
        AudioManager r0 = this.audioManager;
        if (r0 != null) goto L5;
        return;
    L5:
        int r3 = this.savedAlarmVolume;
        if (r3 < 0) goto L9;
        r0.setStreamVolume(4, r3, 0);
        return;
    }

    private final void applyAlarmVolumePercent(int r4) {
        AudioManager r0 = this.audioManager;
        if (r0 != null) goto L5;
        return;
    L5:
        int r3 = this.maxAlarmVolume;
        if (r3 > 0) goto L8;
        return;
    L8:
        r0.setStreamVolume(4, n.a((((r4 * r3) + 100) - 1) / 100, 1, r3), 0);
    }

    private final void hideSystemBars(Window r2) {
        am r1 = new am(r2, r2.getDecorView());
        r1.c(2);
        r1.b(al.m.f());
    }

    private final void keepScreenOn() {
        getWindow().addFlags(128);
        c.f14700a.a(0);
        c.f14700a.a();
    }

    private final void keepScreenOff() {
        getWindow().clearFlags(128);
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onKeyDown(int r2, KeyEvent r3) {
        o.e(r3, "event");
        finish();
        return super.onKeyDown(r2, r3);
    }

    public void onWindowFocusChanged(boolean r1) {
        super.onWindowFocusChanged(r1);
        if (r1 == false) goto L5;
        return;
    L5:
        if (isFinishing() == true) goto L9;
        finish();
        return;
    }

    public static void INVOKEVIRTUAL_com_obric_agent_intents_findphone_FindPhoneActivity_com_obric_performance_power_monitor_audio_MediaPlayerLancet_stop(MediaPlayer r1) {
        if (com.obric.performance.power.monitor.a.f36932a.a() == true) goto L6;
        r1.stop();
        return;
    L6:
        r1.stop();
        if (ZeusTransformUtils.instanceOf(r1, MediaPlayer.class) == false) goto L10;
        com.obric.performance.power.monitor.a.a.b(r1.hashCode());
        return;
    }
}
