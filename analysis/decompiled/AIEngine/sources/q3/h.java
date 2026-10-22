package q3;

import com.fasterxml.jackson.databind.util.NameTransformer;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h extends NameTransformer {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f11558b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f11559c;

    public h(String str, String str2) {
        this.f11558b = str;
        this.f11559c = str2;
    }

    @Override // com.fasterxml.jackson.databind.util.NameTransformer
    public final String a(String str) {
        return this.f11558b + str + this.f11559c;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("[PreAndSuffixTransformer('");
        sb2.append(this.f11558b);
        sb2.append("','");
        return ai.onnxruntime.a.o(sb2, this.f11559c, "')]");
    }
}
