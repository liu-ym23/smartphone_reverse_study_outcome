package io.ktor.http;

import Z8.C1173v;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lio/ktor/http/HeaderValueWithParameters;", "", "", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", "Lio/ktor/http/HeaderValueParam;", "parameters", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "name", "parameter", "(Ljava/lang/String;)Ljava/lang/String;", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getContent", "Ljava/util/List;", "getParameters", "()Ljava/util/List;", "Companion", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class HeaderValueWithParameters {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String content;
    private final List<HeaderValueParam> parameters;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lio/ktor/http/HeaderValueWithParameters$Companion;", "", "<init>", "()V", "R", "", UxipConstants.f30680s, "Lkotlin/Function2;", "", "Lio/ktor/http/HeaderValueParam;", "init", M5.e.FAIL_PARSE, "(Ljava/lang/String;Lp9/p;)Ljava/lang/Object;", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final <R> R parse(String value, p9.p<? super String, ? super List<HeaderValueParam>, ? extends R> init) {
            kotlin.jvm.internal.p.i(value, "value");
            kotlin.jvm.internal.p.i(init, "init");
            HeaderValue headerValue = (HeaderValue) Z8.F.C0(HttpHeaderValueParserKt.parseHeaderValue(value));
            return init.invoke(headerValue.getValue(), headerValue.getParams());
        }

        private Companion() {
        }
    }

    public HeaderValueWithParameters(String content, List<HeaderValueParam> parameters) {
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(parameters, "parameters");
        this.content = content;
        this.parameters = parameters;
    }

    public final String getContent() {
        return this.content;
    }

    public final List<HeaderValueParam> getParameters() {
        return this.parameters;
    }

    public final String parameter(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        int iO = C1173v.o(this.parameters);
        if (iO < 0) {
            return null;
        }
        int i10 = 0;
        while (true) {
            HeaderValueParam headerValueParam = this.parameters.get(i10);
            if (La.D.L(headerValueParam.getName(), name, true)) {
                return headerValueParam.getValue();
            }
            if (i10 == iO) {
                return null;
            }
            i10++;
        }
    }

    public String toString() {
        if (this.parameters.isEmpty()) {
            return this.content;
        }
        int length = this.content.length();
        int i10 = 0;
        int length2 = 0;
        for (HeaderValueParam headerValueParam : this.parameters) {
            length2 += headerValueParam.getName().length() + headerValueParam.getValue().length() + 3;
        }
        StringBuilder sb2 = new StringBuilder(length + length2);
        sb2.append(this.content);
        int iO = C1173v.o(this.parameters);
        if (iO >= 0) {
            while (true) {
                HeaderValueParam headerValueParam2 = this.parameters.get(i10);
                sb2.append("; ");
                sb2.append(headerValueParam2.getName());
                sb2.append("=");
                String value = headerValueParam2.getValue();
                if (HeaderValueWithParametersKt.needQuotes(value)) {
                    sb2.append(HeaderValueWithParametersKt.quote(value));
                } else {
                    sb2.append(value);
                }
                if (i10 == iO) {
                    break;
                }
                i10++;
            }
        }
        String string = sb2.toString();
        kotlin.jvm.internal.p.f(string);
        return string;
    }

    public /* synthetic */ HeaderValueWithParameters(String str, List list, int i10, kotlin.jvm.internal.i iVar) {
        this(str, (i10 & 2) != 0 ? C1173v.m() : list);
    }
}
