package a8;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import com.fasterxml.jackson.databind.introspect.AnnotatedAndMetadata;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.google.crypto.tink.aead.internal.InsecureNonceXChaCha20;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import io.modelcontextprotocol.spec.McpClientSession;
import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import reactor.core.Disposable;
import reactor.core.Scannable;
import reactor.util.retry.Retry;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements Predicate {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f238c;

    public /* synthetic */ e(int i) {
        this.f238c = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f238c) {
            case 0:
                return Objects.nonNull((ResourceBundle) obj);
            case 1:
                return Objects.nonNull((String) obj);
            case 2:
                return ((JsonNode) obj).canConvertToExactIntegral();
            case 3:
                return ((JsonNode) obj).isTextual();
            case 4:
                return ((x7.a) obj).f15589f;
            case 5:
                return "unevaluatedItems".equals(((x7.a) obj).f15584a);
            case 6:
                return "contains".equals(((x7.a) obj).f15584a);
            case 7:
                return ((x7.a) obj).f15589f;
            case 8:
                return "properties".equals(((x7.a) obj).f15584a);
            case 9:
                return "patternProperties".equals(((x7.a) obj).f15584a);
            case 10:
                return "additionalProperties".equals(((x7.a) obj).f15584a);
            case 11:
                return "unevaluatedProperties".equals(((x7.a) obj).f15584a);
            case 12:
                return StdKeyDeserializers.lambda$findStringBasedKeyDeserializer$0((AnnotatedAndMetadata) obj);
            case 13:
                return ((JsonNode) obj).isNull();
            case 14:
                return BeanSerializerFactory.lambda$removeSetterlessGetters$0((BeanPropertyDefinition) obj);
            case 15:
                return McpClientSession.lambda$handle$3((Throwable) obj);
            case 16:
                return McpClientSession.lambda$handle$4((Throwable) obj);
            case 17:
                return Scannable.class.isInstance((Disposable) obj);
            case 18:
                return Retry.lambda$maxInARow$3((Throwable) obj);
            case 19:
                return Retry.lambda$max$2((Throwable) obj);
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                return Retry.lambda$backoff$0((Throwable) obj);
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                return Retry.lambda$indefinitely$4((Throwable) obj);
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                return Retry.lambda$fixedDelay$1((Throwable) obj);
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                return false;
            case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                try {
                    k6.b.a((String) obj);
                } catch (k6.c e10) {
                    if (!e10.f7263c) {
                        return false;
                    }
                }
                return true;
            default:
                try {
                    OffsetDateTime.parse((String) obj);
                    return true;
                } catch (DateTimeParseException unused) {
                    return false;
                }
        }
    }
}
