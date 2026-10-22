package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AgentMessageIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IAgentMessageIDLSPI extends IAgentMessageIDL {
    public static final a Companion = null;
    public static final String TAG = "IAgentMessageIDLSPI";

    /* JADX INFO: compiled from: AgentMessageIDLExt.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f16153a = null;

        static {
            f16153a = new a();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AgentMessageIDLExt.kt */
    public static final class b {
        public static IBinder a(IAgentMessageIDLSPI r2) {
            IAgentMessageIDLSPI r3 = (IAgentMessageIDLSPI) ZeusTransformUtils.wrapperContextForParams(r2, IAgentMessageIDLSPI.class, "com.obric.aiagent.plugin");
            return null;
        }
    }

    static {
        Companion = a.f16153a;
    }

    @Override // android.os.IInterface
    IBinder asBinder();
}
