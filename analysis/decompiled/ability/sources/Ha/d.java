package Ha;

import N9.j;
import j9.m;
import kotlin.jvm.internal.k;
import stepai.aios.guiexecutor.api.ErrorCode;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.api.GuiCommandHandler;
import stepai.aios.guiexecutor.api.GuiCommandType;
import stepai.aios.guiexecutor.api.GuiParameters;
import stepai.aios.guiexecutor.api.GuiResult;
import stepai.aios.guiexecutor.api.ValidationResult;

/* loaded from: classes4.dex */
public final class d implements GuiCommandHandler {

    /* renamed from: a, reason: collision with root package name */
    public final GuiCommandType f786a = GuiCommandType.TAKEOVER;

    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    public final GuiCommandType getSupportedType() {
        return this.f786a;
    }

    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    public final Object handle(GuiCommand guiCommand, H7.c cVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            j.F("Handling takeover command: " + guiCommand.getId(), "TakeoverCommandHandler");
            GuiParameters parameters = guiCommand.getParameters();
            k.d(parameters, "null cannot be cast to non-null type stepai.aios.guiexecutor.api.GuiParameters.TakeoverParams");
            GuiParameters.TakeoverParams takeoverParams = (GuiParameters.TakeoverParams) parameters;
            Object obj = guiCommand.getMetadata().get("sessionId");
            String strL0 = obj instanceof String ? (String) obj : null;
            if (strL0 == null) {
                strL0 = m.L0(guiCommand.getId(), "_");
            }
            j.H("Requesting takeover: id=" + guiCommand.getId() + ", sessionId=" + strL0 + ", reason=" + takeoverParams.getReason(), "TakeoverCommandHandler");
            return GuiResult.Companion.failure$default(GuiResult.INSTANCE, guiCommand.getId(), ErrorCode.TAKEOVER_REQUEST_FAILED, "Takeover requester is not configured", 0L, null, 24, null);
        } catch (Exception e) {
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            com.stepos.statsrpk.service.c.o("Takeover command error: ", guiCommand.getId(), " - ", e.getMessage(), "TakeoverCommandHandler");
            return GuiResult.INSTANCE.failure(guiCommand.getId(), ErrorCode.TAKEOVER_REQUEST_FAILED, B7.a.k("Takeover request failed: ", e.getMessage()), jCurrentTimeMillis2, e);
        }
    }

    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    public final ValidationResult validate(GuiCommand command) {
        k.f(command, "command");
        if (!(command.getParameters() instanceof GuiParameters.TakeoverParams)) {
            return ValidationResult.INSTANCE.failure("Invalid takeover parameters type");
        }
        if (!m.s0(((GuiParameters.TakeoverParams) command.getParameters()).getReason())) {
            return ValidationResult.INSTANCE.success();
        }
        j.J("Takeover reason is blank, continue execution: id=" + command.getId(), "TakeoverCommandHandler");
        return ValidationResult.INSTANCE.success();
    }
}
