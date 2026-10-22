package com.obric.funcall_api;

import android.graphics.Bitmap;
import com.obric.funcall_api.bean.AppActionRequest;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.a.q;
import d.x;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: IIntentActionService.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface IIntentActionService {
    public static final a Companion = null;

    /* JADX INFO: compiled from: IIntentActionService.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f33244a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final IIntentActionService f33245b = null;

        private a() {
        }

        static {
            f33244a = new a();
            f33245b = (IIntentActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentActionService.class), IIntentActionService.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: IIntentActionService.kt */
    public static final class b {
        public static /* synthetic */ void a(IIntentActionService r2, String r3, String r4, boolean r5, m r6, int r7, Object r8) {
            IIntentActionService r9 = (IIntentActionService) ZeusTransformUtils.wrapperContextForParams(r2, IIntentActionService.class, "com.obric.aiagent.plugin");
            m<? super Boolean, ? super String, x> r10 = (m) ZeusTransformUtils.wrapperContextForParams(r6, m.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L13;
            if ((r7 & 4) == 0) goto L8;
            r5 = true;
        L8:
            if ((r7 & 8) == 0) goto L10;
            r10 = null;
        L10:
            r9.sendNormalRouterByHttp(r3, r4, r5, r10);
            return;
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendNormalRouterByHttp");
        }
    }

    static {
        Companion = a.f33244a;
    }

    void cacheScreenshot(Bitmap r1, Map<String, String> r2);

    void init();

    void notifyUserOperateQueue(String r1, m<? super Boolean, ? super String, x> r2);

    void notifyUserTakeOverByHttp(String r1, String r2, String r3, long r4, Map<String, String> r6, m<? super Boolean, ? super String, x> r7);

    void registerAppActionListener(OnAppActionListener r1);

    void replyAskUserUploadByHttp(String r1, String r2, String r3, Map<?, ?> r4, m<? super Boolean, ? super String, x> r5);

    void sendAppAction(AppActionRequest r1, m<? super Boolean, ? super String, x> r2);

    void sendAppActionForAsyncNotifyByHttp(List<AppActionRequest> r1, boolean r2, q<? super Boolean, ? super String, ? super Map<String, String>, x> r3);

    void sendAppActionForCompensationByHttp(List<AppActionRequest> r1, boolean r2, q<? super Boolean, ? super String, ? super Map<String, String>, x> r3);

    void sendNormalRouterByHttp(String r1, String r2, boolean r3, m<? super Boolean, ? super String, x> r4);

    void unRegisterAppActionListener(OnAppActionListener r1);
}
