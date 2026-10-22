package com.stepos.policy.sdk.manager;

import La.C0953c;
import Y8.j;
import Y8.t;
import Z8.C1173v;
import Z8.F;
import Z8.Q;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.stepos.policy.sdk.bean.CustomDeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoEncryptMultiBean;
import com.stepos.policy.sdk.bean.KeyInfo;
import com.stepos.policy.sdk.impl.WithdrawalImpl;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.secureservice.certification.IEncryptCallback;
import com.stepos.secureservice.certification.IEncryptMultiCallback;
import com.stepos.secureservice.certification.ISafeCertService;
import com.stepos.secureservice.policy.IPolicyBindCallback;
import com.stepos.secureservice.policy.IPolicyBindResult;
import com.stepos.secureservice.policy.IPolicyBindService;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ;\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012JW\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2&\u0010\u0010\u001a\"\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016\u0012\u0004\u0012\u00020\b0\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018JC\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0014j\b\u0012\u0004\u0012\u00020\u0019`\u00162\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u000fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJC\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u0014j\b\u0012\u0004\u0012\u00020\u001d`\u00162\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u000fH\u0016¢\u0006\u0004\b\u001e\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/stepos/policy/sdk/manager/WithdrawalManager;", "Lcom/stepos/policy/sdk/impl/WithdrawalImpl;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/ServiceConnection;", Const.STR_DEBUG_TAG_BINDSERVICE, "LY8/t;", "activityLifecycleCallbacks", "(Landroid/content/Context;Landroid/content/ServiceConnection;)V", "", "businessType", "", "deleteType", "Lkotlin/Function1;", "callBackPolicyResult", "getCommonDeleteInfoListBySecure", "(Landroid/content/Context;Ljava/lang/String;ILp9/l;)V", "appId", "Ljava/util/ArrayList;", "Lcom/stepos/policy/sdk/bean/DeleteInfoBean;", "Lkotlin/collections/ArrayList;", "getPrivateDeleteInfoListBySecure", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILp9/l;)V", "Lcom/stepos/policy/sdk/bean/DeleteInfoEncryptMultiBean;", "customDeleteInfoList", "encryptMultiCustomDeleteInfoListBySecure", "(Landroid/content/Context;Ljava/util/ArrayList;Lp9/l;)V", "Lcom/stepos/policy/sdk/bean/CustomDeleteInfoBean;", "encryptCustomDeleteInfoListBySecure", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WithdrawalManager implements WithdrawalImpl {
    public static final WithdrawalManager INSTANCE = new WithdrawalManager();

    private WithdrawalManager() {
    }

    private final void activityLifecycleCallbacks(final Context context, final ServiceConnection bindService) {
        try {
            if (context instanceof Activity) {
                ((Activity) context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager.activityLifecycleCallbacks.1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                        p.i(activity, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                        p.i(activity, "activity");
                        PolicySdkLogUtils.INSTANCE.d("WithdrawalManager", "onActivityDestroyed");
                        context.unbindService(bindService);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                        p.i(activity, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                        p.i(activity, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                        p.i(activity, "activity");
                        p.i(outState, "outState");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                        p.i(activity, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                        p.i(activity, "activity");
                    }
                });
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" exception : ");
            e10.getMessage();
            t tVar = t.f7040a;
            sb2.append(e10);
            companion.e("activityLifecycleCallbacks", sb2.toString());
        }
    }

    @Override // com.stepos.policy.sdk.impl.WithdrawalImpl
    public void encryptCustomDeleteInfoListBySecure(Context context, final ArrayList<CustomDeleteInfoBean> customDeleteInfoList, final InterfaceC5074l<? super DeleteInfoBean, t> callBackPolicyResult) {
        p.i(context, "context");
        p.i(customDeleteInfoList, "customDeleteInfoList");
        p.i(callBackPolicyResult, "callBackPolicyResult");
        try {
            PolicySdkLogUtils.INSTANCE.d("getCustomDeleteInfoList " + customDeleteInfoList);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.stepos.secureservice", "com.stepos.secureservice.certification.SafeCertService"));
            intent.setAction("com.stepos.secureservice.SafeCertification");
            ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$encryptCustomDeleteInfoListBySecure$bindService$1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName name, IBinder service) throws RemoteException {
                    p.i(service, "service");
                    ISafeCertService iSafeCertServiceAsInterface = ISafeCertService.Stub.asInterface(service);
                    Iterator<CustomDeleteInfoBean> it = customDeleteInfoList.iterator();
                    while (it.hasNext()) {
                        final CustomDeleteInfoBean next = it.next();
                        String bindIdValue = next.getBindIdValue();
                        final Gson gson = new Gson();
                        byte[] bytes = bindIdValue.getBytes(C0953c.UTF_8);
                        p.h(bytes, "this as java.lang.String).getBytes(charset)");
                        final long j10 = jCurrentTimeMillis;
                        final InterfaceC5074l<DeleteInfoBean, t> interfaceC5074l = callBackPolicyResult;
                        iSafeCertServiceAsInterface.encrypt(bytes, new IEncryptCallback.Stub() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$encryptCustomDeleteInfoListBySecure$bindService$1$onServiceConnected$1
                            @Override // com.stepos.secureservice.certification.IEncryptCallback
                            public void onErrored(String msg) {
                            }

                            @Override // com.stepos.secureservice.certification.IEncryptCallback
                            public void onGet(byte[] encrypted, String keyId, int keyVersion, int keyLevel, String extra) {
                                long jCurrentTimeMillis2 = System.currentTimeMillis();
                                PolicySdkLogUtils.INSTANCE.d("getCustomDeleteInfoList", "耗时 " + (jCurrentTimeMillis2 - j10) + " | serviceId = " + next.getServiceId() + "  | keyId = " + keyId + " keyVersion =" + keyVersion + " keyLevel=" + keyLevel + " | extra = " + extra);
                                if (keyId == null || encrypted == null) {
                                    return;
                                }
                                String keyInfoJson = gson.toJson(new KeyInfo(keyId, String.valueOf(keyVersion), String.valueOf(keyLevel), String.valueOf(extra)));
                                String strEncodeToString = Base64.getUrlEncoder().encodeToString(encrypted);
                                p.h(strEncodeToString, "getUrlEncoder().encodeToString(encrypted)");
                                Map mapF = Q.f(j.a(next.getBindIdKey(), strEncodeToString));
                                String serviceId = next.getServiceId();
                                String json = gson.toJson(mapF);
                                p.h(json, "gson.toJson(map)");
                                p.h(keyInfoJson, "keyInfoJson");
                                interfaceC5074l.invoke(new DeleteInfoBean(serviceId, json, keyInfoJson));
                            }
                        });
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName name) {
                }
            };
            context.bindService(intent, serviceConnection, 1);
            activityLifecycleCallbacks(context, serviceConnection);
        } catch (Exception e10) {
            e10.printStackTrace();
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" exception : ");
            e10.getMessage();
            t tVar = t.f7040a;
            sb2.append(e10);
            companion.e("getCommonDeleteInfoList", sb2.toString());
        }
    }

    @Override // com.stepos.policy.sdk.impl.WithdrawalImpl
    public void encryptMultiCustomDeleteInfoListBySecure(Context context, final ArrayList<DeleteInfoEncryptMultiBean> customDeleteInfoList, final InterfaceC5074l<? super DeleteInfoBean, t> callBackPolicyResult) {
        p.i(context, "context");
        p.i(customDeleteInfoList, "customDeleteInfoList");
        p.i(callBackPolicyResult, "callBackPolicyResult");
        try {
            PolicySdkLogUtils.INSTANCE.d("encryptMultiCustomDeleteInfoListBySecure " + customDeleteInfoList);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.stepos.secureservice", "com.stepos.secureservice.certification.SafeCertService"));
            intent.setAction("com.stepos.secureservice.SafeCertification");
            ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$encryptMultiCustomDeleteInfoListBySecure$bindService$1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName name, IBinder service) throws RemoteException {
                    Collection<String> collectionValues;
                    List<String> listM1;
                    p.i(service, "service");
                    ISafeCertService iSafeCertServiceAsInterface = ISafeCertService.Stub.asInterface(service);
                    List<String> listM = C1173v.m();
                    Iterator<DeleteInfoEncryptMultiBean> it = customDeleteInfoList.iterator();
                    while (it.hasNext()) {
                        final DeleteInfoEncryptMultiBean next = it.next();
                        LinkedHashMap<String, String> bindMap = next.getBindMap();
                        if (bindMap != null && (collectionValues = bindMap.values()) != null && (listM1 = F.m1(collectionValues)) != null) {
                            listM = listM1;
                        }
                        final Gson gson = new Gson();
                        final long j10 = jCurrentTimeMillis;
                        final InterfaceC5074l<DeleteInfoBean, t> interfaceC5074l = callBackPolicyResult;
                        iSafeCertServiceAsInterface.encryptMulti(listM, new IEncryptMultiCallback.Stub() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$encryptMultiCustomDeleteInfoListBySecure$bindService$1$onServiceConnected$2
                            @Override // com.stepos.secureservice.certification.IEncryptMultiCallback
                            public void onErrored(String msg) {
                            }

                            @Override // com.stepos.secureservice.certification.IEncryptMultiCallback
                            public void onGet(List<String> encrypted, String keyId, int keyVersion, int keyLevel, String extra) {
                                long jCurrentTimeMillis2 = System.currentTimeMillis();
                                PolicySdkLogUtils.INSTANCE.d("encryptMultiCustomDeleteInfoListBySecure", "耗时 " + (jCurrentTimeMillis2 - j10) + " | encrypted = " + encrypted + "  | keyId = " + keyId + " keyVersion =" + keyVersion + " keyLevel=" + keyLevel + " | extra = " + extra);
                                if (keyId == null || encrypted == null) {
                                    return;
                                }
                                LinkedHashMap<String, String> bindMap2 = next.getBindMap();
                                if (bindMap2 != null) {
                                    int i10 = 0;
                                    for (String key : bindMap2.keySet()) {
                                        int i11 = i10 + 1;
                                        if (i10 < encrypted.size()) {
                                            p.h(key, "key");
                                            bindMap2.put(key, encrypted.get(i10));
                                        }
                                        i10 = i11;
                                    }
                                }
                                PolicySdkLogUtils.INSTANCE.d("encryptMultiCustomDeleteInfoListBySecure", "  encrypted groupBy= " + next.getBindMap() + ' ');
                                String keyInfoJson = gson.toJson(new KeyInfo(keyId, String.valueOf(keyVersion), String.valueOf(keyLevel), String.valueOf(extra)));
                                String bindIdJson = gson.toJson(next.getBindMap());
                                String serviceId = next.getServiceId();
                                p.h(bindIdJson, "bindIdJson");
                                p.h(keyInfoJson, "keyInfoJson");
                                interfaceC5074l.invoke(new DeleteInfoBean(serviceId, bindIdJson, keyInfoJson));
                            }
                        });
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName name) {
                }
            };
            context.bindService(intent, serviceConnection, 1);
            activityLifecycleCallbacks(context, serviceConnection);
        } catch (Exception e10) {
            e10.printStackTrace();
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" exception : ");
            e10.getMessage();
            t tVar = t.f7040a;
            sb2.append(e10);
            companion.e("encryptMultiCustomDeleteInfoListBySecure", sb2.toString());
        }
    }

    @Override // com.stepos.policy.sdk.impl.WithdrawalImpl
    public void getCommonDeleteInfoListBySecure(Context context, final String businessType, final int deleteType, final InterfaceC5074l<? super String, t> callBackPolicyResult) {
        p.i(context, "context");
        p.i(businessType, "businessType");
        p.i(callBackPolicyResult, "callBackPolicyResult");
        try {
            PolicySdkLogUtils.INSTANCE.d("getCommonDeleteInfoList");
            final long jCurrentTimeMillis = System.currentTimeMillis();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.stepos.secureservice", "com.stepos.secureservice.policy.PolicyBindService"));
            intent.setAction("com.stepos.secureservice.PolicyBind");
            ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$getCommonDeleteInfoListBySecure$bindService$1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName name, IBinder service) throws RemoteException {
                    p.i(service, "service");
                    IPolicyBindService iPolicyBindServiceAsInterface = IPolicyBindService.Stub.asInterface(service);
                    final long j10 = jCurrentTimeMillis;
                    final InterfaceC5074l<String, t> interfaceC5074l = callBackPolicyResult;
                    iPolicyBindServiceAsInterface.getPublicConfig(new IPolicyBindCallback.Stub() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$getCommonDeleteInfoListBySecure$bindService$1$onServiceConnected$1
                        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
                        public void onErrored(String msg) {
                        }

                        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
                        public void onGet(List<IPolicyBindResult> results, String keyId, int keyVersion, int keyLevel, String extra) {
                            p.i(results, "results");
                            p.i(keyId, "keyId");
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            PolicySdkLogUtils.INSTANCE.d("getCommonDeleteInfoList", "耗时 " + (jCurrentTimeMillis2 - j10) + " | results = " + results + " \n | keyId = " + keyId + " keyVersion =" + keyVersion + " keyLevel=" + keyLevel + " | extra = " + extra);
                            Gson gson = new Gson();
                            ArrayList arrayList = new ArrayList();
                            String keyInfoJson = gson.toJson(new KeyInfo(keyId, String.valueOf(keyVersion), String.valueOf(keyLevel), String.valueOf(extra)));
                            for (IPolicyBindResult iPolicyBindResult : results) {
                                String strValueOf = String.valueOf(iPolicyBindResult.serverId);
                                String str = iPolicyBindResult.bindId;
                                p.h(str, "policyBindResult.bindId");
                                p.h(keyInfoJson, "keyInfoJson");
                                arrayList.add(new DeleteInfoBean(strValueOf, str, keyInfoJson));
                            }
                            String deleteInfoListJson = gson.toJson(arrayList);
                            InterfaceC5074l<String, t> interfaceC5074l2 = interfaceC5074l;
                            p.h(deleteInfoListJson, "deleteInfoListJson");
                            interfaceC5074l2.invoke(deleteInfoListJson);
                        }
                    }, businessType, deleteType);
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName name) {
                }
            };
            context.bindService(intent, serviceConnection, 1);
            activityLifecycleCallbacks(context, serviceConnection);
        } catch (Exception e10) {
            e10.printStackTrace();
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" exception : ");
            e10.getMessage();
            t tVar = t.f7040a;
            sb2.append(e10);
            companion.e("getCommonDeleteInfoList", sb2.toString());
        }
    }

    @Override // com.stepos.policy.sdk.impl.WithdrawalImpl
    public void getPrivateDeleteInfoListBySecure(Context context, final String appId, final String businessType, final int deleteType, final InterfaceC5074l<? super ArrayList<DeleteInfoBean>, t> callBackPolicyResult) {
        p.i(context, "context");
        p.i(appId, "appId");
        p.i(businessType, "businessType");
        p.i(callBackPolicyResult, "callBackPolicyResult");
        try {
            PolicySdkLogUtils.INSTANCE.d("getPrivateDeleteInfoList");
            final long jCurrentTimeMillis = System.currentTimeMillis();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.stepos.secureservice", "com.stepos.secureservice.policy.PolicyBindService"));
            intent.setAction("com.stepos.secureservice.PolicyBind");
            ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$getPrivateDeleteInfoListBySecure$bindService$1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName name, IBinder service) throws RemoteException {
                    p.i(service, "service");
                    IPolicyBindService iPolicyBindServiceAsInterface = IPolicyBindService.Stub.asInterface(service);
                    final long j10 = jCurrentTimeMillis;
                    final InterfaceC5074l<ArrayList<DeleteInfoBean>, t> interfaceC5074l = callBackPolicyResult;
                    iPolicyBindServiceAsInterface.getPrivateConfig(new IPolicyBindCallback.Stub() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$getPrivateDeleteInfoListBySecure$bindService$1$onServiceConnected$1
                        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
                        public void onErrored(String msg) {
                        }

                        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
                        public void onGet(List<IPolicyBindResult> results, String keyId, int keyVersion, int keyLevel, String extra) {
                            p.i(results, "results");
                            p.i(keyId, "keyId");
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            PolicySdkLogUtils.INSTANCE.d("getPrivateDeleteInfoList", "耗时 " + (jCurrentTimeMillis2 - j10) + " | results = " + results + " \n | keyId = " + keyId + " keyVersion =" + keyVersion + " keyLevel=" + keyLevel + " | extra = " + extra);
                            Gson gson = new Gson();
                            ArrayList<DeleteInfoBean> arrayList = new ArrayList<>();
                            String keyInfoJson = gson.toJson(new KeyInfo(keyId, String.valueOf(keyVersion), String.valueOf(keyLevel), String.valueOf(extra)));
                            for (IPolicyBindResult iPolicyBindResult : results) {
                                if (iPolicyBindResult.publicFlag == 0) {
                                    String strValueOf = String.valueOf(iPolicyBindResult.serverId);
                                    String str = iPolicyBindResult.bindId;
                                    p.h(str, "policyBindResult.bindId");
                                    p.h(keyInfoJson, "keyInfoJson");
                                    arrayList.add(new DeleteInfoBean(strValueOf, str, keyInfoJson));
                                }
                            }
                            interfaceC5074l.invoke(arrayList);
                        }
                    }, businessType, deleteType, appId);
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName name) {
                }
            };
            context.bindService(intent, serviceConnection, 1);
            activityLifecycleCallbacks(context, serviceConnection);
        } catch (Exception e10) {
            e10.printStackTrace();
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" exception : ");
            e10.getMessage();
            t tVar = t.f7040a;
            sb2.append(e10);
            companion.e("getPrivateDeleteInfoList", sb2.toString());
        }
    }
}
