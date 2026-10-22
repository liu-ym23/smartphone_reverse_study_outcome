package bg3;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.track.TrackCatcher;
import com.bytedance.apm.ApmAgent;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f18942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f18943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EventActionImpl f18944c;

    public a() {
        this.f18942a = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android"), TuplesKt.to("area_type", "104"), TuplesKt.to("page_name", "product_cart_page")});
        this.f18943b = new LinkedHashSet();
        this.f18944c = new EventActionImpl();
    }

    public final void a(String r100, Map<String, ? extends Object> r101, PageFinder r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "params");
        if (k.c(r103) == true) goto L5;
    L7:
        if (r103 == null) goto L9;
        this.f18943b.add(r103);
    L9:
        LinkedHashMap r104 = new LinkedHashMap();
        r104.putAll(this.f18942a);
        r104.putAll(r101);
        this.f18944c.doEventAction(r100, r102, r104);
        Lazy r105 = TrackCatcher.f187025a;
        if (TrackCatcher.a.a() == null) goto L18;
        Object r106 = r104.get("btm");
        if (r106 == null) goto L15;
        String r107 = r106.toString();
        if (r107 == null) goto L15;
    L16:
        TrackCatcher.c("cart", r100, r107);
    L15:
        r107 = "";
    L18:
        if (Intrinsics.areEqual(r100, "yata_cart_monitor") == false) goto L36;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L29
        JSONObject r109 = new JSONObject();     // Catch: Throwable -> L29
        Iterator r110 = r104.entrySet().iterator();     // Catch: Throwable -> L29
    L21:
        if (r110.hasNext() == false) goto L23;
        Map.Entry r111 = (Map.Entry) r110.next();     // Catch: Throwable -> L29
        r109.put((String) r111.getKey(), r111.getValue());     // Catch: Throwable -> L29
        goto L21
    L23:
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L29
        JSONObject r113 = new JSONObject();     // Catch: Throwable -> L29
        Iterator r114 = r104.entrySet().iterator();     // Catch: Throwable -> L29
    L25:
        if (r114.hasNext() == false) goto L27;
        Map.Entry r115 = (Map.Entry) r114.next();     // Catch: Throwable -> L29
        r113.put((String) r115.getKey(), r115.getValue());     // Catch: Throwable -> L29
        goto L25
    L27:
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L29
        ApmAgent.monitorEvent(r100, r109, null, r113);     // Catch: Throwable -> L29
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L36:
        return;
    L5:
        if (CollectionsKt.contains(this.f18943b, r103) == false) goto L7;
    }
}
