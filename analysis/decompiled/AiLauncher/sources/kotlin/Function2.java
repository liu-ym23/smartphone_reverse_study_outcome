package kotlin;

import Ua.C1060i;
import Ua.C1073o0;
import Ua.I;
import Ua.J;
import Ua.M;
import Ua.Y;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.coroutines.d;
import p9.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0006\u001a\u00020\u00032\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a1\u0010\b\u001a\u00020\u00032\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0000¢\u0006\u0004\b\b\u0010\u0007\u001a1\u0010\t\u001a\u00020\u00032\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0000¢\u0006\u0004\b\t\u0010\u0007\"\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlin/Function2;", "LUa/M;", "Le9/c;", "LY8/t;", "", "block", "c", "(Lp9/p;)V", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "LUa/I;", "singleThreadDispatcher", "LUa/I;", "LUa/J;", "uncaughtHandler", "LUa/J;", "common_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.y, reason: from Kotlin metadata */
/* loaded from: classes3.dex */
public final class Function2 {
    private static final I singleThreadDispatcher = I.t1(Y.b(), 1, null, 2, null);
    private static final J uncaughtHandler = new a(J.INSTANCE);

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"K6/y$a", "Lkotlin/coroutines/a;", "LUa/J;", "Lkotlin/coroutines/d;", "context", "", "exception", "LY8/t;", "handleException", "(Lkotlin/coroutines/d;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: K6.y$a */
    public static final class a extends kotlin.coroutines.a implements J {
        public a(J.Companion companion) {
            super(companion);
        }

        @Override // Ua.J
        public void handleException(d context, Throwable exception) {
            C4148a.g("Launcher", "coroutine uncaught: " + exception.getMessage(), exception, false, 8, null);
        }
    }

    public static final void a(p<? super M, ? super InterfaceC4014c<? super t>, ? extends Object> block) {
        kotlin.jvm.internal.p.i(block, "block");
        C1060i.d(kotlinx.coroutines.d.a(Y.b()), uncaughtHandler, null, block, 2, null);
    }

    public static final void b(p<? super M, ? super InterfaceC4014c<? super t>, ? extends Object> block) {
        kotlin.jvm.internal.p.i(block, "block");
        C1060i.d(kotlinx.coroutines.d.a(Y.c()), null, null, block, 3, null);
    }

    public static final void c(p<? super M, ? super InterfaceC4014c<? super t>, ? extends Object> block) {
        kotlin.jvm.internal.p.i(block, "block");
        C1060i.d(C1073o0.f6391a, singleThreadDispatcher.plus(uncaughtHandler), null, block, 2, null);
    }
}
