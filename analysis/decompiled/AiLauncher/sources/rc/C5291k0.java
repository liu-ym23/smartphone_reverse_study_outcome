package rc;

import java.util.HashMap;
import org.scilab.forge.jlatexmath.ParseException;

/* renamed from: rc.k0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5291k0 {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<String, String> f39338a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public static HashMap<String, String> f39339b = new HashMap<>();

    public static void a(String str, String str2, int i10) throws ParseException {
        f39338a.put(str, str2);
        C5275c0.f39233f.put(str, new C5275c0("org.scilab.forge.jlatexmath.NewCommandMacro", "executeMacro", i10));
    }

    public static void b(String str, String str2, int i10, String str3) throws ParseException {
        if (f39338a.get(str) == null) {
            f39338a.put(str, str2);
            f39339b.put(str, str3);
            C5275c0.f39233f.put(str, new C5275c0("org.scilab.forge.jlatexmath.NewCommandMacro", "executeMacro", i10, 1.0f));
        } else {
            throw new ParseException("Command " + str + " already exists ! Use renewcommand instead ...");
        }
    }

    public static void c(String str, String str2, int i10) {
        if (f39338a.get(str) != null) {
            f39338a.put(str, str2);
            C5275c0.f39233f.put(str, new C5275c0("org.scilab.forge.jlatexmath.NewCommandMacro", "executeMacro", i10));
        } else {
            throw new ParseException("Command " + str + " is not defined ! Use newcommand instead ...");
        }
    }

    public static boolean d(String str) {
        return f39338a.containsKey(str);
    }
}
