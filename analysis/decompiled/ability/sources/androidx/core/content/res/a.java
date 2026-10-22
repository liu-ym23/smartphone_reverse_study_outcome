package androidx.core.content.res;

import android.os.RemoteException;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.stepos.taskrobot.service.TaskRobotManagerImpl;

/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1918a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(Object obj, int i, int i6) {
        this.f1918a = i6;
        this.c = obj;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() throws RemoteException {
        switch (this.f1918a) {
            case 0:
                ((ResourcesCompat.FontCallback) this.c).lambda$callbackFailAsync$1(this.b);
                break;
            case 1:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.c;
                View view = (View) sideSheetBehavior.p.get();
                if (view != null) {
                    sideSheetBehavior.e(view, this.b, false);
                    break;
                }
                break;
            default:
                TaskRobotManagerImpl.cancelPackageConflict$lambda$0((String) this.c, this.b);
                break;
        }
    }
}
