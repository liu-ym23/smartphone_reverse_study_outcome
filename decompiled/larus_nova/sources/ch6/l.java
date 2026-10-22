package ch6;

import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybGuestLinkGetAction;
import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybLinkCallScene;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MultiLinkHybLinkCallScene f23796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f23797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JsonObject f23798c;

    public /* synthetic */ l(MultiLinkHybLinkCallScene r100, MultiLinkHybGuestLinkGetAction r101) {
        this(r100, r101, new JsonObject());
    }

    public l(MultiLinkHybLinkCallScene r100, e r101, JsonObject r102) {
        Intrinsics.checkNotNullParameter(r100, "callScene");
        Intrinsics.checkNotNullParameter(r101, "getAction");
        Intrinsics.checkNotNullParameter(r102, "getRspExtraJson");
        this.f23796a = r100;
        this.f23797b = r101;
        this.f23798c = r102;
    }
}
