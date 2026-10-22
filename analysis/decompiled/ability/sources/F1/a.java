package F1;

import N9.m;
import a.AbstractC0291a;
import aa.InterfaceC0314a;
import aa.InterfaceC0315b;
import android.os.Message;
import com.stepos.ability.database.entity.AtomicAbilityEntity;
import java.util.HashMap;
import java.util.Map;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.k;
import org.slf4j.helpers.NOPLogger;
import stepai.aios.guiagent.util.AppErrorType;
import stepai.aios.guiagent.util.AppException;
import z2.o;
import z2.q;

/* loaded from: classes2.dex */
public final class a implements L.a, P4.a, T9.a, InterfaceC0314a, f2.a, o {

    /* renamed from: a, reason: collision with root package name */
    public static volatile a f533a;

    public static final J3.a g(AtomicAbilityEntity atomicAbilityEntity) {
        return new J3.a(atomicAbilityEntity.f3084a, atomicAbilityEntity.b, atomicAbilityEntity.c, atomicAbilityEntity.d, atomicAbilityEntity.f, atomicAbilityEntity.g, atomicAbilityEntity.h, atomicAbilityEntity.i, atomicAbilityEntity.m, atomicAbilityEntity.n, atomicAbilityEntity.o, atomicAbilityEntity.p);
    }

    public static AppException h(AppErrorType appErrorType, String str, String message, Exception exc) {
        int i = AppException.f6174a;
        if (message == null) {
            message = B7.a.k("应用操作失败: ", exc.getMessage());
        }
        k.f(message, "message");
        return new AppException(message, exc);
    }

    public static com.stepos.taskrobot.taskmanager.experiencelib.client.a k() {
        com.stepos.taskrobot.taskmanager.experiencelib.client.a aVar;
        a aVar2 = com.stepos.taskrobot.taskmanager.experiencelib.client.a.e;
        com.stepos.taskrobot.taskmanager.experiencelib.client.a aVar3 = com.stepos.taskrobot.taskmanager.experiencelib.client.a.f;
        if (aVar3 != null) {
            return aVar3;
        }
        synchronized (aVar2) {
            aVar = com.stepos.taskrobot.taskmanager.experiencelib.client.a.f;
            if (aVar == null) {
                aVar = new com.stepos.taskrobot.taskmanager.experiencelib.client.a("https://biz-gw.stepaos.com/gui-agent-service/api/");
                com.stepos.taskrobot.taskmanager.experiencelib.client.a.f = aVar;
            }
        }
        return aVar;
    }

    public static AppException l(String packageName) {
        int i = AppException.f6174a;
        k.f(packageName, "packageName");
        return new AppException(AppErrorType.c, packageName, null, "启动应用失败: ".concat(packageName), 4);
    }

    public static AppException m(String appName) {
        int i = AppException.f6174a;
        k.f(appName, "appName");
        return new AppException(AppErrorType.b, null, appName, "找不到应用对应的包名: ".concat(appName), 2);
    }

    @Override // L.a
    public String a() {
        return null;
    }

    @Override // L.a
    public String b() {
        return null;
    }

    @Override // L.a
    public String c() {
        return null;
    }

    @Override // aa.InterfaceC0314a
    public InterfaceC0315b d(String str) {
        return NOPLogger.f5514a;
    }

    @Override // P4.a
    public String e() {
        return "https://biz-gw.zyqltest.com/dictionary/";
    }

    @Override // z2.o
    public boolean f(Object obj, Runnable runnable) {
        Message message;
        q qVar = (q) obj;
        return (qVar == null || (message = qVar.f6939a) == null || !runnable.equals(message.getCallback())) ? false : true;
    }

    @Override // L.a
    public String getDid() {
        return null;
    }

    @Override // L.a
    public String getUserId() {
        return null;
    }

    @Override // P4.a
    public String i() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // P4.a
    public String j() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // T9.a
    public void log(String message) {
        k.f(message, "message");
        m.Companion.getClass();
        m.log$default(m.platform, message, 0, null, 6, null);
    }

    @Override // f2.a
    public f2.b c(String str, byte[] bArr, Map map) {
        return new f2.b(200, AbstractC0291a.f(str, (HashMap) map, bArr).getBytes());
    }
}
