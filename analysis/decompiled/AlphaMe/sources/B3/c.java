package B3;

import java.security.PrivilegedAction;

/* loaded from: classes2.dex */
public final class c implements PrivilegedAction {
    @Override // java.security.PrivilegedAction
    public final Object run() {
        return ClassLoader.getSystemClassLoader();
    }
}
