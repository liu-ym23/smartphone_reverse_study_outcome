package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Paint;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/text/font/TypefaceCompatApi26;", "", "<init>", "()V", "threadLocalPaint", "Ljava/lang/ThreadLocal;", "Landroid/graphics/Paint;", "setFontVariationSettings", "Landroid/graphics/Typeface;", "typeface", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TypefaceCompatApi26 {
    public static final TypefaceCompatApi26 INSTANCE = null;
    private static ThreadLocal<Paint> threadLocalPaint;

    private TypefaceCompatApi26() {
    }

    static {
        INSTANCE = new TypefaceCompatApi26();
        threadLocalPaint = new ThreadLocal();
    }

    public final android.graphics.Typeface setFontVariationSettings(android.graphics.Typeface r100, FontVariation.Settings r101, Context r102) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r101.getSettings().isEmpty() == false) goto L8;
        return r100;
    L8:
        Paint r103 = threadLocalPaint.get();
        if (r103 != null) goto L11;
        r103 = new Paint();
        threadLocalPaint.set(r103);
    L11:
        r103.setFontVariationSettings(null);
        r103.setTypeface(r100);
        r103.setFontVariationSettings(PlatformFontVariationSettings_androidKt.toAndroidString(r101, r102));
        return r103.getTypeface();
    }
}
