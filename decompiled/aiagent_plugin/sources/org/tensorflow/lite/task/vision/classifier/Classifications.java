package org.tensorflow.lite.task.vision.classifier;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.tensorflow.lite.support.label.Category;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Classifications {
    public abstract List<Category> a();

    public abstract int b();

    public Classifications() {
    }

    static Classifications create(List<Category> r2, int r3) {
        return new a(Collections.unmodifiableList(new ArrayList((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"))), r3);
    }
}
