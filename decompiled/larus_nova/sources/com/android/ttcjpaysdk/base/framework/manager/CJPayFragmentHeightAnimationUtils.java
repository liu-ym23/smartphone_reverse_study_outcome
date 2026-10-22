package com.android.ttcjpaysdk.base.framework.manager;

import android.content.Context;
import android.view.View;
import com.android.ttcjpaysdk.base.framework.BaseFragment;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayKotlinExtensionsKt;
import com.android.ttcjpaysdk.base.utils.CJPayAnimationUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J@\u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J@\u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/manager/CJPayFragmentHeightAnimationUtils;", "", "()V", "performNewPageHeightAnimation", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bottomFragment", "Lcom/android/ttcjpaysdk/base/framework/BaseFragment;", "unknownHeight", "", "isRemove", "isDoLayerAnimation", "callback", "Lcom/android/ttcjpaysdk/base/framework/manager/CJPayFragmentHeightAnimationUtils$OnHeightAnimationCallback;", "performPageHeightAnimation", "bottomView", "Landroid/view/View;", "OnHeightAnimationCallback", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayFragmentHeightAnimationUtils {
    public static final CJPayFragmentHeightAnimationUtils INSTANCE = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/manager/CJPayFragmentHeightAnimationUtils$OnHeightAnimationCallback;", "", "doPreWork", "", "panelHeight", "", "startValue", "endValue", "doWithHeightAnimEnd", "doWithHeightAnimStart", "doWithoutHeightAnim", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnHeightAnimationCallback {
        void doPreWork(int r100, int r101, int r102);

        void doWithHeightAnimEnd(int r100, int r101, int r102);

        void doWithHeightAnimStart(int r100, int r101, int r102);

        void doWithoutHeightAnim();
    }

    static {
        INSTANCE = new CJPayFragmentHeightAnimationUtils();
    }

    private CJPayFragmentHeightAnimationUtils() {
    }

    @JvmStatic
    public static final boolean performNewPageHeightAnimation(Context r100, BaseFragment r101, int r102, boolean r103, boolean r104, final OnHeightAnimationCallback r110) {
        if (r100 == null) goto L51;
        if (r101 == null) goto L51;
        if (r102 <= 0) goto L51;
        View r105 = r101.getPanelView();
        if (r105 == null) goto L10;
        int r106 = r105.getHeight();
    L11:
        final int r107 = CJPayKotlinExtensionsKt.px2dp(r100, r106);
        View r108 = r101.getPanelView();
        if (r108 == null) goto L14;
        Object r109 = r108.getTag();
    L16:
        if ((r109 instanceof Integer) == false) goto L18;
        Integer r111 = (Integer) r109;
    L19:
        if (r111 == null) goto L21;
        int r112 = r111.intValue();
    L22:
        if (r103 == false) goto L24;
        r107 = r112;
    L24:
        View r113 = r101.getPanelView();
        if (r103 == false) goto L27;
        float r114 = r102;
    L28:
        final int r115 = CJPayBasicExtensionKt.dip2px(r114, r100);
        if (r103 == false) goto L31;
        float r116 = r107;
    L32:
        final int r117 = CJPayBasicExtensionKt.dip2px(r116, r100);
        if (r113 == null) goto L51;
        if (r107 <= 0) goto L51;
        if (r115 <= 0) goto L51;
        if (r117 <= 0) goto L51;
        if (r110 == null) goto L40;
        r110.doPreWork(r107, r115, r117);
    L40:
        if (r104 == false) goto L42;
        r101.performPanelLayerViewVisible(!r103);
    L42:
        if (r115 != r117) goto L44;
        return false;
    L44:
        if (r103 == false) goto L49;
        View r118 = r101.getPanelView();
        if (r118 == null) goto L49;
        r118.setTag(null);
    L49:
        CJPayAnimationUtils.viewHeightAnimation(r113, r115, r117, 300, new AnonymousClass1(r110, r107, r115, r117));
        return true;
    L31:
        r116 = r102;
        goto L32
    L27:
        r114 = r107;
        goto L28
    L21:
        r112 = 470;
        goto L22
    L18:
        r111 = null;
        goto L19
    L14:
        r109 = null;
        goto L16
    L10:
        r106 = 0;
    L51:
        return false;
    }

    @JvmStatic
    public static final boolean performPageHeightAnimation(Context r100, View r101, int r110, boolean r111, boolean r112, final OnHeightAnimationCallback r113) {
        if (r100 == null) goto L34;
        if (r101 == null) goto L34;
        if (r110 <= 0) goto L34;
        final int r102 = CJPayKotlinExtensionsKt.px2dp(r100, r101.getHeight());
        Object r103 = r101.getTag();
        if ((r103 instanceof Integer) == false) goto L10;
        Integer r104 = (Integer) r103;
    L11:
        if (r104 == null) goto L13;
        int r105 = r104.intValue();
    L14:
        if (r111 == false) goto L16;
        r102 = r105;
    L16:
        if (r111 == false) goto L18;
        float r106 = r110;
    L19:
        final int r107 = CJPayBasicExtensionKt.dip2px(r106, r100);
        if (r111 == false) goto L22;
        float r114 = r102;
    L23:
        final int r108 = CJPayBasicExtensionKt.dip2px(r114, r100);
        if (r102 <= 0) goto L34;
        if (r107 <= 0) goto L34;
        if (r108 <= 0) goto L34;
        if (r113 == null) goto L30;
        r113.doPreWork(r102, r107, r108);
    L30:
        if (r107 != r108) goto L32;
        return false;
    L32:
        CJPayAnimationUtils.viewHeightAnimation(r101, r107, r108, 300, new AnonymousClass2(r113, r102, r107, r108));
        return true;
    L22:
        r114 = r110;
        goto L23
    L18:
        r106 = r102;
        goto L19
    L13:
        r105 = 470;
        goto L14
    L10:
        r104 = null;
    L34:
        return false;
    }

    @JvmStatic
    public static final boolean performPageHeightAnimation(Context r100, BaseFragment r101, int r102, boolean r103, boolean r110, final OnHeightAnimationCallback r111) {
        if (r100 == null) goto L32;
        if (r101 == null) goto L32;
        if (r102 <= 0) goto L32;
        final int r104 = r101.getPanelHeight();
        View r105 = r101.getPanelView();
        if (r103 == false) goto L10;
        float r106 = r102;
    L11:
        final int r107 = CJPayBasicExtensionKt.dip2px(r106, r100);
        if (r103 == false) goto L14;
        float r108 = r104;
    L15:
        final int r109 = CJPayBasicExtensionKt.dip2px(r108, r100);
        if (r105 == null) goto L32;
        if (r104 <= 0) goto L32;
        if (r107 <= 0) goto L32;
        if (r109 <= 0) goto L32;
        if (r111 == null) goto L24;
        r111.doPreWork(r104, r107, r109);
    L24:
        if (r110 == false) goto L26;
        r101.performPanelLayerViewVisible(!r103);
    L26:
        if (r104 != r102) goto L30;
        if (r111 == null) goto L29;
        r111.doWithoutHeightAnim();
    L29:
        return false;
    L30:
        CJPayAnimationUtils.viewHeightAnimation(r105, r107, r109, 300, new C88401(r111, r104, r107, r109));
        return true;
    L14:
        r108 = r102;
        goto L15
    L10:
        r106 = r104;
    L32:
        return false;
    }

    public static /* synthetic */ boolean performNewPageHeightAnimation$default(Context r100, BaseFragment r101, int r102, boolean r103, boolean r110, OnHeightAnimationCallback r111, int r112, Object r113) {
        if ((r112 & 32) == 0) goto L6;
        r111 = null;
    L6:
        return performNewPageHeightAnimation(r100, r101, r102, r103, r110, r111);
    }

    public static /* synthetic */ boolean performPageHeightAnimation$default(Context r100, View r101, int r102, boolean r103, boolean r110, OnHeightAnimationCallback r111, int r112, Object r113) {
        if ((r112 & 32) == 0) goto L6;
        r111 = null;
    L6:
        return performPageHeightAnimation(r100, r101, r102, r103, r110, r111);
    }

    public static /* synthetic */ boolean performPageHeightAnimation$default(Context r100, BaseFragment r101, int r102, boolean r103, boolean r110, OnHeightAnimationCallback r111, int r112, Object r113) {
        if ((r112 & 32) == 0) goto L6;
        r111 = null;
    L6:
        return performPageHeightAnimation(r100, r101, r102, r103, r110, r111);
    }
}
