package com.stepos.policy.sdk;

import O.d;
import V3.v;
import W3.C0403n;
import a4.C0428b;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import androidx.core.content.FileProvider;
import com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity;
import com.stepos.policy.sdk.api.PolicyApiService;
import com.stepos.policy.sdk.bean.CustomDeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoEncryptMultiBean;
import com.stepos.policy.sdk.bean.PolicyFileDataResultBean;
import com.stepos.policy.sdk.bean.PolicyHistoryListResponse;
import com.stepos.policy.sdk.bean.PolicyNewestPathResultBean;
import com.stepos.policy.sdk.bean.PolicyNewestResponse;
import com.stepos.policy.sdk.bean.PolicyOperateRecordResponse;
import com.stepos.policy.sdk.bean.PolicyRecordBaseInfo;
import com.stepos.policy.sdk.bean.PolicyRecordRequest;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.bean.PolicyServiceConfigResponse;
import com.stepos.policy.sdk.bean.PolicyVersionResponse;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder;
import com.stepos.policy.sdk.manager.WithdrawalManager;
import com.stepos.policy.sdk.manager.WithdrawalManagerWithoutSecureService;
import com.stepos.policy.sdk.net.PolicySdkRetrofitCreator;
import com.stepos.policy.sdk.net.PolicySdkRetrofitHelper;
import com.stepos.policy.sdk.util.PolicyAppSecretResolver;
import com.stepos.policy.sdk.util.PolicyCheckLogUtils;
import com.stepos.policy.sdk.util.PolicyCloudPolicyIndex;
import com.stepos.policy.sdk.util.PolicyHtmlDisplayAdapter;
import com.stepos.policy.sdk.util.PolicySdkFileUtils;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkNetworkGate;
import com.stepos.policy.sdk.util.PolicySdkNetworkUtil;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import com.stepos.policy.sdk.util.SocketHookUtil;
import i4.InterfaceC0772l;
import j4.u;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.libpag.BuildConfig;
import r4.C1031n;
import s4.AbstractC1056E;
import s4.C1059H;
import s4.C1072g;
import s4.C1073g0;
import s4.C1074h;
import s4.C1076i;
import s4.F0;
import s4.InterfaceC1057F;
import stepos.support.v7.app.r;
import v4.InterfaceC1193b;
import v4.InterfaceC1194c;

/* loaded from: classes.dex */
public final class PolicyManager {
    private static final long SYNC_LOCAL_FILE_MAX_WAIT_MS = 10000;
    private static final long SYNC_LOCAL_FILE_POLL_MS = 200;
    private static String brand;
    private static String companyCode;
    private static final InterfaceC1057F exceptionHandler;
    private static boolean initSDKByDeviceProtectedStorageContext;
    private static String model;
    private static String osVersion;
    private static boolean readAndroidIdEnabled;
    private static boolean syncLocalFileFinished;
    public static final PolicyManager INSTANCE = new PolicyManager();
    private static final s4.I lifecycleScope = s4.J.b();
    private static String mAppId = BuildConfig.FLAVOR;
    private static String mAppSecret = BuildConfig.FLAVOR;
    private static String mAppVersionName = BuildConfig.FLAVOR;
    private static String customPolicyCSSFileName = BuildConfig.FLAVOR;
    private static HashMap<String, String> localAssetsCategoryPathMap = new HashMap<>();
    private static final s4.I scope = s4.J.a(F0.b(null, 1, null).C(s4.W.b()));

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$reTryUploadRecord$1", f = "PolicyManager.kt", l = {1132, 1135}, m = "invokeSuspend")
    static final class A extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super v>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f15431a;

        /* renamed from: b, reason: collision with root package name */
        int f15432b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f15433c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PolicyManager f15434d;

        static final class a extends j4.l implements InterfaceC0772l<PolicySdkResultBean, v> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ PolicyManager f15435a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Context f15436b;

            @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$reTryUploadRecord$1$1$1", f = "PolicyManager.kt", l = {1152}, m = "invokeSuspend")
            /* renamed from: com.stepos.policy.sdk.PolicyManager$A$a$a, reason: collision with other inner class name */
            static final class C0188a extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super v>, Object> {

                /* renamed from: a, reason: collision with root package name */
                int f15437a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ PolicyManager f15438b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ Context f15439c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ j4.v<String> f15440d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0188a(PolicyManager policyManager, Context context, j4.v<String> vVar, Z3.e<? super C0188a> eVar) {
                    super(2, eVar);
                    this.f15438b = policyManager;
                    this.f15439c = context;
                    this.f15440d = vVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
                    return new C0188a(this.f15438b, this.f15439c, this.f15440d, eVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objE = C0428b.e();
                    int i5 = this.f15437a;
                    if (i5 == 0) {
                        V3.o.b(obj);
                        PolicyManager policyManager = this.f15438b;
                        Context context = this.f15439c;
                        String str = this.f15440d.f17836a;
                        this.f15437a = 1;
                        if (policyManager.savePolicyOperate(context, true, str, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i5 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        V3.o.b(obj);
                    }
                    return v.f5542a;
                }

                @Override // i4.p
                public final Object invoke(s4.I i5, Z3.e<? super v> eVar) {
                    return ((C0188a) create(i5, eVar)).invokeSuspend(v.f5542a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(PolicyManager policyManager, Context context) {
                super(1);
                this.f15435a = policyManager;
                this.f15436b = context;
            }

            public final void b(PolicySdkResultBean policySdkResultBean) {
                j4.k.g(policySdkResultBean, "policySdkResultBean");
                j4.v vVar = new j4.v();
                vVar.f17836a = BuildConfig.FLAVOR;
                if (policySdkResultBean.getCode() == 0) {
                    C1076i.b(C1073g0.f20349a, PolicyManager.INSTANCE.getExceptionHandler(), null, new C0188a(this.f15435a, this.f15436b, vVar, null), 2, null);
                }
            }

            @Override // i4.InterfaceC0772l
            public /* bridge */ /* synthetic */ v invoke(PolicySdkResultBean policySdkResultBean) {
                b(policySdkResultBean);
                return v.f5542a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        A(Context context, PolicyManager policyManager, Z3.e<? super A> eVar) {
            super(2, eVar);
            this.f15433c = context;
            this.f15434d = policyManager;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            return new A(this.f15433c, this.f15434d, eVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = a4.C0428b.e()
                int r1 = r8.f15432b
                java.lang.String r2 = "isNeedReTry= "
                java.lang.String r3 = "reTryUploadRecord"
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L24
                if (r1 == r5) goto L20
                if (r1 != r4) goto L18
                int r0 = r8.f15431a
                V3.o.b(r9)
                goto L62
            L18:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L20:
                V3.o.b(r9)
                goto L34
            L24:
                V3.o.b(r9)
                com.stepos.policy.sdk.PolicyManager r9 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                android.content.Context r1 = r8.f15433c
                r8.f15432b = r5
                java.lang.Object r9 = r9.getPolicyOperate(r1, r8)
                if (r9 != r0) goto L34
                goto L60
            L34:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                r1 = r9 ^ 1
                com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r6 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                r7.append(r2)
                r7.append(r1)
                java.lang.String r7 = r7.toString()
                r6.d(r3, r7)
                if (r9 != 0) goto Lb0
                com.stepos.policy.sdk.PolicyManager r9 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                android.content.Context r6 = r8.f15433c
                r8.f15431a = r1
                r8.f15432b = r4
                java.lang.Object r9 = r9.getPolicyOperateJson(r6, r8)
                if (r9 != r0) goto L61
            L60:
                return r0
            L61:
                r0 = r1
            L62:
                java.lang.String r9 = (java.lang.String) r9
                if (r9 == 0) goto Lb0
                int r1 = r9.length()
                if (r1 <= 0) goto Lb0
                A1.e r1 = new A1.e
                r1.<init>()
                java.lang.Class<com.stepos.policy.sdk.bean.PolicyRecordRequest> r4 = com.stepos.policy.sdk.bean.PolicyRecordRequest.class
                java.lang.Object r9 = r1.i(r9, r4)
                com.stepos.policy.sdk.bean.PolicyRecordRequest r9 = (com.stepos.policy.sdk.bean.PolicyRecordRequest) r9
                com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r1 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r2)
                if (r0 == 0) goto L86
                goto L87
            L86:
                r5 = 0
            L87:
                r4.append(r5)
                java.lang.String r0 = r4.toString()
                r1.d(r3, r0)
                com.stepos.policy.sdk.PolicyManager r0 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                java.lang.String r1 = r0.getMAppId()
                java.lang.String r2 = r0.getMAppSecret()
                java.lang.String r0 = r0.getMAppVersionName()
                java.lang.String r3 = "policyRecordRequest"
                j4.k.f(r9, r3)
                com.stepos.policy.sdk.PolicyManager$A$a r3 = new com.stepos.policy.sdk.PolicyManager$A$a
                com.stepos.policy.sdk.PolicyManager r4 = r8.f15434d
                android.content.Context r8 = r8.f15433c
                r3.<init>(r4, r8)
                com.stepos.policy.sdk.PolicyManager.uploadPolicyOperateRecord(r1, r2, r0, r9, r3)
            Lb0:
                V3.v r8 = V3.v.f5542a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.A.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // i4.p
        public final Object invoke(s4.I i5, Z3.e<? super v> eVar) {
            return ((A) create(i5, eVar)).invokeSuspend(v.f5542a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {128}, m = "resolveSignSecret")
    static final class B extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a, reason: collision with root package name */
        Object f15441a;

        /* renamed from: b, reason: collision with root package name */
        boolean f15442b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f15443c;

        /* renamed from: e, reason: collision with root package name */
        int f15445e;

        B(Z3.e<? super B> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f15443c = obj;
            this.f15445e |= Integer.MIN_VALUE;
            return PolicyManager.this.resolveSignSecret(null, null, null, false, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$saveAgreeStatus$1", f = "PolicyManager.kt", l = {379}, m = "invokeSuspend")
    static final class C extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super v>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f15446a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f15447b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f15448c;

        @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$saveAgreeStatus$1$1", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
        static final class a extends kotlin.coroutines.jvm.internal.l implements i4.p<O.a, Z3.e<? super v>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f15449a;

            /* renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f15450b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f15451c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(int i5, Z3.e<? super a> eVar) {
                super(2, eVar);
                this.f15451c = i5;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
                a aVar = new a(this.f15451c, eVar);
                aVar.f15450b = obj;
                return aVar;
            }

            @Override // i4.p
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public final Object invoke(O.a aVar, Z3.e<? super v> eVar) {
                return ((a) create(aVar, eVar)).invokeSuspend(v.f5542a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                C0428b.e();
                if (this.f15449a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                V3.o.b(obj);
                ((O.a) this.f15450b).i(d.b(), kotlin.coroutines.jvm.internal.b.b(this.f15451c));
                return v.f5542a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C(Context context, int i5, Z3.e<? super C> eVar) {
            super(2, eVar);
            this.f15447b = context;
            this.f15448c = i5;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            return new C(this.f15447b, this.f15448c, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objE = C0428b.e();
            int i5 = this.f15446a;
            try {
                if (i5 == 0) {
                    V3.o.b(obj);
                    L.f fVarG = d.g(this.f15447b);
                    a aVar = new a(this.f15448c, null);
                    this.f15446a = 1;
                    if (O.g.a(fVarG, aVar, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    V3.o.b(obj);
                }
            } catch (Exception e6) {
                PolicySdkLogUtils.Companion.e("savePolicyCategoryVersion", "error =" + e6 + ' ');
            }
            return v.f5542a;
        }

        @Override // i4.p
        public final Object invoke(s4.I i5, Z3.e<? super v> eVar) {
            return ((C) create(i5, eVar)).invokeSuspend(v.f5542a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$saveDataStoreString$2", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
    static final class D extends kotlin.coroutines.jvm.internal.l implements i4.p<O.a, Z3.e<? super v>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f15452a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f15453b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.a<String> f15454c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15455d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        D(d.a<String> aVar, String str, Z3.e<? super D> eVar) {
            super(2, eVar);
            this.f15454c = aVar;
            this.f15455d = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            D d6 = new D(this.f15454c, this.f15455d, eVar);
            d6.f15453b = obj;
            return d6;
        }

        @Override // i4.p
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public final Object invoke(O.a aVar, Z3.e<? super v> eVar) {
            return ((D) create(aVar, eVar)).invokeSuspend(v.f5542a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            C0428b.e();
            if (this.f15452a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            V3.o.b(obj);
            O.a aVar = (O.a) this.f15453b;
            d.a<String> aVar2 = this.f15454c;
            String str = this.f15455d;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            aVar.i(aVar2, str);
            return v.f5542a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$saveLocalCategoryMd5$1", f = "PolicyManager.kt", l = {2583}, m = "invokeSuspend")
    static final class E extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super v>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f15456a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15457b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15458c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f15459d;

        @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$saveLocalCategoryMd5$1$1", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
        static final class a extends kotlin.coroutines.jvm.internal.l implements i4.p<O.a, Z3.e<? super v>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f15460a;

            /* renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f15461b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f15462c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f15463d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, String str2, Z3.e<? super a> eVar) {
                super(2, eVar);
                this.f15462c = str;
                this.f15463d = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
                a aVar = new a(this.f15462c, this.f15463d, eVar);
                aVar.f15461b = obj;
                return aVar;
            }

            @Override // i4.p
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public final Object invoke(O.a aVar, Z3.e<? super v> eVar) {
                return ((a) create(aVar, eVar)).invokeSuspend(v.f5542a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                C0428b.e();
                if (this.f15460a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                V3.o.b(obj);
                ((O.a) this.f15461b).i(O.f.f("local_" + this.f15462c), this.f15463d);
                return v.f5542a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        E(String str, String str2, Context context, Z3.e<? super E> eVar) {
            super(2, eVar);
            this.f15457b = str;
            this.f15458c = str2;
            this.f15459d = context;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            return new E(this.f15457b, this.f15458c, this.f15459d, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objE = C0428b.e();
            int i5 = this.f15456a;
            try {
                if (i5 == 0) {
                    V3.o.b(obj);
                    PolicySdkLogUtils.Companion.d("saveLocalCategoryMd5", "the " + this.f15457b + " save local md5 is " + this.f15458c);
                    String str = this.f15458c;
                    if (str != null && str.length() != 0) {
                        L.f fVarG = d.g(this.f15459d);
                        a aVar = new a(this.f15457b, this.f15458c, null);
                        this.f15456a = 1;
                        if (O.g.a(fVarG, aVar, this) == objE) {
                            return objE;
                        }
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    V3.o.b(obj);
                }
            } catch (Exception e6) {
                PolicySdkLogUtils.Companion.e("saveLocalCategoryMd5", "error =" + e6 + ' ');
            }
            return v.f5542a;
        }

        @Override // i4.p
        public final Object invoke(s4.I i5, Z3.e<? super v> eVar) {
            return ((E) create(i5, eVar)).invokeSuspend(v.f5542a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {345, 349}, m = "savePolicyOperate")
    static final class F extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a, reason: collision with root package name */
        Object f15464a;

        /* renamed from: b, reason: collision with root package name */
        Object f15465b;

        /* renamed from: c, reason: collision with root package name */
        boolean f15466c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f15467d;

        /* renamed from: f, reason: collision with root package name */
        int f15469f;

        F(Z3.e<? super F> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f15467d = obj;
            this.f15469f |= Integer.MIN_VALUE;
            return PolicyManager.this.savePolicyOperate(null, false, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$savePolicyOperate$2", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
    static final class G extends kotlin.coroutines.jvm.internal.l implements i4.p<O.a, Z3.e<? super v>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f15470a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f15471b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f15472c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        G(boolean z5, Z3.e<? super G> eVar) {
            super(2, eVar);
            this.f15472c = z5;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            G g5 = new G(this.f15472c, eVar);
            g5.f15471b = obj;
            return g5;
        }

        @Override // i4.p
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public final Object invoke(O.a aVar, Z3.e<? super v> eVar) {
            return ((G) create(aVar, eVar)).invokeSuspend(v.f5542a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            C0428b.e();
            if (this.f15470a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            V3.o.b(obj);
            ((O.a) this.f15471b).i(d.e(), kotlin.coroutines.jvm.internal.b.a(this.f15472c));
            return v.f5542a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$savePolicyOperate$3", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
    static final class H extends kotlin.coroutines.jvm.internal.l implements i4.p<O.a, Z3.e<? super v>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f15473a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f15474b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15475c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        H(String str, Z3.e<? super H> eVar) {
            super(2, eVar);
            this.f15475c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            H h5 = new H(this.f15475c, eVar);
            h5.f15474b = obj;
            return h5;
        }

        @Override // i4.p
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public final Object invoke(O.a aVar, Z3.e<? super v> eVar) {
            return ((H) create(aVar, eVar)).invokeSuspend(v.f5542a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            C0428b.e();
            if (this.f15473a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            V3.o.b(obj);
            O.a aVar = (O.a) this.f15474b;
            d.a<String> aVarF = d.f();
            String str = this.f15475c;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            aVar.i(aVarF, str);
            return v.f5542a;
        }
    }

    public static final class I implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f15476a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener f15477b;

        I(Context context, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
            this.f15476a = context;
            this.f15477b = onPermissionClickListener;
        }

        @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
        public void onPermissionClick(DialogInterface dialogInterface, boolean z5, boolean z6) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            if (z6) {
                SocketHookUtil.recoveryPlatform();
                PolicyManager.INSTANCE.saveAgreeStatus(this.f15476a, 1);
            }
            this.f15477b.onPermissionClick(dialogInterface, z5, z6);
        }
    }

    public static final class J implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f15478a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15479b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15480c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15481d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String[] f15482e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f15483f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener f15484g;

        J(Context context, String str, String str2, String str3, String[] strArr, String str4, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
            this.f15478a = context;
            this.f15479b = str;
            this.f15480c = str2;
            this.f15481d = str3;
            this.f15482e = strArr;
            this.f15483f = str4;
            this.f15484g = onPermissionClickListener;
        }

        @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
        public void onPermissionClick(DialogInterface dialogInterface, boolean z5, boolean z6) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            String str = z6 ? "2" : "0";
            if (z6) {
                SocketHookUtil.recoveryPlatform();
                PolicyManager.INSTANCE.saveAgreeStatus(this.f15478a, 1);
                PolicyManager.autoUploadRecord(this.f15478a, this.f15479b, this.f15480c, this.f15481d, this.f15482e, this.f15483f, str);
            }
            this.f15484g.onPermissionClick(dialogInterface, z5, z6);
        }
    }

    public static final class K implements PolicyPermissionDialogBuilder.OnPermissionClickListener {
        K() {
        }
    }

    public static final class L implements PolicyPermissionDialogBuilder.OnThreeButtonClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f15485a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15486b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15487c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15488d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String[] f15489e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f15490f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener f15491g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ r.h f15492h;

        L(Context context, String str, String str2, String str3, String[] strArr, String str4, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener, r.h hVar) {
            this.f15485a = context;
            this.f15486b = str;
            this.f15487c = str2;
            this.f15488d = str3;
            this.f15489e = strArr;
            this.f15490f = str4;
            this.f15491g = onPermissionClickListener;
            this.f15492h = hVar;
        }

        @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnThreeButtonClickListener
        public void onBasicOnlyClick(DialogInterface dialogInterface, boolean z5) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            SocketHookUtil.recoveryPlatform();
            PolicyManager.INSTANCE.saveAgreeStatus(this.f15485a, 1);
            PolicyManager.autoUploadRecord(this.f15485a, this.f15486b, this.f15487c, this.f15488d, this.f15489e, this.f15490f, "1");
            this.f15492h.onPermissionClick(dialogInterface, z5, true);
        }

        @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnThreeButtonClickListener
        public void onFullAgreeClick(DialogInterface dialogInterface, boolean z5, Map<String, Boolean> map) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            SocketHookUtil.recoveryPlatform();
            PolicyManager.INSTANCE.saveAgreeStatus(this.f15485a, 1);
            PolicyManager.autoUploadRecord(this.f15485a, this.f15486b, this.f15487c, this.f15488d, this.f15489e, this.f15490f, "2");
            this.f15491g.onPermissionClick(dialogInterface, z5, true);
        }

        @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnThreeButtonClickListener
        public void onRejectClick(DialogInterface dialogInterface, boolean z5) {
            this.f15492h.onPermissionClick(dialogInterface, z5, false);
        }
    }

    public static final class M implements r.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f15493a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f15494b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ r.h f15495c;

        M(String str, Context context, r.h hVar) {
            this.f15493a = str;
            this.f15494b = context;
            this.f15495c = hVar;
        }

        @Override // stepos.support.v7.app.r.h
        public void onPermissionClick(DialogInterface dialogInterface, boolean z5, boolean z6) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            if (z6 && j4.k.b(this.f15493a, "2")) {
                SocketHookUtil.recoveryPlatform();
                PolicyManager.INSTANCE.saveAgreeStatus(this.f15494b, 1);
            }
            this.f15495c.onPermissionClick(dialogInterface, z5, z6);
        }
    }

    public static final class N implements r.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f15496a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15497b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15498c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15499d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String[] f15500e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f15501f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ r.h f15502g;

        N(Context context, String str, String str2, String str3, String[] strArr, String str4, r.h hVar) {
            this.f15496a = context;
            this.f15497b = str;
            this.f15498c = str2;
            this.f15499d = str3;
            this.f15500e = strArr;
            this.f15501f = str4;
            this.f15502g = hVar;
        }

        @Override // stepos.support.v7.app.r.h
        public void onPermissionClick(DialogInterface dialogInterface, boolean z5, boolean z6) {
            String str = z6 ? "2" : "0";
            if (z6) {
                PolicyManager.autoUploadRecord(this.f15496a, this.f15497b, this.f15498c, this.f15499d, this.f15500e, this.f15501f, str);
            }
            this.f15502g.onPermissionClick(dialogInterface, z5, z6);
        }
    }

    public static final class O implements r.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f15503a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f15504b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15505c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15506d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f15507e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String[] f15508f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f15509g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ r.h f15510h;

        O(String str, Context context, String str2, String str3, String str4, String[] strArr, String str5, r.h hVar) {
            this.f15503a = str;
            this.f15504b = context;
            this.f15505c = str2;
            this.f15506d = str3;
            this.f15507e = str4;
            this.f15508f = strArr;
            this.f15509g = str5;
            this.f15510h = hVar;
        }

        @Override // stepos.support.v7.app.r.h
        public void onPermissionClick(DialogInterface dialogInterface, boolean z5, boolean z6) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            if (z6) {
                if (j4.k.b(this.f15503a, "1")) {
                    SocketHookUtil.recoveryPlatform();
                    PolicyManager.INSTANCE.saveAgreeStatus(this.f15504b, 1);
                }
                PolicyManager.autoUploadRecord(this.f15504b, this.f15505c, this.f15506d, this.f15507e, this.f15508f, this.f15509g, this.f15503a);
            }
            this.f15510h.onPermissionClick(dialogInterface, z5, z6);
        }
    }

    public static final class P implements r.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f15511a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f15512b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15513c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15514d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f15515e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String[] f15516f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f15517g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ r.h f15518h;

        P(boolean z5, Context context, String str, String str2, String str3, String[] strArr, String str4, r.h hVar) {
            this.f15511a = z5;
            this.f15512b = context;
            this.f15513c = str;
            this.f15514d = str2;
            this.f15515e = str3;
            this.f15516f = strArr;
            this.f15517g = str4;
            this.f15518h = hVar;
        }

        @Override // stepos.support.v7.app.r.h
        public void onPermissionClick(DialogInterface dialogInterface, boolean z5, boolean z6) {
            if (z6 && this.f15511a) {
                PolicyManager.autoUploadRecord(this.f15512b, this.f15513c, this.f15514d, this.f15515e, this.f15516f, this.f15517g, "2");
            }
            this.f15518h.onPermissionClick(dialogInterface, z5, z6);
        }
    }

    public static final class Q implements r.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f15519a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15520b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15521c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15522d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String[] f15523e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f15524f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ r.h f15525g;

        Q(Context context, String str, String str2, String str3, String[] strArr, String str4, r.h hVar) {
            this.f15519a = context;
            this.f15520b = str;
            this.f15521c = str2;
            this.f15522d = str3;
            this.f15523e = strArr;
            this.f15524f = str4;
            this.f15525g = hVar;
        }

        @Override // stepos.support.v7.app.r.h
        public void onPermissionClick(DialogInterface dialogInterface, boolean z5, boolean z6) {
            String str = z6 ? "2" : "0";
            if (z6) {
                PolicyManager.autoUploadRecord(this.f15519a, this.f15520b, this.f15521c, this.f15522d, this.f15523e, this.f15524f, str);
            }
            this.f15525g.onPermissionClick(dialogInterface, z5, z6);
        }
    }

    public static final class R implements r.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f15526a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15527b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15528c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15529d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String[] f15530e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f15531f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ r.h f15532g;

        R(Context context, String str, String str2, String str3, String[] strArr, String str4, r.h hVar) {
            this.f15526a = context;
            this.f15527b = str;
            this.f15528c = str2;
            this.f15529d = str3;
            this.f15530e = strArr;
            this.f15531f = str4;
            this.f15532g = hVar;
        }

        @Override // stepos.support.v7.app.r.h
        public void onPermissionClick(DialogInterface dialogInterface, boolean z5, boolean z6) {
            String str = z6 ? "2" : "0";
            if (z6) {
                PolicyManager.autoUploadRecord(this.f15526a, this.f15527b, this.f15528c, this.f15529d, this.f15530e, this.f15531f, str);
            }
            this.f15532g.onPermissionClick(dialogInterface, z5, z6);
        }
    }

    public static final class S implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j4.v<stepos.support.v7.app.c> f15533a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener f15534b;

        S(j4.v<stepos.support.v7.app.c> vVar, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
            this.f15533a = vVar;
            this.f15534b = onPermissionClickListener;
        }

        @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
        public void onPermissionClick(DialogInterface dialogInterface, boolean z5, boolean z6) {
            try {
                stepos.support.v7.app.c cVar = this.f15533a.f17836a;
                View viewFindViewById = cVar != null ? cVar.findViewById(q.stepos_permission_dialog_checkbox_first) : null;
                j4.k.e(viewFindViewById, "null cannot be cast to non-null type android.widget.CheckBox");
                this.f15534b.onPermissionClick(dialogInterface, ((CheckBox) viewFindViewById).isChecked(), z6);
            } catch (Exception unused) {
            }
        }
    }

