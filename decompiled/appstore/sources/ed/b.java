package ed;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$styleable;
import com.obric.oui.image.OImageShape;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f19405f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OImageShape f19406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f19407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f19408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f19409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f19410e;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static /* synthetic */ b b(a r10, Context r11, AttributeSet r12, int r13, int r14, int r15, Object r16) {
            if ((r15 & 4) == 0) goto L6;
            r13 = 0;
        L6:
            if ((r15 & 8) == 0) goto L9;
            r14 = 0;
        L9:
            return r10.a(r11, r12, r13, r14);
        }

        public final b a(Context r10, AttributeSet r11, int r12, int r13) {
            q.g(r10, "context");
            Result.a r14 = Result.Companion;     // Catch: Throwable -> L6
            if (r11 != null) goto L8;
            OImageShape r15 = null;
            boolean r16 = false;
            Integer r17 = null;
            Integer r18 = null;
            boolean r19 = false;
            b r20 = new b(r15, r16, r17, r18, r19, 31, null);     // Catch: Throwable -> L6
        L22:
            Object r21 = Result.m35constructorimpl(r20);     // Catch: Throwable -> L6
        L26:
            Throwable r22 = Result.m38exceptionOrNullimpl(r21);
            if (r22 == null) goto L31;
            Log.w("OImageStyleHelper", "Failed to parse OImage attrs, fallback to defaults", r22);
            OImageShape r23 = null;
            boolean r24 = false;
            Integer r25 = null;
            Integer r26 = null;
            boolean r27 = false;
            r21 = new b(r23, r24, r25, r26, r27, 31, null);
        L31:
            return (b) r21;
        L8:
            TypedArray r28 = r10.obtainStyledAttributes(r11, R$styleable.OImage, r12, r13);     // Catch: Throwable -> L6
            int r110 = r28.getInt(R$styleable.OImage_oui_imageShape, OImageShape.STANDARD.getAttrValue());     // Catch: Throwable -> L13
            OImageShape r29 = OImageShape.Companion.a(r110);     // Catch: Throwable -> L13
            boolean r30 = r28.getBoolean(R$styleable.OImage_oui_imageStrokeEnabled, true);     // Catch: Throwable -> L13
            int r111 = R$styleable.OImage_oui_imageBackgroundColor;     // Catch: Throwable -> L13
            if (r28.hasValue(r111) == false) goto L15;
            Integer r112 = Integer.valueOf(r28.getColor(r111, 0));     // Catch: Throwable -> L13
        L12:
            Integer r31 = r112;
            int r113 = R$styleable.OImage_oui_imageStrokeColor;     // Catch: Throwable -> L13
            if (r28.hasValue(r113) == false) goto L19;
            int r32 = r28.getColor(r113, ContextCompat.b(r10, R$color.oui_line_1));     // Catch: Throwable -> L13
        L20:
            b r114 = new b(r29, r30, r31, Integer.valueOf(r32), r28.getBoolean(R$styleable.OImage_oui_clipToMask, false));     // Catch: Throwable -> L13
            r28.recycle();     // Catch: Throwable -> L6
            r20 = r114;
            goto L22
        L19:
            r32 = ContextCompat.b(r10, R$color.oui_line_1);     // Catch: Throwable -> L13
            goto L20
        L15:
            r112 = null;
        L13:
            th = move-exception;
            r28.recycle();     // Catch: Throwable -> L6
            throw th;     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            Result.a r33 = Result.Companion;
            r21 = Result.m35constructorimpl(kotlin.c.a(th));
            goto L26
        }

        public a() {
        }
    }

    static {
        f19405f = new a(null);
    }

    public b(OImageShape r10, boolean r11, Integer r12, Integer r13, boolean r14) {
        q.g(r10, "shape");
        this.f19406a = r10;
        this.f19407b = r11;
        this.f19408c = r12;
        this.f19409d = r13;
        this.f19410e = r14;
    }

    public final Integer a() {
        return this.f19408c;
    }

    public final boolean b() {
        return this.f19410e;
    }

    public final OImageShape c() {
        return this.f19406a;
    }

    public final Integer d() {
        return this.f19409d;
    }

    public final boolean e() {
        return this.f19407b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        if (this.f19406a == r11.f19406a) goto L12;
        return false;
    L12:
        if (this.f19407b == r11.f19407b) goto L15;
        return false;
    L15:
        if (q.b(this.f19408c, r11.f19408c) == true) goto L18;
        return false;
    L18:
        if (q.b(this.f19409d, r11.f19409d) == true) goto L21;
        return false;
    L21:
        if (this.f19410e == r11.f19410e) goto L23;
        return false;
    L23:
        return true;
    }

    public final void f(Integer r10) {
        this.f19408c = r10;
    }

    public final void g(boolean r10) {
        this.f19410e = r10;
    }

    public final void h(Integer r10) {
        this.f19409d = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r10 = this.f19406a.hashCode() * 31;
        boolean r11 = this.f19407b;
        ?? r12 = 1;
        ?? r13 = r11;
        if (r11 == false) goto L5;
        r13 = 1;
    L5:
        int r14 = (r10 + r13) * 31;
        Integer r15 = this.f19408c;
        int r16 = 0;
        if (r15 != null) goto L8;
        int r17 = 0;
    L9:
        int r18 = (r14 + r17) * 31;
        Integer r19 = this.f19409d;
        if (r19 == null) goto L13;
        r16 = r19.hashCode();
    L13:
        int r20 = (r18 + r16) * 31;
        boolean r21 = this.f19410e;
        if (r21 == true) goto L18;
        r12 = r21;
    L18:
        return r20 + r12;
    L8:
        r17 = r15.hashCode();
        goto L9
    }

    public String toString() {
        return "OImageStyleConfig(shape=" + this.f19406a + ", strokeEnabled=" + this.f19407b + ", backgroundColor=" + this.f19408c + ", strokeColor=" + this.f19409d + ", clipToMask=" + this.f19410e + ')';
    }

    public /* synthetic */ b(OImageShape r10, boolean r11, Integer r12, Integer r13, boolean r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L6;
        r10 = OImageShape.STANDARD;
    L6:
        if ((r15 & 2) == 0) goto L8;
        r11 = true;
    L8:
        boolean r17 = r11;
        Integer r18 = null;
        if ((r15 & 4) == 0) goto L11;
        Integer r19 = null;
    L13:
        if ((r15 & 8) != 0) goto L17;
        r18 = r13;
    L17:
        if ((r15 & 16) == 0) goto L19;
        r14 = false;
    L19:
        this(r10, r17, r19, r18, r14);
        return;
    L11:
        r19 = r12;
        goto L13
    }
}
