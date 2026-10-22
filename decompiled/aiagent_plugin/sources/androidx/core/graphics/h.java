package androidx.core.graphics;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PaintCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<androidx.core.util.e<Rect, Rect>> f1214a = null;

    /* JADX INFO: compiled from: PaintCompat.java */
    static class a {
        static boolean a(Paint r0, String r1) {
            return r0.hasGlyph(r1);
        }
    }

    static {
        f1214a = new ThreadLocal();
    }

    public static boolean a(Paint r9, String r10) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        int r0 = r10.length();
        if (r0 == 1) goto L9;
    L11:
        float r4 = r9.measureText("\udfffd");
        float r5 = r9.measureText("m");
        float r6 = r9.measureText(r10);
        float r7 = 0.0f;
        if (r6 != 0.0f) goto L15;
        return false;
    L15:
        if (r10.codePointCount(0, r10.length()) <= 1) goto L26;
        if (r6 <= (r5 * 2.0f)) goto L19;
        return false;
    L19:
        int r8 = 0;
    L20:
        if (r8 >= r0) goto L23;
        int r11 = Character.charCount(r10.codePointAt(r8)) + r8;
        r7 = r7 + r9.measureText(r10, r8, r11);
        r8 = r11;
        goto L20
    L23:
        if (r6 < r7) goto L26;
        return false;
    L26:
        if (r6 == r4) goto L28;
        return true;
    L28:
        androidx.core.util.e<Rect, Rect> r12 = a();
        r9.getTextBounds("\udfffd", 0, 2, (Rect) ZeusTransformUtils.preCheckCast(r12.f1371a, Rect.class, "com.obric.aiagent.plugin"));
        r9.getTextBounds(r10, 0, r0, (Rect) ZeusTransformUtils.preCheckCast(r12.f1372b, Rect.class, "com.obric.aiagent.plugin"));
        return !((Rect) ZeusTransformUtils.preCheckCast(r12.f1371a, Rect.class, "com.obric.aiagent.plugin")).equals(r12.f1372b);
    L9:
        if (Character.isWhitespace(r10.charAt(0)) == false) goto L11;
        return true;
    L5:
        return a.a(r9, r10);
    }

    private static androidx.core.util.e<Rect, Rect> a() {
        ThreadLocal<androidx.core.util.e<Rect, Rect>> r0 = f1214a;
        androidx.core.util.e<Rect, Rect> r1 = (androidx.core.util.e) ZeusTransformUtils.preCheckCast(r0.get(), androidx.core.util.e.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        androidx.core.util.e<Rect, Rect> r2 = new androidx.core.util.e(new Rect(), new Rect());
        r0.set(r2);
        return r2;
    L5:
        ((Rect) ZeusTransformUtils.preCheckCast(r1.f1371a, Rect.class, "com.obric.aiagent.plugin")).setEmpty();
        ((Rect) ZeusTransformUtils.preCheckCast(r1.f1372b, Rect.class, "com.obric.aiagent.plugin")).setEmpty();
        return r1;
    }
}
