package com.bytedanceos.common.ui;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.t;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.ad.param.AdReportParam;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class PlayVideoDesActivity extends Activity implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, AudioManager.OnAudioFocusChangeListener, View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private static final int DELAY_TIME_HIDE = 3000;
    private static final int DELAY_TIME_UPDATE = 200;
    private static final int MSG_HIDE_CONTRAL = 32;
    private static final int MSG_UPDATE_VIDEO = 16;
    private static final int STATUS_COMPLETE = 4;
    private static final int STATUS_HIDE_CONTRAL = 5;
    private static final int STATUS_PAUSE = 3;
    private static final int STATUS_PLAYING = 2;
    private static final int STATUS_SHOW_CONTRAL = 6;
    private static final int STATUS_START = 1;
    private static final String TAG = "PlayVideoDesActivity";
    private String cacheConfigKey;
    private String cacheConfigValue;
    private boolean isPlayStart;
    private String mAppName;
    private AudioManager mAudioManager;
    private Button mBackBtn;
    private TextView mCurrentTime;
    private ImageView mFooterPlayBtn;
    private View mFooterView;
    private View mForegroundView;
    private Handler mHandler;
    private View mHeaderView;
    private ProgressBar mLodingBar;
    private Button mMidPlayBtn;
    private AtomicBoolean mPaused;
    private String mPlayImage;
    private String mPlayUrl;
    private AtomicBoolean mResumed;
    private int mScreenType;
    private SeekBar mSeekBar;
    private TextView mTotalTime;
    private VideoView mVideoView;
    private int[] videoViewColor;

    public PlayVideoDesActivity() {
        this.mPlayImage = null;
        this.mPlayUrl = null;
        this.mPaused = new AtomicBoolean();
        this.mResumed = new AtomicBoolean();
        this.isPlayStart = false;
        this.videoViewColor = new int[]{0, -16777216};
        this.mScreenType = 0;
        this.cacheConfigKey = "x-cache-config";
        this.cacheConfigValue = "-1/40960/-1";
        this.mHandler = new AnonymousClass2(this);
    }

    public static /* synthetic */ VideoView access$000(PlayVideoDesActivity r10) {
        return r10.mVideoView;
    }

    public static /* synthetic */ ProgressBar access$100(PlayVideoDesActivity r10) {
        return r10.mLodingBar;
    }

    public static /* synthetic */ void access$200(PlayVideoDesActivity r10, int r11) {
        r10.updateView(r11);
    }

    private String convetTime(int r10) {
        if (r10 <= 0) goto L4;
        int r11 = r10 / 1000;
    L5:
        StringBuilder r12 = new StringBuilder();
        int r13 = r11 / 60;
        if (r13 >= 10) goto L8;
        r12.append(AdReportParam.ClickPosType.SKIP);
    L8:
        r12.append(r13);
        r12.append(":");
        int r14 = r11 % 60;
        if (r14 >= 10) goto L11;
        r12.append(AdReportParam.ClickPosType.SKIP);
    L11:
        r12.append(r14);
        return r12.toString();
    L4:
        r11 = 0;
        goto L5
    }

    private void initParams() {
        String r10 = getIntent().getStringExtra("url");     // Catch: Exception -> L7
        this.mPlayUrl = r10;     // Catch: Exception -> L7
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L9:
        com.bytedanceos.common.toolbox.j.a("play url:" + this.mPlayUrl);     // Catch: Exception -> L7
        finish();     // Catch: Exception -> L7
    L10:
        this.mAppName = getIntent().getStringExtra("name");     // Catch: Exception -> L7
        this.mPlayImage = getIntent().getStringExtra(SlardarSettingsConsts.SETTING_IMAGE);     // Catch: Exception -> L7
        setVolumeControlStream(3);     // Catch: Exception -> L7
        this.mAudioManager = (AudioManager) getSystemService("audio");     // Catch: Exception -> L7
        return;
    L5:
        if (URLUtil.isNetworkUrl(this.mPlayUrl) == true) goto L10;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    private void initView() {
        setContentView(R$layout.play_video_des);
        RelativeLayout r10 = (RelativeLayout) findViewById(R$id.video_control_header);
        this.mScreenType = getIntent().getIntExtra("type", 1);     // Catch: Exception -> L5
    L8:
        if (this.mScreenType != 1) goto L10;
        setRequestedOrientation(1);
        View.inflate(this, R$layout.video_header_portrait, r10);
        ((TextView) findViewById(R$id.video_name)).setText(this.mAppName);
    L11:
        View r11 = findViewById(R$id.video_contral_layout);
        this.mForegroundView = r11;
        r11.setOnClickListener(this);
        this.mHeaderView = findViewById(R$id.video_control_header);
        this.mFooterView = findViewById(R$id.video_control_footer);
        this.mVideoView = (VideoView) findViewById(R$id.videoView);
        ProgressBar r12 = (ProgressBar) findViewById(R$id.video_progressBar);
        this.mLodingBar = r12;
        r12.setVisibility(0);
        Button r13 = (Button) findViewById(R$id.video_back_btn);
        this.mBackBtn = r13;
        r13.setOnClickListener(this);
        Button r14 = (Button) findViewById(R$id.video_play_mid_btn);
        this.mMidPlayBtn = r14;
        r14.setOnClickListener(this);
        ImageView r15 = (ImageView) findViewById(R$id.video_play_footer_btn);
        this.mFooterPlayBtn = r15;
        r15.setOnClickListener(this);
        SeekBar r16 = (SeekBar) findViewById(R$id.video_seekbar);
        this.mSeekBar = r16;
        r16.setOnSeekBarChangeListener(this);
        this.mCurrentTime = (TextView) findViewById(R$id.video_current_time);
        this.mTotalTime = (TextView) findViewById(R$id.video_total_time);
        this.mVideoView.setOnInfoListener(new AnonymousClass1(this));
        return;
    L10:
        setRequestedOrientation(0);
        View.inflate(this, R$layout.video_header_landscape, r10);
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    private void loadVideo() {
        Uri r10 = Uri.parse(this.mPlayUrl);
        HashMap r11 = new HashMap();
        r11.put(this.cacheConfigKey, this.cacheConfigValue);
        this.mVideoView.setVideoURI(r10, r11);
        this.mVideoView.setOnPreparedListener(this);
        this.mVideoView.setOnCompletionListener(this);
        this.mVideoView.setOnErrorListener(this);
        this.mVideoView.requestFocus();
    }

    private void sendMessage(int r10, long r11) {
        if (this.mHandler.hasMessages(r10) == false) goto L5;
        this.mHandler.removeMessages(r10);
    L5:
        Message r12 = Message.obtain();
        r12.what = r10;
        this.mHandler.sendMessageDelayed(r12, r11);
    }

    private void showTouchView() {
        View r10 = this.mHeaderView;
        if (r10 == null) goto L8;
        if (this.mFooterView == null) goto L8;
        r10.setVisibility(0);
        this.mFooterView.setVisibility(0);
    L8:
        if (this.mHandler.hasMessages(32) == false) goto L11;
        this.mHandler.removeMessages(32);
        return;
    }

    private void updateVideoViewBackground(int r10) {
        VideoView r11 = this.mVideoView;
        if (r11 == null) goto L6;
        r11.setBackgroundColor(this.videoViewColor[r10]);
        return;
    }

    private void updateView(int r10) {
        switch(r10) {
            case 1: goto L28;
            case 2: goto L18;
            case 3: goto L14;
            case 4: goto L10;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L45;
        };
    L5:
        this.mHeaderView.setVisibility(0);
        this.mFooterView.setVisibility(0);
        sendMessage(32, WsConstants.EXIT_DELAY_TIME);
        return;
    L10:
        this.mAudioManager.abandonAudioFocus(this);
        this.mFooterPlayBtn.setImageResource(R$drawable.video_ic_vidcontrol_play);
        if (this.mHandler.hasMessages(16) == false) goto L13;
        this.mHandler.removeMessages(16);
    L13:
        this.mSeekBar.setProgress(0);
        this.mCurrentTime.setText(convetTime(0));
        this.mMidPlayBtn.setVisibility(0);
        this.isPlayStart = true;
        return;
    L14:
        this.mPaused.set(true);
        if (this.mHandler.hasMessages(16) == false) goto L17;
        this.mHandler.removeMessages(16);
    L17:
        this.mVideoView.pause();
        this.mFooterPlayBtn.setImageResource(R$drawable.video_ic_vidcontrol_play);
        this.mMidPlayBtn.setVisibility(0);
        this.mLodingBar.setVisibility(8);
        return;
    L18:
        int r11 = this.mVideoView.getCurrentPosition();
        int r12 = this.mVideoView.getDuration();
        if (r11 >= r12) goto L25;
        if (this.mSeekBar.isPressed() == true) goto L23;
        this.mSeekBar.setProgress(r11);
    L23:
        this.mCurrentTime.setText(convetTime(r11));
        sendMessage(16, 200);
        return;
    L25:
        if (this.mSeekBar.isPressed() == true) goto L27;
        this.mSeekBar.setProgress(r12);
    L27:
        this.mCurrentTime.setText(convetTime(r12));
        return;
    L28:
        this.mAudioManager.requestAudioFocus(this, 3, 1);
        if (this.mVideoView.isPlaying() == false) goto L31;
    L37:
        this.mPaused.set(false);
        this.mMidPlayBtn.setVisibility(8);
        this.mFooterPlayBtn.setImageResource(R$drawable.video_ic_vidcontrol_pause);
        this.mCurrentTime.setText(convetTime(this.mVideoView.getCurrentPosition()));
        this.mTotalTime.setText(convetTime(this.mVideoView.getDuration()));
        sendMessage(16, 200);
        return;
    L31:
        if (this.isPlayStart == false) goto L34;
        this.isPlayStart = false;
    L34:
        if (this.mPaused.get() == false) goto L36;
        this.mVideoView.seekTo(this.mSeekBar.getProgress());
    L36:
        this.mVideoView.start();
        goto L37
    L45:
        return;
    L7:
        if (this.mHandler.hasMessages(32) == false) goto L9;
        this.mHandler.removeMessages(32);
    L9:
        this.mHeaderView.setVisibility(8);
        this.mFooterView.setVisibility(8);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (this.mScreenType == 1) goto L6;
        setRequestedOrientation(1);
        return;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int r10) {
        if (r10 == (-2)) goto L17;
        if (r10 == (-1)) goto L17;
        if (r10 == 1) goto L10;
        return;
    L10:
        if (this.mResumed.get() == true) goto L12;
        return;
    L12:
        if (this.mVideoView.isPlaying() == false) goto L14;
        return;
    L14:
        if (this.mPaused.get() == false) goto L22;
        updateView(1);
        return;
    L22:
        return;
    L17:
        if (this.mVideoView.isPlaying() == false) goto L24;
        updateView(3);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        int r11 = r10.getId();
        if (r11 != R$id.video_back_btn) goto L6;
        finish();
        return;
    L6:
        if (r11 != R$id.video_contral_layout) goto L12;
        if (this.mHeaderView.isShown() == false) goto L10;
        updateView(5);
        return;
    L10:
        updateView(6);
        return;
    L12:
        if (r11 != R$id.video_play_mid_btn) goto L15;
        updateView(1);
        return;
    L15:
        if (r11 == R$id.video_play_footer_btn) goto L17;
        return;
    L17:
        if (this.mVideoView.isPlaying() == false) goto L19;
        this.mAudioManager.abandonAudioFocus(this);
        updateView(3);
        return;
    L19:
        updateView(1);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer r10) {
        updateView(4);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        initParams();
        initView();
        getWindow().addFlags(1024);
        t.a(getWindow(), getWindow().getDecorView()).a(WindowInsetsCompat.Type.d());
        loadVideo();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mAudioManager.abandonAudioFocus(this);
        this.mVideoView.stopPlayback();
        if (this.mHandler.hasMessages(16) == false) goto L6;
        this.mHandler.removeMessages(16);
        return;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer r10, int r11, int r12) {
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.mVideoView.isPlaying() == false) goto L5;
        updateView(3);
    L5:
        this.mResumed.set(false);
        updateVideoViewBackground(1);
        d9.b.b().h();
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer r10) {
        updateVideoViewBackground(0);
        if (this.mPaused.get() == false) goto L5;
        this.mVideoView.seekTo(this.mSeekBar.getProgress());
        updateView(3);
        return;
    L5:
        this.mLodingBar.setVisibility(8);
        this.mSeekBar.setMax(this.mVideoView.getDuration());
        updateView(1);
        updateView(6);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar r10, int r11, boolean r12) {
        if (r12 == false) goto L5;
        this.mVideoView.seekTo(r11);
        this.mCurrentTime.setText(convetTime(r11));
        return;
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.mResumed.set(true);
        updateVideoViewBackground(0);
        d9.b.b().i();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar r10) {
        showTouchView();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar r10) {
        updateView(6);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean r10) {
        if (r10 == false) goto L4;
        return;
    L4:
        if (this.mVideoView.isPlaying() == false) goto L8;
        updateView(3);
        return;
    }
}
