package com.android.server.inputmethod;

import android.app.ActivityThread;
import android.provider.DeviceConfig;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class InputMethodDeviceConfigs {
    private final DeviceConfig.OnPropertiesChangedListener mDeviceConfigChangedListener;
    private boolean mHideImeWhenNoEditorFocus;

    public static /* synthetic */ void $r8$lambda$PrJOLZgjH4NGjzuxmBc1sU0a3KE(InputMethodDeviceConfigs r0, DeviceConfig.Properties r1) {
        r0.lambda$new$0(r1);
    }

    InputMethodDeviceConfigs() {
        this.mDeviceConfigChangedListener = new InputMethodDeviceConfigs$$ExternalSyntheticLambda0(this);
        this.mHideImeWhenNoEditorFocus = DeviceConfig.getBoolean("input_method_manager", "hide_ime_when_no_editor_focus", true);
        DeviceConfig.addOnPropertiesChangedListener("input_method_manager", ActivityThread.currentApplication().getMainExecutor(), this.mDeviceConfigChangedListener);
    }

    private /* synthetic */ void lambda$new$0(DeviceConfig.Properties properties) {
        if ("input_method_manager".equals(properties.getNamespace()) == true) goto L5;
        return;
    L5:
        Iterator r0 = properties.getKeyset().iterator();
    L7:
        if (r0.hasNext() == false) goto L16;
        String name = (String) r0.next();
        if ("hide_ime_when_no_editor_focus".equals(name) == false) goto L7;
        this.mHideImeWhenNoEditorFocus = properties.getBoolean(name, true);
        return;
    }

    public boolean shouldHideImeWhenNoEditorFocus() {
        return this.mHideImeWhenNoEditorFocus;
    }

    void destroy() {
        DeviceConfig.removeOnPropertiesChangedListener(this.mDeviceConfigChangedListener);
    }
}
