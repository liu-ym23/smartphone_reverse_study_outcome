package com.stepos.agentframework.chatui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.stepos.agentframework.uikit.R$drawable;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a?\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n\u001a!\u0010\f\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\u00020\u000b2\b\u0010\u0002\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\f\u0010\r\u001a!\u0010\u000e\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\u00020\u000b2\b\u0010\u0002\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u000e\u0010\r\"\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/stepos/agentframework/chatui/view/g;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "", "maxWidth", "maxHeight", "", "cornerRadius", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatui/view/g;Ljava/lang/Object;IIF)V", "Landroid/widget/ImageView;", Const.INTENT_KEY_UMID, "(Landroid/widget/ImageView;Ljava/lang/Object;)V", "c", "SENT_SINGLE_IMAGE_MAX_DP", "F", "agentcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.view.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2076h {
    private static final float SENT_SINGLE_IMAGE_MAX_DP = 360.0f;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [T] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.bumptech.glide.RequestManager] */
    public static final <T> void a(C2074g c2074g, T t10, int i10, int i11, float f10) {
        String strA;
        kotlin.jvm.internal.p.i(c2074g, "<this>");
        c2074g.g(i10, i11);
        String str = t10 instanceof String ? (String) t10 : null;
        if (str != null && (strA = O6.j.a(str)) != null) {
            t10 = (T) strA;
        }
        RequestBuilder<Drawable> requestBuilderLoad = Glide.with(c2074g.getContext()).load(t10);
        RequestOptions requestOptionsEncodeQuality = new RequestOptions().transform(new FitCenter(), new RoundedCorners((int) f10)).encodeQuality(85);
        int i12 = R$drawable.agent_image_erro_placeholder;
        requestBuilderLoad.apply((BaseRequestOptions<?>) requestOptionsEncodeQuality.error(i12).placeholder(i12)).into(c2074g);
    }

    public static /* synthetic */ void b(C2074g c2074g, Object obj, int i10, int i11, float f10, int i12, Object obj2) {
        if ((i12 & 2) != 0) {
            i10 = 150;
        }
        if ((i12 & 4) != 0) {
            i11 = 150;
        }
        if ((i12 & 8) != 0) {
            f10 = 10.0f;
        }
        a(c2074g, obj, i10, i11, f10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.bumptech.glide.RequestManager] */
    /* JADX WARN: Type inference failed for: r8v0, types: [T] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v4 */
    public static final <T> void c(ImageView imageView, T t10) {
        String strA;
        kotlin.jvm.internal.p.i(imageView, "<this>");
        String str = t10 instanceof String ? (String) t10 : null;
        if (str != null && (strA = O6.j.a(str)) != null) {
            t10 = (T) strA;
        }
        RequestBuilder<Drawable> requestBuilderLoad = Glide.with(imageView.getContext()).load(t10);
        RequestOptions requestOptions = new RequestOptions();
        CenterCrop centerCrop = new CenterCrop();
        O6.d dVar = O6.d.INSTANCE;
        Context context = imageView.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        RequestOptions requestOptionsTransform = requestOptions.transform(centerCrop, new RoundedCorners(dVar.a(context, 11.0f)));
        Context context2 = imageView.getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        RequestOptions requestOptionsEncodeQuality = requestOptionsTransform.override(dVar.a(context2, 110.0f)).encodeQuality(85);
        int i10 = R$drawable.agent_image_erro_placeholder;
        requestBuilderLoad.apply((BaseRequestOptions<?>) requestOptionsEncodeQuality.error(i10).placeholder(i10)).into(imageView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.bumptech.glide.RequestManager] */
    /* JADX WARN: Type inference failed for: r7v0, types: [T] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v4 */
    public static final <T> void d(ImageView imageView, T t10) {
        String strA;
        kotlin.jvm.internal.p.i(imageView, "<this>");
        String str = t10 instanceof String ? (String) t10 : null;
        if (str != null && (strA = O6.j.a(str)) != null) {
            t10 = (T) strA;
        }
        O6.d dVar = O6.d.INSTANCE;
        Context context = imageView.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        int iA = dVar.a(context, SENT_SINGLE_IMAGE_MAX_DP);
        RequestBuilder<Drawable> requestBuilderLoad = Glide.with(imageView.getContext()).load(t10);
        RequestOptions requestOptionsOverride = new RequestOptions().override(iA, iA);
        FitCenter fitCenter = new FitCenter();
        Context context2 = imageView.getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        requestBuilderLoad.apply((BaseRequestOptions<?>) requestOptionsOverride.transform(fitCenter, new RoundedCorners(dVar.a(context2, 12.0f))).encodeQuality(85).error(R$drawable.agent_image_erro_placeholder)).into(imageView);
    }
}
