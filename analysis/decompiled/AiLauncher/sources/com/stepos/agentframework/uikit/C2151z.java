package com.stepos.agentframework.uikit;

import I8.a;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.stepos.agentframework.uikit.L;
import h8.C4148a;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.stepos.agentframework.uikit.z, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2151z extends io.noties.markwon.image.b {
    private static final int QR_SIZE_DP = 200;
    private static final String TAG = "GlideAsyncLoader";
    private final Map<io.noties.markwon.image.a, Target<?>> cache = new HashMap(2);
    private androidx.collection.l drawableCache = new androidx.collection.l(20);
    private final a.b glideStore;

    /* renamed from: com.stepos.agentframework.uikit.z$a */
    public class a extends CustomTarget<Drawable> {
        private final io.noties.markwon.image.a drawable;

        public a(io.noties.markwon.image.a aVar) {
            this.drawable = aVar;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
            boolean z10 = C2151z.this.cache.remove(this.drawable) != null;
            boolean zK = this.drawable.k();
            C4148a.b(C2151z.TAG, "onResourceReady: " + this.drawable.b() + " inCache=" + z10 + " attached=" + zK);
            b(this.drawable.b(), drawable);
            if (z10 && zK) {
                io.noties.markwon.image.f.a(drawable);
                this.drawable.p(drawable);
                C2151z.this.drawableCache.put(this.drawable.b(), drawable);
                C4148a.b(C2151z.TAG, "onResourceReady: setResult OK " + this.drawable.b());
            }
        }

        public final void b(String str, Drawable drawable) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                Rect bounds = drawable.getBounds();
                int iWidth = bounds.width();
                intrinsicHeight = bounds.height();
                intrinsicWidth = iWidth;
            }
            L.c(str, intrinsicWidth, intrinsicHeight);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
            C4148a.b(C2151z.TAG, "onLoadCleared: " + this.drawable.b() + " attached=" + this.drawable.k());
            if (this.drawable.k()) {
                this.drawable.a();
            }
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
            boolean z10 = C2151z.this.cache.remove(this.drawable) != null;
            boolean zK = this.drawable.k();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onLoadFailed: ");
            sb2.append(this.drawable.b());
            sb2.append(" inCache=");
            sb2.append(z10);
            sb2.append(" attached=");
            sb2.append(zK);
            sb2.append(" hasError=");
            sb2.append(drawable != null);
            C4148a.b(C2151z.TAG, sb2.toString());
            if (z10 && drawable != null && zK) {
                io.noties.markwon.image.f.a(drawable);
                this.drawable.p(drawable);
            }
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public void onLoadStarted(Drawable drawable) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onLoadStarted: ");
            sb2.append(this.drawable.b());
            sb2.append(" attached=");
            sb2.append(this.drawable.k());
            sb2.append(" hasPlaceholder=");
            sb2.append(drawable != null);
            sb2.append(" keepReservedSize=true");
            C4148a.b(C2151z.TAG, sb2.toString());
        }
    }

    public C2151z(a.b bVar) {
        this.glideStore = bVar;
    }

    @Override // io.noties.markwon.image.b
    public void a(io.noties.markwon.image.a aVar) {
        C4148a.b(TAG, "cancel: " + aVar.b() + " attached=" + aVar.k());
        Target<?> targetRemove = this.cache.remove(aVar);
        if (targetRemove != null) {
            this.glideStore.a(targetRemove);
        }
    }

    @Override // io.noties.markwon.image.b
    public void b(io.noties.markwon.image.a aVar) {
        C4148a.b(TAG, "load: " + aVar.b() + " attached=" + aVar.k());
        if (j0.INSTANCE.e(aVar.b()) && g(aVar)) {
            return;
        }
        a aVar2 = new a(aVar);
        this.cache.put(aVar, aVar2);
        this.glideStore.b(aVar).into((RequestBuilder<Drawable>) aVar2);
    }

    @Override // io.noties.markwon.image.b
    public Drawable d(io.noties.markwon.image.a aVar) {
        Drawable drawable = (Drawable) this.drawableCache.get(aVar.b());
        if (drawable != null) {
            C4148a.b(TAG, "placeholder: " + aVar.b() + " hit=bitmap");
            return drawable;
        }
        L.Size sizeB = L.b(aVar.b());
        if (sizeB == null) {
            C4148a.b(TAG, "placeholder: " + aVar.b() + " hit=miss");
            return null;
        }
        C4148a.b(TAG, "placeholder: " + aVar.b() + " hit=size " + sizeB.getWidth() + "x" + sizeB.getHeight());
        return new K(sizeB.getWidth(), sizeB.getHeight());
    }

    public final boolean g(io.noties.markwon.image.a aVar) throws UnsupportedEncodingException {
        String strB = aVar.b();
        Drawable drawable = (Drawable) this.drawableCache.get(strB);
        if (drawable == null) {
            j0 j0Var = j0.INSTANCE;
            String strB2 = j0Var.b(strB);
            Resources system = Resources.getSystem();
            Bitmap bitmapC = j0Var.c(strB2, (int) (system.getDisplayMetrics().density * 200.0f));
            if (bitmapC == null) {
                C4148a.q(TAG, "loadLocalQr: encode failed " + strB);
                return false;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(system, bitmapC);
            this.drawableCache.put(strB, bitmapDrawable);
            drawable = bitmapDrawable;
        }
        if (aVar.k()) {
            io.noties.markwon.image.f.a(drawable);
            aVar.p(drawable);
        }
        C4148a.b(TAG, "loadLocalQr: setResult OK " + strB);
        return true;
    }
}
