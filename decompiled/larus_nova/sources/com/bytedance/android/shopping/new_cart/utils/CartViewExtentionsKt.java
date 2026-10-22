package com.bytedance.android.shopping.new_cart.utils;

import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class CartViewExtentionsKt {

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f179355a;

        public a(View r100) {
            this.f179355a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object r100 = this.f179355a.getContext().getSystemService("input_method");     // Catch: Throwable -> L9
            if ((r100 instanceof InputMethodManager) == true) goto L5;
            r100 = null;
        L5:
            InputMethodManager r101 = (InputMethodManager) r100;     // Catch: Throwable -> L9
            if (r101 == null) goto L12;
            r101.hideSoftInputFromWindow(this.f179355a.getWindowToken(), 0);     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class b implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CartViewExtentionsKt$scaleImageToFitWidth$1 f179356a;

        public b(CartViewExtentionsKt$scaleImageToFitWidth$1 r100) {
            this.f179356a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            this.f179356a.invoke2();
        }
    }

    public static final Integer a(Object r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L10
        if ((r100 instanceof Number) == false) goto L7;
        return Integer.valueOf(((Number) r100).intValue());
    L7:
        if ((r100 instanceof String) == true) goto L9;
        return null;
    L9:
        return Integer.valueOf(CastIntegerProtector.parseInt((String) r100));
    L10:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    public static final RecyclerView b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getRecyclerView");
        RecyclerView r101 = null;
        if ((r100 instanceof ViewGroup) == true) goto L5;
        r100 = null;
    L5:
        ViewGroup r102 = (ViewGroup) r100;
        if (r102 == null) goto L15;
        Iterator<T> r103 = com.bytedance.commerce.base.view.b.a(r102).iterator();
    L9:
        if (r103.hasNext() == false) goto L21;
        View r104 = (View) r103.next();
        if ((r104 instanceof RecyclerView) == true) goto L20;
        r101 = b(r104);
        if (r101 == null) goto L9;
        return r101;
    L20:
        return (RecyclerView) r104;
    L21:
        return r101;
    L15:
        return null;
    }

    public static final void c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$hideSoftKeyBoard");
        com.bytedance.android.shopping.new_cart.utils.a.f179359c.d("hideSoftKeyBoard", new a(r100));
    }

    public static final void d(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$scaleImageToFitWidth");
        r100.setScaleType(ImageView.ScaleType.MATRIX);
        CartViewExtentionsKt$scaleImageToFitWidth$1 r101 = new CartViewExtentionsKt$scaleImageToFitWidth$1(r100);
        if (r100.getWidth() > 0) goto L5;
    L7:
        r100.addOnLayoutChangeListener(new b(r101));
        return;
    L5:
        if (r100.getDrawable() == null) goto L7;
        r101.invoke2();
        goto L7
    }

    public static final void e(TextView r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setWeightAsSlc");
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L7:
        if (Build.VERSION.SDK_INT < 28) goto L10;
        r100.setTypeface(Typeface.create(r100.getTypeface(), r102, r100.getTypeface().isItalic()));
        return;
    L10:
        if (com.bytedance.android.ecom.arch.slice.render.h.a(Integer.valueOf(r102)) == false) goto L12;
        r100.setTypeface(null, 1);
        return;
    L12:
        r100.setTypeface(null, 0);
        return;
    L5:
        r102 = 400;
        goto L7
    }
}
