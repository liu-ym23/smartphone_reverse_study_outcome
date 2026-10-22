package io.ktor.server.http.content;

import Z8.C1168p;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.http.CacheControl;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMethod;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.application.CreatePluginUtilsKt;
import io.ktor.server.application.RouteScopedPlugin;
import io.ktor.server.application.RouteScopedPluginBuilder;
import io.ktor.server.application.hooks.ResponseBodyReadyForSend;
import io.ktor.server.http.content.FileSystemPaths;
import io.ktor.server.routing.Route;
import io.ktor.server.routing.RouteSelector;
import io.ktor.server.routing.RouteSelectorEvaluation;
import io.ktor.server.routing.RoutingBuilderKt;
import io.ktor.server.routing.RoutingCall;
import io.ktor.server.routing.RoutingContext;
import io.ktor.server.routing.RoutingResolveContext;
import io.ktor.util.AttributeKey;
import io.ktor.util.PathKt;
import io.ktor.util.reflect.TypeInfo;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\u001aI\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u001a\b\u0002\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000b\u001aK\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u001a\b\u0002\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u000e\u0010\u000f\u001aS\u0010\u0013\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u001a\b\u0002\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001aU\u0010\u001c\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\u001a\b\u0002\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u001c\u0010\u001d\u001a;\u0010\"\u001a\u00020\b*\u00020\u00002\u0014\b\u0002\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\u001e\"\u00020\u001f2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\"\u0010#\u001a\u001d\u0010%\u001a\u00020\u0003*\u0004\u0018\u00010\u00032\u0006\u0010$\u001a\u00020\u0003H\u0002¢\u0006\u0004\b%\u0010&\u001a'\u0010'\u001a\u00020\u0000*\u00020\u00002\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b0\u0006H\u0007¢\u0006\u0004\b'\u0010(\u001a/\u0010'\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b0\u0006H\u0007¢\u0006\u0004\b'\u0010)\u001a\u001b\u0010+\u001a\u00020\b*\u00020\u00002\u0006\u0010*\u001a\u00020\u0001H\u0007¢\u0006\u0004\b+\u0010,\u001a\u001b\u0010+\u001a\u00020\b*\u00020\u00002\u0006\u0010*\u001a\u00020\u0003H\u0007¢\u0006\u0004\b+\u0010-\u001a%\u0010$\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010*\u001a\u00020\u0001H\u0007¢\u0006\u0004\b$\u0010.\u001a#\u0010$\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u0003H\u0007¢\u0006\u0004\b$\u0010/\u001a\u001b\u00101\u001a\u00020\b*\u00020\u00002\u0006\u00100\u001a\u00020\u0001H\u0007¢\u0006\u0004\b1\u0010,\u001a\u001b\u00101\u001a\u00020\b*\u00020\u00002\u0006\u00100\u001a\u00020\u0003H\u0007¢\u0006\u0004\b1\u0010-\u001a!\u00103\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00012\b\u00102\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b3\u00104\u001a1\u00105\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u00105\u001a\u00020\u00012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b5\u00106\u001a\u001f\u00107\u001a\u00020\b*\u00020\u00002\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b7\u0010,\u001a'\u00108\u001a\u00020\b*\u00020\u00002\u0006\u00105\u001a\u00020\u00012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b8\u0010.\u001a\u0011\u0010;\u001a\u00020:*\u000209¢\u0006\u0004\b;\u0010<\u001aG\u0010B\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010=\u001a\u00020:2\"\u0010A\u001a\u001e\b\u0001\u0012\u0004\u0012\u000209\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0?\u0012\u0006\u0012\u0004\u0018\u00010@0>H\u0002¢\u0006\u0004\bB\u0010C\u001aº\u0001\u0010O\u001a\u00020\b*\u0002092\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010D2\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020F0\u00062\u0018\u0010I\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0D0\u00062(\u0010K\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u000209\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0?\u0012\u0006\u0012\u0004\u0018\u00010@0J2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020:0\u00062\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00010D2\b\u0010N\u001a\u0004\u0018\u00010\u0001H\u0082@¢\u0006\u0004\bO\u0010P\u001aÄ\u0001\u0010Q\u001a\u00020\b*\u0002092\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010D2\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020F0\u00062\u0018\u0010I\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0D0\u00062(\u0010K\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u000209\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0?\u0012\u0006\u0012\u0004\u0018\u00010@0J2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020:0\u00062\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00010D2\b\u0010N\u001a\u0004\u0018\u00010\u0001H\u0082@¢\u0006\u0004\bQ\u0010R\u001a¼\u0001\u0010T\u001a\u00020\b*\u0002092\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00012\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010D2\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020F0\u00062\u0018\u0010I\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0D0\u00062(\u0010S\u001a$\b\u0001\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u000209\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0?\u0012\u0006\u0012\u0004\u0018\u00010@0J2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020:0\u00062\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00010D2\b\u0010N\u001a\u0004\u0018\u00010\u0001H\u0082@¢\u0006\u0004\bT\u0010U\"\u001d\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00010V8\u0006¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0014\u0010[\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\b[\u0010\\\"\u001a\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00030V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010X\"\u001a\u0010_\u001a\b\u0012\u0004\u0012\u00020\b0^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`\"\u001a\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00010V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010X\",\u0010f\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\b\u0010b\u001a\u0004\u0018\u00010\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bc\u0010d\"\u0004\be\u0010-\"2\u0010l\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010b\u001a\u0004\u0018\u00010\u00018F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\bj\u0010k\u001a\u0004\bg\u0010h\"\u0004\bi\u0010,¨\u0006m"}, d2 = {"Lio/ktor/server/routing/Route;", "", "remotePath", "Ljava/io/File;", Const.JSON_KEY_DIR, "index", "Lkotlin/Function1;", "Lio/ktor/server/http/content/StaticContentConfig;", "LY8/t;", "block", "staticFiles", "(Lio/ktor/server/routing/Route;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;Lp9/l;)Lio/ktor/server/routing/Route;", "basePackage", "Ljava/net/URL;", "staticResources", "(Lio/ktor/server/routing/Route;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lp9/l;)Lio/ktor/server/routing/Route;", "basePath", "Ljava/nio/file/Path;", "zip", "staticZip", "(Lio/ktor/server/routing/Route;Ljava/lang/String;Ljava/lang/String;Ljava/nio/file/Path;Ljava/lang/String;Lp9/l;)Lio/ktor/server/routing/Route;", "Ljava/lang/ClassLoader;", "classLoader", "Ljava/nio/file/FileSystem;", "getFileSystem", "(Ljava/nio/file/Path;Ljava/lang/ClassLoader;)Ljava/nio/file/FileSystem;", "Lio/ktor/server/http/content/FileSystemPaths;", "fileSystem", "staticFileSystem", "(Lio/ktor/server/routing/Route;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/ktor/server/http/content/FileSystemPaths;Lp9/l;)Lio/ktor/server/routing/Route;", "", "Lio/ktor/server/http/content/CompressedFileType;", "types", "configure", "preCompressed", "(Lio/ktor/server/routing/Route;[Lio/ktor/server/http/content/CompressedFileType;Lp9/l;)V", Const.STR_FILE, "combine", "(Ljava/io/File;Ljava/io/File;)Ljava/io/File;", "static", "(Lio/ktor/server/routing/Route;Lp9/l;)Lio/ktor/server/routing/Route;", "(Lio/ktor/server/routing/Route;Ljava/lang/String;Lp9/l;)Lio/ktor/server/routing/Route;", "localPath", "default", "(Lio/ktor/server/routing/Route;Ljava/lang/String;)V", "(Lio/ktor/server/routing/Route;Ljava/io/File;)V", "(Lio/ktor/server/routing/Route;Ljava/lang/String;Ljava/lang/String;)V", "(Lio/ktor/server/routing/Route;Ljava/lang/String;Ljava/io/File;)V", "folder", "files", "resourcePackage", "combinePackage", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "resource", "(Lio/ktor/server/routing/Route;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "resources", "defaultResource", "Lio/ktor/server/application/ApplicationCall;", "", "isStaticContent", "(Lio/ktor/server/application/ApplicationCall;)Z", "autoHead", "Lkotlin/Function2;", "Le9/c;", "", "handler", "staticContentRoute", "(Lio/ktor/server/routing/Route;Ljava/lang/String;ZLp9/p;)Lio/ktor/server/routing/Route;", "", "compressedTypes", "Lio/ktor/http/ContentType;", "contentType", "Lio/ktor/http/CacheControl;", "cacheControl", "Lkotlin/Function3;", "modify", "exclude", "extensions", "defaultPath", "respondStaticFile", "(Lio/ktor/server/application/ApplicationCall;Ljava/lang/String;Ljava/io/File;Ljava/util/List;Lp9/l;Lp9/l;Lp9/q;Lp9/l;Ljava/util/List;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "respondStaticPath", "(Lio/ktor/server/application/ApplicationCall;Lio/ktor/server/http/content/FileSystemPaths;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lp9/l;Lp9/l;Lp9/q;Lp9/l;Ljava/util/List;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "modifier", "respondStaticResource", "(Lio/ktor/server/application/ApplicationCall;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lp9/l;Lp9/l;Lp9/q;Lp9/l;Ljava/util/List;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Lio/ktor/util/AttributeKey;", "StaticFileLocationProperty", "Lio/ktor/util/AttributeKey;", "getStaticFileLocationProperty", "()Lio/ktor/util/AttributeKey;", "pathParameterName", "Ljava/lang/String;", "staticRootFolderKey", "Lio/ktor/server/application/RouteScopedPlugin;", "StaticContentAutoHead", "Lio/ktor/server/application/RouteScopedPlugin;", "staticBasePackageName", UxipConstants.f30680s, "getStaticRootFolder", "(Lio/ktor/server/routing/Route;)Ljava/io/File;", "setStaticRootFolder", "staticRootFolder", "getStaticBasePackage", "(Lio/ktor/server/routing/Route;)Ljava/lang/String;", "setStaticBasePackage", "getStaticBasePackage$annotations", "(Lio/ktor/server/routing/Route;)V", "staticBasePackage", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StaticContentKt {
    private static final RouteScopedPlugin<Y8.t> StaticContentAutoHead;
    private static final AttributeKey<String> StaticFileLocationProperty;
    private static final String pathParameterName = "static-content-path-parameter";
    private static final AttributeKey<String> staticBasePackageName;
    private static final AttributeKey<File> staticRootFolderKey;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/routing/RoutingContext;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/routing/RoutingContext;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.http.content.StaticContentKt$default$1", f = "StaticContent.kt", l = {463}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.http.content.StaticContentKt$default$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<RoutingContext, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ List<CompressedFileType> $compressedTypes;
        final /* synthetic */ File $file;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(File file, List<? extends CompressedFileType> list, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$file = file;
            this.$compressedTypes = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$file, this.$compressedTypes, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(RoutingContext routingContext, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(routingContext, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                RoutingCall call = ((RoutingContext) this.L$0).getCall();
                File file = this.$file;
                List<CompressedFileType> list = this.$compressedTypes;
                this.label = 1;
                if (PreCompressedKt.respondStaticFile$default(call, file, list, null, null, null, this, 28, null) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/routing/RoutingContext;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/routing/RoutingContext;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.http.content.StaticContentKt$defaultResource$1", f = "StaticContent.kt", l = {591}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.http.content.StaticContentKt$defaultResource$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43671 extends SuspendLambda implements p9.p<RoutingContext, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ List<CompressedFileType> $compressedTypes;
        final /* synthetic */ String $packageName;
        final /* synthetic */ String $resource;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C43671(String str, String str2, List<? extends CompressedFileType> list, InterfaceC4014c<? super C43671> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$resource = str;
            this.$packageName = str2;
            this.$compressedTypes = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C43671 c43671 = new C43671(this.$resource, this.$packageName, this.$compressedTypes, interfaceC4014c);
            c43671.L$0 = obj;
            return c43671;
        }

        @Override // p9.p
        public final Object invoke(RoutingContext routingContext, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C43671) create(routingContext, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                RoutingCall call = ((RoutingContext) this.L$0).getCall();
                String str = this.$resource;
                String str2 = this.$packageName;
                List<CompressedFileType> list = this.$compressedTypes;
                this.label = 1;
                if (PreCompressedKt.respondStaticResource$default(call, str, str2, list, null, null, null, null, this, 120, null) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/routing/RoutingContext;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/routing/RoutingContext;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.http.content.StaticContentKt$file$1", f = "StaticContent.kt", l = {487}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.http.content.StaticContentKt$file$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43681 extends SuspendLambda implements p9.p<RoutingContext, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ List<CompressedFileType> $compressedTypes;
        final /* synthetic */ File $file;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C43681(File file, List<? extends CompressedFileType> list, InterfaceC4014c<? super C43681> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$file = file;
            this.$compressedTypes = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C43681 c43681 = new C43681(this.$file, this.$compressedTypes, interfaceC4014c);
            c43681.L$0 = obj;
            return c43681;
        }

        @Override // p9.p
        public final Object invoke(RoutingContext routingContext, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C43681) create(routingContext, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                RoutingCall call = ((RoutingContext) this.L$0).getCall();
                File file = this.$file;
                List<CompressedFileType> list = this.$compressedTypes;
                this.label = 1;
                if (PreCompressedKt.respondStaticFile$default(call, file, list, null, null, null, this, 28, null) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/routing/RoutingContext;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/routing/RoutingContext;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.http.content.StaticContentKt$files$1", f = "StaticContent.kt", l = {512}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.http.content.StaticContentKt$files$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43691 extends SuspendLambda implements p9.p<RoutingContext, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ List<CompressedFileType> $compressedTypes;
        final /* synthetic */ File $dir;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C43691(File file, List<? extends CompressedFileType> list, InterfaceC4014c<? super C43691> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$dir = file;
            this.$compressedTypes = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C43691 c43691 = new C43691(this.$dir, this.$compressedTypes, interfaceC4014c);
            c43691.L$0 = obj;
            return c43691;
        }

        @Override // p9.p
        public final Object invoke(RoutingContext routingContext, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C43691) create(routingContext, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                RoutingContext routingContext = (RoutingContext) this.L$0;
                List<String> all = routingContext.getCall().getParameters().getAll(StaticContentKt.pathParameterName);
                if (all != null) {
                    String separator = File.separator;
                    kotlin.jvm.internal.p.h(separator, "separator");
                    String strA0 = Z8.F.A0(all, separator, null, null, 0, null, null, 62, null);
                    if (strA0 != null) {
                        File fileCombineSafe = PathKt.combineSafe(this.$dir, strA0);
                        RoutingCall call = routingContext.getCall();
                        List<CompressedFileType> list = this.$compressedTypes;
                        this.label = 1;
                        if (PreCompressedKt.respondStaticFile$default(call, fileCombineSafe, list, null, null, null, this, 28, null) == objG) {
                            return objG;
                        }
                    }
                }
                return Y8.t.f7040a;
            }
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/routing/RoutingContext;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/routing/RoutingContext;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.http.content.StaticContentKt$resource$1", f = "StaticContent.kt", l = {552}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.http.content.StaticContentKt$resource$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43701 extends SuspendLambda implements p9.p<RoutingContext, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ List<CompressedFileType> $compressedTypes;
        final /* synthetic */ String $packageName;
        final /* synthetic */ String $resource;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C43701(String str, String str2, List<? extends CompressedFileType> list, InterfaceC4014c<? super C43701> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$resource = str;
            this.$packageName = str2;
            this.$compressedTypes = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C43701 c43701 = new C43701(this.$resource, this.$packageName, this.$compressedTypes, interfaceC4014c);
            c43701.L$0 = obj;
            return c43701;
        }

        @Override // p9.p
        public final Object invoke(RoutingContext routingContext, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C43701) create(routingContext, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                RoutingCall call = ((RoutingContext) this.L$0).getCall();
                String str = this.$resource;
                String str2 = this.$packageName;
                List<CompressedFileType> list = this.$compressedTypes;
                this.label = 1;
                if (PreCompressedKt.respondStaticResource$default(call, str, str2, list, null, null, null, null, this, 120, null) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/routing/RoutingContext;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/routing/RoutingContext;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.http.content.StaticContentKt$resources$1", f = "StaticContent.kt", l = {572}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.http.content.StaticContentKt$resources$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43711 extends SuspendLambda implements p9.p<RoutingContext, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ List<CompressedFileType> $compressedTypes;
        final /* synthetic */ String $packageName;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C43711(String str, List<? extends CompressedFileType> list, InterfaceC4014c<? super C43711> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$packageName = str;
            this.$compressedTypes = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C43711 c43711 = new C43711(this.$packageName, this.$compressedTypes, interfaceC4014c);
            c43711.L$0 = obj;
            return c43711;
        }

        @Override // p9.p
        public final Object invoke(RoutingContext routingContext, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C43711) create(routingContext, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                RoutingContext routingContext = (RoutingContext) this.L$0;
                List<String> all = routingContext.getCall().getParameters().getAll(StaticContentKt.pathParameterName);
                if (all != null) {
                    String separator = File.separator;
                    kotlin.jvm.internal.p.h(separator, "separator");
                    String strA0 = Z8.F.A0(all, separator, null, null, 0, null, null, 62, null);
                    if (strA0 != null) {
                        RoutingCall call = routingContext.getCall();
                        String str = this.$packageName;
                        List<CompressedFileType> list = this.$compressedTypes;
                        this.label = 1;
                        if (PreCompressedKt.respondStaticResource$default(call, strA0, str, list, null, null, null, null, this, 120, null) == objG) {
                            return objG;
                        }
                    }
                }
                return Y8.t.f7040a;
            }
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return Y8.t.f7040a;
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.http.content.StaticContentKt", f = "StaticContent.kt", l = {655, 657, 659, 663, 664, 671}, m = "respondStaticFile")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.http.content.StaticContentKt$respondStaticFile$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43721 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C43721(InterfaceC4014c<? super C43721> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StaticContentKt.respondStaticFile(null, null, null, null, null, null, null, null, null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.http.content.StaticContentKt", f = "StaticContent.kt", l = {698, 700, 702, 706, 707, 714}, m = "respondStaticPath")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.http.content.StaticContentKt$respondStaticPath$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43731 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C43731(InterfaceC4014c<? super C43731> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StaticContentKt.respondStaticPath(null, null, null, null, null, null, null, null, null, null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.http.content.StaticContentKt", f = "StaticContent.kt", l = {738, 750, 763, 774}, m = "respondStaticResource")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.http.content.StaticContentKt$respondStaticResource$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43741 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C43741(InterfaceC4014c<? super C43741> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StaticContentKt.respondStaticResource(null, null, null, null, null, null, null, null, null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/application/ApplicationCall;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/application/ApplicationCall;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.http.content.StaticContentKt$staticFileSystem$2", f = "StaticContent.kt", l = {365}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.http.content.StaticContentKt$staticFileSystem$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<ApplicationCall, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ String $basePath;
        final /* synthetic */ InterfaceC5074l<Path, List<CacheControl>> $cacheControl;
        final /* synthetic */ List<CompressedFileType> $compressedTypes;
        final /* synthetic */ InterfaceC5074l<Path, ContentType> $contentType;
        final /* synthetic */ String $defaultPath;
        final /* synthetic */ InterfaceC5074l<Path, Boolean> $exclude;
        final /* synthetic */ List<String> $extensions;
        final /* synthetic */ FileSystemPaths $fileSystem;
        final /* synthetic */ String $index;
        final /* synthetic */ p9.q<Path, ApplicationCall, InterfaceC4014c<? super Y8.t>, Object> $modify;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(FileSystemPaths fileSystemPaths, String str, String str2, List<? extends CompressedFileType> list, InterfaceC5074l<? super Path, ContentType> interfaceC5074l, InterfaceC5074l<? super Path, ? extends List<? extends CacheControl>> interfaceC5074l2, p9.q<? super Path, ? super ApplicationCall, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> qVar, InterfaceC5074l<? super Path, Boolean> interfaceC5074l3, List<String> list2, String str3, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$fileSystem = fileSystemPaths;
            this.$index = str;
            this.$basePath = str2;
            this.$compressedTypes = list;
            this.$contentType = interfaceC5074l;
            this.$cacheControl = interfaceC5074l2;
            this.$modify = qVar;
            this.$exclude = interfaceC5074l3;
            this.$extensions = list2;
            this.$defaultPath = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$fileSystem, this.$index, this.$basePath, this.$compressedTypes, this.$contentType, this.$cacheControl, this.$modify, this.$exclude, this.$extensions, this.$defaultPath, interfaceC4014c);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // p9.p
        public final Object invoke(ApplicationCall applicationCall, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass2) create(applicationCall, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                ApplicationCall applicationCall = (ApplicationCall) this.L$0;
                FileSystemPaths fileSystemPaths = this.$fileSystem;
                String str = this.$index;
                String str2 = this.$basePath;
                List<CompressedFileType> list = this.$compressedTypes;
                InterfaceC5074l<Path, ContentType> interfaceC5074l = this.$contentType;
                InterfaceC5074l<Path, List<CacheControl>> interfaceC5074l2 = this.$cacheControl;
                p9.q<Path, ApplicationCall, InterfaceC4014c<? super Y8.t>, Object> qVar = this.$modify;
                InterfaceC5074l<Path, Boolean> interfaceC5074l3 = this.$exclude;
                List<String> list2 = this.$extensions;
                String str3 = this.$defaultPath;
                this.label = 1;
                if (StaticContentKt.respondStaticPath(applicationCall, fileSystemPaths, str, str2, list, interfaceC5074l, interfaceC5074l2, qVar, interfaceC5074l3, list2, str3, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/application/ApplicationCall;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/application/ApplicationCall;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.http.content.StaticContentKt$staticFiles$2", f = "StaticContent.kt", l = {211}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.http.content.StaticContentKt$staticFiles$2, reason: invalid class name and case insensitive filesystem */
    public static final class C43762 extends SuspendLambda implements p9.p<ApplicationCall, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ InterfaceC5074l<File, List<CacheControl>> $cacheControl;
        final /* synthetic */ List<CompressedFileType> $compressedTypes;
        final /* synthetic */ InterfaceC5074l<File, ContentType> $contentType;
        final /* synthetic */ String $defaultPath;
        final /* synthetic */ File $dir;
        final /* synthetic */ InterfaceC5074l<File, Boolean> $exclude;
        final /* synthetic */ List<String> $extensions;
        final /* synthetic */ String $index;
        final /* synthetic */ p9.q<File, ApplicationCall, InterfaceC4014c<? super Y8.t>, Object> $modify;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C43762(String str, File file, List<? extends CompressedFileType> list, InterfaceC5074l<? super File, ContentType> interfaceC5074l, InterfaceC5074l<? super File, ? extends List<? extends CacheControl>> interfaceC5074l2, p9.q<? super File, ? super ApplicationCall, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> qVar, InterfaceC5074l<? super File, Boolean> interfaceC5074l3, List<String> list2, String str2, InterfaceC4014c<? super C43762> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$index = str;
            this.$dir = file;
            this.$compressedTypes = list;
            this.$contentType = interfaceC5074l;
            this.$cacheControl = interfaceC5074l2;
            this.$modify = qVar;
            this.$exclude = interfaceC5074l3;
            this.$extensions = list2;
            this.$defaultPath = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C43762 c43762 = new C43762(this.$index, this.$dir, this.$compressedTypes, this.$contentType, this.$cacheControl, this.$modify, this.$exclude, this.$extensions, this.$defaultPath, interfaceC4014c);
            c43762.L$0 = obj;
            return c43762;
        }

        @Override // p9.p
        public final Object invoke(ApplicationCall applicationCall, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C43762) create(applicationCall, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                ApplicationCall applicationCall = (ApplicationCall) this.L$0;
                String str = this.$index;
                File file = this.$dir;
                List<CompressedFileType> list = this.$compressedTypes;
                InterfaceC5074l<File, ContentType> interfaceC5074l = this.$contentType;
                InterfaceC5074l<File, List<CacheControl>> interfaceC5074l2 = this.$cacheControl;
                p9.q<File, ApplicationCall, InterfaceC4014c<? super Y8.t>, Object> qVar = this.$modify;
                InterfaceC5074l<File, Boolean> interfaceC5074l3 = this.$exclude;
                List<String> list2 = this.$extensions;
                String str2 = this.$defaultPath;
                this.label = 1;
                if (StaticContentKt.respondStaticFile(applicationCall, str, file, list, interfaceC5074l, interfaceC5074l2, qVar, interfaceC5074l3, list2, str2, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/application/ApplicationCall;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/application/ApplicationCall;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.http.content.StaticContentKt$staticResources$2", f = "StaticContent.kt", l = {253}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.http.content.StaticContentKt$staticResources$2, reason: invalid class name and case insensitive filesystem */
    public static final class C43772 extends SuspendLambda implements p9.p<ApplicationCall, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ String $basePackage;
        final /* synthetic */ InterfaceC5074l<URL, List<CacheControl>> $cacheControl;
        final /* synthetic */ List<CompressedFileType> $compressedTypes;
        final /* synthetic */ InterfaceC5074l<URL, ContentType> $contentType;
        final /* synthetic */ String $defaultPath;
        final /* synthetic */ InterfaceC5074l<URL, Boolean> $exclude;
        final /* synthetic */ List<String> $extensions;
        final /* synthetic */ String $index;
        final /* synthetic */ p9.q<URL, ApplicationCall, InterfaceC4014c<? super Y8.t>, Object> $modifier;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C43772(String str, String str2, List<? extends CompressedFileType> list, InterfaceC5074l<? super URL, ContentType> interfaceC5074l, InterfaceC5074l<? super URL, ? extends List<? extends CacheControl>> interfaceC5074l2, p9.q<? super URL, ? super ApplicationCall, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> qVar, InterfaceC5074l<? super URL, Boolean> interfaceC5074l3, List<String> list2, String str3, InterfaceC4014c<? super C43772> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$index = str;
            this.$basePackage = str2;
            this.$compressedTypes = list;
            this.$contentType = interfaceC5074l;
            this.$cacheControl = interfaceC5074l2;
            this.$modifier = qVar;
            this.$exclude = interfaceC5074l3;
            this.$extensions = list2;
            this.$defaultPath = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C43772 c43772 = new C43772(this.$index, this.$basePackage, this.$compressedTypes, this.$contentType, this.$cacheControl, this.$modifier, this.$exclude, this.$extensions, this.$defaultPath, interfaceC4014c);
            c43772.L$0 = obj;
            return c43772;
        }

        @Override // p9.p
        public final Object invoke(ApplicationCall applicationCall, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C43772) create(applicationCall, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                ApplicationCall applicationCall = (ApplicationCall) this.L$0;
                String str = this.$index;
                String str2 = this.$basePackage;
                List<CompressedFileType> list = this.$compressedTypes;
                InterfaceC5074l<URL, ContentType> interfaceC5074l = this.$contentType;
                InterfaceC5074l<URL, List<CacheControl>> interfaceC5074l2 = this.$cacheControl;
                p9.q<URL, ApplicationCall, InterfaceC4014c<? super Y8.t>, Object> qVar = this.$modifier;
                InterfaceC5074l<URL, Boolean> interfaceC5074l3 = this.$exclude;
                List<String> list2 = this.$extensions;
                String str3 = this.$defaultPath;
                this.label = 1;
                if (StaticContentKt.respondStaticResource(applicationCall, str, str2, list, interfaceC5074l, interfaceC5074l2, qVar, interfaceC5074l3, list2, str3, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    static {
        InterfaceC5755n interfaceC5755nM;
        InterfaceC5755n interfaceC5755nM2;
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(String.class);
        InterfaceC5755n interfaceC5755nM3 = null;
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(String.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        StaticFileLocationProperty = new AttributeKey<>("StaticFileLocation", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
        InterfaceC5745d interfaceC5745dB2 = kotlin.jvm.internal.t.b(File.class);
        try {
            interfaceC5755nM2 = kotlin.jvm.internal.t.m(File.class);
        } catch (Throwable unused2) {
            interfaceC5755nM2 = null;
        }
        staticRootFolderKey = new AttributeKey<>("BaseFolder", new TypeInfo(interfaceC5745dB2, interfaceC5755nM2));
        StaticContentAutoHead = CreatePluginUtilsKt.createRouteScopedPlugin("StaticContentAutoHead", new InterfaceC5074l() { // from class: io.ktor.server.http.content.B
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StaticContentKt.StaticContentAutoHead$lambda$0((RouteScopedPluginBuilder) obj);
            }
        });
        InterfaceC5745d interfaceC5745dB3 = kotlin.jvm.internal.t.b(String.class);
        try {
            interfaceC5755nM3 = kotlin.jvm.internal.t.m(String.class);
        } catch (Throwable unused3) {
        }
        staticBasePackageName = new AttributeKey<>("BasePackage", new TypeInfo(interfaceC5745dB3, interfaceC5755nM3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t StaticContentAutoHead$lambda$0(RouteScopedPluginBuilder createRouteScopedPlugin) {
        kotlin.jvm.internal.p.i(createRouteScopedPlugin, "$this$createRouteScopedPlugin");
        createRouteScopedPlugin.on(ResponseBodyReadyForSend.INSTANCE, new StaticContentKt$StaticContentAutoHead$1$1(null));
        return Y8.t.f7040a;
    }

    private static final File combine(File file, File file2) {
        return file == null ? file2 : l9.k.z(file, file2);
    }

    private static final String combinePackage(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        return str + '.' + str2;
    }

    /* renamed from: default, reason: not valid java name */
    public static final void m174default(Route route, String localPath) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(localPath, "localPath");
        m173default(route, new File(localPath));
    }

    public static final void defaultResource(Route route, String resource, String str) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(resource, "resource");
        RoutingBuilderKt.get(route, new C43671(resource, combinePackage(getStaticBasePackage(route), str), PreCompressedKt.getStaticContentEncodedTypes(route), null));
    }

    public static /* synthetic */ void defaultResource$default(Route route, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        defaultResource(route, str, str2);
    }

    public static final void file(Route route, String remotePath, String localPath) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(remotePath, "remotePath");
        kotlin.jvm.internal.p.i(localPath, "localPath");
        file(route, remotePath, new File(localPath));
    }

    public static /* synthetic */ void file$default(Route route, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        file(route, str, str2);
    }

    public static final void files(Route route, String folder) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(folder, "folder");
        files(route, new File(folder));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileSystem getFileSystem(Path path, ClassLoader classLoader) throws IOException {
        FileSystem fileSystemNewFileSystem = FileSystems.newFileSystem(path, classLoader);
        kotlin.jvm.internal.p.h(fileSystemNewFileSystem, "newFileSystem(...)");
        return fileSystemNewFileSystem;
    }

    public static final String getStaticBasePackage(Route route) {
        kotlin.jvm.internal.p.i(route, "<this>");
        String str = (String) route.getAttributes().getOrNull(staticBasePackageName);
        if (str != null) {
            return str;
        }
        Route parent = route.getParent();
        if (parent != null) {
            return getStaticBasePackage(parent);
        }
        return null;
    }

    public static /* synthetic */ void getStaticBasePackage$annotations(Route route) {
    }

    public static final AttributeKey<String> getStaticFileLocationProperty() {
        return StaticFileLocationProperty;
    }

    public static final File getStaticRootFolder(Route route) {
        kotlin.jvm.internal.p.i(route, "<this>");
        File file = (File) route.getAttributes().getOrNull(staticRootFolderKey);
        if (file != null) {
            return file;
        }
        Route parent = route.getParent();
        if (parent != null) {
            return getStaticRootFolder(parent);
        }
        return null;
    }

    public static final boolean isStaticContent(ApplicationCall applicationCall) {
        kotlin.jvm.internal.p.i(applicationCall, "<this>");
        return applicationCall.getAttributes().contains(StaticFileLocationProperty);
    }

    public static final void preCompressed(Route route, CompressedFileType[] types, InterfaceC5074l<? super Route, Y8.t> configure) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(types, "types");
        kotlin.jvm.internal.p.i(configure, "configure");
        List<CompressedFileType> staticContentEncodedTypes = PreCompressedKt.getStaticContentEncodedTypes(route);
        if (staticContentEncodedTypes == null) {
            staticContentEncodedTypes = C1173v.m();
        }
        route.getAttributes().put(PreCompressedKt.getCompressedKey(), Z8.F.g0(Z8.F.S0(staticContentEncodedTypes, C1168p.d(types))));
        configure.invoke(route);
        route.getAttributes().remove(PreCompressedKt.getCompressedKey());
    }

    public static /* synthetic */ void preCompressed$default(Route route, CompressedFileType[] compressedFileTypeArr, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            compressedFileTypeArr = (CompressedFileType[]) CompressedFileType.getEntries().toArray(new CompressedFileType[0]);
        }
        preCompressed(route, compressedFileTypeArr, interfaceC5074l);
    }

    public static final void resource(Route route, String remotePath, String resource, String str) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(remotePath, "remotePath");
        kotlin.jvm.internal.p.i(resource, "resource");
        RoutingBuilderKt.get(route, remotePath, new C43701(resource, combinePackage(getStaticBasePackage(route), str), PreCompressedKt.getStaticContentEncodedTypes(route), null));
    }

    public static /* synthetic */ void resource$default(Route route, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        resource(route, str, str2, str3);
    }

    public static final void resources(Route route, String str) {
        kotlin.jvm.internal.p.i(route, "<this>");
        RoutingBuilderKt.get(route, "{static-content-path-parameter...}", new C43711(combinePackage(getStaticBasePackage(route), str), PreCompressedKt.getStaticContentEncodedTypes(route), null));
    }

    public static /* synthetic */ void resources$default(Route route, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        resources(route, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0185, code lost:
    
        if (io.ktor.server.http.content.PreCompressedKt.respondStaticFile(r24, r6, r2, r3, r4, r30, r10) == r11) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x02f5, code lost:
    
        if (io.ktor.server.http.content.PreCompressedKt.respondStaticFile(r6, r0, r2, r3, r4, r1, r10) != r11) goto L75;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x029c -> B:61:0x02a6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object respondStaticFile(io.ktor.server.application.ApplicationCall r24, java.lang.String r25, java.io.File r26, java.util.List<? extends io.ktor.server.http.content.CompressedFileType> r27, p9.InterfaceC5074l<? super java.io.File, io.ktor.http.ContentType> r28, p9.InterfaceC5074l<? super java.io.File, ? extends java.util.List<? extends io.ktor.http.CacheControl>> r29, p9.q<? super java.io.File, ? super io.ktor.server.application.ApplicationCall, ? super e9.InterfaceC4014c<? super Y8.t>, ? extends java.lang.Object> r30, p9.InterfaceC5074l<? super java.io.File, java.lang.Boolean> r31, java.util.List<java.lang.String> r32, java.lang.String r33, e9.InterfaceC4014c<? super Y8.t> r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 788
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.http.content.StaticContentKt.respondStaticFile(io.ktor.server.application.ApplicationCall, java.lang.String, java.io.File, java.util.List, p9.l, p9.l, p9.q, p9.l, java.util.List, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object respondStaticFile$checkExclude(p9.InterfaceC5074l<? super java.io.File, java.lang.Boolean> r4, io.ktor.server.application.ApplicationCall r5, java.io.File r6, e9.InterfaceC4014c<? super java.lang.Boolean> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.server.http.content.StaticContentKt$respondStaticFile$checkExclude$1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.server.http.content.StaticContentKt$respondStaticFile$checkExclude$1 r0 = (io.ktor.server.http.content.StaticContentKt$respondStaticFile$checkExclude$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.http.content.StaticContentKt$respondStaticFile$checkExclude$1 r0 = new io.ktor.server.http.content.StaticContentKt$respondStaticFile$checkExclude$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r7)
            goto L66
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r7)
            java.lang.Object r4 = r4.invoke(r6)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L46
            r4 = 0
            java.lang.Boolean r4 = g9.C4109a.a(r4)
            return r4
        L46:
            io.ktor.http.HttpStatusCode$Companion r4 = io.ktor.http.HttpStatusCode.INSTANCE
            io.ktor.http.HttpStatusCode r4 = r4.getForbidden()
            java.lang.Class<io.ktor.http.HttpStatusCode> r6 = io.ktor.http.HttpStatusCode.class
            w9.d r7 = kotlin.jvm.internal.t.b(r6)
            w9.n r6 = kotlin.jvm.internal.t.m(r6)     // Catch: java.lang.Throwable -> L57
            goto L58
        L57:
            r6 = 0
        L58:
            io.ktor.util.reflect.TypeInfo r2 = new io.ktor.util.reflect.TypeInfo
            r2.<init>(r7, r6)
            r0.label = r3
            java.lang.Object r4 = r5.respond(r4, r2, r0)
            if (r4 != r1) goto L66
            return r1
        L66:
            java.lang.Boolean r4 = g9.C4109a.a(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.http.content.StaticContentKt.respondStaticFile$checkExclude(p9.l, io.ktor.server.application.ApplicationCall, java.io.File, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0368, code lost:
    
        if (io.ktor.server.http.content.PreCompressedKt.respondStaticPath(r7, r6, r0, r4, r3, r5, r1, r11) != r12) goto L84;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0327 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x032a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0331  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x02ff -> B:67:0x030a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object respondStaticPath(io.ktor.server.application.ApplicationCall r26, io.ktor.server.http.content.FileSystemPaths r27, java.lang.String r28, java.lang.String r29, java.util.List<? extends io.ktor.server.http.content.CompressedFileType> r30, p9.InterfaceC5074l<? super java.nio.file.Path, io.ktor.http.ContentType> r31, p9.InterfaceC5074l<? super java.nio.file.Path, ? extends java.util.List<? extends io.ktor.http.CacheControl>> r32, p9.q<? super java.nio.file.Path, ? super io.ktor.server.application.ApplicationCall, ? super e9.InterfaceC4014c<? super Y8.t>, ? extends java.lang.Object> r33, p9.InterfaceC5074l<? super java.nio.file.Path, java.lang.Boolean> r34, java.util.List<java.lang.String> r35, java.lang.String r36, e9.InterfaceC4014c<? super Y8.t> r37) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 902
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.http.content.StaticContentKt.respondStaticPath(io.ktor.server.application.ApplicationCall, io.ktor.server.http.content.FileSystemPaths, java.lang.String, java.lang.String, java.util.List, p9.l, p9.l, p9.q, p9.l, java.util.List, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object respondStaticPath$checkExclude$9(p9.InterfaceC5074l<? super java.nio.file.Path, java.lang.Boolean> r4, io.ktor.server.application.ApplicationCall r5, java.nio.file.Path r6, e9.InterfaceC4014c<? super java.lang.Boolean> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.server.http.content.StaticContentKt$respondStaticPath$checkExclude$1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.server.http.content.StaticContentKt$respondStaticPath$checkExclude$1 r0 = (io.ktor.server.http.content.StaticContentKt$respondStaticPath$checkExclude$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.http.content.StaticContentKt$respondStaticPath$checkExclude$1 r0 = new io.ktor.server.http.content.StaticContentKt$respondStaticPath$checkExclude$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r7)
            goto L66
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r7)
            java.lang.Object r4 = r4.invoke(r6)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L46
            r4 = 0
            java.lang.Boolean r4 = g9.C4109a.a(r4)
            return r4
        L46:
            io.ktor.http.HttpStatusCode$Companion r4 = io.ktor.http.HttpStatusCode.INSTANCE
            io.ktor.http.HttpStatusCode r4 = r4.getForbidden()
            java.lang.Class<io.ktor.http.HttpStatusCode> r6 = io.ktor.http.HttpStatusCode.class
            w9.d r7 = kotlin.jvm.internal.t.b(r6)
            w9.n r6 = kotlin.jvm.internal.t.m(r6)     // Catch: java.lang.Throwable -> L57
            goto L58
        L57:
            r6 = 0
        L58:
            io.ktor.util.reflect.TypeInfo r2 = new io.ktor.util.reflect.TypeInfo
            r2.<init>(r7, r6)
            r0.label = r3
            java.lang.Object r4 = r5.respond(r4, r2, r0)
            if (r4 != r1) goto L66
            return r1
        L66:
            java.lang.Boolean r4 = g9.C4109a.a(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.http.content.StaticContentKt.respondStaticPath$checkExclude$9(p9.l, io.ktor.server.application.ApplicationCall, java.nio.file.Path, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x01a6, code lost:
    
        if (r0 == r1) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0255, code lost:
    
        if (io.ktor.server.http.content.PreCompressedKt.respondStaticResource$default(r11, r12, r13, r14, r15, r16, r17, null, r10, 64, null) == r1) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x022c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x01a6 -> B:20:0x0092). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object respondStaticResource(io.ktor.server.application.ApplicationCall r29, java.lang.String r30, java.lang.String r31, java.util.List<? extends io.ktor.server.http.content.CompressedFileType> r32, p9.InterfaceC5074l<? super java.net.URL, io.ktor.http.ContentType> r33, p9.InterfaceC5074l<? super java.net.URL, ? extends java.util.List<? extends io.ktor.http.CacheControl>> r34, p9.q<? super java.net.URL, ? super io.ktor.server.application.ApplicationCall, ? super e9.InterfaceC4014c<? super Y8.t>, ? extends java.lang.Object> r35, p9.InterfaceC5074l<? super java.net.URL, java.lang.Boolean> r36, java.util.List<java.lang.String> r37, java.lang.String r38, e9.InterfaceC4014c<? super Y8.t> r39) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 609
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.http.content.StaticContentKt.respondStaticResource(io.ktor.server.application.ApplicationCall, java.lang.String, java.lang.String, java.util.List, p9.l, p9.l, p9.q, p9.l, java.util.List, java.lang.String, e9.c):java.lang.Object");
    }

    public static final void setStaticBasePackage(Route route, String str) {
        kotlin.jvm.internal.p.i(route, "<this>");
        if (str != null) {
            route.getAttributes().put(staticBasePackageName, str);
        } else {
            route.getAttributes().remove(staticBasePackageName);
        }
    }

    public static final void setStaticRootFolder(Route route, File file) {
        kotlin.jvm.internal.p.i(route, "<this>");
        if (file != null) {
            route.getAttributes().put(staticRootFolderKey, file);
        } else {
            route.getAttributes().remove(staticRootFolderKey);
        }
    }

    /* renamed from: static, reason: not valid java name */
    public static final Route m176static(Route route, InterfaceC5074l<? super Route, Y8.t> configure) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(configure, "configure");
        configure.invoke(route);
        return route;
    }

    private static final Route staticContentRoute(Route route, String str, final boolean z10, final p9.p<? super ApplicationCall, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar) {
        Route routeCreateChild = route.createChild(new RouteSelector() { // from class: io.ktor.server.http.content.StaticContentKt.staticContentRoute.1
            @Override // io.ktor.server.routing.RouteSelector
            public Object evaluate(RoutingResolveContext routingResolveContext, int i10, InterfaceC4014c<? super RouteSelectorEvaluation> interfaceC4014c) {
                return new RouteSelectorEvaluation.Success(0.1d, null, 0, 6, null);
            }

            public String toString() {
                return "(staticContent)";
            }
        });
        RoutingBuilderKt.route(routeCreateChild, str, new InterfaceC5074l() { // from class: io.ktor.server.http.content.D
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StaticContentKt.staticContentRoute$lambda$8$lambda$7(z10, pVar, (Route) obj);
            }
        });
        return routeCreateChild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t staticContentRoute$lambda$8$lambda$7(final boolean z10, final p9.p pVar, Route route) {
        kotlin.jvm.internal.p.i(route, "$this$route");
        RoutingBuilderKt.route(route, "{static-content-path-parameter...}", new InterfaceC5074l() { // from class: io.ktor.server.http.content.F
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StaticContentKt.staticContentRoute$lambda$8$lambda$7$lambda$6(z10, pVar, (Route) obj);
            }
        });
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t staticContentRoute$lambda$8$lambda$7$lambda$6(boolean z10, final p9.p pVar, Route route) {
        kotlin.jvm.internal.p.i(route, "$this$route");
        RoutingBuilderKt.get(route, new StaticContentKt$staticContentRoute$2$1$1$1(pVar, null));
        if (z10) {
            RoutingBuilderKt.method(route, HttpMethod.INSTANCE.getHead(), new InterfaceC5074l() { // from class: io.ktor.server.http.content.A
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return StaticContentKt.staticContentRoute$lambda$8$lambda$7$lambda$6$lambda$5(pVar, (Route) obj);
                }
            });
        }
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t staticContentRoute$lambda$8$lambda$7$lambda$6$lambda$5(p9.p pVar, Route method) {
        kotlin.jvm.internal.p.i(method, "$this$method");
        Route.DefaultImpls.install$default(method, StaticContentAutoHead, null, 2, null);
        method.handle(new StaticContentKt$staticContentRoute$2$1$1$2$1(pVar, null));
        return Y8.t.f7040a;
    }

    public static final Route staticFileSystem(Route route, String remotePath, String str, String str2, FileSystemPaths fileSystem, InterfaceC5074l<? super StaticContentConfig<Path>, Y8.t> block) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(remotePath, "remotePath");
        kotlin.jvm.internal.p.i(fileSystem, "fileSystem");
        kotlin.jvm.internal.p.i(block, "block");
        StaticContentConfig staticContentConfig = new StaticContentConfig();
        block.invoke(staticContentConfig);
        return staticContentRoute(route, remotePath, staticContentConfig.getAutoHeadResponse(), new AnonymousClass2(fileSystem, str2, str, staticContentConfig.getPreCompressedFileTypes$ktor_server_core(), staticContentConfig.getContentType$ktor_server_core(), staticContentConfig.getCacheControl$ktor_server_core(), staticContentConfig.getModifier$ktor_server_core(), staticContentConfig.getExclude$ktor_server_core(), staticContentConfig.getExtensions$ktor_server_core(), staticContentConfig.getDefaultPath(), null));
    }

    public static /* synthetic */ Route staticFileSystem$default(Route route, String str, String str2, String str3, FileSystemPaths fileSystemPaths, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = "index.html";
        }
        String str4 = str3;
        if ((i10 & 8) != 0) {
            FileSystemPaths.Companion companion = FileSystemPaths.INSTANCE;
            FileSystem fileSystem = FileSystems.getDefault();
            kotlin.jvm.internal.p.h(fileSystem, "getDefault(...)");
            fileSystemPaths = companion.paths(fileSystem);
        }
        FileSystemPaths fileSystemPaths2 = fileSystemPaths;
        if ((i10 & 16) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.http.content.G
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return StaticContentKt.staticFileSystem$lambda$4((StaticContentConfig) obj2);
                }
            };
        }
        return staticFileSystem(route, str, str2, str4, fileSystemPaths2, interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t staticFileSystem$lambda$4(StaticContentConfig staticContentConfig) {
        kotlin.jvm.internal.p.i(staticContentConfig, "<this>");
        return Y8.t.f7040a;
    }

    public static final Route staticFiles(Route route, String remotePath, File dir, String str, InterfaceC5074l<? super StaticContentConfig<File>, Y8.t> block) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(remotePath, "remotePath");
        kotlin.jvm.internal.p.i(dir, "dir");
        kotlin.jvm.internal.p.i(block, "block");
        StaticContentConfig staticContentConfig = new StaticContentConfig();
        block.invoke(staticContentConfig);
        return staticContentRoute(route, remotePath, staticContentConfig.getAutoHeadResponse(), new C43762(str, dir, staticContentConfig.getPreCompressedFileTypes$ktor_server_core(), staticContentConfig.getContentType$ktor_server_core(), staticContentConfig.getCacheControl$ktor_server_core(), staticContentConfig.getModifier$ktor_server_core(), staticContentConfig.getExclude$ktor_server_core(), staticContentConfig.getExtensions$ktor_server_core(), staticContentConfig.getDefaultPath(), null));
    }

    public static /* synthetic */ Route staticFiles$default(Route route, String str, File file, String str2, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = "index.html";
        }
        if ((i10 & 8) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.http.content.z
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return StaticContentKt.staticFiles$lambda$1((StaticContentConfig) obj2);
                }
            };
        }
        return staticFiles(route, str, file, str2, interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t staticFiles$lambda$1(StaticContentConfig staticContentConfig) {
        kotlin.jvm.internal.p.i(staticContentConfig, "<this>");
        return Y8.t.f7040a;
    }

    public static final Route staticResources(Route route, String remotePath, String str, String str2, InterfaceC5074l<? super StaticContentConfig<URL>, Y8.t> block) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(remotePath, "remotePath");
        kotlin.jvm.internal.p.i(block, "block");
        StaticContentConfig staticContentConfig = new StaticContentConfig();
        block.invoke(staticContentConfig);
        return staticContentRoute(route, remotePath, staticContentConfig.getAutoHeadResponse(), new C43772(str2, str, staticContentConfig.getPreCompressedFileTypes$ktor_server_core(), staticContentConfig.getContentType$ktor_server_core(), staticContentConfig.getCacheControl$ktor_server_core(), staticContentConfig.getModifier$ktor_server_core(), staticContentConfig.getExclude$ktor_server_core(), staticContentConfig.getExtensions$ktor_server_core(), staticContentConfig.getDefaultPath(), null));
    }

    public static /* synthetic */ Route staticResources$default(Route route, String str, String str2, String str3, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = "index.html";
        }
        if ((i10 & 8) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.http.content.C
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return StaticContentKt.staticResources$lambda$2((StaticContentConfig) obj2);
                }
            };
        }
        return staticResources(route, str, str2, str3, interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t staticResources$lambda$2(StaticContentConfig staticContentConfig) {
        kotlin.jvm.internal.p.i(staticContentConfig, "<this>");
        return Y8.t.f7040a;
    }

    public static final Route staticZip(Route route, String remotePath, String str, Path zip, String str2, InterfaceC5074l<? super StaticContentConfig<Path>, Y8.t> block) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(remotePath, "remotePath");
        kotlin.jvm.internal.p.i(zip, "zip");
        kotlin.jvm.internal.p.i(block, "block");
        return staticFileSystem(route, remotePath, str, str2, new ReloadingZipFileSystem(zip, route.getEnvironment().getClassLoader(), FileSystemPaths.INSTANCE.paths(getFileSystem(zip, route.getEnvironment().getClassLoader()))), block);
    }

    public static /* synthetic */ Route staticZip$default(Route route, String str, String str2, Path path, String str3, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str3 = "index.html";
        }
        String str4 = str3;
        if ((i10 & 16) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.http.content.E
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return StaticContentKt.staticZip$lambda$3((StaticContentConfig) obj2);
                }
            };
        }
        return staticZip(route, str, str2, path, str4, interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t staticZip$lambda$3(StaticContentConfig staticContentConfig) {
        kotlin.jvm.internal.p.i(staticContentConfig, "<this>");
        return Y8.t.f7040a;
    }

    /* renamed from: default, reason: not valid java name */
    public static final void m173default(Route route, File localPath) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(localPath, "localPath");
        RoutingBuilderKt.get(route, new AnonymousClass1(combine(getStaticRootFolder(route), localPath), PreCompressedKt.getStaticContentEncodedTypes(route), null));
    }

    public static final void file(Route route, String remotePath, File localPath) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(remotePath, "remotePath");
        kotlin.jvm.internal.p.i(localPath, "localPath");
        RoutingBuilderKt.get(route, remotePath, new C43681(combine(getStaticRootFolder(route), localPath), PreCompressedKt.getStaticContentEncodedTypes(route), null));
    }

    public static final void files(Route route, File folder) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(folder, "folder");
        RoutingBuilderKt.get(route, "{static-content-path-parameter...}", new C43691(combine(getStaticRootFolder(route), folder), PreCompressedKt.getStaticContentEncodedTypes(route), null));
    }

    /* renamed from: static, reason: not valid java name */
    public static final Route m175static(Route route, String remotePath, InterfaceC5074l<? super Route, Y8.t> configure) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(remotePath, "remotePath");
        kotlin.jvm.internal.p.i(configure, "configure");
        return RoutingBuilderKt.route(route, remotePath, configure);
    }
}
