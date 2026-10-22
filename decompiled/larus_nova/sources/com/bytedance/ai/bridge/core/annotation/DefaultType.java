package com.bytedance.ai.bridge.core.annotation;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/bridge/core/annotation/DefaultType;", "", "<init>", "(Ljava/lang/String;I)V", "STRING", "DOUBLE", "INT", "LONG", "BOOL", UserProfileEvent.POSITION_NONE, "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DefaultType extends Enum<DefaultType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DefaultType[] $VALUES = null;
    public static final DefaultType BOOL = null;
    public static final DefaultType DOUBLE = null;
    public static final DefaultType INT = null;
    public static final DefaultType LONG = null;
    public static final DefaultType NONE = null;
    public static final DefaultType STRING = null;

    private static final /* synthetic */ DefaultType[] $values() {
        return new DefaultType[]{STRING, DOUBLE, INT, LONG, BOOL, NONE};
    }

    public static EnumEntries<DefaultType> getEntries() {
        return $ENTRIES;
    }

    static {
        STRING = new DefaultType("STRING", 0);
        DOUBLE = new DefaultType("DOUBLE", 1);
        INT = new DefaultType("INT", 2);
        LONG = new DefaultType("LONG", 3);
        BOOL = new DefaultType("BOOL", 4);
        NONE = new DefaultType(UserProfileEvent.POSITION_NONE, 5);
        DefaultType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static DefaultType[] values() {
        return (DefaultType[]) $VALUES.clone();
    }

    public static DefaultType valueOf(String r100) {
        return (DefaultType) a.a(DefaultType.class, r100);
    }

    private DefaultType(String r100, int r101) {
        super(r100, r101);
    }
}
