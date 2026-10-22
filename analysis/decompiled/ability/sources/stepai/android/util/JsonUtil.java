package stepai.android.util;

import B7.a;
import N9.j;
import Na.c;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ,\u0010\n\u001a\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u000b\"\u0004\b\u0000\u0010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00040\bJ\u001c\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006J \u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006JF\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0013\u0018\u00010\u0011\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u0010\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00130\bJ(\u0010\u0016\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u0010\u00132\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u0011J\u0010\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001¨\u0006\u001a"}, d2 = {"Lstepai/android/util/JsonUtil;", "", "()V", "fromJson", ExifInterface.GPS_DIRECTION_TRUE, "json", "", "classOfT", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "fromJsonToList", "", "clazz", "getValueFromJson", "jsonStr", "key", "jsonStrToMap", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "keyClass", "valueClass", "mapToJsonStr", "map", "toJson", "src", "util_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class JsonUtil {
    public static final JsonUtil INSTANCE = new JsonUtil();

    private JsonUtil() {
    }

    public final <T> T fromJson(String json, Class<T> classOfT) {
        if (json == null) {
            return null;
        }
        try {
            return (T) c.f1027a.fromJson(json, (Class) classOfT);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final <T> List<T> fromJsonToList(String json, Class<T> clazz) {
        k.f(clazz, "clazz");
        if (json == null) {
            return null;
        }
        try {
            return (List) c.f1027a.fromJson(json, TypeToken.getParameterized(List.class, clazz).getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final String getValueFromJson(String jsonStr, String key) throws JsonSyntaxException {
        JsonElement jsonElement;
        boolean z10 = true;
        boolean z11 = jsonStr == null || jsonStr.length() == 0;
        if (key != null && key.length() != 0) {
            z10 = false;
        }
        boolean z12 = z10 | z11;
        String asString = null;
        if (z12) {
            j.F("getValueFromJson: jsonStr or key is null or empty", "JsonUtil");
            return null;
        }
        JsonElement string = JsonParser.parseString(jsonStr);
        JsonObject jsonObject = string instanceof JsonObject ? (JsonObject) string : null;
        if (jsonObject != null && (jsonElement = jsonObject.get(key)) != null) {
            asString = jsonElement.getAsString();
        }
        StringBuilder sbW = a.w("getValueFromJson: value=", asString, ". jsonStr=", jsonStr, ", key=");
        sbW.append(key);
        j.F(sbW.toString(), "JsonUtil");
        return asString;
    }

    public final Map<String, Object> jsonStrToMap(String jsonStr) {
        if (jsonStr == null) {
            return null;
        }
        try {
            return (Map) c.f1027a.fromJson(jsonStr, new TypeToken<Map<String, ? extends Object>>() { // from class: stepai.android.util.JsonUtil.jsonStrToMap.2
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final <K, V> String mapToJsonStr(Map<K, ? extends V> map) {
        k.f(map, "map");
        return c.f1027a.toJson(map);
    }

    public final String toJson(Object src) {
        String json = c.f1027a.toJson(src);
        k.e(json, "toJson(...)");
        return json;
    }

    public final <K, V> Map<K, V> jsonStrToMap(String jsonStr, Class<K> keyClass, Class<V> valueClass) {
        k.f(keyClass, "keyClass");
        k.f(valueClass, "valueClass");
        if (jsonStr == null) {
            return null;
        }
        try {
            return (Map) c.f1027a.fromJson(jsonStr, new TypeToken<Map<K, ? extends V>>() { // from class: stepai.android.util.JsonUtil.jsonStrToMap.1
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
