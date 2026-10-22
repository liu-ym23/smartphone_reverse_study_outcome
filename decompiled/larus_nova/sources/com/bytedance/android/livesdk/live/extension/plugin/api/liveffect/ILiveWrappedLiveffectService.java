package com.bytedance.android.livesdk.live.extension.plugin.api.liveffect;

import com.bytedance.android.live.base.IService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;
import va1.b;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017J\b\u0010\u0003\u001a\u00020\u0002H&J\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000bH&J\u0016\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u001a\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/liveffect/ILiveWrappedLiveffectService;", "Lcom/bytedance/android/live/base/IService;", "", "getVersion", "", "isEdgeRender", "Ltf2/a;", "createEffectWrapper", "(Ljava/lang/Boolean;)Ltf2/a;", "", "faceInfo", "Lsf2/a;", "getLiveWrappedFaceInfo", "Lcom/bytedance/android/livesdk/live/extension/plugin/api/liveffect/LiveWrappedFace;", "createFace", "createFaceInfo", "getBaseFaceInfo", "Lorg/json/JSONObject;", "config", ICEffectKeys.KEY_IS_IC_EFFECT_LICENSE, "", "setEffectABInfoWithLicense", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveWrappedLiveffectService extends IService {
    public static final a Companion = null;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.live.extension.plugin.api.liveffect.ILiveWrappedLiveffectService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            a r100 = ILiveWrappedLiveffectService.Companion;
        }

        @JvmStatic
        public static ILiveWrappedLiveffectService get() {
            ILiveWrappedLiveffectService.Companion.getClass();
            return (ILiveWrappedLiveffectService) b.a.f553922a.a(ILiveWrappedLiveffectService.class);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f147285a = null;

        public a() {
        }

        static {
            f147285a = new a();
        }
    }

    static {
        Companion = a.f147285a;
    }

    tf2.a createEffectWrapper(Boolean r100);

    LiveWrappedFace createFace();

    sf2.a createFaceInfo();

    Object getBaseFaceInfo(sf2.a r100);

    sf2.a getLiveWrappedFaceInfo(Object r100);

    String getVersion();

    int setEffectABInfoWithLicense(JSONObject r100, String r101);
}
