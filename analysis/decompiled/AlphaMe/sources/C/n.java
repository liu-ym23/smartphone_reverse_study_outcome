package C;

import android.view.View;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* loaded from: classes.dex */
public final /* synthetic */ class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f269a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f270b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f271c;

    public /* synthetic */ n(int i4, int i5, Object obj) {
        this.f269a = i5;
        this.f271c = obj;
        this.f270b = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f269a;
        int i5 = this.f270b;
        Object obj = this.f271c;
        switch (i4) {
            case 0:
                ((b) obj).g(i5);
                break;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj;
                View view = (View) sideSheetBehavior.f10893p.get();
                if (view != null) {
                    sideSheetBehavior.e(view, i5, false);
                    break;
                }
                break;
        }
    }
}
