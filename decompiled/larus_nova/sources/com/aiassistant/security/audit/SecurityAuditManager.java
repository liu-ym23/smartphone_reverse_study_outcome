package com.aiassistant.security.audit;

import android.os.ParcelFileDescriptor;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class SecurityAuditManager {
    private SecurityAuditManager() {
    }

    public static void clearActiveSession() {
        throw new RuntimeException("Stub!!");
    }

    public static int getPendingUploadCount() {
        throw new RuntimeException("Stub!!");
    }

    public static int confirmUploadSuccess(String r100) {
        throw new RuntimeException("Stub!!");
    }

    public static boolean recordAudit(String r100) {
        throw new RuntimeException("Stub!!");
    }

    public static int recordAuditWithResult(String r100) {
        throw new RuntimeException("Stub!!");
    }

    public static void setActiveSession(String r100) {
        throw new RuntimeException("Stub!!");
    }

    public static String getPendingUploadReport(int r100, int r101) {
        throw new RuntimeException("Stub!!");
    }

    public static int confirmUploadFailure(String r100, int r101, String r102) {
        throw new RuntimeException("Stub!!");
    }

    public static ParcelFileDescriptor exportAllLogs(long r100, long r101, boolean r102) {
        throw new RuntimeException("Stub!!");
    }

    public static List<String> queryLogs(long r100, long r101, String r102, String r103) {
        throw new RuntimeException("Stub!!");
    }
}
