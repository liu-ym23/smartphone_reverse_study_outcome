package q3;

import com.fasterxml.jackson.databind.util.NameTransformer;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i extends NameTransformer {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f11560b;

    public i(String str) {
        this.f11560b = str;
    }

    @Override // com.fasterxml.jackson.databind.util.NameTransformer
    public final String a(String str) {
        return ai.onnxruntime.a.o(new StringBuilder(), this.f11560b, str);
    }

    public final String toString() {
        return ai.onnxruntime.a.o(new StringBuilder("[PrefixTransformer('"), this.f11560b, "')]");
    }
}
