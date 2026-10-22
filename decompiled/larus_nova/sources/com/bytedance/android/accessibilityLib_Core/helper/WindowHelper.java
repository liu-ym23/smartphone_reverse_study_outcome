package com.bytedance.android.accessibilityLib_Core.helper;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.bytedance.android.accessibilityLib_Core.base.api.AbstractAccessibilityLibIsolation$appWindowEventListener$2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class WindowHelper extends e implements AppWindows.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f38275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<WeakReference<AppWindows.a>> f38276c;

    @Override // com.bytedance.android.accessibilityLib_Core.helper.AppWindows.a
    public final void a() {
    }

    @Override // com.bytedance.android.accessibilityLib_Core.helper.AppWindows.a
    public final void c(View r100, String r101) {
    }

    public WindowHelper() {
        this.f38275b = LazyKt.lazy(WindowHelper$appWindows$2.INSTANCE);
        this.f38276c = new ArrayList();
    }

    public final void d(final AbstractAccessibilityLibIsolation$appWindowEventListener$2.a r100) {
    L7:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L11;
        Context r101 = a.f38277a;
    L11:
        e.printStackTrace();
        Unit r102 = Unit.INSTANCE;
        return;
    L3:
        if (Build.VERSION.SDK_INT < 24) goto L5;
        ((ArrayList) this.f38276c).removeIf(new f(r100));     // Catch: Exception -> L7
    L13:
        return;
    L5:
        CollectionsKt.removeAll(this.f38276c, new WindowHelper$removeEventListener$$inlined$Try$lambda$2(this, r100));     // Catch: Exception -> L7
        goto L13
    }

    @Override // com.bytedance.android.accessibilityLib_Core.helper.AppWindows.a
    public final void b(Window r100, View r101, String r102) {
        Iterator r103 = ((ArrayList) this.f38276c).iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        AppWindows.a r104 = (AppWindows.a) ((WeakReference) r103.next()).get();
        if (r104 == null) goto L4;
        r104.b(r100, r101, r102);
        goto L4
    }
}
