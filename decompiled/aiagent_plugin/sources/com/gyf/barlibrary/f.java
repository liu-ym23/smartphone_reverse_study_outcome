package com.gyf.barlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ImmersionProxy.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Fragment f13806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e f13807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f13808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f13809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f13810e;

    public f(Fragment r3) {
        this.f13806a = r3;
        if (ZeusTransformUtils.instanceOf(r3, e.class) == false) goto L7;
        this.f13807b = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin");
        return;
    L7:
        throw new IllegalArgumentException("please implement SimpleImmersionOwner in your Fragment");
    }

    public void a(boolean r2) {
        Fragment r3 = this.f13806a;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.getUserVisibleHint() == false) goto L21;
        if (this.f13810e == true) goto L10;
        this.f13807b.onLazyBeforeView();
        this.f13810e = true;
    L10:
        if (this.f13808c == true) goto L12;
        return;
    L12:
        if (this.f13806a.getUserVisibleHint() == true) goto L14;
        return;
    L14:
        if (this.f13807b.immersionBarEnabled() == false) goto L17;
        this.f13807b.a();
    L17:
        if (this.f13809d == true) goto L19;
        this.f13807b.onLazyAfterView();
        this.f13809d = true;
    L19:
        this.f13807b.onVisible();
        return;
    L21:
        if (this.f13808c == false) goto L28;
        this.f13807b.onInvisible();
        return;
    }

    public void a(Bundle r1) {
        Fragment r2 = this.f13806a;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.getUserVisibleHint() == true) goto L7;
        return;
    L7:
        if (this.f13810e == true) goto L12;
        this.f13807b.onLazyBeforeView();
        this.f13810e = true;
        return;
    }

    public void b(Bundle r2) {
        this.f13808c = true;
        Fragment r0 = this.f13806a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getUserVisibleHint() == true) goto L7;
        return;
    L7:
        if (this.f13807b.immersionBarEnabled() == false) goto L10;
        this.f13807b.a();
    L10:
        if (this.f13809d == true) goto L15;
        this.f13807b.onLazyAfterView();
        this.f13809d = true;
        return;
    }

    public void a() {
        Fragment r0 = this.f13806a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getUserVisibleHint() == false) goto L9;
        this.f13807b.onVisible();
        return;
    }

    public void b() {
        if (this.f13806a == null) goto L6;
        this.f13807b.onInvisible();
        return;
    }

    public void c() {
        Fragment r0 = this.f13806a;
        if (r0 != null) goto L5;
    L9:
        this.f13806a = null;
        this.f13807b = null;
        return;
    L5:
        if (((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin")) == null) goto L9;
        if (this.f13807b.immersionBarEnabled() == false) goto L9;
        ImmersionBar.with(this.f13806a).destroy();
        goto L9
    }

    public void a(Configuration r1) {
        Fragment r2 = this.f13806a;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.getUserVisibleHint() == true) goto L7;
        return;
    L7:
        if (this.f13807b.immersionBarEnabled() == false) goto L9;
        this.f13807b.a();
    L9:
        this.f13807b.onVisible();
    }

    public void b(boolean r1) {
        Fragment r0 = this.f13806a;
        if (r0 == null) goto L6;
        r0.setUserVisibleHint(!r1);
        return;
    }
}
