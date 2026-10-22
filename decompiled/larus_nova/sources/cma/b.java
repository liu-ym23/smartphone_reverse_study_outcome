package cma;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.obric.oui.image.OImageShape;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f24238f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OImageShape f24239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f24240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f24241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f24242d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f24243e;

    public static final class a {
        public a() {
        }

        public static b a(a r110, Context r111, AttributeSet r112, int r113) {
            r110.getClass();
            Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
            int r114 = 0;
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L35
            if (r112 != null) goto L6;
            b r115 = new b(r114);     // Catch: Throwable -> L35
        L31:
            Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L35
        L38:
            if (Result.m9452exceptionOrNullimpl(r116) == null) goto L42;
            r116 = new b(r114);
        L42:
            return (b) r116;
        L6:
            TypedArray r117 = r111.obtainStyledAttributes(r112, new int[]{R.attr.oui_clipToMask, R.attr.oui_imageBackgroundColor, R.attr.oui_imageShape, R.attr.oui_imageStrokeColor, R.attr.oui_imageStrokeEnabled}, r113, 0);     // Catch: Throwable -> L35
            int r118 = r117.getInt(2, OImageShape.STANDARD.getAttrValue());     // Catch: Throwable -> L32
            OImageShape.Companion.getClass();     // Catch: Throwable -> L32
            OImageShape[] r101 = OImageShape.values();     // Catch: Throwable -> L32
            int r102 = r101.length;     // Catch: Throwable -> L32
            int r103 = 0;
        L9:
            if (r103 >= r102) goto L17;
            OImageShape r104 = r101[r103];     // Catch: Throwable -> L32
            if (r104.getAttrValue() != r118) goto L13;
            boolean r105 = true;
        L14:
            if (r105 == true) goto L18;
            r103 = r103 + 1;     // Catch: Throwable -> L32
        L18:
            if (r104 != null) goto L20;
            OImageShape r119 = OImageShape.STANDARD;     // Catch: Throwable -> L32
        L21:
            boolean r106 = r117.getBoolean(4, true);     // Catch: Throwable -> L32
            if (r117.hasValue(1) == false) goto L24;
            Integer r107 = Integer.valueOf(r117.getColor(1, 0));     // Catch: Throwable -> L32
        L26:
            if (r117.hasValue(3) == false) goto L28;
            int r120 = r117.getColor(3, ContextCompat.getColor(r111, R.color.oui_line_1));     // Catch: Throwable -> L32
        L29:
            b r108 = new b(r119, r106, r107, Integer.valueOf(r120), r117.getBoolean(0, false));     // Catch: Throwable -> L32
            r117.recycle();     // Catch: Throwable -> L35
            r115 = r108;
            goto L31
        L28:
            r120 = ContextCompat.getColor(r111, R.color.oui_line_1);     // Catch: Throwable -> L32
            goto L29
        L24:
            r107 = null;
            goto L26
        L20:
            r119 = r104;
            goto L21
        L13:
            r105 = false;
            goto L14
        L17:
            r104 = null;
        L32:
            th = move-exception;
            r117.recycle();     // Catch: Throwable -> L35
            throw th;     // Catch: Throwable -> L35
        L35:
            th = move-exception;
            Result.Companion r121 = Result.Companion;
            r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L38
        }
    }

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f24239a == r101.f24239a) goto L12;
        return false;
    L12:
        if (this.f24240b == r101.f24240b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f24241c, r101.f24241c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f24242d, r101.f24242d) == true) goto L21;
        return false;
    L21:
        if (this.f24243e == r101.f24243e) goto L23;
        return false;
    L23:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r100 = this.f24239a.hashCode() * 31;
        boolean r101 = this.f24240b;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f24241c;
        int r106 = 0;
        if (r105 != null) goto L8;
        int r107 = 0;
    L9:
        int r108 = (r104 + r107) * 31;
        Integer r109 = this.f24242d;
        if (r109 == null) goto L13;
        r106 = r109.hashCode();
    L13:
        int r110 = (r108 + r106) * 31;
        boolean r111 = this.f24243e;
        if (r111 == true) goto L18;
        r102 = r111;
    L18:
        return r110 + r102;
    L8:
        r107 = r105.hashCode();
        goto L9
    }

    public final String toString() {
        return "OImageStyleConfig(shape=" + this.f24239a + ", strokeEnabled=" + this.f24240b + ", backgroundColor=" + this.f24241c + ", strokeColor=" + this.f24242d + ", clipToMask=" + this.f24243e + ')';
    }

    static {
        f24238f = new a();
    }

    public /* synthetic */ b(int r100) {
        this(OImageShape.STANDARD, true, null, null, false);
    }

    public b(OImageShape r100, boolean r101, Integer r102, Integer r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "shape");
        this.f24239a = r100;
        this.f24240b = r101;
        this.f24241c = r102;
        this.f24242d = r103;
        this.f24243e = r104;
    }
}
