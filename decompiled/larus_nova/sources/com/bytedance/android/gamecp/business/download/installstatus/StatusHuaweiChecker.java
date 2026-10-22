package com.bytedance.android.gamecp.business.download.installstatus;

import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class StatusHuaweiChecker extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f52740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f52741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f52742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f52743f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f52744g;

    public StatusHuaweiChecker(c r110) {
        Intrinsics.checkNotNullParameter(r110, "listener");
        super(r110);
        this.f52744g = r110;
        this.f52740c = CollectionsKt.listOf(new String[]{"com", ".", "hu", "aw", "ei", ".", "ap", "pm", "ark", "et"});
        this.f52741d = CollectionsKt.listOf(new String[]{"com", ".", "hu", "awe", RXScreenCaptureService.KEY_INDEX, ".", "ap", "pgal", "lery", ".", "sea", "rch"});
        this.f52742e = LazyKt.lazy(new StatusHuaweiChecker$storePkg$2(this));
        this.f52743f = LazyKt.lazy(new StatusHuaweiChecker$storePkgAct$2(this));
    }

    @Override // com.bytedance.android.gamecp.business.download.installstatus.j, com.bytedance.android.gamecp.business.download.installstatus.e
    public final boolean a(a r100, StringBuilder r101, StringBuilder r102, int r110) {
        Intrinsics.checkNotNullParameter(r100, "checkInfo");
        Intrinsics.checkNotNullParameter(r101, "stepStayStack");
        Intrinsics.checkNotNullParameter(r102, "stepStayTime");
        if (super.a(r100, r101, r102, r110) == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r100.f52763a, (String) this.f52742e.getValue()) == false) goto L17;
        String r103 = r100.f52764b;
        if (r103 != null) goto L10;
    L11:
        String r104 = r100.f52764b;
        if (r104 == null) goto L17;
        if (StringsKt.startsWith$default(r104, (String) this.f52742e.getValue(), false, 2, null) != true) goto L17;
    L15:
        this.f52744g.a(r101.toString(), r102.toString(), r110);
        return true;
    L10:
        if (StringsKt.startsWith$default(r103, (String) this.f52743f.getValue(), false, 2, null) == true) goto L15;
    L17:
        return false;
    }
}
