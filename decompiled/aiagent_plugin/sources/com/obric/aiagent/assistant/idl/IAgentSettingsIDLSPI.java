package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AgentSettingsIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IAgentSettingsIDLSPI extends IAgentSettingsIDL {
    public static final a Companion = null;
    public static final String TAG = "IAgentSettingsIDLSPI";

    /* JADX INFO: compiled from: AgentSettingsIDLExt.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f16156a = null;

        static {
            f16156a = new a();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AgentSettingsIDLExt.kt */
    public static final class b {
        public static IBinder a(IAgentSettingsIDLSPI r2) {
            IAgentSettingsIDLSPI r3 = (IAgentSettingsIDLSPI) ZeusTransformUtils.wrapperContextForParams(r2, IAgentSettingsIDLSPI.class, "com.obric.aiagent.plugin");
            return null;
        }
    }

    static {
        Companion = a.f16156a;
    }

    @Override // android.os.IInterface
    IBinder asBinder();
}
