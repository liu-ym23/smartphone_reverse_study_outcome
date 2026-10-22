package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.browser.jsbridge.base.OpenGalleryResultModel;
import com.bytedance.android.livesdk.widget.FullScreenImageViewDialog;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openGallery")
public final class t8 extends w20.k4<w20.jc, OpenGalleryResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FullScreenImageViewDialog f63678a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        FullScreenImageViewDialog r100 = this.f63678a;
        if (r100 != null) goto L5;
        return;
    L5:
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r100);
    L20:
        this.f63678a = null;
        return;
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r102 == null) goto L19;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        goto L19
    L8:
        if (Looper.myLooper() == r101.getLooper()) goto L10;
        r101.post(DialogLancet.createDismissRunnable(r100));
        goto L20
    }

    public t8() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) throws Exception {
        w20.jc r102 = (w20.jc) r100;
        List<String> r103 = r102.a();
        Integer r104 = r102.b();
        if (r104 != null) goto L5;
        r101.getContext();
        IllegalArgumentException r105 = new IllegalArgumentException();
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_preview_image_load_failed, 0);
        finishWithFailure(r105);
        return;
    L5:
        int r106 = r104.intValue();
        if (r106 < r103.size()) goto L8;
        r101.getContext();
        IndexOutOfBoundsException r107 = new IndexOutOfBoundsException();
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_preview_image_load_failed, 0);
        finishWithFailure(r107);
        return;
    L8:
        String r108 = (String) ListProtector.get(r103, r106);
        final FullScreenImageViewDialog r109 = new FullScreenImageViewDialog(r101.getContext());
        this.f63678a = r109;
        s8 r110 = new s8(this);
        ImageRequest r111 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r108)).build();
        final DataSource<CloseableReference<CloseableImage>> r112 = ImagePipelineFactory.getInstance().getImagePipeline().fetchDecodedImage(r111, r109.getContext());
        r112.subscribe(new com.bytedance.android.livesdk.widget.x(r109, r110), UiThreadImmediateExecutorService.getInstance());
        r109.setOnDismissListener(new com.bytedance.android.livesdk.widget.v(r109, r112));
        FullScreenImageViewDialog r113 = this.f63678a;
        if (DialogLancet.shouldBlockDialogShow(r113) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(r113);
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L12:
        DialogLancet.beforeDialogShow(r113);
        r113.show();
        DialogLancet.afterDialogShow(r113);
    }
}
