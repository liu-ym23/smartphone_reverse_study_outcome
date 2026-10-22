package cf7;

import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;

/* JADX INFO: loaded from: classes22.dex */
public final class g<T> implements l47.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<a.c> f23537a;

    public g(CompletionBlock<a.c> r100) {
        this.f23537a = r100;
    }

    @Override // l47.a
    public final void accept(Object r100) {
        PiaMethod.Error r101 = (PiaMethod.Error) r100;
        CompletionBlock<a.c> r102 = this.f23537a;
        if (r101 == null) goto L5;
        int r103 = r101.getCode();
    L6:
        if (r101 == null) goto L9;
        String r104 = r101.getMessage();
        if (r104 == null) goto L9;
    L10:
        CompletionBlock.DefaultImpls.onFailure$default(r102, r103, r104, null, 4, null);
        return;
    L9:
        r104 = "";
        goto L10
    L5:
        r103 = 0;
        goto L6
    }
}
