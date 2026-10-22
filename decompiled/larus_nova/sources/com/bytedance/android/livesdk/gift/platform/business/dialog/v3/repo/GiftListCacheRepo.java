package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.google.gson.Gson;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftListCacheRepo implements com.bytedance.android.scope.o, dy0.c, xc6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f128281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f128282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<Integer> f128283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f128284d;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public final void f() {
        GiftManagerKt.f130762z.getClass();
        if (GiftManagerKt.A() == false) goto L6;
        return;
    L6:
        if (com.bytedance.android.livesdk.gift.platform.core.h.h().d() != 2) goto L12;
        if (this.f128282b == true) goto L20;
        this.f128282b = true;
        Single.create(new f(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this), new h(this));
        return;
    L20:
        return;
    L12:
        if (com.bytedance.android.livesdk.gift.platform.core.h.h().d() == 3) goto L14;
        return;
    L14:
        if (this.f128282b == true) goto L21;
        this.f128282b = true;
        Single.create(new i(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this), new k(this));
        return;
    }

    public GiftListCacheRepo() {
        this.f128281a = GsonHelper.get();
        this.f128283c = new HashSet();
        this.f128284d = LazyKt.lazy(GiftListCacheRepo$localGiftSPCacheFix$2.INSTANCE);
    }

    @Override // xc6.b
    public final String o1() {
        GiftContext r100 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r100 == null) goto L8;
        com.bytedance.live.datacontext.m<String> r101 = r100.getGiftListResultLogId();
        if (r101 == null) goto L8;
        String r102 = r101.getValue();
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(GiftListCacheRepo r100, Map r101) {
        r100.getClass();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isEmpty() == true) goto L28;
        IRoom r102 = com.bytedance.android.livesdk.gift.platform.core.utils.x.a();
        if (((Boolean) r100.f128284d.getValue()).booleanValue() == false) goto L20;
        if (r102 == null) goto L20;
        int r103 = (int) r102.getRoomLayout();
        LinkedHashMap r104 = new LinkedHashMap();
        Iterator r105 = r101.entrySet().iterator();
    L12:
        if (r105.hasNext() == false) goto L19;
        Map.Entry r106 = (Map.Entry) r105.next();
        if (((Number) r106.getKey()).intValue() != r103) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L12;
        r104.put(r106.getKey(), r106.getValue());
        goto L12
    L16:
        r107 = false;
        goto L17
    L19:
        r101 = r104;
    L20:
        ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).h3(r101);
        return;
    }
}
