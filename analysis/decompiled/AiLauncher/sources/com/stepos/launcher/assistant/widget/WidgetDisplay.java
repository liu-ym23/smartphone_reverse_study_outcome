package com.stepos.launcher.assistant.widget;

import android.text.TextUtils;
import com.stepos.launcher.assistant.widget.WidgetDisplay;
import java.util.Arrays;
import java.util.function.Predicate;

/* loaded from: classes.dex */
public class WidgetDisplay implements WidgetMetaDataParse {
    public static final String KEY_WIDGET_DISPLAY = "widget.display";
    private Display mDisplay = Display.PHONE;
    private String mDisplayText;

    public enum Display {
        PHONE,
        CAR,
        SUB
    }

    private static Display getWidgetDisplay(final String str) {
        return (Display) Arrays.stream(Display.values()).filter(new Predicate() { // from class: com.stepos.launcher.assistant.widget.d
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((WidgetDisplay.Display) obj).name().equals(str.toUpperCase());
            }
        }).findFirst().orElse(Display.PHONE);
    }

    public String getDisplayText() {
        return this.mDisplayText;
    }

    @Override // com.stepos.launcher.assistant.widget.WidgetMetaDataParse
    public String getMetaKey() {
        return KEY_WIDGET_DISPLAY;
    }

    @Override // com.stepos.launcher.assistant.widget.WidgetMetaDataParse
    public void handleMetaValue(String str) {
        this.mDisplayText = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mDisplay = getWidgetDisplay(this.mDisplayText);
    }

    public boolean isCarWidget() {
        return this.mDisplay == Display.CAR;
    }

    public boolean isPhoneWidget() {
        return this.mDisplay == Display.PHONE;
    }

    public boolean isSubWidget() {
        return this.mDisplay == Display.SUB;
    }
}
