package com.bytedance.android.livesdk.common;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes8.dex */
public class ViewModuleManager extends Fragment {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f119685g = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f119686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<a> f119687e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f119688f;

    static {
        f119685g = ViewModuleManager.class.getCanonicalName();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        if (this.f119688f != 6) goto L5;
        return;
    L5:
        this.f119688f = 6;
        Iterator r100 = ((CopyOnWriteArrayList) this.f119687e).iterator();
    L7:
        if (r100.hasNext() == false) goto L33;
        a r101 = (a) r100.next();
        Iterator r102 = ((HashSet) r101.f119690b).iterator();
    L10:
        if (r102.hasNext() == false) goto L32;
        Dialog r103 = (Dialog) r102.next();
        if (r103 == null) goto L10;
        if (r103.isShowing() == false) goto L10;
        Handler r104 = DialogLancet.resolveDialogHandler(r103);
        if (r104 == null) goto L20;
        if (Looper.myLooper() == r104.getLooper()) goto L20;
        r104.post(DialogLancet.createDismissRunnable(r103));
    L20:
        DialogLancet.beforeDialogDismiss(r103);
        r103.dismiss();     // Catch: Throwable -> L23 Exception -> L25
    L29:
        DialogLancet.afterDialogDismiss(r103);
        goto L10
    L25:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L23
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L23
        if (r105 == null) goto L29;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r103);
        throw th;
    L32:
        ((HashSet) r101.f119690b).clear();
        goto L7
    L33:
        ((CopyOnWriteArrayList) this.f119687e).clear();
        super.onDestroy();
    }

    public ViewModuleManager() {
        this.f119687e = new CopyOnWriteArrayList();
        this.f119688f = 0;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        this.f119688f = 4;
        Iterator r100 = ((CopyOnWriteArrayList) this.f119687e).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).getClass();
        goto L4
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f119688f = 3;
        Iterator r100 = ((CopyOnWriteArrayList) this.f119687e).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).getClass();
        goto L4
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f119688f = 2;
        Iterator r100 = ((CopyOnWriteArrayList) this.f119687e).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).getClass();
        goto L4
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f119688f = 5;
        Iterator r100 = ((CopyOnWriteArrayList) this.f119687e).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).getClass();
        goto L4
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f119688f = 1;
        Iterator r101 = ((CopyOnWriteArrayList) this.f119687e).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        a r102 = (a) r101.next();
        r102.f119689a = this.f119686d;
        goto L4
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        super.onSaveInstanceState(r100);
        Iterator r101 = ((CopyOnWriteArrayList) this.f119687e).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((a) r101.next()).getClass();
        goto L4
    }
}
