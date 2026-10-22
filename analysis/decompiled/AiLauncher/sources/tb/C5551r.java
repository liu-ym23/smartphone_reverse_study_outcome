package tb;

import Mb.C0966d;
import Mb.InterfaceC0967e;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.auth.HttpAuthHeader;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0002\f\tB%\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0015\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0017R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0017¨\u0006\u0019"}, d2 = {"Ltb/r;", "Ltb/B;", "", "", "encodedNames", "encodedValues", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "Ltb/x;", Const.INTENT_KEY_PKGNAME, "()Ltb/x;", "", Const.INTENT_KEY_APIKEY, "()J", "LMb/e;", "sink", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LMb/e;)V", "", "countBytes", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LMb/e;Z)J", "Ljava/util/List;", "c", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: tb.r, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5551r extends AbstractC5529B {

    /* renamed from: d, reason: collision with root package name */
    public static final x f42232d = x.INSTANCE.a("application/x-www-form-urlencoded");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final List<String> encodedNames;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final List<String> encodedValues;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0011¨\u0006\u0014"}, d2 = {"Ltb/r$a;", "", "Ljava/nio/charset/Charset;", HttpAuthHeader.Parameters.Charset, "<init>", "(Ljava/nio/charset/Charset;)V", "", "name", UxipConstants.f30680s, Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)Ltb/r$a;", Const.INTENT_KEY_PKGNAME, "Ltb/r;", "c", "()Ltb/r;", "Ljava/nio/charset/Charset;", "", "Ljava/util/List;", "names", "values", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: tb.r$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Charset charset;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final List<String> names;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final List<String> values;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final a a(String name, String value) {
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(value, "value");
            this.names.add(Jb.a.d(name, 0, 0, " !\"#$&'()+,/:;<=>?@[\\]^`{|}~", false, false, false, false, this.charset, 91, null));
            this.values.add(Jb.a.d(value, 0, 0, " !\"#$&'()+,/:;<=>?@[\\]^`{|}~", false, false, false, false, this.charset, 91, null));
            return this;
        }

        public final a b(String name, String value) {
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(value, "value");
            this.names.add(Jb.a.d(name, 0, 0, " !\"#$&'()+,/:;<=>?@[\\]^`{|}~", true, false, true, false, this.charset, 83, null));
            this.values.add(Jb.a.d(value, 0, 0, " !\"#$&'()+,/:;<=>?@[\\]^`{|}~", true, false, true, false, this.charset, 83, null));
            return this;
        }

        public final C5551r c() {
            return new C5551r(this.names, this.values);
        }

        public a(Charset charset) {
            this.charset = charset;
            this.names = new ArrayList();
            this.values = new ArrayList();
        }

        public /* synthetic */ a(Charset charset, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? null : charset);
        }
    }

    public C5551r(List<String> encodedNames, List<String> encodedValues) {
        kotlin.jvm.internal.p.i(encodedNames, "encodedNames");
        kotlin.jvm.internal.p.i(encodedValues, "encodedValues");
        this.encodedNames = ub.q.w(encodedNames);
        this.encodedValues = ub.q.w(encodedValues);
    }

    @Override // tb.AbstractC5529B
    public long a() {
        return h(null, true);
    }

    @Override // tb.AbstractC5529B
    /* renamed from: b */
    public x getMedia() {
        return f42232d;
    }

    @Override // tb.AbstractC5529B
    public void g(InterfaceC0967e sink) throws IOException {
        kotlin.jvm.internal.p.i(sink, "sink");
        h(sink, false);
    }

    public final long h(InterfaceC0967e sink, boolean countBytes) throws EOFException {
        C0966d bufferField;
        if (countBytes) {
            bufferField = new C0966d();
        } else {
            kotlin.jvm.internal.p.f(sink);
            bufferField = sink.getBufferField();
        }
        int size = this.encodedNames.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 > 0) {
                bufferField.writeByte(38);
            }
            bufferField.L(this.encodedNames.get(i10));
            bufferField.writeByte(61);
            bufferField.L(this.encodedValues.get(i10));
        }
        if (!countBytes) {
            return 0L;
        }
        long size2 = bufferField.getSize();
        bufferField.g();
        return size2;
    }
}
