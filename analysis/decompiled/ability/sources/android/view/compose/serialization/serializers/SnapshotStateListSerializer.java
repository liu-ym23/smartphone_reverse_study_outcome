package android.view.compose.serialization.serializers;

import A9.e;
import A9.f;
import B9.C0177d;
import D7.v;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import x9.b;
import z2.l;
import z9.g;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0011R \u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R \u0010\u0015\u001a\u00020\u00148\u0016X\u0096\u0004¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Landroidx/savedstate/compose/serialization/serializers/SnapshotStateListSerializer;", ExifInterface.GPS_DIRECTION_TRUE, "Lx9/b;", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "elementSerializer", AppAgent.CONSTRUCT, "(Lx9/b;)V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Landroidx/compose/runtime/snapshots/SnapshotStateList;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lx9/b;", "", "base", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "getDescriptor$annotations", "()V", "savedstate-compose_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SnapshotStateListSerializer<T> implements b {
    private final b base;
    private final g descriptor;
    private final b elementSerializer;

    public SnapshotStateListSerializer(b elementSerializer) {
        k.f(elementSerializer, "elementSerializer");
        this.elementSerializer = elementSerializer;
        C0177d c0177dD = AbstractC1451a.d(elementSerializer);
        this.base = c0177dD;
        this.descriptor = l.b("androidx.compose.runtime.SnapshotStateList", c0177dD.b);
    }

    public static /* synthetic */ void getDescriptor$annotations() {
    }

    @Override // x9.f, x9.InterfaceC2123a
    public g getDescriptor() {
        return this.descriptor;
    }

    @Override // x9.InterfaceC2123a
    public SnapshotStateList<T> deserialize(e decoder) {
        k.f(decoder, "decoder");
        List list = (List) decoder.decodeSerializableValue(this.base);
        SnapshotStateList<T> snapshotStateList = new SnapshotStateList<>();
        snapshotStateList.addAll(v.f1(list));
        return snapshotStateList;
    }

    @Override // x9.f
    public void serialize(f encoder, SnapshotStateList<T> value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        encoder.encodeSerializableValue(this.base, value);
    }
}
