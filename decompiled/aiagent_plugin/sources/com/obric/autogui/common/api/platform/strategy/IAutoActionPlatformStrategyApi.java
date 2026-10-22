package com.obric.autogui.common.api.platform.strategy;

import android.content.Context;
import com.obric.autogui.common.api.platform.packages.appinfo.OpenableAppInfo;
import com.obric.autogui.common.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.h;
import d.h.b.o;
import java.util.Collection;

/* JADX INFO: compiled from: IAutoActionPlatformStrategyApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionPlatformStrategyApi {

    /* JADX INFO: compiled from: IAutoActionPlatformStrategyApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object isGloballyWhitelistedPackage$default(IAutoActionPlatformStrategyApi r2, Context r3, String r4, Collection r5, d r6, int r7, Object r8) {
            IAutoActionPlatformStrategyApi r9 = (IAutoActionPlatformStrategyApi) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionPlatformStrategyApi.class, "com.obric.aiagent.plugin");
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            Collection<OpenableAppInfo> r11 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.aiagent.plugin");
            d<? super Boolean> r12 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L10;
            if ((r7 & 4) == 0) goto L8;
            r11 = null;
        L8:
            return r9.isGloballyWhitelistedPackage(r10, r4, r11, r12);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isGloballyWhitelistedPackage");
        }
    }

    /* JADX INFO: compiled from: IAutoActionPlatformStrategyApi.kt */
    public static final class SensitiveOpStrategy {
        private static final SensitiveOpStrategy ALLOWED = null;
        public static final Companion Companion = null;
        public static final int STRATEGY_ALLOWED = 0;
        public static final int STRATEGY_DENIED = 1;
        private final boolean isAllowed;
        private final String reason;
        private final int strategy;

        /* JADX INFO: compiled from: IAutoActionPlatformStrategyApi.kt */
        public static final class Companion {
            public /* synthetic */ Companion(h r1) {
                this();
            }

            private Companion() {
            }

            public final SensitiveOpStrategy getALLOWED() {
                return SensitiveOpStrategy.access$getALLOWED$cp();
            }
        }

        public static /* synthetic */ SensitiveOpStrategy copy$default(SensitiveOpStrategy r0, boolean r1, int r2, String r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.isAllowed;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.strategy;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.reason;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final boolean component1() {
            return this.isAllowed;
        }

        public final int component2() {
            return this.strategy;
        }

        public final String component3() {
            return this.reason;
        }

        public final SensitiveOpStrategy copy(boolean r1, int r2, String r3) {
            return new SensitiveOpStrategy(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, SensitiveOpStrategy.class) == true) goto L8;
            return false;
        L8:
            SensitiveOpStrategy r6 = (SensitiveOpStrategy) ZeusTransformUtils.preCheckCast(r5, SensitiveOpStrategy.class, "com.obric.aiagent.plugin");
            if (this.isAllowed == r6.isAllowed) goto L12;
            return false;
        L12:
            if (this.strategy == r6.strategy) goto L15;
            return false;
        L15:
            if (o.a(this.reason, r6.reason) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = ((Boolean.hashCode(this.isAllowed) * 31) + Integer.hashCode(this.strategy)) * 31;
            String r2 = this.reason;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "SensitiveOpStrategy(isAllowed=" + this.isAllowed + ", strategy=" + this.strategy + ", reason=" + this.reason + ')';
        }

        public SensitiveOpStrategy(boolean r1, int r2, String r3) {
            this.isAllowed = r1;
            this.strategy = r2;
            this.reason = r3;
        }

        public /* synthetic */ SensitiveOpStrategy(boolean r1, int r2, String r3, int r4, h r5) {
            if ((r4 & 2) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r4 & 4) == 0) goto L8;
            r3 = null;
        L8:
            this(r1, r2, r3);
        }

        public static final /* synthetic */ SensitiveOpStrategy access$getALLOWED$cp() {
            return ALLOWED;
        }

        public final boolean isAllowed() {
            return this.isAllowed;
        }

        public final int getStrategy() {
            return this.strategy;
        }

        public final String getReason() {
            return this.reason;
        }

        static {
            Companion = new Companion(null);
            ALLOWED = new SensitiveOpStrategy(true, 0, null);
        }
    }

    e applyForSensitiveOp(Context r1, SensitiveOperation r2);

    SensitiveOpStrategy checkSensitiveOp(Context r1, SensitiveOperation r2);

    Object isGloballyWhitelistedPackage(Context r1, String r2, Collection<OpenableAppInfo> r3, d<? super Boolean> r4);
}
