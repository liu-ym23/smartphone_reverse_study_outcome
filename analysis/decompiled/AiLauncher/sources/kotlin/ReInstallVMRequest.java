package kotlin;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.common.ReInstallMode;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"LK6/z;", "", "", M5.b.CREDENTIAL_TOKEN, "Lcom/stepos/common/ReInstallMode;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "<init>", "(Ljava/lang/String;Lcom/stepos/common/ReInstallMode;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getToken", "Lcom/stepos/common/ReInstallMode;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/common/ReInstallMode;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.z, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class ReInstallVMRequest {
    private final ReInstallMode model;
    private final String token;

    public ReInstallVMRequest(String token, ReInstallMode model) {
        p.i(token, "token");
        p.i(model, "model");
        this.token = token;
        this.model = model;
    }

    /* renamed from: a, reason: from getter */
    public final ReInstallMode getModel() {
        return this.model;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReInstallVMRequest)) {
            return false;
        }
        ReInstallVMRequest reInstallVMRequest = (ReInstallVMRequest) other;
        return p.d(this.token, reInstallVMRequest.token) && this.model == reInstallVMRequest.model;
    }

    public int hashCode() {
        return (this.token.hashCode() * 31) + this.model.hashCode();
    }

    public String toString() {
        return "ReInstallVMRequest(token=" + this.token + ", model=" + this.model + ")";
    }
}
