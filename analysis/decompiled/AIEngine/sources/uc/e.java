package uc;

import kotlinx.serialization.json.ClassDiscriminatorMode;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f13203a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f13204b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f13205c;

    /* renamed from: d, reason: collision with root package name */
    public final String f13206d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f13207e;

    /* renamed from: f, reason: collision with root package name */
    public final String f13208f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f13209g;
    public final ClassDiscriminatorMode h;

    public e(boolean z, boolean z3, boolean z10, String prettyPrintIndent, boolean z11, String classDiscriminator, boolean z12, ClassDiscriminatorMode classDiscriminatorMode) {
        kotlin.jvm.internal.g.f(prettyPrintIndent, "prettyPrintIndent");
        kotlin.jvm.internal.g.f(classDiscriminator, "classDiscriminator");
        kotlin.jvm.internal.g.f(classDiscriminatorMode, "classDiscriminatorMode");
        this.f13203a = z;
        this.f13204b = z3;
        this.f13205c = z10;
        this.f13206d = prettyPrintIndent;
        this.f13207e = z11;
        this.f13208f = classDiscriminator;
        this.f13209g = z12;
        this.h = classDiscriminatorMode;
    }

    public final String toString() {
        return "JsonConfiguration(encodeDefaults=false, ignoreUnknownKeys=" + this.f13203a + ", isLenient=" + this.f13204b + ", allowStructuredMapKeys=false, prettyPrint=false, explicitNulls=" + this.f13205c + ", prettyPrintIndent='" + this.f13206d + "', coerceInputValues=" + this.f13207e + ", useArrayPolymorphism=false, classDiscriminator='" + this.f13208f + "', allowSpecialFloatingPointValues=false, useAlternativeNames=" + this.f13209g + ", namingStrategy=null, decodeEnumsCaseInsensitive=false, allowTrailingComma=false, allowComments=false, classDiscriminatorMode=" + this.h + ')';
    }
}
