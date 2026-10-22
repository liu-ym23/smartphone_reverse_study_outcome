package io.ktor.http;

import Z8.C1173v;
import Z8.C1174w;
import androidx.exifinterface.media.ExifInterface;
import com.fasterxml.jackson.core.JsonFactory;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentType;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000F\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\b\u0010\u0005\u001a%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00002\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\b\u0010\u000b\u001a)\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0002*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\r0\f¢\u0006\u0004\b\u000f\u0010\u0010\u001a+\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0011*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a#\u0010\u0018\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001aE\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u001c\u0010\u001c\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u001aj\b\u0012\u0004\u0012\u00020\u0003`\u001b0\u00122\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001d\u0010\u001e\u001a=\u0010 \u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u001c\u0010\u001f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\u001aj\b\u0012\u0004\u0012\u00020\u000e`\u001b0\u0012H\u0002¢\u0006\u0004\b \u0010!\u001a+\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00000\r2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b#\u0010$\u001a+\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00000\r2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b%\u0010$\u001a\u001b\u0010&\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b&\u0010'¨\u0006("}, d2 = {"", "header", "", "Lio/ktor/http/HeaderValue;", "parseAndSortHeader", "(Ljava/lang/String;)Ljava/util/List;", "parseAndSortContentTypeHeader", "text", "parseHeaderValue", "", "parametersOnly", "(Ljava/lang/String;Z)Ljava/util/List;", "", "Lkotlin/Pair;", "Lio/ktor/http/HeaderValueParam;", "toHeaderParamsList", "(Ljava/lang/Iterable;)Ljava/util/List;", ExifInterface.GPS_DIRECTION_TRUE, "LY8/h;", "valueOrEmpty", "(LY8/h;)Ljava/util/List;", "", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "subtrim", "(Ljava/lang/String;II)Ljava/lang/String;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", DidiCardProvider.KEY_ITEMS, "parseHeaderValueItem", "(Ljava/lang/String;ILY8/h;Z)I", "parameters", "parseHeaderValueParameter", "(Ljava/lang/String;ILY8/h;)I", UxipConstants.f30680s, "parseHeaderValueParameterValue", "(Ljava/lang/String;I)Lkotlin/Pair;", "parseHeaderValueParameterValueQuoted", "nextIsDelimiterOrEnd", "(Ljava/lang/String;I)Z", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpHeaderValueParserKt {
    private static final boolean nextIsDelimiterOrEnd(String str, int i10) {
        int i11 = i10 + 1;
        while (i11 < str.length() && str.charAt(i11) == ' ') {
            i11++;
        }
        return i11 == str.length() || str.charAt(i11) == ';' || str.charAt(i11) == ',';
    }

    public static final List<HeaderValue> parseAndSortContentTypeHeader(String str) {
        List<HeaderValue> headerValue = parseHeaderValue(str);
        final Comparator comparator = new Comparator() { // from class: io.ktor.http.HttpHeaderValueParserKt$parseAndSortContentTypeHeader$$inlined$compareByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                return b9.b.d(Double.valueOf(((HeaderValue) t11).getQuality()), Double.valueOf(((HeaderValue) t10).getQuality()));
            }
        };
        final Comparator comparator2 = new Comparator() { // from class: io.ktor.http.HttpHeaderValueParserKt$parseAndSortContentTypeHeader$$inlined$thenBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) throws BadContentTypeFormatException {
                int iCompare = comparator.compare(t10, t11);
                if (iCompare != 0) {
                    return iCompare;
                }
                ContentType.Companion companion = ContentType.INSTANCE;
                ContentType contentType = companion.parse(((HeaderValue) t10).getValue());
                int i10 = kotlin.jvm.internal.p.d(contentType.getContentType(), "*") ? 2 : 0;
                if (kotlin.jvm.internal.p.d(contentType.getContentSubtype(), "*")) {
                    i10++;
                }
                Integer numValueOf = Integer.valueOf(i10);
                ContentType contentType2 = companion.parse(((HeaderValue) t11).getValue());
                int i11 = kotlin.jvm.internal.p.d(contentType2.getContentType(), "*") ? 2 : 0;
                if (kotlin.jvm.internal.p.d(contentType2.getContentSubtype(), "*")) {
                    i11++;
                }
                return b9.b.d(numValueOf, Integer.valueOf(i11));
            }
        };
        return Z8.F.c1(headerValue, new Comparator() { // from class: io.ktor.http.HttpHeaderValueParserKt$parseAndSortContentTypeHeader$$inlined$thenByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                int iCompare = comparator2.compare(t10, t11);
                return iCompare != 0 ? iCompare : b9.b.d(Integer.valueOf(((HeaderValue) t11).getParams().size()), Integer.valueOf(((HeaderValue) t10).getParams().size()));
            }
        });
    }

    public static final List<HeaderValue> parseAndSortHeader(String str) {
        return Z8.F.c1(parseHeaderValue(str), new Comparator() { // from class: io.ktor.http.HttpHeaderValueParserKt$parseAndSortHeader$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                return b9.b.d(Double.valueOf(((HeaderValue) t11).getQuality()), Double.valueOf(((HeaderValue) t10).getQuality()));
            }
        });
    }

    public static final List<HeaderValue> parseHeaderValue(String str) {
        return parseHeaderValue(str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList parseHeaderValue$lambda$4() {
        return new ArrayList();
    }

    private static final int parseHeaderValueItem(String str, int i10, Y8.h<? extends ArrayList<HeaderValue>> hVar, boolean z10) {
        Y8.h hVarA = C4848b.a(LazyThreadSafetyMode.NONE, new InterfaceC5063a() { // from class: io.ktor.http.w
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return HttpHeaderValueParserKt.parseHeaderValueItem$lambda$6();
            }
        });
        Integer numValueOf = z10 ? Integer.valueOf(i10) : null;
        int headerValueParameter = i10;
        while (headerValueParameter <= La.H.n0(str)) {
            char cCharAt = str.charAt(headerValueParameter);
            if (cCharAt == ',') {
                hVar.getValue().add(new HeaderValue(subtrim(str, i10, numValueOf != null ? numValueOf.intValue() : headerValueParameter), valueOrEmpty(hVarA)));
                return headerValueParameter + 1;
            }
            if (cCharAt != ';') {
                headerValueParameter = z10 ? parseHeaderValueParameter(str, headerValueParameter, hVarA) : headerValueParameter + 1;
            } else {
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(headerValueParameter);
                }
                headerValueParameter = parseHeaderValueParameter(str, headerValueParameter + 1, hVarA);
            }
        }
        hVar.getValue().add(new HeaderValue(subtrim(str, i10, numValueOf != null ? numValueOf.intValue() : headerValueParameter), valueOrEmpty(hVarA)));
        return headerValueParameter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList parseHeaderValueItem$lambda$6() {
        return new ArrayList();
    }

    private static final int parseHeaderValueParameter(String str, int i10, Y8.h<? extends ArrayList<HeaderValueParam>> hVar) {
        int i11 = i10;
        while (i11 <= La.H.n0(str)) {
            char cCharAt = str.charAt(i11);
            if (cCharAt == ',' || cCharAt == ';') {
                parseHeaderValueParameter$addParam(hVar, str, i10, i11, "");
                return i11;
            }
            if (cCharAt == '=') {
                Pair<Integer, String> headerValueParameterValue = parseHeaderValueParameterValue(str, i11 + 1);
                int iIntValue = headerValueParameterValue.a().intValue();
                parseHeaderValueParameter$addParam(hVar, str, i10, i11, headerValueParameterValue.b());
                return iIntValue;
            }
            i11++;
        }
        parseHeaderValueParameter$addParam(hVar, str, i10, i11, "");
        return i11;
    }

    private static final void parseHeaderValueParameter$addParam(Y8.h<? extends ArrayList<HeaderValueParam>> hVar, String str, int i10, int i11, String str2) {
        String strSubtrim = subtrim(str, i10, i11);
        if (strSubtrim.length() == 0) {
            return;
        }
        hVar.getValue().add(new HeaderValueParam(strSubtrim, str2));
    }

    private static final Pair<Integer, String> parseHeaderValueParameterValue(String str, int i10) {
        if (str.length() == i10) {
            return Y8.j.a(Integer.valueOf(i10), "");
        }
        if (str.charAt(i10) == '\"') {
            return parseHeaderValueParameterValueQuoted(str, i10 + 1);
        }
        int i11 = i10;
        while (i11 <= La.H.n0(str)) {
            char cCharAt = str.charAt(i11);
            if (cCharAt == ',' || cCharAt == ';') {
                return Y8.j.a(Integer.valueOf(i11), subtrim(str, i10, i11));
            }
            i11++;
        }
        return Y8.j.a(Integer.valueOf(i11), subtrim(str, i10, i11));
    }

    private static final Pair<Integer, String> parseHeaderValueParameterValueQuoted(String str, int i10) {
        StringBuilder sb2 = new StringBuilder();
        while (i10 <= La.H.n0(str)) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\"' && nextIsDelimiterOrEnd(str, i10)) {
                return Y8.j.a(Integer.valueOf(i10 + 1), sb2.toString());
            }
            if (cCharAt != '\\' || i10 >= La.H.n0(str) - 2) {
                sb2.append(cCharAt);
                i10++;
            } else {
                sb2.append(str.charAt(i10 + 1));
                i10 += 2;
            }
        }
        Integer numValueOf = Integer.valueOf(i10);
        String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return Y8.j.a(numValueOf, JsonFactory.DEFAULT_QUOTE_CHAR + string);
    }

    private static final String subtrim(String str, int i10, int i11) {
        String strSubstring = str.substring(i10, i11);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return La.H.D1(strSubstring).toString();
    }

    public static final List<HeaderValueParam> toHeaderParamsList(Iterable<Pair<String, String>> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        ArrayList arrayList = new ArrayList(C1174w.x(iterable, 10));
        for (Pair<String, String> pair : iterable) {
            arrayList.add(new HeaderValueParam(pair.e(), pair.f()));
        }
        return arrayList;
    }

    private static final <T> List<T> valueOrEmpty(Y8.h<? extends List<? extends T>> hVar) {
        return hVar.isInitialized() ? hVar.getValue() : C1173v.m();
    }

    public static final List<HeaderValue> parseHeaderValue(String str, boolean z10) {
        if (str == null) {
            return C1173v.m();
        }
        Y8.h hVarA = C4848b.a(LazyThreadSafetyMode.NONE, new InterfaceC5063a() { // from class: io.ktor.http.v
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return HttpHeaderValueParserKt.parseHeaderValue$lambda$4();
            }
        });
        int headerValueItem = 0;
        while (headerValueItem <= La.H.n0(str)) {
            headerValueItem = parseHeaderValueItem(str, headerValueItem, hVarA, z10);
        }
        return valueOrEmpty(hVarA);
    }
}
