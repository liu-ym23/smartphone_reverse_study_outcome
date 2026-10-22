package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AgentPrivacyIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IAgentPrivacyIDLSPI extends IAgentPrivacyIDL {
    public static final a Companion = null;
    public static final String TAG = "IAgentPrivacyIDLSPI";

    /* JADX INFO: compiled from: AgentPrivacyIDLExt.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f16155a = null;

        static {
            f16155a = new a();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AgentPrivacyIDLExt.kt */
    public static final class b {
        public static IBinder a(IAgentPrivacyIDLSPI r2) {
            IAgentPrivacyIDLSPI r3 = (IAgentPrivacyIDLSPI) ZeusTransformUtils.wrapperContextForParams(r2, IAgentPrivacyIDLSPI.class, "com.obric.aiagent.plugin");
            return null;
        }
    }

    static {
        Companion = a.f16155a;
    }

    @Override // android.os.IInterface
    IBinder asBinder();
}
