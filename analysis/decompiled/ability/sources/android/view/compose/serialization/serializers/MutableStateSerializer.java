package android.view.compose.serialization.serializers;

import A9.e;
import H4.o;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import x9.b;
import z2.l;
import z9.f;
import z9.g;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0011R \u0010\u0013\u001a\u00020\u00128\u0016X\u0096\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Landroidx/savedstate/compose/serialization/serializers/MutableStateSerializer;", ExifInterface.GPS_DIRECTION_TRUE, "Lx9/b;", "Landroidx/compose/runtime/MutableState;", "valueSerializer", AppAgent.CONSTRUCT, "(Lx9/b;)V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Landroidx/compose/runtime/MutableState;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Landroidx/compose/runtime/MutableState;", "Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "getDescriptor$annotations", "()V", "savedstate-compose_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MutableStateSerializer<T> implements b {
    private final g descriptor;
    private final b valueSerializer;

    public MutableStateSerializer(b valueSerializer) {
        k.f(valueSerializer, "valueSerializer");
        this.valueSerializer = valueSerializer;
        o kind = valueSerializer.getDescriptor().getKind();
        this.descriptor = kind instanceof f ? l.a("androidx.compose.runtime.MutableState", (f) kind) : l.b("androidx.compose.runtime.MutableState", valueSerializer.getDescriptor());
    }

    public static /* synthetic */ void getDescriptor$annotations() {
    }

    @Override // x9.f, x9.InterfaceC2123a
    public g getDescriptor() {
        return this.descriptor;
    }

    @Override // x9.InterfaceC2123a
    public MutableState<T> deserialize(e decoder) {
        k.f(decoder, "decoder");
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(decoder.decodeSerializableValue(this.valueSerializer), null, 2, null);
    }

    @Override // x9.f
    public void serialize(A9.f encoder, MutableState<T> value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        encoder.encodeSerializableValue(this.valueSerializer, value.getValue());
    }
}
