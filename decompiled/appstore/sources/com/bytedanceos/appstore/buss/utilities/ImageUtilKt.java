package com.bytedanceos.appstore.buss.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bytedanceos.appstore.buss.utilities.image.RoundedAppIconCornersTransformation;
import com.bytedanceos.appstore.buss.utilities.image.RoundedCornersTransformation;
import com.bytedanceos.common.BaseApplication;
import com.obric.appstore.R;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImageUtilKt {
    public static final void a() {
        com.bytedanceos.appstore.b.a(BaseApplication.c()).clearMemory();
    }

    public static final Activity b(Context r10) {
        if ((r10 instanceof Activity) == false) goto L6;
        return (Activity) r10;
    L6:
        if ((r10 instanceof ContextWrapper) == false) goto L8;
        Context r11 = ((ContextWrapper) r10).getBaseContext();
        kotlin.jvm.internal.q.f(r11, "getBaseContext(...)");
        return b(r11);
    L8:
        return null;
    }

    public static final Object c(ImageView r10, Object r11, Continuation r12) {
        Context r13 = r10.getContext();
        kotlin.jvm.internal.q.f(r13, "getContext(...)");
        Activity r14 = b(r13);
        if (r14 != null) goto L5;
    L9:
        return null;
    L5:
        if (r14.isDestroyed() == true) goto L9;
        return kotlinx.coroutines.h.g(l0.b(), new ImageUtilKt$getBitmapByUrl$2(r10, r11, null), r12);
    }

    public static final void d(ImageView r10, Object r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        Context r12 = r10.getContext();
        kotlin.jvm.internal.q.f(r12, "getContext(...)");
        Activity r13 = b(r12);
        if (r13 != null) goto L5;
        return;
    L5:
        if (r13.isDestroyed() == true) goto L14;
        com.bytedanceos.appstore.e r14 = com.bytedanceos.appstore.b.b(r10);
        if (r11 == null) goto L10;
        Object r15 = com.bytedanceos.common.toolbox.glide.a.a(r11);
    L11:
        r14.o(r15).Q(R.drawable.default_app_icon_normal).o(R.color.grey).into(r10);
        return;
    L10:
        r15 = null;
        goto L11
    }

    public static final void e(ImageView r10, Object r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        Context r12 = r10.getContext();
        kotlin.jvm.internal.q.f(r12, "getContext(...)");
        Activity r13 = b(r12);
        if (r13 != null) goto L5;
        return;
    L5:
        if (r13.isDestroyed() == true) goto L14;
        com.bytedanceos.appstore.e r14 = com.bytedanceos.appstore.b.b(r10);
        if (r11 == null) goto L10;
        Object r15 = com.bytedanceos.common.toolbox.glide.a.a(r11);
    L11:
        r14.o(r15).W(true).i(DiskCacheStrategy.NONE).Q(R.drawable.avator_profile_default).o(R.drawable.avator_profile_default).c0(new com.bytedanceos.appstore.buss.utilities.image.b()).into(r10);
        return;
    L10:
        r15 = null;
        goto L11
    }

    public static final void f(ImageView r10, Object r11, int r12, int r13) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        Context r14 = r10.getContext();
        kotlin.jvm.internal.q.f(r14, "getContext(...)");
        Activity r15 = b(r14);
        if (r15 != null) goto L5;
        return;
    L5:
        if (r15.isDestroyed() == true) goto L14;
        com.bytedanceos.appstore.e r16 = com.bytedanceos.appstore.b.b(r10);
        if (r11 == null) goto L10;
        Object r17 = com.bytedanceos.common.toolbox.glide.a.a(r11);
    L11:
        r16.o(r17).Q(r13).c0(new RoundedAppIconCornersTransformation(g.a(r12), 0)).o(R.color.grey).into(r10);
        return;
    L10:
        r17 = null;
        goto L11
    }

    public static /* synthetic */ void g(ImageView r10, Object r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r13 = R.drawable.default_app_icon_normal;
    L5:
        f(r10, r11, r12, r13);
    }

    public static final void h(ImageView r10, Object r11, int r12) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        Context r13 = r10.getContext();
        kotlin.jvm.internal.q.f(r13, "getContext(...)");
        Activity r14 = b(r13);
        if (r14 != null) goto L5;
        return;
    L5:
        if (r14.isDestroyed() == true) goto L14;
        com.bytedanceos.appstore.e r15 = com.bytedanceos.appstore.b.b(r10);
        if (r11 == null) goto L10;
        Object r16 = com.bytedanceos.common.toolbox.glide.a.a(r11);
    L11:
        r15.o(r16).Q(R.drawable.default_app_icon_normal).c0(new RoundedCornersTransformation(r12, 0)).o(R.color.grey).into(r10);
        return;
    L10:
        r16 = null;
        goto L11
    }

    public static final void i(ImageView r10, Object r11, int r12, int r13) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        Context r14 = r10.getContext();
        kotlin.jvm.internal.q.f(r14, "getContext(...)");
        Activity r15 = b(r14);
        if (r15 != null) goto L5;
        return;
    L5:
        if (r15.isDestroyed() == true) goto L14;
        com.bytedanceos.appstore.e r16 = com.bytedanceos.appstore.b.b(r10);
        if (r11 == null) goto L10;
        Object r17 = com.bytedanceos.common.toolbox.glide.a.a(r11);
    L11:
        r16.o(r17).Q(r13).c0(new RoundedCornersTransformation(r12, 0)).o(r13).into(r10);
        return;
    L10:
        r17 = null;
        goto L11
    }

    public static /* synthetic */ void j(ImageView r10, Object r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L5;
        r12 = 10;
    L5:
        i(r10, r11, r12, r13);
    }

    public static /* synthetic */ void k(ImageView r10, Object r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = 10;
    L5:
        h(r10, r11, r12);
    }
}
