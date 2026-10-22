package com.bytedance.android.live.effect.avadjust;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class r implements com.bytedance.android.live.effect.api.k.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f66891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveColorAdjustHelper$tryDownloadSticker$1 f66892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l.b f66893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f66894d;

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void Z(String r100, Sticker r101) {
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void O1(String r100, Sticker r101) {
        if (Intrinsics.areEqual("live_adjustment", r100) == false) goto L12;
        if (r101 != null) goto L6;
    L8:
        this.f66892b.invoke2(this.f66893c, r101);
        Iterator<T> r102 = this.f66891a.f66850c.iterator();
    L10:
        if (r102.hasNext() == false) goto L14;
        l.b r103 = (l.b) r102.next();
        this.f66892b.invoke2(r103, r101);
        goto L10
    L14:
        return;
    L6:
        if (this.f66894d == false) goto L8;
        this.f66891a.d(r101);
        goto L8
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void z0(String r100, Sticker r101, ExceptionResult r102) {
        if (Intrinsics.areEqual("live_adjustment", r100) == false) goto L8;
        this.f66892b.invoke2(this.f66893c, null);
        Iterator<T> r103 = this.f66891a.f66850c.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        l.b r104 = (l.b) r103.next();
        this.f66892b.invoke2(r104, null);
        goto L6
    L10:
        return;
    }

    public r(l r100, LiveColorAdjustHelper$tryDownloadSticker$1 r101, l.b r102, boolean r103) {
        this.f66891a = r100;
        this.f66892b = r101;
        this.f66893c = r102;
        this.f66894d = r103;
    }
}
