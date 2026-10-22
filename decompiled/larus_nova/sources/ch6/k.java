package ch6;

import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybLinkCallScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MultiLinkHybLinkCallScene f23794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f23795b;

    public k(MultiLinkHybLinkCallScene r100, e r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "callScene");
        Intrinsics.checkNotNullParameter(r101, "getAction");
        Intrinsics.checkNotNullParameter(r102, "getExtraJsonStr");
        this.f23794a = r100;
        this.f23795b = r101;
    }
}
