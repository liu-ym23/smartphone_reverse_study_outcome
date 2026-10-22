package com.android.server.pm.verify.domain;

import android.content.Intent;
import android.content.pm.IntentFilterVerificationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.verify.domain.DomainSet;
import android.content.pm.verify.domain.DomainVerificationInfo;
import android.util.IndentingPrintWriter;
import android.util.Pair;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.pm.Computer;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.verify.domain.proxy.DomainVerificationProxy;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public interface DomainVerificationManagerInternal {
    public static final int APPROVAL_LEVEL_DISABLED = -3;
    public static final int APPROVAL_LEVEL_INSTANT_APP = 5;
    public static final int APPROVAL_LEVEL_LEGACY_ALWAYS = 2;
    public static final int APPROVAL_LEVEL_LEGACY_ASK = 1;
    public static final int APPROVAL_LEVEL_NONE = 0;
    public static final int APPROVAL_LEVEL_NOT_INSTALLED = -4;
    public static final int APPROVAL_LEVEL_SELECTION = 3;
    public static final int APPROVAL_LEVEL_UNDECLARED = -2;
    public static final int APPROVAL_LEVEL_UNVERIFIED = -1;
    public static final int APPROVAL_LEVEL_VERIFIED = 4;
    public static final UUID DISABLED_ID = null;

    public @interface ApprovalLevel {
    }

    public interface Connection extends DomainVerificationEnforcer.Callback {
        int[] getAllUserIds();

        int getCallingUid();

        int getCallingUserId();

        void schedule(int r1, Object r2);

        void scheduleWriteSettings();

        Computer snapshot();
    }

    void addLegacySetting(String r1, IntentFilterVerificationInfo r2);

    void addPackage(PackageStateInternal r1, DomainSet r2);

    int approvalLevelForDomain(PackageStateInternal r1, Intent r2, long r3, int r5);

    void clearPackage(String r1);

    void clearPackageForUser(String r1, int r2);

    void clearUser(int r1);

    Pair<List<ResolveInfo>, Integer> filterToApprovedApp(Intent r1, List<ResolveInfo> r2, int r3, Function<String, PackageStateInternal> r4);

    UUID generateNewId();

    DomainVerificationCollector getCollector();

    DomainVerificationInfo getDomainVerificationInfo(String r1) throws PackageManager.NameNotFoundException;

    UUID getDomainVerificationInfoId(String r1);

    int getLegacyState(String r1, int r2);

    DomainVerificationProxy getProxy();

    DomainVerificationShell getShell();

    void migrateState(PackageStateInternal r1, PackageStateInternal r2, DomainSet r3);

    void printState(Computer r1, IndentingPrintWriter r2, String r3, Integer r4) throws PackageManager.NameNotFoundException;

    void readLegacySettings(TypedXmlPullParser r1) throws IOException, XmlPullParserException;

    void readSettings(Computer r1, TypedXmlPullParser r2) throws IOException, XmlPullParserException;

    void restoreSettings(Computer r1, TypedXmlPullParser r2) throws IOException, XmlPullParserException;

    boolean runMessage(int r1, Object r2);

    void setConnection(Connection r1);

    int setDomainVerificationStatusInternal(int r1, UUID r2, Set<String> r3, int r4) throws PackageManager.NameNotFoundException;

    boolean setLegacyUserState(String r1, int r2, int r3);

    void setProxy(DomainVerificationProxy r1);

    void writeSettings(Computer r1, TypedXmlSerializer r2, boolean r3, int r4) throws IOException;

    static {
        DISABLED_ID = new UUID(0, 0);
    }

    static String approvalLevelToDebugString(int level) {
        switch(level) {
            case -4: goto L23;
            case -3: goto L21;
            case -2: goto L19;
            case -1: goto L17;
            case 0: goto L15;
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L5;
            default: goto L3;
        };
    L3:
        return "UNKNOWN";
    L5:
        return "INSTANT_APP";
    L7:
        return "VERIFIED";
    L9:
        return "USER_SELECTION";
    L11:
        return "LEGACY_ALWAYS";
    L13:
        return "LEGACY_ASK";
    L15:
        return "NONE";
    L17:
        return "UNVERIFIED";
    L19:
        return "UNDECLARED";
    L21:
        return "DISABLED";
    L23:
        return "NOT_INSTALLED";
    }
}
