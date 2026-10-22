package com.android.server.credentials.metrics;

import android.util.Slog;
import com.android.server.credentials.ProviderCreateSession;
import com.android.server.credentials.ProviderGetSession;
import java.util.AbstractMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final enum EntryEnum extends Enum<EntryEnum> {
    private static final /* synthetic */ EntryEnum[] $VALUES = null;
    public static final EntryEnum ACTION_ENTRY = null;
    public static final EntryEnum AUTHENTICATION_ENTRY = null;
    public static final EntryEnum CREDENTIAL_ENTRY = null;
    public static final EntryEnum REMOTE_ENTRY = null;
    private static final String TAG = "EntryEnum";
    public static final EntryEnum UNKNOWN = null;
    private static final Map<String, Integer> sKeyToEntryCode = null;
    private final int mInnerMetricCode;

    private static /* synthetic */ EntryEnum[] $values() {
        return new EntryEnum[]{UNKNOWN, ACTION_ENTRY, CREDENTIAL_ENTRY, REMOTE_ENTRY, AUTHENTICATION_ENTRY};
    }

    public static EntryEnum valueOf(String name) {
        return (EntryEnum) Enum.valueOf(EntryEnum.class, name);
    }

    public static EntryEnum[] values() {
        return (EntryEnum[]) $VALUES.clone();
    }

    static {
        UNKNOWN = new EntryEnum("UNKNOWN", 0, 0);
        ACTION_ENTRY = new EntryEnum("ACTION_ENTRY", 1, 1);
        CREDENTIAL_ENTRY = new EntryEnum("CREDENTIAL_ENTRY", 2, 2);
        REMOTE_ENTRY = new EntryEnum("REMOTE_ENTRY", 3, 3);
        AUTHENTICATION_ENTRY = new EntryEnum("AUTHENTICATION_ENTRY", 4, 4);
        $VALUES = $values();
        sKeyToEntryCode = Map.ofEntries(new Map.Entry[]{new AbstractMap.SimpleEntry(ProviderGetSession.ACTION_ENTRY_KEY, Integer.valueOf(ACTION_ENTRY.mInnerMetricCode)), new AbstractMap.SimpleEntry(ProviderGetSession.AUTHENTICATION_ACTION_ENTRY_KEY, Integer.valueOf(AUTHENTICATION_ENTRY.mInnerMetricCode)), new AbstractMap.SimpleEntry(ProviderGetSession.REMOTE_ENTRY_KEY, Integer.valueOf(REMOTE_ENTRY.mInnerMetricCode)), new AbstractMap.SimpleEntry(ProviderGetSession.CREDENTIAL_ENTRY_KEY, Integer.valueOf(CREDENTIAL_ENTRY.mInnerMetricCode)), new AbstractMap.SimpleEntry(ProviderCreateSession.SAVE_ENTRY_KEY, Integer.valueOf(CREDENTIAL_ENTRY.mInnerMetricCode))});
    }

    private EntryEnum(String r1, int r2, int innerMetricCode) {
        super(r1, r2);
        this.mInnerMetricCode = innerMetricCode;
    }

    public int getMetricCode() {
        return this.mInnerMetricCode;
    }

    public static int getMetricCodeFromString(String stringKey) {
        if (sKeyToEntryCode.containsKey(stringKey) == true) goto L7;
        Slog.i(TAG, "Attempted to use an unsupported string key entry type");
        return UNKNOWN.mInnerMetricCode;
    L7:
        return sKeyToEntryCode.get(stringKey).intValue();
    }
}
