package com.android.ttcjpaysdk.facelive.view.panel;

import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.facelive.view.CJPayFaceGuideActivity;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u00011B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0005H&J\b\u0010\u0016\u001a\u00020\u0005H&J\b\u0010\u0017\u001a\u00020\u0005H\u0004J*\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0004J\b\u0010\u001d\u001a\u00020\u001eH&J\b\u0010\u001f\u001a\u00020 H&J\b\u0010!\u001a\u00020\"H&J\b\u0010#\u001a\u00020\"H\u0004J\u0010\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020&H&J,\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\"2\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010*2\b\b\u0002\u0010+\u001a\u00020\"H&J\b\u0010,\u001a\u00020 H&J$\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020\"2\b\b\u0002\u0010/\u001a\u00020\"2\b\b\u0002\u00100\u001a\u00020\"H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u00062"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/view/panel/CJPayFaceBasePanel;", "", "ctx", "Lcom/android/ttcjpaysdk/facelive/view/CJPayFaceGuideActivity;", "themeMode", "", "navigationBarHeight", "(Lcom/android/ttcjpaysdk/facelive/view/CJPayFaceGuideActivity;II)V", "getCtx", "()Lcom/android/ttcjpaysdk/facelive/view/CJPayFaceGuideActivity;", "getNavigationBarHeight", "()I", "getThemeMode", "createStaticLayout", "Landroid/text/Layout;", "text", "Landroid/text/SpannableString;", "textPaint", "Landroid/text/TextPaint;", "maxWidth", "maxLine", "getAnimViewHeight", "getPanelHeightPercentInt", "getScreenRealHeight", "getTextHeight", BaseSwitches.V, "Landroid/widget/TextView;", "str", "", "getType", "Lcom/android/ttcjpaysdk/facelive/view/panel/CJPayFaceBasePanel$PanelType;", "init", "", "isAdapter9", "", "isDarkTheme", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "release", "hasAnim", "finishTask", "Lkotlin/Function0;", "isFinishForException", "resume", "showGuide", "isShow", "layerTitleVisible", "agreementVisible", "PanelType", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CJPayFaceBasePanel {
    private final CJPayFaceGuideActivity ctx;
    private final int navigationBarHeight;
    private final int themeMode;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/view/panel/CJPayFaceBasePanel$PanelType;", "", "Ljava/io/Serializable;", "(Ljava/lang/String;I)V", "FACE_GUIDE_FULL", "FACE_TRANSLUCENT", "FACE_RESULT_FAIL_MATCH_NOT", "FACE_RESULT_FAIL_ACCOUNT_PROTECT", "FACE_RESULT_FAIL_TIMEOUT", "FACE_RESULT_FAIL_MONTHLY_FREQUENCY_CONTROL", "FACE_RESULT_FAIL_EXTRA", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum PanelType extends Enum<PanelType> implements Serializable {
        private static final /* synthetic */ PanelType[] $VALUES = null;
        public static final PanelType FACE_GUIDE_FULL = null;
        public static final PanelType FACE_RESULT_FAIL_ACCOUNT_PROTECT = null;
        public static final PanelType FACE_RESULT_FAIL_EXTRA = null;
        public static final PanelType FACE_RESULT_FAIL_MATCH_NOT = null;
        public static final PanelType FACE_RESULT_FAIL_MONTHLY_FREQUENCY_CONTROL = null;
        public static final PanelType FACE_RESULT_FAIL_TIMEOUT = null;
        public static final PanelType FACE_TRANSLUCENT = null;

        private static final /* synthetic */ PanelType[] $values() {
            return new PanelType[]{FACE_GUIDE_FULL, FACE_TRANSLUCENT, FACE_RESULT_FAIL_MATCH_NOT, FACE_RESULT_FAIL_ACCOUNT_PROTECT, FACE_RESULT_FAIL_TIMEOUT, FACE_RESULT_FAIL_MONTHLY_FREQUENCY_CONTROL, FACE_RESULT_FAIL_EXTRA};
        }

        public static PanelType valueOf(String r100) {
            return (PanelType) a.a(PanelType.class, r100);
        }

        public static PanelType[] values() {
            return (PanelType[]) $VALUES.clone();
        }

        static {
            FACE_GUIDE_FULL = new PanelType("FACE_GUIDE_FULL", 0);
            FACE_TRANSLUCENT = new PanelType("FACE_TRANSLUCENT", 1);
            FACE_RESULT_FAIL_MATCH_NOT = new PanelType("FACE_RESULT_FAIL_MATCH_NOT", 2);
            FACE_RESULT_FAIL_ACCOUNT_PROTECT = new PanelType("FACE_RESULT_FAIL_ACCOUNT_PROTECT", 3);
            FACE_RESULT_FAIL_TIMEOUT = new PanelType("FACE_RESULT_FAIL_TIMEOUT", 4);
            FACE_RESULT_FAIL_MONTHLY_FREQUENCY_CONTROL = new PanelType("FACE_RESULT_FAIL_MONTHLY_FREQUENCY_CONTROL", 5);
            FACE_RESULT_FAIL_EXTRA = new PanelType("FACE_RESULT_FAIL_EXTRA", 6);
            $VALUES = $values();
        }

        private PanelType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public abstract int getAnimViewHeight();

    public abstract int getPanelHeightPercentInt();

    public abstract PanelType getType();

    public abstract void init();

    public abstract boolean isAdapter9();

    public abstract void onConfigurationChanged(Configuration r100);

    public abstract void release(boolean r100, Function0<Unit> r101, boolean r102);

    public abstract void resume();

    public abstract void showGuide(boolean r100, boolean r101, boolean r102);

    public final int getScreenRealHeight() {
        Object r100 = this.ctx.getSystemService(LiveEndPageData.TAG_WINDOW);
        if ((r100 instanceof WindowManager) == false) goto L5;
        WindowManager r101 = (WindowManager) r100;
    L6:
        if (r101 == null) goto L10;
        Display r102 = r101.getDefaultDisplay();
        Point r103 = new Point();
        r102.getRealSize(r103);
        return r103.y;
    L10:
        return CJPayBasicUtils.getScreenHeight(this.ctx) + this.navigationBarHeight;
    L5:
        r101 = null;
        goto L6
    }

    public final boolean isDarkTheme() {
        if (this.themeMode == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final CJPayFaceGuideActivity getCtx() {
        return this.ctx;
    }

    public final int getNavigationBarHeight() {
        return this.navigationBarHeight;
    }

    public final int getThemeMode() {
        return this.themeMode;
    }

    public CJPayFaceBasePanel(CJPayFaceGuideActivity r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this.ctx = r100;
        this.themeMode = r101;
        this.navigationBarHeight = r102;
    }

    private final Layout createStaticLayout(SpannableString r100, TextPaint r110, int r111, int r112) {
        if (Build.VERSION.SDK_INT <= 23) goto L6;
        return StaticLayout.Builder.obtain(r100, 0, r100.length(), r110, r111).setAlignment(Layout.Alignment.ALIGN_CENTER).setTextDirection(TextDirectionHeuristics.FIRSTSTRONG_LTR).setLineSpacing(0.0f, 0.0f).setIncludePad(false).setMaxLines(r112).setEllipsize(TextUtils.TruncateAt.END).setEllipsizedWidth(r111).build();
    L6:
        return new StaticLayout(r100, r110, r111, Layout.Alignment.ALIGN_CENTER, 0.0f, 0.0f, false);
    }

    public final int getTextHeight(TextView r100, String r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "str");
        boolean r104 = true;
        if ((!StringsKt.isBlank(r101)) == false) goto L7;
        if (r100 == null) goto L7;
        if (r102 <= 0) goto L7;
    L8:
        if (r104 == false) goto L10;
        String r105 = r101;
    L11:
        if (r105 == null) goto L14;
        SpannableString r106 = new SpannableString(r101);
        Intrinsics.checkNotNull(r100);
        Layout r107 = createStaticLayout(r106, r100.getPaint(), r102, r103);
        return r107.getHeight() * r107.getLineCount();
    L14:
        return 0;
    L10:
        r105 = null;
    L7:
        r104 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void release$default(CJPayFaceBasePanel r100, boolean r101, Function0 r102, boolean r103, int r104, Object r105) {
        if (r105 != null) goto L12;
        if ((r104 & 2) == 0) goto L7;
        r102 = null;
    L7:
        if ((r104 & 4) == 0) goto L9;
        r103 = true;
    L9:
        r100.release(r101, r102, r103);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: release");
    }

    public static /* synthetic */ void showGuide$default(CJPayFaceBasePanel r100, boolean r101, boolean r102, boolean r103, int r104, Object r105) {
        if (r105 != null) goto L12;
        if ((r104 & 2) == 0) goto L7;
        r102 = false;
    L7:
        if ((r104 & 4) == 0) goto L9;
        r103 = true;
    L9:
        r100.showGuide(r101, r102, r103);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showGuide");
    }
}
