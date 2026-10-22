package com.android.ttcjpaysdk.base.ui.Utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.imageloader.ImageLoader;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayColorHelper;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/Utils/PaymentUIUtils;", "", "()V", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PaymentUIUtils {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J4\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004J,\u0010\u000f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016J0\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0019\u001a\u00020\rJ8\u0010\u001a\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004J.\u0010\u001c\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\"\u0010\u001d\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\bJ-\u0010\u001f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010!J:\u0010\"\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u0016J;\u0010'\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010(¨\u0006)"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/Utils/PaymentUIUtils$Companion;", "", "()V", "getCirclePlaceholderImage", "Landroid/graphics/drawable/Drawable;", "loadImage", "", "url", "", "view", "Landroid/widget/ImageView;", "maskView", "isEnable", "", "placeholderImage", "setHollowLabel", "Landroid/widget/TextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "maxCorner", "", "height", "", "setIconImage", "iconView", "isNeedRound", "setIconUrl", "iconMaskView", "setIconUrlWithAlpha", "setMarkView", "mark", "updateFillLabel", "colorBg", "(Landroid/widget/TextView;Landroid/content/Context;Ljava/lang/Integer;)V", "updateLabel", "textColor", "strokeColor", "bgColor", "corner", "updateLabelStyle", "(Landroid/widget/TextView;Landroid/content/Context;ZILjava/lang/Integer;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final Drawable getCirclePlaceholderImage() {
            GradientDrawable r100 = new GradientDrawable();
            r100.setShape(1);
            r100.setColor(CJPayColorHelper.safeParseColor$default("#E3E3E5", 0, 2, null));
            return r100;
        }

        private final void updateFillLabel(TextView r110, Context r111, Integer r112) {
            if (r110 == null) goto L30;
            int r100 = CJPayBasicUtils.dipToPX(r111, 2.0f);
            Drawable r101 = r110.getBackground();
            if ((r101 instanceof GradientDrawable) == false) goto L6;
            GradientDrawable r102 = (GradientDrawable) r101;
        L7:
            r110.setGravity(16);
            int r103 = CJPayBasicUtils.dipToPX(r111, 4.0f);
            int r104 = CJPayBasicUtils.dipToPX(r111, 1.5f);
            r110.setPadding(r103, r104, r103, r104);
            if (r102 != null) goto L10;
            return;
        L10:
            if (r112 != null) goto L12;
        L21:
            int r113 = CJPayColorHelper.safeParseColor$default("#ffffff", 0, 2, null);
        L22:
            r102.setColor(r113);
            r110.setTextColor(CJPayColorHelper.safeParseColor$default(CJPayColorConstants.CJ_PAY_RED, 0, 2, null));     // Catch: Exception -> L25
            r102.setStroke(CJPayBasicUtils.dipToPX(r111, 0.5f), CJPayColorHelper.safeParseColor$default(CJPayColorConstants.CJ_PAY_STROKE_RED, 0, 2, null));     // Catch: Exception -> L25
            r102.setCornerRadius(r100);     // Catch: Exception -> L25
            return;
        L25:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("PaymentUIUtils#updateFillLabel", e);
            CJBasicCommonUtils.logCatch("CJCatch", "PaymentUIUtils#updateFillLabel", e);
            r110.setTextColor(CJPayColorHelper.safeParseColor$default(CJPayColorConstants.CJ_PAY_RED, 0, 2, null));
            r102.setStroke(CJPayBasicUtils.dipToPX(r111, 0.5f), CJPayColorHelper.safeParseColor$default(CJPayColorConstants.CJ_PAY_STROKE_RED, 0, 2, null));
            r102.setCornerRadius(r100);
            return;
        L12:
            if (r112.intValue() <= (-1)) goto L14;
            boolean r105 = true;
        L16:
            if (Boolean.valueOf(r105).booleanValue() == true) goto L19;
            r112 = null;
        L19:
            if (r112 == null) goto L21;
            r113 = r112.intValue();
            goto L22
        L14:
            r105 = false;
            goto L16
        L6:
            r102 = null;
            goto L7
        }

        public final void setMarkView(Context r100, TextView r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "view");
            if (TextUtils.isEmpty(r102) == true) goto L5;
            r101.setMaxWidth(CJPayBasicExtensionKt.dip2px(120.0f, r100));
            r101.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            r101.setSingleLine(true);
            r101.setVisibility(0);
            r101.setText(r102);
            return;
        L5:
            r101.setVisibility(8);
        }

        public final void setHollowLabel(TextView r100, Context r110, int r111, float r112) {
            if (r100 == null) goto L19;
            if (r110 == null) goto L21;
            int r101 = CJPayBasicUtils.dipToPX(r110, 2.0f);
            Drawable r102 = r100.getBackground();
            if ((r102 instanceof GradientDrawable) == false) goto L8;
            GradientDrawable r103 = (GradientDrawable) r102;
        L9:
            ViewGroup.LayoutParams r104 = r100.getLayoutParams();
            int r105 = CJPayBasicUtils.dipToPX(r110, 4.0f);
            r100.setPadding(r105, 0, r105, 0);
            r100.setGravity(16);
            r104.height = CJPayBasicUtils.dipToPX(r110, r112);
            if (r103 == null) goto L20;
            r103.setColor(CJPayColorHelper.safeParseColor$default("#ffffff", 0, 2, null));
            r100.setTextColor(CJPayColorHelper.safeParseColor$default(CJPayColorConstants.CJ_PAY_RED, 0, 2, null));     // Catch: Exception -> L14
            r103.setStroke(CJPayBasicUtils.dipToPX(r110, 0.5f), CJPayColorHelper.safeParseColor$default(CJPayColorConstants.CJ_PAY_RED, 0, 2, null));     // Catch: Exception -> L14
            r103.setCornerRadius(r101);     // Catch: Exception -> L14
            return;
        L14:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("PaymentUIUtils#setHollowLabel", e);
            CJBasicCommonUtils.logCatch("CJCatch", "PaymentUIUtils#setHollowLabel", e);
            r100.setTextColor(CJPayColorHelper.safeParseColor$default(CJPayColorConstants.CJ_PAY_RED, 0, 2, null));
            r103.setStroke(CJPayBasicUtils.dipToPX(r110, 0.5f), CJPayColorHelper.safeParseColor$default(CJPayColorConstants.CJ_PAY_RED, 0, 2, null));
            r103.setCornerRadius(r101);
            return;
        L20:
            return;
        L8:
            r103 = null;
            goto L9
        L21:
            return;
        }

        public final void setIconImage(final ImageView r100, String r101, final Drawable r102, final boolean r103) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r102 == null) goto L6;
            r100.setVisibility(0);
            r100.setImageDrawable(r102);
        L6:
            ImageLoader.Companion.getInstance().loadImage(r101, new PaymentUIUtils$Companion$setIconImage$1(r103, r100, r102));
        }

        public final void setIconUrlWithAlpha(final ImageView r100, final String r101, final boolean r102, final Drawable r103) {
            if (r100 != null) goto L5;
            return;
        L5:
            if (TextUtils.isEmpty(r101) == true) goto L14;
            r100.setTag(r101);
            if (r103 == null) goto L9;
            r100.setImageDrawable(r103);
            r100.setVisibility(0);
        L10:
            if (r102 == false) goto L12;
            float r104 = 1.0f;
        L13:
            r100.setAlpha(r104);
            ImageLoader.Companion.getInstance().loadImage(r101, new PaymentUIUtils$Companion$setIconUrlWithAlpha$1(r101, r100, r102, r103));
            return;
        L12:
            r104 = 0.5f;
            goto L13
        L9:
            r100.setImageResource(R.drawable.cj_pay_bg_payment_icon_unable);
            goto L10
        L14:
            r100.setTag(null);
            r100.setImageBitmap(null);
            r100.setVisibility(8);
        }

        public final void loadImage(final String r100, final ImageView r110, final ImageView r111, final boolean r112, final Drawable r113) {
            Intrinsics.checkNotNullParameter(r110, "view");
            Intrinsics.checkNotNullParameter(r111, "maskView");
            r110.setImageBitmap(null);
            if (r113 == null) goto L5;
            r110.setImageDrawable(r113);
            r110.setVisibility(0);
        L6:
            ImageLoader.Companion.getInstance().loadImage(r100, new PaymentUIUtils$Companion$loadImage$1(r100, r110, r111, r112, r113));
            return;
        L5:
            r110.setImageResource(R.drawable.cj_pay_bg_payment_icon_unable);
            goto L6
        }

        public final void setIconUrl(ImageView r100, ImageView r101, String r102, boolean r110, Drawable r111) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r101 != null) goto L7;
            return;
        L7:
            if (TextUtils.isEmpty(r102) == true) goto L9;
            r100.setTag(r102);
            r101.setTag(r102);
            loadImage(r102, r100, r101, r110, r111);
            return;
        L9:
            r100.setTag(null);
            r101.setTag(null);
            r100.setImageBitmap(null);
            r101.setVisibility(8);
        }

        public final void updateLabelStyle(TextView r100, Context r101, boolean r110, int r111, Integer r112) {
            if (r110 == false) goto L4;
            updateFillLabel(r100, r101, r112);
            return;
        L4:
            updateLabel(r100, r101, CJPayColorConstants.CJ_PAY_GRAY, "#57c8cad0", "#57c8cad0", 2.0f);
        }

        public static /* synthetic */ void updateFillLabel$default(Companion r100, TextView r101, Context r102, Integer r103, int r104, Object r105) {
            if ((r104 & 4) == 0) goto L5;
            r103 = null;
        L5:
            r100.updateFillLabel(r101, r102, r103);
        }

        public final void updateLabel(final TextView r100, Context r101, String r102, String r103, String r104, float r105) {
            Intrinsics.checkNotNullParameter(r102, "textColor");
            Intrinsics.checkNotNullParameter(r103, "strokeColor");
            Intrinsics.checkNotNullParameter(r104, "bgColor");
            if (r100 == null) goto L14;
            if (r101 == null) goto L16;
            Drawable r106 = r100.getBackground();
            if ((r106 instanceof GradientDrawable) == false) goto L9;
            GradientDrawable r107 = (GradientDrawable) r106;
        L10:
            CJPayColorHelper.safeParseColor$default(r102, new PaymentUIUtils$Companion$updateLabel$1(r100), null, 4, null);
            if (r107 == null) goto L15;
            r107.setStroke(CJPayBasicUtils.dipToPX(r101, 0.5f), CJPayColorHelper.safeParseColor$default(r103, 0, 2, null));
            r107.setColor(CJPayColorHelper.safeParseColor$default(r104, 0, 2, null));
            r107.setCornerRadius(CJPayBasicUtils.dipToPX(r101, r105));
            return;
        L15:
            return;
        L9:
            r107 = null;
            goto L10
        L16:
            return;
        }

        public static /* synthetic */ void setHollowLabel$default(Companion r100, TextView r101, Context r102, int r103, float r104, int r105, Object r106) {
            if ((r105 & 8) == 0) goto L5;
            r104 = 16.0f;
        L5:
            r100.setHollowLabel(r101, r102, r103, r104);
        }

        public static /* synthetic */ void setIconImage$default(Companion r100, ImageView r101, String r102, Drawable r103, boolean r104, int r105, Object r106) {
            if ((r105 & 4) == 0) goto L6;
            r103 = r100.getCirclePlaceholderImage();
        L6:
            if ((r105 & 8) == 0) goto L8;
            r104 = false;
        L8:
            r100.setIconImage(r101, r102, r103, r104);
        }

        public static /* synthetic */ void setIconUrlWithAlpha$default(Companion r100, ImageView r101, String r102, boolean r103, Drawable r104, int r105, Object r106) {
            if ((r105 & 8) == 0) goto L5;
            r104 = null;
        L5:
            r100.setIconUrlWithAlpha(r101, r102, r103, r104);
        }

        public static /* synthetic */ void loadImage$default(Companion r100, String r101, ImageView r102, ImageView r103, boolean r110, Drawable r111, int r112, Object r113) {
            if ((r112 & 16) == 0) goto L5;
            r111 = null;
        L5:
            r100.loadImage(r101, r102, r103, r110, r111);
        }

        public static /* synthetic */ void setIconUrl$default(Companion r100, ImageView r101, ImageView r102, String r103, boolean r110, Drawable r111, int r112, Object r113) {
            if ((r112 & 16) == 0) goto L5;
            r111 = null;
        L5:
            r100.setIconUrl(r101, r102, r103, r110, r111);
        }

        public static /* synthetic */ void updateLabelStyle$default(Companion r100, TextView r101, Context r102, boolean r103, int r110, Integer r111, int r112, Object r113) {
            if ((r112 & 16) == 0) goto L5;
            r111 = null;
        L5:
            r100.updateLabelStyle(r101, r102, r103, r110, r111);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PaymentUIUtils() {
    }
}
