package com.stepos.ailauncher.sla;

import Z8.C1172u;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/sla/x;", "", "<init>", "()V", "", "raw", "", "Lcom/stepos/ailauncher/sla/x$a;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/util/List;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/ailauncher/sla/x$a;", "TAG", "Ljava/lang/String;", "Lkotlin/text/Regex;", "SEGMENT_DELIMITER", "Lkotlin/text/Regex;", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class x {
    public static final x INSTANCE = new x();
    private static final Regex SEGMENT_DELIMITER = new Regex("\\r?\\n[^\\S\\r\\n]*\\r?\\n");
    private static final String TAG = "SLA";

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\rR#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u001d\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/sla/x$a;", "", "", "function", "text", "", "params", "", "fallback", "rejectReason", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "e", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "Z", Const.INTENT_KEY_APIKEY, "()Z", Const.INTENT_KEY_UMID, "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.sla.x$a, reason: from toString */
    public static final /* data */ class Parsed {
        private final boolean fallback;
        private final String function;
        private final Map<String, String> params;
        private final String rejectReason;
        private final String text;

        public Parsed(String str, String text, Map<String, String> params, boolean z10, String str2) {
            kotlin.jvm.internal.p.i(text, "text");
            kotlin.jvm.internal.p.i(params, "params");
            this.function = str;
            this.text = text;
            this.params = params;
            this.fallback = z10;
            this.rejectReason = str2;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getFallback() {
            return this.fallback;
        }

        /* renamed from: b, reason: from getter */
        public final String getFunction() {
            return this.function;
        }

        public final Map<String, String> c() {
            return this.params;
        }

        /* renamed from: d, reason: from getter */
        public final String getRejectReason() {
            return this.rejectReason;
        }

        /* renamed from: e, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Parsed)) {
                return false;
            }
            Parsed parsed = (Parsed) other;
            return kotlin.jvm.internal.p.d(this.function, parsed.function) && kotlin.jvm.internal.p.d(this.text, parsed.text) && kotlin.jvm.internal.p.d(this.params, parsed.params) && this.fallback == parsed.fallback && kotlin.jvm.internal.p.d(this.rejectReason, parsed.rejectReason);
        }

        public int hashCode() {
            String str = this.function;
            int iHashCode = (((((((str == null ? 0 : str.hashCode()) * 31) + this.text.hashCode()) * 31) + this.params.hashCode()) * 31) + Boolean.hashCode(this.fallback)) * 31;
            String str2 = this.rejectReason;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Parsed(function=" + this.function + ", text=" + this.text + ", params=" + this.params + ", fallback=" + this.fallback + ", rejectReason=" + this.rejectReason + ")";
        }
    }

    public final Parsed a(String raw) {
        int i10;
        StringBuilder sb2;
        Pair pairA;
        if (La.H.x0(raw)) {
            return new Parsed(null, "", kotlin.collections.a.i(), true, "NO_MATCH");
        }
        int iT0 = La.H.t0(raw, '<', 0, false, 6, null);
        int iT02 = iT0 >= 0 ? La.H.t0(raw, '>', iT0, false, 4, null) : -1;
        if (iT0 < 0 || iT02 <= (i10 = iT0 + 1)) {
            return new Parsed(null, "", kotlin.collections.a.i(), true, "OUT_OF_DOMAIN");
        }
        String strSubstring = raw.substring(i10, iT02);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        String string = La.H.D1(strSubstring).toString();
        if (string.length() == 0) {
            return new Parsed(null, "", kotlin.collections.a.i(), true, "OUT_OF_DOMAIN");
        }
        String strSubstring2 = raw.substring(iT02 + 1);
        kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
        String string2 = La.H.D1(strSubstring2).toString();
        List<String> listA1 = La.H.a1(string2, new char[]{'\n'}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList();
        for (String str : listA1) {
            int iT03 = La.H.t0(str, ':', 0, false, 6, null);
            if (iT03 <= 0 || iT03 == str.length() - 1) {
                pairA = null;
            } else {
                String strSubstring3 = str.substring(0, iT03);
                kotlin.jvm.internal.p.h(strSubstring3, "substring(...)");
                String string3 = La.H.D1(strSubstring3).toString();
                String strSubstring4 = str.substring(iT03 + 1);
                kotlin.jvm.internal.p.h(strSubstring4, "substring(...)");
                pairA = Y8.j.a(string3, La.H.D1(strSubstring4).toString());
            }
            if (pairA != null) {
                arrayList.add(pairA);
            }
        }
        Map mapY = kotlin.collections.a.y(arrayList);
        if (string2.length() > 0) {
            sb2 = new StringBuilder();
            sb2.append("<");
            sb2.append(string);
            sb2.append(">");
            sb2.append(string2);
        } else {
            sb2 = new StringBuilder();
            sb2.append("<");
            sb2.append(string);
            sb2.append(">");
        }
        return new Parsed(string, sb2.toString(), mapY, false, null);
    }

    public final List<Parsed> b(String raw) {
        kotlin.jvm.internal.p.i(raw, "raw");
        if (La.H.x0(raw)) {
            return C1172u.e(a(raw));
        }
        List listQ = Regex.q(SEGMENT_DELIMITER, raw, 0, 2, null);
        ArrayList arrayList = new ArrayList(C1174w.x(listQ, 10));
        Iterator it = listQ.iterator();
        while (it.hasNext()) {
            arrayList.add(La.H.D1((String) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.size() <= 1) {
            return C1172u.e(a(raw));
        }
        C4148a.k("SLA", "parseDecisionTexts 多动作 segments=" + arrayList2.size(), false, 4, null);
        ArrayList arrayList3 = new ArrayList(C1174w.x(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(INSTANCE.a((String) it2.next()));
        }
        return arrayList3;
    }
}
