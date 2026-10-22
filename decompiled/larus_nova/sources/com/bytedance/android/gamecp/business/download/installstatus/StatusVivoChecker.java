package com.bytedance.android.gamecp.business.download.installstatus;

import com.amap.api.col.s.ce;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class StatusVivoChecker extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f52756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f52757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f52758e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f52759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f52760g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f52761h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f52762i;

    public StatusVivoChecker(c r110) {
        Intrinsics.checkNotNullParameter(r110, "listener");
        super(r110);
        this.f52762i = r110;
        this.f52756c = CollectionsKt.listOf(new String[]{"com", ".", "b", "b", ce.f26396k, ".", "ap", "pst", "ore"});
        this.f52757d = CollectionsKt.listOf(new String[]{"com", ".", "android", ".", "package", "inst", "aller"});
        this.f52758e = CollectionsKt.listOf(new String[]{"com", ".", "android", ".", "package", "ins", "tal", "ler", ".", "N", "ew", "Ins", "tall", "Inst", "alling"});
        this.f52759f = LazyKt.lazy(new StatusVivoChecker$storePkg$2(this));
        this.f52760g = LazyKt.lazy(new StatusVivoChecker$installerPkg$2(this));
        this.f52761h = LazyKt.lazy(new StatusVivoChecker$installingPkgAct$2(this));
    }

    @Override // com.bytedance.android.gamecp.business.download.installstatus.j, com.bytedance.android.gamecp.business.download.installstatus.e
    public final boolean a(a r100, StringBuilder r101, StringBuilder r102, int r110) {
        Intrinsics.checkNotNullParameter(r100, "checkInfo");
        Intrinsics.checkNotNullParameter(r101, "stepStayStack");
        Intrinsics.checkNotNullParameter(r102, "stepStayTime");
        if (super.a(r100, r101, r102, r110) == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r100.f52763a, (String) this.f52759f.getValue()) == false) goto L14;
        String r103 = r100.f52764b;
        if (r103 == null) goto L14;
        if (StringsKt.startsWith$default(r103, (String) this.f52759f.getValue(), false, 2, null) != true) goto L14;
        this.f52762i.a(r101.toString(), r102.toString(), r110);
        return true;
    L14:
        if (Intrinsics.areEqual(r100.f52763a, (String) this.f52760g.getValue()) == true) goto L16;
    L19:
        return false;
    L16:
        if (Intrinsics.areEqual(r100.f52764b, (String) this.f52761h.getValue()) == false) goto L19;
        this.f52762i.e(r101.toString(), r102.toString(), r110);
        return true;
    }
}
