package com.bytedance.android.livesdk.gamesticker.t01;

import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes8.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ T01GameViewController f125772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f125773b;

    public c(T01GameViewController r100, List r101) {
        this.f125772a = r100;
        this.f125773b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Long r111 = (Long) r110;
        this.f125772a.getClass();
        T01GameViewController r100 = this.f125772a;
        T01GameViewController.a r101 = null;
        if (r100.f125744j == false) goto L23;
        r100.f125744j = false;
        Iterator<T> r102 = this.f125773b.iterator();
    L6:
        if (r102.hasNext() == false) goto L18;
        T r103 = r102.next();
        long r104 = ((T01GameViewController.a) r103).f125746a;
        if (r111 != null) goto L11;
    L15:
        boolean r105 = false;
    L16:
        if (r105 == false) goto L6;
        r101 = r103;
        goto L18
    L11:
        if (r104 != r111.longValue()) goto L15;
        if (r111.longValue() == 0) goto L15;
        r105 = true;
    L18:
        T01GameViewController.a r106 = r101;
        if (r106 == null) goto L51;
        Function0<Unit> r112 = r106.f125748c;
        if (r112 == null) goto L52;
        Unit r113 = r112.invoke();
        return;
    L52:
        return;
    L51:
        return;
    L23:
        Iterator<T> r107 = this.f125773b.iterator();
    L25:
        if (r107.hasNext() == false) goto L35;
        T r108 = r107.next();
        long r109 = ((T01GameViewController.a) r108).f125746a;
        if (r111 != null) goto L30;
    L32:
        boolean r114 = false;
    L33:
        if (r114 == false) goto L25;
        r101 = r108;
        goto L35
    L30:
        if (r109 != r111.longValue()) goto L32;
        r114 = true;
    L35:
        T01GameViewController.a r115 = r101;
        if (r115 == null) goto L54;
        Function0<Unit> r116 = r115.f125748c;
        if (r116 == null) goto L55;
        Unit r117 = r116.invoke();
        return;
    L55:
        return;
    }
}
