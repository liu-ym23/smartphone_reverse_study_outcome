package io.ktor.server.application;

import Y8.t;
import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import f9.C4063a;
import io.ktor.http.ContentType;
import kotlin.Metadata;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.p;
import p9.q;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012(\u0010\t\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0006H\u0086J¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R9\u0010\t\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/server/application/DynamicApplicationModule;", "", "", SkillStoreKt.SKILL_DOC_TYPE_REFERENCE, "Lkotlin/Function3;", "Lio/ktor/server/application/Application;", "Ljava/lang/ClassLoader;", "Le9/c;", "LY8/t;", "function", "<init>", "(Ljava/lang/String;Lp9/q;)V", ContentType.Application.TYPE, "classLoader", "invoke", "(Lio/ktor/server/application/Application;Ljava/lang/ClassLoader;Le9/c;)Ljava/lang/Object;", "Ljava/lang/String;", "getReference", "()Ljava/lang/String;", "Lp9/q;", "getFunction", "()Lp9/q;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DynamicApplicationModule {
    private final q<Application, ClassLoader, InterfaceC4014c<? super t>, Object> function;
    private final String reference;

    /* JADX WARN: Multi-variable type inference failed */
    public DynamicApplicationModule(String str, q<? super Application, ? super ClassLoader, ? super InterfaceC4014c<? super t>, ? extends Object> function) {
        p.i(function, "function");
        this.reference = str;
        this.function = function;
    }

    private final Object invoke$$forInline(Application application, ClassLoader classLoader, InterfaceC4014c<? super t> interfaceC4014c) {
        q<Application, ClassLoader, InterfaceC4014c<? super t>, Object> function = getFunction();
        n.c(0);
        function.invoke(application, classLoader, interfaceC4014c);
        n.c(1);
        return t.f7040a;
    }

    public final q<Application, ClassLoader, InterfaceC4014c<? super t>, Object> getFunction() {
        return this.function;
    }

    public final String getReference() {
        return this.reference;
    }

    public final Object invoke(Application application, ClassLoader classLoader, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objInvoke = getFunction().invoke(application, classLoader, interfaceC4014c);
        return objInvoke == C4063a.g() ? objInvoke : t.f7040a;
    }

    public /* synthetic */ DynamicApplicationModule(String str, q qVar, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, qVar);
    }
}
