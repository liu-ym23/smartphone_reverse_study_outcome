package com.obric.oui.orecyclerview.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public class ViewBoundsCheck {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callback f15585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f15586b;

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
        public int f15587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15588b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15589c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f15590d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f15591e;

        public a() {
            this.f15587a = 0;
        }

        public void a(int r10) {
            this.f15587a = r10 | this.f15587a;
        }

        public boolean b() {
            int r10 = this.f15587a;
            if ((r10 & 7) != 0) goto L5;
        L7:
            int r11 = this.f15587a;
            if ((r11 & 112) != 0) goto L10;
        L12:
            int r12 = this.f15587a;
            if ((r12 & 1792) != 0) goto L15;
        L17:
            int r13 = this.f15587a;
            if ((r13 & 28672) != 0) goto L20;
            return true;
        L20:
            if (((c(this.f15591e, this.f15589c) << 12) & r13) != 0) goto L24;
            return false;
        L24:
            return true;
        L15:
            if ((r12 & (c(this.f15591e, this.f15588b) << 8)) != 0) goto L17;
            return false;
        L10:
            if ((r11 & (c(this.f15590d, this.f15589c) << 4)) != 0) goto L12;
            return false;
        L5:
            if ((r10 & c(this.f15590d, this.f15588b)) != 0) goto L7;
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
            this.f15587a = 0;
        }

        public void e(int r10, int r11, int r12, int r13) {
            this.f15588b = r10;
            this.f15589c = r11;
            this.f15590d = r12;
            this.f15591e = r13;
        }
    }

    public ViewBoundsCheck(Callback r10) {
        this.f15585a = r10;
        this.f15586b = new a();
    }

    public View a(int r10, int r11, int r12, int r13) {
        int r14 = this.f15585a.getParentStart();
        int r15 = this.f15585a.getParentEnd();
        if (r11 <= r10) goto L5;
        int r16 = 1;
    L6:
        View r17 = null;
    L7:
        if (r10 == r11) goto L18;
        View r18 = this.f15585a.getChildAt(r10);
        int r19 = this.f15585a.getChildStart(r18);
        int r20 = this.f15585a.getChildEnd(r18);
        this.f15586b.e(r14, r15, r19, r20);
        if (r12 == 0) goto L13;
        this.f15586b.d();
        this.f15586b.a(r12);
        if (this.f15586b.b() == false) goto L13;
        return r18;
    L13:
        if (r13 == 0) goto L17;
        this.f15586b.d();
        this.f15586b.a(r13);
        if (this.f15586b.b() == false) goto L17;
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
}
