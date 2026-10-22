package com.bytedance.android.shopping.card_list.utils;

import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.card_list.monitor.error.CardListRunCatchExtKt;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class CardListExtentionsKt {
    public static final boolean a(Object r100) {
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L5;
        return true;
    L5:
        if (Intrinsics.areEqual(r100, "true") == false) goto L7;
        return true;
    L7:
        if (Intrinsics.areEqual(r100, 1) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static final Integer b(Object r100) {
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

    public static final RecyclerView e(View r100) {
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
        r101 = e(r104);
        if (r101 == null) goto L9;
        return r101;
    L20:
        return (RecyclerView) r104;
    L21:
        return r101;
    L15:
        return null;
    }

    public static final void h(final View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$hideSoftKeyBoard");
        CardListRunCatchExtKt.a(null, "hideSoftKeyBoard", new CardListExtentionsKt$hideSoftKeyBoard$1(r100));
    }

    public static final void i(final RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$scrollToTop");
        CardListRunCatchExtKt.a(null, "scrollToTop", new CardListExtentionsKt$scrollToTop$1(r100));
    }

    public static List g(Map r100, String r101) {
        List r102 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r100, "$this$getStringList");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "default");
        Object r103 = r100.get(r101);
        if ((r103 instanceof List) == true) goto L5;
        r103 = null;
    L5:
        List r104 = (List) r103;
        if (r104 != null) goto L9;
        return r102;
    L9:
        return r104;
    }

    public static final void j(TextView r100, Integer r101) {
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

    public static final boolean c(Map<String, ? extends Object> r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 != null) goto L5;
        return r102;
    L5:
        Object r103 = r100.get(r101);
        if (r103 != null) goto L9;
        r103 = Boolean.valueOf(r102);
    L9:
        return a(r103);
    }

    public static final int d(Map<String, ? extends Object> r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 != null) goto L5;
        return r102;
    L5:
        Object r103 = r100.get(r101);
        if (r103 != null) goto L9;
        r103 = Integer.valueOf(r102);
    L9:
        return mq.b.b(r103, 0);
    }

    public static final String f(Map<String, ? extends Object> r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "default");
        if (r100 == null) goto L15;
        Object r103 = r100.get(r101);
        if (r103 != null) goto L8;
        return r102;
    L8:
        if ((r103 instanceof String) == true) goto L10;
        r103 = null;
    L10:
        String r104 = (String) r103;
        if (r104 != null) goto L14;
        return r102;
    L14:
        return r104;
    L15:
        return r102;
    }
}
