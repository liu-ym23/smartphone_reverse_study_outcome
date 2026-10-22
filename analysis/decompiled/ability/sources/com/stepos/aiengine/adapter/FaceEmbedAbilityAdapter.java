package com.stepos.aiengine.adapter;

import Q4.g;
import Q4.h;
import Q4.j;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.task.executor.e;
import com.stepos.aiengine.algorithm.face.IFaceEmbed;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.core.c;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.base.Content;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.b;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.k;

@RequiresApi(26)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/aiengine/adapter/FaceEmbedAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/face/IFaceEmbed;", "Lcom/stepos/core/c;", "handle", AppAgent.CONSTRUCT, "(Lcom/stepos/core/c;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "token", "Landroid/os/Bundle;", "image", "extractFeature", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;)Landroid/os/Bundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FaceEmbedAbilityAdapter implements IFaceEmbed {

    /* renamed from: a, reason: collision with root package name */
    public final c f3461a;

    public FaceEmbedAbilityAdapter(c handle) {
        k.f(handle, "handle");
        this.f3461a = handle;
    }

    @Override // com.stepos.aiengine.algorithm.face.IFaceEmbed
    public Bundle extractFeature(AlgorithmToken token, Bundle image) throws InterruptedException {
        Object objA;
        k.f(token, "token");
        k.f(image, "image");
        try {
            objA = e.A(image);
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Bundle bundle = new Bundle();
            bundle.putString("exception", "extractFeature: " + thA.getMessage());
            return bundle;
        }
        Content content = (Content) objA;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        c.i(this.f3461a, String.valueOf(token.getIdentity()), content, new j(ref$ObjectRef, this, countDownLatch, 0), new g(ref$ObjectRef, countDownLatch, 3), new h(countDownLatch, 3));
        countDownLatch.await(30L, TimeUnit.SECONDS);
        ImageContent imageContent = content instanceof ImageContent ? (ImageContent) content : null;
        if (imageContent != null) {
            imageContent.releaseSharedMemory();
        }
        Bundle bundle2 = (Bundle) ref$ObjectRef.f4920a;
        if (bundle2 != null) {
            return bundle2;
        }
        Bundle bundle3 = new Bundle();
        bundle3.putString("exception", "infer timeout");
        return bundle3;
    }
}
