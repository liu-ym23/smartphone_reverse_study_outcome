package android.view.serialization.serializers;

import A9.e;
import A9.f;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "serialName", "LA9/f;", "encoder", "encoderErrorMessage", "(Ljava/lang/String;LA9/f;)Ljava/lang/String;", "LA9/e;", "decoder", "decoderErrorMessage", "(Ljava/lang/String;LA9/e;)Ljava/lang/String;", "savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BuiltInSerializerKt {
    public static final String decoderErrorMessage(String serialName, e decoder) {
        k.f(serialName, "serialName");
        k.f(decoder, "decoder");
        return "Cannot deserialize " + serialName + " with '" + m.f4928a.b(decoder.getClass()).m() + "'. This serializer can only be used with SavedStateDecoder. Use 'decodeFromSavedState' instead.";
    }

    public static final String encoderErrorMessage(String serialName, f encoder) {
        k.f(serialName, "serialName");
        k.f(encoder, "encoder");
        return "Cannot serialize " + serialName + " with '" + m.f4928a.b(encoder.getClass()).m() + "'. This serializer can only be used with SavedStateEncoder. Use 'encodeToSavedState' instead.";
    }
}
