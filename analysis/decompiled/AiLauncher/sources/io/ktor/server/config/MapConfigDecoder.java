package io.ktor.server.config;

import com.stepos.ailauncher.chat.voice.support.C3081a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import sb.AbstractC5465c;
import sb.d;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lio/ktor/server/config/MapConfigDecoder;", "Lio/ktor/server/config/AbstractMapConfigDecoder;", "", "", C3081a.FOCUS_MAP_NAME, "path", "Lsb/c;", "serializersModule", "<init>", "(Ljava/util/Map;Ljava/lang/String;Lsb/c;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "decodeElementIndex", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "", "decodeNotNullMark", "()Z", "decodeString", "()Ljava/lang/String;", "Lob/c;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lob/c;", "elementIndex", "I", "currentPath", "Ljava/lang/String;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MapConfigDecoder extends AbstractMapConfigDecoder {
    private String currentPath;
    private int elementIndex;

    public /* synthetic */ MapConfigDecoder(Map map, String str, AbstractC5465c abstractC5465c, int i10, i iVar) {
        this(map, (i10 & 2) != 0 ? "" : str, (i10 & 4) != 0 ? d.a() : abstractC5465c);
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public ob.c beginStructure(SerialDescriptor descriptor) {
        p.i(descriptor, "descriptor");
        return beginStructure(descriptor, this.currentPath);
    }

    @Override // io.ktor.server.config.AbstractMapConfigDecoder, ob.c
    public int decodeElementIndex(SerialDescriptor descriptor) {
        p.i(descriptor, "descriptor");
        if (this.elementIndex >= descriptor.getElementsCount()) {
            return -1;
        }
        int i10 = this.elementIndex;
        this.elementIndex = i10 + 1;
        String strE = descriptor.e(i10);
        if (getPath().length() != 0) {
            strE = getPath() + '.' + strE;
        }
        if (!MapConfigDecoderKt.containsPrefix(getMap(), strE)) {
            return -1;
        }
        this.currentPath = strE;
        return i10;
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        return MapConfigDecoderKt.containsPrefix(getMap(), this.currentPath);
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public String decodeString() {
        String str = getMap().get(this.currentPath);
        if (str != null) {
            return str;
        }
        throw new SerializationException("Property " + this.currentPath + " not found");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapConfigDecoder(Map<String, String> map, String path, AbstractC5465c serializersModule) {
        super(map, path, serializersModule);
        p.i(map, "map");
        p.i(path, "path");
        p.i(serializersModule, "serializersModule");
        this.currentPath = path;
    }
}
