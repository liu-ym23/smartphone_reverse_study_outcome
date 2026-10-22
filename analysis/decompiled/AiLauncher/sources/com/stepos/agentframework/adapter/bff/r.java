package com.stepos.agentframework.adapter.bff;

import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0007\"\"\u0010\u0001\u001a\u00020\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/p;", "logger", "Lcom/stepos/agentframework/adapter/netcore/p;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/adapter/netcore/p;", "setLogger", "(Lcom/stepos/agentframework/adapter/netcore/p;)V", "protocol_bff_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class r {
    private static com.stepos.agentframework.adapter.netcore.p logger = new a();

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u001f\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0007R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/stepos/agentframework/adapter/bff/r$a", "Lcom/stepos/agentframework/adapter/netcore/p;", "", "tag", "text", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_UMID, "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "", "DEBUG", "Z", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "protocol_bff_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends com.stepos.agentframework.adapter.netcore.p {
        private String TAG = "ZYQLWEBSOCKET_API";
        private boolean DEBUG = true;

        @Override // com.stepos.agentframework.adapter.netcore.p
        public void a(String tag, String text) {
            kotlin.jvm.internal.p.i(tag, "tag");
            kotlin.jvm.internal.p.i(text, "text");
            if (this.DEBUG) {
                C4148a.c(tag, text, true);
            }
        }

        @Override // com.stepos.agentframework.adapter.netcore.p
        public void b(String tag, String text) {
            kotlin.jvm.internal.p.i(tag, "tag");
            kotlin.jvm.internal.p.i(text, "text");
            if (this.DEBUG) {
                C4148a.f(tag, text, true);
            }
        }

        @Override // com.stepos.agentframework.adapter.netcore.p
        public void c(String tag, String text) {
            kotlin.jvm.internal.p.i(tag, "tag");
            kotlin.jvm.internal.p.i(text, "text");
            if (this.DEBUG) {
                C4148a.j(tag, text, true);
            }
        }

        @Override // com.stepos.agentframework.adapter.netcore.p
        public void d(String tag, String text) {
            kotlin.jvm.internal.p.i(tag, "tag");
            kotlin.jvm.internal.p.i(text, "text");
            if (this.DEBUG) {
                C4148a.s(tag, text, true);
            }
        }
    }

    public static final com.stepos.agentframework.adapter.netcore.p a() {
        return logger;
    }
}
