package androidx.compose.ui.text.android;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JØ\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0003\u0010\u0014\u001a\u00020\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0003\u0010\u0017\u001a\u00020\r2\b\b\u0003\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\r2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$J\u0016\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Landroidx/compose/ui/text/android/StaticLayoutFactory;", "", "<init>", "()V", "delegate", "Landroidx/compose/ui/text/android/StaticLayoutFactoryImpl;", "create", "Landroid/text/StaticLayout;", "text", "", "paint", "Landroid/text/TextPaint;", "width", "", "start", "end", "textDir", "Landroid/text/TextDirectionHeuristic;", "alignment", "Landroid/text/Layout$Alignment;", "maxLines", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "ellipsizedWidth", "lineSpacingMultiplier", "", "lineSpacingExtra", "justificationMode", "includePadding", "", "useFallbackLineSpacing", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "hyphenationFrequency", "leftIndents", "", "rightIndents", "isFallbackLineSpacingEnabled", "layout", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StaticLayoutFactory {
    public static final int $stable = 0;
    public static final StaticLayoutFactory INSTANCE = null;
    private static final StaticLayoutFactoryImpl delegate = null;

    private StaticLayoutFactory() {
    }

    static {
        INSTANCE = new StaticLayoutFactory();
        if (Build.VERSION.SDK_INT < 23) goto L5;
        StaticLayoutFactoryImpl r100 = new StaticLayoutFactory23();
    L6:
        delegate = r100;
        $stable = 8;
        return;
    L5:
        r100 = new StaticLayoutFactoryDefault();
        goto L6
    }

    public final boolean isFallbackLineSpacingEnabled(StaticLayout r100, boolean r101) {
        return delegate.isFallbackLineSpacingEnabled(r100, r101);
    }

    public final StaticLayout create(CharSequence r210, TextPaint r211, int r212, int r213, int r214, TextDirectionHeuristic r310, Layout.Alignment r311, int r312, TextUtils.TruncateAt r313, int r314, float r315, float r316, int r317, boolean r318, boolean r319, int r410, int r411, int r412, int r413, int[] r414, int[] r415) {
        return delegate.create(new StaticLayoutParams(r210, r213, r214, r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415));
    }

    public static /* synthetic */ StaticLayout create$default(StaticLayoutFactory r210, CharSequence r211, TextPaint r212, int r213, int r214, int r310, TextDirectionHeuristic r311, Layout.Alignment r312, int r313, TextUtils.TruncateAt r314, int r315, float r316, float r317, int r318, boolean r319, boolean r410, int r411, int r412, int r413, int r414, int[] r415, int[] r416, int r417, Object r418) {
        if ((r417 & 8) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r417 & 16) == 0) goto L9;
        int r101 = r211.length();
    L11:
        if ((r417 & 32) == 0) goto L13;
        TextDirectionHeuristic r102 = LayoutCompat.INSTANCE.getDEFAULT_TEXT_DIRECTION_HEURISTIC$ui_text();
    L15:
        if ((r417 & 64) == 0) goto L17;
        Layout.Alignment r110 = LayoutCompat.INSTANCE.getDEFAULT_LAYOUT_ALIGNMENT$ui_text();
    L19:
        if ((r417 & 128) == 0) goto L21;
        int r111 = Integer.MAX_VALUE;
    L23:
        if ((r417 & 256) == 0) goto L25;
        TextUtils.TruncateAt r112 = null;
    L27:
        if ((r417 & 512) == 0) goto L29;
        int r113 = r213;
    L31:
        if ((r417 & 1024) == 0) goto L33;
        float r114 = 1.0f;
    L35:
        if ((r417 & 2048) == 0) goto L37;
        float r115 = 0.0f;
    L39:
        if ((r417 & 4096) == 0) goto L41;
        int r116 = 0;
    L43:
        if ((r417 & 8192) == 0) goto L45;
        boolean r117 = false;
    L47:
        if ((r417 & 16384) == 0) goto L49;
        boolean r118 = true;
    L51:
        if ((32768 & r417) == 0) goto L53;
        int r119 = 0;
    L55:
        if ((65536 & r417) == 0) goto L57;
        int r215 = 0;
    L59:
        if ((131072 & r417) == 0) goto L61;
        int r216 = 0;
    L63:
        if ((262144 & r417) == 0) goto L65;
        int r217 = 0;
    L67:
        if ((524288 & r417) == 0) goto L69;
        int[] r218 = null;
    L71:
        if ((r417 & 1048576) == 0) goto L73;
        int[] r219 = null;
    L75:
        return r210.create(r211, r212, r213, r100, r101, r102, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r215, r216, r217, r218, r219);
    L73:
        r219 = r416;
        goto L75
    L69:
        r218 = r415;
        goto L71
    L65:
        r217 = r414;
        goto L67
    L61:
        r216 = r413;
        goto L63
    L57:
        r215 = r412;
        goto L59
    L53:
        r119 = r411;
        goto L55
    L49:
        r118 = r410;
        goto L51
    L45:
        r117 = r319;
        goto L47
    L41:
        r116 = r318;
        goto L43
    L37:
        r115 = r317;
        goto L39
    L33:
        r114 = r316;
        goto L35
    L29:
        r113 = r315;
        goto L31
    L25:
        r112 = r314;
        goto L27
    L21:
        r111 = r313;
        goto L23
    L17:
        r110 = r312;
        goto L19
    L13:
        r102 = r311;
        goto L15
    L9:
        r101 = r310;
        goto L11
    L5:
        r100 = r214;
        goto L7
    }
}
