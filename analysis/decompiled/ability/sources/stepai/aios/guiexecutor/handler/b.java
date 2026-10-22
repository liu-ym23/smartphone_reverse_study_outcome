package stepai.aios.guiexecutor.handler;

import N9.j;
import android.content.Context;
import j9.m;
import java.util.Map;
import k2.C1621a;
import kotlin.jvm.internal.k;
import kotlin.text.Regex;
import stepai.aios.guiexecutor.api.GuiActionExecutor;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.api.GuiCommandHandler;
import stepai.aios.guiexecutor.api.GuiCommandType;
import stepai.aios.guiexecutor.api.GuiParameters;
import stepai.aios.guiexecutor.api.ValidationResult;

/* loaded from: classes4.dex */
public final class b implements GuiCommandHandler {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6191a;
    public final GuiActionExecutor b;
    public final GuiCommandType c = GuiCommandType.AWAKE_APP;
    public final C1621a d;

    public b(Context context, GuiActionExecutor guiActionExecutor) {
        this.f6191a = context;
        this.b = guiActionExecutor;
        this.d = new C1621a(context, 2);
    }

    public final String a(String str) throws Exception {
        k.f(str, "<this>");
        if (m.h0(str, ".", false) && new Regex("^[a-zA-Z][a-zA-Z0-9_.]*$").d(str)) {
            j.F("Input is package name: ".concat(str), "AwakeCommandHandler");
            return str;
        }
        j.F("Input is app name, mapping: ".concat(str), "AwakeCommandHandler");
        Map mapY = this.d.y();
        Object obj = Ia.b.f856a;
        String strO = com.stepos.ability.task.executor.e.o(str, mapY);
        if (m.s0(strO) || strO.equals(str)) {
            j.G("Package not found for app: ".concat(str), "AwakeCommandHandler");
            throw new Exception("Package not found for app: ".concat(str));
        }
        j.F("App name mapped to package: " + str + " -> " + strO, "AwakeCommandHandler");
        return strO;
    }

    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    public final GuiCommandType getSupportedType() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0108 A[Catch: Exception -> 0x0094, TRY_ENTER, TRY_LEAVE, TryCatch #8 {Exception -> 0x0094, blocks: (B:25:0x008f, B:32:0x00b4, B:45:0x0108), top: B:99:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0155 A[Catch: Exception -> 0x01b6, TryCatch #5 {Exception -> 0x01b6, blocks: (B:55:0x014b, B:57:0x0155, B:58:0x0183, B:60:0x0189, B:63:0x01a2, B:67:0x01ba, B:52:0x0144, B:75:0x01f4, B:35:0x00ea), top: B:94:0x0037, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01ba A[Catch: Exception -> 0x01b6, TryCatch #5 {Exception -> 0x01b6, blocks: (B:55:0x014b, B:57:0x0155, B:58:0x0183, B:60:0x0189, B:63:0x01a2, B:67:0x01ba, B:52:0x0144, B:75:0x01f4, B:35:0x00ea), top: B:94:0x0037, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v14, types: [stepai.aios.guiexecutor.api.GuiCommand] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handle(stepai.aios.guiexecutor.api.GuiCommand r28, H7.c r29) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiexecutor.handler.b.handle(stepai.aios.guiexecutor.api.GuiCommand, H7.c):java.lang.Object");
    }

    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    public final ValidationResult validate(GuiCommand command) {
        k.f(command, "command");
        return !(command.getParameters() instanceof GuiParameters.AwakeParams) ? ValidationResult.INSTANCE.failure("Invalid awake parameters type") : m.s0(((GuiParameters.AwakeParams) command.getParameters()).getPackageName()) ? ValidationResult.INSTANCE.failure("Package name is required for AWAKE_APP action") : ValidationResult.INSTANCE.success();
    }
}
