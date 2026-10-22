package r6;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.profileinstaller.ProfileInstallReceiver;
import com.stepos.stepclaw.SecurePrefs;
import e0.a0;
import e0.t0;
import e0.x0;
import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.asn1.BERTags;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class x implements h, e0.k, t0.e {

    /* renamed from: b, reason: collision with root package name */
    public static x f5219b;

    /* renamed from: a, reason: collision with root package name */
    public Object f5220a;

    public /* synthetic */ x(Object obj) {
        this.f5220a = obj;
    }

    public static int f(int i8, int i9) {
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < i8; i12++) {
            i10++;
            if (i10 == i9) {
                i11++;
                i10 = 0;
            } else if (i10 > i9) {
                i11++;
                i10 = 1;
            }
        }
        return i10 + 1 > i9 ? i11 + 1 : i11;
    }

    @Override // r6.h
    public p a() throws Throwable {
        u uVarB;
        IOException iOException = null;
        while (!((r) this.f5220a).f5203l.f5171q) {
            try {
                uVarB = ((r) this.f5220a).b();
            } catch (IOException e9) {
                if (iOException == null) {
                    iOException = e9;
                } else {
                    a.a.a(iOException, e9);
                }
                if (!((r) this.f5220a).a(null)) {
                    throw iOException;
                }
            }
            if (!uVarB.isReady()) {
                t tVarF = uVarB.f();
                if (tVarF.f5211b == null && tVarF.f5212c == null) {
                    tVarF = uVarB.c();
                }
                u uVar = tVarF.f5211b;
                Throwable th = tVarF.f5212c;
                if (th != null) {
                    throw th;
                }
                if (uVar != null) {
                    ((r) this.f5220a).f5208q.addFirst(uVar);
                }
            }
            return uVarB.d();
        }
        throw new IOException("Canceled");
    }

    @Override // r6.h
    public v b() {
        return (r) this.f5220a;
    }

    @Override // e0.k
    public x0 c(View view, x0 x0Var) {
        t0 t0Var = x0Var.f2338a;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f5220a;
        if (!Objects.equals(coordinatorLayout.f392o, x0Var)) {
            coordinatorLayout.f392o = x0Var;
            boolean z = x0Var.a() > 0;
            coordinatorLayout.f393p = z;
            coordinatorLayout.setWillNotDraw(!z && coordinatorLayout.getBackground() == null);
            if (!t0Var.n()) {
                int childCount = coordinatorLayout.getChildCount();
                for (int i8 = 0; i8 < childCount; i8++) {
                    View childAt = coordinatorLayout.getChildAt(i8);
                    int[] iArr = a0.f2285a;
                    if (childAt.getFitsSystemWindows() && ((t.d) childAt.getLayoutParams()).f5389a != null && t0Var.n()) {
                        break;
                    }
                }
            }
            coordinatorLayout.requestLayout();
        }
        return x0Var;
    }

    @Override // t0.e
    public void d() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // t0.e
    public void e(int i8, Object obj) {
        String str;
        switch (i8) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case BERTags.EMBEDDED_PDV /* 11 */:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i8 == 6 || i8 == 7 || i8 == 8) {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        } else {
            Log.d("ProfileInstaller", str);
        }
        ((ProfileInstallReceiver) this.f5220a).setResultCode(i8);
    }

    public x(int i8) {
        switch (i8) {
            case 5:
                this.f5220a = new Object();
                new Handler(Looper.getMainLooper(), new v1.e(this));
                break;
            default:
                this.f5220a = new SparseIntArray();
                new SparseIntArray();
                break;
        }
    }
}
