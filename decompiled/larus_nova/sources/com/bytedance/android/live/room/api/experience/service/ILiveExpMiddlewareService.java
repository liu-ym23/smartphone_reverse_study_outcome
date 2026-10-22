package com.bytedance.android.live.room.api.experience.service;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.common.applog.EventVerify;
import d90.d;
import io.reactivex.disposables.Disposable;
import j70.h;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import l61.b;
import l61.c;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bg\u0018\u0000 $2\u00020\u0001:\u0001%J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH&J\u0018\u0010\u0012\u001a\u00020\u00072\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000fH&J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H&J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H&J\b\u0010\u001a\u001a\u00020\u0007H&J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0014\u001a\u00020\u0013H&J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH&J\b\u0010\"\u001a\u00020\u0007H&J\b\u0010#\u001a\u00020\u0007H&¨\u0006&"}, d2 = {"Lcom/bytedance/android/live/room/api/experience/service/ILiveExpMiddlewareService;", "Lcom/bytedance/android/live/base/IService;", "Lj70/h;", "Ld90/d;", "getExpPushTetrisDesc", "", "tag", "", EventVerify.TYPE_LAUNCH, "stop", "Le61/a;", "dispatcher", "Ln61/c;", "source", "processSource", "Lj61/b;", "", "result", "handleResult", "Ll61/b;", "scene", "Lg61/a;", "listener", "Lio/reactivex/disposables/Disposable;", "registerExpBizListener", "unregisterExpBizListener", "showExpOptDialog", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Ll61/c;", "getSceneState", "", BasicTestActionHandler.TEST_ACTION_RESET, "shouldResetPerfBySwitchClose", "checkResetPerfWhenRoomExit", "showWIFISwitch4GPush", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveExpMiddlewareService extends IService {
    public static final a Companion = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            a r100 = ILiveExpMiddlewareService.Companion;
        }

        @JvmStatic
        public static ILiveExpMiddlewareService ins() {
            ILiveExpMiddlewareService.Companion.getClass();
            return (ILiveExpMiddlewareService) k.n(ILiveExpMiddlewareService.class);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f98907a = null;

        public a() {
        }

        static {
            f98907a = new a();
        }
    }

    static {
        Companion = a.f98907a;
    }

    void checkResetPerfWhenRoomExit();

    e61.a dispatcher();

    h<? extends d> getExpPushTetrisDesc();

    c getSceneState(DataCenter r100, b r101);

    void handleResult(j61.b<? extends Object> r100);

    void launch(int r100);

    void processSource(n61.c r100);

    Disposable registerExpBizListener(b r100, g61.a r101);

    void shouldResetPerfBySwitchClose(boolean r100);

    void showExpOptDialog();

    void showWIFISwitch4GPush();

    void stop(int r100);

    void unregisterExpBizListener(b r100, g61.a r101);
}
