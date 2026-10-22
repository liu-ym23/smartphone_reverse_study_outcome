package com.bytedance.ai.bridge.method.media;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.media.image.AbsPreviewImageMethodIDL;
import com.bytedance.ai.bridge.service.PreviewImageCallback;
import com.bytedance.ai.utils.g;
import f3.h;
import k3.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements PreviewImageCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h<AbsPreviewImageMethodIDL.a> f35572a;

    @Override // com.bytedance.ai.bridge.service.PreviewImageCallback
    public final void onSuccess() {
        g.f37637a.i("AISDK_JSB_PreviewImageMethod", "call success");
        h<AbsPreviewImageMethodIDL.a> r100 = this.f35572a;
        Intrinsics.checkNotNullParameter(AbsPreviewImageMethodIDL.a.class, "<this>");
        h.a.b(r100, (ResultModel) c.a(AbsPreviewImageMethodIDL.a.class));
    }

    public a(h<AbsPreviewImageMethodIDL.a> r100) {
        this.f35572a = r100;
    }

    @Override // com.bytedance.ai.bridge.service.PreviewImageCallback
    public final void onFail(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        g r101 = g.f37637a;
        StringBuilder r102 = new StringBuilder("call failed, errNo=");
        f3.a r103 = f3.a.f475265f;
        r102.append(r103.f475285a);
        r102.append(", msg=");
        r102.append(r100);
        r101.e("AISDK_JSB_PreviewImageMethod", r102.toString());
        h.a.a(this.f35572a, r100, r103, null, 10);
    }
}
