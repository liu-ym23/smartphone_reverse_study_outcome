package com.bytedance.android.livesdkapi.ws;

import com.ss.ugc.live.sdk.msg.unify.d;
import com.ss.ugc.live.sdk.msg.unify.e;
import gmc.a;
import imc.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public class GlobalUnifyMessageManager implements b {
    private static volatile GlobalUnifyMessageManager ourInstance;
    private static volatile boolean sInit;
    private a unifyMessageConfig;
    private b unifyMessageManager;

    public static GlobalUnifyMessageManager getInstance() {
        if (ourInstance != null) goto L15;
        monitor-enter(GlobalUnifyMessageManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (ourInstance != null) goto L9;
        ourInstance = new GlobalUnifyMessageManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(GlobalUnifyMessageManager.class);     // Catch: Throwable -> L11
    L15:
        return ourInstance;
    }

    private GlobalUnifyMessageManager() {
    }

    public static boolean isInit() {
        return sInit;
    }

    public void init(a r100) {
        monitor-enter(GlobalUnifyMessageManager.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (sInit == true) goto L7;
        this.unifyMessageConfig = r100;     // Catch: Throwable -> L9
        int r101 = e.f458387a;     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r100, "unifyMessageConfig");     // Catch: Throwable -> L9
        this.unifyMessageManager = new d(r100);     // Catch: Throwable -> L9
        sInit = true;     // Catch: Throwable -> L9
    L7:
        monitor-exit(GlobalUnifyMessageManager.class);     // Catch: Throwable -> L9
    }

    @Override // imc.b
    public imc.a registerBusiness(imc.d r100) {
        if (sInit == false) goto L7;
        return this.unifyMessageManager.registerBusiness(r100);
    L7:
        throw new RuntimeException("unify message manager has not init");
    }
}
