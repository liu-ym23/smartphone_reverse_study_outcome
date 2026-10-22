package stepai.aios.guiagent.util;

import N9.j;
import android.app.Application;
import com.stepos.ability.task.executor.e;
import com.stepos.statsrpk.service.c;
import j9.m;
import java.util.Map;
import k2.C1621a;
import kotlin.jvm.internal.k;
import kotlin.text.Regex;
import z2.l;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6177a = new a();
    public static final C1621a b;

    static {
        Application application = l.b;
        if (application != null) {
            b = new C1621a(application, 2);
        } else {
            k.n("application");
            throw null;
        }
    }

    public static String a(String str) throws AppException {
        k.f(str, "<this>");
        if (m.h0(str, ".", false) && new Regex("^[a-zA-Z][a-zA-Z0-9_.]*$").d(str)) {
            j.H("Input is package name: ".concat(str), "AppUtils");
            return str;
        }
        j.H("Input is app name, mapping: ".concat(str), "AppUtils");
        try {
            Map mapY = b.y();
            Object obj = Ia.b.f856a;
            String strO = e.o(str, mapY);
            if (!m.s0(strO) && !strO.equals(str)) {
                j.H("App name mapped to package: " + str + " -> " + strO, "AppUtils");
                return strO;
            }
            int i = AppException.f6174a;
            AppException appExceptionM = F1.a.m(str);
            j.G("Package not found for app: " + appExceptionM.getMessage(), "AppUtils");
            throw appExceptionM;
        } catch (AppException e) {
            throw e;
        } catch (Exception e6) {
            int i6 = AppException.f6174a;
            AppException appExceptionH = F1.a.h(AppErrorType.b, str, "查找包名失败: ".concat(str), e6);
            c.n("loadPackageName failed: ", appExceptionH.getMessage(), "AppUtils");
            throw appExceptionH;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0098 A[Catch: Exception -> 0x00d4, AppException -> 0x014f, TRY_ENTER, TryCatch #0 {AppException -> 0x014f, blocks: (B:14:0x0036, B:21:0x004c, B:34:0x007e, B:36:0x0089, B:40:0x0098, B:44:0x00d6, B:46:0x00da, B:50:0x00ea, B:26:0x005d, B:28:0x0063, B:31:0x0069, B:52:0x0108, B:53:0x010e, B:54:0x010f), top: B:62:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d6 A[Catch: Exception -> 0x00d4, AppException -> 0x014f, TryCatch #0 {AppException -> 0x014f, blocks: (B:14:0x0036, B:21:0x004c, B:34:0x007e, B:36:0x0089, B:40:0x0098, B:44:0x00d6, B:46:0x00da, B:50:0x00ea, B:26:0x005d, B:28:0x0063, B:31:0x0069, B:52:0x0108, B:53:0x010e, B:54:0x010f), top: B:62:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable b(java.lang.String r17, long r18, stepai.aios.guiexecutor.api.GuiActionExecutor r20, kotlin.coroutines.jvm.internal.ContinuationImpl r21) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.util.a.b(java.lang.String, long, stepai.aios.guiexecutor.api.GuiActionExecutor, kotlin.coroutines.jvm.internal.ContinuationImpl):java.io.Serializable");
    }
}
