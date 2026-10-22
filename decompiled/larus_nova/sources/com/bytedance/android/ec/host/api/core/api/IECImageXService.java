package com.bytedance.android.ec.host.api.core.api;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
import pi.c;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\u008f\u0001\u0010\u001a\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2$\b\u0002\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u000fj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001`\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0017H&¢\u0006\u0004\b\u001a\u0010\u001bJR\u0010#\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010 2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u001a\u0010\u001f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u001e\u0018\u00010\u001dH&J4\u0010)\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\"0!2\b\u0010'\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0005H&J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\tH&Jp\u00100\u001a\u00020\u00122\u0006\u0010%\u001a\u00020$2\u0012\b\u0002\u0010/\u001a\f\u0012\u0006\b\u0000\u0012\u00020.\u0018\u00010-2\u0006\u0010\u001c\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u000fj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001`\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\tH&J\u008e\u0001\u00100\u001a\u00020\u00122\u0006\u0010%\u001a\u00020$2\u0012\b\u0002\u0010/\u001a\f\u0012\u0006\b\u0000\u0012\u00020.\u0018\u00010-2\u0006\u0010\u001c\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u000fj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001`\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\u001c\b\u0002\u0010\u001f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u001e\u0018\u00010\u001dH&J©\u0001\u00103\u001a\u00020\u00122\u0006\u0010%\u001a\u00020$2\u0012\b\u0002\u0010/\u001a\f\u0012\u0006\b\u0000\u0012\u00020.\u0018\u00010-2\u0006\u0010\u001c\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u00101\u001a\u0004\u0018\u00010\u00172\b\u00102\u001a\u0004\u0018\u00010\u00172\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u000fj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001`\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\u001c\b\u0002\u0010\u001f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u001e\u0018\u00010\u001dH&¢\u0006\u0004\b3\u00104J]\u0010:\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00172\b\u00106\u001a\u0004\u0018\u0001052\u0016\u00109\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u000108\u0012\u0004\u0012\u00020\u0007\u0018\u000107H&¢\u0006\u0004\b:\u0010;J \u0010<\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH&J\u001a\u0010=\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH&J\n\u0010>\u001a\u0004\u0018\u00010\u0001H&J\u0012\u0010A\u001a\u00020\u00072\b\u0010@\u001a\u0004\u0018\u00010?H&J\b\u0010B\u001a\u00020\u0007H&J\u0010\u0010D\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0012H&J\b\u0010F\u001a\u00020EH&¨\u0006G"}, d2 = {"Lcom/bytedance/android/ec/host/api/core/api/IECImageXService;", "", "Lorg/json/JSONObject;", "configRule", "data", "Lcom/bytedance/android/ec/host/api/core/api/ImagePreloadConfig;", "extras", "", "preloadImages", "", "imageUrl", "Lcom/facebook/imagepipeline/common/Priority;", "priority", "bizTag", "sceneTag", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "monitor", "", "prefetchToMemoryCache", "specifiedDiskCache", "Lcom/facebook/imagepipeline/listener/BaseRequestListener;", "requestListener", "", "resizeWidth", "resizeHeight", "preloadImage", "(Ljava/lang/String;Lcom/facebook/imagepipeline/common/Priority;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;ZLjava/lang/String;Lcom/facebook/imagepipeline/listener/BaseRequestListener;Ljava/lang/Integer;Ljava/lang/Integer;)V", "url", "Lkotlin/Function0;", "", "monitorInjector", "Lkotlin/Pair;", "", "Lcom/facebook/imagepipeline/request/ImageRequest;", "prepareImageRequest", "Lcom/facebook/drawee/view/GenericDraweeView;", "draweeView", "imageRequests", "lowResImageRequest", "callerContext", "bindImageByRequest", "config", "savePreloadConfig", "urlPreConnect", "Lcom/facebook/drawee/controller/ControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "controllerListener", "bindByImageX", "width", "height", "bindImageXWithSize", "(Lcom/facebook/drawee/view/GenericDraweeView;Lcom/facebook/drawee/controller/ControllerListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/HashMap;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Z", "Lcom/facebook/imagepipeline/request/Postprocessor;", "postprocessor", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "consumer", "downloadByImageX", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/facebook/imagepipeline/request/Postprocessor;Lkotlin/jvm/functions/Function1;)Z", "transformImageUrl", "provideImageCallerContext", "provideSlcImageHook", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "saveFirstScreenImageSet", "initFirstScreenImageRecord", "fromCache", "recordFirstScreenEnd", "Lpi/c;", "providerNetImagePreloader", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECImageXService {
    boolean bindByImageX(GenericDraweeView r100, ControllerListener<? super ImageInfo> r101, String r102, String r103, String r104, HashMap<String, Object> r105, String r106);

    boolean bindByImageX(GenericDraweeView r100, ControllerListener<? super ImageInfo> r101, String r102, String r103, String r104, HashMap<String, Object> r105, String r106, Function0<? extends Map<String, ? extends Object>> r107);

    void bindImageByRequest(GenericDraweeView r100, List<? extends ImageRequest> r101, ImageRequest r102, Object r103);

    boolean bindImageXWithSize(GenericDraweeView r100, ControllerListener<? super ImageInfo> r101, String r102, String r103, String r104, Integer r105, Integer r106, HashMap<String, Object> r107, String r108, Function0<? extends Map<String, ? extends Object>> r110);

    boolean downloadByImageX(String r100, String r101, String r102, Integer r103, Integer r104, Postprocessor r105, Function1<? super Bitmap, Unit> r106);

    void initFirstScreenImageRecord();

    void preloadImage(String r100, Priority r101, String r102, String r103, HashMap<String, Object> r104, boolean r105, String r106, BaseRequestListener r107, Integer r108, Integer r110);

    void preloadImages(JSONObject r100, JSONObject r101, ImagePreloadConfig r102);

    Pair<List<ImageRequest>, Object> prepareImageRequest(String r100, String r101, String r102, Function0<? extends Map<String, ? extends Object>> r103);

    Object provideImageCallerContext(String r100, String r101);

    Object provideSlcImageHook();

    c providerNetImagePreloader();

    void recordFirstScreenEnd(boolean r100);

    void saveFirstScreenImageSet(Context r100);

    void savePreloadConfig(ImagePreloadConfig r100);

    String transformImageUrl(String r100, String r101, String r102);

    void urlPreConnect(String r100);
}
