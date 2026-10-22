package com.stepos.aiengine.adapter;

import M5.b;
import android.graphics.Rect;
import android.os.Bundle;
import android.system.ErrnoException;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.imageextend.IImageExtend;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.core.AbilityHandle;
import com.stepos.core.InferenceCallback;
import com.stepos.core.ability.converter.BundleContentBridge;
import com.stepos.core.ability.converter.VisionParamKeys;
import com.stepos.core.callback.InferResult;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.ImageContent;
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

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J9\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/aiengine/adapter/ImageExtendAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/imageextend/IImageExtend;", "Lcom/stepos/core/AbilityHandle;", "handle", "<init>", "(Lcom/stepos/core/AbilityHandle;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", b.CREDENTIAL_TOKEN, "Landroid/os/Bundle;", "image", "", "seed", "extendPixels", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "progressCallback", "extendImage", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;JLandroid/os/Bundle;Lcom/stepos/aiengine/api/task/IBundleCallback;)Landroid/os/Bundle;", e.f30860s, "", "cancel", "(J)Z", Const.INTENT_KEY_APIKEY, "Lcom/stepos/core/AbilityHandle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ImageExtendAbilityAdapter implements IImageExtend {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    public ImageExtendAbilityAdapter(AbilityHandle handle) {
        p.i(handle, "handle");
        this.handle = handle;
    }

    @Override // com.stepos.aiengine.algorithm.imageextend.IImageExtend
    public boolean cancel(long identity) {
        return this.handle.cancel(String.valueOf(identity));
    }

    @Override // com.stepos.aiengine.algorithm.imageextend.IImageExtend
    public Bundle extendImage(AlgorithmToken algorithmToken, Bundle bundle, long j10, Rect rect, IBundleCallback iBundleCallback) {
        return IImageExtend.DefaultImpls.extendImage(this, algorithmToken, bundle, j10, rect, iBundleCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.stepos.aiengine.algorithm.imageextend.IImageExtend
    public Bundle extendImage(AlgorithmToken token, Bundle image, long seed, Bundle extendPixels, final IBundleCallback progressCallback) throws InterruptedException {
        Object objB;
        ImageContent imageContent;
        p.i(token, "token");
        p.i(image, "image");
        p.i(extendPixels, "extendPixels");
        try {
            Result.Companion companion = Result.INSTANCE;
            Content content = BundleContentBridge.INSTANCE.fromVisionImageBundle(image, false).getContent();
            imageContent = content instanceof ImageContent ? (ImageContent) content : null;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (imageContent == null) {
            Bundle bundle = new Bundle();
            bundle.putString("exception", "extendImage: image is not a bitmap");
            return bundle;
        }
        objB = Result.b(imageContent);
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("exception", "extendImage: " + thE.getMessage());
            return bundle2;
        }
        ImageContent imageContent2 = (ImageContent) objB;
        ContentParams.Builder builderPutInt = new ContentParams.Builder().putLong(VisionParamKeys.INFERENCE_SEED, seed).putInt(VisionParamKeys.EXTEND_LEFT, extendPixels.getInt("left", 0)).putInt(VisionParamKeys.EXTEND_TOP, extendPixels.getInt("top", 0)).putInt(VisionParamKeys.EXTEND_RIGHT, extendPixels.getInt("right", 0)).putInt(VisionParamKeys.EXTEND_BOTTOM, extendPixels.getInt("bottom", 0));
        TaskPriorityArg.INSTANCE.applyTo(builderPutInt, image);
        imageContent2.setParams(builderPutInt.build());
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.handle.infer(String.valueOf(token.getIdentity()), (String) imageContent2, (InferenceCallback) new InferenceCallback<Content>() { // from class: com.stepos.aiengine.adapter.ImageExtendAbilityAdapter.extendImage.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v0, types: [T, android.os.BaseBundle, android.os.Bundle] */
            @Override // com.stepos.core.InferenceCallback
            public void onNext(String inferId, InferResult<? extends Content> result) throws ErrnoException {
                T singleImageBundle;
                p.i(inferId, "inferId");
                p.i(result, "result");
                if (result instanceof InferResult.Result) {
                    Content value = ((InferResult.Result) result).getValue();
                    ImageContent imageContent3 = value instanceof ImageContent ? (ImageContent) value : null;
                    Ref$ObjectRef<Bundle> ref$ObjectRef2 = ref$ObjectRef;
                    if (imageContent3 != null) {
                        singleImageBundle = BundleContentBridge.INSTANCE.toSingleImageBundle(imageContent3);
                    } else {
                        Bundle bundle3 = new Bundle();
                        bundle3.putString("exception", "unexpected output type");
                        singleImageBundle = bundle3;
                    }
                    ref$ObjectRef2.f34820a = singleImageBundle;
                    countDownLatch.countDown();
                    return;
                }
                if (result instanceof InferResult.Error) {
                    Ref$ObjectRef<Bundle> ref$ObjectRef3 = ref$ObjectRef;
                    ?? bundle4 = new Bundle();
                    InferResult.Error error = (InferResult.Error) result;
                    bundle4.putString("exception", "infer error(" + error.getErrorCode() + "): " + error.getMessage());
                    ref$ObjectRef3.f34820a = bundle4;
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
                    Bundle bundle5 = new Bundle();
                    bundle5.putInt("percent", ((InferResult.Progress) result).getPercent());
                    iBundleCallback.onCall(bundle5);
                }
            }
        });
        boolean zAwait = countDownLatch.await(120L, TimeUnit.SECONDS);
        imageContent2.releaseSharedMemory();
        Bundle bundle3 = (Bundle) ref$ObjectRef.f34820a;
        if (bundle3 == null) {
            bundle3 = new Bundle();
            bundle3.putString("exception", zAwait ? "infer completed without result" : "infer timeout");
        }
        return bundle3;
    }
}
