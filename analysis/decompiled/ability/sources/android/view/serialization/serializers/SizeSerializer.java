package android.view.serialization.serializers;

import A9.e;
import A9.f;
import android.util.Size;
import android.view.SavedStateReader;
import android.view.SavedStateWriter;
import android.view.serialization.SavedStateDecoder;
import android.view.serialization.SavedStateEncoder;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import x9.b;
import z2.l;
import z9.g;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/savedstate/serialization/serializers/SizeSerializer;", "Lx9/b;", "Landroid/util/Size;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Landroid/util/Size;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Landroid/util/Size;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SizeSerializer implements b {
    public static final SizeSerializer INSTANCE = new SizeSerializer();
    private static final g descriptor = l.k("android.util.Size", new g[0]);

    private SizeSerializer() {
    }

    @Override // x9.f, x9.InterfaceC2123a
    public g getDescriptor() {
        return descriptor;
    }

    @Override // x9.InterfaceC2123a
    public Size deserialize(e decoder) {
        k.f(decoder, "decoder");
        if (!(decoder instanceof SavedStateDecoder)) {
            throw new IllegalArgumentException(BuiltInSerializerKt.decoderErrorMessage(INSTANCE.getDescriptor().h(), decoder).toString());
        }
        SavedStateDecoder savedStateDecoder = (SavedStateDecoder) decoder;
        return SavedStateReader.m7240getSizeimpl(SavedStateReader.m7177constructorimpl(savedStateDecoder.getSavedState()), savedStateDecoder.getKey());
    }

    @Override // x9.f
    public void serialize(f encoder, Size value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        if (!(encoder instanceof SavedStateEncoder)) {
            throw new IllegalArgumentException(BuiltInSerializerKt.encoderErrorMessage(INSTANCE.getDescriptor().h(), encoder).toString());
        }
        SavedStateEncoder savedStateEncoder = (SavedStateEncoder) encoder;
        SavedStateWriter.m7293putSizeimpl(SavedStateWriter.m7263constructorimpl(savedStateEncoder.getSavedState()), savedStateEncoder.getKey(), value);
    }
}
