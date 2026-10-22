package h5;

import android.os.Message;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Set f20333a;

    static {
        HashSet r10 = new HashSet();
        f20333a = r10;
        r10.add(114);
        f20333a.add(115);
        f20333a.add(116);
        f20333a.add(121);
        f20333a.add(122);
        f20333a.add(123);
    }

    public static boolean a(Message r10) {
        return f20333a.contains(Integer.valueOf(r10.what));
    }
}
