package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AgentIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IAgentIDLSPI extends IAgentIDL {
    public static final a Companion = null;
    public static final String TAG = "IAgentIDLSPI";

    /* JADX INFO: compiled from: AgentIDLExt.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f16152a = null;

        static {
            f16152a = new a();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AgentIDLExt.kt */
    public static final class b {
        public static IBinder a(IAgentIDLSPI r2) {
            IAgentIDLSPI r3 = (IAgentIDLSPI) ZeusTransformUtils.wrapperContextForParams(r2, IAgentIDLSPI.class, "com.obric.aiagent.plugin");
            return null;
        }
    }

    static {
        Companion = a.f16152a;
    }

    @Override // android.os.IInterface
    IBinder asBinder();
}
