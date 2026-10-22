package com.obric.security.guard;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final enum ObricSettingsEvent extends Enum<ObricSettingsEvent> {
    private static final /* synthetic */ ObricSettingsEvent[] $VALUES = null;
    public static final ObricSettingsEvent EVENT_TYPE_ALBUM_DELETE = null;
    public static final ObricSettingsEvent EVENT_TYPE_APP_DATA_CLEAR = null;
    public static final ObricSettingsEvent EVENT_TYPE_CALENDAR_DELETE = null;
    public static final ObricSettingsEvent EVENT_TYPE_CALL_LOGS_DELETE = null;
    public static final ObricSettingsEvent EVENT_TYPE_CLOSE_EARTHQUAKE_WARNING = null;
    public static final ObricSettingsEvent EVENT_TYPE_CLOSE_WEBPAGE_WARNING = null;
    public static final ObricSettingsEvent EVENT_TYPE_CONTACT_DELETE = null;
    public static final ObricSettingsEvent EVENT_TYPE_DELETE_FACE = null;
    public static final ObricSettingsEvent EVENT_TYPE_DELETE_FINGERPRINT = null;
    public static final ObricSettingsEvent EVENT_TYPE_DELETE_PASSWORD = null;
    public static final ObricSettingsEvent EVENT_TYPE_FILE_DELETE = null;
    public static final ObricSettingsEvent EVENT_TYPE_INSTALL_UNKNOWN_APP = null;
    public static final ObricSettingsEvent EVENT_TYPE_JUNK_CLEAR = null;
    public static final ObricSettingsEvent EVENT_TYPE_NOTES_DELETE = null;
    public static final ObricSettingsEvent EVENT_TYPE_PHOTO_DELETE = null;
    public static final ObricSettingsEvent EVENT_TYPE_REBOOT = null;
    public static final ObricSettingsEvent EVENT_TYPE_RECORDING_DELETE = null;
    public static final ObricSettingsEvent EVENT_TYPE_RESTORE_FACTORY = null;
    public static final ObricSettingsEvent EVENT_TYPE_SHUTDOWN = null;
    public static final ObricSettingsEvent EVENT_TYPE_SMS_DELETE = null;
    public static final ObricSettingsEvent EVENT_TYPE_STORY_DELETE = null;
    public static final ObricSettingsEvent EVENT_TYPE_UNINSTALL_APP = null;
    public static final ObricSettingsEvent EVENT_TYPE_VAULT_DELETE = null;
    private static final Set<Integer> VALID_TYPES = null;
    private final int type;

    private static /* synthetic */ ObricSettingsEvent[] $values() {
        return new ObricSettingsEvent[]{EVENT_TYPE_SMS_DELETE, EVENT_TYPE_CONTACT_DELETE, EVENT_TYPE_CALL_LOGS_DELETE, EVENT_TYPE_FILE_DELETE, EVENT_TYPE_NOTES_DELETE, EVENT_TYPE_PHOTO_DELETE, EVENT_TYPE_STORY_DELETE, EVENT_TYPE_VAULT_DELETE, EVENT_TYPE_RECORDING_DELETE, EVENT_TYPE_CALENDAR_DELETE, EVENT_TYPE_ALBUM_DELETE, EVENT_TYPE_APP_DATA_CLEAR, EVENT_TYPE_JUNK_CLEAR, EVENT_TYPE_DELETE_PASSWORD, EVENT_TYPE_DELETE_FINGERPRINT, EVENT_TYPE_DELETE_FACE, EVENT_TYPE_RESTORE_FACTORY, EVENT_TYPE_UNINSTALL_APP, EVENT_TYPE_REBOOT, EVENT_TYPE_SHUTDOWN, EVENT_TYPE_INSTALL_UNKNOWN_APP, EVENT_TYPE_CLOSE_EARTHQUAKE_WARNING, EVENT_TYPE_CLOSE_WEBPAGE_WARNING};
    }

    public static ObricSettingsEvent valueOf(String r2) {
        return (ObricSettingsEvent) ZeusTransformUtils.preCheckCast(Enum.valueOf(ObricSettingsEvent.class, r2), ObricSettingsEvent.class, "com.obric.aiagent.plugin");
    }

    public static ObricSettingsEvent[] values() {
        return (ObricSettingsEvent[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ObricSettingsEvent[].class, "com.obric.aiagent.plugin");
    }

    static {
        int r2 = 0;
        EVENT_TYPE_SMS_DELETE = new ObricSettingsEvent("EVENT_TYPE_SMS_DELETE", 0, 1);
        EVENT_TYPE_CONTACT_DELETE = new ObricSettingsEvent("EVENT_TYPE_CONTACT_DELETE", 1, 2);
        EVENT_TYPE_CALL_LOGS_DELETE = new ObricSettingsEvent("EVENT_TYPE_CALL_LOGS_DELETE", 2, 3);
        EVENT_TYPE_FILE_DELETE = new ObricSettingsEvent("EVENT_TYPE_FILE_DELETE", 3, 4);
        EVENT_TYPE_NOTES_DELETE = new ObricSettingsEvent("EVENT_TYPE_NOTES_DELETE", 4, 5);
        EVENT_TYPE_PHOTO_DELETE = new ObricSettingsEvent("EVENT_TYPE_PHOTO_DELETE", 5, 6);
        EVENT_TYPE_STORY_DELETE = new ObricSettingsEvent("EVENT_TYPE_STORY_DELETE", 6, 7);
        EVENT_TYPE_VAULT_DELETE = new ObricSettingsEvent("EVENT_TYPE_VAULT_DELETE", 7, 8);
        EVENT_TYPE_RECORDING_DELETE = new ObricSettingsEvent("EVENT_TYPE_RECORDING_DELETE", 8, 9);
        EVENT_TYPE_CALENDAR_DELETE = new ObricSettingsEvent("EVENT_TYPE_CALENDAR_DELETE", 9, 10);
        EVENT_TYPE_ALBUM_DELETE = new ObricSettingsEvent("EVENT_TYPE_ALBUM_DELETE", 10, 11);
        EVENT_TYPE_APP_DATA_CLEAR = new ObricSettingsEvent("EVENT_TYPE_APP_DATA_CLEAR", 11, 101);
        EVENT_TYPE_JUNK_CLEAR = new ObricSettingsEvent("EVENT_TYPE_JUNK_CLEAR", 12, 102);
        EVENT_TYPE_DELETE_PASSWORD = new ObricSettingsEvent("EVENT_TYPE_DELETE_PASSWORD", 13, 103);
        EVENT_TYPE_DELETE_FINGERPRINT = new ObricSettingsEvent("EVENT_TYPE_DELETE_FINGERPRINT", 14, 104);
        EVENT_TYPE_DELETE_FACE = new ObricSettingsEvent("EVENT_TYPE_DELETE_FACE", 15, 105);
        EVENT_TYPE_RESTORE_FACTORY = new ObricSettingsEvent("EVENT_TYPE_RESTORE_FACTORY", 16, 1001);
        EVENT_TYPE_UNINSTALL_APP = new ObricSettingsEvent("EVENT_TYPE_UNINSTALL_APP", 17, 1002);
        EVENT_TYPE_REBOOT = new ObricSettingsEvent("EVENT_TYPE_REBOOT", 18, 1003);
        EVENT_TYPE_SHUTDOWN = new ObricSettingsEvent("EVENT_TYPE_SHUTDOWN", 19, 1004);
        EVENT_TYPE_INSTALL_UNKNOWN_APP = new ObricSettingsEvent("EVENT_TYPE_INSTALL_UNKNOWN_APP", 20, 1005);
        EVENT_TYPE_CLOSE_EARTHQUAKE_WARNING = new ObricSettingsEvent("EVENT_TYPE_CLOSE_EARTHQUAKE_WARNING", 21, 10001);
        EVENT_TYPE_CLOSE_WEBPAGE_WARNING = new ObricSettingsEvent("EVENT_TYPE_CLOSE_WEBPAGE_WARNING", 22, 10002);
        $VALUES = $values();
        VALID_TYPES = new HashSet();
        ObricSettingsEvent[] r0 = values();
        int r1 = r0.length;
    L3:
        if (r2 >= r1) goto L5;
        ObricSettingsEvent r3 = r0[r2];
        VALID_TYPES.add(Integer.valueOf(r3.getType()));
        r2 = r2 + 1;
        goto L3
    }

    private ObricSettingsEvent(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }

    public int getType() {
        return this.type;
    }

    public static boolean isValid(int r1) {
        return VALID_TYPES.contains(Integer.valueOf(r1));
    }
}
