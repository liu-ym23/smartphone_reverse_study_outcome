package com.obric.aikernel.phx.sdk;

import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IAIKernelManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J4\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ/\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J4\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Lcom/obric/aikernel/phx/sdk/IAIKernelManager;", "", "clearAIKernelData", "", "params", "Lcom/obric/aikernel/sdk/config/RequestParams;", "(Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPackage", "Lkotlin/Result;", "Lcom/obric/aikernel/sdk/data/PackageResource;", "business", "", "getPackage-0E7RQCE", "(Ljava/lang/String;Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadPackage", "Lcom/obric/aikernel/phx/sdk/api/IBaseModel;", "name", "useCloud", "", "(Ljava/lang/String;ZLcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePackage", "updatePackage-0E7RQCE", "(Lcom/obric/aikernel/sdk/data/PackageResource;Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IAIKernelManager {
    public static final Companion Companion = null;
    public static final String PACKAGE_NAME_AIK = "com.obric.aikernel";
    public static final String PACKAGE_NAME_ASSIST = "com.larus.nova";
    public static final String SERVICE_NAME = "com.obric.aikernel.AIKernelService";
    public static final String TAG = "AIKernelManager";

    /* JADX INFO: compiled from: IAIKernelManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/aikernel/phx/sdk/IAIKernelManager$Companion;", "", "()V", "PACKAGE_NAME_AIK", "", "PACKAGE_NAME_ASSIST", "SERVICE_NAME", "TAG", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        /* JADX INFO: renamed from: getPackage-0E7RQCE$default, reason: not valid java name */
        public static /* synthetic */ Object m313getPackage0E7RQCE$default(IAIKernelManager r0, String r1, RequestParams r2, Continuation r3, int r4, Object r5) {
            if (r5 != null) goto L9;
            if ((r4 & 2) == 0) goto L7;
            r2 = new RequestParams(null, null, 3, null);
        L7:
            return r0.mo311getPackage0E7RQCE(r1, r2, r3);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPackage-0E7RQCE");
        }

        /* JADX INFO: renamed from: updatePackage-0E7RQCE$default, reason: not valid java name */
        public static /* synthetic */ Object m314updatePackage0E7RQCE$default(IAIKernelManager r0, PackageResource r1, RequestParams r2, Continuation r3, int r4, Object r5) {
            if (r5 != null) goto L9;
            if ((r4 & 2) == 0) goto L7;
            r2 = new RequestParams(null, null, 3, null);
        L7:
            return r0.mo312updatePackage0E7RQCE(r1, r2, r3);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updatePackage-0E7RQCE");
        }

        public static /* synthetic */ Object loadPackage$default(IAIKernelManager r0, String r1, boolean r2, RequestParams r3, Continuation r4, int r5, Object r6) {
            if (r6 != null) goto L12;
            if ((r5 & 2) == 0) goto L7;
            r2 = false;
        L7:
            if ((r5 & 4) == 0) goto L10;
            r3 = new RequestParams(null, null, 3, null);
        L10:
            return r0.loadPackage(r1, r2, r3, r4);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadPackage");
        }

        public static /* synthetic */ Object clearAIKernelData$default(IAIKernelManager r0, RequestParams r1, Continuation r2, int r3, Object r4) {
            if (r4 != null) goto L9;
            if ((r3 & 1) == 0) goto L7;
            r1 = new RequestParams(null, null, 3, null);
        L7:
            return r0.clearAIKernelData(r1, r2);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clearAIKernelData");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    Object clearAIKernelData(RequestParams r1, Continuation<? super Unit> r2);

    /* JADX INFO: renamed from: getPackage-0E7RQCE */
    Object mo311getPackage0E7RQCE(String r1, RequestParams r2, Continuation<? super Result<PackageResource>> r3);

    Object loadPackage(String r1, boolean r2, RequestParams r3, Continuation<? super IBaseModel> r4);

    /* JADX INFO: renamed from: updatePackage-0E7RQCE */
    Object mo312updatePackage0E7RQCE(PackageResource r1, RequestParams r2, Continuation<? super Result<PackageResource>> r3);
}
