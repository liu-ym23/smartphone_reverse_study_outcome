package com.bytedance.android.livesdk.gift.platform.format.service;

import ca0.w;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.scope.o;
import com.google.gson.Gson;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class FormatGiftListService implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f132256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<w1> f132257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f132258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Gson f132259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f132260e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i12.e f132261f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.room.c f132262g;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f132258c.dispose();
        this.f132258c.clear();
    }

    public final void a(w r100) {
        if (((ArrayList) this.f132257b).isEmpty() == true) goto L5;
        r100.b(this.f132257b);
        return;
    L5:
        if (this.f132260e == false) goto L7;
        r100.b(this.f132257b);
        return;
    L7:
        this.f132260e = true;
        this.f132258c.add(Single.create(new d(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r100), new f(this, r100)));
    }

    public FormatGiftListService(i12.e r100, com.bytedance.android.livesdk.revenue.service.room.c r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "revRoomService");
        this.f132261f = r100;
        this.f132262g = r101;
        this.f132256a = LazyKt.lazy(FormatGiftListService$addHeaderEnable$2.INSTANCE);
        this.f132257b = new ArrayList();
        this.f132258c = new CompositeDisposable();
        this.f132259d = GsonHelper.get();
    }
}
