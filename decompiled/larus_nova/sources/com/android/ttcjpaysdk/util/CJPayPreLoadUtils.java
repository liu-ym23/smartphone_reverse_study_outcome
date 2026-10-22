package com.android.ttcjpaysdk.util;

import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayFrontCounterService;
import com.android.ttcjpaysdk.base.service.ICJPayIntegratedCounterService;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/util/CJPayPreLoadUtils;", "", "()V", "preLoad", "", "Companion", "integrated-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayPreLoadUtils {
    public static final Companion Companion = null;
    private static final Lazy<CJPayPreLoadUtils> singleInstance$delegate = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u0004H\u0007R!\u0010\u0003\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/util/CJPayPreLoadUtils$Companion;", "", "()V", "singleInstance", "Lcom/android/ttcjpaysdk/util/CJPayPreLoadUtils;", "getSingleInstance$annotations", "getSingleInstance", "()Lcom/android/ttcjpaysdk/util/CJPayPreLoadUtils;", "singleInstance$delegate", "Lkotlin/Lazy;", "getInstance", "integrated-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getSingleInstance$annotations() {
        }

        @JvmStatic
        public final CJPayPreLoadUtils getInstance() {
            return getSingleInstance();
        }

        public final CJPayPreLoadUtils getSingleInstance() {
            return (CJPayPreLoadUtils) CJPayPreLoadUtils.access$getSingleInstance$delegate$cp().getValue();
        }
    }

    private CJPayPreLoadUtils() {
    }

    public /* synthetic */ CJPayPreLoadUtils(DefaultConstructorMarker r100) {
        this();
    }

    @JvmStatic
    public static final CJPayPreLoadUtils getInstance() {
        return Companion.getInstance();
    }

    public static final CJPayPreLoadUtils getSingleInstance() {
        return Companion.getSingleInstance();
    }

    static {
        Companion = new Companion(null);
        singleInstance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, CJPayPreLoadUtils$Companion$singleInstance$2.INSTANCE);
    }

    public final void preLoad() {
        ICJPayIntegratedCounterService r100 = (ICJPayIntegratedCounterService) CJPayServiceManager.getInstance().getIService(ICJPayIntegratedCounterService.class);     // Catch: Throwable -> L7
        if (r100 == null) goto L18;
        r100.preLoad();     // Catch: Throwable -> L7
    L18:
        ICJPayFrontCounterService r101 = (ICJPayFrontCounterService) CJPayServiceManager.getInstance().getIService(ICJPayFrontCounterService.class);     // Catch: Throwable -> L13
        if (r101 == null) goto L20;
        r101.preLoad();     // Catch: Throwable -> L13
        return;
    L20:
        return;
    L13:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayPreLoadUtils#preLoad", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayPreLoadUtils#preLoad", th);
        return;
    L7:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayPreLoadUtils#preLoad", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayPreLoadUtils#preLoad", th);
        goto L18
    }

    public static final /* synthetic */ Lazy access$getSingleInstance$delegate$cp() {
        return singleInstance$delegate;
    }
}
