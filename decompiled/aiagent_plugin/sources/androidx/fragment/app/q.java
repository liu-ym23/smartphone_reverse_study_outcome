package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.ag;
import androidx.lifecycle.am;
import androidx.lifecycle.ao;
import androidx.lifecycle.ap;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FragmentViewLifecycleOwner.java */
/* JADX INFO: loaded from: classes.dex */
class q implements ap, androidx.lifecycle.g, androidx.savedstate.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Fragment f1874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ao f1875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private am.b f1876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private androidx.lifecycle.r f1877d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private androidx.savedstate.b f1878e;

    q(Fragment r2, ao r3) {
        this.f1877d = null;
        this.f1878e = null;
        this.f1874a = r2;
        this.f1875b = r3;
    }

    @Override // androidx.lifecycle.ap
    public ao getViewModelStore() {
        a();
        return this.f1875b;
    }

    void a() {
        if (this.f1877d != null) goto L6;
        this.f1877d = new androidx.lifecycle.r(this);
        this.f1878e = androidx.savedstate.b.a(this);
        return;
    }

    boolean b() {
        if (this.f1877d == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.lifecycle.p
    public androidx.lifecycle.i getLifecycle() {
        a();
        return this.f1877d;
    }

    void a(androidx.lifecycle.i.b r1) {
        this.f1877d.b(r1);
    }

    void a(androidx.lifecycle.i.a r1) {
        this.f1877d.a(r1);
    }

    @Override // androidx.lifecycle.g
    public am.b getDefaultViewModelProviderFactory() {
        am.b r0 = this.f1874a.getDefaultViewModelProviderFactory();
        if (r0.equals(this.f1874a.mDefaultFactory) == true) goto L7;
        this.f1876c = r0;
        return r0;
    L7:
        if (this.f1876c != null) goto L17;
        Application r1 = null;
        Object r2 = ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f1874a.requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L9:
        Context r3 = (Context) r2;
        if (ZeusTransformUtils.instanceOf(r3, ContextWrapper.class) == false) goto L15;
        if (ZeusTransformUtils.instanceOf(r3, Application.class) == true) goto L13;
        r2 = ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r3, ContextWrapper.class, "com.obric.aiagent.plugin")).getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        goto L9
    L13:
        r1 = (Application) ZeusTransformUtils.preCheckCast(r3, Application.class, "com.obric.aiagent.plugin");
    L15:
        this.f1876c = new ag(r1, this, this.f1874a.getArguments());
    L17:
        return this.f1876c;
    }

    @Override // androidx.savedstate.c
    public androidx.savedstate.a getSavedStateRegistry() {
        a();
        return this.f1878e.a();
    }

    void a(Bundle r1) {
        this.f1878e.a(r1);
    }

    void b(Bundle r1) {
        this.f1878e.b(r1);
    }
}
