package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AgentDMStateManagerIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IAgentDMStateManagerIDLSPI extends IAgentDMStateManagerIDL {
    public static final a Companion = null;
    public static final String TAG = "IAgentDMStateManagerIDLSPI";

    /* JADX INFO: compiled from: AgentDMStateManagerIDLExt.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f16151a = null;

        static {
            f16151a = new a();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AgentDMStateManagerIDLExt.kt */
    public static final class b {
        public static IBinder a(IAgentDMStateManagerIDLSPI r2) {
            IAgentDMStateManagerIDLSPI r3 = (IAgentDMStateManagerIDLSPI) ZeusTransformUtils.wrapperContextForParams(r2, IAgentDMStateManagerIDLSPI.class, "com.obric.aiagent.plugin");
            return null;
        }
    }

    static {
        Companion = a.f16151a;
    }

    @Override // android.os.IInterface
    IBinder asBinder();
}
