package com.stepos.stepclaw.base.util;

import com.stepos.stepclaw.SecurePrefs;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import x5.n;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/stepos/stepclaw/base/util/LocationMode;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "rawValue", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "Off", "WhileUsing", "Always", "Companion", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LocationMode {
    private static final /* synthetic */ i5.a $ENTRIES;
    private static final /* synthetic */ LocationMode[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String rawValue;
    public static final LocationMode Off = new LocationMode("Off", 0, "off");
    public static final LocationMode WhileUsing = new LocationMode("WhileUsing", 1, "whileUsing");
    public static final LocationMode Always = new LocationMode("Always", 2, "always");

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/stepclaw/base/util/LocationMode$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "fromRawValue", "Lcom/stepos/stepclaw/base/util/LocationMode;", "raw", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final LocationMode fromRawValue(String raw) {
            String lowerCase;
            String string;
            Object obj = null;
            if (raw == null || (string = n.T1(raw).toString()) == null) {
                lowerCase = null;
            } else {
                lowerCase = string.toLowerCase(Locale.ROOT);
                p.d(lowerCase, "toLowerCase(...)");
            }
            Iterator<E> it = LocationMode.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                String lowerCase2 = ((LocationMode) next).getRawValue().toLowerCase(Locale.ROOT);
                p.d(lowerCase2, "toLowerCase(...)");
                if (lowerCase2.equals(lowerCase)) {
                    obj = next;
                    break;
                }
            }
            LocationMode locationMode = (LocationMode) obj;
            return locationMode == null ? LocationMode.Off : locationMode;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ LocationMode[] $values() {
        return new LocationMode[]{Off, WhileUsing, Always};
    }

    static {
        LocationMode[] locationModeArr$values = $values();
        $VALUES = locationModeArr$values;
        $ENTRIES = a.a.F(locationModeArr$values);
        INSTANCE = new Companion(null);
    }

    private LocationMode(String str, int i8, String str2) {
        this.rawValue = str2;
    }

    public static i5.a getEntries() {
        return $ENTRIES;
    }

    public static LocationMode valueOf(String str) {
        return (LocationMode) Enum.valueOf(LocationMode.class, str);
    }

    public static LocationMode[] values() {
        return (LocationMode[]) $VALUES.clone();
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}
