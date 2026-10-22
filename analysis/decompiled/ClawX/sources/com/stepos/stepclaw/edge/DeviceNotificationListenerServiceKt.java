package com.stepos.stepclaw.edge;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"MAX_NOTIFICATION_TEXT_CHARS", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "sanitizeNotificationText", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "value", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "actionRequiresClearableNotification", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ExtensionCallContract.KIND, "Lcom/stepos/stepclaw/edge/NotificationActionKind;", "step-edge_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DeviceNotificationListenerServiceKt {
    private static final int MAX_NOTIFICATION_TEXT_CHARS = 512;

    public static final boolean actionRequiresClearableNotification(NotificationActionKind kind) {
        p.e(kind, "kind");
        return kind == NotificationActionKind.Dismiss;
    }

    public static final String sanitizeNotificationText(CharSequence charSequence) {
        String string;
        String string2 = (charSequence == null || (string = charSequence.toString()) == null) ? null : n.T1(string).toString();
        if (string2 == null) {
            string2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        String strQ1 = n.Q1(512, string2);
        if (strQ1.length() == 0) {
            return null;
        }
        return strQ1;
    }
}
