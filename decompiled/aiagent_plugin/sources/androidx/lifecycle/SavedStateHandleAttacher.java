package androidx.lifecycle;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SavedStateHandleSupport.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleAttacher implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ae f1957a;

    public SavedStateHandleAttacher(ae r2) {
        d.h.b.o.e(r2, "provider");
        this.f1957a = r2;
    }

    @Override // androidx.lifecycle.m
    public void onStateChanged(p r3, i.a r4) {
        p r5 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, DBHelper.BATTERY_COL_SOURCE);
        d.h.b.o.e(r4, "event");
        if (r4 != i.a.ON_CREATE) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        r5.getLifecycle().b((o) ZeusTransformUtils.preCheckCast(this, o.class, "com.obric.aiagent.plugin"));
        this.f1957a.a();
        return;
    L10:
        throw new IllegalStateException(("Next event must be ON_CREATE, it was " + r4).toString());
    L5:
        r0 = false;
        goto L6
    }
}
