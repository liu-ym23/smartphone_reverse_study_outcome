package af7;

import android.content.DialogInterface;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
public final class p implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<f.c> f3223a;

    public p(CompletionBlock<f.c> r100) {
        this.f3223a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        CompletionBlock<f.c> r102 = this.f3223a;
        XBaseModel r103 = ne7.e.c(Reflection.getOrCreateKotlinClass(f.c.class));
        ((f.c) r103).setAction("cancel");
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) r103, null, 2, null);
    }
}
