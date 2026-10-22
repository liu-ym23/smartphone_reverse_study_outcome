package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: _CollectionsJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
class y extends x {
    public static final <T> void j(List<T> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        Collections.reverse(r3);
    }
}
