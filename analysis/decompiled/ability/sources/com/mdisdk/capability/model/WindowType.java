package com.mdisdk.capability.model;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0005J\u000e\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0005J\u000e\u00108\u001a\u0002062\u0006\u00107\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/mdisdk/capability/model/WindowType;", "", AppAgent.CONSTRUCT, "()V", "BASE_APPLICATION", "", "APPLICATION", "APPLICATION_STARTING", "DRAWN_APPLICATION", "APPLICATION_PANEL", "APPLICATION_MEDIA", "APPLICATION_SUB_PANEL", "APPLICATION_ATTACHED_DIALOG", "APPLICATION_MEDIA_OVERLAY", "APPLICATION_ABOVE_SUB_PANEL", "STATUS_BAR", "SEARCH_BAR", "PHONE", "SYSTEM_ALERT", "KEYGUARD", "TOAST", "SYSTEM_OVERLAY", "PRIORITY_PHONE", "SYSTEM_DIALOG", "KEYGUARD_DIALOG", "SYSTEM_ERROR", "INPUT_METHOD", "INPUT_METHOD_DIALOG", "WALLPAPER", "STATUS_BAR_PANEL", "SECURE_SYSTEM_OVERLAY", "DRAG", "STATUS_BAR_SUB_PANEL", "POINTER", "NAVIGATION_BAR", "VOLUME_OVERLAY", "BOOT_PROGRESS", "INPUT_CONSUMER", "NAVIGATION_BAR_PANEL", "DISPLAY_OVERLAY", "MAGNIFICATION_OVERLAY", "ACCESSIBILITY_OVERLAY", "VOICE_INTERACTION_STARTING", "DOCK_DIVIDER", "QS_DIALOG", "SCREENSHOT", "PRESENTATION", "APPLICATION_OVERLAY", "ACCESSIBILITY_MAGNIFICATION_OVERLAY", "NOTIFICATION_SHADE", "STATUS_BAR_ADDITIONAL", "fromValue", "value", "isSystemWindow", "", "type", "isApplication", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WindowType {
    public static final int ACCESSIBILITY_MAGNIFICATION_OVERLAY = 2039;
    public static final int ACCESSIBILITY_OVERLAY = 2032;
    public static final int APPLICATION = 2;
    public static final int APPLICATION_ABOVE_SUB_PANEL = 1005;
    public static final int APPLICATION_ATTACHED_DIALOG = 1003;
    public static final int APPLICATION_MEDIA = 1001;
    public static final int APPLICATION_MEDIA_OVERLAY = 1004;
    public static final int APPLICATION_OVERLAY = 2038;
    public static final int APPLICATION_PANEL = 1000;
    public static final int APPLICATION_STARTING = 3;
    public static final int APPLICATION_SUB_PANEL = 1002;
    public static final int BASE_APPLICATION = 1;
    public static final int BOOT_PROGRESS = 2021;
    public static final int DISPLAY_OVERLAY = 2026;
    public static final int DOCK_DIVIDER = 2034;
    public static final int DRAG = 2016;
    public static final int DRAWN_APPLICATION = 4;
    public static final int INPUT_CONSUMER = 2022;
    public static final int INPUT_METHOD = 2011;
    public static final int INPUT_METHOD_DIALOG = 2012;
    public static final WindowType INSTANCE = new WindowType();
    public static final int KEYGUARD = 2004;
    public static final int KEYGUARD_DIALOG = 2009;
    public static final int MAGNIFICATION_OVERLAY = 2027;
    public static final int NAVIGATION_BAR = 2019;
    public static final int NAVIGATION_BAR_PANEL = 2024;
    public static final int NOTIFICATION_SHADE = 2040;
    public static final int PHONE = 2002;
    public static final int POINTER = 2018;
    public static final int PRESENTATION = 2037;
    public static final int PRIORITY_PHONE = 2007;
    public static final int QS_DIALOG = 2035;
    public static final int SCREENSHOT = 2036;
    public static final int SEARCH_BAR = 2001;
    public static final int SECURE_SYSTEM_OVERLAY = 2015;
    public static final int STATUS_BAR = 2000;
    public static final int STATUS_BAR_ADDITIONAL = 2041;
    public static final int STATUS_BAR_PANEL = 2014;
    public static final int STATUS_BAR_SUB_PANEL = 2017;
    public static final int SYSTEM_ALERT = 2003;
    public static final int SYSTEM_DIALOG = 2008;
    public static final int SYSTEM_ERROR = 2010;
    public static final int SYSTEM_OVERLAY = 2006;
    public static final int TOAST = 2005;
    public static final int VOICE_INTERACTION_STARTING = 2033;
    public static final int VOLUME_OVERLAY = 2020;
    public static final int WALLPAPER = 2013;

    private WindowType() {
    }

    public final int fromValue(int value) {
        if (1 <= value && value < 100) {
            return value;
        }
        if (1000 <= value && value < 2000) {
            return value;
        }
        if (2000 > value || value >= 3000) {
            return 1;
        }
        return value;
    }

    public final boolean isApplication(int type) {
        return type == 2;
    }

    public final boolean isSystemWindow(int type) {
        return type >= 2000;
    }
}
