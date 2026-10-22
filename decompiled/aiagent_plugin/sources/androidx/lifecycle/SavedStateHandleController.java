package androidx.lifecycle;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SavedStateHandleController.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleController implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ac f1959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1960c;

    public SavedStateHandleController(String r2, ac r3) {
        d.h.b.o.e(r2, "key");
        d.h.b.o.e(r3, "handle");
        this.f1958a = r2;
        this.f1959b = r3;
    }

    public final ac a() {
        return this.f1959b;
    }

    public final boolean b() {
        return this.f1960c;
    }

    public final void a(androidx.savedstate.a r3, i r4) {
        d.h.b.o.e(r3, "registry");
        d.h.b.o.e(r4, "lifecycle");
        if ((!this.f1960c) == false) goto L7;
        this.f1960c = true;
        r4.a((o) ZeusTransformUtils.preCheckCast(this, o.class, "com.obric.aiagent.plugin"));
        r3.a(this.f1958a, this.f1959b.a());
        return;
    L7:
        throw new IllegalStateException("Already attached to lifecycleOwner".toString());
    }

    @Override // androidx.lifecycle.m
    public void onStateChanged(p r3, i.a r4) {
        p r5 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, DBHelper.BATTERY_COL_SOURCE);
        d.h.b.o.e(r4, "event");
        if (r4 != i.a.ON_DESTROY) goto L6;
        this.f1960c = false;
        r5.getLifecycle().b((o) ZeusTransformUtils.preCheckCast(this, o.class, "com.obric.aiagent.plugin"));
        return;
    }
}
