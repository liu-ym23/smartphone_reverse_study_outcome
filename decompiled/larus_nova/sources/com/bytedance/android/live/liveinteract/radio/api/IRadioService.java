package com.bytedance.android.live.liveinteract.radio.api;

import android.os.Bundle;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import kotlin.Metadata;
import yh0.a;
import yh0.b;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/radio/api/IRadioService;", "Lcom/bytedance/android/live/base/IService;", "Lyh0/b;", "createRadioWidget", "", "getRadioWidgetXmlRes", "Lyh0/a;", "createRadioBundleInserter", "Landroid/os/Bundle;", "bundle", "", "canConvert2VoiceLiveTheme", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "voiceLiveTheme", "convertVoiceLT2Bundle", "multilink-radio-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRadioService extends IService {
    boolean canConvert2VoiceLiveTheme(Bundle r100);

    Bundle convertVoiceLT2Bundle(IVoiceLiveTheme r100);

    a createRadioBundleInserter();

    b createRadioWidget();

    int getRadioWidgetXmlRes();
}
