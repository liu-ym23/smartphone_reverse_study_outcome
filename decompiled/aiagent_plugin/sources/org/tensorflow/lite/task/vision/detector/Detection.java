package org.tensorflow.lite.task.vision.detector;

import android.graphics.RectF;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.tensorflow.lite.support.label.Category;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Detection {
    public abstract RectF a();

    public abstract List<Category> b();

    public Detection() {
    }

    public static Detection create(RectF r2, List<Category> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        return new a(new RectF(r2), Collections.unmodifiableList(new ArrayList(r4)));
    }
}
