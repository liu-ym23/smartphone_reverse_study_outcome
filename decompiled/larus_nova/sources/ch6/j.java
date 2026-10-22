package ch6;

import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybLinkCallScene;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MultiLinkHybLinkCallScene f23791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f23792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JsonObject f23793c;

    public j(MultiLinkHybLinkCallScene r100, c r101, JsonObject r102) {
        Intrinsics.checkNotNullParameter(r100, "callScene");
        Intrinsics.checkNotNullParameter(r101, "eventType");
        Intrinsics.checkNotNullParameter(r102, "eventExtraJson");
        this.f23791a = r100;
        this.f23792b = r101;
        this.f23793c = r102;
    }
}
