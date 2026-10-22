package com.obric.aiagent.ipc;

import android.content.Context;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;

/* JADX INFO: compiled from: IAgentIpcManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IAgentIpcManager {
    public static final a Companion = null;

    /* JADX INFO: compiled from: IAgentIpcManager.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f18598a = null;

        static {
            f18598a = new a();
        }

        private a() {
        }

        public final IAgentIpcManager a() {
            return (IAgentIpcManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentIpcManager.class), IAgentIpcManager.class, "com.obric.aiagent.plugin");
        }
    }

    static {
        Companion = a.f18598a;
    }

    void checkIpcReady(d.h.a.b<? super Boolean, x> r1);

    void init(Context r1);
}
