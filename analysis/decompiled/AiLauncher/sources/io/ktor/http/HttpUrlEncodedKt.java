package io.ktor.http;

import La.C0953c;
import Z8.C1172u;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.Parameters;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000L\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0002\u001a)\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a%\u0010\u000b\u001a\u00020\u0000*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\n0\t¢\u0006\u0004\b\u000b\u0010\f\u001a1\u0010\u0011\u001a\u00020\u0010*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\n0\t2\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0011\u0010\u000b\u001a\u00020\u0000*\u00020\u0006¢\u0006\u0004\b\u000b\u0010\u0013\u001a\u001d\u0010\u0011\u001a\u00020\u0010*\u00020\u00062\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e¢\u0006\u0004\b\u0011\u0010\u0014\u001a\u001f\u0010\u0011\u001a\u00020\u0010*\u00020\u00152\n\u0010\u000f\u001a\u00060\rj\u0002`\u000eH\u0000¢\u0006\u0004\b\u0011\u0010\u0016\u001a7\u0010\u0011\u001a\u00020\u0010*\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\t0\u00180\u00172\n\u0010\u000f\u001a\u00060\rj\u0002`\u000eH\u0000¢\u0006\u0004\b\u0011\u0010\u0019¨\u0006\u001a"}, d2 = {"", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "defaultEncoding", "", "limit", "Lio/ktor/http/Parameters;", "parseUrlEncodedParameters", "(Ljava/lang/String;Ljava/nio/charset/Charset;I)Lio/ktor/http/Parameters;", "", "Lkotlin/Pair;", "formUrlEncode", "(Ljava/util/List;)Ljava/lang/String;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "out", "LY8/t;", "formUrlEncodeTo", "(Ljava/util/List;Ljava/lang/Appendable;)V", "(Lio/ktor/http/Parameters;)Ljava/lang/String;", "(Lio/ktor/http/Parameters;Ljava/lang/Appendable;)V", "Lio/ktor/http/ParametersBuilder;", "(Lio/ktor/http/ParametersBuilder;Ljava/lang/Appendable;)V", "", "", "(Ljava/util/Set;Ljava/lang/Appendable;)V", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpUrlEncodedKt {
    public static final String formUrlEncode(List<Pair<String, String>> list) throws IOException {
        kotlin.jvm.internal.p.i(list, "<this>");
        StringBuilder sb2 = new StringBuilder();
        formUrlEncodeTo(list, sb2);
        return sb2.toString();
    }

    public static final void formUrlEncodeTo(List<Pair<String, String>> list, Appendable out) throws IOException {
        kotlin.jvm.internal.p.i(list, "<this>");
        kotlin.jvm.internal.p.i(out, "out");
        Z8.F.x0(list, out, (124 & 2) != 0 ? ", " : Const.STR_MART_ADD, (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new InterfaceC5074l() { // from class: io.ktor.http.x
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return HttpUrlEncodedKt.formUrlEncodeTo$lambda$5((Pair) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence formUrlEncodeTo$lambda$5(Pair it) {
        kotlin.jvm.internal.p.i(it, "it");
        String strEncodeURLParameter = CodecsKt.encodeURLParameter((String) it.e(), true);
        if (it.f() == null) {
            return strEncodeURLParameter;
        }
        return strEncodeURLParameter + '=' + CodecsKt.encodeURLParameterValue(String.valueOf(it.f()));
    }

    public static final Parameters parseUrlEncodedParameters(String str, Charset defaultEncoding, int i10) {
        Object next;
        String name;
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(defaultEncoding, "defaultEncoding");
        List<String> listB1 = La.H.b1(str, new String[]{Const.STR_MART_ADD}, false, i10, 2, null);
        ArrayList<Pair> arrayList = new ArrayList(C1174w.x(listB1, 10));
        for (String str2 : listB1) {
            arrayList.add(Y8.j.a(La.H.x1(str2, "=", null, 2, null), La.H.n1(str2, "=", "")));
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (kotlin.jvm.internal.p.d(((Pair) next).e(), "_charset_")) {
                break;
            }
        }
        Pair pair = (Pair) next;
        if (pair == null || (name = (String) pair.f()) == null) {
            name = CharsetJVMKt.getName(defaultEncoding);
        }
        Charset charsetForName = CharsetJVMKt.forName(C0953c.f4336a, name);
        Parameters.Companion companion = Parameters.INSTANCE;
        ParametersBuilder parametersBuilderParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, null);
        for (Pair pair2 : arrayList) {
            parametersBuilderParametersBuilder$default.append(CodecsKt.decodeURLQueryComponent$default((String) pair2.a(), 0, 0, false, charsetForName, 7, null), CodecsKt.decodeURLQueryComponent$default((String) pair2.b(), 0, 0, false, charsetForName, 7, null));
        }
        return parametersBuilderParametersBuilder$default.build();
    }

    public static /* synthetic */ Parameters parseUrlEncodedParameters$default(String str, Charset charset, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charset = C0953c.UTF_8;
        }
        if ((i11 & 2) != 0) {
            i10 = 1000;
        }
        return parseUrlEncodedParameters(str, charset, i10);
    }

    public static final String formUrlEncode(Parameters parameters) {
        kotlin.jvm.internal.p.i(parameters, "<this>");
        Set<Map.Entry<String, List<String>>> setEntries = parameters.entries();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntries.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Iterable iterable = (Iterable) entry.getValue();
            ArrayList arrayList2 = new ArrayList(C1174w.x(iterable, 10));
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Y8.j.a(entry.getKey(), (String) it2.next()));
            }
            Z8.A.E(arrayList, arrayList2);
        }
        return formUrlEncode(arrayList);
    }

    public static final void formUrlEncodeTo(Parameters parameters, Appendable out) throws IOException {
        kotlin.jvm.internal.p.i(parameters, "<this>");
        kotlin.jvm.internal.p.i(out, "out");
        formUrlEncodeTo(parameters.entries(), out);
    }

    public static final void formUrlEncodeTo(ParametersBuilder parametersBuilder, Appendable out) throws IOException {
        kotlin.jvm.internal.p.i(parametersBuilder, "<this>");
        kotlin.jvm.internal.p.i(out, "out");
        formUrlEncodeTo(parametersBuilder.entries(), out);
    }

    public static final void formUrlEncodeTo(Set<? extends Map.Entry<String, ? extends List<String>>> set, Appendable out) throws IOException {
        List listE;
        kotlin.jvm.internal.p.i(set, "<this>");
        kotlin.jvm.internal.p.i(out, "out");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (list.isEmpty()) {
                listE = C1172u.e(Y8.j.a(str, null));
            } else {
                List list2 = list;
                ArrayList arrayList2 = new ArrayList(C1174w.x(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(Y8.j.a(str, (String) it2.next()));
                }
                listE = arrayList2;
            }
            Z8.A.E(arrayList, listE);
        }
        formUrlEncodeTo(arrayList, out);
    }
}
