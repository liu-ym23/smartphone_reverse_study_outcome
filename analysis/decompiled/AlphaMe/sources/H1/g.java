package H1;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes.dex */
public final class g extends JsonWriter {

    /* renamed from: d, reason: collision with root package name */
    public static final f f717d = new f();

    /* renamed from: e, reason: collision with root package name */
    public static final F1.t f718e = new F1.t("closed");

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f719a;

    /* renamed from: b, reason: collision with root package name */
    public String f720b;

    /* renamed from: c, reason: collision with root package name */
    public F1.p f721c;

    public g() {
        super(f717d);
        this.f719a = new ArrayList();
        this.f721c = F1.r.f449a;
    }

    public final F1.p a() {
        return (F1.p) this.f719a.get(r1.size() - 1);
    }

    public final void b(F1.p pVar) {
        if (this.f720b != null) {
            if (!(pVar instanceof F1.r) || getSerializeNulls()) {
                F1.s sVar = (F1.s) a();
                sVar.f450a.put(this.f720b, pVar);
            }
            this.f720b = null;
            return;
        }
        if (this.f719a.isEmpty()) {
            this.f721c = pVar;
            return;
        }
        F1.p pVarA = a();
        if (!(pVarA instanceof F1.o)) {
            throw new IllegalStateException();
        }
        ((F1.o) pVarA).f448a.add(pVar);
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter beginArray() {
        F1.o oVar = new F1.o();
        b(oVar);
        this.f719a.add(oVar);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter beginObject() {
        F1.s sVar = new F1.s();
        b(sVar);
        this.f719a.add(sVar);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        ArrayList arrayList = this.f719a;
        if (!arrayList.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        arrayList.add(f718e);
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter endArray() {
        ArrayList arrayList = this.f719a;
        if (arrayList.isEmpty() || this.f720b != null) {
            throw new IllegalStateException();
        }
        if (!(a() instanceof F1.o)) {
            throw new IllegalStateException();
        }
        arrayList.remove(arrayList.size() - 1);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter endObject() {
        ArrayList arrayList = this.f719a;
        if (arrayList.isEmpty() || this.f720b != null) {
            throw new IllegalStateException();
        }
        if (!(a() instanceof F1.s)) {
            throw new IllegalStateException();
        }
        arrayList.remove(arrayList.size() - 1);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Flushable
    public final void flush() {
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter jsonValue(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter name(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f719a.isEmpty() || this.f720b != null) {
            throw new IllegalStateException();
        }
        if (!(a() instanceof F1.s)) {
            throw new IllegalStateException();
        }
        this.f720b = str;
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter nullValue() {
        b(F1.r.f449a);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter value(Boolean bool) {
        if (bool == null) {
            b(F1.r.f449a);
            return this;
        }
        b(new F1.t(bool));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter value(Number number) {
        if (number == null) {
            b(F1.r.f449a);
            return this;
        }
        if (!isLenient()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        b(new F1.t(number));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter value(String str) {
        if (str == null) {
            b(F1.r.f449a);
            return this;
        }
        b(new F1.t(str));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter value(boolean z4) {
        b(new F1.t(Boolean.valueOf(z4)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter value(float f4) {
        if (!isLenient() && (Float.isNaN(f4) || Float.isInfinite(f4))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + f4);
        }
        b(new F1.t(Float.valueOf(f4)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter value(double d4) {
        if (!isLenient() && (Double.isNaN(d4) || Double.isInfinite(d4))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d4);
        }
        b(new F1.t(Double.valueOf(d4)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter value(long j4) {
        b(new F1.t(Long.valueOf(j4)));
        return this;
    }
}
