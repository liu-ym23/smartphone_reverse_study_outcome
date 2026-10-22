package com.bytedance.android.gamecp.business.download.installstatus;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$GEO;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class StatusOppoChecker extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f52745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f52746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f52747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f52748f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f52749g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f52750h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f52751i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f52752j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f52753k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f52754l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f52755m;

    public StatusOppoChecker(c r210) {
        Intrinsics.checkNotNullParameter(r210, "listener");
        super(r210);
        this.f52755m = r210;
        this.f52745c = CollectionsKt.listOf(new String[]{"com", ".", "he", "yt", "ap", ".", "mar", "ket"});
        this.f52746d = CollectionsKt.listOf(new String[]{"com", ".", "android", ".", "package", "inst", "aller"});
        this.f52747e = CollectionsKt.listOf(new String[]{"com", ".", "android", ".", "package", "inst", "aller", ".", "opl", EnvConst$GEO.US, ".", "Ins", "tall", "App", "Pro", "gress"});
        this.f52748f = CollectionsKt.listOf(new String[]{"com", ".", "opl", EnvConst$GEO.US, ".", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "pp", "det", "ail"});
        this.f52749g = CollectionsKt.listOf(new String[]{"com", ".", "opl", EnvConst$GEO.US, ".", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "pp", "det", "ail", ".", "model.", "fin", "ish.", "Inst", "all", "Fin", "ish", "Acti", "vity"});
        this.f52750h = LazyKt.lazy(new StatusOppoChecker$storePkg$2(this));
        this.f52751i = LazyKt.lazy(new StatusOppoChecker$installerPkg$2(this));
        this.f52752j = LazyKt.lazy(new StatusOppoChecker$installingPkgAct$2(this));
        this.f52753k = LazyKt.lazy(new StatusOppoChecker$installedPkg$2(this));
        this.f52754l = LazyKt.lazy(new StatusOppoChecker$installedPkgAct$2(this));
    }

    @Override // com.bytedance.android.gamecp.business.download.installstatus.j, com.bytedance.android.gamecp.business.download.installstatus.e
    public final boolean a(a r100, StringBuilder r101, StringBuilder r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "checkInfo");
        Intrinsics.checkNotNullParameter(r101, "stepStayStack");
        Intrinsics.checkNotNullParameter(r102, "stepStayTime");
        if (super.a(r100, r101, r102, r103) == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r100.f52763a, (String) this.f52750h.getValue()) == false) goto L10;
        this.f52755m.a(r101.toString(), r102.toString(), r103);
        return true;
    L10:
        if (Intrinsics.areEqual(r100.f52763a, (String) this.f52751i.getValue()) == false) goto L16;
        if (Intrinsics.areEqual(r100.f52764b, (String) this.f52752j.getValue()) == false) goto L16;
        this.f52755m.e(r101.toString(), r102.toString(), r103);
        return true;
    L16:
        if (Intrinsics.areEqual(r100.f52763a, (String) this.f52753k.getValue()) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(r100.f52764b, (String) this.f52754l.getValue()) == false) goto L23;
        this.f52755m.d(r101.toString(), r102.toString(), r103);
        return true;
    L23:
        return false;
    }
}
