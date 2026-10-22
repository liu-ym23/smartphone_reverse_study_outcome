package com.obric.autoaction.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.k;
import com.bumptech.glide.request.g;
import com.bumptech.glide.request.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class GlideRequests extends RequestManager {
    @Override // com.bumptech.glide.RequestManager
    public /* synthetic */ RequestManager addDefaultRequestListener(g r3) {
        return addDefaultRequestListener((g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ RequestManager applyDefaultRequestOptions(h r1) {
        return applyDefaultRequestOptions(r1);
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ com.bumptech.glide.g as(Class r1) {
        return as(r1);
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ com.bumptech.glide.g asBitmap() {
        return asBitmap();
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ com.bumptech.glide.g asDrawable() {
        return asDrawable();
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ com.bumptech.glide.g asFile() {
        return asFile();
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ com.bumptech.glide.g asGif() {
        return asGif();
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ com.bumptech.glide.g download(Object r1) {
        return download(r1);
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ com.bumptech.glide.g downloadOnly() {
        return downloadOnly();
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ com.bumptech.glide.g load(Bitmap r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ com.bumptech.glide.g load(Drawable r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ com.bumptech.glide.g load(Uri r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ com.bumptech.glide.g load(File r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ com.bumptech.glide.g load(Integer r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ com.bumptech.glide.g load(Object r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ com.bumptech.glide.g load(String r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.RequestManager
    @Deprecated
    public /* bridge */ /* synthetic */ com.bumptech.glide.g load(URL r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ com.bumptech.glide.g load(byte[] r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.RequestManager
    /* JADX INFO: renamed from: load */
    public /* bridge */ /* synthetic */ Object mo20load(Bitmap r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.RequestManager
    /* JADX INFO: renamed from: load */
    public /* bridge */ /* synthetic */ Object mo21load(Drawable r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.RequestManager
    /* JADX INFO: renamed from: load */
    public /* bridge */ /* synthetic */ Object mo22load(Uri r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.RequestManager
    /* JADX INFO: renamed from: load */
    public /* bridge */ /* synthetic */ Object mo23load(File r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.RequestManager
    /* JADX INFO: renamed from: load */
    public /* bridge */ /* synthetic */ Object mo24load(Integer r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.RequestManager
    /* JADX INFO: renamed from: load */
    public /* bridge */ /* synthetic */ Object mo25load(Object r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.RequestManager
    /* JADX INFO: renamed from: load */
    public /* bridge */ /* synthetic */ Object mo26load(String r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.RequestManager
    @Deprecated
    /* JADX INFO: renamed from: load */
    public /* bridge */ /* synthetic */ Object mo27load(URL r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.RequestManager
    /* JADX INFO: renamed from: load */
    public /* bridge */ /* synthetic */ Object mo28load(byte[] r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ RequestManager setDefaultRequestOptions(h r1) {
        return setDefaultRequestOptions(r1);
    }

    public GlideRequests(Glide r3, com.bumptech.glide.manager.h r4, k r5, Context r6) {
        super(r3, (com.bumptech.glide.manager.h) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.manager.h.class, "com.obric.aiagent.plugin"), (k) ZeusTransformUtils.wrapperContextForParams(r5, k.class, "com.obric.aiagent.plugin"), (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bumptech.glide.RequestManager
    public <ResourceType> b<ResourceType> as(Class<ResourceType> r4) {
        return new b(this.glide, this, r4, this.context);
    }

    @Override // com.bumptech.glide.RequestManager
    public synchronized GlideRequests applyDefaultRequestOptions(h r3) {
        monitor-enter(this);
        GlideRequests r4 = (GlideRequests) ZeusTransformUtils.preCheckCast(super.applyDefaultRequestOptions(r3), GlideRequests.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.RequestManager
    public synchronized GlideRequests setDefaultRequestOptions(h r3) {
        monitor-enter(this);
        GlideRequests r4 = (GlideRequests) ZeusTransformUtils.preCheckCast(super.setDefaultRequestOptions(r3), GlideRequests.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.RequestManager
    public GlideRequests addDefaultRequestListener(g<Object> r3) {
        return (GlideRequests) ZeusTransformUtils.preCheckCast(super.addDefaultRequestListener((g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin")), GlideRequests.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.RequestManager
    public b<Bitmap> asBitmap() {
        return (b) ZeusTransformUtils.preCheckCast(super.asBitmap(), b.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.RequestManager
    public b<GifDrawable> asGif() {
        return (b) ZeusTransformUtils.preCheckCast(super.asGif(), b.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.RequestManager
    public b<Drawable> asDrawable() {
        return (b) ZeusTransformUtils.preCheckCast(super.asDrawable(), b.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.RequestManager
    public b<Drawable> load(Bitmap r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.load(r2), b.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.RequestManager
    public b<Drawable> load(Drawable r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.load(r2), b.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.RequestManager
    public b<Drawable> load(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.load(r2), b.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.RequestManager
    public b<Drawable> load(Uri r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.load(r2), b.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.RequestManager
    public b<Drawable> load(File r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.load(r2), b.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.RequestManager
    public b<Drawable> load(Integer r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.load(r2), b.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.RequestManager
    @Deprecated
    public b<Drawable> load(URL r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.load(r2), b.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.RequestManager
    public b<Drawable> load(byte[] r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.load(r2), b.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.RequestManager
    public b<Drawable> load(Object r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.load(r2), b.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.RequestManager
    public b<File> downloadOnly() {
        return (b) ZeusTransformUtils.preCheckCast(super.downloadOnly(), b.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.RequestManager
    public b<File> download(Object r2) {
        return (b) ZeusTransformUtils.preCheckCast(super.download(r2), b.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.RequestManager
    public b<File> asFile() {
        return (b) ZeusTransformUtils.preCheckCast(super.asFile(), b.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.RequestManager
    public void setRequestOptions(h r2) {
        if (ZeusTransformUtils.instanceOf(r2, a.class) == false) goto L5;
        super.setRequestOptions(r2);
        return;
    L5:
        super.setRequestOptions(new a().a(r2));
    }
}
