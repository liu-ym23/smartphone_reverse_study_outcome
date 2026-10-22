package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPKSearchContract$View;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPKSearchFragment;
import com.bytedance.android.live.revlink.impl.pk.utils.SearchSourceFlag;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.u6;
import com.bytedance.android.livesdk.link.model.x8;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class j extends x31.i {
    public final com.bytedance.android.live.revenuelink.connect.f A;
    public final g B;
    public final i11.b C;
    public final f D;
    public final boolean E;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<List<String>> f96010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<List<x8>> f96011e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<u6> f96012f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<IRivalRankRecommendResponse> f96013g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData<Boolean> f96014h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<MutableLiveData<?>> f96015i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<String> f96016j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<x8> f96017k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public IRivalExtraInfo f96018l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f96019m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f96020n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f96021o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final MutableLiveData<Boolean> f96022p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final MutableLiveData<Boolean> f96023q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f96024r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f96025s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f96026t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f96027u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final SearchSourceFlag f96028v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final yz0.l f96029w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final CompositeDisposable f96030x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f96031y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f96032z;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f96033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f96034b;

        public a(j r100, int r101) {
            this.f96033a = r100;
            this.f96034b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ExtraResponse r101 = (ExtraResponse) r100;
            j r102 = this.f96033a;
            r102.f96021o = false;
            r102.f96020n = ((u6) r101.data).getHasMore();
            this.f96033a.f96024r = ((u6) r101.data).getSearchId();
            j r103 = this.f96033a;
            r103.getClass();
            r103.f96025s += this.f96034b;
            List<x8> r104 = r103.f96017k;
            List<x8> r105 = ((u6) r101.data).getAnchorInfo();
            if (r105 != null) goto L6;
            r105 = CollectionsKt.emptyList();
        L6:
            ((ArrayList) r104).addAll(r105);
            ((InteractDialogPKSearchContract$View) this.f96033a.f92392c).ga0((u6) r101.data);
            j r106 = this.f96033a;
            r106.f96011e.postValue(r106.f96017k);
            this.f96033a.f96012f.postValue(r101.data);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f96035a;

        public b(j r100) {
            this.f96035a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            j r102 = this.f96035a;
            r102.f96021o = false;
            MutableLiveData<Boolean> r103 = r102.f96022p;
            Boolean r104 = Boolean.FALSE;
            r103.postValue(r104);
            this.f96035a.f96023q.postValue(r104);
            this.f96035a.d(r101);
            ((InteractDialogPKSearchContract$View) this.f96035a.f92392c).fa0(r101);
            this.f96035a.f96011e.postValue(null);
            this.f96035a.f96012f.postValue(null);
        }
    }

    @Override // com.bytedance.android.livesdk.common.c
    public final void b() {
        this.f119692a = null;
        ((ArrayList) this.f96017k).clear();
        this.f96020n = true;
        this.f96025s = 0;
        this.f96024r = "";
        com.bytedance.android.live.revenuelink.connect.f r100 = this.A;
        if (r100 == null) goto L5;
        r100.removeLinkOutListener(7, this.B);
        this.A.removeLinkOutListener(1, this.B);
    L5:
        i11.b r101 = this.C;
        if (r101 == null) goto L8;
        r101.l(this.D);
    L8:
        this.f96030x.clear();
    }

    public static Map f() {
        return (Map) l51.a.f507445e0.getValue(null, l51.a.f507436a[64]);
    }

    public final void e() {
        this.f96016j.clear();
        Map r100 = f();
        r100.put(String.valueOf(this.f96032z), this.f96016j);
        l51.a.N(r100);
        this.f96010d.postValue(this.f96016j);
    }

    public final int g() {
        if (this.E == false) goto L5;
    L8:
        return 1;
    L5:
        if (this.f96028v == SearchSourceFlag.INVITE_LINKING) goto L8;
        return 0;
    }

    public final void h() {
        Map r100 = f();
        String r101 = this.f96032z;
        if (r101 == null) goto L8;
        if (r100.containsKey(r101) == false) goto L8;
        Object r102 = r100.get(this.f96032z.toString());
        Intrinsics.checkNotNull(r102);
        this.f96016j = (List) r102;
    L14:
        this.f96010d.postValue(this.f96016j);
        return;
    L8:
        if (this.f96032z == null) goto L14;
        if (r100.isEmpty() == false) goto L14;
        com.bytedance.tools.kcp.spongepreference.runtime.a r103 = l51.a.f507447f0;
        KProperty<?>[] r104 = l51.a.f507436a;
        if (Lists.isEmpty((List) r103.getValue(null, r104[65])) == true) goto L14;
        this.f96016j = (List) r103.getValue(null, r104[65]);
        r100.put(this.f96032z.toString(), this.f96016j);
        l51.a.N(r100);
        ArrayList r105 = new ArrayList();
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r103.setValue(null, r104[65], r105);
        goto L14
    }

    public final void i(LifecycleOwner r100) {
        Iterator r101 = ((ArrayList) this.f96015i).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        MutableLiveData r102 = (MutableLiveData) r101.next();
        Intrinsics.checkNotNull(r100);
        r102.removeObservers(r100);
        goto L4
    }

    public j(InteractPKSearchFragment r110, boolean r111, SearchSourceFlag r112) {
        Intrinsics.checkNotNullParameter(r112, "searchSourceFlag");
        super(r110);
        this.E = r111;
        MutableLiveData<List<String>> r100 = new MutableLiveData();
        this.f96010d = r100;
        MutableLiveData<List<x8>> r101 = new MutableLiveData();
        this.f96011e = r101;
        MutableLiveData<u6> r102 = new MutableLiveData();
        this.f96012f = r102;
        MutableLiveData<IRivalRankRecommendResponse> r103 = new MutableLiveData();
        this.f96013g = r103;
        MutableLiveData<Boolean> r104 = new MutableLiveData();
        this.f96014h = r104;
        ArrayList r105 = new ArrayList();
        this.f96015i = r105;
        this.f96016j = new ArrayList();
        this.f96017k = new ArrayList();
        this.f96019m = "";
        this.f96020n = true;
        MutableLiveData<Boolean> r113 = new MutableLiveData();
        this.f96022p = r113;
        MutableLiveData<Boolean> r114 = new MutableLiveData();
        this.f96023q = r114;
        this.f96024r = "";
        this.f96028v = SearchSourceFlag.UNDEFINE;
        yz0.l r106 = (yz0.l) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.l.class);
        this.f96029w = r106;
        CompositeDisposable r115 = new CompositeDisposable();
        this.f96030x = r115;
        this.f96032z = iz.a.a(((com.bytedance.android.livesdk.revenue.service.user.a) com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class)).b());
        com.bytedance.android.live.revenuelink.connect.f r116 = com.bytedance.android.live.revlink.impl.global.b.a();
        this.A = r116;
        g r117 = new g(this);
        this.B = r117;
        f r118 = new f(this);
        this.D = r118;
        this.f96028v = r112;
        SearchSourceFlag r107 = SearchSourceFlag.MAIN_LINK;
        if (r112 != r107) goto L5;
    L8:
        boolean r119 = true;
    L9:
        this.f96027u = r119;
        r105.add(r101);
        r105.add(r100);
        r105.add(r113);
        r105.add(r102);
        r105.add(r114);
        r105.add(r103);
        r105.add(r104);
        if (r106 == null) goto L13;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        r115.add(yz0.h.a.a(r106, com.bytedance.android.live.revenue.common.message.b.f90885b, false, 4).subscribe(new e(this)));
    L13:
        if (r116 == null) goto L25;
        if (r112 != r107) goto L16;
        boolean r108 = true;
    L18:
        if (r108 == false) goto L21;
        r116.addLinkOutListener(7, r117);
        goto L25
    L21:
        if (r112 != SearchSourceFlag.INVITE_LINKING) goto L23;
        r116.addLinkOutListener(7, r117);
        goto L25
    L23:
        r116.addLinkOutListener(7, r117);
        goto L25
    L16:
        r108 = false;
    L25:
        if (com.bytedance.android.live.revlink.impl.global.b.N() == null) goto L28;
        com.bytedance.android.live.revlink.impl.pk.service.b r109 = com.bytedance.android.live.revlink.impl.global.b.N();
        Intrinsics.checkNotNull(r109);
        i11.b r120 = r109.getLinkUserCenter();
        this.C = r120;
        Intrinsics.checkNotNull(r120);
        r120.i(r118);
        return;
    L28:
        return;
    L5:
        if (r112 == SearchSourceFlag.INVITE_LINKING) goto L8;
        r119 = false;
        goto L9
    }

    public final void j(String r110, int r111, int r112, String r113, boolean r114, String r115) {
        Intrinsics.checkNotNullParameter(r110, "queryWord");
        Intrinsics.checkNotNullParameter(r113, "searchId");
        Intrinsics.checkNotNullParameter(r115, "activityName");
        if (r114 == false) goto L16;
        this.f96010d.setValue(null);
        Iterator<String> r100 = this.f96016j.iterator();
    L6:
        if (r100.hasNext() == false) goto L12;
        String r101 = r100.next();
        if (r101 == null) goto L6;
        if (Intrinsics.areEqual(r101, r110) == false) goto L6;
        this.f96016j.remove(r110);
    L12:
        ListProtector.add(this.f96016j, 0, r110);
        if (this.f96016j.size() <= 10) goto L15;
        List<String> r102 = this.f96016j;
        ListProtector.remove(r102, r102.size() - 1);
    L15:
        Map r103 = f();
        r103.put(String.valueOf(this.f96032z), this.f96016j);
        l51.a.N(r103);
        this.f96019m = r110;
        this.f96025s = 0;
        this.f96026t = r112;
        this.f96020n = true;
        this.f96024r = "";
        ((ArrayList) this.f96017k).clear();
    L18:
        if (this.f96020n == true) goto L20;
        return;
    L20:
        if (this.f96021o == true) goto L38;
        this.f96021o = true;
        this.f96022p.postValue(Boolean.valueOf(r114));
        if (this.f96027u == false) goto L24;
        int r104 = 2;
    L25:
        Observable<ExtraResponse<u6, Extra>> r116 = r31.b.a(r31.a.f535859a).J(r110, r111, r112, r113, r115, r104);
        if (r116 == null) goto L39;
        ObservableSubscribeProxy r117 = (ObservableSubscribeProxy) r116.as(c());
        if (r117 == null) goto L40;
        r117.subscribe(new a(this, r112), new b(this));
        return;
    L40:
        return;
    L39:
        return;
    L24:
        r104 = 0;
        goto L25
    L38:
        return;
    L16:
        this.f96023q.postValue(Boolean.valueOf(this.f96020n));
        goto L18
    }
}
