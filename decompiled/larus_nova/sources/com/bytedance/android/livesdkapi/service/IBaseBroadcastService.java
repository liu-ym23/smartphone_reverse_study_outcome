package com.bytedance.android.livesdkapi.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.IStartLiveInterceptor;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.ArrayList;
import kotlin.Metadata;
import nz.e;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&JB\u0010\u0019\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u001a\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u00172\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&JB\u0010\u001a\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u001a\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u00172\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH&J\u0018\u0010#\u001a\u00020\b2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0004H&J\u0010\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$H&J\u0010\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u001dH&J\u0012\u0010)\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IBaseBroadcastService;", "Lcom/bytedance/android/live/base/IService;", "Landroid/app/Activity;", "activity", "", "config", "Lnz/e;", "callback", "", "startContinueBroadcastActivity", "startMultiProcessContinueBroadcastActivity", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "showRestartBroadcastConfirmDialog", "certId", "Landroid/content/Intent;", "intent", "injectRouteOutCertIdToIntent", "Landroidx/fragment/app/FragmentActivity;", "Lcom/bytedance/android/livesdkapi/config/FastStartLiveConfig;", "fastStartLiveConfig", "Ljava/util/ArrayList;", "Lcom/bytedance/android/livesdkapi/IStartLiveInterceptor;", "Lkotlin/collections/ArrayList;", "extraInterceptors", "fastStartLive", "fastStartLiveForSchema", "", "result", "", ShortVideoSegments.KEY_CAMERA_ID, "cameraDirtyDetect", "", "fromPush", "from", "enterStableModel", "Landroid/os/Bundle;", "outBundle", "onSaveInstanceState", "type", "onInnerPushViewClick", "restoreVideoRecordActivity", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IBaseBroadcastService extends IService {
    void cameraDirtyDetect(float r100, int r101);

    void enterStableModel(boolean r100, String r101);

    void fastStartLive(FragmentActivity r100, FastStartLiveConfig r101, ArrayList<IStartLiveInterceptor> r102, e r103);

    void fastStartLiveForSchema(Context r100, FastStartLiveConfig r101, ArrayList<IStartLiveInterceptor> r102, e r103);

    void injectRouteOutCertIdToIntent(String r100, Intent r101);

    void onInnerPushViewClick(int r100);

    void onSaveInstanceState(Bundle r100);

    void restoreVideoRecordActivity(Context r100);

    void showRestartBroadcastConfirmDialog(Context r100);

    void startContinueBroadcastActivity(Activity r100, String r101, e r102);

    void startMultiProcessContinueBroadcastActivity(Activity r100, String r101);
}
