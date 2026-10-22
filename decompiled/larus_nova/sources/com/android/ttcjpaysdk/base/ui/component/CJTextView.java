package com.android.ttcjpaysdk.base.ui.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import com.android.ttcjpaysdk.base.theme.CJPayThemeUtils;
import com.android.ttcjpaysdk.base.ui.component.base.StdUIbaseDraw;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.bytedance.caijing.sdk.infra.base.api.alog.ALogService;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 72\u00020\u0001:\u000267B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020\u0007H\u0016J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%H\u0014J\u0012\u0010&\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0018\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0007H\u0014J\b\u0010-\u001a\u00020\u0010H\u0016J\u0010\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\nH\u0016J\u000e\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\nJ\u000e\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u000204J\u000e\u00102\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u0007R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u00068"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/CJTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxAlpha", "", "getMaxAlpha", "()F", "setMaxAlpha", "(F)V", "sForceLTR", "", "getSForceLTR", "()Z", "setSForceLTR", "(Z)V", "textColor", "getTextColor", "()Ljava/lang/Integer;", "setTextColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "applyStyles", "", "createAccessibilityNodeInfo", "Landroid/view/accessibility/AccessibilityNodeInfo;", "getLayoutDirection", "getTagName", "", "getTextDirection", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMonitorCrash", "text", "", "onVisibilityChanged", "changedView", "Landroid/view/View;", RemoteMessageConst.Notification.VISIBILITY, "performLongClick", "setAlpha", "alpha", "setAlphaMax", "alphaMax", "setTextSpec", "spec", "Lcom/android/ttcjpaysdk/base/ui/component/CJTextView$TextSpec;", "index", "TextSpec", "TextSpecManifest", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class CJTextView extends AppCompatTextView {
    public static final String TAG = "";
    public static final TextSpecManifest TextSpecManifest = null;
    private static final Lazy<TextSpec[]> textSpecEnums$delegate = null;
    private static final Integer[] textSpecs = null;
    private float maxAlpha;
    private boolean sForceLTR;
    private Integer textColor;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/CJTextView$TextSpec;", "", "(Ljava/lang/String;I)V", "getTextStyle", "", "H0", "H1", "H2", "H3", "H4", DiagnoseResult.DIAGNOSE_LEVEL_P1, DiagnoseResult.DIAGNOSE_LEVEL_P2, "P3", "T1", "T2", "H0S", "H1S", "H2S", "H3S", "H4S", "P1S", "P2S", "P3S", "T1S", "T2S", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum TextSpec extends Enum<TextSpec> {
        private static final /* synthetic */ TextSpec[] $VALUES = null;
        public static final TextSpec H0 = null;
        public static final TextSpec H0S = null;
        public static final TextSpec H1 = null;
        public static final TextSpec H1S = null;
        public static final TextSpec H2 = null;
        public static final TextSpec H2S = null;
        public static final TextSpec H3 = null;
        public static final TextSpec H3S = null;
        public static final TextSpec H4 = null;
        public static final TextSpec H4S = null;
        public static final TextSpec P1 = null;
        public static final TextSpec P1S = null;
        public static final TextSpec P2 = null;
        public static final TextSpec P2S = null;
        public static final TextSpec P3 = null;
        public static final TextSpec P3S = null;
        public static final TextSpec T1 = null;
        public static final TextSpec T1S = null;
        public static final TextSpec T2 = null;
        public static final TextSpec T2S = null;

        private static final /* synthetic */ TextSpec[] $values() {
            return new TextSpec[]{H0, H1, H2, H3, H4, P1, P2, P3, T1, T2, H0S, H1S, H2S, H3S, H4S, P1S, P2S, P3S, T1S, T2S};
        }

        public static TextSpec valueOf(String r100) {
            return (TextSpec) a.a(TextSpec.class, r100);
        }

        public static TextSpec[] values() {
            return (TextSpec[]) $VALUES.clone();
        }

        static {
            H0 = new TextSpec("H0", 0);
            H1 = new TextSpec("H1", 1);
            H2 = new TextSpec("H2", 2);
            H3 = new TextSpec("H3", 3);
            H4 = new TextSpec("H4", 4);
            P1 = new TextSpec(DiagnoseResult.DIAGNOSE_LEVEL_P1, 5);
            P2 = new TextSpec(DiagnoseResult.DIAGNOSE_LEVEL_P2, 6);
            P3 = new TextSpec("P3", 7);
            T1 = new TextSpec("T1", 8);
            T2 = new TextSpec("T2", 9);
            H0S = new TextSpec("H0S", 10);
            H1S = new TextSpec("H1S", 11);
            H2S = new TextSpec("H2S", 12);
            H3S = new TextSpec("H3S", 13);
            H4S = new TextSpec("H4S", 14);
            P1S = new TextSpec("P1S", 15);
            P2S = new TextSpec("P2S", 16);
            P3S = new TextSpec("P3S", 17);
            T1S = new TextSpec("T1S", 18);
            T2S = new TextSpec("T2S", 19);
            $VALUES = $values();
        }

        public final int getTextStyle() {
            return TextSpecManifest.access$getTextStyleForSpec(CJTextView.TextSpecManifest, ordinal());
        }

        private TextSpec(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/CJTextView$TextSpecManifest;", "", "()V", "TAG", "", "textSpecEnums", "", "Lcom/android/ttcjpaysdk/base/ui/component/CJTextView$TextSpec;", "getTextSpecEnums", "()[Lcom/android/ttcjpaysdk/base/ui/component/CJTextView$TextSpec;", "textSpecEnums$delegate", "Lkotlin/Lazy;", "textSpecs", "", "[Ljava/lang/Integer;", "getTextSpecFromIndex", "index", "getTextStyleForSpec", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TextSpecManifest {
        private TextSpecManifest() {
        }

        public /* synthetic */ TextSpecManifest(DefaultConstructorMarker r100) {
            this();
        }

        private final TextSpec[] getTextSpecEnums() {
            return (TextSpec[]) CJTextView.access$getTextSpecEnums$delegate$cp().getValue();
        }

        private final TextSpec getTextSpecFromIndex(int r100) {
            boolean r101 = false;
            if (r100 >= 0) goto L5;
        L7:
            if (r101 == true) goto L11;
            return null;
        L11:
            return getTextSpecEnums()[r100];
        L5:
            if (r100 >= getTextSpecEnums().length) goto L7;
            r101 = true;
            goto L7
        }

        private final int getTextStyleForSpec(int r100) {
            if (r100 >= 0) goto L5;
        L7:
            boolean r101 = false;
        L8:
            if (r101 == true) goto L10;
            return 0;
        L10:
            return CJTextView.access$getTextSpecs$cp()[r100].intValue();
        L5:
            if (r100 >= CJTextView.access$getTextSpecs$cp().length) goto L7;
            r101 = true;
            goto L8
        }

        public static final /* synthetic */ TextSpec access$getTextSpecFromIndex(TextSpecManifest r100, int r101) {
            return r100.getTextSpecFromIndex(r101);
        }

        public static final /* synthetic */ int access$getTextStyleForSpec(TextSpecManifest r100, int r101) {
            return r100.getTextStyleForSpec(r101);
        }
    }

    public CJTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public CJTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    @Override // android.view.View
    public int getLayoutDirection() {
        return 0;
    }

    public String getTagName() {
        return "CJTextView";
    }

    @Override // android.view.View
    public int getTextDirection() {
        return 3;
    }

    public void onMonitorCrash(CharSequence r100) {
    }

    static {
        TextSpecManifest = new TextSpecManifest(null);
        textSpecs = new Integer[]{Integer.valueOf(R.style.DuxTextView_Spec_H0), Integer.valueOf(R.style.DuxTextView_Spec_H1), Integer.valueOf(R.style.DuxTextView_Spec_H2), Integer.valueOf(R.style.DuxTextView_Spec_H3), Integer.valueOf(R.style.DuxTextView_Spec_H4), Integer.valueOf(R.style.DuxTextView_Spec_P1), Integer.valueOf(R.style.DuxTextView_Spec_P2), Integer.valueOf(R.style.DuxTextView_Spec_P3), Integer.valueOf(R.style.DuxTextView_Spec_T1), Integer.valueOf(R.style.DuxTextView_Spec_T2), Integer.valueOf(R.style.DuxTextView_Spec_H0S), Integer.valueOf(R.style.DuxTextView_Spec_H1S), Integer.valueOf(R.style.DuxTextView_Spec_H2S), Integer.valueOf(R.style.DuxTextView_Spec_H3S), Integer.valueOf(R.style.DuxTextView_Spec_H4S), Integer.valueOf(R.style.DuxTextView_Spec_P1S), Integer.valueOf(R.style.DuxTextView_Spec_P2S), Integer.valueOf(R.style.DuxTextView_Spec_P3S_CJ), Integer.valueOf(R.style.DuxTextView_Spec_T1S), Integer.valueOf(R.style.DuxTextView_Spec_T2S)};
        textSpecEnums$delegate = LazyKt.lazy(CJTextView$TextSpecManifest$textSpecEnums$2.INSTANCE);
    }

    @Override // android.view.View
    public AccessibilityNodeInfo createAccessibilityNodeInfo() {
        return super.createAccessibilityNodeInfo();
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJTextView#createAccessibilityNodeInfo", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJTextView#createAccessibilityNodeInfo", e);
        ve4.a.f554342a.getClass();
        ALogService r100 = (ALogService) ve4.a.a(ALogService.class);
        if (r100 == null) goto L12;
        r100.e("", "createAccessibilityNodeInfo Exception : " + e.getMessage());
        return null;
    L12:
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        return super.performLongClick();
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJTextView#performLongClick", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJTextView#performLongClick", e);
        onMonitorCrash(getText());
        return false;
    }

    public static final /* synthetic */ Lazy access$getTextSpecEnums$delegate$cp() {
        return textSpecEnums$delegate;
    }

    public static final /* synthetic */ Integer[] access$getTextSpecs$cp() {
        return textSpecs;
    }

    public final float getMaxAlpha() {
        return this.maxAlpha;
    }

    public final boolean getSForceLTR() {
        return this.sForceLTR;
    }

    public final Integer getTextColor() {
        return this.textColor;
    }

    private final void applyStyles(Context r100) {
        Integer r101 = this.textColor;
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L6:
        setTextColor(r102);
        return;
    L5:
        r102 = CJPayThemeUtils.getColor(r100, R.attr.cj_std_ui_component_textview_color);
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        StdUIbaseDraw.INSTANCE.draw(r100, getWidth(), getHeight(), getTagName());
    }

    @Override // android.view.View
    public void setAlpha(float r100) {
        float r101 = this.maxAlpha;
        if (r101 > 0.0f) goto L5;
    L8:
        super.setAlpha(r100);
        return;
    L5:
        if (r100 <= r101) goto L8;
        super.setAlpha(r101);
    }

    public final void setAlphaMax(float r100) {
        this.maxAlpha = r100;
        float r101 = getAlpha();
        float r102 = this.maxAlpha;
        if (r101 <= r102) goto L5;
        setAlpha(r102);
    L5:
        Objects.toString(getText());
    }

    public final void setMaxAlpha(float r100) {
        this.maxAlpha = r100;
    }

    public final void setSForceLTR(boolean r100) {
        this.sForceLTR = r100;
    }

    public final void setTextColor(Integer r100) {
        this.textColor = r100;
    }

    public final void setTextSpec(TextSpec r100) {
        Intrinsics.checkNotNullParameter(r100, "spec");
        TextViewCompat.setTextAppearance(this, TextSpecManifest.access$getTextStyleForSpec(TextSpecManifest, r100.ordinal()));
    }

    public final void setTextSpec(int r100) {
        TextSpec r101 = TextSpecManifest.access$getTextSpecFromIndex(TextSpecManifest, r100);
        if (r101 == null) goto L6;
        setTextSpec(r101);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);     // Catch: NullPointerException -> L5
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJTextView#onVisibilityChanged", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJTextView#onVisibilityChanged", e);
        ve4.a.f554342a.getClass();
        ALogService r102 = (ALogService) ve4.a.a(ALogService.class);
        if (r102 == null) goto L12;
        r102.e("", "onVisibilityChanged: " + e.getMessage());
        return;
    }

    public CJTextView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.maxAlpha = 1.0f;
        this.sForceLTR = true;
        if (r111 == null) goto L26;
        TypedArray r100 = r110.obtainStyledAttributes(r111, new int[]{R.attr.forceTextDirectionLTR, R.attr.textSpec}, r112, 0);
        int r101 = r100.getInt(1, -1);
        boolean r102 = r100.getBoolean(0, true);
        int r103 = CJPayThemeUtils.getColor(r110, R.attr.cj_std_ui_component_textview_color);
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{android.R.attr.textColor}, r112, 0);
        this.textColor = Integer.valueOf(r113.getColor(0, r103));     // Catch: Throwable -> L23
        r113.recycle();
        applyStyles(r110);
        this.sForceLTR = r102;
        r100.recycle();
        if (r101 == (-1)) goto L34;
        int r114 = TextSpecManifest.access$getTextStyleForSpec(TextSpecManifest, r101);
        TypedArray r115 = r110.obtainStyledAttributes(r114, new int[]{android.R.attr.textSize, android.R.attr.typeface, android.R.attr.textStyle, android.R.attr.textColor, android.R.attr.textColorHint, android.R.attr.textColorLink, android.R.attr.shadowColor, android.R.attr.shadowDx, android.R.attr.shadowDy, android.R.attr.shadowRadius, android.R.attr.fontFamily, android.R.attr.textFontWeight, R.attr.fontFamily, R.attr.fontVariationSettings, R.attr.textAllCaps, R.attr.textLocale});
        setTextSize(0, r115.getDimensionPixelSize(0, 0));     // Catch: Throwable -> L20
        r115.recycle();
        TypedArray r116 = r110.obtainStyledAttributes(r114, new int[]{android.R.attr.textAppearance, R.attr.autoSizeMaxTextSize, R.attr.autoSizeMinTextSize, R.attr.autoSizePresetSizes, R.attr.autoSizeStepGranularity, R.attr.autoSizeTextType, R.attr.drawableBottomCompat, R.attr.drawableEndCompat, R.attr.drawableLeftCompat, R.attr.drawableRightCompat, R.attr.drawableStartCompat, R.attr.drawableTint, R.attr.drawableTintMode, R.attr.drawableTopCompat, R.attr.firstBaselineToTopHeight, R.attr.fontFamily, R.attr.fontVariationSettings, R.attr.lastBaselineToBottomHeight, R.attr.lineHeight, R.attr.textAllCaps, R.attr.textLocale});
        setLineHeight(r116.getDimensionPixelSize(18, 0));     // Catch: Throwable -> L13 Exception -> L15
    L12:
        r116.recycle();
        return;
    L13:
        th = move-exception;
        r116.recycle();
        throw th;
    L15:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJTextView#getTagName", e);     // Catch: Throwable -> L13
        CJBasicCommonUtils.logCatch("CJCatch", "CJTextView#getTagName", e);     // Catch: Throwable -> L13
        e.printStackTrace();     // Catch: Throwable -> L13
    L20:
        th = move-exception;
        r115.recycle();
        throw th;
    L34:
        return;
    L23:
        th = move-exception;
        r113.recycle();
        throw th;
    }

    public /* synthetic */ CJTextView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = android.R.attr.textViewStyle;
    L8:
        this(r100, r101, r102);
    }
}
