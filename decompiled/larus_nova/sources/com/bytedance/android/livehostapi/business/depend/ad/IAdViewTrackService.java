package com.bytedance.android.livehostapi.business.depend.ad;

import android.view.View;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public interface IAdViewTrackService {
    void bind(String r100, View r101);

    void pause(String r100);

    void pausePlay(String r100);

    void resume(String r100);

    void startPlay(String r100);

    JSONObject unbind(String r100);
}
