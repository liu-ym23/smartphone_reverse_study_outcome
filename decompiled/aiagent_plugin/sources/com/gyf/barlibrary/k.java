package com.gyf.barlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SimpleImmersionProxy.java */
/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Fragment f13813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j f13814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f13815c;

    public k(Fragment r3) {
        this.f13813a = r3;
        if (ZeusTransformUtils.instanceOf(r3, j.class) == false) goto L7;
        this.f13814b = (j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.aiagent.plugin");
        return;
    L7:
        throw new IllegalArgumentException("please implement SimpleImmersionOwner in your Fragment");
    }

    public void a(boolean r1) {
        b();
    }

    public void a(Bundle r1) {
        this.f13815c = true;
        b();
    }

    public void a() {
        Fragment r0 = this.f13813a;
        if (r0 != null) goto L5;
    L9:
        this.f13813a = null;
        this.f13814b = null;
        return;
    L5:
        if (((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin")) == null) goto L9;
        if (this.f13814b.immersionBarEnabled() == false) goto L9;
        ImmersionBar.with(this.f13813a).destroy();
        goto L9
    }

    public void a(Configuration r1) {
        b();
    }

    public void b(boolean r1) {
        Fragment r0 = this.f13813a;
        if (r0 == null) goto L6;
        r0.setUserVisibleHint(!r1);
        return;
    }

    private void b() {
        Fragment r0 = this.f13813a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.f13815c == true) goto L7;
        return;
    L7:
        if (r0.getUserVisibleHint() == true) goto L9;
        return;
    L9:
        if (this.f13814b.immersionBarEnabled() == false) goto L15;
        this.f13814b.a();
        return;
    }
}
