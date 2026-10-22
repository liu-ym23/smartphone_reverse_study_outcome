package xb;

import java.security.PrivilegedAction;
import java.security.Security;

/* loaded from: classes.dex */
public final class a implements PrivilegedAction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11346a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f11347b;

    public /* synthetic */ a(String str, int i2) {
        this.f11346a = i2;
        this.f11347b = str;
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        switch (this.f11346a) {
            case 0:
                return Security.getProperty(this.f11347b);
            default:
                return System.getProperty(this.f11347b);
        }
    }
}
