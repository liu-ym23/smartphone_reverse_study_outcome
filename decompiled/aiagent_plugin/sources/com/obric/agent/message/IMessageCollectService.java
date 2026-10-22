package com.obric.agent.message;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IMessageCollectService.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IMessageCollectService {
    public static final a Companion = null;

    /* JADX INFO: compiled from: IMessageCollectService.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f15196a = null;

        static {
            f15196a = new a();
        }

        private a() {
        }

        public final IMessageCollectService a() {
            return (IMessageCollectService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IMessageCollectService.class), IMessageCollectService.class, "com.obric.aiagent.plugin");
        }
    }

    static {
        Companion = a.f15196a;
    }

    void start();
}
