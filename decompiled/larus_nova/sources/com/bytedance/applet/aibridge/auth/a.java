package com.bytedance.applet.aibridge.auth;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.platform.api.d5;
import f3.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements d5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h<AbsCheckDouyinOpenAuthStatusMethodIDL.b> f190895a;

    public a(h<AbsCheckDouyinOpenAuthStatusMethodIDL.b> r100) {
        this.f190895a = r100;
    }

    @Override // com.larus.platform.api.d5
    public final void a(boolean r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "clientKey");
        Intrinsics.checkNotNullParameter(r102, "scope");
        Intrinsics.checkNotNullParameter(r103, "state");
        h<AbsCheckDouyinOpenAuthStatusMethodIDL.b> r104 = this.f190895a;
        Intrinsics.checkNotNullParameter(AbsCheckDouyinOpenAuthStatusMethodIDL.b.class, "<this>");
        BaseModel r105 = k3.c.a(AbsCheckDouyinOpenAuthStatusMethodIDL.b.class);
        ((AbsCheckDouyinOpenAuthStatusMethodIDL.b) r105).setAuthorized(r100);
        h.a.b(r104, (ResultModel) r105);
    }
}
