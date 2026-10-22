package com.bytedance.android.livesdk.ktvimpl.concert_stage.handlers;

import androidx.collection.ArraySet;
import com.bytedance.android.live.liveinteract.jsbridge.method.h;
import com.bytedance.android.livesdk.ktvapi.concert_stage.interfaces.IConcertUpdateStatusCallback$Code;
import com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.ConcertStageDataContext;
import com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.w;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.google.gson.JsonObject;
import gd2.d;
import gd2.f;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class TuningHandler implements ce2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f143766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Integer> f143767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f143768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f143769d;

    @Override // ce2.a
    public final void release() {
    }

    public static d e() {
        f r100 = ConcertStageDataContext.Companion.a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getConcertEarMonitor();
    }

    public final ei6.a d() {
        ConcertStageDataContext r100 = ConcertStageDataContext.Companion.getContext();
        if (r100 == null) goto L9;
        j<js1.a> r101 = r100.getLinkComponent();
        if (r101 == null) goto L9;
        js1.a r102 = r101.getValue();
        if (r102 == null) goto L9;
        return r102.a();
    L9:
        return null;
    }

    public TuningHandler(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f143766a = "TuningHandler";
        this.f143767b = new LinkedHashMap();
        new ArraySet();
        this.f143768c = LazyKt.lazy(new TuningHandler$getStatusHandlers$2(this));
        this.f143769d = LazyKt.lazy(new TuningHandler$updateStatusHandlers$2(this));
    }

    public static JsonObject c(String r100) {
        JsonObject r101 = new JsonObject();
        r101.addProperty("code", -1);
        r101.addProperty("message", r100);
        return r101;
    }

    @Override // ce2.a
    public final JsonObject b(hd2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "getStatus");
        String r101 = r100.getType();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L21;
        w.a(this.f143766a, "getStatus: type is null or empty");
        return c("Invalid type");
    L21:
        Function0 r103 = (Function0) ((Map) this.f143768c.getValue()).get(r100.getType());     // Catch: Exception -> L18
        if (r103 == null) goto L16;
        JsonObject r104 = (JsonObject) r103.invoke();     // Catch: Exception -> L18
        if (r104 == null) goto L16;
        return r104;
    L16:
        w.a(this.f143766a, "getStatus: Unsupported type=" + r100.getType());     // Catch: Exception -> L18
        return c("Unsupported type");
    L18:
        e = move-exception;
        w.a(this.f143766a, "getStatus: Error handling type=" + r100.getType() + ", e=" + e.getMessage());
        return c("Internal error: " + e.getMessage());
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // ce2.a
    public final void a(hd2.c r100, h.b r101) {
        Intrinsics.checkNotNullParameter(r100, "updateStatus");
        Intrinsics.checkNotNullParameter(r101, "callback");
        String r102 = r100.getType();
        boolean r103 = false;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.a(IConcertUpdateStatusCallback$Code.Failed, "Invalid update type", null);
        return;
    L12:
        JsonObject r105 = new JsonObject();
        Function1 r106 = (Function1) ((Map) this.f143769d.getValue()).get(r100.getType());     // Catch: Exception -> L19
        if (r106 == null) goto L17;
        r103 = ((Boolean) r106.invoke(r100.f484590c)).booleanValue();     // Catch: Exception -> L19
        String r107 = "Tuning updated successfully";
    L26:
    L21:
        if (r103 == false) goto L23;
        IConcertUpdateStatusCallback$Code r108 = IConcertUpdateStatusCallback$Code.Success;
    L24:
        r101.a(r108, r107, r105);
        return;
    L23:
        r108 = IConcertUpdateStatusCallback$Code.Failed;
        goto L24
    L17:
        r107 = "Unsupported update type: " + r100.getType();     // Catch: Exception -> L19
    L19:
        e = move-exception;
        String r109 = "Error updating status: " + e.getMessage();
        e.printStackTrace();
        r107 = r109;
        goto L21
    L5:
        if (r102.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}
