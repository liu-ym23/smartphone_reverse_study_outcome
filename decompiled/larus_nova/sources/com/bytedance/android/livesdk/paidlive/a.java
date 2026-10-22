package com.bytedance.android.livesdk.paidlive;

import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdkapi.paidlive.IPaidLiveTraceMonitor;
import jc1.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements IPaidLiveTraceMonitor.CategoryGetter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f154254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f154255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f154256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f154257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f154258e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Boolean> f154259f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Boolean> f154260g;

    @Override // com.bytedance.android.livesdkapi.paidlive.IPaidLiveTraceMonitor.CategoryGetter
    public final String getEpisodeId() {
        return "";
    }

    @Override // com.bytedance.android.livesdkapi.paidlive.IPaidLiveTraceMonitor.CategoryGetter
    public final String getUserId() {
        IUserService r100 = (IUserService) k.f(IUserService.class);     // Catch: NullPointerException -> L12
        if (r100 == null) goto L15;
        com.bytedance.android.livesdk.user.f r101 = r100.user();     // Catch: NullPointerException -> L12
        if (r101 == null) goto L16;
        String r102 = r101.n();     // Catch: NullPointerException -> L12
        if (r102 != null) goto L11;
        return "0";
    L11:
        return r102;
    L16:
        return "0";
    L15:
        return "0";
    L18:
        return "0";
    }

    @Override // com.bytedance.android.livesdkapi.paidlive.IPaidLiveTraceMonitor.CategoryGetter
    public final String getWatchPaidliveStatus() {
        if (this.f154259f.invoke().booleanValue() == false) goto L6;
        return "regular";
    L6:
        if (this.f154260g.invoke().booleanValue() == false) goto L8;
        return "try_end";
    L8:
        return "try";
    }

    @Override // com.bytedance.android.livesdkapi.paidlive.IPaidLiveTraceMonitor.CategoryGetter
    public final String getPlayerScene() {
        return this.f154258e;
    }

    @Override // com.bytedance.android.livesdkapi.paidlive.IPaidLiveTraceMonitor.CategoryGetter
    public final String getRoomId() {
        return this.f154257d;
    }

    @Override // com.bytedance.android.livesdkapi.paidlive.IPaidLiveTraceMonitor.CategoryGetter
    public final long getTicketId() {
        return this.f154255b;
    }

    @Override // com.bytedance.android.livesdkapi.paidlive.IPaidLiveTraceMonitor.CategoryGetter
    public final String isPaidlive() {
        return this.f154254a;
    }

    @Override // com.bytedance.android.livesdkapi.paidlive.IPaidLiveTraceMonitor.CategoryGetter
    public final String isVs() {
        return this.f154256c;
    }

    public a(Function0<Boolean> r100, Function0<Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "hasRight");
        Intrinsics.checkNotNullParameter(r101, "tempWatchEnd");
        this.f154259f = r100;
        this.f154260g = r101;
        this.f154254a = "1";
        this.f154256c = "false";
        this.f154257d = "-1";
        this.f154258e = "";
    }
}
