package okhttp3.internal.http;

import com.baidu.platform.comapi.map.MapBundleKey;
import h3.C0606o;
import h3.C0611u;
import h3.C0612v;
import h3.H;
import h3.InterfaceC0613w;
import h3.J;
import h3.b0;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import k3.C0694i;
import k3.l;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;
import y1.f;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\u000b\u001a\u00020\n*\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\u000e\u001a\u00020\r*\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001b\u0010\u0012\u001a\u00020\r*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0015\u001a!\u0010\u001b\u001a\u00020\n*\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0011\u0010\u001e\u001a\u00020\r*\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0017\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001dH\u0007¢\u0006\u0004\b!\u0010\u001f\"\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$\"\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010$¨\u0006&"}, d2 = {"Lh3/H;", "", "headerName", "", "Lh3/o;", "parseChallenges", "(Lh3/H;Ljava/lang/String;)Ljava/util/List;", "Lk3/i;", "", "result", "", "readChallengeHeader", "(Lk3/i;Ljava/util/List;)V", "", "skipCommasAndWhitespace", "(Lk3/i;)Z", "", "prefix", "startsWith", "(Lk3/i;B)Z", "readQuotedString", "(Lk3/i;)Ljava/lang/String;", "readToken", "Lh3/w;", "Lh3/J;", MapBundleKey.MapObjKey.OBJ_URL, "headers", "receiveHeaders", "(Lh3/w;Lh3/J;Lh3/H;)V", "Lh3/b0;", "promisesBody", "(Lh3/b0;)Z", "response", "hasBody", "Lk3/l;", "QUOTED_STRING_DELIMITERS", "Lk3/l;", "TOKEN_DELIMITERS", "okhttp"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "HttpHeaders")
/* loaded from: classes2.dex */
public final class HttpHeaders {

    @NotNull
    private static final l QUOTED_STRING_DELIMITERS;

    @NotNull
    private static final l TOKEN_DELIMITERS;

    static {
        l lVar = l.f13358d;
        QUOTED_STRING_DELIMITERS = C0611u.k("\"\\");
        TOKEN_DELIMITERS = C0611u.k("\t ,=");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "No longer supported", replaceWith = @ReplaceWith(expression = "response.promisesBody()", imports = {}))
    public static final boolean hasBody(@NotNull b0 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return promisesBody(response);
    }

