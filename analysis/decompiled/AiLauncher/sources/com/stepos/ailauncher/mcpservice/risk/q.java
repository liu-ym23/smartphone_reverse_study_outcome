package com.stepos.ailauncher.mcpservice.risk;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/mcpservice/risk/q;", "", "<init>", "()V", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "c", "Lcom/stepos/ailauncher/mcpservice/risk/q$a;", "Lcom/stepos/ailauncher/mcpservice/risk/q$b;", "Lcom/stepos/ailauncher/mcpservice/risk/q$c;", "mcpservice_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class q {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/mcpservice/risk/q$a;", "Lcom/stepos/ailauncher/mcpservice/risk/q;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "mcpservice_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class a extends q {
        public static final a INSTANCE = new a();

        public a() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof a);
        }

        public int hashCode() {
            return -865930625;
        }

        public String toString() {
            return "Cancelled";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/mcpservice/risk/q$b;", "Lcom/stepos/ailauncher/mcpservice/risk/q;", "", "buttonId", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "mcpservice_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.mcpservice.risk.q$b, reason: from toString */
    public static final /* data */ class Chosen extends q {
        private final String buttonId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Chosen(String buttonId) {
            super(null);
            kotlin.jvm.internal.p.i(buttonId, "buttonId");
            this.buttonId = buttonId;
        }

        /* renamed from: a, reason: from getter */
        public final String getButtonId() {
            return this.buttonId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Chosen) && kotlin.jvm.internal.p.d(this.buttonId, ((Chosen) other).buttonId);
        }

        public int hashCode() {
            return this.buttonId.hashCode();
        }

        public String toString() {
            return "Chosen(buttonId=" + this.buttonId + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/mcpservice/risk/q$c;", "Lcom/stepos/ailauncher/mcpservice/risk/q;", "Lcom/stepos/ailauncher/mcpservice/risk/UnlockSceneResult;", "result", "<init>", "(Lcom/stepos/ailauncher/mcpservice/risk/UnlockSceneResult;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/mcpservice/risk/UnlockSceneResult;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/mcpservice/risk/UnlockSceneResult;", "mcpservice_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.mcpservice.risk.q$c, reason: from toString */
    public static final /* data */ class Unlock extends q {
        private final UnlockSceneResult result;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Unlock(UnlockSceneResult result) {
            super(null);
            kotlin.jvm.internal.p.i(result, "result");
            this.result = result;
        }

        /* renamed from: a, reason: from getter */
        public final UnlockSceneResult getResult() {
            return this.result;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Unlock) && this.result == ((Unlock) other).result;
        }

        public int hashCode() {
            return this.result.hashCode();
        }

        public String toString() {
            return "Unlock(result=" + this.result + ")";
        }
    }

    public /* synthetic */ q(kotlin.jvm.internal.i iVar) {
        this();
    }

    public q() {
    }
}
