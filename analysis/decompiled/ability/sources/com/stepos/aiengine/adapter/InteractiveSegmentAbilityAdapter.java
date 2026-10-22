package com.stepos.aiengine.adapter;

import H4.o;
import Q4.f;
import Q4.g;
import android.graphics.Point;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.task.executor.e;
import com.stepos.aiengine.algorithm.interactivesegment.IInteractiveSegment;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.args.InteractiveSegmentPointsBundle;
import com.stepos.aiengine.args.MattingOptionBundle;
import com.stepos.aiengine.args.SingleImageBundle;
import com.stepos.core.c;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.base.Content;
import d5.h;
import d5.i;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.b;
import kotlin.collections.a;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.k;

@RequiresApi(26)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/aiengine/adapter/InteractiveSegmentAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/interactivesegment/IInteractiveSegment;", "Lcom/stepos/core/c;", "handle", AppAgent.CONSTRUCT, "(Lcom/stepos/core/c;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "token", "Landroid/os/Bundle;", "image", "", MattingOptionBundle.KEY_ROTATE_ANGLE, "points", "segmentImage", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;ILandroid/os/Bundle;)Landroid/os/Bundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InteractiveSegmentAbilityAdapter implements IInteractiveSegment {

    /* renamed from: a, reason: collision with root package name */
    public final c f3471a;

    public InteractiveSegmentAbilityAdapter(c handle) {
        k.f(handle, "handle");
        this.f3471a = handle;
    }

    @Override // com.stepos.aiengine.algorithm.interactivesegment.IInteractiveSegment
    public Bundle segmentImage(AlgorithmToken algorithmToken, Bundle bundle, int i, Point[] pointArr) {
        return IInteractiveSegment.DefaultImpls.segmentImage(this, algorithmToken, bundle, i, pointArr);
    }

    @Override // com.stepos.aiengine.algorithm.interactivesegment.IInteractiveSegment
    public Bundle segmentImage(AlgorithmToken token, Bundle image, int rotateAngle, Bundle points) throws InterruptedException {
        Object objA;
        k.f(token, "token");
        k.f(image, "image");
        k.f(points, "points");
        try {
            Content contentA = e.A(image);
            objA = contentA instanceof ImageContent ? (ImageContent) contentA : null;
            if (objA == null) {
                Bundle bundle = new Bundle();
                bundle.putString("exception", "segmentImage: image is not a bitmap");
                return bundle;
            }
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("exception", "segmentImage: " + thA.getMessage());
            return bundle2;
        }
        ImageContent imageContent = (ImageContent) objA;
        int[] intArray = points.getIntArray(InteractiveSegmentPointsBundle.KEY_POINTS_X);
        if (intArray == null) {
            intArray = new int[0];
        }
        int[] intArray2 = points.getIntArray(InteractiveSegmentPointsBundle.KEY_POINTS_Y);
        if (intArray2 == null) {
            intArray2 = new int[0];
        }
        int[] intArray3 = points.getIntArray(InteractiveSegmentPointsBundle.KEY_POINTS_LABEL);
        if (intArray3 == null) {
            intArray3 = new int[0];
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SingleImageBundle.KEY_ROTATE_ANGLE, new i(rotateAngle));
        linkedHashMap.put(InteractiveSegmentPointsBundle.KEY_POINTS_X, new h(intArray));
        linkedHashMap.put(InteractiveSegmentPointsBundle.KEY_POINTS_Y, new h(intArray2));
        linkedHashMap.put(InteractiveSegmentPointsBundle.KEY_POINTS_LABEL, new h(intArray3));
        imageContent.setParams(new ContentParams(a.Y(linkedHashMap), null));
        MixedContent mixedContent = new MixedContent((List<? extends Content>) o.M(imageContent));
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        c.i(this.f3471a, String.valueOf(token.getIdentity()), mixedContent, new f(ref$ObjectRef, countDownLatch, 3), new g(ref$ObjectRef, countDownLatch, 6), new Q4.h(countDownLatch, 6));
        countDownLatch.await(30L, TimeUnit.SECONDS);
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
