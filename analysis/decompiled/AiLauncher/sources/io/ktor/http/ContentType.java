package io.ktor.http;

import Z8.C1173v;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.HeaderValueWithParameters;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 $2\u00020\u0001:\t$%&'()*+,B1\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nB)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b#\u0010\"¨\u0006-"}, d2 = {"Lio/ktor/http/ContentType;", "Lio/ktor/http/HeaderValueWithParameters;", "", "contentType", "contentSubtype", "existingContent", "", "Lio/ktor/http/HeaderValueParam;", "parameters", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "name", UxipConstants.f30680s, "withParameter", "(Ljava/lang/String;Ljava/lang/String;)Lio/ktor/http/ContentType;", "", "hasParameter", "(Ljava/lang/String;Ljava/lang/String;)Z", "withoutParameters", "()Lio/ktor/http/ContentType;", "pattern", "match", "(Lio/ktor/http/ContentType;)Z", "(Ljava/lang/String;)Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getContentType", "()Ljava/lang/String;", "getContentSubtype", "Companion", "Application", "Audio", "Image", "Message", "MultiPart", "Text", "Video", "Font", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ContentType extends HeaderValueWithParameters {
    private final String contentSubtype;
    private final String contentType;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ContentType Any = new ContentType("*", "*", null, 4, null);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b3\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u0007\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u0017\u0010\u001a\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011R\u0017\u0010\u001c\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\u0017\u0010\u001e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011R\u0017\u0010 \u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b \u0010\u000f\u001a\u0004\b!\u0010\u0011R\u0017\u0010\"\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011R\u0017\u0010$\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b$\u0010\u000f\u001a\u0004\b%\u0010\u0011R\u0017\u0010&\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b&\u0010\u000f\u001a\u0004\b'\u0010\u0011R\u0017\u0010(\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b(\u0010\u000f\u001a\u0004\b)\u0010\u0011R\u0017\u0010*\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b*\u0010\u000f\u001a\u0004\b+\u0010\u0011R\u0017\u0010,\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b,\u0010\u000f\u001a\u0004\b-\u0010\u0011R\u0017\u0010.\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b.\u0010\u000f\u001a\u0004\b/\u0010\u0011R\u0017\u00100\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b0\u0010\u000f\u001a\u0004\b1\u0010\u0011R\u0017\u00102\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b2\u0010\u000f\u001a\u0004\b3\u0010\u0011R\u0017\u00104\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b4\u0010\u000f\u001a\u0004\b5\u0010\u0011R\u0017\u00106\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b6\u0010\u000f\u001a\u0004\b7\u0010\u0011R\u0017\u00108\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b8\u0010\u000f\u001a\u0004\b9\u0010\u0011R\u0017\u0010:\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b:\u0010\u000f\u001a\u0004\b;\u0010\u0011R\u0017\u0010<\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b<\u0010\u000f\u001a\u0004\b=\u0010\u0011¨\u0006>"}, d2 = {"Lio/ktor/http/ContentType$Application;", "", "<init>", "()V", "", "contentType", "", "contains", "(Ljava/lang/CharSequence;)Z", "Lio/ktor/http/ContentType;", "(Lio/ktor/http/ContentType;)Z", "", "TYPE", "Ljava/lang/String;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Atom", "getAtom", "Cbor", "getCbor", "Json", "getJson", "HalJson", "getHalJson", "JavaScript", "getJavaScript", "OctetStream", "getOctetStream", "Rss", "getRss", "Soap", "getSoap", "Xml", "getXml", "Xml_Dtd", "getXml_Dtd", "Yaml", "getYaml", "Zip", "getZip", "GZip", "getGZip", "FormUrlEncoded", "getFormUrlEncoded", "Pdf", "getPdf", "Xlsx", "getXlsx", "Docx", "getDocx", "Pptx", "getPptx", "ProtoBuf", "getProtoBuf", "Wasm", "getWasm", "ProblemJson", "getProblemJson", "ProblemXml", "getProblemXml", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Application {
        private static final ContentType JavaScript;
        private static final ContentType ProtoBuf;
        private static final ContentType Zip;
        public static final Application INSTANCE = new Application();
        public static final String TYPE = "application";
        private static final ContentType Any = new ContentType(TYPE, "*", null, 4, null);
        private static final ContentType Atom = new ContentType(TYPE, "atom+xml", null, 4, null);
        private static final ContentType Cbor = new ContentType(TYPE, "cbor", null, 4, null);
        private static final ContentType Json = new ContentType(TYPE, "json", null, 4, null);
        private static final ContentType HalJson = new ContentType(TYPE, "hal+json", null, 4, null);
        private static final ContentType OctetStream = new ContentType(TYPE, "octet-stream", null, 4, null);
        private static final ContentType Rss = new ContentType(TYPE, "rss+xml", null, 4, null);
        private static final ContentType Soap = new ContentType(TYPE, "soap+xml", null, 4, null);
        private static final ContentType Xml = new ContentType(TYPE, "xml", null, 4, null);
        private static final ContentType Xml_Dtd = new ContentType(TYPE, "xml-dtd", null, 4, 0 == true ? 1 : 0);
        private static final ContentType Yaml = new ContentType(TYPE, "yaml", null, 4, null);
        private static final ContentType GZip = new ContentType(TYPE, "gzip", null, 4, null);
        private static final ContentType FormUrlEncoded = new ContentType(TYPE, "x-www-form-urlencoded", null, 4, null);
        private static final ContentType Pdf = new ContentType(TYPE, "pdf", null, 4, null);
        private static final ContentType Xlsx = new ContentType(TYPE, "vnd.openxmlformats-officedocument.spreadsheetml.sheet", null, 4, null);
        private static final ContentType Docx = new ContentType(TYPE, "vnd.openxmlformats-officedocument.wordprocessingml.document", null, 4, 0 == true ? 1 : 0);
        private static final ContentType Pptx = new ContentType(TYPE, "vnd.openxmlformats-officedocument.presentationml.presentation", null, 4, null);
        private static final ContentType Wasm = new ContentType(TYPE, "wasm", null, 4, null);
        private static final ContentType ProblemJson = new ContentType(TYPE, "problem+json", null, 4, null);
        private static final ContentType ProblemXml = new ContentType(TYPE, "problem+xml", null, 4, null);

        /* JADX WARN: Multi-variable type inference failed */
        static {
            kotlin.jvm.internal.i iVar = null;
            JavaScript = new ContentType(TYPE, "javascript", null, 4, iVar);
            Zip = new ContentType(TYPE, "zip", null, 4, iVar);
            ProtoBuf = new ContentType(TYPE, "protobuf", null, 4, iVar);
        }

        private Application() {
        }

        public final boolean contains(CharSequence contentType) {
            kotlin.jvm.internal.p.i(contentType, "contentType");
            return La.H.h1(contentType, "application/", true);
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getAtom() {
            return Atom;
        }

        public final ContentType getCbor() {
            return Cbor;
        }

        public final ContentType getDocx() {
            return Docx;
        }

        public final ContentType getFormUrlEncoded() {
            return FormUrlEncoded;
        }

        public final ContentType getGZip() {
            return GZip;
        }

        public final ContentType getHalJson() {
            return HalJson;
        }

        public final ContentType getJavaScript() {
            return JavaScript;
        }

        public final ContentType getJson() {
            return Json;
        }

        public final ContentType getOctetStream() {
            return OctetStream;
        }

        public final ContentType getPdf() {
            return Pdf;
        }

        public final ContentType getPptx() {
            return Pptx;
        }

        public final ContentType getProblemJson() {
            return ProblemJson;
        }

        public final ContentType getProblemXml() {
            return ProblemXml;
        }

        public final ContentType getProtoBuf() {
            return ProtoBuf;
        }

        public final ContentType getRss() {
            return Rss;
        }

        public final ContentType getSoap() {
            return Soap;
        }

        public final ContentType getWasm() {
            return Wasm;
        }

        public final ContentType getXlsx() {
            return Xlsx;
        }

        public final ContentType getXml() {
            return Xml;
        }

        public final ContentType getXml_Dtd() {
            return Xml_Dtd;
        }

        public final ContentType getYaml() {
            return Yaml;
        }

        public final ContentType getZip() {
            return Zip;
        }

        public final boolean contains(ContentType contentType) {
            kotlin.jvm.internal.p.i(contentType, "contentType");
            return contentType.match(Any);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u0007\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011¨\u0006\u0018"}, d2 = {"Lio/ktor/http/ContentType$Audio;", "", "<init>", "()V", "", "contentType", "", "contains", "(Ljava/lang/CharSequence;)Z", "Lio/ktor/http/ContentType;", "(Lio/ktor/http/ContentType;)Z", "", "TYPE", "Ljava/lang/String;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "MP4", "getMP4", "MPEG", "getMPEG", "OGG", "getOGG", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Audio {
        public static final String TYPE = "audio";
        public static final Audio INSTANCE = new Audio();
        private static final ContentType Any = new ContentType("audio", "*", null, 4, null);
        private static final ContentType MP4 = new ContentType("audio", "mp4", null, 4, null);
        private static final ContentType MPEG = new ContentType("audio", "mpeg", null, 4, null);
        private static final ContentType OGG = new ContentType("audio", "ogg", null, 4, null);

        private Audio() {
        }

        public final boolean contains(CharSequence contentType) {
            kotlin.jvm.internal.p.i(contentType, "contentType");
            return La.H.h1(contentType, "audio/", true);
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getMP4() {
            return MP4;
        }

        public final ContentType getMPEG() {
            return MPEG;
        }

        public final ContentType getOGG() {
            return OGG;
        }

        public final boolean contains(ContentType contentType) {
            kotlin.jvm.internal.p.i(contentType, "contentType");
            return contentType.match(Any);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/http/ContentType$Companion;", "", "<init>", "()V", "", UxipConstants.f30680s, "Lio/ktor/http/ContentType;", M5.e.FAIL_PARSE, "(Ljava/lang/String;)Lio/ktor/http/ContentType;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final ContentType getAny() {
            return ContentType.Any;
        }

        public final ContentType parse(String value) throws BadContentTypeFormatException {
            kotlin.jvm.internal.p.i(value, "value");
            if (La.H.x0(value)) {
                return getAny();
            }
            HeaderValueWithParameters.Companion companion = HeaderValueWithParameters.INSTANCE;
            HeaderValue headerValue = (HeaderValue) Z8.F.C0(HttpHeaderValueParserKt.parseHeaderValue(value));
            String value2 = headerValue.getValue();
            List<HeaderValueParam> params = headerValue.getParams();
            int iT0 = La.H.t0(value2, JsonPointer.SEPARATOR, 0, false, 6, null);
            if (iT0 == -1) {
                if (kotlin.jvm.internal.p.d(La.H.D1(value2).toString(), "*")) {
                    return ContentType.INSTANCE.getAny();
                }
                throw new BadContentTypeFormatException(value);
            }
            String strSubstring = value2.substring(0, iT0);
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            String string = La.H.D1(strSubstring).toString();
            if (string.length() == 0) {
                throw new BadContentTypeFormatException(value);
            }
            String strSubstring2 = value2.substring(iT0 + 1);
            kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
            String string2 = La.H.D1(strSubstring2).toString();
            if (La.H.f0(string, ' ', false, 2, null) || La.H.f0(string2, ' ', false, 2, null)) {
                throw new BadContentTypeFormatException(value);
            }
            if (string2.length() == 0 || La.H.f0(string2, JsonPointer.SEPARATOR, false, 2, null)) {
                throw new BadContentTypeFormatException(value);
            }
            return new ContentType(string, string2, params);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u0007\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u0017\u0010\u001a\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011R\u0017\u0010\u001c\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011¨\u0006\u001e"}, d2 = {"Lio/ktor/http/ContentType$Font;", "", "<init>", "()V", "", "contentType", "", "contains", "(Ljava/lang/CharSequence;)Z", "Lio/ktor/http/ContentType;", "(Lio/ktor/http/ContentType;)Z", "", "TYPE", "Ljava/lang/String;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", CoreUtil.STR_DEX_COLLECTION_NAME, "getCollection", "Otf", "getOtf", "Sfnt", "getSfnt", "Ttf", "getTtf", "Woff", "getWoff", "Woff2", "getWoff2", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Font {
        public static final Font INSTANCE = new Font();
        public static final String TYPE = "font";
        private static final ContentType Any = new ContentType(TYPE, "*", null, 4, null);
        private static final ContentType Collection = new ContentType(TYPE, "collection", null, 4, null);
        private static final ContentType Otf = new ContentType(TYPE, "otf", null, 4, null);
        private static final ContentType Sfnt = new ContentType(TYPE, "sfnt", null, 4, null);
        private static final ContentType Ttf = new ContentType(TYPE, "ttf", null, 4, null);
        private static final ContentType Woff = new ContentType(TYPE, "woff", null, 4, null);
        private static final ContentType Woff2 = new ContentType(TYPE, "woff2", null, 4, null);

        private Font() {
        }

        public final boolean contains(CharSequence contentType) {
            kotlin.jvm.internal.p.i(contentType, "contentType");
            return La.H.h1(contentType, "font/", true);
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getCollection() {
            return Collection;
        }

        public final ContentType getOtf() {
            return Otf;
        }

        public final ContentType getSfnt() {
            return Sfnt;
        }

        public final ContentType getTtf() {
            return Ttf;
        }

        public final ContentType getWoff() {
            return Woff;
        }

        public final ContentType getWoff2() {
            return Woff2;
        }

        public final boolean contains(ContentType contentType) {
            kotlin.jvm.internal.p.i(contentType, "contentType");
            return contentType.match(Any);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u0007\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u0017\u0010\u001a\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011R\u0017\u0010\u001c\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\u0017\u0010\u001e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011R\u0017\u0010 \u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b \u0010\u000f\u001a\u0004\b!\u0010\u0011R\u0017\u0010\"\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011R\u0017\u0010$\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b$\u0010\u000f\u001a\u0004\b%\u0010\u0011R\u0017\u0010&\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b&\u0010\u000f\u001a\u0004\b'\u0010\u0011R\u0017\u0010(\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b(\u0010\u000f\u001a\u0004\b)\u0010\u0011R\u0017\u0010*\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b*\u0010\u000f\u001a\u0004\b+\u0010\u0011¨\u0006,"}, d2 = {"Lio/ktor/http/ContentType$Image;", "", "<init>", "()V", "", "contentSubtype", "", "contains", "(Ljava/lang/String;)Z", "Lio/ktor/http/ContentType;", "contentType", "(Lio/ktor/http/ContentType;)Z", "TYPE", "Ljava/lang/String;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "APNG", "getAPNG", "AVIF", "getAVIF", "BMP", "getBMP", "GIF", "getGIF", "HEIC", "getHEIC", "HEIF", "getHEIF", "JPEG", "getJPEG", "JXL", "getJXL", "PNG", "getPNG", "SVG", "getSVG", "TIFF", "getTIFF", "WEBP", "getWEBP", "XIcon", "getXIcon", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Image {
        private static final ContentType HEIC;
        public static final String TYPE = "image";
        private static final ContentType WEBP;
        public static final Image INSTANCE = new Image();
        private static final ContentType Any = new ContentType("image", "*", null, 4, null);
        private static final ContentType APNG = new ContentType("image", "apng", null, 4, null);
        private static final ContentType AVIF = new ContentType("image", "avif", null, 4, null);
        private static final ContentType BMP = new ContentType("image", "bmp", null, 4, null);
        private static final ContentType GIF = new ContentType("image", "gif", null, 4, null);
        private static final ContentType HEIF = new ContentType("image", "heif", null, 4, null);
        private static final ContentType JPEG = new ContentType("image", "jpeg", null, 4, null);
        private static final ContentType JXL = new ContentType("image", "jxl", null, 4, null);
        private static final ContentType PNG = new ContentType("image", "png", null, 4, null);
        private static final ContentType SVG = new ContentType("image", "svg+xml", null, 4, 0 == true ? 1 : 0);
        private static final ContentType TIFF = new ContentType("image", "tiff", null, 4, null);
        private static final ContentType XIcon = new ContentType("image", "x-icon", null, 4, null);

        /* JADX WARN: Multi-variable type inference failed */
        static {
            kotlin.jvm.internal.i iVar = null;
            HEIC = new ContentType("image", "heic", null, 4, iVar);
            WEBP = new ContentType("image", "webp", null, 4, iVar);
        }

        private Image() {
        }

        public final boolean contains(String contentSubtype) {
            kotlin.jvm.internal.p.i(contentSubtype, "contentSubtype");
            return La.D.V(contentSubtype, "image/", true);
        }

        public final ContentType getAPNG() {
            return APNG;
        }

        public final ContentType getAVIF() {
            return AVIF;
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getBMP() {
            return BMP;
        }

        public final ContentType getGIF() {
            return GIF;
        }

        public final ContentType getHEIC() {
            return HEIC;
        }

        public final ContentType getHEIF() {
            return HEIF;
        }

        public final ContentType getJPEG() {
            return JPEG;
        }

        public final ContentType getJXL() {
            return JXL;
        }

        public final ContentType getPNG() {
            return PNG;
        }

        public final ContentType getSVG() {
            return SVG;
        }

        public final ContentType getTIFF() {
            return TIFF;
        }

        public final ContentType getWEBP() {
            return WEBP;
        }

        public final ContentType getXIcon() {
            return XIcon;
        }

        public final boolean contains(ContentType contentType) {
            kotlin.jvm.internal.p.i(contentType, "contentType");
            return contentType.match(Any);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u0007\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lio/ktor/http/ContentType$Message;", "", "<init>", "()V", "", "contentSubtype", "", "contains", "(Ljava/lang/String;)Z", "Lio/ktor/http/ContentType;", "contentType", "(Lio/ktor/http/ContentType;)Z", "TYPE", "Ljava/lang/String;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Http", "getHttp", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Message {
        public static final String TYPE = "message";
        public static final Message INSTANCE = new Message();
        private static final ContentType Any = new ContentType("message", "*", null, 4, null);
        private static final ContentType Http = new ContentType("message", "http", null, 4, null);

        private Message() {
        }

        public final boolean contains(String contentSubtype) {
            kotlin.jvm.internal.p.i(contentSubtype, "contentSubtype");
            return La.D.V(contentSubtype, "message/", true);
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getHttp() {
            return Http;
        }

        public final boolean contains(ContentType contentType) {
            kotlin.jvm.internal.p.i(contentType, "contentType");
            return contentType.match(Any);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u0007\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u0017\u0010\u001a\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011R\u0017\u0010\u001c\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\u0017\u0010\u001e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011¨\u0006 "}, d2 = {"Lio/ktor/http/ContentType$MultiPart;", "", "<init>", "()V", "", "contentType", "", "contains", "(Ljava/lang/CharSequence;)Z", "Lio/ktor/http/ContentType;", "(Lio/ktor/http/ContentType;)Z", "", "TYPE", "Ljava/lang/String;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Mixed", "getMixed", "Alternative", "getAlternative", "Related", "getRelated", "FormData", "getFormData", "Signed", "getSigned", "Encrypted", "getEncrypted", "ByteRanges", "getByteRanges", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class MultiPart {
        public static final MultiPart INSTANCE = new MultiPart();
        public static final String TYPE = "multipart";
        private static final ContentType Any = new ContentType(TYPE, "*", null, 4, null);
        private static final ContentType Mixed = new ContentType(TYPE, "mixed", null, 4, null);
        private static final ContentType Alternative = new ContentType(TYPE, "alternative", null, 4, null);
        private static final ContentType Related = new ContentType(TYPE, "related", null, 4, null);
        private static final ContentType FormData = new ContentType(TYPE, "form-data", null, 4, null);
        private static final ContentType Signed = new ContentType(TYPE, "signed", null, 4, null);
        private static final ContentType Encrypted = new ContentType(TYPE, "encrypted", null, 4, null);
        private static final ContentType ByteRanges = new ContentType(TYPE, "byteranges", null, 4, null);

        private MultiPart() {
        }

        public final boolean contains(CharSequence contentType) {
            kotlin.jvm.internal.p.i(contentType, "contentType");
            return La.H.h1(contentType, "multipart/", true);
        }

        public final ContentType getAlternative() {
            return Alternative;
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getByteRanges() {
            return ByteRanges;
        }

        public final ContentType getEncrypted() {
            return Encrypted;
        }

        public final ContentType getFormData() {
            return FormData;
        }

        public final ContentType getMixed() {
            return Mixed;
        }

        public final ContentType getRelated() {
            return Related;
        }

        public final ContentType getSigned() {
            return Signed;
        }

        public final boolean contains(ContentType contentType) {
            kotlin.jvm.internal.p.i(contentType, "contentType");
            return contentType.match(Any);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u0007\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u0017\u0010\u001a\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011R\u0017\u0010\u001c\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\u0017\u0010\u001e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011R\u0017\u0010 \u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b \u0010\u000f\u001a\u0004\b!\u0010\u0011¨\u0006\""}, d2 = {"Lio/ktor/http/ContentType$Text;", "", "<init>", "()V", "", "contentType", "", "contains", "(Ljava/lang/CharSequence;)Z", "Lio/ktor/http/ContentType;", "(Lio/ktor/http/ContentType;)Z", "", "TYPE", "Ljava/lang/String;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Plain", "getPlain", "CSS", "getCSS", "CSV", "getCSV", "Html", "getHtml", "JavaScript", "getJavaScript", "VCard", "getVCard", "Xml", "getXml", "EventStream", "getEventStream", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Text {
        public static final String TYPE = "text";
        public static final Text INSTANCE = new Text();
        private static final ContentType Any = new ContentType("text", "*", null, 4, null);
        private static final ContentType Plain = new ContentType("text", "plain", null, 4, null);
        private static final ContentType CSS = new ContentType("text", "css", null, 4, null);
        private static final ContentType CSV = new ContentType("text", "csv", null, 4, null);
        private static final ContentType Html = new ContentType("text", "html", null, 4, null);
        private static final ContentType JavaScript = new ContentType("text", "javascript", null, 4, null);
        private static final ContentType VCard = new ContentType("text", "vcard", null, 4, null);
        private static final ContentType Xml = new ContentType("text", "xml", null, 4, null);
        private static final ContentType EventStream = new ContentType("text", "event-stream", null, 4, null);

        private Text() {
        }

        public final boolean contains(CharSequence contentType) {
            kotlin.jvm.internal.p.i(contentType, "contentType");
            return La.H.h1(contentType, "text/", true);
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getCSS() {
            return CSS;
        }

        public final ContentType getCSV() {
            return CSV;
        }

        public final ContentType getEventStream() {
            return EventStream;
        }

        public final ContentType getHtml() {
            return Html;
        }

        public final ContentType getJavaScript() {
            return JavaScript;
        }

        public final ContentType getPlain() {
            return Plain;
        }

        public final ContentType getVCard() {
            return VCard;
        }

        public final ContentType getXml() {
            return Xml;
        }

        public final boolean contains(ContentType contentType) {
            kotlin.jvm.internal.p.i(contentType, "contentType");
            return contentType.match(Any);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u0007\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011¨\u0006\u001a"}, d2 = {"Lio/ktor/http/ContentType$Video;", "", "<init>", "()V", "", "contentType", "", "contains", "(Ljava/lang/CharSequence;)Z", "Lio/ktor/http/ContentType;", "(Lio/ktor/http/ContentType;)Z", "", "TYPE", "Ljava/lang/String;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "MPEG", "getMPEG", "MP4", "getMP4", "OGG", "getOGG", "QuickTime", "getQuickTime", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Video {
        public static final String TYPE = "video";
        public static final Video INSTANCE = new Video();
        private static final ContentType Any = new ContentType("video", "*", null, 4, null);
        private static final ContentType MPEG = new ContentType("video", "mpeg", null, 4, null);
        private static final ContentType MP4 = new ContentType("video", "mp4", null, 4, null);
        private static final ContentType OGG = new ContentType("video", "ogg", null, 4, null);
        private static final ContentType QuickTime = new ContentType("video", "quicktime", null, 4, null);

        private Video() {
        }

        public final boolean contains(CharSequence contentType) {
            kotlin.jvm.internal.p.i(contentType, "contentType");
            return La.H.h1(contentType, "video/", true);
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getMP4() {
            return MP4;
        }

        public final ContentType getMPEG() {
            return MPEG;
        }

        public final ContentType getOGG() {
            return OGG;
        }

        public final ContentType getQuickTime() {
            return QuickTime;
        }

        public final boolean contains(ContentType contentType) {
            kotlin.jvm.internal.p.i(contentType, "contentType");
            return contentType.match(Any);
        }
    }

    public /* synthetic */ ContentType(String str, String str2, String str3, List list, int i10, kotlin.jvm.internal.i iVar) {
        this(str, str2, str3, (i10 & 8) != 0 ? C1173v.m() : list);
    }

    private final boolean hasParameter(String name, String value) {
        int size = getParameters().size();
        if (size != 0) {
            if (size != 1) {
                List<HeaderValueParam> parameters = getParameters();
                if ((parameters instanceof Collection) && parameters.isEmpty()) {
                    return false;
                }
                for (HeaderValueParam headerValueParam : parameters) {
                    if (La.D.L(headerValueParam.getName(), name, true) && La.D.L(headerValueParam.getValue(), value, true)) {
                        return true;
                    }
                }
                return false;
            }
            HeaderValueParam headerValueParam2 = getParameters().get(0);
            if (La.D.L(headerValueParam2.getName(), name, true) && La.D.L(headerValueParam2.getValue(), value, true)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object other) {
        if (!(other instanceof ContentType)) {
            return false;
        }
        ContentType contentType = (ContentType) other;
        return La.D.L(this.contentType, contentType.contentType, true) && La.D.L(this.contentSubtype, contentType.contentSubtype, true) && kotlin.jvm.internal.p.d(getParameters(), contentType.getParameters());
    }

    public final String getContentSubtype() {
        return this.contentSubtype;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public int hashCode() {
        String str = this.contentType;
        Locale locale = Locale.ROOT;
        String lowerCase = str.toLowerCase(locale);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        int iHashCode = lowerCase.hashCode();
        String lowerCase2 = this.contentSubtype.toLowerCase(locale);
        kotlin.jvm.internal.p.h(lowerCase2, "toLowerCase(...)");
        return iHashCode + (iHashCode * 31) + lowerCase2.hashCode() + (getParameters().hashCode() * 31);
    }

    public final boolean match(ContentType pattern) {
        boolean zL;
        kotlin.jvm.internal.p.i(pattern, "pattern");
        if (!kotlin.jvm.internal.p.d(pattern.contentType, "*") && !La.D.L(pattern.contentType, this.contentType, true)) {
            return false;
        }
        if (!kotlin.jvm.internal.p.d(pattern.contentSubtype, "*") && !La.D.L(pattern.contentSubtype, this.contentSubtype, true)) {
            return false;
        }
        for (HeaderValueParam headerValueParam : pattern.getParameters()) {
            String name = headerValueParam.getName();
            String value = headerValueParam.getValue();
            if (kotlin.jvm.internal.p.d(name, "*")) {
                if (!kotlin.jvm.internal.p.d(value, "*")) {
                    List<HeaderValueParam> parameters = getParameters();
                    if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                        Iterator<T> it = parameters.iterator();
                        while (it.hasNext()) {
                            if (La.D.L(((HeaderValueParam) it.next()).getValue(), value, true)) {
                            }
                        }
                    }
                    zL = false;
                }
                zL = true;
                break;
            }
            String strParameter = parameter(name);
            if (!kotlin.jvm.internal.p.d(value, "*")) {
                zL = La.D.L(strParameter, value, true);
            } else {
                if (strParameter != null) {
                    zL = true;
                    break;
                    break;
                }
                zL = false;
            }
            if (!zL) {
                return false;
            }
        }
        return true;
    }

    public final ContentType withParameter(String name, String value) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(value, "value");
        return hasParameter(name, value) ? this : new ContentType(this.contentType, this.contentSubtype, getContent(), Z8.F.T0(getParameters(), new HeaderValueParam(name, value)));
    }

    public final ContentType withoutParameters() {
        if (getParameters().isEmpty()) {
            return this;
        }
        return new ContentType(this.contentType, this.contentSubtype, null, 4, null);
    }

    private ContentType(String str, String str2, String str3, List<HeaderValueParam> list) {
        super(str3, list);
        this.contentType = str;
        this.contentSubtype = str2;
    }

    public /* synthetic */ ContentType(String str, String str2, List list, int i10, kotlin.jvm.internal.i iVar) {
        this(str, str2, (i10 & 4) != 0 ? C1173v.m() : list);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContentType(String contentType, String contentSubtype, List<HeaderValueParam> parameters) {
        this(contentType, contentSubtype, contentType + JsonPointer.SEPARATOR + contentSubtype, parameters);
        kotlin.jvm.internal.p.i(contentType, "contentType");
        kotlin.jvm.internal.p.i(contentSubtype, "contentSubtype");
        kotlin.jvm.internal.p.i(parameters, "parameters");
    }

    public final boolean match(String pattern) {
        kotlin.jvm.internal.p.i(pattern, "pattern");
        return match(INSTANCE.parse(pattern));
    }
}
