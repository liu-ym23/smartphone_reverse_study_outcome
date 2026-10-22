package io.ktor.server.http.content;

import com.fasterxml.jackson.core.JsonPointer;
import io.ktor.http.ContentType;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.Version;
import io.ktor.http.content.VersionsKt;
import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.ReadingKt;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB!\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010#R\u001b\u0010'\u001a\u00020%8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001c\u001a\u0004\b'\u0010(R\u0016\u0010,\u001a\u0004\u0018\u00010)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lio/ktor/server/http/content/JarFileContent;", "Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "Ljava/io/File;", "jarFile", "", "resourcePath", "Lio/ktor/http/ContentType;", "contentType", "<init>", "(Ljava/io/File;Ljava/lang/String;Lio/ktor/http/ContentType;)V", "Ljava/nio/file/Path;", "zipFilePath", "(Ljava/nio/file/Path;Ljava/lang/String;Lio/ktor/http/ContentType;)V", "Lio/ktor/utils/io/ByteReadChannel;", "readFrom", "()Lio/ktor/utils/io/ByteReadChannel;", "Ljava/io/File;", "getJarFile", "()Ljava/io/File;", "Ljava/lang/String;", "getResourcePath", "()Ljava/lang/String;", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "normalized", "Ljava/util/jar/JarEntry;", "jarEntry$delegate", "LY8/h;", "getJarEntry", "()Ljava/util/jar/JarEntry;", "jarEntry", "Ljava/util/jar/JarFile;", "jar$delegate", "getJar", "()Ljava/util/jar/JarFile;", "jar", "", "isFile$delegate", "isFile", "()Z", "", "getContentLength", "()Ljava/lang/Long;", "contentLength", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class JarFileContent extends OutgoingContent.ReadChannelContent {
    private final ContentType contentType;

    /* renamed from: isFile$delegate, reason: from kotlin metadata */
    private final Y8.h isFile;

    /* renamed from: jar$delegate, reason: from kotlin metadata */
    private final Y8.h jar;

    /* renamed from: jarEntry$delegate, reason: from kotlin metadata */
    private final Y8.h jarEntry;
    private final File jarFile;
    private final String normalized;
    private final String resourcePath;

    public JarFileContent(File jarFile, String resourcePath, ContentType contentType) {
        kotlin.jvm.internal.p.i(jarFile, "jarFile");
        kotlin.jvm.internal.p.i(resourcePath, "resourcePath");
        kotlin.jvm.internal.p.i(contentType, "contentType");
        this.jarFile = jarFile;
        this.resourcePath = resourcePath;
        this.contentType = contentType;
        String string = l9.k.x(new File(resourcePath)).toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        String strS = La.D.S(string, File.separatorChar, JsonPointer.SEPARATOR, false, 4, null);
        this.normalized = strS;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.jarEntry = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: io.ktor.server.http.content.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return JarFileContent.jarEntry_delegate$lambda$0(this.f33407a);
            }
        });
        this.jar = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: io.ktor.server.http.content.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return JarFileContent.jar_delegate$lambda$1(this.f33408a);
            }
        });
        this.isFile = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: io.ktor.server.http.content.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(JarFileContent.isFile_delegate$lambda$2(this.f33409a));
            }
        });
        if (La.D.X(strS, "..", false, 2, null)) {
            throw new IllegalArgumentException(("Bad resource relative path " + resourcePath).toString());
        }
        JarEntry jarEntry = getJarEntry();
        if (jarEntry != null) {
            List<Version> versions = VersionsKt.getVersions(this);
            FileTime lastModifiedTime = jarEntry.getLastModifiedTime();
            kotlin.jvm.internal.p.h(lastModifiedTime, "getLastModifiedTime(...)");
            VersionsKt.setVersions(this, Z8.F.T0(versions, LastModifiedJavaTimeKt.LastModifiedVersion(lastModifiedTime)));
        }
    }

    private final JarFile getJar() {
        return (JarFile) this.jar.getValue();
    }

    private final JarEntry getJarEntry() {
        return (JarEntry) this.jarEntry.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isFile_delegate$lambda$2(JarFileContent jarFileContent) {
        JarEntry jarEntry = jarFileContent.getJarEntry();
        return (jarEntry == null || jarEntry.isDirectory()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JarEntry jarEntry_delegate$lambda$0(JarFileContent jarFileContent) {
        return jarFileContent.getJar().getJarEntry(jarFileContent.resourcePath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JarFile jar_delegate$lambda$1(JarFileContent jarFileContent) {
        return new JarFile(jarFileContent.jarFile);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long getContentLength() {
        JarEntry jarEntry = getJarEntry();
        if (jarEntry != null) {
            return Long.valueOf(jarEntry.getSize());
        }
        return null;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType getContentType() {
        return this.contentType;
    }

    public final File getJarFile() {
        return this.jarFile;
    }

    public final String getResourcePath() {
        return this.resourcePath;
    }

    public final boolean isFile() {
        return ((Boolean) this.isFile.getValue()).booleanValue();
    }

    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
    public ByteReadChannel readFrom() throws IOException {
        JarEntry jarEntry = getJarEntry();
        if (jarEntry != null) {
            InputStream inputStream = getJar().getInputStream(jarEntry);
            kotlin.jvm.internal.p.h(inputStream, "getInputStream(...)");
            return ReadingKt.toByteReadChannel$default(inputStream, null, ByteBufferPoolKt.getKtorDefaultPool(), 1, null);
        }
        throw new IOException("Resource " + this.normalized + " not found");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public JarFileContent(Path zipFilePath, String resourcePath, ContentType contentType) {
        kotlin.jvm.internal.p.i(zipFilePath, "zipFilePath");
        kotlin.jvm.internal.p.i(resourcePath, "resourcePath");
        kotlin.jvm.internal.p.i(contentType, "contentType");
        File file = zipFilePath.toFile();
        kotlin.jvm.internal.p.h(file, "toFile(...)");
        this(file, resourcePath, contentType);
    }
}
