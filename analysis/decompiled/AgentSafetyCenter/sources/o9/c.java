package o9;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import e9.m;
import h0.b0;
import h0.b1;
import h0.r0;
import h0.u1;
import h0.v1;
import h0.y;
import h0.z;
import java.lang.invoke.VarHandle;
import k0.s;
import s0.h;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final z f9340a = b0.c(a.f9331a, 0, 0, 0, 0, a.f9332b, 0, 0, 0, a.f9333c, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -546, 15);

    /* renamed from: b, reason: collision with root package name */
    public static final z f9341b = b0.f(a.f9334d, 0, 0, 0, 0, a.f9335e, 0, 0, 0, a.f9336f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -546, 15);

    public static final void a(boolean z10, boolean z11, s0.c cVar, s sVar, int i) {
        boolean z12;
        boolean z13;
        z zVarF;
        s sVar2 = sVar;
        sVar2.Z(1889963721);
        int i3 = i | 50;
        if (sVar2.P(i3 & 1, (i3 & 147) != 146)) {
            sVar2.U();
            if ((i & 1) == 0 || sVar2.z()) {
                z12 = (((Configuration) sVar2.j(AndroidCompositionLocals_androidKt.f981a)).uiMode & 48) == 32;
                z13 = true;
            } else {
                sVar2.S();
                z12 = z10;
                z13 = z11;
            }
            sVar2.r();
            if (z13) {
                sVar2.X(1183245342);
                Context context = (Context) sVar2.j(AndroidCompositionLocals_androidKt.f982b);
                y yVar = y.f5242a;
                if (z12) {
                    if (Build.VERSION.SDK_INT >= 34) {
                        zVarF = b0.c(yVar.a(context, R.color.system_primary_dark), yVar.a(context, R.color.system_on_primary_dark), yVar.a(context, R.color.system_primary_container_dark), yVar.a(context, R.color.system_on_primary_container_dark), yVar.a(context, R.color.system_primary_light), yVar.a(context, R.color.system_secondary_dark), yVar.a(context, R.color.system_on_secondary_dark), yVar.a(context, R.color.system_secondary_container_dark), yVar.a(context, R.color.system_on_secondary_container_dark), yVar.a(context, R.color.system_tertiary_dark), yVar.a(context, R.color.system_on_tertiary_dark), yVar.a(context, R.color.system_tertiary_container_dark), yVar.a(context, R.color.system_on_tertiary_container_dark), yVar.a(context, R.color.system_background_dark), yVar.a(context, R.color.system_on_background_dark), yVar.a(context, R.color.system_surface_dark), yVar.a(context, R.color.system_on_surface_dark), yVar.a(context, R.color.system_surface_variant_dark), yVar.a(context, R.color.system_on_surface_variant_dark), yVar.a(context, R.color.system_primary_dark), yVar.a(context, R.color.system_surface_light), yVar.a(context, R.color.system_on_surface_light), yVar.a(context, R.color.system_outline_dark), yVar.a(context, R.color.system_outline_variant_dark), 0L, yVar.a(context, R.color.system_surface_bright_dark), yVar.a(context, R.color.system_surface_container_dark), yVar.a(context, R.color.system_surface_container_high_dark), yVar.a(context, R.color.system_surface_container_highest_dark), yVar.a(context, R.color.system_surface_container_low_dark), yVar.a(context, R.color.system_surface_container_lowest_dark), yVar.a(context, R.color.system_surface_dim_dark), 331350016, 0);
                    } else {
                        u1 u1VarF = b1.f(context);
                        long j10 = u1VarF.f5198x;
                        long j11 = u1VarF.A;
                        long j12 = u1VarF.f5200z;
                        long j13 = u1VarF.f5197w;
                        long j14 = u1VarF.f5199y;
                        long j15 = u1VarF.E;
                        long j16 = u1VarF.H;
                        long j17 = u1VarF.G;
                        long j18 = u1VarF.D;
                        long j19 = u1VarF.L;
                        long j20 = u1VarF.O;
                        long j21 = u1VarF.N;
                        long j22 = u1VarF.K;
                        long j23 = u1VarF.f5193s;
                        long j24 = u1VarF.f5182g;
                        long j25 = u1VarF.f5186l;
                        zVarF = b0.c(j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j23, j24, j25, u1VarF.i, j10, j24, u1VarF.f5189o, u1VarF.f5184j, j25, u1VarF.f5195u, u1VarF.f5187m, u1VarF.f5191q, u1VarF.f5190p, u1VarF.f5188n, u1VarF.f5192r, u1VarF.f5194t, j23, 62914560, 0);
                    }
                } else if (Build.VERSION.SDK_INT >= 34) {
                    zVarF = b0.f(yVar.a(context, R.color.system_primary_light), yVar.a(context, R.color.system_on_primary_light), yVar.a(context, R.color.system_primary_container_light), yVar.a(context, R.color.system_on_primary_container_light), yVar.a(context, R.color.system_primary_dark), yVar.a(context, R.color.system_secondary_light), yVar.a(context, R.color.system_on_secondary_light), yVar.a(context, R.color.system_secondary_container_light), yVar.a(context, R.color.system_on_secondary_container_light), yVar.a(context, R.color.system_tertiary_light), yVar.a(context, R.color.system_on_tertiary_light), yVar.a(context, R.color.system_tertiary_container_light), yVar.a(context, R.color.system_on_tertiary_container_light), yVar.a(context, R.color.system_background_light), yVar.a(context, R.color.system_on_background_light), yVar.a(context, R.color.system_surface_light), yVar.a(context, R.color.system_on_surface_light), yVar.a(context, R.color.system_surface_variant_light), yVar.a(context, R.color.system_on_surface_variant_light), yVar.a(context, R.color.system_primary_light), yVar.a(context, R.color.system_surface_dark), yVar.a(context, R.color.system_on_surface_dark), yVar.a(context, R.color.system_outline_light), yVar.a(context, R.color.system_outline_variant_light), 0L, yVar.a(context, R.color.system_surface_bright_light), yVar.a(context, R.color.system_surface_container_light), yVar.a(context, R.color.system_surface_container_high_light), yVar.a(context, R.color.system_surface_container_highest_light), yVar.a(context, R.color.system_surface_container_low_light), yVar.a(context, R.color.system_surface_container_lowest_light), yVar.a(context, R.color.system_surface_dim_light), 331350016, 0);
                } else {
                    u1 u1VarF2 = b1.f(context);
                    long j26 = u1VarF2.f5199y;
                    long j27 = u1VarF2.f5196v;
                    long j28 = u1VarF2.f5197w;
                    long j29 = u1VarF2.B;
                    long j30 = u1VarF2.f5198x;
                    long j31 = u1VarF2.F;
                    long j32 = u1VarF2.C;
                    long j33 = u1VarF2.D;
                    long j34 = u1VarF2.I;
                    long j35 = u1VarF2.M;
                    long j36 = u1VarF2.J;
                    long j37 = u1VarF2.K;
                    long j38 = u1VarF2.P;
                    long j39 = u1VarF2.f5177b;
                    long j40 = u1VarF2.f5192r;
                    long j41 = u1VarF2.f5182g;
                    zVarF = b0.f(j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36, j37, j38, j39, j40, j39, j40, j41, u1VarF2.f5186l, j26, u1VarF2.f5189o, u1VarF2.f5179d, u1VarF2.f5185k, u1VarF2.i, u1VarF2.f5195u, j39, u1VarF2.f5180e, u1VarF2.f5181f, j41, u1VarF2.f5178c, u1VarF2.f5176a, u1VarF2.f5183h, 62914560, 0);
                }
                sVar2 = sVar;
                sVar2.q(false);
            } else if (z12) {
                sVar2.X(-516014568);
                sVar2.q(false);
                zVarF = f9340a;
            } else {
                sVar2.X(-516013543);
                sVar2.q(false);
                zVarF = f9341b;
            }
            v1 v1Var = d.f9342a;
            m mVar = new m(8);
            mVar.f3688f = cVar;
            VarHandle.storeStoreFence();
            r0.a(zVarF, null, v1Var, h.d(-478167395, mVar, sVar2), sVar2, 3456);
        } else {
            sVar.S();
            z12 = z10;
            z13 = z11;
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            b bVar = new b();
            bVar.f9337c = z12;
            bVar.f9338f = z13;
            bVar.f9339g = cVar;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = bVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(int r3, k0.s r4) {
        /*
            r0 = 413497497(0x18a57899, float:4.2773273E-24)
            r4.Z(r0)
            r0 = 1
            r1 = 0
            if (r3 == 0) goto Lc
            r2 = r0
            goto Ld
        Lc:
            r2 = r1
        Ld:
            r3 = r3 & r0
            boolean r3 = r4.P(r3, r2)
            if (r3 == 0) goto L5a
            k0.s2 r3 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.f986f
            java.lang.Object r3 = r4.j(r3)
            android.view.View r3 = (android.view.View) r3
            k0.e0 r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.f981a
            r4.j(r0)
            boolean r0 = r3.isInEditMode()
            if (r0 != 0) goto L53
            r0 = 537886859(0x200f808b, float:1.2155102E-19)
            r4.X(r0)
            boolean r0 = r4.h(r3)
            java.lang.Object r2 = r4.M()
            if (r0 != 0) goto L3b
            k0.y0 r0 = k0.m.f6974a
            if (r2 != r0) goto L4a
        L3b:
            ab.e r2 = new ab.e
            r0 = 12
            r2.<init>(r0)
            r2.f393f = r3
            java.lang.invoke.VarHandle.storeStoreFence()
            r4.i0(r2)
        L4a:
            xb.a r2 = (xb.a) r2
            k0.z.j(r2, r4)
        L4f:
            r4.q(r1)
            goto L5d
        L53:
            r3 = 536408841(0x1ff8f309, float:1.05434153E-19)
            r4.X(r3)
            goto L4f
        L5a:
            r4.S()
        L5d:
            k0.v1 r3 = r4.s()
            if (r3 == 0) goto L6f
            k8.d r4 = new k8.d
            r0 = 8
            r4.<init>(r0)
            java.lang.invoke.VarHandle.storeStoreFence()
            r3.f7091d = r4
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o9.c.b(int, k0.s):void");
    }
}
