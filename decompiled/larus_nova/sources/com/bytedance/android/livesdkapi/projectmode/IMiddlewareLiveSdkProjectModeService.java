package com.bytedance.android.livesdkapi.projectmode;

import android.app.Activity;
import com.bytedance.android.live.base.IService;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.Retrofit;
import kotlin.Metadata;
import vlc.b;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\b\u001a\u00020\u0004H&J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\b\u0010\f\u001a\u00020\u0004H&J(\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH&¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/projectmode/IMiddlewareLiveSdkProjectModeService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/retrofit2/Retrofit$Builder;", "builder", "", "addLocalTestInterceptor", "Lvlc/b;", "getMsgInterceptor", "initWarlock", "Landroid/app/Activity;", "activity", "showLiveDebugDialog", "initTestTool", "", "logId", "path", "request", ContainerPosition.BODY, "consumeRevNetWork", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMiddlewareLiveSdkProjectModeService extends IService {
    void addLocalTestInterceptor(Retrofit.Builder r100);

    void consumeRevNetWork(String r100, String r101, String r102, String r103);

    b getMsgInterceptor();

    void initTestTool();

    void initWarlock();

    void showLiveDebugDialog(Activity r100);
}
