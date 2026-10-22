package com.google.gson.internal.bind;

import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeAdapters {
    public static final TypeAdapter<AtomicBoolean> ATOMIC_BOOLEAN = null;
    public static final TypeAdapterFactory ATOMIC_BOOLEAN_FACTORY = null;
    public static final TypeAdapter<AtomicInteger> ATOMIC_INTEGER = null;
    public static final TypeAdapter<AtomicIntegerArray> ATOMIC_INTEGER_ARRAY = null;
    public static final TypeAdapterFactory ATOMIC_INTEGER_ARRAY_FACTORY = null;
    public static final TypeAdapterFactory ATOMIC_INTEGER_FACTORY = null;
    public static final TypeAdapter<BigDecimal> BIG_DECIMAL = null;
    public static final TypeAdapter<BigInteger> BIG_INTEGER = null;
    public static final TypeAdapter<BitSet> BIT_SET = null;
    public static final TypeAdapterFactory BIT_SET_FACTORY = null;
    public static final TypeAdapter<Boolean> BOOLEAN = null;
    public static final TypeAdapter<Boolean> BOOLEAN_AS_STRING = null;
    public static final TypeAdapterFactory BOOLEAN_FACTORY = null;
    public static final TypeAdapter<Number> BYTE = null;
    public static final TypeAdapterFactory BYTE_FACTORY = null;
    public static final TypeAdapter<Calendar> CALENDAR = null;
    public static final TypeAdapterFactory CALENDAR_FACTORY = null;
    public static final TypeAdapter<Character> CHARACTER = null;
    public static final TypeAdapterFactory CHARACTER_FACTORY = null;
    public static final TypeAdapter<Class> CLASS = null;
    public static final TypeAdapterFactory CLASS_FACTORY = null;
    public static final TypeAdapter<Currency> CURRENCY = null;
    public static final TypeAdapterFactory CURRENCY_FACTORY = null;
    public static final TypeAdapter<Number> DOUBLE = null;
    public static final TypeAdapterFactory ENUM_FACTORY = null;
    public static final TypeAdapter<Number> FLOAT = null;
    public static final TypeAdapter<InetAddress> INET_ADDRESS = null;
    public static final TypeAdapterFactory INET_ADDRESS_FACTORY = null;
    public static final TypeAdapter<Number> INTEGER = null;
    public static final TypeAdapterFactory INTEGER_FACTORY = null;
    public static final TypeAdapter<JsonElement> JSON_ELEMENT = null;
    public static final TypeAdapterFactory JSON_ELEMENT_FACTORY = null;
    public static final TypeAdapter<Locale> LOCALE = null;
    public static final TypeAdapterFactory LOCALE_FACTORY = null;
    public static final TypeAdapter<Number> LONG = null;
    public static final TypeAdapter<Number> NUMBER = null;
    public static final TypeAdapterFactory NUMBER_FACTORY = null;
    public static final TypeAdapter<Number> SHORT = null;
    public static final TypeAdapterFactory SHORT_FACTORY = null;
    public static final TypeAdapter<String> STRING = null;
    public static final TypeAdapter<StringBuffer> STRING_BUFFER = null;
    public static final TypeAdapterFactory STRING_BUFFER_FACTORY = null;
    public static final TypeAdapter<StringBuilder> STRING_BUILDER = null;
    public static final TypeAdapterFactory STRING_BUILDER_FACTORY = null;
    public static final TypeAdapterFactory STRING_FACTORY = null;
    public static final TypeAdapterFactory TIMESTAMP_FACTORY = null;
    public static final TypeAdapter<URI> URI = null;
    public static final TypeAdapterFactory URI_FACTORY = null;
    public static final TypeAdapter<URL> URL = null;
    public static final TypeAdapterFactory URL_FACTORY = null;
    public static final TypeAdapter<UUID> UUID = null;
    public static final TypeAdapterFactory UUID_FACTORY = null;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$36, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass36 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = null;

        static {
            int[] r10 = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = r10;
            r10[JsonToken.NUMBER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L26:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L32:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L42:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_ARRAY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L34:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L36:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_DOCUMENT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L38:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NAME.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L24:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_OBJECT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L30:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_ARRAY.ordinal()] = 10;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    public static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        private final Map<T, String> constantToName;
        private final Map<String, T> nameToConstant;

        public EnumTypeAdapter(Class<T> r12) {
            this.nameToConstant = new HashMap();
            this.constantToName = new HashMap();
            T[] r10 = r12.getEnumConstants();     // Catch: NoSuchFieldException -> L10
            int r11 = r10.length;     // Catch: NoSuchFieldException -> L10
            int r13 = 0;
        L4:
            if (r13 >= r11) goto L14;
            T r14 = r10[r13];     // Catch: NoSuchFieldException -> L10
            String r15 = r14.name();     // Catch: NoSuchFieldException -> L10
            SerializedName r16 = (SerializedName) r12.getField(r15).getAnnotation(SerializedName.class);     // Catch: NoSuchFieldException -> L10
            if (r16 == null) goto L12;
            r15 = r16.value();     // Catch: NoSuchFieldException -> L10
            String[] r17 = r16.alternate();     // Catch: NoSuchFieldException -> L10
            int r18 = r17.length;     // Catch: NoSuchFieldException -> L10
            int r19 = 0;
        L8:
            if (r19 >= r18) goto L12;
            this.nameToConstant.put(r17[r19], r14);     // Catch: NoSuchFieldException -> L10
            r19 = r19 + 1;     // Catch: NoSuchFieldException -> L10
        L12:
            this.nameToConstant.put(r15, r14);     // Catch: NoSuchFieldException -> L10
            this.constantToName.put(r14, r15);     // Catch: NoSuchFieldException -> L10
            r13 = r13 + 1;
            goto L4
        L14:
            return;
        L10:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ Object read(JsonReader r10) throws IOException {
            return read(r10);
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ void write(JsonWriter r10, Object r11) throws IOException {
            write(r10, (Enum) r11);
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r10) throws IOException {
            if (r10.peek() != JsonToken.NULL) goto L7;
            r10.nextNull();
            return null;
        L7:
            return this.nameToConstant.get(r10.nextString());
        }

        public void write(JsonWriter r10, T r11) throws IOException {
            if (r11 != null) goto L4;
            String r12 = null;
        L5:
            r10.value(r12);
            return;
        L4:
            r12 = this.constantToName.get(r11);
            goto L5
        }
    }

    static {
        TypeAdapter<Class> r10 = new AnonymousClass1().nullSafe();
        CLASS = r10;
        CLASS_FACTORY = newFactory(Class.class, r10);
        TypeAdapter<BitSet> r11 = new AnonymousClass2().nullSafe();
        BIT_SET = r11;
        BIT_SET_FACTORY = newFactory(BitSet.class, r11);
        TypeAdapter<Boolean> r12 = new AnonymousClass3();
        BOOLEAN = r12;
        BOOLEAN_AS_STRING = new AnonymousClass4();
        BOOLEAN_FACTORY = newFactory(Boolean.TYPE, Boolean.class, r12);
        TypeAdapter<Number> r13 = new AnonymousClass5();
        BYTE = r13;
        BYTE_FACTORY = newFactory(Byte.TYPE, Byte.class, r13);
        TypeAdapter<Number> r14 = new AnonymousClass6();
        SHORT = r14;
        SHORT_FACTORY = newFactory(Short.TYPE, Short.class, r14);
        TypeAdapter<Number> r15 = new AnonymousClass7();
        INTEGER = r15;
        INTEGER_FACTORY = newFactory(Integer.TYPE, Integer.class, r15);
        TypeAdapter<AtomicInteger> r16 = new AnonymousClass8().nullSafe();
        ATOMIC_INTEGER = r16;
        ATOMIC_INTEGER_FACTORY = newFactory(AtomicInteger.class, r16);
        TypeAdapter<AtomicBoolean> r17 = new AnonymousClass9().nullSafe();
        ATOMIC_BOOLEAN = r17;
        ATOMIC_BOOLEAN_FACTORY = newFactory(AtomicBoolean.class, r17);
        TypeAdapter<AtomicIntegerArray> r18 = new AnonymousClass10().nullSafe();
        ATOMIC_INTEGER_ARRAY = r18;
        ATOMIC_INTEGER_ARRAY_FACTORY = newFactory(AtomicIntegerArray.class, r18);
        LONG = new AnonymousClass11();
        FLOAT = new AnonymousClass12();
        DOUBLE = new AnonymousClass13();
        TypeAdapter<Number> r19 = new AnonymousClass14();
        NUMBER = r19;
        NUMBER_FACTORY = newFactory(Number.class, r19);
        TypeAdapter<Character> r20 = new AnonymousClass15();
        CHARACTER = r20;
        CHARACTER_FACTORY = newFactory(Character.TYPE, Character.class, r20);
        TypeAdapter<String> r21 = new AnonymousClass16();
        STRING = r21;
        BIG_DECIMAL = new AnonymousClass17();
        BIG_INTEGER = new AnonymousClass18();
        STRING_FACTORY = newFactory(String.class, r21);
        TypeAdapter<StringBuilder> r22 = new AnonymousClass19();
        STRING_BUILDER = r22;
        STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, r22);
        TypeAdapter<StringBuffer> r23 = new AnonymousClass20();
        STRING_BUFFER = r23;
        STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, r23);
        TypeAdapter<URL> r24 = new AnonymousClass21();
        URL = r24;
        URL_FACTORY = newFactory(URL.class, r24);
        TypeAdapter<URI> r25 = new AnonymousClass22();
        URI = r25;
        URI_FACTORY = newFactory(URI.class, r25);
        TypeAdapter<InetAddress> r26 = new AnonymousClass23();
        INET_ADDRESS = r26;
        INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, r26);
        TypeAdapter<UUID> r27 = new AnonymousClass24();
        UUID = r27;
        UUID_FACTORY = newFactory(UUID.class, r27);
        TypeAdapter<Currency> r28 = new AnonymousClass25().nullSafe();
        CURRENCY = r28;
        CURRENCY_FACTORY = newFactory(Currency.class, r28);
        TIMESTAMP_FACTORY = new AnonymousClass26();
        TypeAdapter<Calendar> r29 = new AnonymousClass27();
        CALENDAR = r29;
        CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, r29);
        TypeAdapter<Locale> r30 = new AnonymousClass28();
        LOCALE = r30;
        LOCALE_FACTORY = newFactory(Locale.class, r30);
        TypeAdapter<JsonElement> r31 = new AnonymousClass29();
        JSON_ELEMENT = r31;
        JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(JsonElement.class, r31);
        ENUM_FACTORY = new AnonymousClass30();
    }

    private TypeAdapters() {
        throw new UnsupportedOperationException();
    }

    public static <TT> TypeAdapterFactory newFactory(final TypeToken<TT> r10, final TypeAdapter<TT> r11) {
        return new AnonymousClass31(r10, r11);
    }

    public static <TT> TypeAdapterFactory newFactoryForMultipleTypes(final Class<TT> r10, final Class<? extends TT> r11, final TypeAdapter<? super TT> r12) {
        return new AnonymousClass34(r10, r11, r12);
    }

    public static <T1> TypeAdapterFactory newTypeHierarchyFactory(final Class<T1> r10, final TypeAdapter<T1> r11) {
        return new AnonymousClass35(r10, r11);
    }

    public static <TT> TypeAdapterFactory newFactory(final Class<TT> r10, final TypeAdapter<TT> r11) {
        return new AnonymousClass32(r10, r11);
    }

    public static <TT> TypeAdapterFactory newFactory(final Class<TT> r10, final Class<TT> r11, final TypeAdapter<? super TT> r12) {
        return new AnonymousClass33(r10, r11, r12);
    }
}
