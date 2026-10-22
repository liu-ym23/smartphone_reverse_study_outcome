package com.bytedance.privacy.pseudoid;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.privacy.keymanager.AttestKeyManager;
import com.bytedance.privacy.pseudoid.account.AccountApi;
import com.bytedance.privacy.pseudoid.network.NetworkManager;
import com.bytedance.privacy.pseudoid.network.NetworkRequest;
import com.bytedance.privacy.pseudoid.network.NetworkResponse;
import com.bytedance.privacy.utils.CertUtils;
import com.bytedance.privacy.utils.LogUtils;
import com.bytedance.privacy.utils.PrivacyConfig;
import com.bytedance.security.secretdata.AddResult;
import com.bytedance.security.secretdata.QueryResult;
import com.bytedance.security.secretdata.SecretData;
import com.bytedance.security.secretdata.SecretDataManager;
import java.security.cert.Certificate;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PseudoManager {
    public static final String TAG = "PseudoManager";
    private static volatile PseudoManager pseudoManager;

    static {
    }

    public PseudoManager() {
    }

    public static PseudoManager getInstance() {
        if (pseudoManager != null) goto L15;
        monitor-enter(PseudoManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (pseudoManager != null) goto L9;
        pseudoManager = new PseudoManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PseudoManager.class);     // Catch: Throwable -> L11
    L15:
        return pseudoManager;
    }

    public String getPseudoDID(Context r18, String r19) {
        long r4 = System.currentTimeMillis();
        if (r18 == null) goto L112;
        if (r19 == null) goto L112;
        String r13 = r18.getPackageName();     // Catch: Throwable -> L119
    L110:
        th = th;
    L121:
        long r15 = System.currentTimeMillis() - r4;
        if (r19 == null) goto L124;
        String r14 = r19;
    L125:
        PseudoIDEventTrace.eventTrace(0, 0, r13, r14, r15);
        throw th;
    L124:
        r14 = "";
        goto L125
    L8:
        if (r19.isEmpty() == false) goto L10;
    L103:
        LogUtils.e(TAG, "AppId size is invalid!!");     // Catch: Throwable -> L110
        long r16 = System.currentTimeMillis() - r4;
        if (r19 == null) goto L107;
        String r17 = r19;
    L108:
        PseudoIDEventTrace.eventTrace(-3, 0, r13, r17, r16);
        return null;
    L107:
        r17 = "";
        goto L108
    L10:
        if (r19.length() > 128) goto L103;
        String r6 = AccountApi.INSTANCE.getDeviceId();     // Catch: Throwable -> L110
        if (r6.isEmpty() == false) goto L22;
        LogUtils.e(TAG, "deviceId is empty!");     // Catch: Throwable -> L110
        long r110 = System.currentTimeMillis() - r4;
        if (r19 == null) goto L18;
        String r111 = r19;
    L19:
        PseudoIDEventTrace.eventTrace(-4, 0, r13, r111, r110);
        return null;
    L18:
        r111 = "";
        goto L19
    L22:
        if (PrivacyConfig.isDebug() == false) goto L34;
        if (PrivacyConfig.isForceFetchFromCloud(1) == false) goto L34;
        LogUtils.d(TAG, "getPseudoDID forceFetchFromCloud enabled, skip local check.");     // Catch: Throwable -> L110
        String r8 = r19.intern();     // Catch: Throwable -> L110
        monitor-enter(r8);     // Catch: Throwable -> L110
        deletePseudoIDs(r18, r19);     // Catch: Throwable -> L30
        monitor-exit(r8);     // Catch: Throwable -> L30
    L46:
        String r9 = r19.intern();     // Catch: Throwable -> L110
        monitor-enter(r9);     // Catch: Throwable -> L110
    L100:
        th = th;
    L101:
        monitor-exit(r9);     // Catch: Throwable -> L100
        throw th;     // Catch: Throwable -> L110
    L127:
        if (isRPDIDExist(r18, r19, r6) == false) goto L64;
        String r0 = queryRPDID(r18, r19, r6);     // Catch: Throwable -> L100
        if (TextUtils.isEmpty(r0) == false) goto L54;
        LogUtils.e(TAG, "RPDID is already stored, but query failed!");     // Catch: Throwable -> L100
        int r11 = -6;
    L55:
        monitor-exit(r9);     // Catch: Throwable -> L62
        long r112 = System.currentTimeMillis() - r4;
        if (r19 == null) goto L59;
        String r113 = r19;
    L60:
        PseudoIDEventTrace.eventTrace(r11, 0, r13, r113, r112);
        return r0;
    L59:
        r113 = "";
        goto L60
    L54:
        r11 = 0;
        goto L55
    L64:
        String r12 = TAG;     // Catch: Throwable -> L100
        LogUtils.i(r12, "need to get pseudoID from cloud");     // Catch: Throwable -> L100
        if (AccountApi.INSTANCE.isLogin() == true) goto L67;
        LogUtils.i(r12, "Account is not login!!");     // Catch: Throwable -> L100
        int r7 = getPseudoIDFromCloud(r18, r6, "", r19);     // Catch: Throwable -> L100
    L79:
        if (r7 == 0) goto L88;
        LogUtils.e(r12, "get pseudoID from cloud failed, error: " + r7);     // Catch: Throwable -> L100
        monitor-exit(r9);     // Catch: Throwable -> L100
        long r114 = System.currentTimeMillis() - r4;
        if (r19 == null) goto L85;
        String r115 = r19;
    L86:
        PseudoIDEventTrace.eventTrace(r7, 0, r13, r115, r114);
        return null;
    L85:
        r115 = "";
        goto L86
    L88:
        String r1 = queryRPDID(r18, r19, r6);     // Catch: Throwable -> L100
        if (TextUtils.isEmpty(r1) == false) goto L92;
        LogUtils.e(r12, "RPDID store success, but query failed!");     // Catch: Throwable -> L100
        int r116 = -6;
    L93:
        monitor-exit(r9);     // Catch: Throwable -> L62
        long r117 = System.currentTimeMillis() - r4;
        if (r19 == null) goto L97;
        String r118 = r19;
    L98:
        PseudoIDEventTrace.eventTrace(r116, 0, r13, r118, r117);
        return r1;
    L97:
        r118 = "";
        goto L98
    L92:
        r116 = r7;
        goto L93
    L67:
        LogUtils.i(r12, "Account is login!!");     // Catch: Throwable -> L100
        String r119 = AccountApi.INSTANCE.getUserId();     // Catch: Throwable -> L100
        if (r119.isEmpty() == false) goto L78;
        LogUtils.e(r12, "Account is login, but userId is empty!");     // Catch: Throwable -> L100
        monitor-exit(r9);     // Catch: Throwable -> L62
        long r120 = System.currentTimeMillis() - r4;
        if (r19 == null) goto L75;
        String r121 = r19;
    L76:
        PseudoIDEventTrace.eventTrace(-5, 0, r13, r121, r120);
        return null;
    L75:
        r121 = "";
        goto L76
    L78:
        r7 = getPseudoIDFromCloud(r18, r6, r119, r19);     // Catch: Throwable -> L100
    L62:
        th = th;
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L110
    L34:
        if (isRPDIDExist(r18, r19, r6) == false) goto L46;
        String r2 = queryRPDID(r18, r19, r6);     // Catch: Throwable -> L110
        if (TextUtils.isEmpty(r2) == false) goto L39;
        LogUtils.e(TAG, "RPDID is already stored, but query failed!");     // Catch: Throwable -> L110
        int r122 = -6;
    L40:
        long r123 = System.currentTimeMillis() - r4;
        if (r19 == null) goto L43;
        String r124 = r19;
    L44:
        PseudoIDEventTrace.eventTrace(r122, 0, r13, r124, r123);
        return r2;
    L43:
        r124 = "";
        goto L44
    L39:
        r122 = 0;
    L112:
        LogUtils.e(TAG, "Context or appId is null!!");     // Catch: Throwable -> L119
        long r10 = System.currentTimeMillis() - r4;
        if (r19 == null) goto L116;
        String r20 = r19;
    L117:
        PseudoIDEventTrace.eventTrace(-2, 0, "", r20, r10);
        return null;
    L116:
        r20 = "";
    L119:
        th = th;
        r13 = "";
        goto L121
    }

    public String getPseudoUID(Context r18, String r19) {
        long r4 = System.currentTimeMillis();
        if (r18 == null) goto L114;
        if (r19 == null) goto L114;
        String r13 = r18.getPackageName();     // Catch: Throwable -> L121
    L112:
        th = th;
    L123:
        long r15 = System.currentTimeMillis() - r4;
        if (r19 == null) goto L126;
        String r14 = r19;
    L127:
        PseudoIDEventTrace.eventTrace(0, 1, r13, r14, r15);
        throw th;
    L126:
        r14 = "";
        goto L127
    L8:
        if (r19.isEmpty() == false) goto L10;
    L105:
        LogUtils.e(TAG, "AppId size is invalid!!");     // Catch: Throwable -> L112
        long r16 = System.currentTimeMillis() - r4;
        if (r19 == null) goto L109;
        String r17 = r19;
    L110:
        PseudoIDEventTrace.eventTrace(-3, 1, r13, r17, r16);
        return null;
    L109:
        r17 = "";
        goto L110
    L10:
        if (r19.length() > 128) goto L105;
        if (AccountApi.INSTANCE.isLogin() == true) goto L21;
        LogUtils.e(TAG, "Account is not login, no userId!!");     // Catch: Throwable -> L112
        long r110 = System.currentTimeMillis() - r4;
        if (r19 == null) goto L18;
        String r111 = r19;
    L19:
        PseudoIDEventTrace.eventTrace(-20, 1, r13, r111, r110);
        return null;
    L18:
        r111 = "";
        goto L19
    L21:
        String r6 = AccountApi.INSTANCE.getUserId();     // Catch: Throwable -> L112
        if (r6.isEmpty() == false) goto L31;
        LogUtils.e(TAG, "Account is login, but userId is empty!");     // Catch: Throwable -> L112
        long r112 = System.currentTimeMillis() - r4;
        if (r19 == null) goto L27;
        String r113 = r19;
    L28:
        PseudoIDEventTrace.eventTrace(-5, 1, r13, r113, r112);
        return null;
    L27:
        r113 = "";
        goto L28
    L31:
        if (PrivacyConfig.isDebug() == false) goto L43;
        if (PrivacyConfig.isForceFetchFromCloud(1) == false) goto L43;
        LogUtils.d(TAG, " getPseudoUID forceFetchFromCloud enabled, skip local check.");     // Catch: Throwable -> L112
        String r8 = r19.intern();     // Catch: Throwable -> L112
        monitor-enter(r8);     // Catch: Throwable -> L112
        deletePseudoIDs(r18, r19);     // Catch: Throwable -> L39
        monitor-exit(r8);     // Catch: Throwable -> L39
    L55:
        String r9 = TAG;     // Catch: Throwable -> L112
        LogUtils.i(r9, "need to get pseudoID from cloud");     // Catch: Throwable -> L112
        String r11 = AccountApi.INSTANCE.getDeviceId();     // Catch: Throwable -> L112
        if (r11.isEmpty() == false) goto L64;
        LogUtils.e(r9, "getPseudoUID, DID is empty!");     // Catch: Throwable -> L112
        long r114 = System.currentTimeMillis() - r4;
        if (r19 == null) goto L61;
        String r115 = r19;
    L62:
        PseudoIDEventTrace.eventTrace(-4, 1, r13, r115, r114);
        return null;
    L61:
        r115 = "";
        goto L62
    L64:
        String r12 = r19.intern();     // Catch: Throwable -> L112
        monitor-enter(r12);     // Catch: Throwable -> L112
    L102:
        th = th;
    L103:
        monitor-exit(r12);     // Catch: Throwable -> L102
        throw th;     // Catch: Throwable -> L112
    L132:
        if (isRPUIDExist(r18, r19, r6) == false) goto L80;
        String r0 = queryRPUID(r18, r19, r6);     // Catch: Throwable -> L102
        if (TextUtils.isEmpty(r0) == false) goto L72;
        LogUtils.e(r9, "RPUID is already stored, but query failed!");     // Catch: Throwable -> L102
        int r116 = -7;
    L73:
        monitor-exit(r12);     // Catch: Throwable -> L100
        long r117 = System.currentTimeMillis() - r4;
        if (r19 == null) goto L77;
        String r118 = r19;
    L78:
        PseudoIDEventTrace.eventTrace(r116, 1, r13, r118, r117);
        return r0;
    L77:
        r118 = "";
        goto L78
    L72:
        r116 = 0;
        goto L73
    L80:
        int r119 = getPseudoIDFromCloud(r18, r11, r6, r19);     // Catch: Throwable -> L102
        if (r119 == 0) goto L90;
        LogUtils.e(r9, "get pseudoID from cloud failed, error: " + r119);     // Catch: Throwable -> L100
        monitor-exit(r12);     // Catch: Throwable -> L100
        long r120 = System.currentTimeMillis() - r4;
        if (r19 == null) goto L87;
        String r121 = r19;
    L88:
        PseudoIDEventTrace.eventTrace(r119, 1, r13, r121, r120);
        return null;
    L87:
        r121 = "";
        goto L88
    L90:
        String r1 = queryRPUID(r18, r19, r6);     // Catch: Throwable -> L100
        if (TextUtils.isEmpty(r1) == false) goto L93;
        LogUtils.e(r9, "RPUID store success, but query failed!");     // Catch: Throwable -> L100
    L93:
        monitor-exit(r12);     // Catch: Throwable -> L100
        long r122 = System.currentTimeMillis() - r4;
        if (r19 == null) goto L97;
        String r123 = r19;
    L98:
        PseudoIDEventTrace.eventTrace(r119, 1, r13, r123, r122);
        return r1;
    L97:
        r123 = "";
    L100:
        th = th;
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L112
    L43:
        if (isRPUIDExist(r18, r19, r6) == false) goto L55;
        String r2 = queryRPUID(r18, r19, r6);     // Catch: Throwable -> L112
        if (TextUtils.isEmpty(r2) == false) goto L48;
        LogUtils.e(TAG, "RPUID is already stored, but query failed!");     // Catch: Throwable -> L112
        int r124 = -7;
    L49:
        long r125 = System.currentTimeMillis() - r4;
        if (r19 == null) goto L52;
        String r126 = r19;
    L53:
        PseudoIDEventTrace.eventTrace(r124, 1, r13, r126, r125);
        return r2;
    L52:
        r126 = "";
        goto L53
    L48:
        r124 = 0;
    L114:
        LogUtils.e(TAG, "Context or app Id is null!!");     // Catch: Throwable -> L121
        long r10 = System.currentTimeMillis() - r4;
        if (r19 == null) goto L118;
        String r7 = r19;
    L119:
        PseudoIDEventTrace.eventTrace(-2, 1, "", r7, r10);
        return null;
    L118:
        r7 = "";
    L121:
        th = th;
        r13 = "";
        goto L123
    }

    private int getPseudoIDFromCloud(Context r3, String r4, String r5, String r6) {
        if (r3 == null) goto L14;
        if (r6 == null) goto L14;
        if (r4 != null) goto L8;
    L12:
        LogUtils.e(TAG, "deviceId cannot be empty!!");
        return -2;
    L8:
        if (r4.isEmpty() == true) goto L12;
        return requestPseudoID(r3, r4, r5, r6);
    L14:
        LogUtils.e(TAG, "context or appID is null!!");
        return -2;
    }

    private int requestPseudoID(Context r10, String r11, String r12, String r13) {
        String r0 = TAG;
        LogUtils.d(r0, "request PseudoID, PackageName: " + r10.getPackageName());
        LogUtils.d(r0, "request PseudoID, appId:" + r13);
        LogUtils.d(r0, "request PseudoID, deviceId:" + r11);
        if (r12.isEmpty() == true) goto L5;
        LogUtils.d(r0, "request PseudoID, userId:" + r12);
    L5:
        NetworkRequest r1 = new NetworkRequest();
        r1.setRequestType("POST");
        r1.setRequestUrl(NetworkManager.getPseudoIDUrl());
        Bundle r8 = new Bundle();
        r8.putInt("key_algorithm", 2);
        r8.putInt("key_length", 256);
        r8.putInt("key_purpose", 64);
        List<Certificate> r2 = AttestKeyManager.getInstance().getAttestCertChain(r10, r13, r11, false, r8);
        if (r2 != null) goto L8;
    L42:
        LogUtils.e(r0, "Get attest cert chain failed!!");
        int r9 = -9;
    L43:
        AttestKeyManager.getInstance().deleteAttestKey(r10, r13);
        LogUtils.i(TAG, "requestPseudoID end, result:" + r9);
        return r9;
    L8:
        if (r2.isEmpty() == true) goto L42;
        r1.setCertChain(CertUtils.certsToPemString(r2, 3));     // Catch: Exception -> L40
        NetworkResponse r3 = NetworkManager.getInstance().executeRequest(r1);
        LogUtils.d(r0, "response code:" + r3.getCode());
        LogUtils.d(r0, "response msg:" + r3.getMessage());
        if (r3.getCode() >= 200) goto L15;
    L39:
        LogUtils.e(r0, "Network request failed, error code:" + r3.getCode());
        r9 = -21;
        goto L43
    L15:
        if (r3.getCode() >= 300) goto L39;
        if (r3.getPseudoID() != null) goto L20;
        LogUtils.e(r0, "Network response pseudoID is null!");
        r9 = -8;
        goto L43
    L20:
        LogUtils.d(r0, "PRDID:" + r3.getPseudoID().getRPDID());
        LogUtils.d(r0, "PRUID:" + r3.getPseudoID().getRPUID());
        if (r11.isEmpty() == false) goto L23;
        int r14 = 0;
    L31:
        if (r12.isEmpty() == false) goto L33;
    L38:
        r9 = r14;
        goto L43
    L33:
        if (r3.getPseudoID().getRPUID().isEmpty() == false) goto L35;
        LogUtils.e(r0, "Network response RPUID is empty!!");
    L25:
        r9 = -22;
        goto L43
    L35:
        r9 = storePseudoUID(r10, r13, r12, r3.getPseudoID().getRPUID());
        if (r9 == 0) goto L43;
        LogUtils.e(r0, "storePseudoUID failed!, result:" + r9);
        goto L43
    L23:
        if (r3.getPseudoID().getRPDID().isEmpty() == false) goto L26;
        LogUtils.e(r0, "Network response RPDID is empty!!");
        goto L25
    L26:
        r14 = storePseudoDID(r10, r13, r11, r3.getPseudoID().getRPDID());
        if (r14 == 0) goto L31;
        LogUtils.e(r0, "storePseudoDID failed!, result:" + r14);
    L40:
        e = move-exception;
        LogUtils.e(TAG, "Set certificate chain failed!! error:" + e.getMessage());
        r9 = -100;
        goto L43
    }

    private boolean isRPDIDExist(Context r3, String r4, String r5) {
        Bundle r2 = new Bundle();
        r2.putInt("query_mode", 0);
        QueryResult r6 = SecretDataManager.getInstance().queryData(r3, RPIDStoreConfig.buildRPDIDAlias(r4, r5), r2);
        if (r6 != null) goto L5;
    L9:
        return false;
    L5:
        if (r6.getResultCode() != 0) goto L9;
        return true;
    }

    private boolean isDeviceIdExist(Context r3, String r4, String r5) {
        Bundle r2 = new Bundle();
        r2.putInt("query_mode", 0);
        QueryResult r6 = SecretDataManager.getInstance().queryData(r3, RPIDStoreConfig.buildDeviceIdAlias(r4, r5), r2);
        if (r6 != null) goto L5;
    L9:
        return false;
    L5:
        if (r6.getResultCode() != 0) goto L9;
        return true;
    }

    private boolean isRPUIDExist(Context r3, String r4, String r5) {
        Bundle r2 = new Bundle();
        r2.putInt("query_mode", 0);
        QueryResult r6 = SecretDataManager.getInstance().queryData(r3, RPIDStoreConfig.buildRPUIDAlias(r4, r5), r2);
        if (r6 != null) goto L5;
    L9:
        return false;
    L5:
        if (r6.getResultCode() != 0) goto L9;
        return true;
    }

    private String queryRPDID(Context r3, String r4, String r5) {
        Bundle r2 = new Bundle();
        r2.putInt("query_mode", 2);
        QueryResult r6 = SecretDataManager.getInstance().queryData(r3, RPIDStoreConfig.buildRPDIDAlias(r4, r5), r2);
        if (r6 != null) goto L5;
    L16:
        LogUtils.e(TAG, "Query RPDID failed!!");
        return null;
    L5:
        if (r6.getResultCode() != 0) goto L16;
        SecretData r7 = (SecretData) r6.getDataList().get(0);
        if (r7.privateData != null) goto L10;
    L14:
        LogUtils.e(TAG, "Query success, but RPDID is null!!");
        return null;
    L10:
        if (r7.privateData.isEmpty() == true) goto L14;
        return r7.privateData;
    }

    public String queryDIDFromRPDID(Context r4, String r5, String r6) {
        if (r4 == null) goto L32;
        if (r5 == null) goto L32;
        if (r6 == null) goto L32;
        if (r5.isEmpty() == false) goto L10;
    L30:
        LogUtils.e(TAG, "AppId or rpDID size is invalid!!");
        return null;
    L10:
        if (r5.length() > 128) goto L30;
        if (r6.isEmpty() == true) goto L30;
        Bundle r0 = new Bundle();
        r0.putInt("query_mode", 2);
        QueryResult r7 = SecretDataManager.getInstance().queryData(r4, RPIDStoreConfig.buildDeviceIdAlias(r5, r6), r0);
        if (r7 != null) goto L17;
    L28:
        LogUtils.e(TAG, "Query original deviceId failed!!");
        return null;
    L17:
        if (r7.getResultCode() != 0) goto L28;
        SecretData r8 = (SecretData) r7.getDataList().get(0);
        if (r8.privateData != null) goto L22;
    L26:
        LogUtils.e(TAG, "Query success, but original deviceId is null!!");
        return null;
    L22:
        if (r8.privateData.isEmpty() == true) goto L26;
        return r8.privateData;
    L32:
        LogUtils.e(TAG, "input param is null!!");
        return null;
    }

    private String queryRPUID(Context r3, String r4, String r5) {
        Bundle r2 = new Bundle();
        r2.putInt("query_mode", 2);
        QueryResult r6 = SecretDataManager.getInstance().queryData(r3, RPIDStoreConfig.buildRPUIDAlias(r4, r5), r2);
        if (r6 != null) goto L5;
    L16:
        LogUtils.e(TAG, "Query RPUID failed!!");
        return null;
    L5:
        if (r6.getResultCode() != 0) goto L16;
        SecretData r7 = (SecretData) r6.getDataList().get(0);
        if (r7.privateData != null) goto L10;
    L14:
        LogUtils.e(TAG, "Query success, but RPUID is null!!");
        return null;
    L10:
        if (r7.privateData.isEmpty() == true) goto L14;
        return r7.privateData;
    }

    private int storePseudoDID(Context r6, String r7, String r8, String r9) {
        if (isRPDIDExist(r6, r7, r8) == true) goto L13;
        SecretData r0 = new SecretData();
        r0.privateData = r9;
        r0.associate = r7;
        r0.alias = RPIDStoreConfig.buildRPDIDAlias(r7, r8);
        r0.dataType = "RPDID";
        AddResult r1 = SecretDataManager.getInstance().addData(r6, r0, new Bundle());
        if (r1 != null) goto L9;
        LogUtils.e(TAG, "addResult is null, SecretDataManager service failed!!");
        return -14;
    L9:
        if (r1.getResultCode() == 0) goto L13;
        LogUtils.e(TAG, "Store RPDID failed!! result: " + r1.getResultCode());
        return r1.getResultCode();
    L13:
        if (isDeviceIdExist(r6, r7, r9) == true) goto L22;
        SecretData r5 = new SecretData();
        r5.privateData = r8;
        r5.associate = r7;
        r5.alias = RPIDStoreConfig.buildDeviceIdAlias(r7, r9);
        r5.dataType = "DID";
        AddResult r10 = SecretDataManager.getInstance().addData(r6, r5, new Bundle());
        if (r10 != null) goto L19;
        LogUtils.e(TAG, "addResult is null, SecretDataManager service failed!!");
        return -14;
    L19:
        if (r10.getResultCode() == 0) goto L24;
        LogUtils.e(TAG, "Store deviceID failed!! result: " + r10.getResultCode());
        return r10.getResultCode();
    L24:
        return 0;
    L22:
        return 0;
    }

    private int storePseudoUID(Context r1, String r2, String r3, String r4) {
        if (isRPUIDExist(r1, r2, r3) == true) goto L12;
        SecretData r0 = new SecretData();
        r0.privateData = r4;
        r0.associate = r2;
        r0.alias = RPIDStoreConfig.buildRPUIDAlias(r2, r3);
        r0.dataType = "RPUID";
        AddResult r5 = SecretDataManager.getInstance().addData(r1, r0, new Bundle());
        if (r5 != null) goto L9;
        LogUtils.e(TAG, "addResult is null, SecretDataManager service failed!!");
        return -14;
    L9:
        if (r5.getResultCode() == 0) goto L14;
        LogUtils.e(TAG, "Store RPUID failed!! result: " + r5.getResultCode());
        return r5.getResultCode();
    L14:
        return 0;
    L12:
        return 0;
    }

    private void deletePseudoIDs(Context r6, String r7) {
        if (PrivacyConfig.isDebug() == false) goto L29;
        String r0 = AccountApi.INSTANCE.getDeviceId();
        if (isRPDIDExist(r6, r7, r0) == false) goto L22;
        String r1 = queryRPDID(r6, r7, r0);
        if (r1 != null) goto L9;
    L19:
        LogUtils.e(TAG, "RPDID is already stored, but query failed!");
        return;
    L9:
        if (r1.isEmpty() == true) goto L19;
        if (isDeviceIdExist(r6, r7, r1) == false) goto L16;
        int r2 = SecretDataManager.getInstance().deleteData(r6, RPIDStoreConfig.buildDeviceIdAlias(r7, r1), new Bundle());
        if (r2 == 0) goto L16;
        LogUtils.e(TAG, "delete DeviceID failed, result = " + r2);
    L16:
        int r3 = SecretDataManager.getInstance().deleteData(r6, RPIDStoreConfig.buildRPDIDAlias(r7, r0), new Bundle());
        if (r3 == 0) goto L22;
        LogUtils.e(TAG, "delete RPDID failed, result = " + r3);
    L22:
        if (AccountApi.INSTANCE.isLogin() == false) goto L30;
        String r4 = AccountApi.INSTANCE.getUserId();
        if (isRPUIDExist(r6, r7, r4) == false) goto L31;
        int r5 = SecretDataManager.getInstance().deleteData(r6, RPIDStoreConfig.buildRPUIDAlias(r7, r4), new Bundle());
        if (r5 == 0) goto L32;
        LogUtils.e(TAG, "delete RPUID failed, result = " + r5);
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    }
}
