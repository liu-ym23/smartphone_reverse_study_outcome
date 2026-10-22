package com.obric.common.oea.style.scene.alpha.alphaplayer.player;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AbsPlayer.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c.a f32514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c.d f32515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c.b f32516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c.InterfaceC0890c f32517d;

    public a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
    }

    public /* synthetic */ a(Context r2, int r3, h r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = (Context) ZeusTransformUtils.preCheckCast(null, Context.class, "com.obric.aiagent.plugin");
    L5:
        this(r5);
    }

    public final c.a a() {
        return this.f32514a;
    }

    public final c.d b() {
        return this.f32515b;
    }

    public final c.b c() {
        return this.f32516c;
    }

    public final c.InterfaceC0890c d() {
        return this.f32517d;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void a(c.a r3) {
        c.a r4 = (c.a) ZeusTransformUtils.wrapperContextForParams(r3, c.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "completionListener");
        this.f32514a = r4;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void a(c.d r3) {
        c.d r4 = (c.d) ZeusTransformUtils.wrapperContextForParams(r3, c.d.class, "com.obric.aiagent.plugin");
        o.e(r4, "preparedListener");
        this.f32515b = r4;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void a(c.b r3) {
        c.b r4 = (c.b) ZeusTransformUtils.wrapperContextForParams(r3, c.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "errorListener");
        this.f32516c = r4;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void a(c.InterfaceC0890c r3) {
        c.InterfaceC0890c r4 = (c.InterfaceC0890c) ZeusTransformUtils.wrapperContextForParams(r3, c.InterfaceC0890c.class, "com.obric.aiagent.plugin");
        o.e(r4, "firstFrameListener");
        this.f32517d = r4;
    }
}
