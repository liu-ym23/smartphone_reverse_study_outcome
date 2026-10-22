package com.bytedance.ai.applet.permission;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements Function1<Boolean, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i<Boolean> f34941a;

    public d(j r100) {
        this.f34941a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Boolean r100) {
        boolean r101 = r100.booleanValue();
        if (this.f34941a.isActive() == false) goto L6;
        Boolean r102 = Boolean.valueOf(r101);
        this.f34941a.resumeWith(Result.m9449constructorimpl(r102));
    L6:
        return Unit.INSTANCE;
    }
}
