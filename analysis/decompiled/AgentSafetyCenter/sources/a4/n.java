package a4;

import android.content.Context;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n implements i {

    /* renamed from: a, reason: collision with root package name */
    public Context f190a;

    public static n c(Context context) {
        n nVar = new n();
        nVar.f190a = context;
        return nVar;
    }

    @Override // a4.i
    public void a(id.k kVar) {
        ThreadPoolExecutor threadPoolExecutorU = h5.t.u("EmojiCompatInitializer");
        l lVar = new l(0);
        lVar.f185f = this;
        lVar.f186g = kVar;
        lVar.f187h = threadPoolExecutorU;
        VarHandle.storeStoreFence();
        threadPoolExecutorU.execute(lVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(pb.c r6) throws java.lang.Throwable {
        /*
            r5 = this;
            android.content.Context r0 = r5.f190a
            boolean r1 = r6 instanceof g9.m
            if (r1 == 0) goto L15
            r1 = r6
            g9.m r1 = (g9.m) r1
            int r2 = r1.f4527g
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f4527g = r2
            goto L1a
        L15:
            g9.m r1 = new g9.m
            r1.<init>(r5, r6)
        L1a:
            java.lang.Object r5 = r1.f4525c
            ob.a r6 = ob.a.f9351c
            int r2 = r1.f4527g
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2d
            id.c.I(r5)
            jb.i r5 = (jb.i) r5
            java.lang.Object r5 = r5.f6762c
            goto L4a
        L2d:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r5)
            r5 = 0
            return r5
        L34:
            id.c.I(r5)
            g9.s r5 = g9.p0.f4573h
            g9.p0 r5 = r5.b(r0)
            java.lang.String r0 = g9.x0.b(r0)
            r1.f4527g = r3
            java.lang.Object r5 = r5.c(r0, r1)
            if (r5 != r6) goto L4a
            return r6
        L4a:
            id.c.I(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.n.b(pb.c):java.lang.Object");
    }

    public int d() {
        return this.f190a.getResources().getDimensionPixelSize(R.dimen.stepos_action_mode_split_padding);
    }
}
