package com.stepos.policy.sdk.manager;

import A1.e;
import V3.r;
import V3.v;
import W3.C0403n;
import W3.E;
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
import i4.InterfaceC0772l;
import j4.k;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import r4.C1020c;

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
                        k.g(activity, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                        k.g(activity, "activity");
                        PolicySdkLogUtils.Companion.d("WithdrawalManager", "onActivityDestroyed");
                        context.unbindService(serviceConnection);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                        k.g(activity, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                        k.g(activity, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                        k.g(activity, "activity");
                        k.g(bundle, "outState");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                        k.g(activity, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                        k.g(activity, "activity");
                    }
                });
            }
        } catch (Exception e6) {
            e6.printStackTrace();
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            StringBuilder sb = new StringBuilder();
            sb.append(" exception : ");
            e6.getMessage();
            v vVar = v.f5542a;
            sb.append(e6);
            companion.e("activityLifecycleCallbacks", sb.toString());
        }
    }

    @Override // com.stepos.policy.sdk.impl.WithdrawalImpl
    public void encryptCustomDeleteInfoListBySecure(Context context, final ArrayList<CustomDeleteInfoBean> arrayList, final InterfaceC0772l<? super DeleteInfoBean, v> interfaceC0772l) {
        k.g(context, "context");
        k.g(arrayList, "customDeleteInfoList");
        k.g(interfaceC0772l, "callBackPolicyResult");
        try {
            PolicySdkLogUtils.Companion.d("getCustomDeleteInfoList " + arrayList);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.stepos.secureservice", "com.stepos.secureservice.certification.SafeCertService"));
            intent.setAction("com.stepos.secureservice.SafeCertification");
            ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$encryptCustomDeleteInfoListBySecure$bindService$1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    k.g(iBinder, "service");
                    ISafeCertService iSafeCertServiceAsInterface = ISafeCertService.Stub.asInterface(iBinder);
                    ArrayList<CustomDeleteInfoBean> arrayList2 = arrayList;
                    int size = arrayList2.size();
                    int i5 = 0;
                    while (i5 < size) {
                        CustomDeleteInfoBean customDeleteInfoBean = arrayList2.get(i5);
                        i5++;
                        final CustomDeleteInfoBean customDeleteInfoBean2 = customDeleteInfoBean;
                        String bindIdValue = customDeleteInfoBean2.getBindIdValue();
                        final e eVar = new e();
                        byte[] bytes = bindIdValue.getBytes(C1020c.f20083b);
                        k.f(bytes, "this as java.lang.String).getBytes(charset)");
                        final long j5 = jCurrentTimeMillis;
                        final InterfaceC0772l<DeleteInfoBean, v> interfaceC0772l2 = interfaceC0772l;
                        iSafeCertServiceAsInterface.encrypt(bytes, new IEncryptCallback.Stub() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$encryptCustomDeleteInfoListBySecure$bindService$1$onServiceConnected$1
                            @Override // com.stepos.secureservice.certification.IEncryptCallback
                            public void onErrored(String str) {
                            }

                            @Override // com.stepos.secureservice.certification.IEncryptCallback
                            public void onGet(byte[] bArr, String str, int i6, int i7, String str2) {
                                long jCurrentTimeMillis2 = System.currentTimeMillis();
                                PolicySdkLogUtils.Companion.d("getCustomDeleteInfoList", "耗时 " + (jCurrentTimeMillis2 - j5) + " | serviceId = " + customDeleteInfoBean2.getServiceId() + "  | keyId = " + str + " keyVersion =" + i6 + " keyLevel=" + i7 + " | extra = " + str2);
                                if (str == null || bArr == null) {
                                    return;
                                }
                                String strR = eVar.r(new KeyInfo(str, String.valueOf(i6), String.valueOf(i7), String.valueOf(str2)));
                                String strEncodeToString = Base64.getUrlEncoder().encodeToString(bArr);
                                k.f(strEncodeToString, "getUrlEncoder().encodeToString(encrypted)");
                                Map mapB = E.b(r.a(customDeleteInfoBean2.getBindIdKey(), strEncodeToString));
                                String serviceId = customDeleteInfoBean2.getServiceId();
                                String strR2 = eVar.r(mapB);
                                k.f(strR2, "gson.toJson(map)");
                                k.f(strR, "keyInfoJson");
                                interfaceC0772l2.invoke(new DeleteInfoBean(serviceId, strR2, strR));
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
        } catch (Exception e6) {
            e6.printStackTrace();
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            StringBuilder sb = new StringBuilder();
            sb.append(" exception : ");
            e6.getMessage();
            v vVar = v.f5542a;
            sb.append(e6);
            companion.e("getCommonDeleteInfoList", sb.toString());
        }
    }

    @Override // com.stepos.policy.sdk.impl.WithdrawalImpl
    public void encryptMultiCustomDeleteInfoListBySecure(Context context, final ArrayList<DeleteInfoEncryptMultiBean> arrayList, final InterfaceC0772l<? super DeleteInfoBean, v> interfaceC0772l) {
        k.g(context, "context");
        k.g(arrayList, "customDeleteInfoList");
        k.g(interfaceC0772l, "callBackPolicyResult");
        try {
            PolicySdkLogUtils.Companion.d("encryptMultiCustomDeleteInfoListBySecure " + arrayList);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.stepos.secureservice", "com.stepos.secureservice.certification.SafeCertService"));
            intent.setAction("com.stepos.secureservice.SafeCertification");
            ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$encryptMultiCustomDeleteInfoListBySecure$bindService$1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    Collection<String> collectionValues;
                    List<String> listU;
                    k.g(iBinder, "service");
                    ISafeCertService iSafeCertServiceAsInterface = ISafeCertService.Stub.asInterface(iBinder);
                    List<String> listH = C0403n.h();
                    ArrayList<DeleteInfoEncryptMultiBean> arrayList2 = arrayList;
                    int size = arrayList2.size();
                    int i5 = 0;
                    while (i5 < size) {
                        DeleteInfoEncryptMultiBean deleteInfoEncryptMultiBean = arrayList2.get(i5);
                        i5++;
                        final DeleteInfoEncryptMultiBean deleteInfoEncryptMultiBean2 = deleteInfoEncryptMultiBean;
                        LinkedHashMap<String, String> bindMap = deleteInfoEncryptMultiBean2.getBindMap();
                        if (bindMap != null && (collectionValues = bindMap.values()) != null && (listU = C0403n.U(collectionValues)) != null) {
                            listH = listU;
                        }
                        final e eVar = new e();
                        final long j5 = jCurrentTimeMillis;
                        final InterfaceC0772l<DeleteInfoBean, v> interfaceC0772l2 = interfaceC0772l;
                        iSafeCertServiceAsInterface.encryptMulti(listH, new IEncryptMultiCallback.Stub() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$encryptMultiCustomDeleteInfoListBySecure$bindService$1$onServiceConnected$2
                            @Override // com.stepos.secureservice.certification.IEncryptMultiCallback
                            public void onErrored(String str) {
                            }

                            @Override // com.stepos.secureservice.certification.IEncryptMultiCallback
                            public void onGet(List<String> list, String str, int i6, int i7, String str2) {
                                long jCurrentTimeMillis2 = System.currentTimeMillis();
                                PolicySdkLogUtils.Companion.d("encryptMultiCustomDeleteInfoListBySecure", "耗时 " + (jCurrentTimeMillis2 - j5) + " | encrypted = " + list + "  | keyId = " + str + " keyVersion =" + i6 + " keyLevel=" + i7 + " | extra = " + str2);
                                if (str == null || list == null) {
                                    return;
                                }
                                LinkedHashMap<String, String> bindMap2 = deleteInfoEncryptMultiBean2.getBindMap();
                                if (bindMap2 != null) {
                                    int i8 = 0;
                                    for (String str3 : bindMap2.keySet()) {
                                        int i9 = i8 + 1;
                                        if (i8 < list.size()) {
                                            k.f(str3, "key");
                                            bindMap2.put(str3, list.get(i8));
                                        }
                                        i8 = i9;
                                    }
                                }
                                PolicySdkLogUtils.Companion.d("encryptMultiCustomDeleteInfoListBySecure", "  encrypted groupBy= " + deleteInfoEncryptMultiBean2.getBindMap() + ' ');
                                String strR = eVar.r(new KeyInfo(str, String.valueOf(i6), String.valueOf(i7), String.valueOf(str2)));
                                String strR2 = eVar.r(deleteInfoEncryptMultiBean2.getBindMap());
                                String serviceId = deleteInfoEncryptMultiBean2.getServiceId();
                                k.f(strR2, "bindIdJson");
                                k.f(strR, "keyInfoJson");
                                interfaceC0772l2.invoke(new DeleteInfoBean(serviceId, strR2, strR));
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
        } catch (Exception e6) {
            e6.printStackTrace();
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            StringBuilder sb = new StringBuilder();
            sb.append(" exception : ");
            e6.getMessage();
            v vVar = v.f5542a;
            sb.append(e6);
            companion.e("encryptMultiCustomDeleteInfoListBySecure", sb.toString());
        }
    }

    @Override // com.stepos.policy.sdk.impl.WithdrawalImpl
    public void getCommonDeleteInfoListBySecure(Context context, final String str, final int i5, final InterfaceC0772l<? super String, v> interfaceC0772l) {
        k.g(context, "context");
        k.g(str, "businessType");
        k.g(interfaceC0772l, "callBackPolicyResult");
        try {
            PolicySdkLogUtils.Companion.d("getCommonDeleteInfoList");
            final long jCurrentTimeMillis = System.currentTimeMillis();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.stepos.secureservice", "com.stepos.secureservice.policy.PolicyBindService"));
            intent.setAction("com.stepos.secureservice.PolicyBind");
            ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$getCommonDeleteInfoListBySecure$bindService$1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    k.g(iBinder, "service");
                    IPolicyBindService iPolicyBindServiceAsInterface = IPolicyBindService.Stub.asInterface(iBinder);
                    final long j5 = jCurrentTimeMillis;
                    final InterfaceC0772l<String, v> interfaceC0772l2 = interfaceC0772l;
                    iPolicyBindServiceAsInterface.getPublicConfig(new IPolicyBindCallback.Stub() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$getCommonDeleteInfoListBySecure$bindService$1$onServiceConnected$1
                        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
                        public void onErrored(String str2) {
                        }

                        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
                        public void onGet(List<IPolicyBindResult> list, String str2, int i6, int i7, String str3) {
                            k.g(list, "results");
                            k.g(str2, "keyId");
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            PolicySdkLogUtils.Companion.d("getCommonDeleteInfoList", "耗时 " + (jCurrentTimeMillis2 - j5) + " | results = " + list + " \n | keyId = " + str2 + " keyVersion =" + i6 + " keyLevel=" + i7 + " | extra = " + str3);
                            e eVar = new e();
                            ArrayList arrayList = new ArrayList();
                            String strR = eVar.r(new KeyInfo(str2, String.valueOf(i6), String.valueOf(i7), String.valueOf(str3)));
                            for (IPolicyBindResult iPolicyBindResult : list) {
                                String strValueOf = String.valueOf(iPolicyBindResult.serverId);
                                String str4 = iPolicyBindResult.bindId;
                                k.f(str4, "policyBindResult.bindId");
                                k.f(strR, "keyInfoJson");
                                arrayList.add(new DeleteInfoBean(strValueOf, str4, strR));
                            }
                            String strR2 = eVar.r(arrayList);
                            InterfaceC0772l<String, v> interfaceC0772l3 = interfaceC0772l2;
                            k.f(strR2, "deleteInfoListJson");
                            interfaceC0772l3.invoke(strR2);
                        }
                    }, str, i5);
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }
            };
            context.bindService(intent, serviceConnection, 1);
            activityLifecycleCallbacks(context, serviceConnection);
        } catch (Exception e6) {
            e6.printStackTrace();
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            StringBuilder sb = new StringBuilder();
            sb.append(" exception : ");
            e6.getMessage();
            v vVar = v.f5542a;
            sb.append(e6);
            companion.e("getCommonDeleteInfoList", sb.toString());
        }
    }

    @Override // com.stepos.policy.sdk.impl.WithdrawalImpl
    public void getPrivateDeleteInfoListBySecure(Context context, final String str, final String str2, final int i5, final InterfaceC0772l<? super ArrayList<DeleteInfoBean>, v> interfaceC0772l) {
        k.g(context, "context");
        k.g(str, "appId");
        k.g(str2, "businessType");
        k.g(interfaceC0772l, "callBackPolicyResult");
        try {
            PolicySdkLogUtils.Companion.d("getPrivateDeleteInfoList");
            final long jCurrentTimeMillis = System.currentTimeMillis();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.stepos.secureservice", "com.stepos.secureservice.policy.PolicyBindService"));
            intent.setAction("com.stepos.secureservice.PolicyBind");
            ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$getPrivateDeleteInfoListBySecure$bindService$1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    k.g(iBinder, "service");
                    IPolicyBindService iPolicyBindServiceAsInterface = IPolicyBindService.Stub.asInterface(iBinder);
                    final long j5 = jCurrentTimeMillis;
                    final InterfaceC0772l<ArrayList<DeleteInfoBean>, v> interfaceC0772l2 = interfaceC0772l;
                    iPolicyBindServiceAsInterface.getPrivateConfig(new IPolicyBindCallback.Stub() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$getPrivateDeleteInfoListBySecure$bindService$1$onServiceConnected$1
                        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
                        public void onErrored(String str3) {
                        }

                        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
                        public void onGet(List<IPolicyBindResult> list, String str3, int i6, int i7, String str4) {
                            k.g(list, "results");
                            k.g(str3, "keyId");
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            PolicySdkLogUtils.Companion.d("getPrivateDeleteInfoList", "耗时 " + (jCurrentTimeMillis2 - j5) + " | results = " + list + " \n | keyId = " + str3 + " keyVersion =" + i6 + " keyLevel=" + i7 + " | extra = " + str4);
                            e eVar = new e();
                            ArrayList<DeleteInfoBean> arrayList = new ArrayList<>();
                            String strR = eVar.r(new KeyInfo(str3, String.valueOf(i6), String.valueOf(i7), String.valueOf(str4)));
                            for (IPolicyBindResult iPolicyBindResult : list) {
                                if (iPolicyBindResult.publicFlag == 0) {
                                    String strValueOf = String.valueOf(iPolicyBindResult.serverId);
                                    String str5 = iPolicyBindResult.bindId;
                                    k.f(str5, "policyBindResult.bindId");
                                    k.f(strR, "keyInfoJson");
                                    arrayList.add(new DeleteInfoBean(strValueOf, str5, strR));
                                }
                            }
                            interfaceC0772l2.invoke(arrayList);
                        }
                    }, str2, i5, str);
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }
            };
            context.bindService(intent, serviceConnection, 1);
            activityLifecycleCallbacks(context, serviceConnection);
        } catch (Exception e6) {
            e6.printStackTrace();
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            StringBuilder sb = new StringBuilder();
            sb.append(" exception : ");
            e6.getMessage();
            v vVar = v.f5542a;
            sb.append(e6);
            companion.e("getPrivateDeleteInfoList", sb.toString());
        }
    }
}
