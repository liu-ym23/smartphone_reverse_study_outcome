package com.android.ttcjpaysdk.ocr.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0013J4\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u00132\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0013J\u0018\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u001aJ6\u0010\u001b\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\r0 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/utils/OCRAnimationUtil;", "", "()V", "FLASH_LIGHT_HIDE_DURATION", "", "FLASH_LIGHT_LAST_SHOW_TIME_TAG_KEY", "", "FLASH_LIGHT_MIN_VISIBLE_DURATION", "FLASH_LIGHT_PENDING_HIDE_TAG_KEY", "FLASH_LIGHT_SHOW_DURATION", "FLASH_LIGHT_SHOW_START_TIME_TAG_KEY", "FLASH_LIGHT_TARGET_STATE_TAG_KEY", "doScanSuccessAnim", "", "ocrStartImg", "Landroid/view/View;", "ocrEndImg", "Landroid/widget/ImageView;", "callback", "Lkotlin/Function0;", "doScanSuccessAnimInternal", "onStartCallback", "onFinishCallback", "executeWarningAnimation", "view", "listener", "Landroid/animation/AnimatorListenerAdapter;", "flashLightAnim", "lightView", "isShow", "", "respectMinVisibleDuration", "Lkotlin/Function1;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCRAnimationUtil {
    private static final long FLASH_LIGHT_HIDE_DURATION = 300;
    private static final int FLASH_LIGHT_LAST_SHOW_TIME_TAG_KEY = 0;
    private static final long FLASH_LIGHT_MIN_VISIBLE_DURATION = 300;
    private static final int FLASH_LIGHT_PENDING_HIDE_TAG_KEY = 0;
    private static final long FLASH_LIGHT_SHOW_DURATION = 300;
    private static final int FLASH_LIGHT_SHOW_START_TIME_TAG_KEY = 0;
    private static final int FLASH_LIGHT_TARGET_STATE_TAG_KEY = 0;
    public static final OCRAnimationUtil INSTANCE = null;

    private OCRAnimationUtil() {
    }

    static {
        INSTANCE = new OCRAnimationUtil();
        FLASH_LIGHT_TARGET_STATE_TAG_KEY = R.id.new_light_layout;
        FLASH_LIGHT_LAST_SHOW_TIME_TAG_KEY = R.id.new_light_image;
        FLASH_LIGHT_PENDING_HIDE_TAG_KEY = R.id.new_light_tips;
        FLASH_LIGHT_SHOW_START_TIME_TAG_KEY = R.id.album_upload_tv;
    }

    public static final /* synthetic */ int access$getFLASH_LIGHT_LAST_SHOW_TIME_TAG_KEY$p() {
        return FLASH_LIGHT_LAST_SHOW_TIME_TAG_KEY;
    }

    public static final /* synthetic */ int access$getFLASH_LIGHT_PENDING_HIDE_TAG_KEY$p() {
        return FLASH_LIGHT_PENDING_HIDE_TAG_KEY;
    }

    public static final /* synthetic */ int access$getFLASH_LIGHT_SHOW_START_TIME_TAG_KEY$p() {
        return FLASH_LIGHT_SHOW_START_TIME_TAG_KEY;
    }

    public static final /* synthetic */ int access$getFLASH_LIGHT_TARGET_STATE_TAG_KEY$p() {
        return FLASH_LIGHT_TARGET_STATE_TAG_KEY;
    }

    public final void executeWarningAnimation(View r100, AnimatorListenerAdapter r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        if (r100 != null) goto L5;
        return;
    L5:
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, CJPayBasicExtensionKt.dpF(-20.0f), CJPayBasicExtensionKt.dpF(20.0f), CJPayBasicExtensionKt.dpF(-20.0f), CJPayBasicExtensionKt.dpF(20.0f), 0.0f});
        r102.setDuration(500);
        r102.setInterpolator(new AccelerateDecelerateInterpolator());
        r102.addListener(r101);
        r102.start();
    }

    public final void doScanSuccessAnim(View r100, ImageView r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "ocrStartImg");
        Intrinsics.checkNotNullParameter(r101, "ocrEndImg");
        Intrinsics.checkNotNullParameter(r102, "callback");
        doScanSuccessAnimInternal(r100, r101, r102, null);
    }

    public final void doScanSuccessAnimInternal(final View r110, ImageView r111, final Function0<Unit> r112, final Function0<Unit> r113) {
        Intrinsics.checkNotNullParameter(r110, "ocrStartImg");
        Intrinsics.checkNotNullParameter(r111, "ocrEndImg");
        Intrinsics.checkNotNullParameter(r112, "onStartCallback");
        int[] r100 = new int[2];
        r110.getLocationOnScreen(r100);
        int r101 = r100[0];
        int r102 = r100[1];
        r111.getLocationOnScreen(r100);
        ObjectAnimator r103 = ObjectAnimator.ofPropertyValuesHolder(r110, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, r100[0] - r101}), PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, r100[1] - r102}), PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.45f}), PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.45f})});
        r103.setInterpolator(new PathInterpolator(0.72f, 0.0f, 0.66f, 1.0f));
        r103.setDuration(500);
        r103.setStartDelay(167);
        r103.addListener(new OCRAnimationUtil$doScanSuccessAnimInternal$startAnim$1$1(r110));
        ObjectAnimator r104 = ObjectAnimator.ofPropertyValuesHolder(r111, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.9f, 1.0f}), PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.9f, 1.0f}), PropertyValuesHolder.ofFloat("alpha", new float[]{0.5f, 1.0f})});
        r104.setInterpolator(new PathInterpolator(0.6f, 0.0f, 0.66f, 1.0f));
        r104.setDuration(283);
        r104.setStartDelay(533);
        r104.addListener(new OCRAnimationUtil$doScanSuccessAnimInternal$endScaleAnim$1$1(r112, r113));
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r110, ImageView.ALPHA, new float[]{0.0f, 1.0f, 0.0f});
        r105.setDuration(833);
        r105.setInterpolator(new LinearInterpolator());
        AnimatorSet r106 = new AnimatorSet();
        r106.playTogether(new Animator[]{r103, r104, r105});
        r106.start();
    }

    public final void flashLightAnim(final View r210, final boolean r211, boolean r212, final Function1<? super Boolean, Unit> r213) {
        Intrinsics.checkNotNullParameter(r213, "callback");
        if (r210 != null) goto L145;
        return;
    L145:
        long r100 = SystemClock.uptimeMillis();     // Catch: Throwable -> L131
        int r101 = FLASH_LIGHT_PENDING_HIDE_TAG_KEY;     // Catch: Throwable -> L131
        Object r110 = r210.getTag(r101);     // Catch: Throwable -> L131
        if ((r110 instanceof Runnable) == false) goto L9;
        Runnable r111 = (Runnable) r110;     // Catch: Throwable -> L131
    L10:
        if (r111 == null) goto L12;
        r210.removeCallbacks(r111);     // Catch: Throwable -> L131
        r210.setTag(r101, null);     // Catch: Throwable -> L131
    L12:
        int r112 = FLASH_LIGHT_TARGET_STATE_TAG_KEY;     // Catch: Throwable -> L131
        Object r113 = r210.getTag(r112);     // Catch: Throwable -> L131
        if ((r113 instanceof Boolean) == false) goto L15;
        Boolean r114 = (Boolean) r113;     // Catch: Throwable -> L131
    L16:
        int r115 = FLASH_LIGHT_SHOW_START_TIME_TAG_KEY;     // Catch: Throwable -> L131
        Object r116 = r210.getTag(r115);     // Catch: Throwable -> L131
        if ((r116 instanceof Long) == false) goto L19;
        Long r117 = (Long) r116;     // Catch: Throwable -> L131
    L21:
        if (r117 == null) goto L23;
        long r118 = r117.longValue();     // Catch: Throwable -> L131
    L24:
        Object r119 = Boolean.FALSE;     // Catch: Throwable -> L131
        boolean r120 = true;
        if (Intrinsics.areEqual(r114, r119) == true) goto L27;
    L31:
        boolean r121 = false;
    L32:
        Object r122 = Boolean.TRUE;     // Catch: Throwable -> L131
        if (Intrinsics.areEqual(r114, r122) == true) goto L35;
    L41:
        boolean r214 = false;
    L43:
        if (r210.getVisibility() == 0) goto L45;
    L47:
        boolean r215 = false;
    L49:
        if (Intrinsics.areEqual(r114, r119) == true) goto L51;
    L53:
        r120 = false;
    L54:
        if (r211 == false) goto L56;
    L60:
        if (r211 == false) goto L67;
        if (r120 == false) goto L67;
        ViewPropertyAnimator r102 = r210.animate();     // Catch: Throwable -> L131
        if (r102 == null) goto L65;
        r102.cancel();     // Catch: Throwable -> L131
    L65:
        r210.setAlpha(1.0f);     // Catch: Throwable -> L131
        r210.setVisibility(0);     // Catch: Throwable -> L131
        r210.setTag(r112, r122);     // Catch: Throwable -> L131
        r210.setTag(r115, 0L);     // Catch: Throwable -> L131
        r210.setTag(FLASH_LIGHT_LAST_SHOW_TIME_TAG_KEY, Long.valueOf(r100));     // Catch: Throwable -> L131
        r213.invoke(r122);     // Catch: Throwable -> L131
        return;
    L67:
        if (r211 == false) goto L76;
        if (r214 == false) goto L76;
        if (r121 == true) goto L76;
        ViewPropertyAnimator r103 = r210.animate();     // Catch: Throwable -> L131
        if (r103 == null) goto L73;
        r103.cancel();     // Catch: Throwable -> L131
    L73:
        r210.setAlpha(1.0f);     // Catch: Throwable -> L131
        r210.setVisibility(0);     // Catch: Throwable -> L131
        r210.setTag(r112, r122);     // Catch: Throwable -> L131
        r210.setTag(FLASH_LIGHT_LAST_SHOW_TIME_TAG_KEY, Long.valueOf(r100));     // Catch: Throwable -> L131
        r213.invoke(r122);     // Catch: Throwable -> L131
        return;
    L76:
        if (r211 == false) goto L83;
        if (r121 == true) goto L83;
        if (r215 == true) goto L80;
        if (r214 == false) goto L83;
    L80:
        r210.setTag(r112, r122);     // Catch: Throwable -> L131
        return;
    L83:
        if (r211 == true) goto L107;
        if (r212 == false) goto L107;
        if (r214 == false) goto L87;
        long r104 = RangesKt.coerceAtLeast(300 - (r100 - r118), 0) + 300;     // Catch: Throwable -> L131
    L96:
        if (r210.getVisibility() != 0) goto L107;
        if (r104 <= 0) goto L107;
        if (r214 == true) goto L104;
        ViewPropertyAnimator r105 = r210.animate();     // Catch: Throwable -> L131
        if (r105 == null) goto L103;
        r105.cancel();     // Catch: Throwable -> L131
    L103:
        r210.setAlpha(1.0f);     // Catch: Throwable -> L131
        r213.invoke(r122);     // Catch: Throwable -> L131
    L104:
        r210.setTag(r112, r119);     // Catch: Throwable -> L131
        Runnable r106 = new OCRAnimationUtil$flashLightAnim$delayedHide$1(r210, r213);     // Catch: Throwable -> L131
        r210.setTag(r101, r106);     // Catch: Throwable -> L131
        r210.postDelayed(r106, r104);     // Catch: Throwable -> L131
        return;
    L87:
        Object r107 = r210.getTag(FLASH_LIGHT_LAST_SHOW_TIME_TAG_KEY);     // Catch: Throwable -> L131
        if ((r107 instanceof Long) == false) goto L90;
        Long r108 = (Long) r107;     // Catch: Throwable -> L131
    L91:
        if (r108 == null) goto L93;
        long r216 = r108.longValue();     // Catch: Throwable -> L131
    L94:
        r104 = RangesKt.coerceAtLeast(300 - (r100 - r216), 0);     // Catch: Throwable -> L131
        goto L96
    L93:
        r216 = 0;
        goto L94
    L90:
        r108 = null;
    L107:
        if (r211 == true) goto L115;
        if (Intrinsics.areEqual(r114, r119) == false) goto L115;
        if (r210.getVisibility() != 8) goto L115;
        return;
    L115:
        if (r211 == true) goto L146;
        if (r121 == false) goto L146;
        return;
    L146:
        r210.setTag(r112, Boolean.valueOf(r211));     // Catch: Throwable -> L129
        ViewPropertyAnimator r109 = r210.animate();     // Catch: Throwable -> L129
        if (r109 == null) goto L121;
        r109.cancel();     // Catch: Throwable -> L129
    L121:
        ViewPropertyAnimator r123 = r210.animate();     // Catch: Throwable -> L129
        if (r123 == null) goto L148;
        r123.setDuration(300);     // Catch: Throwable -> L129
        if (r211 == false) goto L126;
        float r124 = 1.0f;
    L127:
        r123.alpha(r124);     // Catch: Throwable -> L129
        r123.withStartAction(new OCRAnimationUtil$flashLightAnim$1$1(r213, r210, r211));     // Catch: Throwable -> L129
        r123.withEndAction(new OCRAnimationUtil$flashLightAnim$1$2(r210, r211, r213));     // Catch: Throwable -> L129
        r123.start();     // Catch: Throwable -> L129
        return;
    L126:
        r124 = 0.0f;
        goto L127
    L148:
        return;
    L129:
        th = th;
    L133:
        CJBasicCommonUtils.reportCatchException("OCRAnimationUtil#flashLightAnim", th);
        CJLogger.c("ocr_opt", "flashLightAnim failed", th);
        ViewPropertyAnimator r125 = r210.animate();
        if (r125 == null) goto L136;
        r125.cancel();
    L136:
        if (r211 == false) goto L138;
        int r126 = 0;
    L139:
        r210.setVisibility(r126);
        if (r211 == false) goto L142;
        float r127 = 1.0f;
    L143:
        r210.setAlpha(r127);
        r213.invoke(Boolean.valueOf(r211));
        return;
    L142:
        r127 = 0.0f;
        goto L143
    L138:
        r126 = 8;
        goto L139
    L56:
        if (r210.getVisibility() == 0) goto L60;
        if (r121 == true) goto L60;
        r210.setTag(r112, r119);     // Catch: Throwable -> L131
        r210.setTag(r115, 0L);     // Catch: Throwable -> L131
        r210.setAlpha(0.0f);     // Catch: Throwable -> L131
        r210.setVisibility(8);     // Catch: Throwable -> L131
        r213.invoke(r119);     // Catch: Throwable -> L131
        return;
    L51:
        if (r210.getVisibility() != 0) goto L53;
    L45:
        if (r210.getAlpha() < 1.0f) goto L47;
        r215 = true;
        goto L49
    L35:
        if (r210.getVisibility() != 0) goto L41;
        if (r210.getAlpha() >= 1.0f) goto L41;
        if (r118 <= 0) goto L41;
        r214 = true;
        goto L43
    L27:
        if (r210.getVisibility() != 0) goto L31;
        if (r210.getAlpha() >= 1.0f) goto L31;
        r121 = true;
        goto L32
    L23:
        r118 = 0;
        goto L24
    L19:
        r117 = null;
        goto L21
    L15:
        r114 = null;
        goto L16
    L9:
        r111 = null;
    L131:
        th = th;
        goto L133
    }

    public static /* synthetic */ void flashLightAnim$default(OCRAnimationUtil r100, View r101, boolean r102, boolean r103, Function1 r104, int r105, Object r106) {
        if ((r105 & 4) == 0) goto L5;
        r103 = true;
    L5:
        r100.flashLightAnim(r101, r102, r103, r104);
    }
}
