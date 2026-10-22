package com.stepos.aiengine.adapter;

import M5.b;
import android.os.Bundle;
import android.system.ErrnoException;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.imageinpaint.IImageInpaint;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.core.AbilityHandle;
import com.stepos.core.InferenceCallback;
import com.stepos.core.ability.converter.BundleContentBridge;
import com.stepos.core.callback.InferResult;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.base.Content;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J1\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/aiengine/adapter/ImageInpaintAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/imageinpaint/IImageInpaint;", "Lcom/stepos/core/AbilityHandle;", "handle", "<init>", "(Lcom/stepos/core/AbilityHandle;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", b.CREDENTIAL_TOKEN, "Landroid/os/Bundle;", "images", "", "seed", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "progressCallback", "inpaintImage", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;JLcom/stepos/aiengine/api/task/IBundleCallback;)Landroid/os/Bundle;", e.f30860s, "", "cancel", "(J)Z", Const.INTENT_KEY_APIKEY, "Lcom/stepos/core/AbilityHandle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ImageInpaintAbilityAdapter implements IImageInpaint {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    public ImageInpaintAbilityAdapter(AbilityHandle handle) {
        p.i(handle, "handle");
        this.handle = handle;
    }

    @Override // com.stepos.aiengine.algorithm.imageinpaint.IImageInpaint
    public boolean cancel(long identity) {
        return this.handle.cancel(String.valueOf(identity));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.stepos.aiengine.algorithm.imageinpaint.IImageInpaint
    public Bundle inpaintImage(AlgorithmToken token, Bundle images, long seed, final IBundleCallback progressCallback) throws InterruptedException {
        Object objB;
        p.i(token, "token");
        p.i(images, "images");
        try {
            Result.Companion companion = Result.INSTANCE;
            MixedContent mixedContentFromMultiImageBundle = BundleContentBridge.INSTANCE.fromMultiImageBundle(images);
            ContentParams.Builder builderPutLong = new ContentParams.Builder().putLong("seed", seed);
            TaskPriorityArg.INSTANCE.applyTo(builderPutLong, images);
            mixedContentFromMultiImageBundle.setParams(builderPutLong.build());
            objB = Result.b(mixedContentFromMultiImageBundle);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Bundle bundle = new Bundle();
            bundle.putString("exception", "inpaintImage: " + thE.getMessage());
            return bundle;
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.handle.infer(String.valueOf(token.getIdentity()), (String) objB, (InferenceCallback) new InferenceCallback<Content>() { // from class: com.stepos.aiengine.adapter.ImageInpaintAbilityAdapter.inpaintImage.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v0, types: [T, android.os.BaseBundle, android.os.Bundle] */
            @Override // com.stepos.core.InferenceCallback
            public void onNext(String inferId, InferResult<? extends Content> result) throws ErrnoException {
                T singleImageBundle;
                p.i(inferId, "inferId");
                p.i(result, "result");
                if (result instanceof InferResult.Result) {
                    Content value = ((InferResult.Result) result).getValue();
                    ImageContent imageContent = value instanceof ImageContent ? (ImageContent) value : null;
                    Ref$ObjectRef<Bundle> ref$ObjectRef2 = ref$ObjectRef;
                    if (imageContent != null) {
                        singleImageBundle = BundleContentBridge.INSTANCE.toSingleImageBundle(imageContent);
                    } else {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("exception", "unexpected output type");
                        singleImageBundle = bundle2;
                    }
                    ref$ObjectRef2.f34820a = singleImageBundle;
                    countDownLatch.countDown();
                    return;
                }
                if (result instanceof InferResult.Error) {
                    Ref$ObjectRef<Bundle> ref$ObjectRef3 = ref$ObjectRef;
                    ?? bundle3 = new Bundle();
                    InferResult.Error error = (InferResult.Error) result;
                    bundle3.putString("exception", "infer error(" + error.getErrorCode() + "): " + error.getMessage());
                    ref$ObjectRef3.f34820a = bundle3;
                    countDownLatch.countDown();
                    return;
                }
                if (p.d(result, InferResult.Complete.INSTANCE)) {
                    countDownLatch.countDown();
                    return;
                }
                if (result instanceof InferResult.Cancelled) {
                    countDownLatch.countDown();
                    return;
                }
                if (result instanceof InferResult.RoutingDecision) {
                    return;
                }
                if (!(result instanceof InferResult.Progress)) {
                    throw new NoWhenBranchMatchedException();
                }
                IBundleCallback iBundleCallback = progressCallback;
                if (iBundleCallback != null) {
                    Bundle bundle4 = new Bundle();
                    bundle4.putInt("percent", ((InferResult.Progress) result).getPercent());
                    iBundleCallback.onCall(bundle4);
                }
            }
        });
        boolean zAwait = countDownLatch.await(120L, TimeUnit.SECONDS);
        Bundle bundle2 = (Bundle) ref$ObjectRef.f34820a;
        if (bundle2 == null) {
            bundle2 = new Bundle();
            bundle2.putString("exception", zAwait ? "infer completed without result" : "infer timeout");
        }
        return bundle2;
    }
}
