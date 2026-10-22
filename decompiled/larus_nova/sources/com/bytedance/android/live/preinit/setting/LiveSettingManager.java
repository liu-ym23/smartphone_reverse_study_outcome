package com.bytedance.android.live.preinit.setting;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.LiveGsonHelper;
import com.bytedance.android.live.base.sp.TTOpenLiveSettingUtil;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import com.bytedance.android.livesdk.config.LiveInitSettingKeysForSaas;
import com.bytedance.android.livesdkapi.util.LiveSDKConstUtil;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ms0.c;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0003J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010J$\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/preinit/setting/LiveSettingManager;", "", "()V", "ASYNC_SETTING", "", "SETTING_CALLBACK", "Lkotlin/Function1;", "", "", "getSETTING_CALLBACK", "()Lkotlin/jvm/functions/Function1;", "setSETTING_CALLBACK", "(Lkotlin/jvm/functions/Function1;)V", "SETTING_PATH", "getSettingsTasksInIoThread", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "syncLiveSDKSettings", "callback", "livehostadapter_release"}, k = 1, mv = {1, 4, 3})
public final class LiveSettingManager {
    public static final String ASYNC_SETTING = "enable_async_settings";
    public static final LiveSettingManager INSTANCE = null;
    private static Function1<? super Boolean, Unit> SETTING_CALLBACK = null;
    public static final String SETTING_PATH = "/webcast/openapi/setting/";

    public static final class a<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f85886a = null;

        static {
            f85886a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<JsonObject> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            IHostNetwork r101 = (IHostNetwork) k.f(IHostNetwork.class);
            String r102 = null;
            if (r101 == null) goto L5;
            String r103 = r101.getHostDomain();
        L7:
            if (TextUtils.isEmpty(r103) == true) goto L35;
            UrlBuilder r104 = new UrlBuilder("https://" + r103 + LiveSettingManager.SETTING_PATH);
            IHostContext r105 = (IHostContext) k.f(IHostContext.class);
            boolean r106 = false;
            if (r105 == null) goto L11;
            int r107 = r105.appId();
        L12:
            r104.addParam("webcast_app_id", r107);
            String r108 = LiveSDKConstUtil.getSdkVersion();
            if (r108.length() <= 0) goto L15;
            boolean r109 = true;
        L16:
            if (r109 == true) goto L19;
            r108 = null;
        L19:
            if (r108 == null) goto L37;
            r104.addParam("webcast_sdk_version", r108);
        L37:
            String r110 = NetworkClient.getDefault().get(r104.build());     // Catch: Exception -> L31
            if (r110.length() <= 0) goto L24;
            r106 = true;
        L24:
            if (r106 == false) goto L26;
            r102 = r110;
        L26:
            if (r102 == null) goto L35;
            LiveInitSettingKeysForSaas.canReadPerformanceSettings = true;     // Catch: Exception -> L31
            JsonObject r111 = ((ms0.a) LiveGsonHelper.get().fromJson(r102, ms0.a.class)).a();     // Catch: Exception -> L31
            if (r111 == null) goto L35;
            r100.onNext(r111);     // Catch: Exception -> L31
        L31:
            e = move-exception;
            ALogger.e("ttlive_error", e);
            Function1<Boolean, Unit> r112 = LiveSettingManager.INSTANCE.getSETTING_CALLBACK();
            if (r112 == null) goto L35;
            Unit r113 = r112.invoke(Boolean.FALSE);
            goto L35
        L15:
            r109 = false;
            goto L16
        L11:
            r107 = 0;
        L35:
            r100.onComplete();
            return;
        L5:
            r103 = null;
            goto L7
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f85887a;

        public b(Context r100) {
            this.f85887a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            JsonObject r101 = (JsonObject) r100;
            Function1<Boolean, Unit> r102 = LiveSettingManager.INSTANCE.getSETTING_CALLBACK();
            if (r102 == null) goto L5;
            Unit r103 = r102.invoke(Boolean.TRUE);
        L5:
            TTOpenLiveSettingUtil.updateSettings(this.f85887a, r101);
        }
    }

    private LiveSettingManager() {
    }

    static {
        INSTANCE = new LiveSettingManager();
    }

    public final Function1<Boolean, Unit> getSETTING_CALLBACK() {
        return SETTING_CALLBACK;
    }

    private final void getSettingsTasksInIoThread(Context r100) {
        Observable.create(a.f85886a).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new b(r100));
    }

    public final void setSETTING_CALLBACK(Function1<? super Boolean, Unit> r100) {
        SETTING_CALLBACK = r100;
    }

    public final void syncLiveSDKSettings(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (TTOpenLiveSettingUtil.isAsyncSettingEnable() == false) goto L5;
        getSettingsTasksInIoThread(r100.getApplicationContext());
        return;
    L5:
        new c(r100.getApplicationContext()).execute1(new String[0]);
    }

    public final void syncLiveSDKSettings(Context r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        SETTING_CALLBACK = r101;
        if (TTOpenLiveSettingUtil.isAsyncSettingEnable() == false) goto L5;
        getSettingsTasksInIoThread(r100.getApplicationContext());
        return;
    L5:
        new c(r100.getApplicationContext()).execute1(new String[0]);
    }
}
