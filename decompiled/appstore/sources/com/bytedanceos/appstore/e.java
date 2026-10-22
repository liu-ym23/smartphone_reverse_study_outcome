package com.bytedanceos.appstore;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.io.File;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class e extends RequestManager {
    public e(Glide r10, Lifecycle r11, RequestManagerTreeNode r12, Context r13) {
        super(r10, r11, r12, r13);
    }

    public e a(RequestListener r10) {
        return (e) super.addDefaultRequestListener(r10);
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ RequestManager addDefaultRequestListener(RequestListener r10) {
        return a(r10);
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ RequestManager applyDefaultRequestOptions(RequestOptions r10) {
        return b(r10);
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ RequestBuilder as(Class r10) {
        return c(r10);
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ RequestBuilder asBitmap() {
        return d();
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ RequestBuilder asDrawable() {
        return e();
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ RequestBuilder asFile() {
        return f();
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ RequestBuilder asGif() {
        return g();
    }

    public synchronized e b(RequestOptions r10) {
        monitor-enter(this);
        e r11 = (e) super.applyDefaultRequestOptions(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    public d c(Class r10) {
        return new d(this.glide, this, r10, this.context);
    }

    public d d() {
        return (d) super.asBitmap();
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ RequestBuilder download(Object r10) {
        return h(r10);
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ RequestBuilder downloadOnly() {
        return i();
    }

    public d e() {
        return (d) super.asDrawable();
    }

    public d f() {
        return (d) super.asFile();
    }

    public d g() {
        return (d) super.asGif();
    }

    public d h(Object r10) {
        return (d) super.download(r10);
    }

    public d i() {
        return (d) super.downloadOnly();
    }

    public d j(Bitmap r10) {
        return (d) super.load(r10);
    }

    public d k(Drawable r10) {
        return (d) super.load(r10);
    }

    public d l(Uri r10) {
        return (d) super.load(r10);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(Bitmap r10) {
        return j(r10);
    }

    public d m(File r10) {
        return (d) super.load(r10);
    }

    public d n(Integer r10) {
        return (d) super.load(r10);
    }

    public d o(Object r10) {
        return (d) super.load(r10);
    }

    public d p(String r10) {
        return (d) super.load(r10);
    }

    public d q(URL r10) {
        return (d) super.load(r10);
    }

    public d r(byte[] r10) {
        return (d) super.load(r10);
    }

    public synchronized e s(RequestOptions r10) {
        monitor-enter(this);
        e r11 = (e) super.setDefaultRequestOptions(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ RequestManager setDefaultRequestOptions(RequestOptions r10) {
        return s(r10);
    }

    @Override // com.bumptech.glide.RequestManager
    public void setRequestOptions(RequestOptions r10) {
        if ((r10 instanceof c) == false) goto L5;
        super.setRequestOptions(r10);
        return;
    L5:
        super.setRequestOptions(new c().a(r10));
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(Drawable r10) {
        return k(r10);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(Uri r10) {
        return l(r10);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(File r10) {
        return m(r10);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(Integer r10) {
        return n(r10);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(Object r10) {
        return o(r10);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(String r10) {
        return p(r10);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(URL r10) {
        return q(r10);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(byte[] r10) {
        return r(r10);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    /* JADX INFO: renamed from: load, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load2(Bitmap r10) {
        return j(r10);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    /* JADX INFO: renamed from: load, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load2(Drawable r10) {
        return k(r10);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    /* JADX INFO: renamed from: load, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load2(Uri r10) {
        return l(r10);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    /* JADX INFO: renamed from: load, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load2(File r10) {
        return m(r10);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    /* JADX INFO: renamed from: load, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load2(Integer r10) {
        return n(r10);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    /* JADX INFO: renamed from: load, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load2(Object r10) {
        return o(r10);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    /* JADX INFO: renamed from: load, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load2(String r10) {
        return p(r10);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    /* JADX INFO: renamed from: load, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load2(URL r10) {
        return q(r10);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    /* JADX INFO: renamed from: load, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load2(byte[] r10) {
        return r(r10);
    }
}
