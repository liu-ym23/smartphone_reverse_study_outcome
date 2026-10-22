package com.bytedance.android.ecom.arch.slice.render.widget.fresco;

import android.graphics.drawable.Drawable;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.DefaultDrawableFactory;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements DeferredReleaser.Releasable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AsyncDeferredReleaser f50942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Executor f50943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public BaseControllerListener<ImageInfo> f50944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public SettableDraweeHierarchy f50945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f50946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f50947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f50948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f50949h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public DataSource<CloseableReference<CloseableImage>> f50950i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public CloseableReference<CloseableImage> f50951j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public Drawable f50952k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f50953l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public ImageRequest f50954m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public e f50955n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final DrawableFactory f50956o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Supplier<DataSource<CloseableReference<CloseableImage>>> f50957p;

    public static class a extends d<ImageInfo> {
        public a() {
        }
    }

    public final BaseControllerListener<ImageInfo> b() {
        BaseControllerListener<ImageInfo> r100 = this.f50944c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new BaseControllerListener();
    }

    public final void f() {
        boolean r100 = this.f50949h;
        this.f50949h = false;
        final DataSource<CloseableReference<CloseableImage>> r101 = this.f50950i;
        this.f50950i = null;
        com.bytedance.android.ecom.arch.slice.render.util.h.c(new f(this, r101));
        if (r100 == false) goto L6;
        b().onRelease(this.f50946e);
        return;
    }

    public final String toString() {
        Objects.ToStringHelper r100 = Objects.toStringHelper(this).add("isAttached", this.f50948g).add("isRequestSubmitted", this.f50949h);
        CloseableReference<CloseableImage> r101 = this.f50951j;
        if (r101 == null) goto L5;
        int r102 = r101.getValueHash();
    L7:
        return r100.add("fetchedImage", r102).add("dataSourceSupplier", this.f50957p).toString();
    L5:
        r102 = 0;
        goto L7
    }

    @Override // com.facebook.drawee.components.DeferredReleaser.Releasable
    public final void release() {
        f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(BaseControllerListener<? super ImageInfo> r100) {
        boolean r101 = nq.a.f520084a;
        if (r100 == 0) goto L5;
        boolean r102 = true;
    L6:
        nq.a.d(r102, null, null);
        BaseControllerListener<ImageInfo> r103 = this.f50944c;
        if ((r103 instanceof a) == false) goto L16;
        a r104 = (a) r103;
        monitor-enter(r104);
        ((ArrayList) r104.f50935a).add(r100);     // Catch: Throwable -> L13
        monitor-exit(r104);
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        if (r103 == null) goto L19;
        a r105 = new a();
        r105.addListener(r103);
        r105.addListener(r100);
        this.f50944c = r105;
        return;
    L19:
        this.f50944c = r100;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void g(@Nullable DraweeHierarchy r100) {
        if (this.f50949h == false) goto L6;
        this.f50942a.cancelDeferredRelease(this);
        f();
    L6:
        if (this.f50945d == null) goto L8;
        this.f50945d = null;
    L8:
        if (r100 != null) goto L10;
        return;
    L10:
        if ((r100 instanceof SettableDraweeHierarchy) == false) goto L12;
        this.f50945d = (SettableDraweeHierarchy) r100;
        return;
    L12:
        this.f50945d = null;
        nq.a.b(null, null);
    }

    public final synchronized void c(String r100, Object r101) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.f50953l == true) goto L8;
        AsyncDeferredReleaser r102 = this.f50942a;     // Catch: Throwable -> L15
        if (r102 == null) goto L8;
        r102.cancelDeferredRelease(this);     // Catch: Throwable -> L15
    L8:
        this.f50948g = false;     // Catch: Throwable -> L15
        f();     // Catch: Throwable -> L15
        BaseControllerListener<ImageInfo> r103 = this.f50944c;     // Catch: Throwable -> L15
        if ((r103 instanceof a) == false) goto L11;
        ((a) r103).clearListeners();     // Catch: Throwable -> L15
    L12:
        this.f50945d = null;     // Catch: Throwable -> L15
        this.f50946e = r100;     // Catch: Throwable -> L15
        this.f50947f = r101;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L11:
        this.f50944c = null;     // Catch: Throwable -> L15
        goto L12
    }

    public final boolean d(String r100, DataSource<CloseableReference<CloseableImage>> r101) {
        e r102 = this.f50955n;
        if (r102 != null) goto L5;
        Boolean r103 = Boolean.TRUE;
    L10:
        if (r103.booleanValue() == false) goto L12;
        return false;
    L12:
        DataSource<CloseableReference<CloseableImage>> r104 = this.f50950i;
        if (r101 != null) goto L17;
        if (r104 != null) goto L17;
        return true;
    L17:
        if (r100.equals(this.f50946e) == false) goto L23;
        if (r101 == r104) goto L20;
        return false;
    L20:
        if (this.f50949h == false) goto L25;
        return true;
    L25:
        return false;
    L23:
        return false;
    L5:
        nq.a.a();
        if (r102.f50936a == false) goto L8;
        r103 = Boolean.TRUE;
        goto L10
    L8:
        r103 = Boolean.FALSE;
        goto L10
    }

    public h(AsyncDeferredReleaser r100, DefaultDrawableFactory r101, UiThreadImmediateExecutorService r102) {
        this.f50953l = true;
        this.f50942a = r100;
        this.f50943b = r102;
        c(null, null);
        this.f50956o = r101;
    }

    public final void e(String r100, DataSource<CloseableReference<CloseableImage>> r101, Throwable r102, boolean r103) {
        if (d(r100, r101) == true) goto L6;
        r101.close();
        return;
    L6:
        if (r103 == false) goto L8;
        this.f50950i = null;
        b().onFailure(this.f50946e, r102);
        return;
    L8:
        b().onIntermediateImageFailed(this.f50946e, r102);
    }
}
