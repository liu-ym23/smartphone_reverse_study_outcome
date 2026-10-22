package android.ss.com.vboost.i;

import android.ss.com.vboost.CapabilityType;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<CapabilityType> f4682a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f4683b;

    static {
        f4682a = new HashSet();
        f4683b = false;
    }

    public a() {
    }

    public Set<CapabilityType> a() {
        return f4682a;
    }

    public void a(Set<CapabilityType> r100) {
        f4682a.addAll(r100);
    }

    public boolean b(CapabilityType r100) {
        return f4682a.contains(r100);
    }
}
