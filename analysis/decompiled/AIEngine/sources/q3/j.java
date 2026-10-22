package q3;

import com.fasterxml.jackson.databind.util.NameTransformer;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j extends NameTransformer {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f11561b;

    public j(String str) {
        this.f11561b = str;
    }

    @Override // com.fasterxml.jackson.databind.util.NameTransformer
    public final String a(String str) {
        StringBuilder sbB = v1.d.b(str);
        sbB.append(this.f11561b);
        return sbB.toString();
    }

    public final String toString() {
        return ai.onnxruntime.a.o(new StringBuilder("[SuffixTransformer('"), this.f11561b, "')]");
    }
}
