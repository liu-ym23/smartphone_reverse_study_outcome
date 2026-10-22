package com.ss.android.socialbase.downloader.constants;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final enum ListenerType extends Enum<ListenerType> {
    private static final /* synthetic */ ListenerType[] $VALUES = null;
    public static final ListenerType MAIN = null;
    public static final ListenerType NONE = null;
    public static final ListenerType NOTIFICATION = null;
    public static final ListenerType SUB = null;

    private ListenerType(String r1, int r2) {
        super(r1, r2);
    }

    public static ListenerType valueOf(String r2) {
        return (ListenerType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ListenerType.class, r2), ListenerType.class, "com.obric.aiagent.plugin");
    }

    public static ListenerType[] values() {
        return (ListenerType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ListenerType[].class, "com.obric.aiagent.plugin");
    }

    static {
        ListenerType r0 = new ListenerType("MAIN", 0);
        MAIN = r0;
        ListenerType r1 = new ListenerType("SUB", 1);
        SUB = r1;
        ListenerType r3 = new ListenerType("NOTIFICATION", 2);
        NOTIFICATION = r3;
        ListenerType r5 = new ListenerType("NONE", 3);
        NONE = r5;
        $VALUES = new ListenerType[]{r0, r1, r3, r5};
    }
}
