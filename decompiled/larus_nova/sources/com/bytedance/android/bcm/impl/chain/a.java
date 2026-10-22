package com.bytedance.android.bcm.impl.chain;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.locallife.cube.bridge.POINativeModule;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, com.bytedance.android.bcm.api.c<?>> f41805a = null;

    /* JADX INFO: renamed from: com.bytedance.android.bcm.impl.chain.a$a, reason: collision with other inner class name */
    public static final class C0769a extends com.bytedance.android.bcm.api.a<kc.a> {
        @Override // com.bytedance.android.bcm.api.c
        public final String id() {
            return POINativeModule.RESP_EXIST;
        }

        public C0769a() {
        }
    }

    public static final class b extends com.bytedance.android.bcm.api.a<kc.a> {
        @Override // com.bytedance.android.bcm.api.c
        public final String id() {
            return TemplateNodeType.RAW;
        }

        public b() {
        }
    }

    public static final class c extends com.bytedance.android.bcm.api.a<kc.a> {
        @Override // com.bytedance.android.bcm.api.c
        public final String id() {
            return "reverse";
        }

        public c() {
        }
    }

    static {
        LinkedHashMap r100 = new LinkedHashMap();
        f41805a = r100;
        b r101 = new b();
        C0769a r102 = new C0769a();
        c r103 = new c();
        r100.put(TemplateNodeType.RAW, r101);
        r100.put(POINativeModule.RESP_EXIST, r102);
        r100.put("reverse", r103);
    }
}
