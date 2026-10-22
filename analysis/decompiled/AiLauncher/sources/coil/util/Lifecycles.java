package coil.util;

import Ua.InterfaceC1066l;
import Y8.t;
import android.view.InterfaceC1387e;
import android.view.InterfaceC1397o;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0081@¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001b\u0010\u0006\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/lifecycle/Lifecycle;", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroidx/lifecycle/Lifecycle;Le9/c;)Ljava/lang/Object;", "Landroidx/lifecycle/o;", "observer", Const.INTENT_KEY_PKGNAME, "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/o;)V", "coil-base_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* renamed from: coil.util.-Lifecycles, reason: invalid class name */
/* loaded from: classes.dex */
public final class Lifecycles {

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"coil/util/-Lifecycles$a", "Landroidx/lifecycle/e;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "LY8/t;", UxipConstants.f30640D, "(Landroidx/lifecycle/LifecycleOwner;)V", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: coil.util.-Lifecycles$a */
    public static final class a implements InterfaceC1387e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1066l<t> f15813a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(InterfaceC1066l<? super t> interfaceC1066l) {
            this.f15813a = interfaceC1066l;
        }

        @Override // android.view.InterfaceC1387e
        public void onStart(LifecycleOwner owner) {
            InterfaceC1066l<t> interfaceC1066l = this.f15813a;
            Result.Companion companion = Result.INSTANCE;
            interfaceC1066l.resumeWith(Result.b(t.f7040a));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, coil.util.-Lifecycles$a, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(android.view.Lifecycle r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof coil.util.Lifecycles$awaitStarted$1
            if (r0 == 0) goto L13
            r0 = r7
            coil.util.-Lifecycles$awaitStarted$1 r0 = (coil.util.Lifecycles$awaitStarted$1) r0
            int r1 = r0.f15817d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15817d = r1
            goto L18
        L13:
            coil.util.-Lifecycles$awaitStarted$1 r0 = new coil.util.-Lifecycles$awaitStarted$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f15816c
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f15817d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.f15815b
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref$ObjectRef) r6
            java.lang.Object r0 = r0.f15814a
            androidx.lifecycle.Lifecycle r0 = (android.view.Lifecycle) r0
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L31
            goto L8c
        L31:
            r7 = move-exception
            goto L98
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            kotlin.C4849c.b(r7)
            androidx.lifecycle.Lifecycle$State r7 = r6.getState()
            androidx.lifecycle.Lifecycle$State r2 = androidx.lifecycle.Lifecycle.State.STARTED
            boolean r7 = r7.isAtLeast(r2)
            if (r7 == 0) goto L4d
            Y8.t r6 = Y8.t.f7040a
            return r6
        L4d:
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            r0.f15814a = r6     // Catch: java.lang.Throwable -> L81
            r0.f15815b = r7     // Catch: java.lang.Throwable -> L81
            r0.f15817d = r3     // Catch: java.lang.Throwable -> L81
            kotlinx.coroutines.c r2 = new kotlinx.coroutines.c     // Catch: java.lang.Throwable -> L81
            e9.c r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.d(r0)     // Catch: java.lang.Throwable -> L81
            r2.<init>(r4, r3)     // Catch: java.lang.Throwable -> L81
            r2.I()     // Catch: java.lang.Throwable -> L81
            coil.util.-Lifecycles$a r3 = new coil.util.-Lifecycles$a     // Catch: java.lang.Throwable -> L81
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L81
            r7.f34820a = r3     // Catch: java.lang.Throwable -> L81
            kotlin.jvm.internal.p.f(r3)     // Catch: java.lang.Throwable -> L81
            androidx.lifecycle.o r3 = (android.view.InterfaceC1397o) r3     // Catch: java.lang.Throwable -> L81
            r6.a(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.Object r2 = r2.C()     // Catch: java.lang.Throwable -> L81
            java.lang.Object r3 = f9.C4063a.g()     // Catch: java.lang.Throwable -> L81
            if (r2 != r3) goto L87
            g9.f.c(r0)     // Catch: java.lang.Throwable -> L81
            goto L87
        L81:
            r0 = move-exception
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
            goto L98
        L87:
            if (r2 != r1) goto L8a
            return r1
        L8a:
            r0 = r6
            r6 = r7
        L8c:
            T r6 = r6.f34820a
            androidx.lifecycle.o r6 = (android.view.InterfaceC1397o) r6
            if (r6 == 0) goto L95
            r0.d(r6)
        L95:
            Y8.t r6 = Y8.t.f7040a
            return r6
        L98:
            T r6 = r6.f34820a
            androidx.lifecycle.o r6 = (android.view.InterfaceC1397o) r6
            if (r6 == 0) goto La1
            r0.d(r6)
        La1:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.util.Lifecycles.a(androidx.lifecycle.Lifecycle, e9.c):java.lang.Object");
    }

    public static final void b(Lifecycle lifecycle, InterfaceC1397o interfaceC1397o) {
        lifecycle.d(interfaceC1397o);
        lifecycle.a(interfaceC1397o);
    }
}
