package com.bytedance.android.live.effect.beauty.filter;

import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.api.k;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.StringUtils;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import java.util.Iterator;

/* JADX INFO: loaded from: classes45.dex */
public final class i implements k.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveComposerFilterHelper f67288a;

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void Z(String r100, Sticker r101) {
    }

    public i(LiveComposerFilterHelper r100) {
        this.f67288a = r100;
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void O1(String r100, Sticker r101) {
        if (StringUtils.equal(d0.f66751a, r100) == false) goto L13;
        if (r101 != null) goto L9;
        Iterator<T> r102 = this.f67288a.f67271c.iterator();
    L7:
        if (r102.hasNext() == false) goto L16;
        ((com.bytedance.android.live.effect.beauty.makeups.a.b) r102.next()).onError();
        goto L7
    L16:
        return;
    L9:
        Iterator<T> r103 = this.f67288a.f67271c.iterator();
    L11:
        if (r103.hasNext() == false) goto L17;
        ((com.bytedance.android.live.effect.beauty.makeups.a.b) r103.next()).a(r101);
        goto L11
    L17:
        return;
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void z0(String r100, Sticker r101, ExceptionResult r102) {
        if (StringUtils.equal(d0.f66751a, r100) == false) goto L8;
        Iterator<T> r103 = this.f67288a.f67271c.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        ((com.bytedance.android.live.effect.beauty.makeups.a.b) r103.next()).onError();
        goto L6
    L10:
        return;
    }
}
