package android.view.serialization.serializers;

import A9.e;
import A9.f;
import android.os.Parcelable;
import android.view.SavedStateReader;
import android.view.SavedStateWriter;
import android.view.serialization.SavedStateDecoder;
import android.view.serialization.SavedStateEncoder;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import x9.b;
import z2.l;
import z9.g;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/savedstate/serialization/serializers/ParcelableArraySerializer;", "Lx9/b;", "", "Landroid/os/Parcelable;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;[Landroid/os/Parcelable;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)[Landroid/os/Parcelable;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ParcelableArraySerializer implements b {
    public static final ParcelableArraySerializer INSTANCE = new ParcelableArraySerializer();
    private static final g descriptor = l.k("kotlin.Array<android.os.Parcelable>", new g[0]);

    private ParcelableArraySerializer() {
    }

    @Override // x9.f, x9.InterfaceC2123a
    public g getDescriptor() {
        return descriptor;
    }

    @Override // x9.InterfaceC2123a
    public Parcelable[] deserialize(e decoder) {
        k.f(decoder, "decoder");
        if (!(decoder instanceof SavedStateDecoder)) {
            throw new IllegalArgumentException(BuiltInSerializerKt.decoderErrorMessage(INSTANCE.getDescriptor().h(), decoder).toString());
        }
        SavedStateDecoder savedStateDecoder = (SavedStateDecoder) decoder;
        return SavedStateReader.m7225getParcelableArrayimpl(SavedStateReader.m7177constructorimpl(savedStateDecoder.getSavedState()), savedStateDecoder.getKey(), m.f4928a.b(Parcelable.class));
    }

    @Override // x9.f
    public void serialize(f encoder, Parcelable[] value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        if (!(encoder instanceof SavedStateEncoder)) {
            throw new IllegalArgumentException(BuiltInSerializerKt.encoderErrorMessage(INSTANCE.getDescriptor().h(), encoder).toString());
        }
        SavedStateEncoder savedStateEncoder = (SavedStateEncoder) encoder;
        SavedStateWriter.m7288putParcelableArrayimpl(SavedStateWriter.m7263constructorimpl(savedStateEncoder.getSavedState()), savedStateEncoder.getKey(), value);
    }
}
