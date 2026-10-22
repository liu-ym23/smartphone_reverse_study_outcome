package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.db.FwkDatabase;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import w4.RobotInfo;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0003\u0010\u0004\u001a,\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0004\b\t\u0010\n\u001a\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0086@¢\u0006\u0004\b\u000b\u0010\f\"\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lw4/h;", "info", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lw4/h;Le9/c;)Ljava/lang/Object;", "", "taskId", "status", "errorMessage", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "", "dbLock", "Ljava/lang/Object;", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class J0 {
    private static final Object dbLock = new Object();

    public static final Object a(String str, InterfaceC4014c<? super RobotInfo> interfaceC4014c) {
        RobotInfo robotInfoB;
        synchronized (dbLock) {
            robotInfoB = FwkDatabase.INSTANCE.n().n0().b(str);
        }
        return robotInfoB;
    }

    public static final Object b(RobotInfo robotInfo, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        synchronized (dbLock) {
            FwkDatabase.INSTANCE.n().n0().a(robotInfo);
        }
        return Y8.t.f7040a;
    }

    public static final Object c(String str, String str2, String str3, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        synchronized (dbLock) {
            try {
                FwkDatabase.Companion iVar = FwkDatabase.INSTANCE;
                RobotInfo robotInfoB = iVar.n().n0().b(str);
                if (robotInfoB != null) {
                    robotInfoB.o(str2);
                    if (str3 != null) {
                        robotInfoB.k(str3);
                    }
                    robotInfoB.r(System.currentTimeMillis());
                    iVar.n().n0().a(robotInfoB);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return Y8.t.f7040a;
    }

    public static /* synthetic */ Object d(String str, String str2, String str3, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        return c(str, str2, str3, interfaceC4014c);
    }
}
