package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

import androidx.lifecycle.LiveData;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class MultiRegisterViewListenContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<CallContext, List<String>> f93889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Object, CallContext> f93890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, LiveData<Pair<String, JSONObject>>> f93891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MultiRegisterViewListenContext$sendDataToLynxObserver$1 f93892d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, LiveData<?>> f93893e;

    public final void a() {
        Iterator<String> r100 = this.f93893e.keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        String r101 = r100.next();
        LiveData r102 = (LiveData) ((LinkedHashMap) this.f93891c).get(r101);
        if (r102 == null) goto L4;
        x.e(r102, this.f93892d);
        goto L4
    }

    public final void b() {
        Iterator<String> r100 = this.f93893e.keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        String r101 = r100.next();
        LiveData r102 = (LiveData) ((LinkedHashMap) this.f93891c).get(r101);
        if (r102 == null) goto L4;
        r102.removeObserver(this.f93892d);
        goto L4
    L8:
        HashMap<CallContext, List<String>> r103 = this.f93889a;
        if (r103 == null) goto L11;
        r103.clear();
    L11:
        HashMap<Object, CallContext> r104 = this.f93890b;
        if (r104 == null) goto L20;
        r104.clear();
        return;
    }

    /* JADX WARN: Type inference failed for: r6v4, types: [com.bytedance.android.live.revlink.impl.multianchor.dynamic.MultiRegisterViewListenContext$sendDataToLynxObserver$1] */
    public MultiRegisterViewListenContext(HashMap<String, LiveData<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "dataMap");
        this.f93893e = r100;
        this.f93889a = new HashMap();
        this.f93890b = new HashMap();
        LinkedHashMap r101 = new LinkedHashMap(MapsKt.mapCapacity(r100.size()));
        Iterator<T> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry r103 = (Map.Entry) r102.next();
        Object r104 = r103.getKey();
        String r105 = (String) r103.getKey();
        r101.put(r104, e.b((LiveData) r103.getValue(), r105, FormatType.NEW));
        goto L4
    L6:
        this.f93891c = r101;
        this.f93892d = new MultiRegisterViewListenContext$sendDataToLynxObserver$1(this);
    }

    public final void d(CallContext r100) {
        Intrinsics.checkNotNullParameter(r100, "callContext");
        HashMap<Object, CallContext> r101 = this.f93890b;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101.containsKey(r100.f249269d) == false) goto L6;
        HashMap<CallContext, List<String>> r102 = this.f93889a;
        HashMap<Object, CallContext> r103 = this.f93890b;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r102.remove(r103.get(r100.f249269d));
        HashMap<Object, CallContext> r104 = this.f93890b;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r104.remove(r100.f249269d);
        return;
    }

    public final void c(CallContext r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, PromotionProductPrivilegesStruct.TAGS);
        if (r101.isEmpty() == false) goto L5;
        return;
    L5:
        HashMap<Object, CallContext> r102 = this.f93890b;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r102.containsKey(r100.f249269d) == false) goto L8;
        HashMap<CallContext, List<String>> r103 = this.f93889a;
        HashMap<Object, CallContext> r104 = this.f93890b;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r103.remove(r104.get(r100.f249269d));
        HashMap<Object, CallContext> r105 = this.f93890b;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r105.remove(r100.f249269d);
    L8:
        HashMap<Object, CallContext> r106 = this.f93890b;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r106.put(r100.f249269d, r100);
        this.f93889a.put(r100, r101);
        Map<String, LiveData<Pair<String, JSONObject>>> r107 = this.f93891c;
        LinkedHashMap r108 = new LinkedHashMap();
        Iterator r109 = ((LinkedHashMap) r107).entrySet().iterator();
    L10:
        if (r109.hasNext() == false) goto L14;
        Map.Entry r110 = (Map.Entry) r109.next();
        if (r101.contains((String) r110.getKey()) == false) goto L10;
        r108.put(r110.getKey(), r110.getValue());
        goto L10
    L14:
        Iterator r111 = r108.entrySet().iterator();
    L16:
        if (r111.hasNext() == false) goto L21;
        Map.Entry r112 = (Map.Entry) r111.next();
        String r113 = (String) r112.getKey();
        Pair r114 = (Pair) ((LiveData) r112.getValue()).getValue();
        if (r114 == null) goto L16;
        String r115 = (String) r114.component1();
        JSONObject r116 = (JSONObject) r114.component2();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("H5_revenueInteractData", "key");
        Intrinsics.checkNotNullParameter(r116, "value");
        r100.b("H5_revenueInteractData", r116);
        goto L16
    }
}
