package com.stepos.pps.logpull;

/* loaded from: classes.dex */
public class LogPullStatus {
    public static final int ACKED = 1;
    public static final int BACKEND_DELETED = 10;
    public static final int CHECKSUM_FAILED = 8;
    public static final int DELIVERED = 6;
    public static final int FETCH_FAILED = 4;
    public static final int MOBILE_DELETED = 9;
    public static final int PENDING_ACK = 0;
    public static final int TASK_BUILT = 3;
    public static final int UPLOADING = 5;
    public static final int UPLOAD_TIMEOUT = 7;
    public static final int USER_REJECTED = 2;

    public static boolean isTerminal(int i) {
        return i == 2 || i == 4 || i == 6 || i == 7 || i == 8 || i == 9 || i == 10;
    }

    public static int detectServerTerminalReject(String str) {
        if (str != null && !str.isEmpty()) {
            int iIndexOf = str.indexOf("->");
            if (iIndexOf > 0 && str.contains("非法状态转移")) {
                str = str.substring(0, iIndexOf);
            }
            if (containsAny(str, "回传超时", "UPLOAD_TIMEOUT")) {
                return 7;
            }
            if (containsAny(str, "移动端删除", "移动端已删除", "MOBILE_DELETED")) {
                return 9;
            }
            if (containsAny(str, "后台已删除", "后台删除", "BACKEND_DELETED")) {
                return 10;
            }
            if (containsAny(str, "校验失败", "CHECKSUM_FAILED")) {
                return 8;
            }
            if (containsAny(str, "用户拒绝", "USER_REJECTED")) {
                return 2;
            }
            if (containsAny(str, "拉取失败", "FETCH_FAILED")) {
                return 4;
            }
        }
        return -1;
    }

    public static String terminalReason(int i) {
        if (i == 2) {
            return "服务端已结束：已拒绝";
        }
        if (i != 4) {
            switch (i) {
                case 7:
                    return "服务端已结束：回传超时";
                case 8:
                    return "服务端已结束：校验失败";
                case 9:
                    return "服务端已结束：任务已删除";
                case 10:
                    return "服务端已结束：后台已删除";
                default:
                    return "服务端已结束本次任务";
            }
        }
        return "服务端已结束：拉取失败";
    }

    private static boolean containsAny(String str, String... strArr) {
        for (String str2 : strArr) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}
