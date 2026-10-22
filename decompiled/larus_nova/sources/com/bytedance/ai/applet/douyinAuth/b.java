package com.bytedance.ai.applet.douyinAuth;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements Function3<String, String, String, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i<f> f34620a;

    public b(j r100) {
        this.f34620a = r100;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Unit invoke(String r100, String r101, String r102) {
        String r103 = r100;
        String r104 = r101;
        String r105 = r102;
        if (this.f34620a.isActive() == false) goto L6;
        this.f34620a.resumeWith(Result.m9449constructorimpl(new f(r103, r104, r105)));
    L6:
        return Unit.INSTANCE;
    }
}
