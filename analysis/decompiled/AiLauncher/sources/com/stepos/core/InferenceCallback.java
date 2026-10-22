package com.stepos.core;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.core.callback.InferResult;
import com.stepos.core.data.base.Content;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0000*\u00020\u00012\u00020\u0003J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/core/InferenceCallback;", "Lcom/stepos/core/data/base/Content;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "inferId", "Lcom/stepos/core/callback/InferResult;", "result", "LY8/t;", "onNext", "(Ljava/lang/String;Lcom/stepos/core/callback/InferResult;)V", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface InferenceCallback<T extends Content> {
    void onNext(String inferId, InferResult<? extends T> result);
}
