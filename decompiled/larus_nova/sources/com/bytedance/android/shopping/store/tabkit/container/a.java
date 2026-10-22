package com.bytedance.android.shopping.store.tabkit.container;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ABSTabkitBottomSheetFragment f186721a;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.tabkit.container.a$a, reason: collision with other inner class name */
    public static final class C2741a implements TabKitBottomSheetBehavior.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f186722a;

        public C2741a(a r100) {
            this.f186722a = r100;
        }

        @Override // com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetBehavior.a
        public final void a(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
            this.f186722a.f186721a.getClass();
            if (r101 != 5) goto L24;
            Dialog r102 = this.f186722a.f186721a.getDialog();
            if (r102 == null) goto L24;
            Handler r103 = DialogLancet.resolveDialogHandler(r102);
            if (r103 != null) goto L9;
        L11:
            DialogLancet.beforeDialogDismiss(r102);
            r102.dismiss();     // Catch: Throwable -> L14 Exception -> L16
        L20:
            DialogLancet.afterDialogDismiss(r102);
            goto L24
        L16:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
            Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
            if (r104 == null) goto L20;
            com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r102);
            throw th;
        L9:
            if (Looper.myLooper() == r103.getLooper()) goto L11;
            r103.post(DialogLancet.createDismissRunnable(r102));
        L24:
            if (r101 != 3) goto L30;
            this.f186722a.f186721a.V90(true);
            Iterator<T> r105 = this.f186722a.f186721a.f186641g.iterator();
        L27:
            if (r105.hasNext() == false) goto L30;
            ((ABSTabkitBottomSheetFragment.b) r105.next()).a();
        L30:
            if (r101 != 4) goto L35;
            this.f186722a.f186721a.V90(false);
            Iterator<T> r106 = this.f186722a.f186721a.f186641g.iterator();
        L33:
            if (r106.hasNext() == false) goto L41;
            ((ABSTabkitBottomSheetFragment.b) r106.next()).a();
            goto L33
        L41:
            return;
        }

        @Override // com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetBehavior.a
        public final void b(View r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
            this.f186722a.f186721a.W90(r101);
        }

        @Override // com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetBehavior.a
        public final void c(View r100, float r101, int r102, int r103, int r104) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        }
    }

    public a(ABSTabkitBottomSheetFragment r100) {
        this.f186721a = r100;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r100) {
        ABSTabkitBottomSheetFragment r101 = this.f186721a;
        View r102 = r101.f186639e;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r101.f186644j == false) goto L7;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        r103.width = -1;
        r103.height = -1;
    L8:
        TabKitBottomSheetBehavior<View> r104 = this.f186721a.f186638d;
        if (r104 == null) goto L11;
        C2741a r105 = new C2741a(this);
        Intrinsics.checkNotNullParameter(r105, "callback");
        r104.E.add(r105);
    L11:
        ABSTabkitBottomSheetFragment r106 = this.f186721a;
        TabKitBottomSheetBehavior<View> r107 = r106.f186638d;
        if (r107 == null) goto L14;
        r107.setHideable(r106.f186643i);
    L14:
        ABSTabkitBottomSheetFragment r108 = this.f186721a;
        TabKitBottomSheetBehavior<View> r109 = r108.f186638d;
        if (r109 == null) goto L17;
        r109.setPeekHeight(r108.T90());
    L17:
        ABSTabkitBottomSheetFragment r110 = this.f186721a;
        TabKitBottomSheetBehavior<View> r111 = r110.f186638d;
        if (r111 == null) goto L20;
        r111.f186662e = r110.f186644j;
    L20:
        if (r111 != null) goto L22;
        return;
    L22:
        if (r110.f186642h == 1) goto L24;
        int r112 = 3;
    L25:
        r111.setState(r112);
        return;
    L24:
        r112 = 4;
        goto L25
    L7:
        ViewGroup.LayoutParams r113 = r102.getLayoutParams();
        r113.width = -1;
        r113.height = this.f186721a.T90();
        goto L8
    }
}
