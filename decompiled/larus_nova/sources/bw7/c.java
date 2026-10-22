package bw7;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes23.dex */
public final class c extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f21199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f21200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f21201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f21202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f21203e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView f21204f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView.ViewHolder f21205g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f21206h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f21207i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f21208j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Interpolator f21209k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f21210l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f21211m;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WeakReference<c> f21213b;

        public final void a() {
            c r100 = this.f21213b.get();
            this.f21213b.clear();
            this.f21213b = null;
            if (r100 == null) goto L18;
            int r101 = this.f21212a;
            int r102 = 1 << r101;
            long r103 = r100.f21208j;
            long r104 = System.currentTimeMillis();
            if (r104 < r103) goto L7;
            long r105 = r104 - r103;
        L8:
            int r106 = r100.f21211m;
            r100.f21211m = (~r102) & r106;
            if (r101 == 0) goto L13;
            if (r101 != 1) goto L21;
            r100.f21204f.removeItemDecoration(r100);
            ViewCompat.postInvalidateOnAnimation(r100.f21204f);
            r100.f21204f = null;
            r100.f21205g = null;
            r100.f21207i = 0;
            r100.f21209k = null;
            return;
        L21:
            return;
        L13:
            long r107 = r100.f21201c;
            if (r105 >= r107) goto L16;
            r100.h(0, r107 - r105);
            return;
        L16:
            ViewCompat.postInvalidateOnAnimation(r100.f21204f);
            r100.h(1, r100.f21202d);
            return;
        L7:
            r105 = Long.MAX_VALUE;
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(c r100, int r101) {
            this.f21213b = new WeakReference(r100);
            this.f21212a = r101;
        }
    }

    public final void h(int r100, long r101) {
        int r102 = 1 << r100;
        int r103 = this.f21211m;
        if ((r103 & r102) == 0) goto L5;
        return;
    L5:
        this.f21211m = r102 | r103;
        a r104 = new a(this, r100);
        ViewCompat.postOnAnimationDelayed(this.f21204f, r104, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        long r100 = this.f21208j;
        long r101 = System.currentTimeMillis();
        if (r101 < r100) goto L5;
        long r102 = r101 - r100;
    L6:
        long r103 = this.f21201c;
        float r104 = 1.0f;
        if (r102 >= r103) goto L9;
        float r105 = 1.0f;
    L17:
        Drawable r106 = this.f21210l;
        Rect r107 = this.f21200b;
        int r108 = this.f21206h;
        int r109 = this.f21207i;
        boolean r113 = this.f21203e;
        if (r113 == false) goto L20;
        float r114 = 1.0f;
    L21:
        if (r113 == false) goto L23;
        r104 = r105;
    L23:
        int r115 = (int) ((r114 * r107.width()) + 0.5f);
        int r116 = (int) ((r104 * r107.height()) + 0.5f);
        boolean r117 = false;
        if (r116 == 0) goto L30;
        if (r115 == 0) goto L30;
        if (r106 == null) goto L30;
        int r118 = r110.save();
        int r119 = r107.left + r108;
        int r120 = r107.top + r109;
        r110.clipRect(r119, r120, r119 + r115, r120 + r116);
        r110.translate((r107.left + r108) - ((r107.width() - r115) / 2), (r107.top + r109) - ((r107.height() - r116) / 2));
        r106.setBounds(0, 0, r107.width(), r107.height());
        r106.draw(r110);
        r110.restoreToCount(r118);
    L30:
        if (this.f21199a != this.f21205g.getItemId()) goto L32;
        this.f21206h = (int) (this.f21205g.itemView.getTranslationX() + 0.5f);
        this.f21207i = (int) (this.f21205g.itemView.getTranslationY() + 0.5f);
    L32:
        long r121 = this.f21201c;
        if (r102 >= r121) goto L35;
    L37:
        if (r117 == false) goto L40;
        ViewCompat.postInvalidateOnAnimation(this.f21204f);
        return;
    L40:
        return;
    L35:
        if (r102 >= (r121 + this.f21202d)) goto L37;
        r117 = true;
        goto L37
    L20:
        r114 = r105;
        goto L21
    L9:
        long r122 = this.f21202d;
        if (r102 < (r103 + r122)) goto L12;
    L16:
        r105 = 0.0f;
        goto L17
    L12:
        if (r122 == 0) goto L16;
        r105 = 1.0f - ((r102 - r103) / r122);
        Interpolator r123 = this.f21209k;
        if (r123 == null) goto L17;
        r105 = r123.getInterpolation(r105);
        goto L17
    L5:
        r102 = Long.MAX_VALUE;
        goto L6
    }

    public c(RecyclerView r100, RecyclerView.ViewHolder r101, int r102, long r103, long r110) {
        Rect r104 = new Rect();
        this.f21200b = r104;
        boolean r105 = false;
        this.f21211m = 0;
        this.f21204f = r100;
        this.f21205g = r101;
        this.f21199a = r101.getItemId();
        if (r102 != 2) goto L5;
    L6:
        r105 = true;
    L7:
        this.f21203e = r105;
        this.f21201c = r103 + 50;
        this.f21202d = r110;
        this.f21206h = (int) (r101.itemView.getTranslationX() + 0.5f);
        this.f21207i = (int) (r101.itemView.getTranslationY() + 0.5f);
        View r106 = this.f21205g.itemView;
        r104.left = r106.getLeft();
        r104.right = r106.getRight();
        r104.top = r106.getTop();
        r104.bottom = r106.getBottom();
        return;
    L5:
        if (r102 != 4) goto L7;
        goto L6
    }
}
