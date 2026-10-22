package androidx.camera.camera2.pipe.core;

import Ua.C1060i;
import Ua.M;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import f9.C4063a;
import g9.f;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.g;
import p9.p;
import z.C6047e;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a=\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0004\b\t\u0010\n\u001a\u0014\u0010\f\u001a\u00020\u0005*\u00020\u000bH\u0082@¢\u0006\u0004\b\f\u0010\r\u001a\u0014\u0010\u000e\u001a\u00020\u0005*\u00020\u000bH\u0082@¢\u0006\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {"Lz/e;", "LUa/M;", "scope", "Lkotlin/Function2;", "Le9/c;", "LY8/t;", "", "block", "Lkotlinx/coroutines/g;", "e", "(Lz/e;LUa/M;Lp9/p;)Lkotlinx/coroutines/g;", "Leb/a;", Const.INTENT_KEY_UMID, "(Leb/a;Le9/c;)Ljava/lang/Object;", "c", "camera-camera2-pipe"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutexesKt {
    public static final Object c(InterfaceC4021a interfaceC4021a, InterfaceC4014c<? super t> interfaceC4014c) {
        if (IntrinsicsKt__IntrinsicsJvmKt.e(MutexesKt$lockAndSuspend$lockFn$1.f10694a, interfaceC4021a, interfaceC4014c) != C4063a.g()) {
            IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c).resumeWith(Result.b(t.f7040a));
        }
        Object objG = C4063a.g();
        if (objG == C4063a.g()) {
            f.c(interfaceC4014c);
        }
        return objG == C4063a.g() ? objG : t.f7040a;
    }

    public static final Object d(InterfaceC4021a interfaceC4021a, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objM = interfaceC4021a.m(null, interfaceC4014c);
        return objM == C4063a.g() ? objM : t.f7040a;
    }

    public static final g e(C6047e c6047e, M scope, p<? super M, ? super InterfaceC4014c<? super t>, ? extends Object> block) {
        kotlin.jvm.internal.p.i(c6047e, "<this>");
        kotlin.jvm.internal.p.i(scope, "scope");
        kotlin.jvm.internal.p.i(block, "block");
        return C1060i.d(scope, null, CoroutineStart.UNDISPATCHED, new MutexesKt$withLockLaunch$1(c6047e, block, null), 1, null);
    }
}
