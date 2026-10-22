package com.stepos.ability.manager.reporter;

import N5.b;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.util.Log;
import androidx.core.content.ContextCompat;
import c4.C0878a;
import com.stepos.ability.database.dao.AbilityReportDao;
import com.stepos.ability.net.INet;
import d4.d;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.flow.h;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.r0;
import p9.e;
import s9.C1923c;
import u9.c;
import z2.l;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3149a;
    public final AbilityReportDao b;
    public final INet c;
    public final d d;
    public final C1923c e;
    public final h f;
    public C0878a g;
    public final b h;

    public a(Context context, AbilityReportDao abilityReportDao, INet iNet, d uploadGate) {
        k.f(iNet, "iNet");
        k.f(uploadGate, "uploadGate");
        this.f3149a = context;
        this.b = abilityReportDao;
        this.c = iNet;
        this.d = uploadGate;
        r0 r0VarC = AbstractC1683A.c();
        u9.d dVar = AbstractC1691I.f5315a;
        this.e = AbstractC1683A.b(l.H(r0VarC, c.f6743a));
        this.f = e.b(0, 1, null, 5);
        this.h = new b(this, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:49:0x00fb, B:55:0x012f], limit reached: 71 */
    /* JADX WARN: Path cross not found for [B:55:0x012f, B:49:0x00fb], limit reached: 71 */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fb A[Catch: Exception -> 0x0053, TryCatch #0 {Exception -> 0x0053, blocks: (B:41:0x00c5, B:43:0x00e0, B:46:0x00f5, B:49:0x00fb, B:51:0x0101, B:54:0x0115, B:55:0x012f, B:58:0x0142, B:15:0x004e, B:20:0x005c, B:23:0x0067), top: B:69:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0142 A[Catch: Exception -> 0x0053, TRY_LEAVE, TryCatch #0 {Exception -> 0x0053, blocks: (B:41:0x00c5, B:43:0x00e0, B:46:0x00f5, B:49:0x00fb, B:51:0x0101, B:54:0x0115, B:55:0x012f, B:58:0x0142, B:15:0x004e, B:20:0x005c, B:23:0x0067), top: B:69:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v5, types: [com.stepos.ability.database.entity.AbilityReportTaskEntity] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0192 -> B:63:0x0195). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(com.stepos.ability.manager.reporter.a r16, kotlin.coroutines.jvm.internal.ContinuationImpl r17) {
        /*
            Method dump skipped, instructions count: 452
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.reporter.a.a(com.stepos.ability.manager.reporter.a, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void b() {
        Log.i("AbilityReportProcessor", "start.");
        AbilityReportProcessor$observeManualTrigger$1 abilityReportProcessor$observeManualTrigger$1 = new AbilityReportProcessor$observeManualTrigger$1(this, null);
        C1923c c1923c = this.e;
        AbstractC1683A.n(c1923c, null, abilityReportProcessor$observeManualTrigger$1, 3);
        Context context = this.f3149a;
        Object systemService = context.getSystemService("connectivity");
        k.d(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addTransportType(1).addTransportType(0).addCapability(12).build();
        C0878a c0878a = new C0878a(this);
        this.g = c0878a;
        ((ConnectivityManager) systemService).registerNetworkCallback(networkRequestBuild, c0878a);
        AbstractC1683A.n(c1923c, null, new AbilityReportProcessor$observerLoop$1(this, null), 3);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.stepos.ability.report.ACTION_TRIGGER_UPLOAD");
        ContextCompat.registerReceiver(context, this.h, intentFilter, 4);
    }
}
