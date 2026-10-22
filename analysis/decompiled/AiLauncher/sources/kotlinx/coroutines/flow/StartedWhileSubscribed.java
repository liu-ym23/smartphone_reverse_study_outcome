package kotlinx.coroutines.flow;

import Xa.b;
import Xa.d;
import Xa.t;
import Z8.C1172u;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0017¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/flow/StartedWhileSubscribed;", "Lkotlinx/coroutines/flow/a;", "", "stopTimeout", "replayExpiration", "<init>", "(JJ)V", "LXa/t;", "", "subscriptionCount", "LXa/b;", "Lkotlinx/coroutines/flow/SharingCommand;", Const.INTENT_KEY_APIKEY, "(LXa/t;)LXa/b;", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", Const.INTENT_KEY_PKGNAME, "J", "c", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StartedWhileSubscribed implements a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final long stopTimeout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final long replayExpiration;

    public StartedWhileSubscribed(long j10, long j11) {
        this.stopTimeout = j10;
        this.replayExpiration = j11;
        if (j10 < 0) {
            throw new IllegalArgumentException(("stopTimeout(" + j10 + " ms) cannot be negative").toString());
        }
        if (j11 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("replayExpiration(" + j11 + " ms) cannot be negative").toString());
    }

    @Override // kotlinx.coroutines.flow.a
    public b<SharingCommand> a(t<Integer> subscriptionCount) {
        return d.q(d.t(d.N(subscriptionCount, new StartedWhileSubscribed$command$1(this, null)), new StartedWhileSubscribed$command$2(null)));
    }

    public boolean equals(Object other) {
        if (!(other instanceof StartedWhileSubscribed)) {
            return false;
        }
        StartedWhileSubscribed startedWhileSubscribed = (StartedWhileSubscribed) other;
        return this.stopTimeout == startedWhileSubscribed.stopTimeout && this.replayExpiration == startedWhileSubscribed.replayExpiration;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return (Long.hashCode(this.stopTimeout) * 31) + Long.hashCode(this.replayExpiration);
    }

    public String toString() {
        List listD = C1172u.d(2);
        if (this.stopTimeout > 0) {
            listD.add("stopTimeout=" + this.stopTimeout + Const.SP_KEY_GSM_UPLOAD_MXSIZE);
        }
        if (this.replayExpiration < Long.MAX_VALUE) {
            listD.add("replayExpiration=" + this.replayExpiration + Const.SP_KEY_GSM_UPLOAD_MXSIZE);
        }
        return "SharingStarted.WhileSubscribed(" + F.A0(C1172u.a(listD), null, null, null, 0, null, null, 63, null) + ')';
    }
}
