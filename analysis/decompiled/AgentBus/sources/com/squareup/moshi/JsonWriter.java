package com.squareup.moshi;

import java.io.Closeable;
import java.io.Flushable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import ob.i;
import ob.j;

/* loaded from: classes.dex */
public abstract class JsonWriter implements Closeable, Flushable {
    String indent;
    boolean lenient;
    boolean promoteValueToName;
    boolean serializeNulls;
    private Map<Class<?>, Object> tags;
    int stackSize = 0;
    int[] scopes = new int[32];
    String[] pathNames = new String[32];
    int[] pathIndices = new int[32];
    int flattenStackSize = -1;

    @CheckReturnValue
    public static JsonWriter of(i iVar) {
        return new JsonUtf8Writer(iVar);
    }

    public abstract JsonWriter beginArray();

    @CheckReturnValue
    public final int beginFlatten() {
        int iPeekScope = peekScope();
        if (iPeekScope != 5 && iPeekScope != 3 && iPeekScope != 2 && iPeekScope != 1) {
            throw new IllegalStateException("Nesting problem.");
        }
        int i2 = this.flattenStackSize;
        this.flattenStackSize = this.stackSize;
        return i2;
    }

    public abstract JsonWriter beginObject();

    public final boolean checkStack() {
        int i2 = this.stackSize;
        int[] iArr = this.scopes;
        if (i2 != iArr.length) {
            return false;
        }
        if (i2 == 256) {
            throw new JsonDataException("Nesting too deep at " + getPath() + ": circular reference?");
        }
        this.scopes = Arrays.copyOf(iArr, iArr.length * 2);
        String[] strArr = this.pathNames;
        this.pathNames = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        int[] iArr2 = this.pathIndices;
        this.pathIndices = Arrays.copyOf(iArr2, iArr2.length * 2);
        if (!(this instanceof JsonValueWriter)) {
            return true;
        }
        JsonValueWriter jsonValueWriter = (JsonValueWriter) this;
        Object[] objArr = jsonValueWriter.stack;
        jsonValueWriter.stack = Arrays.copyOf(objArr, objArr.length * 2);
        return true;
    }

    public abstract JsonWriter endArray();

    public final void endFlatten(int i2) {
        this.flattenStackSize = i2;
    }

    public abstract JsonWriter endObject();

    @CheckReturnValue
    public final String getIndent() {
        String str = this.indent;
        return str != null ? str : "";
    }

    @CheckReturnValue
    public final String getPath() {
        return JsonScope.getPath(this.stackSize, this.scopes, this.pathNames, this.pathIndices);
    }

    @CheckReturnValue
    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    @CheckReturnValue
    public final boolean isLenient() {
        return this.lenient;
    }

    public final JsonWriter jsonValue(@Nullable Object obj) {
        if (obj instanceof Map) {
            beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (!(key instanceof String)) {
                    throw new IllegalArgumentException(key == null ? "Map keys must be non-null" : "Map keys must be of type String: ".concat(key.getClass().getName()));
                }
                name((String) key);
                jsonValue(entry.getValue());
            }
            endObject();
            return this;
        }
        if (obj instanceof List) {
            beginArray();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                jsonValue(it.next());
            }
            endArray();
            return this;
        }
        if (obj instanceof String) {
            value((String) obj);
            return this;
        }
        if (obj instanceof Boolean) {
            value(((Boolean) obj).booleanValue());
            return this;
        }
        if (obj instanceof Double) {
            value(((Double) obj).doubleValue());
            return this;
        }
        if (obj instanceof Long) {
            value(((Long) obj).longValue());
            return this;
        }
        if (obj instanceof Number) {
            value((Number) obj);
            return this;
        }
        if (obj != null) {
            throw new IllegalArgumentException("Unsupported type: ".concat(obj.getClass().getName()));
        }
        nullValue();
        return this;
    }

    public abstract JsonWriter name(String str);

    public abstract JsonWriter nullValue();

    public final int peekScope() {
        int i2 = this.stackSize;
        if (i2 != 0) {
            return this.scopes[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void promoteValueToName() {
        int iPeekScope = peekScope();
        if (iPeekScope != 5 && iPeekScope != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        this.promoteValueToName = true;
    }

    public final void pushScope(int i2) {
        int[] iArr = this.scopes;
        int i10 = this.stackSize;
        this.stackSize = i10 + 1;
        iArr[i10] = i2;
    }

    public final void replaceTop(int i2) {
        this.scopes[this.stackSize - 1] = i2;
    }

    public void setIndent(String str) {
        if (str.isEmpty()) {
            str = null;
        }
        this.indent = str;
    }

    public final void setLenient(boolean z4) {
        this.lenient = z4;
    }

    public final void setSerializeNulls(boolean z4) {
        this.serializeNulls = z4;
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

    @CheckReturnValue
    @Nullable
    public final <T> T tag(Class<T> cls) {
        Map<Class<?>, Object> map = this.tags;
        if (map == null) {
            return null;
        }
        return (T) map.get(cls);
    }

    public abstract JsonWriter value(double d6);

    public abstract JsonWriter value(long j2);

    public abstract JsonWriter value(@Nullable Boolean bool);

    public abstract JsonWriter value(@Nullable Number number);

    public abstract JsonWriter value(@Nullable String str);

    public final JsonWriter value(j jVar) {
        if (this.promoteValueToName) {
            throw new IllegalStateException("BufferedSource cannot be used as a map key in JSON at path " + getPath());
        }
        i iVarValueSink = valueSink();
        try {
            jVar.A(iVarValueSink);
            if (iVarValueSink != null) {
                iVarValueSink.close();
            }
            return this;
        } catch (Throwable th) {
            if (iVarValueSink != null) {
                try {
                    iVarValueSink.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public abstract JsonWriter value(boolean z4);

    @CheckReturnValue
    public abstract i valueSink();
}
