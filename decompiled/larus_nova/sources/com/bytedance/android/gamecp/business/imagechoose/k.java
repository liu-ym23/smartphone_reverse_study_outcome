package com.bytedance.android.gamecp.business.imagechoose;

import android.content.Context;
import com.bytedance.android.gamecp.base.core.service.depend.w;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import wu.l4;

/* JADX INFO: loaded from: classes44.dex */
public final class k<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f56090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f56091b;

    public k(i r100, Context r101) {
        this.f56090a = r100;
        this.f56091b = r101;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        w r101 = (w) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        i r102 = this.f56090a;
        Context r103 = this.f56091b;
        r102.getClass();
        int r104 = pt.a.f530616a;
        String r105 = r101.f51415e;
        if (r105 != null) goto L6;
        r105 = "";
    L6:
        return new i.b(r101, pt.a.a(r103, r105, l4.f561346a.getValue().b()));
    }
}
