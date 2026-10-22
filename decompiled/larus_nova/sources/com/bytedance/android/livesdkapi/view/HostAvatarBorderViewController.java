package com.bytedance.android.livesdkapi.view;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.base.model.user.User;
import ry.f;

/* JADX INFO: loaded from: classes12.dex */
public class HostAvatarBorderViewController implements f {
    private static final int ANIMATION_DURATION_TIME = 800;
    private static final int CIRCLE_ANIMATION_DURATION_TIME = 640;
    public static final String TAG = null;
    private static boolean isFollowPageResumed;
    private ValueAnimator animator;
    private AnimatorSet animatorSet;
    private View.OnAttachStateChangeListener attachListener;
    private SaasLiveCircleView avartarCircleView;
    private boolean canPlayAnimation;
    private User curUser;
    private boolean isCircleRunning;
    protected boolean isCloseAnim;
    private boolean isFeed;
    private boolean isFollowSkyLiveAnimScene;
    private boolean isIgnoreFollowSkyLiveAnimStartWhenPageNotResume;
    private boolean isLiving;
    protected boolean isOfficialAuthor;
    private boolean isRunning;
    private View liveAvatarView;
    public String mEventType;
    protected Class sceneClazz;
    private View unliveAvatarView;
    private ValueAnimator valueAnimator;

    public boolean needCallStartAnim() {
        return true;
    }

    public boolean needCallStopAnim() {
        return true;
    }

    public void setCanPlayAnimationOpt() {
        this.canPlayAnimation = false;
    }

    public boolean shouldShowLiveEffect(User r100) {
        return true;
    }

    public void showLiveEffect() {
        setVisibility(0);
        startAnimation();
    }

    public void startAnimation() {
        this.isIgnoreFollowSkyLiveAnimStartWhenPageNotResume = false;
        boolean r100 = shouldShowLiveEffect(this.curUser);
        this.isLiving = r100;
        if (r100 == true) goto L7;
        stopLiveEffect();
        return;
    L7:
        if (this.isRunning == false) goto L10;
        return;
    L10:
        if (this.isCloseAnim == false) goto L12;
        return;
    L12:
        createAnimation();
        this.animatorSet.play(this.valueAnimator);
        this.isRunning = true;
        this.animatorSet.start();
    }

    static {
        TAG = "HostAvatarBorderViewController";
        isFollowPageResumed = false;
    }

    private void createAnimation() {
        if (this.valueAnimator != null) goto L9;
        SaasLiveCircleView r100 = this.avartarCircleView;
        if (r100 == null) goto L7;
        r100.isCatonFuncOptEnabled = false;
    L7:
        ValueAnimator r101 = ValueAnimator.ofInt(new int[]{0, 800});
        this.valueAnimator = r101;
        r101.setRepeatCount(-1);
        this.valueAnimator.setRepeatMode(1);
        this.valueAnimator.addUpdateListener(new AnonymousClass2(this));
    L9:
        if (this.animator != null) goto L12;
        ValueAnimator r102 = ValueAnimator.ofInt(new int[]{0, 800});
        this.animator = r102;
        r102.setRepeatCount(-1);
        this.animator.setRepeatMode(1);
        this.animator.setDuration(800);
        this.animator.addUpdateListener(new AnonymousClass3(this));
        this.animator.addListener(new AnonymousClass4(this));
    L12:
        if (this.animatorSet != null) goto L15;
        AnimatorSet r103 = new AnimatorSet();
        this.animatorSet = r103;
        r103.setDuration(800);
        this.animatorSet.addListener(new AnonymousClass5(this));
        return;
    }

    private void createCombineAnimation() {
        if (this.valueAnimator != null) goto L9;
        SaasLiveCircleView r100 = this.avartarCircleView;
        if (r100 == null) goto L7;
        r100.isCatonFuncOptEnabled = false;
    L7:
        ValueAnimator r101 = ValueAnimator.ofInt(new int[]{0, 800});
        this.valueAnimator = r101;
        r101.setRepeatCount(-1);
        this.valueAnimator.setRepeatMode(1);
        this.valueAnimator.addUpdateListener(new AnonymousClass6(this));
        this.valueAnimator.addListener(new AnonymousClass7(this));
    L9:
        if (this.animatorSet != null) goto L12;
        AnimatorSet r102 = new AnimatorSet();
        this.animatorSet = r102;
        r102.setDuration(800);
        this.animatorSet.addListener(new AnonymousClass8(this));
        return;
    }

    public void endAnimation() {
        AnimatorSet r100 = this.animatorSet;
        if (r100 == null) goto L5;
        r100.cancel();
        this.isRunning = false;
        this.isCircleRunning = false;
    L5:
        this.isIgnoreFollowSkyLiveAnimStartWhenPageNotResume = false;
    }

    public boolean isAnimating() {
        if (this.isRunning == false) goto L5;
    L8:
        return true;
    L5:
        if (this.isCircleRunning == true) goto L8;
        return false;
    }

    public void onFollowSkyLivListAnimationCanPlay() {
        if (this.isIgnoreFollowSkyLiveAnimStartWhenPageNotResume == false) goto L6;
        startAnimation();
        this.isIgnoreFollowSkyLiveAnimStartWhenPageNotResume = false;
        return;
    }

    public HostAvatarBorderViewController() {
        this.isCloseAnim = false;
        this.isFeed = false;
        this.canPlayAnimation = true;
        this.isFollowSkyLiveAnimScene = false;
        this.isIgnoreFollowSkyLiveAnimStartWhenPageNotResume = false;
        this.attachListener = new AnonymousClass1(this);
    }

