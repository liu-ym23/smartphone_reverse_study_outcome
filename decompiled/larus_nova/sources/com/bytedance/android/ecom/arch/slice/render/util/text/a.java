package com.bytedance.android.ecom.arch.slice.render.util.text;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.text.TextDirectionHeuristicCompat;
import com.bytedance.android.ecom.arch.slice.q;
import java.lang.reflect.Field;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f50761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Field f50762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0865a f50763c = null;

    /* JADX INFO: renamed from: com.bytedance.android.ecom.arch.slice.render.util.text.a$a, reason: collision with other inner class name */
    public static final class C0865a {
        public C0865a() {
        }

        @JvmStatic
        public static StaticLayout a(CharSequence r110, int r111, TextPaint r112, int r113, Layout.Alignment r114, TextUtils.TruncateAt r115, int r116, int r210, TextDirectionHeuristicCompat r211) {
            return q.a(r110, r111, r112, r113, r114, r115, r116, r210, r211);
        L6:
            return new StaticLayout(r110, 0, r111, r112, r113, r114, 1.0f, 0.0f, false, r115, r116);
        }

        @JvmStatic
        public static StaticLayout b(CharSequence r110, int r111, TextPaint r112, int r113, Layout.Alignment r210, TextUtils.TruncateAt r211, int r212, int r213, TextDirectionHeuristicCompat r214) {
            int r100 = Build.VERSION.SDK_INT;
            if (r100 < 23) goto L12;
            StaticLayout.Builder r101 = StaticLayout.Builder.obtain(r110, 0, r111, r112, r113).setAlignment(r210).setLineSpacing(0.0f, 1.0f).setIncludePad(false).setEllipsize(r211).setEllipsizedWidth(r212).setMaxLines(r213).setTextDirection(q.b(r214)).setBreakStrategy(0).setHyphenationFrequency(0).setIndents(null, null);
            if (r100 < 26) goto L8;
            r101.setJustificationMode(0);
        L8:
            if (r100 < 28) goto L11;
            r101.setUseLineSpacingFromFallbacks(false);
        L11:
            return r101.build();
        L12:
            int r102 = r111;
            StaticLayout r103 = a(r110, r111, r112, r113, r210, r211, r212, r213, r214);
            if (r213 <= 0) goto L30;
        L15:
            if (r103.getLineCount() <= r213) goto L30;
            int r104 = r103.getLineStart(r213);
            if (r104 >= r102) goto L30;
            int r105 = r104;
        L20:
            if (r105 <= 0) goto L24;
            int r106 = r105 - 1;
            if (Character.isSpace(r110.charAt(r106)) == false) goto L24;
            r105 = r106;
        L24:
            int r114 = r105;
            r103 = a(r110, r105, r112, r113, r210, r211, r212, r213, r214);
            if (r103.getLineCount() < r213) goto L29;
            if (r103.getEllipsisCount(r213 - 1) != 0) goto L29;
            String r107 = r110.subSequence(0, r114).toString() + " …";
            r103 = a(r107, r107.length(), r112, r113, r210, r211, r212, r213, r214);
        L29:
            r102 = r114;
        L30:
            int r108 = r103.getLineStart(0);
            int r109 = r103.getLineCount();
            int r115 = 0;
        L31:
            boolean r116 = true;
            if (r115 >= r109) goto L51;
            int r117 = r103.getLineEnd(r115);
            if (r117 < r108) goto L54;
            r115 = r115 + 1;
            r108 = r117;
            goto L31
        L54:
            Field r118 = a.f50761a;     // Catch: Exception -> L49
            if (r118 != null) goto L38;
            r118 = StaticLayout.class.getDeclaredField("mLines");     // Catch: Exception -> L49
            a.f50761a = r118;     // Catch: Exception -> L49
        L38:
            r118.setAccessible(true);     // Catch: Exception -> L49
            Field r119 = a.f50762b;     // Catch: Exception -> L49
            if (r119 != null) goto L41;
            r119 = StaticLayout.class.getDeclaredField("mColumns");     // Catch: Exception -> L49
            a.f50762b = r119;     // Catch: Exception -> L49
        L41:
            r119.setAccessible(true);     // Catch: Exception -> L49
            Object r120 = r118.get(r103);     // Catch: Exception -> L49
            if (r120 == null) goto L48;
            int[] r121 = (int[]) r120;     // Catch: Exception -> L49
            int r122 = r119.getInt(r103);     // Catch: Exception -> L49
            int r123 = 0;
        L44:
            if (r123 >= r122) goto L46;
            int r124 = (r122 * r115) + r123;     // Catch: Exception -> L49
            int r125 = r124 + r122;     // Catch: Exception -> L49
            int r126 = r121[r124];     // Catch: Exception -> L49
            r121[r124] = r121[r125];     // Catch: Exception -> L49
            r121[r125] = r126;     // Catch: Exception -> L49
            r123 = r123 + 1;     // Catch: Exception -> L49
            goto L44
        L46:
            r116 = false;
            goto L51
        L48:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.IntArray");     // Catch: Exception -> L49
        L51:
            if (r116 == false) goto L30;
            return r103;
        }
    }

    static {
        f50763c = new C0865a();
    }
}
