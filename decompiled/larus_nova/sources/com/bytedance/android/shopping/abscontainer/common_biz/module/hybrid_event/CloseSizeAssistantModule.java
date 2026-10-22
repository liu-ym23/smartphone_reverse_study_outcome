package com.bytedance.android.shopping.abscontainer.common_biz.module.hybrid_event;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import v43.r;

/* JADX INFO: loaded from: classes12.dex */
public final class CloseSizeAssistantModule<STATE extends r, PROPS extends u33.a> extends s33.b<STATE, PROPS> implements o33.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k33.a f164323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f164324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f164325d;

    @Override // o33.b
    public final String getEventName() {
        return this.f164325d;
    }

    @Override // s33.b
    public final String j() {
        return this.f164324c;
    }

    public CloseSizeAssistantModule(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164324c = "CloseSizeAssistantModule";
        this.f164325d = "CLIENT_SHOULD_UPDATE_RECOMMEND_SIZE";
    }

    @Override // o33.b
    public final void a(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        k33.a r101 = this.f164323b;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        this.f164323b = this.f540457a.f507250d.e().c(new CloseSizeAssistantModule$onReceivedEvent$1(this, null));
    }
}
