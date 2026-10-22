package com.bytedance.android.livesdk.arch.task;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class x implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f103934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.arch.context.a f103935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.livesdk.arch.comp.b f103936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l.b f103937d;

    @Override // com.bytedance.android.livesdk.arch.task.e
    public final com.bytedance.android.livesdk.arch.context.a a() {
        return this.f103935b;
    }

    @Override // com.bytedance.android.livesdk.arch.task.e
    public final boolean c() {
        return this.f103934a;
    }

    @Override // com.bytedance.android.livesdk.arch.task.e
    public final com.bytedance.android.livesdk.arch.comp.b d() {
        return this.f103936c;
    }

    @Override // com.bytedance.android.livesdk.arch.task.e
    public final l.b getCommandType() {
        return this.f103937d;
    }

    @Override // com.bytedance.android.livesdk.arch.task.e
    public final void b(boolean r100) {
        this.f103934a = r100;
    }

    public x(com.bytedance.android.livesdk.arch.context.a r100, com.bytedance.android.livesdk.arch.comp.b r101, l.b r102) {
        Intrinsics.checkNotNullParameter(r100, "tbContext");
        Intrinsics.checkNotNullParameter(r101, "comp");
        Intrinsics.checkNotNullParameter(r102, "commandType");
        this.f103935b = r100;
        this.f103936c = r101;
        this.f103937d = r102;
        this.f103934a = true;
    }
}
