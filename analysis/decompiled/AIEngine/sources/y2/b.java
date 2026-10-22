package y2;

import a3.k;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class b extends w2.a {

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f13973o = x2.a.h;

    /* renamed from: j, reason: collision with root package name */
    public final x2.b f13974j;

    /* renamed from: k, reason: collision with root package name */
    public int[] f13975k;

    /* renamed from: l, reason: collision with root package name */
    public int f13976l;

    /* renamed from: m, reason: collision with root package name */
    public v2.e f13977m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f13978n;

    public b(x2.b bVar, int i10, v2.c cVar) {
        this.f13556c = i10;
        this.f13555b = cVar;
        this.f13558e = new d(0, null, JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION.a(i10) ? new androidx.coordinatorlayout.widget.a(this) : null);
        this.f13557d = JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS.a(i10);
        this.f13975k = f13973o;
        this.f13977m = DefaultPrettyPrinter.f3635k;
        this.f13974j = bVar;
        if (JsonGenerator.Feature.ESCAPE_NON_ASCII.a(i10)) {
            this.f13976l = 127;
        }
        this.f13978n = !JsonGenerator.Feature.QUOTE_FIELD_NAMES.a(i10);
    }

    public final void l1(String str) throws JsonGenerationException {
        a(h0.e.c("Can not ", str, ", expecting field name (context: ", this.f13558e.h(), ")"));
        throw null;
    }

    public final void m1(int i10, String str) throws JsonGenerationException {
        if (i10 == 0) {
            if (this.f13558e.d()) {
                this.f3540a.h(this);
                return;
            } else {
                if (this.f13558e.e()) {
                    this.f3540a.b(this);
                    return;
                }
                return;
            }
        }
        if (i10 == 1) {
            this.f3540a.f(this);
            return;
        }
        if (i10 == 2) {
            this.f3540a.a(this);
            return;
        }
        if (i10 == 3) {
            this.f3540a.g(this);
        } else {
            if (i10 != 5) {
                k.a();
                throw null;
            }
            l1(str);
            throw null;
        }
    }

    public final JsonGenerator n1(JsonGenerator.Feature feature) {
        int i10 = feature.f3551b;
        this.f13556c &= ~i10;
        if ((i10 & w2.a.h) != 0) {
            if (feature == JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS) {
                this.f13557d = false;
            } else if (feature == JsonGenerator.Feature.ESCAPE_NON_ASCII) {
                o1(0);
            } else if (feature == JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION) {
                d dVar = this.f13558e;
                dVar.f13986d = null;
                this.f13558e = dVar;
            }
        }
        if (feature == JsonGenerator.Feature.QUOTE_FIELD_NAMES) {
            this.f13978n = true;
        }
        return this;
    }

    public final b o1(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        this.f13976l = i10;
        return this;
    }
}
