package com.obric.capabilitykit.entity.memory;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryProductType {
    public static final int ACTIVE_MEMORY = 1;
    public static final int AI_ACTIVE_MEMORY = 11;
    public static final int AUDITORY_RECORDING_MEMORY = 12;
    public static final int CAMERA_POSTVIEW_ACTIVE_MEMORY = 18;
    public static final int CAMERA_VIEWFINDER_ACTIVE_MEMORY = 17;
    public static final int DIALOG_ACTIVE_MEMORY = 3;
    public static final int DIALOG_AUTO_MEMORY = 4;
    public static final int FIRST_PARTY_AUTO_MEMORY = 6;
    public static final int GALLERY_DOCUMENT_ACTIVE_MEMORY = 16;
    public static final int GALLERY_SCREENSHOT_ACTIVE_MEMORY = 19;
    public static final int GALLERY_SINGLE_ACTIVE_MEMORY = 15;
    public static final int GLASSES_ACTIVE_MEMORY = 20;
    public static final MemoryProductType INSTANCE = null;
    public static final int KEYBOARD_SHORTCUT_ACTIVE_MEMORY = 10;
    public static final int OMNI_ACTIVE_MEMORY = 21;
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
