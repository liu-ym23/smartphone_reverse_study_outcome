package com.stepos.agentframework.adapter.netcore;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u0000 \t2\u00020\u0001:\u0001\nJ\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/n;", "", "", "reason", "", "cancel", "(Ljava/lang/String;)Z", "isCancelled", "()Z", "Companion", Const.INTENT_KEY_APIKEY, "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface n {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String REASON_CLIENT_PREFIX = "client.";
    public static final String REASON_SUPERSEDED = "client.superseded";
    public static final String REASON_USER_ABORT = "user.abort";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/n$a;", "", "<init>", "()V", "", "reason", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Z", "REASON_USER_ABORT", "Ljava/lang/String;", "REASON_CLIENT_PREFIX", "REASON_SUPERSEDED", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.netcore.n$a, reason: from kotlin metadata */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String REASON_CLIENT_PREFIX = "client.";
        public static final String REASON_SUPERSEDED = "client.superseded";
        public static final String REASON_USER_ABORT = "user.abort";

        public final boolean a(String reason) {
            kotlin.jvm.internal.p.i(reason, "reason");
            return !La.D.X(reason, "client.", false, 2, null);
        }
    }

    static /* synthetic */ boolean a(n nVar, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
        if ((i10 & 1) != 0) {
            str = "user.abort";
        }
        return nVar.cancel(str);
    }

    boolean cancel(String reason);

    boolean isCancelled();
}
