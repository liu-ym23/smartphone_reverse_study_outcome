package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AgentTaskAppIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IAgentTaskAppIDLSPI extends IAgentTaskAppIDL {
    public static final a Companion = null;
    public static final String TAG = "IAgentTaskAppIDLSPI";

    /* JADX INFO: compiled from: AgentTaskAppIDLExt.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f16159a = null;

        static {
            f16159a = new a();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AgentTaskAppIDLExt.kt */
    public static final class b {
        public static IBinder a(IAgentTaskAppIDLSPI r2) {
            IAgentTaskAppIDLSPI r3 = (IAgentTaskAppIDLSPI) ZeusTransformUtils.wrapperContextForParams(r2, IAgentTaskAppIDLSPI.class, "com.obric.aiagent.plugin");
            return null;
        }
    }

    static {
        Companion = a.f16159a;
    }

    @Override // android.os.IInterface
    IBinder asBinder();
}