    public void resetAllStatue() {
        endAnimation();
        AnimatorSet r100 = this.animatorSet;
        if (r100 == null) goto L5;
        r100.removeAllListeners();
    L5:
        View r101 = this.liveAvatarView;
        if (r101 == null) goto L9;
        r101.removeOnAttachStateChangeListener(this.attachListener);
        this.liveAvatarView.setScaleX(1.0f);
        this.liveAvatarView.setScaleY(1.0f);
        return;
    }

    public void stopLiveEffect() {
        endAnimation();
        setVisibility(8);
    }

    public static /* synthetic */ boolean access$000(HostAvatarBorderViewController r100) {
        return r100.isLiving;
    }

    public static /* synthetic */ View access$100(HostAvatarBorderViewController r100) {
        return r100.liveAvatarView;
    }

    public static /* synthetic */ boolean access$200(HostAvatarBorderViewController r100) {
        return r100.isCircleRunning;
    }

    public static /* synthetic */ ValueAnimator access$300(HostAvatarBorderViewController r100) {
        return r100.animator;
    }

    public static /* synthetic */ SaasLiveCircleView access$400(HostAvatarBorderViewController r100) {
        return r100.avartarCircleView;
    }

    public static /* synthetic */ ValueAnimator access$500(HostAvatarBorderViewController r100) {
        return r100.valueAnimator;
    }

    public static void setIsFollowPageResumed(boolean r100) {
        isFollowPageResumed = r100;
    }

    public void setCanPlayAnimation(boolean r100) {
        this.canPlayAnimation = r100;
    }

    public void setCloseAnim(boolean r100) {
        this.isCloseAnim = r100;
    }

    public void setIsFeed(boolean r100) {
        this.isFeed = r100;
    }

    public void setIsFollowSkyLiveAnimScene(boolean r100) {
        this.isFollowSkyLiveAnimScene = r100;
    }

    public void setVisibility(int r100) {
        if (r100 != 0) goto L14;
        SaasLiveCircleView r101 = this.avartarCircleView;
        if (r101 == null) goto L7;
        r101.setVisibility(0);
    L7:
        View r102 = this.liveAvatarView;
        if (r102 == null) goto L26;
        r102.setVisibility(0);
        View r103 = this.unliveAvatarView;
        if (r103 != null) goto L12;
        return;
    L12:
        if (this.liveAvatarView == r103) goto L28;
        r103.setVisibility(8);
        return;
    L28:
        return;
    L26:
        return;
    L14:
        SaasLiveCircleView r104 = this.avartarCircleView;
        if (r104 == null) goto L17;
        r104.setVisibility(8);
    L17:
        View r105 = this.liveAvatarView;
        if (r105 != null) goto L20;
    L22:
        View r106 = this.unliveAvatarView;
        if (r106 == null) goto L30;
        r106.setVisibility(0);
        return;
    L30:
        return;
    L20:
        if (r105 == this.unliveAvatarView) goto L22;
        r105.setVisibility(8);
        goto L22
    }

    public static /* synthetic */ boolean access$202(HostAvatarBorderViewController r100, boolean r101) {
        r100.isCircleRunning = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$602(HostAvatarBorderViewController r100, boolean r101) {
        r100.isRunning = r101;
        return r101;
    }

    public void bind(User r100, Class r101) {
        bind(r100, r101, false);
    }

    @Override // ry.f
    public void endAnimation(ImageView r100, View r101) {
        endAnimation();
    }

    @Override // ry.f
    public void startAnimation(ImageView r100, View r101) {
        startAnimation();
    }

    public void bind(User r100, Class r101, boolean r102) {
        this.isOfficialAuthor = r102;
        this.curUser = r100;
        this.sceneClazz = r101;
        this.isLiving = shouldShowLiveEffect(r100);
        this.liveAvatarView.removeOnAttachStateChangeListener(this.attachListener);
        this.liveAvatarView.addOnAttachStateChangeListener(this.attachListener);
        if (r100 == null) goto L6;
        r100.getNickName();
    L6:
        if (this.isLiving == false) goto L8;
        this.avartarCircleView.postInvalidate();
        showLiveEffect();
        return;
    L8:
        stopLiveEffect();
    }

    public HostAvatarBorderViewController(boolean r100, View r101, View r102, SaasLiveCircleView r103) {
        int r104 = 0;
        this.isCloseAnim = false;
        this.isFeed = false;
        this.canPlayAnimation = true;
        this.isFollowSkyLiveAnimScene = false;
        this.isIgnoreFollowSkyLiveAnimStartWhenPageNotResume = false;
        this.attachListener = new AnonymousClass1(this);
        this.liveAvatarView = r101;
        this.unliveAvatarView = r102;
        this.avartarCircleView = r103;
        this.isLiving = r100;
        if (r100 == true) goto L6;
        r104 = 8;
    L6:
        r103.setVisibility(r104);
        r101.addOnAttachStateChangeListener(this.attachListener);
    }

    public HostAvatarBorderViewController(boolean r100, View r101, View r102, SaasLiveCircleView r103, boolean r104) {
        int r105 = 0;
        this.isCloseAnim = false;
        this.isFeed = false;
        this.canPlayAnimation = true;
        this.isFollowSkyLiveAnimScene = false;
        this.isIgnoreFollowSkyLiveAnimStartWhenPageNotResume = false;
        this.attachListener = new AnonymousClass1(this);
        this.liveAvatarView = r101;
        this.unliveAvatarView = r102;
        this.avartarCircleView = r103;
        this.isLiving = r100;
        if (r104 == false) goto L8;
        if (r100 == true) goto L7;
        r105 = 8;
    L7:
        r103.setVisibility(r105);
    L8:
        r101.addOnAttachStateChangeListener(this.attachListener);
    }
}
