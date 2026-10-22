package com.stepos.agentframework.adapter.bff;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005\t\n\u000b\f\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/BffConstant;", "", AppAgent.CONSTRUCT, "()V", "_Module", "", "_Command", "_DeviceId", "_TraceId", "Type", BffConstant._Module, "Cmd", "Role", "Error", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BffConstant {
    public static final BffConstant INSTANCE = new BffConstant();
    public static final String _Command = "Command";
    public static final String _DeviceId = "DeviceId";
    public static final String _Module = "Module";
    public static final String _TraceId = "TraceId";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/BffConstant$Cmd;", "", AppAgent.CONSTRUCT, "()V", Cmd.Auth, "", Cmd.Heartbeat, Cmd.Invoke, Cmd.Chat, Cmd.CallBack, Cmd.CallTool, Cmd.ImageLayout, Cmd.VideoHighlight, "AgentCall", Cmd.VideoEdit, Cmd.VideoNewEdit, Cmd.NewChat, Cmd.VideoVoiceEdit, "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Cmd {
        public static final String AgentCall = "ChatCompletionStream";
        public static final String Auth = "Auth";
        public static final String CallBack = "CallBack";
        public static final String CallTool = "CallTool";
        public static final String Chat = "Chat";
        public static final String Heartbeat = "Heartbeat";
        public static final Cmd INSTANCE = new Cmd();
        public static final String ImageLayout = "ImageLayout";
        public static final String Invoke = "Invoke";
        public static final String NewChat = "NewChat";
        public static final String VideoEdit = "VideoEdit";
        public static final String VideoHighlight = "VideoHighlight";
        public static final String VideoNewEdit = "VideoNewEdit";
        public static final String VideoVoiceEdit = "VideoVoiceEdit";

        private Cmd() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/BffConstant$Error;", "", AppAgent.CONSTRUCT, "()V", "ConnectBreak", "", "RuntimeError", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Error {
        public static final int ConnectBreak = 100001;
        public static final Error INSTANCE = new Error();
        public static final int RuntimeError = 100002;

        private Error() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/BffConstant$Module;", "", AppAgent.CONSTRUCT, "()V", Module.Stream, "", Module.Task, Module.Omni, Module.Internet, "Model", Module.Images, "Video", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Module {
        public static final Module INSTANCE = new Module();
        public static final String Images = "Images";
        public static final String Internet = "Internet";
        public static final String Model = "Model";
        public static final String Omni = "Omni";
        public static final String Stream = "Stream";
        public static final String Task = "Task";
        public static final String Video = "Videos";

        private Module() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/BffConstant$Role;", "", AppAgent.CONSTRUCT, "()V", "User", "", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Role {
        public static final Role INSTANCE = new Role();
        public static final String User = "user";

        private Role() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/BffConstant$Type;", "", AppAgent.CONSTRUCT, "()V", "Text", "", "Image", "Audio", "File", "Url", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Type {
        public static final String Audio = "audio";
        public static final String File = "file";
        public static final Type INSTANCE = new Type();
        public static final String Image = "image";
        public static final String Text = "text";
        public static final String Url = "url";

        private Type() {
        }
    }

    private BffConstant() {
    }
}
