package com.obric.aikernel.phx.sdk;

import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.n;
import d.x;

/* JADX INFO: compiled from: IAIKernelManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAIKernelManager {
    public static final Companion Companion = null;
    public static final String PACKAGE_NAME_AIK = "com.obric.aikernel";
    public static final String PACKAGE_NAME_ASSIST = "com.larus.nova";
    public static final String SERVICE_NAME = "com.obric.aikernel.AIKernelService";
    public static final String TAG = "AIKernelManager";

    /* JADX INFO: compiled from: IAIKernelManager.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String PACKAGE_NAME_AIK = "com.obric.aikernel";
        public static final String PACKAGE_NAME_ASSIST = "com.larus.nova";
        public static final String SERVICE_NAME = "com.obric.aikernel.AIKernelService";
        public static final String TAG = "AIKernelManager";

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: IAIKernelManager.kt */
    public static final class DefaultImpls {
        /* JADX INFO: renamed from: getPackage-0E7RQCE$default, reason: not valid java name */
        public static /* synthetic */ Object m395getPackage0E7RQCE$default(IAIKernelManager r2, String r3, RequestParams r4, d r5, int r6, Object r7) {
            IAIKernelManager r8 = (IAIKernelManager) ZeusTransformUtils.wrapperContextForParams(r2, IAIKernelManager.class, "com.obric.aiagent.plugin");
            d<? super n<PackageResource>> r9 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 2) == 0) goto L8;
            r4 = new RequestParams(null, null, 3, null);
        L8:
            return r8.mo393getPackage0E7RQCE(r3, r4, r9);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPackage-0E7RQCE");
        }

        /* JADX INFO: renamed from: updatePackage-0E7RQCE$default, reason: not valid java name */
        public static /* synthetic */ Object m396updatePackage0E7RQCE$default(IAIKernelManager r2, PackageResource r3, RequestParams r4, d r5, int r6, Object r7) {
            IAIKernelManager r8 = (IAIKernelManager) ZeusTransformUtils.wrapperContextForParams(r2, IAIKernelManager.class, "com.obric.aiagent.plugin");
            d<? super n<PackageResource>> r9 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 2) == 0) goto L8;
            r4 = new RequestParams(null, null, 3, null);
        L8:
            return r8.mo394updatePackage0E7RQCE(r3, r4, r9);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updatePackage-0E7RQCE");
        }

        public static /* synthetic */ Object loadPackage$default(IAIKernelManager r2, String r3, boolean r4, RequestParams r5, d r6, int r7, Object r8) {
            IAIKernelManager r9 = (IAIKernelManager) ZeusTransformUtils.wrapperContextForParams(r2, IAIKernelManager.class, "com.obric.aiagent.plugin");
            d<? super IBaseModel> r10 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L13;
            if ((r7 & 2) == 0) goto L8;
            r4 = false;
        L8:
            if ((r7 & 4) == 0) goto L11;
            r5 = new RequestParams(null, null, 3, null);
        L11:
            return r9.loadPackage(r3, r4, r5, r10);
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadPackage");
        }

        public static /* synthetic */ Object clearAIKernelData$default(IAIKernelManager r2, RequestParams r3, d r4, int r5, Object r6) {
            IAIKernelManager r7 = (IAIKernelManager) ZeusTransformUtils.wrapperContextForParams(r2, IAIKernelManager.class, "com.obric.aiagent.plugin");
            d<? super x> r8 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 1) == 0) goto L8;
            r3 = new RequestParams(null, null, 3, null);
        L8:
            return r7.clearAIKernelData(r3, r8);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clearAIKernelData");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    Object clearAIKernelData(RequestParams r1, d<? super x> r2);

    /* JADX INFO: renamed from: getPackage-0E7RQCE */
    Object mo393getPackage0E7RQCE(String r1, RequestParams r2, d<? super n<PackageResource>> r3);

    Object loadPackage(String r1, boolean r2, RequestParams r3, d<? super IBaseModel> r4);

    /* JADX INFO: renamed from: updatePackage-0E7RQCE */
    Object mo394updatePackage0E7RQCE(PackageResource r1, RequestParams r2, d<? super n<PackageResource>> r3);
}
