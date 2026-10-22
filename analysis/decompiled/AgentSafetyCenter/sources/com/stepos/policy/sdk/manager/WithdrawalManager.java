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
import hc.a;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kb.s;
import m7.e;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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
                        activity.getClass();
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                        activity.getClass();
                        PolicySdkLogUtils.Companion.d("WithdrawalManager", "onActivityDestroyed");
                        context.unbindService(serviceConnection);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                        activity.getClass();
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                        activity.getClass();
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                        activity.getClass();
                        bundle.getClass();
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                        activity.getClass();
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                        activity.getClass();
                    }
                });
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            StringBuilder sb2 = new StringBuilder(" exception : ");
            e10.getMessage();
            sb2.append(e10);
            companion.e("activityLifecycleCallbacks", sb2.toString());
        }
    }

    @Override // com.stepos.policy.sdk.impl.WithdrawalImpl
    public void encryptCustomDeleteInfoListBySecure(Context context, final ArrayList<CustomDeleteInfoBean> arrayList, final l lVar) {
        context.getClass();
        arrayList.getClass();
        lVar.getClass();
        try {
            PolicySdkLogUtils.Companion.d("getCustomDeleteInfoList " + arrayList);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.stepos.secureservice", "com.stepos.secureservice.certification.SafeCertService"));
            intent.setAction("com.stepos.secureservice.SafeCertification");
            ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$encryptCustomDeleteInfoListBySecure$bindService$1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    iBinder.getClass();
                    ISafeCertService iSafeCertServiceAsInterface = ISafeCertService.Stub.asInterface(iBinder);
                    ArrayList<CustomDeleteInfoBean> arrayList2 = arrayList;
                    int size = arrayList2.size();
                    int i = 0;
                    while (i < size) {
                        CustomDeleteInfoBean customDeleteInfoBean = arrayList2.get(i);
                        i++;
                        final CustomDeleteInfoBean customDeleteInfoBean2 = customDeleteInfoBean;
                        String bindIdValue = customDeleteInfoBean2.getBindIdValue();
                        final e eVar = new e();
                        byte[] bytes = bindIdValue.getBytes(a.f5448a);
                        bytes.getClass();
                        final long j10 = jCurrentTimeMillis;
                        final l lVar2 = lVar;
                        iSafeCertServiceAsInterface.encrypt(bytes, new IEncryptCallback.Stub() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$encryptCustomDeleteInfoListBySecure$bindService$1$onServiceConnected$1
                            @Override // com.stepos.secureservice.certification.IEncryptCallback
                            public void onGet(byte[] bArr, String str, int i3, int i10, String str2) {
                                long jCurrentTimeMillis2 = System.currentTimeMillis();
                                PolicySdkLogUtils.Companion.d("getCustomDeleteInfoList", "耗时 " + (jCurrentTimeMillis2 - j10) + " | serviceId = " + customDeleteInfoBean2.getServiceId() + "  | keyId = " + str + " keyVersion =" + i3 + " keyLevel=" + i10 + " | extra = " + str2);
                                if (str == null || bArr == null) {
                                    return;
                                }
                                String strE = eVar.e(new KeyInfo(str, String.valueOf(i3), String.valueOf(i10), String.valueOf(str2)));
                                String strEncodeToString = Base64.getUrlEncoder().encodeToString(bArr);
                                strEncodeToString.getClass();
                                Map mapSingletonMap = Collections.singletonMap(customDeleteInfoBean2.getBindIdKey(), strEncodeToString);
                                mapSingletonMap.getClass();
                                lVar2.invoke(new DeleteInfoBean(customDeleteInfoBean2.getServiceId(), eVar.e(mapSingletonMap), strE));
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
            sb2.append(e10);
            companion.e("getCommonDeleteInfoList", sb2.toString());
        }
    }

    @Override // com.stepos.policy.sdk.impl.WithdrawalImpl
    public void encryptMultiCustomDeleteInfoListBySecure(Context context, final ArrayList<DeleteInfoEncryptMultiBean> arrayList, final l lVar) {
        context.getClass();
        arrayList.getClass();
        lVar.getClass();
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
                    iBinder.getClass();
                    ISafeCertService iSafeCertServiceAsInterface = ISafeCertService.Stub.asInterface(iBinder);
                    ArrayList<DeleteInfoEncryptMultiBean> arrayList2 = arrayList;
                    int size = arrayList2.size();
                    List<String> listL0 = s.f7404c;
                    int i = 0;
                    while (i < size) {
                        DeleteInfoEncryptMultiBean deleteInfoEncryptMultiBean = arrayList2.get(i);
                        i++;
                        final DeleteInfoEncryptMultiBean deleteInfoEncryptMultiBean2 = deleteInfoEncryptMultiBean;
                        LinkedHashMap<String, String> bindMap = deleteInfoEncryptMultiBean2.getBindMap();
                        if (bindMap != null && (collectionValues = bindMap.values()) != null) {
                            listL0 = kb.l.L0(collectionValues);
                        }
                        final e eVar = new e();
                        final long j10 = jCurrentTimeMillis;
                        final l lVar2 = lVar;
                        iSafeCertServiceAsInterface.encryptMulti(listL0, new IEncryptMultiCallback.Stub() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$encryptMultiCustomDeleteInfoListBySecure$bindService$1$onServiceConnected$2
                            @Override // com.stepos.secureservice.certification.IEncryptMultiCallback
                            public void onGet(List<String> list, String str, int i3, int i10, String str2) {
                                long jCurrentTimeMillis2 = System.currentTimeMillis();
                                PolicySdkLogUtils.Companion.d("encryptMultiCustomDeleteInfoListBySecure", "耗时 " + (jCurrentTimeMillis2 - j10) + " | encrypted = " + list + "  | keyId = " + str + " keyVersion =" + i3 + " keyLevel=" + i10 + " | extra = " + str2);
                                if (str == null || list == null) {
                                    return;
                                }
                                LinkedHashMap<String, String> bindMap2 = deleteInfoEncryptMultiBean2.getBindMap();
                                if (bindMap2 != null) {
                                    int i11 = 0;
                                    for (String str3 : bindMap2.keySet()) {
                                        int i12 = i11 + 1;
                                        if (i11 < list.size()) {
                                            str3.getClass();
                                            bindMap2.put(str3, list.get(i11));
                                        }
                                        i11 = i12;
                                    }
                                }
                                PolicySdkLogUtils.Companion.d("encryptMultiCustomDeleteInfoListBySecure", "  encrypted groupBy= " + deleteInfoEncryptMultiBean2.getBindMap() + ' ');
                                lVar2.invoke(new DeleteInfoBean(deleteInfoEncryptMultiBean2.getServiceId(), eVar.e(deleteInfoEncryptMultiBean2.getBindMap()), eVar.e(new KeyInfo(str, String.valueOf(i3), String.valueOf(i10), String.valueOf(str2)))));
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
            sb2.append(e10);
            companion.e("encryptMultiCustomDeleteInfoListBySecure", sb2.toString());
        }
    }

    @Override // com.stepos.policy.sdk.impl.WithdrawalImpl
    public void getCommonDeleteInfoListBySecure(Context context, final String str, final int i, final l lVar) {
        context.getClass();
        str.getClass();
        lVar.getClass();
        try {
            PolicySdkLogUtils.Companion.d("getCommonDeleteInfoList");
            final long jCurrentTimeMillis = System.currentTimeMillis();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.stepos.secureservice", "com.stepos.secureservice.policy.PolicyBindService"));
            intent.setAction("com.stepos.secureservice.PolicyBind");
            ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$getCommonDeleteInfoListBySecure$bindService$1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    iBinder.getClass();
                    IPolicyBindService iPolicyBindServiceAsInterface = IPolicyBindService.Stub.asInterface(iBinder);
                    final long j10 = jCurrentTimeMillis;
                    final l lVar2 = lVar;
                    iPolicyBindServiceAsInterface.getPublicConfig(new IPolicyBindCallback.Stub() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$getCommonDeleteInfoListBySecure$bindService$1$onServiceConnected$1
                        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
                        public void onGet(List<IPolicyBindResult> list, String str2, int i3, int i10, String str3) {
                            list.getClass();
                            str2.getClass();
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            PolicySdkLogUtils.Companion.d("getCommonDeleteInfoList", "耗时 " + (jCurrentTimeMillis2 - j10) + " | results = " + list + " \n | keyId = " + str2 + " keyVersion =" + i3 + " keyLevel=" + i10 + " | extra = " + str3);
                            e eVar = new e();
                            ArrayList arrayList = new ArrayList();
                            String strE = eVar.e(new KeyInfo(str2, String.valueOf(i3), String.valueOf(i10), String.valueOf(str3)));
                            for (IPolicyBindResult iPolicyBindResult : list) {
                                String strValueOf = String.valueOf(iPolicyBindResult.serverId);
                                String str4 = iPolicyBindResult.bindId;
                                str4.getClass();
                                arrayList.add(new DeleteInfoBean(strValueOf, str4, strE));
                            }
                            lVar2.invoke(eVar.e(arrayList));
                        }

                        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
                        public void onErrored(String str2) {
                        }
                    }, str, i);
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
            sb2.append(e10);
            companion.e("getCommonDeleteInfoList", sb2.toString());
        }
    }

    @Override // com.stepos.policy.sdk.impl.WithdrawalImpl
    public void getPrivateDeleteInfoListBySecure(Context context, final String str, final String str2, final int i, final l lVar) {
        context.getClass();
        str.getClass();
        str2.getClass();
        lVar.getClass();
        try {
            PolicySdkLogUtils.Companion.d("getPrivateDeleteInfoList");
            final long jCurrentTimeMillis = System.currentTimeMillis();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.stepos.secureservice", "com.stepos.secureservice.policy.PolicyBindService"));
            intent.setAction("com.stepos.secureservice.PolicyBind");
            ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$getPrivateDeleteInfoListBySecure$bindService$1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    iBinder.getClass();
                    IPolicyBindService iPolicyBindServiceAsInterface = IPolicyBindService.Stub.asInterface(iBinder);
                    final long j10 = jCurrentTimeMillis;
                    final l lVar2 = lVar;
                    iPolicyBindServiceAsInterface.getPrivateConfig(new IPolicyBindCallback.Stub() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$getPrivateDeleteInfoListBySecure$bindService$1$onServiceConnected$1
                        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
                        public void onGet(List<IPolicyBindResult> list, String str3, int i3, int i10, String str4) {
                            list.getClass();
                            str3.getClass();
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            PolicySdkLogUtils.Companion.d("getPrivateDeleteInfoList", "耗时 " + (jCurrentTimeMillis2 - j10) + " | results = " + list + " \n | keyId = " + str3 + " keyVersion =" + i3 + " keyLevel=" + i10 + " | extra = " + str4);
                            e eVar = new e();
                            ArrayList arrayList = new ArrayList();
                            String strE = eVar.e(new KeyInfo(str3, String.valueOf(i3), String.valueOf(i10), String.valueOf(str4)));
                            for (IPolicyBindResult iPolicyBindResult : list) {
                                if (iPolicyBindResult.publicFlag == 0) {
                                    String strValueOf = String.valueOf(iPolicyBindResult.serverId);
                                    String str5 = iPolicyBindResult.bindId;
                                    str5.getClass();
                                    arrayList.add(new DeleteInfoBean(strValueOf, str5, strE));
                                }
                            }
                            lVar2.invoke(arrayList);
                        }

                        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
                        public void onErrored(String str3) {
                        }
                    }, str2, i, str);
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
            sb2.append(e10);
            companion.e("getPrivateDeleteInfoList", sb2.toString());
        }
    }
}
