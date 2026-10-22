package com.obric.autoaction.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.e;
import com.bumptech.glide.g;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.m;
import com.bumptech.glide.load.resource.bitmap.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.net.URL;

/* JADX INFO: compiled from: GlideRequest.java */
/* JADX INFO: loaded from: classes3.dex */
public class b<TranscodeType> extends g<TranscodeType> implements Cloneable {
    @Override // com.bumptech.glide.g
    public /* synthetic */ g a() {
        return N();
    }

    @Override // com.bumptech.glide.g
    public /* synthetic */ g a(Bitmap r1) {
        return b(r1);
    }

    @Override // com.bumptech.glide.g
    public /* synthetic */ g a(Drawable r1) {
        return b(r1);
    }

    @Override // com.bumptech.glide.g
    public /* synthetic */ g a(Uri r1) {
        return b(r1);
    }

    @Override // com.bumptech.glide.g
    public /* synthetic */ g a(com.bumptech.glide.request.a r1) {
        return c(r1);
    }

    @Override // com.bumptech.glide.g
    public /* synthetic */ g a(com.bumptech.glide.request.g r3) {
        return b((com.bumptech.glide.request.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.g.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bumptech.glide.g
    public /* synthetic */ g a(File r1) {
        return b(r1);
    }

    @Override // com.bumptech.glide.g
    public /* synthetic */ g a(Integer r1) {
        return b(r1);
    }

    @Override // com.bumptech.glide.g
    public /* synthetic */ g a(Object r1) {
        return b(r1);
    }

    @Override // com.bumptech.glide.g
    public /* synthetic */ g a(String r1) {
        return b(r1);
    }

    @Override // com.bumptech.glide.g
    @Deprecated
    public /* synthetic */ g a(URL r1) {
        return b(r1);
    }

    @Override // com.bumptech.glide.g
    public /* synthetic */ g a(byte[] r1) {
        return b(r1);
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a a(float r1) {
        return b(r1);
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a a(e r1) {
        return b(r1);
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a a(j r1) {
        return b(r1);
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a a(com.bumptech.glide.load.g r3) {
        return b((com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a a(h r1, Object r2) {
        return b(r1, r2);
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a a(m r3) {
        return b((m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a a(l r1) {
        return b(r1);
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a a(Class r1) {
        return b(r1);
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a a(boolean r1) {
        return c(r1);
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a b(int r1, int r2) {
        return c(r1, r2);
    }

    @Override // com.bumptech.glide.g, com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a b(com.bumptech.glide.request.a r1) {
        return c(r1);
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a b(boolean r1) {
        return d(r1);
    }

    @Override // com.bumptech.glide.g, com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a c() {
        return N();
    }

    @Override // com.bumptech.glide.g, com.bumptech.glide.request.a
    public /* synthetic */ Object clone() {
        return N();
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a f() {
        return K();
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a g() {
        return L();
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a h() {
        return M();
    }

    b(Glide r3, RequestManager r4, Class<TranscodeType> r5, Context r6) {
        super(r3, r4, r5, (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin"));
    }

    public b<TranscodeType> b(float r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.aiagent.plugin");
    }

    public b<TranscodeType> c(boolean r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.aiagent.plugin");
    }

    public b<TranscodeType> b(j r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.aiagent.plugin");
    }

    public b<TranscodeType> b(e r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.aiagent.plugin");
    }

    public b<TranscodeType> d(boolean r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.b(r2), b.class, "com.obric.aiagent.plugin");
    }

    public b<TranscodeType> c(int r1, int r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.b(r1, r2), b.class, "com.obric.aiagent.plugin");
    }

    public b<TranscodeType> b(com.bumptech.glide.load.g r3) {
        return (b) ZeusTransformUtils.preCheckCast(super.a((com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin");
    }

    public <Y> b<TranscodeType> b(h<Y> r1, Y r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r1, r2), b.class, "com.obric.aiagent.plugin");
    }

    public b<TranscodeType> b(Class<?> r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.aiagent.plugin");
    }

    public b<TranscodeType> b(l r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.aiagent.plugin");
    }

    public b<TranscodeType> K() {
        return (b) ZeusTransformUtils.preCheckCast(super.f(), b.class, "com.obric.aiagent.plugin");
    }

    public b<TranscodeType> L() {
        return (b) ZeusTransformUtils.preCheckCast(super.g(), b.class, "com.obric.aiagent.plugin");
    }

    public b<TranscodeType> M() {
        return (b) ZeusTransformUtils.preCheckCast(super.h(), b.class, "com.obric.aiagent.plugin");
    }

    public b<TranscodeType> b(m<Bitmap> r3) {
        return (b) ZeusTransformUtils.preCheckCast(super.a((m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin");
    }

    public b<TranscodeType> c(com.bumptech.glide.request.a<?> r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.aiagent.plugin");
    }

    public b<TranscodeType> b(com.bumptech.glide.request.g<TranscodeType> r3) {
        return (b) ZeusTransformUtils.preCheckCast(super.a((com.bumptech.glide.request.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.g.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin");
    }

    public b<TranscodeType> b(Object r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.aiagent.plugin");
    }

    public b<TranscodeType> b(Bitmap r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.aiagent.plugin");
    }

    public b<TranscodeType> b(Drawable r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.aiagent.plugin");
    }

    public b<TranscodeType> b(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.aiagent.plugin");
    }

    public b<TranscodeType> b(Uri r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.aiagent.plugin");
    }

    public b<TranscodeType> b(File r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.aiagent.plugin");
    }

    public b<TranscodeType> b(Integer r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.aiagent.plugin");
    }

    @Deprecated
    public b<TranscodeType> b(URL r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.aiagent.plugin");
    }

    public b<TranscodeType> b(byte[] r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.a(r2), b.class, "com.obric.aiagent.plugin");
    }

    public b<TranscodeType> N() {
        return (b) ZeusTransformUtils.preCheckCast(super.a(), b.class, "com.obric.aiagent.plugin");
    }
}
