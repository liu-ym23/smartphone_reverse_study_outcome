package kotlinx.coroutines;

import Ua.C1091z;
import Ua.G;
import Ua.K;
import Ua.S0;
import Ua.W;
import Y8.t;
import Za.C1188h;
import Za.J;
import androidx.exifinterface.media.ExifInterface;
import bb.AbstractRunnableC1472g;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import e9.InterfaceC4014c;
import java.util.concurrent.CancellationException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\u0011\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH ¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\fH\u0010¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d8 X \u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001e¨\u0006 "}, d2 = {"Lkotlinx/coroutines/f;", ExifInterface.GPS_DIRECTION_TRUE, "Lbb/g;", "Lkotlinx/coroutines/SchedulerTask;", "", "resumeMode", "<init>", "(I)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/lang/Object;", "takenState", "", "cause", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;Ljava/lang/Throwable;)V", VoiceWakeupReceiver.EXTRA_STATE, "e", "(Ljava/lang/Object;)Ljava/lang/Object;", Const.INTENT_KEY_UMID, "(Ljava/lang/Object;)Ljava/lang/Throwable;", "run", "()V", "exception", "f", "(Ljava/lang/Throwable;)V", "c", "I", "Le9/c;", "()Le9/c;", "delegate", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class f<T> extends AbstractRunnableC1472g {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int resumeMode;

    public f(int i10) {
        this.resumeMode = i10;
    }

    public void a(Object takenState, Throwable cause) {
    }

    public abstract InterfaceC4014c<T> c();

    public Throwable d(Object state) {
        C1091z c1091z = state instanceof C1091z ? (C1091z) state : null;
        if (c1091z != null) {
            return c1091z.cause;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T e(Object state) {
        return state;
    }

    public final void f(Throwable exception) {
        K.a(c().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", exception));
    }

    public abstract Object i();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            InterfaceC4014c<T> interfaceC4014cC = c();
            p.g(interfaceC4014cC, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            C1188h c1188h = (C1188h) interfaceC4014cC;
            InterfaceC4014c<T> interfaceC4014c = c1188h.continuation;
            Object obj = c1188h.countOrElement;
            kotlin.coroutines.d context = interfaceC4014c.getContext();
            Object objI = J.i(context, obj);
            g gVar = null;
            S0<?> s0M = objI != J.f7710a ? G.m(interfaceC4014c, context, objI) : null;
            try {
                kotlin.coroutines.d context2 = interfaceC4014c.getContext();
                Object objI2 = i();
                Throwable thD = d(objI2);
                if (thD == null && W.b(this.resumeMode)) {
                    gVar = (g) context2.get(g.INSTANCE);
                }
                if (gVar != null && !gVar.b()) {
                    CancellationException cancellationExceptionG = gVar.G();
                    a(objI2, cancellationExceptionG);
                    Result.Companion companion = Result.INSTANCE;
                    interfaceC4014c.resumeWith(Result.b(C4849c.a(cancellationExceptionG)));
                } else if (thD != null) {
                    Result.Companion companion2 = Result.INSTANCE;
                    interfaceC4014c.resumeWith(Result.b(C4849c.a(thD)));
                } else {
                    Result.Companion companion3 = Result.INSTANCE;
                    interfaceC4014c.resumeWith(Result.b(e(objI2)));
                }
                t tVar = t.f7040a;
                if (s0M == null || s0M.c1()) {
                    J.f(context, objI);
                }
            } catch (Throwable th) {
                if (s0M == null || s0M.c1()) {
                    J.f(context, objI);
                }
                throw th;
            }
        } catch (DispatchException e10) {
            K.a(c().getContext(), e10.getCause());
        } catch (Throwable th2) {
            f(th2);
        }
    }
}
