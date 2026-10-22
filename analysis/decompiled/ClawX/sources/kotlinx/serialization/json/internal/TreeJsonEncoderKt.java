package kotlinx.serialization.json.internal;

import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0087\u0080\u0004¢\u0006\u0002\u0010\b\u001a<\u0010\u0010\u001a\u0002H\u0002\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013H\u0080\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0014\"\u0019\u0010\t\u001a\u00020\n*\u00020\u000b8BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u000f\u0010\u000e\u001a\u00020\u000fX\u0080Ô\b¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"writeJson", "Lkotlinx/serialization/json/JsonElement;", "T", "json", "Lkotlinx/serialization/json/Json;", "value", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/json/Json;Ljava/lang/Object;Lkotlinx/serialization/SerializationStrategy;)Lkotlinx/serialization/json/JsonElement;", "requiresTopLevelTag", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getRequiresTopLevelTag", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Z", "PRIMITIVE_TAG", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "cast", "serialName", "path", "Lkotlin/Function0;", "(Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Lkotlinx/serialization/json/JsonElement;", "kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TreeJsonEncoderKt {
    public static final String PRIMITIVE_TAG = "primitive";

    public static final /* synthetic */ <T extends JsonElement> T cast(JsonElement value, String serialName, p5.a path) {
        p.e(value, "value");
        p.e(serialName, "serialName");
        p.e(path, "path");
        p.i();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getRequiresTopLevelTag(SerialDescriptor serialDescriptor) {
        return (serialDescriptor.getKind() instanceof PrimitiveKind) || serialDescriptor.getKind() == SerialKind.ENUM.INSTANCE;
    }

    @JsonFriendModuleApi
    public static final <T> JsonElement writeJson(Json json, T t8, SerializationStrategy<? super T> serializer) {
        p.e(json, "json");
        p.e(serializer, "serializer");
        y yVar = new y();
        new JsonTreeEncoder(json, new a(1, yVar)).encodeSerializableValue(serializer, t8);
        Object obj = yVar.f3686a;
        if (obj != null) {
            return (JsonElement) obj;
        }
        p.l("result");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 writeJson$lambda$0(y yVar, JsonElement it) {
        p.e(it, "it");
        yVar.f3686a = it;
        return a0.f883a;
    }
}
