package androidx.recyclerview.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class ViewBoundsCheck {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callback f4302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f4303b;

    public interface Callback {
        View getChildAt(int r10);

        int getChildEnd(View r10);

        int getChildStart(View r10);

        int getParentEnd();

        int getParentStart();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewBounds {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4304a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4305b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4306c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4307d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4308e;

        public a() {
            this.f4304a = 0;
        }

        public void a(int r10) {
            this.f4304a = r10 | this.f4304a;
        }

        public boolean b() {
            int r10 = this.f4304a;
            if ((r10 & 7) != 0) goto L5;
        L7:
            int r11 = this.f4304a;
            if ((r11 & 112) != 0) goto L10;
        L12:
            int r12 = this.f4304a;
            if ((r12 & 1792) != 0) goto L15;
        L17:
            int r13 = this.f4304a;
            if ((r13 & 28672) != 0) goto L20;
            return true;
        L20:
            if (((c(this.f4308e, this.f4306c) << 12) & r13) != 0) goto L24;
            return false;
        L24:
            return true;
        L15:
            if ((r12 & (c(this.f4308e, this.f4305b) << 8)) != 0) goto L17;
            return false;
        L10:
            if ((r11 & (c(this.f4307d, this.f4306c) << 4)) != 0) goto L12;
            return false;
        L5:
            if ((r10 & c(this.f4307d, this.f4305b)) != 0) goto L7;
            return false;
        }

        public int c(int r10, int r11) {
            if (r10 <= r11) goto L5;
            return 1;
        L5:
            if (r10 != r11) goto L8;
            return 2;
        L8:
            return 4;
        }

        public void d() {
            this.f4304a = 0;
        }

        public void e(int r10, int r11, int r12, int r13) {
            this.f4305b = r10;
            this.f4306c = r11;
            this.f4307d = r12;
            this.f4308e = r13;
        }
    }

    public ViewBoundsCheck(Callback r10) {
        this.f4302a = r10;
        this.f4303b = new a();
    }

    public View a(int r10, int r11, int r12, int r13) {
        int r14 = this.f4302a.getParentStart();
        int r15 = this.f4302a.getParentEnd();
        if (r11 <= r10) goto L5;
        int r16 = 1;
    L6:
        View r17 = null;
    L7:
        if (r10 == r11) goto L18;
        View r18 = this.f4302a.getChildAt(r10);
        int r19 = this.f4302a.getChildStart(r18);
        int r20 = this.f4302a.getChildEnd(r18);
        this.f4303b.e(r14, r15, r19, r20);
        if (r12 == 0) goto L13;
        this.f4303b.d();
        this.f4303b.a(r12);
        if (this.f4303b.b() == false) goto L13;
        return r18;
    L13:
        if (r13 == 0) goto L17;
        this.f4303b.d();
        this.f4303b.a(r13);
        if (this.f4303b.b() == false) goto L17;
        r17 = r18;
    L17:
        r10 = r10 + r16;
        goto L7
    L18:
        return r17;
    L5:
        r16 = -1;
        goto L6
    }

    public boolean b(View r10, int r11) {
        this.f4303b.e(this.f4302a.getParentStart(), this.f4302a.getParentEnd(), this.f4302a.getChildStart(r10), this.f4302a.getChildEnd(r10));
        if (r11 == 0) goto L6;
        this.f4303b.d();
        this.f4303b.a(r11);
        return this.f4303b.b();
    L6:
        return false;
    }
}
