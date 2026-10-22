package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AgentAppIntentIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IAgentAppIntentIDLSPI extends IAgentAppIntentIDL {
    public static final a Companion = null;
    public static final String TAG = "IAgentAppIntentIDLSPI";

    /* JADX INFO: compiled from: AgentAppIntentIDLExt.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f16148a = null;

        static {
            f16148a = new a();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AgentAppIntentIDLExt.kt */
    public static final class b {
        public static IBinder a(IAgentAppIntentIDLSPI r2) {
            IAgentAppIntentIDLSPI r3 = (IAgentAppIntentIDLSPI) ZeusTransformUtils.wrapperContextForParams(r2, IAgentAppIntentIDLSPI.class, "com.obric.aiagent.plugin");
            return null;
        }
    }

    static {
        Companion = a.f16148a;
    }

    @Override // android.os.IInterface
    IBinder asBinder();
}
