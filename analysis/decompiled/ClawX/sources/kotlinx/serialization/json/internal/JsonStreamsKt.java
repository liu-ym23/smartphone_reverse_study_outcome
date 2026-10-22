package kotlinx.serialization.json.internal;

import c5.b;
import com.stepos.stepclaw.SecurePrefs;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.DecodeSequenceMode;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonEncoder;
import w5.i;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a;\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00060\f2\u0006\u0010\r\u001a\u0002H\u0006H\u0087\u0080\u0004¢\u0006\u0002\u0010\u000e\u001a3\u0010\u000f\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0014\u001a>\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0016\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0087\u0080\u0004\u001a2\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0016\"\u0006\b\u0000\u0010\u0006\u0018\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0087\u0088\u0004\"\u000f\u0010\u0000\u001a\u00020\u0001X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010\u0002\u001a\u00020\u0001X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010\u0003\u001a\u00020\u0001X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"SINGLE_CHAR_MAX_CODEPOINT", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "HIGH_SURROGATE_HEADER", "LOW_SURROGATE_HEADER", "encodeByWriter", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "T", "json", "Lkotlinx/serialization/json/Json;", "writer", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "value", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/InternalJsonWriter;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "decodeByReader", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "reader", "Lkotlinx/serialization/json/internal/InternalJsonReader;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/DeserializationStrategy;Lkotlinx/serialization/json/internal/InternalJsonReader;)Ljava/lang/Object;", "decodeToSequenceByReader", "Lkotlin/sequences/Sequence;", "format", "Lkotlinx/serialization/json/DecodeSequenceMode;", "kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class JsonStreamsKt {
    private static final int HIGH_SURROGATE_HEADER = 55232;
    private static final int LOW_SURROGATE_HEADER = 56320;
    private static final int SINGLE_CHAR_MAX_CODEPOINT = 65535;

    @JsonFriendModuleApi
    public static final <T> T decodeByReader(Json json, DeserializationStrategy<? extends T> deserializer, InternalJsonReader reader) {
        p.e(json, "json");
        p.e(deserializer, "deserializer");
        p.e(reader, "reader");
        ReaderJsonLexer readerJsonLexerReaderJsonLexer$default = ReaderJsonLexerKt.ReaderJsonLexer$default(json, reader, null, 4, null);
        try {
            T t8 = (T) new StreamingJsonDecoder(json, WriteMode.OBJ, readerJsonLexerReaderJsonLexer$default, deserializer.getDescriptor(), null).decodeSerializableValue(deserializer);
            readerJsonLexerReaderJsonLexer$default.expectEof();
            return t8;
        } finally {
            readerJsonLexerReaderJsonLexer$default.release();
        }
    }

    @JsonFriendModuleApi
    @ExperimentalSerializationApi
    public static final <T> i decodeToSequenceByReader(Json json, InternalJsonReader reader, DeserializationStrategy<? extends T> deserializer, DecodeSequenceMode format) {
        p.e(json, "json");
        p.e(reader, "reader");
        p.e(deserializer, "deserializer");
        p.e(format, "format");
        final Iterator itJsonIterator = JsonIteratorKt.JsonIterator(format, json, ReaderJsonLexerKt.ReaderJsonLexer(json, reader, new char[ReaderJsonLexerKt.BATCH_SIZE]), deserializer);
        return new w5.a(new i() { // from class: kotlinx.serialization.json.internal.JsonStreamsKt$decodeToSequenceByReader$$inlined$Sequence$1
            @Override // w5.i
            public Iterator<T> iterator() {
                return itJsonIterator;
            }
        });
    }

    public static /* synthetic */ i decodeToSequenceByReader$default(Json json, InternalJsonReader internalJsonReader, DeserializationStrategy deserializationStrategy, DecodeSequenceMode decodeSequenceMode, int i8, Object obj) {
        if ((i8 & 8) != 0) {
            decodeSequenceMode = DecodeSequenceMode.AUTO_DETECT;
        }
        return decodeToSequenceByReader(json, internalJsonReader, deserializationStrategy, decodeSequenceMode);
    }

    @JsonFriendModuleApi
    public static final <T> void encodeByWriter(Json json, InternalJsonWriter writer, SerializationStrategy<? super T> serializer, T t8) {
        p.e(json, "json");
        p.e(writer, "writer");
        p.e(serializer, "serializer");
        new StreamingJsonEncoder(writer, json, WriteMode.OBJ, new JsonEncoder[((b) WriteMode.getEntries()).size()]).encodeSerializableValue(serializer, t8);
    }

    public static /* synthetic */ i decodeToSequenceByReader$default(Json json, InternalJsonReader reader, DecodeSequenceMode format, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            format = DecodeSequenceMode.AUTO_DETECT;
        }
        p.e(json, "json");
        p.e(reader, "reader");
        p.e(format, "format");
        json.getSerializersModule();
        p.i();
        throw null;
    }

    @JsonFriendModuleApi
    @ExperimentalSerializationApi
    public static final /* synthetic */ <T> i decodeToSequenceByReader(Json json, InternalJsonReader reader, DecodeSequenceMode format) {
        p.e(json, "json");
        p.e(reader, "reader");
        p.e(format, "format");
        json.getSerializersModule();
        p.i();
        throw null;
    }
}
