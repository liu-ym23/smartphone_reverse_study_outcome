package C4;

import A6.i;
import A6.l;
import C7.r;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.Executor;
import kotlin.Result;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final FunctionReferenceImpl f295a;
    public final AudioManager b;
    public final Executor c;
    public boolean e;
    public boolean f;
    public i g;
    public final Handler d = new Handler(Looper.getMainLooper());
    public final l h = new l(this, 2);

    /* JADX WARN: Multi-variable type inference failed */
    public f(J4.a aVar, S7.a aVar2) {
        this.f295a = (FunctionReferenceImpl) aVar2;
        this.b = (AudioManager) aVar.getSystemService(AudioManager.class);
        this.c = aVar.getMainExecutor();
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [S7.a, kotlin.jvm.internal.FunctionReferenceImpl] */
    public final boolean a() {
        if (!this.f) {
            AudioManager audioManager = this.b;
            Integer numValueOf = audioManager != null ? Integer.valueOf(audioManager.getMode()) : null;
            if ((numValueOf == null || numValueOf.intValue() != 2) && ((numValueOf == null || numValueOf.intValue() != 3) && ((numValueOf == null || numValueOf.intValue() != 4) && ((numValueOf == null || numValueOf.intValue() != 5) && (numValueOf == null || numValueOf.intValue() != 6))))) {
                return false;
            }
            if (!this.f) {
                this.f = true;
                c();
                this.f295a.invoke();
                return true;
            }
        }
        return true;
    }

    public final void b() {
        Object objA;
        if (this.e || this.f) {
            return;
        }
        this.e = true;
        AudioManager audioManager = this.b;
        if (audioManager != null) {
            AudioManager.OnModeChangedListener onModeChangedListener = new AudioManager.OnModeChangedListener() { // from class: C4.e
                /* JADX WARN: Type inference failed for: r1v2, types: [S7.a, kotlin.jvm.internal.FunctionReferenceImpl] */
                @Override // android.media.AudioManager.OnModeChangedListener
                public final void onModeChanged(int i) {
                    f fVar = this.f294a;
                    if (fVar.e) {
                        if ((i == 2 || i == 3 || i == 4 || i == 5 || i == 6) && !fVar.f) {
                            fVar.f = true;
                            fVar.c();
                            fVar.f295a.invoke();
                        }
                    }
                }
            };
            try {
                audioManager.addOnModeChangedListener(this.c, onModeChangedListener);
                this.g = new i(4, this, onModeChangedListener);
                objA = r.f317a;
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                Log.w("VoiceWakeCallMonitor", "register audio mode listener failed, falling back to polling", thA);
            }
        }
        a();
        if (this.e && this.g == null && audioManager != null) {
            this.d.postDelayed(this.h, 250L);
        }
    }

    public final void c() {
        Object objA;
        this.e = false;
        this.d.removeCallbacks(this.h);
        i iVar = this.g;
        r rVar = null;
        this.g = null;
        if (iVar != null) {
            try {
                iVar.invoke();
                rVar = r.f317a;
                objA = rVar;
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
        } else {
            objA = rVar;
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Log.w("VoiceWakeCallMonitor", "remove audio mode listener failed", thA);
        }
    }
}
