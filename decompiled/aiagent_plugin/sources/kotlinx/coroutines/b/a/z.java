package kotlinx.coroutines.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.b.ac;
import kotlinx.coroutines.b.ak;

/* JADX INFO: compiled from: AbstractSharedFlow.kt */
/* JADX INFO: loaded from: classes4.dex */
final class z extends ac<Integer> implements ak<Integer> {
    @Override // kotlinx.coroutines.b.ak
    public /* synthetic */ Integer c() {
        return k();
    }

    public z(int r4) {
        super(1, Integer.MAX_VALUE, kotlinx.coroutines.a.a.f38772b);
        a(Integer.valueOf(r4));
    }

    public Integer k() {
        monitor-enter(this);
        Integer r0 = Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(d(), Number.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final boolean c(int r4) {
        monitor-enter(this);
        boolean r5 = a(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(d(), Number.class, "com.obric.aiagent.plugin")).intValue() + r4));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }
}
