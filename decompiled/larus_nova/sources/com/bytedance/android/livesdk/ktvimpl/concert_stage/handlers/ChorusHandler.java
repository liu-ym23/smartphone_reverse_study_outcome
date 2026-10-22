package com.bytedance.android.livesdk.ktvimpl.concert_stage.handlers;

import com.bytedance.android.live.liveinteract.jsbridge.method.h;
import com.bytedance.android.livesdk.ktvapi.concert_stage.interfaces.IConcertUpdateStatusCallback$Code;
import com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.ConcertStageDataContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ChorusHandler implements ce2.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f143758d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f143759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f143760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f143761c;

    public static final class a {
    }

    static {
    }

    @Override // ce2.a
    public final void release() {
    }

    public final ei6.a c() {
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

    public ChorusHandler(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f143761c = r100;
        this.f143759a = LazyKt.lazy(new ChorusHandler$getStatusHandlers$2(this));
        this.f143760b = LazyKt.lazy(new ChorusHandler$updateStatusHandlers$2(this));
    }

    @Override // ce2.a
    public final JsonObject b(hd2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "getStatus");
        if (r100.getType().length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        Function0 r102 = (Function0) ((Map) this.f143759a.getValue()).get(r100.getType());
        if (r102 == null) goto L14;
        JsonObject r103 = (JsonObject) r102.invoke();
        if (r103 == null) goto L14;
        return r103;
    L14:
        return new JsonObject();
    L8:
        return new JsonObject();
    L5:
        r101 = false;
        goto L6
    }

    @Override // ce2.a
    public final void a(hd2.c r100, h.b r101) {
        Intrinsics.checkNotNullParameter(r100, "updateStatus");
        Intrinsics.checkNotNullParameter(r101, "callback");
        boolean r102 = false;
        if (r100.getType().length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        r101.a(IConcertUpdateStatusCallback$Code.Failed, "Invalid update type", null);
        return;
    L9:
        JsonObject r104 = new JsonObject();
        Function1 r105 = (Function1) ((Map) this.f143760b.getValue()).get(r100.getType());     // Catch: Exception -> L16
        if (r105 == null) goto L14;
        r102 = ((Boolean) r105.invoke(r100.f484590c)).booleanValue();     // Catch: Exception -> L16
        String r106 = "chorus updated successfully";
    L23:
    L18:
        if (r102 == false) goto L20;
        IConcertUpdateStatusCallback$Code r107 = IConcertUpdateStatusCallback$Code.Success;
    L21:
        r101.a(r107, r106, r104);
        return;
    L20:
        r107 = IConcertUpdateStatusCallback$Code.Failed;
        goto L21
    L14:
        r106 = "Unsupported update type: " + r100.getType();     // Catch: Exception -> L16
    L16:
        e = move-exception;
        String r108 = "Error updating status: " + e.getMessage();
        e.printStackTrace();
        r106 = r108;
        goto L18
    L5:
        r103 = false;
        goto L6
    }
}
