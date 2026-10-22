package io.ktor.util.debug;

import Ua.C1056g;
import Ua.M;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.util.debug.plugins.PluginName;
import io.ktor.util.debug.plugins.PluginsTrace;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a4\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006\u001a<\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\b\u001a\u00020\u00072\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0086@¢\u0006\u0004\b\t\u0010\n\u001a<\u0010\u0011\u001a\u00020\u000f\"\b\b\u0000\u0010\f*\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u0001H\u0086@¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Le9/c;", "", "block", "initContextInDebugMode", "(Lp9/l;Le9/c;)Ljava/lang/Object;", "", "pluginName", "addToContextInDebugMode", "(Ljava/lang/String;Lp9/l;Le9/c;)Ljava/lang/Object;", "Lkotlin/coroutines/d$b;", "Element", "Lkotlin/coroutines/d$c;", "key", "LY8/t;", "action", "useContextElementInDebugMode", "(Lkotlin/coroutines/d$c;Lp9/l;Le9/c;)Ljava/lang/Object;", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ContextUtilsKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LUa/M;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.util.debug.ContextUtilsKt$addToContextInDebugMode$2", f = "ContextUtils.kt", l = {37}, m = "invokeSuspend")
    /* renamed from: io.ktor.util.debug.ContextUtilsKt$addToContextInDebugMode$2, reason: invalid class name */
    public static final class AnonymousClass2<T> extends SuspendLambda implements p<M, InterfaceC4014c<? super T>, Object> {
        final /* synthetic */ InterfaceC5074l<InterfaceC4014c<? super T>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(InterfaceC5074l<? super InterfaceC4014c<? super T>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$block = interfaceC5074l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.$block, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super T> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            InterfaceC5074l<InterfaceC4014c<? super T>, Object> interfaceC5074l = this.$block;
            this.label = 1;
            Object objInvoke = interfaceC5074l.invoke(this);
            return objInvoke == objG ? objG : objInvoke;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LUa/M;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.util.debug.ContextUtilsKt$initContextInDebugMode$2", f = "ContextUtils.kt", l = {22}, m = "invokeSuspend")
    /* renamed from: io.ktor.util.debug.ContextUtilsKt$initContextInDebugMode$2, reason: invalid class name and case insensitive filesystem */
    public static final class C44182<T> extends SuspendLambda implements p<M, InterfaceC4014c<? super T>, Object> {
        final /* synthetic */ InterfaceC5074l<InterfaceC4014c<? super T>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C44182(InterfaceC5074l<? super InterfaceC4014c<? super T>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super C44182> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$block = interfaceC5074l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C44182(this.$block, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super T> interfaceC4014c) {
            return ((C44182) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            InterfaceC5074l<InterfaceC4014c<? super T>, Object> interfaceC5074l = this.$block;
            this.label = 1;
            Object objInvoke = interfaceC5074l.invoke(this);
            return objInvoke == objG ? objG : objInvoke;
        }
    }

    public static final <T> Object addToContextInDebugMode(String str, InterfaceC5074l<? super InterfaceC4014c<? super T>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super T> interfaceC4014c) {
        return !IntellijIdeaDebugDetector.INSTANCE.isDebuggerConnected() ? interfaceC5074l.invoke(interfaceC4014c) : C1056g.j(interfaceC4014c.getContext().plus(new PluginName(str)), new AnonymousClass2(interfaceC5074l, null), interfaceC4014c);
    }

    public static final <T> Object initContextInDebugMode(InterfaceC5074l<? super InterfaceC4014c<? super T>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super T> interfaceC4014c) {
        return !IntellijIdeaDebugDetector.INSTANCE.isDebuggerConnected() ? interfaceC5074l.invoke(interfaceC4014c) : C1056g.j(interfaceC4014c.getContext().plus(new PluginsTrace(null, 1, null)), new C44182(interfaceC5074l, null), interfaceC4014c);
    }

    public static final <Element extends d.b> Object useContextElementInDebugMode(d.c<Element> cVar, InterfaceC5074l<? super Element, t> interfaceC5074l, InterfaceC4014c<? super t> interfaceC4014c) {
        if (!IntellijIdeaDebugDetector.INSTANCE.isDebuggerConnected()) {
            return t.f7040a;
        }
        d.b bVar = interfaceC4014c.getContext().get(cVar);
        if (bVar != null) {
            interfaceC5074l.invoke(bVar);
        }
        return t.f7040a;
    }
}