    public static final class T implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j4.v<stepos.support.v7.app.c> f15535a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener f15536b;

        T(j4.v<stepos.support.v7.app.c> vVar, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
            this.f15535a = vVar;
            this.f15536b = onPermissionClickListener;
        }

        @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
        public void onPermissionClick(DialogInterface dialogInterface, boolean z5, boolean z6) {
            try {
                stepos.support.v7.app.c cVar = this.f15535a.f17836a;
                View viewFindViewById = cVar != null ? cVar.findViewById(q.stepos_permission_dialog_checkbox_first) : null;
                j4.k.e(viewFindViewById, "null cannot be cast to non-null type android.widget.CheckBox");
                boolean zIsChecked = ((CheckBox) viewFindViewById).isChecked();
                stepos.support.v7.app.c cVar2 = this.f15535a.f17836a;
                View viewFindViewById2 = cVar2 != null ? cVar2.findViewById(q.stepos_permission_dialog_checkbox_second) : null;
                j4.k.e(viewFindViewById2, "null cannot be cast to non-null type android.widget.CheckBox");
                this.f15536b.onPermissionClick(dialogInterface, z6, zIsChecked, ((CheckBox) viewFindViewById2).isChecked());
            } catch (Exception unused) {
            }
        }
    }

    public static final class U extends Z3.a implements InterfaceC1057F {
        public U(InterfaceC1057F.a aVar) {
            super(aVar);
        }

        @Override // s4.InterfaceC1057F
        public void v(Z3.i iVar, Throwable th) {
            PolicySdkLogUtils.Companion.d("exceptionHandler", iVar.a(C1059H.f20302b) + " 处理异常 ：" + th);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$uploadPolicyOperateRecord$1", f = "PolicyManager.kt", l = {504, 513}, m = "invokeSuspend")
    static final class V extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super v>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f15537a;

        /* renamed from: b, reason: collision with root package name */
        int f15538b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15539c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15540d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ InterfaceC0772l<PolicySdkResultBean, v> f15541e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ PolicyRecordRequest f15542f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f15543g;

        @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$uploadPolicyOperateRecord$1$response$1", f = "PolicyManager.kt", l = {514}, m = "invokeSuspend")
        static final class a extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super R4.t<PolicyOperateRecordResponse>>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f15544a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f15545b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ j4.v<String> f15546c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ u f15547d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ PolicyRecordRequest f15548e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f15549f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, j4.v<String> vVar, u uVar, PolicyRecordRequest policyRecordRequest, String str2, Z3.e<? super a> eVar) {
                super(2, eVar);
                this.f15545b = str;
                this.f15546c = vVar;
                this.f15547d = uVar;
                this.f15548e = policyRecordRequest;
                this.f15549f = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
                return new a(this.f15545b, this.f15546c, this.f15547d, this.f15548e, this.f15549f, eVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objE = C0428b.e();
                int i5 = this.f15544a;
                if (i5 != 0) {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    V3.o.b(obj);
                    return obj;
                }
                V3.o.b(obj);
                PolicyApiService policyApiService = new PolicyApiService(PolicySdkRetrofitHelper.INSTANCE.getApiService());
                String str = this.f15545b;
                String str2 = this.f15546c.f17836a;
                long j5 = this.f15547d.f17835a;
                PolicyRecordRequest policyRecordRequest = this.f15548e;
                PolicyManager policyManager = PolicyManager.INSTANCE;
                String brand = policyManager.getBrand();
                String model = policyManager.getModel();
                String osVersion = policyManager.getOsVersion();
                String str3 = this.f15549f;
                this.f15544a = 1;
                Object objUploadOperateRecordUsingPOST = policyApiService.uploadOperateRecordUsingPOST(str, str2, j5, policyRecordRequest, brand, model, osVersion, str3, this);
                return objUploadOperateRecordUsingPOST == objE ? objE : objUploadOperateRecordUsingPOST;
            }

