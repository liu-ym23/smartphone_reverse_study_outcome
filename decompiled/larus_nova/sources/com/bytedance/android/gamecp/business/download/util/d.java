package com.bytedance.android.gamecp.business.download.util;

import android.content.Context;
import com.bytedance.android.gamecp.common.utils.m1;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import ita.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f52949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f52950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f52951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f52952d;

    public d(List r100, Context r101, String r102, String r103) {
        this.f52949a = r100;
        this.f52950b = r101;
        this.f52951c = r102;
        this.f52952d = r103;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<List<String>> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        List r101 = this.f52949a;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        T r104 = r103.next();
        Context r105 = this.f52950b;
        if (k.h(r105, (String) r104) == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        int r106 = m1.f57241a;
        m1.a(this.f52951c);
        m1.a(this.f52952d);
        r100.onNext(r102);
    }
}
