package io.ktor.http.cio;

import Y8.t;
import Z8.C1172u;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.Headers;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0014\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\r0\u00130\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\tR\u0014\u0010\u001a\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012¨\u0006\u001c"}, d2 = {"Lio/ktor/http/cio/CIOHeaders;", "Lio/ktor/http/Headers;", "Lio/ktor/http/cio/HttpHeadersMap;", "headers", "<init>", "(Lio/ktor/http/cio/HttpHeadersMap;)V", "", "", "names", "()Ljava/util/Set;", "name", "get", "(Ljava/lang/String;)Ljava/lang/String;", "", "getAll", "(Ljava/lang/String;)Ljava/util/List;", "", "isEmpty", "()Z", "", "entries", "Lio/ktor/http/cio/HttpHeadersMap;", "names$delegate", "LY8/h;", "getNames", "getCaseInsensitiveName", "caseInsensitiveName", "Entry", "ktor-http-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CIOHeaders implements Headers {
    private final HttpHeadersMap headers;

    /* renamed from: names$delegate, reason: from kotlin metadata */
    private final Y8.h names;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u000b\b\u0082\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lio/ktor/http/cio/CIOHeaders$Entry;", "", "", "", "", "offset", "<init>", "(Lio/ktor/http/cio/CIOHeaders;I)V", "I", "getKey", "()Ljava/lang/String;", "key", "getValue", "()Ljava/util/List;", UxipConstants.f30680s, "ktor-http-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class Entry implements Map.Entry<String, List<? extends String>>, InterfaceC5162a {
        private final int offset;

        public Entry(int i10) {
            this.offset = i10;
        }

        @Override // java.util.Map.Entry
        public /* bridge */ /* synthetic */ List<? extends String> setValue(List<? extends String> list) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map.Entry
        public String getKey() {
            return CIOHeaders.this.headers.nameAtOffset(this.offset).toString();
        }

        @Override // java.util.Map.Entry
        public List<? extends String> getValue() {
            return C1172u.e(CIOHeaders.this.headers.valueAtOffset(this.offset).toString());
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public List<String> setValue2(List<String> list) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public CIOHeaders(HttpHeadersMap headers) {
        p.i(headers, "headers");
        this.headers = headers;
        this.names = C4848b.a(LazyThreadSafetyMode.NONE, new InterfaceC5063a() { // from class: io.ktor.http.cio.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CIOHeaders.names_delegate$lambda$1(this.f33295a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Entry entries$lambda$4(CIOHeaders cIOHeaders, int i10) {
        return cIOHeaders.new Entry(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getAll$lambda$2(CharSequence it) {
        p.i(it, "it");
        return it.toString();
    }

    private final Set<String> getNames() {
        return (Set) this.names.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinkedHashSet names_delegate$lambda$1(CIOHeaders cIOHeaders) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(cIOHeaders.headers.getSize());
        Iterator<Integer> it = cIOHeaders.headers.offsets().iterator();
        while (it.hasNext()) {
            linkedHashSet.add(cIOHeaders.headers.nameAtOffset(it.next().intValue()).toString());
        }
        return linkedHashSet;
    }

    @Override // io.ktor.util.StringValues
    public boolean contains(String str) {
        return super.contains(str);
    }

    @Override // io.ktor.util.StringValues
    public Set<Map.Entry<String, List<String>>> entries() {
        return SequencesKt___SequencesKt.f0(SequencesKt___SequencesKt.R(this.headers.offsets(), new InterfaceC5074l() { // from class: io.ktor.http.cio.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CIOHeaders.entries$lambda$4(this.f33296a, ((Integer) obj).intValue());
            }
        }));
    }

    @Override // io.ktor.util.StringValues
    public void forEach(p9.p<? super String, ? super List<String>, t> pVar) {
        super.forEach(pVar);
    }

    @Override // io.ktor.util.StringValues
    public String get(String name) {
        p.i(name, "name");
        CharSequence charSequence = this.headers.get(name);
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // io.ktor.util.StringValues
    public List<String> getAll(String name) {
        p.i(name, "name");
        List<String> listD0 = SequencesKt___SequencesKt.d0(SequencesKt___SequencesKt.R(this.headers.getAll(name), new InterfaceC5074l() { // from class: io.ktor.http.cio.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CIOHeaders.getAll$lambda$2((CharSequence) obj);
            }
        }));
        if (listD0.isEmpty()) {
            return null;
        }
        return listD0;
    }

    @Override // io.ktor.util.StringValues
    public boolean getCaseInsensitiveName() {
        return true;
    }

    @Override // io.ktor.util.StringValues
    public boolean isEmpty() {
        return this.headers.getSize() == 0;
    }

    @Override // io.ktor.util.StringValues
    public Set<String> names() {
        return getNames();
    }

    @Override // io.ktor.util.StringValues
    public boolean contains(String str, String str2) {
        return super.contains(str, str2);
    }
}
