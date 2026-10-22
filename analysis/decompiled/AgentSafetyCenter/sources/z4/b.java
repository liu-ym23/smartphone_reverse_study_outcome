package z4;

import android.content.Context;
import java.lang.invoke.VarHandle;
import jb.k;
import n3.r0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements y4.b {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0028, code lost:
    
        if (r1.equals("undo_eligible") == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
    
        if (r1.equals("revoked") == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        if (r1.equals("eligible") == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
    
        return z8.g.f16511g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0046, code lost:
    
        if (r1.equals("undo_revoked") == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
    
        return z8.g.i;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static z8.g b(java.lang.String r1) {
        /*
            boolean r0 = hc.h.g0(r1)
            if (r0 == 0) goto L9
            z8.g r1 = z8.g.f16510f
            return r1
        L9:
            java.lang.CharSequence r1 = hc.h.w0(r1)
            java.lang.String r1 = r1.toString()
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r1 = r1.toLowerCase(r0)
            r1.getClass()
            int r0 = r1.hashCode()
            switch(r0) {
                case -1309235419: goto L58;
                case 3387192: goto L4c;
                case 49552963: goto L40;
                case 100743639: goto L34;
                case 1100137118: goto L2b;
                case 1892373202: goto L22;
                default: goto L21;
            }
        L21:
            goto L60
        L22:
            java.lang.String r0 = "undo_eligible"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L3d
            goto L60
        L2b:
            java.lang.String r0 = "revoked"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L49
            goto L60
        L34:
            java.lang.String r0 = "eligible"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L3d
            goto L60
        L3d:
            z8.g r1 = z8.g.f16511g
            return r1
        L40:
            java.lang.String r0 = "undo_revoked"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L49
            goto L60
        L49:
            z8.g r1 = z8.g.i
            return r1
        L4c:
            java.lang.String r0 = "none"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L55
            goto L60
        L55:
            z8.g r1 = z8.g.f16510f
            return r1
        L58:
            java.lang.String r0 = "expired"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L63
        L60:
            z8.g r1 = z8.g.f16510f
            return r1
        L63:
            z8.g r1 = z8.g.f16512h
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: z4.b.b(java.lang.String):z8.g");
    }

    @Override // y4.b
    public y4.c a(y4.a aVar) {
        Context context = aVar.f15893a;
        String str = aVar.f15894b;
        r0 r0Var = aVar.f15895c;
        boolean z10 = aVar.f15896d;
        boolean z11 = aVar.f15897e;
        context.getClass();
        r0Var.getClass();
        h hVar = new h();
        hVar.f16402c = context;
        hVar.f16403f = str;
        hVar.f16404g = r0Var;
        hVar.f16405h = z10;
        hVar.i = z11;
        ab.e eVar = new ab.e(24);
        eVar.f393f = hVar;
        VarHandle.storeStoreFence();
        hVar.f16406j = new k(eVar);
        VarHandle.storeStoreFence();
        return hVar;
    }
}
