package com.obric.aiagent.product.impl;

import com.obric.aiagent.platform.IAIAgentPlatform;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.aiagent.product.api.IObricProduct;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: ObricProductImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObricProductImpl implements IObricProduct {
    public static final a Companion = null;
    private static final String TAG = "ObricProductImpl";

    /* JADX INFO: compiled from: ObricProductImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public ObricProductImpl() {
    }

    @Override // com.obric.aiagent.product.api.IObricProduct
    public void initProductSdk() {
        b.f18795a.a();
        ObricProductSdk.INSTANCE.init((IAIAgentPlatform) ZeusTransformUtils.preCheckCast(new AnonymousClass1(), IAIAgentPlatform.class, "com.obric.aiagent.plugin"));
    }
}
