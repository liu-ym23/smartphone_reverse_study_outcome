package androidx.lifecycle;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SingleGeneratedAdapterObserver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SingleGeneratedAdapterObserver implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f1961a;

    public SingleGeneratedAdapterObserver(f r3) {
        f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "generatedAdapter");
        this.f1961a = r4;
    }

    @Override // androidx.lifecycle.m
    public void onStateChanged(p r4, i.a r5) {
        p r6 = (p) ZeusTransformUtils.wrapperContextForParams(r4, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, DBHelper.BATTERY_COL_SOURCE);
        d.h.b.o.e(r5, "event");
        this.f1961a.a(r6, r5, false, null);
        this.f1961a.a(r6, r5, true, null);
    }
}
