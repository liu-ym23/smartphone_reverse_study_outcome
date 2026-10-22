package com.bytedance.android.format.host.api;

import android.app.Activity;
import android.content.Context;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import pr.e;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001:\u0001#J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H&J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H&J8\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u001bH&J\b\u0010\u001e\u001a\u00020\u0011H&J\b\u0010\u001f\u001a\u00020\tH&R\u0014\u0010\"\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/bytedance/android/format/host/api/IHostApp;", "", "Landroid/app/Activity;", "getCurrentActivity", "", "isPIPMode", "isCalling", "", "getAppId", "", "getDeviceId", "getVersionName", "getVersionCode", "Landroid/content/Context;", "getApplicationContext", "Lpr/e;", "params", "", "triggerHostAnimation", "Lcom/bytedance/android/format/host/api/IHostApp$a;", "listener", "registerHostAppMuteListener", "unregisterHostAppMuteListener", "activity", "id", "type", "extraStr", "Lkotlin/Function0;", "jumpFinish", "shootSameJumpFinish", "clearFormatLiveEffect", "getEffectSdkVersionByFormatLive", "getHostAppMuted", "()Z", "hostAppMuted", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHostApp {

    public interface a {
    }

    void clearFormatLiveEffect();

    int getAppId();

    Context getApplicationContext();

    Activity getCurrentActivity();

    String getDeviceId();

    String getEffectSdkVersionByFormatLive();

    boolean getHostAppMuted();

    String getVersionCode();

    String getVersionName();

    boolean isCalling();

    boolean isPIPMode();

    void registerHostAppMuteListener(a r100);

    void shootSameJumpFinish(Activity r100, String r101, String r102, String r103, Function0<Unit> r104);

    void triggerHostAnimation(e r100);

    void unregisterHostAppMuteListener(a r100);
}
