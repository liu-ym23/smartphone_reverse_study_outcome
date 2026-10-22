package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AgentSkillManagerIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IAgentSkillManagerIDLSPI extends IAgentSkillManagerIDL {
    public static final a Companion = null;
    public static final String TAG = "IAgentSkillManagerIDLSPI";

    /* JADX INFO: compiled from: AgentSkillManagerIDLExt.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f16157a = null;

        static {
            f16157a = new a();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AgentSkillManagerIDLExt.kt */
    public static final class b {
        public static IBinder a(IAgentSkillManagerIDLSPI r2) {
            IAgentSkillManagerIDLSPI r3 = (IAgentSkillManagerIDLSPI) ZeusTransformUtils.wrapperContextForParams(r2, IAgentSkillManagerIDLSPI.class, "com.obric.aiagent.plugin");
            return null;
        }
    }

    static {
        Companion = a.f16157a;
    }

    @Override // android.os.IInterface
    IBinder asBinder();
}
