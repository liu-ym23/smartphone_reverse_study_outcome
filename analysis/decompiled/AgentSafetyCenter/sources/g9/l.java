package g9;

import android.os.Bundle;
import com.stepos.agentsafetycenter.permission.AgentPermissionProvider;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public int f4515c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f4516f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ AgentPermissionProvider f4517g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f4518h;
    public final /* synthetic */ Bundle i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(String str, AgentPermissionProvider agentPermissionProvider, boolean z10, Bundle bundle, nb.c cVar) {
        super(2, cVar);
        this.f4516f = str;
        this.f4517g = agentPermissionProvider;
        this.f4518h = z10;
        this.i = bundle;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        return new l(this.f4516f, this.f4517g, this.f4518h, this.i, cVar);
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((l) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
    
        if (r10 == r0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005a, code lost:
    
        if (r10 == r0) goto L25;
     */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            ob.a r0 = ob.a.f9351c
            int r1 = r9.f4515c
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1b
            if (r1 == r3) goto L17
            if (r1 != r2) goto L10
            id.c.I(r10)
            goto L5d
        L10:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r9)
            r9 = 0
            return r9
        L17:
            id.c.I(r10)
            goto L39
        L1b:
            id.c.I(r10)
            java.lang.String r10 = "getSnapshot"
            java.lang.String r1 = r9.f4516f
            boolean r10 = r1.equals(r10)
            boolean r4 = r9.f4518h
            com.stepos.agentsafetycenter.permission.AgentPermissionProvider r5 = r9.f4517g
            if (r10 == 0) goto L3c
            ad.z r10 = com.stepos.agentsafetycenter.permission.AgentPermissionProvider.a(r5)
            r9.f4515c = r3
            java.lang.Object r10 = r10.m(r4, r9)
            if (r10 != r0) goto L39
            goto L5c
        L39:
            g9.j r10 = (g9.j) r10
            return r10
        L3c:
            java.lang.String r10 = "getGroup"
            boolean r10 = r1.equals(r10)
            if (r10 == 0) goto L60
            android.os.Bundle r10 = r9.i
            if (r10 == 0) goto L4f
            java.lang.String r1 = "group_id"
            java.lang.String r10 = r10.getString(r1)
            goto L50
        L4f:
            r10 = 0
        L50:
            ad.z r1 = com.stepos.agentsafetycenter.permission.AgentPermissionProvider.a(r5)
            r9.f4515c = r2
            java.lang.Object r10 = r1.k(r10, r4, r9)
            if (r10 != r0) goto L5d
        L5c:
            return r0
        L5d:
            g9.j r10 = (g9.j) r10
            return r10
        L60:
            g9.j r0 = new g9.j
            java.lang.String r9 = "unknown method="
            java.lang.String r2 = r9.concat(r1)
            r7 = 0
            r8 = 124(0x7c, float:1.74E-43)
            r1 = 3
            r3 = 0
            r5 = 0
            r6 = 0
            r0.<init>(r1, r2, r3, r5, r6, r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.l.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
