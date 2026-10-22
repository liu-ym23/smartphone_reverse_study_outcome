package b74;

import com.bytedance.badger.monitor.TriggerStage;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.TypeCastException;
import x64.l;
import z64.f;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f17946a;

    public c(a r100) {
        this.f17946a = r100;
    }

    public final void a() {
        z64.c r100 = this.f17946a.f17940c;     // Catch: Exception -> L11
        if ((r100 instanceof f) == false) goto L8;
        if (r100 == null) goto L7;
        f r101 = (f) r100;     // Catch: Exception -> L11
        String r102 = r101.f570469e;     // Catch: Exception -> L11
        String r103 = r101.f570470f;     // Catch: Exception -> L11
        String r104 = r102;
    L9:
        com.bytedance.badger.C.b r105 = x64.b.f562608a;     // Catch: Exception -> L11
        x64.b.a(new l(TriggerStage.manual, r100.getSceneId(), false, com.bytedance.badger.C.a.f199019c, r104, r103), new b(this));     // Catch: Exception -> L11
        return;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.badger.data.LoginBadgerRequest");     // Catch: Exception -> L11
    L8:
        r104 = "";
        r103 = r104;
    L11:
        e = move-exception;
        com.bytedance.badger.e.c("CompensationManager", "attemptCompensationIfNeeded# error", e);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
