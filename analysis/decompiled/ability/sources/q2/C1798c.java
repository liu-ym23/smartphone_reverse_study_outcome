package q2;

import A2.f;
import H4.o;
import M0.i;
import N9.j;
import android.os.Process;
import android.os.SystemClock;
import com.apm.insight.CrashType;
import com.apm.insight.Npth;
import com.apm.insight.g;
import com.apm.insight.nativecrash.NativeImpl;
import com.stepos.statsrpk.d;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.io.File;
import java.io.IOException;
import s2.C1912a;
import y2.e;

/* renamed from: q2.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1798c implements f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5575a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ long d;
    public final /* synthetic */ String e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ Thread g;
    public final /* synthetic */ String h;
    public final /* synthetic */ File i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f5576j;

    public /* synthetic */ C1798c(Object obj, Throwable th, boolean z10, long j5, String str, boolean z11, Thread thread, String str2, File file, int i) {
        this.f5575a = i;
        this.f5576j = obj;
        this.b = th;
        this.c = z10;
        this.d = j5;
        this.e = str;
        this.f = z11;
        this.g = thread;
        this.h = str2;
        this.i = file;
    }

    @Override // A2.f
    public final n2.a e(int i, n2.a aVar) {
        int i6 = this.f5575a;
        File file = this.i;
        switch (i6) {
            case 0:
                try {
                    M.a.p(new File(file, file.getName() + "." + i), aVar.f5345a);
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            default:
                try {
                    M.a.p(new File(file, file.getName() + "." + i), aVar.f5345a);
                    break;
                } catch (IOException e6) {
                    e6.printStackTrace();
                    break;
                }
        }
        return aVar;
        return aVar;
    }

    @Override // A2.f
    public final n2.a f(int i, n2.a aVar) {
        String str;
        String strValueOf;
        String str2;
        String strValueOf2;
        switch (this.f5575a) {
            case 0:
                com.zyql.ability.sdk.client.b bVar = (com.zyql.ability.sdk.client.b) this.f5576j;
                SystemClock.uptimeMillis();
                int i6 = 2;
                Throwable th = this.b;
                boolean z10 = this.c;
                if (i != 0) {
                    if (i == 1) {
                        Thread thread = this.g;
                        aVar.e(thread != null ? thread.getName() : "", "crash_thread_name");
                        aVar.e(Integer.valueOf(Process.myTid()), "tid");
                        aVar.f("crash_after_crash", Npth.hasCrashWhenJavaCrash() ? "true" : "false");
                        aVar.f("crash_after_native", NativeImpl.q() ? "true" : "false");
                        C1797b.c().getClass();
                        C1797b.e(thread, th, false, aVar);
                        break;
                    } else if (i == 2) {
                        if (z10) {
                            d.b(bVar.b, aVar.f5345a);
                        }
                        Object objY = h2.d.y();
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        Object objN = h2.d.n(jUptimeMillis);
                        Object objG = i.g(jUptimeMillis);
                        aVar.e(objY, "history_message");
                        aVar.e(objN, "current_message");
                        aVar.e(objG, "pending_messages");
                        aVar.f("disable_looper_monitor", String.valueOf(z2.b.f()));
                        strValueOf = String.valueOf(i2.a.a());
                        str = "npth_force_apm_crash";
                        aVar.f(str, strValueOf);
                        break;
                    } else if (i == 3) {
                        Object objM = e.m(Thread.currentThread().getName());
                        if (objM != null) {
                            aVar.e(objM, "all_thread_stacks");
                        }
                        aVar.e(M.a.g(0L, g.g()), "logcat");
                        break;
                    } else if (i == 4) {
                        if (!z10) {
                            d.b(bVar.b, aVar.f5345a);
                            break;
                        }
                    } else if (i == 5) {
                        aVar.e(this.h, "crash_uuid");
                        o.d(j.D(g.f2160a), CrashType.JAVA, "");
                        break;
                    }
                } else {
                    aVar.e(e.b(th), SettingsConfig.KEY_DATA);
                    aVar.e(Boolean.valueOf(z10), "isOOM");
                    aVar.e(1, "isJava");
                    aVar.e(Long.valueOf(this.d), "crash_time");
                    int i10 = A2.e.f81w;
                    if (i10 != 1) {
                        i6 = i10;
                    } else if (!A2.e.f82x) {
                        i6 = 1;
                    }
                    aVar.e(Integer.valueOf(i6), "launch_mode");
                    aVar.e(Long.valueOf(A2.e.y), "launch_time");
                    String str3 = this.e;
                    if (str3 != null) {
                        aVar.e(str3, "crash_md5");
                        aVar.f("crash_md5", str3);
                        boolean z11 = this.f;
                        if (z11) {
                            str = "has_ignore";
                            strValueOf = String.valueOf(z11);
                            aVar.f(str, strValueOf);
                        }
                    }
                }
                break;
            default:
                com.zyql.ability.sdk.client.b bVar2 = (com.zyql.ability.sdk.client.b) this.f5576j;
                SystemClock.uptimeMillis();
                int i11 = 2;
                Throwable th2 = this.b;
                long j5 = this.d;
                boolean z12 = this.c;
                if (i != 0) {
                    if (i == 1) {
                        aVar.e(Long.valueOf(j5), "timestamp");
                        aVar.e(Boolean.valueOf(d.l(bVar2.b)), "main_process");
                        aVar.e(CrashType.JAVA, "crash_type");
                        Thread thread2 = this.g;
                        aVar.e(thread2 != null ? thread2.getName() : "", "crash_thread_name");
                        aVar.e(Integer.valueOf(Process.myTid()), "tid");
                        aVar.f("crash_after_crash", Npth.hasCrashWhenJavaCrash() ? "true" : "false");
                        aVar.f("crash_after_native", NativeImpl.q() ? "true" : "false");
                        C1797b.c().getClass();
                        C1797b.e(thread2, th2, true, aVar);
                        break;
                    } else if (i == 2) {
                        if (z12) {
                            d.b(bVar2.b, aVar.f5345a);
                        }
                        aVar.e(C1912a.a(bVar2.b), "launch_did");
                        Object objY2 = h2.d.y();
                        long jUptimeMillis2 = SystemClock.uptimeMillis();
                        Object objN2 = h2.d.n(jUptimeMillis2);
                        Object objG2 = i.g(jUptimeMillis2);
                        aVar.e(objY2, "history_message");
                        aVar.e(objN2, "current_message");
                        aVar.e(objG2, "pending_messages");
                        aVar.f("disable_looper_monitor", String.valueOf(z2.b.f()));
                        strValueOf2 = String.valueOf(i2.a.a());
                        str2 = "npth_force_apm_crash";
                        aVar.f(str2, strValueOf2);
                        break;
                    } else if (i == 3) {
                        Object objM2 = e.m(Thread.currentThread().getName());
                        if (objM2 != null) {
                            aVar.e(objM2, "all_thread_stacks");
                        }
                        aVar.e(M.a.g(0L, g.g()), "logcat");
                        break;
                    } else if (i == 4) {
                        if (!z12) {
                            d.b(bVar2.b, aVar.f5345a);
                            break;
                        }
                    } else if (i == 5) {
                        aVar.e(this.h, "crash_uuid");
                        o.d(j.D(g.f2160a), CrashType.LAUNCH, "");
                        break;
                    }
                } else {
                    aVar.e(e.b(th2), "stack");
                    aVar.e("start_crash", "event_type");
                    aVar.e(Boolean.valueOf(z12), "isOOM");
                    aVar.e(Long.valueOf(j5), "crash_time");
                    int i12 = A2.e.f81w;
                    if (i12 != 1) {
                        i11 = i12;
                    } else if (!A2.e.f82x) {
                        i11 = 1;
                    }
                    aVar.e(Integer.valueOf(i11), "launch_mode");
                    aVar.e(Long.valueOf(A2.e.y), "launch_time");
                    String str4 = this.e;
                    if (str4 != null) {
                        aVar.e(str4, "crash_md5");
                        aVar.f("crash_md5", str4);
                        boolean z13 = this.f;
                        if (z13) {
                            str2 = "has_ignore";
                            strValueOf2 = String.valueOf(z13);
                            aVar.f(str2, strValueOf2);
                        }
                    }
                }
                break;
        }
        return aVar;
    }
}
