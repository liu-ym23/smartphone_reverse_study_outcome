package com.stepos.ailauncher.taskstore.widget;

import android.util.Log;
import android.widget.ImageView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.imageloader.ImageDataSource;
import com.stepos.ailauncher.common.imageloader.ImageRequest;
import com.stepos.ailauncher.taskstore.R$id;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001aI\u0010\r\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000e\"\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\"\u0014\u0010\u0012\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013\",\u0010\u0019\u001a\u0004\u0018\u00010\u0005*\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u00058B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Landroid/widget/ImageView;", "imageView", "LY8/t;", "f", "(Landroid/widget/ImageView;)V", "", "url", "Lcom/stepos/ailauncher/taskstore/widget/HalftoneShaderView;", "shaderBackdrop", "fileId", "Lkotlin/Function1;", "", "onFinished", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/widget/ImageView;Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/widget/HalftoneShaderView;Ljava/lang/String;Lp9/l;)V", "", "RESULT_CROSSFADE_MS", "I", "TAG", "Ljava/lang/String;", UxipConstants.f30680s, Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/widget/ImageView;)Ljava/lang/String;", "k", "(Landroid/widget/ImageView;Ljava/lang/String;)V", "boundResultUrl", "taskstore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class w0 {
    private static final int RESULT_CROSSFADE_MS = 220;
    private static final String TAG = "TextToImageCardView";

    public static final void f(ImageView imageView) {
        com.stepos.ailauncher.common.imageloader.g.INSTANCE.l(imageView);
        k(imageView, null);
    }

    public static final String g(ImageView imageView) {
        Object tag = imageView.getTag(R$id.taskstore_tti_bound_image_url);
        if (tag instanceof String) {
            return (String) tag;
        }
        return null;
    }

    public static final void h(final ImageView imageView, final String str, final HalftoneShaderView halftoneShaderView, final String str2, final InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
        if (imageView.getDrawable() != null && kotlin.jvm.internal.p.d(g(imageView), str)) {
            halftoneShaderView.u();
            interfaceC5074l.invoke(Boolean.TRUE);
            return;
        }
        k(imageView, str);
        if (imageView.getDrawable() != null) {
            com.stepos.ailauncher.common.imageloader.g.s(com.stepos.ailauncher.common.imageloader.g.INSTANCE, imageView, new ImageRequest(str, 0, 0, null, null, 0, 0, 0, 0, false, null, true, false, false, false, null, 0.0f, false, 260094, null), null, new com.stepos.ailauncher.common.imageloader.b() { // from class: com.stepos.ailauncher.taskstore.widget.u0
                @Override // com.stepos.ailauncher.common.imageloader.b
                public final void a(boolean z10, ImageDataSource imageDataSource) {
                    w0.i(imageView, str, str2, interfaceC5074l, z10, imageDataSource);
                }
            }, null, 20, null);
            halftoneShaderView.u();
        } else {
            halftoneShaderView.t();
            com.stepos.ailauncher.common.imageloader.g.s(com.stepos.ailauncher.common.imageloader.g.INSTANCE, imageView, new ImageRequest(str, 0, 0, null, null, 0, 0, 0, 0, false, Integer.valueOf(RESULT_CROSSFADE_MS), false, false, false, false, null, 0.0f, false, 261118, null), null, new com.stepos.ailauncher.common.imageloader.b() { // from class: com.stepos.ailauncher.taskstore.widget.v0
                @Override // com.stepos.ailauncher.common.imageloader.b
                public final void a(boolean z10, ImageDataSource imageDataSource) {
                    w0.j(imageView, str, str2, halftoneShaderView, interfaceC5074l, z10, imageDataSource);
                }
            }, null, 20, null);
        }
    }

    public static final void i(ImageView imageView, String str, String str2, InterfaceC5074l interfaceC5074l, boolean z10, ImageDataSource imageDataSource) {
        kotlin.jvm.internal.p.i(imageDataSource, "<unused var>");
        if (kotlin.jvm.internal.p.d(g(imageView), str)) {
            if (!z10) {
                Log.e(TAG, "reload result image failed fileId=" + str2);
            }
            interfaceC5074l.invoke(Boolean.valueOf(z10));
        }
    }

    public static final void j(ImageView imageView, String str, String str2, HalftoneShaderView halftoneShaderView, InterfaceC5074l interfaceC5074l, boolean z10, ImageDataSource source) {
        kotlin.jvm.internal.p.i(source, "source");
        if (z10) {
            halftoneShaderView.v(source == ImageDataSource.MEMORY_CACHE ? 0L : 220L);
            interfaceC5074l.invoke(Boolean.TRUE);
        } else if (kotlin.jvm.internal.p.d(g(imageView), str)) {
            Log.e(TAG, "load result image failed fileId=" + str2);
            halftoneShaderView.u();
            interfaceC5074l.invoke(Boolean.FALSE);
            k(imageView, null);
        }
    }

    public static final void k(ImageView imageView, String str) {
        imageView.setTag(R$id.taskstore_tti_bound_image_url, str);
    }
}
