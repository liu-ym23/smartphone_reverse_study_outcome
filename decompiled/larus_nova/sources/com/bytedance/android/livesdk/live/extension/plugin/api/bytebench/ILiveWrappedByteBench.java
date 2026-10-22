package com.bytedance.android.livesdk.live.extension.plugin.api.bytebench;

import com.bytedance.android.live.base.IService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import nf2.b;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \b2\u00020\u0001:\u0001\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/bytebench/ILiveWrappedByteBench;", "Lcom/bytedance/android/live/base/IService;", "", "isInit", "Lnf2/b;", "newStrategySettingsBuilder", "Lnf2/a;", "getBTCStrategyManagement", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveWrappedByteBench extends IService {
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f147281a = null;

        public a() {
        }

        static {
            f147281a = new a();
        }
    }

    static {
        Companion = a.f147281a;
    }

    nf2.a getBTCStrategyManagement();

    boolean isInit();

    b newStrategySettingsBuilder();
}
