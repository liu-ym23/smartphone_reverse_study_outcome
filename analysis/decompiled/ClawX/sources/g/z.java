package g;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2874a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2875b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f2876c;
    public final /* synthetic */ Object d;

    public z(TextView textView, Typeface typeface, int i8) {
        this.f2876c = textView;
        this.d = typeface;
        this.f2875b = i8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2874a) {
            case 0:
                ((TextView) this.f2876c).setTypeface((Typeface) this.d, this.f2875b);
                break;
            default:
                ((BottomSheetBehavior) this.d).E(this.f2876c, this.f2875b, false);
                break;
        }
    }

    public z(BottomSheetBehavior bottomSheetBehavior, View view, int i8) {
        this.d = bottomSheetBehavior;
        this.f2876c = view;
        this.f2875b = i8;
    }
}
