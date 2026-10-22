package qb;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlinx.serialization.json.ClassDiscriminatorMode;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b(\u0018\u00002\u00020\u0001Bµ\u0001\b\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001eR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001eR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b#\u0010\u001c\u001a\u0004\b!\u0010\u001eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\u001eR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b&\u0010\u001c\u001a\u0004\b'\u0010\u001eR \u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b(\u0010)\u0012\u0004\b+\u0010,\u001a\u0004\b*\u0010\u001aR\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b-\u0010\u001c\u001a\u0004\b(\u0010\u001eR\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001c\u001a\u0004\b.\u0010\u001eR\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b'\u0010)\u001a\u0004\b$\u0010\u001aR\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b/\u0010\u001c\u001a\u0004\b0\u0010\u001eR \u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b%\u0010\u001c\u0012\u0004\b1\u0010,\u001a\u0004\b-\u0010\u001eR \u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b*\u0010\u001c\u0012\u0004\b2\u0010,\u001a\u0004\b#\u0010\u001eR \u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b0\u0010\u001c\u0012\u0004\b3\u0010,\u001a\u0004\b\u001b\u0010\u001eR0\u0010\u0016\u001a\u00020\u00152\u0006\u00104\u001a\u00020\u00158\u0006@GX\u0087\u000e¢\u0006\u0018\n\u0004\b.\u00105\u0012\u0004\b9\u0010,\u001a\u0004\b&\u00106\"\u0004\b7\u00108R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010:\u0012\u0004\b<\u0010,\u001a\u0004\b/\u0010;¨\u0006="}, d2 = {"Lqb/f;", "", "", "encodeDefaults", "ignoreUnknownKeys", "isLenient", "allowStructuredMapKeys", "prettyPrint", "explicitNulls", "", "prettyPrintIndent", "coerceInputValues", "useArrayPolymorphism", "classDiscriminator", "allowSpecialFloatingPointValues", "useAlternativeNames", "Lqb/z;", "namingStrategy", "decodeEnumsCaseInsensitive", "allowTrailingComma", "allowComments", "Lkotlinx/serialization/json/ClassDiscriminatorMode;", "classDiscriminatorMode", "<init>", "(ZZZZZZLjava/lang/String;ZZLjava/lang/String;ZZLqb/z;ZZZLkotlinx/serialization/json/ClassDiscriminatorMode;)V", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Z", Const.INTENT_KEY_PKGNAME, "k", "c", "q", Const.INTENT_KEY_UMID, "e", "m", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/lang/String;", "n", "getPrettyPrintIndent$annotations", "()V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "p", "l", "o", "getDecodeEnumsCaseInsensitive$annotations", "getAllowTrailingComma$annotations", "getAllowComments$annotations", UxipConstants.f30680s, "Lkotlinx/serialization/json/ClassDiscriminatorMode;", "()Lkotlinx/serialization/json/ClassDiscriminatorMode;", "setClassDiscriminatorMode", "(Lkotlinx/serialization/json/ClassDiscriminatorMode;)V", "getClassDiscriminatorMode$annotations", "Lqb/z;", "()Lqb/z;", "getNamingStrategy$annotations", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: qb.f, reason: case insensitive filesystem and from toString */
/* loaded from: classes5.dex */
public final class JsonConfiguration {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean encodeDefaults;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean ignoreUnknownKeys;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean isLenient;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean allowStructuredMapKeys;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean prettyPrint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean explicitNulls;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final String prettyPrintIndent;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean coerceInputValues;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean useArrayPolymorphism;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    public final String classDiscriminator;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean allowSpecialFloatingPointValues;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean useAlternativeNames;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean decodeEnumsCaseInsensitive;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean allowTrailingComma;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean allowComments;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    public ClassDiscriminatorMode classDiscriminatorMode;

    public JsonConfiguration(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, String prettyPrintIndent, boolean z16, boolean z17, String classDiscriminator, boolean z18, boolean z19, z zVar, boolean z20, boolean z21, boolean z22, ClassDiscriminatorMode classDiscriminatorMode) {
        kotlin.jvm.internal.p.i(prettyPrintIndent, "prettyPrintIndent");
        kotlin.jvm.internal.p.i(classDiscriminator, "classDiscriminator");
        kotlin.jvm.internal.p.i(classDiscriminatorMode, "classDiscriminatorMode");
        this.encodeDefaults = z10;
        this.ignoreUnknownKeys = z11;
        this.isLenient = z12;
        this.allowStructuredMapKeys = z13;
        this.prettyPrint = z14;
        this.explicitNulls = z15;
        this.prettyPrintIndent = prettyPrintIndent;
        this.coerceInputValues = z16;
        this.useArrayPolymorphism = z17;
        this.classDiscriminator = classDiscriminator;
        this.allowSpecialFloatingPointValues = z18;
        this.useAlternativeNames = z19;
        this.decodeEnumsCaseInsensitive = z20;
        this.allowTrailingComma = z21;
        this.allowComments = z22;
        this.classDiscriminatorMode = classDiscriminatorMode;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getAllowComments() {
        return this.allowComments;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getAllowSpecialFloatingPointValues() {
        return this.allowSpecialFloatingPointValues;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getAllowStructuredMapKeys() {
        return this.allowStructuredMapKeys;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getAllowTrailingComma() {
        return this.allowTrailingComma;
    }

    /* renamed from: e, reason: from getter */
    public final String getClassDiscriminator() {
        return this.classDiscriminator;
    }

    /* renamed from: f, reason: from getter */
    public final ClassDiscriminatorMode getClassDiscriminatorMode() {
        return this.classDiscriminatorMode;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getCoerceInputValues() {
        return this.coerceInputValues;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getDecodeEnumsCaseInsensitive() {
        return this.decodeEnumsCaseInsensitive;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getEncodeDefaults() {
        return this.encodeDefaults;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getExplicitNulls() {
        return this.explicitNulls;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getIgnoreUnknownKeys() {
        return this.ignoreUnknownKeys;
    }

    public final z l() {
        return null;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getPrettyPrint() {
        return this.prettyPrint;
    }

    /* renamed from: n, reason: from getter */
    public final String getPrettyPrintIndent() {
        return this.prettyPrintIndent;
    }

    /* renamed from: o, reason: from getter */
    public final boolean getUseAlternativeNames() {
        return this.useAlternativeNames;
    }

    /* renamed from: p, reason: from getter */
    public final boolean getUseArrayPolymorphism() {
        return this.useArrayPolymorphism;
    }

    /* renamed from: q, reason: from getter */
    public final boolean getIsLenient() {
        return this.isLenient;
    }

    public String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.encodeDefaults + ", ignoreUnknownKeys=" + this.ignoreUnknownKeys + ", isLenient=" + this.isLenient + ", allowStructuredMapKeys=" + this.allowStructuredMapKeys + ", prettyPrint=" + this.prettyPrint + ", explicitNulls=" + this.explicitNulls + ", prettyPrintIndent='" + this.prettyPrintIndent + "', coerceInputValues=" + this.coerceInputValues + ", useArrayPolymorphism=" + this.useArrayPolymorphism + ", classDiscriminator='" + this.classDiscriminator + "', allowSpecialFloatingPointValues=" + this.allowSpecialFloatingPointValues + ", useAlternativeNames=" + this.useAlternativeNames + ", namingStrategy=" + ((Object) null) + ", decodeEnumsCaseInsensitive=" + this.decodeEnumsCaseInsensitive + ", allowTrailingComma=" + this.allowTrailingComma + ", allowComments=" + this.allowComments + ", classDiscriminatorMode=" + this.classDiscriminatorMode + ')';
    }

    public /* synthetic */ JsonConfiguration(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, String str, boolean z16, boolean z17, String str2, boolean z18, boolean z19, z zVar, boolean z20, boolean z21, boolean z22, ClassDiscriminatorMode classDiscriminatorMode, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? false : z11, (i10 & 4) != 0 ? false : z12, (i10 & 8) != 0 ? false : z13, (i10 & 16) != 0 ? false : z14, (i10 & 32) != 0 ? true : z15, (i10 & 64) != 0 ? "    " : str, (i10 & 128) != 0 ? false : z16, (i10 & 256) != 0 ? false : z17, (i10 & 512) != 0 ? "type" : str2, (i10 & 1024) != 0 ? false : z18, (i10 & 2048) == 0 ? z19 : true, (i10 & 4096) != 0 ? null : zVar, (i10 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? false : z20, (i10 & 16384) != 0 ? false : z21, (i10 & 32768) != 0 ? false : z22, (i10 & 65536) != 0 ? ClassDiscriminatorMode.POLYMORPHIC : classDiscriminatorMode);
    }
}
