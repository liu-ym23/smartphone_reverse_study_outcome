package com.android.server.am;

import android.content.ComponentName;

/* JADX INFO: loaded from: classes.dex */
public final class HostingRecord {
    private static final int APP_ZYGOTE = 2;
    public static final String HOSTING_TYPE_ACTIVITY = "activity";
    public static final String HOSTING_TYPE_ADDED_APPLICATION = "added application";
    public static final String HOSTING_TYPE_BACKUP = "backup";
    public static final String HOSTING_TYPE_BROADCAST = "broadcast";
    public static final String HOSTING_TYPE_CONTENT_PROVIDER = "content provider";
    public static final String HOSTING_TYPE_EMPTY = "";
    public static final String HOSTING_TYPE_LINK_FAIL = "link fail";
    public static final String HOSTING_TYPE_NEXT_ACTIVITY = "next-activity";
    public static final String HOSTING_TYPE_NEXT_TOP_ACTIVITY = "next-top-activity";
    public static final String HOSTING_TYPE_ON_HOLD = "on-hold";
    public static final String HOSTING_TYPE_RESTART = "restart";
    public static final String HOSTING_TYPE_SERVICE = "service";
    public static final String HOSTING_TYPE_SYSTEM = "system";
    public static final String HOSTING_TYPE_TOP_ACTIVITY = "top-activity";
    private static final int REGULAR_ZYGOTE = 0;
    public static final String TRIGGER_TYPE_ALARM = "alarm";
    public static final String TRIGGER_TYPE_JOB = "job";
    public static final String TRIGGER_TYPE_PUSH_MESSAGE = "push_message";
    public static final String TRIGGER_TYPE_PUSH_MESSAGE_OVER_QUOTA = "push_message_over_quota";
    public static final String TRIGGER_TYPE_UNKNOWN = "unknown";
    private static final int WEBVIEW_ZYGOTE = 1;
    private final String mAction;
    private final String mDefiningPackageName;
    private final String mDefiningProcessName;
    private final int mDefiningUid;
    private final String mHostingName;
    private final String mHostingType;
    private final int mHostingZygote;
    private final boolean mIsTopApp;
    private final String mTriggerType;

    public HostingRecord(String hostingType) {
        this(hostingType, null, 0, null, -1, false, null, null, "unknown");
    }

    public HostingRecord(String hostingType, ComponentName hostingName) {
        this(hostingType, hostingName, 0);
    }

    public HostingRecord(String hostingType, ComponentName hostingName, String action, String triggerType) {
        this(hostingType, hostingName.toShortString(), 0, null, -1, false, null, action, triggerType);
    }

    public HostingRecord(String hostingType, ComponentName hostingName, String definingPackageName, int definingUid, String definingProcessName, String triggerType) {
        this(hostingType, hostingName.toShortString(), 0, definingPackageName, definingUid, false, definingProcessName, null, triggerType);
    }

    public HostingRecord(String hostingType, ComponentName hostingName, boolean isTopApp) {
        this(hostingType, hostingName.toShortString(), 0, null, -1, isTopApp, null, null, "unknown");
    }

    public HostingRecord(String hostingType, String hostingName) {
        this(hostingType, hostingName, 0);
    }

    private HostingRecord(String hostingType, ComponentName hostingName, int hostingZygote) {
        this(hostingType, hostingName.toShortString(), hostingZygote);
    }

    private HostingRecord(String hostingType, String hostingName, int hostingZygote) {
        this(hostingType, hostingName, hostingZygote, null, -1, false, null, null, "unknown");
    }

    private HostingRecord(String hostingType, String hostingName, int hostingZygote, String definingPackageName, int definingUid, boolean isTopApp, String definingProcessName, String action, String triggerType) {
        this.mHostingType = hostingType;
        this.mHostingName = hostingName;
        this.mHostingZygote = hostingZygote;
        this.mDefiningPackageName = definingPackageName;
        this.mDefiningUid = definingUid;
        this.mIsTopApp = isTopApp;
        this.mDefiningProcessName = definingProcessName;
        this.mAction = action;
        this.mTriggerType = triggerType;
    }

    public String getType() {
        return this.mHostingType;
    }

    public String getName() {
        return this.mHostingName;
    }

    public boolean isTopApp() {
        return this.mIsTopApp;
    }

    public int getDefiningUid() {
        return this.mDefiningUid;
    }

    public String getDefiningPackageName() {
        return this.mDefiningPackageName;
    }

    public String getDefiningProcessName() {
        return this.mDefiningProcessName;
    }

    public String getAction() {
        return this.mAction;
    }

    public String getTriggerType() {
        return this.mTriggerType;
    }

    public static HostingRecord byWebviewZygote(ComponentName hostingName, String definingPackageName, int definingUid, String definingProcessName) {
        return new HostingRecord("", hostingName.toShortString(), 1, definingPackageName, definingUid, false, definingProcessName, null, "unknown");
    }

    public static HostingRecord byAppZygote(ComponentName hostingName, String definingPackageName, int definingUid, String definingProcessName) {
        return new HostingRecord("", hostingName.toShortString(), 2, definingPackageName, definingUid, false, definingProcessName, null, "unknown");
    }

