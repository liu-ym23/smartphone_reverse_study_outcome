package com.obric.capabilitykit;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    public static final class a extends d.h.b.p implements d.h.a.b<String, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f32161a = null;

        static {
            f32161a = new a();
        }

        public a() {
            super(1);
        }

        public final CharSequence a(String r1) {
            d.h.b.o.e(r1, "it");
            return r1;
        }

        @Override // d.h.a.b
        public /* synthetic */ CharSequence invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final String a(List<String> r9) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r0, "array");
        return d.a.p.a(r0, ",", null, null, 0, null, a.f32161a, 30, null);
    }

    public static final List<String> b(List<? extends AppEntity> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "appEntityList");
        ArrayList r0 = new ArrayList(d.a.p.a(r5, 10));
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r0.add(((AppEntity) ZeusTransformUtils.preCheckCast(r6.next(), AppEntity.class, "com.obric.aiagent.plugin")).getId());
        goto L4
    L6:
        return r0;
    }
}
