package com.bytedanceos.common.ui;

import android.R;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$anim;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.ad.common.AdJumpUtil;
import com.bytedanceos.common.ad.common.AdReportUtil;
import com.bytedanceos.common.ad.entity.rep.RepAdEntity;
import com.bytedanceos.common.ad.entity.rep.RepAdsEntity;
import com.bytedanceos.common.ad.entity.rep.RepCreativeEntity;
import com.bytedanceos.common.ad.entity.rep.media.RepSplashMediaEntity;
import com.bytedanceos.common.ad.listener.AdListener;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.bytedanceos.common.networkv2.subscriber.ISubscriberManager;
import com.bytedanceos.common.networkv2.subscriber.NSubscriber;
import com.bytedanceos.common.toolbox.s;
import com.bytedanceos.common.ui.listener.AppStateHelper;
import com.gyf.barlibrary.BarHide;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SplashActivity extends BasicActivity implements View.OnClickListener, ISubscriberManager {
    private static final int DISPLAY_SECONDS = 3;
    public static final String EXTRA_INTRUSION = "intrusion";
    private static final long MAX_DELAY_LOAD_AD = 1000;
    private static final long MAX_DELAY_REQUEST_AD = 1000;
    private static final int MSG_EXIT_SPLASH = 102;
    private static final int MSG_TIMER = 100;
    private static final int MSG_WAIT_AD_TIMEOUT = 101;
    private static final String TAG = "SplashActivity";
    private RepAdEntity<RepSplashMediaEntity> mAdEntity;
    private List<RepAdEntity<RepSplashMediaEntity>> mAdList;
    private AdListener mAdListener;
    private int mCurSecond;
    private Handler mHandler;
    private boolean mIsAdPresent;
    private boolean mIsSplashInit;
    private boolean mIsStop;
    private ImageView mIvAd;
    private NSubscriber<RepAdsEntity<RepSplashMediaEntity>> mNSubscriber;
    private Handler mTimerHandler;
    private int mTotalSeconds;
    private TextView mTvSkip;
    private TextView mTvTitle;

    public class SplashAdListener implements AdListener<RepSplashMediaEntity> {
        final /* synthetic */ SplashActivity this$0;

        private SplashAdListener(SplashActivity r10) {
            this.this$0 = r10;
        }

        @Override // com.bytedanceos.common.ad.listener.AdListener
        public void onClick(RepAdEntity<RepSplashMediaEntity> r10, View r11) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (r10.isCreativeAvailable() == false) goto L10;
            RepCreativeEntity r12 = (RepCreativeEntity) r10.getCreative().get(0);
            if (r12 == null) goto L11;
            AdJumpUtil.jump(this.this$0, r12);
            AdReportParam.Event r13 = AdReportParam.Event.SPLASH_CLICK;
            r13.setClickPosType("1");
            AdReportUtil.reportSplash(r13, (RepSplashMediaEntity) r12.getMedia());
            return;
        L11:
            return;
        }

        @Override // com.bytedanceos.common.ad.listener.AdListener
        public void onDismiss() {
            SplashActivity.access$100(this.this$0);
        }

        @Override // com.bytedanceos.common.ad.listener.AdListener
        public void onNoAD(String r10) {
            com.bytedanceos.common.toolbox.i.a(SplashActivity.access$000(), "Ad load error: " + r10);
        }

        @Override // com.bytedanceos.common.ad.listener.AdListener
        public boolean onPresent(RepAdEntity<RepSplashMediaEntity> r10, View r11) {
            if (SplashActivity.access$500(this.this$0) == true) goto L14;
            if (r10 == null) goto L14;
            if (r10.isCreativeAvailable() == false) goto L14;
            if (SplashActivity.access$1100(this.this$0) == null) goto L14;
            SplashActivity.access$1100(this.this$0).removeMessages(101);
            SplashActivity.access$1402(this.this$0, true);
            SplashActivity.access$1500(this.this$0, r10.getSet().getSettings().getDisplay_time());
            SplashActivity.access$1300(this.this$0).setClickable(true);
            RepCreativeEntity r12 = (RepCreativeEntity) r10.getCreative().get(0);
            if (r12 == null) goto L13;
            AdReportUtil.reportSplash(AdReportParam.Event.SPLASH_EXPOSURE, (RepSplashMediaEntity) r12.getMedia());
        L13:
            return false;
        L14:
            return true;
        }

        @Override // com.bytedanceos.common.ad.listener.AdListener
        public void onResponse(final RepAdEntity<RepSplashMediaEntity> r10) {
            if (r10 != null) goto L4;
        L6:
            onNoAD("ad entity unavailable");
            return;
        L4:
            if (r10.isCreativeAvailable() == false) goto L6;
            SplashActivity.access$1100(this.this$0).removeMessages(101);
            SplashActivity.access$1100(this.this$0).sendEmptyMessageDelayed(101, 1000);
            SplashActivity.access$1202(this.this$0, r10);
            String r11 = ((RepSplashMediaEntity) ((RepCreativeEntity) r10.getCreative().get(0)).getMedia()).getCreative_url();
            com.bytedanceos.common.toolbox.glide.b.h(BaseApplication.c(), r11, SplashActivity.access$1300(this.this$0), new AnonymousClass1(this, r10));
        }

        @Override // com.bytedanceos.common.ad.listener.AdListener
        public void onSkip(RepAdEntity<RepSplashMediaEntity> r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (r10.isCreativeAvailable() == false) goto L10;
            RepCreativeEntity r11 = (RepCreativeEntity) r10.getCreative().get(0);
            if (r11 == null) goto L11;
            onDismiss();
            AdReportParam.Event r12 = AdReportParam.Event.SPLASH_CLICK;
            r12.setClickPosType(AdReportParam.ClickPosType.SKIP);
            AdReportUtil.reportSplash(r12, (RepSplashMediaEntity) r11.getMedia());
            return;
        L11:
            return;
        }

        public /* synthetic */ SplashAdListener(SplashActivity r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public class SplashHandler extends Handler {
        final /* synthetic */ SplashActivity this$0;

        public SplashHandler(SplashActivity r10) {
            this.this$0 = r10;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            int r11 = r10.what;
            if (r11 != 101) goto L5;
            com.bytedanceos.common.toolbox.i.a(SplashActivity.access$000(), "wait ad timeout");
            SplashActivity.access$100(this.this$0);
            com.bytedanceos.common.toolbox.e.z1(SplashActivity.access$200(this.this$0));
            return;
        L5:
            if (r11 != 102) goto L11;
            this.this$0.finish();
            return;
        }
    }

    static {
    }

    public SplashActivity() {
        this.mHandler = new SplashHandler(this);
        this.mCurSecond = 0;
        this.mTotalSeconds = 0;
        this.mIsStop = false;
        this.mIsAdPresent = false;
        this.mIsSplashInit = false;
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ void access$100(SplashActivity r10) {
        r10.exitSplash();
    }

    public static /* synthetic */ Handler access$1000(SplashActivity r10) {
        return r10.mTimerHandler;
    }

    public static /* synthetic */ Handler access$1100(SplashActivity r10) {
        return r10.mHandler;
    }

    public static /* synthetic */ RepAdEntity access$1202(SplashActivity r10, RepAdEntity r11) {
        r10.mAdEntity = r11;
        return r11;
    }

    public static /* synthetic */ ImageView access$1300(SplashActivity r10) {
        return r10.mIvAd;
    }

    public static /* synthetic */ boolean access$1402(SplashActivity r10, boolean r11) {
        r10.mIsAdPresent = r11;
        return r11;
    }

    public static /* synthetic */ void access$1500(SplashActivity r10, int r11) {
        r10.startTimer(r11);
    }

    public static /* synthetic */ NSubscriber access$200(SplashActivity r10) {
        return r10.mNSubscriber;
    }

    public static /* synthetic */ AdListener access$400(SplashActivity r10) {
        return r10.mAdListener;
    }

    public static /* synthetic */ boolean access$500(SplashActivity r10) {
        return r10.mIsStop;
    }

    public static /* synthetic */ List access$602(SplashActivity r10, List r11) {
        r10.mAdList = r11;
        return r11;
    }

    public static /* synthetic */ void access$700(SplashActivity r10) {
        r10.loopNextAd();
    }

    public static /* synthetic */ int access$800(SplashActivity r10) {
        return r10.mCurSecond;
    }

    public static /* synthetic */ int access$810(SplashActivity r10) {
        int r11 = r10.mCurSecond;
        r10.mCurSecond = r11 - 1;
        return r11;
    }

    public static /* synthetic */ TextView access$900(SplashActivity r10) {
        return r10.mTvSkip;
    }

    private boolean checkAd(RepAdEntity<RepSplashMediaEntity> r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.isCreativeAvailable() == false) goto L20;
        RepCreativeEntity r11 = (RepCreativeEntity) r10.getCreative().get(0);
        if (r11 == null) goto L21;
        RepSplashMediaEntity r12 = (RepSplashMediaEntity) r11.getMedia();
        if (r12 == null) goto L22;
        boolean r13 = true;
        if (TextUtils.isEmpty(r12.getPkg()) == false) goto L14;
    L23:
        return r13;
    L14:
        if (TextUtils.isEmpty(r12.getDeeplink_url()) == false) goto L23;
        boolean r14 = com.bytedanceos.common.toolbox.e.x0(r12.getPkg());
        r13 = !r14;
        if (r14 == false) goto L23;
        com.bytedanceos.common.toolbox.i.a(TAG, r12.getPkg() + " has been installed");
        goto L23
    L22:
        return false;
    L21:
        return false;
    L20:
        return false;
    }

    private void continueTimer() {
        if (this.mCurSecond >= 0) goto L5;
        this.mCurSecond = 0;
    L5:
        pauseTimer();
        final Looper r10 = Looper.getMainLooper();
        Handler r11 = new AnonymousClass2(this, r10);
        this.mTimerHandler = r11;
        r11.sendEmptyMessage(100);
    }

    private void exitSplash() {
        this.mIsStop = true;
        Handler r10 = this.mHandler;
        if (r10 == null) goto L6;
        r10.removeCallbacksAndMessages(null);
    L6:
        if (AppStateHelper.getInstance().isSingleActivity() == false) goto L10;
        AdJumpUtil.startMainPage(this);
        overridePendingTransition(R$anim.splash_fade_in, R$anim.splash_hold);
        Handler r11 = this.mHandler;
        if (r11 == null) goto L12;
        r11.sendEmptyMessageDelayed(102, getResources().getInteger(R.integer.config_shortAnimTime));
        return;
    L12:
        return;
    L10:
        finish();
        overridePendingTransition(0, R$anim.splash_fade_out);
    }

    private void initListener() {
        this.mIvAd.setOnClickListener(this);
        this.mIvAd.setClickable(false);
        this.mTvSkip.setOnClickListener(this);
        this.mAdListener = new SplashAdListener(this, null);
    }

    private void initSplash() {
        setContentView(R$layout.layout_splash);
        this.mIsSplashInit = true;
        initView();
        initListener();
    }

    private void initView() {
        this.mIvAd = (ImageView) findViewById(R$id.iv_ad);
        TextView r10 = (TextView) findViewById(R$id.tv_skip);
        this.mTvSkip = r10;
        r10.setVisibility(8);
        this.mTvTitle = (TextView) findViewById(R$id.tv_title);
        if (BaseApplication.c().o() == true) goto L6;
        this.mTvTitle.setText(getString(R$string.splash_ad_title_gamestore));
        return;
    }

    private void loopNextAd() {
        if (com.bytedanceos.common.toolbox.c.a(this.mAdList) == false) goto L8;
        AdListener r10 = this.mAdListener;
        if (r10 == null) goto L18;
        r10.onNoAD("empty adlist");
        return;
    L18:
        return;
    L8:
        RepAdEntity<RepSplashMediaEntity> r11 = this.mAdList.remove(0);
        if (checkAd(r11) == true) goto L11;
        loopNextAd();
        return;
    L11:
        if (r11.getSet().getAtype() != 1) goto L21;
        AdListener r12 = this.mAdListener;
        if (r12 == null) goto L19;
        r12.onResponse(r11);
        return;
    L19:
        return;
    }

    private void pauseTimer() {
        Handler r10 = this.mTimerHandler;
        if (r10 == null) goto L6;
        r10.removeCallbacksAndMessages(null);
        return;
    }

    private void requestAd() {
        this.mHandler.removeMessages(101);
        this.mHandler.sendEmptyMessageDelayed(101, 1000);
        this.mIsStop = false;
        com.bytedanceos.common.toolbox.e.z1(this.mNSubscriber);
        NSubscriber<RepAdsEntity<RepSplashMediaEntity>> r10 = new AnonymousClass1(this);
        this.mNSubscriber = r10;
        addNSubscriber(r10);
    }

    private void startTimer(int r10) {
        this.mTvSkip.setVisibility(0);
        if (r10 > 0) goto L6;
        r10 = 3;
    L6:
        this.mTotalSeconds = r10;
        this.mCurSecond = r10;
        continueTimer();
    }

    private void stopTimer() {
        pauseTimer();
        this.mCurSecond = 0;
    }

    @Override // com.bytedanceos.common.ui.BasicActivity
    public String getSourcePage() {
        return "9029";
    }

    @Override // com.bytedanceos.common.ui.BasicActivity
    public String getSourcePageName() {
        return getString(R$string.splash);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        if (r10.getId() != R$id.tv_skip) goto L8;
        AdListener r11 = this.mAdListener;
        if (r11 == null) goto L13;
        r11.onSkip(this.mAdEntity);
        return;
    L13:
        return;
    L8:
        if (r10.getId() != R$id.iv_ad) goto L15;
        AdListener r12 = this.mAdListener;
        if (r12 == null) goto L16;
        r12.onClick(this.mAdEntity, r10);
        return;
    L16:
        return;
    }

    @Override // com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        if (s.h(getApplicationContext()) == false) goto L11;
        AdJumpUtil.startMainPage(this);
        finish();
    L9:
        m9.e.d0(this).b0().G(BarHide.FLAG_HIDE_STATUS_BAR).M(-1).N(true).H();
        return;
    L11:
        AdJumpUtil.startMainPage(this);     // Catch: Exception -> L7
        finish();     // Catch: Exception -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    @Override // com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mIsAdPresent = false;
        this.mIsStop = true;
        Handler r10 = this.mHandler;
        if (r10 == null) goto L5;
        r10.removeCallbacksAndMessages(null);
    L5:
        stopTimer();
        this.mIsSplashInit = false;
        com.bytedanceos.common.toolbox.glide.b.a(BaseApplication.c());
        com.bytedanceos.common.toolbox.e.z1(this.mNSubscriber);
        m9.e.d0(this).q();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mIsStop = true;
        Handler r10 = this.mHandler;
        if (r10 == null) goto L5;
        r10.removeMessages(101);
    L5:
        pauseTimer();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mIsSplashInit == true) goto L6;
        return;
    L6:
        if (this.mIsAdPresent == false) goto L8;
        continueTimer();
        return;
    L8:
        requestAd();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
