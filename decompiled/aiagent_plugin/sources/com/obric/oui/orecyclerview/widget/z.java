package com.obric.oui.orecyclerview.widget;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ViewBoundsCheck.java */
/* JADX INFO: loaded from: classes4.dex */
class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final b f35851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    a f35852b;

    /* JADX INFO: compiled from: ViewBoundsCheck.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f35853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f35854b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f35855c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f35856d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f35857e;

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
            this.f35853a = 0;
        }

        void a(int r1, int r2, int r3, int r4) {
            this.f35854b = r1;
            this.f35855c = r2;
            this.f35856d = r3;
            this.f35857e = r4;
        }

        void a(int r2) {
            this.f35853a = r2 | this.f35853a;
        }

        void a() {
            this.f35853a = 0;
        }

        boolean b() {
            int r0 = this.f35853a;
            if ((r0 & 7) != 0) goto L5;
        L7:
            int r1 = this.f35853a;
            if ((r1 & 112) != 0) goto L10;
        L12:
            int r2 = this.f35853a;
            if ((r2 & 1792) != 0) goto L15;
        L17:
            int r3 = this.f35853a;
            if ((r3 & 28672) != 0) goto L20;
            return true;
        L20:
            if (((a(this.f35857e, this.f35855c) << 12) & r3) != 0) goto L24;
            return false;
        L24:
            return true;
        L15:
            if ((r2 & (a(this.f35857e, this.f35854b) << 8)) != 0) goto L17;
            return false;
        L10:
            if ((r1 & (a(this.f35856d, this.f35855c) << 4)) != 0) goto L12;
            return false;
        L5:
            if ((r0 & (a(this.f35856d, this.f35854b) << 0)) != 0) goto L7;
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

    z(b r3) {
        this.f35851a = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        this.f35852b = new a();
    }

    View a(int r9, int r10, int r11, int r12) {
        int r0 = this.f35851a.a();
        int r1 = this.f35851a.b();
        if (r10 <= r9) goto L5;
        int r2 = 1;
    L6:
        View r3 = null;
    L7:
        if (r9 == r10) goto L18;
        View r4 = this.f35851a.a(r9);
        int r5 = this.f35851a.a(r4);
        int r6 = this.f35851a.b(r4);
        this.f35852b.a(r0, r1, r5, r6);
        if (r11 == 0) goto L13;
        this.f35852b.a();
        this.f35852b.a(r11);
        if (this.f35852b.b() == false) goto L13;
        return r4;
    L13:
        if (r12 == 0) goto L17;
        this.f35852b.a();
        this.f35852b.a(r12);
        if (this.f35852b.b() == false) goto L17;
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
        this.f35852b.a(this.f35851a.a(), this.f35851a.b(), this.f35851a.a(r6), this.f35851a.b(r6));
        if (r7 == 0) goto L6;
        this.f35852b.a();
        this.f35852b.a(r7);
        return this.f35852b.b();
    L6:
        return false;
    }
}
