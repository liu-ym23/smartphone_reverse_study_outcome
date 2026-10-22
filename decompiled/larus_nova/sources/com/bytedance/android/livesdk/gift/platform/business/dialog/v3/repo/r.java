package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import android.text.TextUtils;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftDataStorageService;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class r implements wp2.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Long f128405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f128406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f128407c;

    @Override // wp2.i
    public final void a(wp2.d r100) {
        if (r100.f560560a != true) goto L12;
        String r101 = r100.f560556c.optString("room_id");
        boolean r102 = r100.f560556c.optBoolean("predict_value");
        GiftDataStorageService r103 = com.bytedance.android.livesdk.gift.platform.core.utils.s.b();
        if (r103 == null) goto L8;
        r103.f131275o = r102 ? 1 : 0;
    L8:
        if (TextUtils.equals(String.valueOf(this.f128405a), r101) == false) goto L13;
        if (r102 == false) goto L14;
        Completable.complete().observeOn(Schedulers.computation()).subscribe(new q(this));
        return;
    L14:
        return;
    L13:
        return;
    }

    public r(Long r100, List r101, int r102) {
        this.f128405a = r100;
        this.f128406b = r101;
        this.f128407c = r102;
    }
}
