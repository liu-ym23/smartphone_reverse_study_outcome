package qb;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import sb.AbstractC5465c;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\"\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\n\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR(\u0010&\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0012\u0010\u001f\u0012\u0004\b$\u0010%\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010(\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\n\u001a\u0004\b'\u0010\f\"\u0004\b\u0018\u0010\u000eR\"\u0010+\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001f\u001a\u0004\b)\u0010!\"\u0004\b*\u0010#R(\u00102\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u001c\u0010-\u0012\u0004\b1\u0010%\u001a\u0004\b.\u0010/\"\u0004\b\u0014\u00100R\"\u00106\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010\n\u001a\u0004\b4\u0010\f\"\u0004\b5\u0010\u000eR(\u0010;\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b7\u0010\n\u0012\u0004\b:\u0010%\u001a\u0004\b8\u0010\f\"\u0004\b9\u0010\u000eR(\u0010@\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b<\u0010\n\u0012\u0004\b?\u0010%\u001a\u0004\b=\u0010\f\"\u0004\b>\u0010\u000eR(\u0010E\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bA\u0010\n\u0012\u0004\bD\u0010%\u001a\u0004\bB\u0010\f\"\u0004\bC\u0010\u000eR\"\u0010I\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010\n\u001a\u0004\bG\u0010\f\"\u0004\bH\u0010\u000eR\"\u0010M\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010\n\u001a\u0004\bK\u0010\f\"\u0004\bL\u0010\u000eR\"\u0010Q\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010\n\u001a\u0004\bO\u0010\f\"\u0004\bP\u0010\u000eR\"\u0010X\u001a\u00020R8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\b\u0010\u0010U\"\u0004\bV\u0010W¨\u0006Y"}, d2 = {"Lqb/d;", "", "Lqb/a;", "json", "<init>", "(Lqb/a;)V", "Lqb/f;", Const.INTENT_KEY_APIKEY, "()Lqb/f;", "", "Z", "getEncodeDefaults", "()Z", "e", "(Z)V", "encodeDefaults", Const.INTENT_KEY_PKGNAME, "getExplicitNulls", "f", "explicitNulls", "c", "getIgnoreUnknownKeys", Const.INTENT_KEY_BACKGROUND_COMMAND, "ignoreUnknownKeys", Const.INTENT_KEY_UMID, "isLenient", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "getPrettyPrint", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "prettyPrint", "", "Ljava/lang/String;", "getPrettyPrintIndent", "()Ljava/lang/String;", "setPrettyPrintIndent", "(Ljava/lang/String;)V", "getPrettyPrintIndent$annotations", "()V", "prettyPrintIndent", "getCoerceInputValues", "coerceInputValues", "getClassDiscriminator", "setClassDiscriminator", "classDiscriminator", "Lkotlinx/serialization/json/ClassDiscriminatorMode;", "Lkotlinx/serialization/json/ClassDiscriminatorMode;", "getClassDiscriminatorMode", "()Lkotlinx/serialization/json/ClassDiscriminatorMode;", "(Lkotlinx/serialization/json/ClassDiscriminatorMode;)V", "getClassDiscriminatorMode$annotations", "classDiscriminatorMode", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "getUseAlternativeNames", "setUseAlternativeNames", "useAlternativeNames", "k", "getDecodeEnumsCaseInsensitive", "setDecodeEnumsCaseInsensitive", "getDecodeEnumsCaseInsensitive$annotations", "decodeEnumsCaseInsensitive", "l", "getAllowTrailingComma", "setAllowTrailingComma", "getAllowTrailingComma$annotations", "allowTrailingComma", "m", "getAllowComments", "setAllowComments", "getAllowComments$annotations", "allowComments", "n", "getAllowSpecialFloatingPointValues", "setAllowSpecialFloatingPointValues", "allowSpecialFloatingPointValues", "o", "getAllowStructuredMapKeys", "setAllowStructuredMapKeys", "allowStructuredMapKeys", "p", "getUseArrayPolymorphism", "setUseArrayPolymorphism", "useArrayPolymorphism", "Lsb/c;", "q", "Lsb/c;", "()Lsb/c;", "setSerializersModule", "(Lsb/c;)V", "serializersModule", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: qb.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5174d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public boolean encodeDefaults;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public boolean explicitNulls;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean ignoreUnknownKeys;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public boolean isLenient;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean prettyPrint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public String prettyPrintIndent;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public boolean coerceInputValues;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public String classDiscriminator;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public ClassDiscriminatorMode classDiscriminatorMode;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public boolean useAlternativeNames;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public boolean decodeEnumsCaseInsensitive;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public boolean allowTrailingComma;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public boolean allowComments;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public boolean allowSpecialFloatingPointValues;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public boolean allowStructuredMapKeys;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public boolean useArrayPolymorphism;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public AbstractC5465c serializersModule;

    public C5174d(AbstractC5171a json) {
        kotlin.jvm.internal.p.i(json, "json");
        this.encodeDefaults = json.getConfiguration().getEncodeDefaults();
        this.explicitNulls = json.getConfiguration().getExplicitNulls();
        this.ignoreUnknownKeys = json.getConfiguration().getIgnoreUnknownKeys();
        this.isLenient = json.getConfiguration().getIsLenient();
        this.prettyPrint = json.getConfiguration().getPrettyPrint();
        this.prettyPrintIndent = json.getConfiguration().getPrettyPrintIndent();
        this.coerceInputValues = json.getConfiguration().getCoerceInputValues();
        this.classDiscriminator = json.getConfiguration().getClassDiscriminator();
        this.classDiscriminatorMode = json.getConfiguration().getClassDiscriminatorMode();
        this.useAlternativeNames = json.getConfiguration().getUseAlternativeNames();
        json.getConfiguration().l();
        this.decodeEnumsCaseInsensitive = json.getConfiguration().getDecodeEnumsCaseInsensitive();
        this.allowTrailingComma = json.getConfiguration().getAllowTrailingComma();
        this.allowComments = json.getConfiguration().getAllowComments();
        this.allowSpecialFloatingPointValues = json.getConfiguration().getAllowSpecialFloatingPointValues();
        this.allowStructuredMapKeys = json.getConfiguration().getAllowStructuredMapKeys();
        this.useArrayPolymorphism = json.getConfiguration().getUseArrayPolymorphism();
        this.serializersModule = json.getSerializersModule();
    }

    public final JsonConfiguration a() {
        if (this.useArrayPolymorphism) {
            if (!kotlin.jvm.internal.p.d(this.classDiscriminator, "type")) {
                throw new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified");
            }
            if (this.classDiscriminatorMode != ClassDiscriminatorMode.POLYMORPHIC) {
                throw new IllegalArgumentException("useArrayPolymorphism option can only be used if classDiscriminatorMode in a default POLYMORPHIC state.");
            }
        }
        if (this.prettyPrint) {
            if (!kotlin.jvm.internal.p.d(this.prettyPrintIndent, "    ")) {
                String str = this.prettyPrintIndent;
                for (int i10 = 0; i10 < str.length(); i10++) {
                    char cCharAt = str.charAt(i10);
                    if (cCharAt != ' ' && cCharAt != '\t' && cCharAt != '\r' && cCharAt != '\n') {
                        throw new IllegalArgumentException(("Only whitespace, tab, newline and carriage return are allowed as pretty print symbols. Had " + this.prettyPrintIndent).toString());
                    }
                }
            }
        } else if (!kotlin.jvm.internal.p.d(this.prettyPrintIndent, "    ")) {
            throw new IllegalArgumentException("Indent should not be specified when default printing mode is used");
        }
        return new JsonConfiguration(this.encodeDefaults, this.ignoreUnknownKeys, this.isLenient, this.allowStructuredMapKeys, this.prettyPrint, this.explicitNulls, this.prettyPrintIndent, this.coerceInputValues, this.useArrayPolymorphism, this.classDiscriminator, this.allowSpecialFloatingPointValues, this.useAlternativeNames, null, this.decodeEnumsCaseInsensitive, this.allowTrailingComma, this.allowComments, this.classDiscriminatorMode);
    }

    /* renamed from: b, reason: from getter */
    public final AbstractC5465c getSerializersModule() {
        return this.serializersModule;
    }

    public final void c(ClassDiscriminatorMode classDiscriminatorMode) {
        kotlin.jvm.internal.p.i(classDiscriminatorMode, "<set-?>");
        this.classDiscriminatorMode = classDiscriminatorMode;
    }

    public final void d(boolean z10) {
        this.coerceInputValues = z10;
    }

    public final void e(boolean z10) {
        this.encodeDefaults = z10;
    }

    public final void f(boolean z10) {
        this.explicitNulls = z10;
    }

    public final void g(boolean z10) {
        this.ignoreUnknownKeys = z10;
    }

    public final void h(boolean z10) {
        this.isLenient = z10;
    }

    public final void i(boolean z10) {
        this.prettyPrint = z10;
    }
}
