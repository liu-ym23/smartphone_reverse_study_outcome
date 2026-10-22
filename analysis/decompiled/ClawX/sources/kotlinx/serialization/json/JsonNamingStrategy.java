package kotlinx.serialization.json;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonNamingStrategy;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bç\u0080\u0001\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H¦\u0080\u0004¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkotlinx/serialization/json/JsonNamingStrategy;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "serialNameForJson", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementIndex", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "serialName", "Builtins", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
@ExperimentalSerializationApi
/* loaded from: classes.dex */
public interface JsonNamingStrategy {

    /* renamed from: Builtins, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    String serialNameForJson(SerialDescriptor descriptor, int elementIndex, String serialName);

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0082\u0080\u0004R\u001d\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0084\b¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0084\b¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\b¨\u0006\u0011"}, d2 = {"Lkotlinx/serialization/json/JsonNamingStrategy$Builtins;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "SnakeCase", "Lkotlinx/serialization/json/JsonNamingStrategy;", "getSnakeCase$annotations", "getSnakeCase", "()Lkotlinx/serialization/json/JsonNamingStrategy;", "KebabCase", "getKebabCase$annotations", "getKebabCase", "convertCamelCase", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "serialName", "delimiter", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @ExperimentalSerializationApi
    /* renamed from: kotlinx.serialization.json.JsonNamingStrategy$Builtins, reason: from kotlin metadata */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final JsonNamingStrategy SnakeCase = new JsonNamingStrategy() { // from class: kotlinx.serialization.json.JsonNamingStrategy$Builtins$SnakeCase$1
            @Override // kotlinx.serialization.json.JsonNamingStrategy
            public String serialNameForJson(SerialDescriptor descriptor, int elementIndex, String serialName) {
                p.e(descriptor, "descriptor");
                p.e(serialName, "serialName");
                return JsonNamingStrategy.Companion.$$INSTANCE.convertCamelCase(serialName, '_');
            }

            public String toString() {
                return "kotlinx.serialization.json.JsonNamingStrategy.SnakeCase";
            }
        };
        private static final JsonNamingStrategy KebabCase = new JsonNamingStrategy() { // from class: kotlinx.serialization.json.JsonNamingStrategy$Builtins$KebabCase$1
            @Override // kotlinx.serialization.json.JsonNamingStrategy
            public String serialNameForJson(SerialDescriptor descriptor, int elementIndex, String serialName) {
                p.e(descriptor, "descriptor");
                p.e(serialName, "serialName");
                return JsonNamingStrategy.Companion.$$INSTANCE.convertCamelCase(serialName, '-');
            }

            public String toString() {
                return "kotlinx.serialization.json.JsonNamingStrategy.KebabCase";
            }
        };

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String convertCamelCase(String serialName, char delimiter) {
            StringBuilder sb = new StringBuilder(serialName.length() * 2);
            Character chValueOf = null;
            int i8 = 0;
            for (int i9 = 0; i9 < serialName.length(); i9++) {
                char cCharAt = serialName.charAt(i9);
                if (Character.isUpperCase(cCharAt)) {
                    if (i8 == 0 && sb.length() > 0 && n.u1(sb) != delimiter) {
                        sb.append(delimiter);
                    }
                    if (chValueOf != null) {
                        sb.append(chValueOf.charValue());
                    }
                    i8++;
                    chValueOf = Character.valueOf(Character.toLowerCase(cCharAt));
                } else {
                    if (chValueOf != null) {
                        if (i8 > 1 && Character.isLetter(cCharAt)) {
                            sb.append(delimiter);
                        }
                        sb.append(chValueOf.charValue());
                        chValueOf = null;
                        i8 = 0;
                    }
                    sb.append(cCharAt);
                }
            }
            if (chValueOf != null) {
                sb.append(chValueOf.charValue());
            }
            return sb.toString();
        }

        public final JsonNamingStrategy getKebabCase() {
            return KebabCase;
        }

        public final JsonNamingStrategy getSnakeCase() {
            return SnakeCase;
        }

        @ExperimentalSerializationApi
        public static /* synthetic */ void getKebabCase$annotations() {
        }

        @ExperimentalSerializationApi
        public static /* synthetic */ void getSnakeCase$annotations() {
        }
    }
}
