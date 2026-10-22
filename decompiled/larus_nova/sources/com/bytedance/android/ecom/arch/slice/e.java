package com.bytedance.android.ecom.arch.slice;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public interface e {

    public static final class a {
        public static void a(e r100, Map<String, SlcElement> r101) {
            Intrinsics.checkNotNullParameter(r101, "templateMap");
            Iterator<Map.Entry<String, SlcElement>> r102 = r101.entrySet().iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            Map.Entry<String, SlcElement> r103 = r102.next();
            SlcElement r104 = r103.getValue();
            if (r104 == null) goto L4;
            r100.a(r103.getKey(), r104);
            goto L4
        }
    }

    void a(String r100, SlcElement r101);

    void b(Map<String, SlcElement> r100);

    SlcElement getTemplate(String r100);
}
