package l3;

import android.util.Base64;
import android.util.JsonWriter;
import com.google.firebase.encoders.EncodingException;
import j3.C4765c;
import j3.InterfaceC4766d;
import j3.InterfaceC4767e;
import j3.InterfaceC4768f;
import j3.g;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class e implements InterfaceC4767e, g {

    /* renamed from: a, reason: collision with root package name */
    public e f36956a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f36957b = true;

    /* renamed from: c, reason: collision with root package name */
    public final JsonWriter f36958c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<Class<?>, InterfaceC4766d<?>> f36959d;

    /* renamed from: e, reason: collision with root package name */
    public final Map<Class<?>, InterfaceC4768f<?>> f36960e;

    /* renamed from: f, reason: collision with root package name */
    public final InterfaceC4766d<Object> f36961f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f36962g;

    public e(Writer writer, Map<Class<?>, InterfaceC4766d<?>> map, Map<Class<?>, InterfaceC4768f<?>> map2, InterfaceC4766d<Object> interfaceC4766d, boolean z10) {
        this.f36958c = new JsonWriter(writer);
        this.f36959d = map;
        this.f36960e = map2;
        this.f36961f = interfaceC4766d;
        this.f36962g = z10;
    }

    @Override // j3.InterfaceC4767e
    public InterfaceC4767e a(C4765c c4765c, Object obj) throws IOException {
        return i(c4765c.b(), obj);
    }

    @Override // j3.InterfaceC4767e
    public InterfaceC4767e b(C4765c c4765c, long j10) throws IOException {
        return h(c4765c.b(), j10);
    }

    public e e(long j10) throws IOException {
        q();
        this.f36958c.value(j10);
        return this;
    }

    public e f(Object obj, boolean z10) throws IOException {
        if (z10 && l(obj)) {
            throw new EncodingException(String.format("%s cannot be encoded inline", obj == null ? null : obj.getClass()));
        }
        if (obj == null) {
            this.f36958c.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.f36958c.value((Number) obj);
            return this;
        }
        int i10 = 0;
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                this.f36958c.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    f(it.next(), false);
                }
                this.f36958c.endArray();
                return this;
            }
            if (obj instanceof Map) {
                this.f36958c.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        i((String) key, entry.getValue());
                    } catch (ClassCastException e10) {
                        throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e10);
                    }
                }
                this.f36958c.endObject();
                return this;
            }
            InterfaceC4766d<?> interfaceC4766d = this.f36959d.get(obj.getClass());
            if (interfaceC4766d != null) {
                return n(interfaceC4766d, obj, z10);
            }
            InterfaceC4768f<?> interfaceC4768f = this.f36960e.get(obj.getClass());
            if (interfaceC4768f != null) {
                interfaceC4768f.a(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                return n(this.f36961f, obj, z10);
            }
            c(((Enum) obj).name());
            return this;
        }
        if (obj instanceof byte[]) {
            return k((byte[]) obj);
        }
        this.f36958c.beginArray();
        if (obj instanceof int[]) {
            int length = ((int[]) obj).length;
            while (i10 < length) {
                this.f36958c.value(r6[i10]);
                i10++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i10 < length2) {
                e(jArr[i10]);
                i10++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i10 < length3) {
                this.f36958c.value(dArr[i10]);
                i10++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i10 < length4) {
                this.f36958c.value(zArr[i10]);
                i10++;
            }
        } else if (obj instanceof Number[]) {
            for (Number number : (Number[]) obj) {
                f(number, false);
            }
        } else {
            for (Object obj2 : (Object[]) obj) {
                f(obj2, false);
            }
        }
        this.f36958c.endArray();
        return this;
    }

    @Override // j3.g
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public e c(String str) throws IOException {
        q();
        this.f36958c.value(str);
        return this;
    }

    public e h(String str, long j10) throws IOException {
        q();
        this.f36958c.name(str);
        return e(j10);
    }

    public e i(String str, Object obj) throws IOException {
        return this.f36962g ? p(str, obj) : o(str, obj);
    }

    @Override // j3.g
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public e d(boolean z10) throws IOException {
        q();
        this.f36958c.value(z10);
        return this;
    }

    public e k(byte[] bArr) throws IOException {
        q();
        if (bArr == null) {
            this.f36958c.nullValue();
            return this;
        }
        this.f36958c.value(Base64.encodeToString(bArr, 2));
        return this;
    }

    public final boolean l(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    public void m() throws IOException {
        q();
        this.f36958c.flush();
    }

    public e n(InterfaceC4766d<Object> interfaceC4766d, Object obj, boolean z10) throws IOException {
        if (!z10) {
            this.f36958c.beginObject();
        }
        interfaceC4766d.a(obj, this);
        if (!z10) {
            this.f36958c.endObject();
        }
        return this;
    }

    public final e o(String str, Object obj) throws EncodingException, IOException {
        q();
        this.f36958c.name(str);
        if (obj != null) {
            return f(obj, false);
        }
        this.f36958c.nullValue();
        return this;
    }

    public final e p(String str, Object obj) throws EncodingException, IOException {
        if (obj == null) {
            return this;
        }
        q();
        this.f36958c.name(str);
        return f(obj, false);
    }

    public final void q() throws IOException {
        if (!this.f36957b) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
        e eVar = this.f36956a;
        if (eVar != null) {
            eVar.q();
            this.f36956a.f36957b = false;
            this.f36956a = null;
            this.f36958c.endObject();
        }
    }
}
