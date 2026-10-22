package E7;

import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import tb.C5528A;
import tb.C5530C;
import tb.w;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\fB\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"LE7/h;", "Ltb/w;", "Lkotlin/Function0;", "", "gate", "<init>", "(Lp9/a;)V", "Ltb/w$a;", "chain", "Ltb/C;", "intercept", "(Ltb/w$a;)Ltb/C;", Const.INTENT_KEY_APIKEY, "Lp9/a;", Const.INTENT_KEY_PKGNAME, "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class h implements w {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5063a<Boolean> gate;

    public h(InterfaceC5063a<Boolean> gate) {
        p.i(gate, "gate");
        this.gate = gate;
    }

    @Override // tb.w
    public C5530C intercept(w.a chain) throws IOException {
        boolean zBooleanValue;
        p.i(chain, "chain");
        try {
            zBooleanValue = this.gate.invoke().booleanValue();
        } catch (Throwable th) {
            Log.w("PrivacyGate", "privacy gate threw, treat as not granted", th);
            zBooleanValue = false;
        }
        if (zBooleanValue) {
            return chain.i(chain.getRequest());
        }
        C5528A request = chain.getRequest();
        Log.w("PrivacyGate", "blocked before privacy consent: " + request.getMethod() + " " + request.getUrl());
        throw new IOException("Network blocked: privacy not granted (" + request.getUrl() + ")");
    }
}
