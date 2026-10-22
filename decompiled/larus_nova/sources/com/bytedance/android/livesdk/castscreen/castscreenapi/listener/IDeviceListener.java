package com.bytedance.android.livesdk.castscreen.castscreenapi.listener;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import java.util.List;
import kotlin.Metadata;
import lf1.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/castscreenapi/listener/IDeviceListener;", "", "", "Llf1/a;", "devices", "", LynxVideoManagerLite.EVENT_ON_DEVICE_CHANGE, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IDeviceListener {
    void onDeviceChange(List<? extends a> r100);
}
