package hd;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import com.ttnet.org.chromium.net.PrivateKeyType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final C0266a f20400l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f20401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f20402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f20404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f20406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f20407g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f20408h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f20409i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f20410j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Interpolator f20411k;

    /* JADX INFO: renamed from: hd.a$a, reason: collision with other inner class name */
    public static final class C0266a {
        public /* synthetic */ C0266a(DefaultConstructorMarker r10) {
            this();
        }

        public C0266a() {
        }
    }

    static {
        f20400l = new C0266a(null);
    }

    public a(Drawable r10, Drawable r11) {
        q.g(r10, "startDrawable");
        q.g(r11, "endDrawable");
        this.f20401a = r10;
        this.f20402b = r11;
        this.f20410j = true;
        this.f20411k = new AccelerateInterpolator();
    }

    public final void a(Canvas r10, int r11) {
        this.f20401a.setBounds(getBounds());
        this.f20402b.setBounds(getBounds());
        if (this.f20410j == false) goto L5;
        this.f20401a.setAlpha(255 - r11);
    L5:
        this.f20401a.draw(r10);
        if (this.f20410j == false) goto L8;
        this.f20401a.setAlpha(PrivateKeyType.INVALID);
    L8:
        if (r11 <= 0) goto L11;
        this.f20402b.setAlpha(r11);
        this.f20402b.draw(r10);
        this.f20402b.setAlpha(PrivateKeyType.INVALID);
        return;
    }

    public final void b() {
        this.f20408h = 0;
        this.f20403c = 0;
        invalidateSelf();
    }

    public final void c(int r13) {
        long r10 = SystemClock.uptimeMillis();
        int r11 = 0;
        if (this.f20403c != 2) goto L17;
        long r12 = this.f20404d;
        long r14 = r10 - r12;
        int r15 = this.f20405e;
        if (r14 > r15) goto L17;
        boolean r16 = this.f20409i;
        this.f20409i = !r16;
        this.f20406f = this.f20408h;
        if (r16 == false) goto L11;
        r11 = 255;
    L11:
        this.f20407g = r11;
        long r17 = r10 - r12;
        if (r16 == true) goto L14;
        int r18 = (int) r17;
    L15:
        this.f20405e = r18;
        this.f20403c = 1;
        invalidateSelf();
        return;
    L14:
        r18 = r15 - ((int) r17);
    L17:
        this.f20406f = PrivateKeyType.INVALID;
        this.f20407g = 0;
        this.f20408h = PrivateKeyType.INVALID;
        this.f20405e = r13;
        this.f20409i = true;
        this.f20403c = 1;
        invalidateSelf();
    }

    public final void d() {
        this.f20408h = PrivateKeyType.INVALID;
        this.f20403c = 0;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r10) {
        q.g(r10, "canvas");
        int r11 = this.f20403c;
        if (r11 == 1) goto L10;
        if (r11 != 2) goto L11;
        long r12 = SystemClock.uptimeMillis() - this.f20404d;
        int r13 = this.f20405e;
        if (r12 < r13) goto L9;
        this.f20408h = this.f20407g;
        this.f20403c = 0;
        goto L11
    L9:
        float r14 = this.f20411k.getInterpolation(r12 / r13);
        int r15 = this.f20406f;
        this.f20408h = r15 + ((int) ((this.f20407g - r15) * r14));
    L11:
        int r16 = this.f20408h;
        if (this.f20403c != 0) goto L20;
        if (r16 != 0) goto L15;
        this.f20401a.setBounds(getBounds());
        this.f20401a.draw(r10);
        return;
    L15:
        if (r16 == 255) goto L17;
        a(r10, r16);
        return;
    L17:
        this.f20402b.setBounds(getBounds());
        this.f20402b.draw(r10);
        return;
    L20:
        a(r10, r16);
        if (this.f20403c != 2) goto L26;
        invalidateSelf();
        return;
    L26:
        return;
    L10:
        this.f20404d = SystemClock.uptimeMillis();
        this.f20403c = 2;
        goto L11
    }

    public final void e(int r10) {
        this.f20406f = 0;
        this.f20407g = PrivateKeyType.INVALID;
        this.f20408h = 0;
        this.f20405e = r10;
        this.f20409i = false;
        this.f20403c = 1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.max(this.f20401a.getIntrinsicHeight(), this.f20402b.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.max(this.f20401a.getIntrinsicWidth(), this.f20402b.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        this.f20401a.setAlpha(r10);
        this.f20402b.setAlpha(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r10) {
        this.f20401a.setColorFilter(r10);
        this.f20402b.setColorFilter(r10);
    }
}
