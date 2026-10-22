package kotlinx.serialization;

import java.util.List;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MissingFieldException extends SerializationException {

    /* renamed from: a, reason: collision with root package name */
    public final List<String> f10121a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MissingFieldException(List missingFields, String str, MissingFieldException missingFieldException) {
        super(str, missingFieldException);
        g.f(missingFields, "missingFields");
        this.f10121a = missingFields;
    }
}
