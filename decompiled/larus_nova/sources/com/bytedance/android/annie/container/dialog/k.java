package com.bytedance.android.annie.container.dialog;

import com.bytedance.android.annie.api.container.HybridDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, HybridDialog> f39268a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, WeakReference<HybridDialog>> f39269b = null;

    static {
        f39268a = new LinkedHashMap();
        f39269b = new LinkedHashMap();
    }

    public static void a(HybridDialog r100) {
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @JvmStatic
    public static final void c(HybridDialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        String r101 = "";
        if (i9.e.f488748a.booleanValue() == false) goto L15;
        Iterator r102 = ((LinkedHashMap) f39269b).keySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L14;
        String r103 = (String) r102.next();
        WeakReference r104 = (WeakReference) ((LinkedHashMap) f39269b).get(r103);
        if (r104 == null) goto L10;
        HybridDialog r105 = (HybridDialog) r104.get();
    L12:
        if (Intrinsics.areEqual(r105, r100) == false) goto L6;
        r101 = r103;
        goto L6
    L10:
        r105 = null;
        goto L12
    L14:
        f39269b.remove(r101);
        return;
    L15:
        Iterator r106 = ((LinkedHashMap) f39268a).keySet().iterator();
    L17:
        if (r106.hasNext() == false) goto L21;
        String r107 = (String) r106.next();
        if (Intrinsics.areEqual(((LinkedHashMap) f39268a).get(r107), r100) == false) goto L17;
        r101 = r107;
        goto L17
    L21:
        f39268a.remove(r101);
    }

    @JvmStatic
    public static final void b(String r100, HybridDialog r101) {
        Intrinsics.checkNotNullParameter(r100, "scheme");
        Intrinsics.checkNotNullParameter(r101, "dialog");
        if (i9.e.f488748a.booleanValue() == false) goto L11;
        Map<String, WeakReference<HybridDialog>> r102 = f39269b;
        WeakReference r103 = (WeakReference) ((LinkedHashMap) r102).get(r100);
        if (r103 == null) goto L7;
        HybridDialog r104 = (HybridDialog) r103.get();
    L8:
        if (r104 != null) goto L10;
        r102.put(r100, new WeakReference(r101));
        return;
    L10:
        a(r101);
        return;
    L7:
        r104 = null;
        goto L8
    L11:
        Map<String, HybridDialog> r105 = f39268a;
        if (((HybridDialog) ((LinkedHashMap) r105).get(r100)) != null) goto L14;
        r105.put(r100, r101);
        return;
    L14:
        a(r101);
    }
}
