package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Builders.common.kt */
/* JADX INFO: loaded from: classes4.dex */
class cv extends a<d.x> {
    public cv(d.c.g r3, boolean r4) {
        super((d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin"), true, r4);
    }

    @Override // kotlinx.coroutines.ci
    public boolean f(Throwable r1) {
        aj.a(getContext(), r1);
        return true;
    }
}
