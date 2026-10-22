package io.ktor.server.http.content;

import Z8.C1175x;
import com.fasterxml.jackson.core.JsonPointer;
import io.ktor.http.CodecsKt;
import io.ktor.http.ContentType;
import io.ktor.http.FileContentTypeKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.server.application.Application;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.plugins.BadRequestException;
import io.ktor.server.util.PathsKt;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aG\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000b\u001aS\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e*\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0006H\u0000¢\u0006\u0004\b\n\u0010\u000f\u001a5\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0013\u0010\u0016\u001a\u00020\u0001*\u00020\u0001H\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a!\u0010\u0018\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\"'\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lio/ktor/server/application/ApplicationCall;", "", "path", "resourcePackage", "Ljava/lang/ClassLoader;", "classLoader", "Lkotlin/Function1;", "Lio/ktor/http/ContentType;", "mimeResolve", "Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "resolveResource", "(Lio/ktor/server/application/ApplicationCall;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;Lp9/l;)Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "Lio/ktor/server/application/Application;", "Ljava/net/URL;", "Lkotlin/Pair;", "(Lio/ktor/server/application/Application;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;Lp9/l;)Lkotlin/Pair;", "url", "resourceClasspathResource", "(Ljava/net/URL;Ljava/lang/String;Lp9/l;)Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "Ljava/io/File;", "findContainingJarFile", "(Ljava/lang/String;)Ljava/io/File;", "extension", "(Ljava/lang/String;)Ljava/lang/String;", "normalisedPath", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "resourceCache$delegate", "LY8/h;", "getResourceCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "resourceCache", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StaticContentResolutionKt {
    private static final Y8.h resourceCache$delegate = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.server.http.content.K
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return StaticContentResolutionKt.resourceCache_delegate$lambda$3();
        }
    });

    public static final String extension(String str) {
        int iIntValue;
        kotlin.jvm.internal.p.i(str, "<this>");
        Integer numValueOf = Integer.valueOf(La.H.A0(str, JsonPointer.SEPARATOR, 0, false, 6, null));
        if (numValueOf.intValue() == -1) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            iIntValue = numValueOf.intValue();
        } else {
            Integer numValueOf2 = Integer.valueOf(La.H.A0(str, '\\', 0, false, 6, null));
            Integer num = numValueOf2.intValue() != -1 ? numValueOf2 : null;
            iIntValue = num != null ? num.intValue() : 0;
        }
        int iT0 = La.H.t0(str, '.', iIntValue, false, 4, null);
        if (iT0 < 0) {
            return "";
        }
        String strSubstring = str.substring(iT0);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final File findContainingJarFile(String url) {
        kotlin.jvm.internal.p.i(url, "url");
        if (!La.D.X(url, "jar:file:", false, 2, null)) {
            throw new IllegalArgumentException("Only local jars are supported (jar:file:)");
        }
        int iU0 = La.H.u0(url, "!", 9, false, 4, null);
        if (iU0 != -1) {
            String strSubstring = url.substring(9, iU0);
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            return new File(CodecsKt.decodeURLPart$default(strSubstring, 0, 0, null, 7, null));
        }
        throw new IllegalArgumentException(("Jar path requires !/ separator but it is: " + url).toString());
    }

    private static final ConcurrentHashMap<String, URL> getResourceCache() {
        return (ConcurrentHashMap) resourceCache$delegate.getValue();
    }

    private static final String normalisedPath(String str, String str2) throws BadRequestException {
        List listA1 = La.H.a1(str2, new char[]{JsonPointer.SEPARATOR, '\\'}, false, 0, 6, null);
        if (!listA1.contains("..")) {
            if (str == null) {
                str = "";
            }
            return Z8.F.A0(PathsKt.normalizePathComponents(Z8.F.S0(La.H.a1(str, new char[]{'.', JsonPointer.SEPARATOR, '\\'}, false, 0, 6, null), listA1)), "/", null, null, 0, null, null, 62, null);
        }
        throw new BadRequestException("Relative path should not contain path traversing characters: " + str2, null, 2, null);
    }

    public static final OutgoingContent.ReadChannelContent resolveResource(ApplicationCall applicationCall, String path, String str, ClassLoader classLoader, final InterfaceC5074l<? super String, ContentType> mimeResolve) throws IOException, BadRequestException {
        kotlin.jvm.internal.p.i(applicationCall, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(classLoader, "classLoader");
        kotlin.jvm.internal.p.i(mimeResolve, "mimeResolve");
        if (!La.D.K(path, "/", false, 2, null) && !La.D.K(path, "\\", false, 2, null)) {
            String strNormalisedPath = normalisedPath(str, path);
            Enumeration<URL> resources = classLoader.getResources(strNormalisedPath);
            kotlin.jvm.internal.p.h(resources, "getResources(...)");
            for (URL url : Ka.t.h(C1175x.A(resources))) {
                kotlin.jvm.internal.p.f(url);
                OutgoingContent.ReadChannelContent readChannelContentResourceClasspathResource = resourceClasspathResource(url, strNormalisedPath, new InterfaceC5074l() { // from class: io.ktor.server.http.content.J
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return StaticContentResolutionKt.resolveResource$lambda$1(mimeResolve, (URL) obj);
                    }
                });
                if (readChannelContentResourceClasspathResource != null) {
                    return readChannelContentResourceClasspathResource;
                }
            }
        }
        return null;
    }

    public static /* synthetic */ OutgoingContent.ReadChannelContent resolveResource$default(ApplicationCall applicationCall, String str, String str2, ClassLoader classLoader, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            classLoader = applicationCall.getApplication().getEnvironment().getClassLoader();
        }
        if ((i10 & 8) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.http.content.H
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return StaticContentResolutionKt.resolveResource$lambda$0((String) obj2);
                }
            };
        }
        return resolveResource(applicationCall, str, str2, classLoader, (InterfaceC5074l<? super String, ContentType>) interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentType resolveResource$lambda$0(String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return FileContentTypeKt.defaultForFileExtension(ContentType.INSTANCE, it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentType resolveResource$lambda$1(InterfaceC5074l interfaceC5074l, URL it) {
        kotlin.jvm.internal.p.i(it, "it");
        String path = it.getPath();
        kotlin.jvm.internal.p.h(path, "getPath(...)");
        return (ContentType) interfaceC5074l.invoke(extension(path));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair resolveResource$lambda$5(String str, InterfaceC5074l interfaceC5074l, URL url) {
        kotlin.jvm.internal.p.i(url, "url");
        OutgoingContent.ReadChannelContent readChannelContentResourceClasspathResource = resourceClasspathResource(url, str, interfaceC5074l);
        if (readChannelContentResourceClasspathResource != null) {
            return Y8.j.a(url, readChannelContentResourceClasspathResource);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConcurrentHashMap resourceCache_delegate$lambda$3() {
        return new ConcurrentHashMap();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        if (r0.equals("jrt") == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0096, code lost:
    
        if (r0.equals("resource") == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a4, code lost:
    
        return new io.ktor.http.content.URIFileContent(r8, r10.invoke(r8));
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @io.ktor.utils.io.InternalAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final io.ktor.http.content.OutgoingContent.ReadChannelContent resourceClasspathResource(java.net.URL r8, java.lang.String r9, p9.InterfaceC5074l<? super java.net.URL, io.ktor.http.ContentType> r10) {
        /*
            java.lang.String r0 = "url"
            kotlin.jvm.internal.p.i(r8, r0)
            java.lang.String r0 = "path"
            kotlin.jvm.internal.p.i(r9, r0)
            java.lang.String r0 = "mimeResolve"
            kotlin.jvm.internal.p.i(r10, r0)
            java.lang.String r0 = r8.getProtocol()
            r1 = 0
            if (r0 == 0) goto La5
            int r2 = r0.hashCode()
            switch(r2) {
                case -341064690: goto L90;
                case 104987: goto L5c;
                case 105516: goto L53;
                case 3143036: goto L1f;
                default: goto L1d;
            }
        L1d:
            goto La5
        L1f:
            java.lang.String r9 = "file"
            boolean r9 = r0.equals(r9)
            if (r9 != 0) goto L29
            goto La5
        L29:
            java.io.File r9 = new java.io.File
            java.lang.String r2 = r8.getPath()
            java.lang.String r0 = "getPath(...)"
            kotlin.jvm.internal.p.h(r2, r0)
            r6 = 7
            r7 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            java.lang.String r0 = io.ktor.http.CodecsKt.decodeURLPart$default(r2, r3, r4, r5, r6, r7)
            r9.<init>(r0)
            boolean r0 = r9.isFile()
            if (r0 == 0) goto L52
            io.ktor.server.http.content.LocalFileContent r0 = new io.ktor.server.http.content.LocalFileContent
            java.lang.Object r8 = r10.invoke(r8)
            io.ktor.http.ContentType r8 = (io.ktor.http.ContentType) r8
            r0.<init>(r9, r8)
            return r0
        L52:
            return r1
        L53:
            java.lang.String r9 = "jrt"
            boolean r9 = r0.equals(r9)
            if (r9 != 0) goto L99
            goto La5
        L5c:
            java.lang.String r2 = "jar"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L65
            goto La5
        L65:
            r0 = 0
            r2 = 2
            java.lang.String r3 = "/"
            boolean r0 = La.D.K(r9, r3, r0, r2, r1)
            if (r0 == 0) goto L70
            return r1
        L70:
            java.lang.String r0 = r8.toString()
            java.lang.String r2 = "toString(...)"
            kotlin.jvm.internal.p.h(r0, r2)
            java.io.File r0 = findContainingJarFile(r0)
            io.ktor.server.http.content.JarFileContent r2 = new io.ktor.server.http.content.JarFileContent
            java.lang.Object r8 = r10.invoke(r8)
            io.ktor.http.ContentType r8 = (io.ktor.http.ContentType) r8
            r2.<init>(r0, r9, r8)
            boolean r8 = r2.isFile()
            if (r8 == 0) goto L8f
            return r2
        L8f:
            return r1
        L90:
            java.lang.String r9 = "resource"
            boolean r9 = r0.equals(r9)
            if (r9 != 0) goto L99
            goto La5
        L99:
            io.ktor.http.content.URIFileContent r9 = new io.ktor.http.content.URIFileContent
            java.lang.Object r10 = r10.invoke(r8)
            io.ktor.http.ContentType r10 = (io.ktor.http.ContentType) r10
            r9.<init>(r8, r10)
            return r9
        La5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.http.content.StaticContentResolutionKt.resourceClasspathResource(java.net.URL, java.lang.String, p9.l):io.ktor.http.content.OutgoingContent$ReadChannelContent");
    }

    public static /* synthetic */ Pair resolveResource$default(Application application, String str, String str2, ClassLoader classLoader, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            classLoader = application.getEnvironment().getClassLoader();
        }
        return resolveResource(application, str, str2, classLoader, (InterfaceC5074l<? super URL, ContentType>) interfaceC5074l);
    }

    public static final Pair<URL, OutgoingContent.ReadChannelContent> resolveResource(Application application, String path, String str, ClassLoader classLoader, final InterfaceC5074l<? super URL, ContentType> mimeResolve) throws IOException, BadRequestException {
        Object objInvoke;
        Pair<URL, OutgoingContent.ReadChannelContent> pair;
        kotlin.jvm.internal.p.i(application, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(classLoader, "classLoader");
        kotlin.jvm.internal.p.i(mimeResolve, "mimeResolve");
        if (!La.D.K(path, "/", false, 2, null) && !La.D.K(path, "\\", false, 2, null)) {
            final String strNormalisedPath = normalisedPath(str, path);
            String str2 = classLoader.hashCode() + JsonPointer.SEPARATOR + strNormalisedPath;
            InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.http.content.I
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return StaticContentResolutionKt.resolveResource$lambda$5(strNormalisedPath, mimeResolve, (URL) obj);
                }
            };
            URL url = getResourceCache().get(str2);
            if (url != null && (pair = (Pair) interfaceC5074l.invoke(url)) != null) {
                return pair;
            }
            Enumeration<URL> resources = classLoader.getResources(strNormalisedPath);
            kotlin.jvm.internal.p.h(resources, "getResources(...)");
            Iterator it = Ka.t.h(C1175x.A(resources)).iterator();
            while (true) {
                if (!it.hasNext()) {
                    objInvoke = null;
                    break;
                }
                objInvoke = interfaceC5074l.invoke(it.next());
                if (objInvoke != null) {
                    break;
                }
            }
            Pair<URL, OutgoingContent.ReadChannelContent> pair2 = (Pair) objInvoke;
            if (pair2 != null) {
                getResourceCache().put(str2, pair2.a());
                return pair2;
            }
        }
        return null;
    }
}
