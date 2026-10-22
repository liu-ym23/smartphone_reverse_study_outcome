package io.ktor.server.application;

import Y8.t;
import Z8.C1172u;
import Z8.F;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import e9.InterfaceC4014c;
import io.ktor.server.engine.ServerEngineUtilsKt;
import io.ktor.util.PlatformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\n\u001a\u00020\b2\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f¢\u0006\u0004\b\n\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R<\u0010\u0017\u001a$\u0012 \u0012\u001e\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f0\u00168\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u00065"}, d2 = {"Lio/ktor/server/application/ServerConfigBuilder;", "", "Lio/ktor/server/application/ApplicationEnvironment;", "environment", "<init>", "(Lio/ktor/server/application/ApplicationEnvironment;)V", "Lkotlin/Function1;", "Lio/ktor/server/application/Application;", "LY8/t;", "body", "module", "(Lp9/l;)V", "Lkotlin/Function2;", "Le9/c;", "(Lp9/p;)V", "Lio/ktor/server/application/ServerConfig;", "build$ktor_server_core", "()Lio/ktor/server/application/ServerConfig;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lio/ktor/server/application/ApplicationEnvironment;", "getEnvironment", "()Lio/ktor/server/application/ApplicationEnvironment;", "", "modules", "Ljava/util/List;", "getModules$ktor_server_core", "()Ljava/util/List;", "", "", "watchPaths", "getWatchPaths", "setWatchPaths", "(Ljava/util/List;)V", "rootPath", "Ljava/lang/String;", "getRootPath", "()Ljava/lang/String;", "setRootPath", "(Ljava/lang/String;)V", "", "developmentMode", "Z", "getDevelopmentMode", "()Z", "setDevelopmentMode", "(Z)V", "Lkotlin/coroutines/d;", "parentCoroutineContext", "Lkotlin/coroutines/d;", "getParentCoroutineContext", "()Lkotlin/coroutines/d;", "setParentCoroutineContext", "(Lkotlin/coroutines/d;)V", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServerConfigBuilder {
    private boolean developmentMode;
    private final ApplicationEnvironment environment;
    private final List<p<Application, InterfaceC4014c<? super t>, Object>> modules;
    private kotlin.coroutines.d parentCoroutineContext;
    private String rootPath;
    private List<String> watchPaths;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.application.ServerConfigBuilder$module$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements p<Application, InterfaceC4014c<? super t>, Object> {
        public AnonymousClass1(Object obj) {
            super(2, obj, p.a.class, "suspendConversion0", "module$suspendConversion0(Lkotlin/jvm/functions/Function1;Lio/ktor/server/application/Application;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // p9.p
        public final Object invoke(Application application, InterfaceC4014c<? super t> interfaceC4014c) {
            return ServerConfigBuilder.module$suspendConversion0((InterfaceC5074l) this.receiver, application, interfaceC4014c);
        }
    }

    public ServerConfigBuilder(ApplicationEnvironment environment) {
        kotlin.jvm.internal.p.i(environment, "environment");
        this.environment = environment;
        this.modules = new ArrayList();
        this.watchPaths = C1172u.e(ServerEngineUtilsKt.getWORKING_DIRECTORY_PATH());
        this.rootPath = "";
        this.developmentMode = PlatformUtils.INSTANCE.getIS_DEVELOPMENT_MODE();
        this.parentCoroutineContext = EmptyCoroutineContext.f34779a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object module$suspendConversion0(InterfaceC5074l interfaceC5074l, Application application, InterfaceC4014c interfaceC4014c) {
        interfaceC5074l.invoke(application);
        return t.f7040a;
    }

    public final ServerConfig build$ktor_server_core() {
        return new ServerConfig(this.environment, F.m1(this.modules), this.watchPaths, this.rootPath, this.developmentMode, this.parentCoroutineContext);
    }

    public final boolean getDevelopmentMode() {
        return this.developmentMode;
    }

    public final ApplicationEnvironment getEnvironment() {
        return this.environment;
    }

    public final List<p9.p<Application, InterfaceC4014c<? super t>, Object>> getModules$ktor_server_core() {
        return this.modules;
    }

    public final kotlin.coroutines.d getParentCoroutineContext() {
        return this.parentCoroutineContext;
    }

    public final String getRootPath() {
        return this.rootPath;
    }

    public final List<String> getWatchPaths() {
        return this.watchPaths;
    }

    public final /* synthetic */ void module(InterfaceC5074l body) {
        kotlin.jvm.internal.p.i(body, "body");
        this.modules.add(new AnonymousClass1(body));
    }

    public final void setDevelopmentMode(boolean z10) {
        this.developmentMode = z10;
    }

    public final void setParentCoroutineContext(kotlin.coroutines.d dVar) {
        kotlin.jvm.internal.p.i(dVar, "<set-?>");
        this.parentCoroutineContext = dVar;
    }

    public final void setRootPath(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.rootPath = str;
    }

    public final void setWatchPaths(List<String> list) {
        kotlin.jvm.internal.p.i(list, "<set-?>");
        this.watchPaths = list;
    }

    public final void module(p9.p<? super Application, ? super InterfaceC4014c<? super t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(body, "body");
        this.modules.add(body);
    }
}
