package com.stepos.aiengine.adapter;

import android.graphics.Rect;
import android.os.Bundle;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.algorithm.imageextend.IImageExtend;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0016¨\u0006\u0011"}, d2 = {"Lcom/stepos/aiengine/adapter/ImageExtendStubAdapter;", "Lcom/stepos/aiengine/algorithm/imageextend/IImageExtend;", AppAgent.CONSTRUCT, "()V", "extendImage", "Landroid/os/Bundle;", "token", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "image", "seed", "", "extendPixels", "progressCallback", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "cancel", "", "identity", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ImageExtendStubAdapter implements IImageExtend {
    @Override // com.stepos.aiengine.algorithm.imageextend.IImageExtend
    public boolean cancel(long identity) {
        return false;
    }

    @Override // com.stepos.aiengine.algorithm.imageextend.IImageExtend
    public Bundle extendImage(AlgorithmToken algorithmToken, Bundle bundle, long j5, Rect rect, IBundleCallback iBundleCallback) {
        return IImageExtend.DefaultImpls.extendImage(this, algorithmToken, bundle, j5, rect, iBundleCallback);
    }

    @Override // com.stepos.aiengine.algorithm.imageextend.IImageExtend
    public Bundle extendImage(AlgorithmToken token, Bundle image, long seed, Bundle extendPixels, IBundleCallback progressCallback) {
        k.f(token, "token");
        k.f(image, "image");
        k.f(extendPixels, "extendPixels");
        Bundle bundle = new Bundle();
        bundle.putString("exception", "ImageExtend: not implemented yet");
        return bundle;
    }
}
