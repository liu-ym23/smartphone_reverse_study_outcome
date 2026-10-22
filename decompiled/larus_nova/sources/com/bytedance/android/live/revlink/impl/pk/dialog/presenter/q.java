package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractPkBanContract$View;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPkBanListFragment;
import com.bytedance.android.livesdk.link.model.j3;
import com.bytedance.android.livesdk.link.model.k3;
import com.bytedance.android.livesdk.link.model.u0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class q extends x31.r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f96073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f96074e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f96075f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f96076g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f96077h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f96078i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f96079j;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f96080a;

        public b(q r100) {
            this.f96080a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ExtraResponse r101 = (ExtraResponse) r100;
            if (r101 == null) goto L31;
            k3 r102 = (k3) r101.data;
            if (r102 == null) goto L32;
            q r103 = this.f96080a;
            j3 r104 = r102.getList();
            boolean r105 = false;
            if (r104 == null) goto L22;
            List<u0> r106 = r104.getList();
            if (r106 == null) goto L22;
            if (r106.isEmpty() == true) goto L22;
            j3 r107 = r102.getList();
            if (r107 == null) goto L22;
            String r108 = r107.getNextCursor();
            if (r108 == null) goto L22;
            if (r108.length() != 0) goto L19;
            boolean r109 = true;
        L20:
            if (r109 == true) goto L22;
            r105 = true;
            goto L22
        L19:
            r109 = false;
        L22:
            r103.f96075f = r105;
            q r110 = this.f96080a;
            j3 r111 = r102.getList();
            if (r111 == null) goto L26;
            String r112 = r111.getNextCursor();
            if (r112 == null) goto L26;
        L27:
            r110.f96073d = r112;
            InteractPkBanContract$View r113 = (InteractPkBanContract$View) this.f96080a.f92392c;
            if (r113 == null) goto L33;
            r113.ca0((k3) r101.data);
            return;
        L33:
            return;
        L26:
            r112 = "";
            goto L27
        L32:
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f96081a;

        public c(q r100) {
            this.f96081a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            q r101 = this.f96081a;
            r101.d((Throwable) r100);
            InteractPkBanContract$View r102 = (InteractPkBanContract$View) this.f96081a.f92392c;
            if (r102 == null) goto L6;
            r102.ba0();
            return;
        }
    }

    static {
    }

    @Override // x31.r
    public final void e() {
        f(this.f96073d, false);
    }

    @Override // x31.r
    public final void h() {
        this.f96073d = "";
        this.f96074e = 20;
        this.f96075f = true;
        Disposable r100 = this.f96076g;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public q(InteractPkBanListFragment r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f96079j = r101;
        this.f96073d = "";
        this.f96074e = 20;
        this.f96075f = true;
        this.f96078i = LazyKt.lazy(InteractPkBanListPresenter$mRoom$2.INSTANCE);
    }

    @Override // x31.r
    public final void f(String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, EffectConfiguration.KEY_CURSOR);
        if (r111 == false) goto L5;
        h();
    L5:
        IRoom r112 = (IRoom) this.f96078i.getValue();
        if (r112 != null) goto L8;
        return;
    L8:
        if (this.f96075f == false) goto L24;
        r31.a r100 = r31.b.a(r31.a.f535859a);
        long r101 = r112.getId();
        IBaseUser r102 = r112.getOwner();
        if (r102 == null) goto L12;
        Intrinsics.checkNotNullParameter(r102, "$this$secUidExt");
        r102.getCastSecUid();
    L12:
        IBaseUser r113 = r112.getOwner();
        Disposable r103 = null;
        if (r113 == null) goto L15;
        String r104 = iz.a.a(r113);
    L16:
        Observable r114 = r100.w(r101, r104, r110, this.f96074e, this.f96079j);
        if (r114 == null) goto L21;
        ObservableSubscribeProxy r115 = (ObservableSubscribeProxy) r114.as(c());
        if (r115 == null) goto L21;
        r103 = r115.subscribe(new b(this), new c(this));
    L21:
        this.f96076g = r103;
        return;
    L15:
        r104 = null;
        goto L16
    }

    @Override // x31.r
    public final void g(u0 r100, Function0 r110) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r110, "onSuccess");
        if (this.f96077h == false) goto L5;
        return;
    L5:
        IRoom r101 = (IRoom) this.f96078i.getValue();
        if (r101 == null) goto L24;
        this.f96077h = true;
        HashMap r102 = new HashMap();
        if (this.f96079j != 1) goto L10;
        String r103 = "invite_reject_permanent";
        int r104 = 12;
    L11:
        r102.put(r103, Boolean.FALSE);
        String r105 = r100.getUserId();
        if (r105 != null) goto L14;
        r105 = "";
    L14:
        r102.put("rival_anchor_id", r105);
        r31.a r106 = r31.b.a(r31.a.f535859a);
        long r107 = r101.getId();
        IBaseUser r108 = r101.getOwner();
        if (r108 == null) goto L17;
        Intrinsics.checkNotNullParameter(r108, "$this$secUidExt");
        String r109 = r108.getCastSecUid();
    L18:
        Observable<ExtraResponse<Object, Extra>> r111 = r106.N(r107, r109, r104, r102);
        if (r111 == null) goto L25;
        ObservableSubscribeProxy r112 = (ObservableSubscribeProxy) r111.as(c());
        if (r112 == null) goto L26;
        r112.subscribe(new r(this, r100, r110), new s(this, r100, r110));
        return;
    L26:
        return;
    L25:
        return;
    L17:
        r109 = null;
        goto L18
    L10:
        r103 = "invite_reject_temporary";
        r104 = 11;
        goto L11
    }
}
