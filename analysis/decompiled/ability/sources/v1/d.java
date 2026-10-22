package v1;

import F.i;
import H.h;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes2.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f6766a = new HashMap();
    public static long b = -1;
    public static c c = new i();

    public static void a(String str) {
        try {
            File databasePath = h.f711a.getDatabasePath(str.concat(".db"));
            if (databasePath.exists()) {
                databasePath.delete();
            }
        } catch (Exception unused) {
        }
    }
}
