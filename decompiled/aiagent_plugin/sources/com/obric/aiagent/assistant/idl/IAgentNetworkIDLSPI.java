package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AgentNetworkIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IAgentNetworkIDLSPI extends IAgentNetworkIDL {
    public static final a Companion = null;
    public static final String TAG = "IAgentNetworkIDLSPI";

    /* JADX INFO: compiled from: AgentNetworkIDLExt.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f16154a = null;

        static {
            f16154a = new a();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AgentNetworkIDLExt.kt */
    public static final class b {
        public static IBinder a(IAgentNetworkIDLSPI r2) {
            IAgentNetworkIDLSPI r3 = (IAgentNetworkIDLSPI) ZeusTransformUtils.wrapperContextForParams(r2, IAgentNetworkIDLSPI.class, "com.obric.aiagent.plugin");
            return null;
        }
    }

    static {
        Companion = a.f16154a;
    }

    @Override // android.os.IInterface
    IBinder asBinder();
}
