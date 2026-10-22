package com.bytedance.android.gamecp.business.gallery.transfer;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import com.bytedance.android.gamecp.business.gallery.transfer.adapter.GalleryAdapter;
import com.bytedance.android.gamecp.business.gallery.view.image.TransferImage;
import com.bytedance.android.gamecp.common.utils.j0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements DialogInterface.OnShowListener, DialogInterface.OnKeyListener, e.d, DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f53288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AlertDialog f53289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f53290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f53291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f53292e;

    public final void b() {
        Activity r100 = com.bytedance.android.gamecp.common.utils.g.a(this.f53288a);
        if (r100 != null) goto L5;
        return;
    L5:
        AlertDialog r101 = new AlertDialog.Builder(r100, R.style.Theme.Translucent.NoTitleBar).setView(this.f53290c).create();
        this.f53289b = r101;
        if (r101 == null) goto L12;
        r101.setOnShowListener(this);
        this.f53289b.setOnKeyListener(this);
        this.f53289b.setOnDismissListener(this);
    L12:
        j0.c(this.f53289b.getWindow());     // Catch: Exception -> L11
        return;
    }

    public h(Context r100) {
        this.f53288a = r100;
        if (this.f53290c != null) goto L5;
        this.f53290c = new e(r100);
    L5:
        this.f53290c.setOnLayoutResetListener(this);
        b();
    }

    public static void a(AlertDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        d r101 = this.f53291d;
        if (r101 == null) goto L8;
        d.a r102 = r101.f53263s;
        if (r102 == null) goto L9;
        r102.a(this.f53289b, this.f53290c);
        return;
    L9:
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r100) {
        e r101 = this.f53290c;
        if (r101 == null) goto L23;
        d r102 = r101.f53269d;
        TransferImage r103 = null;
        if (r102 == null) goto L10;
        List<String> r104 = r102.f53252h;
        if (r104 == null) goto L10;
        GalleryAdapter r105 = new GalleryAdapter(r101, r104.size(), r101.f53269d.f53245a);
        r101.f53268c = r105;
        r105.f53234b = r101.f53279n;
        BounceBackViewPager r106 = new BounceBackViewPager(r101.f53272g, null);
        r101.f53267b = r106;
        r106.setOverScrollMode(2);
        r101.setBackgroundColor(r101.d(0.0f));
        r101.f53267b.setVisibility(4);
        r101.f53267b.setOffscreenPageLimit(r101.f53273h + 1);
        r101.f53267b.setAdapter(r101.f53268c);
        r101.f53267b.setCurrentItem(r101.f53269d.f53245a);
        r101.addView(r101.f53267b, new FrameLayout.LayoutParams(-1, -1));
    L10:
        d r107 = r101.f53269d;
        if (r107 == null) goto L23;
        int r108 = r107.f53245a;
        if (r108 >= 0) goto L15;
        r108 = 0;
    L15:
        c r109 = new c(r101);
        d r110 = r101.getTransConfig();
        if (r110 == null) goto L22;
        List r111 = r110.f53251g;
        if (r111 != null) goto L21;
        r111 = new ArrayList();
    L21:
        r103 = r109.a((ImageView) ListProtector.get(r111, r108));
        r109.b((String) ListProtector.get(r110.f53253i, r108), r103, true);
        r101.addView(r103, 1);
    L22:
        r101.f53266a = r103;
    L23:
        d r112 = this.f53291d;
        if (r112 == null) goto L29;
        d.a r113 = r112.f53263s;
        if (r113 == null) goto L30;
        r113.b(this.f53289b, this.f53290c);
        return;
    L30:
        return;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
        if (r101 == 4) goto L5;
    L17:
        return true;
    L5:
        if (r102.getAction() != 1) goto L17;
        if (r102.isCanceled() == true) goto L17;
        if (this.f53292e == false) goto L17;
        e r103 = this.f53290c;
        if (r103 == null) goto L17;
        d r104 = this.f53291d;
        if (r104 == null) goto L17;
        if (r103.c(r104.f53245a) == false) goto L17;
        this.f53292e = false;
        goto L17
    }
}
