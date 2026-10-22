package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f75650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f75651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f75652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f75653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f75654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f75655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final pn0.i f75656g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Triple<Integer, Integer, String> f75657h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Integer> f75658i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Long f75659j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DataCenter f75660k;

    public List<Integer> a() {
        return this.f75658i;
    }

    public h(int r100, int r101, j r102, boolean r103, int r104, boolean r105, pn0.i r106, Triple<Integer, Integer, String> r107, List<Integer> r110, Long r111, DataCenter r112) {
        Intrinsics.checkNotNullParameter(r102, "traceInfo");
        Intrinsics.checkNotNullParameter(r107, "absContainerWHAndReason");
        this.f75650a = r100;
        this.f75651b = r101;
        this.f75652c = r102;
        this.f75653d = r103;
        this.f75654e = r104;
        this.f75655f = r105;
        this.f75656g = r106;
        this.f75657h = r107;
        this.f75658i = r110;
        this.f75659j = r111;
        this.f75660k = r112;
    }

    public /* synthetic */ h(int r110, int r111, j r112, boolean r113, int r210, boolean r211, pn0.i r212, Triple r213, List r214, Long r215, DataCenter r216, int r217) {
        if ((r217 & 2) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r217 & 4) == 0) goto L9;
        j r101 = new j(new StringBuilder());
    L11:
        if ((r217 & 8) == 0) goto L13;
        boolean r102 = true;
    L15:
        if ((r217 & 16) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r217 & 32) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r217 & 64) == 0) goto L25;
        pn0.i r114 = null;
    L27:
        if ((r217 & 256) == 0) goto L29;
        List r115 = null;
    L31:
        if ((r217 & 512) == 0) goto L33;
        Long r116 = null;
    L34:
        this(r110, r100, r101, r102, r103, r104, r114, r213, r115, r116, r216);
        return;
    L33:
        r116 = r215;
        goto L34
    L29:
        r115 = r214;
        goto L31
    L25:
        r114 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
