package com.obric.capabilitykit.entity.memory;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/MemoryProductType;", "", "()V", "ACTIVE_MEMORY", "", "AI_ACTIVE_MEMORY", "AUDITORY_RECORDING_MEMORY", "DIALOG_ACTIVE_MEMORY", "DIALOG_AUTO_MEMORY", "FIRST_PARTY_AUTO_MEMORY", "KEYBOARD_SHORTCUT_ACTIVE_MEMORY", "SCREENSHOT_ACTIVE_MEMORY", "SCREENSHOT_SCROLL_ACTIVE_MEMORY", "SHARE_ACTIVE_MEMORY", "SMART_MEMORY", "TEXT_MENU_ACTIVE_MEMORY", "THIRD_PARTY_AUTO_MEMORY", "THREE_FINGER_SWIPE_UP_ACTIVE_MEMORY", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MemoryProductType {
    public static final int ACTIVE_MEMORY = 1;
    public static final int AI_ACTIVE_MEMORY = 11;
    public static final int AUDITORY_RECORDING_MEMORY = 12;
    public static final int DIALOG_ACTIVE_MEMORY = 3;
    public static final int DIALOG_AUTO_MEMORY = 4;
    public static final int FIRST_PARTY_AUTO_MEMORY = 6;
    public static final MemoryProductType INSTANCE = null;
    public static final int KEYBOARD_SHORTCUT_ACTIVE_MEMORY = 10;
    public static final int SCREENSHOT_ACTIVE_MEMORY = 8;
    public static final int SCREENSHOT_SCROLL_ACTIVE_MEMORY = 13;
    public static final int SHARE_ACTIVE_MEMORY = 14;
    public static final int SMART_MEMORY = 2;
    public static final int TEXT_MENU_ACTIVE_MEMORY = 7;
    public static final int THIRD_PARTY_AUTO_MEMORY = 5;
    public static final int THREE_FINGER_SWIPE_UP_ACTIVE_MEMORY = 9;

    static {
        INSTANCE = new MemoryProductType();
    }

    private MemoryProductType() {
    }
}
