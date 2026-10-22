package com.android.server.appop;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.UserInfo;
import android.os.Handler;
import android.os.PackageTagsList;
import android.os.UserManager;
import android.util.ArrayMap;
import android.util.IndentingPrintWriter;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AppOpsRestrictionsImpl implements AppOpsRestrictions {
    private static final int UID_ANY = -2;
    private AppOpsRestrictions.AppOpsRestrictionRemovedListener mAppOpsRestrictionRemovedListener;
    private Context mContext;
    private final ArrayMap<Object, SparseBooleanArray> mGlobalRestrictions;
    private Handler mHandler;
    private final ArrayMap<Object, SparseArray<PackageTagsList>> mUserRestrictionExcludedPackageTags;
    private final ArrayMap<Object, SparseArray<SparseBooleanArray>> mUserRestrictions;

    /* JADX INFO: renamed from: $r8$lambda$CjDvL82V--Rfte21ogi7681bDSE, reason: not valid java name */
    public static /* synthetic */ void m1712$r8$lambda$CjDvL82VRfte21ogi7681bDSE(AppOpsRestrictionsImpl r0, int r1) {
        r0.lambda$notifyAllUserRestrictions$0(r1);
    }

    public AppOpsRestrictionsImpl(Context context, Handler handler, AppOpsRestrictions.AppOpsRestrictionRemovedListener appOpsRestrictionRemovedListener) {
        this.mGlobalRestrictions = new ArrayMap();
        this.mUserRestrictions = new ArrayMap();
        this.mUserRestrictionExcludedPackageTags = new ArrayMap();
        this.mContext = context;
        this.mHandler = handler;
        this.mAppOpsRestrictionRemovedListener = appOpsRestrictionRemovedListener;
    }

    @Override // com.android.server.appop.AppOpsRestrictions
    public boolean setGlobalRestriction(Object clientToken, int code, boolean restricted) {
        if (restricted == true) goto L4;
        SparseBooleanArray restrictedCodes = this.mGlobalRestrictions.get(clientToken);
        if (restrictedCodes != null) goto L11;
        return false;
    L11:
        boolean changed = restrictedCodes.get(code);
        restrictedCodes.delete(code);
        if (restrictedCodes.size() != 0) goto L14;
        this.mGlobalRestrictions.remove(clientToken);
    L14:
        if (changed == false) goto L16;
        AppOpsManager.invalidateAppOpModeCache();
    L16:
        return changed;
    L4:
        if (this.mGlobalRestrictions.containsKey(clientToken) == true) goto L6;
        this.mGlobalRestrictions.put(clientToken, new SparseBooleanArray());
    L6:
        SparseBooleanArray restrictedCodes2 = this.mGlobalRestrictions.get(clientToken);
        restrictedCodes2.getClass();
        changed = !restrictedCodes2.get(code);
        restrictedCodes2.put(code, true);
        goto L14
    }

    @Override // com.android.server.appop.AppOpsRestrictions
    public boolean getGlobalRestriction(Object clientToken, int code) {
        SparseBooleanArray restrictedCodes = this.mGlobalRestrictions.get(clientToken);
        if (restrictedCodes != null) goto L7;
        return false;
    L7:
        return restrictedCodes.get(code);
    }

    @Override // com.android.server.appop.AppOpsRestrictions
    public boolean hasGlobalRestrictions(Object clientToken) {
        return this.mGlobalRestrictions.containsKey(clientToken);
    }

    @Override // com.android.server.appop.AppOpsRestrictions
    public boolean clearGlobalRestrictions(Object clientToken) {
        if (this.mGlobalRestrictions.remove(clientToken) == null) goto L5;
        boolean changed = true;
    L6:
        if (changed == false) goto L8;
        AppOpsManager.invalidateAppOpModeCache();
    L8:
        return changed;
    L5:
        changed = false;
        goto L6
    }

    @Override // com.android.server.appop.AppOpsRestrictions
    public boolean setUserRestriction(Object clientToken, int userId, int code, boolean restricted, PackageTagsList excludedPackageTags) {
        int[] userIds = resolveUserId(userId);
        boolean changed = false;
        int i = 0;
    L4:
        if (i >= userIds.length) goto L7;
        changed = (changed | putUserRestriction(clientToken, userIds[i], code, restricted)) | putUserRestrictionExclusions(clientToken, userIds[i], excludedPackageTags);
        i = i + 1;
        goto L4
    L7:
        if (changed == false) goto L9;
        AppOpsManager.invalidateAppOpModeCache();
    L9:
        return changed;
    }

    private int[] resolveUserId(int userId) {
        if (userId != (-1)) goto L10;
        List<UserInfo> liveUsers = UserManager.get(this.mContext).getUsers();
        int[] userIds = new int[liveUsers.size()];
        int i = 0;
    L6:
        if (i >= liveUsers.size()) goto L12;
        userIds[i] = liveUsers.get(i).id;
        i = i + 1;
        goto L6
    L12:
        return userIds;
    L10:
        return new int[]{userId};
    }

    @Override // com.android.server.appop.AppOpsRestrictions
    public boolean hasUserRestrictions(Object clientToken) {
        return this.mUserRestrictions.containsKey(clientToken);
    }

    private boolean getUserRestriction(Object clientToken, int userId, int code) {
        SparseArray<SparseBooleanArray> userIdRestrictedCodes = this.mUserRestrictions.get(clientToken);
        if (userIdRestrictedCodes != null) goto L5;
        return false;
    L5:
        SparseBooleanArray restrictedCodes = userIdRestrictedCodes.get(userId);
        if (restrictedCodes != null) goto L9;
        return false;
    L9:
        return restrictedCodes.get(code);
    }

    @Override // com.android.server.appop.AppOpsRestrictions
    public boolean getUserRestriction(Object clientToken, int userId, int code, String packageName, String attributionTag, boolean isCheckOp) {
        boolean restricted = getUserRestriction(clientToken, userId, code);
        if (restricted == true) goto L6;
        return false;
    L6:
        PackageTagsList perUserExclusions = getUserRestrictionExclusions(clientToken, userId);
        if (perUserExclusions != null) goto L9;
        return true;
    L9:
        if (isCheckOp == false) goto L13;
        return true ^ perUserExclusions.includes(packageName);
    L13:
        return true ^ perUserExclusions.contains(packageName, attributionTag);
    }

    @Override // com.android.server.appop.AppOpsRestrictions
    public boolean clearUserRestrictions(Object clientToken) {
        SparseBooleanArray allUserRestrictedCodes = collectAllUserRestrictedCodes(clientToken);
        boolean r3 = false;
        if (this.mUserRestrictions.remove(clientToken) == null) goto L5;
        boolean r2 = true;
    L6:
        boolean changed = false | r2;
        if (this.mUserRestrictionExcludedPackageTags.remove(clientToken) == null) goto L9;
        r3 = true;
    L9:
        boolean changed2 = changed | r3;
        notifyAllUserRestrictions(allUserRestrictedCodes);
        if (changed2 == false) goto L12;
        AppOpsManager.invalidateAppOpModeCache();
    L12:
        return changed2;
    L5:
        r2 = false;
        goto L6
    }

    private SparseBooleanArray collectAllUserRestrictedCodes(Object clientToken) {
        SparseBooleanArray allRestrictedCodes = new SparseBooleanArray();
        SparseArray<SparseBooleanArray> userIdRestrictedCodes = this.mUserRestrictions.get(clientToken);
        if (userIdRestrictedCodes != null) goto L5;
        return allRestrictedCodes;
    L5:
        int userIdRestrictedCodesSize = userIdRestrictedCodes.size();
        int i = 0;
    L6:
        if (i >= userIdRestrictedCodesSize) goto L12;
        SparseBooleanArray restrictedCodes = userIdRestrictedCodes.valueAt(i);
        int restrictedCodesSize = restrictedCodes.size();
        int j = 0;
    L8:
        if (j >= restrictedCodesSize) goto L10;
        int code = restrictedCodes.keyAt(j);
        allRestrictedCodes.put(code, true);
        j = j + 1;
        goto L8
    L10:
        i = i + 1;
        goto L6
    L12:
        return allRestrictedCodes;
    }

    private void notifyAllUserRestrictions(SparseBooleanArray allUserRestrictedCodes) {
        int restrictedCodesSize = allUserRestrictedCodes.size();
        int j = 0;
    L3:
        if (j >= restrictedCodesSize) goto L6;
        final int code = allUserRestrictedCodes.keyAt(j);
        this.mHandler.post(new AppOpsRestrictionsImpl$$ExternalSyntheticLambda0(this, code));
        j = j + 1;
        goto L3
    }

    private /* synthetic */ void lambda$notifyAllUserRestrictions$0(int code) {
        this.mAppOpsRestrictionRemovedListener.onAppOpsRestrictionRemoved(code);
    }

    @Override // com.android.server.appop.AppOpsRestrictions
    public boolean clearUserRestrictions(Object clientToken, Integer userId) {
        boolean changed = false;
        SparseArray<SparseBooleanArray> userIdRestrictedCodes = this.mUserRestrictions.get(clientToken);
        if (userIdRestrictedCodes == null) goto L7;
        changed = false | userIdRestrictedCodes.contains(userId.intValue());
        userIdRestrictedCodes.remove(userId.intValue());
        if (userIdRestrictedCodes.size() != 0) goto L7;
        this.mUserRestrictions.remove(clientToken);
    L7:
        SparseArray<PackageTagsList> userIdPackageTags = this.mUserRestrictionExcludedPackageTags.get(clientToken);
        if (userIdPackageTags == null) goto L12;
        changed = changed | userIdPackageTags.contains(userId.intValue());
        userIdPackageTags.remove(userId.intValue());
        if (userIdPackageTags.size() != 0) goto L12;
        this.mUserRestrictionExcludedPackageTags.remove(clientToken);
    L12:
        if (changed == false) goto L14;
        AppOpsManager.invalidateAppOpModeCache();
    L14:
        return changed;
    }

    private boolean putUserRestriction(Object token, int userId, int code, boolean restricted) {
        if (restricted == true) goto L5;
        SparseArray<SparseBooleanArray> userIdRestrictedCodes = this.mUserRestrictions.get(token);
        if (userIdRestrictedCodes != null) goto L14;
        return false;
    L14:
        SparseBooleanArray restrictedCodes = userIdRestrictedCodes.get(userId);
        if (restrictedCodes != null) goto L17;
        return false;
    L17:
        boolean changed = restrictedCodes.get(code);
        restrictedCodes.delete(code);
        if (restrictedCodes.size() != 0) goto L21;
        userIdRestrictedCodes.remove(userId);
    L21:
        if (userIdRestrictedCodes.size() != 0) goto L24;
        this.mUserRestrictions.remove(token);
    L24:
        return changed;
    L5:
        if (this.mUserRestrictions.containsKey(token) == true) goto L7;
        this.mUserRestrictions.put(token, new SparseArray());
    L7:
        SparseArray<SparseBooleanArray> userIdRestrictedCodes2 = this.mUserRestrictions.get(token);
        userIdRestrictedCodes2.getClass();
        if (userIdRestrictedCodes2.contains(userId) == true) goto L10;
        userIdRestrictedCodes2.put(userId, new SparseBooleanArray());
    L10:
        SparseBooleanArray restrictedCodes2 = userIdRestrictedCodes2.get(userId);
        boolean changed2 = !restrictedCodes2.get(code);
        restrictedCodes2.put(code, restricted);
        return changed2;
    }

    @Override // com.android.server.appop.AppOpsRestrictions
    public PackageTagsList getUserRestrictionExclusions(Object clientToken, int userId) {
        SparseArray<PackageTagsList> userIdPackageTags = this.mUserRestrictionExcludedPackageTags.get(clientToken);
        if (userIdPackageTags != null) goto L7;
        return null;
    L7:
        return userIdPackageTags.get(userId);
    }

    private boolean putUserRestrictionExclusions(Object token, int userId, PackageTagsList excludedPackageTags) {
        boolean changed = false;
        if (excludedPackageTags != null) goto L5;
    L7:
        boolean addingExclusions = false;
    L8:
        if (addingExclusions == true) goto L10;
        SparseArray<PackageTagsList> userIdExclusions = this.mUserRestrictionExcludedPackageTags.get(token);
        if (userIdExclusions != null) goto L18;
        return false;
    L18:
        if (userIdExclusions.get(userId) == null) goto L20;
        changed = true;
    L20:
        userIdExclusions.remove(userId);
        if (userIdExclusions.size() != 0) goto L23;
        this.mUserRestrictionExcludedPackageTags.remove(token);
    L23:
        return changed;
    L10:
        if (this.mUserRestrictionExcludedPackageTags.containsKey(token) == true) goto L12;
        this.mUserRestrictionExcludedPackageTags.put(token, new SparseArray());
    L12:
        SparseArray<PackageTagsList> userIdExcludedPackageTags = this.mUserRestrictionExcludedPackageTags.get(token);
        userIdExcludedPackageTags.getClass();
        userIdExcludedPackageTags.put(userId, excludedPackageTags);
        return true;
    L5:
        if (excludedPackageTags.isEmpty() == true) goto L7;
        addingExclusions = true;
        goto L8
    }

    @Override // com.android.server.appop.AppOpsRestrictions
    public void dumpRestrictions(PrintWriter pw, int code, String dumpPackage, boolean showUserRestrictions) {
        AppOpsRestrictionsImpl r0 = this;
        PrintWriter r1 = pw;
        int globalRestrictionCount = r0.mGlobalRestrictions.size();
        int i = 0;
    L3:
        String r8 = "[";
        if (i >= globalRestrictionCount) goto L13;
        Object token = r0.mGlobalRestrictions.keyAt(i);
        SparseBooleanArray restrictedOps = r0.mGlobalRestrictions.valueAt(i);
        r1.println("  Global restrictions for token " + token + ":");
        StringBuilder restrictedOpsValue = new StringBuilder();
        restrictedOpsValue.append("[");
        int restrictedOpCount = restrictedOps.size();
        int j = 0;
    L6:
        if (j >= restrictedOpCount) goto L11;
        if (restrictedOpsValue.length() <= 1) goto L10;
        restrictedOpsValue.append(", ");
    L10:
        restrictedOpsValue.append(AppOpsManager.opToName(restrictedOps.keyAt(j)));
        j = j + 1;
        goto L6
    L11:
        restrictedOpsValue.append("]");
        r1.println("      Restricted ops: " + restrictedOpsValue);
        i = i + 1;
        goto L3
    L13:
        if (showUserRestrictions == true) goto L15;
        return;
    L15:
        int userRestrictionCount = r0.mUserRestrictions.size();
        int i2 = 0;
    L16:
        if (i2 >= userRestrictionCount) goto L76;
        Object token2 = r0.mUserRestrictions.keyAt(i2);
        SparseArray<SparseBooleanArray> perUserRestrictions = r0.mUserRestrictions.get(token2);
        SparseArray<PackageTagsList> perUserExcludedPackageTags = r0.mUserRestrictionExcludedPackageTags.get(token2);
        boolean printedTokenHeader = false;
        int r16 = 0;
        if (perUserRestrictions == null) goto L20;
        int r17 = perUserRestrictions.size();
    L21:
        int restrictionCount = r17;
        if (restrictionCount <= 0) goto L48;
        if (dumpPackage != null) goto L48;
        boolean printedOpsHeader = false;
        int j2 = 0;
    L25:
        int globalRestrictionCount2 = globalRestrictionCount;
        int globalRestrictionCount3 = restrictionCount;
        if (j2 >= globalRestrictionCount3) goto L47;
        restrictionCount = globalRestrictionCount3;
        int userId = perUserRestrictions.keyAt(j2);
        int j3 = j2;
        SparseBooleanArray restrictedOps2 = perUserRestrictions.valueAt(j2);
        if (restrictedOps2 == null) goto L33;
        if (code >= 0) goto L32;
    L34:
        if (printedTokenHeader == true) goto L37;
        r1.println("  User restrictions for token " + token2 + ":");
        printedTokenHeader = true;
    L37:
        if (printedOpsHeader == true) goto L39;
        r1.println("      Restricted ops:");
        printedOpsHeader = true;
    L39:
        StringBuilder restrictedOpsValue2 = new StringBuilder();
        restrictedOpsValue2.append(r8);
        int restrictedOpCount2 = restrictedOps2.size();
        int k = 0;
    L40:
        if (k >= restrictedOpCount2) goto L45;
        int restrictedOp = restrictedOps2.keyAt(k);
        SparseBooleanArray restrictedOps3 = restrictedOps2;
        int restrictedOpCount3 = restrictedOpCount2;
        if (restrictedOpsValue2.length() <= 1) goto L44;
        restrictedOpsValue2.append(", ");
    L44:
        restrictedOpsValue2.append(AppOpsManager.opToName(restrictedOp));
        k = k + 1;
        restrictedOps2 = restrictedOps3;
        restrictedOpCount2 = restrictedOpCount3;
        goto L40
    L45:
        restrictedOpsValue2.append("]");
        r1.print("        ");
        r1.print("user: ");
        r1.print(userId);
        r1.print(" restricted ops: ");
        r1.println(restrictedOpsValue2);
    L46:
        j2 = j3 + 1;
        code = code;
        globalRestrictionCount = globalRestrictionCount2;
        userRestrictionCount = userRestrictionCount;
        r8 = r8;
        goto L25
    L32:
        if (restrictedOps2.get(code) == true) goto L34;
    L33:
        userRestrictionCount = userRestrictionCount;
        goto L46
    L47:
        int userRestrictionCount2 = userRestrictionCount;
        String r24 = r8;
    L49:
        if (perUserExcludedPackageTags == null) goto L52;
        r16 = perUserExcludedPackageTags.size();
    L52:
        int excludedPackageCount = r16;
        if (excludedPackageCount <= 0) goto L74;
        if (code >= 0) goto L74;
        IndentingPrintWriter ipw = new IndentingPrintWriter(r1);
        ipw.increaseIndent();
        boolean printedPackagesHeader = false;
        int j4 = 0;
    L56:
        if (j4 >= excludedPackageCount) goto L72;
        int userId2 = perUserExcludedPackageTags.keyAt(j4);
        int excludedPackageCount2 = excludedPackageCount;
        PackageTagsList packageNames = perUserExcludedPackageTags.valueAt(j4);
        if (packageNames == null) goto L71;
        if (dumpPackage == null) goto L62;
        boolean hasPackage = packageNames.includes(dumpPackage);
    L63:
        if (hasPackage == false) goto L71;
        if (printedTokenHeader == true) goto L67;
        ipw.println("User restrictions for token " + token2 + ":");
        printedTokenHeader = true;
    L67:
        ipw.increaseIndent();
        if (printedPackagesHeader == true) goto L70;
        ipw.println("Excluded packages:");
        printedPackagesHeader = true;
    L70:
        ipw.increaseIndent();
        ipw.print("user: ");
        ipw.print(userId2);
        ipw.println(" packages: ");
        ipw.increaseIndent();
        packageNames.dump(ipw);
        ipw.decreaseIndent();
        ipw.decreaseIndent();
        ipw.decreaseIndent();
        goto L71
    L62:
        hasPackage = true;
    L71:
        j4 = j4 + 1;
        dumpPackage = dumpPackage;
        excludedPackageCount = excludedPackageCount2;
        goto L56
    L72:
        ipw.decreaseIndent();
    L74:
        i2 = i2 + 1;
        r0 = this;
        r1 = pw;
        globalRestrictionCount = globalRestrictionCount2;
        userRestrictionCount = userRestrictionCount2;
        r8 = r24;
    L48:
        globalRestrictionCount2 = globalRestrictionCount;
        userRestrictionCount2 = userRestrictionCount;
        r24 = r8;
        goto L49
    L20:
        r17 = 0;
        goto L21
    }
}
