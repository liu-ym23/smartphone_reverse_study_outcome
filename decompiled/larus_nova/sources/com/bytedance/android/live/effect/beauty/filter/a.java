package com.bytedance.android.live.effect.beauty.filter;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements com.bytedance.android.live.effect.beauty.makeups.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveComposerFilterAdapter f67273a;

    @Override // com.bytedance.android.live.effect.beauty.makeups.a.b
    public final void onError() {
    }

    public a(LiveComposerFilterAdapter r100) {
        this.f67273a = r100;
    }

    @Override // com.bytedance.android.live.effect.beauty.makeups.a.b
    public final void a(Sticker r100) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        Iterator r101 = ((ArrayList) this.f67273a.f67221a).iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(((Sticker) r101.next()).getResourceId(), r100.getResourceId()) == true) goto L10;
        r102 = r102 + 1;
    L10:
        int r103 = this.f67273a.getItemCount();
        if (r102 < 0) goto L19;
        if (r103 <= r102) goto L18;
        this.f67273a.notifyItemChanged(r102);
        return;
    L18:
        return;
    L19:
        return;
    L9:
        r102 = -1;
        goto L10
    }
}
