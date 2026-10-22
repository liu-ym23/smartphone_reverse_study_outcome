package androidx.savedstate.serialization.serializers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import muc.e;
import muc.f;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\b"}, d2 = {"encoderErrorMessage", "", "serialName", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "decoderErrorMessage", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "savedstate"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BuiltInSerializerKt {
    public static final String decoderErrorMessage(String r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "serialName");
        Intrinsics.checkNotNullParameter(r101, "decoder");
        return "Cannot deserialize " + r100 + " with '" + Reflection.getOrCreateKotlinClass(r101.getClass()).getSimpleName() + "'. This serializer can only be used with SavedStateDecoder. Use 'decodeFromSavedState' instead.";
    }

    public static final String encoderErrorMessage(String r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "serialName");
        Intrinsics.checkNotNullParameter(r101, "encoder");
        return "Cannot serialize " + r100 + " with '" + Reflection.getOrCreateKotlinClass(r101.getClass()).getSimpleName() + "'. This serializer can only be used with SavedStateEncoder. Use 'encodeToSavedState' instead.";
    }
}
