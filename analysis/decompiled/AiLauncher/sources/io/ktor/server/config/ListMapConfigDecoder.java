package io.ktor.server.config;

import com.fasterxml.jackson.core.JsonFactory;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import io.ktor.http.ContentDisposition;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import sb.AbstractC5465c;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015¨\u0006\u001a"}, d2 = {"Lio/ktor/server/config/ListMapConfigDecoder;", "Lio/ktor/server/config/AbstractMapConfigDecoder;", "", "", C3081a.FOCUS_MAP_NAME, "path", "", ContentDisposition.Parameters.Size, "Lsb/c;", "serializersModule", "<init>", "(Ljava/util/Map;Ljava/lang/String;ILsb/c;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "decodeElementIndex", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "decodeString", "()Ljava/lang/String;", "Lob/c;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lob/c;", "I", "Lsb/c;", "getSerializersModule", "()Lsb/c;", "index", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ListMapConfigDecoder extends AbstractMapConfigDecoder {
    private int index;
    private final AbstractC5465c serializersModule;
    private final int size;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListMapConfigDecoder(Map<String, String> map, String path, int i10, AbstractC5465c serializersModule) {
        super(map, path, serializersModule);
        p.i(map, "map");
        p.i(path, "path");
        p.i(serializersModule, "serializersModule");
        this.size = i10;
        this.serializersModule = serializersModule;
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public ob.c beginStructure(SerialDescriptor descriptor) {
        p.i(descriptor, "descriptor");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getPath());
        sb2.append('.');
        sb2.append(this.index - 1);
        return beginStructure(descriptor, sb2.toString());
    }

    @Override // io.ktor.server.config.AbstractMapConfigDecoder, ob.c
    public int decodeElementIndex(SerialDescriptor descriptor) {
        p.i(descriptor, "descriptor");
        int i10 = this.index;
        if (i10 >= this.size) {
            return -1;
        }
        this.index = i10 + 1;
        return i10;
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public String decodeString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getPath());
        sb2.append('.');
        sb2.append(this.index - 1);
        String string = sb2.toString();
        String str = getMap().get(string);
        if (str != null) {
            return str;
        }
        throw new SerializationException("Missing list element at \"" + string + JsonFactory.DEFAULT_QUOTE_CHAR);
    }

    @Override // io.ktor.server.config.AbstractMapConfigDecoder, ob.c
    public AbstractC5465c getSerializersModule() {
        return this.serializersModule;
    }
}
