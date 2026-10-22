package N5;

import La.B;
import La.D;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001f\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\t8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001f\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000eR\u001f\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\t8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000e¨\u0006\u0017"}, d2 = {"LN5/A;", "", "<init>", "()V", "Lcom/google/gson/stream/JsonReader;", "reader", "", "f", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Double;", "Lcom/google/gson/TypeAdapter;", "", "intAdapter", "Lcom/google/gson/TypeAdapter;", Const.INTENT_KEY_UMID, "()Lcom/google/gson/TypeAdapter;", "", "longAdapter", "e", "doubleAdapter", Const.INTENT_KEY_PKGNAME, "", "floatAdapter", "c", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class A {
    public static final A INSTANCE = new A();
    private static final TypeAdapter<Integer> intAdapter = new d();
    private static final TypeAdapter<Long> longAdapter = new e();
    private static final TypeAdapter<Double> doubleAdapter = new b();
    private static final TypeAdapter<Float> floatAdapter = new c();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JsonToken.values().length];
            try {
                iArr[JsonToken.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[JsonToken.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"N5/A$b", "Lcom/google/gson/TypeAdapter;", "", "Lcom/google/gson/stream/JsonWriter;", "out", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Double;)V", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Double;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends TypeAdapter<Double> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter out, Double value) throws IOException {
            kotlin.jvm.internal.p.i(out, "out");
            if (value == null) {
                out.nullValue();
            } else {
                out.value(value.doubleValue());
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Double read(JsonReader reader) {
            kotlin.jvm.internal.p.i(reader, "reader");
            return A.INSTANCE.f(reader);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"N5/A$c", "Lcom/google/gson/TypeAdapter;", "", "Lcom/google/gson/stream/JsonWriter;", "out", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Float;)V", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Float;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends TypeAdapter<Float> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter out, Float value) throws IOException {
            kotlin.jvm.internal.p.i(out, "out");
            if (value == null) {
                out.nullValue();
            } else {
                out.value(value.floatValue());
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Float read(JsonReader reader) throws IOException {
            kotlin.jvm.internal.p.i(reader, "reader");
            Double dF = A.INSTANCE.f(reader);
            if (dF != null) {
                return Float.valueOf((float) dF.doubleValue());
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"N5/A$d", "Lcom/google/gson/TypeAdapter;", "", "Lcom/google/gson/stream/JsonWriter;", "out", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Integer;)V", "Lcom/google/gson/stream/JsonReader;", "reader", Const.INTENT_KEY_APIKEY, "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Integer;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends TypeAdapter<Integer> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer read(JsonReader reader) throws IOException {
            kotlin.jvm.internal.p.i(reader, "reader");
            Double dF = A.INSTANCE.f(reader);
            if (dF != null) {
                return Integer.valueOf((int) dF.doubleValue());
            }
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter out, Integer value) throws IOException {
            kotlin.jvm.internal.p.i(out, "out");
            if (value == null) {
                out.nullValue();
            } else {
                out.value(value.intValue());
            }
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"N5/A$e", "Lcom/google/gson/TypeAdapter;", "", "Lcom/google/gson/stream/JsonWriter;", "out", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Long;)V", "Lcom/google/gson/stream/JsonReader;", "reader", Const.INTENT_KEY_APIKEY, "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Long;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e extends TypeAdapter<Long> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long read(JsonReader reader) throws IOException {
            kotlin.jvm.internal.p.i(reader, "reader");
            Double dF = A.INSTANCE.f(reader);
            if (dF != null) {
                return Long.valueOf((long) dF.doubleValue());
            }
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter out, Long value) throws IOException {
            kotlin.jvm.internal.p.i(out, "out");
            if (value == null) {
                out.nullValue();
            } else {
                out.value(value.longValue());
            }
        }
    }

    public final TypeAdapter<Double> b() {
        return doubleAdapter;
    }

    public final TypeAdapter<Float> c() {
        return floatAdapter;
    }

    public final TypeAdapter<Integer> d() {
        return intAdapter;
    }

    public final TypeAdapter<Long> e() {
        return longAdapter;
    }

    public final Double f(JsonReader reader) throws IOException {
        JsonToken jsonTokenPeek = reader.peek();
        int i10 = jsonTokenPeek == null ? -1 : a.$EnumSwitchMapping$0[jsonTokenPeek.ordinal()];
        if (i10 == 1) {
            reader.nextNull();
            return null;
        }
        if (i10 == 2) {
            return Double.valueOf(reader.nextDouble());
        }
        if (i10 != 3) {
            if (i10 == 4) {
                return Double.valueOf(reader.nextBoolean() ? 1.0d : 0.0d);
            }
            reader.skipValue();
            return null;
        }
        String strNextString = reader.nextString();
        kotlin.jvm.internal.p.f(strNextString);
        if (strNextString.length() == 0 || D.L(strNextString, "null", true)) {
            return null;
        }
        return B.t(strNextString);
    }
}
