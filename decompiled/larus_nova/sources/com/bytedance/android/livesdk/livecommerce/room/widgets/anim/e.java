package com.bytedance.android.livesdk.livecommerce.room.widgets.anim;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes10.dex */
public final class e extends b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Function0 f151995f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Function0 f151996g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Function0 f151997h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ View f151998i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Function0 f151999j;

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b
    public final void a() {
        Function0 r100 = this.f151996g;
        if (r100 == null) goto L6;
        Unit r101 = (Unit) r100.invoke();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b
    public final void b() {
        Function0 r100 = this.f151995f;
        if (r100 == null) goto L6;
        Unit r101 = (Unit) r100.invoke();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b
    public final void c() {
        Function0 r100 = this.f151997h;
        if (r100 == null) goto L6;
        Unit r101 = (Unit) r100.invoke();
        return;
    }

    public e(Function0 r100, Function0 r101, Function0 r102, View r103, Function0 r104, View r105, Function2 r106) {
        this.f151995f = r100;
        this.f151996g = r101;
        this.f151997h = r102;
        this.f151998i = r103;
        this.f151999j = r104;
        super("100", r105, 1, r106);
    }
}
