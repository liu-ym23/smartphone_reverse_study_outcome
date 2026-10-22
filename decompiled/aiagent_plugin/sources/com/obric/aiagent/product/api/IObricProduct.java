package com.obric.aiagent.product.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IObricProduct.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IObricProduct {
    public static final a Companion = null;

    /* JADX INFO: compiled from: IObricProduct.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f18788a = null;

        static {
            f18788a = new a();
        }

        private a() {
        }

        public final IObricProduct a() {
            return (IObricProduct) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IObricProduct.class), IObricProduct.class, "com.obric.aiagent.plugin");
        }
    }

    static {
        Companion = a.f18788a;
    }

    void initProductSdk();
}
