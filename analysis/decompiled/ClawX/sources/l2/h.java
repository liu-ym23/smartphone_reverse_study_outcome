package l2;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3783a;

    /* renamed from: b, reason: collision with root package name */
    public final t1.f f3784b;

    public /* synthetic */ h(t1.f fVar, int i8) {
        this.f3783a = i8;
        this.f3784b = fVar;
    }

    public final Object a(String str) throws GeneralSecurityException {
        switch (this.f3783a) {
            case 0:
                String[] strArr = {"GmsCore_OpenSSL", "AndroidOpenSSL"};
                ArrayList arrayList = new ArrayList();
                int i8 = 0;
                for (int i9 = 0; i9 < 2; i9++) {
                    Provider provider = Security.getProvider(strArr[i9]);
                    if (provider != null) {
                        arrayList.add(provider);
                    }
                }
                int size = arrayList.size();
                Exception exc = null;
                while (true) {
                    t1.f fVar = this.f3784b;
                    if (i8 >= size) {
                        return fVar.h(str, null);
                    }
                    Object obj = arrayList.get(i8);
                    i8++;
                    try {
                        return fVar.h(str, (Provider) obj);
                    } catch (Exception e9) {
                        if (exc == null) {
                            exc = e9;
                        }
                    }
                }
            case 1:
                return this.f3784b.h(str, null);
            default:
                String[] strArr2 = {"GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt"};
                ArrayList arrayList2 = new ArrayList();
                int i10 = 0;
                for (int i11 = 0; i11 < 3; i11++) {
                    Provider provider2 = Security.getProvider(strArr2[i11]);
                    if (provider2 != null) {
                        arrayList2.add(provider2);
                    }
                }
                int size2 = arrayList2.size();
                Exception exc2 = null;
                while (i10 < size2) {
                    Object obj2 = arrayList2.get(i10);
                    i10++;
                    try {
                        return this.f3784b.h(str, (Provider) obj2);
                    } catch (Exception e10) {
                        if (exc2 == null) {
                            exc2 = e10;
                        }
                    }
                }
                throw new GeneralSecurityException("No good Provider found.", exc2);
        }
    }
}
