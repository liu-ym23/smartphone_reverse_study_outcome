package tb;

import La.H;
import La.MatchGroup;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonFactory;
import i9.C4180c;
import io.ktor.http.auth.HttpAuthHeader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \"2\u00020\u0001:\u0001\u001aB/\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001f\u0010\u0012R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006#"}, d2 = {"Ltb/x;", "", "", "mediaType", "type", "subtype", "", "parameterNamesAndValues", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "Ljava/nio/charset/Charset;", "defaultValue", "c", "(Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;", "name", "f", "(Ljava/lang/String;)Ljava/lang/String;", "toString", "()Ljava/lang/String;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getMediaType$okhttp", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_UMID, "[Ljava/lang/String;", "e", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class x {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    public static final Regex f42263f = new Regex("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: g, reason: collision with root package name */
    public static final Regex f42264g = new Regex(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String mediaType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String subtype;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final String[] parameterNamesAndValues;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005*\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, d2 = {"Ltb/x$a;", "", "<init>", "()V", "", "Ltb/x;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ltb/x;", Const.INTENT_KEY_PKGNAME, "TOKEN", "Ljava/lang/String;", "QUOTED", "Lkotlin/text/Regex;", "TYPE_SUBTYPE", "Lkotlin/text/Regex;", "PARAMETER", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: tb.x$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final x a(String str) {
            kotlin.jvm.internal.p.i(str, "<this>");
            La.m mVarI = x.f42263f.i(str, 0);
            if (mVarI == null) {
                throw new IllegalArgumentException("No subtype found for: \"" + str + JsonFactory.DEFAULT_QUOTE_CHAR);
            }
            String str2 = mVarI.c().get(1);
            Locale locale = Locale.ROOT;
            String lowerCase = str2.toLowerCase(locale);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            String lowerCase2 = mVarI.c().get(2).toLowerCase(locale);
            kotlin.jvm.internal.p.h(lowerCase2, "toLowerCase(...)");
            ArrayList arrayList = new ArrayList();
            int last = mVarI.a().getLast();
            while (true) {
                int i10 = last + 1;
                if (i10 >= str.length()) {
                    return new x(str, lowerCase, lowerCase2, (String[]) arrayList.toArray(new String[0]));
                }
                La.m mVarI2 = x.f42264g.i(str, i10);
                if (mVarI2 == null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Parameter is not formatted correctly: \"");
                    String strSubstring = str.substring(i10);
                    kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
                    sb2.append(strSubstring);
                    sb2.append("\" for: \"");
                    sb2.append(str);
                    sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
                    throw new IllegalArgumentException(sb2.toString().toString());
                }
                MatchGroup matchGroup = mVarI2.getGroups().get(1);
                String value = matchGroup != null ? matchGroup.getValue() : null;
                if (value == null) {
                    last = mVarI2.a().getLast();
                } else {
                    MatchGroup matchGroup2 = mVarI2.getGroups().get(2);
                    String value2 = matchGroup2 != null ? matchGroup2.getValue() : null;
                    if (value2 == null) {
                        MatchGroup matchGroup3 = mVarI2.getGroups().get(3);
                        kotlin.jvm.internal.p.f(matchGroup3);
                        value2 = matchGroup3.getValue();
                    } else if (H.i1(value2, '\'', false, 2, null) && H.j0(value2, '\'', false, 2, null) && value2.length() > 2) {
                        value2 = value2.substring(1, value2.length() - 1);
                        kotlin.jvm.internal.p.h(value2, "substring(...)");
                    }
                    arrayList.add(value);
                    arrayList.add(value2);
                    last = mVarI2.a().getLast();
                }
            }
        }

        public final x b(String str) {
            kotlin.jvm.internal.p.i(str, "<this>");
            try {
                return a(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public Companion() {
        }
    }

    public x(String mediaType, String type, String subtype, String[] parameterNamesAndValues) {
        kotlin.jvm.internal.p.i(mediaType, "mediaType");
        kotlin.jvm.internal.p.i(type, "type");
        kotlin.jvm.internal.p.i(subtype, "subtype");
        kotlin.jvm.internal.p.i(parameterNamesAndValues, "parameterNamesAndValues");
        this.mediaType = mediaType;
        this.type = type;
        this.subtype = subtype;
        this.parameterNamesAndValues = parameterNamesAndValues;
    }

    public static /* synthetic */ Charset d(x xVar, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = null;
        }
        return xVar.c(charset);
    }

    public static final x e(String str) {
        return INSTANCE.a(str);
    }

    public final Charset c(Charset defaultValue) {
        String strF = f(HttpAuthHeader.Parameters.Charset);
        if (strF == null) {
            return defaultValue;
        }
        try {
            return Charset.forName(strF);
        } catch (IllegalArgumentException unused) {
            return defaultValue;
        }
    }

    public boolean equals(Object other) {
        return (other instanceof x) && kotlin.jvm.internal.p.d(((x) other).mediaType, this.mediaType);
    }

    public final String f(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        int i10 = 0;
        int iC = C4180c.c(0, this.parameterNamesAndValues.length - 1, 2);
        if (iC < 0) {
            return null;
        }
        while (!La.D.L(this.parameterNamesAndValues[i10], name, true)) {
            if (i10 == iC) {
                return null;
            }
            i10 += 2;
        }
        return this.parameterNamesAndValues[i10 + 1];
    }

    /* renamed from: g, reason: from getter */
    public final String getSubtype() {
        return this.subtype;
    }

    /* renamed from: h, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    /* renamed from: toString, reason: from getter */
    public String getMediaType() {
        return this.mediaType;
    }
}
