package com.stepos.launcher.assistant.widget;

/* loaded from: classes.dex */
public class WidgetModule implements WidgetMetaDataParse {
    private static final String KEY_LAUNCHER_MODULE = "launcher.module";
    private String mModule;

    @Override // com.stepos.launcher.assistant.widget.WidgetMetaDataParse
    public String getMetaKey() {
        return KEY_LAUNCHER_MODULE;
    }

    public String getModule() {
        return this.mModule;
    }

    @Override // com.stepos.launcher.assistant.widget.WidgetMetaDataParse
    public void handleMetaValue(String str) {
        this.mModule = str;
    }
}
