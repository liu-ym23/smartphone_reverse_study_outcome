package h4;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class r extends ThreadLocal {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f4153a;

    public r(s sVar) {
        this.f4153a = sVar;
    }

    @Override // java.lang.ThreadLocal
    public final Object initialValue() throws InvalidKeyException {
        s sVar = this.f4153a;
        try {
            m mVar = m.f4150c;
            Mac mac = (Mac) mVar.f4151a.a((String) sVar.f4156h);
            mac.init((SecretKeySpec) sVar.f4157i);
            return mac;
        } catch (GeneralSecurityException e10) {
            throw new IllegalStateException(e10);
        }
    }
}
