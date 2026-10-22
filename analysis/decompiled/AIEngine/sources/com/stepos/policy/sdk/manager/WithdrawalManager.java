package com.stepos.policy.sdk.manager;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
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
import d5.i;
import gc.a;
import h0.e;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;
import lb.n;
import mb.v;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class WithdrawalManager implements WithdrawalImpl {
    public static final WithdrawalManager INSTANCE = new WithdrawalManager();

    private WithdrawalManager() {
    }

    private final void activityLifecycleCallbacks(final Context context, final ServiceConnection serviceConnection) {
        try {
            if (context instanceof Activity) {
                ((Activity) context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager.activityLifecycleCallbacks.1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        g.f(activity, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                        g.f(activity, "activity");
                        PolicySdkLogUtils.Companion.d("WithdrawalManager", "onActivityDestroyed");
                        context.unbindService(serviceConnection);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                        g.f(activity, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                        g.f(activity, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                        g.f(activity, "activity");
                        g.f(outState, "outState");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                        g.f(activity, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                        g.f(activity, "activity");
                    }
                });
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            StringBuilder sb2 = new StringBuilder(" exception : ");
            e10.getMessage();
            n nVar = n.f10413a;
            sb2.append(e10);
            companion.e("activityLifecycleCallbacks", sb2.toString());
        }
    }

    @Override // com.stepos.policy.sdk.impl.WithdrawalImpl
    public void encryptCustomDeleteInfoListBySecure(Context context, final ArrayList<CustomDeleteInfoBean> customDeleteInfoList, final l<? super DeleteInfoBean, n> callBackPolicyResult) {
        g.f(context, "context");
        g.f(customDeleteInfoList, "customDeleteInfoList");
        g.f(callBackPolicyResult, "callBackPolicyResult");
        try {
            PolicySdkLogUtils.Companion.d("getCustomDeleteInfoList " + customDeleteInfoList);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.stepos.secureservice", "com.stepos.secureservice.certification.SafeCertService"));
            intent.setAction("com.stepos.secureservice.SafeCertification");
            ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$encryptCustomDeleteInfoListBySecure$bindService$1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder service) {
                    g.f(service, "service");
                    ISafeCertService iSafeCertServiceAsInterface = ISafeCertService.Stub.asInterface(service);
                    ArrayList<CustomDeleteInfoBean> arrayList = customDeleteInfoList;
                    int size = arrayList.size();
                    int i10 = 0;
                    while (i10 < size) {
                        CustomDeleteInfoBean customDeleteInfoBean = arrayList.get(i10);
                        i10++;
                        final CustomDeleteInfoBean customDeleteInfoBean2 = customDeleteInfoBean;
                        String bindIdValue = customDeleteInfoBean2.getBindIdValue();
                        final i iVar = new i();
                        byte[] bytes = bindIdValue.getBytes(a.f9106b);
                        g.e(bytes, "this as java.lang.String).getBytes(charset)");
                        final long j10 = jCurrentTimeMillis;
                        final l<DeleteInfoBean, n> lVar = callBackPolicyResult;
                        iSafeCertServiceAsInterface.encrypt(bytes, new IEncryptCallback.Stub() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$encryptCustomDeleteInfoListBySecure$bindService$1$onServiceConnected$1
                            @Override // com.stepos.secureservice.certification.IEncryptCallback
                            public void onGet(byte[] bArr, String str, int i11, int i12, String str2) {
                                long jCurrentTimeMillis2 = System.currentTimeMillis();
                                PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                                StringBuilder sb2 = new StringBuilder("耗时 ");
                                sb2.append(jCurrentTimeMillis2 - j10);
                                sb2.append(" | serviceId = ");
                                sb2.append(customDeleteInfoBean2.getServiceId());
                                sb2.append("  | keyId = ");
                                sb2.append(str);
                                sb2.append(" keyVersion =");
                                e.l(sb2, i11, " keyLevel=", i12, " | extra = ");
                                sb2.append(str2);
                                companion.d("getCustomDeleteInfoList", sb2.toString());
                                if (str == null || bArr == null) {
                                    return;
                                }
                                String keyInfoJson = iVar.h(new KeyInfo(str, String.valueOf(i11), String.valueOf(i12), String.valueOf(str2)));
                                String strEncodeToString = Base64.getUrlEncoder().encodeToString(bArr);
                                g.e(strEncodeToString, "getUrlEncoder().encodeToString(encrypted)");
                                Map mapB0 = v.b0(new Pair(customDeleteInfoBean2.getBindIdKey(), strEncodeToString));
                                String serviceId = customDeleteInfoBean2.getServiceId();
                                String strH = iVar.h(mapB0);
                                g.e(strH, "gson.toJson(map)");
                                g.e(keyInfoJson, "keyInfoJson");
                                lVar.invoke(new DeleteInfoBean(serviceId, strH, keyInfoJson));
                            }

                            @Override // com.stepos.secureservice.certification.IEncryptCallback
                            public void onErrored(String str) {
                            }
                        });
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }
            };
            context.bindService(intent, serviceConnection, 1);
            activityLifecycleCallbacks(context, serviceConnection);
        } catch (Exception e10) {
            e10.printStackTrace();
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            StringBuilder sb2 = new StringBuilder(" exception : ");
            e10.getMessage();
            n nVar = n.f10413a;
            sb2.append(e10);
            companion.e("getCommonDeleteInfoList", sb2.toString());
        }
    }

    @Override // com.stepos.policy.sdk.impl.WithdrawalImpl
    public void encryptMultiCustomDeleteInfoListBySecure(Context context, final ArrayList<DeleteInfoEncryptMultiBean> customDeleteInfoList, final l<? super DeleteInfoBean, n> callBackPolicyResult) {
        g.f(context, "context");
        g.f(customDeleteInfoList, "customDeleteInfoList");
        g.f(callBackPolicyResult, "callBackPolicyResult");
        try {
            PolicySdkLogUtils.Companion.d("encryptMultiCustomDeleteInfoListBySecure " + customDeleteInfoList);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.stepos.secureservice", "com.stepos.secureservice.certification.SafeCertService"));
            intent.setAction("com.stepos.secureservice.SafeCertification");
            ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$encryptMultiCustomDeleteInfoListBySecure$bindService$1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder service) {
                    Collection<String> collectionValues;
                    List<String> listO0;
                    g.f(service, "service");
                    ISafeCertService iSafeCertServiceAsInterface = ISafeCertService.Stub.asInterface(service);
                    List<String> list = EmptyList.f10001a;
                    ArrayList<DeleteInfoEncryptMultiBean> arrayList = customDeleteInfoList;
                    int size = arrayList.size();
                    int i10 = 0;
                    while (i10 < size) {
                        DeleteInfoEncryptMultiBean deleteInfoEncryptMultiBean = arrayList.get(i10);
                        i10++;
                        final DeleteInfoEncryptMultiBean deleteInfoEncryptMultiBean2 = deleteInfoEncryptMultiBean;
                        LinkedHashMap<String, String> bindMap = deleteInfoEncryptMultiBean2.getBindMap();
                        if (bindMap != null && (collectionValues = bindMap.values()) != null && (listO0 = kotlin.collections.a.O0(collectionValues)) != null) {
                            list = listO0;
                        }
                        final i iVar = new i();
                        final long j10 = jCurrentTimeMillis;
                        final l<DeleteInfoBean, n> lVar = callBackPolicyResult;
                        iSafeCertServiceAsInterface.encryptMulti(list, new IEncryptMultiCallback.Stub() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$encryptMultiCustomDeleteInfoListBySecure$bindService$1$onServiceConnected$2
                            @Override // com.stepos.secureservice.certification.IEncryptMultiCallback
                            public void onGet(List<String> list2, String str, int i11, int i12, String str2) {
                                long jCurrentTimeMillis2 = System.currentTimeMillis();
                                PolicySdkLogUtils.Companion.d("encryptMultiCustomDeleteInfoListBySecure", "耗时 " + (jCurrentTimeMillis2 - j10) + " | encrypted = " + list2 + "  | keyId = " + str + " keyVersion =" + i11 + " keyLevel=" + i12 + " | extra = " + str2);
                                if (str == null || list2 == null) {
                                    return;
                                }
                                LinkedHashMap<String, String> bindMap2 = deleteInfoEncryptMultiBean2.getBindMap();
                                if (bindMap2 != null) {
                                    int i13 = 0;
                                    for (String key : bindMap2.keySet()) {
                                        int i14 = i13 + 1;
                                        if (i13 < list2.size()) {
                                            g.e(key, "key");
                                            bindMap2.put(key, list2.get(i13));
                                        }
                                        i13 = i14;
                                    }
                                }
                                PolicySdkLogUtils.Companion.d("encryptMultiCustomDeleteInfoListBySecure", "  encrypted groupBy= " + deleteInfoEncryptMultiBean2.getBindMap() + ' ');
                                String keyInfoJson = iVar.h(new KeyInfo(str, String.valueOf(i11), String.valueOf(i12), String.valueOf(str2)));
                                String bindIdJson = iVar.h(deleteInfoEncryptMultiBean2.getBindMap());
                                String serviceId = deleteInfoEncryptMultiBean2.getServiceId();
                                g.e(bindIdJson, "bindIdJson");
                                g.e(keyInfoJson, "keyInfoJson");
                                lVar.invoke(new DeleteInfoBean(serviceId, bindIdJson, keyInfoJson));
                            }

                            @Override // com.stepos.secureservice.certification.IEncryptMultiCallback
                            public void onErrored(String str) {
                            }
                        });
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }
            };
            context.bindService(intent, serviceConnection, 1);
            activityLifecycleCallbacks(context, serviceConnection);
        } catch (Exception e10) {
            e10.printStackTrace();
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            StringBuilder sb2 = new StringBuilder(" exception : ");
            e10.getMessage();
            n nVar = n.f10413a;
            sb2.append(e10);
            companion.e("encryptMultiCustomDeleteInfoListBySecure", sb2.toString());
        }
    }

    @Override // com.stepos.policy.sdk.impl.WithdrawalImpl
    public void getCommonDeleteInfoListBySecure(Context context, final String businessType, final int i10, final l<? super String, n> callBackPolicyResult) {
        g.f(context, "context");
        g.f(businessType, "businessType");
        g.f(callBackPolicyResult, "callBackPolicyResult");
        try {
            PolicySdkLogUtils.Companion.d("getCommonDeleteInfoList");
            final long jCurrentTimeMillis = System.currentTimeMillis();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.stepos.secureservice", "com.stepos.secureservice.policy.PolicyBindService"));
            intent.setAction("com.stepos.secureservice.PolicyBind");
            ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$getCommonDeleteInfoListBySecure$bindService$1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder service) {
                    g.f(service, "service");
                    IPolicyBindService iPolicyBindServiceAsInterface = IPolicyBindService.Stub.asInterface(service);
                    final long j10 = jCurrentTimeMillis;
                    final l<String, n> lVar = callBackPolicyResult;
                    iPolicyBindServiceAsInterface.getPublicConfig(new IPolicyBindCallback.Stub() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$getCommonDeleteInfoListBySecure$bindService$1$onServiceConnected$1
                        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
                        public void onGet(List<IPolicyBindResult> results, String keyId, int i11, int i12, String str) {
                            g.f(results, "results");
                            g.f(keyId, "keyId");
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            PolicySdkLogUtils.Companion.d("getCommonDeleteInfoList", "耗时 " + (jCurrentTimeMillis2 - j10) + " | results = " + results + " \n | keyId = " + keyId + " keyVersion =" + i11 + " keyLevel=" + i12 + " | extra = " + str);
                            i iVar = new i();
                            ArrayList arrayList = new ArrayList();
                            String keyInfoJson = iVar.h(new KeyInfo(keyId, String.valueOf(i11), String.valueOf(i12), String.valueOf(str)));
                            for (IPolicyBindResult iPolicyBindResult : results) {
                                String strValueOf = String.valueOf(iPolicyBindResult.serverId);
                                String str2 = iPolicyBindResult.bindId;
                                g.e(str2, "policyBindResult.bindId");
                                g.e(keyInfoJson, "keyInfoJson");
                                arrayList.add(new DeleteInfoBean(strValueOf, str2, keyInfoJson));
                            }
                            String deleteInfoListJson = iVar.h(arrayList);
                            l<String, n> lVar2 = lVar;
                            g.e(deleteInfoListJson, "deleteInfoListJson");
                            lVar2.invoke(deleteInfoListJson);
                        }

                        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
                        public void onErrored(String str) {
                        }
                    }, businessType, i10);
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }
            };
            context.bindService(intent, serviceConnection, 1);
            activityLifecycleCallbacks(context, serviceConnection);
        } catch (Exception e10) {
            e10.printStackTrace();
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            StringBuilder sb2 = new StringBuilder(" exception : ");
            e10.getMessage();
            n nVar = n.f10413a;
            sb2.append(e10);
            companion.e("getCommonDeleteInfoList", sb2.toString());
        }
    }

    @Override // com.stepos.policy.sdk.impl.WithdrawalImpl
    public void getPrivateDeleteInfoListBySecure(Context context, final String appId, final String businessType, final int i10, final l<? super ArrayList<DeleteInfoBean>, n> callBackPolicyResult) {
        g.f(context, "context");
        g.f(appId, "appId");
        g.f(businessType, "businessType");
        g.f(callBackPolicyResult, "callBackPolicyResult");
        try {
            PolicySdkLogUtils.Companion.d("getPrivateDeleteInfoList");
            final long jCurrentTimeMillis = System.currentTimeMillis();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.stepos.secureservice", "com.stepos.secureservice.policy.PolicyBindService"));
            intent.setAction("com.stepos.secureservice.PolicyBind");
            ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$getPrivateDeleteInfoListBySecure$bindService$1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder service) {
                    g.f(service, "service");
                    IPolicyBindService iPolicyBindServiceAsInterface = IPolicyBindService.Stub.asInterface(service);
                    final long j10 = jCurrentTimeMillis;
                    final l<ArrayList<DeleteInfoBean>, n> lVar = callBackPolicyResult;
                    iPolicyBindServiceAsInterface.getPrivateConfig(new IPolicyBindCallback.Stub() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$getPrivateDeleteInfoListBySecure$bindService$1$onServiceConnected$1
                        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
                        public void onGet(List<IPolicyBindResult> results, String keyId, int i11, int i12, String str) {
                            g.f(results, "results");
                            g.f(keyId, "keyId");
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            PolicySdkLogUtils.Companion.d("getPrivateDeleteInfoList", "耗时 " + (jCurrentTimeMillis2 - j10) + " | results = " + results + " \n | keyId = " + keyId + " keyVersion =" + i11 + " keyLevel=" + i12 + " | extra = " + str);
                            i iVar = new i();
                            ArrayList<DeleteInfoBean> arrayList = new ArrayList<>();
                            String keyInfoJson = iVar.h(new KeyInfo(keyId, String.valueOf(i11), String.valueOf(i12), String.valueOf(str)));
                            for (IPolicyBindResult iPolicyBindResult : results) {
                                if (iPolicyBindResult.publicFlag == 0) {
                                    String strValueOf = String.valueOf(iPolicyBindResult.serverId);
                                    String str2 = iPolicyBindResult.bindId;
                                    g.e(str2, "policyBindResult.bindId");
                                    g.e(keyInfoJson, "keyInfoJson");
                                    arrayList.add(new DeleteInfoBean(strValueOf, str2, keyInfoJson));
                                }
                            }
                            lVar.invoke(arrayList);
                        }

                        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
                        public void onErrored(String str) {
                        }
                    }, businessType, i10, appId);
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }
            };
            context.bindService(intent, serviceConnection, 1);
            activityLifecycleCallbacks(context, serviceConnection);
        } catch (Exception e10) {
            e10.printStackTrace();
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            StringBuilder sb2 = new StringBuilder(" exception : ");
            e10.getMessage();
            n nVar = n.f10413a;
            sb2.append(e10);
            companion.e("getPrivateDeleteInfoList", sb2.toString());
        }
    }
}