    @NotNull
    public static final List<C0606o> parseChallenges(@NotNull H h4, @NotNull String headerName) {
        Intrinsics.checkNotNullParameter(h4, "<this>");
        Intrinsics.checkNotNullParameter(headerName, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = h4.size();
        int i4 = 0;
        while (i4 < size) {
            int i5 = i4 + 1;
            if (StringsKt__StringsJVMKt.equals(headerName, h4.c(i4), true)) {
                C0694i c0694i = new C0694i();
                c0694i.d0(h4.f(i4));
                try {
                    readChallengeHeader(c0694i, arrayList);
                } catch (EOFException e4) {
                    Platform.INSTANCE.get().log("Unable to parse challenge", 5, e4);
                }
            }
            i4 = i5;
        }
        return arrayList;
    }

    public static final boolean promisesBody(@NotNull b0 b0Var) {
        Intrinsics.checkNotNullParameter(b0Var, "<this>");
        if (Intrinsics.areEqual(b0Var.f12864a.f12827b, "HEAD")) {
            return false;
        }
        int i4 = b0Var.f12867d;
        return (((i4 >= 100 && i4 < 200) || i4 == 204 || i4 == 304) && Util.headersContentLength(b0Var) == -1 && !StringsKt__StringsJVMKt.equals("chunked", b0.b(b0Var, "Transfer-Encoding"), true)) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x007a, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x007a, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void readChallengeHeader(k3.C0694i r7, java.util.List<h3.C0606o> r8) throws java.io.EOFException {
        /*
            r0 = 0
        L1:
            r1 = r0
        L2:
            if (r1 != 0) goto Le
            skipCommasAndWhitespace(r7)
            java.lang.String r1 = readToken(r7)
            if (r1 != 0) goto Le
            return
        Le:
            boolean r2 = skipCommasAndWhitespace(r7)
            java.lang.String r3 = readToken(r7)
            if (r3 != 0) goto L2c
            boolean r7 = r7.s()
            if (r7 != 0) goto L1f
            return
        L1f:
            h3.o r7 = new h3.o
            java.util.Map r0 = kotlin.collections.MapsKt.emptyMap()
            r7.<init>(r1, r0)
            r8.add(r7)
            return
        L2c:
            r4 = 61
            int r5 = okhttp3.internal.Util.skipAll(r7, r4)
            boolean r6 = skipCommasAndWhitespace(r7)
            if (r2 != 0) goto L5c
            if (r6 != 0) goto L40
            boolean r2 = r7.s()
            if (r2 == 0) goto L5c
        L40:
            h3.o r2 = new h3.o
            java.lang.String r4 = "="
            java.lang.String r4 = kotlin.text.StringsKt.q(r4, r5)
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r4)
            java.util.Map r3 = java.util.Collections.singletonMap(r0, r3)
            java.lang.String r4 = "singletonMap<String, Str…ek + \"=\".repeat(eqCount))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r2.<init>(r1, r3)
            r8.add(r2)
            goto L1
        L5c:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            int r6 = okhttp3.internal.Util.skipAll(r7, r4)
            int r6 = r6 + r5
        L66:
            if (r3 != 0) goto L78
            java.lang.String r3 = readToken(r7)
            boolean r5 = skipCommasAndWhitespace(r7)
            if (r5 == 0) goto L73
            goto L7a
        L73:
            int r5 = okhttp3.internal.Util.skipAll(r7, r4)
            r6 = r5
        L78:
            if (r6 != 0) goto L85
        L7a:
            h3.o r4 = new h3.o
            r4.<init>(r1, r2)
            r8.add(r4)
            r1 = r3
            goto L2
        L85:
            r5 = 1
            if (r6 <= r5) goto L89
            return
        L89:
            boolean r5 = skipCommasAndWhitespace(r7)
            if (r5 == 0) goto L90
            return
        L90:
            r5 = 34
            boolean r5 = startsWith(r7, r5)
            if (r5 == 0) goto L9d
            java.lang.String r5 = readQuotedString(r7)
            goto La1
        L9d:
            java.lang.String r5 = readToken(r7)
        La1:
            if (r5 != 0) goto La4
            return
        La4:
            java.lang.Object r3 = r2.put(r3, r5)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto Lad
            return
        Lad:
            boolean r3 = skipCommasAndWhitespace(r7)
            if (r3 != 0) goto Lba
            boolean r3 = r7.s()
            if (r3 != 0) goto Lba
            return
        Lba:
            r3 = r0
            goto L66
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.HttpHeaders.readChallengeHeader(k3.i, java.util.List):void");
    }

    private static final String readQuotedString(C0694i c0694i) throws EOFException {
        if (c0694i.readByte() != 34) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        C0694i c0694i2 = new C0694i();
        while (true) {
            long jU = c0694i.u(QUOTED_STRING_DELIMITERS);
            if (jU == -1) {
                return null;
            }
            if (c0694i.l(jU) == 34) {
                c0694i2.write(c0694i, jU);
                c0694i.readByte();
                return c0694i2.O();
            }
            if (c0694i.f13357b == jU + 1) {
                return null;
            }
            c0694i2.write(c0694i, jU);
            c0694i.readByte();
            c0694i2.write(c0694i, 1L);
        }
    }

    private static final String readToken(C0694i c0694i) {
        long jU = c0694i.u(TOKEN_DELIMITERS);
        if (jU == -1) {
            jU = c0694i.f13357b;
        }
        if (jU != 0) {
            return c0694i.N(jU, Charsets.UTF_8);
        }
        return null;
    }

    public static final void receiveHeaders(@NotNull InterfaceC0613w interfaceC0613w, @NotNull J url, @NotNull H headers) throws NumberFormatException {
        List cookies;
        Intrinsics.checkNotNullParameter(interfaceC0613w, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (interfaceC0613w == InterfaceC0613w.f12987c0) {
            return;
        }
        Pattern pattern = C0612v.f12974j;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        List listG = headers.g("Set-Cookie");
        int size = listG.size();
        ArrayList arrayList = null;
        int i4 = 0;
        while (i4 < size) {
            int i5 = i4 + 1;
            String setCookie = (String) listG.get(i4);
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(setCookie, "setCookie");
            C0612v c0612vU = C0611u.u(System.currentTimeMillis(), url, setCookie);
            if (c0612vU != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(c0612vU);
            }
            i4 = i5;
        }
        if (arrayList != null) {
            cookies = Collections.unmodifiableList(arrayList);
            Intrinsics.checkNotNullExpressionValue(cookies, "{\n        Collections.un…ableList(cookies)\n      }");
        } else {
            cookies = CollectionsKt.emptyList();
        }
        if (cookies.isEmpty()) {
            return;
        }
        ((f) interfaceC0613w).getClass();
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(cookies, "cookies");
    }

    private static final boolean skipCommasAndWhitespace(C0694i c0694i) {
        boolean z4 = false;
        while (!c0694i.s()) {
            byte bL = c0694i.l(0L);
            if (bL == 44) {
                c0694i.readByte();
                z4 = true;
            } else {
                if (bL != 32 && bL != 9) {
                    break;
                }
                c0694i.readByte();
            }
        }
        return z4;
    }

    private static final boolean startsWith(C0694i c0694i, byte b4) {
        return !c0694i.s() && c0694i.l(0L) == b4;
    }
}
