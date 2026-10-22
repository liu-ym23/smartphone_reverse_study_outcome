package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c0.b f116237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ToolbarButton f116238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<ExtendedToolbarButton, c0.b> f116239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f116240d;

    public e2() {
        throw null;
    }

    public abstract Panel a();

    public abstract boolean b();

    public final int hashCode() {
        return this.f116238b.hashCode();
    }

    public final boolean equals(Object r100) {
        ToolbarButton r101 = null;
        if ((r100 instanceof e2) == true) goto L5;
        r100 = null;
    L5:
        e2 r102 = (e2) r100;
        if (r102 == null) goto L9;
        r101 = r102.f116238b;
    L9:
        if (r101 != this.f116238b) goto L11;
        return true;
    L11:
        return false;
    }

    public e2(ToolbarButton r100, r r101) {
        Intrinsics.checkNotNullParameter(r100, "button");
        Intrinsics.checkNotNullParameter(r101, "behaviorFactory");
        this.f116238b = r100;
        this.f116239c = r101;
        this.f116240d = true;
    }
}
