package xa;

import q7.k;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11338a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11339b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f11340c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f11341d;

    /* renamed from: e, reason: collision with root package name */
    public final String f11342e;

    /* renamed from: f, reason: collision with root package name */
    public final String f11343f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f11344g;

    /* renamed from: h, reason: collision with root package name */
    public final a f11345h;

    public f(boolean z4, boolean z10, boolean z11, boolean z12, String str, String str2, boolean z13, a aVar) {
        k.e(str, "prettyPrintIndent");
        k.e(str2, "classDiscriminator");
        k.e(aVar, "classDiscriminatorMode");
        this.f11338a = z4;
        this.f11339b = z10;
        this.f11340c = z11;
        this.f11341d = z12;
        this.f11342e = str;
        this.f11343f = str2;
        this.f11344g = z13;
        this.f11345h = aVar;
    }

    public final String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.f11338a + ", ignoreUnknownKeys=" + this.f11339b + ", isLenient=" + this.f11340c + ", allowStructuredMapKeys=false, prettyPrint=false, explicitNulls=" + this.f11341d + ", prettyPrintIndent='" + this.f11342e + "', coerceInputValues=false, useArrayPolymorphism=false, classDiscriminator='" + this.f11343f + "', allowSpecialFloatingPointValues=false, useAlternativeNames=" + this.f11344g + ", namingStrategy=null, decodeEnumsCaseInsensitive=false, allowTrailingComma=false, allowComments=false, classDiscriminatorMode=" + this.f11345h + ')';
    }
}
