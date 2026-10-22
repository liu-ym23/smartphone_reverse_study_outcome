package com.stepos.aiengine.adapter;

import M5.b;
import Y8.t;
import Z8.C1172u;
import android.graphics.Point;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.adapter.InteractiveSegmentAbilityAdapter;
import com.stepos.aiengine.algorithm.interactivesegment.IInteractiveSegment;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.args.MattingOptionBundle;
import com.stepos.aiengine.args.result.ErrorBundleKt;
import com.stepos.core.AbilityHandle;
import com.stepos.core.ability.converter.BundleContentBridge;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.base.Content;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import p9.q;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/aiengine/adapter/InteractiveSegmentAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/interactivesegment/IInteractiveSegment;", "Lcom/stepos/core/AbilityHandle;", "handle", "<init>", "(Lcom/stepos/core/AbilityHandle;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", b.CREDENTIAL_TOKEN, "Landroid/os/Bundle;", "image", "", MattingOptionBundle.KEY_ROTATE_ANGLE, "points", "segmentImage", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;ILandroid/os/Bundle;)Landroid/os/Bundle;", Const.INTENT_KEY_APIKEY, "Lcom/stepos/core/AbilityHandle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InteractiveSegmentAbilityAdapter implements IInteractiveSegment {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    public InteractiveSegmentAbilityAdapter(AbilityHandle handle) {
        p.i(handle, "handle");
        this.handle = handle;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [T, android.os.Bundle] */
    public static final t d(Ref$ObjectRef ref$ObjectRef, CountDownLatch countDownLatch, String str, ImageContent r10) {
        p.i(str, "<unused var>");
        p.i(r10, "r");
        ref$ObjectRef.f34820a = BundleContentBridge.INSTANCE.toSingleImageBundle(r10);
        countDownLatch.countDown();
        return t.f7040a;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [T, android.os.Bundle] */
    public static final t e(Ref$ObjectRef ref$ObjectRef, CountDownLatch countDownLatch, String str, int i10, String msg) {
        p.i(str, "<unused var>");
        p.i(msg, "msg");
        ?? bundle = new Bundle();
        ErrorBundleKt.writeInferError(bundle, i10, msg);
        ref$ObjectRef.f34820a = bundle;
        countDownLatch.countDown();
        return t.f7040a;
    }

    public static final t f(CountDownLatch countDownLatch, String it) {
        p.i(it, "it");
        countDownLatch.countDown();
        return t.f7040a;
    }

    @Override // com.stepos.aiengine.algorithm.interactivesegment.IInteractiveSegment
    public Bundle segmentImage(AlgorithmToken algorithmToken, Bundle bundle, int i10, Point[] pointArr) {
        return IInteractiveSegment.DefaultImpls.segmentImage(this, algorithmToken, bundle, i10, pointArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.stepos.aiengine.algorithm.interactivesegment.IInteractiveSegment
    public Bundle segmentImage(AlgorithmToken token, Bundle image, int rotateAngle, Bundle points) throws InterruptedException {
        Object objB;
        ImageContent imageContent;
        p.i(token, "token");
        p.i(image, "image");
        p.i(points, "points");
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
            bundle.putString("exception", "segmentImage: image is not a bitmap");
            return bundle;
        }
        objB = Result.b(imageContent);
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("exception", "segmentImage: " + thE.getMessage());
            return bundle2;
        }
        ImageContent imageContent2 = (ImageContent) objB;
        int[] intArray = points.getIntArray("points_x");
        if (intArray == null) {
            intArray = new int[0];
        }
        int[] intArray2 = points.getIntArray("points_y");
        if (intArray2 == null) {
            intArray2 = new int[0];
        }
        int[] intArray3 = points.getIntArray("points_label");
        if (intArray3 == null) {
            intArray3 = new int[0];
        }
        ContentParams.Builder builderPutIntArray = new ContentParams.Builder().putInt("rotate_angle", rotateAngle).putIntArray("points_x", intArray).putIntArray("points_y", intArray2).putIntArray("points_label", intArray3);
        TaskPriorityArg taskPriorityArg = TaskPriorityArg.INSTANCE;
        if (!taskPriorityArg.applyTo(builderPutIntArray, points)) {
            taskPriorityArg.applyTo(builderPutIntArray, image);
        }
        imageContent2.setParams(builderPutIntArray.build());
        MixedContent mixedContent = new MixedContent((List<? extends Content>) C1172u.e(imageContent2));
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        AbilityHandle.infer$default(this.handle, String.valueOf(token.getIdentity()), mixedContent, new p9.p() { // from class: O4.S
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return InteractiveSegmentAbilityAdapter.d(ref$ObjectRef, countDownLatch, (String) obj, (ImageContent) obj2);
            }
        }, new q() { // from class: O4.T
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return InteractiveSegmentAbilityAdapter.e(ref$ObjectRef, countDownLatch, (String) obj, ((Integer) obj2).intValue(), (String) obj3);
            }
        }, new InterfaceC5074l() { // from class: O4.U
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return InteractiveSegmentAbilityAdapter.f(countDownLatch, (String) obj);
            }
        }, (q) null, (p9.p) null, 96, (Object) null);
        boolean zAwait = countDownLatch.await(30L, TimeUnit.SECONDS);
        imageContent2.releaseSharedMemory();
        Bundle bundle3 = (Bundle) ref$ObjectRef.f34820a;
        if (bundle3 == null) {
            bundle3 = new Bundle();
            bundle3.putString("exception", zAwait ? "infer completed without result" : "infer timeout");
        }
        return bundle3;
    }
}
