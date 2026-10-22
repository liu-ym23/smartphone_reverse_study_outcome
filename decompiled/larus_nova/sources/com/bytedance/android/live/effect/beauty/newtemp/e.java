package com.bytedance.android.live.effect.beauty.newtemp;

import com.bytedance.android.live.effect.beauty.smallitem.q;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f67399a;

    @Override // com.bytedance.android.live.effect.beauty.smallitem.q
    public final void onError() {
        q r100 = this.f67399a;
        if (r100 == null) goto L6;
        r100.onError();
        return;
    }

    public e(q r100) {
        this.f67399a = r100;
    }

    @Override // com.bytedance.android.live.effect.beauty.smallitem.q
    public final void a(List<Sticker> r100, List<Integer> r101) {
        Intrinsics.checkNotNullParameter(r100, "stickerList");
        ArrayList r102 = new ArrayList();
        r102.add(Integer.valueOf(r100.size()));
        q r103 = this.f67399a;
        if (r103 == null) goto L6;
        r103.a(r100, r102);
        return;
    }
}
