package com.bytedanceos.common.toolbox.glide;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.toolbox.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public static void a(Context r10) {
        Glide.get(r10).clearMemory();
    }

    public static void b(Context r10, View r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        Activity r12 = e(r10);
        if (r12 != null) goto L7;
    L9:
        Glide.with(r10).clear(r11);
        return;
    L7:
        if (r12.isDestroyed() == false) goto L9;
    }

    public static void c(Context r10, Target r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        Activity r12 = e(r10);
        if (r12 != null) goto L7;
    L9:
        Glide.with(r10).clear(r11);
        return;
    L7:
        if (r12.isDestroyed() == false) goto L9;
    }

    public static void d(View r10, Target r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        c(r10.getContext(), r11);
    }

    public static Activity e(Context r10) {
        if ((r10 instanceof Activity) == false) goto L7;
        return (Activity) r10;
    L7:
        if ((r10 instanceof ContextWrapper) == true) goto L9;
        return null;
    L9:
        return e(((ContextWrapper) r10).getBaseContext());
    }

    public static Target f(Context r10, String r11, int r12, int r13, int r14, BitmapTransformation[] r15, Target r16) {
        c(r10, r16);     // Catch: Exception -> L7
        RequestBuilder r17 = Glide.with(r10).asBitmap().load(a.a(r11)).placeholder(r12).error(r12).diskCacheStrategy(DiskCacheStrategy.RESOURCE).override(r13, r14);     // Catch: Exception -> L7
        if (r15 != null) goto L5;
    L9:
        return r17.into(r16);
    L5:
        if (r15.length <= 0) goto L9;
        r17.transform(r15);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        j.b(e.getMessage());
        return null;
    }

    public static void g(Context r10, int r11, String r12, ImageView r13) {
        b(r10, r13);
        Glide.with(r10).load(r12).error(r11).transition(new DrawableTransitionOptions().crossFade()).placeholder(r11).into(r13);
    }

    public static void h(Context r10, String r11, ImageView r12, RequestListener r13) {
        Glide.with(r10).load(r11).transition(new DrawableTransitionOptions().crossFade()).listener(r13).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(r12);
    }

    public static void i(Context r10, int r11, String r12, ImageView r13) {
        b(r10, r13);
        RequestOptions r14 = new RequestOptions().error(r11).placeholder(r11).dontAnimate().centerCrop().diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(r10).load(r12).apply(r14).transition(new DrawableTransitionOptions().crossFade()).into(r13);
    }

    public static void j(Context r10, String r11, ImageView r12) {
        i(r10, R$drawable.default_app_icon_normal, r11, r12);
    }

    public static void k(Context r10, int r11, String r12, ImageView r13, int r14) {
        l(r10, r11, r12, r13, 15, r14);
    }

    public static void l(Context r10, int r11, String r12, ImageView r13, int r14, int r15) {
        b(r10, r13);
        GlideRoundTransform r16 = new GlideRoundTransform();
        r16.f(r14).e(r15);
        RequestOptions r17 = new RequestOptions().error(r11).placeholder(r11).transform(r16).dontAnimate().centerCrop().diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(r10).load(r12).apply(r17).transition(new DrawableTransitionOptions().crossFade()).into(r13);
    }
}
