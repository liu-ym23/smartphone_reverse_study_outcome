package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import com.bytedance.common.utility.Logger;
import io.reactivex.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes9.dex */
public final class r<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f134010a;

    public r(o r100) {
        this.f134010a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        Iterator<String> r102 = this.f134010a.f134002d.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        String r103 = r102.next();
        StringBuilder r104 = new StringBuilder("self take 2: ");
        q22.a r105 = this.f134010a.f134002d.get(r103);
        if (r105 == null) goto L8;
        String r106 = r105.f531396c;
    L9:
        r104.append(r106);
        Logger.d("GiftDanmakuShooter", r104.toString());
        o r107 = this.f134010a;
        r107.l(r107.f134002d.get(r103));
        goto L4
    L8:
        r106 = null;
        goto L9
    L10:
        this.f134010a.f134002d.clear();
    }
}
