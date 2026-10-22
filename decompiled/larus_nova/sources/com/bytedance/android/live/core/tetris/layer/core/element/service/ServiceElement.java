package com.bytedance.android.live.core.tetris.layer.core.element.service;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.ss.android.lark.utils.statistics.PerfLog;
import h70.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/element/service/ServiceElement;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/live/core/tetris/layer/core/element/Element;", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ServiceElement<T> extends Element<T> {
    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final View c(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    public abstract void l();

    public ServiceElement(b r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        super(r100);
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final void onViewCreated(View r100) {
        l();
    }
}
