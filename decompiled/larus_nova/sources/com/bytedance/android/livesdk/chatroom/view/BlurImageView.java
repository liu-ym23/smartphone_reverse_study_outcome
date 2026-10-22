package com.bytedance.android.livesdk.chatroom.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/view/BlurImageView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/graphics/Bitmap;", SimplayerImageStrategy.RESULT_BITMAP, "", "setBlurBackground", "Landroid/graphics/drawable/Drawable;", "background", "setBackground", "", "radius", "setBlurRadius", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BlurImageView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f114688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f114689b;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BlurImageView f114690a;

        public a(BlurImageView r100) {
            this.f114690a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            BlurImageView r101 = this.f114690a;
            BlurImageView.R5(r101, (Drawable) r100);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f114691a = null;

        static {
            f114691a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ALogger.i("BlurImageView", String.valueOf(((Throwable) r100).getMessage()));
        }
    }

    public BlurImageView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BlurImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r100 = this.f114689b;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f114689b = null;
    }

    private final void setBlurBackground(Bitmap r100) {
        Disposable r101 = this.f114689b;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        Observable r102 = Observable.create(new com.bytedance.android.livesdk.chatroom.view.a(this, r100));
        if (r102 == null) goto L12;
        Observable r103 = r102.subscribeOn(Schedulers.io());
        if (r103 == null) goto L12;
        Observable r104 = r103.observeOn(AndroidSchedulers.mainThread());
        if (r104 == null) goto L12;
        Disposable r105 = r104.subscribe(new a(this), b.f114691a);
    L13:
        this.f114689b = r105;
        return;
    L12:
        r105 = null;
        goto L13
    }

    @Override // android.view.View
    public void setBackground(Drawable r100) {
        if ((r100 instanceof BitmapDrawable) == true) goto L5;
        Drawable r101 = null;
    L6:
        BitmapDrawable r102 = (BitmapDrawable) r101;
        if (r102 == null) goto L12;
        Bitmap r103 = r102.getBitmap();
        if (r103 == null) goto L12;
        setBlurBackground(r103);
        return;
    L12:
        super.setBackground(r100);
        return;
    L5:
        r101 = r100;
        goto L6
    }

    public final void setBlurRadius(int r100) {
        this.f114688a = r100;
    }

    public final void setBackground(Bitmap r100) {
        if (r100 == null) goto L5;
        setBlurBackground(r100);
        return;
    }

    public static final /* synthetic */ void R5(BlurImageView r100, Drawable r101) {
        super.setBackground(r101);
    }

    public BlurImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ttlive_blur_radius}, r102, 0);
        this.f114688a = r103.getDimensionPixelSize(0, 0);
        r103.recycle();
        Drawable r104 = getBackground();
        if ((r104 instanceof BitmapDrawable) == true) goto L5;
        r104 = null;
    L5:
        BitmapDrawable r105 = (BitmapDrawable) r104;
        if (r105 == null) goto L11;
        Bitmap r106 = r105.getBitmap();
        if (r106 == null) goto L12;
        setBlurBackground(r106);
        return;
    L12:
        return;
    }

    public /* synthetic */ BlurImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
