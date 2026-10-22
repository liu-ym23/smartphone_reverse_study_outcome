package a6;

import com.stepos.stepclaw.SecurePrefs;
import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a2 extends CancellationException implements x {

    /* renamed from: a, reason: collision with root package name */
    public final transient h1 f134a;

    public a2(String str, h1 h1Var) {
        super(str);
        this.f134a = h1Var;
    }

    @Override // a6.x
    public final Throwable a() {
        String message = getMessage();
        if (message == null) {
            message = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        a2 a2Var = new a2(message, this.f134a);
        a2Var.initCause(this);
        return a2Var;
    }
}
