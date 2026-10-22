package com.bytedance.android.live.liveinteract.videotalk.utils.panel;

import com.google.gson.JsonObject;
import java.util.concurrent.Callable;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes46.dex */
public final class o<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JsonObject f79869a;

    public o(JsonObject r100) {
        this.f79869a = r100;
    }

    @Override // java.util.concurrent.Callable
    public final JsonObject call() {
        JsonObject r100 = new JsonObject();
        Lazy r101 = MultiLinkLynxSettingPanelActionHandler.f79826a;
        JsonObject r102 = MultiLinkLynxSettingPanelActionHandler.b(this.f79869a);
        if (r102 == null) goto L5;
        r100.add("settings", r102);
    L5:
        JsonObject r103 = MultiLinkLynxSettingPanelActionHandler.a(this.f79869a);
        if (r103 == null) goto L8;
        r100.add("local_storage", r103);
    L8:
        return r100;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
