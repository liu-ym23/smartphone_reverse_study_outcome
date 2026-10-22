package com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk;

import android.content.Context;
import android.content.res.AssetManager;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.base.IService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import java.lang.reflect.Field;
import kotlin.Metadata;
import va1.b;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 (2\u00020\u0001:\u0001)J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\t\u001a\u0004\u0018\u00010\u0007H&J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H&J0\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H&J\b\u0010\u0019\u001a\u00020\u0018H&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&J\u001c\u0010\u001e\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u001f\u001a\u00020\u000eH&J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u000eH&J\b\u0010\"\u001a\u00020\u000eH&J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u000eH&J\u0017\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H&¢\u0006\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/effectsdk/ILiveWrappedEffectSDKService;", "Lcom/bytedance/android/live/base/IService;", "", "getSdkVersion", "getBuildConfigFullVersion", ICEffectKeys.KEY_IS_IC_EFFECT_LICENSE, "requestABInfoWithLicense", "Lof2/b;", "providerResourceFinder", "getLazyResourceFinder", "Landroid/content/res/AssetManager;", "assetManager", MapBundleKey.MapObjKey.OBJ_DIR, "getNewAssetResourceFinder", "", "isDebug", "deviceId", "", "appId", "appVersion", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "buildEffectUpdateRunner", "Lof2/a;", "getAvatarManagerInstance", "Lpf2/a;", "getMessageCenter", "bundleType", "hostBuildType", "multiMediaEnv_initialize", "multiMediaEnv_diagnosis_getEnableVEHook", "enable", "multiMediaEnv_diagnosis_setEnableVEHook", "multiMediaEnv_diagnosis_getEnableLoadLibrariesFromDisk", "multiMediaEnv_diagnosis_setEnableLoadLibrariesFromDisk", "", "Ljava/lang/reflect/Field;", "getTecommonenvinitializerBuildConfigFileds", "()[Ljava/lang/reflect/Field;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveWrappedEffectSDKService extends IService {
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f147283a = null;

        public a() {
        }

        static {
            f147283a = new a();
        }

        public static ILiveWrappedEffectSDKService a() {
            return (ILiveWrappedEffectSDKService) b.a.f553922a.a(ILiveWrappedEffectSDKService.class);
        }
    }

    static {
        Companion = a.f147283a;
    }

    void buildEffectUpdateRunner(boolean r100, String r101, int r102, String r103, Context r104);

    of2.a getAvatarManagerInstance();

    String getBuildConfigFullVersion();

    of2.b getLazyResourceFinder();

    pf2.a getMessageCenter();

    of2.b getNewAssetResourceFinder(AssetManager r100, String r101);

    String getSdkVersion();

    Field[] getTecommonenvinitializerBuildConfigFileds();

    boolean multiMediaEnv_diagnosis_getEnableLoadLibrariesFromDisk();

    boolean multiMediaEnv_diagnosis_getEnableVEHook();

    void multiMediaEnv_diagnosis_setEnableLoadLibrariesFromDisk(boolean r100);

    void multiMediaEnv_diagnosis_setEnableVEHook(boolean r100);

    void multiMediaEnv_initialize(String r100, String r101);

    of2.b providerResourceFinder();

    String requestABInfoWithLicense(String r100);
}
