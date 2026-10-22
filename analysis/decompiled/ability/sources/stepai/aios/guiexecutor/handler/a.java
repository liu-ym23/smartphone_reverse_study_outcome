package stepai.aios.guiexecutor.handler;

import D7.w;
import j9.m;
import j9.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.k;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.api.GuiCommandHandler;
import stepai.aios.guiexecutor.api.GuiCommandType;
import stepai.aios.guiexecutor.api.GuiParameters;
import stepai.aios.guiexecutor.api.QueryType;
import stepai.aios.guiexecutor.api.ValidationResult;
import stepai.aios.guiexecutor.input.UserInputManager;
import stepai.aios.guiexecutor.input.UserInputType;

/* loaded from: classes4.dex */
public final class a implements GuiCommandHandler {

    /* renamed from: a, reason: collision with root package name */
    public final UserInputManager f6190a;
    public final GuiCommandType b = GuiCommandType.ASK_FOR_INPUT;

    public a(UserInputManager userInputManager) {
        this.f6190a = userInputManager;
    }

    public static UserInputType a(GuiParameters.QueryParams queryParams) {
        Object next;
        String upperCase;
        Iterator<T> it = queryParams.getAttributes().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (t.e0((String) next, "inputType:", false)) {
                break;
            }
        }
        String str = (String) next;
        String strH0 = str != null ? m.H0(str, "inputType:", str) : null;
        if (strH0 != null) {
            try {
                upperCase = strH0.toUpperCase(Locale.ROOT);
                k.e(upperCase, "toUpperCase(...)");
            } catch (IllegalArgumentException unused) {
                return UserInputType.TEXT;
            }
        } else {
            upperCase = "TEXT";
        }
        return UserInputType.valueOf(upperCase);
    }

    public static String b(GuiParameters.QueryParams queryParams) {
        Object next;
        Iterator<T> it = queryParams.getAttributes().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (t.e0((String) next, "message:", false)) {
                break;
            }
        }
        String str = (String) next;
        if (str != null) {
            return m.H0(str, "message:", str);
        }
        return null;
    }

    public static ArrayList c(GuiParameters.QueryParams queryParams) {
        Object next;
        Iterator<T> it = queryParams.getAttributes().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (t.e0((String) next, "options:", false)) {
                break;
            }
        }
        String str = (String) next;
        String strH0 = str != null ? m.H0(str, "options:", str) : null;
        if (strH0 == null) {
            return null;
        }
        List listD0 = m.D0(strH0, new String[]{","}, 6);
        ArrayList arrayList = new ArrayList(w.c0(listD0, 10));
        Iterator it2 = listD0.iterator();
        while (it2.hasNext()) {
            arrayList.add(m.R0((String) it2.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            Object next2 = it3.next();
            if (((String) next2).length() > 0) {
                arrayList2.add(next2);
            }
        }
        return arrayList2;
    }

    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    public final GuiCommandType getSupportedType() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019f A[Catch: Exception -> 0x01de, TryCatch #2 {Exception -> 0x01de, blocks: (B:63:0x0191, B:65:0x019f, B:70:0x01e2, B:71:0x0211, B:77:0x0244, B:82:0x0252, B:85:0x025a, B:79:0x0249, B:80:0x024c, B:81:0x024f, B:59:0x0187, B:95:0x0276), top: B:104:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0211 A[Catch: Exception -> 0x01de, TryCatch #2 {Exception -> 0x01de, blocks: (B:63:0x0191, B:65:0x019f, B:70:0x01e2, B:71:0x0211, B:77:0x0244, B:82:0x0252, B:85:0x025a, B:79:0x0249, B:80:0x024c, B:81:0x024f, B:59:0x0187, B:95:0x0276), top: B:104:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v22, types: [stepai.aios.guiexecutor.api.GuiCommand] */
    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handle(stepai.aios.guiexecutor.api.GuiCommand r29, H7.c r30) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 719
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiexecutor.handler.a.handle(stepai.aios.guiexecutor.api.GuiCommand, H7.c):java.lang.Object");
    }

    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    public final ValidationResult validate(GuiCommand command) {
        k.f(command, "command");
        if (!(command.getParameters() instanceof GuiParameters.QueryParams)) {
            return ValidationResult.INSTANCE.failure("Invalid parameters type for ask for input command");
        }
        GuiParameters.QueryParams queryParams = (GuiParameters.QueryParams) command.getParameters();
        if (queryParams.getQueryType() != QueryType.USER_INFO) {
            return ValidationResult.INSTANCE.failure("AskForInputCommandHandler only supports USER_INFO query type");
        }
        String strB = b(queryParams);
        return (strB == null || strB.length() == 0) ? ValidationResult.INSTANCE.failure("Message content is required") : ValidationResult.INSTANCE.success();
    }
}
