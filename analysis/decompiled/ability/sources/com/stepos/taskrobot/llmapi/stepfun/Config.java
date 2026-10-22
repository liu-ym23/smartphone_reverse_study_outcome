package com.stepos.taskrobot.llmapi.stepfun;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00148\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/Config;", "", AppAgent.CONSTRUCT, "()V", "", "enabled", "LC7/r;", "setDebugInfoDialogEnabled", "(Z)V", "markGuiAgentInitialized", "", "TAG", "Ljava/lang/String;", "GUI_AGENT_FAILED_MESSAGE", "GUI_SUCCESS_MESSAGE", "", "DELAY_MS", "J", "guiAgentInitialized", "Z", "Lcom/stepos/taskrobot/llmapi/stepfun/Config$GuiExecutorMode;", "value", "guiExecutorMode", "Lcom/stepos/taskrobot/llmapi/stepfun/Config$GuiExecutorMode;", "getGuiExecutorMode", "()Lcom/stepos/taskrobot/llmapi/stepfun/Config$GuiExecutorMode;", "debugInfoDialogEnabled", "getDebugInfoDialogEnabled", "()Z", "StartType", "GuiExecutorMode", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Config {
    public static final long DELAY_MS = 1000;
    public static final String GUI_AGENT_FAILED_MESSAGE = "任务执行失败，gui agent不可用:1.已经执行的任务:";
    public static final String GUI_SUCCESS_MESSAGE = "任务执行成功:";
    private static final String TAG = "Config";
    private static volatile boolean debugInfoDialogEnabled;
    private static boolean guiAgentInitialized;
    public static final Config INSTANCE = new Config();
    private static GuiExecutorMode guiExecutorMode = GuiExecutorMode.SYSTEM;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/Config$GuiExecutorMode;", "", "storageValue", "", "displayName", AppAgent.CONSTRUCT, "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getStorageValue", "()Ljava/lang/String;", "getDisplayName", "ACCESSIBILITY", "SYSTEM", "Companion", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class GuiExecutorMode {
        private static final /* synthetic */ K7.a $ENTRIES;
        private static final /* synthetic */ GuiExecutorMode[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final String displayName;
        private final String storageValue;
        public static final GuiExecutorMode ACCESSIBILITY = new GuiExecutorMode("ACCESSIBILITY", 0, "accessibility", "无障碍模式");
        public static final GuiExecutorMode SYSTEM = new GuiExecutorMode("SYSTEM", 1, "system", "系统模式");

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/Config$GuiExecutorMode$Companion;", "", AppAgent.CONSTRUCT, "()V", "fromStorage", "Lcom/stepos/taskrobot/llmapi/stepfun/Config$GuiExecutorMode;", "storage", "", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
                this();
            }

            public final GuiExecutorMode fromStorage(String storage) {
                GuiExecutorMode guiExecutorMode;
                GuiExecutorMode[] guiExecutorModeArrValues = GuiExecutorMode.values();
                int length = guiExecutorModeArrValues.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        guiExecutorMode = null;
                        break;
                    }
                    guiExecutorMode = guiExecutorModeArrValues[i];
                    if (kotlin.jvm.internal.k.b(guiExecutorMode.getStorageValue(), storage)) {
                        break;
                    }
                    i++;
                }
                return guiExecutorMode == null ? GuiExecutorMode.SYSTEM : guiExecutorMode;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ GuiExecutorMode[] $values() {
            return new GuiExecutorMode[]{ACCESSIBILITY, SYSTEM};
        }

        static {
            GuiExecutorMode[] guiExecutorModeArr$values = $values();
            $VALUES = guiExecutorModeArr$values;
            $ENTRIES = kotlin.enums.a.a(guiExecutorModeArr$values);
            INSTANCE = new Companion(null);
        }

        private GuiExecutorMode(String str, int i, String str2, String str3) {
            this.storageValue = str2;
            this.displayName = str3;
        }

        public static K7.a getEntries() {
            return $ENTRIES;
        }

        public static GuiExecutorMode valueOf(String str) {
            return (GuiExecutorMode) Enum.valueOf(GuiExecutorMode.class, str);
        }

        public static GuiExecutorMode[] values() {
            return (GuiExecutorMode[]) $VALUES.clone();
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final String getStorageValue() {
            return this.storageValue;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/Config$StartType;", "", AppAgent.CONSTRUCT, "()V", "START_TYPE_NORMAL", "", "START_TYPE_VIRTUAL_SURFACE", "START_TYPE_VIRTUAL_BACKGROUND", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class StartType {
        public static final StartType INSTANCE = new StartType();
        public static final int START_TYPE_NORMAL = 0;
        public static final int START_TYPE_VIRTUAL_BACKGROUND = 2;
        public static final int START_TYPE_VIRTUAL_SURFACE = 1;

        private StartType() {
        }
    }

    private Config() {
    }

    public final boolean getDebugInfoDialogEnabled() {
        return debugInfoDialogEnabled;
    }

    public final GuiExecutorMode getGuiExecutorMode() {
        return guiExecutorMode;
    }

    public final void markGuiAgentInitialized() {
        guiAgentInitialized = true;
        N9.j.H("标记 GuiAgent 已初始化", TAG);
    }

    public final void setDebugInfoDialogEnabled(boolean enabled) {
        debugInfoDialogEnabled = enabled;
    }
}
