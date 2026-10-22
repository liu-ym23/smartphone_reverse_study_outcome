package h4;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4147a;

    /* renamed from: b, reason: collision with root package name */
    public final o f4148b;

    public /* synthetic */ l(o oVar, int i2) {
        this.f4147a = i2;
        this.f4148b = oVar;
    }

    public final Object a(String str) throws GeneralSecurityException {
        switch (this.f4147a) {
            case 0:
                String[] strArr = {"GmsCore_OpenSSL", "AndroidOpenSSL"};
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < 2; i2++) {
                    Provider provider = Security.getProvider(strArr[i2]);
                    if (provider != null) {
                        arrayList.add(provider);
                    }
                }
                Iterator it = arrayList.iterator();
                Exception exc = null;
                while (true) {
                    boolean zHasNext = it.hasNext();
                    o oVar = this.f4148b;
                    if (!zHasNext) {
                        return oVar.c(str, null);
                    }
                    try {
                        return oVar.c(str, (Provider) it.next());
                    } catch (Exception e10) {
                        if (exc == null) {
                            exc = e10;
                        }
                    }
                }
            case 1:
                return this.f4148b.c(str, null);
            default:
                String[] strArr2 = {"GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt"};
                ArrayList arrayList2 = new ArrayList();
                for (int i10 = 0; i10 < 3; i10++) {
                    Provider provider2 = Security.getProvider(strArr2[i10]);
                    if (provider2 != null) {
                        arrayList2.add(provider2);
                    }
                }
                Iterator it2 = arrayList2.iterator();
                Exception exc2 = null;
                while (it2.hasNext()) {
                    try {
                        return this.f4148b.c(str, (Provider) it2.next());
                    } catch (Exception e11) {
                        if (exc2 == null) {
                            exc2 = e11;
                        }
                    }
                }
                throw new GeneralSecurityException("No good Provider found.", exc2);
        }
    }
}
