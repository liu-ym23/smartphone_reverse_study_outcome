package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes9.dex */
public final class r<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f127480a;

    public r(n r100) {
        this.f127480a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        n r102 = this.f127480a;
        boolean r103 = true;
        r102.f127463c++;
        h1 r104 = r102.f127461a;
        if (r104 == null) goto L5;
        com.bytedance.android.livesdk.gift.model.l r105 = r104.getComboHint();
    L6:
        if (r105 == null) goto L13;
        int r106 = (r105.curLeftGiftCount - r102.f127463c) + 1;
        Iterator<com.bytedance.android.livesdk.gift.model.m> r107 = r105.dataList.iterator();
    L9:
        if (r107.hasNext() == false) goto L13;
        if (r106 != r107.next().leftGiftCount) goto L9;
    L20:
        if (r103 == false) goto L35;
        Disposable r108 = this.f127480a.f127465e;
        if (r108 == null) goto L24;
        r108.dispose();
    L24:
        Disposable r109 = this.f127480a.f127464d;
        if (r109 == null) goto L27;
        r109.dispose();
    L27:
        this.f127480a.f127465e = Observable.timer(1400, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new o(this), p.f127475a, q.f127479a);
        return;
    L35:
        return;
    L13:
        Iterator<com.bytedance.android.livesdk.gift.platform.core.model.e> r110 = GiftManagerKt.s().iterator();
    L15:
        if (r110.hasNext() == false) goto L19;
        if (r102.f127463c != r110.next().comboCount) goto L15;
    L19:
        r103 = false;
        goto L20
    L5:
        r105 = null;
        goto L6
    }
}
