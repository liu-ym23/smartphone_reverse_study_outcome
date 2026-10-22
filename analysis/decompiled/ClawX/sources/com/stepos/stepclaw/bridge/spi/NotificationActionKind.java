package com.stepos.stepclaw.bridge.spi;

import com.stepos.stepclaw.SecurePrefs;
import i5.a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/bridge/spi/NotificationActionKind;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;I)V", "Open", "Dismiss", "Reply", "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NotificationActionKind {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ NotificationActionKind[] $VALUES;
    public static final NotificationActionKind Open = new NotificationActionKind("Open", 0);
    public static final NotificationActionKind Dismiss = new NotificationActionKind("Dismiss", 1);
    public static final NotificationActionKind Reply = new NotificationActionKind("Reply", 2);

    private static final /* synthetic */ NotificationActionKind[] $values() {
        return new NotificationActionKind[]{Open, Dismiss, Reply};
    }

    static {
        NotificationActionKind[] notificationActionKindArr$values = $values();
        $VALUES = notificationActionKindArr$values;
        $ENTRIES = a.a.F(notificationActionKindArr$values);
    }

    private NotificationActionKind(String str, int i8) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static NotificationActionKind valueOf(String str) {
        return (NotificationActionKind) Enum.valueOf(NotificationActionKind.class, str);
    }

    public static NotificationActionKind[] values() {
        return (NotificationActionKind[]) $VALUES.clone();
    }
}
