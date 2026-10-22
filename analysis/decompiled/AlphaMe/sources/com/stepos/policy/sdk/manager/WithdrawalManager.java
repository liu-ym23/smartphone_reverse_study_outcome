package com.stepos.policy.sdk.manager;

import F1.n;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.RequiresApi;
import ch.qos.logback.core.CoreConstants;
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
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002JK\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00040\u000fH\u0016JK\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u000bj\b\u0012\u0004\u0012\u00020\u0015`\r2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00040\u000fH\u0016JC\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00040\u000fH\u0016J_\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a25\u0010\u000e\u001a1\u0012'\u0012%\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\r¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00040\u000fH\u0016¨\u0006\u001e"}, d2 = {"Lcom/stepos/policy/sdk/manager/WithdrawalManager;", "Lcom/stepos/policy/sdk/impl/WithdrawalImpl;", "()V", "activityLifecycleCallbacks", "", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "bindService", "Landroid/content/ServiceConnection;", "encryptCustomDeleteInfoListBySecure", "customDeleteInfoList", "Ljava/util/ArrayList;", "Lcom/stepos/policy/sdk/bean/CustomDeleteInfoBean;", "Lkotlin/collections/ArrayList;", "callBackPolicyResult", "Lkotlin/Function1;", "Lcom/stepos/policy/sdk/bean/DeleteInfoBean;", "Lkotlin/ParameterName;", "name", "deleteInfoBean", "encryptMultiCustomDeleteInfoListBySecure", "Lcom/stepos/policy/sdk/bean/DeleteInfoEncryptMultiBean;", "getCommonDeleteInfoListBySecure", "businessType", "", "deleteType", "", "deleteInfoListJson", "getPrivateDeleteInfoListBySecure", "appId", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWithdrawalManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WithdrawalManager.kt\ncom/stepos/policy/sdk/manager/WithdrawalManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,452:1\n1#2:453\n*E\n"})
/* loaded from: classes.dex */
public final class WithdrawalManager implements WithdrawalImpl {

    @NotNull
    public static final WithdrawalManager INSTANCE = new WithdrawalManager();

    private WithdrawalManager() {
    }

    private final void activityLifecycleCallbacks(final Context context, final ServiceConnection bindService) {
        try {
            if (context instanceof Activity) {
                ((Activity) context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager.activityLifecycleCallbacks.1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(@NotNull Activity activity) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                        PolicySdkLogUtils.INSTANCE.d("WithdrawalManager", "onActivityDestroyed");
                        context.unbindService(bindService);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(@NotNull Activity activity) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(@NotNull Activity activity) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                        Intrinsics.checkNotNullParameter(outState, "outState");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(@NotNull Activity activity) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(@NotNull Activity activity) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                    }
                });
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
            StringBuilder sb = new StringBuilder(" exception : ");
            e4.getMessage();
            Unit unit = Unit.INSTANCE;
            sb.append(e4);
            companion.e("activityLifecycleCallbacks", sb.toString());
        }
    }

    @Override // com.stepos.policy.sdk.impl.WithdrawalImpl
    public void encryptCustomDeleteInfoListBySecure(@NotNull Context context, @NotNull final ArrayList<CustomDeleteInfoBean> customDeleteInfoList, @NotNull final Function1<? super DeleteInfoBean, Unit> callBackPolicyResult) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customDeleteInfoList, "customDeleteInfoList");
        Intrinsics.checkNotNullParameter(callBackPolicyResult, "callBackPolicyResult");
        try {
            PolicySdkLogUtils.INSTANCE.d("getCustomDeleteInfoList " + customDeleteInfoList);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.stepos.secureservice", "com.stepos.secureservice.certification.SafeCertService"));
            intent.setAction("com.stepos.secureservice.SafeCertification");
            ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$encryptCustomDeleteInfoListBySecure$bindService$1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(@Nullable ComponentName name, @NotNull IBinder service) throws RemoteException {
                    Intrinsics.checkNotNullParameter(service, "service");
                    ISafeCertService iSafeCertServiceAsInterface = ISafeCertService.Stub.asInterface(service);
                    Iterator<CustomDeleteInfoBean> it = customDeleteInfoList.iterator();
                    while (it.hasNext()) {
                        final CustomDeleteInfoBean next = it.next();
                        String bindIdValue = next.getBindIdValue();
                        final n nVar = new n();
                        byte[] bytes = bindIdValue.getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                        final long j4 = jCurrentTimeMillis;
                        final Function1<DeleteInfoBean, Unit> function1 = callBackPolicyResult;
                        iSafeCertServiceAsInterface.encrypt(bytes, new IEncryptCallback.Stub() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$encryptCustomDeleteInfoListBySecure$bindService$1$onServiceConnected$1
                            @Override // com.stepos.secureservice.certification.IEncryptCallback
                            public void onErrored(@Nullable String msg) {
                            }

                            @Override // com.stepos.secureservice.certification.IEncryptCallback
                            @RequiresApi(26)
                            public void onGet(@Nullable byte[] encrypted, @Nullable String keyId, int keyVersion, int keyLevel, @Nullable String extra) {
                                long jCurrentTimeMillis2 = System.currentTimeMillis();
                                PolicySdkLogUtils.INSTANCE.d("getCustomDeleteInfoList", "耗时 " + (jCurrentTimeMillis2 - j4) + " | serviceId = " + next.getServiceId() + "  | keyId = " + keyId + " keyVersion =" + keyVersion + " keyLevel=" + keyLevel + " | extra = " + extra);
                                if (keyId == null || encrypted == null) {
                                    return;
                                }
                                String keyInfoJson = nVar.g(new KeyInfo(keyId, String.valueOf(keyVersion), String.valueOf(keyLevel), String.valueOf(extra)));
                                String strEncodeToString = Base64.getUrlEncoder().encodeToString(encrypted);
                                Intrinsics.checkNotNullExpressionValue(strEncodeToString, "getUrlEncoder().encodeToString(encrypted)");
                                Map mapMapOf = MapsKt.mapOf(TuplesKt.to(next.getBindIdKey(), strEncodeToString));
                                String serviceId = next.getServiceId();
                                String strG = nVar.g(mapMapOf);
                                Intrinsics.checkNotNullExpressionValue(strG, "gson.toJson(map)");
                                Intrinsics.checkNotNullExpressionValue(keyInfoJson, "keyInfoJson");
                                function1.invoke(new DeleteInfoBean(serviceId, strG, keyInfoJson));
                            }
                        });
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(@Nullable ComponentName name) {
                }
            };
            context.bindService(intent, serviceConnection, 1);
            activityLifecycleCallbacks(context, serviceConnection);
        } catch (Exception e4) {
            e4.printStackTrace();
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
            StringBuilder sb = new StringBuilder(" exception : ");
            e4.getMessage();
            Unit unit = Unit.INSTANCE;
            sb.append(e4);
            companion.e("getCommonDeleteInfoList", sb.toString());
        }
    }

    @Override // com.stepos.policy.sdk.impl.WithdrawalImpl
    public void encryptMultiCustomDeleteInfoListBySecure(@NotNull Context context, @NotNull final ArrayList<DeleteInfoEncryptMultiBean> customDeleteInfoList, @NotNull final Function1<? super DeleteInfoBean, Unit> callBackPolicyResult) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customDeleteInfoList, "customDeleteInfoList");
        Intrinsics.checkNotNullParameter(callBackPolicyResult, "callBackPolicyResult");
        try {
            PolicySdkLogUtils.INSTANCE.d("encryptMultiCustomDeleteInfoListBySecure " + customDeleteInfoList);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.stepos.secureservice", "com.stepos.secureservice.certification.SafeCertService"));
            intent.setAction("com.stepos.secureservice.SafeCertification");
            ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$encryptMultiCustomDeleteInfoListBySecure$bindService$1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(@Nullable ComponentName name, @NotNull IBinder service) throws RemoteException {
                    Collection<String> collectionValues;
                    List<String> list;
                    Intrinsics.checkNotNullParameter(service, "service");
                    ISafeCertService iSafeCertServiceAsInterface = ISafeCertService.Stub.asInterface(service);
                    List<String> listEmptyList = CollectionsKt.emptyList();
                    Iterator<DeleteInfoEncryptMultiBean> it = customDeleteInfoList.iterator();
                    while (it.hasNext()) {
                        final DeleteInfoEncryptMultiBean next = it.next();
                        LinkedHashMap<String, String> bindMap = next.getBindMap();
                        if (bindMap != null && (collectionValues = bindMap.values()) != null && (list = CollectionsKt.toList(collectionValues)) != null) {
                            listEmptyList = list;
                        }
                        final n nVar = new n();
                        final long j4 = jCurrentTimeMillis;
                        final Function1<DeleteInfoBean, Unit> function1 = callBackPolicyResult;
                        iSafeCertServiceAsInterface.encryptMulti(listEmptyList, new IEncryptMultiCallback.Stub() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$encryptMultiCustomDeleteInfoListBySecure$bindService$1$onServiceConnected$2
                            @Override // com.stepos.secureservice.certification.IEncryptMultiCallback
                            public void onErrored(@Nullable String msg) {
                            }

                            @Override // com.stepos.secureservice.certification.IEncryptMultiCallback
                            public void onGet(@Nullable List<String> encrypted, @Nullable String keyId, int keyVersion, int keyLevel, @Nullable String extra) {
                                long jCurrentTimeMillis2 = System.currentTimeMillis();
                                PolicySdkLogUtils.INSTANCE.d("encryptMultiCustomDeleteInfoListBySecure", "耗时 " + (jCurrentTimeMillis2 - j4) + " | encrypted = " + encrypted + "  | keyId = " + keyId + " keyVersion =" + keyVersion + " keyLevel=" + keyLevel + " | extra = " + extra);
                                if (keyId == null || encrypted == null) {
                                    return;
                                }
                                LinkedHashMap<String, String> bindMap2 = next.getBindMap();
                                if (bindMap2 != null) {
                                    int i4 = 0;
                                    for (String key : bindMap2.keySet()) {
                                        int i5 = i4 + 1;
                                        if (i4 < encrypted.size()) {
                                            Intrinsics.checkNotNullExpressionValue(key, "key");
                                            bindMap2.put(key, encrypted.get(i4));
                                        }
                                        i4 = i5;
                                    }
                                }
                                PolicySdkLogUtils.INSTANCE.d("encryptMultiCustomDeleteInfoListBySecure", "  encrypted groupBy= " + next.getBindMap() + ' ');
                                String keyInfoJson = nVar.g(new KeyInfo(keyId, String.valueOf(keyVersion), String.valueOf(keyLevel), String.valueOf(extra)));
                                String bindIdJson = nVar.g(next.getBindMap());
                                String serviceId = next.getServiceId();
                                Intrinsics.checkNotNullExpressionValue(bindIdJson, "bindIdJson");
                                Intrinsics.checkNotNullExpressionValue(keyInfoJson, "keyInfoJson");
                                function1.invoke(new DeleteInfoBean(serviceId, bindIdJson, keyInfoJson));
                            }
                        });
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(@Nullable ComponentName name) {
                }
            };
            context.bindService(intent, serviceConnection, 1);
            activityLifecycleCallbacks(context, serviceConnection);
        } catch (Exception e4) {
            e4.printStackTrace();
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
            StringBuilder sb = new StringBuilder(" exception : ");
            e4.getMessage();
            Unit unit = Unit.INSTANCE;
            sb.append(e4);
            companion.e("encryptMultiCustomDeleteInfoListBySecure", sb.toString());
        }
    }

    @Override // com.stepos.policy.sdk.impl.WithdrawalImpl
    public void getCommonDeleteInfoListBySecure(@NotNull Context context, @NotNull final String businessType, final int deleteType, @NotNull final Function1<? super String, Unit> callBackPolicyResult) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(businessType, "businessType");
        Intrinsics.checkNotNullParameter(callBackPolicyResult, "callBackPolicyResult");
        try {
            PolicySdkLogUtils.INSTANCE.d("getCommonDeleteInfoList");
            final long jCurrentTimeMillis = System.currentTimeMillis();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.stepos.secureservice", "com.stepos.secureservice.policy.PolicyBindService"));
            intent.setAction("com.stepos.secureservice.PolicyBind");
            ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$getCommonDeleteInfoListBySecure$bindService$1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(@Nullable ComponentName name, @NotNull IBinder service) throws RemoteException {
                    Intrinsics.checkNotNullParameter(service, "service");
                    IPolicyBindService iPolicyBindServiceAsInterface = IPolicyBindService.Stub.asInterface(service);
                    final long j4 = jCurrentTimeMillis;
                    final Function1<String, Unit> function1 = callBackPolicyResult;
                    iPolicyBindServiceAsInterface.getPublicConfig(new IPolicyBindCallback.Stub() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$getCommonDeleteInfoListBySecure$bindService$1$onServiceConnected$1
                        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
                        public void onErrored(@Nullable String msg) {
                        }

                        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
                        public void onGet(@NotNull List<IPolicyBindResult> results, @NotNull String keyId, int keyVersion, int keyLevel, @Nullable String extra) {
                            Intrinsics.checkNotNullParameter(results, "results");
                            Intrinsics.checkNotNullParameter(keyId, "keyId");
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            PolicySdkLogUtils.INSTANCE.d("getCommonDeleteInfoList", "耗时 " + (jCurrentTimeMillis2 - j4) + " | results = " + results + " \n | keyId = " + keyId + " keyVersion =" + keyVersion + " keyLevel=" + keyLevel + " | extra = " + extra);
                            n nVar = new n();
                            ArrayList arrayList = new ArrayList();
                            String keyInfoJson = nVar.g(new KeyInfo(keyId, String.valueOf(keyVersion), String.valueOf(keyLevel), String.valueOf(extra)));
                            for (IPolicyBindResult iPolicyBindResult : results) {
                                String strValueOf = String.valueOf(iPolicyBindResult.serverId);
                                String str = iPolicyBindResult.bindId;
                                Intrinsics.checkNotNullExpressionValue(str, "policyBindResult.bindId");
                                Intrinsics.checkNotNullExpressionValue(keyInfoJson, "keyInfoJson");
                                arrayList.add(new DeleteInfoBean(strValueOf, str, keyInfoJson));
                            }
                            String deleteInfoListJson = nVar.g(arrayList);
                            Function1<String, Unit> function12 = function1;
                            Intrinsics.checkNotNullExpressionValue(deleteInfoListJson, "deleteInfoListJson");
                            function12.invoke(deleteInfoListJson);
                        }
                    }, businessType, deleteType);
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(@Nullable ComponentName name) {
                }
            };
            context.bindService(intent, serviceConnection, 1);
            activityLifecycleCallbacks(context, serviceConnection);
        } catch (Exception e4) {
            e4.printStackTrace();
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
            StringBuilder sb = new StringBuilder(" exception : ");
            e4.getMessage();
            Unit unit = Unit.INSTANCE;
            sb.append(e4);
            companion.e("getCommonDeleteInfoList", sb.toString());
        }
    }

    @Override // com.stepos.policy.sdk.impl.WithdrawalImpl
    public void getPrivateDeleteInfoListBySecure(@NotNull Context context, @NotNull final String appId, @NotNull final String businessType, final int deleteType, @NotNull final Function1<? super ArrayList<DeleteInfoBean>, Unit> callBackPolicyResult) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(businessType, "businessType");
        Intrinsics.checkNotNullParameter(callBackPolicyResult, "callBackPolicyResult");
        try {
            PolicySdkLogUtils.INSTANCE.d("getPrivateDeleteInfoList");
            final long jCurrentTimeMillis = System.currentTimeMillis();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.stepos.secureservice", "com.stepos.secureservice.policy.PolicyBindService"));
            intent.setAction("com.stepos.secureservice.PolicyBind");
            ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$getPrivateDeleteInfoListBySecure$bindService$1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(@Nullable ComponentName name, @NotNull IBinder service) throws RemoteException {
                    Intrinsics.checkNotNullParameter(service, "service");
                    IPolicyBindService iPolicyBindServiceAsInterface = IPolicyBindService.Stub.asInterface(service);
                    final long j4 = jCurrentTimeMillis;
                    final Function1<ArrayList<DeleteInfoBean>, Unit> function1 = callBackPolicyResult;
                    iPolicyBindServiceAsInterface.getPrivateConfig(new IPolicyBindCallback.Stub() { // from class: com.stepos.policy.sdk.manager.WithdrawalManager$getPrivateDeleteInfoListBySecure$bindService$1$onServiceConnected$1
                        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
                        public void onErrored(@Nullable String msg) {
                        }

                        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
                        public void onGet(@NotNull List<IPolicyBindResult> results, @NotNull String keyId, int keyVersion, int keyLevel, @Nullable String extra) {
                            Intrinsics.checkNotNullParameter(results, "results");
                            Intrinsics.checkNotNullParameter(keyId, "keyId");
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            PolicySdkLogUtils.INSTANCE.d("getPrivateDeleteInfoList", "耗时 " + (jCurrentTimeMillis2 - j4) + " | results = " + results + " \n | keyId = " + keyId + " keyVersion =" + keyVersion + " keyLevel=" + keyLevel + " | extra = " + extra);
                            n nVar = new n();
                            ArrayList<DeleteInfoBean> arrayList = new ArrayList<>();
                            String keyInfoJson = nVar.g(new KeyInfo(keyId, String.valueOf(keyVersion), String.valueOf(keyLevel), String.valueOf(extra)));
                            for (IPolicyBindResult iPolicyBindResult : results) {
                                if (iPolicyBindResult.publicFlag == 0) {
                                    String strValueOf = String.valueOf(iPolicyBindResult.serverId);
                                    String str = iPolicyBindResult.bindId;
                                    Intrinsics.checkNotNullExpressionValue(str, "policyBindResult.bindId");
                                    Intrinsics.checkNotNullExpressionValue(keyInfoJson, "keyInfoJson");
                                    arrayList.add(new DeleteInfoBean(strValueOf, str, keyInfoJson));
                                }
                            }
                            function1.invoke(arrayList);
                        }
                    }, businessType, deleteType, appId);
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(@Nullable ComponentName name) {
                }
            };
            context.bindService(intent, serviceConnection, 1);
            activityLifecycleCallbacks(context, serviceConnection);
        } catch (Exception e4) {
            e4.printStackTrace();
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
            StringBuilder sb = new StringBuilder(" exception : ");
            e4.getMessage();
            Unit unit = Unit.INSTANCE;
            sb.append(e4);
            companion.e("getPrivateDeleteInfoList", sb.toString());
        }
    }
}
