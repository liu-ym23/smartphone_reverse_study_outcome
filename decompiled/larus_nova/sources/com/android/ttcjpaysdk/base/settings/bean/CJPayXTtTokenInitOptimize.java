package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \b2\u00020\u00012\u00020\u0002:\u0001\bB\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayXTtTokenInitOptimize;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "waitMs", "", "processorIsValid", "", "(JZ)V", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayXTtTokenInitOptimize implements CJPayObject, Serializable {
    public static final Companion Companion = null;
    private static final Lazy<CJPayXTtTokenInitOptimize> config$delegate = null;
    public boolean processorIsValid;
    public long waitMs;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayXTtTokenInitOptimize$Companion;", "", "()V", "config", "Lcom/android/ttcjpaysdk/base/settings/bean/CJPayXTtTokenInitOptimize;", "getConfig", "()Lcom/android/ttcjpaysdk/base/settings/bean/CJPayXTtTokenInitOptimize;", "config$delegate", "Lkotlin/Lazy;", MonitorConstants.CONNECT_TYPE_GET, "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final CJPayXTtTokenInitOptimize getConfig() {
            return (CJPayXTtTokenInitOptimize) CJPayXTtTokenInitOptimize.access$getConfig$delegate$cp().getValue();
        }

        public final CJPayXTtTokenInitOptimize get() {
            return getConfig();
        }
    }

    public CJPayXTtTokenInitOptimize() {
        this(0, false, 3, null);
    }

    static {
        Companion = new Companion(null);
        config$delegate = LazyKt.lazy(CJPayXTtTokenInitOptimize$Companion$config$2.INSTANCE);
    }

    public static final /* synthetic */ Lazy access$getConfig$delegate$cp() {
        return config$delegate;
    }

    public CJPayXTtTokenInitOptimize(long r100, boolean r101) {
        this.waitMs = r100;
        this.processorIsValid = r101;
    }

    public /* synthetic */ CJPayXTtTokenInitOptimize(long r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 100;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = true;
    L8:
        this(r100, r101);
    }
}
