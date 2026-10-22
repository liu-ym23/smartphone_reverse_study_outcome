package com.bytedanceos.appstore;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import java.io.File;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class d extends RequestBuilder implements Cloneable {
    public d(Class r10, RequestBuilder r11) {
        super(r10, r11);
    }

    public d A(Uri r10) {
        return (d) super.load(r10);
    }

    public d B(File r10) {
        return (d) super.load(r10);
    }

    public d C(Integer r10) {
        return (d) super.load(r10);
    }

    public d D(Object r10) {
        return (d) super.load(r10);
    }

    public d E(String r10) {
        return (d) super.load(r10);
    }

    public d F(URL r10) {
        return (d) super.load(r10);
    }

    public d G(byte[] r10) {
        return (d) super.load(r10);
    }

    public d H(boolean r10) {
        return (d) super.onlyRetrieveFromCache(r10);
    }

    public d I() {
        return (d) super.optionalCenterCrop();
    }

    public d J() {
        return (d) super.optionalCenterInside();
    }

    public d K() {
        return (d) super.optionalCircleCrop();
    }

    public d L() {
        return (d) super.optionalFitCenter();
    }

    public d M(Transformation r10) {
        return (d) super.optionalTransform(r10);
    }

    public d N(Class r10, Transformation r11) {
        return (d) super.optionalTransform(r10, r11);
    }

    public d O(int r10) {
        return (d) super.override(r10);
    }

    public d P(int r10, int r11) {
        return (d) super.override(r10, r11);
    }

    public d Q(int r10) {
        return (d) super.placeholder(r10);
    }

    public d R(Drawable r10) {
        return (d) super.placeholder(r10);
    }

    public d S(Priority r10) {
        return (d) super.priority(r10);
    }

    public d T(Option r10, Object r11) {
        return (d) super.set(r10, r11);
    }

    public d U(Key r10) {
        return (d) super.signature(r10);
    }

    public d V(float r10) {
        return (d) super.sizeMultiplier(r10);
    }

    public d W(boolean r10) {
        return (d) super.skipMemoryCache(r10);
    }

    public d X(Resources.Theme r10) {
        return (d) super.theme(r10);
    }

    public d Y(float r10) {
        return (d) super.thumbnail(r10);
    }

    public d Z(RequestBuilder r10) {
        return (d) super.thumbnail(r10);
    }

    public d a(RequestListener r10) {
        return (d) super.addListener(r10);
    }

    public final d a0(RequestBuilder... r10) {
        return (d) super.thumbnail(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public /* bridge */ /* synthetic */ RequestBuilder addListener(RequestListener r10) {
        return a(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ RequestBuilder apply(BaseRequestOptions r10) {
        return b(r10);
    }

    public d b(BaseRequestOptions r10) {
        return (d) super.apply(r10);
    }

    public d b0(int r10) {
        return (d) super.timeout(r10);
    }

    public d c() {
        return (d) super.centerCrop();
    }

    public d c0(Transformation r10) {
        return (d) super.transform(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions centerCrop() {
        return c();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions centerInside() {
        return d();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions circleCrop() {
        return e();
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ RequestBuilder clone() {
        return f();
    }

    public d d() {
        return (d) super.centerInside();
    }

    public d d0(Class r10, Transformation r11) {
        return (d) super.transform(r10, r11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions decode(Class r10) {
        return g(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions disallowHardwareConfig() {
        return h();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions diskCacheStrategy(DiskCacheStrategy r10) {
        return i(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions dontAnimate() {
        return j();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions dontTransform() {
        return k();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions downsample(DownsampleStrategy r10) {
        return l(r10);
    }

    public d e() {
        return (d) super.circleCrop();
    }

    public d e0(Transformation... r10) {
        return (d) super.transform(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions encodeFormat(Bitmap.CompressFormat r10) {
        return m(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions encodeQuality(int r10) {
        return n(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public /* bridge */ /* synthetic */ RequestBuilder error(RequestBuilder r10) {
        return q(r10);
    }

    public d f() {
        return (d) super.clone();
    }

    public d f0(Transformation... r10) {
        return (d) super.transforms(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions fallback(int r10) {
        return r(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions fitCenter() {
        return t();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions format(DecodeFormat r10) {
        return u(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions frame(long r10) {
        return v(r10);
    }

    public d g(Class r10) {
        return (d) super.decode(r10);
    }

    public d g0(TransitionOptions r10) {
        return (d) super.transition(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public /* bridge */ /* synthetic */ RequestBuilder getDownloadOnlyRequest() {
        return w();
    }

    public d h() {
        return (d) super.disallowHardwareConfig();
    }

    public d h0(boolean r10) {
        return (d) super.useAnimationPool(r10);
    }

    public d i(DiskCacheStrategy r10) {
        return (d) super.diskCacheStrategy(r10);
    }

    public d i0(boolean r10) {
        return (d) super.useUnlimitedSourceGeneratorsPool(r10);
    }

    public d j() {
        return (d) super.dontAnimate();
    }

    public d k() {
        return (d) super.dontTransform();
    }

    public d l(DownsampleStrategy r10) {
        return (d) super.downsample(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public /* bridge */ /* synthetic */ RequestBuilder listener(RequestListener r10) {
        return x(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder load(Bitmap r10) {
        return y(r10);
    }

    public d m(Bitmap.CompressFormat r10) {
        return (d) super.encodeFormat(r10);
    }

    public d n(int r10) {
        return (d) super.encodeQuality(r10);
    }

    public d o(int r10) {
        return (d) super.error(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions onlyRetrieveFromCache(boolean r10) {
        return H(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions optionalCenterCrop() {
        return I();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions optionalCenterInside() {
        return J();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions optionalCircleCrop() {
        return K();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions optionalFitCenter() {
        return L();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions optionalTransform(Transformation r10) {
        return M(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions override(int r10) {
        return O(r10);
    }

    public d p(Drawable r10) {
        return (d) super.error(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions placeholder(int r10) {
        return Q(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions priority(Priority r10) {
        return S(r10);
    }

    public d q(RequestBuilder r10) {
        return (d) super.error(r10);
    }

    public d r(int r10) {
        return (d) super.fallback(r10);
    }

    public d s(Drawable r10) {
        return (d) super.fallback(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions set(Option r10, Object r11) {
        return T(r10, r11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions signature(Key r10) {
        return U(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions sizeMultiplier(float r10) {
        return V(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions skipMemoryCache(boolean r10) {
        return W(r10);
    }

    public d t() {
        return (d) super.fitCenter();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions theme(Resources.Theme r10) {
        return X(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public /* bridge */ /* synthetic */ RequestBuilder thumbnail(float r10) {
        return Y(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions timeout(int r10) {
        return b0(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions transform(Transformation r10) {
        return c0(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions transforms(Transformation[] r10) {
        return f0(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public /* bridge */ /* synthetic */ RequestBuilder transition(TransitionOptions r10) {
        return g0(r10);
    }

    public d u(DecodeFormat r10) {
        return (d) super.format(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions useAnimationPool(boolean r10) {
        return h0(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions useUnlimitedSourceGeneratorsPool(boolean r10) {
        return i0(r10);
    }

    public d v(long r10) {
        return (d) super.frame(r10);
    }

    public d w() {
        return new d(File.class, this).b(RequestBuilder.DOWNLOAD_ONLY_OPTIONS);
    }

    public d x(RequestListener r10) {
        return (d) super.listener(r10);
    }

    public d y(Bitmap r10) {
        return (d) super.load(r10);
    }

    public d z(Drawable r10) {
        return (d) super.load(r10);
    }

    public d(Glide r10, RequestManager r11, Class r12, Context r13) {
        super(r10, r11, r12, r13);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions apply(BaseRequestOptions r10) {
        return b(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions clone() {
        return f();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions error(int r10) {
        return o(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions fallback(Drawable r10) {
        return s(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder load(Drawable r10) {
        return z(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions optionalTransform(Class r10, Transformation r11) {
        return N(r10, r11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions override(int r10, int r11) {
        return P(r10, r11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions placeholder(Drawable r10) {
        return R(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public /* bridge */ /* synthetic */ RequestBuilder thumbnail(RequestBuilder r10) {
        return Z(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions transform(Class r10, Transformation r11) {
        return d0(r10, r11);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.request.BaseRequestOptions
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo5clone() {
        return f();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions error(Drawable r10) {
        return p(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder load(Uri r10) {
        return A(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public /* bridge */ /* synthetic */ RequestBuilder thumbnail(RequestBuilder[] r10) {
        return a0(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions transform(Transformation[] r10) {
        return e0(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder load(File r10) {
        return B(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder load(Integer r10) {
        return C(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder load(Object r10) {
        return D(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder load(String r10) {
        return E(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder load(URL r10) {
        return F(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder load(byte[] r10) {
        return G(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ Object load(Bitmap r10) {
        return y(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ Object load(Drawable r10) {
        return z(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ Object load(Uri r10) {
        return A(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ Object load(File r10) {
        return B(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ Object load(Integer r10) {
        return C(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ Object load(Object r10) {
        return D(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ Object load(String r10) {
        return E(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ Object load(URL r10) {
        return F(r10);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ Object load(byte[] r10) {
        return G(r10);
    }
}
