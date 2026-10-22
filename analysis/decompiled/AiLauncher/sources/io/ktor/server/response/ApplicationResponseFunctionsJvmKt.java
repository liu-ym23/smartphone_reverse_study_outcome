package io.ktor.server.response;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import io.ktor.http.ContentType;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.OutputStreamContent;
import io.ktor.http.content.WriterContent;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.http.content.LocalFileContent;
import io.ktor.server.http.content.LocalFileContentKt;
import io.ktor.server.http.content.LocalPathContent;
import io.ktor.util.reflect.TypeInfo;
import java.io.File;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\u001aP\u0010\u000b\u001a\u00020\b*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005H\u0086@¢\u0006\u0004\b\u000b\u0010\f\u001aP\u0010\u000f\u001a\u00020\b*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005H\u0086@¢\u0006\u0004\b\u000f\u0010\f\u001a:\u0010\u0017\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014H\u0086@¢\u0006\u0004\b\u0017\u0010\u0018\u001a:\u0010\u001b\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014H\u0086@¢\u0006\u0004\b\u001b\u0010\u001c\u001a2\u0010\u0017\u001a\u00020\b*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00102\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014H\u0086@¢\u0006\u0004\b\u0017\u0010\u001e\u001a2\u0010\u001b\u001a\u00020\b*\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00192\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014H\u0086@¢\u0006\u0004\b\u001b\u0010 \u001a\\\u0010\u000b\u001a\u00020\b*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005H\u0086@¢\u0006\u0004\b\u000b\u0010#\u001a\\\u0010\u000f\u001a\u00020\b*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005H\u0086@¢\u0006\u0004\b\u000f\u0010#¨\u0006$"}, d2 = {"Lio/ktor/server/application/ApplicationCall;", "Lio/ktor/http/ContentType;", "contentType", "Lio/ktor/http/HttpStatusCode;", "status", "Lkotlin/Function2;", "Ljava/io/Writer;", "Le9/c;", "LY8/t;", "", "writer", "respondTextWriter", "(Lio/ktor/server/application/ApplicationCall;Lio/ktor/http/ContentType;Lio/ktor/http/HttpStatusCode;Lp9/p;Le9/c;)Ljava/lang/Object;", "Ljava/io/OutputStream;", "producer", "respondOutputStream", "Ljava/io/File;", "baseDir", "", "fileName", "Lkotlin/Function1;", "Lio/ktor/http/content/OutgoingContent;", "configure", "respondFile", "(Lio/ktor/server/application/ApplicationCall;Ljava/io/File;Ljava/lang/String;Lp9/l;Le9/c;)Ljava/lang/Object;", "Ljava/nio/file/Path;", "relativePath", "respondPath", "(Lio/ktor/server/application/ApplicationCall;Ljava/nio/file/Path;Ljava/nio/file/Path;Lp9/l;Le9/c;)Ljava/lang/Object;", Const.STR_FILE, "(Lio/ktor/server/application/ApplicationCall;Ljava/io/File;Lp9/l;Le9/c;)Ljava/lang/Object;", "path", "(Lio/ktor/server/application/ApplicationCall;Ljava/nio/file/Path;Lp9/l;Le9/c;)Ljava/lang/Object;", "", "contentLength", "(Lio/ktor/server/application/ApplicationCall;Lio/ktor/http/ContentType;Lio/ktor/http/HttpStatusCode;Ljava/lang/Long;Lp9/p;Le9/c;)Ljava/lang/Object;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApplicationResponseFunctionsJvmKt {
    public static final Object respondFile(ApplicationCall applicationCall, File file, String str, InterfaceC5074l<? super OutgoingContent, t> interfaceC5074l, InterfaceC4014c<? super t> interfaceC4014c) {
        InterfaceC5755n interfaceC5755nM = null;
        LocalFileContent localFileContentLocalFileContent$default = LocalFileContentKt.LocalFileContent$default(file, str, (ContentType) null, 4, (Object) null);
        interfaceC5074l.invoke(localFileContentLocalFileContent$default);
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(LocalFileContent.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(LocalFileContent.class);
        } catch (Throwable unused) {
        }
        Object objRespond = applicationCall.respond(localFileContentLocalFileContent$default, new TypeInfo(interfaceC5745dB, interfaceC5755nM), interfaceC4014c);
        return objRespond == C4063a.g() ? objRespond : t.f7040a;
    }

    public static /* synthetic */ Object respondFile$default(ApplicationCall applicationCall, File file, String str, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.response.d
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return ApplicationResponseFunctionsJvmKt.respondFile$lambda$0((OutgoingContent) obj2);
                }
            };
        }
        return respondFile(applicationCall, file, str, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t respondFile$lambda$0(OutgoingContent outgoingContent) {
        p.i(outgoingContent, "<this>");
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t respondFile$lambda$2(OutgoingContent outgoingContent) {
        p.i(outgoingContent, "<this>");
        return t.f7040a;
    }

    public static final Object respondOutputStream(ApplicationCall applicationCall, ContentType contentType, HttpStatusCode httpStatusCode, p9.p<? super OutputStream, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super t> interfaceC4014c) {
        InterfaceC5755n interfaceC5755nM;
        if (contentType == null) {
            contentType = ContentType.Application.INSTANCE.getOctetStream();
        }
        OutputStreamContent outputStreamContent = new OutputStreamContent(pVar, contentType, httpStatusCode, null, 8, null);
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(OutputStreamContent.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(OutputStreamContent.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        Object objRespond = applicationCall.respond(outputStreamContent, new TypeInfo(interfaceC5745dB, interfaceC5755nM), interfaceC4014c);
        return objRespond == C4063a.g() ? objRespond : t.f7040a;
    }

    public static /* synthetic */ Object respondOutputStream$default(ApplicationCall applicationCall, ContentType contentType, HttpStatusCode httpStatusCode, p9.p pVar, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            contentType = null;
        }
        if ((i10 & 2) != 0) {
            httpStatusCode = null;
        }
        return respondOutputStream(applicationCall, contentType, httpStatusCode, pVar, interfaceC4014c);
    }

    public static final Object respondPath(ApplicationCall applicationCall, Path path, Path path2, InterfaceC5074l<? super OutgoingContent, t> interfaceC5074l, InterfaceC4014c<? super t> interfaceC4014c) {
        InterfaceC5755n interfaceC5755nM = null;
        LocalPathContent localPathContentLocalPathContent$default = LocalFileContentKt.LocalPathContent$default(path, path2, null, 4, null);
        interfaceC5074l.invoke(localPathContentLocalPathContent$default);
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(LocalPathContent.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(LocalPathContent.class);
        } catch (Throwable unused) {
        }
        Object objRespond = applicationCall.respond(localPathContentLocalPathContent$default, new TypeInfo(interfaceC5745dB, interfaceC5755nM), interfaceC4014c);
        return objRespond == C4063a.g() ? objRespond : t.f7040a;
    }

    public static /* synthetic */ Object respondPath$default(ApplicationCall applicationCall, Path path, Path path2, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.response.b
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return ApplicationResponseFunctionsJvmKt.respondPath$lambda$1((OutgoingContent) obj2);
                }
            };
        }
        return respondPath(applicationCall, path, path2, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t respondPath$lambda$1(OutgoingContent outgoingContent) {
        p.i(outgoingContent, "<this>");
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t respondPath$lambda$3(OutgoingContent outgoingContent) {
        p.i(outgoingContent, "<this>");
        return t.f7040a;
    }

    public static final Object respondTextWriter(ApplicationCall applicationCall, ContentType contentType, HttpStatusCode httpStatusCode, p9.p<? super Writer, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super t> interfaceC4014c) {
        InterfaceC5755n interfaceC5755nM;
        WriterContent writerContent = new WriterContent(pVar, ApplicationResponseFunctionsKt.defaultTextContentType(applicationCall, contentType), httpStatusCode, null, 8, null);
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(WriterContent.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(WriterContent.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        Object objRespond = applicationCall.respond(writerContent, new TypeInfo(interfaceC5745dB, interfaceC5755nM), interfaceC4014c);
        return objRespond == C4063a.g() ? objRespond : t.f7040a;
    }

    public static /* synthetic */ Object respondTextWriter$default(ApplicationCall applicationCall, ContentType contentType, HttpStatusCode httpStatusCode, p9.p pVar, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            contentType = null;
        }
        if ((i10 & 2) != 0) {
            httpStatusCode = null;
        }
        return respondTextWriter(applicationCall, contentType, httpStatusCode, pVar, interfaceC4014c);
    }

    public static /* synthetic */ Object respondOutputStream$default(ApplicationCall applicationCall, ContentType contentType, HttpStatusCode httpStatusCode, Long l10, p9.p pVar, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            contentType = null;
        }
        if ((i10 & 2) != 0) {
            httpStatusCode = null;
        }
        if ((i10 & 4) != 0) {
            l10 = null;
        }
        return respondOutputStream(applicationCall, contentType, httpStatusCode, l10, pVar, interfaceC4014c);
    }

    public static /* synthetic */ Object respondTextWriter$default(ApplicationCall applicationCall, ContentType contentType, HttpStatusCode httpStatusCode, Long l10, p9.p pVar, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            contentType = null;
        }
        if ((i10 & 2) != 0) {
            httpStatusCode = null;
        }
        if ((i10 & 4) != 0) {
            l10 = null;
        }
        return respondTextWriter(applicationCall, contentType, httpStatusCode, l10, pVar, interfaceC4014c);
    }

    public static /* synthetic */ Object respondFile$default(ApplicationCall applicationCall, File file, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.response.a
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return ApplicationResponseFunctionsJvmKt.respondFile$lambda$2((OutgoingContent) obj2);
                }
            };
        }
        return respondFile(applicationCall, file, interfaceC5074l, interfaceC4014c);
    }

    public static /* synthetic */ Object respondPath$default(ApplicationCall applicationCall, Path path, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.response.c
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return ApplicationResponseFunctionsJvmKt.respondPath$lambda$3((OutgoingContent) obj2);
                }
            };
        }
        return respondPath(applicationCall, path, interfaceC5074l, interfaceC4014c);
    }

    public static final Object respondFile(ApplicationCall applicationCall, File file, InterfaceC5074l<? super OutgoingContent, t> interfaceC5074l, InterfaceC4014c<? super t> interfaceC4014c) {
        InterfaceC5755n interfaceC5755nM = null;
        LocalFileContent localFileContent = new LocalFileContent(file, null, 2, null);
        interfaceC5074l.invoke(localFileContent);
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(LocalFileContent.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(LocalFileContent.class);
        } catch (Throwable unused) {
        }
        Object objRespond = applicationCall.respond(localFileContent, new TypeInfo(interfaceC5745dB, interfaceC5755nM), interfaceC4014c);
        return objRespond == C4063a.g() ? objRespond : t.f7040a;
    }

    public static final Object respondOutputStream(ApplicationCall applicationCall, ContentType contentType, HttpStatusCode httpStatusCode, Long l10, p9.p<? super OutputStream, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super t> interfaceC4014c) {
        InterfaceC5755n interfaceC5755nM;
        if (contentType == null) {
            contentType = ContentType.Application.INSTANCE.getOctetStream();
        }
        OutputStreamContent outputStreamContent = new OutputStreamContent(pVar, contentType, httpStatusCode, l10);
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(OutputStreamContent.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(OutputStreamContent.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        Object objRespond = applicationCall.respond(outputStreamContent, new TypeInfo(interfaceC5745dB, interfaceC5755nM), interfaceC4014c);
        return objRespond == C4063a.g() ? objRespond : t.f7040a;
    }

    public static final Object respondPath(ApplicationCall applicationCall, Path path, InterfaceC5074l<? super OutgoingContent, t> interfaceC5074l, InterfaceC4014c<? super t> interfaceC4014c) {
        InterfaceC5755n interfaceC5755nM = null;
        LocalPathContent localPathContent = new LocalPathContent(path, null, 2, null);
        interfaceC5074l.invoke(localPathContent);
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(LocalPathContent.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(LocalPathContent.class);
        } catch (Throwable unused) {
        }
        Object objRespond = applicationCall.respond(localPathContent, new TypeInfo(interfaceC5745dB, interfaceC5755nM), interfaceC4014c);
        return objRespond == C4063a.g() ? objRespond : t.f7040a;
    }

    public static final Object respondTextWriter(ApplicationCall applicationCall, ContentType contentType, HttpStatusCode httpStatusCode, Long l10, p9.p<? super Writer, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super t> interfaceC4014c) {
        InterfaceC5755n interfaceC5755nM;
        WriterContent writerContent = new WriterContent(pVar, ApplicationResponseFunctionsKt.defaultTextContentType(applicationCall, contentType), httpStatusCode, l10);
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(WriterContent.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(WriterContent.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        Object objRespond = applicationCall.respond(writerContent, new TypeInfo(interfaceC5745dB, interfaceC5755nM), interfaceC4014c);
        return objRespond == C4063a.g() ? objRespond : t.f7040a;
    }
}
