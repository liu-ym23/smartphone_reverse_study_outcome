package af7;

import android.content.DialogInterface;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
public final class q implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<f.c> f3224a;

    public q(CompletionBlock<f.c> r100) {
        this.f3224a = r100;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        CompletionBlock<f.c> r101 = this.f3224a;
        XBaseModel r102 = ne7.e.c(Reflection.getOrCreateKotlinClass(f.c.class));
        ((f.c) r102).setAction(BuyNowCloseMethod.MASK);
        CompletionBlock.DefaultImpls.onSuccess$default(r101, (XBaseResultModel) r102, null, 2, null);
    }
}
