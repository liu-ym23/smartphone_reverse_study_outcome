package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes10.dex */
public final class g extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Function0 f148390f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Function0 f148391g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Function0 f148392h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ View f148393i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Function0 f148394j;

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.a
    public final void a() {
        Function0 r100 = this.f148391g;
        if (r100 == null) goto L6;
        Unit r101 = (Unit) r100.invoke();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.a
    public final void b() {
        Function0 r100 = this.f148390f;
        if (r100 == null) goto L6;
        Unit r101 = (Unit) r100.invoke();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.a
    public final void c() {
        Function0 r100 = this.f148392h;
        if (r100 == null) goto L6;
        Unit r101 = (Unit) r100.invoke();
        return;
    }

    public g(Function0 r100, Function0 r101, Function0 r102, View r103, Function0 r104, View r105, Function2 r106) {
        this.f148390f = r100;
        this.f148391g = r101;
        this.f148392h = r102;
        this.f148393i = r103;
        this.f148394j = r104;
        super("100", r105, 0, r106);
    }
}
