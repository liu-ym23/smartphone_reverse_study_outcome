package cf7;

import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;

/* JADX INFO: loaded from: classes22.dex */
public final class d<T> implements l47.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<b.c> f23535a;

    public d(CompletionBlock<b.c> r100) {
        this.f23535a = r100;
    }

    @Override // l47.a
    public final void accept(Object r100) {
        PiaMethod.Error r101 = (PiaMethod.Error) r100;
        CompletionBlock<b.c> r102 = this.f23535a;
        int r103 = r101.getCode();
        String r104 = r101.getMessage();
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        CompletionBlock.DefaultImpls.onFailure$default(r102, r103, r104, null, 4, null);
    }
}
