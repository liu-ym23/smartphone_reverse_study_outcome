package g0;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Printer;
import h2.h;

/* loaded from: classes2.dex */
public final class d implements Printer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4459a;

    public /* synthetic */ d(int i) {
        this.f4459a = i;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        switch (this.f4459a) {
            case 0:
                if (!TextUtils.isEmpty(str)) {
                    if (str.charAt(0) != '>') {
                        if (str.charAt(0) == '<') {
                            e.b(str, false);
                            break;
                        }
                    } else {
                        e.b(str, true);
                        break;
                    }
                }
                break;
            case 1:
                if (!TextUtils.isEmpty(str)) {
                    boolean z10 = false;
                    if (str.charAt(0) == '>') {
                        z10 = true;
                    } else if (str.charAt(0) != '<') {
                    }
                    h.a(str, z10);
                    break;
                }
                break;
            default:
                if (str != null) {
                    if (str.charAt(0) == '>') {
                        z2.h hVarA = z2.h.a();
                        hVarA.f6930a = -1L;
                        try {
                            z2.h.b(str, hVarA.b);
                            break;
                        } catch (Exception e) {
                            S0.b.R(e);
                            return;
                        }
                    } else if (str.charAt(0) == '<') {
                        z2.h hVarA2 = z2.h.a();
                        hVarA2.getClass();
                        hVarA2.f6930a = SystemClock.uptimeMillis();
                        try {
                            z2.h.b(str, hVarA2.c);
                            break;
                        } catch (Exception e6) {
                            S0.b.p0(e6);
                        }
                    }
                }
                break;
        }
    }
}
