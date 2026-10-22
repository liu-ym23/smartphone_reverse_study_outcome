package com.stepos.ailauncher.chat.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.autonavi.aps.amapapi.config.Const;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.zyql.ai.selector.R;
import com.zyql.ai.selector.engine.ImageEngine;
import com.zyql.ai.selector.listener.OnImageCompleteCallback;
import com.zyql.ai.selector.tools.MediaUtils;
import com.zyql.ai.selector.widget.longimage.ImageSource;
import com.zyql.ai.selector.widget.longimage.ImageViewState;
import com.zyql.ai.selector.widget.longimage.SubsamplingScaleImageView;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ?\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u000b\u0010\u0011J5\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000b\u0010\u0012J-\u0010\u0013\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\fJ-\u0010\u0014\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\fJ-\u0010\u0015\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/chat/util/a;", "Lcom/zyql/ai/selector/engine/ImageEngine;", "<init>", "()V", "Landroid/content/Context;", "context", "", "url", "Landroid/widget/ImageView;", "imageView", "LY8/t;", "loadImage", "(Landroid/content/Context;Ljava/lang/String;Landroid/widget/ImageView;)V", "Lcom/zyql/ai/selector/widget/longimage/SubsamplingScaleImageView;", "longImageView", "Lcom/zyql/ai/selector/listener/OnImageCompleteCallback;", "callback", "(Landroid/content/Context;Ljava/lang/String;Landroid/widget/ImageView;Lcom/zyql/ai/selector/widget/longimage/SubsamplingScaleImageView;Lcom/zyql/ai/selector/listener/OnImageCompleteCallback;)V", "(Landroid/content/Context;Ljava/lang/String;Landroid/widget/ImageView;Lcom/zyql/ai/selector/widget/longimage/SubsamplingScaleImageView;)V", "loadFolderImage", "loadAsGifImage", "loadGridImage", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a implements ImageEngine {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile a instance;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/chat/util/a$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/util/a;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/chat/util/a;", "instance", "Lcom/stepos/ailauncher/chat/util/a;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.util.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final a a() {
            a aVar;
            a aVar2 = a.instance;
            if (aVar2 != null) {
                return aVar2;
            }
            synchronized (this) {
                aVar = a.instance;
                if (aVar == null) {
                    aVar = new a(null);
                    a.instance = aVar;
                }
            }
            return aVar;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/util/a$b", "Lcom/bumptech/glide/request/target/BitmapImageViewTarget;", "Landroid/graphics/Bitmap;", "resource", "LY8/t;", "setResource", "(Landroid/graphics/Bitmap;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends BitmapImageViewTarget {
        final /* synthetic */ Context $context;
        final /* synthetic */ ImageView $imageView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ImageView imageView, Context context) {
            super(imageView);
            this.$imageView = imageView;
            this.$context = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.request.target.BitmapImageViewTarget, com.bumptech.glide.request.target.ImageViewTarget
        public void setResource(Bitmap resource) {
            if (resource != null) {
                u0.c cVarA = u0.d.a(this.$context.getResources(), resource);
                kotlin.jvm.internal.p.h(cVarA, "create(...)");
                cVarA.e(8.0f);
                this.$imageView.setImageDrawable(cVarA);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/stepos/ailauncher/chat/util/a$c", "Lcom/bumptech/glide/request/target/ImageViewTarget;", "Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", "placeholder", "LY8/t;", "onLoadStarted", "(Landroid/graphics/drawable/Drawable;)V", "errorDrawable", "onLoadFailed", "resource", "setResource", "(Landroid/graphics/Bitmap;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends ImageViewTarget<Bitmap> {
        final /* synthetic */ OnImageCompleteCallback $callback;
        final /* synthetic */ ImageView $imageView;
        final /* synthetic */ SubsamplingScaleImageView $longImageView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ImageView imageView, OnImageCompleteCallback onImageCompleteCallback, SubsamplingScaleImageView subsamplingScaleImageView) {
            super(imageView);
            this.$imageView = imageView;
            this.$callback = onImageCompleteCallback;
            this.$longImageView = subsamplingScaleImageView;
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable errorDrawable) {
            super.onLoadFailed(errorDrawable);
            OnImageCompleteCallback onImageCompleteCallback = this.$callback;
            if (onImageCompleteCallback != null) {
                onImageCompleteCallback.onHideLoading();
            }
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public void onLoadStarted(Drawable placeholder) {
            super.onLoadStarted(placeholder);
            OnImageCompleteCallback onImageCompleteCallback = this.$callback;
            if (onImageCompleteCallback != null) {
                onImageCompleteCallback.onShowLoading();
            }
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget
        public void setResource(Bitmap resource) {
            OnImageCompleteCallback onImageCompleteCallback = this.$callback;
            if (onImageCompleteCallback != null) {
                onImageCompleteCallback.onHideLoading();
            }
            if (resource != null) {
                boolean zIsLongImg = MediaUtils.isLongImg(resource.getWidth(), resource.getHeight());
                this.$longImageView.setVisibility(zIsLongImg ? 0 : 8);
                this.$imageView.setVisibility(zIsLongImg ? 8 : 0);
                if (!zIsLongImg) {
                    this.$imageView.setImageBitmap(resource);
                    return;
                }
                this.$longImageView.setQuickScaleEnabled(true);
                this.$longImageView.setZoomEnabled(true);
                this.$longImageView.setDoubleTapZoomDuration(100);
                this.$longImageView.setMinimumScaleType(2);
                this.$longImageView.setDoubleTapZoomDpi(2);
                this.$longImageView.setImage(ImageSource.cachedBitmap(resource), new ImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/util/a$d", "Lcom/bumptech/glide/request/target/ImageViewTarget;", "Landroid/graphics/Bitmap;", "resource", "LY8/t;", "setResource", "(Landroid/graphics/Bitmap;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends ImageViewTarget<Bitmap> {
        final /* synthetic */ ImageView $imageView;
        final /* synthetic */ SubsamplingScaleImageView $longImageView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView) {
            super(imageView);
            this.$imageView = imageView;
            this.$longImageView = subsamplingScaleImageView;
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget
        public void setResource(Bitmap resource) {
            if (resource != null) {
                boolean zIsLongImg = MediaUtils.isLongImg(resource.getWidth(), resource.getHeight());
                this.$longImageView.setVisibility(zIsLongImg ? 0 : 8);
                this.$imageView.setVisibility(zIsLongImg ? 8 : 0);
                if (!zIsLongImg) {
                    this.$imageView.setImageBitmap(resource);
                    return;
                }
                this.$longImageView.setQuickScaleEnabled(true);
                this.$longImageView.setZoomEnabled(true);
                this.$longImageView.setDoubleTapZoomDuration(100);
                this.$longImageView.setMinimumScaleType(2);
                this.$longImageView.setDoubleTapZoomDpi(2);
                this.$longImageView.setImage(ImageSource.cachedBitmap(resource), new ImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
            }
        }
    }

    public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
        this();
    }

    @Override // com.zyql.ai.selector.engine.ImageEngine
    public void loadAsGifImage(Context context, String url, ImageView imageView) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(url, "url");
        kotlin.jvm.internal.p.i(imageView, "imageView");
        Glide.with(context).asGif().load(url).into(imageView);
    }

    @Override // com.zyql.ai.selector.engine.ImageEngine
    public void loadFolderImage(Context context, String url, ImageView imageView) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(url, "url");
        kotlin.jvm.internal.p.i(imageView, "imageView");
        Glide.with(context).asBitmap().load(url).override(180, 180).centerCrop().sizeMultiplier(0.5f).placeholder(R.drawable.picture_image_placeholder).into((RequestBuilder) new b(imageView, context));
    }

    @Override // com.zyql.ai.selector.engine.ImageEngine
    public void loadGridImage(Context context, String url, ImageView imageView) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(url, "url");
        kotlin.jvm.internal.p.i(imageView, "imageView");
        Glide.with(context).load(url).override(200, 200).centerCrop().placeholder(R.drawable.picture_image_placeholder).into(imageView);
    }

    @Override // com.zyql.ai.selector.engine.ImageEngine
    public void loadImage(Context context, String url, ImageView imageView) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(url, "url");
        kotlin.jvm.internal.p.i(imageView, "imageView");
        Glide.with(context).load(url).into(imageView);
    }

    public a() {
    }

    @Override // com.zyql.ai.selector.engine.ImageEngine
    public void loadImage(Context context, String url, ImageView imageView, SubsamplingScaleImageView longImageView, OnImageCompleteCallback callback) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(url, "url");
        kotlin.jvm.internal.p.i(imageView, "imageView");
        kotlin.jvm.internal.p.i(longImageView, "longImageView");
        Glide.with(context).asBitmap().load(url).into((RequestBuilder<Bitmap>) new c(imageView, callback, longImageView));
    }

    @Override // com.zyql.ai.selector.engine.ImageEngine
    public void loadImage(Context context, String url, ImageView imageView, SubsamplingScaleImageView longImageView) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(url, "url");
        kotlin.jvm.internal.p.i(imageView, "imageView");
        kotlin.jvm.internal.p.i(longImageView, "longImageView");
        Glide.with(context).asBitmap().load(url).into((RequestBuilder<Bitmap>) new d(imageView, longImageView));
    }
}
