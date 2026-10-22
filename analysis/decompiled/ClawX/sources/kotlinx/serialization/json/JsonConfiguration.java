package kotlinx.serialization.json;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.json.internal.ReaderJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u0001Bµ\u0001\b@\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\n\u00102\u001a\u00020\nH\u0096\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u0004\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0015\u0010\u0005\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u001aR\u0015\u0010\u0006\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0015\u0010\u0007\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0015\u0010\b\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0015\u0010\t\u001a\u00020\nX\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0015\u0010\u000b\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0015\u0010\f\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0015\u0010\r\u001a\u00020\nX\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0015\u0010\u000e\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0015\u0010\u000f\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u001f\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0084\b¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0015\u0010\u0012\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0015\u0010\u0013\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0015\u0010\u0014\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001aR#\u0010\u0015\u001a\u00020\u00168\u0006X\u0087\u008e\b¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010'\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00063"}, d2 = {"Lkotlinx/serialization/json/JsonConfiguration;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "encodeDefaults", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "ignoreUnknownKeys", "isLenient", "allowStructuredMapKeys", "prettyPrint", "explicitNulls", "prettyPrintIndent", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "coerceInputValues", "useArrayPolymorphism", "classDiscriminator", "allowSpecialFloatingPointValues", "useAlternativeNames", "namingStrategy", "Lkotlinx/serialization/json/JsonNamingStrategy;", "decodeEnumsCaseInsensitive", "allowTrailingComma", "allowComments", "classDiscriminatorMode", "Lkotlinx/serialization/json/ClassDiscriminatorMode;", "<init>", "(ZZZZZZLjava/lang/String;ZZLjava/lang/String;ZZLkotlinx/serialization/json/JsonNamingStrategy;ZZZLkotlinx/serialization/json/ClassDiscriminatorMode;)V", "getEncodeDefaults", "()Z", "getIgnoreUnknownKeys", "getAllowStructuredMapKeys", "getPrettyPrint", "getExplicitNulls", "getPrettyPrintIndent", "()Ljava/lang/String;", "getCoerceInputValues", "getUseArrayPolymorphism", "getClassDiscriminator", "getAllowSpecialFloatingPointValues", "getUseAlternativeNames", "getNamingStrategy$annotations", "()V", "getNamingStrategy", "()Lkotlinx/serialization/json/JsonNamingStrategy;", "getDecodeEnumsCaseInsensitive", "getAllowTrailingComma", "getAllowComments", "getClassDiscriminatorMode$annotations", "getClassDiscriminatorMode", "()Lkotlinx/serialization/json/ClassDiscriminatorMode;", "setClassDiscriminatorMode", "(Lkotlinx/serialization/json/ClassDiscriminatorMode;)V", "toString", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class JsonConfiguration {
    private final boolean allowComments;
    private final boolean allowSpecialFloatingPointValues;
    private final boolean allowStructuredMapKeys;
    private final boolean allowTrailingComma;
    private final String classDiscriminator;
    private ClassDiscriminatorMode classDiscriminatorMode;
    private final boolean coerceInputValues;
    private final boolean decodeEnumsCaseInsensitive;
    private final boolean encodeDefaults;
    private final boolean explicitNulls;
    private final boolean ignoreUnknownKeys;
    private final boolean isLenient;
    private final JsonNamingStrategy namingStrategy;
    private final boolean prettyPrint;
    private final String prettyPrintIndent;
    private final boolean useAlternativeNames;
    private final boolean useArrayPolymorphism;

    public JsonConfiguration() {
        this(false, false, false, false, false, false, null, false, false, null, false, false, null, false, false, false, null, 131071, null);
    }

    public final boolean getAllowComments() {
        return this.allowComments;
    }

    public final boolean getAllowSpecialFloatingPointValues() {
        return this.allowSpecialFloatingPointValues;
    }

    public final boolean getAllowStructuredMapKeys() {
        return this.allowStructuredMapKeys;
    }

    public final boolean getAllowTrailingComma() {
        return this.allowTrailingComma;
    }

    public final String getClassDiscriminator() {
        return this.classDiscriminator;
    }

    public final ClassDiscriminatorMode getClassDiscriminatorMode() {
        return this.classDiscriminatorMode;
    }

    public final boolean getCoerceInputValues() {
        return this.coerceInputValues;
    }

    public final boolean getDecodeEnumsCaseInsensitive() {
        return this.decodeEnumsCaseInsensitive;
    }

    public final boolean getEncodeDefaults() {
        return this.encodeDefaults;
    }

    public final boolean getExplicitNulls() {
        return this.explicitNulls;
    }

    public final boolean getIgnoreUnknownKeys() {
        return this.ignoreUnknownKeys;
    }

    public final JsonNamingStrategy getNamingStrategy() {
        return this.namingStrategy;
    }

    public final boolean getPrettyPrint() {
        return this.prettyPrint;
    }

    public final String getPrettyPrintIndent() {
        return this.prettyPrintIndent;
    }

    public final boolean getUseAlternativeNames() {
        return this.useAlternativeNames;
    }

    public final boolean getUseArrayPolymorphism() {
        return this.useArrayPolymorphism;
    }

    /* renamed from: isLenient, reason: from getter */
    public final boolean getIsLenient() {
        return this.isLenient;
    }

    public final void setClassDiscriminatorMode(ClassDiscriminatorMode classDiscriminatorMode) {
        p.e(classDiscriminatorMode, "<set-?>");
        this.classDiscriminatorMode = classDiscriminatorMode;
    }

    public String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.encodeDefaults + ", ignoreUnknownKeys=" + this.ignoreUnknownKeys + ", isLenient=" + this.isLenient + ", allowStructuredMapKeys=" + this.allowStructuredMapKeys + ", prettyPrint=" + this.prettyPrint + ", explicitNulls=" + this.explicitNulls + ", prettyPrintIndent='" + this.prettyPrintIndent + "', coerceInputValues=" + this.coerceInputValues + ", useArrayPolymorphism=" + this.useArrayPolymorphism + ", classDiscriminator='" + this.classDiscriminator + "', allowSpecialFloatingPointValues=" + this.allowSpecialFloatingPointValues + ", useAlternativeNames=" + this.useAlternativeNames + ", namingStrategy=" + this.namingStrategy + ", decodeEnumsCaseInsensitive=" + this.decodeEnumsCaseInsensitive + ", allowTrailingComma=" + this.allowTrailingComma + ", allowComments=" + this.allowComments + ", classDiscriminatorMode=" + this.classDiscriminatorMode + ')';
    }

    public JsonConfiguration(boolean z, boolean z2, boolean z8, boolean z9, boolean z10, boolean z11, String prettyPrintIndent, boolean z12, boolean z13, String classDiscriminator, boolean z14, boolean z15, JsonNamingStrategy jsonNamingStrategy, boolean z16, boolean z17, boolean z18, ClassDiscriminatorMode classDiscriminatorMode) {
        p.e(prettyPrintIndent, "prettyPrintIndent");
        p.e(classDiscriminator, "classDiscriminator");
        p.e(classDiscriminatorMode, "classDiscriminatorMode");
        this.encodeDefaults = z;
        this.ignoreUnknownKeys = z2;
        this.isLenient = z8;
        this.allowStructuredMapKeys = z9;
        this.prettyPrint = z10;
        this.explicitNulls = z11;
        this.prettyPrintIndent = prettyPrintIndent;
        this.coerceInputValues = z12;
        this.useArrayPolymorphism = z13;
        this.classDiscriminator = classDiscriminator;
        this.allowSpecialFloatingPointValues = z14;
        this.useAlternativeNames = z15;
        this.namingStrategy = jsonNamingStrategy;
        this.decodeEnumsCaseInsensitive = z16;
        this.allowTrailingComma = z17;
        this.allowComments = z18;
        this.classDiscriminatorMode = classDiscriminatorMode;
    }

    public /* synthetic */ JsonConfiguration(boolean z, boolean z2, boolean z8, boolean z9, boolean z10, boolean z11, String str, boolean z12, boolean z13, String str2, boolean z14, boolean z15, JsonNamingStrategy jsonNamingStrategy, boolean z16, boolean z17, boolean z18, ClassDiscriminatorMode classDiscriminatorMode, int i8, i iVar) {
        this((i8 & 1) != 0 ? false : z, (i8 & 2) != 0 ? false : z2, (i8 & 4) != 0 ? false : z8, (i8 & 8) != 0 ? false : z9, (i8 & 16) != 0 ? false : z10, (i8 & 32) != 0 ? true : z11, (i8 & 64) != 0 ? "    " : str, (i8 & 128) != 0 ? false : z12, (i8 & 256) != 0 ? false : z13, (i8 & 512) != 0 ? "type" : str2, (i8 & 1024) != 0 ? false : z14, (i8 & 2048) == 0 ? z15 : true, (i8 & 4096) != 0 ? null : jsonNamingStrategy, (i8 & 8192) != 0 ? false : z16, (i8 & ReaderJsonLexerKt.BATCH_SIZE) != 0 ? false : z17, (i8 & 32768) != 0 ? false : z18, (i8 & 65536) != 0 ? ClassDiscriminatorMode.POLYMORPHIC : classDiscriminatorMode);
    }

    @ExperimentalSerializationApi
    public static /* synthetic */ void getClassDiscriminatorMode$annotations() {
    }

    @ExperimentalSerializationApi
    public static /* synthetic */ void getNamingStrategy$annotations() {
    }
}
