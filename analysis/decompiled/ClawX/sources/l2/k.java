package l2;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import javax.crypto.Mac;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k extends ThreadLocal {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f3788a;

    public k(l lVar) {
        this.f3788a = lVar;
    }

    @Override // java.lang.ThreadLocal
    public final Object initialValue() throws InvalidKeyException {
        l lVar = this.f3788a;
        try {
            i iVar = i.f3786c;
            Mac mac = (Mac) iVar.f3787a.a(lVar.f3790b);
            mac.init(lVar.f3791c);
            return mac;
        } catch (GeneralSecurityException e9) {
            throw new IllegalStateException(e9);
        }
    }
}
