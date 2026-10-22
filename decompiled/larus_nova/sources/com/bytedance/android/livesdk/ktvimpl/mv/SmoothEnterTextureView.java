package com.bytedance.android.livesdk.ktvimpl.mv;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.TextureView;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011R2\u0010\u000b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/mv/SmoothEnterTextureView;", "Landroid/view/TextureView;", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/jvm/functions/Function1;", "getBgInfock", "()Lkotlin/jvm/functions/Function1;", "setBgInfock", "(Lkotlin/jvm/functions/Function1;)V", "bgInfock", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SmoothEnterTextureView extends TextureView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Drawable, Unit> f146036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f146037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f146038c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SmoothEnterTextureView f146039a;

        public a(SmoothEnterTextureView r100) {
            this.f146039a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function1<Drawable, Unit> r100 = this.f146039a.getBgInfock();     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            Unit r101 = r100.invoke(null);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f146037b.postDelayed(this.f146038c, 300);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        Bitmap r100 = getBitmap();     // Catch: Throwable -> L8
        if (r100 == null) goto L10;
        BitmapDrawable r101 = new BitmapDrawable(getContext().getResources(), r100);     // Catch: Throwable -> L8
        this.f146037b.removeCallbacks(this.f146038c);     // Catch: Throwable -> L8
        Function1<? super Drawable, Unit> r102 = this.f146036a;     // Catch: Throwable -> L8
        if (r102 == null) goto L10;
        Unit r103 = r102.invoke(r101);     // Catch: Throwable -> L8
    L10:
        super.onDetachedFromWindow();
        return;
    L8:
        th = move-exception;
        ALogger.i("SmoothEnterTextureView", "getBitMap error" + th.getMessage());
        goto L10
    }

    public final Function1<Drawable, Unit> getBgInfock() {
        return this.f146036a;
    }

    public final void setBgInfock(Function1<? super Drawable, Unit> r100) {
        this.f146036a = r100;
    }

    public SmoothEnterTextureView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f146037b = new Handler(Looper.getMainLooper());
        this.f146038c = new a(this);
    }
}
