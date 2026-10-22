package com.bytedance.android.live.liveinteract.radio.impl;

import android.os.Bundle;
import com.bytedance.android.live.liveinteract.radio.api.IRadioService;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yh0.a;
import zh0.b;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/liveinteract/radio/impl/RadioService;", "Lcom/bytedance/android/live/liveinteract/radio/api/IRadioService;", "Lyh0/b;", "createRadioWidget", "", "getRadioWidgetXmlRes", "Lyh0/a;", "createRadioBundleInserter", "Landroid/os/Bundle;", "bundle", "", "canConvert2VoiceLiveTheme", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "voiceLiveTheme", "convertVoiceLT2Bundle", "<init>", "()V", "multilink-radio-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class RadioService implements IRadioService {
    public RadioService() {
    }

    @Override // com.bytedance.android.live.liveinteract.radio.api.IRadioService
    public int getRadioWidgetXmlRes() {
        return R.layout.ttlive_view_live_radio;
    }

    @Override // com.bytedance.android.live.liveinteract.radio.api.IRadioService
    public a createRadioBundleInserter() {
        return new b();
    }

    @Override // com.bytedance.android.live.liveinteract.radio.api.IRadioService
    public yh0.b createRadioWidget() {
        return new RadioWidget();
    }

    @Override // com.bytedance.android.live.liveinteract.radio.api.IRadioService
    public boolean canConvert2VoiceLiveTheme(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        return zh0.a.a(r100);
    }

    @Override // com.bytedance.android.live.liveinteract.radio.api.IRadioService
    public Bundle convertVoiceLT2Bundle(IVoiceLiveTheme r100) {
        Intrinsics.checkNotNullParameter(r100, "voiceLiveTheme");
        return zh0.a.c(r100);
    }
}
