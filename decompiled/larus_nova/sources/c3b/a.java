package c3b;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.media.MediaMutex;
import com.ss.android.lark.media.MediaType;
import com.ss.android.lark.media.Scene;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static InterfaceC0398a f22345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f22346b = null;

    /* JADX INFO: renamed from: c3b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0398a {

        /* JADX INFO: renamed from: c3b.a$a$a, reason: collision with other inner class name */
        public static final class C0399a implements InterfaceC0398a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final MediaMutex.LockError f22347a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C0399a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f22347a, ((C0399a) r100).f22347a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f22347a.hashCode();
            }

            public final String toString() {
                return "Error(lockError=" + this.f22347a + ')';
            }

            public C0399a(MediaMutex.LockError r100) {
                Intrinsics.checkNotNullParameter(r100, "lockError");
                this.f22347a = r100;
            }
        }

        /* JADX INFO: renamed from: c3b.a$a$b */
        public static final class b implements InterfaceC0398a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f22348a = null;

            static {
                f22348a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: c3b.a$a$c */
        public static final class c implements InterfaceC0398a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Scene f22349a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final MediaType f22350b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f22351c;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof c) == true) goto L8;
                return false;
            L8:
                c r101 = (c) r100;
                if (this.f22349a == r101.f22349a) goto L12;
                return false;
            L12:
                if (this.f22350b == r101.f22350b) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f22351c, r101.f22351c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                int r100 = ((this.f22349a.hashCode() * 31) + this.f22350b.hashCode()) * 31;
                String r101 = this.f22351c;
                if (r101 != null) goto L5;
                int r102 = 0;
            L7:
                return r100 + r102;
            L5:
                r102 = r101.hashCode();
                goto L7
            }

            public final String toString() {
                return "Interrupted(byScene=" + this.f22349a + ", type=" + this.f22350b + ", interruptMsg=" + this.f22351c + ')';
            }

            public final MediaType getType() {
                return this.f22350b;
            }

            public c(Scene r100, MediaType r101) {
                Intrinsics.checkNotNullParameter(r100, "byScene");
                Intrinsics.checkNotNullParameter(r101, "type");
                this.f22349a = r100;
                this.f22350b = r101;
                this.f22351c = "";
            }
        }

        /* JADX INFO: renamed from: c3b.a$a$d */
        public static final class d implements InterfaceC0398a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f22352a = null;

            static {
                f22352a = new d();
            }

            public d() {
            }
        }
    }

    public static final class b implements com.ss.android.lark.media.a {
        public b() {
        }

        @Override // com.ss.android.lark.media.a
        public final void onSuccess() {
            InterfaceC0398a r100 = a.f22345a;
            a.f22345a = InterfaceC0398a.d.f22352a;
            Log.i("AudioPlayMutexController", "media occupy success");
        }

        @Override // com.ss.android.lark.media.a
        public final void a(MediaMutex.LockError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            InterfaceC0398a r101 = a.f22345a;
            a.f22345a = new InterfaceC0398a.C0399a(r100);
            Log.w("AudioPlayMutexController", "media is occupied by " + r100.getOccupiedScene());
        }

        @Override // com.ss.android.lark.media.a
        public final void b(Scene r100, MediaType r101) {
            Intrinsics.checkNotNullParameter(r100, "byScene");
            Intrinsics.checkNotNullParameter(r101, "type");
            Log.i("AudioPlayMutexController", "Interrupted byScene:" + r100 + ",type:" + r101 + ",interruptMsg:");
            InterfaceC0398a r102 = a.f22345a;
            a.f22345a = new InterfaceC0398a.c(r100, r101);
        }

        @Override // com.ss.android.lark.media.a
        public final void c(Scene r100, MediaType r101) {
            Intrinsics.checkNotNullParameter(r100, "fromScene");
            Intrinsics.checkNotNullParameter(r101, "type");
            Log.i("AudioPlayMutexController", "InterruptionEnd fromScene:" + r100 + ",type:" + r101);
        }
    }

    static {
        f22345a = InterfaceC0398a.b.f22348a;
        f22346b = new b();
    }

    public static void a() {
        if ((f22345a instanceof InterfaceC0398a.d) == true) goto L6;
        Log.i("AudioPlayMutexController", "releaseMediaResource isOccupied=false");
        return;
    L6:
        Log.i("AudioPlayMutexController", "releaseMediaResource unlock");
        f22345a = InterfaceC0398a.b.f22348a;
        MediaMutex.f431631r.n(Scene.IM_Audio_Play, f22346b);
    }

    public static boolean b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((f22345a instanceof InterfaceC0398a.d) == false) goto L5;
        Log.i("AudioPlayMutexController", "occupyMediaResource isOccupied");
    L6:
        InterfaceC0398a r101 = f22345a;
        if ((r101 instanceof InterfaceC0398a.d) == false) goto L10;
        return true;
    L10:
        if ((r101 instanceof InterfaceC0398a.C0399a) == false) goto L13;
        UDToast.show(r100, ((InterfaceC0398a.C0399a) r101).f22347a.getErrorMessage());
    L17:
        return false;
    L13:
        if ((r101 instanceof InterfaceC0398a.c) == false) goto L17;
        String r102 = ((InterfaceC0398a.c) r101).f22351c;
        if (r102 == null) goto L17;
        UDToast.show(r100, r102);
        goto L17
    L5:
        MediaMutex.f431631r.getClass();
        Log.i("AudioPlayMutexController", "occupyMediaResource tryLock, fg:true");
        MediaMutex.f431631r.l(Scene.IM_Audio_Play, true, f22346b, true);
        goto L6
    }
}
