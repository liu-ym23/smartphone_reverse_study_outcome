package com.bytedance.android.livesdk.interactivity.api;

import android.app.Application;
import android.os.SystemClock;
import com.bytedance.android.livehostapi.foundation.depend.PluginType;
import com.bytedance.android.livesdk.interactivity.asr.widget.AnchorAsrHintWidget;
import com.bytedance.android.livesdk.interactivity.asr.widget.AnchorAsrServiceWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H\u0016J\u0010\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/AnchorAsrService;", "Lcom/bytedance/android/livesdk/interactivity/api/IAnchorAsrService;", "()V", "getAnchorAsrHintWidget", "Ljava/lang/Class;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "getAnchorAsrServiceWidget", "loadPlugin", "", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AnchorAsrService implements IAnchorAsrService {
    public AnchorAsrService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAnchorAsrService
    public void loadPlugin() {
        boolean r100 = com.bytedance.android.livesdk.interactivity.asr.c.f133831a;
        if (com.bytedance.android.livesdk.interactivity.api.asr.utils.a.a() == true) goto L5;
        return;
    L5:
        if (com.bytedance.android.livesdk.interactivity.asr.c.f133832b == true) goto L17;
        PluginType r101 = PluginType.AsrSo;
        if (r101.isInstalled() == false) goto L10;
        com.bytedance.android.livesdk.interactivity.asr.c.c();
        com.bytedance.android.livesdk.interactivity.asr.c.b();
        return;
    L10:
        Application r102 = jc1.a.b();
        if (r102 == null) goto L18;
        long r103 = SystemClock.elapsedRealtime();
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("start install asr plugin");
        r101.checkInstall(r102, "", new com.bytedance.android.livesdk.interactivity.asr.b(r103), false);
        return;
    L18:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAnchorAsrService
    public Class<? extends Widget> getAnchorAsrHintWidget() {
        return AnchorAsrHintWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAnchorAsrService
    public Class<? extends Widget> getAnchorAsrServiceWidget() {
        return AnchorAsrServiceWidget.class;
    }
}
