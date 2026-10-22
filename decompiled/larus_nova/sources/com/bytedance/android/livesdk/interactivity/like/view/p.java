package com.bytedance.android.livesdk.interactivity.like.view;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class p<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DiggCountFlipperLayout f137951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f137952b;

    public p(DiggCountFlipperLayout r100, int r101) {
        this.f137951a = r100;
        this.f137952b = r101;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r110) {
        Long r111 = (Long) r110;
        Intrinsics.checkNotNullParameter(r111, "count");
        if (this.f137951a.f137822k == false) goto L44;
        long r100 = r111.longValue();
        int r112 = this.f137952b;
        int r101 = (int) (r100 % ((long) r112));
        int r102 = ((r101 - 1) + r112) % r112;
        DiggCountFlipperLayout r113 = this.f137951a;
        r113.getClass();
        if (r101 == r102) goto L14;
        if (r101 < 0) goto L14;
        if (r101 >= r113.f137833v.size()) goto L14;
        if (r102 < 0) goto L14;
        if (r102 >= r113.f137833v.size()) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L44;
        Iterator<ArrayList<View>> r104 = r113.f137833v.iterator();
        int r105 = 0;
    L19:
        if (r104.hasNext() == false) goto L31;
        ArrayList<View> r106 = r104.next();
        int r107 = r105 + 1;
        if (r105 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        ArrayList<View> r108 = r106;
        if (r105 == r101) goto L30;
        if (r105 == r102) goto L30;
        Iterator<T> r109 = r108.iterator();
    L28:
        if (r109.hasNext() == false) goto L30;
        View r114 = (View) r109.next();
        r114.clearAnimation();
        r114.setVisibility(8);
    L30:
        r105 = r107;
        goto L19
    L31:
        Iterator<T> r115 = ((Iterable) ListProtector.get(r113.f137833v, r101)).iterator();
    L33:
        if (r115.hasNext() == false) goto L35;
        ((View) r115.next()).startAnimation(r113.f137818g);
        goto L33
    L35:
        Iterator<T> r116 = ((Iterable) ListProtector.get(r113.f137833v, r102)).iterator();
    L37:
        if (r116.hasNext() == false) goto L39;
        ((View) r116.next()).startAnimation(r113.f137819h);
        goto L37
    L39:
        Iterator<T> r117 = ((Iterable) ListProtector.get(r113.f137833v, r101)).iterator();
    L41:
        if (r117.hasNext() == false) goto L44;
        View r118 = (View) r117.next();
        r118.setVisibility(0);
        r113.g(r118, r101 + 1);
    L14:
        r103 = false;
    L44:
        return Unit.INSTANCE;
    }
}
