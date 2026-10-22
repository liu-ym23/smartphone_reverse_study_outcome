package com.bytedance.android.live.revlink.impl.control;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.FormatType;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.RevLinkOldDynamicDataContextKt$transformLinkAnchorInfo$$inlined$also$lambda$1;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/control/CreateLinkLynxWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CreateLinkLynxWidget extends LiveWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f92212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zy0.b f92213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<List<com.bytedance.android.livesdk.link.model.p>> f92214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f92215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f92216e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, LiveData<?>> f92217f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, LiveData<Pair<String, JSONObject>>> f92218g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f92219h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i11.c f92220i;

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        if (this.f92212a == true) goto L50;
        com.bytedance.android.live.revlink.impl.settings.dynamic.a r100 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H;
        r100.getClass();
        ReadOnlyProperty r101 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.f97555z;
        KProperty<?>[] r102 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.f97530a;
        u6 r103 = new u6((String) r101.getValue(r100, r102[24]));
        u6 r104 = r103.d("url");
        yz0.k r105 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        View r106 = null;
        if (r105 == null) goto L8;
        IRoom r107 = r105.getRoom();
    L9:
        if (r107 == null) goto L13;
        IBaseUser r108 = r107.getOwner();
        if (r108 == null) goto L13;
        String r109 = r108.getIdString();
    L14:
        r104.b("anchor_id", r109);
        if (r107 == null) goto L19;
        IBaseUser r110 = r107.getOwner();
        if (r110 == null) goto L19;
        Intrinsics.checkNotNullParameter(r110, "$this$secUidExt");
        String r111 = r110.getCastSecUid();
    L20:
        r104.b("sec_anchor_id", r111);
        r104.b("user_id", com.bytedance.android.live.revlink.impl.utils.u.e());
        if (r107 == null) goto L23;
        String r112 = r107.getIdStr();
    L24:
        r104.b("room_id", r112);
        r104.b("forest_newly_builtin", "1");
        r104.b("load_source", "0");
        r104.b("business_type", r41.b.a());
        r104.b("group", r41.b.a());
        if (r41.b.f536016a == false) goto L27;
    L29:
        boolean r113 = false;
    L30:
        r104.b("enable_find_people", String.valueOf(r113));
        this.f92212a = true;
        long r114 = System.currentTimeMillis();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.dynamic.a.A.getValue(r100, r102[25])).booleanValue() == false) goto L33;
        zy0.b r115 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).q8(this.context, r103.c(), new CreateLinkLynxWidget$initHub$1(r114));
    L34:
        this.f92213b = r115;
        if (r115 == null) goto L39;
        View r116 = r115.c();
        if (r116 == null) goto L39;
        r116.setVisibility(8);
    L39:
        ViewGroup r117 = this.containerView;
        if (r117 == null) goto L45;
        zy0.b r118 = this.f92213b;
        if (r118 == null) goto L44;
        r106 = r118.c();
    L44:
        r117.addView(r106, new FrameLayout.LayoutParams(0, 0));
    L45:
        zy0.b r119 = this.f92213b;
        if (r119 == null) goto L50;
        xy0.a<?> r120 = r119.g();
        if (r120 == null) goto L50;
        r120.load();
        goto L50
    L33:
        r115 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(this.context, r103.c(), new CreateLinkLynxWidget$initHub$2(r114));
        goto L34
    L27:
        if (com.bytedance.android.live.revlink.impl.utils.u.b() == false) goto L29;
        r113 = true;
        goto L30
    L23:
        r112 = null;
    L19:
        r111 = null;
    L13:
        r109 = null;
        goto L14
    L8:
        r107 = null;
    L50:
        i11.c r121 = this.f92220i;
        if (r121 == null) goto L53;
        r121.i(this.f92215d);
    L53:
        Iterator<String> r122 = this.f92217f.keySet().iterator();
    L55:
        if (r122.hasNext() == false) goto L59;
        LiveData r123 = (LiveData) ((LinkedHashMap) this.f92218g).get(r122.next());
        if (r123 == null) goto L55;
        r123.observeForever(this.f92219h);
        goto L55
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        zy0.b r100 = this.f92213b;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f92216e.dispose();
        i11.c r101 = this.f92220i;
        if (r101 == null) goto L8;
        r101.l(this.f92215d);
    L8:
        Iterator<String> r102 = this.f92217f.keySet().iterator();
    L10:
        if (r102.hasNext() == false) goto L14;
        String r103 = r102.next();
        LiveData r104 = (LiveData) ((LinkedHashMap) this.f92218g).get(r103);
        if (r104 == null) goto L10;
        r104.removeObserver(this.f92219h);
        goto L10
    }

    public CreateLinkLynxWidget(AnchorLinkUserCenterV2 r100) {
        this.f92220i = r100;
        MutableLiveData<List<com.bytedance.android.livesdk.link.model.p>> r101 = new MutableLiveData();
        this.f92214c = r101;
        this.f92215d = new b(this);
        this.f92216e = new CompositeDisposable();
        HashMap<String, LiveData<?>> r102 = new HashMap();
        Intrinsics.checkNotNullParameter(r101, "liveData");
        MediatorLiveData r103 = new MediatorLiveData();
        r103.addSource(r101, new RevLinkOldDynamicDataContextKt$transformLinkAnchorInfo$$inlined$also$lambda$1(r103, null));
        r102.put("link_anchor_list_v2", r103);
        Unit r104 = Unit.INSTANCE;
        this.f92217f = r102;
        LinkedHashMap r105 = new LinkedHashMap(MapsKt.mapCapacity(r102.size()));
        Iterator r106 = r102.entrySet().iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        Map.Entry r107 = (Map.Entry) r106.next();
        Object r108 = r107.getKey();
        String r109 = (String) r107.getKey();
        r105.put(r108, com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.b((LiveData) r107.getValue(), r109, FormatType.NEW));
        goto L4
    L6:
        this.f92218g = r105;
        this.f92219h = new a(this);
    }
}
