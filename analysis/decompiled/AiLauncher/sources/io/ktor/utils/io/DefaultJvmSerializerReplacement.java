package io.ktor.utils.io;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 \u0017*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\u0017B!\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0007\u0010\bB\t\b\u0016¢\u0006\u0004\b\u0007\u0010\tJ\u000f\u0010\n\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0016¨\u0006\u0018"}, d2 = {"Lio/ktor/utils/io/DefaultJvmSerializerReplacement;", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Externalizable;", "Lio/ktor/utils/io/JvmSerializer;", "serializer", UxipConstants.f30680s, "<init>", "(Lio/ktor/utils/io/JvmSerializer;Ljava/lang/Object;)V", "()V", "readResolve", "()Ljava/lang/Object;", "Ljava/io/ObjectOutput;", "out", "LY8/t;", "writeExternal", "(Ljava/io/ObjectOutput;)V", "Ljava/io/ObjectInput;", "in", "readExternal", "(Ljava/io/ObjectInput;)V", "Lio/ktor/utils/io/JvmSerializer;", "Ljava/lang/Object;", "Companion", "ktor-io"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultJvmSerializerReplacement<T> implements Externalizable {
    private static final long serialVersionUID = 0;
    private JvmSerializer<T> serializer;
    private T value;

    public DefaultJvmSerializerReplacement(JvmSerializer<T> jvmSerializer, T t10) {
        this.serializer = jvmSerializer;
        this.value = t10;
    }

    private final Object readResolve() {
        T t10 = this.value;
        p.f(t10);
        return t10;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput in) throws ClassNotFoundException, IOException {
        p.i(in, "in");
        Object object = in.readObject();
        p.g(object, "null cannot be cast to non-null type io.ktor.utils.io.JvmSerializer<T of io.ktor.utils.io.DefaultJvmSerializerReplacement>");
        JvmSerializer<T> jvmSerializer = (JvmSerializer) object;
        this.serializer = jvmSerializer;
        p.f(jvmSerializer);
        Object object2 = in.readObject();
        p.g(object2, "null cannot be cast to non-null type kotlin.ByteArray");
        this.value = jvmSerializer.jvmDeserialize((byte[]) object2);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput out) throws IOException {
        p.i(out, "out");
        out.writeObject(this.serializer);
        JvmSerializer<T> jvmSerializer = this.serializer;
        p.f(jvmSerializer);
        T t10 = this.value;
        p.f(t10);
        out.writeObject(jvmSerializer.jvmSerialize(t10));
    }

    public DefaultJvmSerializerReplacement() {
        this(null, null);
    }
}
