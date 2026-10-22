package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AgentVoiceInteractionIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IAgentVoiceInteractionIDLSPI extends IAgentVoiceInteractionIDL {
    public static final a Companion = null;
    public static final String TAG = "IAgentVoiceInteractionIDLSPI";

    /* JADX INFO: compiled from: AgentVoiceInteractionIDLExt.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f16160a = null;

        static {
            f16160a = new a();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AgentVoiceInteractionIDLExt.kt */
    public static final class b {
        public static IBinder a(IAgentVoiceInteractionIDLSPI r2) {
            IAgentVoiceInteractionIDLSPI r3 = (IAgentVoiceInteractionIDLSPI) ZeusTransformUtils.wrapperContextForParams(r2, IAgentVoiceInteractionIDLSPI.class, "com.obric.aiagent.plugin");
            return null;
        }
    }

    static {
        Companion = a.f16160a;
    }

    @Override // android.os.IInterface
    IBinder asBinder();
}
