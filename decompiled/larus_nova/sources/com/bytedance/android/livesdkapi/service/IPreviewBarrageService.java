package com.bytedance.android.livesdkapi.service;

import android.content.Context;
import com.bytedance.android.livesdkapi.barrage.ChangeSettingSource;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IPreviewBarrageService;", "", "isDanmakuOpen", "", "openDanmakuSettingDialog", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "Lcom/bytedance/android/livesdkapi/service/OpenParams;", "switchDanmaKu", "open", "source", "Lcom/bytedance/android/livesdkapi/barrage/ChangeSettingSource;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPreviewBarrageService {
    boolean isDanmakuOpen();

    void openDanmakuSettingDialog(Context r100, OpenParams r101);

    void switchDanmaKu(boolean r100, ChangeSettingSource r101);
}
