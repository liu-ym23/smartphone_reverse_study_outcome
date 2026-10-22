package androidx.lifecycle;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CompositeGeneratedAdaptersObserver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CompositeGeneratedAdaptersObserver implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f[] f1917a;

    public CompositeGeneratedAdaptersObserver(f[] r2) {
        d.h.b.o.e(r2, "generatedAdapters");
        this.f1917a = r2;
    }

    @Override // androidx.lifecycle.m
    public void onStateChanged(p r7, i.a r8) {
        p r9 = (p) ZeusTransformUtils.wrapperContextForParams(r7, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, DBHelper.BATTERY_COL_SOURCE);
        d.h.b.o.e(r8, "event");
        u r0 = new u();
        f[] r1 = this.f1917a;
        int r2 = r1.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        r1[r4].a(r9, r8, false, r0);
        r4 = r4 + 1;
        goto L3
    L5:
        f[] r6 = this.f1917a;
        int r5 = r6.length;
    L6:
        if (r3 >= r5) goto L8;
        r6[r3].a(r9, r8, true, r0);
        r3 = r3 + 1;
        goto L6
    }
}
