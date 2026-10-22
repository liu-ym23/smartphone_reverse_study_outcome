package com.obric.aiagent.ipc.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FileIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IFileIDLSPI extends IFileIDL {
    public static final a Companion = null;
    public static final String TAG = "IFileIDLSPI";

    /* JADX INFO: compiled from: FileIDLExt.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f18637a = null;

        static {
            f18637a = new a();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: FileIDLExt.kt */
    public static final class b {
        public static IBinder a(IFileIDLSPI r2) {
            IFileIDLSPI r3 = (IFileIDLSPI) ZeusTransformUtils.wrapperContextForParams(r2, IFileIDLSPI.class, "com.obric.aiagent.plugin");
            return null;
        }
    }

    static {
        Companion = a.f18637a;
    }

    @Override // android.os.IInterface
    IBinder asBinder();
}
