package io.ktor.server.config;

import La.D;
import La.H;
import Z8.C1174w;
import Z8.F;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import sb.AbstractC5465c;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0010¨\u0006!"}, d2 = {"Lio/ktor/server/config/SubMapConfigDecoder;", "Lio/ktor/server/config/AbstractMapConfigDecoder;", "", "", C3081a.FOCUS_MAP_NAME, "path", "Lsb/c;", "serializersModule", "<init>", "(Ljava/util/Map;Ljava/lang/String;Lsb/c;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "decodeElementIndex", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "decodeString", "()Ljava/lang/String;", "Lob/c;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lob/c;", "Lsb/c;", "getSerializersModule", "()Lsb/c;", "index", "I", "", "keys", "Ljava/util/List;", "getCurrentKeyIndex", "()I", "currentKeyIndex", "getCurrentKey", "currentKey", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
final class SubMapConfigDecoder extends AbstractMapConfigDecoder {
    private int index;
    private final List<String> keys;
    private final AbstractC5465c serializersModule;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubMapConfigDecoder(Map<String, String> map, String path, AbstractC5465c serializersModule) {
        super(map, path, serializersModule);
        p.i(map, "map");
        p.i(path, "path");
        p.i(serializersModule, "serializersModule");
        this.serializersModule = serializersModule;
        Set<String> setKeySet = map.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (D.X((String) obj, path + '.', false, 2, null)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add((String) F.q0(H.a1(H.p1((String) it.next(), path + '.', null, 2, null), new char[]{'.'}, false, 0, 6, null)));
        }
        this.keys = F.g0(arrayList2);
    }

    private final String getCurrentKey() {
        return this.keys.get(getCurrentKeyIndex());
    }

    private final int getCurrentKeyIndex() {
        int i10 = this.index;
        return i10 % 2 == 1 ? (i10 - 1) / 2 : (i10 - 2) / 2;
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public ob.c beginStructure(SerialDescriptor descriptor) {
        p.i(descriptor, "descriptor");
        return beginStructure(descriptor, getPath() + '.' + getCurrentKey());
    }

    @Override // io.ktor.server.config.AbstractMapConfigDecoder, ob.c
    public int decodeElementIndex(SerialDescriptor descriptor) {
        p.i(descriptor, "descriptor");
        if (this.index >= this.keys.size() * 2) {
            return -1;
        }
        int i10 = this.index;
        this.index = i10 + 1;
        return i10;
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public String decodeString() {
        int i10 = this.index;
        if (i10 % 2 == 1) {
            return this.keys.get((i10 - 1) / 2);
        }
        String str = getPath() + '.' + this.keys.get((this.index - 2) / 2);
        String str2 = getMap().get(str);
        if (str2 != null) {
            return str2;
        }
        throw new SerializationException("Missing map value at " + str);
    }

    @Override // io.ktor.server.config.AbstractMapConfigDecoder, ob.c
    public AbstractC5465c getSerializersModule() {
        return this.serializersModule;
    }
}
