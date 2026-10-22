package com.stepos.agentframework.adapter.bff;

import com.stepos.agentframework.adapter.netcore.ILogger;
import com.stepos.statsrpk.d;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"logger", "Lcom/stepos/agentframework/adapter/netcore/ILogger;", "getLogger", "()Lcom/stepos/agentframework/adapter/netcore/ILogger;", "setLogger", "(Lcom/stepos/agentframework/adapter/netcore/ILogger;)V", "bff_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LogUtilKt {
    private static ILogger logger = new ILogger() { // from class: com.stepos.agentframework.adapter.bff.LogUtilKt$logger$1
        private String TAG = "ZYQLWEBSOCKET_API";
        private boolean DEBUG = true;

        @Override // com.stepos.agentframework.adapter.netcore.ILogger
        public void d(String tag, String text) {
            k.f(tag, "tag");
            k.f(text, "text");
            if (this.DEBUG) {
                d.s(tag, text);
            }
        }

        @Override // com.stepos.agentframework.adapter.netcore.ILogger
        public void e(String tag, String text) {
            k.f(tag, "tag");
            k.f(text, "text");
            if (this.DEBUG) {
                d.u(tag, text);
            }
        }

        public final boolean getDEBUG() {
            return this.DEBUG;
        }

        public final String getTAG() {
            return this.TAG;
        }

        @Override // com.stepos.agentframework.adapter.netcore.ILogger
        public void i(String tag, String text) {
            k.f(tag, "tag");
            k.f(text, "text");
            if (this.DEBUG) {
                d.D(tag, text);
            }
        }

        public final void setDEBUG(boolean z10) {
            this.DEBUG = z10;
        }

        public final void setTAG(String str) {
            k.f(str, "<set-?>");
            this.TAG = str;
        }

        @Override // com.stepos.agentframework.adapter.netcore.ILogger
        public void w(String tag, String text) {
            k.f(tag, "tag");
            k.f(text, "text");
            if (this.DEBUG) {
                d.O(tag, text);
            }
        }

        public final void d(String text) {
            k.f(text, "text");
            d(this.TAG, text);
        }

        public final void e(String text) {
            k.f(text, "text");
            e(this.TAG, text);
        }

        public final void i(String text) {
            k.f(text, "text");
            i(this.TAG, text);
        }

        public final void w(String text) {
            k.f(text, "text");
            w(this.TAG, text);
        }
    };

    public static final ILogger getLogger() {
        return logger;
    }

    public static final void setLogger(ILogger iLogger) {
        k.f(iLogger, "<set-?>");
        logger = iLogger;
    }
}
