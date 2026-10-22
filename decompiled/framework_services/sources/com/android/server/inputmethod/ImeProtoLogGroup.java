package com.android.server.inputmethod;

import com.android.internal.protolog.common.IProtoLogGroup;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final enum ImeProtoLogGroup extends Enum<ImeProtoLogGroup> implements IProtoLogGroup {
    private static final /* synthetic */ ImeProtoLogGroup[] $VALUES = null;
    public static final ImeProtoLogGroup IME_VISIBILITY_APPLIER_DEBUG = null;
    public static final ImeProtoLogGroup IME_VIS_STATE_COMPUTER_DEBUG = null;
    public static final ImeProtoLogGroup IMMS_DEBUG = null;
    private final boolean mEnabled;
    private volatile boolean mLogToLogcat;
    private volatile boolean mLogToProto;
    private final String mTag;

    private static class Consts {
        private static final boolean ENABLE_DEBUG = true;
        private static final int START_ID = 0;

        /* JADX INFO: renamed from: -$$Nest$sfgetSTART_ID, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4641$$Nest$sfgetSTART_ID() {
            return START_ID;
        }

        private Consts() {
        }

        static {
            START_ID = (int) (UUID.nameUUIDFromBytes(ImeProtoLogGroup.class.getName().getBytes()).getMostSignificantBits() % 2147483647L);
        }
    }

    private static /* synthetic */ ImeProtoLogGroup[] $values() {
        return new ImeProtoLogGroup[]{IMMS_DEBUG, IME_VISIBILITY_APPLIER_DEBUG, IME_VIS_STATE_COMPUTER_DEBUG};
    }

    public static ImeProtoLogGroup valueOf(String name) {
        return (ImeProtoLogGroup) Enum.valueOf(ImeProtoLogGroup.class, name);
    }

    public static ImeProtoLogGroup[] values() {
        return (ImeProtoLogGroup[]) $VALUES.clone();
    }

    static {
        IMMS_DEBUG = new ImeProtoLogGroup("IMMS_DEBUG", 0, true, false, false, "InputMethodManagerService");
        IME_VISIBILITY_APPLIER_DEBUG = new ImeProtoLogGroup("IME_VISIBILITY_APPLIER_DEBUG", 1, true, false, false, "DefaultImeVisibilityApplier");
        IME_VIS_STATE_COMPUTER_DEBUG = new ImeProtoLogGroup("IME_VIS_STATE_COMPUTER_DEBUG", 2, true, false, false, "ImeVisibilityStateComputer");
        $VALUES = $values();
    }

    private ImeProtoLogGroup(String r1, int r2, boolean enabled, boolean logToProto, boolean logToLogcat, String tag) {
        super(r1, r2);
        this.mEnabled = enabled;
        this.mLogToProto = logToProto;
        this.mLogToLogcat = logToLogcat;
        this.mTag = tag;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public boolean isLogToProto() {
        return this.mLogToProto;
    }

    public boolean isLogToLogcat() {
        return this.mLogToLogcat;
    }

    public String getTag() {
        return this.mTag;
    }

    public int getId() {
        return Consts.m4641$$Nest$sfgetSTART_ID() + ordinal();
    }

    public void setLogToProto(boolean logToProto) {
        this.mLogToProto = logToProto;
    }

    public void setLogToLogcat(boolean logToLogcat) {
        this.mLogToLogcat = logToLogcat;
    }
}
