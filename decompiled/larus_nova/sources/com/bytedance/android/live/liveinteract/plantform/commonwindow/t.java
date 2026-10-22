package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class t extends h {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<Integer> f75872l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<Integer> f75873m;

    public t() {
        throw null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.h
    public final List<Integer> a() {
        return this.f75873m;
    }

    public t(int r110, List r111, int r112, boolean r113, int r210, boolean r211, pn0.i r212, Triple r213, List r214, DataCenter r215, int r216) {
        if ((r216 & 4) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r216 & 8) == 0) goto L9;
        j r101 = new j(new StringBuilder());
    L11:
        if ((r216 & 16) == 0) goto L13;
        boolean r102 = true;
    L15:
        if ((r216 & 64) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r216 & 128) == 0) goto L21;
        pn0.i r104 = null;
    L23:
        if ((r216 & 512) == 0) goto L25;
        List r114 = null;
    L26:
        Intrinsics.checkNotNullParameter(r101, "traceInfo");
        Intrinsics.checkNotNullParameter(r213, "mAbsContainerWHAndReason");
        super(r110, r100, r101, r102, r210, r103, r104, r213, r114, null, r215, 512);
        this.f75872l = r111;
        this.f75873m = r114;
        return;
    L25:
        r114 = r214;
        goto L26
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
