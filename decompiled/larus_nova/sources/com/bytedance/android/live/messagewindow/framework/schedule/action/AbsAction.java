package com.bytedance.android.live.messagewindow.framework.schedule.action;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import j71.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class AbsAction<State> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PropertyOwner<State> f83197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PropertyOwner f83198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f83199c;

    public AbsAction(a r100, State r101) {
        Intrinsics.checkNotNullParameter(r100, "cmd");
        Intrinsics.checkNotNullParameter(r101, "initState");
        this.f83199c = r100;
        PropertyOwner<State> r102 = new PropertyOwner(r101, AbsAction$_curState$1.INSTANCE);
        this.f83197a = r102;
        this.f83198b = r102;
    }
}
