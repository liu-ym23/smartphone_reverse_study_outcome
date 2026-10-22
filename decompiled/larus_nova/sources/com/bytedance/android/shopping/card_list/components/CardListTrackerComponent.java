package com.bytedance.android.shopping.card_list.components;

import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.params.CartPassThroughData;
import com.bytedance.android.shopping.card_list.params.CollectPassThroughData;
import com.obric.miniapp.alarm.AccountType;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class CardListTrackerComponent extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final gb3.a f171434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f171435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f171436f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f171437g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f171438h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CardListObjectContainer f171439i;

    public static final class a {
    }

    static {
    }

    public CardListTrackerComponent(CardListObjectContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "objectContainer");
        super(r100);
        this.f171439i = r100;
        this.f171434d = new gb3.a(r100.f171546f.getPageName(), r100.f171546f.getPageType());
        this.f171435e = LazyKt.lazy(new CardListTrackerComponent$cardListSliceCustomWidgetAdapterComponent$2(this));
        this.f171436f = LazyKt.lazy(new CardListTrackerComponent$yataInstance$2(this));
        this.f171437g = LazyKt.lazy(new CardListTrackerComponent$monitorId$2(this));
        this.f171438h = new AtomicBoolean(false);
    }

    public final void g(String r100, Map<String, ? extends Object> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "params");
        LinkedHashMap r103 = new LinkedHashMap();
        CardPassThroughData r104 = this.f171439i.f171545e.f171309a;
        Pair[] r105 = new Pair[4];
        r105[0] = TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        String r106 = this.f171439i.f171546f.getPageName();
        if (r106 != null) goto L5;
        r106 = "product_card_list_page";
    L5:
        r105[1] = TuplesKt.to("page_name", r106);
        r105[2] = TuplesKt.to("session_id", this.f171439i.f171545e.f171317i);
        String r107 = this.f171439i.f171546f.getPageType();
        if (r107 != null) goto L8;
        r107 = "none";
    L8:
        r105[3] = TuplesKt.to("page_type", r107);
        Map r108 = MapsKt.mutableMapOf(r105);
        if (r104 == null) goto L15;
        CollectPassThroughData r109 = r104.getCollectSchemaData();
        if (r109 == null) goto L15;
        String r110 = r109.getPreviousPage();
        if (r110 == null) goto L15;
        r108.put("previous_page", r110);
    L15:
        if (r104 == null) goto L31;
        CartPassThroughData r111 = r104.getCartSchemaData();
        if (r111 == null) goto L31;
        r108.put("is_split_screen", Integer.valueOf(com.bytedance.android.shopping.extensions.k.q(Boolean.valueOf(this.f171439i.f171545e.f171321m))));
        CardListSliceCustomWidgetAdapterComponent r112 = (CardListSliceCustomWidgetAdapterComponent) this.f171435e.getValue();
        if (r112 == null) goto L22;
        String r113 = r112.f171429f;
        if (r113 == null) goto L22;
    L23:
        r108.put("top_tab_name", r113);
        String r114 = r111.getHistoryPath();
        String r115 = "";
        if (r114 != null) goto L26;
        r114 = "";
    L26:
        r108.put("previous_page", r114);
        String r116 = r111.getNewSourceType();
        if (r116 == null) goto L30;
        r115 = r116;
    L30:
        r108.put(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE, r115);
        r108.put("area_type", "104");
    L22:
        r113 = AccountType.MAIN;
    L31:
        r103.putAll(r108);
        r103.putAll(r101);
        this.f171434d.a(r100, r103, this.f171439i.f171545e.f171315g, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void h(CardListTrackerComponent r100, String r101, Map r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = MapsKt.emptyMap();
    L5:
        r100.g(r101, r102, null);
    }
}
