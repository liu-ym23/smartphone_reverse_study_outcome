package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PlatformApiIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IPlatformApiIDLSPI extends IPlatformApiIDL {
    public static final a Companion = null;
    public static final String TAG = "IPlatformApiIDLSPI";

    /* JADX INFO: compiled from: PlatformApiIDLExt.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f16201a = null;

        static {
            f16201a = new a();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: PlatformApiIDLExt.kt */
    public static final class b {
        public static IBinder a(IPlatformApiIDLSPI r2) {
            IPlatformApiIDLSPI r3 = (IPlatformApiIDLSPI) ZeusTransformUtils.wrapperContextForParams(r2, IPlatformApiIDLSPI.class, "com.obric.aiagent.plugin");
            return null;
        }
    }

    static {
        Companion = a.f16201a;
    }

    @Override // android.os.IInterface
    IBinder asBinder();
}
