package com.android.server.wm;

/* JADX INFO: loaded from: classes3.dex */
public class ConfigurationContainerSysExFactory {
    public ConfigurationContainerSysExFactory() {
    }

    public static ConfigurationContainerSysEx createSmtEx(ConfigurationContainer container) {
        if ((container instanceof ActivityRecord) == false) goto L7;
        return new ActivityRecordSmtBase((ActivityRecord) container);
    L7:
        if ((container instanceof WindowState) == false) goto L11;
        return new WindowStateSmtBase((WindowState) container);
    L11:
        if ((container instanceof RootWindowContainer) == false) goto L15;
        return new RootWindowContainerSmtBase((RootWindowContainer) container);
    L15:
        if ((container instanceof WindowToken) == false) goto L19;
        return new WindowTokenSysEx((WindowToken) container);
    L19:
        if ((container instanceof WindowContainer) == false) goto L23;
        return new WindowContainerSysEx((WindowContainer) container);
    L23:
        if ((container instanceof WindowProcessController) == false) goto L27;
        return new WindowProcessControllerSmtBase((WindowProcessController) container);
    L27:
        return new ConfigurationContainerSysEx(container);
    }
}
