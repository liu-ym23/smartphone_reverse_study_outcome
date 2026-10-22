package com.bytedance.android.livesdk.chatroom.dsl;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yt1.m;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DSLContainerDynamicProxy f105885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f105886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f105887c;

    @Override // yt1.m
    public final void onFetchSuccess() {
    }

    public a(DSLContainerDynamicProxy r100, Function1 r101, Function1 r102) {
        this.f105885a = r100;
        this.f105886b = r101;
        this.f105887c = r102;
    }

    @Override // yt1.m
    public final void a(com.bytedance.android.livesdk.dslservice.a r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "loadFrom");
        Intrinsics.checkNotNullParameter(r102, "loadFrom");
        if (r100 != null) goto L5;
        return;
    L5:
        View r103 = r100.getView();
        if ((r103 instanceof ViewGroup) == true) goto L8;
        r103 = null;
    L8:
        ViewGroup r104 = (ViewGroup) r103;
        if (r104 == null) goto L11;
        DSLContainerDynamicProxy r105 = this.f105885a;
        Function1<View, Unit> r106 = new DSLContainerDynamicProxy$asyncCreateDSLDynamicView$1$onLoadSuccess$1(this);
        r105.getClass();
        DSLContainerDynamicProxy.d(r104, r106);
    L11:
        Function1 r107 = this.f105887c;
        if (r107 == null) goto L15;
        Unit r108 = (Unit) r107.invoke(r100);
        return;
    }

    @Override // yt1.m
    public final void b(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "reason");
        m.a.a(r100, r101);
        Function1 r103 = this.f105887c;
        if (r103 == null) goto L6;
        Unit r104 = (Unit) r103.invoke(null);
        return;
    }
}
