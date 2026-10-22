package com.bytedanceos.appstore.buss.utilities;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.FutureTarget;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.utilities.ImageUtilKt$getBitmapByUrl$2", f = "ImageUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ImageUtilKt$getBitmapByUrl$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ ImageView $this_getBitmapByUrl;
    final /* synthetic */ Object $url;
    int label;

    public ImageUtilKt$getBitmapByUrl$2(ImageView r10, Object r11, Continuation<? super ImageUtilKt$getBitmapByUrl$2> r12) {
        this.$this_getBitmapByUrl = r10;
        this.$url = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new ImageUtilKt$getBitmapByUrl$2(this.$this_getBitmapByUrl, this.$url, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Bitmap> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L11;
        kotlin.c.b(r10);
        RequestBuilder<Bitmap> r11 = Glide.with(this.$this_getBitmapByUrl.getContext()).asBitmap();
        Object r12 = this.$url;
        if (r12 == null) goto L7;
        Object r13 = com.bytedanceos.common.toolbox.glide.a.a(r12);
    L8:
        FutureTarget<Bitmap> r14 = r11.load(r13).submit(this.$this_getBitmapByUrl.getWidth(), this.$this_getBitmapByUrl.getHeight());
        kotlin.jvm.internal.q.f(r14, "submit(...)");
        return r14.get();
    L7:
        r13 = null;
        goto L8
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Bitmap> r11) {
        return ((ImageUtilKt$getBitmapByUrl$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
