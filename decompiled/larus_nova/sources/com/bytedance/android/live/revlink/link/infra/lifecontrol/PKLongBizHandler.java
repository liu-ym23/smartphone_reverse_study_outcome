package com.bytedance.android.live.revlink.link.infra.lifecontrol;

import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.livesdk.link.model.a5;
import com.bytedance.android.livesdk.message.model.ek;
import com.bytedance.android.livesdk.revenue.service.message.d;
import com.bytedance.android.livesdk.revenue.service.room.c;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import yh6.b;
import yz0.f;
import yz0.h;

/* JADX INFO: loaded from: classes47.dex */
public final class PKLongBizHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f98610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f98611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f98612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f98613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f98614e;

    public final void a() {
        f r100 = this.f98612c;
        com.bytedance.android.live.revenue.common.message.a r101 = com.bytedance.android.live.revenue.common.message.a.f90883g;
        Lazy r102 = CommonMessageTypeKt.f90851a;
        Intrinsics.checkNotNullParameter(r101, "$this$LINK_MIC_BATTLE_FINISH");
        Observable r103 = h.a.a(r100, (b) CommonMessageTypeKt.f90859h.getValue(), false, 6);
        final PKLongBizHandler$attach$1 r104 = new PKLongBizHandler$attach$1(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r103.subscribe(new a(r104)), this.f98610a);
    }

    public final void b(a5 r100) {
        String r101 = r100.getCutShortPrompt();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L24;
        IRoomBase r103 = this.f98614e.getRoomContext().getCommonRoom();
        String r104 = null;
        if ((r103 instanceof IRoom) == true) goto L13;
        r103 = null;
    L13:
        IRoom r105 = (IRoom) r103;
        if (r105 == null) goto L16;
        r104 = r105.getIdStr();
    L16:
        d r106 = this.f98613d;
        if (r106 == null) goto L25;
        if (r104 != null) goto L20;
        r104 = "";
    L20:
        ek r107 = r106.u4(r104, r100.getCutShortPrompt());
        if (r107 == null) goto L26;
        this.f98612c.insert(r107, true);
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public PKLongBizHandler(boolean r100, f r101, d r102, c r103) {
        Intrinsics.checkNotNullParameter(r101, "messageService");
        Intrinsics.checkNotNullParameter(r103, "roomService");
        this.f98611b = r100;
        this.f98612c = r101;
        this.f98613d = r102;
        this.f98614e = r103;
        this.f98610a = new CompositeDisposable();
    }
}
