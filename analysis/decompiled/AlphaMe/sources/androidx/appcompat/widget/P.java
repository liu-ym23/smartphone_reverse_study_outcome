package androidx.appcompat.widget;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.appcompat.app.C0182h;
import androidx.appcompat.app.C0186l;
import androidx.appcompat.app.DialogInterfaceC0187m;

/* loaded from: classes.dex */
public final class P implements U, DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public DialogInterfaceC0187m f2894a;

    /* renamed from: b, reason: collision with root package name */
    public ListAdapter f2895b;

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f2896c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ V f2897d;

    public P(V v4) {
        this.f2897d = v4;
    }

    @Override // androidx.appcompat.widget.U
    public final void d(Drawable drawable) {
        Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }

    @Override // androidx.appcompat.widget.U
    public final void dismiss() {
        DialogInterfaceC0187m dialogInterfaceC0187m = this.f2894a;
        if (dialogInterfaceC0187m != null) {
            dialogInterfaceC0187m.dismiss();
            this.f2894a = null;
        }
    }

    @Override // androidx.appcompat.widget.U
    public final boolean e() {
        DialogInterfaceC0187m dialogInterfaceC0187m = this.f2894a;
        if (dialogInterfaceC0187m != null) {
            return dialogInterfaceC0187m.isShowing();
        }
        return false;
    }

    @Override // androidx.appcompat.widget.U
    public final int f() {
        return 0;
    }

    @Override // androidx.appcompat.widget.U
    public final Drawable h() {
        return null;
    }

    @Override // androidx.appcompat.widget.U
    public final void j(CharSequence charSequence) {
        this.f2896c = charSequence;
    }

    @Override // androidx.appcompat.widget.U
    public final void k(int i4) {
        Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    @Override // androidx.appcompat.widget.U
    public final void l(int i4) {
        Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }

    @Override // androidx.appcompat.widget.U
    public final void m(int i4) {
        Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    @Override // androidx.appcompat.widget.U
    public final void n(int i4, int i5) {
        if (this.f2895b == null) {
            return;
        }
        V v4 = this.f2897d;
        C0186l c0186l = new C0186l(v4.getPopupContext());
        CharSequence charSequence = this.f2896c;
        if (charSequence != null) {
            ((C0182h) c0186l.f2661c).f2600d = charSequence;
        }
        ListAdapter listAdapter = this.f2895b;
        int selectedItemPosition = v4.getSelectedItemPosition();
        C0182h c0182h = (C0182h) c0186l.f2661c;
        c0182h.f2609m = listAdapter;
        c0182h.f2610n = this;
        c0182h.f2615s = selectedItemPosition;
        c0182h.f2614r = true;
        DialogInterfaceC0187m dialogInterfaceC0187mB = c0186l.b();
        this.f2894a = dialogInterfaceC0187mB;
        AlertController$RecycleListView alertController$RecycleListView = dialogInterfaceC0187mB.f2664f.f2639g;
        alertController$RecycleListView.setTextDirection(i4);
        alertController$RecycleListView.setTextAlignment(i5);
        this.f2894a.show();
    }

    @Override // androidx.appcompat.widget.U
    public final int o() {
        return 0;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i4) {
        V v4 = this.f2897d;
        v4.setSelection(i4);
        if (v4.getOnItemClickListener() != null) {
            v4.performItemClick(null, i4, this.f2895b.getItemId(i4));
        }
        dismiss();
    }

    @Override // androidx.appcompat.widget.U
    public final CharSequence p() {
        return this.f2896c;
    }

    @Override // androidx.appcompat.widget.U
    public final void q(ListAdapter listAdapter) {
        this.f2895b = listAdapter;
    }
}
