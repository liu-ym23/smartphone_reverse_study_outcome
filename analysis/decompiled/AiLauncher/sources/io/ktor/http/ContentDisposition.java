package io.ktor.http;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.HeaderValueWithParameters;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\r\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0010\u001a\u00020\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0003\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001a¨\u0006\u001f"}, d2 = {"Lio/ktor/http/ContentDisposition;", "Lio/ktor/http/HeaderValueWithParameters;", "", "disposition", "", "Lio/ktor/http/HeaderValueParam;", "parameters", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "key", UxipConstants.f30680s, "", "encodeValue", "withParameter", "(Ljava/lang/String;Ljava/lang/String;Z)Lio/ktor/http/ContentDisposition;", "newParameters", "withParameters", "(Ljava/util/List;)Lio/ktor/http/ContentDisposition;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "getDisposition", "()Ljava/lang/String;", "getName", "name", "Companion", "Parameters", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ContentDisposition extends HeaderValueWithParameters {
    private static final ContentDisposition Attachment;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ContentDisposition File;
    private static final ContentDisposition Inline;
    private static final ContentDisposition Mixed;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lio/ktor/http/ContentDisposition$Companion;", "", "<init>", "()V", "", UxipConstants.f30680s, "Lio/ktor/http/ContentDisposition;", M5.e.FAIL_PARSE, "(Ljava/lang/String;)Lio/ktor/http/ContentDisposition;", "File", "Lio/ktor/http/ContentDisposition;", "getFile", "()Lio/ktor/http/ContentDisposition;", "Mixed", "getMixed", "Attachment", "getAttachment", "Inline", "getInline", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final ContentDisposition getAttachment() {
            return ContentDisposition.Attachment;
        }

        public final ContentDisposition getFile() {
            return ContentDisposition.File;
        }

        public final ContentDisposition getInline() {
            return ContentDisposition.Inline;
        }

        public final ContentDisposition getMixed() {
            return ContentDisposition.Mixed;
        }

        public final ContentDisposition parse(String value) {
            kotlin.jvm.internal.p.i(value, "value");
            HeaderValueWithParameters.Companion companion = HeaderValueWithParameters.INSTANCE;
            HeaderValue headerValue = (HeaderValue) Z8.F.C0(HttpHeaderValueParserKt.parseHeaderValue(value));
            return new ContentDisposition(headerValue.getValue(), headerValue.getParams());
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"Lio/ktor/http/ContentDisposition$Parameters;", "", "<init>", "()V", "", "FileName", "Ljava/lang/String;", "FileNameAsterisk", "Name", "CreationDate", "ModificationDate", "ReadDate", "Size", "Handling", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Parameters {
        public static final String CreationDate = "creation-date";
        public static final String FileName = "filename";
        public static final String FileNameAsterisk = "filename*";
        public static final String Handling = "handling";
        public static final Parameters INSTANCE = new Parameters();
        public static final String ModificationDate = "modification-date";
        public static final String Name = "name";
        public static final String ReadDate = "read-date";
        public static final String Size = "size";

        private Parameters() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i10 = 2;
        File = new ContentDisposition(Const.STR_FILE, 0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
        Mixed = new ContentDisposition("mixed", 0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
        Attachment = new ContentDisposition("attachment", 0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
        Inline = new ContentDisposition("inline", 0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
    }

    public /* synthetic */ ContentDisposition(String str, List list, int i10, kotlin.jvm.internal.i iVar) {
        this(str, (i10 & 2) != 0 ? C1173v.m() : list);
    }

    public static /* synthetic */ ContentDisposition withParameter$default(ContentDisposition contentDisposition, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        return contentDisposition.withParameter(str, str2, z10);
    }

    public boolean equals(Object other) {
        if (!(other instanceof ContentDisposition)) {
            return false;
        }
        ContentDisposition contentDisposition = (ContentDisposition) other;
        return kotlin.jvm.internal.p.d(getDisposition(), contentDisposition.getDisposition()) && kotlin.jvm.internal.p.d(getParameters(), contentDisposition.getParameters());
    }

    public final String getDisposition() {
        return getContent();
    }

    public final String getName() {
        return parameter("name");
    }

    public int hashCode() {
        return (getDisposition().hashCode() * 31) + getParameters().hashCode();
    }

    public final ContentDisposition withParameter(String key, String value, boolean encodeValue) {
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(value, "value");
        if (encodeValue) {
            value = ContentDispositionKt.encodeContentDispositionAttribute(key, value);
        }
        return new ContentDisposition(getDisposition(), Z8.F.T0(getParameters(), new HeaderValueParam(key, value)));
    }

    public final ContentDisposition withParameters(List<HeaderValueParam> newParameters) {
        kotlin.jvm.internal.p.i(newParameters, "newParameters");
        return new ContentDisposition(getDisposition(), Z8.F.S0(getParameters(), newParameters));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentDisposition(String disposition, List<HeaderValueParam> parameters) {
        super(disposition, parameters);
        kotlin.jvm.internal.p.i(disposition, "disposition");
        kotlin.jvm.internal.p.i(parameters, "parameters");
    }
}
