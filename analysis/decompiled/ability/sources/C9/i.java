package C9;

import kotlinx.serialization.json.ClassDiscriminatorMode;

/* loaded from: classes4.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f327a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final String f;
    public final boolean g;
    public final String h;
    public final boolean i;

    /* renamed from: j, reason: collision with root package name */
    public final ClassDiscriminatorMode f328j;

    public i(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, String prettyPrintIndent, boolean z15, String classDiscriminator, boolean z16, ClassDiscriminatorMode classDiscriminatorMode) {
        kotlin.jvm.internal.k.f(prettyPrintIndent, "prettyPrintIndent");
        kotlin.jvm.internal.k.f(classDiscriminator, "classDiscriminator");
        kotlin.jvm.internal.k.f(classDiscriminatorMode, "classDiscriminatorMode");
        this.f327a = z10;
        this.b = z11;
        this.c = z12;
        this.d = z13;
        this.e = z14;
        this.f = prettyPrintIndent;
        this.g = z15;
        this.h = classDiscriminator;
        this.i = z16;
        this.f328j = classDiscriminatorMode;
    }

    public final String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.f327a + ", ignoreUnknownKeys=" + this.b + ", isLenient=" + this.c + ", allowStructuredMapKeys=false, prettyPrint=" + this.d + ", explicitNulls=" + this.e + ", prettyPrintIndent='" + this.f + "', coerceInputValues=" + this.g + ", useArrayPolymorphism=false, classDiscriminator='" + this.h + "', allowSpecialFloatingPointValues=false, useAlternativeNames=" + this.i + ", namingStrategy=null, decodeEnumsCaseInsensitive=false, allowTrailingComma=false, allowComments=false, classDiscriminatorMode=" + this.f328j + ')';
    }
}
