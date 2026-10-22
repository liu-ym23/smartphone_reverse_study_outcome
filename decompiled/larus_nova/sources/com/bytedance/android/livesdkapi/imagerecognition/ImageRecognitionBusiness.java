package com.bytedance.android.livesdkapi.imagerecognition;

import android.content.Context;
import com.bytedance.android.livesdkapi.depend.model.live.imagerecognition.StreamRecognitionResponse;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J8\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH&J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/imagerecognition/ImageRecognitionBusiness;", "", "getScaleConfig", "Lcom/bytedance/android/livesdkapi/imagerecognition/ScaleConfig;", "onInjectExtra", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "entry", "Lcom/bytedance/android/livesdkapi/imagerecognition/ImageRecognitionEntry;", "res", "Lcom/bytedance/android/livesdkapi/depend/model/live/imagerecognition/StreamRecognitionResponse;", "extra", "", "", "provide", "Lcom/bytedance/android/livesdkapi/imagerecognition/ImageRecognitionButton;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ImageRecognitionBusiness {
    ScaleConfig getScaleConfig();

    void onInjectExtra(Context r100, ImageRecognitionEntry r101, StreamRecognitionResponse r102, Map<String, Object> r103);

    ImageRecognitionButton provide(ImageRecognitionEntry r100);
}
