package Ga;

import N9.j;
import S7.k;
import android.content.Context;
import stepai.aios.guiexecutor.api.GuiActionExecutor;
import stepai.aios.guiexecutor.core.AccessibleGuiActionExecutor;
import stepai.aios.guiexecutor.core.DefaultCommandDispatcher;
import stepai.aios.guiexecutor.core.DefaultCommandValidator;
import stepai.aios.guiexecutor.core.DefaultGuiExecutor;
import stepai.aios.guiexecutor.handler.b;
import stepai.aios.guiexecutor.handler.c;
import stepai.aios.guiexecutor.handler.d;
import stepai.aios.guiexecutor.handler.e;
import stepai.aios.guiexecutor.handler.f;
import stepai.aios.guiexecutor.handler.g;
import stepai.aios.guiexecutor.input.UserInputManager;

/* loaded from: classes4.dex */
public final class a {
    public static DefaultGuiExecutor a(Context context, GuiActionExecutor guiActionExecutor, UserInputManager userInputManager, k kVar, k kVar2, long j5) {
        j.H("Creating GUI executor. delayToPerformAccessibilityAction: " + j5, "GuiExecutorFactory");
        if (guiActionExecutor == null) {
            guiActionExecutor = AccessibleGuiActionExecutor.INSTANCE;
        }
        GuiActionExecutor guiActionExecutor2 = guiActionExecutor;
        DefaultCommandDispatcher defaultCommandDispatcher = new DefaultCommandDispatcher();
        DefaultCommandValidator defaultCommandValidator = new DefaultCommandValidator();
        defaultCommandDispatcher.registerHandler(new c(guiActionExecutor2, kVar, kVar2, j5));
        defaultCommandDispatcher.registerHandler(new d(guiActionExecutor2, kVar, kVar2));
        defaultCommandDispatcher.registerHandler(new e(guiActionExecutor2, kVar, kVar2));
        defaultCommandDispatcher.registerHandler(new g());
        defaultCommandDispatcher.registerHandler(new b(context, guiActionExecutor2));
        defaultCommandDispatcher.registerHandler(new Ha.g());
        defaultCommandDispatcher.registerHandler(new Ha.e(context));
        defaultCommandDispatcher.registerHandler(new f(guiActionExecutor2));
        defaultCommandDispatcher.registerHandler(new stepai.aios.guiexecutor.handler.a(userInputManager));
        defaultCommandDispatcher.registerHandler(new Ha.d());
        j.H("Registered " + defaultCommandDispatcher.getSupportedTypes().size() + " command handlers", "GuiExecutorFactory");
        return new DefaultGuiExecutor(defaultCommandDispatcher, defaultCommandValidator, null, 4, null);
    }
}
