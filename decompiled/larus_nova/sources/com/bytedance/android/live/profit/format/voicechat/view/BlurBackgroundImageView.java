package com.bytedance.android.live.profit.format.voicechat.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/view/BlurBackgroundImageView;", "Landroid/widget/ImageView;", "", "radius", "", "setBlurRadius", "resId", "setBlurBackgroundRes", "Landroid/graphics/Bitmap;", SimplayerImageStrategy.RESULT_BITMAP, "setBlurBackground", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BlurBackgroundImageView extends ImageView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f87701c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f87702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f87703b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BlurBackgroundImageView f87704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bitmap f87705b;

        /* JADX INFO: renamed from: com.bytedance.android.live.profit.format.voicechat.view.BlurBackgroundImageView$a$a, reason: collision with other inner class name */
        public static final class C1336a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f87706a;

            public C1336a(a r100) {
                this.f87706a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                BlurBackgroundImageView r101 = this.f87706a.f87704a;
                int r102 = BlurBackgroundImageView.f87701c;
                r101.setBackground((Drawable) r100);
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f87707a = null;

            static {
                f87707a = new b();
            }

            public b() {
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                ((Throwable) r100).getMessage();
            }
        }

        public a(BlurBackgroundImageView r100, Bitmap r101) {
            this.f87704a = r100;
            this.f87705b = r101;
        }

        public final void a() {
            Disposable r100 = this.f87704a.f87703b;
            if (r100 == null) goto L5;
            r100.dispose();
        L5:
            BlurBackgroundImageView r101 = this.f87704a;
            Bitmap r102 = this.f87705b;
            r101.getClass();
            Observable r103 = Observable.create(new com.bytedance.android.live.profit.format.voicechat.view.a(r101, r102));
            if (r103 == null) goto L12;
            Observable r104 = r103.subscribeOn(Schedulers.io());
            if (r104 == null) goto L12;
            Observable r105 = r104.observeOn(AndroidSchedulers.mainThread());
            if (r105 == null) goto L12;
            Disposable r106 = r105.subscribe(new C1336a(this), b.f87707a);
        L13:
            r101.f87703b = r106;
            return;
        L12:
            r106 = null;
            goto L13
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public BlurBackgroundImageView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BlurBackgroundImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r100 = this.f87703b;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f87703b = null;
    }

    public final void setBlurBackground(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        post(new a(this, r100));
    }

    public final void setBlurBackgroundRes(int r100) {
        setBlurBackground(BitmapFactory.decodeResource(getResources(), r100));
    }

    public final void setBlurRadius(int r100) {
        this.f87702a = r100;
    }

    public BlurBackgroundImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f87702a = 10;
    }

    public /* synthetic */ BlurBackgroundImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
