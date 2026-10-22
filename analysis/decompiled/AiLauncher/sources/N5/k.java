package N5;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\b\u001a\u0004\u0018\u00010\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ)\u0010\n\u001a\u0004\u0018\u00010\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\n\u0010\tR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"LN5/k;", "", "<init>", "()V", "", "", "data", "Lcom/google/gson/JsonObject;", "c", "(Ljava/util/Map;)Lcom/google/gson/JsonObject;", Const.INTENT_KEY_APIKEY, "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", Const.INTENT_KEY_PKGNAME, "()Lcom/google/gson/Gson;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class k {
    public static final k INSTANCE = new k();
    private static final Gson gson;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        A a10 = A.INSTANCE;
        Gson gsonCreate = gsonBuilder.registerTypeAdapter(Integer.class, a10.d().nullSafe()).registerTypeAdapter(Long.class, a10.e().nullSafe()).registerTypeAdapter(Double.class, a10.b().nullSafe()).registerTypeAdapter(Float.class, a10.c().nullSafe()).create();
        kotlin.jvm.internal.p.h(gsonCreate, "create(...)");
        gson = gsonCreate;
    }

    public final JsonObject a(Map<String, ? extends Object> data) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            JsonElement jsonTree = gson.toJsonTree(data);
            objB = Result.b(jsonTree instanceof JsonObject ? (JsonObject) jsonTree : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (JsonObject) (Result.g(objB) ? null : objB);
    }

    public final Gson b() {
        return gson;
    }

    public final JsonObject c(Map<String, ? extends Object> data) {
        return a(data);
    }
}
