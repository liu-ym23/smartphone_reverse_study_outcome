package com.bytedance.android.livesdkapi.service;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/ProviderResult;", "", "isOk", "", "(Z)V", "()Z", "Companion", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProviderResult {
    public static final Companion Companion = null;
    private static final ProviderResult Failed = null;
    private static final ProviderResult Succeed = null;
    private final boolean isOk;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/ProviderResult$Companion;", "", "()V", "Failed", "Lcom/bytedance/android/livesdkapi/service/ProviderResult;", "getFailed", "()Lcom/bytedance/android/livesdkapi/service/ProviderResult;", "Succeed", "getSucceed", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final ProviderResult getFailed() {
            return ProviderResult.access$getFailed$cp();
        }

        public final ProviderResult getSucceed() {
            return ProviderResult.access$getSucceed$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        Succeed = new ProviderResult(true);
        Failed = new ProviderResult(false);
    }

    public static final /* synthetic */ ProviderResult access$getFailed$cp() {
        return Failed;
    }

    public static final /* synthetic */ ProviderResult access$getSucceed$cp() {
        return Succeed;
    }

    public final boolean isOk() {
        return this.isOk;
    }

    public ProviderResult(boolean r100) {
        this.isOk = r100;
    }
}