    public boolean usesAppZygote() {
        if (this.mHostingZygote != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean usesWebviewZygote() {
        if (this.mHostingZygote == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static int getHostingTypeIdStatsd(String hostingType) {
        switch(hostingType.hashCode()) {
            case -1726126969: goto L45;
            case -1682898044: goto L42;
            case -1655966961: goto L39;
            case -1618876223: goto L36;
            case -1526161119: goto L33;
            case -1396673086: goto L30;
            case -1372333075: goto L27;
            case -1355707223: goto L24;
            case -887328209: goto L21;
            case 0: goto L18;
            case 1097506319: goto L15;
            case 1418439096: goto L12;
            case 1637159472: goto L9;
            case 1984153269: goto L6;
            default: goto L47;
        };
    L47:
        byte r0 = -1;
    L48:
        switch(r0) {
            case 0: goto L64;
            case 1: goto L63;
            case 2: goto L62;
            case 3: goto L61;
            case 4: goto L60;
            case 5: goto L59;
            case 6: goto L58;
            case 7: goto L57;
            case 8: goto L56;
            case 9: goto L55;
            case 10: goto L54;
            case 11: goto L53;
            case 12: goto L52;
            case 13: goto L50;
            default: goto L49;
        };
    L49:
        return 0;
    L50:
        return 14;
    L52:
        return 13;
    L53:
        return 12;
    L54:
        return 11;
    L55:
        return 10;
    L56:
        return 9;
    L57:
        return 8;
    L58:
        return 7;
    L59:
        return 6;
    L60:
        return 5;
    L61:
        return 4;
    L62:
        return 3;
    L63:
        return 2;
    L64:
        return 1;
    L6:
        if (hostingType.equals(HOSTING_TYPE_SERVICE) == false) goto L47;
        r0 = 10;
        goto L48
    L9:
        if (hostingType.equals(HOSTING_TYPE_ADDED_APPLICATION) == false) goto L47;
        r0 = 1;
        goto L48
    L12:
        if (hostingType.equals(HOSTING_TYPE_CONTENT_PROVIDER) == false) goto L47;
        r0 = 4;
        goto L48
    L15:
        if (hostingType.equals(HOSTING_TYPE_RESTART) == false) goto L47;
        r0 = 9;
        goto L48
    L18:
        if (hostingType.equals("") == false) goto L47;
        r0 = 13;
        goto L48
    L21:
        if (hostingType.equals("system") == false) goto L47;
        r0 = 11;
        goto L48
    L24:
        if (hostingType.equals(HOSTING_TYPE_NEXT_ACTIVITY) == false) goto L47;
        r0 = 7;
        goto L48
    L27:
        if (hostingType.equals(HOSTING_TYPE_ON_HOLD) == false) goto L47;
        r0 = 6;
        goto L48
    L30:
        if (hostingType.equals(HOSTING_TYPE_BACKUP) == false) goto L47;
        r0 = 2;
        goto L48
    L33:
        if (hostingType.equals(HOSTING_TYPE_NEXT_TOP_ACTIVITY) == false) goto L47;
        r0 = 8;
        goto L48
    L36:
        if (hostingType.equals("broadcast") == false) goto L47;
        r0 = 3;
        goto L48
    L39:
        if (hostingType.equals(HOSTING_TYPE_ACTIVITY) == false) goto L47;
        r0 = 0;
        goto L48
    L42:
        if (hostingType.equals(HOSTING_TYPE_LINK_FAIL) == false) goto L47;
        r0 = 5;
        goto L48
    L45:
        if (hostingType.equals(HOSTING_TYPE_TOP_ACTIVITY) == false) goto L47;
        r0 = 12;
        goto L48
    }

    public static int getTriggerTypeForStatsd(String triggerType) {
        switch(triggerType.hashCode()) {
            case -2000959542: goto L15;
            case 105405: goto L12;
            case 92895825: goto L9;
            case 679713762: goto L6;
            default: goto L17;
        };
    L17:
        byte r0 = -1;
    L18:
        switch(r0) {
            case 0: goto L24;
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L20;
            default: goto L19;
        };
    L19:
        return 0;
    L20:
        return 4;
    L22:
        return 3;
    L23:
        return 2;
    L24:
        return 1;
    L6:
        if (triggerType.equals(TRIGGER_TYPE_PUSH_MESSAGE) == false) goto L17;
        r0 = 1;
        goto L18
    L9:
        if (triggerType.equals(TRIGGER_TYPE_ALARM) == false) goto L17;
        r0 = 0;
        goto L18
    L12:
        if (triggerType.equals(TRIGGER_TYPE_JOB) == false) goto L17;
        r0 = 3;
        goto L18
    L15:
        if (triggerType.equals(TRIGGER_TYPE_PUSH_MESSAGE_OVER_QUOTA) == false) goto L17;
        r0 = 2;
        goto L18
    }

    private static boolean isTypeActivity(String hostingType) {
        if (HOSTING_TYPE_ACTIVITY.equals(hostingType) == false) goto L5;
    L12:
        return true;
    L5:
        if (HOSTING_TYPE_NEXT_ACTIVITY.equals(hostingType) == true) goto L12;
        if (HOSTING_TYPE_NEXT_TOP_ACTIVITY.equals(hostingType) == true) goto L12;
        if (HOSTING_TYPE_TOP_ACTIVITY.equals(hostingType) == true) goto L12;
        return false;
    }

    public boolean isTypeActivity() {
        return isTypeActivity(this.mHostingType);
    }
}
