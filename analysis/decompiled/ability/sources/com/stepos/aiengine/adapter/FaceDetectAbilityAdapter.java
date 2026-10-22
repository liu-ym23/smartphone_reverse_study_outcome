package com.stepos.aiengine.adapter;

import Q4.g;
import Q4.h;
import S7.n;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.task.executor.e;
import com.stepos.aiengine.algorithm.face.IFaceDetect;
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
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/aiengine/adapter/FaceDetectAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/face/IFaceDetect;", "Lcom/stepos/core/c;", "handle", AppAgent.CONSTRUCT, "(Lcom/stepos/core/c;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "token", "Landroid/os/Bundle;", "image", "detectFaces", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;)Landroid/os/Bundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FaceDetectAbilityAdapter implements IFaceDetect {

    /* renamed from: a, reason: collision with root package name */
    public final c f3460a;

    public FaceDetectAbilityAdapter(c handle) {
        k.f(handle, "handle");
        this.f3460a = handle;
    }

    @Override // com.stepos.aiengine.algorithm.face.IFaceDetect
    public Bundle detectFaces(AlgorithmToken token, Bundle image) throws InterruptedException {
        Object objA;
        k.f(token, "token");
        k.f(image, "image");
        final float fMin = 1.0f;
        if (((Bitmap) image.getParcelable("bitmap")) != null) {
            float f = 1280;
            fMin = Math.min(f / r0.getWidth(), Math.min(f / r0.getHeight(), 1.0f));
        }
        try {
            objA = e.A(image);
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Bundle bundle = new Bundle();
            bundle.putString("exception", "detectFaces: " + thA.getMessage());
            return bundle;
        }
        Content content = (Content) objA;
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        c.i(this.f3460a, String.valueOf(token.getIdentity()), content, new n() { // from class: Q4.i
            /* JADX WARN: Removed duplicated region for block: B:35:0x020f  */
            @Override // S7.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invoke(java.lang.Object r18, java.lang.Object r19) {
                /*
                    Method dump skipped, instructions count: 635
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: Q4.i.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }, new g(ref$ObjectRef, countDownLatch, 2), new h(countDownLatch, 2));
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