            @Override // i4.p
            public final Object invoke(s4.I i5, Z3.e<? super R4.t<PolicyOperateRecordResponse>> eVar) {
                return ((a) create(i5, eVar)).invokeSuspend(v.f5542a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        V(String str, String str2, InterfaceC0772l<? super PolicySdkResultBean, v> interfaceC0772l, PolicyRecordRequest policyRecordRequest, String str3, Z3.e<? super V> eVar) {
            super(2, eVar);
            this.f15539c = str;
            this.f15540d = str2;
            this.f15541e = interfaceC0772l;
            this.f15542f = policyRecordRequest;
            this.f15543g = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            return new V(this.f15539c, this.f15540d, this.f15541e, this.f15542f, this.f15543g, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x00aa, code lost:
        
            if (r0 == r8) goto L27;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v2 */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instructions count: 362
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.V.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // i4.p
        public final Object invoke(s4.I i5, Z3.e<? super v> eVar) {
            return ((V) create(i5, eVar)).invokeSuspend(v.f5542a);
        }
    }

    static final class W extends j4.l implements InterfaceC0772l<PolicySdkResultBean, v> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0772l<PolicySdkResultBean, v> f15550a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        W(InterfaceC0772l<? super PolicySdkResultBean, v> interfaceC0772l) {
            super(1);
            this.f15550a = interfaceC0772l;
        }

        public final void b(PolicySdkResultBean policySdkResultBean) {
            j4.k.g(policySdkResultBean, "policySdkResultBean");
            PolicySdkLogUtils.Companion.d("uploadRecordToCleanServiceData", "policySdkResultBean.code " + policySdkResultBean.getCode());
            this.f15550a.invoke(policySdkResultBean);
        }

        @Override // i4.InterfaceC0772l
        public /* bridge */ /* synthetic */ v invoke(PolicySdkResultBean policySdkResultBean) {
            b(policySdkResultBean);
            return v.f5542a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$uploadRecordToCleanServiceData$1", f = "PolicyManager.kt", l = {1282}, m = "invokeSuspend")
    static final class X extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super v>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f15551a;

        /* renamed from: b, reason: collision with root package name */
        int f15552b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f15553c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String[] f15554d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f15555e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f15556f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f15557g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f15558h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f15559i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ ArrayList<DeleteInfoBean> f15560j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f15561k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ String f15562l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f15563m;

        /* renamed from: n, reason: collision with root package name */
        final /* synthetic */ InterfaceC0772l<PolicySdkResultBean, v> f15564n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        X(Context context, String[] strArr, String str, String str2, String str3, String str4, String str5, ArrayList<DeleteInfoBean> arrayList, String str6, String str7, String str8, InterfaceC0772l<? super PolicySdkResultBean, v> interfaceC0772l, Z3.e<? super X> eVar) {
            super(2, eVar);
            this.f15553c = context;
            this.f15554d = strArr;
            this.f15555e = str;
            this.f15556f = str2;
            this.f15557g = str3;
            this.f15558h = str4;
            this.f15559i = str5;
            this.f15560j = arrayList;
            this.f15561k = str6;
            this.f15562l = str7;
            this.f15563m = str8;
            this.f15564n = interfaceC0772l;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            return new X(this.f15553c, this.f15554d, this.f15555e, this.f15556f, this.f15557g, this.f15558h, this.f15559i, this.f15560j, this.f15561k, this.f15562l, this.f15563m, this.f15564n, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            PolicyRecordRequest policyRecordRequest;
            PolicyRecordRequest policyRecordRequest2;
            ArrayList<DeleteInfoBean> arrayList;
            Object objE = C0428b.e();
            int i5 = this.f15552b;
            if (i5 == 0) {
                V3.o.b(obj);
                PolicyRecordRequest policyRecordRequestCreateRecordRequest = PolicyManager.createRecordRequest(this.f15553c, this.f15554d, this.f15555e, this.f15556f);
                policyRecordRequestCreateRecordRequest.setVerify_type(this.f15557g);
                policyRecordRequestCreateRecordRequest.setServiceName(this.f15558h);
                policyRecordRequestCreateRecordRequest.setValidateCode(this.f15559i);
                if (!j4.k.b(this.f15557g, "0") && (arrayList = this.f15560j) != null && arrayList.size() > 0) {
                    policyRecordRequestCreateRecordRequest.setDeleteInfoList(this.f15560j);
                }
                if (!j4.k.b(this.f15557g, "1") && !j4.k.b(this.f15557g, "3")) {
                    policyRecordRequest2 = policyRecordRequestCreateRecordRequest;
                    PolicySdkLogUtils.Companion.d("uploadRecordToCleanServiceData", "verifyType " + this.f15557g + " | policyRecordRequest.deleteInfoList = " + policyRecordRequest2.getDeleteInfoList());
                    PolicyManager.uploadRecordByCustomRecordRequest(this.f15553c, this.f15561k, this.f15562l, this.f15563m, policyRecordRequest2, this.f15564n);
                    return v.f5542a;
                }
                PolicyManager policyManager = PolicyManager.INSTANCE;
                Context context = this.f15553c;
                d.a<String> aVarD = d.d();
                this.f15551a = policyRecordRequestCreateRecordRequest;
                this.f15552b = 1;
                Object dataStoreString = policyManager.getDataStoreString(context, aVarD, this);
                if (dataStoreString == objE) {
                    return objE;
                }
                policyRecordRequest = policyRecordRequestCreateRecordRequest;
                obj = dataStoreString;
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                policyRecordRequest = (PolicyRecordRequest) this.f15551a;
                V3.o.b(obj);
            }
            String str = (String) obj;
            if (str != null && !TextUtils.isEmpty(str)) {
                ArrayList<DeleteInfoBean> deleteInfoBeanByGson = PolicySdkToolsUtils.Companion.getDeleteInfoBeanByGson(str);
                PolicySdkLogUtils.Companion.d("uploadRecordToCleanServiceData", "commonDeleteInfoList = " + deleteInfoBeanByGson);
                policyRecordRequest.setDeleteInfoList(C0403n.W(C0403n.M(policyRecordRequest.getDeleteInfoList(), deleteInfoBeanByGson)));
            }
            policyRecordRequest2 = policyRecordRequest;
            PolicySdkLogUtils.Companion.d("uploadRecordToCleanServiceData", "verifyType " + this.f15557g + " | policyRecordRequest.deleteInfoList = " + policyRecordRequest2.getDeleteInfoList());
            PolicyManager.uploadRecordByCustomRecordRequest(this.f15553c, this.f15561k, this.f15562l, this.f15563m, policyRecordRequest2, this.f15564n);
            return v.f5542a;
        }

        @Override // i4.p
        public final Object invoke(s4.I i5, Z3.e<? super v> eVar) {
            return ((X) create(i5, eVar)).invokeSuspend(v.f5542a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$uploadRecordWithoutSecureService$1", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
    static final class Y extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super v>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f15565a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f15566b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String[] f15567c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15568d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f15569e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f15570f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f15571g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f15572h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ArrayList<DeleteInfoBean> f15573i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f15574j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f15575k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ String f15576l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ InterfaceC0772l<PolicySdkResultBean, v> f15577m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        Y(Context context, String[] strArr, String str, String str2, String str3, String str4, String str5, ArrayList<DeleteInfoBean> arrayList, String str6, String str7, String str8, InterfaceC0772l<? super PolicySdkResultBean, v> interfaceC0772l, Z3.e<? super Y> eVar) {
            super(2, eVar);
            this.f15566b = context;
            this.f15567c = strArr;
            this.f15568d = str;
            this.f15569e = str2;
            this.f15570f = str3;
            this.f15571g = str4;
            this.f15572h = str5;
            this.f15573i = arrayList;
            this.f15574j = str6;
            this.f15575k = str7;
            this.f15576l = str8;
            this.f15577m = interfaceC0772l;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            return new Y(this.f15566b, this.f15567c, this.f15568d, this.f15569e, this.f15570f, this.f15571g, this.f15572h, this.f15573i, this.f15574j, this.f15575k, this.f15576l, this.f15577m, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            ArrayList<DeleteInfoBean> arrayList;
            C0428b.e();
            if (this.f15565a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            V3.o.b(obj);
            PolicyRecordRequest policyRecordRequestCreateRecordRequest = PolicyManager.createRecordRequest(this.f15566b, this.f15567c, this.f15568d, this.f15569e);
            policyRecordRequestCreateRecordRequest.setVerify_type(this.f15570f);
            policyRecordRequestCreateRecordRequest.setServiceName(this.f15571g);
            policyRecordRequestCreateRecordRequest.setValidateCode(this.f15572h);
            if (!j4.k.b(this.f15570f, "0") && (arrayList = this.f15573i) != null && arrayList.size() > 0) {
                policyRecordRequestCreateRecordRequest.setDeleteInfoList(this.f15573i);
            }
            PolicySdkLogUtils.Companion.d("uploadRecordToCleanServiceData", "verifyType " + this.f15570f + " | policyRecordRequest.deleteInfoList = " + policyRecordRequestCreateRecordRequest.getDeleteInfoList());
            PolicyManager.uploadRecordByCustomRecordRequest(this.f15566b, this.f15574j, this.f15575k, this.f15576l, policyRecordRequestCreateRecordRequest, this.f15577m);
            return v.f5542a;
        }

        @Override // i4.p
        public final Object invoke(s4.I i5, Z3.e<? super v> eVar) {
            return ((Y) create(i5, eVar)).invokeSuspend(v.f5542a);
        }
    }

    /* renamed from: com.stepos.policy.sdk.PolicyManager$a, reason: case insensitive filesystem */
    static final class C0614a extends j4.l implements InterfaceC0772l<PolicySdkResultBean, v> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j4.v<PolicyRecordRequest> f15578a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f15579b;

        @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$autoUploadRecord$1$1", f = "PolicyManager.kt", l = {1343}, m = "invokeSuspend")
        /* renamed from: com.stepos.policy.sdk.PolicyManager$a$a, reason: collision with other inner class name */
        static final class C0189a extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super v>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f15580a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ PolicySdkResultBean f15581b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ j4.v<PolicyRecordRequest> f15582c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Context f15583d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0189a(PolicySdkResultBean policySdkResultBean, j4.v<PolicyRecordRequest> vVar, Context context, Z3.e<? super C0189a> eVar) {
                super(2, eVar);
                this.f15581b = policySdkResultBean;
                this.f15582c = vVar;
                this.f15583d = context;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
                return new C0189a(this.f15581b, this.f15582c, this.f15583d, eVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                String strR;
                boolean z5;
                Object objE = C0428b.e();
                int i5 = this.f15580a;
                if (i5 == 0) {
                    V3.o.b(obj);
                    PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                    companion.d("autoUploadRecord", "policySdkResultBean.code " + this.f15581b.getCode());
                    if (this.f15581b.getCode() == 0) {
                        strR = BuildConfig.FLAVOR;
                        z5 = true;
                    } else {
                        strR = new A1.e().r(this.f15582c.f17836a);
                        j4.k.f(strR, "gson.toJson(policyRecordRequest)");
                        z5 = false;
                    }
                    companion.d("autoUploadRecord", "isOperateSuccess " + z5);
                    PolicyManager policyManager = PolicyManager.INSTANCE;
                    Context context = this.f15583d;
                    this.f15580a = 1;
                    if (policyManager.savePolicyOperate(context, z5, strR, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    V3.o.b(obj);
                }
                return v.f5542a;
            }

            @Override // i4.p
            public final Object invoke(s4.I i5, Z3.e<? super v> eVar) {
                return ((C0189a) create(i5, eVar)).invokeSuspend(v.f5542a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0614a(j4.v<PolicyRecordRequest> vVar, Context context) {
            super(1);
            this.f15578a = vVar;
            this.f15579b = context;
        }

        public final void b(PolicySdkResultBean policySdkResultBean) {
            j4.k.g(policySdkResultBean, "policySdkResultBean");
            C1076i.b(C1073g0.f20349a, PolicyManager.INSTANCE.getExceptionHandler(), null, new C0189a(policySdkResultBean, this.f15578a, this.f15579b, null), 2, null);
        }

        @Override // i4.InterfaceC0772l
        public /* bridge */ /* synthetic */ v invoke(PolicySdkResultBean policySdkResultBean) {
            b(policySdkResultBean);
            return v.f5542a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$autoUploadRecord$2", f = "PolicyManager.kt", l = {1351}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$b, reason: case insensitive filesystem */
    static final class C0615b extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super v>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f15584a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ j4.v<PolicyRecordRequest> f15585b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f15586c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0615b(j4.v<PolicyRecordRequest> vVar, Context context, Z3.e<? super C0615b> eVar) {
            super(2, eVar);
            this.f15585b = vVar;
            this.f15586c = context;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            return new C0615b(this.f15585b, this.f15586c, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objE = C0428b.e();
            int i5 = this.f15584a;
            if (i5 == 0) {
                V3.o.b(obj);
                String strR = new A1.e().r(this.f15585b.f17836a);
                PolicyManager policyManager = PolicyManager.INSTANCE;
                Context context = this.f15586c;
                this.f15584a = 1;
                if (policyManager.savePolicyOperate(context, false, strR, this) == objE) {
                    return objE;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                V3.o.b(obj);
            }
            return v.f5542a;
        }

        @Override // i4.p
        public final Object invoke(s4.I i5, Z3.e<? super v> eVar) {
            return ((C0615b) create(i5, eVar)).invokeSuspend(v.f5542a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {181}, m = "awaitSyncLocalFileFinished")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$c, reason: case insensitive filesystem */
    static final class C0616c extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a, reason: collision with root package name */
        long f15587a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f15588b;

        /* renamed from: d, reason: collision with root package name */
        int f15590d;

        C0616c(Z3.e<? super C0616c> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f15588b = obj;
            this.f15590d |= Integer.MIN_VALUE;
            return PolicyManager.this.awaitSyncLocalFileFinished(this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$checkNewestPolicy$1", f = "PolicyManager.kt", l = {1547, 1597, 1610}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$d, reason: case insensitive filesystem */
    static final class C0617d extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super v>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f15591a;

        /* renamed from: b, reason: collision with root package name */
        Object f15592b;

        /* renamed from: c, reason: collision with root package name */
        Object f15593c;

        /* renamed from: d, reason: collision with root package name */
        Object f15594d;

        /* renamed from: e, reason: collision with root package name */
        int f15595e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f15596f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f15597g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f15598h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f15599i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f15600j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f15601k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ String f15602l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ InterfaceC0772l<PolicySdkResultBean, v> f15603m;

        @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$checkNewestPolicy$1$response$1", f = "PolicyManager.kt", l = {1611}, m = "invokeSuspend")
        /* renamed from: com.stepos.policy.sdk.PolicyManager$d$a */
        static final class a extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super R4.t<PolicyNewestResponse>>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f15604a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f15605b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ j4.v<String> f15606c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f15607d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ u f15608e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f15609f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ j4.v<Long> f15610g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f15611h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ j4.v<String> f15612i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, j4.v<String> vVar, String str2, u uVar, String str3, j4.v<Long> vVar2, String str4, j4.v<String> vVar3, Z3.e<? super a> eVar) {
                super(2, eVar);
                this.f15605b = str;
                this.f15606c = vVar;
                this.f15607d = str2;
                this.f15608e = uVar;
                this.f15609f = str3;
                this.f15610g = vVar2;
                this.f15611h = str4;
                this.f15612i = vVar3;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
                return new a(this.f15605b, this.f15606c, this.f15607d, this.f15608e, this.f15609f, this.f15610g, this.f15611h, this.f15612i, eVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objE = C0428b.e();
                int i5 = this.f15604a;
                if (i5 != 0) {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    V3.o.b(obj);
                    return obj;
                }
                V3.o.b(obj);
                PolicyApiService policyApiService = new PolicyApiService(PolicySdkRetrofitHelper.INSTANCE.getApiService());
                String str = this.f15605b;
                String str2 = this.f15606c.f17836a;
                String str3 = this.f15607d;
                long j5 = this.f15608e.f17835a;
                String str4 = this.f15609f;
                long jLongValue = this.f15610g.f17836a.longValue();
                PolicyManager policyManager = PolicyManager.INSTANCE;
                String brand = policyManager.getBrand();
                String model = policyManager.getModel();
                String osVersion = policyManager.getOsVersion();
                String str5 = this.f15611h;
                String str6 = this.f15612i.f17836a;
                this.f15604a = 1;
                Object policyUsingGET = policyApiService.getPolicyUsingGET(str, str2, str3, j5, str4, jLongValue, brand, model, osVersion, str5, str6, this);
                return policyUsingGET == objE ? objE : policyUsingGET;
            }

            @Override // i4.p
            public final Object invoke(s4.I i5, Z3.e<? super R4.t<PolicyNewestResponse>> eVar) {
                return ((a) create(i5, eVar)).invokeSuspend(v.f5542a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C0617d(Context context, String str, String str2, boolean z5, String str3, String str4, String str5, InterfaceC0772l<? super PolicySdkResultBean, v> interfaceC0772l, Z3.e<? super C0617d> eVar) {
            super(2, eVar);
            this.f15596f = context;
            this.f15597g = str;
            this.f15598h = str2;
            this.f15599i = z5;
            this.f15600j = str3;
            this.f15601k = str4;
            this.f15602l = str5;
            this.f15603m = interfaceC0772l;
        }

        private static final void i(j4.v<PolicySdkResultBean> vVar, InterfaceC0772l<? super PolicySdkResultBean, v> interfaceC0772l, String str, String str2) {
            PolicySdkLogUtils.Companion.logCheckNewestResult(vVar.f17836a, str, str2);
            interfaceC0772l.invoke(vVar.f17836a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            return new C0617d(this.f15596f, this.f15597g, this.f15598h, this.f15599i, this.f15600j, this.f15601k, this.f15602l, this.f15603m, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:52:0x01a3, code lost:
        
            if (r0 == r6) goto L53;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0103  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0134  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0147  */
        /* JADX WARN: Type inference failed for: r0v19, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v3, types: [T, com.stepos.policy.sdk.bean.PolicySdkResultBean] */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r36) {
            /*
                Method dump skipped, instructions count: 1229
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C0617d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // i4.p
        public final Object invoke(s4.I i5, Z3.e<? super v> eVar) {
            return ((C0617d) create(i5, eVar)).invokeSuspend(v.f5542a);
        }
    }

    /* renamed from: com.stepos.policy.sdk.PolicyManager$e, reason: case insensitive filesystem */
    static final class C0618e extends j4.l implements InterfaceC0772l<DeleteInfoBean, v> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList<DeleteInfoBean> f15613a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<CustomDeleteInfoBean> f15614b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ InterfaceC0772l<ArrayList<DeleteInfoBean>, v> f15615c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C0618e(ArrayList<DeleteInfoBean> arrayList, ArrayList<CustomDeleteInfoBean> arrayList2, InterfaceC0772l<? super ArrayList<DeleteInfoBean>, v> interfaceC0772l) {
            super(1);
            this.f15613a = arrayList;
            this.f15614b = arrayList2;
            this.f15615c = interfaceC0772l;
        }

        public final void b(DeleteInfoBean deleteInfoBean) {
            j4.k.g(deleteInfoBean, "deleteInfoBean");
            PolicyManager policyManager = PolicyManager.INSTANCE;
            ArrayList<DeleteInfoBean> arrayList = this.f15613a;
            ArrayList<CustomDeleteInfoBean> arrayList2 = this.f15614b;
            InterfaceC0772l<ArrayList<DeleteInfoBean>, v> interfaceC0772l = this.f15615c;
            arrayList.add(deleteInfoBean);
            if (arrayList.size() == arrayList2.size()) {
                interfaceC0772l.invoke(arrayList);
            }
        }

        @Override // i4.InterfaceC0772l
        public /* bridge */ /* synthetic */ v invoke(DeleteInfoBean deleteInfoBean) {
            b(deleteInfoBean);
            return v.f5542a;
        }
    }

    /* renamed from: com.stepos.policy.sdk.PolicyManager$f, reason: case insensitive filesystem */
    static final class C0619f extends j4.l implements InterfaceC0772l<DeleteInfoBean, v> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList<DeleteInfoBean> f15616a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<DeleteInfoEncryptMultiBean> f15617b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ InterfaceC0772l<ArrayList<DeleteInfoBean>, v> f15618c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C0619f(ArrayList<DeleteInfoBean> arrayList, ArrayList<DeleteInfoEncryptMultiBean> arrayList2, InterfaceC0772l<? super ArrayList<DeleteInfoBean>, v> interfaceC0772l) {
            super(1);
            this.f15616a = arrayList;
            this.f15617b = arrayList2;
            this.f15618c = interfaceC0772l;
        }

        public final void b(DeleteInfoBean deleteInfoBean) {
            j4.k.g(deleteInfoBean, "deleteInfoBean");
            PolicyManager policyManager = PolicyManager.INSTANCE;
            ArrayList<DeleteInfoBean> arrayList = this.f15616a;
            ArrayList<DeleteInfoEncryptMultiBean> arrayList2 = this.f15617b;
            InterfaceC0772l<ArrayList<DeleteInfoBean>, v> interfaceC0772l = this.f15618c;
            arrayList.add(deleteInfoBean);
            if (arrayList.size() == arrayList2.size()) {
                interfaceC0772l.invoke(arrayList);
            }
        }

        @Override // i4.InterfaceC0772l
        public /* bridge */ /* synthetic */ v invoke(DeleteInfoBean deleteInfoBean) {
            b(deleteInfoBean);
            return v.f5542a;
        }
    }

    /* renamed from: com.stepos.policy.sdk.PolicyManager$g, reason: case insensitive filesystem */
    public static final class C0620g implements InterfaceC1193b<Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC1193b f15619a;

        /* renamed from: com.stepos.policy.sdk.PolicyManager$g$a */
        public static final class a<T> implements InterfaceC1194c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ InterfaceC1194c f15620a;

            @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$getAgreeStatus$$inlined$map$1$2", f = "PolicyManager.kt", l = {223}, m = "emit")
            /* renamed from: com.stepos.policy.sdk.PolicyManager$g$a$a, reason: collision with other inner class name */
            public static final class C0190a extends kotlin.coroutines.jvm.internal.d {

                /* renamed from: a, reason: collision with root package name */
                /* synthetic */ Object f15621a;

                /* renamed from: b, reason: collision with root package name */
                int f15622b;

                public C0190a(Z3.e eVar) {
                    super(eVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.f15621a = obj;
                    this.f15622b |= Integer.MIN_VALUE;
                    return a.this.g(null, this);
                }
            }

            public a(InterfaceC1194c interfaceC1194c) {
                this.f15620a = interfaceC1194c;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // v4.InterfaceC1194c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object g(java.lang.Object r5, Z3.e r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof com.stepos.policy.sdk.PolicyManager.C0620g.a.C0190a
                    if (r0 == 0) goto L13
                    r0 = r6
                    com.stepos.policy.sdk.PolicyManager$g$a$a r0 = (com.stepos.policy.sdk.PolicyManager.C0620g.a.C0190a) r0
                    int r1 = r0.f15622b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f15622b = r1
                    goto L18
                L13:
                    com.stepos.policy.sdk.PolicyManager$g$a$a r0 = new com.stepos.policy.sdk.PolicyManager$g$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f15621a
                    java.lang.Object r1 = a4.C0428b.e()
                    int r2 = r0.f15622b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    V3.o.b(r6)
                    goto L49
                L29:
                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                    java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                    r4.<init>(r5)
                    throw r4
                L31:
                    V3.o.b(r6)
                    v4.c r4 = r4.f15620a
                    O.d r5 = (O.d) r5
                    O.d$a r6 = com.stepos.policy.sdk.d.b()
                    java.lang.Object r5 = r5.b(r6)
                    r0.f15622b = r3
                    java.lang.Object r4 = r4.g(r5, r0)
                    if (r4 != r1) goto L49
                    return r1
                L49:
                    V3.v r4 = V3.v.f5542a
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C0620g.a.g(java.lang.Object, Z3.e):java.lang.Object");
            }
        }

        public C0620g(InterfaceC1193b interfaceC1193b) {
            this.f15619a = interfaceC1193b;
        }

        @Override // v4.InterfaceC1193b
        public Object a(InterfaceC1194c<? super Integer> interfaceC1194c, Z3.e eVar) {
            Object objA = this.f15619a.a(new a(interfaceC1194c), eVar);
            return objA == C0428b.e() ? objA : v.f5542a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {398}, m = "getAgreeStatus")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$h, reason: case insensitive filesystem */
    static final class C0621h extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f15624a;

        /* renamed from: c, reason: collision with root package name */
        int f15626c;

        C0621h(Z3.e<? super C0621h> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f15624a = obj;
            this.f15626c |= Integer.MIN_VALUE;
            return PolicyManager.this.getAgreeStatus(null, this);
        }
    }

    /* renamed from: com.stepos.policy.sdk.PolicyManager$i, reason: case insensitive filesystem */
    static final class C0622i extends j4.l implements InterfaceC0772l<String, v> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f15627a;

        @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$getCommonDeleteInfoList$1$1", f = "PolicyManager.kt", l = {2457}, m = "invokeSuspend")
        /* renamed from: com.stepos.policy.sdk.PolicyManager$i$a */
        static final class a extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super v>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f15628a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f15629b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Context f15630c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, Context context, Z3.e<? super a> eVar) {
                super(2, eVar);
                this.f15629b = str;
                this.f15630c = context;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
                return new a(this.f15629b, this.f15630c, eVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objE = C0428b.e();
                int i5 = this.f15628a;
                if (i5 == 0) {
                    V3.o.b(obj);
                    PolicySdkLogUtils.Companion.d("getCommonDeleteInfoList", "result = " + this.f15629b);
                    Context context = this.f15630c;
                    if (context != null) {
                        PolicyManager policyManager = PolicyManager.INSTANCE;
                        d.a<String> aVarD = d.d();
                        String str = this.f15629b;
                        this.f15628a = 1;
                        if (policyManager.saveDataStoreString(context, aVarD, str, this) == objE) {
                            return objE;
                        }
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    V3.o.b(obj);
                }
                return v.f5542a;
            }

            @Override // i4.p
            public final Object invoke(s4.I i5, Z3.e<? super v> eVar) {
                return ((a) create(i5, eVar)).invokeSuspend(v.f5542a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0622i(Context context) {
            super(1);
            this.f15627a = context;
        }

        @Override // i4.InterfaceC0772l
        public /* bridge */ /* synthetic */ v invoke(String str) {
            invoke2(str);
            return v.f5542a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            j4.k.g(str, "deleteInfoListJson");
            PolicyManager policyManager = PolicyManager.INSTANCE;
            C1076i.b(policyManager.getLifecycleScope(), policyManager.getExceptionHandler(), null, new a(str, this.f15627a, null), 2, null);
        }
    }

    /* renamed from: com.stepos.policy.sdk.PolicyManager$j, reason: case insensitive filesystem */
    public static final class C0623j implements InterfaceC1193b<String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC1193b f15631a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.a f15632b;

        /* renamed from: com.stepos.policy.sdk.PolicyManager$j$a */
        public static final class a<T> implements InterfaceC1194c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ InterfaceC1194c f15633a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ d.a f15634b;

            @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1$2", f = "PolicyManager.kt", l = {223}, m = "emit")
            /* renamed from: com.stepos.policy.sdk.PolicyManager$j$a$a, reason: collision with other inner class name */
            public static final class C0191a extends kotlin.coroutines.jvm.internal.d {

                /* renamed from: a, reason: collision with root package name */
                /* synthetic */ Object f15635a;

                /* renamed from: b, reason: collision with root package name */
                int f15636b;

                public C0191a(Z3.e eVar) {
                    super(eVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.f15635a = obj;
                    this.f15636b |= Integer.MIN_VALUE;
                    return a.this.g(null, this);
                }
            }

            public a(InterfaceC1194c interfaceC1194c, d.a aVar) {
                this.f15633a = interfaceC1194c;
                this.f15634b = aVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // v4.InterfaceC1194c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object g(java.lang.Object r5, Z3.e r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof com.stepos.policy.sdk.PolicyManager.C0623j.a.C0191a
                    if (r0 == 0) goto L13
                    r0 = r6
                    com.stepos.policy.sdk.PolicyManager$j$a$a r0 = (com.stepos.policy.sdk.PolicyManager.C0623j.a.C0191a) r0
                    int r1 = r0.f15636b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f15636b = r1
                    goto L18
                L13:
                    com.stepos.policy.sdk.PolicyManager$j$a$a r0 = new com.stepos.policy.sdk.PolicyManager$j$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f15635a
                    java.lang.Object r1 = a4.C0428b.e()
                    int r2 = r0.f15636b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    V3.o.b(r6)
                    goto L47
                L29:
                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                    java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                    r4.<init>(r5)
                    throw r4
                L31:
                    V3.o.b(r6)
                    v4.c r6 = r4.f15633a
                    O.d r5 = (O.d) r5
                    O.d$a r4 = r4.f15634b
                    java.lang.Object r4 = r5.b(r4)
                    r0.f15636b = r3
                    java.lang.Object r4 = r6.g(r4, r0)
                    if (r4 != r1) goto L47
                    return r1
                L47:
                    V3.v r4 = V3.v.f5542a
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C0623j.a.g(java.lang.Object, Z3.e):java.lang.Object");
            }
        }

        public C0623j(InterfaceC1193b interfaceC1193b, d.a aVar) {
            this.f15631a = interfaceC1193b;
            this.f15632b = aVar;
        }

        @Override // v4.InterfaceC1193b
        public Object a(InterfaceC1194c<? super String> interfaceC1194c, Z3.e eVar) {
            Object objA = this.f15631a.a(new a(interfaceC1194c, this.f15632b), eVar);
            return objA == C0428b.e() ? objA : v.f5542a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1", f = "PolicyManager.kt", l = {2602}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$k, reason: case insensitive filesystem */
    static final class C0624k extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super String>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f15638a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f15639b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15640c;

        /* renamed from: com.stepos.policy.sdk.PolicyManager$k$a */
        public static final class a implements InterfaceC1193b<String> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ InterfaceC1193b f15641a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f15642b;

            /* renamed from: com.stepos.policy.sdk.PolicyManager$k$a$a, reason: collision with other inner class name */
            public static final class C0192a<T> implements InterfaceC1194c {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ InterfaceC1194c f15643a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ String f15644b;

                @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1$2", f = "PolicyManager.kt", l = {223}, m = "emit")
                /* renamed from: com.stepos.policy.sdk.PolicyManager$k$a$a$a, reason: collision with other inner class name */
                public static final class C0193a extends kotlin.coroutines.jvm.internal.d {

                    /* renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f15645a;

                    /* renamed from: b, reason: collision with root package name */
                    int f15646b;

                    public C0193a(Z3.e eVar) {
                        super(eVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    public final Object invokeSuspend(Object obj) {
                        this.f15645a = obj;
                        this.f15646b |= Integer.MIN_VALUE;
                        return C0192a.this.g(null, this);
                    }
                }

                public C0192a(InterfaceC1194c interfaceC1194c, String str) {
                    this.f15643a = interfaceC1194c;
                    this.f15644b = str;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // v4.InterfaceC1194c
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object g(java.lang.Object r6, Z3.e r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof com.stepos.policy.sdk.PolicyManager.C0624k.a.C0192a.C0193a
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.stepos.policy.sdk.PolicyManager$k$a$a$a r0 = (com.stepos.policy.sdk.PolicyManager.C0624k.a.C0192a.C0193a) r0
                        int r1 = r0.f15646b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f15646b = r1
                        goto L18
                    L13:
                        com.stepos.policy.sdk.PolicyManager$k$a$a$a r0 = new com.stepos.policy.sdk.PolicyManager$k$a$a$a
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.f15645a
                        java.lang.Object r1 = a4.C0428b.e()
                        int r2 = r0.f15646b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        V3.o.b(r7)
                        goto L5c
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        V3.o.b(r7)
                        v4.c r7 = r5.f15643a
                        O.d r6 = (O.d) r6
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        r2.<init>()
                        java.lang.String r4 = "local_"
                        r2.append(r4)
                        java.lang.String r5 = r5.f15644b
                        r2.append(r5)
                        java.lang.String r5 = r2.toString()
                        O.d$a r5 = O.f.f(r5)
                        java.lang.Object r5 = r6.b(r5)
                        r0.f15646b = r3
                        java.lang.Object r5 = r7.g(r5, r0)
                        if (r5 != r1) goto L5c
                        return r1
                    L5c:
                        V3.v r5 = V3.v.f5542a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C0624k.a.C0192a.g(java.lang.Object, Z3.e):java.lang.Object");
                }
            }

            public a(InterfaceC1193b interfaceC1193b, String str) {
                this.f15641a = interfaceC1193b;
                this.f15642b = str;
            }

            @Override // v4.InterfaceC1193b
            public Object a(InterfaceC1194c<? super String> interfaceC1194c, Z3.e eVar) {
                Object objA = this.f15641a.a(new C0192a(interfaceC1194c, this.f15642b), eVar);
                return objA == C0428b.e() ? objA : v.f5542a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0624k(Context context, String str, Z3.e<? super C0624k> eVar) {
            super(2, eVar);
            this.f15639b = context;
            this.f15640c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            return new C0624k(this.f15639b, this.f15640c, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objE = C0428b.e();
            int i5 = this.f15638a;
            if (i5 == 0) {
                V3.o.b(obj);
                a aVar = new a(d.g(this.f15639b).a(), this.f15640c);
                this.f15638a = 1;
                obj = v4.d.d(aVar, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                V3.o.b(obj);
            }
            String strValueOf = String.valueOf(obj);
            return j4.k.b(strValueOf, "null") ? BuildConfig.FLAVOR : strValueOf;
        }

        @Override // i4.p
        public final Object invoke(s4.I i5, Z3.e<? super String> eVar) {
            return ((C0624k) create(i5, eVar)).invokeSuspend(v.f5542a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$getPolicyByVersion$1", f = "PolicyManager.kt", l = {2325, 2335}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$l, reason: case insensitive filesystem */
    static final class C0625l extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super v>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f15648a;

        /* renamed from: b, reason: collision with root package name */
        int f15649b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Long f15650c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15651d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f15652e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f15653f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ InterfaceC0772l<PolicySdkResultBean, PolicySdkResultBean> f15654g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f15655h;

        @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$getPolicyByVersion$1$response$1", f = "PolicyManager.kt", l = {2337}, m = "invokeSuspend")
        /* renamed from: com.stepos.policy.sdk.PolicyManager$l$a */
        static final class a extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super R4.t<PolicyVersionResponse>>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f15656a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f15657b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ j4.v<String> f15658c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ u f15659d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f15660e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Long f15661f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f15662g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, j4.v<String> vVar, u uVar, String str2, Long l5, String str3, Z3.e<? super a> eVar) {
                super(2, eVar);
                this.f15657b = str;
                this.f15658c = vVar;
                this.f15659d = uVar;
                this.f15660e = str2;
                this.f15661f = l5;
                this.f15662g = str3;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
                return new a(this.f15657b, this.f15658c, this.f15659d, this.f15660e, this.f15661f, this.f15662g, eVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objE = C0428b.e();
                int i5 = this.f15656a;
                if (i5 != 0) {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    V3.o.b(obj);
                    return obj;
                }
                V3.o.b(obj);
                PolicySdkLogUtils.Companion.d("PolicyManager", "getPolicyUsingGET");
                PolicyApiService policyApiService = new PolicyApiService(PolicySdkRetrofitHelper.INSTANCE.getApiService());
                String str = this.f15657b;
                String str2 = this.f15658c.f17836a;
                long j5 = this.f15659d.f17835a;
                String str3 = this.f15660e;
                long jLongValue = this.f15661f.longValue();
                PolicyManager policyManager = PolicyManager.INSTANCE;
                String brand = policyManager.getBrand();
                String model = policyManager.getModel();
                String osVersion = policyManager.getOsVersion();
                String str4 = this.f15662g;
                this.f15656a = 1;
                Object objPolicyVersionInfoUsingGET = policyApiService.policyVersionInfoUsingGET(str, str2, j5, str3, jLongValue, brand, model, osVersion, str4, this);
                return objPolicyVersionInfoUsingGET == objE ? objE : objPolicyVersionInfoUsingGET;
            }

            @Override // i4.p
            public final Object invoke(s4.I i5, Z3.e<? super R4.t<PolicyVersionResponse>> eVar) {
                return ((a) create(i5, eVar)).invokeSuspend(v.f5542a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C0625l(Long l5, String str, String str2, String str3, InterfaceC0772l<? super PolicySdkResultBean, PolicySdkResultBean> interfaceC0772l, String str4, Z3.e<? super C0625l> eVar) {
            super(2, eVar);
            this.f15650c = l5;
            this.f15651d = str;
            this.f15652e = str2;
            this.f15653f = str3;
            this.f15654g = interfaceC0772l;
            this.f15655h = str4;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            return new C0625l(this.f15650c, this.f15651d, this.f15652e, this.f15653f, this.f15654g, this.f15655h, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00b6, code lost:
        
            if (r0 == r8) goto L30;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v28, types: [T, com.stepos.policy.sdk.bean.PolicyVersionResponse] */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r23) {
            /*
                Method dump skipped, instructions count: 399
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C0625l.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // i4.p
        public final Object invoke(s4.I i5, Z3.e<? super v> eVar) {
            return ((C0625l) create(i5, eVar)).invokeSuspend(v.f5542a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$getPolicyData$1", f = "PolicyManager.kt", l = {2139, 2148}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$m, reason: case insensitive filesystem */
    static final class C0626m extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super v>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f15663a;

        /* renamed from: b, reason: collision with root package name */
        int f15664b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15665c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Long f15666d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f15667e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f15668f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f15669g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ InterfaceC0772l<PolicySdkResultBean, v> f15670h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f15671i;

        @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$getPolicyData$1$response$1", f = "PolicyManager.kt", l = {2150}, m = "invokeSuspend")
        /* renamed from: com.stepos.policy.sdk.PolicyManager$m$a */
        static final class a extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super R4.t<PolicyNewestResponse>>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f15672a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f15673b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ j4.v<String> f15674c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f15675d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ u f15676e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f15677f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ Long f15678g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f15679h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, j4.v<String> vVar, String str2, u uVar, String str3, Long l5, String str4, Z3.e<? super a> eVar) {
                super(2, eVar);
                this.f15673b = str;
                this.f15674c = vVar;
                this.f15675d = str2;
                this.f15676e = uVar;
                this.f15677f = str3;
                this.f15678g = l5;
                this.f15679h = str4;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
                return new a(this.f15673b, this.f15674c, this.f15675d, this.f15676e, this.f15677f, this.f15678g, this.f15679h, eVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objE = C0428b.e();
                int i5 = this.f15672a;
                if (i5 != 0) {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    V3.o.b(obj);
                    return obj;
                }
                V3.o.b(obj);
                PolicySdkLogUtils.Companion.d("getPolicyData", "getPolicyUsingGET");
                PolicyApiService policyApiService = new PolicyApiService(PolicySdkRetrofitHelper.INSTANCE.getApiService());
                String str = this.f15673b;
                String str2 = this.f15674c.f17836a;
                String str3 = this.f15675d;
                long j5 = this.f15676e.f17835a;
                String str4 = this.f15677f;
                long jLongValue = this.f15678g.longValue();
                PolicyManager policyManager = PolicyManager.INSTANCE;
                String brand = policyManager.getBrand();
                String model = policyManager.getModel();
                String osVersion = policyManager.getOsVersion();
                String str5 = this.f15679h;
                this.f15672a = 1;
                Object policyUsingGET = policyApiService.getPolicyUsingGET(str, str2, str3, j5, str4, jLongValue, brand, model, osVersion, str5, BuildConfig.FLAVOR, this);
                return policyUsingGET == objE ? objE : policyUsingGET;
            }

            @Override // i4.p
            public final Object invoke(s4.I i5, Z3.e<? super R4.t<PolicyNewestResponse>> eVar) {
                return ((a) create(i5, eVar)).invokeSuspend(v.f5542a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C0626m(String str, Long l5, String str2, String str3, String str4, InterfaceC0772l<? super PolicySdkResultBean, v> interfaceC0772l, String str5, Z3.e<? super C0626m> eVar) {
            super(2, eVar);
            this.f15665c = str;
            this.f15666d = l5;
            this.f15667e = str2;
            this.f15668f = str3;
            this.f15669g = str4;
            this.f15670h = interfaceC0772l;
            this.f15671i = str5;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            return new C0626m(this.f15665c, this.f15666d, this.f15667e, this.f15668f, this.f15669g, this.f15670h, this.f15671i, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x00c2, code lost:
        
            if (r0 == r9) goto L32;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v14, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v27, types: [T, com.stepos.policy.sdk.bean.PolicyNewestResponse] */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) {
            /*
                Method dump skipped, instructions count: 480
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C0626m.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // i4.p
        public final Object invoke(s4.I i5, Z3.e<? super v> eVar) {
            return ((C0626m) create(i5, eVar)).invokeSuspend(v.f5542a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$getPolicyHistoryList$1", f = "PolicyManager.kt", l = {2239, 2249}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$n, reason: case insensitive filesystem */
    static final class C0627n extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super v>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f15680a;

        /* renamed from: b, reason: collision with root package name */
        int f15681b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15682c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15683d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f15684e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f15685f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ InterfaceC0772l<PolicySdkResultBean, PolicySdkResultBean> f15686g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f15687h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f15688i;

        @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$getPolicyHistoryList$1$response$1", f = "PolicyManager.kt", l = {2251}, m = "invokeSuspend")
        /* renamed from: com.stepos.policy.sdk.PolicyManager$n$a */
        static final class a extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super R4.t<PolicyHistoryListResponse>>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f15689a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f15690b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ j4.v<String> f15691c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f15692d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ u f15693e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f15694f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ long f15695g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f15696h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, j4.v<String> vVar, String str2, u uVar, String str3, long j5, String str4, Z3.e<? super a> eVar) {
                super(2, eVar);
                this.f15690b = str;
                this.f15691c = vVar;
                this.f15692d = str2;
                this.f15693e = uVar;
                this.f15694f = str3;
                this.f15695g = j5;
                this.f15696h = str4;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
                return new a(this.f15690b, this.f15691c, this.f15692d, this.f15693e, this.f15694f, this.f15695g, this.f15696h, eVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objE = C0428b.e();
                int i5 = this.f15689a;
                if (i5 != 0) {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    V3.o.b(obj);
                    return obj;
                }
                V3.o.b(obj);
                PolicySdkLogUtils.Companion.d("PolicyManager", "getPolicyUsingGET");
                PolicyApiService policyApiService = new PolicyApiService(PolicySdkRetrofitHelper.INSTANCE.getApiService());
                String str = this.f15690b;
                String str2 = this.f15691c.f17836a;
                String str3 = this.f15692d;
                long j5 = this.f15693e.f17835a;
                String str4 = this.f15694f;
                long j6 = this.f15695g;
                PolicyManager policyManager = PolicyManager.INSTANCE;
                String brand = policyManager.getBrand();
                String model = policyManager.getModel();
                String osVersion = policyManager.getOsVersion();
                String str5 = this.f15696h;
                this.f15689a = 1;
                Object objPolicyHistoryListUsingGET = policyApiService.policyHistoryListUsingGET(str, str2, str3, j5, str4, j6, brand, model, osVersion, str5, this);
                return objPolicyHistoryListUsingGET == objE ? objE : objPolicyHistoryListUsingGET;
            }

            @Override // i4.p
            public final Object invoke(s4.I i5, Z3.e<? super R4.t<PolicyHistoryListResponse>> eVar) {
                return ((a) create(i5, eVar)).invokeSuspend(v.f5542a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C0627n(String str, String str2, String str3, String str4, InterfaceC0772l<? super PolicySdkResultBean, PolicySdkResultBean> interfaceC0772l, String str5, long j5, Z3.e<? super C0627n> eVar) {
            super(2, eVar);
            this.f15682c = str;
            this.f15683d = str2;
            this.f15684e = str3;
            this.f15685f = str4;
            this.f15686g = interfaceC0772l;
            this.f15687h = str5;
            this.f15688i = j5;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            return new C0627n(this.f15682c, this.f15683d, this.f15684e, this.f15685f, this.f15686g, this.f15687h, this.f15688i, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00ba, code lost:
        
            if (r0 == r8) goto L30;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v27, types: [T, com.stepos.policy.sdk.bean.PolicyHistoryListResponse] */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) {
            /*
                Method dump skipped, instructions count: 397
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C0627n.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // i4.p
        public final Object invoke(s4.I i5, Z3.e<? super v> eVar) {
            return ((C0627n) create(i5, eVar)).invokeSuspend(v.f5542a);
        }
    }

    /* renamed from: com.stepos.policy.sdk.PolicyManager$o, reason: case insensitive filesystem */
    public static final class C0628o implements InterfaceC1193b<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC1193b f15697a;

        /* renamed from: com.stepos.policy.sdk.PolicyManager$o$a */
        public static final class a<T> implements InterfaceC1194c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ InterfaceC1194c f15698a;

            @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$getPolicyOperate$$inlined$map$1$2", f = "PolicyManager.kt", l = {223}, m = "emit")
            /* renamed from: com.stepos.policy.sdk.PolicyManager$o$a$a, reason: collision with other inner class name */
            public static final class C0194a extends kotlin.coroutines.jvm.internal.d {

                /* renamed from: a, reason: collision with root package name */
                /* synthetic */ Object f15699a;

                /* renamed from: b, reason: collision with root package name */
                int f15700b;

                public C0194a(Z3.e eVar) {
                    super(eVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.f15699a = obj;
                    this.f15700b |= Integer.MIN_VALUE;
                    return a.this.g(null, this);
                }
            }

            public a(InterfaceC1194c interfaceC1194c) {
                this.f15698a = interfaceC1194c;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // v4.InterfaceC1194c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object g(java.lang.Object r5, Z3.e r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof com.stepos.policy.sdk.PolicyManager.C0628o.a.C0194a
                    if (r0 == 0) goto L13
                    r0 = r6
                    com.stepos.policy.sdk.PolicyManager$o$a$a r0 = (com.stepos.policy.sdk.PolicyManager.C0628o.a.C0194a) r0
                    int r1 = r0.f15700b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f15700b = r1
                    goto L18
                L13:
                    com.stepos.policy.sdk.PolicyManager$o$a$a r0 = new com.stepos.policy.sdk.PolicyManager$o$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f15699a
                    java.lang.Object r1 = a4.C0428b.e()
                    int r2 = r0.f15700b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    V3.o.b(r6)
                    goto L49
                L29:
                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                    java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                    r4.<init>(r5)
                    throw r4
                L31:
                    V3.o.b(r6)
                    v4.c r4 = r4.f15698a
                    O.d r5 = (O.d) r5
                    O.d$a r6 = com.stepos.policy.sdk.d.e()
                    java.lang.Object r5 = r5.b(r6)
                    r0.f15700b = r3
                    java.lang.Object r4 = r4.g(r5, r0)
                    if (r4 != r1) goto L49
                    return r1
                L49:
                    V3.v r4 = V3.v.f5542a
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C0628o.a.g(java.lang.Object, Z3.e):java.lang.Object");
            }
        }

        public C0628o(InterfaceC1193b interfaceC1193b) {
            this.f15697a = interfaceC1193b;
        }

        @Override // v4.InterfaceC1193b
        public Object a(InterfaceC1194c<? super Boolean> interfaceC1194c, Z3.e eVar) {
            Object objA = this.f15697a.a(new a(interfaceC1194c), eVar);
            return objA == C0428b.e() ? objA : v.f5542a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {371}, m = "getPolicyOperate")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$p, reason: case insensitive filesystem */
    static final class C0629p extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f15702a;

        /* renamed from: c, reason: collision with root package name */
        int f15704c;

        C0629p(Z3.e<? super C0629p> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f15702a = obj;
            this.f15704c |= Integer.MIN_VALUE;
            return PolicyManager.this.getPolicyOperate(null, this);
        }
    }

    /* renamed from: com.stepos.policy.sdk.PolicyManager$q, reason: case insensitive filesystem */
    public static final class C0630q implements InterfaceC1193b<String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC1193b f15705a;

        /* renamed from: com.stepos.policy.sdk.PolicyManager$q$a */
        public static final class a<T> implements InterfaceC1194c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ InterfaceC1194c f15706a;

            @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1$2", f = "PolicyManager.kt", l = {223}, m = "emit")
            /* renamed from: com.stepos.policy.sdk.PolicyManager$q$a$a, reason: collision with other inner class name */
            public static final class C0195a extends kotlin.coroutines.jvm.internal.d {

                /* renamed from: a, reason: collision with root package name */
                /* synthetic */ Object f15707a;

                /* renamed from: b, reason: collision with root package name */
                int f15708b;

                public C0195a(Z3.e eVar) {
                    super(eVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.f15707a = obj;
                    this.f15708b |= Integer.MIN_VALUE;
                    return a.this.g(null, this);
                }
            }

            public a(InterfaceC1194c interfaceC1194c) {
                this.f15706a = interfaceC1194c;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // v4.InterfaceC1194c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object g(java.lang.Object r5, Z3.e r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof com.stepos.policy.sdk.PolicyManager.C0630q.a.C0195a
                    if (r0 == 0) goto L13
                    r0 = r6
                    com.stepos.policy.sdk.PolicyManager$q$a$a r0 = (com.stepos.policy.sdk.PolicyManager.C0630q.a.C0195a) r0
                    int r1 = r0.f15708b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f15708b = r1
                    goto L18
                L13:
                    com.stepos.policy.sdk.PolicyManager$q$a$a r0 = new com.stepos.policy.sdk.PolicyManager$q$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f15707a
                    java.lang.Object r1 = a4.C0428b.e()
                    int r2 = r0.f15708b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    V3.o.b(r6)
                    goto L49
                L29:
                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                    java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                    r4.<init>(r5)
                    throw r4
                L31:
                    V3.o.b(r6)
                    v4.c r4 = r4.f15706a
                    O.d r5 = (O.d) r5
                    O.d$a r6 = com.stepos.policy.sdk.d.f()
                    java.lang.Object r5 = r5.b(r6)
                    r0.f15708b = r3
                    java.lang.Object r4 = r4.g(r5, r0)
                    if (r4 != r1) goto L49
                    return r1
                L49:
                    V3.v r4 = V3.v.f5542a
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C0630q.a.g(java.lang.Object, Z3.e):java.lang.Object");
            }
        }

        public C0630q(InterfaceC1193b interfaceC1193b) {
            this.f15705a = interfaceC1193b;
        }

        @Override // v4.InterfaceC1193b
        public Object a(InterfaceC1194c<? super String> interfaceC1194c, Z3.e eVar) {
            Object objA = this.f15705a.a(new a(interfaceC1194c), eVar);
            return objA == C0428b.e() ? objA : v.f5542a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$getPolicyServiceConfig$1", f = "PolicyManager.kt", l = {2623, 2633}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$r, reason: case insensitive filesystem */
    static final class C0631r extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super v>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f15710a;

        /* renamed from: b, reason: collision with root package name */
        int f15711b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15712c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15713d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f15714e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ InterfaceC0772l<PolicySdkResultBean, PolicySdkResultBean> f15715f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f15716g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Context f15717h;

        @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$getPolicyServiceConfig$1$response$1", f = "PolicyManager.kt", l = {2635}, m = "invokeSuspend")
        /* renamed from: com.stepos.policy.sdk.PolicyManager$r$a */
        static final class a extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super R4.t<PolicyServiceConfigResponse>>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f15718a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f15719b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ j4.v<String> f15720c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ u f15721d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f15722e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f15723f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, j4.v<String> vVar, u uVar, String str2, String str3, Z3.e<? super a> eVar) {
                super(2, eVar);
                this.f15719b = str;
                this.f15720c = vVar;
                this.f15721d = uVar;
                this.f15722e = str2;
                this.f15723f = str3;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
                return new a(this.f15719b, this.f15720c, this.f15721d, this.f15722e, this.f15723f, eVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objE = C0428b.e();
                int i5 = this.f15718a;
                if (i5 != 0) {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    V3.o.b(obj);
                    return obj;
                }
                V3.o.b(obj);
                PolicySdkLogUtils.Companion.d("PolicyManager", "getPolicyUsingGET");
                PolicyApiService policyApiService = new PolicyApiService(PolicySdkRetrofitHelper.INSTANCE.getApiService());
                String str = this.f15719b;
                String str2 = this.f15720c.f17836a;
                long j5 = this.f15721d.f17835a;
                String str3 = this.f15722e;
                PolicyManager policyManager = PolicyManager.INSTANCE;
                String brand = policyManager.getBrand();
                String model = policyManager.getModel();
                String osVersion = policyManager.getOsVersion();
                String str4 = this.f15723f;
                this.f15718a = 1;
                Object serviceConfig = policyApiService.getServiceConfig(str, str2, j5, str3, brand, model, osVersion, str4, this);
                return serviceConfig == objE ? objE : serviceConfig;
            }

            @Override // i4.p
            public final Object invoke(s4.I i5, Z3.e<? super R4.t<PolicyServiceConfigResponse>> eVar) {
                return ((a) create(i5, eVar)).invokeSuspend(v.f5542a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C0631r(String str, String str2, String str3, InterfaceC0772l<? super PolicySdkResultBean, PolicySdkResultBean> interfaceC0772l, String str4, Context context, Z3.e<? super C0631r> eVar) {
            super(2, eVar);
            this.f15712c = str;
            this.f15713d = str2;
            this.f15714e = str3;
            this.f15715f = interfaceC0772l;
            this.f15716g = str4;
            this.f15717h = context;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            return new C0631r(this.f15712c, this.f15713d, this.f15714e, this.f15715f, this.f15716g, this.f15717h, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x00ae, code lost:
        
            if (r0 == r8) goto L28;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v28, types: [T, com.stepos.policy.sdk.bean.PolicyServiceConfigResponse] */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                Method dump skipped, instructions count: 402
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C0631r.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // i4.p
        public final Object invoke(s4.I i5, Z3.e<? super v> eVar) {
            return ((C0631r) create(i5, eVar)).invokeSuspend(v.f5542a);
        }
    }

    /* renamed from: com.stepos.policy.sdk.PolicyManager$s, reason: case insensitive filesystem */
    static final class C0632s extends j4.l implements InterfaceC0772l<ArrayList<DeleteInfoBean>, v> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0772l<ArrayList<DeleteInfoBean>, v> f15724a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C0632s(InterfaceC0772l<? super ArrayList<DeleteInfoBean>, v> interfaceC0772l) {
            super(1);
            this.f15724a = interfaceC0772l;
        }

        public final void b(ArrayList<DeleteInfoBean> arrayList) {
            PolicyManager policyManager = PolicyManager.INSTANCE;
            InterfaceC0772l<ArrayList<DeleteInfoBean>, v> interfaceC0772l = this.f15724a;
            PolicySdkLogUtils.Companion.d("getPrivateDeleteInfoList", "result = " + arrayList);
            interfaceC0772l.invoke(arrayList);
        }

        @Override // i4.InterfaceC0772l
        public /* bridge */ /* synthetic */ v invoke(ArrayList<DeleteInfoBean> arrayList) {
            b(arrayList);
            return v.f5542a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {1903}, m = "initPolicyNewestPath")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$t, reason: case insensitive filesystem */
    static final class C0633t extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a, reason: collision with root package name */
        Object f15725a;

        /* renamed from: b, reason: collision with root package name */
        Object f15726b;

        /* renamed from: c, reason: collision with root package name */
        Object f15727c;

        /* renamed from: d, reason: collision with root package name */
        Object f15728d;

        /* renamed from: e, reason: collision with root package name */
        Object f15729e;

        /* renamed from: f, reason: collision with root package name */
        Object f15730f;

        /* renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f15731g;

        /* renamed from: h, reason: collision with root package name */
        int f15732h;

        C0633t(Z3.e<? super C0633t> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f15731g = obj;
            this.f15732h |= Integer.MIN_VALUE;
            return PolicyManager.initPolicyNewestPath(null, null, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$initSDK$1", f = "PolicyManager.kt", l = {293, 294}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$u, reason: case insensitive filesystem */
    static final class C0634u extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super v>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f15733a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f15734b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0634u(Context context, Z3.e<? super C0634u> eVar) {
            super(2, eVar);
            this.f15734b = context;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            return new C0634u(this.f15734b, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
        
            if (r5.loadCloudPolicyUidCategoryMap(r1, r4) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = a4.C0428b.e()
                int r1 = r4.f15733a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                V3.o.b(r5)
                goto L44
            L12:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L1a:
                V3.o.b(r5)
                goto L2e
            L1e:
                V3.o.b(r5)
                com.stepos.policy.sdk.PolicyManager r5 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                android.content.Context r1 = r4.f15734b
                r4.f15733a = r3
                java.lang.Object r5 = r5.getAgreeStatus(r1, r4)
                if (r5 != r0) goto L2e
                goto L43
            L2e:
                java.lang.Number r5 = (java.lang.Number) r5
                int r5 = r5.intValue()
                com.stepos.policy.sdk.util.PolicySdkNetworkGate.updateAgreeStatusCache(r5)
                com.stepos.policy.sdk.PolicyManager r5 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                android.content.Context r1 = r4.f15734b
                r4.f15733a = r2
                java.lang.Object r4 = com.stepos.policy.sdk.PolicyManager.access$loadCloudPolicyUidCategoryMap(r5, r1, r4)
                if (r4 != r0) goto L44
            L43:
                return r0
            L44:
                V3.v r4 = V3.v.f5542a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C0634u.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // i4.p
        public final Object invoke(s4.I i5, Z3.e<? super v> eVar) {
            return ((C0634u) create(i5, eVar)).invokeSuspend(v.f5542a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$initSDK$2", f = "PolicyManager.kt", l = {305}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$v, reason: case insensitive filesystem */
    static final class C0635v extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super v>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f15735a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f15736b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ HashMap<String, String> f15737c;

        @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$initSDK$2$1", f = "PolicyManager.kt", l = {318}, m = "invokeSuspend")
        /* renamed from: com.stepos.policy.sdk.PolicyManager$v$a */
        static final class a extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super v>, Object> {

            /* renamed from: a, reason: collision with root package name */
            Object f15738a;

            /* renamed from: b, reason: collision with root package name */
            Object f15739b;

            /* renamed from: c, reason: collision with root package name */
            int f15740c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Context f15741d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ HashMap<String, String> f15742e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, HashMap<String, String> map, Z3.e<? super a> eVar) {
                super(2, eVar);
                this.f15741d = context;
                this.f15742e = map;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
                return new a(this.f15741d, this.f15742e, eVar);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x005f  */
            /* JADX WARN: Removed duplicated region for block: B:15:0x00b3  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0096 -> B:14:0x0099). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                /*
                    r9 = this;
                    java.lang.Object r0 = a4.C0428b.e()
                    int r1 = r9.f15740c
                    java.lang.String r2 = " *************** policyKey = "
                    r3 = 1
                    java.lang.String r4 = "initSDK"
                    if (r1 == 0) goto L24
                    if (r1 != r3) goto L1c
                    java.lang.Object r1 = r9.f15739b
                    java.lang.String r1 = (java.lang.String) r1
                    java.lang.Object r5 = r9.f15738a
                    java.util.Iterator r5 = (java.util.Iterator) r5
                    V3.o.b(r10)
                    goto L99
                L1c:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r10)
                    throw r9
                L24:
                    V3.o.b(r10)
                    com.stepos.policy.sdk.PolicyManager r10 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                    r1 = 0
                    r10.setSyncLocalFileFinished(r1)
                    com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r1 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    r5.<init>()
                    java.lang.String r6 = "syncLocalFileFinished start time = "
                    r5.append(r6)
                    long r6 = java.lang.System.currentTimeMillis()
                    r5.append(r6)
                    java.lang.String r5 = r5.toString()
                    r1.d(r4, r5)
                    android.content.Context r1 = r9.f15741d
                    java.util.HashMap<java.lang.String, java.lang.String> r5 = r9.f15742e
                    com.stepos.policy.sdk.PolicyManager.access$selfCheckLocalAssets(r10, r1, r5)
                    java.util.HashMap<java.lang.String, java.lang.String> r10 = r9.f15742e
                    java.util.Set r10 = r10.entrySet()
                    java.util.Iterator r10 = r10.iterator()
                    r5 = r10
                L59:
                    boolean r10 = r5.hasNext()
                    if (r10 == 0) goto Lb3
                    java.lang.Object r10 = r5.next()
                    java.util.Map$Entry r10 = (java.util.Map.Entry) r10
                    java.lang.Object r1 = r10.getKey()
                    java.lang.String r1 = (java.lang.String) r1
                    java.lang.Object r10 = r10.getValue()
                    java.lang.String r10 = (java.lang.String) r10
                    com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r6 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    r7.<init>()
                    r7.append(r2)
                    r7.append(r1)
                    java.lang.String r8 = " start***************"
                    r7.append(r8)
                    java.lang.String r7 = r7.toString()
                    r6.d(r4, r7)
                    android.content.Context r6 = r9.f15741d
                    r9.f15738a = r5
                    r9.f15739b = r1
                    r9.f15740c = r3
                    java.lang.Object r10 = com.stepos.policy.sdk.PolicyManager.initPolicyNewestPath(r6, r10, r1, r9)
                    if (r10 != r0) goto L99
                    return r0
                L99:
                    com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r10 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    r6.append(r2)
                    r6.append(r1)
                    java.lang.String r1 = " end ***************"
                    r6.append(r1)
                    java.lang.String r1 = r6.toString()
                    r10.d(r4, r1)
                    goto L59
                Lb3:
                    com.stepos.policy.sdk.PolicyManager r10 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                    r10.setSyncLocalFileFinished(r3)
                    com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r10 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = ">>> DONE syncLocalFileFinished=true, storage="
                    r0.append(r1)
                    android.content.Context r1 = r9.f15741d
                    java.io.File r1 = r1.getDataDir()
                    if (r1 == 0) goto Ld1
                    java.lang.String r1 = r1.getPath()
                    goto Ld2
                Ld1:
                    r1 = 0
                Ld2:
                    r0.append(r1)
                    java.lang.String r1 = ", categories="
                    r0.append(r1)
                    java.util.HashMap<java.lang.String, java.lang.String> r9 = r9.f15742e
                    java.util.Set r9 = r9.keySet()
                    r0.append(r9)
                    java.lang.String r9 = r0.toString()
                    r10.i(r4, r9)
                    V3.v r9 = V3.v.f5542a
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C0635v.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // i4.p
            public final Object invoke(s4.I i5, Z3.e<? super v> eVar) {
                return ((a) create(i5, eVar)).invokeSuspend(v.f5542a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0635v(Context context, HashMap<String, String> map, Z3.e<? super C0635v> eVar) {
            super(2, eVar);
            this.f15736b = context;
            this.f15737c = map;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            return new C0635v(this.f15736b, this.f15737c, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objE = C0428b.e();
            int i5 = this.f15735a;
            if (i5 == 0) {
                V3.o.b(obj);
                AbstractC1056E abstractC1056EB = s4.W.b();
                a aVar = new a(this.f15736b, this.f15737c, null);
                this.f15735a = 1;
                if (C1072g.e(abstractC1056EB, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                V3.o.b(obj);
            }
            return v.f5542a;
        }

        @Override // i4.p
        public final Object invoke(s4.I i5, Z3.e<? super v> eVar) {
            return ((C0635v) create(i5, eVar)).invokeSuspend(v.f5542a);
        }
    }

    /* renamed from: com.stepos.policy.sdk.PolicyManager$w, reason: case insensitive filesystem */
    public static final class C0636w implements InterfaceC1193b<String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC1193b f15743a;

        /* renamed from: com.stepos.policy.sdk.PolicyManager$w$a */
        public static final class a<T> implements InterfaceC1194c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ InterfaceC1194c f15744a;

            @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$loadCloudPolicyUidCategoryMap$$inlined$map$1$2", f = "PolicyManager.kt", l = {223}, m = "emit")
            /* renamed from: com.stepos.policy.sdk.PolicyManager$w$a$a, reason: collision with other inner class name */
            public static final class C0196a extends kotlin.coroutines.jvm.internal.d {

                /* renamed from: a, reason: collision with root package name */
                /* synthetic */ Object f15745a;

                /* renamed from: b, reason: collision with root package name */
                int f15746b;

                public C0196a(Z3.e eVar) {
                    super(eVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.f15745a = obj;
                    this.f15746b |= Integer.MIN_VALUE;
                    return a.this.g(null, this);
                }
            }

            public a(InterfaceC1194c interfaceC1194c) {
                this.f15744a = interfaceC1194c;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // v4.InterfaceC1194c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object g(java.lang.Object r5, Z3.e r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof com.stepos.policy.sdk.PolicyManager.C0636w.a.C0196a
                    if (r0 == 0) goto L13
                    r0 = r6
                    com.stepos.policy.sdk.PolicyManager$w$a$a r0 = (com.stepos.policy.sdk.PolicyManager.C0636w.a.C0196a) r0
                    int r1 = r0.f15746b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f15746b = r1
                    goto L18
                L13:
                    com.stepos.policy.sdk.PolicyManager$w$a$a r0 = new com.stepos.policy.sdk.PolicyManager$w$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f15745a
                    java.lang.Object r1 = a4.C0428b.e()
                    int r2 = r0.f15746b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    V3.o.b(r6)
                    goto L49
                L29:
                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                    java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                    r4.<init>(r5)
                    throw r4
                L31:
                    V3.o.b(r6)
                    v4.c r4 = r4.f15744a
                    O.d r5 = (O.d) r5
                    O.d$a r6 = com.stepos.policy.sdk.d.c()
                    java.lang.Object r5 = r5.b(r6)
                    r0.f15746b = r3
                    java.lang.Object r4 = r4.g(r5, r0)
                    if (r4 != r1) goto L49
                    return r1
                L49:
                    V3.v r4 = V3.v.f5542a
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C0636w.a.g(java.lang.Object, Z3.e):java.lang.Object");
            }
        }

        public C0636w(InterfaceC1193b interfaceC1193b) {
            this.f15743a = interfaceC1193b;
        }

        @Override // v4.InterfaceC1193b
        public Object a(InterfaceC1194c<? super String> interfaceC1194c, Z3.e eVar) {
            Object objA = this.f15743a.a(new a(interfaceC1194c), eVar);
            return objA == C0428b.e() ? objA : v.f5542a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {404}, m = "loadCloudPolicyUidCategoryMap")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$x, reason: case insensitive filesystem */
    static final class C0637x extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f15748a;

        /* renamed from: c, reason: collision with root package name */
        int f15750c;

        C0637x(Z3.e<? super C0637x> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f15748a = obj;
            this.f15750c |= Integer.MIN_VALUE;
            return PolicyManager.this.loadCloudPolicyUidCategoryMap(null, this);
        }
    }

    /* renamed from: com.stepos.policy.sdk.PolicyManager$y, reason: case insensitive filesystem */
    public static final class C0638y extends com.google.gson.reflect.a<Map<String, ? extends String>> {
        C0638y() {
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$persistCloudPolicyUidCategoryMap$1", f = "PolicyManager.kt", l = {425}, m = "invokeSuspend")
    static final class z extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super v>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f15751a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f15752b;

        @kotlin.coroutines.jvm.internal.f(c = "com.stepos.policy.sdk.PolicyManager$persistCloudPolicyUidCategoryMap$1$1", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
        static final class a extends kotlin.coroutines.jvm.internal.l implements i4.p<O.a, Z3.e<? super v>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f15753a;

            /* renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f15754b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f15755c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, Z3.e<? super a> eVar) {
                super(2, eVar);
                this.f15755c = str;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
                a aVar = new a(this.f15755c, eVar);
                aVar.f15754b = obj;
                return aVar;
            }

            @Override // i4.p
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public final Object invoke(O.a aVar, Z3.e<? super v> eVar) {
                return ((a) create(aVar, eVar)).invokeSuspend(v.f5542a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                C0428b.e();
                if (this.f15753a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                V3.o.b(obj);
                O.a aVar = (O.a) this.f15754b;
                d.a<String> aVarC = d.c();
                String str = this.f15755c;
                j4.k.f(str, "json");
                aVar.i(aVarC, str);
                return v.f5542a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        z(Context context, Z3.e<? super z> eVar) {
            super(2, eVar);
            this.f15752b = context;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            return new z(this.f15752b, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objE = C0428b.e();
            int i5 = this.f15751a;
            try {
                if (i5 == 0) {
                    V3.o.b(obj);
                    String strR = new A1.e().r(PolicyCloudPolicyIndex.snapshot());
                    L.f fVarG = d.g(this.f15752b);
                    a aVar = new a(strR, null);
                    this.f15751a = 1;
                    if (O.g.a(fVarG, aVar, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    V3.o.b(obj);
                }
            } catch (Exception e6) {
                PolicySdkLogUtils.Companion.e("CloudPolicyIndex", "persist failed: " + e6);
            }
            return v.f5542a;
        }

        @Override // i4.p
        public final Object invoke(s4.I i5, Z3.e<? super v> eVar) {
            return ((z) create(i5, eVar)).invokeSuspend(v.f5542a);
        }
    }

    static {
        String channelToBrand = PolicySdkToolsUtils.Companion.getChannelToBrand();
        companyCode = channelToBrand;
        brand = channelToBrand;
        model = BuildConfig.FLAVOR;
        osVersion = BuildConfig.FLAVOR;
        exceptionHandler = new U(InterfaceC1057F.f20300O);
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [T, com.stepos.policy.sdk.bean.PolicyRecordRequest] */
    public static final void autoUploadRecord(Context context, String str, String str2, String str3, String[] strArr, String str4, String str5) {
        j4.k.g(context, "context");
        j4.k.g(str, "appId");
        j4.k.g(str2, "appSecret");
        j4.k.g(str3, "versionName");
        j4.k.g(strArr, "categoryList");
        j4.k.g(str5, "operationType");
        j4.v vVar = new j4.v();
        vVar.f17836a = createRecordRequest(context, strArr, str4, str5);
        if (PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            uploadPolicyOperateRecord(str, str2, str3, (PolicyRecordRequest) vVar.f17836a, new C0614a(vVar, context));
        } else {
            C1076i.b(C1073g0.f20349a, exceptionHandler, null, new C0615b(vVar, context, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x004c -> B:22:0x004f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object awaitSyncLocalFileFinished(Z3.e<? super V3.v> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.stepos.policy.sdk.PolicyManager.C0616c
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.policy.sdk.PolicyManager$c r0 = (com.stepos.policy.sdk.PolicyManager.C0616c) r0
            int r1 = r0.f15590d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15590d = r1
            goto L18
        L13:
            com.stepos.policy.sdk.PolicyManager$c r0 = new com.stepos.policy.sdk.PolicyManager$c
            r0.<init>(r10)
        L18:
            java.lang.Object r9 = r0.f15588b
            java.lang.Object r10 = a4.C0428b.e()
            int r1 = r0.f15590d
            r2 = 200(0xc8, double:9.9E-322)
            r4 = 1
            if (r1 == 0) goto L35
            if (r1 != r4) goto L2d
            long r5 = r0.f15587a
            V3.o.b(r9)
            goto L4f
        L2d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L35:
            V3.o.b(r9)
            r5 = 0
        L3a:
            boolean r9 = com.stepos.policy.sdk.PolicyManager.syncLocalFileFinished
            if (r9 != 0) goto L51
            r7 = 10000(0x2710, double:4.9407E-320)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 >= 0) goto L51
            r0.f15587a = r5
            r0.f15590d = r4
            java.lang.Object r9 = s4.S.a(r2, r0)
            if (r9 != r10) goto L4f
            return r10
        L4f:
            long r5 = r5 + r2
            goto L3a
        L51:
            V3.v r9 = V3.v.f5542a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.awaitSyncLocalFileFinished(Z3.e):java.lang.Object");
    }

    public static final void checkNewestPolicy(Context context, boolean z5, String str, String str2, String str3, String str4, String str5, InterfaceC0772l<? super PolicySdkResultBean, v> interfaceC0772l) {
        j4.k.g(context, "context");
        j4.k.g(str, "appId");
        j4.k.g(str2, "appSecret");
        j4.k.g(str3, "language");
        j4.k.g(str4, "category");
        j4.k.g(str5, "versionName");
        j4.k.g(interfaceC0772l, "callBackPolicyResult");
        C1076i.b(C1073g0.f20349a, exceptionHandler, null, new C0617d(context, str4, str3, z5, str, str2, str5, interfaceC0772l, null), 2, null);
    }

    public static final String copyPolicyFile(Context context, String str, String str2) {
        j4.k.g(context, "context");
        j4.k.g(str, "category");
        j4.k.g(str2, "toPath");
        PolicySdkFileUtils.Companion companion = PolicySdkFileUtils.Companion;
        PolicyNewestPathResultBean policyNewestPathResultBeanIsNewestPolicyFileIsExists = companion.isNewestPolicyFileIsExists(context, str);
        PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
        companion2.d("copyPolicyFile", "policyNewestPathResultBean.isExists = " + policyNewestPathResultBeanIsNewestPolicyFileIsExists.isExists());
        String strCopyPolicyFile = policyNewestPathResultBeanIsNewestPolicyFileIsExists.isExists() ? companion.copyPolicyFile(policyNewestPathResultBeanIsNewestPolicyFileIsExists.getNewestPolicyPath(), str2) : BuildConfig.FLAVOR;
        companion2.d("copyPolicyFile", "successPath = " + strCopyPolicyFile);
        return strCopyPolicyFile;
    }

    private final stepos.support.v7.app.r createReGrantDialogBuilder(final Context context, final boolean z5, boolean z6, String str, final String str2, final String str3, r.h hVar) {
        stepos.support.v7.app.r rVar = new stepos.support.v7.app.r(context);
        rVar.o(str2).i(str).n(hVar).p(z6).r(new View.OnClickListener() { // from class: com.stepos.policy.sdk.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PolicyManager.createReGrantDialogBuilder$lambda$8(context, z5, str2, str3, view);
            }
        });
        return rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createReGrantDialogBuilder$lambda$8(Context context, boolean z5, String str, String str2, View view) {
        j4.k.g(context, "$context");
        j4.k.g(str, "$privacyPolicyName");
        j4.k.g(str2, "$category");
        openPolicyMethod(context, z5, str, str2);
    }

    public static final PolicyRecordRequest createRecordRequest(Context context, String[] strArr, String str, String str2) {
        j4.k.g(context, "context");
        j4.k.g(strArr, "categoryList");
        j4.k.g(str2, "operationType");
        PolicyRecordRequest policyRecordRequest = new PolicyRecordRequest();
        if (readAndroidIdEnabled) {
            String string = Settings.System.getString(context.getContentResolver(), "android_id");
            j4.k.f(string, "androidId");
            policyRecordRequest.setBusinessId(string);
        }
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

    public static final void encryptCustomDeleteInfoListBySecure(Context context, ArrayList<CustomDeleteInfoBean> arrayList, InterfaceC0772l<? super ArrayList<DeleteInfoBean>, v> interfaceC0772l) {
        j4.k.g(context, "context");
        j4.k.g(arrayList, "customDeleteInfoList");
        j4.k.g(interfaceC0772l, "callBackPolicyResult");
        WithdrawalManager.INSTANCE.encryptCustomDeleteInfoListBySecure(context, arrayList, new C0618e(new ArrayList(), arrayList, interfaceC0772l));
    }

    public static final ArrayList<DeleteInfoBean> encryptDeleteInfoWithoutSecureService(Context context, ArrayList<DeleteInfoEncryptMultiBean> arrayList) {
        j4.k.g(context, "context");
        j4.k.g(arrayList, "customDeleteInfoList");
        return WithdrawalManagerWithoutSecureService.INSTANCE.getEncryptByDeleteInfoList(context, arrayList);
    }

    public static final void encryptMultiDeleteListBySecure(Context context, ArrayList<DeleteInfoEncryptMultiBean> arrayList, InterfaceC0772l<? super ArrayList<DeleteInfoBean>, v> interfaceC0772l) {
        j4.k.g(context, "context");
        j4.k.g(arrayList, "customDeleteInfoList");
        j4.k.g(interfaceC0772l, "callBackPolicyResult");
        WithdrawalManager.INSTANCE.encryptMultiCustomDeleteInfoListBySecure(context, arrayList, new C0619f(new ArrayList(), arrayList, interfaceC0772l));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PolicyNewestPathResultBean findNewestPolicyFile(Context context, String str) {
        Context contextResolvePolicyContext = resolvePolicyContext(context);
        PolicySdkFileUtils.Companion companion = PolicySdkFileUtils.Companion;
        PolicyNewestPathResultBean policyNewestPathResultBeanIsNewestPolicyFileIsExists = companion.isNewestPolicyFileIsExists(contextResolvePolicyContext, str);
        if (!policyNewestPathResultBeanIsNewestPolicyFileIsExists.isExists()) {
            Context applicationContext = isDeviceProtectedStorageContext(contextResolvePolicyContext) ? context.getApplicationContext() : context.getApplicationContext().createDeviceProtectedStorageContext();
            j4.k.f(applicationContext, "alternateContext");
            PolicyNewestPathResultBean policyNewestPathResultBeanIsNewestPolicyFileIsExists2 = companion.isNewestPolicyFileIsExists(applicationContext, str);
            if (policyNewestPathResultBeanIsNewestPolicyFileIsExists2.isExists()) {
                PolicySdkLogUtils.Companion.d("PolicyManager", "findNewestPolicyFile fallback hit: " + policyNewestPathResultBeanIsNewestPolicyFileIsExists2.getNewestPolicyPath());
                return policyNewestPathResultBeanIsNewestPolicyFileIsExists2;
            }
        }
        return policyNewestPathResultBeanIsNewestPolicyFileIsExists;
    }

    public static final void getCommonDeleteInfoList(Context context, String str, int i5) {
        j4.k.g(context, "mContext");
        j4.k.g(str, "businessType");
        WithdrawalManager.INSTANCE.getCommonDeleteInfoListBySecure(context, str, i5, new C0622i((Context) new WeakReference(context.getApplicationContext()).get()));
    }

    private final String getLocalCategoryMd5(Context context, String str) {
        return (String) C1074h.b(null, new C0624k(context, str, null), 1, null);
    }

    public static final void getPolicyByVersion(String str, String str2, String str3, Long l5, String str4, InterfaceC0772l<? super PolicySdkResultBean, PolicySdkResultBean> interfaceC0772l) {
        j4.k.g(str, "appId");
        j4.k.g(str2, "appSecret");
        j4.k.g(str3, "language");
        j4.k.g(interfaceC0772l, "callBackPolicyResult");
        C1076i.b(C1073g0.f20349a, exceptionHandler, null, new C0625l(l5, str4, str, str2, interfaceC0772l, str3, null), 2, null);
    }

    public static final void getPolicyData(String str, String str2, String str3, String str4, Long l5, String str5, InterfaceC0772l<? super PolicySdkResultBean, v> interfaceC0772l) {
        j4.k.g(str, "appId");
        j4.k.g(str2, "appSecret");
        j4.k.g(str3, "language");
        j4.k.g(interfaceC0772l, "callBackPolicyResult");
        C1076i.b(C1073g0.f20349a, exceptionHandler, null, new C0626m(str4, l5, str5, str, str2, interfaceC0772l, str3, null), 2, null);
    }

    public static final void getPolicyHistoryList(String str, String str2, String str3, String str4, long j5, String str5, InterfaceC0772l<? super PolicySdkResultBean, PolicySdkResultBean> interfaceC0772l) {
        j4.k.g(str, "appId");
        j4.k.g(str2, "appSecret");
        j4.k.g(str3, "language");
        j4.k.g(interfaceC0772l, "callBackPolicyResult");
        C1076i.b(C1073g0.f20349a, exceptionHandler, null, new C0627n(str4, str5, str, str2, interfaceC0772l, str3, j5, null), 2, null);
    }

    public static final String getPolicyHistoryUrl(String str, String str2, long j5, String str3) {
        j4.k.g(str, "appId");
        j4.k.g(str2, "category");
        j4.k.g(str3, "language");
        String str4 = "https://policy-h5.stepaos.com/?appId=" + str + "&category=" + str2 + "&version=" + j5 + "&language=" + str3;
        PolicySdkLogUtils.Companion.d("getPolicyHistoryUrl", str4);
        return str4;
    }

    public static final PolicySdkResultBean getPolicyNewestPath(Context context, String str) {
        j4.k.g(context, "context");
        j4.k.g(str, "category");
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
            j4.k.f(name, "myFile.name");
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
        j4.k.g(context, "context");
        j4.k.g(str, "category");
        PolicySdkLogUtils.Companion.d("getPolicyNewestPathByCustom", " initSDKByDeviceProtectedStorageContext= " + initSDKByDeviceProtectedStorageContext);
        return getPolicyNewestPath(context, str);
    }

    public static final void getPolicyServiceConfig(Context context, String str, String str2, String str3, String str4, InterfaceC0772l<? super PolicySdkResultBean, PolicySdkResultBean> interfaceC0772l) {
        j4.k.g(context, "context");
        j4.k.g(str, "appId");
        j4.k.g(str2, "appSecret");
        j4.k.g(str3, "language");
        j4.k.g(interfaceC0772l, "callBackPolicyResult");
        C1076i.b(C1073g0.f20349a, exceptionHandler, null, new C0631r(str4, str, str2, interfaceC0772l, str3, context, null), 2, null);
    }

    public static final void getPrivateDeleteInfoList(Context context, String str, String str2, int i5, InterfaceC0772l<? super ArrayList<DeleteInfoBean>, v> interfaceC0772l) {
        j4.k.g(context, "context");
        j4.k.g(str, "appId");
        j4.k.g(str2, "businessType");
        j4.k.g(interfaceC0772l, "callBackPolicyResult");
        WithdrawalManager.INSTANCE.getPrivateDeleteInfoListBySecure(context, str, str2, i5, new C0632s(interfaceC0772l));
    }

    public static final boolean getReadAndroidIdEnabled() {
        return readAndroidIdEnabled;
    }

    public static /* synthetic */ void getReadAndroidIdEnabled$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0184 A[Catch: Exception -> 0x019b, TryCatch #0 {Exception -> 0x019b, blocks: (B:50:0x016a, B:52:0x0184, B:54:0x018e, B:56:0x0193), top: B:60:0x016a }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0193 A[Catch: Exception -> 0x019b, TRY_LEAVE, TryCatch #0 {Exception -> 0x019b, blocks: (B:50:0x016a, B:52:0x0184, B:54:0x018e, B:56:0x0193), top: B:60:0x016a }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object initPolicyNewestPath(android.content.Context r19, java.lang.String r20, java.lang.String r21, Z3.e<? super com.stepos.policy.sdk.bean.PolicySdkResultBean> r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 415
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.initPolicyNewestPath(android.content.Context, java.lang.String, java.lang.String, Z3.e):java.lang.Object");
    }

    public static final void initSDK(Context context, String str, String str2, String str3, HashMap<String, String> map) {
        j4.k.g(context, "context");
        j4.k.g(str, "appId");
        j4.k.g(str2, "appSecret");
        j4.k.g(str3, "versionName");
        j4.k.g(map, "policyCategoryMap");
        PolicySdkRetrofitCreator.INSTANCE.init(context);
        mAppId = str;
        mAppSecret = str2;
        PolicyAppSecretResolver.INSTANCE.reset(mAppSecret);
        mAppVersionName = str3;
        PolicySdkToolsUtils.Companion companion = PolicySdkToolsUtils.Companion;
        model = companion.getSystemModel(context);
        osVersion = companion.getSystemVersion(context);
        Context contextResolvePolicyContext = resolvePolicyContext(context);
        localAssetsCategoryPathMap = map;
        try {
            C1074h.b(null, new C0634u(contextResolvePolicyContext, null), 1, null);
        } catch (Exception e6) {
            PolicySdkLogUtils.Companion.e("initSDK", "load agreeStatus/uidMap failed: " + e6);
        }
        PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
        StringBuilder sb = new StringBuilder();
        sb.append("policyCategoryMap=");
        sb.append(map);
        sb.append(", policyContext=");
        File dataDir = contextResolvePolicyContext.getDataDir();
        sb.append(dataDir != null ? dataDir.getPath() : null);
        companion2.d("initSDK", sb.toString());
        C1076i.b(C1073g0.f20349a, exceptionHandler, null, new C0635v(contextResolvePolicyContext, map, null), 2, null);
    }

    private final boolean isDeviceProtectedStorageContext(Context context) {
        String path;
        File dataDir = context.getDataDir();
        return (dataDir == null || (path = dataDir.getPath()) == null || !C1031n.u(path, "user_de", false, 2, null)) ? false : true;
    }

    public static final boolean isSupportSecureService(Context context, int i5) {
        j4.k.g(context, "context");
        return INSTANCE.getSecureServiceVersionCode(context) >= i5;
    }

    public static final boolean isSupportSecureService31(Context context) {
        j4.k.g(context, "context");
        try {
            int secureServiceVersionCode = INSTANCE.getSecureServiceVersionCode(context);
            PolicySdkLogUtils.Companion.d("PolicyManager", "com.stepos.secureservice versionCode : " + secureServiceVersionCode + ' ');
            return secureServiceVersionCode >= 11000031;
        } catch (Exception e6) {
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            StringBuilder sb = new StringBuilder();
            sb.append("exception : ");
            e6.getMessage();
            v vVar = v.f5542a;
            sb.append(e6);
            companion.e("PolicyManager", sb.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object loadCloudPolicyUidCategoryMap(android.content.Context r6, Z3.e<? super V3.v> r7) {
        /*
            r5 = this;
            java.lang.String r0 = "CloudPolicyIndex"
            boolean r1 = r7 instanceof com.stepos.policy.sdk.PolicyManager.C0637x
            if (r1 == 0) goto L15
            r1 = r7
            com.stepos.policy.sdk.PolicyManager$x r1 = (com.stepos.policy.sdk.PolicyManager.C0637x) r1
            int r2 = r1.f15750c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f15750c = r2
            goto L1a
        L15:
            com.stepos.policy.sdk.PolicyManager$x r1 = new com.stepos.policy.sdk.PolicyManager$x
            r1.<init>(r7)
        L1a:
            java.lang.Object r5 = r1.f15748a
            java.lang.Object r7 = a4.C0428b.e()
            int r2 = r1.f15750c
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            V3.o.b(r5)
            goto L4c
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            V3.o.b(r5)
            L.f r5 = com.stepos.policy.sdk.d.a(r6)
            v4.b r5 = r5.a()
            com.stepos.policy.sdk.PolicyManager$w r6 = new com.stepos.policy.sdk.PolicyManager$w
            r6.<init>(r5)
            r1.f15750c = r3
            java.lang.Object r5 = v4.d.d(r6, r1)
            if (r5 != r7) goto L4c
            return r7
        L4c:
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto Lae
            boolean r6 = r4.C1031n.E(r5)
            if (r6 == 0) goto L57
            goto Lae
        L57:
            com.stepos.policy.sdk.PolicyManager$y r6 = new com.stepos.policy.sdk.PolicyManager$y     // Catch: java.lang.Exception -> L70
            r6.<init>()     // Catch: java.lang.Exception -> L70
            java.lang.reflect.Type r6 = r6.getType()     // Catch: java.lang.Exception -> L70
            A1.e r7 = new A1.e     // Catch: java.lang.Exception -> L70
            r7.<init>()     // Catch: java.lang.Exception -> L70
            java.lang.Object r5 = r7.j(r5, r6)     // Catch: java.lang.Exception -> L70
            java.util.Map r5 = (java.util.Map) r5     // Catch: java.lang.Exception -> L70
            if (r5 != 0) goto L72
            V3.v r5 = V3.v.f5542a     // Catch: java.lang.Exception -> L70
            return r5
        L70:
            r5 = move-exception
            goto L95
        L72:
            com.stepos.policy.sdk.util.PolicyCloudPolicyIndex.putAll(r5)     // Catch: java.lang.Exception -> L70
            com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r6 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion     // Catch: java.lang.Exception -> L70
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L70
            r7.<init>()     // Catch: java.lang.Exception -> L70
            java.lang.String r1 = "loaded "
            r7.append(r1)     // Catch: java.lang.Exception -> L70
            int r5 = r5.size()     // Catch: java.lang.Exception -> L70
            r7.append(r5)     // Catch: java.lang.Exception -> L70
            java.lang.String r5 = " uid→category from DataStore"
            r7.append(r5)     // Catch: java.lang.Exception -> L70
            java.lang.String r5 = r7.toString()     // Catch: java.lang.Exception -> L70
            r6.d(r0, r5)     // Catch: java.lang.Exception -> L70
            goto Lab
        L95:
            com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r6 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r1 = "load failed: "
            r7.append(r1)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.e(r0, r5)
        Lab:
            V3.v r5 = V3.v.f5542a
            return r5
        Lae:
            V3.v r5 = V3.v.f5542a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.loadCloudPolicyUidCategoryMap(android.content.Context, Z3.e):java.lang.Object");
    }

    public static final PolicySdkResultBean openPolicyDataByBrowser(Context context, String str, String str2) {
        j4.k.g(context, "context");
        j4.k.g(str, "category");
        j4.k.g(str2, "title");
        PolicySdkResultBean policyNewestPathByCustom = getPolicyNewestPathByCustom(context, str);
        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
        companion.d("PolicyManager", "openPolicyDataByBrowser " + policyNewestPathByCustom.getPolicyNewestPath() + '}');
        PolicyCheckLogUtils.Companion companion2 = PolicyCheckLogUtils.Companion;
        companion2.i("openPolicy", ">>> START category=" + str + " method=BROWSER syncDone=" + syncLocalFileFinished);
        if (policyNewestPathByCustom.getCode() == 0) {
            String policyNewestPath = policyNewestPathByCustom.getPolicyNewestPath();
            companion.d("PolicyManager", "openPolicyDataByBrowser policyNewestPath path = " + policyNewestPath + ' ');
            Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".PolicySdk.FileProvider", new File(policyNewestPath));
            if (uriForFile != null) {
                PolicySdkToolsUtils.Companion.startBrowser(context, uriForFile);
            }
            companion2.i("openPolicy", ">>> END category=" + str + " code=SUCCESS 已唤起浏览器 path=" + policyNewestPath);
            return policyNewestPathByCustom;
        }
        companion2.e("openPolicy", ">>> END category=" + str + " code=FAILED 未打开页面(无反应)");
        companion2.e("openPolicy", "原因: 本地无 " + str + " 缓存文件; syncDone=" + syncLocalFileFinished + "; code=" + policyNewestPathByCustom.getCode());
        StringBuilder sb = new StringBuilder();
        sb.append("建议: 1)确认 assets 有对应 ");
        sb.append(str);
        sb.append("_x.html 且 initSDK 已 put(\"");
        sb.append(str);
        sb.append("\",...); 2)syncDone=false 时查启动自检(selfCheck)是否有 ⚠️ 缺文件导致同步中断; 3)确认打开与登记的 category 完全一致");
        companion2.e("openPolicy", sb.toString());
        return policyNewestPathByCustom;
    }

    public static final PolicySdkResultBean openPolicyDataByWebView(Context context, String str, String str2) {
        j4.k.g(context, "context");
        j4.k.g(str, "category");
        j4.k.g(str2, "title");
        PolicySdkResultBean policyNewestPathByCustom = getPolicyNewestPathByCustom(context, str);
        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
        companion.d("PolicyManager", "openPolicyDataByWebView " + policyNewestPathByCustom.getPolicyNewestPath() + '}');
        PolicyCheckLogUtils.Companion companion2 = PolicyCheckLogUtils.Companion;
        companion2.i("openPolicy", ">>> START category=" + str + " method=IN_APP syncDone=" + syncLocalFileFinished);
        if (policyNewestPathByCustom.getCode() != 0) {
            companion2.e("openPolicy", ">>> END category=" + str + " code=FAILED 未打开页面(无反应)");
            companion2.e("openPolicy", "原因: 本地无 " + str + " 缓存文件; syncDone=" + syncLocalFileFinished + "; code=" + policyNewestPathByCustom.getCode());
            StringBuilder sb = new StringBuilder();
            sb.append("建议: 1)确认 assets 有对应 ");
            sb.append(str);
            sb.append("_x.html 且 initSDK 已 put(\"");
            sb.append(str);
            sb.append("\",...); 2)syncDone=false 时查启动自检(selfCheck)是否有 ⚠️ 缺文件导致同步中断; 3)确认打开与登记的 category 完全一致");
            companion2.e("openPolicy", sb.toString());
            return policyNewestPathByCustom;
        }
        String policyNewestPath = policyNewestPathByCustom.getPolicyNewestPath();
        Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".PolicySdk.FileProvider", new File(policyNewestPath));
        companion.d("PolicyManager", "save sucessful path = " + policyNewestPath + ' ');
        String string = uriForFile.toString();
        j4.k.f(string, "contentUri.toString()");
        if (!syncLocalFileFinished && localAssetsCategoryPathMap.containsKey(str) && localAssetsCategoryPathMap.get(str) != null && !j4.k.b(BuildConfig.FLAVOR, localAssetsCategoryPathMap.get(str))) {
            string = String.valueOf(localAssetsCategoryPathMap.get(str));
        }
        companion.d("openPolicyDataByWebView", "initSDK syncLocalFileFinished " + syncLocalFileFinished + " |  policyPath = " + string);
        PolicyHtmlViewerActivity.Companion.openPolicy(context, string, str2, null);
        companion2.i("openPolicy", ">>> END category=" + str + " code=SUCCESS 已打开页面 path=" + string);
        return policyNewestPathByCustom;
    }

    public static final PolicySdkResultBean openPolicyMethod(Context context, boolean z5, String str, String str2) {
        j4.k.g(context, "context");
        j4.k.g(str, "title");
        j4.k.g(str2, "category");
        return z5 ? openPolicyDataByWebView(context, str2, str) : openPolicyDataByBrowser(context, str2, str);
    }

    private final void persistCloudPolicyUidCategoryMap(Context context) {
        C1076i.b(C1073g0.f20349a, exceptionHandler, null, new z(context, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reTryUploadRecord(Context context) {
        C1076i.b(C1073g0.f20349a, exceptionHandler, null, new A(context, this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void rememberCloudPolicyUidCategory(android.content.Context r3, java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            r2 = this;
            if (r5 == 0) goto L36
            boolean r0 = r4.C1031n.E(r5)
            if (r0 == 0) goto L9
            goto L36
        L9:
            r0 = 0
            if (r6 == 0) goto L19
            boolean r1 = r4.C1031n.E(r6)
            if (r1 != 0) goto L13
            goto L14
        L13:
            r6 = r0
        L14:
            if (r6 != 0) goto L17
            goto L19
        L17:
            r0 = r6
            goto L27
        L19:
            if (r4 != 0) goto L1d
            java.lang.String r4 = ""
        L1d:
            com.stepos.policy.sdk.bean.CloudPolicyUrlInfo r4 = com.stepos.policy.sdk.util.PolicyHtmlLinkHandler.parseCloudPolicyUrl(r4)
            if (r4 == 0) goto L27
            java.lang.String r0 = r4.getPolicyUid()
        L27:
            if (r0 == 0) goto L36
            boolean r4 = r4.C1031n.E(r0)
            if (r4 == 0) goto L30
            goto L36
        L30:
            com.stepos.policy.sdk.util.PolicyCloudPolicyIndex.put(r0, r5)
            r2.persistCloudPolicyUidCategoryMap(r3)
        L36:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.rememberCloudPolicyUidCategory(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public static final Context resolvePolicyContext(Context context) {
        j4.k.g(context, "context");
        if (INSTANCE.isDeviceProtectedStorageContext(context)) {
            initSDKByDeviceProtectedStorageContext = true;
            return context;
        }
        if (!initSDKByDeviceProtectedStorageContext) {
            return context;
        }
        Context contextCreateDeviceProtectedStorageContext = context.getApplicationContext().createDeviceProtectedStorageContext();
        j4.k.f(contextCreateDeviceProtectedStorageContext, "{\n            context.ap…torageContext()\n        }");
        return contextCreateDeviceProtectedStorageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object resolveSignSecret(java.lang.String r5, java.lang.String r6, java.lang.String r7, boolean r8, Z3.e<? super java.lang.String> r9) {
        /*
            r4 = this;
            boolean r0 = r9 instanceof com.stepos.policy.sdk.PolicyManager.B
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.policy.sdk.PolicyManager$B r0 = (com.stepos.policy.sdk.PolicyManager.B) r0
            int r1 = r0.f15445e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15445e = r1
            goto L18
        L13:
            com.stepos.policy.sdk.PolicyManager$B r0 = new com.stepos.policy.sdk.PolicyManager$B
            r0.<init>(r9)
        L18:
            java.lang.Object r4 = r0.f15443c
            java.lang.Object r9 = a4.C0428b.e()
            int r1 = r0.f15445e
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            boolean r8 = r0.f15442b
            java.lang.Object r5 = r0.f15441a
            r7 = r5
            java.lang.String r7 = (java.lang.String) r7
            V3.o.b(r4)
            goto L4a
        L30:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L38:
            V3.o.b(r4)
            com.stepos.policy.sdk.util.PolicyAppSecretResolver r4 = com.stepos.policy.sdk.util.PolicyAppSecretResolver.INSTANCE
            r0.f15441a = r7
            r0.f15442b = r8
            r0.f15445e = r2
            java.lang.Object r4 = r4.resolveForSign(r5, r6, r0)
            if (r4 != r9) goto L4a
            return r9
        L4a:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r4.length()
            if (r5 <= 0) goto L55
            com.stepos.policy.sdk.PolicyManager.mAppSecret = r4
            return r4
        L55:
            boolean r5 = com.stepos.policy.sdk.util.PolicySdkNetworkGate.shouldBlock()
            if (r5 == 0) goto L5e
            java.lang.String r5 = "未同意前禁网且无 initSDK 兜底"
            goto L60
        L5e:
            java.lang.String r5 = "换密钥失败且无 initSDK 兜底"
        L60:
            if (r8 == 0) goto L65
            java.lang.String r6 = "，已返回本地缓存"
            goto L67
        L65:
            java.lang.String r6 = ""
        L67:
            com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r8 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r7)
            java.lang.String r7 = " 未发出: "
            r9.append(r7)
            r9.append(r5)
            r9.append(r6)
            java.lang.String r5 = r9.toString()
            java.lang.String r6 = "AppSecret"
            r8.w(r6, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.resolveSignSecret(java.lang.String, java.lang.String, java.lang.String, boolean, Z3.e):java.lang.Object");
    }

    static /* synthetic */ Object resolveSignSecret$default(PolicyManager policyManager, String str, String str2, String str3, boolean z5, Z3.e eVar, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            z5 = false;
        }
        return policyManager.resolveSignSecret(str, str2, str3, z5, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveDataStoreString(Context context, d.a<String> aVar, String str, Z3.e<? super v> eVar) {
        PolicySdkLogUtils.Companion.d("saveDataStoreString", ' ' + aVar + " | dataStoreValue =" + str + ' ');
        Object objA = O.g.a(d.g(context), new D(aVar, str, null), eVar);
        return objA == C0428b.e() ? objA : v.f5542a;
    }

    private final void saveLocalCategoryMd5(Context context, String str, String str2) {
        C1076i.b(C1073g0.f20349a, exceptionHandler, null, new E(str, str2, context, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009c, code lost:
    
        if (O.g.a(r6, r7, r0) == r10) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object savePolicyOperate(android.content.Context r7, boolean r8, java.lang.String r9, Z3.e<? super V3.v> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.stepos.policy.sdk.PolicyManager.F
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.policy.sdk.PolicyManager$F r0 = (com.stepos.policy.sdk.PolicyManager.F) r0
            int r1 = r0.f15469f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15469f = r1
            goto L18
        L13:
            com.stepos.policy.sdk.PolicyManager$F r0 = new com.stepos.policy.sdk.PolicyManager$F
            r0.<init>(r10)
        L18:
            java.lang.Object r6 = r0.f15467d
            java.lang.Object r10 = a4.C0428b.e()
            int r1 = r0.f15469f
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L44
            if (r1 == r3) goto L35
            if (r1 != r2) goto L2d
            V3.o.b(r6)
            goto L9f
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            boolean r8 = r0.f15466c
            java.lang.Object r7 = r0.f15465b
            r9 = r7
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r7 = r0.f15464a
            android.content.Context r7 = (android.content.Context) r7
            V3.o.b(r6)
            goto L7f
        L44:
            V3.o.b(r6)
            com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r6 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "isOperateSuccess ="
            r1.append(r5)
            r1.append(r8)
            java.lang.String r5 = " |operateJson = "
            r1.append(r5)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            java.lang.String r5 = "savePolicyOperate"
            r6.d(r5, r1)
            L.f r6 = com.stepos.policy.sdk.d.a(r7)
            com.stepos.policy.sdk.PolicyManager$G r1 = new com.stepos.policy.sdk.PolicyManager$G
            r1.<init>(r8, r4)
            r0.f15464a = r7
            r0.f15465b = r9
            r0.f15466c = r8
            r0.f15469f = r3
            java.lang.Object r6 = O.g.a(r6, r1, r0)
            if (r6 != r10) goto L7f
            goto L9e
        L7f:
            if (r8 != 0) goto La2
            if (r9 == 0) goto La2
            int r6 = r9.length()
            if (r6 <= 0) goto La2
            L.f r6 = com.stepos.policy.sdk.d.a(r7)
            com.stepos.policy.sdk.PolicyManager$H r7 = new com.stepos.policy.sdk.PolicyManager$H
            r7.<init>(r9, r4)
            r0.f15464a = r4
            r0.f15465b = r4
            r0.f15469f = r2
            java.lang.Object r6 = O.g.a(r6, r7, r0)
            if (r6 != r10) goto L9f
        L9e:
            return r10
        L9f:
            V3.v r6 = V3.v.f5542a
            return r6
        La2:
            V3.v r6 = V3.v.f5542a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.savePolicyOperate(android.content.Context, boolean, java.lang.String, Z3.e):java.lang.Object");
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
                } else if (C1031n.u(value, "file:////android_asset", false, 2, null)) {
                    String strO = C1031n.o(value, "file:////android_asset/", BuildConfig.FLAVOR, false, 4, null);
                    if (assetExists(context, strO)) {
                        PolicyCheckLogUtils.Companion.i("selfCheck", "category=" + key + " asset=" + strO + " present=true");
                    } else {
                        arrayList.add(key);
                        PolicyCheckLogUtils.Companion.w("selfCheck", "category=" + key + " asset=" + strO + " present=FALSE ⚠️ 缺失会中断同步(其后 category 不再同步)且该 category 无法本地打开");
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
        } catch (Exception e6) {
            PolicyCheckLogUtils.Companion.e("selfCheck", "自检异常: " + e6.getMessage());
        }
    }

    public static final void setReadAndroidIdEnabled(boolean z5) {
        readAndroidIdEnabled = z5;
    }

    public static final stepos.support.v7.app.c showCustomPolicyDialog(Context context, boolean z5, String[] strArr, String[] strArr2, String str, CharSequence charSequence, CharSequence charSequence2, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        j4.k.g(context, "context");
        j4.k.g(str, "title");
        j4.k.g(charSequence2, "customTerms");
        j4.k.g(onPermissionClickListener, "permissionDialogClickListener");
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        policyPermissionDialogBuilder.setAppName(str).setOnPermissionListener(new I(context, onPermissionClickListener)).setSecondaryConfirmation(z5).setCustomTerms(charSequence2);
        if (charSequence != null && !TextUtils.isEmpty(charSequence)) {
            policyPermissionDialogBuilder.setReminder(charSequence);
        }
        if (strArr != null && strArr2 != null) {
            policyPermissionDialogBuilder.setPermission(strArr, strArr2);
        }
        return policyPermissionDialogBuilder.create();
    }

    public static final stepos.support.v7.app.c showCustomPolicyDialogAndUploadRecord(Context context, boolean z5, String[] strArr, String[] strArr2, String str, CharSequence charSequence, CharSequence charSequence2, String str2, String str3, String str4, String[] strArr3, String str5, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        j4.k.g(context, "context");
        j4.k.g(str, "title");
        j4.k.g(charSequence2, "customTerms");
        j4.k.g(str2, "appId");
        j4.k.g(str3, "appSecret");
        j4.k.g(str4, "versionName");
        j4.k.g(strArr3, "categoryList");
        j4.k.g(onPermissionClickListener, "permissionDialogClickListener");
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        policyPermissionDialogBuilder.setAppName(str).setOnPermissionListener(new J(context, str2, str3, str4, strArr3, str5, onPermissionClickListener)).setSecondaryConfirmation(z5).setCustomTerms(charSequence2);
        if (charSequence != null && !TextUtils.isEmpty(charSequence)) {
            policyPermissionDialogBuilder.setReminder(charSequence);
        }
        if (strArr != null && strArr2 != null) {
            policyPermissionDialogBuilder.setPermission(strArr, strArr2);
        }
        return policyPermissionDialogBuilder.create();
    }

    public static final stepos.support.v7.app.c showCustomPolicyThreeButtonDialogAndUploadRecord(Context context, boolean z5, String[] strArr, String[] strArr2, String str, CharSequence charSequence, CharSequence charSequence2, String str2, String str3, String str4, String[] strArr3, String str5, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener, r.h hVar) {
        j4.k.g(context, "context");
        j4.k.g(str, "title");
        j4.k.g(charSequence2, "customTerms");
        j4.k.g(str2, "appId");
        j4.k.g(str3, "appSecret");
        j4.k.g(str4, "versionName");
        j4.k.g(strArr3, "categoryList");
        j4.k.g(onPermissionClickListener, "fullAgreeListener");
        j4.k.g(hVar, "basicListener");
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        policyPermissionDialogBuilder.setDark(PolicyHtmlDisplayAdapter.isDarkMode(context));
        policyPermissionDialogBuilder.setAppName(str).setOnPermissionListener(new K()).setSecondaryConfirmation(z5).setCustomTerms(charSequence2);
        if (charSequence != null && !TextUtils.isEmpty(charSequence)) {
            policyPermissionDialogBuilder.setReminder(charSequence);
        }
        if (strArr != null && strArr2 != null) {
            policyPermissionDialogBuilder.setPermission(strArr, strArr2);
        }
        return policyPermissionDialogBuilder.createThreeButton(new L(context, str2, str3, str4, strArr3, str5, onPermissionClickListener, hVar));
    }

    public static final stepos.support.v7.app.r showDialogByCustomThemeViewBuilder(Context context, int i5, String str, CharSequence charSequence, String str2, String str3, r.h hVar) {
        j4.k.g(context, "context");
        j4.k.g(str, "title");
        j4.k.g(charSequence, "customTerms");
        j4.k.g(str2, "customNegativeButtonText");
        j4.k.g(str3, "customPositiveButtonText");
        j4.k.g(hVar, "permissionDialogClickListener");
        stepos.support.v7.app.r rVar = new stepos.support.v7.app.r(context);
        rVar.i(str).n(hVar).m(charSequence).k(str2).l(str3);
        return rVar;
    }

    public static final stepos.support.v7.app.c showDialogByCustomView(Context context, String str, CharSequence charSequence, String str2, String str3, r.h hVar) {
        j4.k.g(context, "context");
        j4.k.g(str, "title");
        j4.k.g(charSequence, "customTerms");
        j4.k.g(str2, "customNegativeButtonText");
        j4.k.g(str3, "customPositiveButtonText");
        j4.k.g(hVar, "permissionDialogClickListener");
        stepos.support.v7.app.r rVarShowDialogByCustomViewBuilder = showDialogByCustomViewBuilder(context, str, charSequence, str2, str3, "2", hVar);
        if (rVarShowDialogByCustomViewBuilder != null) {
            return rVarShowDialogByCustomViewBuilder.e();
        }
        return null;
    }

    public static final stepos.support.v7.app.c showDialogByCustomViewAndUploadRecord(Context context, String str, CharSequence charSequence, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, String str8, r.h hVar) {
        j4.k.g(context, "context");
        j4.k.g(str, "title");
        j4.k.g(charSequence, "customTerms");
        j4.k.g(str2, "customNegativeButtonText");
        j4.k.g(str3, "customPositiveButtonText");
        j4.k.g(str4, "appId");
        j4.k.g(str5, "appSecret");
        j4.k.g(str6, "versionName");
        j4.k.g(strArr, "categoryList");
        j4.k.g(str8, "operationType");
        j4.k.g(hVar, "permissionDialogClickListener");
        stepos.support.v7.app.r rVarShowDialogUploadRecordBuilder = showDialogUploadRecordBuilder(context, str, charSequence, str2, str3, str4, str5, str6, strArr, str7, str8, hVar);
        if (rVarShowDialogUploadRecordBuilder != null) {
            return rVarShowDialogUploadRecordBuilder.e();
        }
        return null;
    }

    public static final stepos.support.v7.app.r showDialogByCustomViewBuilder(Context context, String str, CharSequence charSequence, String str2, String str3, String str4, r.h hVar) {
        j4.k.g(context, "context");
        j4.k.g(str, "title");
        j4.k.g(charSequence, "customTerms");
        j4.k.g(str2, "customNegativeButtonText");
        j4.k.g(str3, "customPositiveButtonText");
        j4.k.g(str4, "operationType");
        j4.k.g(hVar, "permissionDialogClickListener");
        stepos.support.v7.app.r rVar = new stepos.support.v7.app.r(context);
        rVar.i(str).n(new M(str4, context, hVar)).m(charSequence).k(str2).l(str3);
        return rVar;
    }

    public static final stepos.support.v7.app.r showDialogByCustomViewBuilderRecord(Context context, String str, CharSequence charSequence, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, r.h hVar) {
        j4.k.g(context, "context");
        j4.k.g(str, "title");
        j4.k.g(charSequence, "customTerms");
        j4.k.g(str2, "customNegativeButtonText");
        j4.k.g(str3, "customPositiveButtonText");
        j4.k.g(str4, "appId");
        j4.k.g(str5, "appSecret");
        j4.k.g(str6, "versionName");
        j4.k.g(strArr, "categoryList");
        j4.k.g(hVar, "permissionDialogClickListener");
        return new stepos.support.v7.app.r(context).i(str).n(new N(context, str4, str5, str6, strArr, str7, hVar)).m(charSequence).k(str2).l(str3);
    }

    public static final stepos.support.v7.app.r showDialogUploadRecordBuilder(Context context, String str, CharSequence charSequence, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, String str8, r.h hVar) {
        j4.k.g(context, "context");
        j4.k.g(str, "title");
        j4.k.g(charSequence, "customTerms");
        j4.k.g(str2, "customNegativeButtonText");
        j4.k.g(str3, "customPositiveButtonText");
        j4.k.g(str4, "appId");
        j4.k.g(str5, "appSecret");
        j4.k.g(str6, "versionName");
        j4.k.g(strArr, "categoryList");
        j4.k.g(str8, "operationType");
        j4.k.g(hVar, "permissionDialogClickListener");
        stepos.support.v7.app.r rVar = new stepos.support.v7.app.r(context);
        rVar.i(str).n(new O(str8, context, str4, str5, str6, strArr, str7, hVar)).m(charSequence).k(str2).l(str3);
        return rVar;
    }

    public static final stepos.support.v7.app.c showNewestDialogAndUploadRecord(Context context, String str, String str2, String str3, String str4, String[] strArr, String str5, boolean z5, CharSequence charSequence, String str6, String str7, r.h hVar) {
        j4.k.g(context, "context");
        j4.k.g(str, "dialogTitle");
        j4.k.g(str2, "appId");
        j4.k.g(str3, "appSecret");
        j4.k.g(str4, "versionName");
        j4.k.g(strArr, "categoryList");
        j4.k.g(charSequence, "customTerms");
        j4.k.g(str6, "btnNegative");
        j4.k.g(str7, "btnPositive");
        j4.k.g(hVar, "permissionDialogClickListener");
        stepos.support.v7.app.r rVar = new stepos.support.v7.app.r(context);
        rVar.i(str).n(new P(z5, context, str2, str3, str4, strArr, str5, hVar)).m(charSequence).k(str6).l(str7);
        return rVar.e();
    }

    public static final stepos.support.v7.app.c showReGrantDialog(Context context, boolean z5, boolean z6, String str, String str2, String str3, r.h hVar) {
        j4.k.g(context, "context");
        j4.k.g(str, "title");
        j4.k.g(str2, "privacyPolicyName");
        j4.k.g(str3, "category");
        j4.k.g(hVar, "permissionDialogClickListener");
        return INSTANCE.createReGrantDialogBuilder(context, z5, z6, str, str2, str3, hVar).e();
    }

    public static final stepos.support.v7.app.c showReGrantDialogAndUploadRecord(Context context, boolean z5, boolean z6, String str, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, r.h hVar) {
        j4.k.g(context, "context");
        j4.k.g(str, "title");
        j4.k.g(str2, "privacyPolicyName");
        j4.k.g(str3, "category");
        j4.k.g(str4, "appId");
        j4.k.g(str5, "appSecret");
        j4.k.g(str6, "versionName");
        j4.k.g(strArr, "categoryList");
        j4.k.g(hVar, "permissionDialogClickListener");
        return INSTANCE.createReGrantDialogBuilder(context, z5, z6, str, str2, str3, new Q(context, str4, str5, str6, strArr, str7, hVar)).e();
    }

    public static final stepos.support.v7.app.c showReGrantTwoPolicyDialog(final Context context, final boolean z5, boolean z6, String str, final String str2, final String str3, String str4, String str5, r.h hVar) {
        j4.k.g(context, "context");
        j4.k.g(str, "title");
        j4.k.g(str2, "userPrivacyPolicyName");
        j4.k.g(str3, "userCategory");
        j4.k.g(str4, "privacyPolicyName");
        j4.k.g(str5, "category");
        j4.k.g(hVar, "permissionDialogClickListener");
        stepos.support.v7.app.r rVarCreateReGrantDialogBuilder = INSTANCE.createReGrantDialogBuilder(context, z5, z6, str, str4, str5, hVar);
        rVarCreateReGrantDialogBuilder.q(str2);
        rVarCreateReGrantDialogBuilder.s(new View.OnClickListener() { // from class: com.stepos.policy.sdk.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PolicyManager.showReGrantTwoPolicyDialog$lambda$7(context, z5, str2, str3, view);
            }
        });
        return rVarCreateReGrantDialogBuilder.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showReGrantTwoPolicyDialog$lambda$7(Context context, boolean z5, String str, String str2, View view) {
        j4.k.g(context, "$context");
        j4.k.g(str, "$userPrivacyPolicyName");
        j4.k.g(str2, "$userCategory");
        openPolicyMethod(context, z5, str, str2);
    }

    public static final stepos.support.v7.app.c showReGrantTwoPolicyDialogAndUploadRecord(final Context context, final boolean z5, boolean z6, String str, final String str2, final String str3, String str4, String str5, String str6, String str7, String str8, String[] strArr, String str9, r.h hVar) {
        j4.k.g(context, "context");
        j4.k.g(str, "title");
        j4.k.g(str2, "userPrivacyPolicyName");
        j4.k.g(str3, "userCategory");
        j4.k.g(str4, "privacyPolicyName");
        j4.k.g(str5, "category");
        j4.k.g(str6, "appId");
        j4.k.g(str7, "appSecret");
        j4.k.g(str8, "versionName");
        j4.k.g(strArr, "categoryList");
        j4.k.g(hVar, "permissionDialogClickListener");
        stepos.support.v7.app.r rVarCreateReGrantDialogBuilder = INSTANCE.createReGrantDialogBuilder(context, z5, z6, str, str4, str5, new R(context, str6, str7, str8, strArr, str9, hVar));
        rVarCreateReGrantDialogBuilder.q(str2);
        rVarCreateReGrantDialogBuilder.s(new View.OnClickListener() { // from class: com.stepos.policy.sdk.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PolicyManager.showReGrantTwoPolicyDialogAndUploadRecord$lambda$6(context, z5, str2, str3, view);
            }
        });
        return rVarCreateReGrantDialogBuilder.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showReGrantTwoPolicyDialogAndUploadRecord$lambda$6(Context context, boolean z5, String str, String str2, View view) {
        j4.k.g(context, "$context");
        j4.k.g(str, "$userPrivacyPolicyName");
        j4.k.g(str2, "$userCategory");
        openPolicyMethod(context, z5, str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, stepos.support.v7.app.c] */
    /* JADX WARN: Type inference failed for: r4v8, types: [T, stepos.support.v7.app.c] */
    /* JADX WARN: Type inference failed for: r4v9, types: [T, stepos.support.v7.app.c] */
    public static final stepos.support.v7.app.c showWithdrawalAndCleanServiceDataDialog(Context context, String str, CharSequence charSequence, String str2, String str3, String str4, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) throws Resources.NotFoundException {
        j4.k.g(context, "context");
        j4.k.g(str, "title");
        j4.k.g(charSequence, "customTerms");
        j4.k.g(str2, "customNegativeButtonText");
        j4.k.g(str3, "customPositiveButtonText");
        j4.k.g(str4, "checkButtonMessage");
        j4.k.g(onPermissionClickListener, "permissionDialogClickListener");
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        j4.v vVar = new j4.v();
        policyPermissionDialogBuilder.setAppName(str).setOnPermissionListener(new S(vVar, onPermissionClickListener)).setCustomTerms(charSequence).setShowAlmostDenyBtn(true).setCustomNegativeButtonText(str2).setCustomPositiveButtonText(str3).setCancelable(true).setCheckEnableConfirmBtn(true);
        vVar.f17836a = policyPermissionDialogBuilder.create();
        ?? Create = policyPermissionDialogBuilder.create();
        vVar.f17836a = Create;
        ?? InitWithdrawalCleanDataOneCheckBox = PolicySdkToolsUtils.Companion.initWithdrawalCleanDataOneCheckBox(context, Create, str4);
        vVar.f17836a = InitWithdrawalCleanDataOneCheckBox;
        return InitWithdrawalCleanDataOneCheckBox;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [T, stepos.support.v7.app.c] */
    /* JADX WARN: Type inference failed for: r8v1, types: [T, stepos.support.v7.app.c] */
    public static final stepos.support.v7.app.c showWithdrawalAndCleanServiceDataDialogByAccount(Context context, boolean z5, String str, CharSequence charSequence, String str2, String str3, String str4, String str5, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) throws Resources.NotFoundException {
        j4.k.g(context, "context");
        j4.k.g(str, "title");
        j4.k.g(charSequence, "customTerms");
        j4.k.g(str2, "customNegativeButtonText");
        j4.k.g(str3, "customPositiveButtonText");
        j4.k.g(str4, "checkButtonMessage");
        j4.k.g(str5, "secondCheckButtonMessage");
        j4.k.g(onPermissionClickListener, "permissionDialogClickListener");
        j4.v vVar = new j4.v();
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        policyPermissionDialogBuilder.setAppName(str).setOnPermissionListener(new T(vVar, onPermissionClickListener)).setCustomTerms(charSequence).setShowAlmostDenyBtn(true).setCustomNegativeButtonText(str2).setCustomPositiveButtonText(str3).setCancelable(true).setCheckEnableConfirmBtn(true);
        ?? Create = policyPermissionDialogBuilder.create();
        vVar.f17836a = Create;
        ?? InitWithdrawalCleanDataTwoCheckBox = PolicySdkToolsUtils.Companion.initWithdrawalCleanDataTwoCheckBox(context, Create, z5, str4, str5);
        vVar.f17836a = InitWithdrawalCleanDataTwoCheckBox;
        return InitWithdrawalCleanDataTwoCheckBox;
    }

    public static final void uploadPolicyOperateRecord(String str, String str2, String str3, PolicyRecordRequest policyRecordRequest, InterfaceC0772l<? super PolicySdkResultBean, v> interfaceC0772l) {
        j4.k.g(str, "appId");
        j4.k.g(str2, "appSecret");
        j4.k.g(str3, "versionName");
        j4.k.g(policyRecordRequest, "policyRecordRequest");
        j4.k.g(interfaceC0772l, "callBackPolicyResult");
        C1076i.b(C1073g0.f20349a, exceptionHandler, null, new V(str, str2, interfaceC0772l, policyRecordRequest, str3, null), 2, null);
    }

    public static final void uploadRecordByCustomRecordRequest(Context context, String str, String str2, String str3, PolicyRecordRequest policyRecordRequest, InterfaceC0772l<? super PolicySdkResultBean, v> interfaceC0772l) {
        j4.k.g(context, "context");
        j4.k.g(str, "appId");
        j4.k.g(str2, "appSecret");
        j4.k.g(str3, "versionName");
        j4.k.g(policyRecordRequest, "policyRecordRequest");
        j4.k.g(interfaceC0772l, "callBackPolicyResult");
        if (PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            uploadPolicyOperateRecord(str, str2, str3, policyRecordRequest, new W(interfaceC0772l));
        }
    }

    public static final void uploadRecordToCleanServiceData(Context context, String str, String str2, String str3, ArrayList<DeleteInfoBean> arrayList, String str4, String str5, String str6, String[] strArr, String str7, String str8, InterfaceC0772l<? super PolicySdkResultBean, v> interfaceC0772l) {
        j4.k.g(context, "context");
        j4.k.g(str, "serviceName");
        j4.k.g(str2, "validateCode");
        j4.k.g(str3, "verifyType");
        j4.k.g(str4, "appId");
        j4.k.g(str5, "appSecret");
        j4.k.g(str6, "versionName");
        j4.k.g(strArr, "categoryList");
        j4.k.g(str8, "operationType");
        j4.k.g(interfaceC0772l, "callBackPolicyResult");
        C1076i.b(scope, exceptionHandler, null, new X(context, strArr, str7, str8, str3, str, str2, arrayList, str4, str5, str6, interfaceC0772l, null), 2, null);
    }

    public static final void uploadRecordWithoutSecureService(Context context, String str, String str2, String str3, ArrayList<DeleteInfoBean> arrayList, String str4, String str5, String str6, String[] strArr, String str7, String str8, InterfaceC0772l<? super PolicySdkResultBean, v> interfaceC0772l) {
        j4.k.g(context, "context");
        j4.k.g(str, "serviceName");
        j4.k.g(str2, "validateCode");
        j4.k.g(str3, "verifyType");
        j4.k.g(str4, "appId");
        j4.k.g(str5, "appSecret");
        j4.k.g(str6, "versionName");
        j4.k.g(strArr, "categoryList");
        j4.k.g(str8, "operationType");
        j4.k.g(interfaceC0772l, "callBackPolicyResult");
        C1076i.b(scope, exceptionHandler, null, new Y(context, strArr, str7, str8, str3, str, str2, arrayList, str4, str5, str6, interfaceC0772l, null), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getAgreeStatus(android.content.Context r5, Z3.e<? super java.lang.Integer> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.policy.sdk.PolicyManager.C0621h
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.policy.sdk.PolicyManager$h r0 = (com.stepos.policy.sdk.PolicyManager.C0621h) r0
            int r1 = r0.f15626c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15626c = r1
            goto L18
        L13:
            com.stepos.policy.sdk.PolicyManager$h r0 = new com.stepos.policy.sdk.PolicyManager$h
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.f15624a
            java.lang.Object r6 = a4.C0428b.e()
            int r1 = r0.f15626c
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            V3.o.b(r4)
            goto L4a
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            V3.o.b(r4)
            L.f r4 = com.stepos.policy.sdk.d.a(r5)
            v4.b r4 = r4.a()
            com.stepos.policy.sdk.PolicyManager$g r5 = new com.stepos.policy.sdk.PolicyManager$g
            r5.<init>(r4)
            r0.f15626c = r2
            java.lang.Object r4 = v4.d.d(r5, r0)
            if (r4 != r6) goto L4a
            return r6
        L4a:
            java.lang.Integer r4 = (java.lang.Integer) r4
            if (r4 == 0) goto L53
            int r4 = r4.intValue()
            goto L54
        L53:
            r4 = 0
        L54:
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.b.b(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.getAgreeStatus(android.content.Context, Z3.e):java.lang.Object");
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

    public final Object getDataStoreString(Context context, d.a<String> aVar, Z3.e<? super String> eVar) {
        return v4.d.d(new C0623j(d.g(context).a(), aVar), eVar);
    }

    public final InterfaceC1057F getExceptionHandler() {
        return exceptionHandler;
    }

    public final boolean getInitSDKByDeviceProtectedStorageContext() {
        return initSDKByDeviceProtectedStorageContext;
    }

    public final s4.I getLifecycleScope() {
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
    public final java.lang.Object getPolicyOperate(android.content.Context r5, Z3.e<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.policy.sdk.PolicyManager.C0629p
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.policy.sdk.PolicyManager$p r0 = (com.stepos.policy.sdk.PolicyManager.C0629p) r0
            int r1 = r0.f15704c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15704c = r1
            goto L18
        L13:
            com.stepos.policy.sdk.PolicyManager$p r0 = new com.stepos.policy.sdk.PolicyManager$p
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.f15702a
            java.lang.Object r6 = a4.C0428b.e()
            int r1 = r0.f15704c
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            V3.o.b(r4)
            goto L4a
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            V3.o.b(r4)
            L.f r4 = com.stepos.policy.sdk.d.a(r5)
            v4.b r4 = r4.a()
            com.stepos.policy.sdk.PolicyManager$o r5 = new com.stepos.policy.sdk.PolicyManager$o
            r5.<init>(r4)
            r0.f15704c = r2
            java.lang.Object r4 = v4.d.d(r5, r0)
            if (r4 != r6) goto L4a
            return r6
        L4a:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.b.a(r2)
            boolean r4 = j4.k.b(r4, r5)
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.b.a(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.getPolicyOperate(android.content.Context, Z3.e):java.lang.Object");
    }

    public final Object getPolicyOperateJson(Context context, Z3.e<? super String> eVar) {
        return v4.d.d(new C0630q(d.g(context).a()), eVar);
    }

    public final s4.I getScope() {
        return scope;
    }

    public final int getSecureServiceVersionCode(Context context) {
        j4.k.g(context, "context");
        int i5 = context.getApplicationContext().getPackageManager().getPackageInfo("com.stepos.secureservice", 128).versionCode;
        PolicySdkLogUtils.Companion.d("PolicyManager", "com.stepos.secureservice versionCode : " + i5 + ' ');
        return i5;
    }

    public final boolean getSyncLocalFileFinished() {
        return syncLocalFileFinished;
    }

    public final void saveAgreeStatus(Context context, int i5) {
        j4.k.g(context, "context");
        PolicySdkNetworkGate.updateAgreeStatusCache(i5);
        C1076i.b(C1073g0.f20349a, exceptionHandler, null, new C(context, i5, null), 2, null);
    }

    public final void setBrand(String str) {
        j4.k.g(str, "<set-?>");
        brand = str;
    }

    public final void setCompanyCode(String str) {
        j4.k.g(str, "<set-?>");
        companyCode = str;
    }

    public final void setCustomPolicyCSSFileName(String str) {
        j4.k.g(str, "<set-?>");
        customPolicyCSSFileName = str;
    }

    public final void setInitSDKByDeviceProtectedStorageContext(boolean z5) {
        initSDKByDeviceProtectedStorageContext = z5;
    }

    public final void setLocalAssetsCategoryPathMap(HashMap<String, String> map) {
        j4.k.g(map, "<set-?>");
        localAssetsCategoryPathMap = map;
    }

    public final void setMAppId(String str) {
        j4.k.g(str, "<set-?>");
        mAppId = str;
    }

    public final void setMAppSecret(String str) {
        j4.k.g(str, "<set-?>");
        mAppSecret = str;
    }

    public final void setMAppVersionName(String str) {
        j4.k.g(str, "<set-?>");
        mAppVersionName = str;
    }

    public final void setModel(String str) {
        j4.k.g(str, "<set-?>");
        model = str;
    }

    public final void setOsVersion(String str) {
        j4.k.g(str, "<set-?>");
        osVersion = str;
    }

    public final void setSyncLocalFileFinished(boolean z5) {
        syncLocalFileFinished = z5;
    }
}
