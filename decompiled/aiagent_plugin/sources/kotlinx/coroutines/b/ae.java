package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.aq;

/* JADX INFO: compiled from: SharedFlow.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ae extends kotlinx.coroutines.b.a.d<ac<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f38970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d.c.d<? super d.x> f38971b;

    public ae() {
        this.f38970a = -1;
    }

    @Override // kotlinx.coroutines.b.a.d
    public /* synthetic */ boolean a(ac<?> r3) {
        return a2((ac) ZeusTransformUtils.preCheckCast(r3, ac.class, "com.obric.aiagent.plugin"));
    }

    @Override // kotlinx.coroutines.b.a.d
    public /* synthetic */ d.c.d[] b(ac<?> r3) {
        return b2((ac) ZeusTransformUtils.preCheckCast(r3, ac.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(ac<?> r5) {
        if (this.f38970a < 0) goto L6;
        return false;
    L6:
        this.f38970a = r5.e();
        return true;
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    public d.c.d<d.x>[] b2(ac<?> r5) {
        if (aq.a() == true) goto L5;
    L12:
        long r0 = this.f38970a;
        this.f38970a = -1;
        this.f38971b = null;
        return r5.a(r0);
    L5:
        if (this.f38970a < 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L12;
        throw new AssertionError();
    L7:
        r1 = false;
        goto L8
    }
}
