package ch6;

import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybLinkCallScene;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f23787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MultiLinkHybLinkCallScene f23788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f23789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JsonObject f23790d;

    public i(boolean r100, MultiLinkHybLinkCallScene r101, b r102, JsonObject r103) {
        Intrinsics.checkNotNullParameter(r101, "callScene");
        Intrinsics.checkNotNullParameter(r102, "changeAction");
        Intrinsics.checkNotNullParameter(r103, "changeRspExtraJson");
        this.f23787a = r100;
        this.f23788b = r101;
        this.f23789c = r102;
        this.f23790d = r103;
    }
}
