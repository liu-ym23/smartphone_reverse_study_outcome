package io.ktor.server.http.content;

import A7.T;
import Z8.C1173v;
import e9.InterfaceC4014c;
import io.ktor.http.CacheControl;
import io.ktor.http.ContentType;
import io.ktor.http.FileContentTypeJvmKt;
import io.ktor.http.FileContentTypeKt;
import io.ktor.server.application.ApplicationCall;
import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b%\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0013\u001a\u00020\b2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0017\u001a\u00020\b2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0010¢\u0006\u0004\b\u0017\u0010\u0014J7\u0010\u001b\u001a\u00020\b2(\u0010\u0012\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001e\u001a\u00020\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0\u0010¢\u0006\u0004\b\u001e\u0010\u0014J!\u0010\u001f\u001a\u00020\b2\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0005\"\u00020\f¢\u0006\u0004\b\u001f\u0010 R \u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R.\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00110\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010\u0014R4\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\"\u001a\u0004\b&\u0010$\"\u0004\b'\u0010\u0014RD\u0010(\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00188\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010\u001cR.\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\"\u001a\u0004\b-\u0010$\"\u0004\b.\u0010\u0014R(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00104\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u0010\u000fR(\u00109\u001a\b\u0012\u0004\u0012\u00020\u00060\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b9\u0010/\u001a\u0004\b:\u00101\"\u0004\b;\u00103R\"\u0010<\u001a\u00020\u001d8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006B"}, d2 = {"Lio/ktor/server/http/content/StaticContentConfig;", "", "Resource", "<init>", "()V", "", "Lio/ktor/server/http/content/CompressedFileType;", "types", "LY8/t;", "preCompressed", "([Lio/ktor/server/http/content/CompressedFileType;)V", "enableAutoHeadResponse", "", "path", "default", "(Ljava/lang/String;)V", "Lkotlin/Function1;", "Lio/ktor/http/ContentType;", "block", "contentType", "(Lp9/l;)V", "", "Lio/ktor/http/CacheControl;", "cacheControl", "Lkotlin/Function3;", "Lio/ktor/server/application/ApplicationCall;", "Le9/c;", "modify", "(Lp9/q;)V", "", "exclude", "extensions", "([Ljava/lang/String;)V", "defaultContentType", "Lp9/l;", "getContentType$ktor_server_core", "()Lp9/l;", "setContentType$ktor_server_core", "getCacheControl$ktor_server_core", "setCacheControl$ktor_server_core", "modifier", "Lp9/q;", "getModifier$ktor_server_core", "()Lp9/q;", "setModifier$ktor_server_core", "getExclude$ktor_server_core", "setExclude$ktor_server_core", "Ljava/util/List;", "getExtensions$ktor_server_core", "()Ljava/util/List;", "setExtensions$ktor_server_core", "(Ljava/util/List;)V", "defaultPath", "Ljava/lang/String;", "getDefaultPath$ktor_server_core", "()Ljava/lang/String;", "setDefaultPath$ktor_server_core", "preCompressedFileTypes", "getPreCompressedFileTypes$ktor_server_core", "setPreCompressedFileTypes$ktor_server_core", "autoHeadResponse", "Z", "getAutoHeadResponse$ktor_server_core", "()Z", "setAutoHeadResponse$ktor_server_core", "(Z)V", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StaticContentConfig<Resource> {
    private boolean autoHeadResponse;
    private InterfaceC5074l<? super Resource, ? extends List<? extends CacheControl>> cacheControl;
    private InterfaceC5074l<? super Resource, ContentType> contentType;
    private final InterfaceC5074l<Resource, ContentType> defaultContentType;
    private String defaultPath;
    private InterfaceC5074l<? super Resource, Boolean> exclude;
    private List<String> extensions;
    private p9.q<? super Resource, ? super ApplicationCall, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> modifier;
    private List<? extends CompressedFileType> preCompressedFileTypes;

    public StaticContentConfig() {
        T t10 = (InterfaceC5074l<Resource, ContentType>) new InterfaceC5074l() { // from class: io.ktor.server.http.content.u
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StaticContentConfig.defaultContentType$lambda$0(obj);
            }
        };
        this.defaultContentType = t10;
        this.contentType = t10;
        this.cacheControl = new InterfaceC5074l() { // from class: io.ktor.server.http.content.v
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StaticContentConfig.cacheControl$lambda$1(obj);
            }
        };
        this.modifier = new StaticContentConfig$modifier$1(null);
        this.exclude = new InterfaceC5074l() { // from class: io.ktor.server.http.content.w
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(StaticContentConfig.exclude$lambda$2(obj));
            }
        };
        this.extensions = C1173v.m();
        this.preCompressedFileTypes = C1173v.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List cacheControl$lambda$1(Object it) {
        kotlin.jvm.internal.p.i(it, "it");
        return C1173v.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentType contentType$lambda$3(InterfaceC5074l interfaceC5074l, StaticContentConfig staticContentConfig, Object resource) {
        kotlin.jvm.internal.p.i(resource, "resource");
        ContentType contentType = (ContentType) interfaceC5074l.invoke(resource);
        return contentType == null ? staticContentConfig.defaultContentType.invoke(resource) : contentType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentType defaultContentType$lambda$0(Object it) {
        kotlin.jvm.internal.p.i(it, "it");
        if (it instanceof File) {
            return FileContentTypeJvmKt.defaultForFile(ContentType.INSTANCE, (File) it);
        }
        if (it instanceof URL) {
            ContentType.Companion companion = ContentType.INSTANCE;
            String path = ((URL) it).getPath();
            kotlin.jvm.internal.p.h(path, "getPath(...)");
            return FileContentTypeKt.defaultForFilePath(companion, path);
        }
        if (it instanceof Path) {
            return FileContentTypeJvmKt.defaultForPath(ContentType.INSTANCE, (Path) it);
        }
        throw new IllegalArgumentException("Argument can be only of type File, Path or URL, but was " + kotlin.jvm.internal.t.b(it.getClass()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean exclude$lambda$2(Object it) {
        kotlin.jvm.internal.p.i(it, "it");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean exclude$lambda$4(InterfaceC5074l interfaceC5074l, InterfaceC5074l interfaceC5074l2, Object it) {
        kotlin.jvm.internal.p.i(it, "it");
        if (((Boolean) interfaceC5074l.invoke(it)).booleanValue()) {
            return true;
        }
        return ((Boolean) interfaceC5074l2.invoke(it)).booleanValue();
    }

    public final void cacheControl(InterfaceC5074l<? super Resource, ? extends List<? extends CacheControl>> block) {
        kotlin.jvm.internal.p.i(block, "block");
        this.cacheControl = block;
    }

    public final void contentType(final InterfaceC5074l<? super Resource, ContentType> block) {
        kotlin.jvm.internal.p.i(block, "block");
        this.contentType = new InterfaceC5074l() { // from class: io.ktor.server.http.content.y
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StaticContentConfig.contentType$lambda$3(block, this, obj);
            }
        };
    }

    /* renamed from: default, reason: not valid java name */
    public final void m172default(String path) {
        this.defaultPath = path;
    }

    public final void enableAutoHeadResponse() {
        this.autoHeadResponse = true;
    }

    public final void exclude(final InterfaceC5074l<? super Resource, Boolean> block) {
        kotlin.jvm.internal.p.i(block, "block");
        final InterfaceC5074l<? super Resource, Boolean> interfaceC5074l = this.exclude;
        this.exclude = new InterfaceC5074l() { // from class: io.ktor.server.http.content.x
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(StaticContentConfig.exclude$lambda$4(interfaceC5074l, block, obj));
            }
        };
    }

    public final void extensions(String... extensions) {
        kotlin.jvm.internal.p.i(extensions, "extensions");
        this.extensions = Z8.r.T0(extensions);
    }

    /* renamed from: getAutoHeadResponse$ktor_server_core, reason: from getter */
    public final boolean getAutoHeadResponse() {
        return this.autoHeadResponse;
    }

    public final InterfaceC5074l<Resource, List<CacheControl>> getCacheControl$ktor_server_core() {
        return this.cacheControl;
    }

    public final InterfaceC5074l<Resource, ContentType> getContentType$ktor_server_core() {
        return this.contentType;
    }

    /* renamed from: getDefaultPath$ktor_server_core, reason: from getter */
    public final String getDefaultPath() {
        return this.defaultPath;
    }

    public final InterfaceC5074l<Resource, Boolean> getExclude$ktor_server_core() {
        return this.exclude;
    }

    public final List<String> getExtensions$ktor_server_core() {
        return this.extensions;
    }

    public final p9.q<Resource, ApplicationCall, InterfaceC4014c<? super Y8.t>, Object> getModifier$ktor_server_core() {
        return this.modifier;
    }

    public final List<CompressedFileType> getPreCompressedFileTypes$ktor_server_core() {
        return this.preCompressedFileTypes;
    }

    public final void modify(p9.q<? super Resource, ? super ApplicationCall, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> block) {
        kotlin.jvm.internal.p.i(block, "block");
        this.modifier = block;
    }

    public final void preCompressed(CompressedFileType... types) {
        kotlin.jvm.internal.p.i(types, "types");
        this.preCompressedFileTypes = Z8.r.T0(types);
    }

    public final void setAutoHeadResponse$ktor_server_core(boolean z10) {
        this.autoHeadResponse = z10;
    }

    public final void setCacheControl$ktor_server_core(InterfaceC5074l<? super Resource, ? extends List<? extends CacheControl>> interfaceC5074l) {
        kotlin.jvm.internal.p.i(interfaceC5074l, "<set-?>");
        this.cacheControl = interfaceC5074l;
    }

    public final void setContentType$ktor_server_core(InterfaceC5074l<? super Resource, ContentType> interfaceC5074l) {
        kotlin.jvm.internal.p.i(interfaceC5074l, "<set-?>");
        this.contentType = interfaceC5074l;
    }

    public final void setDefaultPath$ktor_server_core(String str) {
        this.defaultPath = str;
    }

    public final void setExclude$ktor_server_core(InterfaceC5074l<? super Resource, Boolean> interfaceC5074l) {
        kotlin.jvm.internal.p.i(interfaceC5074l, "<set-?>");
        this.exclude = interfaceC5074l;
    }

    public final void setExtensions$ktor_server_core(List<String> list) {
        kotlin.jvm.internal.p.i(list, "<set-?>");
        this.extensions = list;
    }

    public final void setModifier$ktor_server_core(p9.q<? super Resource, ? super ApplicationCall, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> qVar) {
        kotlin.jvm.internal.p.i(qVar, "<set-?>");
        this.modifier = qVar;
    }

    public final void setPreCompressedFileTypes$ktor_server_core(List<? extends CompressedFileType> list) {
        kotlin.jvm.internal.p.i(list, "<set-?>");
        this.preCompressedFileTypes = list;
    }
}
