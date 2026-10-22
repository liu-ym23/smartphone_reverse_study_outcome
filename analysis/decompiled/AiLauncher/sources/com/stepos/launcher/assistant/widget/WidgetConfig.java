package com.stepos.launcher.assistant.widget;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.function.Consumer;

/* loaded from: classes.dex */
public class WidgetConfig implements WidgetMetaDataParse {
    private static final int CONFIG_FLAG_ASSISTANT_FILTER = 1;
    private static final int CONFIG_FLAG_BLUR_BG = 16;
    private static final int CONFIG_FLAG_HIDE_TITLE = 4;
    private static final int CONFIG_FLAG_HOME_FILTER = 2;
    private static final int CONFIG_FLAG_MOTION_GLASS = 256;
    private static final int CONFIG_FLAG_NONE = 0;
    private static final int CONFIG_FLAG_NO_ALIGN = 8;
    private static final int CONFIG_FLAG_PREVIEW_NO_PADDING = 32;
    private static final int CONFIG_STEPOS_ALIGN = 64;
    private static final int CONFIG_THIRD_PARTY_WIDGET_ALIGN = 128;
    private static final String KEY_WIDGET_CONFIG = "stepos.widget.config";
    private static final String VALUE_ASSISTANT_FILTER = "assistantfilter";
    private static final String VALUE_BLUR_BG = "blurBg";
    private static final String VALUE_HIDE_TITLE = "hidetitle";
    private static final String VALUE_HOME_FILTER = "homefilter";
    private static final String VALUE_MOTION_GLASS = "motionGlass";
    private static final String VALUE_NO_ALIGN = "noAlign";
    private static final String VALUE_PREVIEW_NO_PADDING = "previewNoPadding";
    private static final String VALUE_STEPOS_ALIGN = "steposAlign";
    private static final String VALUE_THIRD_PARTY_WIDGET_ALIGN = "align";
    private int mWidgetConfigFlags = 0;
    private String mWidgetConfigText;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleMetaValue$0(String str) {
        str.getClass();
        switch (str) {
            case "previewNoPadding":
                this.mWidgetConfigFlags |= 32;
                break;
            case "blurBg":
                this.mWidgetConfigFlags |= 16;
                break;
            case "motionGlass":
                this.mWidgetConfigFlags |= 256;
                break;
            case "assistantfilter":
                this.mWidgetConfigFlags |= 1;
                break;
            case "align":
                this.mWidgetConfigFlags |= 128;
                break;
            case "hidetitle":
                this.mWidgetConfigFlags |= 4;
                break;
            case "steposAlign":
                this.mWidgetConfigFlags |= 64;
                break;
            case "homefilter":
                this.mWidgetConfigFlags |= 2;
                break;
            case "noAlign":
                this.mWidgetConfigFlags |= 8;
                break;
        }
    }

    @Override // com.stepos.launcher.assistant.widget.WidgetMetaDataParse
    public String getMetaKey() {
        return KEY_WIDGET_CONFIG;
    }

    public String getWidgetConfigText() {
        return this.mWidgetConfigText;
    }

    @Override // com.stepos.launcher.assistant.widget.WidgetMetaDataParse
    public void handleMetaValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mWidgetConfigText = str;
        Arrays.asList(str.split("\\|")).forEach(new Consumer() { // from class: com.stepos.launcher.assistant.widget.c
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f30171a.lambda$handleMetaValue$0((String) obj);
            }
        });
    }

    public boolean isAssistantFilter() {
        return (this.mWidgetConfigFlags & 1) != 0;
    }

    public boolean isBlurBg() {
        return (this.mWidgetConfigFlags & 16) != 0;
    }

    public boolean isHideTitle() {
        return (this.mWidgetConfigFlags & 4) != 0;
    }

    public boolean isHomeFilter() {
        return (this.mWidgetConfigFlags & 2) != 0;
    }

    public boolean isMotionGlass() {
        return (this.mWidgetConfigFlags & 256) != 0;
    }

    public boolean isNoAlign() {
        return (this.mWidgetConfigFlags & 8) != 0;
    }

    public boolean isPreviewNoPadding() {
        return (this.mWidgetConfigFlags & 32) != 0;
    }

    public boolean isStepOSAlign() {
        return (this.mWidgetConfigFlags & 64) != 0;
    }

    public boolean isThirdPartyAlign() {
        return (this.mWidgetConfigFlags & 128) != 0;
    }
}
