package com.android.server.notification;

import android.app.NotificationHistory;
import android.graphics.drawable.Icon;
import android.text.TextUtils;
import android.util.Slog;
import android.util.proto.ProtoInputStream;
import android.util.proto.ProtoOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class NotificationHistoryProtoHelper {
    private static final String TAG = "NotifHistoryProto";

    private NotificationHistoryProtoHelper() {
    }

    private static List<String> readStringPool(ProtoInputStream proto) throws IOException {
        long token = proto.start(1146756268033L);
        if (proto.nextField(1120986464257L) == false) goto L5;
        List<String> stringPool = new ArrayList(proto.readInt(1120986464257L));
    L7:
        if (proto.nextField() == (-1)) goto L13;
        switch(proto.getFieldNumber()) {
            case 2: goto L11;
            default: goto L7;
        };
    L11:
        stringPool.add(proto.readString(2237677961218L));
        goto L7
    L13:
        proto.end(token);
        return stringPool;
    L5:
        stringPool = new ArrayList();
        goto L7
    }

    private static void writeStringPool(ProtoOutputStream proto, NotificationHistory notifications) {
        long token = proto.start(1146756268033L);
        String[] pooledStrings = notifications.getPooledStringsToWrite();
        proto.write(1120986464257L, pooledStrings.length);
        int i = 0;
    L4:
        if (i >= pooledStrings.length) goto L6;
        proto.write(2237677961218L, pooledStrings[i]);
        i = i + 1;
        goto L4
    L6:
        proto.end(token);
    }

    private static void readNotification(ProtoInputStream proto, List<String> stringPool, NotificationHistory notifications, NotificationHistoryFilter filter) throws IOException {
        long token = proto.start(2246267895811L);
        NotificationHistory.HistoricalNotification notification = readNotification(proto, stringPool);     // Catch: Throwable -> L9 Exception -> L11
        if (filter.matchesPackageAndChannelFilter(notification) == true) goto L6;
    L14:
        proto.end(token);
        return;
    L6:
        if (filter.matchesCountFilter(notifications) == false) goto L14;
        notifications.addNotificationToWrite(notification);     // Catch: Throwable -> L9 Exception -> L11
    L11:
        e = move-exception;
        Slog.e(TAG, "Error reading notification", e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        proto.end(token);
        throw th;
    }

    private static NotificationHistory.HistoricalNotification readNotification(ProtoInputStream parser, List<String> stringPool) throws IOException {
        NotificationHistory.HistoricalNotification.Builder notification = new NotificationHistory.HistoricalNotification.Builder();
        String pkg = null;
    L4:
        switch(parser.nextField()) {
            case -1: goto L22;
            case 0: goto L4;
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            case 13: goto L7;
            case 14: goto L6;
            default: goto L4;
        };
    L6:
        notification.setConversationId(stringPool.get(parser.readInt(1120986464270L) - 1));
        goto L4
    L7:
        String conversationId = parser.readString(1138166333453L);
        notification.setConversationId(conversationId);
        stringPool.add(conversationId);
        goto L4
    L8:
        long iconToken = parser.start(1146756268044L);
        loadIcon(parser, notification, pkg);
        parser.end(iconToken);
        goto L4
    L9:
        notification.setText(parser.readString(1138166333451L));
        goto L4
    L10:
        notification.setTitle(parser.readString(1138166333450L));
        goto L4
    L11:
        notification.setPostedTimeMs(parser.readLong(1112396529673L));
        goto L4
    L12:
        notification.setUserId(parser.readInt(1120986464264L));
        goto L4
    L13:
        notification.setUid(parser.readInt(1120986464263L));
        goto L4
    L14:
        notification.setChannelId(stringPool.get(parser.readInt(1120986464262L) - 1));
        goto L4
    L15:
        String channelId = parser.readString(1138166333445L);
        notification.setChannelId(channelId);
        stringPool.add(channelId);
        goto L4
    L16:
        notification.setChannelName(stringPool.get(parser.readInt(1120986464260L) - 1));
        goto L4
    L17:
        String channelName = parser.readString(1138166333443L);
        notification.setChannelName(channelName);
        stringPool.add(channelName);
        goto L4
    L18:
        String pkg2 = stringPool.get(parser.readInt(1120986464258L) - 1);
        pkg = pkg2;
        notification.setPackage(pkg);
        goto L4
    L19:
        pkg = parser.readString(1138166333441L);
        notification.setPackage(pkg);
        stringPool.add(pkg);
        goto L4
    L22:
        return notification.build();
    }

    private static void loadIcon(ProtoInputStream parser, NotificationHistory.HistoricalNotification.Builder notification, String pkg) throws IOException {
        int iconType = 0;
        int imageResourceId = 0;
        String imageResourceIdPackage = null;
        byte[] imageByteData = null;
        int imageByteDataLength = 0;
        int imageByteDataOffset = 0;
        String imageUri = null;
    L4:
        switch(parser.nextField()) {
            case -1: goto L16;
            case 0: goto L4;
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L4;
        };
    L6:
        imageUri = parser.readString(1138166333448L);
        goto L4
    L7:
        imageByteDataOffset = parser.readInt(1120986464263L);
        goto L4
    L8:
        imageByteDataLength = parser.readInt(1120986464262L);
        goto L4
    L9:
        imageByteData = parser.readBytes(1151051235333L);
        goto L4
    L10:
        imageResourceIdPackage = parser.readString(1138166333444L);
        goto L4
    L11:
        imageResourceId = parser.readInt(1120986464259L);
        goto L4
    L12:
        parser.readString(1138166333442L);
        goto L4
    L13:
        iconType = parser.readInt(1159641169921L);
        goto L4
    L16:
        if (iconType != 3) goto L20;
        if (imageByteData == null) goto L31;
        notification.setIcon(Icon.createWithData(imageByteData, imageByteDataOffset, imageByteDataLength));
        return;
    L31:
        return;
    L20:
        if (iconType != 2) goto L27;
        if (imageResourceId == 0) goto L52;
        if (imageResourceIdPackage == null) goto L24;
        String r8 = imageResourceIdPackage;
    L25:
        notification.setIcon(Icon.createWithResource(r8, imageResourceId));
        return;
    L24:
        r8 = pkg;
        goto L25
    L52:
        return;
    L27:
        if (iconType != 4) goto L56;
        if (imageUri == null) goto L54;
        notification.setIcon(Icon.createWithContentUri(imageUri));
        return;
    L54:
        return;
    }

    private static void writeIcon(ProtoOutputStream proto, NotificationHistory.HistoricalNotification notification) {
        long token = proto.start(1146756268044L);
        proto.write(1159641169921L, notification.getIcon().getType());
        switch(notification.getIcon().getType()) {
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L5;
            default: goto L10;
        };
    L5:
        proto.write(1138166333448L, notification.getIcon().getUriString());
        goto L10
    L6:
        proto.write(1151051235333L, notification.getIcon().getDataBytes());
        proto.write(1120986464262L, notification.getIcon().getDataLength());
        proto.write(1120986464263L, notification.getIcon().getDataOffset());
        goto L10
    L7:
        proto.write(1120986464259L, notification.getIcon().getResId());
        if (notification.getPackage().equals(notification.getIcon().getResPackage()) == true) goto L10;
        proto.write(1138166333444L, notification.getIcon().getResPackage());
    L10:
        proto.end(token);
    }

    private static void writeNotification(ProtoOutputStream proto, String[] stringPool, NotificationHistory.HistoricalNotification notification) {
        long token = proto.start(2246267895811L);
        int packageIndex = Arrays.binarySearch(stringPool, notification.getPackage());
        if (packageIndex < 0) goto L5;
        proto.write(1120986464258L, packageIndex + 1);
    L6:
        int channelNameIndex = Arrays.binarySearch(stringPool, notification.getChannelName());
        if (channelNameIndex < 0) goto L9;
        proto.write(1120986464260L, channelNameIndex + 1);
    L10:
        int channelIdIndex = Arrays.binarySearch(stringPool, notification.getChannelId());
        if (channelIdIndex < 0) goto L13;
        proto.write(1120986464262L, channelIdIndex + 1);
    L15:
        if (TextUtils.isEmpty(notification.getConversationId()) == true) goto L20;
        int conversationIdIndex = Arrays.binarySearch(stringPool, notification.getConversationId());
        if (conversationIdIndex < 0) goto L19;
        proto.write(1120986464270L, conversationIdIndex + 1);
        goto L20
    L19:
        Slog.w(TAG, "notification conversation id (" + notification.getConversationId() + ") not found in string cache");
        proto.write(1138166333453L, notification.getConversationId());
    L20:
        proto.write(1120986464263L, notification.getUid());
        proto.write(1120986464264L, notification.getUserId());
        proto.write(1112396529673L, notification.getPostedTimeMs());
        proto.write(1138166333450L, notification.getTitle());
        proto.write(1138166333451L, notification.getText());
        writeIcon(proto, notification);
        proto.end(token);
        return;
    L13:
        Slog.w(TAG, "notification channel id (" + notification.getChannelId() + ") not found in string cache");
        proto.write(1138166333445L, notification.getChannelId());
        goto L15
    L9:
        Slog.w(TAG, "notification channel name (" + notification.getChannelName() + ") not found in string cache");
        proto.write(1138166333443L, notification.getChannelName());
        goto L10
    L5:
        Slog.w(TAG, "notification package name (" + notification.getPackage() + ") not found in string cache");
        proto.write(1138166333441L, notification.getPackage());
        goto L6
    }

    public static void read(InputStream in, NotificationHistory notifications, NotificationHistoryFilter filter) throws IOException {
        ProtoInputStream proto = new ProtoInputStream(in);
        List<String> stringPool = new ArrayList();
    L4:
        switch(proto.nextField()) {
            case -1: goto L10;
            case 0: goto L4;
            case 1: goto L7;
            case 2: goto L4;
            case 3: goto L6;
            default: goto L4;
        };
    L6:
        readNotification(proto, stringPool, notifications, filter);
        goto L4
    L7:
        stringPool = readStringPool(proto);
        goto L4
    L10:
        if (filter.isFiltering() == false) goto L12;
        notifications.poolStringsFromNotifications();
        return;
    L12:
        notifications.addPooledStrings(stringPool);
    }

    public static void write(OutputStream out, NotificationHistory notifications, int version) {
        ProtoOutputStream proto = new ProtoOutputStream(out);
        proto.write(1120986464258L, version);
        writeStringPool(proto, notifications);
        List<NotificationHistory.HistoricalNotification> notificationsToWrite = notifications.getNotificationsToWrite();
        int count = notificationsToWrite.size();
        int i = 0;
    L3:
        if (i >= count) goto L5;
        writeNotification(proto, notifications.getPooledStringsToWrite(), notificationsToWrite.get(i));
        i = i + 1;
        goto L3
    L5:
        proto.flush();
    }
}
