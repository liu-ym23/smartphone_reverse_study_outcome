package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p005new;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.toolbarservice.api.IToolbarPlatformService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Set;
import jc1.k;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ot2.b;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f116165b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f116166a;

    @Override // ot2.b
    public final String a() {
        return this.f116166a.a();
    }

    @Override // ot2.b
    public final String b() {
        return this.f116166a.b();
    }

    @Override // ot2.b
    public final Disposable c(int r100, Function1<? super Integer, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r101, "checkFunc");
        return this.f116166a.c(r100, r101);
    }

    @Override // ot2.b
    public final String d() {
        return this.f116166a.d();
    }

    @Override // ot2.b
    public final String e() {
        return this.f116166a.e();
    }

    @Override // ot2.b
    public final void f(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "room");
        this.f116166a.f(r100);
    }

    @Override // ot2.b
    public final void g(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "reason");
        this.f116166a.g(r100, r101, r102);
    }

    @Override // ot2.b
    public final String getTAG() {
        return this.f116166a.getTAG();
    }

    @Override // ot2.b
    public final void h(List<s> r100, Set<Integer> r101, Set<Integer> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "loadErrorIds");
        Intrinsics.checkNotNullParameter(r102, "showErrorIds");
        this.f116166a.h(r100, r101, r102, r103);
    }

    @Override // ot2.b
    public final int i() {
        return this.f116166a.i();
    }

    @Override // ot2.b
    public final void j(s r100, String r101, boolean r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "action");
        this.f116166a.j(r100, r101, r110, r111, r112);
    }

    static {
        f116165b = new a();
    }

    public a() {
        this.f116166a = ((IToolbarPlatformService) k.n(IToolbarPlatformService.class)).getBottomToolbarLogImpl();
    }
}
