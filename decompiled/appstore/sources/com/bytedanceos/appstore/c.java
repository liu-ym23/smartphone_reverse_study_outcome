package com.bytedanceos.appstore;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends RequestOptions implements Cloneable {
    public c() {
    }

    public c A() {
        return (c) super.optionalFitCenter();
    }

    public c B(Transformation r10) {
        return (c) super.optionalTransform(r10);
    }

    public c C(Class r10, Transformation r11) {
        return (c) super.optionalTransform(r10, r11);
    }

    public c D(int r10) {
        return (c) super.override(r10);
    }

    public c E(int r10, int r11) {
        return (c) super.override(r10, r11);
    }

    public c F(int r10) {
        return (c) super.placeholder(r10);
    }

    public c G(Drawable r10) {
        return (c) super.placeholder(r10);
    }

    public c H(Priority r10) {
        return (c) super.priority(r10);
    }

    public c I(Option r10, Object r11) {
        return (c) super.set(r10, r11);
    }

    public c J(Key r10) {
        return (c) super.signature(r10);
    }

    public c K(float r10) {
        return (c) super.sizeMultiplier(r10);
    }

    public c L(boolean r10) {
        return (c) super.skipMemoryCache(r10);
    }

    public c M(Resources.Theme r10) {
        return (c) super.theme(r10);
    }

    public c N(int r10) {
        return (c) super.timeout(r10);
    }

    public c O(Transformation r10) {
        return (c) super.transform(r10);
    }

    public c P(Class r10, Transformation r11) {
        return (c) super.transform(r10, r11);
    }

    public final c Q(Transformation... r10) {
        return (c) super.transform(r10);
    }

    public final c R(Transformation... r10) {
        return (c) super.transforms(r10);
    }

    public c S(boolean r10) {
        return (c) super.useAnimationPool(r10);
    }

    public c T(boolean r10) {
        return (c) super.useUnlimitedSourceGeneratorsPool(r10);
    }

    public c a(BaseRequestOptions r10) {
        return (c) super.apply(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions apply(BaseRequestOptions r10) {
        return a(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions autoClone() {
        return b();
    }

    public c b() {
        return (c) super.autoClone();
    }

    public c c() {
        return (c) super.centerCrop();
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

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions clone() {
        return f();
    }

    public c d() {
        return (c) super.centerInside();
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

    public c e() {
        return (c) super.circleCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions encodeFormat(Bitmap.CompressFormat r10) {
        return m(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions encodeQuality(int r10) {
        return n(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions error(int r10) {
        return o(r10);
    }

    public c f() {
        return (c) super.clone();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions fallback(int r10) {
        return q(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions fitCenter() {
        return s();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions format(DecodeFormat r10) {
        return t(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions frame(long r10) {
        return u(r10);
    }

    public c g(Class r10) {
        return (c) super.decode(r10);
    }

    public c h() {
        return (c) super.disallowHardwareConfig();
    }

    public c i(DiskCacheStrategy r10) {
        return (c) super.diskCacheStrategy(r10);
    }

    public c j() {
        return (c) super.dontAnimate();
    }

    public c k() {
        return (c) super.dontTransform();
    }

    public c l(DownsampleStrategy r10) {
        return (c) super.downsample(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions lock() {
        return v();
    }

    public c m(Bitmap.CompressFormat r10) {
        return (c) super.encodeFormat(r10);
    }

    public c n(int r10) {
        return (c) super.encodeQuality(r10);
    }

    public c o(int r10) {
        return (c) super.error(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions onlyRetrieveFromCache(boolean r10) {
        return w(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions optionalCenterCrop() {
        return x();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions optionalCenterInside() {
        return y();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions optionalCircleCrop() {
        return z();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions optionalFitCenter() {
        return A();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions optionalTransform(Transformation r10) {
        return B(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions override(int r10) {
        return D(r10);
    }

    public c p(Drawable r10) {
        return (c) super.error(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions placeholder(int r10) {
        return F(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions priority(Priority r10) {
        return H(r10);
    }

    public c q(int r10) {
        return (c) super.fallback(r10);
    }

    public c r(Drawable r10) {
        return (c) super.fallback(r10);
    }

    public c s() {
        return (c) super.fitCenter();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions set(Option r10, Object r11) {
        return I(r10, r11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions signature(Key r10) {
        return J(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions sizeMultiplier(float r10) {
        return K(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions skipMemoryCache(boolean r10) {
        return L(r10);
    }

    public c t(DecodeFormat r10) {
        return (c) super.format(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions theme(Resources.Theme r10) {
        return M(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions timeout(int r10) {
        return N(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions transform(Transformation r10) {
        return O(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions transforms(Transformation[] r10) {
        return R(r10);
    }

    public c u(long r10) {
        return (c) super.frame(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions useAnimationPool(boolean r10) {
        return S(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions useUnlimitedSourceGeneratorsPool(boolean r10) {
        return T(r10);
    }

    public c v() {
        return (c) super.lock();
    }

    public c w(boolean r10) {
        return (c) super.onlyRetrieveFromCache(r10);
    }

    public c x() {
        return (c) super.optionalCenterCrop();
    }

    public c y() {
        return (c) super.optionalCenterInside();
    }

    public c z() {
        return (c) super.optionalCircleCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo5clone() {
        return f();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions error(Drawable r10) {
        return p(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions fallback(Drawable r10) {
        return r(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions optionalTransform(Class r10, Transformation r11) {
        return C(r10, r11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions override(int r10, int r11) {
        return E(r10, r11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions placeholder(Drawable r10) {
        return G(r10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions transform(Class r10, Transformation r11) {
        return P(r10, r11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions transform(Transformation[] r10) {
        return Q(r10);
    }
}
