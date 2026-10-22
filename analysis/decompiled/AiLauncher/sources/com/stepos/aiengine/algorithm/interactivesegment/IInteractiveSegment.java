package com.stepos.aiengine.algorithm.interactivesegment;

import M5.b;
import Y8.t;
import Z8.F;
import android.graphics.Point;
import android.os.Bundle;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.args.MattingOptionBundle;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H&J3\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/aiengine/algorithm/interactivesegment/IInteractiveSegment;", "", "segmentImage", "Landroid/os/Bundle;", b.CREDENTIAL_TOKEN, "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "image", MattingOptionBundle.KEY_ROTATE_ANGLE, "", "points", "", "Landroid/graphics/Point;", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;I[Landroid/graphics/Point;)Landroid/os/Bundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IInteractiveSegment {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Bundle segmentImage(IInteractiveSegment iInteractiveSegment, AlgorithmToken token, Bundle image, int i10, Point[] points) {
            p.i(token, "token");
            p.i(image, "image");
            p.i(points, "points");
            Bundle bundle = new Bundle();
            ArrayList arrayList = new ArrayList(points.length);
            for (Point point : points) {
                arrayList.add(Integer.valueOf(point.x));
            }
            bundle.putIntArray("points_x", F.l1(arrayList));
            ArrayList arrayList2 = new ArrayList(points.length);
            for (Point point2 : points) {
                arrayList2.add(Integer.valueOf(point2.y));
            }
            bundle.putIntArray("points_y", F.l1(arrayList2));
            int length = points.length;
            int[] iArr = new int[length];
            for (int i11 = 0; i11 < length; i11++) {
                iArr[i11] = 1;
            }
            bundle.putIntArray("points_label", iArr);
            t tVar = t.f7040a;
            return iInteractiveSegment.segmentImage(token, image, i10, bundle);
        }
    }

    Bundle segmentImage(AlgorithmToken token, Bundle image, int rotateAngle, Bundle points);

    Bundle segmentImage(AlgorithmToken token, Bundle image, int rotateAngle, Point[] points);
}
