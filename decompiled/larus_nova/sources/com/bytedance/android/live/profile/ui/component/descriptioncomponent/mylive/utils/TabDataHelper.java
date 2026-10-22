package com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.utils;

import com.bytedance.android.live.base.model.user.LiveDSLContainer;
import com.bytedance.android.live.base.model.user.MyLiveTab;
import com.bytedance.android.live.base.model.user.MyLiveTabData;
import com.bytedance.android.live.base.model.user.MyLiveTabItem;
import com.bytedance.android.live.base.model.user.MyLiveUIConfig;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profile.repository.NewProfileApi;
import com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.TabItemAdapter;
import com.bytedance.android.livesdk.dsl.recyclerview.e;
import com.bytedance.android.livesdk.dsl.recyclerview.f;
import com.bytedance.android.livesdkapi.depend.model.live.LiveDSLModel;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import yt1.o;

/* JADX INFO: loaded from: classes47.dex */
public final class TabDataHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TabItemAdapter f86654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f86655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MyLiveTab.Extra f86656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f86657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<e> f86658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MyLiveTab f86659f;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TabDataHelper f86660a;

        public b(TabDataHelper r100) {
            this.f86660a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
            TabDataHelper r102 = this.f86660a;
            Object r103 = null;
            if (r101 == null) goto L9;
            r102.getClass();
            MyLiveTabData r104 = (MyLiveTabData) r101.data;
            if (r104 == null) goto L9;
            MyLiveTab r105 = r104.getTab();
            if (r105 == null) goto L9;
            MyLiveTab.Extra r106 = r105.getExtra();
        L10:
            r102.f86656c = r106;
            TabDataHelper r107 = this.f86660a;
            r107.getClass();
            if (r101 == null) goto L84;
            MyLiveTabData r108 = (MyLiveTabData) r101.data;
            if (r108 == null) goto L85;
            MyLiveTab r109 = r108.getTab();
            if (r109 == null) goto L87;
            r107.f86659f = r109;
            if ((CollectionsKt.lastOrNull(r107.f86658e) instanceof rt0.a) == false) goto L25;
            int r110 = CollectionsKt.getLastIndex(r107.f86658e);
            CollectionsKt.removeLastOrNull(r107.f86658e);
            TabItemAdapter r111 = r107.f86654a;
            if (r111 == null) goto L22;
            r111.setData(r107.f86658e);
        L22:
            TabItemAdapter r112 = r107.f86654a;
            if (r112 == null) goto L25;
            r112.notifyItemRemoved(r110);
        L25:
            e r113 = (e) CollectionsKt.lastOrNull(r107.f86658e);
            if (r113 == null) goto L28;
            String r114 = r113.getGroupId();
        L29:
            if (r113 == null) goto L31;
            String r115 = r113.getGroupId();
        L32:
            List<MyLiveTabItem> r116 = r107.f86659f.getItems();
            if (r116 == null) goto L39;
            MyLiveTabItem r117 = (MyLiveTabItem) CollectionsKt.firstOrNull(r116);
            if (r117 == null) goto L39;
            MyLiveUIConfig r118 = r117.getUiConfig();
            if (r118 == null) goto L39;
            String r119 = r118.group;
        L41:
            if ((!Intrinsics.areEqual(r115, r119)) == false) goto L57;
            if ((r113 instanceof com.bytedance.android.livesdk.dsl.recyclerview.b) == false) goto L70;
            com.bytedance.android.livesdk.dsl.recyclerview.b r120 = (com.bytedance.android.livesdk.dsl.recyclerview.b) r113;
            HashMap<String, Object> r121 = r120.f122788e;
            if (r121 == null) goto L47;
            Object r122 = r121.get("radius");
        L49:
            if (TypeIntrinsics.isMutableMap(r122) == false) goto L52;
            r103 = r122;
        L52:
            Map r123 = (Map) r103;
            if (r123 == null) goto L55;
            String r124 = (String) r123.put("bottom", "12");
        L55:
            r120.a(MapsKt.mapOf(TuplesKt.to("radius", r123)));
            goto L70
        L47:
            r122 = null;
        L70:
            List<e> r125 = r107.b(r107.a(r114, r107.f86659f.getItems()), ((ArrayList) r107.f86658e).size());
            int r126 = ((ArrayList) r107.f86658e).size();
            ((ArrayList) r107.f86658e).addAll(r125);
            TabItemAdapter r127 = r107.f86654a;
            if (r127 == null) goto L73;
            r127.setData(r107.f86658e);
        L73:
            TabItemAdapter r128 = r107.f86654a;
            if (r128 == null) goto L76;
            r128.notifyItemRangeInserted(r126, ((ArrayList) r125).size());
        L76:
            int r129 = ((ArrayList) r125).size();
            int r130 = r126 - 1;
            if (r130 < 0) goto L79;
            r129 = r129 + 1;
        L80:
            TabItemAdapter r131 = r107.f86654a;
            if (r131 == null) goto L86;
            r131.notifyItemRangeChanged(r130, r129);
            return;
        L86:
            return;
        L79:
            r130 = 0;
            goto L80
        L57:
            if ((r113 instanceof com.bytedance.android.livesdk.dsl.recyclerview.b) == false) goto L70;
            com.bytedance.android.livesdk.dsl.recyclerview.b r132 = (com.bytedance.android.livesdk.dsl.recyclerview.b) r113;
            HashMap<String, Object> r133 = r132.f122788e;
            if (r133 == null) goto L61;
            Object r134 = r133.get("radius");
        L63:
            if (TypeIntrinsics.isMutableMap(r134) == false) goto L66;
            r103 = r134;
        L66:
            Map r135 = (Map) r103;
            if (r135 == null) goto L69;
            String r136 = (String) r135.put("bottom", "0");
        L69:
            r132.a(MapsKt.mapOf(TuplesKt.to("radius", r135)));
            goto L70
        L61:
            r134 = null;
        L39:
            r119 = null;
            goto L41
        L31:
            r115 = null;
            goto L32
        L28:
            r114 = null;
            goto L29
        L87:
            return;
        L85:
            return;
        L84:
            return;
        L9:
            r106 = null;
            goto L10
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TabDataHelper f86661a;

        public c(TabDataHelper r100) {
            this.f86661a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            TabDataHelper r102 = this.f86661a;
            e r103 = (e) CollectionsKt.lastOrNull(r102.f86658e);
            if (r103 != null) goto L6;
            return;
        L6:
            if ((r103 instanceof rt0.a) == false) goto L8;
            ((rt0.a) r103).f539162c = false;
        L8:
            TabItemAdapter r104 = r102.f86654a;
            if (r104 == null) goto L11;
            r104.setData(r102.f86658e);
        L11:
            TabItemAdapter r105 = r102.f86654a;
            if (r105 == null) goto L15;
            r105.notifyItemChanged(CollectionsKt.getLastIndex(r102.f86658e));
            return;
        }
    }

    static {
    }

    public final void c() {
        MyLiveTab.Extra r100 = this.f86656c;
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.getHasMore() != true) goto L7;
    L9:
        if (r101 == true) goto L12;
        ALogger.i("TabDataHelper", "queryMore, there's no more ");
        return;
    L12:
        Disposable r102 = this.f86657d;
        if (r102 != null) goto L15;
    L18:
        MyLiveTab.Extra r103 = this.f86656c;
        if (r103 != null) goto L21;
        return;
    L21:
        NewProfileApi r104 = (NewProfileApi) com.bytedance.android.live.network.c.b().e(NewProfileApi.class);
        if (r104 == null) goto L30;
        Single<com.bytedance.android.live.network.response.e<MyLiveTabData>> r105 = r104.queryMoreTabsInfo(this.f86659f.getBizName(), r103.getNextQueryIndex());
        if (r105 == null) goto L30;
        Single<com.bytedance.android.live.network.response.e<MyLiveTabData>> r106 = r105.subscribeOn(Schedulers.io());
        if (r106 == null) goto L30;
        Single<com.bytedance.android.live.network.response.e<MyLiveTabData>> r107 = r106.observeOn(AndroidSchedulers.mainThread());
        if (r107 == null) goto L30;
        Disposable r108 = r107.subscribe(new b(this), new c(this));
    L31:
        this.f86657d = r108;
        return;
    L30:
        r108 = null;
        goto L31
    L15:
        if (r102.isDisposed() == true) goto L18;
        ALogger.i("TabDataHelper", "is requesting");
        return;
    L7:
        r101 = false;
        goto L9
    }

    public TabDataHelper(MyLiveTab r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f86659f = r100;
        this.f86655b = LazyKt.lazy(TabDataHelper$templateStore$2.INSTANCE);
        this.f86656c = this.f86659f.getExtra();
        this.f86658e = new ArrayList();
    }

    public final List<MyLiveTabItem> a(String r100, List<MyLiveTabItem> r110) {
        ArrayList r101 = new ArrayList();
        MyLiveTabItem r102 = null;
        if (r110 == null) goto L23;
        Iterator<T> r111 = r110.iterator();
        MyLiveTabItem r103 = null;
        int r104 = 0;
    L6:
        if (r111.hasNext() == false) goto L22;
        Object r105 = r111.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        MyLiveTabItem r107 = (MyLiveTabItem) r105;
        MyLiveUIConfig r108 = r107.getUiConfig();
        if (r108 == null) goto L13;
        String r109 = r108.group;
    L15:
        if ((!Intrinsics.areEqual(r109, r100)) == false) goto L17;
        d(r103, false, true);
        int r112 = rt0.c.f539163c;
        MyLiveTabItem r113 = new MyLiveTabItem();
        r113.setLocalId(-101);
        r101.add(r113);
        d(r107, true, false);
    L17:
        r101.add(r107);
        MyLiveUIConfig r114 = r107.getUiConfig();
        if (r114 == null) goto L20;
        r100 = r114.group;
    L21:
        r103 = r107;
        r104 = r106;
        goto L6
    L20:
        r100 = null;
        goto L21
    L13:
        r109 = null;
        goto L15
    L22:
        r102 = r103;
    L23:
        MyLiveTab.Extra r115 = this.f86656c;
        if (r115 != null) goto L26;
    L28:
        boolean r116 = false;
    L29:
        if (r116 == false) goto L31;
        d(r102, false, true);
        int r117 = rt0.a.f539159d;
        MyLiveTabItem r118 = new MyLiveTabItem();
        r118.setLocalId(-100);
        r101.add(r118);
    L31:
        return r101;
    L26:
        if (r115.getHasMore() != true) goto L28;
        r116 = true;
        goto L29
    }

    public final List<e> b(List<MyLiveTabItem> r110, int r111) {
        ArrayList r100 = new ArrayList();
        Iterator<T> r112 = r110.iterator();
        int r101 = 0;
    L4:
        if (r112.hasNext() == false) goto L60;
        Object r102 = r112.next();
        int r103 = r101 + 1;
        if (r101 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        MyLiveTabItem r104 = (MyLiveTabItem) r102;
        Integer r105 = r104.getLocalId();
        if (r105 != null) goto L12;
    L14:
        if (r105 != null) goto L17;
    L19:
        int r106 = r101 + r111;
        LiveDSLContainer r107 = r104.getDslItem();
        Long r108 = null;
        if (r107 == null) goto L22;
        LiveDSLModel r109 = r107.getDslModel();
    L23:
        Integer r113 = r104.getLocalId();
        if (r113 != null) goto L28;
        if (r109 == null) goto L27;
        r113 = Integer.valueOf((int) r109.getId());
        goto L28
    L27:
        r113 = null;
    L28:
        int r114 = -1;
        if (r113 == null) goto L31;
        int r115 = r113.intValue();
    L33:
        if (r104.getRadius() == null) goto L35;
        Map<String, ? extends Object> r116 = MapsKt.mapOf(TuplesKt.to("radius", r104.getRadius()));
    L37:
        if (r109 == null) goto L40;
        String r117 = r109.getDslData();
        if (r117 == null) goto L40;
    L41:
        MyLiveUIConfig r118 = r104.getUiConfig();
        if (r118 == null) goto L44;
        String r119 = r118.group;
    L45:
        rt0.b r120 = new rt0.b(r117, r106, r115, r119);
        if (r109 == null) goto L48;
        r108 = Long.valueOf(r109.getId());
    L48:
        r120.f122785b = r108;
        if (r116 == null) goto L51;
        r120.a(r116);
    L51:
        r120.a(MapsKt.mapOf(TuplesKt.to("tab_type", this.f86659f.getBizName())));
        r100.add(r120);
        LiveDSLContainer r121 = r104.getDslItem();
        if (r121 == null) goto L59;
        LiveDSLModel r122 = r121.getDslModel();
        if (r122 == null) goto L59;
        f r123 = (f) this.f86655b.getValue();
        TabItemAdapter r124 = this.f86654a;
        if (r124 == null) goto L58;
        r114 = r124.y2(r120);
    L58:
        o.f569030e.getClass();
        r123.b(r114, o.a.b(r122));
    L59:
        r101 = r103;
        goto L4
    L44:
        r119 = null;
    L40:
        r117 = "";
        goto L41
    L35:
        r116 = null;
        goto L37
    L31:
        r115 = -1;
        goto L33
    L22:
        r109 = null;
        goto L23
    L17:
        if (r105.intValue() != (-101)) goto L19;
        r100.add(new rt0.c());
        goto L59
    L12:
        if (r105.intValue() != (-100)) goto L14;
        r100.add(new rt0.a(0));
        goto L59
    L60:
        return r100;
    }

    public static void d(MyLiveTabItem r100, boolean r101, boolean r102) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getRadius() != null) goto L7;
        r100.setRadius(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("top", "0"), TuplesKt.to("bottom", "0")}));
    L7:
        Map<String, String> r103 = r100.getRadius();
        if (r103 != null) goto L10;
        return;
    L10:
        if (r101 == false) goto L12;
        r103.put("top", "12");
    L12:
        if (r102 == false) goto L16;
        r103.put("bottom", "12");
        return;
    }
}
