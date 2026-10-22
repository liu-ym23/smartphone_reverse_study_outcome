package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007Jf\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u000fH\u0007J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\rH\u0007¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/text/android/BoringLayoutFactory33;", "", "<init>", "()V", "isBoring", "Landroid/text/BoringLayout$Metrics;", "text", "", "paint", "Landroid/text/TextPaint;", "textDir", "Landroid/text/TextDirectionHeuristic;", "create", "Landroid/text/BoringLayout;", "width", "", "alignment", "Landroid/text/Layout$Alignment;", "lineSpacingMultiplier", "", "lineSpacingExtra", "metrics", "includePadding", "", "useFallbackLineSpacing", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "ellipsizedWidth", "isFallbackLineSpacingEnabled", "layout", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class BoringLayoutFactory33 {
    public static final BoringLayoutFactory33 INSTANCE = null;

    static {
        INSTANCE = new BoringLayoutFactory33();
    }

    private BoringLayoutFactory33() {
    }

    @JvmStatic
    public static final boolean isFallbackLineSpacingEnabled(BoringLayout r100) {
        return r100.isFallbackLineSpacingEnabled();
    }

    @JvmStatic
    public static final BoringLayout.Metrics isBoring(CharSequence r100, TextPaint r101, TextDirectionHeuristic r102) {
        return BoringLayout.isBoring(r100, r101, r102, true, null);
    }

    @JvmStatic
    public static final BoringLayout create(CharSequence r110, TextPaint r111, int r112, Layout.Alignment r113, float r114, float r115, BoringLayout.Metrics r116, boolean r210, boolean r211, TextUtils.TruncateAt r212, int r213) {
        return new BoringLayout(r110, r111, r112, r113, r114, r115, r116, r210, r212, r213, r211);
    }

    public static /* synthetic */ BoringLayout create$default(CharSequence r110, TextPaint r111, int r112, Layout.Alignment r113, float r114, float r115, BoringLayout.Metrics r116, boolean r210, boolean r211, TextUtils.TruncateAt r212, int r213, int r214, Object r215) {
        if ((r214 & 512) == 0) goto L5;
        TextUtils.TruncateAt r117 = null;
    L7:
        if ((r214 & 1024) == 0) goto L9;
        int r118 = r112;
    L11:
        return create(r110, r111, r112, r113, r114, r115, r116, r210, r211, r117, r118);
    L9:
        r118 = r213;
        goto L11
    L5:
        r117 = r212;
        goto L7
    }
}
