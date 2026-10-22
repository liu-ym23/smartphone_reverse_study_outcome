package com.stepos.policy.sdk;

import android.content.Context;
import fc.c;
import java.lang.invoke.VarHandle;
import t.i1;
import v3.f;
import y3.e;
import yb.o;
import yb.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicyManagerKt {
    static final /* synthetic */ c[] $$delegatedProperties;
    private static e KEY_AGREE_STATUS;
    private static e KEY_COMMON_DELETE_INFO_JSON;
    private static e KEY_POLICY_OPERATE;
    private static e KEY_POLICY_OPERATE_JSON;
    private static e KEY_READ_CLIPBOARD_STATUS;
    private static final bc.a policySdkDataStore$delegate;

    static {
        o oVar = new o(PolicyManagerKt.class, "policySdkDataStore", "getPolicySdkDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1);
        v.f16099a.getClass();
        $$delegatedProperties = new c[]{oVar};
        policySdkDataStore$delegate = i1.q("policy_sdk_data");
        KEY_POLICY_OPERATE = t.o.b("policyOperate");
        KEY_POLICY_OPERATE_JSON = t.o.n("policyOperateRequestJson");
        e eVar = new e();
        eVar.f15891a = "readClipboardStatus";
        VarHandle.storeStoreFence();
        KEY_READ_CLIPBOARD_STATUS = eVar;
        e eVar2 = new e();
        eVar2.f15891a = "agreeStatus";
        VarHandle.storeStoreFence();
        KEY_AGREE_STATUS = eVar2;
        KEY_COMMON_DELETE_INFO_JSON = t.o.n("commonDeleteInfoJson");
    }

    public static final e getKEY_AGREE_STATUS() {
        return KEY_AGREE_STATUS;
    }

    public static final e getKEY_COMMON_DELETE_INFO_JSON() {
        return KEY_COMMON_DELETE_INFO_JSON;
    }

    public static final e getKEY_POLICY_OPERATE() {
        return KEY_POLICY_OPERATE;
    }

    public static final e getKEY_POLICY_OPERATE_JSON() {
        return KEY_POLICY_OPERATE_JSON;
    }

    public static final e getKEY_READ_CLIPBOARD_STATUS() {
        return KEY_READ_CLIPBOARD_STATUS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f getPolicySdkDataStore(Context context) {
        return ((x3.b) policySdkDataStore$delegate).a(context, $$delegatedProperties[0]);
    }

    public static final void setKEY_AGREE_STATUS(e eVar) {
        eVar.getClass();
        KEY_AGREE_STATUS = eVar;
    }

    public static final void setKEY_COMMON_DELETE_INFO_JSON(e eVar) {
        eVar.getClass();
        KEY_COMMON_DELETE_INFO_JSON = eVar;
    }

    public static final void setKEY_POLICY_OPERATE(e eVar) {
        eVar.getClass();
        KEY_POLICY_OPERATE = eVar;
    }

    public static final void setKEY_POLICY_OPERATE_JSON(e eVar) {
        eVar.getClass();
        KEY_POLICY_OPERATE_JSON = eVar;
    }

    public static final void setKEY_READ_CLIPBOARD_STATUS(e eVar) {
        eVar.getClass();
        KEY_READ_CLIPBOARD_STATUS = eVar;
    }
}
