package reactor.util.retry;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import reactor.util.retry.Retry;
import z3.C2160e;
import z3.K;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5966a;

    public /* synthetic */ a(int i) {
        this.f5966a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f5966a) {
            case 0:
                return ((Retry.RetrySignal) obj).failure();
            case 1:
                return new ArrayList();
            case 2:
                return new LinkedHashMap();
            case 3:
                return new LinkedHashMap();
            case 4:
                return new ConcurrentHashMap();
            case 5:
                return new ConcurrentHashMap();
            case 6:
                return new ConcurrentHashMap();
            case 7:
                return new ArrayList();
            case 8:
                return ((JsonNode) obj).textValue();
            case 9:
                return new LinkedHashMap();
            default:
                String str = (String) obj;
                K.b.h(str, "Unknown keyword {} - you should define your own Meta Schema. If the keyword is irrelevant for validation, just use a NonValidationKeyword or if it should generate annotations AnnotationKeyword");
                return new C2160e(str, 0);
        }
    }
}
