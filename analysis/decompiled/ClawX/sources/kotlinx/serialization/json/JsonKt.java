package kotlinx.serialization.json;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\u0080\u0004\u001a#\u0010\b\u001a\u00020\t\"\u0006\b\u0000\u0010\n\u0018\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u0002H\nH\u0086\u0088\u0004¢\u0006\u0002\u0010\f\u001a#\u0010\r\u001a\u0002H\n\"\u0006\b\u0000\u0010\n\u0018\u0001*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\tH\u0086\u0088\u0004¢\u0006\u0002\u0010\u000f\"\u000f\u0010\u0010\u001a\u00020\u0011X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010\u0012\u001a\u00020\u0011X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Json", "Lkotlinx/serialization/json/Json;", "from", "builderAction", "Lkotlin/Function1;", "Lkotlinx/serialization/json/JsonBuilder;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/ExtensionFunctionType;", "encodeToJsonElement", "Lkotlinx/serialization/json/JsonElement;", "T", "value", "(Lkotlinx/serialization/json/Json;Ljava/lang/Object;)Lkotlinx/serialization/json/JsonElement;", "decodeFromJsonElement", "json", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Object;", "defaultIndent", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "defaultDiscriminator", "kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class JsonKt {
    private static final String defaultDiscriminator = "type";
    private static final String defaultIndent = "    ";

    public static final Json Json(Json from, l builderAction) {
        p.e(from, "from");
        p.e(builderAction, "builderAction");
        JsonBuilder jsonBuilder = new JsonBuilder(from);
        builderAction.invoke(jsonBuilder);
        return new JsonImpl(jsonBuilder.build$kotlinx_serialization_json(), jsonBuilder.getSerializersModule());
    }

    public static /* synthetic */ Json Json$default(Json json, l lVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            json = Json.INSTANCE;
        }
        return Json(json, lVar);
    }

    public static final /* synthetic */ <T> T decodeFromJsonElement(Json json, JsonElement json2) {
        p.e(json, "<this>");
        p.e(json2, "json");
        json.getSerializersModule();
        p.i();
        throw null;
    }

    public static final /* synthetic */ <T> JsonElement encodeToJsonElement(Json json, T t8) {
        p.e(json, "<this>");
        json.getSerializersModule();
        p.i();
        throw null;
    }
}
