package cn.jzvd;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.R$style;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.e0;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public class JzvdStd extends Jzvd {
    protected Timer DISMISS_CONTROL_VIEW_TIMER;
    public ProgressBar bottomProgressBar;
    public PopupWindow clarityPopWindow;
    public ProgressBar loadingProgressBar;
    public NetworkImageView mBannerView;
    protected Dialog mBrightnessDialog;
    protected ProgressBar mDialogBrightnessProgressBar;
    protected TextView mDialogBrightnessTextView;
    protected ImageView mDialogIcon;
    protected ProgressBar mDialogProgressBar;
    protected TextView mDialogSeekTime;
    protected TextView mDialogTotalTime;
    protected ImageView mDialogVolumeImageView;
    protected ProgressBar mDialogVolumeProgressBar;
    protected TextView mDialogVolumeTextView;
    protected DismissControlViewTimerTask mDismissControlViewTimerTask;
    private boolean mIsControlVisable;
    protected Dialog mProgressDialog;
    public TextView mRetryBtn;
    public View mRetryLayout;
    protected Dialog mVolumeDialog;

    public class DismissControlViewTimerTask extends TimerTask {
        final /* synthetic */ JzvdStd this$0;

        public DismissControlViewTimerTask(JzvdStd r10) {
            this.this$0 = r10;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.this$0.dissmissControlView();
        }
    }

    public JzvdStd(Context r10) {
        super(r10);
        this.mIsControlVisable = true;
    }

    private void loadTopicBanner(String r10) {
        this.mBannerView.setImageUrl(r10);
    }

    private void setCacheProgress(int r10) {
        ProgressBar r11 = this.bottomProgressBar;
        if (r11 == null) goto L6;
        r11.setSecondaryProgress(r10);
        return;
    }

    public void cancelDismissControlViewTimer() {
        Timer r10 = this.DISMISS_CONTROL_VIEW_TIMER;
        if (r10 == null) goto L5;
        r10.cancel();
    L5:
        DismissControlViewTimerTask r11 = this.mDismissControlViewTimerTask;
        if (r11 == null) goto L9;
        r11.cancel();
        return;
    }

    public void changeStartButtonSize(int r10) {
        ViewGroup.LayoutParams r11 = this.startButton.getLayoutParams();
        r11.height = r10;
        r11.width = r10;
        ViewGroup.LayoutParams r12 = this.loadingProgressBar.getLayoutParams();
        r12.height = r10;
        r12.width = r10;
    }

    public void changeUiToComplete() {
        int r10 = this.currentScreen;
        if (r10 != 0) goto L5;
    L10:
        setAllControlsVisiblity(0, 4, 0, 4, 0, 4, 4);
        updateStartImage();
        return;
    L5:
        if (r10 == 1) goto L10;
        if (r10 != 2) goto L13;
        setAllControlsVisiblity(0, 4, 0, 4, 0, 4, 4);
        updateStartImage();
        return;
    }

    public void changeUiToError() {
        int r10 = this.currentScreen;
        if (r10 != 0) goto L5;
    L10:
        setAllControlsVisiblity(4, 4, 0, 4, 4, 4, 0);
        updateStartImage();
        return;
    L5:
        if (r10 == 1) goto L10;
        if (r10 != 2) goto L13;
        setAllControlsVisiblity(0, 4, 0, 4, 4, 4, 0);
        updateStartImage();
        return;
    }

    public void changeUiToNormal() {
        int r10 = this.currentScreen;
        if (r10 != 0) goto L5;
    L10:
        setAllControlsVisiblity(0, 4, 0, 4, 0, 4, 4);
        updateStartImage();
        return;
    L5:
        if (r10 == 1) goto L10;
        if (r10 != 2) goto L13;
        setAllControlsVisiblity(0, 4, 0, 4, 0, 4, 4);
        updateStartImage();
        return;
    }

    public void changeUiToPauseClear() {
        int r10 = this.currentScreen;
        if (r10 != 0) goto L5;
    L10:
        setAllControlsVisiblity(4, 4, 4, 4, 4, 0, 4);
        return;
    L5:
        if (r10 == 1) goto L10;
        if (r10 != 2) goto L13;
        setAllControlsVisiblity(4, 4, 4, 4, 4, 0, 4);
        return;
    }

    public void changeUiToPauseShow() {
        int r10 = this.currentScreen;
        if (r10 != 0) goto L5;
    L10:
        setAllControlsVisiblity(0, 0, 0, 4, 4, 4, 4);
        updateStartImage();
        return;
    L5:
        if (r10 == 1) goto L10;
        if (r10 != 2) goto L13;
        setAllControlsVisiblity(0, 0, 0, 4, 4, 4, 4);
        updateStartImage();
        return;
    }

    public void changeUiToPlayingClear() {
        int r10 = this.currentScreen;
        if (r10 != 0) goto L5;
    L10:
        setAllControlsVisiblity(4, 4, 4, 4, 4, 0, 4);
        return;
    L5:
        if (r10 == 1) goto L10;
        if (r10 != 2) goto L13;
        setAllControlsVisiblity(4, 4, 4, 4, 4, 0, 4);
        return;
    }

    public void changeUiToPlayingShow() {
        int r10 = this.currentScreen;
        if (r10 != 0) goto L5;
    L10:
        setAllControlsVisiblity(0, 0, 0, 4, 4, 4, 4);
        updateStartImage();
        return;
    L5:
        if (r10 == 1) goto L10;
        if (r10 != 2) goto L13;
        setAllControlsVisiblity(0, 0, 0, 4, 4, 4, 4);
        updateStartImage();
        return;
    }

    public void changeUiToPreparing() {
        int r10 = this.currentScreen;
        if (r10 != 0) goto L5;
    L9:
        setAllControlsVisiblity(4, 4, 4, 0, 0, 4, 4);
        updateStartImage();
        return;
    L5:
        if (r10 == 1) goto L9;
        if (r10 == 2) goto L9;
    }

    @Override // cn.jzvd.Jzvd
    public void changeUrl(int r10, long r11) {
        super.changeUrl(r10, r11);
        this.startButton.setVisibility(4);
        this.mRetryLayout.setVisibility(8);
    }

    public Dialog createDialogWithView(View r10) {
        Dialog r11 = new Dialog(getContext(), R$style.jz_style_dialog_progress);
        r11.setContentView(r10);
        Window r12 = r11.getWindow();
        r12.addFlags(8);
        r12.addFlags(32);
        r12.addFlags(16);
        r12.setLayout(-2, -2);
        WindowManager.LayoutParams r13 = r12.getAttributes();
        r13.gravity = 17;
        r12.setAttributes(r13);
        return r11;
    }

    @Override // cn.jzvd.Jzvd
    public void dismissBrightnessDialog() {
        super.dismissBrightnessDialog();
        Dialog r10 = this.mBrightnessDialog;
        if (r10 == null) goto L6;
        r10.dismiss();
        return;
    }

    @Override // cn.jzvd.Jzvd
    public void dismissProgressDialog() {
        super.dismissProgressDialog();
        Dialog r10 = this.mProgressDialog;
        if (r10 == null) goto L6;
        r10.dismiss();
        return;
    }

    @Override // cn.jzvd.Jzvd
    public void dismissVolumeDialog() {
        super.dismissVolumeDialog();
        Dialog r10 = this.mVolumeDialog;
        if (r10 == null) goto L6;
        r10.dismiss();
        return;
    }

    public void dissmissControlView() {
        int r10 = this.currentState;
        if (r10 != 0) goto L5;
        return;
    L5:
        if (r10 != 7) goto L7;
        return;
    L7:
        if (r10 == 6) goto L12;
        post(new AnonymousClass3(this));
        return;
    }

    @Override // cn.jzvd.Jzvd
    public int getLayoutId() {
        return R$layout.jz_layout_std;
    }

    @Override // cn.jzvd.Jzvd
    public void init(Context r10) {
        super.init(r10);
        this.bottomProgressBar = (ProgressBar) findViewById(R$id.bottom_progress);
        this.loadingProgressBar = (ProgressBar) findViewById(R$id.loading);
        this.mRetryBtn = (TextView) findViewById(R$id.retry_btn);
        this.mRetryLayout = findViewById(R$id.retry_layout);
        this.mBannerView = (NetworkImageView) findViewById(R$id.banner_view);
        this.mRetryBtn.setOnClickListener(this);
    }

    public boolean isControlVisable() {
        return this.mIsControlVisable;
    }

    @Override // cn.jzvd.Jzvd
    public void onAutoCompletion(MediaPlayer r10) {
        super.onAutoCompletion(r10);
        cancelDismissControlViewTimer();
    }

    public void onCLickUiToggleToClear() {
        int r10 = this.currentState;
        if (r10 != 1) goto L8;
        if (this.startButton.getVisibility() != 0) goto L23;
        changeUiToPreparing();
        return;
    L23:
        return;
    L8:
        if (r10 != 3) goto L13;
        if (this.startButton.getVisibility() != 0) goto L25;
        changeUiToPlayingClear();
        return;
    L25:
        return;
    L13:
        if (r10 != 5) goto L18;
        if (this.startButton.getVisibility() != 0) goto L27;
        changeUiToPauseClear();
        return;
    L27:
        return;
    L18:
        if (r10 == 6) goto L20;
        return;
    L20:
        if (this.startButton.getVisibility() != 0) goto L30;
        changeUiToComplete();
        return;
    }

    @Override // cn.jzvd.Jzvd, com.danikula.videocache.CacheListener
    public void onCacheAvailable(File r10, String r11, int r12) {
        super.onCacheAvailable(r10, r11, r12);
        if (r11.equals(this.mUrl) == false) goto L6;
        setCacheProgress(r12);
        return;
    }

    @Override // cn.jzvd.Jzvd, android.view.View.OnClickListener
    public void onClick(View r10) {
        super.onClick(r10);
        int r11 = r10.getId();
        if (r11 != R$id.surface_container) goto L6;
        startDismissControlViewTimer();
        return;
    L6:
        if (r11 == R$id.retry_btn) goto L8;
        return;
    L8:
        if (this.jzDataSource.urlsMap.isEmpty() == false) goto L10;
    L23:
        Toast.makeText(getContext(), getResources().getString(R$string.no_url), 0).show();
        return;
    L10:
        if (this.jzDataSource.getCurrentUrl() == null) goto L23;
        if (this.jzDataSource.getCurrentUrl().toString().startsWith("file") == false) goto L15;
    L22:
        initTextureView();
        addTextureView();
        JZMediaManager.setDataSource(this.jzDataSource);
        onStatePreparing();
        onEvent(1);
        return;
    L15:
        if (this.jzDataSource.getCurrentUrl().toString().startsWith(LibrarianImpl.Constants.SEPARATOR) == true) goto L22;
        if (JZUtils.isWifiConnected(getContext()) == true) goto L22;
        if (Jzvd.WIFI_TIP_DIALOG_SHOWED == true) goto L22;
        showWifiDialog();
    }

    public void onClickUiToggle() {
        int r10 = this.currentState;
        if (r10 != 1) goto L6;
        changeUiToPreparing();
        return;
    L6:
        if (r10 != 3) goto L12;
        if (this.startButton.getVisibility() != 0) goto L10;
        changeUiToPlayingClear();
        return;
    L10:
        changeUiToPlayingShow();
        return;
    L12:
        if (r10 == 5) goto L14;
        return;
    L14:
        if (this.startButton.getVisibility() != 0) goto L16;
        changeUiToPauseClear();
        return;
    L16:
        changeUiToPauseShow();
    }

    @Override // cn.jzvd.Jzvd
    public void onCompletion() {
        super.onCompletion();
        cancelDismissControlViewTimer();
        PopupWindow r10 = this.clarityPopWindow;
        if (r10 == null) goto L6;
        r10.dismiss();
        return;
    }

    @Override // cn.jzvd.Jzvd
    public void onProgress(int r10, long r11, long r12) {
        super.onProgress(r10, r11, r12);
        if (r10 == 0) goto L6;
        this.bottomProgressBar.setProgress(r10);
        return;
    }

    @Override // cn.jzvd.Jzvd, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar r10) {
        super.onStartTrackingTouch(r10);
        cancelDismissControlViewTimer();
    }

    @Override // cn.jzvd.Jzvd
    public void onStateAutoComplete() {
        super.onStateAutoComplete();
        changeUiToComplete();
        cancelDismissControlViewTimer();
        this.bottomProgressBar.setProgress(100);
    }

    @Override // cn.jzvd.Jzvd
    public void onStateError() {
        super.onStateError();
        changeUiToError();
    }

    @Override // cn.jzvd.Jzvd
    public void onStateNormal() {
        super.onStateNormal();
        changeUiToNormal();
    }

    @Override // cn.jzvd.Jzvd
    public void onStatePause() {
        super.onStatePause();
        changeUiToPauseShow();
        cancelDismissControlViewTimer();
    }

    @Override // cn.jzvd.Jzvd
    public void onStatePlaying() {
        super.onStatePlaying();
        changeUiToPlayingClear();
    }

    @Override // cn.jzvd.Jzvd
    public void onStatePreparing() {
        super.onStatePreparing();
        changeUiToPreparing();
    }

    @Override // cn.jzvd.Jzvd, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar r10) {
        super.onStopTrackingTouch(r10);
        startDismissControlViewTimer();
    }

    @Override // cn.jzvd.Jzvd, android.view.View.OnTouchListener
    public boolean onTouch(View r10, MotionEvent r11) {
        if (r10.getId() != R$id.surface_container) goto L21;
        if (r11.getAction() != 1) goto L21;
        if (isControlVisable() == false) goto L21;
        startDismissControlViewTimer();
        if (this.mChangePosition == false) goto L16;
        long r12 = getDuration();
        long r13 = this.mSeekTimePosition * 100;
        if (r12 != 0) goto L14;
        r12 = 1;
    L14:
        ProgressBar r14 = this.bottomProgressBar;
        r14.setProgress((int) (r13 / r12));
    L16:
        if (this.mChangePosition == true) goto L21;
        if (this.mChangeVolume == true) goto L21;
        onEvent(102);
        onClickUiToggle();
    L21:
        return super.onTouch(r10, r11);
    }

    public void pauseByDisabledNetwork() {
        if (this.currentState != 3) goto L6;
        onStatePreparing();
        JZMediaManager.pause();
        return;
    }

    @Override // cn.jzvd.Jzvd
    public void resetProgressAndTime() {
        super.resetProgressAndTime();
        this.bottomProgressBar.setProgress(0);
    }

    public void resumeByNetwork() {
        if (this.currentState != 1) goto L6;
        onStatePlaying();
        JZMediaManager.start();
        return;
    }

    public void setAllControlsVisiblity(int r10, int r11, int r12, int r13, int r14, int r15, int r16) {
        this.startButton.setVisibility(r12);
        this.loadingProgressBar.setVisibility(r13);
        this.mBannerView.setVisibility(r14);
        this.mRetryLayout.setVisibility(r16);
    }

    public void setBannerUrl(String r10) {
        loadTopicBanner(r10);
    }

    public void setControlVisable(boolean r10) {
        this.mIsControlVisable = r10;
    }

    @Override // cn.jzvd.Jzvd
    public void setUp(JZDataSource r10, int r11) {
        super.setUp(r10, r11);
        int r12 = this.currentScreen;
        if (r12 != 2) goto L5;
        this.fullscreenButton.setImageResource(R$drawable.jz_shrink);
        changeStartButtonSize((int) getResources().getDimension(R$dimen.jz_start_button_w_h_fullscreen));
    L14:
        if (this.tmp_test_back == false) goto L17;
        this.tmp_test_back = false;
        JzvdMgr.setFirstFloor(this);
        Jzvd.backPress();
        return;
    L17:
        return;
    L5:
        if (r12 != 0) goto L7;
    L12:
        this.fullscreenButton.setImageResource(R$drawable.jz_enlarge);
        changeStartButtonSize((int) getResources().getDimension(R$dimen.jz_start_button_w_h_normal));
        goto L14
    L7:
        if (r12 == 1) goto L12;
        if (r12 != 3) goto L14;
        setAllControlsVisiblity(4, 4, 4, 4, 4, 4, 4);
        goto L14
    }

    @Override // cn.jzvd.Jzvd
    public void setUpWithCache(String r10, String r11, int r12) {
        super.setUpWithCache(r10, r11, r12);
        if (isCached() == false) goto L6;
        setCacheProgress(100);
        return;
    }

    public void setVideoUrl(String r10) {
        setUpWithCache(r10, "", 0);
    }

    @Override // cn.jzvd.Jzvd
    public void showBrightnessDialog(int r10) {
        super.showBrightnessDialog(r10);
        if (this.mBrightnessDialog != null) goto L6;
        View r11 = LayoutInflater.from(getContext()).inflate(R$layout.jz_dialog_brightness, null);
        this.mDialogBrightnessTextView = (TextView) r11.findViewById(R$id.tv_brightness);
        this.mDialogBrightnessProgressBar = (ProgressBar) r11.findViewById(R$id.brightness_progressbar);
        this.mBrightnessDialog = createDialogWithView(r11);
    L6:
        if (this.mBrightnessDialog.isShowing() == true) goto L9;
        this.mBrightnessDialog.show();
    L9:
        if (r10 <= 100) goto L11;
        r10 = 100;
    L13:
        this.mDialogBrightnessTextView.setText(r10 + "%");
        this.mDialogBrightnessProgressBar.setProgress(r10);
        onCLickUiToggleToClear();
        return;
    L11:
        if (r10 >= 0) goto L13;
        r10 = 0;
        goto L13
    }

    @Override // cn.jzvd.Jzvd
    public void showProgressDialog(float r10, String r11, long r12, String r13, long r14) {
        super.showProgressDialog(r10, r11, r12, r13, r14);
        if (this.mProgressDialog != null) goto L6;
        View r15 = LayoutInflater.from(getContext()).inflate(R$layout.jz_dialog_progress, null);
        this.mDialogProgressBar = (ProgressBar) r15.findViewById(R$id.duration_progressbar);
        this.mDialogSeekTime = (TextView) r15.findViewById(R$id.tv_current);
        this.mDialogTotalTime = (TextView) r15.findViewById(R$id.tv_duration);
        this.mDialogIcon = (ImageView) r15.findViewById(R$id.duration_image_tip);
        this.mProgressDialog = createDialogWithView(r15);
    L6:
        if (this.mProgressDialog.isShowing() == true) goto L8;
        this.mProgressDialog.show();
    L8:
        this.mDialogSeekTime.setText(r11);
        this.mDialogTotalTime.setText(" / " + r13);
        ProgressBar r16 = this.mDialogProgressBar;
        if (r14 > 0) goto L11;
        int r17 = 0;
    L12:
        r16.setProgress(r17);
        if (r10 <= 0.0f) goto L15;
        this.mDialogIcon.setBackgroundResource(R$drawable.jz_forward_icon);
    L16:
        onCLickUiToggleToClear();
        return;
    L15:
        this.mDialogIcon.setBackgroundResource(R$drawable.jz_backward_icon);
        goto L16
    L11:
        r17 = (int) ((r12 * 100) / r14);
        goto L12
    }

    @Override // cn.jzvd.Jzvd
    public void showVolumeDialog(float r10, int r11) {
        super.showVolumeDialog(r10, r11);
        if (this.mVolumeDialog != null) goto L6;
        View r12 = LayoutInflater.from(getContext()).inflate(R$layout.jz_dialog_volume, null);
        this.mDialogVolumeImageView = (ImageView) r12.findViewById(R$id.volume_image_tip);
        this.mDialogVolumeTextView = (TextView) r12.findViewById(R$id.tv_volume);
        this.mDialogVolumeProgressBar = (ProgressBar) r12.findViewById(R$id.volume_progressbar);
        this.mVolumeDialog = createDialogWithView(r12);
    L6:
        if (this.mVolumeDialog.isShowing() == true) goto L8;
        this.mVolumeDialog.show();
    L8:
        if (r11 > 0) goto L10;
        this.mDialogVolumeImageView.setBackgroundResource(R$drawable.jz_close_volume);
    L12:
        if (r11 <= 100) goto L14;
        r11 = 100;
    L16:
        this.mDialogVolumeTextView.setText(r11 + "%");
        this.mDialogVolumeProgressBar.setProgress(r11);
        onCLickUiToggleToClear();
        return;
    L14:
        if (r11 >= 0) goto L16;
        r11 = 0;
        goto L16
    L10:
        this.mDialogVolumeImageView.setBackgroundResource(R$drawable.jz_add_volume);
        goto L12
    }

    @Override // cn.jzvd.Jzvd
    public void showWifiDialog() {
        super.showWifiDialog();
        if (e.A0(getContext()) == true) goto L6;
        e0.e(R$string.retry_connection);
        return;
    L6:
        AlertDialog.Builder r10 = new AlertDialog.Builder(getContext());
        r10.setMessage(getResources().getString(R$string.tips_not_wifi));
        r10.setPositiveButton(getResources().getString(R$string.tips_not_wifi_confirm), new AnonymousClass1(this));
        r10.setNegativeButton(getResources().getString(R$string.tips_not_wifi_cancel), new AnonymousClass2(this));
        r10.create().show();
    }

    public void startDismissControlViewTimer() {
        cancelDismissControlViewTimer();
        this.DISMISS_CONTROL_VIEW_TIMER = new Timer();
        DismissControlViewTimerTask r10 = new DismissControlViewTimerTask(this);
        this.mDismissControlViewTimerTask = r10;
        this.DISMISS_CONTROL_VIEW_TIMER.schedule(r10, PerfConsts.DEFAULT_BLOCK_INTERVAL_MS);
    }

    public void updateStartImage() {
        int r10 = this.currentState;
        if (r10 != 3) goto L6;
        this.startButton.setVisibility(0);
        this.startButton.setImageResource(R$drawable.jz_pause_normal);
        return;
    L6:
        if (r10 != 7) goto L9;
        this.startButton.setVisibility(4);
        return;
    L9:
        if (r10 != 6) goto L11;
        this.startButton.setVisibility(0);
        this.startButton.setImageResource(R$drawable.jz_play_normal);
        return;
    L11:
        this.startButton.setImageResource(R$drawable.jz_play_normal);
    }

    public void updateVideoView() {
        updateMuteView();
        if (getContext() != null) goto L5;
        return;
    L5:
        if (this.jzDataSource != null) goto L7;
        return;
    L7:
        if (this.bottomProgressBar == null) goto L14;
        long r10 = getDuration();
        if (r10 <= 0) goto L15;
        long r11 = JZUtils.getSavedProgress(getContext(), this.jzDataSource.getCurrentUrl());
        this.bottomProgressBar.setProgress((int) ((r11 * 100) / r10));
        return;
    L15:
        return;
    }

    public JzvdStd(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mIsControlVisable = true;
    }

    @Override // cn.jzvd.Jzvd
    public void changeUrl(JZDataSource r10, long r11) {
        super.changeUrl(r10, r11);
        this.startButton.setVisibility(4);
        this.mRetryLayout.setVisibility(8);
    }
}
