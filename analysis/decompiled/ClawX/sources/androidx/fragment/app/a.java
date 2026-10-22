package androidx.fragment.app;

import android.view.View;
import androidx.emoji2.text.t;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f656a;

    /* renamed from: b, reason: collision with root package name */
    public int f657b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f658c;
    public final Object d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f659e;

    public a(k kVar) {
        this.f656a = 0;
        kVar.getClass();
        this.d = new ArrayList();
        this.f657b = -1;
        this.f659e = kVar;
    }

    public void a(int i8) {
        switch (this.f656a) {
            case 1:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f659e;
                WeakReference weakReference = bottomSheetBehavior.W;
                if (weakReference != null && weakReference.get() != null) {
                    this.f657b = i8;
                    if (!this.f658c) {
                        ((View) bottomSheetBehavior.W.get()).postOnAnimation((b) this.d);
                        this.f658c = true;
                        break;
                    }
                }
                break;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f659e;
                WeakReference weakReference2 = sideSheetBehavior.f1339p;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.f657b = i8;
                    if (!this.f658c) {
                        ((View) sideSheetBehavior.f1339p.get()).postOnAnimation((t) this.d);
                        this.f658c = true;
                        break;
                    }
                }
                break;
        }
    }

    public String toString() {
        switch (this.f656a) {
            case 0:
                StringBuilder sb = new StringBuilder(128);
                sb.append("BackStackEntry{");
                sb.append(Integer.toHexString(System.identityHashCode(this)));
                if (this.f657b >= 0) {
                    sb.append(" #");
                    sb.append(this.f657b);
                }
                sb.append("}");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public a(SideSheetBehavior sideSheetBehavior) {
        this.f656a = 2;
        this.f659e = sideSheetBehavior;
        this.d = new t(7, this);
    }

    public a(BottomSheetBehavior bottomSheetBehavior) {
        this.f656a = 1;
        this.f659e = bottomSheetBehavior;
        this.d = new b(7, this);
    }
}
