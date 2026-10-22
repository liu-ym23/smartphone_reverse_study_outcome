package io.ktor.server.http.content;

import Z8.C1173v;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.http.ContentType;
import io.ktor.http.FileContentTypeJvmKt;
import io.ktor.http.FileContentTypeKt;
import io.ktor.http.HeaderValue;
import io.ktor.http.content.OutgoingContent;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.routing.Route;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.Regex;
import p9.InterfaceC5074l;
import w9.C5757p;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a7\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001aK\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\u000e\u001a]\u0010\u0007\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00022\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014H\u0000¢\u0006\u0004\b\u0007\u0010\u0019\u001a\u008a\u0001\u0010\"\u001a\u00020\u001f*\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00002\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00022\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00160\u00142\u001a\b\u0002\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00020\u00142*\b\u0002\u0010!\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\u0006\u0012\u0004\u0018\u00010 0\u001dH\u0080@¢\u0006\u0004\b\"\u0010#\u001a\u0092\u0001\u0010%\u001a\u00020\u001f*\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u000b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00022\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00160\u00142\u001a\b\u0002\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00020\u00142*\b\u0002\u0010!\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\u0006\u0012\u0004\u0018\u00010 0\u001dH\u0080@¢\u0006\u0004\b%\u0010&\u001aª\u0001\u0010+\u001a\u00020\u001f*\u00020\u000f2\u0006\u0010'\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00022\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00142\u001a\b\u0002\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00020\u00142*\b\u0002\u0010(\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\u0006\u0012\u0004\u0018\u00010 0\u001d2\u0014\b\u0002\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020)0\u0014H\u0080@¢\u0006\u0004\b+\u0010,\"&\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00020-8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\" \u00105\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002*\u0002028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00066"}, d2 = {"Ljava/io/File;", Const.STR_FILE, "", "Lio/ktor/http/HeaderValue;", "acceptEncoding", "Lio/ktor/server/http/content/CompressedFileType;", "compressedTypes", "bestCompressionFit", "(Ljava/io/File;Ljava/util/List;Ljava/util/List;)Lio/ktor/server/http/content/CompressedFileType;", "Lio/ktor/server/http/content/FileSystemPaths;", "fileSystem", "Ljava/nio/file/Path;", "path", "Lkotlin/Pair;", "(Lio/ktor/server/http/content/FileSystemPaths;Ljava/nio/file/Path;Ljava/util/List;Ljava/util/List;)Lkotlin/Pair;", "Lio/ktor/server/application/ApplicationCall;", "call", "", "resource", "packageName", "Lkotlin/Function1;", "Ljava/net/URL;", "Lio/ktor/http/ContentType;", "contentType", "Lio/ktor/server/http/content/CompressedResource;", "(Lio/ktor/server/application/ApplicationCall;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lp9/l;)Lio/ktor/server/http/content/CompressedResource;", "requestedFile", "Lio/ktor/http/CacheControl;", "cacheControl", "Lkotlin/Function3;", "Le9/c;", "LY8/t;", "", "modify", "respondStaticFile", "(Lio/ktor/server/application/ApplicationCall;Ljava/io/File;Ljava/util/List;Lp9/l;Lp9/l;Lp9/q;Le9/c;)Ljava/lang/Object;", "requestedPath", "respondStaticPath", "(Lio/ktor/server/application/ApplicationCall;Lio/ktor/server/http/content/FileSystemPaths;Ljava/nio/file/Path;Ljava/util/List;Lp9/l;Lp9/l;Lp9/q;Le9/c;)Ljava/lang/Object;", "requestedResource", "modifier", "", "exclude", "respondStaticResource", "(Lio/ktor/server/application/ApplicationCall;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lp9/l;Lp9/l;Lp9/q;Lp9/l;Le9/c;)Ljava/lang/Object;", "Lio/ktor/util/AttributeKey;", "compressedKey", "Lio/ktor/util/AttributeKey;", "getCompressedKey", "()Lio/ktor/util/AttributeKey;", "Lio/ktor/server/routing/Route;", "getStaticContentEncodedTypes", "(Lio/ktor/server/routing/Route;)Ljava/util/List;", "staticContentEncodedTypes", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PreCompressedKt {
    private static final AttributeKey<List<CompressedFileType>> compressedKey;

    @InterfaceC4112d(c = "io.ktor.server.http.content.PreCompressedKt", f = "PreCompressed.kt", l = {130, 228, 142, 239}, m = "respondStaticFile")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.http.content.PreCompressedKt$respondStaticFile$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreCompressedKt.respondStaticFile(null, null, null, null, null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/io/File;", "<unused var>", "Lio/ktor/server/application/ApplicationCall;", "LY8/t;", "<anonymous>", "(Ljava/io/File;Lio/ktor/server/application/ApplicationCall;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.http.content.PreCompressedKt$respondStaticFile$4", f = "PreCompressed.kt", l = {}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.http.content.PreCompressedKt$respondStaticFile$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements p9.q<File, ApplicationCall, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        public AnonymousClass4(InterfaceC4014c<? super AnonymousClass4> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // p9.q
        public final Object invoke(File file, ApplicationCall applicationCall, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return new AnonymousClass4(interfaceC4014c).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return Y8.t.f7040a;
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.http.content.PreCompressedKt", f = "PreCompressed.kt", l = {162, 228, 170, 239}, m = "respondStaticPath")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.http.content.PreCompressedKt$respondStaticPath$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43631 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C43631(InterfaceC4014c<? super C43631> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreCompressedKt.respondStaticPath(null, null, null, null, null, null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/nio/file/Path;", "<unused var>", "Lio/ktor/server/application/ApplicationCall;", "LY8/t;", "<anonymous>", "(Ljava/nio/file/Path;Lio/ktor/server/application/ApplicationCall;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.http.content.PreCompressedKt$respondStaticPath$4", f = "PreCompressed.kt", l = {}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.http.content.PreCompressedKt$respondStaticPath$4, reason: invalid class name and case insensitive filesystem */
    public static final class C43644 extends SuspendLambda implements p9.q<Path, ApplicationCall, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        public C43644(InterfaceC4014c<? super C43644> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return Y8.t.f7040a;
        }

        @Override // p9.q
        public final Object invoke(Path path, ApplicationCall applicationCall, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return new C43644(interfaceC4014c).invokeSuspend(Y8.t.f7040a);
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.http.content.PreCompressedKt", f = "PreCompressed.kt", l = {228, 206, 239, 250, 223, 261}, m = "respondStaticResource")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.http.content.PreCompressedKt$respondStaticResource$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43651 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C43651(InterfaceC4014c<? super C43651> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreCompressedKt.respondStaticResource(null, null, null, null, null, null, null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/net/URL;", "<unused var>", "Lio/ktor/server/application/ApplicationCall;", "LY8/t;", "<anonymous>", "(Ljava/net/URL;Lio/ktor/server/application/ApplicationCall;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.http.content.PreCompressedKt$respondStaticResource$4", f = "PreCompressed.kt", l = {}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.http.content.PreCompressedKt$respondStaticResource$4, reason: invalid class name and case insensitive filesystem */
    public static final class C43664 extends SuspendLambda implements p9.q<URL, ApplicationCall, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        public C43664(InterfaceC4014c<? super C43664> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return Y8.t.f7040a;
        }

        @Override // p9.q
        public final Object invoke(URL url, ApplicationCall applicationCall, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return new C43664(interfaceC4014c).invokeSuspend(Y8.t.f7040a);
        }
    }

    static {
        InterfaceC5755n interfaceC5755nN;
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(List.class);
        try {
            interfaceC5755nN = kotlin.jvm.internal.t.n(List.class, C5757p.INSTANCE.d(kotlin.jvm.internal.t.m(CompressedFileType.class)));
        } catch (Throwable unused) {
            interfaceC5755nN = null;
        }
        compressedKey = new AttributeKey<>("StaticContentCompressed", new TypeInfo(interfaceC5745dB, interfaceC5755nN));
    }

    public static final CompressedFileType bestCompressionFit(File file, List<HeaderValue> acceptEncoding, List<? extends CompressedFileType> list) {
        kotlin.jvm.internal.p.i(file, "file");
        kotlin.jvm.internal.p.i(acceptEncoding, "acceptEncoding");
        List<HeaderValue> list2 = acceptEncoding;
        ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((HeaderValue) it.next()).getValue());
        }
        Set setR1 = Z8.F.r1(arrayList);
        Object obj = null;
        if (list == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list) {
            if (setR1.contains(((CompressedFileType) obj2).getEncoding())) {
                arrayList2.add(obj2);
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (new File(file.getAbsolutePath() + '.' + ((CompressedFileType) next).getExtension()).isFile()) {
                obj = next;
                break;
            }
        }
        return (CompressedFileType) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompressedResource bestCompressionFit$lambda$10(final String str, ApplicationCall applicationCall, String str2, final InterfaceC5074l interfaceC5074l, CompressedFileType it) {
        kotlin.jvm.internal.p.i(it, "it");
        final String str3 = str + '.' + it.getExtension();
        Pair pairResolveResource$default = StaticContentResolutionKt.resolveResource$default(applicationCall.getApplication(), str3, str2, (ClassLoader) null, new InterfaceC5074l() { // from class: io.ktor.server.http.content.m
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return PreCompressedKt.bestCompressionFit$lambda$10$lambda$9(str3, str, interfaceC5074l, (URL) obj);
            }
        }, 4, (Object) null);
        if (pairResolveResource$default == null) {
            return null;
        }
        return new CompressedResource((URL) pairResolveResource$default.e(), (OutgoingContent.ReadChannelContent) pairResolveResource$default.f(), it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentType bestCompressionFit$lambda$10$lambda$9(String str, String str2, InterfaceC5074l interfaceC5074l, URL url) {
        kotlin.jvm.internal.p.i(url, "url");
        String path = url.getPath();
        kotlin.jvm.internal.p.h(path, "getPath(...)");
        StringBuilder sb2 = new StringBuilder();
        Regex.Companion companion = Regex.INSTANCE;
        String separator = File.separator;
        kotlin.jvm.internal.p.h(separator, "separator");
        sb2.append(companion.d(La.H.t1(str, separator, null, 2, null)));
        sb2.append('$');
        Regex regex = new Regex(sb2.toString());
        kotlin.jvm.internal.p.h(separator, "separator");
        return (ContentType) interfaceC5074l.invoke(new URL(url.getProtocol(), url.getHost(), url.getPort(), regex.l(path, La.H.t1(str2, separator, null, 2, null))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bestCompressionFit$lambda$8(Set set, CompressedFileType it) {
        kotlin.jvm.internal.p.i(it, "it");
        return set.contains(it.getEncoding());
    }

    public static final AttributeKey<List<CompressedFileType>> getCompressedKey() {
        return compressedKey;
    }

    public static final List<CompressedFileType> getStaticContentEncodedTypes(Route route) {
        kotlin.jvm.internal.p.i(route, "<this>");
        List<CompressedFileType> list = (List) route.getAttributes().getOrNull(compressedKey);
        if (list != null) {
            return list;
        }
        Route parent = route.getParent();
        if (parent != null) {
            return getStaticContentEncodedTypes(parent);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0111, code lost:
    
        if (r0.respond(r3, r4, r5) != r6) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01d5, code lost:
    
        if (r0.respond(r1, r4, r5) != r6) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01a0 A[PHI: r0 r1 r2 r4 r10
      0x01a0: PHI (r0v4 io.ktor.server.application.ApplicationCall) = (r0v0 io.ktor.server.application.ApplicationCall), (r0v12 io.ktor.server.application.ApplicationCall) binds: [B:49:0x019d, B:17:0x0046] A[DONT_GENERATE, DONT_INLINE]
      0x01a0: PHI (r1v6 java.io.File) = (r1v0 java.io.File), (r1v14 java.io.File) binds: [B:49:0x019d, B:17:0x0046] A[DONT_GENERATE, DONT_INLINE]
      0x01a0: PHI (r2v5 p9.l<? super java.io.File, io.ktor.http.ContentType>) = 
      (r2v0 p9.l<? super java.io.File, io.ktor.http.ContentType>)
      (r2v15 p9.l<? super java.io.File, io.ktor.http.ContentType>)
     binds: [B:49:0x019d, B:17:0x0046] A[DONT_GENERATE, DONT_INLINE]
      0x01a0: PHI (r4v10 io.ktor.server.http.content.CompressedFileType) = (r4v5 io.ktor.server.http.content.CompressedFileType), (r4v12 io.ktor.server.http.content.CompressedFileType) binds: [B:49:0x019d, B:17:0x0046] A[DONT_GENERATE, DONT_INLINE]
      0x01a0: PHI (r10v2 java.io.File) = (r10v1 java.io.File), (r10v3 java.io.File) binds: [B:49:0x019d, B:17:0x0046] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object respondStaticFile(io.ktor.server.application.ApplicationCall r23, java.io.File r24, java.util.List<? extends io.ktor.server.http.content.CompressedFileType> r25, p9.InterfaceC5074l<? super java.io.File, io.ktor.http.ContentType> r26, p9.InterfaceC5074l<? super java.io.File, ? extends java.util.List<? extends io.ktor.http.CacheControl>> r27, p9.q<? super java.io.File, ? super io.ktor.server.application.ApplicationCall, ? super e9.InterfaceC4014c<? super Y8.t>, ? extends java.lang.Object> r28, e9.InterfaceC4014c<? super Y8.t> r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 475
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.http.content.PreCompressedKt.respondStaticFile(io.ktor.server.application.ApplicationCall, java.io.File, java.util.List, p9.l, p9.l, p9.q, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object respondStaticFile$default(ApplicationCall applicationCall, File file, List list, InterfaceC5074l interfaceC5074l, InterfaceC5074l interfaceC5074l2, p9.q qVar, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.http.content.k
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return PreCompressedKt.respondStaticFile$lambda$11((File) obj2);
                }
            };
        }
        InterfaceC5074l interfaceC5074l3 = interfaceC5074l;
        if ((i10 & 8) != 0) {
            interfaceC5074l2 = new InterfaceC5074l() { // from class: io.ktor.server.http.content.l
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return PreCompressedKt.respondStaticFile$lambda$12((File) obj2);
                }
            };
        }
        InterfaceC5074l interfaceC5074l4 = interfaceC5074l2;
        if ((i10 & 16) != 0) {
            qVar = new AnonymousClass4(null);
        }
        return respondStaticFile(applicationCall, file, list, interfaceC5074l3, interfaceC5074l4, qVar, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentType respondStaticFile$lambda$11(File it) {
        kotlin.jvm.internal.p.i(it, "it");
        return FileContentTypeJvmKt.defaultForFile(ContentType.INSTANCE, it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List respondStaticFile$lambda$12(File it) {
        kotlin.jvm.internal.p.i(it, "it");
        return C1173v.m();
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0117, code lost:
    
        if (r0.respond(r3, r4, r5) != r6) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0187, code lost:
    
        if (r0.respond(r1, r4, r5) != r6) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object respondStaticPath(io.ktor.server.application.ApplicationCall r23, io.ktor.server.http.content.FileSystemPaths r24, java.nio.file.Path r25, java.util.List<? extends io.ktor.server.http.content.CompressedFileType> r26, p9.InterfaceC5074l<? super java.nio.file.Path, io.ktor.http.ContentType> r27, p9.InterfaceC5074l<? super java.nio.file.Path, ? extends java.util.List<? extends io.ktor.http.CacheControl>> r28, p9.q<? super java.nio.file.Path, ? super io.ktor.server.application.ApplicationCall, ? super e9.InterfaceC4014c<? super Y8.t>, ? extends java.lang.Object> r29, e9.InterfaceC4014c<? super Y8.t> r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.http.content.PreCompressedKt.respondStaticPath(io.ktor.server.application.ApplicationCall, io.ktor.server.http.content.FileSystemPaths, java.nio.file.Path, java.util.List, p9.l, p9.l, p9.q, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object respondStaticPath$default(ApplicationCall applicationCall, FileSystemPaths fileSystemPaths, Path path, List list, InterfaceC5074l interfaceC5074l, InterfaceC5074l interfaceC5074l2, p9.q qVar, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.http.content.f
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return PreCompressedKt.respondStaticPath$lambda$13((Path) obj2);
                }
            };
        }
        InterfaceC5074l interfaceC5074l3 = interfaceC5074l;
        if ((i10 & 16) != 0) {
            interfaceC5074l2 = new InterfaceC5074l() { // from class: io.ktor.server.http.content.g
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return PreCompressedKt.respondStaticPath$lambda$14((Path) obj2);
                }
            };
        }
        InterfaceC5074l interfaceC5074l4 = interfaceC5074l2;
        if ((i10 & 32) != 0) {
            qVar = new C43644(null);
        }
        return respondStaticPath(applicationCall, fileSystemPaths, path, list, interfaceC5074l3, interfaceC5074l4, qVar, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentType respondStaticPath$lambda$13(Path it) {
        kotlin.jvm.internal.p.i(it, "it");
        return FileContentTypeJvmKt.defaultForPath(ContentType.INSTANCE, it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List respondStaticPath$lambda$14(Path it) {
        kotlin.jvm.internal.p.i(it, "it");
        return C1173v.m();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b8, code lost:
    
        if (r0.respond(r2, r1, r9) == r10) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0171, code lost:
    
        if (r0.respond(r2, r4, r9) != r10) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01b7, code lost:
    
        if (r0.respond(r2, r1, r9) == r10) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0220, code lost:
    
        if (r0.respond(r1, r4, r9) != r10) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object respondStaticResource(io.ktor.server.application.ApplicationCall r21, java.lang.String r22, java.lang.String r23, java.util.List<? extends io.ktor.server.http.content.CompressedFileType> r24, p9.InterfaceC5074l<? super java.net.URL, io.ktor.http.ContentType> r25, p9.InterfaceC5074l<? super java.net.URL, ? extends java.util.List<? extends io.ktor.http.CacheControl>> r26, p9.q<? super java.net.URL, ? super io.ktor.server.application.ApplicationCall, ? super e9.InterfaceC4014c<? super Y8.t>, ? extends java.lang.Object> r27, p9.InterfaceC5074l<? super java.net.URL, java.lang.Boolean> r28, e9.InterfaceC4014c<? super Y8.t> r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 572
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.http.content.PreCompressedKt.respondStaticResource(io.ktor.server.application.ApplicationCall, java.lang.String, java.lang.String, java.util.List, p9.l, p9.l, p9.q, p9.l, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object respondStaticResource$default(ApplicationCall applicationCall, String str, String str2, List list, InterfaceC5074l interfaceC5074l, InterfaceC5074l interfaceC5074l2, p9.q qVar, InterfaceC5074l interfaceC5074l3, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.http.content.h
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return PreCompressedKt.respondStaticResource$lambda$15((URL) obj2);
                }
            };
        }
        InterfaceC5074l interfaceC5074l4 = interfaceC5074l;
        if ((i10 & 16) != 0) {
            interfaceC5074l2 = new InterfaceC5074l() { // from class: io.ktor.server.http.content.i
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return PreCompressedKt.respondStaticResource$lambda$16((URL) obj2);
                }
            };
        }
        return respondStaticResource(applicationCall, str, str2, list, interfaceC5074l4, interfaceC5074l2, (i10 & 32) != 0 ? new C43664(null) : qVar, (i10 & 64) != 0 ? new InterfaceC5074l() { // from class: io.ktor.server.http.content.j
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(PreCompressedKt.respondStaticResource$lambda$17((URL) obj2));
            }
        } : interfaceC5074l3, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentType respondStaticResource$lambda$15(URL it) {
        kotlin.jvm.internal.p.i(it, "it");
        ContentType.Companion companion = ContentType.INSTANCE;
        String path = it.getPath();
        kotlin.jvm.internal.p.h(path, "getPath(...)");
        return FileContentTypeKt.defaultForFileExtension(companion, StaticContentResolutionKt.extension(path));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List respondStaticResource$lambda$16(URL it) {
        kotlin.jvm.internal.p.i(it, "it");
        return C1173v.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean respondStaticResource$lambda$17(URL it) {
        kotlin.jvm.internal.p.i(it, "it");
        return false;
    }

    public static final Pair<Path, CompressedFileType> bestCompressionFit(FileSystemPaths fileSystem, Path path, List<HeaderValue> acceptEncoding, List<? extends CompressedFileType> list) {
        kotlin.jvm.internal.p.i(fileSystem, "fileSystem");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(acceptEncoding, "acceptEncoding");
        List<HeaderValue> list2 = acceptEncoding;
        ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((HeaderValue) it.next()).getValue());
        }
        Set setR1 = Z8.F.r1(arrayList);
        Object obj = null;
        if (list == null) {
            return null;
        }
        ArrayList<CompressedFileType> arrayList2 = new ArrayList();
        for (Object obj2 : list) {
            if (setR1.contains(((CompressedFileType) obj2).getEncoding())) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(C1174w.x(arrayList2, 10));
        for (CompressedFileType compressedFileType : arrayList2) {
            arrayList3.add(Y8.j.a(fileSystem.getPath(path.toString() + '.' + compressedFileType.getExtension(), new String[0]), compressedFileType));
        }
        Iterator it2 = arrayList3.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (Files.exists((Path) ((Pair) next).e(), (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                obj = next;
                break;
            }
        }
        return (Pair) obj;
    }

    public static final CompressedResource bestCompressionFit(final ApplicationCall call, final String resource, final String str, List<HeaderValue> acceptEncoding, List<? extends CompressedFileType> list, final InterfaceC5074l<? super URL, ContentType> contentType) {
        Ka.j jVarD0;
        Ka.j jVarF;
        Ka.j jVarS;
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(resource, "resource");
        kotlin.jvm.internal.p.i(acceptEncoding, "acceptEncoding");
        kotlin.jvm.internal.p.i(contentType, "contentType");
        List<HeaderValue> list2 = acceptEncoding;
        ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((HeaderValue) it.next()).getValue());
        }
        final Set setR1 = Z8.F.r1(arrayList);
        if (list == null || (jVarD0 = Z8.F.d0(list)) == null || (jVarF = SequencesKt___SequencesKt.F(jVarD0, new InterfaceC5074l() { // from class: io.ktor.server.http.content.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(PreCompressedKt.bestCompressionFit$lambda$8(setR1, (CompressedFileType) obj));
            }
        })) == null || (jVarS = SequencesKt___SequencesKt.S(jVarF, new InterfaceC5074l() { // from class: io.ktor.server.http.content.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return PreCompressedKt.bestCompressionFit$lambda$10(resource, call, str, contentType, (CompressedFileType) obj);
            }
        })) == null) {
            return null;
        }
        return (CompressedResource) SequencesKt___SequencesKt.K(jVarS);
    }
}
