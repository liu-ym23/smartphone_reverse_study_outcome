package com.bytedance.android.live.room.api.login;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import q61.b;

/* JADX INFO: loaded from: classes47.dex */
@ServiceLookup("com.bytedance.android.live.login.LoginGuideService")
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \n2\u00020\u0001:\u0001\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/room/api/login/ILoginGuideService;", "Lcom/bytedance/android/live/base/IService;", "Lq61/b;", SoloKtvContext.SOLO_PAGE_ENTRANCE, "", "intercept", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lq61/a;", "createAutoLoginGuideLauncher", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILoginGuideService extends IService {
    public static final a Companion = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.room.api.login.ILoginGuideService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            a r100 = ILoginGuideService.Companion;
        }

        @JvmStatic
        public static ILoginGuideService ins() {
            ILoginGuideService.Companion.getClass();
            return a.a();
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f98918a = null;

        public a() {
        }

        static {
            f98918a = new a();
        }

        @JvmStatic
        public static ILoginGuideService a() {
            return (ILoginGuideService) k.f(ILoginGuideService.class);
        }
    }

    static {
        Companion = a.f98918a;
    }

    q61.a createAutoLoginGuideLauncher(DataCenter r100);

    boolean intercept(b r100);
}
