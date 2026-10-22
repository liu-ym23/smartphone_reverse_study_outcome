package e9;

import com.stepos.agentsafetycenter.R;
import h0.t1;
import s8.p3;
import w.s0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements xb.q {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3611c;

    public /* synthetic */ a(int i) {
        this.f3611c = i;
    }

    @Override // xb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i = this.f3611c;
        w0.j jVar = w0.j.f15113c;
        jb.v vVar = jb.v.f6774a;
        switch (i) {
            case 0:
                k0.s sVar = (k0.s) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((x.b) obj).getClass();
                if (!sVar.P(iIntValue & 1, (iIntValue & 17) != 16)) {
                    sVar.S();
                    break;
                } else {
                    t0.a.b(sVar, androidx.compose.foundation.layout.c.c(t2.a.l(jVar), 8));
                    break;
                }
            case 1:
                k0.s sVar2 = (k0.s) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((x.b) obj).getClass();
                if (!sVar2.P(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    sVar2.S();
                    break;
                } else {
                    t0.a.b(sVar2, androidx.compose.foundation.layout.c.c(t2.a.l(jVar), 8));
                    break;
                }
            case 2:
                k0.s sVar3 = (k0.s) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((s0) obj).getClass();
                if (!sVar3.P(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    sVar3.S();
                    break;
                } else {
                    t1.b(t2.a.o(R.string.screen_perception_remove_cancel, sVar3), null, j9.b0.f6638f, com.stepos.statsrpk.h.t(17), null, 0L, null, 0L, 0, false, 0, 0, null, sVar3, 3456, 0, 131058);
                    break;
                }
            case 3:
                k0.s sVar4 = (k0.s) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((s0) obj).getClass();
                if (!sVar4.P(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    sVar4.S();
                    break;
                } else {
                    t1.b(t2.a.o(R.string.screen_perception_remove_confirm, sVar4), null, j9.b0.f6638f, com.stepos.statsrpk.h.t(17), g2.k.f4253h, 0L, null, 0L, 0, false, 0, 0, null, sVar4, 200064, 0, 131026);
                    break;
                }
            case 4:
                k0.s sVar5 = (k0.s) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((s0) obj).getClass();
                if (!sVar5.P(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    sVar5.S();
                    break;
                } else {
                    t1.b(t2.a.o(R.string.installed_apps_consent_allow, sVar5), null, 0L, 0L, null, 0L, null, 0L, 0, false, 0, 0, null, sVar5, 0, 0, 131070);
                    break;
                }
            case 5:
                k0.s sVar6 = (k0.s) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((s0) obj).getClass();
                if (!sVar6.P(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    sVar6.S();
                    break;
                } else {
                    t1.b(t2.a.o(R.string.installed_apps_consent_deny, sVar6), null, 0L, 0L, null, 0L, null, 0L, 0, false, 0, 0, null, sVar6, 0, 0, 131070);
                    break;
                }
            case 6:
                k0.s sVar7 = (k0.s) obj2;
                int iIntValue7 = ((Integer) obj3).intValue();
                ((s0) obj).getClass();
                if (!sVar7.P(iIntValue7 & 1, (iIntValue7 & 17) != 16)) {
                    sVar7.S();
                    break;
                } else {
                    t1.b(t2.a.o(R.string.installed_apps_permission_go_settings, sVar7), null, 0L, 0L, null, 0L, null, 0L, 0, false, 0, 0, null, sVar7, 0, 0, 131070);
                    break;
                }
            case 7:
                k0.s sVar8 = (k0.s) obj2;
                int iIntValue8 = ((Integer) obj3).intValue();
                ((s0) obj).getClass();
                if (!sVar8.P(iIntValue8 & 1, (iIntValue8 & 17) != 16)) {
                    sVar8.S();
                    break;
                } else {
                    t1.b(t2.a.o(R.string.perm_dialog_cancel, sVar8), null, 0L, 0L, null, 0L, null, 0L, 0, false, 0, 0, null, sVar8, 0, 0, 131070);
                    break;
                }
            case 8:
                ((Integer) obj3).intValue();
                ((p3) obj).getClass();
                break;
            default:
                k0.s sVar9 = (k0.s) obj2;
                int iIntValue9 = ((Integer) obj3).intValue();
                ((x.b) obj).getClass();
                if (!sVar9.P(iIntValue9 & 1, (iIntValue9 & 17) != 16)) {
                    sVar9.S();
                    break;
                } else {
                    t0.a.b(sVar9, androidx.compose.foundation.layout.c.c(jVar, 4));
                    break;
                }
        }
        return vVar;
    }
}
