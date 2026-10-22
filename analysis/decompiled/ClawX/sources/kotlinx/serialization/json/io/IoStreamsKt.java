package kotlinx.serialization.json.io;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import j6.j;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.DecodeSequenceMode;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.internal.JsonStreamsKt;
import kotlinx.serialization.json.io.internal.IoSerialReader;
import kotlinx.serialization.json.io.internal.JsonToIoStreamWriter;
import w5.i;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a7\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0087\u0080\u0004¢\u0006\u0002\u0010\t\u001a+\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0006\u001a\u0002H\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0087\u0088\u0004¢\u0006\u0002\u0010\n\u001a/\u0010\u000b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0087\u0080\u0004¢\u0006\u0002\u0010\u0010\u001a#\u0010\u000b\u001a\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0087\u0088\u0004¢\u0006\u0002\u0010\u0011\u001a:\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0013\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0087\u0080\u0004\u001a.\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0013\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0087\u0088\u0004¨\u0006\u0016"}, d2 = {"encodeToSink", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "T", "Lkotlinx/serialization/json/Json;", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "value", "sink", "Lkotlinx/io/Sink;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;Lkotlinx/io/Sink;)V", "(Lkotlinx/serialization/json/Json;Ljava/lang/Object;Lkotlinx/io/Sink;)V", "decodeFromSource", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", ExtensionCallContract.SOURCE, "Lkotlinx/io/Source;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/DeserializationStrategy;Lkotlinx/io/Source;)Ljava/lang/Object;", "(Lkotlinx/serialization/json/Json;Lkotlinx/io/Source;)Ljava/lang/Object;", "decodeSourceToSequence", "Lkotlin/sequences/Sequence;", "format", "Lkotlinx/serialization/json/DecodeSequenceMode;", "kotlinx-serialization-json-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IoStreamsKt {
    @ExperimentalSerializationApi
    public static final <T> T decodeFromSource(Json json, DeserializationStrategy<? extends T> deserializer, j source) {
        p.e(json, "<this>");
        p.e(deserializer, "deserializer");
        p.e(source, "source");
        return (T) JsonStreamsKt.decodeByReader(json, deserializer, new IoSerialReader(source));
    }

    @ExperimentalSerializationApi
    public static final <T> i decodeSourceToSequence(Json json, j source, DeserializationStrategy<? extends T> deserializer, DecodeSequenceMode format) {
        p.e(json, "<this>");
        p.e(source, "source");
        p.e(deserializer, "deserializer");
        p.e(format, "format");
        return JsonStreamsKt.decodeToSequenceByReader(json, new IoSerialReader(source), deserializer, format);
    }

    public static /* synthetic */ i decodeSourceToSequence$default(Json json, j jVar, DeserializationStrategy deserializationStrategy, DecodeSequenceMode decodeSequenceMode, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            decodeSequenceMode = DecodeSequenceMode.AUTO_DETECT;
        }
        return decodeSourceToSequence(json, jVar, deserializationStrategy, decodeSequenceMode);
    }

    @ExperimentalSerializationApi
    public static final <T> void encodeToSink(Json json, SerializationStrategy<? super T> serializer, T t8, j6.i sink) {
        p.e(json, "<this>");
        p.e(serializer, "serializer");
        p.e(sink, "sink");
        JsonToIoStreamWriter jsonToIoStreamWriter = new JsonToIoStreamWriter(sink);
        try {
            JsonStreamsKt.encodeByWriter(json, jsonToIoStreamWriter, serializer, t8);
        } finally {
            jsonToIoStreamWriter.release();
        }
    }

    @ExperimentalSerializationApi
    public static final /* synthetic */ <T> T decodeFromSource(Json json, j source) {
        p.e(json, "<this>");
        p.e(source, "source");
        json.getSerializersModule();
        p.i();
        throw null;
    }

    @ExperimentalSerializationApi
    public static final /* synthetic */ <T> i decodeSourceToSequence(Json json, j source, DecodeSequenceMode format) {
        p.e(json, "<this>");
        p.e(source, "source");
        p.e(format, "format");
        json.getSerializersModule();
        p.i();
        throw null;
    }

    public static /* synthetic */ i decodeSourceToSequence$default(Json json, j source, DecodeSequenceMode format, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            format = DecodeSequenceMode.AUTO_DETECT;
        }
        p.e(json, "<this>");
        p.e(source, "source");
        p.e(format, "format");
        json.getSerializersModule();
        p.i();
        throw null;
    }

    @ExperimentalSerializationApi
    public static final /* synthetic */ <T> void encodeToSink(Json json, T t8, j6.i sink) {
        p.e(json, "<this>");
        p.e(sink, "sink");
        json.getSerializersModule();
        p.i();
        throw null;
    }
}
