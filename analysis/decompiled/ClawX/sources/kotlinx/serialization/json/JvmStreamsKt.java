package kotlinx.serialization.json;

import com.stepos.stepclaw.SecurePrefs;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.internal.JavaStreamSerialReader;
import kotlinx.serialization.json.internal.JsonStreamsKt;
import kotlinx.serialization.json.internal.JsonToJavaStreamWriter;
import w5.i;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a7\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0087\u0080\u0004¢\u0006\u0002\u0010\t\u001a+\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0006\u001a\u0002H\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0087\u0088\u0004¢\u0006\u0002\u0010\n\u001a/\u0010\u000b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\r2\u0006\u0010\u0007\u001a\u00020\u000eH\u0087\u0080\u0004¢\u0006\u0002\u0010\u000f\u001a#\u0010\u000b\u001a\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u000eH\u0087\u0088\u0004¢\u0006\u0002\u0010\u0010\u001a:\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0012\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u000e2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0087\u0080\u0004\u001a.\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0012\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0087\u0088\u0004¨\u0006\u0015"}, d2 = {"encodeToStream", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "T", "Lkotlinx/serialization/json/Json;", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "value", "stream", "Ljava/io/OutputStream;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;Ljava/io/OutputStream;)V", "(Lkotlinx/serialization/json/Json;Ljava/lang/Object;Ljava/io/OutputStream;)V", "decodeFromStream", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "Ljava/io/InputStream;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/DeserializationStrategy;Ljava/io/InputStream;)Ljava/lang/Object;", "(Lkotlinx/serialization/json/Json;Ljava/io/InputStream;)Ljava/lang/Object;", "decodeToSequence", "Lkotlin/sequences/Sequence;", "format", "Lkotlinx/serialization/json/DecodeSequenceMode;", "kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class JvmStreamsKt {
    @ExperimentalSerializationApi
    public static final <T> T decodeFromStream(Json json, DeserializationStrategy<? extends T> deserializer, InputStream stream) {
        p.e(json, "<this>");
        p.e(deserializer, "deserializer");
        p.e(stream, "stream");
        JavaStreamSerialReader javaStreamSerialReader = new JavaStreamSerialReader(stream);
        try {
            return (T) JsonStreamsKt.decodeByReader(json, deserializer, javaStreamSerialReader);
        } finally {
            javaStreamSerialReader.release();
        }
    }

    @ExperimentalSerializationApi
    public static final <T> i decodeToSequence(Json json, InputStream stream, DeserializationStrategy<? extends T> deserializer, DecodeSequenceMode format) {
        p.e(json, "<this>");
        p.e(stream, "stream");
        p.e(deserializer, "deserializer");
        p.e(format, "format");
        return JsonStreamsKt.decodeToSequenceByReader(json, new JavaStreamSerialReader(stream), deserializer, format);
    }

    public static /* synthetic */ i decodeToSequence$default(Json json, InputStream inputStream, DeserializationStrategy deserializationStrategy, DecodeSequenceMode decodeSequenceMode, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            decodeSequenceMode = DecodeSequenceMode.AUTO_DETECT;
        }
        return decodeToSequence(json, inputStream, deserializationStrategy, decodeSequenceMode);
    }

    @ExperimentalSerializationApi
    public static final <T> void encodeToStream(Json json, SerializationStrategy<? super T> serializer, T t8, OutputStream stream) throws IOException {
        p.e(json, "<this>");
        p.e(serializer, "serializer");
        p.e(stream, "stream");
        JsonToJavaStreamWriter jsonToJavaStreamWriter = new JsonToJavaStreamWriter(stream);
        try {
            JsonStreamsKt.encodeByWriter(json, jsonToJavaStreamWriter, serializer, t8);
        } finally {
            jsonToJavaStreamWriter.release();
        }
    }

    @ExperimentalSerializationApi
    public static final /* synthetic */ <T> i decodeToSequence(Json json, InputStream stream, DecodeSequenceMode format) {
        p.e(json, "<this>");
        p.e(stream, "stream");
        p.e(format, "format");
        json.getSerializersModule();
        p.i();
        throw null;
    }

    public static /* synthetic */ i decodeToSequence$default(Json json, InputStream stream, DecodeSequenceMode format, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            format = DecodeSequenceMode.AUTO_DETECT;
        }
        p.e(json, "<this>");
        p.e(stream, "stream");
        p.e(format, "format");
        json.getSerializersModule();
        p.i();
        throw null;
    }

    @ExperimentalSerializationApi
    public static final /* synthetic */ <T> T decodeFromStream(Json json, InputStream stream) {
        p.e(json, "<this>");
        p.e(stream, "stream");
        json.getSerializersModule();
        p.i();
        throw null;
    }

    @ExperimentalSerializationApi
    public static final /* synthetic */ <T> void encodeToStream(Json json, T t8, OutputStream stream) {
        p.e(json, "<this>");
        p.e(stream, "stream");
        json.getSerializersModule();
        p.i();
        throw null;
    }
}
