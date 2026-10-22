package com.bytedance.android.ec.core.monitor.listener;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.hybrid.list.util.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public abstract class ActionRateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f45166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f45167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f45168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f45169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f45170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f45171f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f45172g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f45173h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Unit> f45174i;

    public static final class a {
    }

    static {
    }

    public final void d() {
        e(this.f45167b);
    }

    public final void g() {
        h(this.f45167b);
    }

    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        JSONObject r101 = this.f45167b;     // Catch: Exception -> L5
        x0.b(r101, r100, false);     // Catch: Exception -> L5
        this.f45167b = r101;     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public final void b(Pair<String, String>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Iterator r101 = SequencesKt.filter(ArraysKt.asSequence(r100), ActionRateListener$appendCategory$1.INSTANCE).iterator();     // Catch: Exception -> L8
    L5:
        if (r101.hasNext() == false) goto L15;
        Pair r102 = (Pair) r101.next();     // Catch: Exception -> L8
        this.f45167b.put((String) r102.getFirst(), r102.getSecond());     // Catch: Exception -> L8
        goto L5
    L15:
        return;
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public final void e(JSONObject r110) {
        Set<String> r100 = ECProcessMonitor.f45118a;
        String r101 = this.f45172g;
        String r102 = this.f45171f;
        if (r102 != null) goto L5;
        r102 = this.f45173h;
    L5:
        JSONObject r103 = this.f45168c;
        Intrinsics.checkNotNullParameter(this, "listener");
        Intrinsics.checkNotNullParameter(r101, "pageName");
        Intrinsics.checkNotNullParameter(r102, "actionName");
        boolean r104 = this.f45166a;
        if (r110 == null) goto L8;
        JSONObject r111 = x0.a(r110);
    L9:
        JSONObject r105 = r111;
        r105.put("event_type", "rate");
        r105.put("page_name", r101);
        r105.put("action_name", r102);
        r105.put("rate_type", "start");
        Unit r112 = Unit.INSTANCE;
        ECProcessMonitor.i(r104, 0, "ec_full_trade_process_monitor", r105, null, r103, ECProcessMonitor.r(r101, ""));
        this.f45169d = System.currentTimeMillis();
        return;
    L8:
        r111 = new JSONObject();
        goto L9
    }

    public final void f(Map<String, ? extends Object> r100) {
        JSONObject r101 = x0.a(this.f45167b);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L15
        if (r100 == null) goto L12;
        Iterator<Map.Entry<String, ? extends Object>> r103 = r100.entrySet().iterator();     // Catch: Throwable -> L15
    L7:
        if (r103.hasNext() == false) goto L11;
        Map.Entry<String, ? extends Object> r104 = r103.next();     // Catch: Throwable -> L15
        if (r104.getValue() == null) goto L7;
        r101.put(r104.getKey(), r104.getValue());     // Catch: Throwable -> L15
        goto L7
    L11:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L15
    L17:
        e(r101);
        return;
    L12:
        r105 = null;
    L15:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    public final void h(JSONObject r110) {
        Set<String> r100 = ECProcessMonitor.f45118a;
        String r101 = this.f45172g;
        String r102 = this.f45171f;
        if (r102 != null) goto L5;
        r102 = this.f45173h;
    L5:
        JSONObject r103 = this.f45168c;
        Intrinsics.checkNotNullParameter(this, "listener");
        Intrinsics.checkNotNullParameter(r101, "pageName");
        Intrinsics.checkNotNullParameter(r102, "actionName");
        boolean r104 = this.f45166a;
        if (r110 == null) goto L8;
        JSONObject r105 = x0.a(r110);
    L9:
        r105.put("event_type", "rate");
        r105.put("page_name", r101);
        r105.put("action_name", r102);
        r105.put("rate_type", "success");
        Unit r106 = Unit.INSTANCE;
        ECProcessMonitor.i(r104, 0, "ec_full_trade_process_monitor", r105, null, r103, ECProcessMonitor.r(r101, ""));
        if (this.f45169d > 0) goto L12;
    L17:
        this.f45174i.invoke();
        return;
    L12:
        if (this.f45170e == false) goto L17;
        String r107 = this.f45172g;
        String r108 = this.f45171f;
        if (r108 != null) goto L16;
        r108 = this.f45173h;
    L16:
        ECProcessMonitor.j(r107, r108, System.currentTimeMillis() - this.f45169d, r110, this.f45168c);
        goto L17
    L8:
        r105 = new JSONObject();
        goto L9
    }

    public final void i(Map<String, ? extends Object> r100) {
        JSONObject r101 = x0.a(this.f45167b);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L15
        if (r100 == null) goto L12;
        Iterator<Map.Entry<String, ? extends Object>> r103 = r100.entrySet().iterator();     // Catch: Throwable -> L15
    L7:
        if (r103.hasNext() == false) goto L11;
        Map.Entry<String, ? extends Object> r104 = r103.next();     // Catch: Throwable -> L15
        if (r104.getValue() == null) goto L7;
        r101.put(r104.getKey(), r104.getValue());     // Catch: Throwable -> L15
        goto L7
    L11:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L15
    L17:
        h(r101);
        return;
    L12:
        r105 = null;
    L15:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    public ActionRateListener(String r100, String r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        Intrinsics.checkNotNullParameter(r101, "actionName");
        Intrinsics.checkNotNullParameter(r102, "fullFill");
        this.f45172g = r100;
        this.f45173h = r101;
        this.f45174i = r102;
        Set<String> r103 = ECProcessMonitor.f45118a;
        this.f45166a = ECProcessMonitor.q("rate");
        this.f45167b = new JSONObject();
        this.f45168c = new JSONObject();
        this.f45170e = true;
    }

    public static void c(ActionRateListener r100, JSONObject r101, JSONObject r102, boolean r103, int r104) {
        if ((r104 & 1) == 0) goto L5;
        r101 = new JSONObject();
    L5:
        String r105 = null;
        if ((r104 & 2) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = false;
    L11:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "categoryInfo");
        JSONObject r106 = r100.f45167b;     // Catch: Exception -> L28
        x0.b(r106, r101, false);     // Catch: Exception -> L28
        if (r103 == true) goto L24;
        kc.a r107 = com.bytedance.android.bcm.api.b.c(null, CollectionsKt.arrayListOf(new String[]{"ecom_entrance"}));     // Catch: Exception -> L28
        if (r107 == null) goto L23;
        List<kc.a.C6534a> r108 = r107.f502353a;     // Catch: Exception -> L28
        if (r108 == null) goto L23;
        List<kc.a.C6534a> r109 = r108;     // Catch: Exception -> L28
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));     // Catch: Exception -> L28
        Iterator<T> r111 = r109.iterator();     // Catch: Exception -> L28
    L20:
        if (r111.hasNext() == false) goto L22;
        r110.add(((kc.a.C6534a) r111.next()).f502356c);     // Catch: Exception -> L28
        goto L20
    L22:
        r105 = k.d(r110);     // Catch: Exception -> L28
    L23:
        r106.put("btm_list", r105);     // Catch: Exception -> L28
    L24:
        Unit r112 = Unit.INSTANCE;     // Catch: Exception -> L28
        r100.f45167b = r106;     // Catch: Exception -> L28
        if (r102 == null) goto L34;
        JSONObject r113 = r100.f45168c;     // Catch: Exception -> L28
        x0.b(r113, r102, false);     // Catch: Exception -> L28
        r100.f45168c = r113;     // Catch: Exception -> L28
        return;
    L34:
        return;
    L28:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }
}
