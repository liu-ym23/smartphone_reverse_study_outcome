package nd;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import bg.h;
import com.ttnet.org.chromium.net.PrivateKeyType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C0322a f22437j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final float[] f22438k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f22439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PorterDuffXfermode f22440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f22441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Matrix f22442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f22443e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f22444f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearGradient f22445g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearGradient f22446h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f22447i;

    /* JADX INFO: renamed from: nd.a$a, reason: collision with other inner class name */
    public static final class C0322a {
        public /* synthetic */ C0322a(DefaultConstructorMarker r10) {
            this();
        }

        public C0322a() {
        }
    }

    static {
        f22437j = new C0322a(null);
        f22438k = new float[]{0.0f, 1.0f};
    }

    public a() {
        this.f22439a = new Paint(1);
        this.f22440b = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.f22441c = new Matrix();
        this.f22442d = new Matrix();
        this.f22447i = -1.0f;
    }

    public final void a(Canvas r11, float r12, float r13, float r14, float r15, boolean r16, boolean r17) {
        q.g(r11, "canvas");
        float r10 = Math.min(this.f22444f, ((int) (r14 - r12)) / 2.0f);
        if (r10 > 0.0f) goto L5;
        return;
    L5:
        b(r10);
        this.f22439a.setXfermode(this.f22440b);
        if (r16 == false) goto L11;
        LinearGradient r18 = this.f22445g;
        if (r18 == null) goto L10;
        this.f22441c.reset();
        this.f22441c.setTranslate(r12, 0.0f);
        r18.setLocalMatrix(this.f22441c);
        this.f22439a.setShader(r18);
    L10:
        r11.drawRect(r12, r13, r12 + r10, r15, this.f22439a);
    L11:
        if (r17 == false) goto L16;
        LinearGradient r19 = this.f22446h;
        if (r19 == null) goto L15;
        this.f22442d.reset();
        this.f22442d.setTranslate(r14 - r10, 0.0f);
        r19.setLocalMatrix(this.f22442d);
        this.f22439a.setShader(r19);
    L15:
        r11.drawRect(r14 - r10, r13, r14, r15, this.f22439a);
    L16:
        this.f22439a.setShader(null);
        this.f22439a.setXfermode(null);
    }

    public final void b(float r16) {
        if (this.f22447i != r16) goto L5;
        return;
    L5:
        this.f22447i = r16;
        int[] r10 = {Color.argb(0, 0, 0, 0), Color.argb(PrivateKeyType.INVALID, 0, 0, 0)};
        float[] r13 = f22438k;
        Shader.TileMode r14 = Shader.TileMode.CLAMP;
        this.f22445g = new LinearGradient(0.0f, 0.0f, r16, 0.0f, r10, r13, r14);
        this.f22446h = new LinearGradient(0.0f, 0.0f, r16, 0.0f, new int[]{Color.argb(PrivateKeyType.INVALID, 0, 0, 0), Color.argb(0, 0, 0, 0)}, r13, r14);
    }

    public final float c() {
        return this.f22444f;
    }

    public final void d() {
        this.f22447i = -1.0f;
        this.f22445g = null;
        this.f22446h = null;
    }

    public final boolean e(boolean r10) {
        if (this.f22443e != r10) goto L6;
        return false;
    L6:
        this.f22443e = r10;
        return true;
    }

    public final boolean f(float r10) {
        float r11 = h.c(r10, 0.0f);
        if (this.f22444f != r11) goto L6;
        return false;
    L6:
        this.f22444f = r11;
        d();
        return true;
    }

    public final boolean g(int r10, int r11, boolean r12, boolean r13) {
        if (this.f22443e == true) goto L5;
    L11:
        return false;
    L5:
        if (this.f22444f <= 0.0f) goto L11;
        if (r10 <= 0) goto L11;
        if (r11 <= 0) goto L11;
        if (r12 == true) goto L10;
        if (r13 == false) goto L11;
    L10:
        return true;
    }
}
