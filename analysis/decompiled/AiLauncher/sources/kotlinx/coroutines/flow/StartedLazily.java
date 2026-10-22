package kotlinx.coroutines.flow;

import Xa.b;
import Xa.t;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/flow/StartedLazily;", "Lkotlinx/coroutines/flow/a;", "<init>", "()V", "LXa/t;", "", "subscriptionCount", "LXa/b;", "Lkotlinx/coroutines/flow/SharingCommand;", Const.INTENT_KEY_APIKEY, "(LXa/t;)LXa/b;", "", "toString", "()Ljava/lang/String;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StartedLazily implements a {
    @Override // kotlinx.coroutines.flow.a
    public b<SharingCommand> a(t<Integer> subscriptionCount) {
        return new StartedLazily$command$$inlined$unsafeFlow$1(subscriptionCount);
    }

    public String toString() {
        return "SharingStarted.Lazily";
    }
}
