package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Build;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ImmersionDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f13857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f13858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private l f13859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13860d;

    i(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, Activity.class) == false) goto L8;
        if (this.f13857a != null) goto L24;
        this.f13857a = new g((Activity) ZeusTransformUtils.preCheckCast(r4, Activity.class, "com.obric.aiagent.plugin"));
        return;
    L24:
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r4, Fragment.class) == false) goto L16;
        if (this.f13857a == null) goto L12;
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r4, DialogFragment.class) == false) goto L14;
        this.f13857a = new g((DialogFragment) ZeusTransformUtils.preCheckCast(r4, DialogFragment.class, "com.obric.aiagent.plugin"));
        return;
    L14:
        this.f13857a = new g((Fragment) ZeusTransformUtils.preCheckCast(r4, Fragment.class, "com.obric.aiagent.plugin"));
        return;
    L16:
        if (ZeusTransformUtils.instanceOf(r4, android.app.Fragment.class) == true) goto L18;
        return;
    L18:
        if (this.f13857a == null) goto L20;
        return;
    L20:
        if (ZeusTransformUtils.instanceOf(r4, android.app.DialogFragment.class) == false) goto L22;
        this.f13857a = new g((android.app.DialogFragment) ZeusTransformUtils.preCheckCast(r4, android.app.DialogFragment.class, "com.obric.aiagent.plugin"));
        return;
    L22:
        this.f13857a = new g((android.app.Fragment) ZeusTransformUtils.preCheckCast(r4, android.app.Fragment.class, "com.obric.aiagent.plugin"));
    }

    i(Activity r3, Dialog r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        if (this.f13857a != null) goto L6;
        this.f13857a = new g(r5, r4);
        return;
    }

    public g a() {
        return this.f13857a;
    }

    void a(Configuration r1) {
        c(r1);
    }

    void b() {
        g r0 = this.f13857a;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    void c() {
        this.f13858b = null;
        this.f13859c = null;
        g r1 = this.f13857a;
        if (r1 == null) goto L6;
        r1.b();
        this.f13857a = null;
        return;
    }

    void b(Configuration r2) {
        g r0 = this.f13857a;
        if (r0 == null) goto L6;
        r0.a(r2);
        c(r2);
        return;
    }

    private void c(Configuration r6) {
        g r0 = this.f13857a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.o() == true) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 19) goto L28;
        l r1 = this.f13857a.f().N;
        this.f13859c = r1;
        if (r1 == null) goto L29;
        Activity r2 = ZeusTransformUtils.getActivity(this.f13857a, "com.obric.aiagent.plugin");
        if (this.f13858b != null) goto L13;
        this.f13858b = new d();
    L13:
        d r3 = this.f13858b;
        if (r6.orientation != 1) goto L16;
        boolean r7 = true;
    L17:
        r3.a(r7);
        int r8 = r2.getWindowManager().getDefaultDisplay().getRotation();
        if (r8 != 1) goto L21;
        this.f13858b.b(true);
        this.f13858b.c(false);
    L24:
        ZeusTransformUtils.getWindow(r2, "com.obric.aiagent.plugin").getDecorView().post(this);
        return;
    L21:
        if (r8 != 3) goto L23;
        this.f13858b.b(false);
        this.f13858b.c(true);
        goto L24
    L23:
        this.f13858b.b(false);
        this.f13858b.c(false);
        goto L24
    L16:
        r7 = false;
        goto L17
    L29:
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        g r0 = this.f13857a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.getActivity(r0, "com.obric.aiagent.plugin") == null) goto L14;
        Activity r1 = ZeusTransformUtils.getActivity(this.f13857a, "com.obric.aiagent.plugin");
        a r2 = new a(r1);
        this.f13858b.a(r2.b());
        this.f13858b.e(r2.d());
        this.f13858b.b(r2.e());
        this.f13858b.c(r2.f());
        this.f13858b.e(r2.c());
        boolean r3 = NotchUtils.hasNotchScreen(r1);
        this.f13858b.d(r3);
        if (r3 == true) goto L9;
    L11:
        this.f13859c.a(this.f13858b);
        return;
    L9:
        if (this.f13860d != 0) goto L11;
        int r4 = NotchUtils.getNotchHeight(r1);
        this.f13860d = r4;
        this.f13858b.d(r4);
        goto L11
    }
}
