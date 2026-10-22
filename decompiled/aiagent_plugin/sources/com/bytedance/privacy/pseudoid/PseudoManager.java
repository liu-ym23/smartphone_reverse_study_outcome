package com.bytedance.privacy.pseudoid;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.privacy.keymanager.AttestKeyManager;
import com.bytedance.privacy.pseudoid.account.AccountApi;
import com.bytedance.privacy.pseudoid.network.NetworkManager;
import com.bytedance.privacy.pseudoid.network.NetworkRequest;
import com.bytedance.privacy.pseudoid.network.NetworkResponse;
import com.bytedance.privacy.security.SecurityFrameworkCompat;
import com.bytedance.privacy.utils.CertUtils;
import com.bytedance.privacy.utils.LogUtils;
import com.bytedance.privacy.utils.PrivacyConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.cert.Certificate;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
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

    public String getPseudoDID(Context r17, String r18) {
        String r1 = r18;
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.aiagent.plugin");
        long r3 = System.currentTimeMillis();
        String r6 = TAG;
        LogUtils.i(r6, "getPseudoDID enter");
        if (r2 == null) goto L121;
        if (r1 == null) goto L121;
        String r12 = r2.getPackageName();     // Catch: Throwable -> L128 Exception -> L130
    L119:
        e = e;
    L156:
    L144:
        th = move-exception;
        Throwable r7 = th;
        int r0 = 0;
    L146:
        String r4 = r12;
    L147:
        long r5 = System.currentTimeMillis() - r3;
        if (r1 != null) goto L151;
        r1 = "";
    L151:
        PseudoIDEventTrace.eventTrace(r0, 0, r4, r1, r5);
        throw r7;
    L134:
        if (e.getMessage() != null) goto L136;
        String r8 = e.getClass().getSimpleName();     // Catch: Throwable -> L144
    L137:
        LogUtils.e(TAG, "getPseudoDID failed, error: " + r8);     // Catch: Throwable -> L144
        long r14 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L141;
        String r13 = r1;
    L142:
        PseudoIDEventTrace.eventTrace(0, 0, r12, r13, r14);
        return null;
    L141:
        r13 = "";
        goto L142
    L136:
        r8 = e.getMessage();     // Catch: Throwable -> L144
    L117:
        th = move-exception;
        r7 = th;
        r0 = 0;
        goto L146
    L8:
        if (r18.isEmpty() == false) goto L10;
    L110:
        LogUtils.e(r6, "AppId size is invalid!!");     // Catch: Throwable -> L117 Exception -> L119
        long r15 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L114;
        String r16 = r1;
    L115:
        PseudoIDEventTrace.eventTrace(-3, 0, r12, r16, r15);
        return null;
    L114:
        r16 = "";
        goto L115
    L10:
        if (r18.length() > 128) goto L110;
        String r9 = AccountApi.INSTANCE.getDeviceId();     // Catch: Throwable -> L117 Exception -> L119
        if (r9.isEmpty() == false) goto L21;
        LogUtils.e(r6, "deviceId is empty!");     // Catch: Throwable -> L117 Exception -> L119
        long r19 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L18;
        String r110 = r1;
    L19:
        PseudoIDEventTrace.eventTrace(-4, 0, r12, r110, r19);
        return null;
    L18:
        r110 = "";
        goto L19
    L21:
        int r10 = -6;
        if (PrivacyConfig.isDebug() == false) goto L34;
        if (PrivacyConfig.isForceFetchFromCloud(1) == false) goto L34;
        LogUtils.d(r6, "getPseudoDID forceFetchFromCloud enabled, skip local check.");     // Catch: Throwable -> L117 Exception -> L119
        String r11 = r18.intern();     // Catch: Throwable -> L117 Exception -> L119
        monitor-enter(r11);     // Catch: Throwable -> L117 Exception -> L119
        deletePseudoIDs(r2, r1);     // Catch: Throwable -> L30
        monitor-exit(r11);     // Catch: Throwable -> L30
    L46:
        String r20 = r18.intern();     // Catch: Throwable -> L117 Exception -> L119
        monitor-enter(r20);     // Catch: Throwable -> L117 Exception -> L119
    L107:
        th = th;
    L108:
        monitor-exit(r20);     // Catch: Throwable -> L107
        throw th;     // Catch: Throwable -> L117 Exception -> L119
    L155:
        if (isRPDIDExist(r2, r1, r9) == false) goto L68;
        String r21 = queryRPDID(r2, r1, r9);     // Catch: Throwable -> L107
        if (TextUtils.isEmpty(r21) == false) goto L55;
        LogUtils.e(r6, "RPDID is already stored, but query failed!");     // Catch: Throwable -> L66
    L56:
        monitor-exit(r20);     // Catch: Throwable -> L63
        long r111 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L60;
        String r112 = r1;
    L61:
        PseudoIDEventTrace.eventTrace(r10, 0, r12, r112, r111);
        return r21;
    L60:
        r112 = "";
        goto L61
    L55:
        r10 = 0;
        goto L56
    L68:
        LogUtils.i(r6, "need to get pseudoID from cloud");     // Catch: Throwable -> L107
        if (AccountApi.INSTANCE.isLogin() == true) goto L71;
        LogUtils.i(r6, "Account is not login!!");     // Catch: Throwable -> L107
        int r22 = getPseudoIDFromCloud(r2, r9, "", r1);     // Catch: Throwable -> L107
    L85:
        if (r22 == 0) goto L94;
        LogUtils.e(r6, "get pseudoID from cloud failed, error: " + r22);     // Catch: Throwable -> L107
        monitor-exit(r20);     // Catch: Throwable -> L107
        long r113 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L91;
        String r114 = r1;
    L92:
        PseudoIDEventTrace.eventTrace(r22, 0, r12, r114, r113);
        return null;
    L91:
        r114 = "";
        goto L92
    L94:
        String r23 = queryRPDID(r2, r1, r9);     // Catch: Throwable -> L107
        if (TextUtils.isEmpty(r23) == false) goto L99;
        LogUtils.e(r6, "RPDID store success, but query failed!");     // Catch: Throwable -> L66
    L100:
        monitor-exit(r20);     // Catch: Throwable -> L63
        long r115 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L104;
        String r116 = r1;
    L105:
        PseudoIDEventTrace.eventTrace(r10, 0, r12, r116, r115);
        return r23;
    L104:
        r116 = "";
        goto L105
    L99:
        r10 = r22;
        goto L100
    L71:
        LogUtils.i(r6, "Account is login!!");     // Catch: Throwable -> L107
        String r117 = AccountApi.INSTANCE.getUserId();     // Catch: Throwable -> L107
        if (r117.isEmpty() == false) goto L84;
        LogUtils.e(r6, "Account is login, but userId is empty!");     // Catch: Throwable -> L107
        r10 = -5;
        monitor-exit(r20);     // Catch: Throwable -> L82
        long r118 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L79;
        String r119 = r1;
    L80:
        PseudoIDEventTrace.eventTrace(-5, 0, r12, r119, r118);
        return null;
    L79:
        r119 = "";
    L82:
        th = th;
        goto L108
    L84:
        r22 = getPseudoIDFromCloud(r2, r9, r117, r1);     // Catch: Throwable -> L107
    L63:
        th = th;
    L66:
        th = th;
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L117 Exception -> L119
    L34:
        if (isRPDIDExist(r2, r1, r9) == false) goto L46;
        String r24 = queryRPDID(r2, r1, r9);     // Catch: Throwable -> L117 Exception -> L119
        if (TextUtils.isEmpty(r24) == false) goto L39;
        LogUtils.e(r6, "RPDID is already stored, but query failed!");     // Catch: Throwable -> L117 Exception -> L119
    L40:
        long r120 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L43;
        String r121 = r1;
    L44:
        PseudoIDEventTrace.eventTrace(r10, 0, r12, r121, r120);
        return r24;
    L43:
        r121 = "";
        goto L44
    L39:
        r10 = 0;
    L121:
        LogUtils.e(r6, "Context or appId is null!!");     // Catch: Throwable -> L128 Exception -> L130
        long r25 = System.currentTimeMillis() - r3;
        if (r1 != null) goto L126;
        r1 = "";
    L126:
        PseudoIDEventTrace.eventTrace(-2, 0, "", r1, r25);
        return null;
    L130:
        e = e;
        r12 = "";
    L128:
        th = move-exception;
        r7 = th;
        r4 = "";
        r0 = 0;
        goto L147
    }

    public String getPseudoUID(Context r17, String r18) {
        String r1 = r18;
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.aiagent.plugin");
        long r3 = System.currentTimeMillis();
        String r6 = TAG;
        LogUtils.i(r6, "getPseudoUID enter");
        if (r2 == null) goto L122;
        if (r1 == null) goto L122;
        String r12 = r2.getPackageName();     // Catch: Throwable -> L129 Exception -> L131
    L120:
        e = e;
    L156:
    L145:
        th = move-exception;
        Throwable r7 = th;
        int r0 = 0;
    L147:
        String r4 = r12;
    L148:
        long r5 = System.currentTimeMillis() - r3;
        if (r1 != null) goto L152;
        r1 = "";
    L152:
        PseudoIDEventTrace.eventTrace(r0, 1, r4, r1, r5);
        throw r7;
    L135:
        if (e.getMessage() != null) goto L137;
        String r8 = e.getClass().getSimpleName();     // Catch: Throwable -> L145
    L138:
        LogUtils.e(TAG, "getPseudoUID failed, error: " + r8);     // Catch: Throwable -> L145
        long r14 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L142;
        String r13 = r1;
    L143:
        PseudoIDEventTrace.eventTrace(0, 1, r12, r13, r14);
        return null;
    L142:
        r13 = "";
        goto L143
    L137:
        r8 = e.getMessage();     // Catch: Throwable -> L145
    L118:
        th = move-exception;
        r7 = th;
        r0 = 0;
        goto L147
    L8:
        if (r18.isEmpty() == false) goto L10;
    L111:
        LogUtils.e(r6, "AppId size is invalid!!");     // Catch: Throwable -> L118 Exception -> L120
        long r15 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L115;
        String r16 = r1;
    L116:
        PseudoIDEventTrace.eventTrace(-3, 1, r12, r16, r15);
        return null;
    L115:
        r16 = "";
        goto L116
    L10:
        if (r18.length() > 128) goto L111;
        if (AccountApi.INSTANCE.isLogin() == true) goto L21;
        LogUtils.e(r6, "Account is not login, no userId!!");     // Catch: Throwable -> L118 Exception -> L120
        long r19 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L18;
        String r110 = r1;
    L19:
        PseudoIDEventTrace.eventTrace(-20, 1, r12, r110, r19);
        return null;
    L18:
        r110 = "";
        goto L19
    L21:
        String r9 = AccountApi.INSTANCE.getUserId();     // Catch: Throwable -> L118 Exception -> L120
        if (r9.isEmpty() == false) goto L30;
        LogUtils.e(r6, "Account is login, but userId is empty!");     // Catch: Throwable -> L118 Exception -> L120
        long r111 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L27;
        String r112 = r1;
    L28:
        PseudoIDEventTrace.eventTrace(-5, 1, r12, r112, r111);
        return null;
    L27:
        r112 = "";
        goto L28
    L30:
        int r10 = -7;
        if (PrivacyConfig.isDebug() == false) goto L43;
        if (PrivacyConfig.isForceFetchFromCloud(1) == false) goto L43;
        LogUtils.d(r6, " getPseudoUID forceFetchFromCloud enabled, skip local check.");     // Catch: Throwable -> L118 Exception -> L120
        String r11 = r18.intern();     // Catch: Throwable -> L118 Exception -> L120
        monitor-enter(r11);     // Catch: Throwable -> L118 Exception -> L120
        deletePseudoIDs(r2, r1);     // Catch: Throwable -> L39
        monitor-exit(r11);     // Catch: Throwable -> L39
    L55:
        LogUtils.i(r6, "need to get pseudoID from cloud");     // Catch: Throwable -> L118 Exception -> L120
        String r20 = AccountApi.INSTANCE.getDeviceId();     // Catch: Throwable -> L118 Exception -> L120
        if (r20.isEmpty() == false) goto L64;
        LogUtils.e(r6, "getPseudoUID, DID is empty!");     // Catch: Throwable -> L118 Exception -> L120
        long r113 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L61;
        String r114 = r1;
    L62:
        PseudoIDEventTrace.eventTrace(-4, 1, r12, r114, r113);
        return null;
    L61:
        r114 = "";
        goto L62
    L64:
        String r115 = r18.intern();     // Catch: Throwable -> L118 Exception -> L120
        monitor-enter(r115);     // Catch: Throwable -> L118 Exception -> L120
    L108:
        th = th;
    L109:
        monitor-exit(r115);     // Catch: Throwable -> L108
        throw th;     // Catch: Throwable -> L118 Exception -> L120
    L154:
        if (isRPUIDExist(r2, r1, r9) == false) goto L83;
        String r21 = queryRPUID(r2, r1, r9);     // Catch: Throwable -> L108
    L81:
        th = th;
        goto L109
    L70:
        if (TextUtils.isEmpty(r21) == false) goto L73;
        LogUtils.e(r6, "RPUID is already stored, but query failed!");     // Catch: Throwable -> L81
    L74:
        monitor-exit(r115);     // Catch: Throwable -> L104
        long r116 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L78;
        String r117 = r1;
    L79:
        PseudoIDEventTrace.eventTrace(r10, 1, r12, r117, r116);
        return r21;
    L78:
        r117 = "";
        goto L79
    L73:
        r10 = 0;
        goto L74
    L83:
        r10 = getPseudoIDFromCloud(r2, r20, r9, r1);     // Catch: Throwable -> L108
        if (r10 == 0) goto L93;
        LogUtils.e(r6, "get pseudoID from cloud failed, error: " + r10);     // Catch: Throwable -> L106
        monitor-exit(r115);     // Catch: Throwable -> L106
        long r118 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L90;
        String r119 = r1;
    L91:
        PseudoIDEventTrace.eventTrace(r10, 1, r12, r119, r118);
        return null;
    L90:
        r119 = "";
        goto L91
    L93:
        String r22 = queryRPUID(r2, r1, r9);     // Catch: Throwable -> L106
        if (TextUtils.isEmpty(r22) == false) goto L97;
        LogUtils.e(r6, "RPUID store success, but query failed!");     // Catch: Throwable -> L104
    L97:
        monitor-exit(r115);     // Catch: Throwable -> L104
        long r120 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L101;
        String r121 = r1;
    L102:
        PseudoIDEventTrace.eventTrace(r10, 1, r12, r121, r120);
        return r22;
    L101:
        r121 = "";
    L106:
        th = th;
    L104:
        th = th;
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L118 Exception -> L120
    L43:
        if (isRPUIDExist(r2, r1, r9) == false) goto L55;
        String r23 = queryRPUID(r2, r1, r9);     // Catch: Throwable -> L118 Exception -> L120
        if (TextUtils.isEmpty(r23) == false) goto L48;
        LogUtils.e(r6, "RPUID is already stored, but query failed!");     // Catch: Throwable -> L118 Exception -> L120
    L49:
        long r122 = System.currentTimeMillis() - r3;
        if (r1 == null) goto L52;
        String r123 = r1;
    L53:
        PseudoIDEventTrace.eventTrace(r10, 1, r12, r123, r122);
        return r23;
    L52:
        r123 = "";
        goto L53
    L48:
        r10 = 0;
    L122:
        LogUtils.e(r6, "Context or app Id is null!!");     // Catch: Throwable -> L129 Exception -> L131
        long r24 = System.currentTimeMillis() - r3;
        if (r1 != null) goto L127;
        r1 = "";
    L127:
        PseudoIDEventTrace.eventTrace(-2, 1, "", r1, r24);
        return null;
    L131:
        e = e;
        r12 = "";
    L129:
        th = move-exception;
        r7 = th;
        r4 = "";
        r0 = 0;
        goto L148
    }

    private int getPseudoIDFromCloud(Context r3, String r4, String r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L14;
        if (r6 == null) goto L14;
        if (r4 != null) goto L8;
    L12:
        LogUtils.e(TAG, "deviceId cannot be empty!!");
        return -2;
    L8:
        if (r4.isEmpty() == true) goto L12;
        return requestPseudoID(r7, r4, r5, r6);
    L14:
        LogUtils.e(TAG, "context or appID is null!!");
        return -2;
    }

    private int requestPseudoID(Context r10, String r11, String r12, String r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        String r6 = TAG;
        LogUtils.d(r6, "request PseudoID, PackageName: " + r14.getPackageName());
        LogUtils.d(r6, "request PseudoID, appId:" + r13);
        LogUtils.d(r6, "request PseudoID, deviceId:" + r11);
        if (r12.isEmpty() == true) goto L5;
        LogUtils.d(r6, "request PseudoID, userId:" + r12);
    L5:
        NetworkRequest r7 = new NetworkRequest();
        r7.setRequestType("POST");
        r7.setRequestUrl(NetworkManager.getPseudoIDUrl());
        int r8 = 0;
        AttestKeyManager.getInstance().deleteAttestKey(r14, r13);
        Bundle r5 = new Bundle();
        r5.putInt(SecurityFrameworkCompat.keyAlgoKey(), SecurityFrameworkCompat.keyAlgorithmEcc());
        r5.putInt(SecurityFrameworkCompat.keyLenKey(), 256);
        r5.putInt(SecurityFrameworkCompat.keyPurposeKey(), SecurityFrameworkCompat.purposeAttestKey());
        List<Certificate> r0 = AttestKeyManager.getInstance().getAttestCertChain(r14, r13, r11, false, r5);
        int r1 = -22;
        if (r0 != null) goto L8;
    L40:
        LogUtils.e(r6, "Get attest cert chain failed!!");
        r1 = -9;
    L41:
        AttestKeyManager.getInstance().deleteAttestKey(r14, r13);
        LogUtils.i(TAG, "requestPseudoID end, result:" + r1);
        return r1;
    L8:
        if (r0.isEmpty() == true) goto L40;
        r7.setCertChain(CertUtils.certsToPemString(r0, 3));     // Catch: Exception -> L38
        NetworkResponse r2 = NetworkManager.getInstance().executeRequest(r7);
        LogUtils.d(r6, "response code:" + r2.getCode());
        LogUtils.d(r6, "response msg:" + r2.getMessage());
        if (r2.getCode() >= 200) goto L15;
    L37:
        LogUtils.e(r6, "Network request failed, error code:" + r2.getCode());
        r1 = -21;
        goto L41
    L15:
        if (r2.getCode() >= 300) goto L37;
        if (r2.getPseudoID() != null) goto L20;
        LogUtils.e(r6, "Network response pseudoID is null!");
        r1 = -8;
        goto L41
    L20:
        LogUtils.d(r6, "PRDID:" + r2.getPseudoID().getRPDID());
        LogUtils.d(r6, "PRUID:" + r2.getPseudoID().getRPUID());
        if (r11.isEmpty() == true) goto L29;
        if (r2.getPseudoID().getRPDID().isEmpty() == false) goto L25;
        LogUtils.e(r6, "Network response RPDID is empty!!");
        goto L41
    L25:
        r8 = storePseudoDID(r14, r13, r11, r2.getPseudoID().getRPDID());
        if (r8 == 0) goto L29;
        LogUtils.e(r6, "storePseudoDID failed!, result:" + r8);
    L36:
        r1 = r8;
    L29:
        if (r12.isEmpty() == true) goto L36;
        if (r2.getPseudoID().getRPUID().isEmpty() == false) goto L33;
        LogUtils.e(r6, "Network response RPUID is empty!!");
        goto L41
    L33:
        r1 = storePseudoUID(r14, r13, r12, r2.getPseudoID().getRPUID());
        if (r1 == 0) goto L41;
        LogUtils.e(r6, "storePseudoUID failed!, result:" + r1);
    L38:
        e = move-exception;
        LogUtils.e(TAG, "Set certificate chain failed!! error:" + e.getMessage());
        r1 = -100;
        goto L41
    }

    private boolean isRPDIDExist(Context r3, String r4, String r5) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Bundle r6 = new Bundle();
        r6.putInt(SecurityFrameworkCompat.secretBundleKeyQueryMode(), SecurityFrameworkCompat.queryModeIfDataExist());
        SecurityFrameworkCompat.SecretQueryResult r7 = SecurityFrameworkCompat.querySecretData(r2, RPIDStoreConfig.buildRPDIDAlias(r4, r5), r6);
        if (r7.isNull() == false) goto L5;
        return false;
    L5:
        if (r7.getResultCode() != 0) goto L11;
        return true;
    L11:
        return false;
    }

    private boolean isDeviceIdExist(Context r3, String r4, String r5) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Bundle r6 = new Bundle();
        r6.putInt(SecurityFrameworkCompat.secretBundleKeyQueryMode(), SecurityFrameworkCompat.queryModeIfDataExist());
        SecurityFrameworkCompat.SecretQueryResult r7 = SecurityFrameworkCompat.querySecretData(r2, RPIDStoreConfig.buildDeviceIdAlias(r4, r5), r6);
        if (r7.isNull() == false) goto L5;
        return false;
    L5:
        if (r7.getResultCode() != 0) goto L11;
        return true;
    L11:
        return false;
    }

    private boolean isRPUIDExist(Context r3, String r4, String r5) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Bundle r6 = new Bundle();
        r6.putInt(SecurityFrameworkCompat.secretBundleKeyQueryMode(), SecurityFrameworkCompat.queryModeIfDataExist());
        SecurityFrameworkCompat.SecretQueryResult r7 = SecurityFrameworkCompat.querySecretData(r2, RPIDStoreConfig.buildRPUIDAlias(r4, r5), r6);
        if (r7.isNull() == false) goto L5;
        return false;
    L5:
        if (r7.getResultCode() != 0) goto L11;
        return true;
    L11:
        return false;
    }

    private String queryRPDID(Context r3, String r4, String r5) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Bundle r6 = new Bundle();
        r6.putInt(SecurityFrameworkCompat.secretBundleKeyQueryMode(), SecurityFrameworkCompat.queryModePreciseQueryAndDecrypt());
        SecurityFrameworkCompat.SecretQueryResult r7 = SecurityFrameworkCompat.querySecretData(r2, RPIDStoreConfig.buildRPDIDAlias(r4, r5), r6);
        if (r7.isNull() == false) goto L5;
    L15:
        LogUtils.e(TAG, "Query RPDID failed!!");
        return null;
    L5:
        if (r7.getResultCode() != 0) goto L15;
        String r8 = r7.getFirstPrivateData();
        if (r8 != null) goto L10;
    L13:
        LogUtils.e(TAG, "Query success, but RPDID is null!!");
        return null;
    L10:
        if (r8.isEmpty() == true) goto L13;
        return r8;
    }

    public String queryDIDFromRPDID(Context r4, String r5, String r6) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L31;
        if (r5 == null) goto L31;
        if (r6 == null) goto L31;
        if (r5.isEmpty() == false) goto L10;
    L29:
        LogUtils.e(TAG, "AppId or rpDID size is invalid!!");
        return null;
    L10:
        if (r5.length() > 128) goto L29;
        if (r6.isEmpty() == true) goto L29;
        Bundle r0 = new Bundle();
        r0.putInt(SecurityFrameworkCompat.secretBundleKeyQueryMode(), SecurityFrameworkCompat.queryModePreciseQueryAndDecrypt());
        SecurityFrameworkCompat.SecretQueryResult r7 = SecurityFrameworkCompat.querySecretData(r3, RPIDStoreConfig.buildDeviceIdAlias(r5, r6), r0);
        if (r7.isNull() == false) goto L17;
    L27:
        LogUtils.e(TAG, "Query original deviceId failed!!");
        return null;
    L17:
        if (r7.getResultCode() != 0) goto L27;
        String r8 = r7.getFirstPrivateData();
        if (r8 != null) goto L22;
    L25:
        LogUtils.e(TAG, "Query success, but original deviceId is null!!");
        return null;
    L22:
        if (r8.isEmpty() == true) goto L25;
        return r8;
    L31:
        LogUtils.e(TAG, "input param is null!!");
        return null;
    }

    private String queryRPUID(Context r3, String r4, String r5) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Bundle r6 = new Bundle();
        r6.putInt(SecurityFrameworkCompat.secretBundleKeyQueryMode(), SecurityFrameworkCompat.queryModePreciseQueryAndDecrypt());
        SecurityFrameworkCompat.SecretQueryResult r7 = SecurityFrameworkCompat.querySecretData(r2, RPIDStoreConfig.buildRPUIDAlias(r4, r5), r6);
        if (r7.isNull() == false) goto L5;
    L15:
        LogUtils.e(TAG, "Query RPUID failed!!");
        return null;
    L5:
        if (r7.getResultCode() != 0) goto L15;
        String r8 = r7.getFirstPrivateData();
        if (r8 != null) goto L10;
    L13:
        LogUtils.e(TAG, "Query success, but RPUID is null!!");
        return null;
    L10:
        if (r8.isEmpty() == true) goto L13;
        return r8;
    }

    private int storePseudoDID(Context r10, String r11, String r12, String r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        if (isRPDIDExist(r14, r11, r12) == true) goto L12;
        int r0 = SecurityFrameworkCompat.addSecretData(r14, r13, r11, RPIDStoreConfig.buildRPDIDAlias(r11, r12), "RPDID", new Bundle());
        if (r0 != (-1)) goto L8;
        LogUtils.e(TAG, "addSecretData failed, SecretDataManager service error");
        return -14;
    L8:
        if (r0 == 0) goto L12;
        LogUtils.e(TAG, "Store RPDID failed!! result: " + r0);
        return r0;
    L12:
        if (isDeviceIdExist(r14, r11, r13) == true) goto L20;
        int r9 = SecurityFrameworkCompat.addSecretData(r14, r12, r11, RPIDStoreConfig.buildDeviceIdAlias(r11, r13), "DID", new Bundle());
        if (r9 != (-1)) goto L17;
        LogUtils.e(TAG, "addSecretData failed, SecretDataManager service error");
        return -14;
    L17:
        if (r9 == 0) goto L22;
        LogUtils.e(TAG, "Store deviceID failed!! result: " + r9);
        return r9;
    L22:
        return 0;
    L20:
        return 0;
    }

    private int storePseudoUID(Context r7, String r8, String r9, String r10) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        if (isRPUIDExist(r0, r8, r9) == true) goto L11;
        int r6 = SecurityFrameworkCompat.addSecretData(r0, r10, r8, RPIDStoreConfig.buildRPUIDAlias(r8, r9), "RPUID", new Bundle());
        if (r6 != (-1)) goto L8;
        LogUtils.e(TAG, "addSecretData failed, SecretDataManager service error");
        return -14;
    L8:
        if (r6 == 0) goto L13;
        LogUtils.e(TAG, "Store RPUID failed!! result: " + r6);
        return r6;
    L13:
        return 0;
    L11:
        return 0;
    }

    private void deletePseudoIDs(Context r6, String r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        if (PrivacyConfig.isDebug() == false) goto L29;
        String r0 = AccountApi.INSTANCE.getDeviceId();
        if (isRPDIDExist(r8, r7, r0) == false) goto L22;
        String r1 = queryRPDID(r8, r7, r0);
        if (r1 != null) goto L9;
    L19:
        LogUtils.e(TAG, "RPDID is already stored, but query failed!");
        return;
    L9:
        if (r1.isEmpty() == true) goto L19;
        if (isDeviceIdExist(r8, r7, r1) == false) goto L16;
        int r2 = SecurityFrameworkCompat.deleteSecretData(r8, RPIDStoreConfig.buildDeviceIdAlias(r7, r1), new Bundle());
        if (r2 == 0) goto L16;
        LogUtils.e(TAG, "delete DeviceID failed, result = " + r2);
    L16:
        int r3 = SecurityFrameworkCompat.deleteSecretData(r8, RPIDStoreConfig.buildRPDIDAlias(r7, r0), new Bundle());
        if (r3 == 0) goto L22;
        LogUtils.e(TAG, "delete RPDID failed, result = " + r3);
    L22:
        if (AccountApi.INSTANCE.isLogin() == false) goto L30;
        String r4 = AccountApi.INSTANCE.getUserId();
        if (isRPUIDExist(r8, r7, r4) == false) goto L31;
        int r5 = SecurityFrameworkCompat.deleteSecretData(r8, RPIDStoreConfig.buildRPUIDAlias(r7, r4), new Bundle());
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
