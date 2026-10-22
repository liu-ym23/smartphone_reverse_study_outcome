package android.view.serialization;

import A9.a;
import E9.e;
import E9.g;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import x9.InterfaceC2123a;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/savedstate/serialization/EmptyArrayDecoder;", "LA9/a;", AppAgent.CONSTRUCT, "()V", "Lz9/g;", "descriptor", "", "decodeElementIndex", "(Lz9/g;)I", "LE9/e;", "serializersModule", "LE9/e;", "getSerializersModule", "()LE9/e;", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
final class EmptyArrayDecoder extends a {
    public static final EmptyArrayDecoder INSTANCE = new EmptyArrayDecoder();
    private static final e serializersModule = g.f499a;

    private EmptyArrayDecoder() {
    }

    @Override // A9.c
    public /* bridge */ /* synthetic */ int decodeCollectionSize(z9.g gVar) {
        super.decodeCollectionSize(gVar);
        return -1;
    }

    @Override // A9.c
    public int decodeElementIndex(z9.g descriptor) {
        k.f(descriptor, "descriptor");
        return -1;
    }

    public Object decodeNullableSerializableValue(InterfaceC2123a deserializer) {
        k.f(deserializer, "deserializer");
        return (deserializer.getDescriptor().b() || decodeNotNullMark()) ? decodeSerializableValue(deserializer) : decodeNull();
    }

    @Override // A9.c
    public /* bridge */ /* synthetic */ boolean decodeSequentially() {
        return false;
    }

    @Override // A9.e
    public /* bridge */ /* synthetic */ Object decodeSerializableValue(InterfaceC2123a interfaceC2123a) {
        return super.decodeSerializableValue(interfaceC2123a);
    }

    @Override // A9.c
    public e getSerializersModule() {
        return serializersModule;
    }
}
