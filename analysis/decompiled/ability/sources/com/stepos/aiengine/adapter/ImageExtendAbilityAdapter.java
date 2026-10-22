package com.stepos.aiengine.adapter;

import android.graphics.Rect;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.task.executor.e;
import com.stepos.aiengine.algorithm.imageextend.IImageExtend;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.core.c;
import com.stepos.core.d;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.base.Content;
import d5.i;
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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J9\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/aiengine/adapter/ImageExtendAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/imageextend/IImageExtend;", "Lcom/stepos/core/c;", "handle", AppAgent.CONSTRUCT, "(Lcom/stepos/core/c;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "token", "Landroid/os/Bundle;", "image", "", "seed", "extendPixels", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "progressCallback", "extendImage", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;JLandroid/os/Bundle;Lcom/stepos/aiengine/api/task/IBundleCallback;)Landroid/os/Bundle;", "identity", "", "cancel", "(J)Z", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ImageExtendAbilityAdapter implements IImageExtend {

    /* renamed from: a, reason: collision with root package name */
    public final c f3465a;

    public ImageExtendAbilityAdapter(c handle) {
        k.f(handle, "handle");
        this.f3465a = handle;
    }

    @Override // com.stepos.aiengine.algorithm.imageextend.IImageExtend
    public boolean cancel(long identity) {
        return this.f3465a.a(String.valueOf(identity));
    }

    @Override // com.stepos.aiengine.algorithm.imageextend.IImageExtend
    public Bundle extendImage(AlgorithmToken algorithmToken, Bundle bundle, long j5, Rect rect, IBundleCallback iBundleCallback) {
        return IImageExtend.DefaultImpls.extendImage(this, algorithmToken, bundle, j5, rect, iBundleCallback);
    }

    @Override // com.stepos.aiengine.algorithm.imageextend.IImageExtend
    public Bundle extendImage(AlgorithmToken token, Bundle image, long seed, Bundle extendPixels, final IBundleCallback progressCallback) throws InterruptedException {
        Object objA;
        k.f(token, "token");
        k.f(image, "image");
        k.f(extendPixels, "extendPixels");
        try {
            Content contentA = e.A(image);
            objA = contentA instanceof ImageContent ? (ImageContent) contentA : null;
            if (objA == null) {
                Bundle bundle = new Bundle();
                bundle.putString("exception", "extendImage: image is not a bitmap");
                return bundle;
            }
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("exception", "extendImage: " + thA.getMessage());
            return bundle2;
        }
        ImageContent imageContent = (ImageContent) objA;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("seed", new j(seed));
        linkedHashMap.put("left", new i(extendPixels.getInt("left", 0)));
        linkedHashMap.put("top", new i(extendPixels.getInt("top", 0)));
        linkedHashMap.put("right", new i(extendPixels.getInt("right", 0)));
        linkedHashMap.put("bottom", new i(extendPixels.getInt("bottom", 0)));
        imageContent.setParams(new ContentParams(a.Y(linkedHashMap), null));
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f3465a.g(String.valueOf(token.getIdentity()), imageContent, new d() { // from class: com.stepos.aiengine.adapter.ImageExtendAbilityAdapter.extendImage.1
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
                    Bundle bundle3 = new Bundle();
                    com.stepos.core.callback.b bVar = (com.stepos.core.callback.b) result;
                    bundle3.putString("exception", androidx.constraintlayout.core.dsl.a.c(bVar.f3827a, "infer error(", "): ", bVar.b));
                    ref$ObjectRef.f4920a = bundle3;
                    countDownLatch2.countDown();
                }
            }
        });
        countDownLatch.await(120L, TimeUnit.SECONDS);
        imageContent.releaseSharedMemory();
        Bundle bundle3 = (Bundle) ref$ObjectRef.f4920a;
        if (bundle3 != null) {
            return bundle3;
        }
        Bundle bundle4 = new Bundle();
        bundle4.putString("exception", "infer timeout");
        return bundle4;
    }
}
