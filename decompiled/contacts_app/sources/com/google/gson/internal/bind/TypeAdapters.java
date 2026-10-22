package com.google.gson.internal.bind;

import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.security.AccessController;
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

/* JADX INFO: loaded from: classes2.dex */
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
    public static final TypeAdapter<LazilyParsedNumber> LAZILY_PARSED_NUMBER = null;
    public static final TypeAdapter<Locale> LOCALE = null;
    public static final TypeAdapterFactory LOCALE_FACTORY = null;
    public static final TypeAdapter<Number> LONG = null;
    public static final TypeAdapter<Number> SHORT = null;
    public static final TypeAdapterFactory SHORT_FACTORY = null;
    public static final TypeAdapter<String> STRING = null;
    public static final TypeAdapter<StringBuffer> STRING_BUFFER = null;
    public static final TypeAdapterFactory STRING_BUFFER_FACTORY = null;
    public static final TypeAdapter<StringBuilder> STRING_BUILDER = null;
    public static final TypeAdapterFactory STRING_BUILDER_FACTORY = null;
    public static final TypeAdapterFactory STRING_FACTORY = null;
    public static final TypeAdapter<URI> URI = null;
    public static final TypeAdapterFactory URI_FACTORY = null;
    public static final TypeAdapter<URL> URL = null;
    public static final TypeAdapterFactory URL_FACTORY = null;
    public static final TypeAdapter<UUID> UUID = null;
    public static final TypeAdapterFactory UUID_FACTORY = null;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$42, reason: invalid class name */
    static /* synthetic */ class AnonymousClass42 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = null;

        static {
            int[] r0 = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = r0;
            r0[JsonToken.NUMBER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_ARRAY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    private static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        private final Map<T, String> constantToName;
        private final Map<String, T> nameToConstant;
        private final Map<String, T> stringToConstant;

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ Object read(JsonReader r1) throws IOException {
            return read(r1);
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ void write(JsonWriter r1, Object r2) throws IOException {
            write(r1, (Enum) r2);
        }

        public EnumTypeAdapter(final Class<T> r12) {
            this.nameToConstant = new HashMap();
            this.stringToConstant = new HashMap();
            this.constantToName = new HashMap();
            Field[] r13 = (Field[]) AccessController.doPrivileged(new AnonymousClass1(this, r12));     // Catch: IllegalAccessException -> L13
            int r0 = r13.length;     // Catch: IllegalAccessException -> L13
            int r2 = 0;
        L4:
            if (r2 >= r0) goto L12;
            Field r3 = r13[r2];     // Catch: IllegalAccessException -> L13
            Enum r4 = (Enum) r3.get(null);     // Catch: IllegalAccessException -> L13
            String r5 = r4.name();     // Catch: IllegalAccessException -> L13
            String r6 = r4.toString();     // Catch: IllegalAccessException -> L13
            SerializedName r7 = (SerializedName) r3.getAnnotation(SerializedName.class);     // Catch: IllegalAccessException -> L13
            if (r7 == null) goto L10;
            r5 = r7.value();     // Catch: IllegalAccessException -> L13
            String[] r8 = r7.alternate();     // Catch: IllegalAccessException -> L13
            int r9 = r8.length;     // Catch: IllegalAccessException -> L13
            int r10 = 0;
        L8:
            if (r10 >= r9) goto L10;
            this.nameToConstant.put(r8[r10], (T) r4);     // Catch: IllegalAccessException -> L13
            r10 = r10 + 1;     // Catch: IllegalAccessException -> L13
        L10:
            this.nameToConstant.put(r5, (T) r4);     // Catch: IllegalAccessException -> L13
            this.stringToConstant.put(r6, (T) r4);     // Catch: IllegalAccessException -> L13
            this.constantToName.put((T) r4, r5);     // Catch: IllegalAccessException -> L13
            r2 = r2 + 1;
            goto L4
        L12:
            return;
        L13:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r3) throws IOException {
            if (r3.peek() != JsonToken.NULL) goto L6;
            r3.nextNull();
            return null;
        L6:
            String r4 = r3.nextString();
            T r0 = this.nameToConstant.get(r4);
            if (r0 == null) goto L9;
            return r0;
        L9:
            return this.stringToConstant.get(r4);
        }

        public void write(JsonWriter r1, T r2) throws IOException {
            if (r2 != null) goto L4;
            String r0 = null;
        L5:
            r1.value(r0);
            return;
        L4:
            r0 = this.constantToName.get(r2);
            goto L5
        }
    }

    private TypeAdapters() {
        throw new UnsupportedOperationException();
    }

    static {
        TypeAdapter<Class> r0 = new AnonymousClass1().nullSafe();
        CLASS = r0;
        CLASS_FACTORY = newFactory(Class.class, r0);
        TypeAdapter<BitSet> r1 = new AnonymousClass2().nullSafe();
        BIT_SET = r1;
        BIT_SET_FACTORY = newFactory(BitSet.class, r1);
        TypeAdapter<Boolean> r2 = new AnonymousClass3();
        BOOLEAN = r2;
        BOOLEAN_AS_STRING = new AnonymousClass4();
        BOOLEAN_FACTORY = newFactory(Boolean.TYPE, Boolean.class, r2);
        TypeAdapter<Number> r3 = new AnonymousClass5();
        BYTE = r3;
        BYTE_FACTORY = newFactory(Byte.TYPE, Byte.class, r3);
        TypeAdapter<Number> r4 = new AnonymousClass6();
        SHORT = r4;
        SHORT_FACTORY = newFactory(Short.TYPE, Short.class, r4);
        TypeAdapter<Number> r5 = new AnonymousClass7();
        INTEGER = r5;
        INTEGER_FACTORY = newFactory(Integer.TYPE, Integer.class, r5);
        TypeAdapter<AtomicInteger> r6 = new AnonymousClass8().nullSafe();
        ATOMIC_INTEGER = r6;
        ATOMIC_INTEGER_FACTORY = newFactory(AtomicInteger.class, r6);
        TypeAdapter<AtomicBoolean> r7 = new AnonymousClass9().nullSafe();
        ATOMIC_BOOLEAN = r7;
        ATOMIC_BOOLEAN_FACTORY = newFactory(AtomicBoolean.class, r7);
        TypeAdapter<AtomicIntegerArray> r8 = new AnonymousClass10().nullSafe();
        ATOMIC_INTEGER_ARRAY = r8;
        ATOMIC_INTEGER_ARRAY_FACTORY = newFactory(AtomicIntegerArray.class, r8);
        LONG = new AnonymousClass11();
        FLOAT = new AnonymousClass12();
        DOUBLE = new AnonymousClass13();
        TypeAdapter<Character> r9 = new AnonymousClass14();
        CHARACTER = r9;
        CHARACTER_FACTORY = newFactory(Character.TYPE, Character.class, r9);
        TypeAdapter<String> r10 = new AnonymousClass15();
        STRING = r10;
        BIG_DECIMAL = new AnonymousClass16();
        BIG_INTEGER = new AnonymousClass17();
        LAZILY_PARSED_NUMBER = new AnonymousClass18();
        STRING_FACTORY = newFactory(String.class, r10);
        TypeAdapter<StringBuilder> r11 = new AnonymousClass19();
        STRING_BUILDER = r11;
        STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, r11);
        TypeAdapter<StringBuffer> r12 = new AnonymousClass20();
        STRING_BUFFER = r12;
        STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, r12);
        TypeAdapter<URL> r13 = new AnonymousClass21();
        URL = r13;
        URL_FACTORY = newFactory(URL.class, r13);
        TypeAdapter<URI> r14 = new AnonymousClass22();
        URI = r14;
        URI_FACTORY = newFactory(URI.class, r14);
        TypeAdapter<InetAddress> r15 = new AnonymousClass23();
        INET_ADDRESS = r15;
        INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, r15);
        TypeAdapter<UUID> r16 = new AnonymousClass24();
        UUID = r16;
        UUID_FACTORY = newFactory(UUID.class, r16);
        TypeAdapter<Currency> r17 = new AnonymousClass25().nullSafe();
        CURRENCY = r17;
        CURRENCY_FACTORY = newFactory(Currency.class, r17);
        TypeAdapter<Calendar> r18 = new AnonymousClass26();
        CALENDAR = r18;
        CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, r18);
        TypeAdapter<Locale> r19 = new AnonymousClass27();
        LOCALE = r19;
        LOCALE_FACTORY = newFactory(Locale.class, r19);
        TypeAdapter<JsonElement> r20 = new AnonymousClass28();
        JSON_ELEMENT = r20;
        JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(JsonElement.class, r20);
        ENUM_FACTORY = new AnonymousClass29();
    }

    public static <TT> TypeAdapterFactory newFactory(final TypeToken<TT> r1, final TypeAdapter<TT> r2) {
        return new AnonymousClass30(r1, r2);
    }

    public static <TT> TypeAdapterFactory newFactory(final Class<TT> r1, final TypeAdapter<TT> r2) {
        return new AnonymousClass31(r1, r2);
    }

    public static <TT> TypeAdapterFactory newFactory(final Class<TT> r1, final Class<TT> r2, final TypeAdapter<? super TT> r3) {
        return new AnonymousClass32(r1, r2, r3);
    }

    public static <TT> TypeAdapterFactory newFactoryForMultipleTypes(final Class<TT> r1, final Class<? extends TT> r2, final TypeAdapter<? super TT> r3) {
        return new AnonymousClass33(r1, r2, r3);
    }

    public static <T1> TypeAdapterFactory newTypeHierarchyFactory(final Class<T1> r1, final TypeAdapter<T1> r2) {
        return new AnonymousClass34(r1, r2);
    }
}
