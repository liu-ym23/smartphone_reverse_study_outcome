package androidx.recyclerview.widget;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ViewBoundsCheck.java */
/* JADX INFO: loaded from: classes.dex */
class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final b f2429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    a f2430b;

    /* JADX INFO: compiled from: ViewBoundsCheck.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2432b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2433c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2434d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f2435e;

        int a(int r1, int r2) {
            if (r1 <= r2) goto L5;
            return 1;
        L5:
            if (r1 != r2) goto L8;
            return 2;
        L8:
            return 4;
        }

        a() {
            this.f2431a = 0;
        }

        void a(int r1, int r2, int r3, int r4) {
            this.f2432b = r1;
            this.f2433c = r2;
            this.f2434d = r3;
            this.f2435e = r4;
        }

        void a(int r2) {
            this.f2431a = r2 | this.f2431a;
        }

        void a() {
            this.f2431a = 0;
        }

        boolean b() {
            int r0 = this.f2431a;
            if ((r0 & 7) != 0) goto L5;
        L7:
            int r1 = this.f2431a;
            if ((r1 & 112) != 0) goto L10;
        L12:
            int r2 = this.f2431a;
            if ((r2 & 1792) != 0) goto L15;
        L17:
            int r3 = this.f2431a;
            if ((r3 & 28672) != 0) goto L20;
            return true;
        L20:
            if (((a(this.f2435e, this.f2433c) << 12) & r3) != 0) goto L24;
            return false;
        L24:
            return true;
        L15:
            if ((r2 & (a(this.f2435e, this.f2432b) << 8)) != 0) goto L17;
            return false;
        L10:
            if ((r1 & (a(this.f2434d, this.f2433c) << 4)) != 0) goto L12;
            return false;
        L5:
            if ((r0 & (a(this.f2434d, this.f2432b) << 0)) != 0) goto L7;
            return false;
        }
    }

    /* JADX INFO: compiled from: ViewBoundsCheck.java */
    interface b {
        int a();

        int a(View r1);

        View a(int r1);

        int b();

        int b(View r1);
    }

    ab(b r3) {
        this.f2429a = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        this.f2430b = new a();
    }

    View a(int r9, int r10, int r11, int r12) {
        int r0 = this.f2429a.a();
        int r1 = this.f2429a.b();
        if (r10 <= r9) goto L5;
        int r2 = 1;
    L6:
        View r3 = null;
    L7:
        if (r9 == r10) goto L18;
        View r4 = this.f2429a.a(r9);
        int r5 = this.f2429a.a(r4);
        int r6 = this.f2429a.b(r4);
        this.f2430b.a(r0, r1, r5, r6);
        if (r11 == 0) goto L13;
        this.f2430b.a();
        this.f2430b.a(r11);
        if (this.f2430b.b() == false) goto L13;
        return r4;
    L13:
        if (r12 == 0) goto L17;
        this.f2430b.a();
        this.f2430b.a(r12);
        if (this.f2430b.b() == false) goto L17;
        r3 = r4;
    L17:
        r9 = r9 + r2;
        goto L7
    L18:
        return r3;
    L5:
        r2 = -1;
        goto L6
    }

    boolean a(View r6, int r7) {
        this.f2430b.a(this.f2429a.a(), this.f2429a.b(), this.f2429a.a(r6), this.f2429a.b(r6));
        if (r7 == 0) goto L6;
        this.f2430b.a();
        this.f2430b.a(r7);
        return this.f2430b.b();
    L6:
        return false;
    }
}
