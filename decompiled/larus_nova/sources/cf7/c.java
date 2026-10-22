package cf7;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Map;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
public final class c<T> implements l47.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<b.c> f23534a;

    public c(CompletionBlock<b.c> r100) {
        this.f23534a = r100;
    }

    @Override // l47.a
    public final void accept(Object r100) {
        CompletionBlock<b.c> r101 = this.f23534a;
        XBaseModel r102 = ne7.e.c(Reflection.getOrCreateKotlinClass(b.c.class));
        b.c r103 = (b.c) r102;
        r103.setResult((Map) r100);
        CompletionBlock.DefaultImpls.onSuccess$default(r101, (XBaseResultModel) r102, null, 2, null);
    }
}
