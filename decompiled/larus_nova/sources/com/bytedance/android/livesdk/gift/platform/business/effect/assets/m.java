package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k.b f129116a;

    public m(k.b r100) {
        this.f129116a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        List<k.a> r101 = (List) r100;
        Iterator<k.a> r102 = r101.iterator();
    L3:
        boolean r103 = true;
    L5:
        if (r102.hasNext() == false) goto L14;
        k.a r104 = r102.next();
        if (r104.f129106c == (-1)) goto L8;
        if (r103 == false) goto L13;
        if (r104.f129108e == true) goto L3;
    L13:
        r103 = false;
        goto L5
    L8:
        this.f129116a.a(r101);
        return;
    L14:
        this.f129116a.b(r103);
        this.f129116a.onResult(r101);
    }
}
