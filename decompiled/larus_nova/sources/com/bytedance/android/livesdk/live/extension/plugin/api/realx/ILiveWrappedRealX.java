package com.bytedance.android.livesdk.live.extension.plugin.api.realx;

import com.bytedance.android.live.base.IService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import vf2.b;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/realx/ILiveWrappedRealX;", "Lcom/bytedance/android/live/base/IService;", "Lvf2/a;", "getContextUtils", "Lvf2/b;", "getThreadUtils", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveWrappedRealX extends IService {
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f147293a = null;

        public a() {
        }

        static {
            f147293a = new a();
        }
    }

    static {
        Companion = a.f147293a;
    }

    vf2.a getContextUtils();

    b getThreadUtils();
}
