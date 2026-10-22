package io.ktor.http;

import Z8.C1173v;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 R2\u00020\u0001:\u0001RBm\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u001fR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R*\u0010\u0007\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010+\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00101\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u001c\u001a\u0004\b2\u0010\u0017\"\u0004\b3\u0010\u001fR$\u00104\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\u001c\u001a\u0004\b5\u0010\u0017\"\u0004\b6\u0010\u001fR\"\u00107\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010\u001c\u001a\u0004\b8\u0010\u0017\"\u0004\b9\u0010\u001fR(\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R*\u0010A\u001a\u00020@2\u0006\u0010%\u001a\u00020@8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010\r\u001a\u00020@2\u0006\u0010%\u001a\u00020@8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\r\u0010B\u001a\u0004\bG\u0010DR$\u0010\u0003\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bH\u0010.\"\u0004\bI\u00100R(\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bJ\u0010\u0017\"\u0004\bK\u0010\u001fR(\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bL\u0010\u0017\"\u0004\bM\u0010\u001fR$\u0010\u000e\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bN\u0010\u0017\"\u0004\bO\u0010\u001fR0\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bP\u0010=\"\u0004\bQ\u0010?¨\u0006S"}, d2 = {"Lio/ktor/http/URLBuilder;", "", "Lio/ktor/http/URLProtocol;", "protocol", "", "host", "", "port", "user", "password", "", "pathSegments", "Lio/ktor/http/Parameters;", "parameters", "fragment", "", "trailingQuery", "<init>", "(Lio/ktor/http/URLProtocol;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Lio/ktor/http/Parameters;Ljava/lang/String;Z)V", "LY8/t;", "applyOrigin", "()V", "buildString", "()Ljava/lang/String;", "toString", "Lio/ktor/http/Url;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Lio/ktor/http/Url;", "Ljava/lang/String;", "getHost", "setHost", "(Ljava/lang/String;)V", "Z", "getTrailingQuery", "()Z", "setTrailingQuery", "(Z)V", UxipConstants.f30680s, "I", "getPort", "()I", "setPort", "(I)V", "protocolOrNull", "Lio/ktor/http/URLProtocol;", "getProtocolOrNull", "()Lio/ktor/http/URLProtocol;", "setProtocolOrNull", "(Lio/ktor/http/URLProtocol;)V", "encodedUser", "getEncodedUser", "setEncodedUser", "encodedPassword", "getEncodedPassword", "setEncodedPassword", "encodedFragment", "getEncodedFragment", "setEncodedFragment", "encodedPathSegments", "Ljava/util/List;", "getEncodedPathSegments", "()Ljava/util/List;", "setEncodedPathSegments", "(Ljava/util/List;)V", "Lio/ktor/http/ParametersBuilder;", "encodedParameters", "Lio/ktor/http/ParametersBuilder;", "getEncodedParameters", "()Lio/ktor/http/ParametersBuilder;", "setEncodedParameters", "(Lio/ktor/http/ParametersBuilder;)V", "getParameters", "getProtocol", "setProtocol", "getUser", "setUser", "getPassword", "setPassword", "getFragment", "setFragment", "getPathSegments", "setPathSegments", "Companion", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class URLBuilder {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final int INITIAL_CAPACITY = 256;
    private static final Url originUrl;
    private String encodedFragment;
    private ParametersBuilder encodedParameters;
    private String encodedPassword;
    private List<String> encodedPathSegments;
    private String encodedUser;
    private String host;
    private ParametersBuilder parameters;
    private int port;
    private URLProtocol protocolOrNull;
    private boolean trailingQuery;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/http/URLBuilder$Companion;", "", "<init>", "()V", "Lio/ktor/http/Url;", "originUrl", "Lio/ktor/http/Url;", "", "INITIAL_CAPACITY", "I", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        originUrl = URLUtilsKt.Url(URLBuilderJvmKt.getOrigin(companion));
    }

    public URLBuilder() {
        this(null, null, 0, null, null, null, null, null, false, 511, null);
    }

    private final void applyOrigin() {
        if (this.host.length() <= 0 && !kotlin.jvm.internal.p.d(getProtocol().getName(), Const.STR_FILE)) {
            Url url = originUrl;
            this.host = url.getHost();
            if (this.protocolOrNull == null) {
                this.protocolOrNull = url.getProtocolOrNull();
            }
            if (this.port == 0) {
                setPort(url.getSpecifiedPort());
            }
        }
    }

    public final Url build() {
        applyOrigin();
        return new Url(this.protocolOrNull, this.host, this.port, getPathSegments(), this.parameters.build(), getFragment(), getUser(), getPassword(), this.trailingQuery, buildString());
    }

    public final String buildString() {
        applyOrigin();
        String string = ((StringBuilder) URLBuilderKt.appendTo(this, new StringBuilder(256))).toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return string;
    }

    public final String getEncodedFragment() {
        return this.encodedFragment;
    }

    public final ParametersBuilder getEncodedParameters() {
        return this.encodedParameters;
    }

    public final String getEncodedPassword() {
        return this.encodedPassword;
    }

    public final List<String> getEncodedPathSegments() {
        return this.encodedPathSegments;
    }

    public final String getEncodedUser() {
        return this.encodedUser;
    }

    public final String getFragment() {
        return CodecsKt.decodeURLQueryComponent$default(this.encodedFragment, 0, 0, false, null, 15, null);
    }

    public final String getHost() {
        return this.host;
    }

    public final ParametersBuilder getParameters() {
        return this.parameters;
    }

    public final String getPassword() {
        String str = this.encodedPassword;
        if (str != null) {
            return CodecsKt.decodeURLPart$default(str, 0, 0, null, 7, null);
        }
        return null;
    }

    public final List<String> getPathSegments() {
        List<String> list = this.encodedPathSegments;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CodecsKt.decodeURLPart$default((String) it.next(), 0, 0, null, 7, null));
        }
        return arrayList;
    }

    public final int getPort() {
        return this.port;
    }

    public final URLProtocol getProtocol() {
        URLProtocol uRLProtocol = this.protocolOrNull;
        return uRLProtocol == null ? URLProtocol.INSTANCE.getHTTP() : uRLProtocol;
    }

    public final URLProtocol getProtocolOrNull() {
        return this.protocolOrNull;
    }

    public final boolean getTrailingQuery() {
        return this.trailingQuery;
    }

    public final String getUser() {
        String str = this.encodedUser;
        if (str != null) {
            return CodecsKt.decodeURLPart$default(str, 0, 0, null, 7, null);
        }
        return null;
    }

    public final void setEncodedFragment(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.encodedFragment = str;
    }

    public final void setEncodedParameters(ParametersBuilder value) {
        kotlin.jvm.internal.p.i(value, "value");
        this.encodedParameters = value;
        this.parameters = new UrlDecodedParametersBuilder(value);
    }

    public final void setEncodedPassword(String str) {
        this.encodedPassword = str;
    }

    public final void setEncodedPathSegments(List<String> list) {
        kotlin.jvm.internal.p.i(list, "<set-?>");
        this.encodedPathSegments = list;
    }

    public final void setEncodedUser(String str) {
        this.encodedUser = str;
    }

    public final void setFragment(String value) {
        kotlin.jvm.internal.p.i(value, "value");
        this.encodedFragment = CodecsKt.encodeURLQueryComponent$default(value, false, false, null, 7, null);
    }

    public final void setHost(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.host = str;
    }

    public final void setPassword(String str) {
        this.encodedPassword = str != null ? CodecsKt.encodeURLParameter$default(str, false, 1, null) : null;
    }

    public final void setPathSegments(List<String> value) {
        kotlin.jvm.internal.p.i(value, "value");
        List<String> list = value;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CodecsKt.encodeURLPathPart((String) it.next()));
        }
        this.encodedPathSegments = arrayList;
    }

    public final void setPort(int i10) {
        if (i10 >= 0 && i10 < 65536) {
            this.port = i10;
            return;
        }
        throw new IllegalArgumentException(("Port must be between 0 and 65535, or 0 if not set. Provided: " + i10).toString());
    }

    public final void setProtocol(URLProtocol value) {
        kotlin.jvm.internal.p.i(value, "value");
        this.protocolOrNull = value;
    }

    public final void setProtocolOrNull(URLProtocol uRLProtocol) {
        this.protocolOrNull = uRLProtocol;
    }

    public final void setTrailingQuery(boolean z10) {
        this.trailingQuery = z10;
    }

    public final void setUser(String str) {
        this.encodedUser = str != null ? CodecsKt.encodeURLParameter$default(str, false, 1, null) : null;
    }

    public String toString() {
        String string = ((StringBuilder) URLBuilderKt.appendTo(this, new StringBuilder(256))).toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return string;
    }

    public URLBuilder(URLProtocol uRLProtocol, String host, int i10, String str, String str2, List<String> pathSegments, Parameters parameters, String fragment, boolean z10) {
        kotlin.jvm.internal.p.i(host, "host");
        kotlin.jvm.internal.p.i(pathSegments, "pathSegments");
        kotlin.jvm.internal.p.i(parameters, "parameters");
        kotlin.jvm.internal.p.i(fragment, "fragment");
        this.host = host;
        this.trailingQuery = z10;
        this.port = i10;
        this.protocolOrNull = uRLProtocol;
        this.encodedUser = str != null ? CodecsKt.encodeURLParameter$default(str, false, 1, null) : null;
        this.encodedPassword = str2 != null ? CodecsKt.encodeURLParameter$default(str2, false, 1, null) : null;
        this.encodedFragment = CodecsKt.encodeURLQueryComponent$default(fragment, false, false, null, 7, null);
        List<String> list = pathSegments;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CodecsKt.encodeURLPathPart((String) it.next()));
        }
        this.encodedPathSegments = arrayList;
        ParametersBuilder parametersBuilderEncodeParameters = UrlDecodedParametersBuilderKt.encodeParameters(parameters);
        this.encodedParameters = parametersBuilderEncodeParameters;
        this.parameters = new UrlDecodedParametersBuilder(parametersBuilderEncodeParameters);
    }

    public /* synthetic */ URLBuilder(URLProtocol uRLProtocol, String str, int i10, String str2, String str3, List list, Parameters parameters, String str4, boolean z10, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? null : uRLProtocol, (i11 & 2) != 0 ? "" : str, (i11 & 4) != 0 ? 0 : i10, (i11 & 8) != 0 ? null : str2, (i11 & 16) != 0 ? null : str3, (i11 & 32) != 0 ? C1173v.m() : list, (i11 & 64) != 0 ? Parameters.INSTANCE.getEmpty() : parameters, (i11 & 128) != 0 ? "" : str4, (i11 & 256) != 0 ? false : z10);
    }
}
