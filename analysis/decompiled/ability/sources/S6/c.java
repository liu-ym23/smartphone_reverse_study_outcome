package S6;

import com.ethlo.time.LeapSecondException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import com.fasterxml.jackson.databind.introspect.AnnotatedAndMetadata;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import io.modelcontextprotocol.spec.McpClientSession;
import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import reactor.core.Disposable;
import reactor.core.Scannable;
import reactor.util.retry.Retry;
import v3.C2057a;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1177a;

    public /* synthetic */ c(int i) {
        this.f1177a = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f1177a) {
            case 0:
                return !"x-tos-signature".equals((String) obj);
            case 1:
                return StdKeyDeserializers.lambda$findStringBasedKeyDeserializer$0((AnnotatedAndMetadata) obj);
            case 2:
                return ((JsonNode) obj).isNull();
            case 3:
                return BeanSerializerFactory.lambda$removeSetterlessGetters$0((BeanPropertyDefinition) obj);
            case 4:
                return McpClientSession.lambda$handle$3((Throwable) obj);
            case 5:
                return McpClientSession.lambda$handle$4((Throwable) obj);
            case 6:
                return Scannable.class.isInstance((Disposable) obj);
            case 7:
                return Retry.lambda$maxInARow$3((Throwable) obj);
            case 8:
                return Retry.lambda$max$2((Throwable) obj);
            case 9:
                return Retry.lambda$backoff$0((Throwable) obj);
            case 10:
                return Retry.lambda$indefinitely$4((Throwable) obj);
            case 11:
                return Retry.lambda$fixedDelay$1((Throwable) obj);
            case 12:
                return false;
            case 13:
                try {
                    M2.b.a((String) obj);
                } catch (LeapSecondException e) {
                    if (!e.f2250a) {
                        return false;
                    }
                }
                return true;
            case 14:
                try {
                    OffsetDateTime.parse((String) obj);
                    return true;
                } catch (DateTimeParseException unused) {
                    return false;
                }
            case 15:
                return Objects.nonNull((ResourceBundle) obj);
            case 16:
                return Objects.nonNull((String) obj);
            case 17:
                return ((JsonNode) obj).canConvertToExactIntegral();
            case 18:
                return ((JsonNode) obj).isTextual();
            case 19:
                return ((C2057a) obj).f;
            case 20:
                return "unevaluatedItems".equals(((C2057a) obj).f6768a);
            case 21:
                return "contains".equals(((C2057a) obj).f6768a);
            case 22:
                return ((C2057a) obj).f;
            case 23:
                return "properties".equals(((C2057a) obj).f6768a);
            case 24:
                return "patternProperties".equals(((C2057a) obj).f6768a);
            case 25:
                return "additionalProperties".equals(((C2057a) obj).f6768a);
            default:
                return "unevaluatedProperties".equals(((C2057a) obj).f6768a);
        }
    }
}
