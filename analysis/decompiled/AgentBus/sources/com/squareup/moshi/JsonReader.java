package com.squareup.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import ob.b;
import ob.h;
import ob.j;
import ob.k;
import ob.y;

/* loaded from: classes.dex */
public abstract class JsonReader implements Closeable {
    boolean failOnUnknown;
    boolean lenient;
    int[] pathIndices;
    String[] pathNames;
    int[] scopes;
    int stackSize;
    private Map<Class<?>, Object> tags;

    /* renamed from: com.squareup.moshi.JsonReader$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$squareup$moshi$JsonReader$Token;

        static {
            int[] iArr = new int[Token.values().length];
            $SwitchMap$com$squareup$moshi$JsonReader$Token = iArr;
            try {
                iArr[Token.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$squareup$moshi$JsonReader$Token[Token.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$squareup$moshi$JsonReader$Token[Token.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$squareup$moshi$JsonReader$Token[Token.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$squareup$moshi$JsonReader$Token[Token.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$squareup$moshi$JsonReader$Token[Token.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static final class Options {
        final y doubleQuoteSuffix;
        final String[] strings;

        private Options(String[] strArr, y yVar) {
            this.strings = strArr;
            this.doubleQuoteSuffix = yVar;
        }

        @CheckReturnValue
        public static Options of(String... strArr) {
            try {
                k[] kVarArr = new k[strArr.length];
                h hVar = new h();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    JsonUtf8Writer.string(hVar, strArr[i2]);
                    hVar.readByte();
                    kVarArr[i2] = hVar.j(hVar.f7993g);
                }
                return new Options((String[]) strArr.clone(), b.g(kVarArr));
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        public List<String> strings() {
            return Collections.unmodifiableList(Arrays.asList(this.strings));
        }
    }

    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    public JsonReader() {
        this.scopes = new int[32];
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
    }

    @CheckReturnValue
    public static JsonReader of(j jVar) {
        return new JsonUtf8Reader(jVar);
    }

    public abstract void beginArray();

    public abstract void beginObject();

    public abstract void endArray();

    public abstract void endObject();

    @CheckReturnValue
    public final boolean failOnUnknown() {
        return this.failOnUnknown;
    }

    @CheckReturnValue
    public final String getPath() {
        return JsonScope.getPath(this.stackSize, this.scopes, this.pathNames, this.pathIndices);
    }

    @CheckReturnValue
    public abstract boolean hasNext();

    @CheckReturnValue
    public final boolean isLenient() {
        return this.lenient;
    }

    public abstract boolean nextBoolean();

    public abstract double nextDouble();

    public abstract int nextInt();

    public abstract long nextLong();

    @CheckReturnValue
    public abstract String nextName();

    @Nullable
    public abstract <T> T nextNull();

    public abstract j nextSource();

    public abstract String nextString();

    @CheckReturnValue
    public abstract Token peek();

    @CheckReturnValue
    public abstract JsonReader peekJson();

    public abstract void promoteNameToValue();

    public final void pushScope(int i2) {
        int i10 = this.stackSize;
        int[] iArr = this.scopes;
        if (i10 == iArr.length) {
            if (i10 == 256) {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
            this.scopes = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.pathNames;
            this.pathNames = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.pathIndices;
            this.pathIndices = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.scopes;
        int i11 = this.stackSize;
        this.stackSize = i11 + 1;
        iArr3[i11] = i2;
    }

    @Nullable
    public final Object readJsonValue() {
        switch (AnonymousClass1.$SwitchMap$com$squareup$moshi$JsonReader$Token[peek().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                beginArray();
                while (hasNext()) {
                    arrayList.add(readJsonValue());
                }
                endArray();
                return arrayList;
            case 2:
                LinkedHashTreeMap linkedHashTreeMap = new LinkedHashTreeMap();
                beginObject();
                while (hasNext()) {
                    String strNextName = nextName();
                    Object jsonValue = readJsonValue();
                    Object objPut = linkedHashTreeMap.put(strNextName, jsonValue);
                    if (objPut != null) {
                        throw new JsonDataException("Map key '" + strNextName + "' has multiple values at path " + getPath() + ": " + objPut + " and " + jsonValue);
                    }
                }
                endObject();
                return linkedHashTreeMap;
            case 3:
                return nextString();
            case 4:
                return Double.valueOf(nextDouble());
            case 5:
                return Boolean.valueOf(nextBoolean());
            case 6:
                return nextNull();
            default:
                throw new IllegalStateException("Expected a value but was " + peek() + " at path " + getPath());
        }
    }

    @CheckReturnValue
    public abstract int selectName(Options options);

    @CheckReturnValue
    public abstract int selectString(Options options);

    public final void setFailOnUnknown(boolean z4) {
        this.failOnUnknown = z4;
    }

    public final void setLenient(boolean z4) {
        this.lenient = z4;
    }

    public final <T> void setTag(Class<T> cls, T t2) {
        if (!cls.isAssignableFrom(t2.getClass())) {
            throw new IllegalArgumentException("Tag value must be of type ".concat(cls.getName()));
        }
        if (this.tags == null) {
            this.tags = new LinkedHashMap();
        }
        this.tags.put(cls, t2);
    }

    public abstract void skipName();

    public abstract void skipValue();

    public final JsonEncodingException syntaxError(String str) throws JsonEncodingException {
        throw new JsonEncodingException(str + " at path " + getPath());
    }

    @CheckReturnValue
    @Nullable
    public final <T> T tag(Class<T> cls) {
        Map<Class<?>, Object> map = this.tags;
        if (map == null) {
            return null;
        }
        return (T) map.get(cls);
    }

    public final JsonDataException typeMismatch(@Nullable Object obj, Object obj2) {
        if (obj == null) {
            return new JsonDataException("Expected " + obj2 + " but was null at path " + getPath());
        }
        return new JsonDataException("Expected " + obj2 + " but was " + obj + ", a " + obj.getClass().getName() + ", at path " + getPath());
    }

    public JsonReader(JsonReader jsonReader) {
        this.stackSize = jsonReader.stackSize;
        this.scopes = (int[]) jsonReader.scopes.clone();
        this.pathNames = (String[]) jsonReader.pathNames.clone();
        this.pathIndices = (int[]) jsonReader.pathIndices.clone();
        this.lenient = jsonReader.lenient;
        this.failOnUnknown = jsonReader.failOnUnknown;
    }
}
