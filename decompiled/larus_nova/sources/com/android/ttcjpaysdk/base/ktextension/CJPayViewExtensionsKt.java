package com.android.ttcjpaysdk.base.ktextension;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.caijing.sdk.infra.base.api.alog.ALogService;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u001a\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a>\u0010\r\u001a\u00020\u0007\"\b\b\u0000\u0010\u000e*\u00020\b*\u0004\u0018\u0001H\u000e2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u0011H\u000e¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\u0002\u0010\u0014\u001aH\u0010\r\u001a\u00020\u0007\"\b\b\u0000\u0010\u000e*\u00020\b*\u0004\u0018\u0001H\u000e2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u0011H\u000e¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00070\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a2\u0010\u0018\u001a\u00020\u0007*\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001a\u001a?\u0010\u001e\u001a\u00020\u0007*\u00020\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010\u001f\u001a?\u0010 \u001a\u00020\u0007*\u00020\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010\u001f\u001a\u0014\u0010!\u001a\u00020\u0007*\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$\u001a\u0014\u0010!\u001a\u00020\u0007*\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\f\u001a\u0014\u0010%\u001a\u00020\u0007*\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\f\u001a\u0012\u0010&\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a\u001a\u0012\u0010'\u001a\u00020\u0007*\u00020\b2\u0006\u0010(\u001a\u00020)\u001a\n\u0010*\u001a\u00020\u0007*\u00020\b\u001a\n\u0010+\u001a\u00020\u0007*\u00020\b\u001a\n\u0010,\u001a\u00020\u0007*\u00020\b\"\u001d\u0010\u0000\u001a\u0004\u0018\u00010\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006-"}, d2 = {"logService", "Lcom/bytedance/caijing/sdk/infra/base/api/alog/ALogService;", "getLogService", "()Lcom/bytedance/caijing/sdk/infra/base/api/alog/ALogService;", "logService$delegate", "Lkotlin/Lazy;", "setCornersAndBgColor", "", "Landroid/view/View;", "radius", "", "color", "", "setDebouncingOnClickListener", ExifInterface.GPS_DIRECTION_TRUE, "doClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", BaseSwitches.V, "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", VideoThumbInfo.KEY_INTERVAL, "", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;J)V", "setMargins", "left", "", "top", "right", "bottom", "setMarginsDefaultCur", "(Landroid/view/View;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setPaddingDefaultCur", "setTextAndVisible", "Landroid/widget/TextView;", "content", "", "setTextOrInvisible", "setTopMargin", "toggleVisible", "isVisible", "", "viewGone", "viewInvisible", "viewVisible", "cj-host-service-api_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CJPayViewExtensionsKt {
    private static final Lazy logService$delegate = null;

    static {
        logService$delegate = LazyKt.lazy(CJPayViewExtensionsKt$logService$2.INSTANCE);
    }

    public static final ALogService getLogService() {
        return (ALogService) logService$delegate.getValue();
    }

    public static final void viewGone(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setVisibility(8);
    }

    public static final void viewInvisible(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setVisibility(4);
    }

    public static final void viewVisible(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setVisibility(0);
    }

    public static final <T extends View> void setDebouncingOnClickListener(T r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "doClick");
        if (r100 == null) goto L6;
        setDebouncingOnClickListener(r100, r101, 500);
        return;
    }

    public static final void setTextAndVisible(TextView r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        boolean r102 = false;
        if (r101 != null) goto L5;
        Boolean r103 = null;
    L10:
        if (r103 == null) goto L12;
        r102 = r103.booleanValue();
    L12:
        if (r102 == false) goto L14;
        r100.setText(r101);
        viewVisible(r100);
        return;
    L14:
        viewGone(r100);
        return;
    L5:
        if (r101.length() <= 0) goto L7;
        boolean r104 = true;
    L8:
        r103 = Boolean.valueOf(r104);
        goto L10
    L7:
        r104 = false;
        goto L8
    }

    public static final void setTextOrInvisible(TextView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        boolean r102 = false;
        if (r101 != null) goto L5;
        Boolean r103 = null;
    L10:
        if (r103 == null) goto L12;
        r102 = r103.booleanValue();
    L12:
        if (r102 == false) goto L14;
        r100.setText(r101);
        viewVisible(r100);
        return;
    L14:
        viewInvisible(r100);
        return;
    L5:
        if (r101.length() <= 0) goto L7;
        boolean r104 = true;
    L8:
        r103 = Boolean.valueOf(r104);
        goto L10
    L7:
        r104 = false;
        goto L8
    }

    public static final void setTopMargin(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
    L6:
        if (r103 == null) goto L9;
        r103.topMargin = r101;
        r100.setLayoutParams(r103);
        return;
    L9:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static final void toggleVisible(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == false) goto L5;
        viewVisible(r100);
        return;
    L5:
        viewGone(r100);
    }

    public static final void setTextAndVisible(TextView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        boolean r102 = false;
        if (r101 != null) goto L5;
        Boolean r103 = null;
    L10:
        if (r103 == null) goto L12;
        r102 = r103.booleanValue();
    L12:
        if (r102 == false) goto L14;
        r100.setText(r101);
        viewVisible(r100);
        return;
    L14:
        viewGone(r100);
        return;
    L5:
        if (r101.length() <= 0) goto L7;
        boolean r104 = true;
    L8:
        r103 = Boolean.valueOf(r104);
        goto L10
    L7:
        r104 = false;
        goto L8
    }

    public static final void setCornersAndBgColor(View r100, float r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "color");
        GradientDrawable r103 = new GradientDrawable();
        r103.setShape(0);
        r103.setColor(ColorProtector.parseColor(r102));
        r103.setCornerRadius(CJPayBasicExtensionKt.dpF(r101));
        r100.setBackground(r103);
    }

    public static final <T extends View> void setDebouncingOnClickListener(final T r100, final Function1<? super T, Unit> r101, final long r102) {
        Intrinsics.checkNotNullParameter(r101, "doClick");
        if (r100 == null) goto L6;
        r100.setOnClickListener(new AnonymousClass1(r102, r101, r100));
        return;
    }

    public static final void setMargins(View r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r105 = r100.getLayoutParams();
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
    L6:
        if (r106 == null) goto L9;
        r106.setMargins(r101, r102, r103, r104);
        r100.setLayoutParams(r106);
        return;
    L9:
        return;
    L5:
        r106 = null;
        goto L6
    }

    public static final void setMarginsDefaultCur(View r100, Integer r101, Integer r102, Integer r103, Integer r104) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r105 = r100.getLayoutParams();
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
    L6:
        if (r106 == null) goto L21;
        if (r101 == null) goto L9;
        int r107 = r101.intValue();
    L10:
        if (r102 == null) goto L12;
        int r108 = r102.intValue();
    L13:
        if (r103 == null) goto L15;
        int r109 = r103.intValue();
    L16:
        if (r104 == null) goto L18;
        int r110 = r104.intValue();
    L19:
        r106.setMargins(r107, r108, r109, r110);
        r100.setLayoutParams(r106);
        return;
    L18:
        r110 = r106.bottomMargin;
        goto L19
    L15:
        r109 = r106.rightMargin;
        goto L16
    L12:
        r108 = r106.topMargin;
        goto L13
    L9:
        r107 = r106.leftMargin;
        goto L10
    L21:
        return;
    L5:
        r106 = null;
        goto L6
    }

    public static final void setPaddingDefaultCur(View r100, Integer r101, Integer r102, Integer r103, Integer r104) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == null) goto L5;
        int r105 = r101.intValue();
    L6:
        if (r102 == null) goto L8;
        int r106 = r102.intValue();
    L9:
        if (r103 == null) goto L11;
        int r107 = r103.intValue();
    L12:
        if (r104 == null) goto L14;
        int r108 = r104.intValue();
    L15:
        r100.setPadding(r105, r106, r107, r108);
        return;
    L14:
        r108 = r100.getPaddingBottom();
        goto L15
    L11:
        r107 = r100.getPaddingRight();
        goto L12
    L8:
        r106 = r100.getPaddingTop();
        goto L9
    L5:
        r105 = r100.getPaddingLeft();
        goto L6
    }

    public static /* synthetic */ void setMargins$default(View r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = 0;
    L12:
        if ((r105 & 8) == 0) goto L14;
        r104 = 0;
    L14:
        setMargins(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ void setMarginsDefaultCur$default(View r100, Integer r101, Integer r102, Integer r103, Integer r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = null;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = null;
    L12:
        if ((r105 & 8) == 0) goto L14;
        r104 = null;
    L14:
        setMarginsDefaultCur(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ void setPaddingDefaultCur$default(View r100, Integer r101, Integer r102, Integer r103, Integer r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = null;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = null;
    L12:
        if ((r105 & 8) == 0) goto L14;
        r104 = null;
    L14:
        setPaddingDefaultCur(r100, r101, r102, r103, r104);
    }
}
