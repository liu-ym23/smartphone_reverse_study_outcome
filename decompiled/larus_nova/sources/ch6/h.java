package ch6;

import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybLinkCallScene;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MultiLinkHybLinkCallScene f23784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f23785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JsonObject f23786c;

    public final MultiLinkHybLinkCallScene a() {
        return this.f23784a;
    }

    public final b b() {
        return this.f23785b;
    }

    public final JsonObject c() {
        return this.f23786c;
    }

    public h(MultiLinkHybLinkCallScene r100, b r101, JsonObject r102) {
        Intrinsics.checkNotNullParameter(r100, "callScene");
        Intrinsics.checkNotNullParameter(r101, "changeAction");
        Intrinsics.checkNotNullParameter(r102, "changeExtraJson");
        this.f23784a = r100;
        this.f23785b = r101;
        this.f23786c = r102;
    }
}
