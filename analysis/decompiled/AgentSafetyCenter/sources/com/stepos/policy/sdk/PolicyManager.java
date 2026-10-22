package com.stepos.policy.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity;
import com.stepos.policy.sdk.bean.CustomDeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoEncryptMultiBean;
import com.stepos.policy.sdk.bean.PolicyData;
import com.stepos.policy.sdk.bean.PolicyFileDataResultBean;
import com.stepos.policy.sdk.bean.PolicyNewestPathResultBean;
import com.stepos.policy.sdk.bean.PolicyNewestResponse;
import com.stepos.policy.sdk.bean.PolicyRecordBaseInfo;
import com.stepos.policy.sdk.bean.PolicyRecordRequest;
import com.stepos.policy.sdk.bean.PolicyResponse;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.bean.PolicyServiceConfigBean;
import com.stepos.policy.sdk.bean.PolicyServiceConfigResponse;
import com.stepos.policy.sdk.bean.PolicyVersionResponse;
import com.stepos.policy.sdk.config.PolicySdkErrorCode;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder;
import com.stepos.policy.sdk.manager.WithdrawalManager;
import com.stepos.policy.sdk.manager.WithdrawalManagerWithoutSecureService;
import com.stepos.policy.sdk.net.PolicySdkRetrofitCreator;
import com.stepos.policy.sdk.util.PolicyCheckLogUtils;
import com.stepos.policy.sdk.util.PolicyHtmlDisplayAdapter;
import com.stepos.policy.sdk.util.PolicySdkFileUtils;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkNetworkUtil;
import com.stepos.policy.sdk.util.PolicySdkStringUtils;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import com.stepos.policy.sdk.util.ReadClipboardUtils;
import com.stepos.policy.sdk.util.SocketHookUtil;
import ie.o0;
import java.io.File;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jb.v;
import kc.e0;
import kc.k1;
import kc.q;
import kc.r;
import kc.r0;
import kc.t;
import kc.w;
import nb.c;
import nc.g;
import nc.h;
import nc.k0;
import od.f;
import pb.e;
import pb.i;
import pc.n;
import rc.d;
import stepos.support.v7.app.f0;
import stepos.support.v7.app.h0;
import t.m0;
import t.o;
import xb.l;
import xb.p;
import yb.k;
import yb.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicyManager {
    public static final PolicyManager INSTANCE = new PolicyManager();
    private static final long SYNC_LOCAL_FILE_MAX_WAIT_MS = 10000;
    private static final long SYNC_LOCAL_FILE_POLL_MS = 200;
    private static String brand;
    private static String companyCode;
    private static String customPolicyCSSFileName;
    private static final r exceptionHandler;
    private static boolean initSDKByDeviceProtectedStorageContext;
    private static final t lifecycleScope;
    private static HashMap<String, String> localAssetsCategoryPathMap;
    private static String mAppId;
    private static String mAppSecret;
    private static String mAppVersionName;
    private static String model;
    private static String osVersion;
    private static final t scope;
    private static boolean syncLocalFileFinished;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.PolicyManager$autoUploadRecord$2", f = "PolicyManager.kt", l = {1289}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$autoUploadRecord$2, reason: invalid class name */
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ Context $context;
        final /* synthetic */ u $policyRecordRequest;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(u uVar, Context context, c cVar) {
            super(2, cVar);
            this.$policyRecordRequest = uVar;
            this.$context = context;
        }

        @Override // pb.a
        public final c create(Object obj, c cVar) {
            return new AnonymousClass2(this.$policyRecordRequest, this.$context, cVar);
        }

        @Override // xb.p
        public final Object invoke(t tVar, c cVar) {
            return ((AnonymousClass2) create(tVar, cVar)).invokeSuspend(v.f6774a);
        }

        @Override // pb.a
        public final Object invokeSuspend(Object obj) {
            ob.a aVar = ob.a.f9351c;
            int i = this.label;
            if (i == 0) {
                id.c.I(obj);
                String strE = new m7.e().e(this.$policyRecordRequest.f16098c);
                PolicyManager policyManager = PolicyManager.INSTANCE;
                Context context = this.$context;
                this.label = 1;
                if (policyManager.savePolicyOperate(context, false, strE, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i != 1) {
                    f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
            }
            return v.f6774a;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {143}, m = "awaitSyncLocalFileFinished")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$awaitSyncLocalFileFinished$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00131 extends pb.c {
        long J$0;
        int label;
        /* synthetic */ Object result;

        public C00131(c cVar) {
            super(cVar);
        }

        @Override // pb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PolicyManager.this.awaitSyncLocalFileFinished(this);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.PolicyManager$checkNewestPolicy$1", f = "PolicyManager.kt", l = {1493, 1547}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$checkNewestPolicy$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00141 extends i implements p {
        final /* synthetic */ String $appId;
        final /* synthetic */ String $appSecret;
        final /* synthetic */ l $callBackPolicyResult;
        final /* synthetic */ String $category;
        final /* synthetic */ Context $context;
        final /* synthetic */ boolean $isAutoRecord;
        final /* synthetic */ String $language;
        final /* synthetic */ String $versionName;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00141(Context context, String str, String str2, boolean z10, String str3, String str4, String str5, l lVar, c cVar) {
            super(2, cVar);
            this.$context = context;
            this.$category = str;
            this.$language = str2;
            this.$isAutoRecord = z10;
            this.$appId = str3;
            this.$appSecret = str4;
            this.$versionName = str5;
            this.$callBackPolicyResult = lVar;
        }

        private static final void invokeSuspend$deliver(u uVar, l lVar, String str, String str2) {
            PolicySdkLogUtils.Companion.logCheckNewestResult((PolicySdkResultBean) uVar.f16098c, str, str2);
            lVar.invoke(uVar.f16098c);
        }

        public static /* synthetic */ void invokeSuspend$deliver$default(u uVar, l lVar, String str, String str2, int i, Object obj) {
            if ((i & 8) != 0) {
                str2 = "";
            }
            invokeSuspend$deliver(uVar, lVar, str, str2);
        }

        @Override // pb.a
        public final c create(Object obj, c cVar) {
            return new C00141(this.$context, this.$category, this.$language, this.$isAutoRecord, this.$appId, this.$appSecret, this.$versionName, this.$callBackPolicyResult, cVar);
        }

        @Override // xb.p
        public final Object invoke(t tVar, c cVar) {
            return ((C00141) create(tVar, cVar)).invokeSuspend(v.f6774a);
        }

        /* JADX WARN: Removed duplicated region for block: B:117:0x031f  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0149  */
        @Override // pb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r33) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 1030
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C00141.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {381}, m = "getAgreeStatus")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getAgreeStatus$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00171 extends pb.c {
        int label;
        /* synthetic */ Object result;

        public C00171(c cVar) {
            super(cVar);
        }

        @Override // pb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PolicyManager.this.getAgreeStatus(null, this);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1", f = "PolicyManager.kt", l = {2509}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00191 extends i implements p {
        final /* synthetic */ String $category;
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00191(Context context, String str, c cVar) {
            super(2, cVar);
            this.$context = context;
            this.$category = str;
        }

        @Override // pb.a
        public final c create(Object obj, c cVar) {
            return new C00191(this.$context, this.$category, cVar);
        }

        @Override // xb.p
        public final Object invoke(t tVar, c cVar) {
            return ((C00191) create(tVar, cVar)).invokeSuspend(v.f6774a);
        }

        @Override // pb.a
        public final Object invokeSuspend(Object obj) {
            ob.a aVar = ob.a.f9351c;
            int i = this.label;
            if (i == 0) {
                id.c.I(obj);
                final g data = PolicyManagerKt.getPolicySdkDataStore(this.$context).getData();
                final String str = this.$category;
                g gVar = new g() { // from class: com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1

                    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
                    /* renamed from: com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements h {
                        final /* synthetic */ String $category$inlined;
                        final /* synthetic */ h $this_unsafeFlow;

                        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
                        @e(c = "com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1$2", f = "PolicyManager.kt", l = {223}, m = "emit")
                        /* renamed from: com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        public static final class AnonymousClass1 extends pb.c {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(c cVar) {
                                super(cVar);
                            }

                            @Override // pb.a
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(h hVar, String str) {
                            this.$this_unsafeFlow = hVar;
                            this.$category$inlined = str;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // nc.h
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r6, nb.c r7) {
                            /*
                                r5 = this;
                                boolean r0 = r7 instanceof com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r7
                                com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1$2$1
                                r0.<init>(r7)
                            L18:
                                java.lang.Object r7 = r0.result
                                ob.a r1 = ob.a.f9351c
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L2e
                                if (r2 != r3) goto L27
                                id.c.I(r7)
                                goto L56
                            L27:
                                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                                od.f.e(r5)
                                r5 = 0
                                return r5
                            L2e:
                                id.c.I(r7)
                                nc.h r7 = r5.$this_unsafeFlow
                                y3.b r6 = (y3.b) r6
                                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                java.lang.String r4 = "local_"
                                r2.<init>(r4)
                                java.lang.String r5 = r5.$category$inlined
                                r2.append(r5)
                                java.lang.String r5 = r2.toString()
                                y3.e r5 = t.o.n(r5)
                                java.lang.Object r5 = r6.c(r5)
                                r0.label = r3
                                java.lang.Object r5 = r7.emit(r5, r0)
                                if (r5 != r1) goto L56
                                return r1
                            L56:
                                jb.v r5 = jb.v.f6774a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, nb.c):java.lang.Object");
                        }
                    }

                    @Override // nc.g
                    public Object collect(h hVar, c cVar) {
                        Object objCollect = data.collect(new AnonymousClass2(hVar, str), cVar);
                        return objCollect == ob.a.f9351c ? objCollect : v.f6774a;
                    }
                };
                this.label = 1;
                obj = k0.i(gVar, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i != 1) {
                    f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
            }
            String strValueOf = String.valueOf(obj);
            return strValueOf.equals("null") ? "" : strValueOf;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.PolicyManager$getPolicyByVersion$1", f = "PolicyManager.kt", l = {2242}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyByVersion$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00201 extends i implements p {
        final /* synthetic */ String $appId;
        final /* synthetic */ String $appSecret;
        final /* synthetic */ l $callBackPolicyResult;
        final /* synthetic */ String $language;
        final /* synthetic */ Long $versionId;
        final /* synthetic */ String $versionName;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00201(Long l2, String str, String str2, String str3, l lVar, String str4, c cVar) {
            super(2, cVar);
            this.$versionId = l2;
            this.$versionName = str;
            this.$appId = str2;
            this.$appSecret = str3;
            this.$callBackPolicyResult = lVar;
            this.$language = str4;
        }

        @Override // pb.a
        public final c create(Object obj, c cVar) {
            return new C00201(this.$versionId, this.$versionName, this.$appId, this.$appSecret, this.$callBackPolicyResult, this.$language, cVar);
        }

        @Override // xb.p
        public final Object invoke(t tVar, c cVar) {
            return ((C00201) create(tVar, cVar)).invokeSuspend(v.f6774a);
        }

        @Override // pb.a
        public final Object invokeSuspend(Object obj) {
            Object objE;
            PolicySdkResultBean policySdkResultBean;
            PolicyVersionResponse policyVersionResponse;
            PolicyData data;
            ob.a aVar = ob.a.f9351c;
            int i = this.label;
            try {
            } catch (Throwable th) {
                PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                StringBuilder sb2 = new StringBuilder("exception : ");
                th.getMessage();
                sb2.append(th);
                companion.e("PolicyManager", sb2.toString());
            }
            if (i == 0) {
                id.c.I(obj);
                PolicySdkResultBean policySdkResultBean2 = new PolicySdkResultBean();
                if (this.$versionId == null || this.$versionName == null) {
                    policySdkResultBean2.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
                    PolicySdkLogUtils.Companion.e("PolicyManager", "return policySdkResultBean = : " + policySdkResultBean2.getCode());
                    this.$callBackPolicyResult.invoke(policySdkResultBean2);
                    return v.f6774a;
                }
                yb.t tVar = new yb.t();
                long jCurrentTimeMillis = System.currentTimeMillis();
                tVar.f16097c = jCurrentTimeMillis;
                u uVar = new u();
                uVar.f16098c = PolicySdkToolsUtils.Companion.getAppSign(this.$appId, this.$appSecret, jCurrentTimeMillis);
                rc.e eVar = e0.f7430a;
                d dVar = d.f10552f;
                PolicyManager$getPolicyByVersion$1$response$1 policyManager$getPolicyByVersion$1$response$1 = new PolicyManager$getPolicyByVersion$1$response$1(this.$appId, uVar, tVar, this.$language, this.$versionId, this.$versionName, null);
                this.L$0 = policySdkResultBean2;
                this.label = 1;
                objE = w.E(dVar, policyManager$getPolicyByVersion$1$response$1, this);
                if (objE == aVar) {
                    return aVar;
                }
                policySdkResultBean = policySdkResultBean2;
            } else {
                if (i != 1) {
                    f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                policySdkResultBean = (PolicySdkResultBean) this.L$0;
                id.c.I(obj);
                objE = obj;
            }
            o0 o0Var = (o0) objE;
            PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
            companion2.d("PolicyManager", "response" + o0Var);
            ad.e0 e0Var = o0Var.f6056a;
            Object obj2 = o0Var.f6057b;
            if (e0Var.e()) {
                companion2.d("PolicyManager", "response isSuccessful");
                companion2.d("PolicyManager", "response.code()=" + o0Var.f6056a.f471h);
                companion2.d("PolicyManager", "response.body() =" + obj2);
                PolicyVersionResponse policyVersionResponse2 = (PolicyVersionResponse) obj2;
                policyVersionResponse = policyVersionResponse2 != null ? policyVersionResponse2 : null;
                policySdkResultBean.setCode(0);
                if (policyVersionResponse != null && (data = policyVersionResponse.getData()) != null) {
                    policySdkResultBean.setPolicyData(data);
                }
                companion2.e("PolicyManager", "return policySdkResultBean = : " + policySdkResultBean.getCode());
                this.$callBackPolicyResult.invoke(policySdkResultBean);
                return v.f6774a;
            }
            companion2.d("PolicyManager", "response failed");
            policySdkResultBean.setCode(0);
            if (policyVersionResponse != null) {
                policySdkResultBean.setPolicyData(data);
            }
            companion2.e("PolicyManager", "return policySdkResultBean = : " + policySdkResultBean.getCode());
            this.$callBackPolicyResult.invoke(policySdkResultBean);
            return v.f6774a;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.PolicyManager$getPolicyData$1", f = "PolicyManager.kt", l = {2067}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00211 extends i implements p {
        final /* synthetic */ String $appId;
        final /* synthetic */ String $appSecret;
        final /* synthetic */ l $callBackPolicyResult;
        final /* synthetic */ String $category;
        final /* synthetic */ String $language;
        final /* synthetic */ Long $version;
        final /* synthetic */ String $versionName;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00211(String str, Long l2, String str2, String str3, String str4, l lVar, String str5, c cVar) {
            super(2, cVar);
            this.$category = str;
            this.$version = l2;
            this.$versionName = str2;
            this.$appId = str3;
            this.$appSecret = str4;
            this.$callBackPolicyResult = lVar;
            this.$language = str5;
        }

        @Override // pb.a
        public final c create(Object obj, c cVar) {
            return new C00211(this.$category, this.$version, this.$versionName, this.$appId, this.$appSecret, this.$callBackPolicyResult, this.$language, cVar);
        }

        @Override // xb.p
        public final Object invoke(t tVar, c cVar) {
            return ((C00211) create(tVar, cVar)).invokeSuspend(v.f6774a);
        }

        @Override // pb.a
        public final Object invokeSuspend(Object obj) {
            Object objE;
            PolicySdkResultBean policySdkResultBean;
            PolicyNewestResponse policyNewestResponse;
            PolicyData data;
            ob.a aVar = ob.a.f9351c;
            int i = this.label;
            try {
            } catch (Throwable th) {
                PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                StringBuilder sb2 = new StringBuilder("Throwable : ");
                th.getMessage();
                sb2.append(th);
                companion.e("PolicyManager", sb2.toString());
                PolicySdkResultBean policySdkResultBean2 = new PolicySdkResultBean();
                policySdkResultBean2.setCode(PolicySdkErrorCode.NETWORK_ERROR);
                this.$callBackPolicyResult.invoke(policySdkResultBean2);
            }
            if (i == 0) {
                id.c.I(obj);
                PolicySdkResultBean policySdkResultBean3 = new PolicySdkResultBean();
                if (this.$category == null || this.$version == null || this.$versionName == null) {
                    policySdkResultBean3.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
                    PolicySdkLogUtils.Companion.e("PolicyManager", "return policySdkResultBean = : " + policySdkResultBean3.getCode());
                    this.$callBackPolicyResult.invoke(policySdkResultBean3);
                    return v.f6774a;
                }
                yb.t tVar = new yb.t();
                long jCurrentTimeMillis = System.currentTimeMillis();
                tVar.f16097c = jCurrentTimeMillis;
                u uVar = new u();
                uVar.f16098c = PolicySdkToolsUtils.Companion.getAppSign(this.$appId, this.$appSecret, jCurrentTimeMillis);
                rc.e eVar = e0.f7430a;
                d dVar = d.f10552f;
                PolicyManager$getPolicyData$1$response$1 policyManager$getPolicyData$1$response$1 = new PolicyManager$getPolicyData$1$response$1(this.$appId, uVar, this.$category, tVar, this.$language, this.$version, this.$versionName, null);
                this.L$0 = policySdkResultBean3;
                this.label = 1;
                objE = w.E(dVar, policyManager$getPolicyData$1$response$1, this);
                if (objE == aVar) {
                    return aVar;
                }
                policySdkResultBean = policySdkResultBean3;
            } else {
                if (i != 1) {
                    f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                policySdkResultBean = (PolicySdkResultBean) this.L$0;
                id.c.I(obj);
                objE = obj;
            }
            o0 o0Var = (o0) objE;
            PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
            companion2.d("getPolicyData", "response" + o0Var);
            ad.e0 e0Var = o0Var.f6056a;
            Object obj2 = o0Var.f6057b;
            if (e0Var.e() && (policyNewestResponse = (PolicyNewestResponse) obj2) != null && policyNewestResponse.getCode() == 200) {
                companion2.d("getPolicyData", "response isSuccessful");
                companion2.d("getPolicyData", "response.code()=" + o0Var.f6056a.f471h);
                companion2.d("PolicyManager", "response.body() =" + obj2);
                PolicyNewestResponse policyNewestResponse2 = (PolicyNewestResponse) obj2;
                PolicyNewestResponse policyNewestResponse3 = policyNewestResponse2 != null ? policyNewestResponse2 : null;
                if (policyNewestResponse3 != null) {
                    policySdkResultBean.setCode(0);
                    PolicyResponse data2 = policyNewestResponse3.getData();
                    if (data2 != null && (data = data2.getData()) != null) {
                        policySdkResultBean.setPolicyData(data);
                        policySdkResultBean.setPolicyUrl(data.getPolicyUrl());
                    }
                    PolicyResponse data3 = policyNewestResponse3.getData();
                    if (data3 != null) {
                        policySdkResultBean.setPolicyNewest(data3.getNewest());
                    }
                }
            } else {
                policySdkResultBean.setCode(-1);
                companion2.d("PolicyManager", "response failed");
            }
            companion2.e("PolicyManager", "return policySdkResultBean = : " + policySdkResultBean.getCode());
            this.$callBackPolicyResult.invoke(policySdkResultBean);
            return v.f6774a;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.PolicyManager$getPolicyHistoryList$1", f = "PolicyManager.kt", l = {2162}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyHistoryList$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00221 extends i implements p {
        final /* synthetic */ String $appId;
        final /* synthetic */ String $appSecret;
        final /* synthetic */ l $callBackPolicyResult;
        final /* synthetic */ String $category;
        final /* synthetic */ String $language;
        final /* synthetic */ long $version;
        final /* synthetic */ String $versionName;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00221(String str, String str2, String str3, String str4, l lVar, String str5, long j10, c cVar) {
            super(2, cVar);
            this.$category = str;
            this.$versionName = str2;
            this.$appId = str3;
            this.$appSecret = str4;
            this.$callBackPolicyResult = lVar;
            this.$language = str5;
            this.$version = j10;
        }

        @Override // pb.a
        public final c create(Object obj, c cVar) {
            return new C00221(this.$category, this.$versionName, this.$appId, this.$appSecret, this.$callBackPolicyResult, this.$language, this.$version, cVar);
        }

        @Override // xb.p
        public final Object invoke(t tVar, c cVar) {
            return ((C00221) create(tVar, cVar)).invokeSuspend(v.f6774a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00de A[Catch: all -> 0x00d0, TryCatch #0 {all -> 0x00d0, blocks: (B:25:0x0094, B:27:0x00a1, B:34:0x00d8, B:36:0x00de, B:37:0x00e1, B:33:0x00d2, B:40:0x00fe), top: B:45:0x0012 }] */
        /* JADX WARN: Type inference failed for: r7v0 */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v7 */
        @Override // pb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r23) {
            /*
                Method dump skipped, instructions count: 312
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C00221.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {323}, m = "getPolicyOperate")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyOperate$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00231 extends pb.c {
        int label;
        /* synthetic */ Object result;

        public C00231(c cVar) {
            super(cVar);
        }

        @Override // pb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PolicyManager.this.getPolicyOperate(null, this);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.PolicyManager$getPolicyServiceConfig$1", f = "PolicyManager.kt", l = {2534}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyServiceConfig$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00241 extends i implements p {
        final /* synthetic */ String $appId;
        final /* synthetic */ String $appSecret;
        final /* synthetic */ l $callBackPolicyResult;
        final /* synthetic */ Context $context;
        final /* synthetic */ String $language;
        final /* synthetic */ String $versionName;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00241(String str, String str2, String str3, l lVar, String str4, Context context, c cVar) {
            super(2, cVar);
            this.$versionName = str;
            this.$appId = str2;
            this.$appSecret = str3;
            this.$callBackPolicyResult = lVar;
            this.$language = str4;
            this.$context = context;
        }

        @Override // pb.a
        public final c create(Object obj, c cVar) {
            return new C00241(this.$versionName, this.$appId, this.$appSecret, this.$callBackPolicyResult, this.$language, this.$context, cVar);
        }

        @Override // xb.p
        public final Object invoke(t tVar, c cVar) {
            return ((C00241) create(tVar, cVar)).invokeSuspend(v.f6774a);
        }

        @Override // pb.a
        public final Object invokeSuspend(Object obj) {
            Object objE;
            PolicySdkResultBean policySdkResultBean;
            PolicyServiceConfigResponse policyServiceConfigResponse;
            List<PolicyServiceConfigBean> data;
            ob.a aVar = ob.a.f9351c;
            int i = this.label;
            try {
            } catch (Throwable th) {
                PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                StringBuilder sb2 = new StringBuilder("exception : ");
                th.getMessage();
                sb2.append(th);
                companion.e("PolicyManager", sb2.toString());
            }
            if (i == 0) {
                id.c.I(obj);
                PolicySdkResultBean policySdkResultBean2 = new PolicySdkResultBean();
                if (this.$versionName == null) {
                    policySdkResultBean2.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
                    PolicySdkLogUtils.Companion.e("PolicyManager", "return policySdkResultBean = : " + policySdkResultBean2.getCode());
                    this.$callBackPolicyResult.invoke(policySdkResultBean2);
                    return v.f6774a;
                }
                yb.t tVar = new yb.t();
                long jCurrentTimeMillis = System.currentTimeMillis();
                tVar.f16097c = jCurrentTimeMillis;
                u uVar = new u();
                uVar.f16098c = PolicySdkToolsUtils.Companion.getAppSign(this.$appId, this.$appSecret, jCurrentTimeMillis);
                rc.e eVar = e0.f7430a;
                d dVar = d.f10552f;
                PolicyManager$getPolicyServiceConfig$1$response$1 policyManager$getPolicyServiceConfig$1$response$1 = new PolicyManager$getPolicyServiceConfig$1$response$1(this.$appId, uVar, tVar, this.$language, this.$versionName, null);
                this.L$0 = policySdkResultBean2;
                this.label = 1;
                objE = w.E(dVar, policyManager$getPolicyServiceConfig$1$response$1, this);
                if (objE == aVar) {
                    return aVar;
                }
                policySdkResultBean = policySdkResultBean2;
            } else {
                if (i != 1) {
                    f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                policySdkResultBean = (PolicySdkResultBean) this.L$0;
                id.c.I(obj);
                objE = obj;
            }
            o0 o0Var = (o0) objE;
            PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
            companion2.d("PolicyManager", "response" + o0Var);
            ad.e0 e0Var = o0Var.f6056a;
            Object obj2 = o0Var.f6057b;
            if (e0Var.e()) {
                companion2.d("PolicyManager", "response isSuccessful");
                companion2.d("PolicyManager", "response.code()=" + o0Var.f6056a.f471h);
                companion2.d("PolicyManager", "response.body() =" + obj2);
                PolicyServiceConfigResponse policyServiceConfigResponse2 = (PolicyServiceConfigResponse) obj2;
                policyServiceConfigResponse = policyServiceConfigResponse2 != null ? policyServiceConfigResponse2 : null;
                policySdkResultBean.setCode(0);
                if (policyServiceConfigResponse != null && (data = policyServiceConfigResponse.getData()) != null) {
                    Context context = this.$context;
                    policySdkResultBean.setPolicyServiceConfigList(data);
                    policySdkResultBean.setDeleteInfoBeanList(PolicySdkStringUtils.INSTANCE.getDeleteInfoListFromServiceConfig(context, data));
                }
                companion2.d("PolicyManager", "return policySdkResultBean = : " + policySdkResultBean.getCode());
                this.$callBackPolicyResult.invoke(policySdkResultBean);
                return v.f6774a;
            }
            companion2.d("PolicyManager", "response failed");
            policySdkResultBean.setCode(0);
            if (policyServiceConfigResponse != null) {
                Context context2 = this.$context;
                policySdkResultBean.setPolicyServiceConfigList(data);
                policySdkResultBean.setDeleteInfoBeanList(PolicySdkStringUtils.INSTANCE.getDeleteInfoListFromServiceConfig(context2, data));
            }
            companion2.d("PolicyManager", "return policySdkResultBean = : " + policySdkResultBean.getCode());
            this.$callBackPolicyResult.invoke(policySdkResultBean);
            return v.f6774a;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.PolicyManager$getReadClipboardStatus$1", f = "PolicyManager.kt", l = {352}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getReadClipboardStatus$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00261 extends i implements p {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00261(Context context, c cVar) {
            super(2, cVar);
            this.$context = context;
        }

        @Override // pb.a
        public final c create(Object obj, c cVar) {
            return new C00261(this.$context, cVar);
        }

        @Override // xb.p
        public final Object invoke(t tVar, c cVar) {
            return ((C00261) create(tVar, cVar)).invokeSuspend(v.f6774a);
        }

        @Override // pb.a
        public final Object invokeSuspend(Object obj) {
            ob.a aVar = ob.a.f9351c;
            int i = this.label;
            if (i == 0) {
                id.c.I(obj);
                final g data = PolicyManagerKt.getPolicySdkDataStore(this.$context).getData();
                g gVar = new g() { // from class: com.stepos.policy.sdk.PolicyManager$getReadClipboardStatus$1$invokeSuspend$$inlined$map$1

                    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
                    /* renamed from: com.stepos.policy.sdk.PolicyManager$getReadClipboardStatus$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements h {
                        final /* synthetic */ h $this_unsafeFlow;

                        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
                        @e(c = "com.stepos.policy.sdk.PolicyManager$getReadClipboardStatus$1$invokeSuspend$$inlined$map$1$2", f = "PolicyManager.kt", l = {223}, m = "emit")
                        /* renamed from: com.stepos.policy.sdk.PolicyManager$getReadClipboardStatus$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        public static final class AnonymousClass1 extends pb.c {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(c cVar) {
                                super(cVar);
                            }

                            @Override // pb.a
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(h hVar) {
                            this.$this_unsafeFlow = hVar;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // nc.h
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r5, nb.c r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof com.stepos.policy.sdk.PolicyManager$getReadClipboardStatus$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.stepos.policy.sdk.PolicyManager$getReadClipboardStatus$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.stepos.policy.sdk.PolicyManager$getReadClipboardStatus$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.stepos.policy.sdk.PolicyManager$getReadClipboardStatus$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.stepos.policy.sdk.PolicyManager$getReadClipboardStatus$1$invokeSuspend$$inlined$map$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                ob.a r1 = ob.a.f9351c
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L2e
                                if (r2 != r3) goto L27
                                id.c.I(r6)
                                goto L46
                            L27:
                                java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
                                od.f.e(r4)
                                r4 = 0
                                return r4
                            L2e:
                                id.c.I(r6)
                                nc.h r4 = r4.$this_unsafeFlow
                                y3.b r5 = (y3.b) r5
                                y3.e r6 = com.stepos.policy.sdk.PolicyManagerKt.getKEY_READ_CLIPBOARD_STATUS()
                                java.lang.Object r5 = r5.c(r6)
                                r0.label = r3
                                java.lang.Object r4 = r4.emit(r5, r0)
                                if (r4 != r1) goto L46
                                return r1
                            L46:
                                jb.v r4 = jb.v.f6774a
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager$getReadClipboardStatus$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, nb.c):java.lang.Object");
                        }
                    }

                    @Override // nc.g
                    public Object collect(h hVar, c cVar) {
                        Object objCollect = data.collect(new AnonymousClass2(hVar), cVar);
                        return objCollect == ob.a.f9351c ? objCollect : v.f6774a;
                    }
                };
                this.label = 1;
                obj = k0.i(gVar, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i != 1) {
                    f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
            }
            Integer num = (Integer) obj;
            return num == null ? new Integer(ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_DISAGREE) : num;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {1828}, m = "initPolicyNewestPath")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$initPolicyNewestPath$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00271 extends pb.c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C00271(c cVar) {
            super(cVar);
        }

        @Override // pb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PolicyManager.initPolicyNewestPath(null, null, null, this);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.PolicyManager$initSDK$1", f = "PolicyManager.kt", l = {257}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$initSDK$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00281 extends i implements p {
        final /* synthetic */ HashMap<String, String> $policyCategoryMap;
        final /* synthetic */ Context $policyContext;
        int label;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        @e(c = "com.stepos.policy.sdk.PolicyManager$initSDK$1$1", f = "PolicyManager.kt", l = {270}, m = "invokeSuspend")
        /* renamed from: com.stepos.policy.sdk.PolicyManager$initSDK$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00061 extends i implements p {
            final /* synthetic */ HashMap<String, String> $policyCategoryMap;
            final /* synthetic */ Context $policyContext;
            Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00061(Context context, HashMap<String, String> map, c cVar) {
                super(2, cVar);
                this.$policyContext = context;
                this.$policyCategoryMap = map;
            }

            @Override // pb.a
            public final c create(Object obj, c cVar) {
                return new C00061(this.$policyContext, this.$policyCategoryMap, cVar);
            }

            @Override // xb.p
            public final Object invoke(t tVar, c cVar) {
                return ((C00061) create(tVar, cVar)).invokeSuspend(v.f6774a);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0058  */
            /* JADX WARN: Removed duplicated region for block: B:15:0x00a6  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x008c -> B:14:0x008f). Please report as a decompilation issue!!! */
            @Override // pb.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                /*
                    r9 = this;
                    ob.a r0 = ob.a.f9351c
                    int r1 = r9.label
                    java.lang.String r2 = " *************** policyKey = "
                    r3 = 1
                    java.lang.String r4 = "initSDK"
                    if (r1 == 0) goto L20
                    if (r1 != r3) goto L19
                    java.lang.Object r1 = r9.L$1
                    java.lang.String r1 = (java.lang.String) r1
                    java.lang.Object r5 = r9.L$0
                    java.util.Iterator r5 = (java.util.Iterator) r5
                    id.c.I(r10)
                    goto L8f
                L19:
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    od.f.e(r9)
                    r9 = 0
                    return r9
                L20:
                    id.c.I(r10)
                    com.stepos.policy.sdk.PolicyManager r10 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                    r1 = 0
                    r10.setSyncLocalFileFinished(r1)
                    com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r1 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    java.lang.String r6 = "syncLocalFileFinished start time = "
                    r5.<init>(r6)
                    long r6 = java.lang.System.currentTimeMillis()
                    r5.append(r6)
                    java.lang.String r5 = r5.toString()
                    r1.d(r4, r5)
                    android.content.Context r1 = r9.$policyContext
                    java.util.HashMap<java.lang.String, java.lang.String> r5 = r9.$policyCategoryMap
                    com.stepos.policy.sdk.PolicyManager.access$selfCheckLocalAssets(r10, r1, r5)
                    java.util.HashMap<java.lang.String, java.lang.String> r10 = r9.$policyCategoryMap
                    java.util.Set r10 = r10.entrySet()
                    java.util.Iterator r10 = r10.iterator()
                    r5 = r10
                L52:
                    boolean r10 = r5.hasNext()
                    if (r10 == 0) goto La6
                    java.lang.Object r10 = r5.next()
                    java.util.Map$Entry r10 = (java.util.Map.Entry) r10
                    java.lang.Object r1 = r10.getKey()
                    java.lang.String r1 = (java.lang.String) r1
                    java.lang.Object r10 = r10.getValue()
                    java.lang.String r10 = (java.lang.String) r10
                    com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r6 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    r7.<init>(r2)
                    r7.append(r1)
                    java.lang.String r8 = " start***************"
                    r7.append(r8)
                    java.lang.String r7 = r7.toString()
                    r6.d(r4, r7)
                    android.content.Context r6 = r9.$policyContext
                    r9.L$0 = r5
                    r9.L$1 = r1
                    r9.label = r3
                    java.lang.Object r10 = com.stepos.policy.sdk.PolicyManager.initPolicyNewestPath(r6, r10, r1, r9)
                    if (r10 != r0) goto L8f
                    return r0
                L8f:
                    com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r10 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>(r2)
                    r6.append(r1)
                    java.lang.String r1 = " end ***************"
                    r6.append(r1)
                    java.lang.String r1 = r6.toString()
                    r10.d(r4, r1)
                    goto L52
                La6:
                    com.stepos.policy.sdk.PolicyManager r10 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                    r10.setSyncLocalFileFinished(r3)
                    com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r10 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r1 = ">>> DONE syncLocalFileFinished=true, storage="
                    r0.<init>(r1)
                    android.content.Context r1 = r9.$policyContext
                    java.io.File r1 = r1.getDataDir()
                    if (r1 == 0) goto Lc1
                    java.lang.String r1 = r1.getPath()
                    goto Lc2
                Lc1:
                    r1 = 0
                Lc2:
                    r0.append(r1)
                    java.lang.String r1 = ", categories="
                    r0.append(r1)
                    java.util.HashMap<java.lang.String, java.lang.String> r9 = r9.$policyCategoryMap
                    java.util.Set r9 = r9.keySet()
                    r0.append(r9)
                    java.lang.String r9 = r0.toString()
                    r10.i(r4, r9)
                    jb.v r9 = jb.v.f6774a
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C00281.C00061.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00281(Context context, HashMap<String, String> map, c cVar) {
            super(2, cVar);
            this.$policyContext = context;
            this.$policyCategoryMap = map;
        }

        @Override // pb.a
        public final c create(Object obj, c cVar) {
            return new C00281(this.$policyContext, this.$policyCategoryMap, cVar);
        }

        @Override // xb.p
        public final Object invoke(t tVar, c cVar) {
            return ((C00281) create(tVar, cVar)).invokeSuspend(v.f6774a);
        }

        @Override // pb.a
        public final Object invokeSuspend(Object obj) {
            ob.a aVar = ob.a.f9351c;
            int i = this.label;
            if (i == 0) {
                id.c.I(obj);
                rc.e eVar = e0.f7430a;
                d dVar = d.f10552f;
                C00061 c00061 = new C00061(this.$policyContext, this.$policyCategoryMap, null);
                this.label = 1;
                if (w.E(dVar, c00061, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i != 1) {
                    f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
            }
            return v.f6774a;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.PolicyManager$saveAgreeStatus$1", f = "PolicyManager.kt", l = {363}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$saveAgreeStatus$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00301 extends i implements p {
        final /* synthetic */ Context $context;
        final /* synthetic */ int $status;
        int label;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        @e(c = "com.stepos.policy.sdk.PolicyManager$saveAgreeStatus$1$1", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.stepos.policy.sdk.PolicyManager$saveAgreeStatus$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00091 extends i implements p {
            final /* synthetic */ int $status;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00091(int i, c cVar) {
                super(2, cVar);
                this.$status = i;
            }

            @Override // pb.a
            public final c create(Object obj, c cVar) {
                C00091 c00091 = new C00091(this.$status, cVar);
                c00091.L$0 = obj;
                return c00091;
            }

            @Override // xb.p
            public final Object invoke(y3.b bVar, c cVar) {
                return ((C00091) create(bVar, cVar)).invokeSuspend(v.f6774a);
            }

            @Override // pb.a
            public final Object invokeSuspend(Object obj) {
                ob.a aVar = ob.a.f9351c;
                if (this.label != 0) {
                    f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                ((y3.b) this.L$0).d(PolicyManagerKt.getKEY_AGREE_STATUS(), new Integer(this.$status));
                return v.f6774a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00301(Context context, int i, c cVar) {
            super(2, cVar);
            this.$context = context;
            this.$status = i;
        }

        @Override // pb.a
        public final c create(Object obj, c cVar) {
            return new C00301(this.$context, this.$status, cVar);
        }

        @Override // xb.p
        public final Object invoke(t tVar, c cVar) {
            return ((C00301) create(tVar, cVar)).invokeSuspend(v.f6774a);
        }

        @Override // pb.a
        public final Object invokeSuspend(Object obj) {
            ob.a aVar = ob.a.f9351c;
            int i = this.label;
            try {
                if (i == 0) {
                    id.c.I(obj);
                    v3.f policySdkDataStore = PolicyManagerKt.getPolicySdkDataStore(this.$context);
                    C00091 c00091 = new C00091(this.$status, null);
                    this.label = 1;
                    if (m0.h(policySdkDataStore, c00091, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        f.e("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    id.c.I(obj);
                }
            } catch (Exception e10) {
                PolicySdkLogUtils.Companion.e("savePolicyCategoryVersion", "error =" + e10 + ' ');
            }
            return v.f6774a;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.PolicyManager$saveDataStoreString$2", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$saveDataStoreString$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00312 extends i implements p {
        final /* synthetic */ y3.e $dataStoreKey;
        final /* synthetic */ String $dataStoreValue;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00312(y3.e eVar, String str, c cVar) {
            super(2, cVar);
            this.$dataStoreKey = eVar;
            this.$dataStoreValue = str;
        }

        @Override // pb.a
        public final c create(Object obj, c cVar) {
            C00312 c00312 = new C00312(this.$dataStoreKey, this.$dataStoreValue, cVar);
            c00312.L$0 = obj;
            return c00312;
        }

        @Override // xb.p
        public final Object invoke(y3.b bVar, c cVar) {
            return ((C00312) create(bVar, cVar)).invokeSuspend(v.f6774a);
        }

        @Override // pb.a
        public final Object invokeSuspend(Object obj) {
            ob.a aVar = ob.a.f9351c;
            if (this.label != 0) {
                f.e("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            id.c.I(obj);
            y3.b bVar = (y3.b) this.L$0;
            y3.e eVar = this.$dataStoreKey;
            String str = this.$dataStoreValue;
            if (str == null) {
                str = "";
            }
            bVar.d(eVar, str);
            return v.f6774a;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.PolicyManager$saveLocalCategoryMd5$1", f = "PolicyManager.kt", l = {2490}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$saveLocalCategoryMd5$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00321 extends i implements p {
        final /* synthetic */ String $category;
        final /* synthetic */ Context $context;
        final /* synthetic */ String $md5;
        int label;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        @e(c = "com.stepos.policy.sdk.PolicyManager$saveLocalCategoryMd5$1$1", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.stepos.policy.sdk.PolicyManager$saveLocalCategoryMd5$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00101 extends i implements p {
            final /* synthetic */ String $category;
            final /* synthetic */ String $md5;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00101(String str, String str2, c cVar) {
                super(2, cVar);
                this.$category = str;
                this.$md5 = str2;
            }

            @Override // pb.a
            public final c create(Object obj, c cVar) {
                C00101 c00101 = new C00101(this.$category, this.$md5, cVar);
                c00101.L$0 = obj;
                return c00101;
            }

            @Override // xb.p
            public final Object invoke(y3.b bVar, c cVar) {
                return ((C00101) create(bVar, cVar)).invokeSuspend(v.f6774a);
            }

            @Override // pb.a
            public final Object invokeSuspend(Object obj) {
                ob.a aVar = ob.a.f9351c;
                if (this.label != 0) {
                    f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                y3.b bVar = (y3.b) this.L$0;
                y3.e eVarN = o.n("local_" + this.$category);
                String str = this.$md5;
                bVar.getClass();
                bVar.e(eVarN, str);
                return v.f6774a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00321(String str, String str2, Context context, c cVar) {
            super(2, cVar);
            this.$category = str;
            this.$md5 = str2;
            this.$context = context;
        }

        @Override // pb.a
        public final c create(Object obj, c cVar) {
            return new C00321(this.$category, this.$md5, this.$context, cVar);
        }

        @Override // xb.p
        public final Object invoke(t tVar, c cVar) {
            return ((C00321) create(tVar, cVar)).invokeSuspend(v.f6774a);
        }

        @Override // pb.a
        public final Object invokeSuspend(Object obj) {
            ob.a aVar = ob.a.f9351c;
            int i = this.label;
            try {
                if (i == 0) {
                    id.c.I(obj);
                    PolicySdkLogUtils.Companion.d("saveLocalCategoryMd5", "the " + this.$category + " save local md5 is " + this.$md5);
                    String str = this.$md5;
                    if (str != null && str.length() != 0) {
                        v3.f policySdkDataStore = PolicyManagerKt.getPolicySdkDataStore(this.$context);
                        C00101 c00101 = new C00101(this.$category, this.$md5, null);
                        this.label = 1;
                        if (m0.h(policySdkDataStore, c00101, this) == aVar) {
                            return aVar;
                        }
                    }
                } else {
                    if (i != 1) {
                        f.e("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    id.c.I(obj);
                }
            } catch (Exception e10) {
                PolicySdkLogUtils.Companion.e("saveLocalCategoryMd5", "error =" + e10 + ' ');
            }
            return v.f6774a;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {297, 301}, m = "savePolicyOperate")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$savePolicyOperate$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00331 extends pb.c {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C00331(c cVar) {
            super(cVar);
        }

        @Override // pb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PolicyManager.this.savePolicyOperate(null, false, null, this);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.PolicyManager$savePolicyOperate$2", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$savePolicyOperate$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00342 extends i implements p {
        final /* synthetic */ boolean $isOperateSuccess;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00342(boolean z10, c cVar) {
            super(2, cVar);
            this.$isOperateSuccess = z10;
        }

        @Override // pb.a
        public final c create(Object obj, c cVar) {
            C00342 c00342 = new C00342(this.$isOperateSuccess, cVar);
            c00342.L$0 = obj;
            return c00342;
        }

        @Override // xb.p
        public final Object invoke(y3.b bVar, c cVar) {
            return ((C00342) create(bVar, cVar)).invokeSuspend(v.f6774a);
        }

        @Override // pb.a
        public final Object invokeSuspend(Object obj) {
            ob.a aVar = ob.a.f9351c;
            if (this.label != 0) {
                f.e("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            id.c.I(obj);
            ((y3.b) this.L$0).d(PolicyManagerKt.getKEY_POLICY_OPERATE(), Boolean.valueOf(this.$isOperateSuccess));
            return v.f6774a;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.PolicyManager$savePolicyOperate$3", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$savePolicyOperate$3, reason: invalid class name */
    public static final class AnonymousClass3 extends i implements p {
        final /* synthetic */ String $operateJson;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str, c cVar) {
            super(2, cVar);
            this.$operateJson = str;
        }

        @Override // pb.a
        public final c create(Object obj, c cVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$operateJson, cVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // xb.p
        public final Object invoke(y3.b bVar, c cVar) {
            return ((AnonymousClass3) create(bVar, cVar)).invokeSuspend(v.f6774a);
        }

        @Override // pb.a
        public final Object invokeSuspend(Object obj) {
            ob.a aVar = ob.a.f9351c;
            if (this.label != 0) {
                f.e("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            id.c.I(obj);
            y3.b bVar = (y3.b) this.L$0;
            y3.e key_policy_operate_json = PolicyManagerKt.getKEY_POLICY_OPERATE_JSON();
            String str = this.$operateJson;
            if (str == null) {
                str = "";
            }
            bVar.d(key_policy_operate_json, str);
            return v.f6774a;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.PolicyManager$saveReadClipboardStatus$1", f = "PolicyManager.kt", l = {333}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$saveReadClipboardStatus$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00351 extends i implements p {
        final /* synthetic */ Context $context;
        int label;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        @e(c = "com.stepos.policy.sdk.PolicyManager$saveReadClipboardStatus$1$1", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.stepos.policy.sdk.PolicyManager$saveReadClipboardStatus$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00111 extends i implements p {
            /* synthetic */ Object L$0;
            int label;

            public C00111(c cVar) {
                super(2, cVar);
            }

            @Override // pb.a
            public final c create(Object obj, c cVar) {
                C00111 c00111 = new C00111(cVar);
                c00111.L$0 = obj;
                return c00111;
            }

            @Override // xb.p
            public final Object invoke(y3.b bVar, c cVar) {
                return ((C00111) create(bVar, cVar)).invokeSuspend(v.f6774a);
            }

            @Override // pb.a
            public final Object invokeSuspend(Object obj) {
                ob.a aVar = ob.a.f9351c;
                if (this.label != 0) {
                    f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                ((y3.b) this.L$0).d(PolicyManagerKt.getKEY_READ_CLIPBOARD_STATUS(), new Integer(ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_AGREE));
                return v.f6774a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00351(Context context, c cVar) {
            super(2, cVar);
            this.$context = context;
        }

        @Override // pb.a
        public final c create(Object obj, c cVar) {
            return new C00351(this.$context, cVar);
        }

        @Override // xb.p
        public final Object invoke(t tVar, c cVar) {
            return ((C00351) create(tVar, cVar)).invokeSuspend(v.f6774a);
        }

        @Override // pb.a
        public final Object invokeSuspend(Object obj) {
            ob.a aVar = ob.a.f9351c;
            int i = this.label;
            try {
                if (i == 0) {
                    id.c.I(obj);
                    v3.f policySdkDataStore = PolicyManagerKt.getPolicySdkDataStore(this.$context);
                    C00111 c00111 = new C00111(null);
                    this.label = 1;
                    if (m0.h(policySdkDataStore, c00111, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        f.e("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    id.c.I(obj);
                }
            } catch (Exception e10) {
                PolicySdkLogUtils.Companion.e("savePolicyCategoryVersion", "error =" + e10 + ' ');
            }
            return v.f6774a;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.PolicyManager$uploadPolicyOperateRecord$1", f = "PolicyManager.kt", l = {447}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$uploadPolicyOperateRecord$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00461 extends i implements p {
        final /* synthetic */ String $appId;
        final /* synthetic */ String $appSecret;
        final /* synthetic */ l $callBackPolicyResult;
        final /* synthetic */ PolicyRecordRequest $policyRecordRequest;
        final /* synthetic */ String $versionName;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00461(String str, String str2, PolicyRecordRequest policyRecordRequest, l lVar, String str3, c cVar) {
            super(2, cVar);
            this.$appId = str;
            this.$appSecret = str2;
            this.$policyRecordRequest = policyRecordRequest;
            this.$callBackPolicyResult = lVar;
            this.$versionName = str3;
        }

        @Override // pb.a
        public final c create(Object obj, c cVar) {
            return new C00461(this.$appId, this.$appSecret, this.$policyRecordRequest, this.$callBackPolicyResult, this.$versionName, cVar);
        }

        @Override // xb.p
        public final Object invoke(t tVar, c cVar) {
            return ((C00461) create(tVar, cVar)).invokeSuspend(v.f6774a);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0087 A[Catch: Exception -> 0x001f, TryCatch #0 {Exception -> 0x001f, blocks: (B:6:0x0019, B:17:0x006a, B:19:0x0087, B:21:0x00ba, B:23:0x00c2, B:25:0x00d0, B:24:0x00c7, B:26:0x00d6), top: B:33:0x0019 }] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00d6 A[Catch: Exception -> 0x001f, TRY_LEAVE, TryCatch #0 {Exception -> 0x001f, blocks: (B:6:0x0019, B:17:0x006a, B:19:0x0087, B:21:0x00ba, B:23:0x00c2, B:25:0x00d0, B:24:0x00c7, B:26:0x00d6), top: B:33:0x0019 }] */
        @Override // pb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 276
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C00461.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.PolicyManager$uploadRecordToCleanServiceData$1", f = "PolicyManager.kt", l = {1220}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$uploadRecordToCleanServiceData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00481 extends i implements p {
        final /* synthetic */ String $appId;
        final /* synthetic */ String $appSecret;
        final /* synthetic */ l $callBackPolicyResult;
        final /* synthetic */ String[] $categoryList;
        final /* synthetic */ Context $context;
        final /* synthetic */ ArrayList<DeleteInfoBean> $deleteInfoBeanList;
        final /* synthetic */ String $operationType;
        final /* synthetic */ String $serviceName;
        final /* synthetic */ String $userId;
        final /* synthetic */ String $validateCode;
        final /* synthetic */ String $verifyType;
        final /* synthetic */ String $versionName;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00481(Context context, String[] strArr, String str, String str2, String str3, String str4, String str5, ArrayList<DeleteInfoBean> arrayList, String str6, String str7, String str8, l lVar, c cVar) {
            super(2, cVar);
            this.$context = context;
            this.$categoryList = strArr;
            this.$userId = str;
            this.$operationType = str2;
            this.$verifyType = str3;
            this.$serviceName = str4;
            this.$validateCode = str5;
            this.$deleteInfoBeanList = arrayList;
            this.$appId = str6;
            this.$appSecret = str7;
            this.$versionName = str8;
            this.$callBackPolicyResult = lVar;
        }

        @Override // pb.a
        public final c create(Object obj, c cVar) {
            return new C00481(this.$context, this.$categoryList, this.$userId, this.$operationType, this.$verifyType, this.$serviceName, this.$validateCode, this.$deleteInfoBeanList, this.$appId, this.$appSecret, this.$versionName, this.$callBackPolicyResult, cVar);
        }

        @Override // xb.p
        public final Object invoke(t tVar, c cVar) {
            return ((C00481) create(tVar, cVar)).invokeSuspend(v.f6774a);
        }

        @Override // pb.a
        public final Object invokeSuspend(Object obj) {
            PolicyRecordRequest policyRecordRequest;
            PolicyRecordRequest policyRecordRequest2;
            ArrayList<DeleteInfoBean> arrayList;
            ob.a aVar = ob.a.f9351c;
            int i = this.label;
            if (i == 0) {
                id.c.I(obj);
                PolicyRecordRequest policyRecordRequestCreateRecordRequest = PolicyManager.createRecordRequest(this.$context, this.$categoryList, this.$userId, this.$operationType);
                policyRecordRequestCreateRecordRequest.setVerify_type(this.$verifyType);
                policyRecordRequestCreateRecordRequest.setServiceName(this.$serviceName);
                policyRecordRequestCreateRecordRequest.setValidateCode(this.$validateCode);
                if (!k.a(this.$verifyType, "0") && (arrayList = this.$deleteInfoBeanList) != null && arrayList.size() > 0) {
                    policyRecordRequestCreateRecordRequest.setDeleteInfoList(this.$deleteInfoBeanList);
                }
                if (!k.a(this.$verifyType, "1") && !k.a(this.$verifyType, "3")) {
                    policyRecordRequest2 = policyRecordRequestCreateRecordRequest;
                    PolicySdkLogUtils.Companion.d("uploadRecordToCleanServiceData", "verifyType " + this.$verifyType + " | policyRecordRequest.deleteInfoList = " + policyRecordRequest2.getDeleteInfoList());
                    PolicyManager.uploadRecordByCustomRecordRequest(this.$context, this.$appId, this.$appSecret, this.$versionName, policyRecordRequest2, this.$callBackPolicyResult);
                    return v.f6774a;
                }
                PolicyManager policyManager = PolicyManager.INSTANCE;
                Context context = this.$context;
                y3.e key_common_delete_info_json = PolicyManagerKt.getKEY_COMMON_DELETE_INFO_JSON();
                this.L$0 = policyRecordRequestCreateRecordRequest;
                this.label = 1;
                Object dataStoreString = policyManager.getDataStoreString(context, key_common_delete_info_json, this);
                if (dataStoreString == aVar) {
                    return aVar;
                }
                policyRecordRequest = policyRecordRequestCreateRecordRequest;
                obj = dataStoreString;
            } else {
                if (i != 1) {
                    f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                policyRecordRequest = (PolicyRecordRequest) this.L$0;
                id.c.I(obj);
            }
            String str = (String) obj;
            if (str != null && !TextUtils.isEmpty(str)) {
                ArrayList<DeleteInfoBean> deleteInfoBeanByGson = PolicySdkToolsUtils.Companion.getDeleteInfoBeanByGson(str);
                PolicySdkLogUtils.Companion.d("uploadRecordToCleanServiceData", "commonDeleteInfoList = " + deleteInfoBeanByGson);
                policyRecordRequest.setDeleteInfoList(new ArrayList(kb.l.F0(policyRecordRequest.getDeleteInfoList(), deleteInfoBeanByGson)));
            }
            policyRecordRequest2 = policyRecordRequest;
            PolicySdkLogUtils.Companion.d("uploadRecordToCleanServiceData", "verifyType " + this.$verifyType + " | policyRecordRequest.deleteInfoList = " + policyRecordRequest2.getDeleteInfoList());
            PolicyManager.uploadRecordByCustomRecordRequest(this.$context, this.$appId, this.$appSecret, this.$versionName, policyRecordRequest2, this.$callBackPolicyResult);
            return v.f6774a;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.PolicyManager$uploadRecordWithoutSecureService$1", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$uploadRecordWithoutSecureService$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00491 extends i implements p {
        final /* synthetic */ String $appId;
        final /* synthetic */ String $appSecret;
        final /* synthetic */ l $callBackPolicyResult;
        final /* synthetic */ String[] $categoryList;
        final /* synthetic */ Context $context;
        final /* synthetic */ ArrayList<DeleteInfoBean> $deleteInfoBeanList;
        final /* synthetic */ String $operationType;
        final /* synthetic */ String $serviceName;
        final /* synthetic */ String $userId;
        final /* synthetic */ String $validateCode;
        final /* synthetic */ String $verifyType;
        final /* synthetic */ String $versionName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00491(Context context, String[] strArr, String str, String str2, String str3, String str4, String str5, ArrayList<DeleteInfoBean> arrayList, String str6, String str7, String str8, l lVar, c cVar) {
            super(2, cVar);
            this.$context = context;
            this.$categoryList = strArr;
            this.$userId = str;
            this.$operationType = str2;
            this.$verifyType = str3;
            this.$serviceName = str4;
            this.$validateCode = str5;
            this.$deleteInfoBeanList = arrayList;
            this.$appId = str6;
            this.$appSecret = str7;
            this.$versionName = str8;
            this.$callBackPolicyResult = lVar;
        }

        @Override // pb.a
        public final c create(Object obj, c cVar) {
            return new C00491(this.$context, this.$categoryList, this.$userId, this.$operationType, this.$verifyType, this.$serviceName, this.$validateCode, this.$deleteInfoBeanList, this.$appId, this.$appSecret, this.$versionName, this.$callBackPolicyResult, cVar);
        }

        @Override // xb.p
        public final Object invoke(t tVar, c cVar) {
            return ((C00491) create(tVar, cVar)).invokeSuspend(v.f6774a);
        }

        @Override // pb.a
        public final Object invokeSuspend(Object obj) {
            ArrayList<DeleteInfoBean> arrayList;
            ob.a aVar = ob.a.f9351c;
            if (this.label != 0) {
                f.e("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            id.c.I(obj);
            PolicyRecordRequest policyRecordRequestCreateRecordRequest = PolicyManager.createRecordRequest(this.$context, this.$categoryList, this.$userId, this.$operationType);
            policyRecordRequestCreateRecordRequest.setVerify_type(this.$verifyType);
            policyRecordRequestCreateRecordRequest.setServiceName(this.$serviceName);
            policyRecordRequestCreateRecordRequest.setValidateCode(this.$validateCode);
            if (!k.a(this.$verifyType, "0") && (arrayList = this.$deleteInfoBeanList) != null && arrayList.size() > 0) {
                policyRecordRequestCreateRecordRequest.setDeleteInfoList(this.$deleteInfoBeanList);
            }
            PolicySdkLogUtils.Companion.d("uploadRecordToCleanServiceData", "verifyType " + this.$verifyType + " | policyRecordRequest.deleteInfoList = " + policyRecordRequestCreateRecordRequest.getDeleteInfoList());
            PolicyManager.uploadRecordByCustomRecordRequest(this.$context, this.$appId, this.$appSecret, this.$versionName, policyRecordRequestCreateRecordRequest, this.$callBackPolicyResult);
            return v.f6774a;
        }
    }

    static {
        k1 k1VarC = w.c();
        rc.e eVar = e0.f7430a;
        lifecycleScope = new pc.c(ac.a.N(k1VarC, n.f9978a));
        mAppId = "";
        mAppSecret = "";
        mAppVersionName = "";
        customPolicyCSSFileName = "";
        localAssetsCategoryPathMap = new HashMap<>();
        scope = w.a(ac.a.N(w.c(), d.f10552f));
        String channelToBrand = PolicySdkToolsUtils.Companion.getChannelToBrand();
        companyCode = channelToBrand;
        brand = channelToBrand;
        model = "";
        osVersion = "";
        exceptionHandler = new PolicyManager$special$$inlined$CoroutineExceptionHandler$1(q.f7473c);
    }

    private PolicyManager() {
    }

    private final boolean assetExists(Context context, String str) throws IOException {
        try {
            context.getAssets().open(str).close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static final void autoUploadRecord(Context context, String str, String str2, String str3, String[] strArr, String str4, String str5) {
        context.getClass();
        str.getClass();
        str2.getClass();
        str3.getClass();
        strArr.getClass();
        str5.getClass();
        u uVar = new u();
        uVar.f16098c = createRecordRequest(context, strArr, str4, str5);
        if (PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            uploadPolicyOperateRecord(str, str2, str3, (PolicyRecordRequest) uVar.f16098c, new AnonymousClass1(uVar, context));
            return;
        }
        w.u(r0.f7476c, exceptionHandler, null, new AnonymousClass2(uVar, context, null), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0049 -> B:22:0x004c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object awaitSyncLocalFileFinished(nb.c r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.stepos.policy.sdk.PolicyManager.C00131
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.policy.sdk.PolicyManager$awaitSyncLocalFileFinished$1 r0 = (com.stepos.policy.sdk.PolicyManager.C00131) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.policy.sdk.PolicyManager$awaitSyncLocalFileFinished$1 r0 = new com.stepos.policy.sdk.PolicyManager$awaitSyncLocalFileFinished$1
            r0.<init>(r10)
        L18:
            java.lang.Object r9 = r0.result
            ob.a r10 = ob.a.f9351c
            int r1 = r0.label
            r2 = 200(0xc8, double:9.9E-322)
            r4 = 1
            if (r1 == 0) goto L32
            if (r1 != r4) goto L2b
            long r5 = r0.J$0
            id.c.I(r9)
            goto L4c
        L2b:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r9)
            r9 = 0
            return r9
        L32:
            id.c.I(r9)
            r5 = 0
        L37:
            boolean r9 = com.stepos.policy.sdk.PolicyManager.syncLocalFileFinished
            if (r9 != 0) goto L4e
            r7 = 10000(0x2710, double:4.9407E-320)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 >= 0) goto L4e
            r0.J$0 = r5
            r0.label = r4
            java.lang.Object r9 = kc.w.g(r2, r0)
            if (r9 != r10) goto L4c
            return r10
        L4c:
            long r5 = r5 + r2
            goto L37
        L4e:
            jb.v r9 = jb.v.f6774a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.awaitSyncLocalFileFinished(nb.c):java.lang.Object");
    }

    public static final void checkNewestPolicy(Context context, boolean z10, String str, String str2, String str3, String str4, String str5, l lVar) {
        context.getClass();
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        lVar.getClass();
        w.u(r0.f7476c, exceptionHandler, null, new C00141(context, str4, str3, z10, str, str2, str5, lVar, null), 2);
    }

    public static final String copyPolicyFile(Context context, String str, String str2) {
        context.getClass();
        str.getClass();
        str2.getClass();
        PolicySdkFileUtils.Companion companion = PolicySdkFileUtils.Companion;
        PolicyNewestPathResultBean policyNewestPathResultBeanIsNewestPolicyFileIsExists = companion.isNewestPolicyFileIsExists(context, str);
        PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
        companion2.d("copyPolicyFile", "policyNewestPathResultBean.isExists = " + policyNewestPathResultBeanIsNewestPolicyFileIsExists.isExists());
        String strCopyPolicyFile = policyNewestPathResultBeanIsNewestPolicyFileIsExists.isExists() ? companion.copyPolicyFile(policyNewestPathResultBeanIsNewestPolicyFileIsExists.getNewestPolicyPath(), str2) : "";
        companion2.d("copyPolicyFile", "successPath = " + strCopyPolicyFile);
        return strCopyPolicyFile;
    }

    private final h0 createReGrantDialogBuilder(Context context, boolean z10, boolean z11, String str, String str2, String str3, f0 f0Var) {
        h0 h0Var = new h0(context);
        h0Var.f12331m = str2;
        h0Var.f12322c = str;
        h0Var.f12328j = f0Var;
        h0Var.f12330l = z11;
        a aVar = new a(0);
        aVar.f2777f = context;
        aVar.f2778g = z10;
        aVar.f2779h = str2;
        aVar.i = str3;
        VarHandle.storeStoreFence();
        h0Var.f12325f = aVar;
        return h0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createReGrantDialogBuilder$lambda$6(Context context, boolean z10, String str, String str2, View view) {
        context.getClass();
        str.getClass();
        str2.getClass();
        openPolicyMethod(context, z10, str, str2);
    }

    public static final PolicyRecordRequest createRecordRequest(Context context, String[] strArr, String str, String str2) {
        context.getClass();
        strArr.getClass();
        str2.getClass();
        String string = Settings.System.getString(context.getContentResolver(), "android_id");
        PolicyRecordRequest policyRecordRequest = new PolicyRecordRequest();
        string.getClass();
        policyRecordRequest.setBusinessId(string);
        policyRecordRequest.setType("phone");
        if (str != null) {
            policyRecordRequest.setUseId(str);
        }
        ArrayList arrayList = new ArrayList();
        for (String str3 : strArr) {
            PolicyRecordBaseInfo policyRecordBaseInfo = new PolicyRecordBaseInfo(null, null, null, 7, null);
            policyRecordBaseInfo.setVersion(PolicySdkFileUtils.Companion.getPolicyVersion(context, str3));
            policyRecordBaseInfo.setCategory(str3);
            arrayList.add(policyRecordBaseInfo);
        }
        policyRecordRequest.setBaseInfoList(arrayList);
        policyRecordRequest.setOperation(str2);
        return policyRecordRequest;
    }

    public static final void encryptCustomDeleteInfoListBySecure(Context context, ArrayList<CustomDeleteInfoBean> arrayList, l lVar) {
        context.getClass();
        arrayList.getClass();
        lVar.getClass();
        WithdrawalManager.INSTANCE.encryptCustomDeleteInfoListBySecure(context, arrayList, new C00151(new ArrayList(), arrayList, lVar));
    }

    public static final ArrayList<DeleteInfoBean> encryptDeleteInfoWithoutSecureService(Context context, ArrayList<DeleteInfoEncryptMultiBean> arrayList) {
        context.getClass();
        arrayList.getClass();
        return WithdrawalManagerWithoutSecureService.INSTANCE.getEncryptByDeleteInfoList(context, arrayList);
    }

    public static final void encryptMultiDeleteListBySecure(Context context, ArrayList<DeleteInfoEncryptMultiBean> arrayList, l lVar) {
        context.getClass();
        arrayList.getClass();
        lVar.getClass();
        WithdrawalManager.INSTANCE.encryptMultiCustomDeleteInfoListBySecure(context, arrayList, new C00161(new ArrayList(), arrayList, lVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PolicyNewestPathResultBean findNewestPolicyFile(Context context, String str) {
        Context contextResolvePolicyContext = resolvePolicyContext(context);
        PolicySdkFileUtils.Companion companion = PolicySdkFileUtils.Companion;
        PolicyNewestPathResultBean policyNewestPathResultBeanIsNewestPolicyFileIsExists = companion.isNewestPolicyFileIsExists(contextResolvePolicyContext, str);
        if (!policyNewestPathResultBeanIsNewestPolicyFileIsExists.isExists()) {
            Context applicationContext = isDeviceProtectedStorageContext(contextResolvePolicyContext) ? context.getApplicationContext() : context.getApplicationContext().createDeviceProtectedStorageContext();
            applicationContext.getClass();
            PolicyNewestPathResultBean policyNewestPathResultBeanIsNewestPolicyFileIsExists2 = companion.isNewestPolicyFileIsExists(applicationContext, str);
            if (policyNewestPathResultBeanIsNewestPolicyFileIsExists2.isExists()) {
                PolicySdkLogUtils.Companion.d("PolicyManager", "findNewestPolicyFile fallback hit: " + policyNewestPathResultBeanIsNewestPolicyFileIsExists2.getNewestPolicyPath());
                return policyNewestPathResultBeanIsNewestPolicyFileIsExists2;
            }
        }
        return policyNewestPathResultBeanIsNewestPolicyFileIsExists;
    }

    public static final void getCommonDeleteInfoList(Context context, String str, int i) {
        context.getClass();
        str.getClass();
        WithdrawalManager.INSTANCE.getCommonDeleteInfoListBySecure(context, str, i, new C00181((Context) new WeakReference(context.getApplicationContext()).get()));
    }

    private final String getLocalCategoryMd5(Context context, String str) {
        return (String) w.y(nb.h.f8811c, new C00191(context, str, null));
    }

    public static final void getPolicyByVersion(String str, String str2, String str3, Long l2, String str4, l lVar) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        lVar.getClass();
        w.u(r0.f7476c, exceptionHandler, null, new C00201(l2, str4, str, str2, lVar, str3, null), 2);
    }

    public static final void getPolicyData(String str, String str2, String str3, String str4, Long l2, String str5, l lVar) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        lVar.getClass();
        w.u(r0.f7476c, exceptionHandler, null, new C00211(str4, l2, str5, str, str2, lVar, str3, null), 2);
    }

    public static final void getPolicyHistoryList(String str, String str2, String str3, String str4, long j10, String str5, l lVar) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        lVar.getClass();
        w.u(r0.f7476c, exceptionHandler, null, new C00221(str4, str5, str, str2, lVar, str3, j10, null), 2);
    }

    public static final String getPolicyHistoryUrl(String str, String str2, long j10, String str3) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        String str4 = "https://policy-h5.stepos.com/?appId=" + str + "&category=" + str2 + "&version=" + j10 + "&language=" + str3;
        PolicySdkLogUtils.Companion.d("getPolicyHistoryUrl", str4);
        return str4;
    }

    public static final PolicySdkResultBean getPolicyNewestPath(Context context, String str) {
        context.getClass();
        str.getClass();
        PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
        PolicyNewestPathResultBean policyNewestPathResultBeanFindNewestPolicyFile = INSTANCE.findNewestPolicyFile(context, str);
        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
        companion.d("getNewestPolicyPath", "getNewestPolicyPath");
        companion.d("getNewestPolicyPath", " policyNewestPathResultBean.isExists " + policyNewestPathResultBeanFindNewestPolicyFile + ".isExists");
        if (!policyNewestPathResultBeanFindNewestPolicyFile.isExists()) {
            policySdkResultBean.setCode(-1);
            return policySdkResultBean;
        }
        PolicySdkFileUtils.Companion companion2 = PolicySdkFileUtils.Companion;
        policySdkResultBean.setPolicyNewestPath(companion2.renameFileNameByMd5(policyNewestPathResultBeanFindNewestPolicyFile.getNewestPolicyPath()));
        companion.d("getNewestPolicyPath", " policyNewestPath result= " + policySdkResultBean.getPolicyNewestPath());
        try {
            String name = new File(policySdkResultBean.getPolicyNewestPath()).getName();
            name.getClass();
            PolicyFileDataResultBean policyDataFromFileName = companion2.getPolicyDataFromFileName(name);
            Long lValueOf = policyDataFromFileName != null ? Long.valueOf(policyDataFromFileName.getVersion()) : null;
            policySdkResultBean.setCode(0);
            if (lValueOf != null) {
                policySdkResultBean.setPolicyNewestVersion(lValueOf.longValue());
            }
            return policySdkResultBean;
        } catch (Exception unused) {
            policySdkResultBean.setCode(-1);
            return policySdkResultBean;
        }
    }

    public static final PolicySdkResultBean getPolicyNewestPathByCustom(Context context, String str) {
        context.getClass();
        str.getClass();
        PolicySdkLogUtils.Companion.d("getPolicyNewestPathByCustom", " initSDKByDeviceProtectedStorageContext= " + initSDKByDeviceProtectedStorageContext);
        return getPolicyNewestPath(context, str);
    }

    public static final void getPolicyServiceConfig(Context context, String str, String str2, String str3, String str4, l lVar) {
        context.getClass();
        str.getClass();
        str2.getClass();
        str3.getClass();
        lVar.getClass();
        w.u(r0.f7476c, exceptionHandler, null, new C00241(str4, str, str2, lVar, str3, context, null), 2);
    }

    public static final void getPrivateDeleteInfoList(Context context, String str, String str2, int i, l lVar) {
        context.getClass();
        str.getClass();
        str2.getClass();
        lVar.getClass();
        WithdrawalManager.INSTANCE.getPrivateDeleteInfoListBySecure(context, str, str2, i, new C00251(lVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0142 A[Catch: Exception -> 0x015a, TryCatch #0 {Exception -> 0x015a, blocks: (B:47:0x012a, B:49:0x0142, B:51:0x014d, B:53:0x0152), top: B:57:0x012a }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0152 A[Catch: Exception -> 0x015a, TRY_LEAVE, TryCatch #0 {Exception -> 0x015a, blocks: (B:47:0x012a, B:49:0x0142, B:51:0x014d, B:53:0x0152), top: B:57:0x012a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object initPolicyNewestPath(android.content.Context r10, java.lang.String r11, java.lang.String r12, nb.c r13) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.initPolicyNewestPath(android.content.Context, java.lang.String, java.lang.String, nb.c):java.lang.Object");
    }

    public static final void initSDK(Context context, String str, String str2, String str3, HashMap<String, String> map) {
        context.getClass();
        str.getClass();
        str2.getClass();
        str3.getClass();
        map.getClass();
        PolicySdkRetrofitCreator.INSTANCE.init(context);
        mAppId = str;
        mAppSecret = str2;
        mAppVersionName = str3;
        PolicySdkToolsUtils.Companion companion = PolicySdkToolsUtils.Companion;
        model = companion.getSystemModel(context);
        osVersion = companion.getSystemVersion(context);
        Context contextResolvePolicyContext = resolvePolicyContext(context);
        localAssetsCategoryPathMap = map;
        PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
        StringBuilder sb2 = new StringBuilder("policyCategoryMap=");
        sb2.append(map);
        sb2.append(", policyContext=");
        File dataDir = contextResolvePolicyContext.getDataDir();
        sb2.append(dataDir != null ? dataDir.getPath() : null);
        companion2.d("initSDK", sb2.toString());
        w.u(r0.f7476c, exceptionHandler, null, new C00281(contextResolvePolicyContext, map, null), 2);
    }

    private final boolean isDeviceProtectedStorageContext(Context context) {
        String path;
        File dataDir = context.getDataDir();
        return (dataDir == null || (path = dataDir.getPath()) == null || !hc.h.X(path, "user_de", false)) ? false : true;
    }

    public static final boolean isSupportSecureService(Context context, int i) {
        context.getClass();
        return INSTANCE.getSecureServiceVersionCode(context) >= i;
    }

    public static final boolean isSupportSecureService31(Context context) {
        context.getClass();
        try {
            int secureServiceVersionCode = INSTANCE.getSecureServiceVersionCode(context);
            PolicySdkLogUtils.Companion.d("PolicyManager", "com.stepos.secureservice versionCode : " + secureServiceVersionCode + ' ');
            return secureServiceVersionCode >= 11000031;
        } catch (Exception e10) {
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            StringBuilder sb2 = new StringBuilder("exception : ");
            e10.getMessage();
            sb2.append(e10);
            companion.e("PolicyManager", sb2.toString());
            return false;
        }
    }

    @SuppressLint({"SuspiciousIndentation"})
    public static final PolicySdkResultBean openPolicyDataByBrowser(Context context, String str, String str2) {
        context.getClass();
        str.getClass();
        str2.getClass();
        PolicySdkResultBean policyNewestPathByCustom = getPolicyNewestPathByCustom(context, str);
        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
        companion.d("PolicyManager", "openPolicyDataByBrowser " + policyNewestPathByCustom.getPolicyNewestPath() + '}');
        PolicyCheckLogUtils.Companion companion2 = PolicyCheckLogUtils.Companion;
        StringBuilder sbO = androidx.activity.b.o(">>> START category=", str, " method=BROWSER syncDone=");
        sbO.append(syncLocalFileFinished);
        companion2.i("openPolicy", sbO.toString());
        if (policyNewestPathByCustom.getCode() == 0) {
            String policyNewestPath = policyNewestPathByCustom.getPolicyNewestPath();
            companion.d("PolicyManager", "openPolicyDataByBrowser policyNewestPath path = " + policyNewestPath + ' ');
            Uri uriForFile = androidx.core.content.c.getUriForFile(context, context.getPackageName() + ".PolicySdk.FileProvider", new File(policyNewestPath));
            if (uriForFile != null) {
                PolicySdkToolsUtils.Companion.startBrowser(context, uriForFile);
            }
            companion2.i("openPolicy", androidx.activity.b.j(">>> END category=", str, " code=SUCCESS 已唤起浏览器 path=", policyNewestPath));
            return policyNewestPathByCustom;
        }
        companion2.e("openPolicy", ">>> END category=" + str + " code=FAILED 未打开页面(无反应)");
        StringBuilder sbO2 = androidx.activity.b.o("原因: 本地无 ", str, " 缓存文件; syncDone=");
        sbO2.append(syncLocalFileFinished);
        sbO2.append("; code=");
        sbO2.append(policyNewestPathByCustom.getCode());
        companion2.e("openPolicy", sbO2.toString());
        companion2.e("openPolicy", "建议: 1)确认 assets 有对应 " + str + "_x.html 且 initSDK 已 put(\"" + str + "\",...); 2)syncDone=false 时查启动自检(selfCheck)是否有 ⚠️ 缺文件导致同步中断; 3)确认打开与登记的 category 完全一致");
        return policyNewestPathByCustom;
    }

    @SuppressLint({"SuspiciousIndentation"})
    public static final PolicySdkResultBean openPolicyDataByWebView(Context context, String str, String str2) {
        context.getClass();
        str.getClass();
        str2.getClass();
        PolicySdkResultBean policyNewestPathByCustom = getPolicyNewestPathByCustom(context, str);
        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
        companion.d("PolicyManager", "openPolicyDataByWebView " + policyNewestPathByCustom.getPolicyNewestPath() + '}');
        PolicyCheckLogUtils.Companion companion2 = PolicyCheckLogUtils.Companion;
        StringBuilder sbO = androidx.activity.b.o(">>> START category=", str, " method=IN_APP syncDone=");
        sbO.append(syncLocalFileFinished);
        companion2.i("openPolicy", sbO.toString());
        if (policyNewestPathByCustom.getCode() != 0) {
            companion2.e("openPolicy", ">>> END category=" + str + " code=FAILED 未打开页面(无反应)");
            StringBuilder sbO2 = androidx.activity.b.o("原因: 本地无 ", str, " 缓存文件; syncDone=");
            sbO2.append(syncLocalFileFinished);
            sbO2.append("; code=");
            sbO2.append(policyNewestPathByCustom.getCode());
            companion2.e("openPolicy", sbO2.toString());
            companion2.e("openPolicy", "建议: 1)确认 assets 有对应 " + str + "_x.html 且 initSDK 已 put(\"" + str + "\",...); 2)syncDone=false 时查启动自检(selfCheck)是否有 ⚠️ 缺文件导致同步中断; 3)确认打开与登记的 category 完全一致");
            return policyNewestPathByCustom;
        }
        String policyNewestPath = policyNewestPathByCustom.getPolicyNewestPath();
        Uri uriForFile = androidx.core.content.c.getUriForFile(context, context.getPackageName() + ".PolicySdk.FileProvider", new File(policyNewestPath));
        companion.d("PolicyManager", "save sucessful path = " + policyNewestPath + ' ');
        String string = uriForFile.toString();
        string.getClass();
        if (!syncLocalFileFinished && localAssetsCategoryPathMap.containsKey(str) && localAssetsCategoryPathMap.get(str) != null && !"".equals(localAssetsCategoryPathMap.get(str))) {
            string = String.valueOf(localAssetsCategoryPathMap.get(str));
        }
        companion.d("openPolicyDataByWebView", "initSDK syncLocalFileFinished " + syncLocalFileFinished + " |  policyPath = " + string);
        PolicyHtmlViewerActivity.Companion.openPolicy(context, string, str2, null);
        companion2.i("openPolicy", androidx.activity.b.j(">>> END category=", str, " code=SUCCESS 已打开页面 path=", string));
        return policyNewestPathByCustom;
    }

    public static final PolicySdkResultBean openPolicyMethod(Context context, boolean z10, String str, String str2) {
        context.getClass();
        str.getClass();
        str2.getClass();
        return z10 ? openPolicyDataByWebView(context, str2, str) : openPolicyDataByBrowser(context, str2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reTryUploadRecord(Context context) {
        w.u(r0.f7476c, exceptionHandler, null, new C00291(context, this, null), 2);
    }

    public static final Context resolvePolicyContext(Context context) {
        context.getClass();
        if (INSTANCE.isDeviceProtectedStorageContext(context)) {
            initSDKByDeviceProtectedStorageContext = true;
            return context;
        }
        if (!initSDKByDeviceProtectedStorageContext) {
            return context;
        }
        Context contextCreateDeviceProtectedStorageContext = context.getApplicationContext().createDeviceProtectedStorageContext();
        contextCreateDeviceProtectedStorageContext.getClass();
        return contextCreateDeviceProtectedStorageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveDataStoreString(Context context, y3.e eVar, String str, c cVar) {
        PolicySdkLogUtils.Companion.d("saveDataStoreString", " " + eVar + " | dataStoreValue =" + str + ' ');
        Object objH = m0.h(PolicyManagerKt.getPolicySdkDataStore(context), new C00312(eVar, str, null), cVar);
        return objH == ob.a.f9351c ? objH : v.f6774a;
    }

    private final void saveLocalCategoryMd5(Context context, String str, String str2) {
        w.u(r0.f7476c, exceptionHandler, null, new C00321(str, str2, context, null), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object savePolicyOperate(android.content.Context r8, boolean r9, java.lang.String r10, nb.c r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.stepos.policy.sdk.PolicyManager.C00331
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.policy.sdk.PolicyManager$savePolicyOperate$1 r0 = (com.stepos.policy.sdk.PolicyManager.C00331) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.policy.sdk.PolicyManager$savePolicyOperate$1 r0 = new com.stepos.policy.sdk.PolicyManager$savePolicyOperate$1
            r0.<init>(r11)
        L18:
            java.lang.Object r7 = r0.result
            ob.a r11 = ob.a.f9351c
            int r1 = r0.label
            jb.v r2 = jb.v.f6774a
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L43
            if (r1 == r4) goto L34
            if (r1 != r3) goto L2d
            id.c.I(r7)
            goto L9b
        L2d:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r7)
            r7 = 0
            return r7
        L34:
            boolean r9 = r0.Z$0
            java.lang.Object r8 = r0.L$1
            r10 = r8
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r8 = r0.L$0
            android.content.Context r8 = (android.content.Context) r8
            id.c.I(r7)
            goto L7b
        L43:
            id.c.I(r7)
            com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r7 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r6 = "isOperateSuccess ="
            r1.<init>(r6)
            r1.append(r9)
            java.lang.String r6 = " |operateJson = "
            r1.append(r6)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            java.lang.String r6 = "savePolicyOperate"
            r7.d(r6, r1)
            v3.f r7 = com.stepos.policy.sdk.PolicyManagerKt.access$getPolicySdkDataStore(r8)
            com.stepos.policy.sdk.PolicyManager$savePolicyOperate$2 r1 = new com.stepos.policy.sdk.PolicyManager$savePolicyOperate$2
            r1.<init>(r9, r5)
            r0.L$0 = r8
            r0.L$1 = r10
            r0.Z$0 = r9
            r0.label = r4
            java.lang.Object r7 = t.m0.h(r7, r1, r0)
            if (r7 != r11) goto L7b
            goto L9a
        L7b:
            if (r9 != 0) goto L9b
            if (r10 == 0) goto L9b
            int r7 = r10.length()
            if (r7 <= 0) goto L9b
            v3.f r7 = com.stepos.policy.sdk.PolicyManagerKt.access$getPolicySdkDataStore(r8)
            com.stepos.policy.sdk.PolicyManager$savePolicyOperate$3 r8 = new com.stepos.policy.sdk.PolicyManager$savePolicyOperate$3
            r8.<init>(r10, r5)
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r7 = t.m0.h(r7, r8, r0)
            if (r7 != r11) goto L9b
        L9a:
            return r11
        L9b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.savePolicyOperate(android.content.Context, boolean, java.lang.String, nb.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selfCheckLocalAssets(Context context, HashMap<String, String> map) {
        try {
            PolicyCheckLogUtils.Companion.i("selfCheck", ">>> START categories=" + map.keySet());
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value.length() == 0) {
                    arrayList.add(key);
                    PolicyCheckLogUtils.Companion.w("selfCheck", "category=" + key + " ⚠️ localPath 为空");
                } else if (hc.h.X(value, "file:////android_asset", false)) {
                    String strS = hc.o.S(value, "file:////android_asset/", "");
                    if (assetExists(context, strS)) {
                        PolicyCheckLogUtils.Companion.i("selfCheck", "category=" + key + " asset=" + strS + " present=true");
                    } else {
                        arrayList.add(key);
                        PolicyCheckLogUtils.Companion.w("selfCheck", "category=" + key + " asset=" + strS + " present=FALSE ⚠️ 缺失会中断同步(其后 category 不再同步)且该 category 无法本地打开");
                    }
                } else {
                    arrayList.add(key);
                    PolicyCheckLogUtils.Companion.w("selfCheck", "category=" + key + " ⚠️ localPath 格式错误(需 file:////android_asset/ 四斜杠): " + value);
                }
            }
            if (arrayList.isEmpty()) {
                PolicyCheckLogUtils.Companion.i("selfCheck", ">>> END 自检通过 ok=" + map.keySet());
                return;
            }
            PolicyCheckLogUtils.Companion.w("selfCheck", ">>> END 自检发现问题 problems=" + arrayList + " 请补齐对应 assets 或从 policyCategoryMap 移除未使用的 category");
        } catch (Exception e10) {
            PolicyCheckLogUtils.Companion.e("selfCheck", "自检异常: " + e10.getMessage());
        }
    }

    public static final stepos.support.v7.app.i showCustomPolicyDialog(final Context context, boolean z10, String[] strArr, String[] strArr2, String str, CharSequence charSequence, CharSequence charSequence2, final PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        context.getClass();
        str.getClass();
        charSequence2.getClass();
        onPermissionClickListener.getClass();
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        policyPermissionDialogBuilder.setAppName(str).setOnPermissionListener(new PolicyPermissionDialogBuilder.OnPermissionClickListener() { // from class: com.stepos.policy.sdk.PolicyManager.showCustomPolicyDialog.1
            @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
            public void onPermissionClick(DialogInterface dialogInterface, boolean z11, boolean z12) {
                if (z12) {
                    SocketHookUtil.recoveryPlatform();
                    ReadClipboardUtils.setAgreeReadClipBoard(ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_AGREE);
                    PolicyManager policyManager = PolicyManager.INSTANCE;
                    policyManager.saveReadClipboardStatus(context);
                    policyManager.saveAgreeStatus(context, 1);
                }
                onPermissionClickListener.onPermissionClick(dialogInterface, z11, z12);
            }
        }).setSecondaryConfirmation(z10).setCustomTerms(charSequence2);
        if (charSequence != null && !TextUtils.isEmpty(charSequence)) {
            policyPermissionDialogBuilder.setReminder(charSequence);
        }
        if (strArr != null && strArr2 != null) {
            policyPermissionDialogBuilder.setPermission(strArr, strArr2);
        }
        return policyPermissionDialogBuilder.create();
    }

    public static final stepos.support.v7.app.i showCustomPolicyDialogAndUploadRecord(final Context context, boolean z10, String[] strArr, String[] strArr2, String str, CharSequence charSequence, CharSequence charSequence2, final String str2, final String str3, final String str4, final String[] strArr3, final String str5, final PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        context.getClass();
        str.getClass();
        charSequence2.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        strArr3.getClass();
        onPermissionClickListener.getClass();
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        policyPermissionDialogBuilder.setAppName(str).setOnPermissionListener(new PolicyPermissionDialogBuilder.OnPermissionClickListener() { // from class: com.stepos.policy.sdk.PolicyManager.showCustomPolicyDialogAndUploadRecord.1
            @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
            public void onPermissionClick(DialogInterface dialogInterface, boolean z11, boolean z12) {
                String str6 = z12 ? "2" : "0";
                if (z12) {
                    SocketHookUtil.recoveryPlatform();
                    ReadClipboardUtils.setAgreeReadClipBoard(ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_AGREE);
                    PolicyManager policyManager = PolicyManager.INSTANCE;
                    policyManager.saveReadClipboardStatus(context);
                    policyManager.saveAgreeStatus(context, 1);
                    PolicyManager.autoUploadRecord(context, str2, str3, str4, strArr3, str5, str6);
                }
                onPermissionClickListener.onPermissionClick(dialogInterface, z11, z12);
            }
        }).setSecondaryConfirmation(z10).setCustomTerms(charSequence2);
        if (charSequence != null && !TextUtils.isEmpty(charSequence)) {
            policyPermissionDialogBuilder.setReminder(charSequence);
        }
        if (strArr != null && strArr2 != null) {
            policyPermissionDialogBuilder.setPermission(strArr, strArr2);
        }
        return policyPermissionDialogBuilder.create();
    }

    public static final stepos.support.v7.app.i showCustomPolicyThreeButtonDialogAndUploadRecord(final Context context, boolean z10, String[] strArr, String[] strArr2, String str, CharSequence charSequence, CharSequence charSequence2, final String str2, final String str3, final String str4, final String[] strArr3, final String str5, final PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener, final f0 f0Var) {
        context.getClass();
        str.getClass();
        charSequence2.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        strArr3.getClass();
        onPermissionClickListener.getClass();
        f0Var.getClass();
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        policyPermissionDialogBuilder.setDark(PolicyHtmlDisplayAdapter.isDarkMode(context));
        policyPermissionDialogBuilder.setAppName(str).setOnPermissionListener(new PolicyPermissionDialogBuilder.OnPermissionClickListener() { // from class: com.stepos.policy.sdk.PolicyManager.showCustomPolicyThreeButtonDialogAndUploadRecord.1
        }).setSecondaryConfirmation(z10).setCustomTerms(charSequence2);
        if (charSequence != null && !TextUtils.isEmpty(charSequence)) {
            policyPermissionDialogBuilder.setReminder(charSequence);
        }
        if (strArr != null && strArr2 != null) {
            policyPermissionDialogBuilder.setPermission(strArr, strArr2);
        }
        return policyPermissionDialogBuilder.createThreeButton(new PolicyPermissionDialogBuilder.OnThreeButtonClickListener() { // from class: com.stepos.policy.sdk.PolicyManager.showCustomPolicyThreeButtonDialogAndUploadRecord.2
            @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnThreeButtonClickListener
            public void onBasicOnlyClick(DialogInterface dialogInterface, boolean z11) {
                SocketHookUtil.recoveryPlatform();
                ReadClipboardUtils.setAgreeReadClipBoard(ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_AGREE);
                PolicyManager policyManager = PolicyManager.INSTANCE;
                policyManager.saveReadClipboardStatus(context);
                policyManager.saveAgreeStatus(context, 1);
                PolicyManager.autoUploadRecord(context, str2, str3, str4, strArr3, str5, "1");
                f0Var.onPermissionClick(dialogInterface, z11, true);
            }

            @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnThreeButtonClickListener
            public void onFullAgreeClick(DialogInterface dialogInterface, boolean z11, Map<String, Boolean> map) {
                SocketHookUtil.recoveryPlatform();
                ReadClipboardUtils.setAgreeReadClipBoard(ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_AGREE);
                PolicyManager policyManager = PolicyManager.INSTANCE;
                policyManager.saveReadClipboardStatus(context);
                policyManager.saveAgreeStatus(context, 1);
                PolicyManager.autoUploadRecord(context, str2, str3, str4, strArr3, str5, "2");
                onPermissionClickListener.onPermissionClick(dialogInterface, z11, true);
            }

            @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnThreeButtonClickListener
            public void onRejectClick(DialogInterface dialogInterface, boolean z11) {
                f0Var.onPermissionClick(dialogInterface, z11, false);
            }
        });
    }

    public static final h0 showDialogByCustomThemeViewBuilder(Context context, int i, String str, CharSequence charSequence, String str2, String str3, f0 f0Var) {
        context.getClass();
        str.getClass();
        charSequence.getClass();
        str2.getClass();
        str3.getClass();
        f0Var.getClass();
        h0 h0Var = new h0(context);
        h0Var.f12322c = str;
        h0Var.f12328j = f0Var;
        h0Var.f12329k = charSequence;
        h0Var.f12333o = str2;
        h0Var.f12334p = str3;
        return h0Var;
    }

    public static final stepos.support.v7.app.i showDialogByCustomView(Context context, String str, CharSequence charSequence, String str2, String str3, f0 f0Var) {
        context.getClass();
        str.getClass();
        charSequence.getClass();
        str2.getClass();
        str3.getClass();
        f0Var.getClass();
        h0 h0VarShowDialogByCustomViewBuilder = showDialogByCustomViewBuilder(context, str, charSequence, str2, str3, "2", f0Var);
        if (h0VarShowDialogByCustomViewBuilder != null) {
            return h0VarShowDialogByCustomViewBuilder.a();
        }
        return null;
    }

    public static final stepos.support.v7.app.i showDialogByCustomViewAndUploadRecord(Context context, String str, CharSequence charSequence, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, String str8, f0 f0Var) {
        context.getClass();
        str.getClass();
        charSequence.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        str6.getClass();
        strArr.getClass();
        str8.getClass();
        f0Var.getClass();
        h0 h0VarShowDialogUploadRecordBuilder = showDialogUploadRecordBuilder(context, str, charSequence, str2, str3, str4, str5, str6, strArr, str7, str8, f0Var);
        if (h0VarShowDialogUploadRecordBuilder != null) {
            return h0VarShowDialogUploadRecordBuilder.a();
        }
        return null;
    }

    public static final h0 showDialogByCustomViewBuilder(final Context context, String str, CharSequence charSequence, String str2, String str3, final String str4, final f0 f0Var) {
        context.getClass();
        str.getClass();
        charSequence.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        f0Var.getClass();
        h0 h0Var = new h0(context);
        h0Var.f12322c = str;
        h0Var.f12328j = new f0() { // from class: com.stepos.policy.sdk.PolicyManager.showDialogByCustomViewBuilder.1
            @Override // stepos.support.v7.app.f0
            public void onPermissionClick(DialogInterface dialogInterface, boolean z10, boolean z11) {
                if (z11 && k.a(str4, "2")) {
                    SocketHookUtil.recoveryPlatform();
                    ReadClipboardUtils.setAgreeReadClipBoard(ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_AGREE);
                    PolicyManager policyManager = PolicyManager.INSTANCE;
                    policyManager.saveReadClipboardStatus(context);
                    policyManager.saveAgreeStatus(context, 1);
                }
                f0Var.onPermissionClick(dialogInterface, z10, z11);
            }

            public /* bridge */ /* synthetic */ void onPermissionClick(DialogInterface dialogInterface, boolean z10, boolean z11, Map map) {
            }
        };
        h0Var.f12329k = charSequence;
        h0Var.f12333o = str2;
        h0Var.f12334p = str3;
        return h0Var;
    }

    public static final h0 showDialogByCustomViewBuilderRecord(final Context context, String str, CharSequence charSequence, String str2, String str3, final String str4, final String str5, final String str6, final String[] strArr, final String str7, final f0 f0Var) {
        context.getClass();
        str.getClass();
        charSequence.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        str6.getClass();
        strArr.getClass();
        f0Var.getClass();
        h0 h0Var = new h0(context);
        h0Var.f12322c = str;
        h0Var.f12328j = new f0() { // from class: com.stepos.policy.sdk.PolicyManager.showDialogByCustomViewBuilderRecord.1
            @Override // stepos.support.v7.app.f0
            public void onPermissionClick(DialogInterface dialogInterface, boolean z10, boolean z11) {
                String str8 = z11 ? "2" : "0";
                if (z11) {
                    PolicyManager.autoUploadRecord(context, str4, str5, str6, strArr, str7, str8);
                }
                f0Var.onPermissionClick(dialogInterface, z10, z11);
            }

            public /* bridge */ /* synthetic */ void onPermissionClick(DialogInterface dialogInterface, boolean z10, boolean z11, Map map) {
            }
        };
        h0Var.f12329k = charSequence;
        h0Var.f12333o = str2;
        h0Var.f12334p = str3;
        return h0Var;
    }

    public static final h0 showDialogUploadRecordBuilder(final Context context, String str, CharSequence charSequence, String str2, String str3, final String str4, final String str5, final String str6, final String[] strArr, final String str7, final String str8, final f0 f0Var) {
        context.getClass();
        str.getClass();
        charSequence.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        str6.getClass();
        strArr.getClass();
        str8.getClass();
        f0Var.getClass();
        h0 h0Var = new h0(context);
        h0Var.f12322c = str;
        h0Var.f12328j = new f0() { // from class: com.stepos.policy.sdk.PolicyManager.showDialogUploadRecordBuilder.1
            @Override // stepos.support.v7.app.f0
            public void onPermissionClick(DialogInterface dialogInterface, boolean z10, boolean z11) {
                if (z11) {
                    if (k.a(str8, "1")) {
                        SocketHookUtil.recoveryPlatform();
                        ReadClipboardUtils.setAgreeReadClipBoard(ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_AGREE);
                        PolicyManager policyManager = PolicyManager.INSTANCE;
                        policyManager.saveReadClipboardStatus(context);
                        policyManager.saveAgreeStatus(context, 1);
                    }
                    PolicyManager.autoUploadRecord(context, str4, str5, str6, strArr, str7, str8);
                }
                f0Var.onPermissionClick(dialogInterface, z10, z11);
            }

            public /* bridge */ /* synthetic */ void onPermissionClick(DialogInterface dialogInterface, boolean z10, boolean z11, Map map) {
            }
        };
        h0Var.f12329k = charSequence;
        h0Var.f12333o = str2;
        h0Var.f12334p = str3;
        return h0Var;
    }

    public static final stepos.support.v7.app.i showNewestDialogAndUploadRecord(final Context context, String str, final String str2, final String str3, final String str4, final String[] strArr, final String str5, final boolean z10, CharSequence charSequence, String str6, String str7, final f0 f0Var) {
        context.getClass();
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        strArr.getClass();
        charSequence.getClass();
        str6.getClass();
        str7.getClass();
        f0Var.getClass();
        h0 h0Var = new h0(context);
        h0Var.f12322c = str;
        h0Var.f12328j = new f0() { // from class: com.stepos.policy.sdk.PolicyManager.showNewestDialogAndUploadRecord.1
            @Override // stepos.support.v7.app.f0
            public void onPermissionClick(DialogInterface dialogInterface, boolean z11, boolean z12) {
                if (z12 && z10) {
                    PolicyManager.autoUploadRecord(context, str2, str3, str4, strArr, str5, "2");
                }
                f0Var.onPermissionClick(dialogInterface, z11, z12);
            }

            public /* bridge */ /* synthetic */ void onPermissionClick(DialogInterface dialogInterface, boolean z11, boolean z12, Map map) {
            }
        };
        h0Var.f12329k = charSequence;
        h0Var.f12333o = str6;
        h0Var.f12334p = str7;
        return h0Var.a();
    }

    public static final stepos.support.v7.app.i showReGrantDialog(Context context, boolean z10, boolean z11, String str, String str2, String str3, f0 f0Var) {
        context.getClass();
        str.getClass();
        str2.getClass();
        str3.getClass();
        f0Var.getClass();
        return INSTANCE.createReGrantDialogBuilder(context, z10, z11, str, str2, str3, f0Var).a();
    }

    public static final stepos.support.v7.app.i showReGrantDialogAndUploadRecord(final Context context, boolean z10, boolean z11, String str, String str2, String str3, final String str4, final String str5, final String str6, final String[] strArr, final String str7, final f0 f0Var) {
        context.getClass();
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        str6.getClass();
        strArr.getClass();
        f0Var.getClass();
        return INSTANCE.createReGrantDialogBuilder(context, z10, z11, str, str2, str3, new f0() { // from class: com.stepos.policy.sdk.PolicyManager$showReGrantDialogAndUploadRecord$builder$1
            @Override // stepos.support.v7.app.f0
            public void onPermissionClick(DialogInterface dialogInterface, boolean z12, boolean z13) {
                String str8 = z13 ? "2" : "0";
                if (z13) {
                    PolicyManager.autoUploadRecord(context, str4, str5, str6, strArr, str7, str8);
                }
                f0Var.onPermissionClick(dialogInterface, z12, z13);
            }

            public /* bridge */ /* synthetic */ void onPermissionClick(DialogInterface dialogInterface, boolean z12, boolean z13, Map map) {
            }
        }).a();
    }

    public static final stepos.support.v7.app.i showReGrantTwoPolicyDialog(Context context, boolean z10, boolean z11, String str, String str2, String str3, String str4, String str5, f0 f0Var) {
        context.getClass();
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        f0Var.getClass();
        h0 h0VarCreateReGrantDialogBuilder = INSTANCE.createReGrantDialogBuilder(context, z10, z11, str, str4, str5, f0Var);
        h0VarCreateReGrantDialogBuilder.f12332n = str2;
        a aVar = new a(2);
        aVar.f2777f = context;
        aVar.f2778g = z10;
        aVar.f2779h = str2;
        aVar.i = str3;
        VarHandle.storeStoreFence();
        h0VarCreateReGrantDialogBuilder.f12326g = aVar;
        return h0VarCreateReGrantDialogBuilder.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showReGrantTwoPolicyDialog$lambda$5(Context context, boolean z10, String str, String str2, View view) {
        context.getClass();
        str.getClass();
        str2.getClass();
        openPolicyMethod(context, z10, str, str2);
    }

    public static final stepos.support.v7.app.i showReGrantTwoPolicyDialogAndUploadRecord(final Context context, boolean z10, boolean z11, String str, String str2, String str3, String str4, String str5, final String str6, final String str7, final String str8, final String[] strArr, final String str9, final f0 f0Var) {
        context.getClass();
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        str6.getClass();
        str7.getClass();
        str8.getClass();
        strArr.getClass();
        f0Var.getClass();
        h0 h0VarCreateReGrantDialogBuilder = INSTANCE.createReGrantDialogBuilder(context, z10, z11, str, str4, str5, new f0() { // from class: com.stepos.policy.sdk.PolicyManager$showReGrantTwoPolicyDialogAndUploadRecord$builder$1
            @Override // stepos.support.v7.app.f0
            public void onPermissionClick(DialogInterface dialogInterface, boolean z12, boolean z13) {
                String str10 = z13 ? "2" : "0";
                if (z13) {
                    PolicyManager.autoUploadRecord(context, str6, str7, str8, strArr, str9, str10);
                }
                f0Var.onPermissionClick(dialogInterface, z12, z13);
            }

            public /* bridge */ /* synthetic */ void onPermissionClick(DialogInterface dialogInterface, boolean z12, boolean z13, Map map) {
            }
        });
        h0VarCreateReGrantDialogBuilder.f12332n = str2;
        a aVar = new a(1);
        aVar.f2777f = context;
        aVar.f2778g = z10;
        aVar.f2779h = str2;
        aVar.i = str3;
        VarHandle.storeStoreFence();
        h0VarCreateReGrantDialogBuilder.f12326g = aVar;
        return h0VarCreateReGrantDialogBuilder.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showReGrantTwoPolicyDialogAndUploadRecord$lambda$4(Context context, boolean z10, String str, String str2, View view) {
        context.getClass();
        str.getClass();
        str2.getClass();
        openPolicyMethod(context, z10, str, str2);
    }

    public static final stepos.support.v7.app.i showWithdrawalAndCleanServiceDataDialog(Context context, String str, CharSequence charSequence, String str2, String str3, String str4, final PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        context.getClass();
        str.getClass();
        charSequence.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        onPermissionClickListener.getClass();
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        final u uVar = new u();
        policyPermissionDialogBuilder.setAppName(str).setOnPermissionListener(new PolicyPermissionDialogBuilder.OnPermissionClickListener() { // from class: com.stepos.policy.sdk.PolicyManager.showWithdrawalAndCleanServiceDataDialog.1
            @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
            public void onPermissionClick(DialogInterface dialogInterface, boolean z10, boolean z11) {
                try {
                    stepos.support.v7.app.i iVar = (stepos.support.v7.app.i) uVar.f16098c;
                    View viewFindViewById = iVar != null ? iVar.findViewById(R.id.stepos_permission_dialog_checkbox_first) : null;
                    viewFindViewById.getClass();
                    onPermissionClickListener.onPermissionClick(dialogInterface, ((CheckBox) viewFindViewById).isChecked(), z11);
                } catch (Exception unused) {
                }
            }
        }).setCustomTerms(charSequence).setShowAlmostDenyBtn(true).setCustomNegativeButtonText(str2).setCustomPositiveButtonText(str3).setCancelable(true).setCheckEnableConfirmBtn(true);
        uVar.f16098c = policyPermissionDialogBuilder.create();
        stepos.support.v7.app.i iVarCreate = policyPermissionDialogBuilder.create();
        uVar.f16098c = iVarCreate;
        stepos.support.v7.app.i iVarInitWithdrawalCleanDataOneCheckBox = PolicySdkToolsUtils.Companion.initWithdrawalCleanDataOneCheckBox(context, iVarCreate, str4);
        uVar.f16098c = iVarInitWithdrawalCleanDataOneCheckBox;
        return iVarInitWithdrawalCleanDataOneCheckBox;
    }

    public static final stepos.support.v7.app.i showWithdrawalAndCleanServiceDataDialogByAccount(Context context, boolean z10, String str, CharSequence charSequence, String str2, String str3, String str4, String str5, final PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        context.getClass();
        str.getClass();
        charSequence.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        onPermissionClickListener.getClass();
        final u uVar = new u();
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        policyPermissionDialogBuilder.setAppName(str).setOnPermissionListener(new PolicyPermissionDialogBuilder.OnPermissionClickListener() { // from class: com.stepos.policy.sdk.PolicyManager.showWithdrawalAndCleanServiceDataDialogByAccount.1
            @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
            public void onPermissionClick(DialogInterface dialogInterface, boolean z11, boolean z12) {
                try {
                    stepos.support.v7.app.i iVar = (stepos.support.v7.app.i) uVar.f16098c;
                    View viewFindViewById = iVar != null ? iVar.findViewById(R.id.stepos_permission_dialog_checkbox_first) : null;
                    viewFindViewById.getClass();
                    boolean zIsChecked = ((CheckBox) viewFindViewById).isChecked();
                    stepos.support.v7.app.i iVar2 = (stepos.support.v7.app.i) uVar.f16098c;
                    View viewFindViewById2 = iVar2 != null ? iVar2.findViewById(R.id.stepos_permission_dialog_checkbox_second) : null;
                    viewFindViewById2.getClass();
                    onPermissionClickListener.onPermissionClick(dialogInterface, z12, zIsChecked, ((CheckBox) viewFindViewById2).isChecked());
                } catch (Exception unused) {
                }
            }
        }).setCustomTerms(charSequence).setShowAlmostDenyBtn(true).setCustomNegativeButtonText(str2).setCustomPositiveButtonText(str3).setCancelable(true).setCheckEnableConfirmBtn(true);
        stepos.support.v7.app.i iVarCreate = policyPermissionDialogBuilder.create();
        uVar.f16098c = iVarCreate;
        stepos.support.v7.app.i iVarInitWithdrawalCleanDataTwoCheckBox = PolicySdkToolsUtils.Companion.initWithdrawalCleanDataTwoCheckBox(context, iVarCreate, z10, str4, str5);
        uVar.f16098c = iVarInitWithdrawalCleanDataTwoCheckBox;
        return iVarInitWithdrawalCleanDataTwoCheckBox;
    }

    public static final void uploadPolicyOperateRecord(String str, String str2, String str3, PolicyRecordRequest policyRecordRequest, l lVar) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        policyRecordRequest.getClass();
        lVar.getClass();
        w.u(r0.f7476c, exceptionHandler, null, new C00461(str, str2, policyRecordRequest, lVar, str3, null), 2);
    }

    public static final void uploadRecordByCustomRecordRequest(Context context, String str, String str2, String str3, PolicyRecordRequest policyRecordRequest, l lVar) {
        context.getClass();
        str.getClass();
        str2.getClass();
        str3.getClass();
        policyRecordRequest.getClass();
        lVar.getClass();
        if (PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            uploadPolicyOperateRecord(str, str2, str3, policyRecordRequest, new C00471(lVar));
        }
    }

    public static final void uploadRecordToCleanServiceData(Context context, String str, String str2, String str3, ArrayList<DeleteInfoBean> arrayList, String str4, String str5, String str6, String[] strArr, String str7, String str8, l lVar) {
        context.getClass();
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        str6.getClass();
        strArr.getClass();
        str8.getClass();
        lVar.getClass();
        w.u(scope, exceptionHandler, null, new C00481(context, strArr, str7, str8, str3, str, str2, arrayList, str4, str5, str6, lVar, null), 2);
    }

    public static final void uploadRecordWithoutSecureService(Context context, String str, String str2, String str3, ArrayList<DeleteInfoBean> arrayList, String str4, String str5, String str6, String[] strArr, String str7, String str8, l lVar) {
        context.getClass();
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        str6.getClass();
        strArr.getClass();
        str8.getClass();
        lVar.getClass();
        w.u(scope, exceptionHandler, null, new C00491(context, strArr, str7, str8, str3, str, str2, arrayList, str4, str5, str6, lVar, null), 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getAgreeStatus(android.content.Context r5, nb.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.policy.sdk.PolicyManager.C00171
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.policy.sdk.PolicyManager$getAgreeStatus$1 r0 = (com.stepos.policy.sdk.PolicyManager.C00171) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.policy.sdk.PolicyManager$getAgreeStatus$1 r0 = new com.stepos.policy.sdk.PolicyManager$getAgreeStatus$1
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.result
            ob.a r6 = ob.a.f9351c
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L2e
            if (r1 != r2) goto L27
            id.c.I(r4)
            goto L47
        L27:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r4)
            r4 = 0
            return r4
        L2e:
            id.c.I(r4)
            v3.f r4 = com.stepos.policy.sdk.PolicyManagerKt.access$getPolicySdkDataStore(r5)
            nc.g r4 = r4.getData()
            com.stepos.policy.sdk.PolicyManager$getAgreeStatus$$inlined$map$1 r5 = new com.stepos.policy.sdk.PolicyManager$getAgreeStatus$$inlined$map$1
            r5.<init>()
            r0.label = r2
            java.lang.Object r4 = nc.k0.i(r5, r0)
            if (r4 != r6) goto L47
            return r6
        L47:
            java.lang.Integer r4 = (java.lang.Integer) r4
            if (r4 != 0) goto L51
            java.lang.Integer r4 = new java.lang.Integer
            r5 = 0
            r4.<init>(r5)
        L51:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.getAgreeStatus(android.content.Context, nb.c):java.lang.Object");
    }

    public final String getBrand() {
        return brand;
    }

    public final String getCompanyCode() {
        return companyCode;
    }

    public final String getCustomPolicyCSSFileName() {
        return customPolicyCSSFileName;
    }

    public final Object getDataStoreString(Context context, final y3.e eVar, c cVar) {
        final g data = PolicyManagerKt.getPolicySdkDataStore(context).getData();
        return k0.i(new g() { // from class: com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1

            /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
            /* renamed from: com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements h {
                final /* synthetic */ y3.e $dataStoreKey$inlined;
                final /* synthetic */ h $this_unsafeFlow;

                /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
                @e(c = "com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1$2", f = "PolicyManager.kt", l = {223}, m = "emit")
                /* renamed from: com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends pb.c {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(c cVar) {
                        super(cVar);
                    }

                    @Override // pb.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(h hVar, y3.e eVar) {
                    this.$this_unsafeFlow = hVar;
                    this.$dataStoreKey$inlined = eVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // nc.h
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, nb.c r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1$2$1 r0 = (com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1$2$1 r0 = new com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        ob.a r1 = ob.a.f9351c
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2e
                        if (r2 != r3) goto L27
                        id.c.I(r6)
                        goto L44
                    L27:
                        java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
                        od.f.e(r4)
                        r4 = 0
                        return r4
                    L2e:
                        id.c.I(r6)
                        nc.h r6 = r4.$this_unsafeFlow
                        y3.b r5 = (y3.b) r5
                        y3.e r4 = r4.$dataStoreKey$inlined
                        java.lang.Object r4 = r5.c(r4)
                        r0.label = r3
                        java.lang.Object r4 = r6.emit(r4, r0)
                        if (r4 != r1) goto L44
                        return r1
                    L44:
                        jb.v r4 = jb.v.f6774a
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, nb.c):java.lang.Object");
                }
            }

            @Override // nc.g
            public Object collect(h hVar, c cVar2) {
                Object objCollect = data.collect(new AnonymousClass2(hVar, eVar), cVar2);
                return objCollect == ob.a.f9351c ? objCollect : v.f6774a;
            }
        }, cVar);
    }

    public final r getExceptionHandler() {
        return exceptionHandler;
    }

    public final boolean getInitSDKByDeviceProtectedStorageContext() {
        return initSDKByDeviceProtectedStorageContext;
    }

    public final t getLifecycleScope() {
        return lifecycleScope;
    }

    public final HashMap<String, String> getLocalAssetsCategoryPathMap() {
        return localAssetsCategoryPathMap;
    }

    public final String getMAppId() {
        return mAppId;
    }

    public final String getMAppSecret() {
        return mAppSecret;
    }

    public final String getMAppVersionName() {
        return mAppVersionName;
    }

    public final String getModel() {
        return model;
    }

    public final String getOsVersion() {
        return osVersion;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getPolicyOperate(android.content.Context r5, nb.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.policy.sdk.PolicyManager.C00231
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.policy.sdk.PolicyManager$getPolicyOperate$1 r0 = (com.stepos.policy.sdk.PolicyManager.C00231) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.policy.sdk.PolicyManager$getPolicyOperate$1 r0 = new com.stepos.policy.sdk.PolicyManager$getPolicyOperate$1
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.result
            ob.a r6 = ob.a.f9351c
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L2e
            if (r1 != r2) goto L27
            id.c.I(r4)
            goto L47
        L27:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r4)
            r4 = 0
            return r4
        L2e:
            id.c.I(r4)
            v3.f r4 = com.stepos.policy.sdk.PolicyManagerKt.access$getPolicySdkDataStore(r5)
            nc.g r4 = r4.getData()
            com.stepos.policy.sdk.PolicyManager$getPolicyOperate$$inlined$map$1 r5 = new com.stepos.policy.sdk.PolicyManager$getPolicyOperate$$inlined$map$1
            r5.<init>()
            r0.label = r2
            java.lang.Object r4 = nc.k0.i(r5, r0)
            if (r4 != r6) goto L47
            return r6
        L47:
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            boolean r4 = yb.k.a(r4, r5)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.getPolicyOperate(android.content.Context, nb.c):java.lang.Object");
    }

    public final Object getPolicyOperateJson(Context context, c cVar) {
        final g data = PolicyManagerKt.getPolicySdkDataStore(context).getData();
        return k0.i(new g() { // from class: com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1

            /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
            /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements h {
                final /* synthetic */ h $this_unsafeFlow;

                /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
                @e(c = "com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1$2", f = "PolicyManager.kt", l = {223}, m = "emit")
                /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends pb.c {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(c cVar) {
                        super(cVar);
                    }

                    @Override // pb.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(h hVar) {
                    this.$this_unsafeFlow = hVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // nc.h
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, nb.c r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1$2$1 r0 = (com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1$2$1 r0 = new com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        ob.a r1 = ob.a.f9351c
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2e
                        if (r2 != r3) goto L27
                        id.c.I(r6)
                        goto L46
                    L27:
                        java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
                        od.f.e(r4)
                        r4 = 0
                        return r4
                    L2e:
                        id.c.I(r6)
                        nc.h r4 = r4.$this_unsafeFlow
                        y3.b r5 = (y3.b) r5
                        y3.e r6 = com.stepos.policy.sdk.PolicyManagerKt.getKEY_POLICY_OPERATE_JSON()
                        java.lang.Object r5 = r5.c(r6)
                        r0.label = r3
                        java.lang.Object r4 = r4.emit(r5, r0)
                        if (r4 != r1) goto L46
                        return r1
                    L46:
                        jb.v r4 = jb.v.f6774a
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, nb.c):java.lang.Object");
                }
            }

            @Override // nc.g
            public Object collect(h hVar, c cVar2) {
                Object objCollect = data.collect(new AnonymousClass2(hVar), cVar2);
                return objCollect == ob.a.f9351c ? objCollect : v.f6774a;
            }
        }, cVar);
    }

    public final int getReadClipboardStatus(Context context) {
        context.getClass();
        return ((Number) w.y(nb.h.f8811c, new C00261(context, null))).intValue();
    }

    public final t getScope() {
        return scope;
    }

    public final int getSecureServiceVersionCode(Context context) {
        context.getClass();
        int i = context.getApplicationContext().getPackageManager().getPackageInfo("com.stepos.secureservice", 128).versionCode;
        PolicySdkLogUtils.Companion.d("PolicyManager", "com.stepos.secureservice versionCode : " + i + ' ');
        return i;
    }

    public final boolean getSyncLocalFileFinished() {
        return syncLocalFileFinished;
    }

    public final void saveAgreeStatus(Context context, int i) {
        context.getClass();
        w.u(r0.f7476c, exceptionHandler, null, new C00301(context, i, null), 2);
    }

    public final void saveReadClipboardStatus(Context context) {
        context.getClass();
        if (ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_AGREE == getReadClipboardStatus(context)) {
            return;
        }
        w.u(r0.f7476c, exceptionHandler, null, new C00351(context, null), 2);
    }

    public final void setBrand(String str) {
        str.getClass();
        brand = str;
    }

    public final void setCompanyCode(String str) {
        str.getClass();
        companyCode = str;
    }

    public final void setCustomPolicyCSSFileName(String str) {
        str.getClass();
        customPolicyCSSFileName = str;
    }

    public final void setInitSDKByDeviceProtectedStorageContext(boolean z10) {
        initSDKByDeviceProtectedStorageContext = z10;
    }

    public final void setLocalAssetsCategoryPathMap(HashMap<String, String> map) {
        map.getClass();
        localAssetsCategoryPathMap = map;
    }

    public final void setMAppId(String str) {
        str.getClass();
        mAppId = str;
    }

    public final void setMAppSecret(String str) {
        str.getClass();
        mAppSecret = str;
    }

    public final void setMAppVersionName(String str) {
        str.getClass();
        mAppVersionName = str;
    }

    public final void setModel(String str) {
        str.getClass();
        model = str;
    }

    public final void setOsVersion(String str) {
        str.getClass();
        osVersion = str;
    }

    public final void setSyncLocalFileFinished(boolean z10) {
        syncLocalFileFinished = z10;
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    /* renamed from: com.stepos.policy.sdk.PolicyManager$autoUploadRecord$1, reason: invalid class name */
    public static final class AnonymousClass1 extends yb.l implements l {
        final /* synthetic */ Context $context;
        final /* synthetic */ u $policyRecordRequest;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        @e(c = "com.stepos.policy.sdk.PolicyManager$autoUploadRecord$1$1", f = "PolicyManager.kt", l = {1281}, m = "invokeSuspend")
        /* renamed from: com.stepos.policy.sdk.PolicyManager$autoUploadRecord$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00041 extends i implements p {
            final /* synthetic */ Context $context;
            final /* synthetic */ u $policyRecordRequest;
            final /* synthetic */ PolicySdkResultBean $policySdkResultBean;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00041(PolicySdkResultBean policySdkResultBean, u uVar, Context context, c cVar) {
                super(2, cVar);
                this.$policySdkResultBean = policySdkResultBean;
                this.$policyRecordRequest = uVar;
                this.$context = context;
            }

            @Override // pb.a
            public final c create(Object obj, c cVar) {
                return new C00041(this.$policySdkResultBean, this.$policyRecordRequest, this.$context, cVar);
            }

            @Override // xb.p
            public final Object invoke(t tVar, c cVar) {
                return ((C00041) create(tVar, cVar)).invokeSuspend(v.f6774a);
            }

            @Override // pb.a
            public final Object invokeSuspend(Object obj) {
                String strE;
                boolean z10;
                ob.a aVar = ob.a.f9351c;
                int i = this.label;
                if (i == 0) {
                    id.c.I(obj);
                    PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                    companion.d("autoUploadRecord", "policySdkResultBean.code " + this.$policySdkResultBean.getCode());
                    if (this.$policySdkResultBean.getCode() == 0) {
                        strE = "";
                        z10 = true;
                    } else {
                        strE = new m7.e().e(this.$policyRecordRequest.f16098c);
                        z10 = false;
                    }
                    companion.d("autoUploadRecord", "isOperateSuccess " + z10);
                    PolicyManager policyManager = PolicyManager.INSTANCE;
                    Context context = this.$context;
                    this.label = 1;
                    if (policyManager.savePolicyOperate(context, z10, strE, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        f.e("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    id.c.I(obj);
                }
                return v.f6774a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(u uVar, Context context) {
            super(1);
            this.$policyRecordRequest = uVar;
            this.$context = context;
        }

        public final void invoke(PolicySdkResultBean policySdkResultBean) {
            policySdkResultBean.getClass();
            w.u(r0.f7476c, PolicyManager.INSTANCE.getExceptionHandler(), null, new C00041(policySdkResultBean, this.$policyRecordRequest, this.$context, null), 2);
        }

        @Override // xb.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PolicySdkResultBean) obj);
            return v.f6774a;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getCommonDeleteInfoList$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00181 extends yb.l implements l {
        final /* synthetic */ Context $context;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        @e(c = "com.stepos.policy.sdk.PolicyManager$getCommonDeleteInfoList$1$1", f = "PolicyManager.kt", l = {2364}, m = "invokeSuspend")
        /* renamed from: com.stepos.policy.sdk.PolicyManager$getCommonDeleteInfoList$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00051 extends i implements p {
            final /* synthetic */ Context $context;
            final /* synthetic */ String $deleteInfoListJson;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00051(String str, Context context, c cVar) {
                super(2, cVar);
                this.$deleteInfoListJson = str;
                this.$context = context;
            }

            @Override // pb.a
            public final c create(Object obj, c cVar) {
                return new C00051(this.$deleteInfoListJson, this.$context, cVar);
            }

            @Override // xb.p
            public final Object invoke(t tVar, c cVar) {
                return ((C00051) create(tVar, cVar)).invokeSuspend(v.f6774a);
            }

            @Override // pb.a
            public final Object invokeSuspend(Object obj) {
                ob.a aVar = ob.a.f9351c;
                int i = this.label;
                if (i == 0) {
                    id.c.I(obj);
                    PolicySdkLogUtils.Companion.d("getCommonDeleteInfoList", "result = " + this.$deleteInfoListJson);
                    Context context = this.$context;
                    if (context != null) {
                        PolicyManager policyManager = PolicyManager.INSTANCE;
                        y3.e key_common_delete_info_json = PolicyManagerKt.getKEY_COMMON_DELETE_INFO_JSON();
                        String str = this.$deleteInfoListJson;
                        this.label = 1;
                        if (policyManager.saveDataStoreString(context, key_common_delete_info_json, str, this) == aVar) {
                            return aVar;
                        }
                    }
                } else {
                    if (i != 1) {
                        f.e("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    id.c.I(obj);
                }
                return v.f6774a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00181(Context context) {
            super(1);
            this.$context = context;
        }

        public final void invoke(String str) {
            str.getClass();
            PolicyManager policyManager = PolicyManager.INSTANCE;
            w.u(policyManager.getLifecycleScope(), policyManager.getExceptionHandler(), null, new C00051(str, this.$context, null), 2);
        }

        @Override // xb.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return v.f6774a;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    /* renamed from: com.stepos.policy.sdk.PolicyManager$encryptCustomDeleteInfoListBySecure$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00151 extends yb.l implements l {
        final /* synthetic */ l $callBackPolicyResult;
        final /* synthetic */ ArrayList<CustomDeleteInfoBean> $customDeleteInfoList;
        final /* synthetic */ ArrayList<DeleteInfoBean> $resultDeleteInfoBeanList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00151(ArrayList<DeleteInfoBean> arrayList, ArrayList<CustomDeleteInfoBean> arrayList2, l lVar) {
            super(1);
            this.$resultDeleteInfoBeanList = arrayList;
            this.$customDeleteInfoList = arrayList2;
            this.$callBackPolicyResult = lVar;
        }

        public final void invoke(DeleteInfoBean deleteInfoBean) {
            deleteInfoBean.getClass();
            PolicyManager policyManager = PolicyManager.INSTANCE;
            ArrayList<DeleteInfoBean> arrayList = this.$resultDeleteInfoBeanList;
            ArrayList<CustomDeleteInfoBean> arrayList2 = this.$customDeleteInfoList;
            l lVar = this.$callBackPolicyResult;
            arrayList.add(deleteInfoBean);
            if (arrayList.size() == arrayList2.size()) {
                lVar.invoke(arrayList);
            }
        }

        @Override // xb.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((DeleteInfoBean) obj);
            return v.f6774a;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    /* renamed from: com.stepos.policy.sdk.PolicyManager$encryptMultiDeleteListBySecure$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00161 extends yb.l implements l {
        final /* synthetic */ l $callBackPolicyResult;
        final /* synthetic */ ArrayList<DeleteInfoEncryptMultiBean> $customDeleteInfoList;
        final /* synthetic */ ArrayList<DeleteInfoBean> $resultDeleteInfoBeanList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00161(ArrayList<DeleteInfoBean> arrayList, ArrayList<DeleteInfoEncryptMultiBean> arrayList2, l lVar) {
            super(1);
            this.$resultDeleteInfoBeanList = arrayList;
            this.$customDeleteInfoList = arrayList2;
            this.$callBackPolicyResult = lVar;
        }

        public final void invoke(DeleteInfoBean deleteInfoBean) {
            deleteInfoBean.getClass();
            PolicyManager policyManager = PolicyManager.INSTANCE;
            ArrayList<DeleteInfoBean> arrayList = this.$resultDeleteInfoBeanList;
            ArrayList<DeleteInfoEncryptMultiBean> arrayList2 = this.$customDeleteInfoList;
            l lVar = this.$callBackPolicyResult;
            arrayList.add(deleteInfoBean);
            if (arrayList.size() == arrayList2.size()) {
                lVar.invoke(arrayList);
            }
        }

        @Override // xb.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((DeleteInfoBean) obj);
            return v.f6774a;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getPrivateDeleteInfoList$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00251 extends yb.l implements l {
        final /* synthetic */ l $callBackPolicyResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00251(l lVar) {
            super(1);
            this.$callBackPolicyResult = lVar;
        }

        public final void invoke(ArrayList<DeleteInfoBean> arrayList) {
            PolicyManager policyManager = PolicyManager.INSTANCE;
            l lVar = this.$callBackPolicyResult;
            PolicySdkLogUtils.Companion.d("getPrivateDeleteInfoList", "result = " + arrayList);
            lVar.invoke(arrayList);
        }

        @Override // xb.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ArrayList<DeleteInfoBean>) obj);
            return v.f6774a;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    /* renamed from: com.stepos.policy.sdk.PolicyManager$uploadRecordByCustomRecordRequest$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00471 extends yb.l implements l {
        final /* synthetic */ l $callBackPolicyResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00471(l lVar) {
            super(1);
            this.$callBackPolicyResult = lVar;
        }

        public final void invoke(PolicySdkResultBean policySdkResultBean) {
            policySdkResultBean.getClass();
            PolicySdkLogUtils.Companion.d("uploadRecordToCleanServiceData", "policySdkResultBean.code " + policySdkResultBean.getCode());
            this.$callBackPolicyResult.invoke(policySdkResultBean);
        }

        @Override // xb.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PolicySdkResultBean) obj);
            return v.f6774a;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.PolicyManager$reTryUploadRecord$1", f = "PolicyManager.kt", l = {1070, 1073}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$reTryUploadRecord$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00291 extends i implements p {
        final /* synthetic */ Context $context;
        int I$0;
        int label;
        final /* synthetic */ PolicyManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00291(Context context, PolicyManager policyManager, c cVar) {
            super(2, cVar);
            this.$context = context;
            this.this$0 = policyManager;
        }

        @Override // pb.a
        public final c create(Object obj, c cVar) {
            return new C00291(this.$context, this.this$0, cVar);
        }

        @Override // xb.p
        public final Object invoke(t tVar, c cVar) {
            return ((C00291) create(tVar, cVar)).invokeSuspend(v.f6774a);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
        @Override // pb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                ob.a r0 = ob.a.f9351c
                int r1 = r8.label
                java.lang.String r2 = "isNeedReTry= "
                java.lang.String r3 = "reTryUploadRecord"
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L21
                if (r1 == r5) goto L1d
                if (r1 != r4) goto L16
                int r0 = r8.I$0
                id.c.I(r9)
                goto L5c
            L16:
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                od.f.e(r8)
                r8 = 0
                return r8
            L1d:
                id.c.I(r9)
                goto L31
            L21:
                id.c.I(r9)
                com.stepos.policy.sdk.PolicyManager r9 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                android.content.Context r1 = r8.$context
                r8.label = r5
                java.lang.Object r9 = r9.getPolicyOperate(r1, r8)
                if (r9 != r0) goto L31
                goto L5a
            L31:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                r1 = r9 ^ 1
                com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r6 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r2)
                r7.append(r1)
                java.lang.String r7 = r7.toString()
                r6.d(r3, r7)
                if (r9 != 0) goto La9
                com.stepos.policy.sdk.PolicyManager r9 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                android.content.Context r6 = r8.$context
                r8.I$0 = r1
                r8.label = r4
                java.lang.Object r9 = r9.getPolicyOperateJson(r6, r8)
                if (r9 != r0) goto L5b
            L5a:
                return r0
            L5b:
                r0 = r1
            L5c:
                java.lang.String r9 = (java.lang.String) r9
                if (r9 == 0) goto La9
                int r1 = r9.length()
                if (r1 <= 0) goto La9
                m7.e r1 = new m7.e
                r1.<init>()
                java.lang.Class<com.stepos.policy.sdk.bean.PolicyRecordRequest> r4 = com.stepos.policy.sdk.bean.PolicyRecordRequest.class
                t7.a r4 = t7.a.get(r4)
                java.lang.Object r9 = r1.b(r9, r4)
                com.stepos.policy.sdk.bean.PolicyRecordRequest r9 = (com.stepos.policy.sdk.bean.PolicyRecordRequest) r9
                com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r1 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>(r2)
                if (r0 == 0) goto L81
                goto L82
            L81:
                r5 = 0
            L82:
                r4.append(r5)
                java.lang.String r0 = r4.toString()
                r1.d(r3, r0)
                com.stepos.policy.sdk.PolicyManager r0 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                java.lang.String r1 = r0.getMAppId()
                java.lang.String r2 = r0.getMAppSecret()
                java.lang.String r0 = r0.getMAppVersionName()
                r9.getClass()
                com.stepos.policy.sdk.PolicyManager$reTryUploadRecord$1$1 r3 = new com.stepos.policy.sdk.PolicyManager$reTryUploadRecord$1$1
                com.stepos.policy.sdk.PolicyManager r4 = r8.this$0
                android.content.Context r8 = r8.$context
                r3.<init>(r4, r8)
                com.stepos.policy.sdk.PolicyManager.uploadPolicyOperateRecord(r1, r2, r0, r9, r3)
            La9:
                jb.v r8 = jb.v.f6774a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C00291.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        /* renamed from: com.stepos.policy.sdk.PolicyManager$reTryUploadRecord$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00071 extends yb.l implements l {
            final /* synthetic */ Context $context;
            final /* synthetic */ PolicyManager this$0;

            /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
            @e(c = "com.stepos.policy.sdk.PolicyManager$reTryUploadRecord$1$1$1", f = "PolicyManager.kt", l = {1090}, m = "invokeSuspend")
            /* renamed from: com.stepos.policy.sdk.PolicyManager$reTryUploadRecord$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C00081 extends i implements p {
                final /* synthetic */ Context $context;
                final /* synthetic */ u $policyRecordGson;
                int label;
                final /* synthetic */ PolicyManager this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00081(PolicyManager policyManager, Context context, u uVar, c cVar) {
                    super(2, cVar);
                    this.this$0 = policyManager;
                    this.$context = context;
                    this.$policyRecordGson = uVar;
                }

                @Override // pb.a
                public final c create(Object obj, c cVar) {
                    return new C00081(this.this$0, this.$context, this.$policyRecordGson, cVar);
                }

                @Override // xb.p
                public final Object invoke(t tVar, c cVar) {
                    return ((C00081) create(tVar, cVar)).invokeSuspend(v.f6774a);
                }

                @Override // pb.a
                public final Object invokeSuspend(Object obj) {
                    ob.a aVar = ob.a.f9351c;
                    int i = this.label;
                    if (i == 0) {
                        id.c.I(obj);
                        PolicyManager policyManager = this.this$0;
                        Context context = this.$context;
                        String str = (String) this.$policyRecordGson.f16098c;
                        this.label = 1;
                        if (policyManager.savePolicyOperate(context, true, str, this) == aVar) {
                            return aVar;
                        }
                    } else {
                        if (i != 1) {
                            f.e("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        id.c.I(obj);
                    }
                    return v.f6774a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00071(PolicyManager policyManager, Context context) {
                super(1);
                this.this$0 = policyManager;
                this.$context = context;
            }

            public final void invoke(PolicySdkResultBean policySdkResultBean) {
                policySdkResultBean.getClass();
                u uVar = new u();
                uVar.f16098c = "";
                if (policySdkResultBean.getCode() == 0) {
                    w.u(r0.f7476c, PolicyManager.INSTANCE.getExceptionHandler(), null, new C00081(this.this$0, this.$context, uVar, null), 2);
                }
            }

            @Override // xb.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PolicySdkResultBean) obj);
                return v.f6774a;
            }
        }
    }
}
