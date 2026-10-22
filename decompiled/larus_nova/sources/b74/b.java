package b74;

import com.bytedance.badger.network.a0;
import com.bytedance.badger.network.b0;
import com.bytedance.badger.network.l0;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements Function6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f17945a;

    public b(c r100) {
        this.f17945a = r100;
    }

    @Override // kotlin.jvm.functions.Function6
    public final Object invoke(Object r100, Object r101, Object r102, Object r103, Object r104, Object r105) {
        ((Boolean) r100).booleanValue();
        String r106 = (String) r101;
        a0 r107 = (a0) r102;
        b0 r108 = (b0) r103;
        l0 r109 = (l0) r104;
        com.bytedance.badger.C.a r110 = (com.bytedance.badger.C.a) r105;
        Object r111 = e.f17950d;
        monitor-enter(r111);
        this.f17945a.f17946a.f17939b = false;     // Catch: Throwable -> L15
        if (e.a(r108) != 0) goto L11;
        this.f17945a.f17946a.f17938a = true;     // Catch: Throwable -> L15
        com.bytedance.badger.e.f("CompensationManager", "onCompensate# success!, cause=" + this.f17945a.f17946a.f17943f);     // Catch: Throwable -> L15
    L12:
        monitor-exit(r111);
        return Unit.INSTANCE;
    L11:
        com.bytedance.badger.e.g("CompensationManager", "onCompensate# failed, will retry on next eligible event: cause=" + this.f17945a.f17946a.f17943f);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }
}
