package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftPanelTraceService implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONArray f131390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<JSONObject> f131391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f131392c;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        com.bytedance.live.kmp.util.d.b(0, false, new AnonymousClass1(this), 7);
    }

    public GiftPanelTraceService() {
        this.f131390a = new JSONArray();
        this.f131391b = new CopyOnWriteArrayList();
        this.f131392c = new JSONObject();
    }

    public final void c(final JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        com.bytedance.live.kmp.util.d.b(0, false, new GiftPanelTraceService$addStateTrace$1(this, r100), 7);
    }

    public final void d(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceInfo");
        com.bytedance.live.kmp.util.d.b(0, false, new GiftPanelTraceService$addTraceString$1(this, r100), 7);
    }

    public final void a(final String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r101, "actionInfo");
        com.bytedance.live.kmp.util.d.b(0, false, new GiftPanelTraceService$addActionTrace$1(this, r100, r101), 7);
    }
}
