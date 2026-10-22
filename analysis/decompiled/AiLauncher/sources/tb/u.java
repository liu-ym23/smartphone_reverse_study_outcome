package tb;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import q9.InterfaceC5162a;
import zb.C6479c;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \t2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002%\tB\u0017\b\u0000\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0011J\u001b\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\"\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0016H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0096\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000eH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0003H\u0016¢\u0006\u0004\b#\u0010$R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b)\u0010\"¨\u0006*"}, d2 = {"Ltb/u;", "", "Lkotlin/Pair;", "", "", "namesAndValues", "<init>", "([Ljava/lang/String;)V", "name", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/util/Date;", "c", "(Ljava/lang/String;)Ljava/util/Date;", "", "index", "f", "(I)Ljava/lang/String;", "k", "", "l", "(Ljava/lang/String;)Ljava/util/List;", "", "iterator", "()Ljava/util/Iterator;", "Ltb/u$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ltb/u$a;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "[Ljava/lang/String;", "e", "()[Ljava/lang/String;", ContentDisposition.Parameters.Size, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class u implements Iterable<Pair<? extends String, ? extends String>>, InterfaceC5162a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final u f42241c = new u(new String[0]);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String[] namesAndValues;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0011\u0010\u000bJ\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0007J \u0010\u0013\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u000bJ\r\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00168\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Ltb/u$a;", "", "<init>", "()V", "", "line", "c", "(Ljava/lang/String;)Ltb/u$a;", "name", UxipConstants.f30680s, Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)Ltb/u$a;", "e", "Ltb/u;", "headers", Const.INTENT_KEY_PKGNAME, "(Ltb/u;)Ltb/u$a;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "f", "()Ltb/u;", "", "Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/util/List;", "namesAndValues", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final List<String> namesAndValues = new ArrayList(20);

        public final a a(String name, String value) {
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(value, "value");
            return ub.k.b(this, name, value);
        }

        public final a b(u headers) {
            kotlin.jvm.internal.p.i(headers, "headers");
            return ub.k.c(this, headers);
        }

        public final a c(String line) {
            kotlin.jvm.internal.p.i(line, "line");
            int iT0 = H.t0(line, ':', 1, false, 4, null);
            if (iT0 != -1) {
                String strSubstring = line.substring(0, iT0);
                kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
                String strSubstring2 = line.substring(iT0 + 1);
                kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
                d(strSubstring, strSubstring2);
                return this;
            }
            if (line.charAt(0) != ':') {
                d("", line);
                return this;
            }
            String strSubstring3 = line.substring(1);
            kotlin.jvm.internal.p.h(strSubstring3, "substring(...)");
            d("", strSubstring3);
            return this;
        }

        public final a d(String name, String value) {
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(value, "value");
            return ub.k.d(this, name, value);
        }

        public final a e(String name, String value) {
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(value, "value");
            ub.k.r(name);
            d(name, value);
            return this;
        }

        public final u f() {
            return ub.k.e(this);
        }

        public final List<String> g() {
            return this.namesAndValues;
        }

        public final a h(String name) {
            kotlin.jvm.internal.p.i(name, "name");
            return ub.k.m(this, name);
        }

        public final a i(String name, String value) {
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(value, "value");
            return ub.k.n(this, name, value);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ltb/u$b;", "", "<init>", "()V", "", "", "namesAndValues", "Ltb/u;", Const.INTENT_KEY_APIKEY, "([Ljava/lang/String;)Ltb/u;", "EMPTY", "Ltb/u;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: tb.u$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final u a(String... namesAndValues) {
            kotlin.jvm.internal.p.i(namesAndValues, "namesAndValues");
            return ub.k.i((String[]) Arrays.copyOf(namesAndValues, namesAndValues.length));
        }

        public Companion() {
        }
    }

    public u(String[] namesAndValues) {
        kotlin.jvm.internal.p.i(namesAndValues, "namesAndValues");
        this.namesAndValues = namesAndValues;
    }

    public static final u j(String... strArr) {
        return INSTANCE.a(strArr);
    }

    public final String b(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        return ub.k.h(this.namesAndValues, name);
    }

    public final Date c(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        String strB = b(name);
        if (strB != null) {
            return C6479c.a(strB);
        }
        return null;
    }

    /* renamed from: e, reason: from getter */
    public final String[] getNamesAndValues() {
        return this.namesAndValues;
    }

    public boolean equals(Object other) {
        return ub.k.f(this, other);
    }

    public final String f(int index) {
        return ub.k.k(this, index);
    }

    public int hashCode() {
        return ub.k.g(this);
    }

    public final a i() {
        return ub.k.l(this);
    }

    @Override // java.lang.Iterable
    public Iterator<Pair<? extends String, ? extends String>> iterator() {
        return ub.k.j(this);
    }

    public final String k(int index) {
        return ub.k.p(this, index);
    }

    public final List<String> l(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        return ub.k.q(this, name);
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public String toString() {
        return ub.k.o(this);
    }
}
