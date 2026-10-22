package m;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h0 implements m0, DialogInterface.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public h.h f7919c;

    /* renamed from: f, reason: collision with root package name */
    public i0 f7920f;

    /* renamed from: g, reason: collision with root package name */
    public CharSequence f7921g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ n0 f7922h;

    @Override // m.m0
    public final int a() {
        return 0;
    }

    @Override // m.m0
    public final boolean b() {
        h.h hVar = this.f7919c;
        if (hVar != null) {
            return hVar.isShowing();
        }
        return false;
    }

    @Override // m.m0
    public final void c(int i) {
        Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    @Override // m.m0
    public final CharSequence d() {
        return this.f7921g;
    }

    @Override // m.m0
    public final void dismiss() {
        h.h hVar = this.f7919c;
        if (hVar != null) {
            hVar.dismiss();
            this.f7919c = null;
        }
    }

    @Override // m.m0
    public final Drawable e() {
        return null;
    }

    @Override // m.m0
    public final void i(CharSequence charSequence) {
        this.f7921g = charSequence;
    }

    @Override // m.m0
    public final void j(Drawable drawable) {
        Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }

    @Override // m.m0
    public final void k(int i) {
        Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    @Override // m.m0
    public final void l(int i) {
        Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }

    @Override // m.m0
    public final void m(int i, int i3) {
        n0 n0Var = this.f7922h;
        if (this.f7920f == null) {
            return;
        }
        wd.a aVar = new wd.a(n0Var.getPopupContext());
        h.d dVar = (h.d) aVar.f15390g;
        CharSequence charSequence = this.f7921g;
        if (charSequence != null) {
            dVar.f4760d = charSequence;
        }
        i0 i0Var = this.f7920f;
        int selectedItemPosition = n0Var.getSelectedItemPosition();
        dVar.f4763g = i0Var;
        dVar.f4764h = this;
        dVar.f4765j = selectedItemPosition;
        dVar.i = true;
        h.h hVarF = aVar.f();
        this.f7919c = hVarF;
        AlertController$RecycleListView alertController$RecycleListView = hVarF.f4835j.f4815e;
        alertController$RecycleListView.setTextDirection(i);
        alertController$RecycleListView.setTextAlignment(i3);
        this.f7919c.show();
    }

    @Override // m.m0
    public final int o() {
        return 0;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        n0 n0Var = this.f7922h;
        n0Var.setSelection(i);
        if (n0Var.getOnItemClickListener() != null) {
            n0Var.performItemClick(null, i, this.f7920f.getItemId(i));
        }
        dismiss();
    }

    @Override // m.m0
    public final void p(ListAdapter listAdapter) {
        this.f7920f = (i0) listAdapter;
    }
}
