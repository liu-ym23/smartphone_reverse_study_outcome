package com.stepos.probe;

import c7.j;
import d7.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import q7.k;
import q7.r;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000b\u001a\u00020\n2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0011\u001a\u00020\n2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0015\u001a\u00020\n2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u000e\u0010\u0014\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0019\u001a\u00020\n2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001d\u001a\u00020\n2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u001b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u001b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b!\u0010 J?\u0010%\u001a\u00020\u001b2\u001a\u0010#\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\"0\u00172\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013¢\u0006\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/stepos/probe/ProbeJson;", "", "<init>", "()V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "value", "", "indent", "Lc7/r;", "prettyAppend", "(Ljava/lang/StringBuilder;Ljava/lang/Object;I)V", "v", "", "isContainer", "(Ljava/lang/Object;)Z", "append", "(Ljava/lang/StringBuilder;Ljava/lang/Object;)V", "", "map", "appendObject", "(Ljava/lang/StringBuilder;Ljava/util/Map;)V", "", "list", "appendArray", "(Ljava/lang/StringBuilder;Ljava/util/List;)V", "", "s", "appendString", "(Ljava/lang/StringBuilder;Ljava/lang/String;)V", "stringify", "(Ljava/lang/Object;)Ljava/lang/String;", "pretty", "Lc7/j;", "ordered", "extras", "line", "(Ljava/util/List;Ljava/util/Map;)Ljava/lang/String;", "probe-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ProbeJson {
    public static final ProbeJson INSTANCE = new ProbeJson();

    private ProbeJson() {
    }

    private final void append(StringBuilder sb2, Object value) {
        if (value == null) {
            sb2.append("null");
            return;
        }
        if ((value instanceof Number) || (value instanceof Boolean)) {
            sb2.append(value.toString());
            return;
        }
        if (value instanceof Map) {
            appendObject(sb2, (Map) value);
        } else if (value instanceof List) {
            appendArray(sb2, (List) value);
        } else {
            appendString(sb2, value.toString());
        }
    }

    private final void appendArray(StringBuilder sb2, List<?> list) {
        sb2.append('[');
        boolean z4 = true;
        for (Object obj : list) {
            if (!z4) {
                sb2.append(',');
            }
            INSTANCE.append(sb2, obj);
            z4 = false;
        }
        sb2.append(']');
    }

    private final void appendObject(StringBuilder sb2, Map<?, ?> map) {
        sb2.append('{');
        boolean z4 = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                if (!z4) {
                    sb2.append(',');
                }
                ProbeJson probeJson = INSTANCE;
                probeJson.appendString(sb2, String.valueOf(key));
                sb2.append(':');
                probeJson.append(sb2, value);
                z4 = false;
            }
        }
        sb2.append('}');
    }

    private final void appendString(StringBuilder sb2, String s10) {
        sb2.append('\"');
        int length = s10.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = s10.charAt(i2);
            if (cCharAt == '\t') {
                sb2.append("\\t");
            } else if (cCharAt == '\n') {
                sb2.append("\\n");
            } else if (cCharAt == '\r') {
                sb2.append("\\r");
            } else if (cCharAt == '\"') {
                sb2.append("\\\"");
            } else if (cCharAt == '\\') {
                sb2.append("\\\\");
            } else if (k.f(cCharAt, 32) < 0) {
                sb2.append(String.format("\\u%04x", Arrays.copyOf(new Object[]{Integer.valueOf(cCharAt)}, 1)));
            } else {
                sb2.append(cCharAt);
            }
        }
        sb2.append('\"');
    }

    private final boolean isContainer(Object v10) {
        return (v10 instanceof Map) || (v10 instanceof List);
    }

    private static final void line$put(r rVar, StringBuilder sb2, String str, Object obj) {
        if (obj == null) {
            return;
        }
        if (!rVar.f8816f) {
            sb2.append(',');
        }
        rVar.f8816f = false;
        ProbeJson probeJson = INSTANCE;
        probeJson.appendString(sb2, str);
        sb2.append(':');
        probeJson.append(sb2, obj);
    }

    private final void prettyAppend(StringBuilder sb2, Object value, int indent) {
        int i2 = 0;
        if (!(value instanceof Map)) {
            if (!(value instanceof List)) {
                append(sb2, value);
                return;
            }
            Iterable iterable = (Iterable) value;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    if (INSTANCE.isContainer(it.next())) {
                        sb2.append("[\n");
                        int i10 = indent + 2;
                        String strC0 = ga.r.c0(i10, " ");
                        for (Object obj : iterable) {
                            int i11 = i2 + 1;
                            if (i2 < 0) {
                                s.z0();
                                throw null;
                            }
                            sb2.append(strC0);
                            INSTANCE.prettyAppend(sb2, obj, i10);
                            if (i2 < ((List) value).size() - 1) {
                                sb2.append(",");
                            }
                            sb2.append("\n");
                            i2 = i11;
                        }
                        sb2.append(ga.r.c0(indent, " "));
                        sb2.append("]");
                        return;
                    }
                }
            }
            sb2.append("[");
            for (Object obj2 : iterable) {
                int i12 = i2 + 1;
                if (i2 < 0) {
                    s.z0();
                    throw null;
                }
                if (i2 > 0) {
                    sb2.append(", ");
                }
                INSTANCE.append(sb2, obj2);
                i2 = i12;
            }
            sb2.append("]");
            return;
        }
        Set setEntrySet = ((Map) value).entrySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj3 : setEntrySet) {
            if (((Map.Entry) obj3).getValue() != null) {
                arrayList.add(obj3);
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (INSTANCE.isContainer(((Map.Entry) it2.next()).getValue())) {
                    sb2.append("{\n");
                    int i13 = indent + 2;
                    String strC02 = ga.r.c0(i13, " ");
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        Object next = it3.next();
                        int i14 = i2 + 1;
                        if (i2 < 0) {
                            s.z0();
                            throw null;
                        }
                        Map.Entry entry = (Map.Entry) next;
                        sb2.append(strC02);
                        ProbeJson probeJson = INSTANCE;
                        probeJson.appendString(sb2, String.valueOf(entry.getKey()));
                        sb2.append(": ");
                        probeJson.prettyAppend(sb2, entry.getValue(), i13);
                        if (i2 < arrayList.size() - 1) {
                            sb2.append(",");
                        }
                        sb2.append("\n");
                        i2 = i14;
                    }
                    sb2.append(ga.r.c0(indent, " "));
                    sb2.append("}");
                    return;
                }
            }
        }
        sb2.append("{");
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            Object next2 = it4.next();
            int i15 = i2 + 1;
            if (i2 < 0) {
                s.z0();
                throw null;
            }
            Map.Entry entry2 = (Map.Entry) next2;
            if (i2 > 0) {
                sb2.append(", ");
            }
            ProbeJson probeJson2 = INSTANCE;
            probeJson2.appendString(sb2, String.valueOf(entry2.getKey()));
            sb2.append(": ");
            probeJson2.append(sb2, entry2.getValue());
            i2 = i15;
        }
        sb2.append("}");
    }

    public final String line(List<? extends j> ordered, Map<String, ? extends Object> extras) {
        k.e(ordered, "ordered");
        k.e(extras, "extras");
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append('{');
        r rVar = new r();
        rVar.f8816f = true;
        for (j jVar : ordered) {
            line$put(rVar, sb2, (String) jVar.f1973f, jVar.f1974g);
        }
        for (Map.Entry<String, ? extends Object> entry : extras.entrySet()) {
            line$put(rVar, sb2, entry.getKey(), entry.getValue());
        }
        sb2.append('}');
        String string = sb2.toString();
        k.d(string, "toString(...)");
        return string;
    }

    public final String pretty(Object value) {
        StringBuilder sb2 = new StringBuilder(256);
        INSTANCE.prettyAppend(sb2, value, 0);
        String string = sb2.toString();
        k.d(string, "toString(...)");
        return string;
    }

    public final String stringify(Object value) {
        StringBuilder sb2 = new StringBuilder(128);
        INSTANCE.append(sb2, value);
        String string = sb2.toString();
        k.d(string, "toString(...)");
        return string;
    }
}
