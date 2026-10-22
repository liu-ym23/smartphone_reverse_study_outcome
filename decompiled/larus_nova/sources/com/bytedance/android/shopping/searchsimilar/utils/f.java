package com.bytedance.android.shopping.searchsimilar.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.shopping.searchsimilar.api.SimilarProductApi;
import com.bytedance.android.shopping.searchsimilar.view.SearchSimilarAuthorizationDialog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: classes13.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f182499a;

    public f() {
    }

    static {
    }

    public static final void a(Context r100, boolean r101) {
        new Handler(Looper.getMainLooper()).postDelayed(new c(new SearchSimilarAuthorizationDialog(r100, r101)), 100);
        SimilarProductApi.f182486a.getClass();
        SimilarProductApi r102 = SimilarProductApi.a.f182487a;
        if (r102 == null) goto L5;
        Observable<CommerceBaseResponse> r103 = r102.updateShowSimilarProductGuide();
    L6:
        if (r103 == null) goto L12;
        Observable<CommerceBaseResponse> r104 = r103.subscribeOn(Schedulers.io());
        if (r104 == null) goto L12;
        Observable<CommerceBaseResponse> r105 = r104.observeOn(AndroidSchedulers.mainThread());
        if (r105 == null) goto L12;
        r105.subscribe(new d());
    L12:
        f182499a = false;
        return;
    L5:
        r103 = null;
        goto L6
    }
}
