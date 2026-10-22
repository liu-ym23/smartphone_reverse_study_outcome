package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedanceos.appstore.buss.entity.AppInfoEntity;
import com.bytedanceos.appstore.buss.entity.CommonAppCommentEntity;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.netwrap.AppCollectEntity;
import com.bytedanceos.appstore.buss.utilities.e;
import com.bytedanceos.common.ad.param.AdReportParam;
import h7.d;
import java.util.ArrayList;
import java.util.Date;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class AppDetailViewModel extends d {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f8895p = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f8897e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8898f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f8899g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f8900h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f8901i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f8902j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f8903k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f8904l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AppCollectEntity f8905m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f8906n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f8907o;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends ViewModelProvider.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f8908d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f8909e;

        public b(String r10, String r11) {
            q.g(r10, "packageName");
            this.f8908d = r10;
            this.f8909e = r11;
        }

        @Override // androidx.lifecycle.ViewModelProvider.b, androidx.lifecycle.ViewModelProvider.Factory
        public k0 create(Class r10) {
            q.g(r10, "modelClass");
            return new AppDetailViewModel(this.f8908d, this.f8909e);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public k0 create(Class r10, CreationExtras r11) {
            q.g(r10, "modelClass");
            q.g(r11, "extras");
            return new AppDetailViewModel(this.f8908d, this.f8909e);
        }
    }

    static {
        f8895p = new a(null);
    }

    public AppDetailViewModel(String r10, String r11) {
        q.g(r10, "appPackageName");
        this.f8896d = r10;
        this.f8897e = r11;
        this.f8898f = kotlin.b.b(AppDetailViewModel$commonWishAppLiveData$2.INSTANCE);
        this.f8899g = kotlin.b.b(AppDetailViewModel$commonPostWishAppLiveData$2.INSTANCE);
        this.f8900h = kotlin.b.b(AppDetailViewModel$appDetailLiveData$2.INSTANCE);
        this.f8901i = kotlin.b.b(AppDetailViewModel$appGiftLiveData$2.INSTANCE);
        this.f8902j = kotlin.b.b(AppDetailViewModel$postWishAppLiveData$2.INSTANCE);
        this.f8903k = new ArrayList();
        this.f8904l = true;
        this.f8906n = kotlin.b.b(AppDetailViewModel$appInfoEntityLiveData$2.INSTANCE);
        this.f8907o = kotlin.b.b(AppDetailViewModel$commonAppCommentsLiveData$2.INSTANCE);
        o();
    }

    public static final /* synthetic */ String f(AppDetailViewModel r10) {
        return r10.f8896d;
    }

    public static final /* synthetic */ MutableLiveData g(AppDetailViewModel r10) {
        return r10.u();
    }

    public static final /* synthetic */ MutableLiveData h(AppDetailViewModel r10) {
        return r10.v();
    }

    public static final /* synthetic */ String i(AppDetailViewModel r10) {
        return r10.f8897e;
    }

    public static final /* synthetic */ ArrayList j(AppDetailViewModel r10) {
        return r10.f8903k;
    }

    public static final /* synthetic */ boolean k(AppDetailViewModel r10) {
        return r10.f8904l;
    }

    public static final /* synthetic */ void l(AppDetailViewModel r10, AppCollectEntity r11) {
        r10.f8905m = r11;
    }

    public static final /* synthetic */ void m(AppDetailViewModel r10, boolean r11) {
        r10.f8904l = r11;
    }

    public final void n(CommonAppCommentEntity r10) {
        AppInfoEntity r11 = (AppInfoEntity) s().e();
        if (r11 != null) goto L5;
        return;
    L5:
        if (r10 != null) goto L7;
        return;
    L7:
        if (q.b(this.f8896d, r10.getPkg()) == false) goto L11;
        r11.setScores(String.valueOf(r10.getScores()));
        r11.setComments(String.valueOf(r10.getCount()));
        r11.setResId(r10.getResId());
        s().m(r11);
        return;
    }

    public final void o() {
        h.d(l0.a(this), null, null, new AppDetailViewModel$getAppDetail$1(this, null), 3, null);
    }

    public final MutableLiveData p() {
        return (MutableLiveData) this.f8900h.getValue();
    }

    public final void q(String r10, String r11) {
        q.g(r10, "appPackageName");
        q.g(r11, "giftId");
        h.d(l0.a(this), null, null, new AppDetailViewModel$getAppGift$1(this, r10, r11, null), 3, null);
    }

    public final MutableLiveData r() {
        return (MutableLiveData) this.f8901i.getValue();
    }

    public final MutableLiveData s() {
        return (MutableLiveData) this.f8906n.getValue();
    }

    public final MutableLiveData t() {
        return (MutableLiveData) this.f8907o.getValue();
    }

    public final MutableLiveData u() {
        return (MutableLiveData) this.f8899g.getValue();
    }

    public final MutableLiveData v() {
        return (MutableLiveData) this.f8898f.getValue();
    }

    public final MutableLiveData w() {
        return (MutableLiveData) this.f8902j.getValue();
    }

    public final void x(CommonAppEntity r10) {
        AppCollectEntity r11 = this.f8905m;
        if (r11 != null) goto L5;
        AppCollectEntity r12 = new AppCollectEntity(this.f8896d, "1", e.f8837a.a(new Date(System.currentTimeMillis()), "yyyy-MM-dd HH:mm:ss"));
        this.f8905m = r12;
        this.f8903k.add(0, r12);
        this.f8904l = false;
    L10:
        h.d(l0.a(this), null, null, new AppDetailViewModel$postWishApp$3(this, r10, null), 3, null);
        return;
    L5:
        if (r11 == null) goto L10;
        int r13 = this.f8903k.indexOf(r11);
        if (this.f8904l == false) goto L9;
        ((AppCollectEntity) this.f8903k.get(r13)).setStatus(AdReportParam.ClickPosType.SKIP);
        goto L10
    L9:
        ((AppCollectEntity) this.f8903k.get(r13)).setStatus("1");
        goto L10
    }

    public void y(LifecycleOwner r10) {
        q.g(r10, "owner");
        v().o(r10);
        u().o(r10);
        p().o(r10);
        r().o(r10);
        w().o(r10);
        s().o(r10);
    }
}
