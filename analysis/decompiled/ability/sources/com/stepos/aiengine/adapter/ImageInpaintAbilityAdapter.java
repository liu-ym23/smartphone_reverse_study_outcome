package com.stepos.aiengine.adapter;

import android.os.Bundle;
import androidx.annotation.RequiresApi;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.task.executor.e;
import com.stepos.aiengine.algorithm.imageinpaint.IImageInpaint;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.core.c;
import com.stepos.core.d;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.MixedContent;
import d5.j;
import java.util.LinkedHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.b;
import kotlin.collections.a;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.k;

@RequiresApi(26)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J1\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/aiengine/adapter/ImageInpaintAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/imageinpaint/IImageInpaint;", "Lcom/stepos/core/c;", "handle", AppAgent.CONSTRUCT, "(Lcom/stepos/core/c;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "token", "Landroid/os/Bundle;", "images", "", "seed", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "progressCallback", "inpaintImage", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;JLcom/stepos/aiengine/api/task/IBundleCallback;)Landroid/os/Bundle;", "identity", "", "cancel", "(J)Z", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ImageInpaintAbilityAdapter implements IImageInpaint {

    /* renamed from: a, reason: collision with root package name */
    public final c f3467a;

    public ImageInpaintAbilityAdapter(c handle) {
        k.f(handle, "handle");
        this.f3467a = handle;
    }

    @Override // com.stepos.aiengine.algorithm.imageinpaint.IImageInpaint
    public boolean cancel(long identity) {
        return this.f3467a.a(String.valueOf(identity));
    }

    @Override // com.stepos.aiengine.algorithm.imageinpaint.IImageInpaint
    public Bundle inpaintImage(AlgorithmToken token, Bundle images, long seed, final IBundleCallback progressCallback) throws InterruptedException {
        Object objA;
        k.f(token, "token");
        k.f(images, "images");
        try {
            MixedContent mixedContentZ = e.z(images);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("seed", new j(seed));
            mixedContentZ.setParams(new ContentParams(a.Y(linkedHashMap), null));
            objA = mixedContentZ;
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Bundle bundle = new Bundle();
            bundle.putString("exception", "inpaintImage: " + thA.getMessage());
            return bundle;
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f3467a.g(String.valueOf(token.getIdentity()), (MixedContent) objA, new d() { // from class: com.stepos.aiengine.adapter.ImageInpaintAbilityAdapter.inpaintImage.1
            @Override // com.stepos.core.d
            public void onNext(String inferId, com.stepos.core.callback.c result) {
                k.f(inferId, "inferId");
                k.f(result, "result");
                boolean z10 = result instanceof com.stepos.core.callback.b;
                CountDownLatch countDownLatch2 = countDownLatch;
                if (!z10) {
                    if (!result.equals(com.stepos.core.callback.a.f3826a)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    countDownLatch2.countDown();
                } else {
                    Bundle bundle2 = new Bundle();
                    com.stepos.core.callback.b bVar = (com.stepos.core.callback.b) result;
                    bundle2.putString("exception", androidx.constraintlayout.core.dsl.a.c(bVar.f3827a, "infer error(", "): ", bVar.b));
                    ref$ObjectRef.f4920a = bundle2;
                    countDownLatch2.countDown();
                }
            }
        });
        countDownLatch.await(120L, TimeUnit.SECONDS);
        Bundle bundle2 = (Bundle) ref$ObjectRef.f4920a;
        if (bundle2 != null) {
            return bundle2;
        }
        Bundle bundle3 = new Bundle();
        bundle3.putString("exception", "infer timeout");
        return bundle3;
    }
}
