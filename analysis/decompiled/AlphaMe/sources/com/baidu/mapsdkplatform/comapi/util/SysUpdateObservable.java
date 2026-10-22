package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class SysUpdateObservable {

    /* renamed from: a, reason: collision with root package name */
    private static volatile SysUpdateObservable f8188a;

    /* renamed from: b, reason: collision with root package name */
    private List<SysUpdateObserver> f8189b;

    private SysUpdateObservable() {
        this.f8189b = null;
        this.f8189b = new ArrayList();
    }

    public static SysUpdateObservable getInstance() {
        if (f8188a == null) {
            synchronized (SysUpdateObservable.class) {
                try {
                    if (f8188a == null) {
                        f8188a = new SysUpdateObservable();
                    }
                } finally {
                }
            }
        }
        return f8188a;
    }

    public synchronized void addObserver(SysUpdateObserver sysUpdateObserver) {
        this.f8189b.add(sysUpdateObserver);
    }

    public synchronized void init(String str) {
        for (SysUpdateObserver sysUpdateObserver : this.f8189b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.init(str);
            }
        }
    }

    public synchronized void updateCuid(String str) {
        for (SysUpdateObserver sysUpdateObserver : this.f8189b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updateCuid(str);
            }
        }
    }

    public synchronized void updateNetworkInfo(Context context) {
        for (SysUpdateObserver sysUpdateObserver : this.f8189b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updateNetworkInfo(context);
            }
        }
    }

    public synchronized void updateNetworkProxy(Context context) {
        for (SysUpdateObserver sysUpdateObserver : this.f8189b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updateNetworkProxy(context);
            }
        }
    }

    public synchronized void updatePhoneInfo(String str) {
        for (SysUpdateObserver sysUpdateObserver : this.f8189b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updatePhoneInfo(str);
            }
        }
    }

    public synchronized void updateZid(String str) {
        for (SysUpdateObserver sysUpdateObserver : this.f8189b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updateZid(str);
            }
        }
    }
}
