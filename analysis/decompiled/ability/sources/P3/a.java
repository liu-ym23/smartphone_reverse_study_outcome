package P3;

import C7.f;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.Map;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final f f1084a = kotlin.a.a(new Ba.a(29));

    public static Map a(String str) {
        if (str == null || str.length() == 0) {
            return kotlin.collections.a.M();
        }
        try {
            Object objFromJson = b().fromJson(str, TypeToken.getParameterized(Map.class, String.class, Object.class).getType());
            k.c(objFromJson);
            return (Map) objFromJson;
        } catch (Exception unused) {
            return kotlin.collections.a.M();
        }
    }

    public static Gson b() {
        Object f4884a = f1084a.getF4884a();
        k.e(f4884a, "getValue(...)");
        return (Gson) f4884a;
    }

    public static String c(Object obj) {
        return b().toJson(obj);
    }
}
