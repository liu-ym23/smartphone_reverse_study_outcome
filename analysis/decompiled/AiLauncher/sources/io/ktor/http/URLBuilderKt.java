package io.ktor.http;

import Z8.C1173v;
import Z8.C1174w;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.sse.ServerSentEventKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a)\u0010\u0005\u001a\u00028\u0000\"\f\b\u0000\u0010\u0002*\u00060\u0000j\u0002`\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u000b\u001a\u00020\n*\u00060\u0000j\u0002`\u00012\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a'\u0010\u000e\u001a\u00020\n*\u00060\u0000j\u0002`\u00012\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\f\u001a\u001f\u0010\u000f\u001a\u00020\n*\u00060\u0000j\u0002`\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0011\u0010\u0011\u001a\u00020\u0003*\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012\u001a)\u0010\u0017\u001a\u00020\u0003*\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018\u001a/\u0010\u0017\u001a\u00020\u0003*\u00020\u00032\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0019\"\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u001b\u001a%\u0010\u001c\u001a\u00020\n*\u00020\u00032\u0012\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0019\"\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001f\u0010\u001e\u001a\u00020\u0003*\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0004\b\u001e\u0010\u001f\u001a%\u0010\u001e\u001a\u00020\u0003*\u00020\u00032\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0019\"\u00020\u0007¢\u0006\u0004\b\u001e\u0010 \u001a\u0019\u0010!\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0002¢\u0006\u0004\b!\u0010\"\u001aW\u0010(\u001a\u00020\n*\u00020\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0&¢\u0006\u0004\b(\u0010)\u001a'\u0010*\u001a\u00020\u0003*\u00020\u00032\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0019\"\u00020\u0007H\u0007¢\u0006\u0004\b*\u0010 \u001a!\u0010*\u001a\u00020\u0003*\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0007¢\u0006\u0004\b*\u0010\u001f\"\u0014\u0010+\u001a\u00020$8\u0006X\u0086T¢\u0006\u0006\n\u0004\b+\u0010,\"\u0018\u0010/\u001a\u00020\u0007*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.\"\u0015\u00101\u001a\u00020\u0007*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b0\u0010.\"(\u0010\r\u001a\u00020\u0007*\u00020\u00032\u0006\u00102\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u0010.\"\u0004\b4\u00105¨\u00066"}, d2 = {"Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lio/ktor/http/URLBuilder;", "out", "appendTo", "(Lio/ktor/http/URLBuilder;Ljava/lang/Appendable;)Ljava/lang/Appendable;", "", "encodedUser", "host", "LY8/t;", "appendMailto", "(Ljava/lang/Appendable;Ljava/lang/String;Ljava/lang/String;)V", "encodedPath", "appendFile", "appendPayload", "(Ljava/lang/Appendable;Ljava/lang/String;)V", "clone", "(Lio/ktor/http/URLBuilder;)Lio/ktor/http/URLBuilder;", "", "segments", "", "encodeSlash", "appendPathSegments", "(Lio/ktor/http/URLBuilder;Ljava/util/List;Z)Lio/ktor/http/URLBuilder;", "", "components", "(Lio/ktor/http/URLBuilder;[Ljava/lang/String;Z)Lio/ktor/http/URLBuilder;", "path", "(Lio/ktor/http/URLBuilder;[Ljava/lang/String;)V", "appendEncodedPathSegments", "(Lio/ktor/http/URLBuilder;Ljava/util/List;)Lio/ktor/http/URLBuilder;", "(Lio/ktor/http/URLBuilder;[Ljava/lang/String;)Lio/ktor/http/URLBuilder;", "joinPath", "(Ljava/util/List;)Ljava/lang/String;", "scheme", "", "port", "Lkotlin/Function1;", "block", "set", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lp9/l;)V", "pathComponents", "DEFAULT_PORT", "I", "getEncodedUserAndPassword", "(Lio/ktor/http/URLBuilder;)Ljava/lang/String;", "encodedUserAndPassword", "getAuthority", "authority", UxipConstants.f30680s, "getEncodedPath", "setEncodedPath", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;)V", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class URLBuilderKt {
    public static final int DEFAULT_PORT = 0;

    public static final URLBuilder appendEncodedPathSegments(URLBuilder uRLBuilder, List<String> segments) {
        kotlin.jvm.internal.p.i(uRLBuilder, "<this>");
        kotlin.jvm.internal.p.i(segments, "segments");
        boolean z10 = false;
        boolean z11 = uRLBuilder.getEncodedPathSegments().size() > 1 && ((CharSequence) Z8.F.C0(uRLBuilder.getEncodedPathSegments())).length() == 0 && !segments.isEmpty();
        if (segments.size() > 1 && ((CharSequence) Z8.F.q0(segments)).length() == 0 && !uRLBuilder.getEncodedPathSegments().isEmpty()) {
            z10 = true;
        }
        uRLBuilder.setEncodedPathSegments((z11 && z10) ? Z8.F.S0(Z8.F.i0(uRLBuilder.getEncodedPathSegments(), 1), Z8.F.h0(segments, 1)) : z11 ? Z8.F.S0(Z8.F.i0(uRLBuilder.getEncodedPathSegments(), 1), segments) : z10 ? Z8.F.S0(uRLBuilder.getEncodedPathSegments(), Z8.F.h0(segments, 1)) : Z8.F.S0(uRLBuilder.getEncodedPathSegments(), segments));
        return uRLBuilder;
    }

    private static final void appendFile(Appendable appendable, String str, String str2) throws IOException {
        appendable.append("://");
        appendable.append(str);
        if (!La.H.i1(str2, JsonPointer.SEPARATOR, false, 2, null)) {
            appendable.append(JsonPointer.SEPARATOR);
        }
        appendable.append(str2);
    }

    private static final void appendMailto(Appendable appendable, String str, String str2) throws IOException {
        appendable.append(ServerSentEventKt.COLON);
        appendable.append(str);
        appendable.append(str2);
    }

    public static final URLBuilder appendPathSegments(URLBuilder uRLBuilder, List<String> segments, boolean z10) {
        kotlin.jvm.internal.p.i(uRLBuilder, "<this>");
        kotlin.jvm.internal.p.i(segments, "segments");
        if (!z10) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = segments.iterator();
            while (it.hasNext()) {
                Z8.A.E(arrayList, La.H.a1((String) it.next(), new char[]{JsonPointer.SEPARATOR}, false, 0, 6, null));
            }
            segments = arrayList;
        }
        List<String> list = segments;
        ArrayList arrayList2 = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(CodecsKt.encodeURLPathPart((String) it2.next()));
        }
        appendEncodedPathSegments(uRLBuilder, arrayList2);
        return uRLBuilder;
    }

    public static /* synthetic */ URLBuilder appendPathSegments$default(URLBuilder uRLBuilder, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return appendPathSegments(uRLBuilder, (List<String>) list, z10);
    }

    private static final void appendPayload(Appendable appendable, String str) throws IOException {
        appendable.append(ServerSentEventKt.COLON);
        appendable.append(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    public static final <A extends Appendable> A appendTo(URLBuilder uRLBuilder, A a10) throws IOException {
        a10.append(uRLBuilder.getProtocol().getName());
        String name = uRLBuilder.getProtocol().getName();
        switch (name.hashCode()) {
            case -1081572750:
                if (name.equals("mailto")) {
                    appendMailto(a10, getEncodedUserAndPassword(uRLBuilder), uRLBuilder.getHost());
                    return a10;
                }
                break;
            case 114715:
                if (name.equals("tel")) {
                    appendPayload(a10, uRLBuilder.getHost());
                    return a10;
                }
                break;
            case 3076010:
                if (name.equals("data")) {
                    appendPayload(a10, uRLBuilder.getHost());
                    return a10;
                }
                break;
            case 3143036:
                if (name.equals(Const.STR_FILE)) {
                    appendFile(a10, uRLBuilder.getHost(), getEncodedPath(uRLBuilder));
                    return a10;
                }
                break;
            case 92611469:
                if (name.equals("about")) {
                    appendPayload(a10, uRLBuilder.getHost());
                    return a10;
                }
                break;
        }
        a10.append("://");
        a10.append(getAuthority(uRLBuilder));
        URLUtilsKt.appendUrlFullPath(a10, getEncodedPath(uRLBuilder), uRLBuilder.getEncodedParameters(), uRLBuilder.getTrailingQuery());
        if (uRLBuilder.getEncodedFragment().length() > 0) {
            a10.append('#');
            a10.append(uRLBuilder.getEncodedFragment());
        }
        return a10;
    }

    public static final URLBuilder clone(URLBuilder uRLBuilder) {
        kotlin.jvm.internal.p.i(uRLBuilder, "<this>");
        return URLUtilsKt.takeFrom(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), uRLBuilder);
    }

    public static final String getAuthority(URLBuilder uRLBuilder) {
        kotlin.jvm.internal.p.i(uRLBuilder, "<this>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getEncodedUserAndPassword(uRLBuilder));
        sb2.append(uRLBuilder.getHost());
        if (uRLBuilder.getPort() != 0 && uRLBuilder.getPort() != uRLBuilder.getProtocol().getDefaultPort()) {
            sb2.append(ServerSentEventKt.COLON);
            sb2.append(String.valueOf(uRLBuilder.getPort()));
        }
        return sb2.toString();
    }

    public static final String getEncodedPath(URLBuilder uRLBuilder) {
        kotlin.jvm.internal.p.i(uRLBuilder, "<this>");
        return joinPath(uRLBuilder.getEncodedPathSegments());
    }

    public static final String getEncodedUserAndPassword(URLBuilder uRLBuilder) {
        kotlin.jvm.internal.p.i(uRLBuilder, "<this>");
        StringBuilder sb2 = new StringBuilder();
        URLUtilsKt.appendUserAndPassword(sb2, uRLBuilder.getEncodedUser(), uRLBuilder.getEncodedPassword());
        return sb2.toString();
    }

    private static final String joinPath(List<String> list) {
        return list.isEmpty() ? "" : list.size() == 1 ? ((CharSequence) Z8.F.q0(list)).length() == 0 ? "/" : (String) Z8.F.q0(list) : Z8.F.A0(list, "/", null, null, 0, null, null, 62, null);
    }

    public static final void path(URLBuilder uRLBuilder, String... path) {
        kotlin.jvm.internal.p.i(uRLBuilder, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        ArrayList arrayList = new ArrayList(path.length);
        for (String str : path) {
            arrayList.add(CodecsKt.encodeURLPath$default(str, false, false, 3, null));
        }
        uRLBuilder.setEncodedPathSegments(arrayList);
    }

    public static final URLBuilder pathComponents(URLBuilder uRLBuilder, String... components) {
        kotlin.jvm.internal.p.i(uRLBuilder, "<this>");
        kotlin.jvm.internal.p.i(components, "components");
        return appendPathSegments$default(uRLBuilder, Z8.r.T0(components), false, 2, (Object) null);
    }

    public static final void set(URLBuilder uRLBuilder, String str, String str2, Integer num, String str3, InterfaceC5074l<? super URLBuilder, Y8.t> block) {
        kotlin.jvm.internal.p.i(uRLBuilder, "<this>");
        kotlin.jvm.internal.p.i(block, "block");
        if (str != null) {
            uRLBuilder.setProtocol(URLProtocol.INSTANCE.createOrDefault(str));
        }
        if (str2 != null) {
            uRLBuilder.setHost(str2);
        }
        if (num != null) {
            uRLBuilder.setPort(num.intValue());
        }
        if (str3 != null) {
            setEncodedPath(uRLBuilder, str3);
        }
        block.invoke(uRLBuilder);
    }

    public static /* synthetic */ void set$default(URLBuilder uRLBuilder, String str, String str2, Integer num, String str3, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            num = null;
        }
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        if ((i10 & 16) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.http.B
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return URLBuilderKt.set$lambda$5((URLBuilder) obj2);
                }
            };
        }
        set(uRLBuilder, str, str2, num, str3, interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t set$lambda$5(URLBuilder uRLBuilder) {
        kotlin.jvm.internal.p.i(uRLBuilder, "<this>");
        return Y8.t.f7040a;
    }

    public static final void setEncodedPath(URLBuilder uRLBuilder, String value) {
        kotlin.jvm.internal.p.i(uRLBuilder, "<this>");
        kotlin.jvm.internal.p.i(value, "value");
        uRLBuilder.setEncodedPathSegments(La.H.x0(value) ? C1173v.m() : kotlin.jvm.internal.p.d(value, "/") ? URLParserKt.getROOT_PATH() : Z8.F.p1(La.H.a1(value, new char[]{JsonPointer.SEPARATOR}, false, 0, 6, null)));
    }

    public static /* synthetic */ URLBuilder appendPathSegments$default(URLBuilder uRLBuilder, String[] strArr, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return appendPathSegments(uRLBuilder, strArr, z10);
    }

    public static final URLBuilder pathComponents(URLBuilder uRLBuilder, List<String> components) {
        kotlin.jvm.internal.p.i(uRLBuilder, "<this>");
        kotlin.jvm.internal.p.i(components, "components");
        return appendPathSegments$default(uRLBuilder, (List) components, false, 2, (Object) null);
    }

    public static final URLBuilder appendEncodedPathSegments(URLBuilder uRLBuilder, String... components) {
        kotlin.jvm.internal.p.i(uRLBuilder, "<this>");
        kotlin.jvm.internal.p.i(components, "components");
        return appendEncodedPathSegments(uRLBuilder, (List<String>) Z8.r.T0(components));
    }

    public static final URLBuilder appendPathSegments(URLBuilder uRLBuilder, String[] components, boolean z10) {
        kotlin.jvm.internal.p.i(uRLBuilder, "<this>");
        kotlin.jvm.internal.p.i(components, "components");
        return appendPathSegments(uRLBuilder, (List<String>) Z8.r.T0(components), z10);
    }
}
