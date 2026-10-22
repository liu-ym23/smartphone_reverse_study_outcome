package io.ktor.http;

import La.C0951a;
import Z8.C1173v;
import io.ktor.http.Parameters;
import io.ktor.utils.io.InternalAPI;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0007\u001a3\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001a3\u0010\f\u001a\u00020\u000b*\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\r\u001a;\u0010\u0011\u001a\u00020\u000b*\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a'\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u0018\u001a\u0013\u0010\u001a\u001a\u00020\u0007*\u00020\u0007H\u0007¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"", "query", "", "startIndex", "limit", "", "decode", "Lio/ktor/http/Parameters;", "parseQueryString", "(Ljava/lang/String;IIZ)Lio/ktor/http/Parameters;", "Lio/ktor/http/ParametersBuilder;", "LY8/t;", M5.e.FAIL_PARSE, "(Lio/ktor/http/ParametersBuilder;Ljava/lang/String;IIZ)V", "nameIndex", "equalIndex", "endIndex", "appendParam", "(Lio/ktor/http/ParametersBuilder;Ljava/lang/String;IIIZ)V", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "", "text", "trimEnd", "(IILjava/lang/CharSequence;)I", "trimStart", "withEmptyStringForValuelessKeys", "(Lio/ktor/http/Parameters;)Lio/ktor/http/Parameters;", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QueryKt {
    private static final void appendParam(ParametersBuilder parametersBuilder, String str, int i10, int i11, int i12, boolean z10) {
        String strSubstring;
        String strSubstring2;
        String strSubstring3;
        if (i11 == -1) {
            int iTrimStart = trimStart(i10, i12, str);
            int iTrimEnd = trimEnd(iTrimStart, i12, str);
            if (iTrimEnd > iTrimStart) {
                if (z10) {
                    strSubstring3 = CodecsKt.decodeURLQueryComponent$default(str, iTrimStart, iTrimEnd, false, null, 12, null);
                } else {
                    strSubstring3 = str.substring(iTrimStart, iTrimEnd);
                    kotlin.jvm.internal.p.h(strSubstring3, "substring(...)");
                }
                parametersBuilder.appendAll(strSubstring3, C1173v.m());
                return;
            }
            return;
        }
        int iTrimStart2 = trimStart(i10, i11, str);
        int iTrimEnd2 = trimEnd(iTrimStart2, i11, str);
        if (iTrimEnd2 > iTrimStart2) {
            if (z10) {
                strSubstring = CodecsKt.decodeURLQueryComponent$default(str, iTrimStart2, iTrimEnd2, false, null, 12, null);
            } else {
                strSubstring = str.substring(iTrimStart2, iTrimEnd2);
                kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            }
            int iTrimStart3 = trimStart(i11 + 1, i12, str);
            int iTrimEnd3 = trimEnd(iTrimStart3, i12, str);
            if (z10) {
                strSubstring2 = CodecsKt.decodeURLQueryComponent$default(str, iTrimStart3, iTrimEnd3, true, null, 8, null);
            } else {
                strSubstring2 = str.substring(iTrimStart3, iTrimEnd3);
                kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
            }
            parametersBuilder.append(strSubstring, strSubstring2);
        }
    }

    private static final void parse(ParametersBuilder parametersBuilder, String str, int i10, int i11, boolean z10) {
        int i12;
        int i13;
        int iN0 = La.H.n0(str);
        int i14 = 0;
        if (i10 <= iN0) {
            int i15 = -1;
            int i16 = i10;
            int i17 = i16;
            while (i14 != i11) {
                char cCharAt = str.charAt(i17);
                if (cCharAt == '&') {
                    appendParam(parametersBuilder, str, i16, i15, i17, z10);
                    i14++;
                    i15 = -1;
                    i16 = i17 + 1;
                } else if (cCharAt == '=' && i15 == -1) {
                    i15 = i17;
                }
                if (i17 != iN0) {
                    i17++;
                } else {
                    i13 = i16;
                    i12 = i15;
                }
            }
            return;
        }
        i12 = -1;
        i13 = i10;
        if (i14 == i11) {
            return;
        }
        appendParam(parametersBuilder, str, i13, i12, str.length(), z10);
    }

    public static final Parameters parseQueryString(String query, int i10, int i11, boolean z10) {
        kotlin.jvm.internal.p.i(query, "query");
        if (i10 > La.H.n0(query)) {
            return Parameters.INSTANCE.getEmpty();
        }
        Parameters.Companion companion = Parameters.INSTANCE;
        ParametersBuilder parametersBuilderParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, null);
        parse(parametersBuilderParametersBuilder$default, query, i10, i11, z10);
        return parametersBuilderParametersBuilder$default.build();
    }

    public static /* synthetic */ Parameters parseQueryString$default(String str, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = 1000;
        }
        if ((i12 & 8) != 0) {
            z10 = true;
        }
        return parseQueryString(str, i10, i11, z10);
    }

    private static final int trimEnd(int i10, int i11, CharSequence charSequence) {
        while (i11 > i10 && C0951a.c(charSequence.charAt(i11 - 1))) {
            i11--;
        }
        return i11;
    }

    private static final int trimStart(int i10, int i11, CharSequence charSequence) {
        while (i10 < i11 && C0951a.c(charSequence.charAt(i10))) {
            i10++;
        }
        return i10;
    }

    @InternalAPI
    public static final Parameters withEmptyStringForValuelessKeys(final Parameters parameters) {
        kotlin.jvm.internal.p.i(parameters, "<this>");
        Set<Map.Entry<String, List<String>>> setEntries = parameters.entries();
        if ((setEntries instanceof Collection) && setEntries.isEmpty()) {
            return parameters;
        }
        Iterator<T> it = setEntries.iterator();
        while (it.hasNext()) {
            if (((List) ((Map.Entry) it.next()).getValue()).isEmpty()) {
                return new Parameters() { // from class: io.ktor.http.QueryKt$withEmptyStringForValuelessKeys$2$1
                    @Override // io.ktor.util.StringValues
                    public boolean contains(String str) {
                        return super.contains(str);
                    }

                    @Override // io.ktor.util.StringValues
                    public Set<Map.Entry<String, List<String>>> entries() {
                        return parameters.entries();
                    }

                    @Override // io.ktor.util.StringValues
                    public void forEach(p9.p<? super String, ? super List<String>, Y8.t> pVar) {
                        super.forEach(pVar);
                    }

                    @Override // io.ktor.util.StringValues
                    public String get(String name) {
                        kotlin.jvm.internal.p.i(name, "name");
                        List<String> all = getAll(name);
                        if (all == null) {
                            return null;
                        }
                        return all.isEmpty() ? "" : (String) Z8.F.q0(all);
                    }

                    @Override // io.ktor.util.StringValues
                    public List<String> getAll(String name) {
                        kotlin.jvm.internal.p.i(name, "name");
                        return parameters.getAll(name);
                    }

                    @Override // io.ktor.util.StringValues
                    public boolean getCaseInsensitiveName() {
                        return parameters.getCaseInsensitiveName();
                    }

                    @Override // io.ktor.util.StringValues
                    public boolean isEmpty() {
                        return parameters.isEmpty();
                    }

                    @Override // io.ktor.util.StringValues
                    public Set<String> names() {
                        return parameters.names();
                    }

                    @Override // io.ktor.util.StringValues
                    public boolean contains(String str, String str2) {
                        return super.contains(str, str2);
                    }
                };
            }
        }
        return parameters;
    }
}
