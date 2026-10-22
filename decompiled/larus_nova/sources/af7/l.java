package af7;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ShowActionSheetListener;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
public final class l implements ShowActionSheetListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<d.e> f3222a;

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.ShowActionSheetListener
    public final void onDismiss() {
        CompletionBlock<d.e> r100 = this.f3222a;
        XBaseModel r101 = ne7.e.c(Reflection.getOrCreateKotlinClass(d.e.class));
        ((d.e) r101).setAction("dismiss");
        CompletionBlock.DefaultImpls.onSuccess$default(r100, (XBaseResultModel) r101, null, 2, null);
    }

    public l(CompletionBlock<d.e> r100) {
        this.f3222a = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.ShowActionSheetListener
    public final void onSelect(int r100) {
        CompletionBlock<d.e> r101 = this.f3222a;
        XBaseModel r102 = ne7.e.c(Reflection.getOrCreateKotlinClass(d.e.class));
        d.e r103 = (d.e) r102;
        r103.setAction("select");
        d.c r104 = (d.c) ne7.e.c(Reflection.getOrCreateKotlinClass(d.c.class));
        r104.setIndex(Integer.valueOf(r100));
        r103.setDetail(r104);
        CompletionBlock.DefaultImpls.onSuccess$default(r101, (XBaseResultModel) r102, null, 2, null);
    }
}
