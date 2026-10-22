package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.livesdk.livecommerce.room.controller.related.IRelatedInfoManager$FromSource;
import com.bytedance.android.livesdk.livecommerce.room.controller.related.RelatedInfoManager;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f152282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f152283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile a f152284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super ECUIPromotion, Unit> f152285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RelatedInfoManager f152286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function3<com.bytedance.android.livesdk.livecommerce.room.model.e, String, Boolean, Observable<ECCurrentPromotion>> f152287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function2<com.bytedance.android.livesdk.livecommerce.room.model.e, Boolean, Observable<ECCurrentPromotion>> f152288g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ECUIPromotion f152289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ECUIPromotion f152290b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f152289a, r101.f152289a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f152290b, r101.f152290b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            ECUIPromotion r100 = this.f152289a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            ECUIPromotion r104 = this.f152290b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "CombineResponse(explainCardResp=" + this.f152289a + ", relatedCardResp=" + this.f152290b + ")";
        }

        public a(ECUIPromotion r100, ECUIPromotion r101) {
            this.f152289a = r100;
            this.f152290b = r101;
        }
    }

    public static void a(String r100) {
        dm.a.a("LiveCardLoad").i(r100);
    }

    public final void b(ECUIPromotion r100) {
        String r101 = r100.replaceRelatedInfo;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L15;
        a("replace related_info to ".concat(r101));
        this.f152286e.i(r101, IRelatedInfoManager$FromSource.RELATED_CARD);
        return;
    L15:
        return;
    L7:
        r102 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p(RelatedInfoManager r100, Function3<? super com.bytedance.android.livesdk.livecommerce.room.model.e, ? super String, ? super Boolean, ? extends Observable<ECCurrentPromotion>> r101, Function2<? super com.bytedance.android.livesdk.livecommerce.room.model.e, ? super Boolean, ? extends Observable<ECCurrentPromotion>> r102) {
        Intrinsics.checkNotNullParameter(r100, "relatedInfoManager");
        Intrinsics.checkNotNullParameter(r101, "relatedCardDataSource");
        Intrinsics.checkNotNullParameter(r102, "explainCardDataSource");
        this.f152286e = r100;
        this.f152287f = r101;
        this.f152288g = r102;
        this.f152283b = true;
    }

    public final void c(ECContext r100, com.bytedance.android.livesdk.livecommerce.room.model.g r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "ecContext");
        Intrinsics.checkNotNullParameter(r101, "roomInfo");
        a("instant room, req explain card and related card, disposable = " + this.f152282a);
        if (this.f152282a == null) goto L5;
        return;
    L5:
        this.f152283b = true;
        Function2<com.bytedance.android.livesdk.livecommerce.room.model.e, Boolean, Observable<ECCurrentPromotion>> r103 = this.f152288g;
        Boolean r104 = Boolean.TRUE;
        this.f152282a = bk2.c.a(Observable.combineLatest(r103.invoke(r101, r104), this.f152287f.invoke(r101, r102, r104), q.f152291a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new r(this), new s(this)), r100.getDisposableContext().getValue());
    }
}
