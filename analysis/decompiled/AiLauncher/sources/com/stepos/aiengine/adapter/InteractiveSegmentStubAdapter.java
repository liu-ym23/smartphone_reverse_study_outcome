package com.stepos.aiengine.adapter;

import M5.b;
import android.graphics.Point;
import android.os.Bundle;
import com.stepos.aiengine.algorithm.interactivesegment.IInteractiveSegment;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.args.MattingOptionBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/stepos/aiengine/adapter/InteractiveSegmentStubAdapter;", "Lcom/stepos/aiengine/algorithm/interactivesegment/IInteractiveSegment;", "<init>", "()V", "segmentImage", "Landroid/os/Bundle;", b.CREDENTIAL_TOKEN, "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "image", MattingOptionBundle.KEY_ROTATE_ANGLE, "", "points", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InteractiveSegmentStubAdapter implements IInteractiveSegment {
    @Override // com.stepos.aiengine.algorithm.interactivesegment.IInteractiveSegment
    public Bundle segmentImage(AlgorithmToken algorithmToken, Bundle bundle, int i10, Point[] pointArr) {
        return IInteractiveSegment.DefaultImpls.segmentImage(this, algorithmToken, bundle, i10, pointArr);
    }

    @Override // com.stepos.aiengine.algorithm.interactivesegment.IInteractiveSegment
    public Bundle segmentImage(AlgorithmToken token, Bundle image, int rotateAngle, Bundle points) {
        p.i(token, "token");
        p.i(image, "image");
        p.i(points, "points");
        Bundle bundle = new Bundle();
        bundle.putString("exception", "InteractiveSegment: not implemented yet");
        return bundle;
    }
}
