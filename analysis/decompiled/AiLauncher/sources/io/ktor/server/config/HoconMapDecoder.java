package io.ktor.server.config;

import Z8.F;
import b8.InterfaceC1455a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.descriptors.SerialDescriptor;
import sb.AbstractC5465c;
import sb.d;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\r0\r0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lio/ktor/server/config/HoconMapDecoder;", "Lio/ktor/server/config/HoconDecoder;", "Lb8/a;", "config", "Lsb/c;", "serializersModule", "<init>", "(Lb8/a;Lsb/c;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "decodeElementIndex", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "", "decodeString", "()Ljava/lang/String;", "Lb8/a;", "Lsb/c;", "getSerializersModule", "()Lsb/c;", "", "kotlin.jvm.PlatformType", "keys", "Ljava/util/List;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HoconMapDecoder extends HoconDecoder {
    private final InterfaceC1455a config;
    private final List<String> keys;
    private final AbstractC5465c serializersModule;

    public /* synthetic */ HoconMapDecoder(InterfaceC1455a interfaceC1455a, AbstractC5465c abstractC5465c, int i10, i iVar) {
        this(interfaceC1455a, (i10 & 2) != 0 ? d.a() : abstractC5465c);
    }

    @Override // io.ktor.server.config.HoconDecoder, ob.c
    public int decodeElementIndex(SerialDescriptor descriptor) {
        p.i(descriptor, "descriptor");
        if (getElementIndex() >= this.keys.size() * 2) {
            return -1;
        }
        int elementIndex = getElementIndex();
        if (getElementIndex() % 2 == 0) {
            String str = this.keys.get(getElementIndex() / 2);
            p.h(str, "get(...)");
            setCurrentPath(str);
        }
        setElementIndex(getElementIndex() + 1);
        return elementIndex;
    }

    @Override // io.ktor.server.config.HoconDecoder, ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public String decodeString() {
        if (getElementIndex() % 2 == 1) {
            return getCurrentPath();
        }
        String strT = this.config.t(getCurrentPath());
        p.f(strT);
        return strT;
    }

    @Override // io.ktor.server.config.HoconDecoder, ob.c
    public AbstractC5465c getSerializersModule() {
        return this.serializersModule;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HoconMapDecoder(InterfaceC1455a config, AbstractC5465c serializersModule) {
        super(config, "", serializersModule);
        p.i(config, "config");
        p.i(serializersModule, "serializersModule");
        this.config = config;
        this.serializersModule = serializersModule;
        this.keys = F.m1(config.K().keySet());
    }
}
