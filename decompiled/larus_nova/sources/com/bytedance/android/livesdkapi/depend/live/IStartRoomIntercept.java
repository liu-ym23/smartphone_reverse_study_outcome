package com.bytedance.android.livesdkapi.depend.live;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public interface IStartRoomIntercept {
    void bindContext(Context r100);

    boolean intercept(Map<String, String> r100);
}
