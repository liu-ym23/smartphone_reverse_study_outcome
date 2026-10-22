package com.bytedance.android.live.revenue.common;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class ToastUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f90810a = 0;

    static {
    }

    public static void c(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Context r101 = s1.getContext();
        if (r101 != null) goto L7;
        return;
    L7:
        Toast r102 = new Toast(r101);
        r102.setGravity(17, 0, 0);
        r102.setView(r100);
        r102.setDuration(0);
        r102.show();
    }

    public static void a(int r100, int r101) {
        Context r102 = s1.getContext();
        if (r102 != null) goto L5;
        return;
    L5:
        b(r102.getString(r100), r101);
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [T, kotlin.Unit] */
    /* JADX WARN: Type inference failed for: r5v3, types: [T, kotlin.Unit] */
    public static void b(final String r100, final int r101) {
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return;
    L12:
        if ((!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) == false) goto L15;
        Function0<Unit> r103 = new ToastUtil$centerToast$1(r100, r101);
        Intrinsics.checkNotNullParameter(r103, "action");
        com.bytedance.live.kmp.util.f.a(r103);
        return;
    L15:
        Context r104 = s1.getContext();
        if (r104 != null) goto L18;
        return;
    L18:
        kjc.c r105 = new kjc.c();
        if (3 != kjc.a.a()) goto L22;
        kjc.b<T> r106 = r105.f503730a;
        ((bi6.a) vh6.c.b(bi6.a.class)).x(r100, r101);
        r106.f503729a = Unit.INSTANCE;
        r105.f503731b = true;
    L22:
        if (r105.f503731b == true) goto L24;
        kjc.b<T> r107 = r105.f503730a;
        ((bi6.a) vh6.c.b(bi6.a.class)).centerToast(r104, r100, r101);
        r107.f503729a = Unit.INSTANCE;
    L24:
        T r108 = r105.f503730a.f503729a;
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
