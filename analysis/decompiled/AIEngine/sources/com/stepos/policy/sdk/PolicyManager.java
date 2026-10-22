package com.stepos.policy.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.PreferenceDataStore;
import androidx.datastore.preferences.core.PreferencesKt;
import com.stepos.aiengine.R;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.ota.crypto.KeyCenterException;
import com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity;
import com.stepos.policy.sdk.bean.CustomDeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoEncryptMultiBean;
import com.stepos.policy.sdk.bean.PolicyFileDataResultBean;
import com.stepos.policy.sdk.bean.PolicyNewestPathResultBean;
import com.stepos.policy.sdk.bean.PolicyRecordBaseInfo;
import com.stepos.policy.sdk.bean.PolicyRecordRequest;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder;
import com.stepos.policy.sdk.manager.WithdrawalManager;
import com.stepos.policy.sdk.manager.WithdrawalManagerWithoutSecureService;
import com.stepos.policy.sdk.net.PolicySdkRetrofitCreator;
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
import g1.a;
import gc.o;
import gc.q;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import lb.n;
import stepos.support.v7.app.g0;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicyManager {
    private static final long SYNC_LOCAL_FILE_MAX_WAIT_MS = 10000;
    private static final long SYNC_LOCAL_FILE_POLL_MS = 200;
    private static String brand;
    private static String companyCode;
    private static final CoroutineExceptionHandler exceptionHandler;
    private static boolean initSDKByDeviceProtectedStorageContext;
    private static String model;
    private static String osVersion;
    private static boolean readAndroidIdEnabled;
    private static boolean syncLocalFileFinished;
    public static final PolicyManager INSTANCE = new PolicyManager();
    private static final CoroutineScope lifecycleScope = CoroutineScopeKt.MainScope();
    private static String mAppId = "";
    private static String mAppSecret = "";
    private static String mAppVersionName = "";
    private static String customPolicyCSSFileName = "";
    private static HashMap<String, String> localAssetsCategoryPathMap = new HashMap<>();
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f7684a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener f7685b;

        public a(Context context, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
            this.f7684a = context;
            this.f7685b = onPermissionClickListener;
        }

        @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
        public final void onPermissionClick(DialogInterface dialogInterface, boolean z, boolean z3) {
            if (z3) {
                SocketHookUtil.recoveryPlatform();
                PolicyManager.INSTANCE.saveAgreeStatus(this.f7684a, 1);
            }
            this.f7685b.onPermissionClick(dialogInterface, z, z3);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager$autoUploadRecord$2", f = "PolicyManager.kt", l = {1351}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$autoUploadRecord$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f7692a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<PolicyRecordRequest> f7693b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f7694c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Ref$ObjectRef<PolicyRecordRequest> ref$ObjectRef, Context context, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.f7693b = ref$ObjectRef;
            this.f7694c = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new AnonymousClass2(this.f7693b, this.f7694c, bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((AnonymousClass2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.f7692a;
            if (i10 == 0) {
                kotlin.c.b(obj);
                String strH = new d5.i().h(this.f7693b.f10076a);
                PolicyManager policyManager = PolicyManager.INSTANCE;
                this.f7692a = 1;
                if (policyManager.savePolicyOperate(this.f7694c, false, strH, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            return n.f10413a;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {181}, m = "awaitSyncLocalFileFinished")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$awaitSyncLocalFileFinished$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04111 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public long f7695a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f7696b;

        /* renamed from: d, reason: collision with root package name */
        public int f7698d;

        public C04111(qb.b<? super C04111> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7696b = obj;
            this.f7698d |= Integer.MIN_VALUE;
            return PolicyManager.this.awaitSyncLocalFileFinished(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f7699a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7700b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f7701c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f7702d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String[] f7703e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f7704f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener f7705g;

        public b(Context context, String str, String str2, String str3, String[] strArr, String str4, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
            this.f7699a = context;
            this.f7700b = str;
            this.f7701c = str2;
            this.f7702d = str3;
            this.f7703e = strArr;
            this.f7704f = str4;
            this.f7705g = onPermissionClickListener;
        }

        @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
        public final void onPermissionClick(DialogInterface dialogInterface, boolean z, boolean z3) {
            String str = z3 ? "2" : "0";
            if (z3) {
                SocketHookUtil.recoveryPlatform();
                PolicyManager.INSTANCE.saveAgreeStatus(this.f7699a, 1);
                PolicyManager.autoUploadRecord(this.f7699a, this.f7700b, this.f7701c, this.f7702d, this.f7703e, this.f7704f, str);
            }
            this.f7705g.onPermissionClick(dialogInterface, z, z3);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c implements PolicyPermissionDialogBuilder.OnPermissionClickListener {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager$checkNewestPolicy$1", f = "PolicyManager.kt", l = {1547, 1597, 1610}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$checkNewestPolicy$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04121 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Ref$ObjectRef f7706a;

        /* renamed from: b, reason: collision with root package name */
        public PolicyNewestPathResultBean f7707b;

        /* renamed from: c, reason: collision with root package name */
        public Ref$ObjectRef f7708c;

        /* renamed from: d, reason: collision with root package name */
        public Ref$ObjectRef f7709d;

        /* renamed from: e, reason: collision with root package name */
        public int f7710e;
        public final /* synthetic */ Context h;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f7711j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ String f7712k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ boolean f7713l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f7714m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ String f7715n;

        /* renamed from: o, reason: collision with root package name */
        public final /* synthetic */ String f7716o;

        /* renamed from: p, reason: collision with root package name */
        public final /* synthetic */ zb.l<PolicySdkResultBean, n> f7717p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C04121(Context context, String str, String str2, boolean z, String str3, String str4, String str5, zb.l<? super PolicySdkResultBean, n> lVar, qb.b<? super C04121> bVar) {
            super(2, bVar);
            this.h = context;
            this.f7711j = str;
            this.f7712k = str2;
            this.f7713l = z;
            this.f7714m = str3;
            this.f7715n = str4;
            this.f7716o = str5;
            this.f7717p = lVar;
        }

        public static final void b(Ref$ObjectRef<PolicySdkResultBean> ref$ObjectRef, zb.l<? super PolicySdkResultBean, n> lVar, String str, String str2) {
            PolicySdkLogUtils.Companion.logCheckNewestResult(ref$ObjectRef.f10076a, str, str2);
            lVar.invoke(ref$ObjectRef.f10076a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new C04121(this.h, this.f7711j, this.f7712k, this.f7713l, this.f7714m, this.f7715n, this.f7716o, this.f7717p, bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C04121) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:117:0x039e  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0110  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0142  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0155  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x01af  */
        /* JADX WARN: Type inference failed for: r0v21, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v0, types: [T, com.stepos.policy.sdk.bean.PolicySdkResultBean] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r28) {
            /*
                Method dump skipped, instructions count: 1158
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C04121.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class d implements PolicyPermissionDialogBuilder.OnThreeButtonClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f7726a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7727b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f7728c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f7729d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String[] f7730e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f7731f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener f7732g;
        public final /* synthetic */ g0.a h;

        public d(Context context, String str, String str2, String str3, String[] strArr, String str4, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener, g0.a aVar) {
            this.f7726a = context;
            this.f7727b = str;
            this.f7728c = str2;
            this.f7729d = str3;
            this.f7730e = strArr;
            this.f7731f = str4;
            this.f7732g = onPermissionClickListener;
            this.h = aVar;
        }

        @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnThreeButtonClickListener
        public final void onBasicOnlyClick(DialogInterface dialogInterface, boolean z) {
            SocketHookUtil.recoveryPlatform();
            PolicyManager policyManager = PolicyManager.INSTANCE;
            Context context = this.f7726a;
            policyManager.saveAgreeStatus(context, 1);
            PolicyManager.autoUploadRecord(context, this.f7727b, this.f7728c, this.f7729d, this.f7730e, this.f7731f, "1");
            this.h.onPermissionClick(dialogInterface, z, true);
        }

        @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnThreeButtonClickListener
        public final void onFullAgreeClick(DialogInterface dialogInterface, boolean z, Map<String, Boolean> map) {
            SocketHookUtil.recoveryPlatform();
            PolicyManager.INSTANCE.saveAgreeStatus(this.f7726a, 1);
            PolicyManager.autoUploadRecord(this.f7726a, this.f7727b, this.f7728c, this.f7729d, this.f7730e, this.f7731f, "2");
            this.f7732g.onPermissionClick(dialogInterface, z, true);
        }

        @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnThreeButtonClickListener
        public final void onRejectClick(DialogInterface dialogInterface, boolean z) {
            this.h.onPermissionClick(dialogInterface, z, false);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class e implements g0.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7733a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f7734b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g0.a f7735c;

        public e(String str, Context context, g0.a aVar) {
            this.f7733a = str;
            this.f7734b = context;
            this.f7735c = aVar;
        }

        @Override // stepos.support.v7.app.g0.a
        public final void onPermissionClick(DialogInterface dialogInterface, boolean z, boolean z3) {
            if (z3 && this.f7733a.equals("2")) {
                SocketHookUtil.recoveryPlatform();
                PolicyManager.INSTANCE.saveAgreeStatus(this.f7734b, 1);
            }
            this.f7735c.onPermissionClick(dialogInterface, z, z3);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class f implements g0.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f7742a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7743b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f7744c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f7745d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String[] f7746e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f7747f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ g0.a f7748g;

        public f(Context context, String str, String str2, String str3, String[] strArr, String str4, g0.a aVar) {
            this.f7742a = context;
            this.f7743b = str;
            this.f7744c = str2;
            this.f7745d = str3;
            this.f7746e = strArr;
            this.f7747f = str4;
            this.f7748g = aVar;
        }

        @Override // stepos.support.v7.app.g0.a
        public final void onPermissionClick(DialogInterface dialogInterface, boolean z, boolean z3) {
            String str = z3 ? "2" : "0";
            if (z3) {
                PolicyManager.autoUploadRecord(this.f7742a, this.f7743b, this.f7744c, this.f7745d, this.f7746e, this.f7747f, str);
            }
            this.f7748g.onPermissionClick(dialogInterface, z, z3);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class g implements g0.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7749a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f7750b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f7751c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f7752d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f7753e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String[] f7754f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f7755g;
        public final /* synthetic */ g0.a h;

        public g(String str, Context context, String str2, String str3, String str4, String[] strArr, String str5, g0.a aVar) {
            this.f7749a = str;
            this.f7750b = context;
            this.f7751c = str2;
            this.f7752d = str3;
            this.f7753e = str4;
            this.f7754f = strArr;
            this.f7755g = str5;
            this.h = aVar;
        }

        @Override // stepos.support.v7.app.g0.a
        public final void onPermissionClick(DialogInterface dialogInterface, boolean z, boolean z3) {
            if (z3) {
                String str = this.f7749a;
                boolean zEquals = str.equals("1");
                Context context = this.f7750b;
                if (zEquals) {
                    SocketHookUtil.recoveryPlatform();
                    PolicyManager.INSTANCE.saveAgreeStatus(context, 1);
                }
                PolicyManager.autoUploadRecord(context, this.f7751c, this.f7752d, this.f7753e, this.f7754f, this.f7755g, str);
            }
            this.h.onPermissionClick(dialogInterface, z, z3);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {398}, m = "getAgreeStatus")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getAgreeStatus$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04151 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f7756a;

        /* renamed from: c, reason: collision with root package name */
        public int f7758c;

        public C04151(qb.b<? super C04151> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7756a = obj;
            this.f7758c |= Integer.MIN_VALUE;
            return PolicyManager.this.getAgreeStatus(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1", f = "PolicyManager.kt", l = {2602}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04171 extends SuspendLambda implements p<CoroutineScope, qb.b<? super String>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f7763a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f7764b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f7765c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04171(Context context, String str, qb.b<? super C04171> bVar) {
            super(2, bVar);
            this.f7764b = context;
            this.f7765c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new C04171(this.f7764b, this.f7765c, bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super String> bVar) {
            return ((C04171) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.f7763a;
            if (i10 == 0) {
                kotlin.c.b(obj);
                final Flow<T> flow = ((PreferenceDataStore) com.stepos.policy.sdk.c.a(this.f7764b)).f1709a.f1677d;
                final String str = this.f7765c;
                Flow<String> flow2 = new Flow<String>() { // from class: com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1

                    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
                    /* renamed from: com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {

                        /* renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ FlowCollector f7664a;

                        /* renamed from: b, reason: collision with root package name */
                        public final /* synthetic */ String f7665b;

                        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
                        @rb.c(c = "com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1$2", f = "PolicyManager.kt", l = {223}, m = "emit")
                        /* renamed from: com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        public static final class AnonymousClass1 extends ContinuationImpl {

                            /* renamed from: a, reason: collision with root package name */
                            public /* synthetic */ Object f7666a;

                            /* renamed from: b, reason: collision with root package name */
                            public int f7667b;

                            public AnonymousClass1(qb.b bVar) {
                                super(bVar);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.f7666a = obj;
                                this.f7667b |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector, String str) {
                            this.f7664a = flowCollector;
                            this.f7665b = str;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r5, qb.b r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.f7667b
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.f7667b = r1
                                goto L18
                            L13:
                                com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.f7666a
                                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                                int r2 = r0.f7667b
                                r3 = 1
                                if (r2 == 0) goto L2f
                                if (r2 != r3) goto L27
                                kotlin.c.b(r6)
                                goto L57
                            L27:
                                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                                r4.<init>(r5)
                                throw r4
                            L2f:
                                kotlin.c.b(r6)
                                g1.a r5 = (g1.a) r5
                                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                                java.lang.String r2 = "local_"
                                r6.<init>(r2)
                                java.lang.String r2 = r4.f7665b
                                r6.append(r2)
                                java.lang.String r6 = r6.toString()
                                g1.a$a r6 = a4.a.v(r6)
                                java.lang.Object r5 = r5.b(r6)
                                r0.f7667b = r3
                                kotlinx.coroutines.flow.FlowCollector r4 = r4.f7664a
                                java.lang.Object r4 = r4.emit(r5, r0)
                                if (r4 != r1) goto L57
                                return r1
                            L57:
                                lb.n r4 = lb.n.f10413a
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, qb.b):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    public final Object collect(FlowCollector<? super String> flowCollector, qb.b bVar) {
                        Object objCollect = flow.collect(new AnonymousClass2(flowCollector, str), bVar);
                        return objCollect == CoroutineSingletons.f10059a ? objCollect : n.f10413a;
                    }
                };
                this.f7763a = 1;
                obj = FlowKt.first(flow2, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            String strValueOf = String.valueOf(obj);
            return strValueOf.equals("null") ? "" : strValueOf;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager$getPolicyByVersion$1", f = "PolicyManager.kt", l = {2325, 2335}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyByVersion$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04181 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public PolicySdkResultBean f7766a;

        /* renamed from: b, reason: collision with root package name */
        public int f7767b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Long f7768c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f7769d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f7770e;
        public final /* synthetic */ String h;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ zb.l<PolicySdkResultBean, PolicySdkResultBean> f7771j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ String f7772k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C04181(Long l10, String str, String str2, String str3, zb.l<? super PolicySdkResultBean, PolicySdkResultBean> lVar, String str4, qb.b<? super C04181> bVar) {
            super(2, bVar);
            this.f7768c = l10;
            this.f7769d = str;
            this.f7770e = str2;
            this.h = str3;
            this.f7771j = lVar;
            this.f7772k = str4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new C04181(this.f7768c, this.f7769d, this.f7770e, this.h, this.f7771j, this.f7772k, bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C04181) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x00c3, code lost:
        
            if (r0 == r11) goto L32;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r7v6, types: [T, com.stepos.policy.sdk.bean.PolicyVersionResponse] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                Method dump skipped, instructions count: 386
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C04181.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager$getPolicyData$1", f = "PolicyManager.kt", l = {2139, 2148}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04191 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public PolicySdkResultBean f7779a;

        /* renamed from: b, reason: collision with root package name */
        public int f7780b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f7781c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Long f7782d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f7783e;
        public final /* synthetic */ String h;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f7784j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ zb.l<PolicySdkResultBean, n> f7785k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ String f7786l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C04191(String str, Long l10, String str2, String str3, String str4, zb.l<? super PolicySdkResultBean, n> lVar, String str5, qb.b<? super C04191> bVar) {
            super(2, bVar);
            this.f7781c = str;
            this.f7782d = l10;
            this.f7783e = str2;
            this.h = str3;
            this.f7784j = str4;
            this.f7785k = lVar;
            this.f7786l = str5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new C04191(this.f7781c, this.f7782d, this.f7783e, this.h, this.f7784j, this.f7785k, this.f7786l, bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C04191) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:45:0x00eb, code lost:
        
            if (r0 == r12) goto L46;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v19, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r5v2, types: [T, com.stepos.policy.sdk.bean.PolicyNewestResponse] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r26) {
            /*
                Method dump skipped, instructions count: 496
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C04191.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager$getPolicyHistoryList$1", f = "PolicyManager.kt", l = {2239, 2249}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyHistoryList$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04201 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public PolicySdkResultBean f7794a;

        /* renamed from: b, reason: collision with root package name */
        public int f7795b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f7796c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f7797d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f7798e;
        public final /* synthetic */ String h;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ zb.l<PolicySdkResultBean, PolicySdkResultBean> f7799j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ String f7800k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ long f7801l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C04201(String str, String str2, String str3, String str4, zb.l<? super PolicySdkResultBean, PolicySdkResultBean> lVar, String str5, long j10, qb.b<? super C04201> bVar) {
            super(2, bVar);
            this.f7796c = str;
            this.f7797d = str2;
            this.f7798e = str3;
            this.h = str4;
            this.f7799j = lVar;
            this.f7800k = str5;
            this.f7801l = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new C04201(this.f7796c, this.f7797d, this.f7798e, this.h, this.f7799j, this.f7800k, this.f7801l, bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C04201) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x00cb, code lost:
        
            if (r0 == r11) goto L33;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r7v6, types: [T, com.stepos.policy.sdk.bean.PolicyHistoryListResponse] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                Method dump skipped, instructions count: 388
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C04201.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {371}, m = "getPolicyOperate")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyOperate$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04211 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f7809a;

        /* renamed from: c, reason: collision with root package name */
        public int f7811c;

        public C04211(qb.b<? super C04211> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7809a = obj;
            this.f7811c |= Integer.MIN_VALUE;
            return PolicyManager.this.getPolicyOperate(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager$getPolicyServiceConfig$1", f = "PolicyManager.kt", l = {2623, 2633}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyServiceConfig$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04221 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public PolicySdkResultBean f7812a;

        /* renamed from: b, reason: collision with root package name */
        public int f7813b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f7814c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f7815d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f7816e;
        public final /* synthetic */ zb.l<PolicySdkResultBean, PolicySdkResultBean> h;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f7817j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ Context f7818k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C04221(String str, String str2, String str3, zb.l<? super PolicySdkResultBean, PolicySdkResultBean> lVar, String str4, Context context, qb.b<? super C04221> bVar) {
            super(2, bVar);
            this.f7814c = str;
            this.f7815d = str2;
            this.f7816e = str3;
            this.h = lVar;
            this.f7817j = str4;
            this.f7818k = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new C04221(this.f7814c, this.f7815d, this.f7816e, this.h, this.f7817j, this.f7818k, bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C04221) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x00bf, code lost:
        
            if (r0 == r11) goto L29;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r4v6, types: [T, com.stepos.policy.sdk.bean.PolicyServiceConfigResponse] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instructions count: 389
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C04221.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class h implements g0.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f7825a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f7826b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f7827c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f7828d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f7829e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String[] f7830f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f7831g;
        public final /* synthetic */ g0.a h;

        public h(boolean z, Context context, String str, String str2, String str3, String[] strArr, String str4, g0.a aVar) {
            this.f7825a = z;
            this.f7826b = context;
            this.f7827c = str;
            this.f7828d = str2;
            this.f7829e = str3;
            this.f7830f = strArr;
            this.f7831g = str4;
            this.h = aVar;
        }

        @Override // stepos.support.v7.app.g0.a
        public final void onPermissionClick(DialogInterface dialogInterface, boolean z, boolean z3) {
            if (z3 && this.f7825a) {
                PolicyManager.autoUploadRecord(this.f7826b, this.f7827c, this.f7828d, this.f7829e, this.f7830f, this.f7831g, "2");
            }
            this.h.onPermissionClick(dialogInterface, z, z3);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class i implements g0.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f7832a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7833b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f7834c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f7835d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String[] f7836e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f7837f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ g0.a f7838g;

        public i(Context context, String str, String str2, String str3, String[] strArr, String str4, g0.a aVar) {
            this.f7832a = context;
            this.f7833b = str;
            this.f7834c = str2;
            this.f7835d = str3;
            this.f7836e = strArr;
            this.f7837f = str4;
            this.f7838g = aVar;
        }

        @Override // stepos.support.v7.app.g0.a
        public final void onPermissionClick(DialogInterface dialogInterface, boolean z, boolean z3) {
            String str = z3 ? "2" : "0";
            if (z3) {
                PolicyManager.autoUploadRecord(this.f7832a, this.f7833b, this.f7834c, this.f7835d, this.f7836e, this.f7837f, str);
            }
            this.f7838g.onPermissionClick(dialogInterface, z, z3);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {1903}, m = "initPolicyNewestPath")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$initPolicyNewestPath$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04241 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Context f7839a;

        /* renamed from: b, reason: collision with root package name */
        public String f7840b;

        /* renamed from: c, reason: collision with root package name */
        public String f7841c;

        /* renamed from: d, reason: collision with root package name */
        public PolicySdkResultBean f7842d;

        /* renamed from: e, reason: collision with root package name */
        public PolicyNewestPathResultBean f7843e;
        public String h;

        /* renamed from: j, reason: collision with root package name */
        public /* synthetic */ Object f7844j;

        /* renamed from: k, reason: collision with root package name */
        public int f7845k;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7844j = obj;
            this.f7845k |= Integer.MIN_VALUE;
            return PolicyManager.initPolicyNewestPath(null, null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager$initSDK$1", f = "PolicyManager.kt", l = {293, 294}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$initSDK$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04251 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f7846a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f7847b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04251(Context context, qb.b<? super C04251> bVar) {
            super(2, bVar);
            this.f7847b = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new C04251(this.f7847b, bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C04251) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:
        
            if (r6.loadCloudPolicyUidCategoryMap(r2, r5) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r5.f7846a
                android.content.Context r2 = r5.f7847b
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L1e
                if (r1 == r4) goto L1a
                if (r1 != r3) goto L12
                kotlin.c.b(r6)
                goto L40
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1a:
                kotlin.c.b(r6)
                goto L2c
            L1e:
                kotlin.c.b(r6)
                com.stepos.policy.sdk.PolicyManager r6 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                r5.f7846a = r4
                java.lang.Object r6 = r6.getAgreeStatus(r2, r5)
                if (r6 != r0) goto L2c
                goto L3f
            L2c:
                java.lang.Number r6 = (java.lang.Number) r6
                int r6 = r6.intValue()
                com.stepos.policy.sdk.util.PolicySdkNetworkGate.updateAgreeStatusCache(r6)
                com.stepos.policy.sdk.PolicyManager r6 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                r5.f7846a = r3
                java.lang.Object r5 = com.stepos.policy.sdk.PolicyManager.access$loadCloudPolicyUidCategoryMap(r6, r2, r5)
                if (r5 != r0) goto L40
            L3f:
                return r0
            L40:
                lb.n r5 = lb.n.f10413a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C04251.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager$initSDK$2", f = "PolicyManager.kt", l = {305}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$initSDK$2, reason: invalid class name and case insensitive filesystem */
    public static final class C04262 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f7848a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f7849b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ HashMap<String, String> f7850c;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        @rb.c(c = "com.stepos.policy.sdk.PolicyManager$initSDK$2$1", f = "PolicyManager.kt", l = {318}, m = "invokeSuspend")
        /* renamed from: com.stepos.policy.sdk.PolicyManager$initSDK$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public Iterator f7851a;

            /* renamed from: b, reason: collision with root package name */
            public String f7852b;

            /* renamed from: c, reason: collision with root package name */
            public int f7853c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Context f7854d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ HashMap<String, String> f7855e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Context context, HashMap<String, String> map, qb.b<? super AnonymousClass1> bVar) {
                super(2, bVar);
                this.f7854d = context;
                this.f7855e = map;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final qb.b<n> create(Object obj, qb.b<?> bVar) {
                return new AnonymousClass1(this.f7854d, this.f7855e, bVar);
            }

            @Override // zb.p
            public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
                return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0053  */
            /* JADX WARN: Removed duplicated region for block: B:15:0x009f  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0085 -> B:14:0x0088). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                /*
                    r11 = this;
                    kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                    int r1 = r11.f7853c
                    java.lang.String r2 = " *************** policyKey = "
                    java.util.HashMap<java.lang.String, java.lang.String> r3 = r11.f7855e
                    android.content.Context r4 = r11.f7854d
                    r5 = 1
                    java.lang.String r6 = "initSDK"
                    if (r1 == 0) goto L21
                    if (r1 != r5) goto L19
                    java.lang.String r1 = r11.f7852b
                    java.util.Iterator r7 = r11.f7851a
                    kotlin.c.b(r12)
                    goto L88
                L19:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r12)
                    throw r11
                L21:
                    kotlin.c.b(r12)
                    com.stepos.policy.sdk.PolicyManager r12 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                    r1 = 0
                    r12.setSyncLocalFileFinished(r1)
                    com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r1 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    java.lang.String r8 = "syncLocalFileFinished start time = "
                    r7.<init>(r8)
                    long r8 = java.lang.System.currentTimeMillis()
                    r7.append(r8)
                    java.lang.String r7 = r7.toString()
                    r1.d(r6, r7)
                    com.stepos.policy.sdk.PolicyManager.access$selfCheckLocalAssets(r12, r4, r3)
                    java.util.Set r12 = r3.entrySet()
                    java.util.Iterator r12 = r12.iterator()
                    r7 = r12
                L4d:
                    boolean r12 = r7.hasNext()
                    if (r12 == 0) goto L9f
                    java.lang.Object r12 = r7.next()
                    java.util.Map$Entry r12 = (java.util.Map.Entry) r12
                    java.lang.Object r1 = r12.getKey()
                    java.lang.String r1 = (java.lang.String) r1
                    java.lang.Object r12 = r12.getValue()
                    java.lang.String r12 = (java.lang.String) r12
                    com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r8 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder
                    r9.<init>(r2)
                    r9.append(r1)
                    java.lang.String r10 = " start***************"
                    r9.append(r10)
                    java.lang.String r9 = r9.toString()
                    r8.d(r6, r9)
                    r11.f7851a = r7
                    r11.f7852b = r1
                    r11.f7853c = r5
                    java.lang.Object r12 = com.stepos.policy.sdk.PolicyManager.initPolicyNewestPath(r4, r12, r1, r11)
                    if (r12 != r0) goto L88
                    return r0
                L88:
                    com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r12 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder
                    r8.<init>(r2)
                    r8.append(r1)
                    java.lang.String r1 = " end ***************"
                    r8.append(r1)
                    java.lang.String r1 = r8.toString()
                    r12.d(r6, r1)
                    goto L4d
                L9f:
                    com.stepos.policy.sdk.PolicyManager r11 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                    r11.setSyncLocalFileFinished(r5)
                    com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r11 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion
                    java.lang.StringBuilder r12 = new java.lang.StringBuilder
                    java.lang.String r0 = ">>> DONE syncLocalFileFinished=true, storage="
                    r12.<init>(r0)
                    java.io.File r0 = r4.getDataDir()
                    if (r0 == 0) goto Lb8
                    java.lang.String r0 = r0.getPath()
                    goto Lb9
                Lb8:
                    r0 = 0
                Lb9:
                    r12.append(r0)
                    java.lang.String r0 = ", categories="
                    r12.append(r0)
                    java.util.Set r0 = r3.keySet()
                    r12.append(r0)
                    java.lang.String r12 = r12.toString()
                    r11.i(r6, r12)
                    lb.n r11 = lb.n.f10413a
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C04262.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04262(Context context, HashMap<String, String> map, qb.b<? super C04262> bVar) {
            super(2, bVar);
            this.f7849b = context;
            this.f7850c = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new C04262(this.f7849b, this.f7850c, bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C04262) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.f7848a;
            if (i10 == 0) {
                kotlin.c.b(obj);
                CoroutineDispatcher io = Dispatchers.getIO();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f7849b, this.f7850c, null);
                this.f7848a = 1;
                if (BuildersKt.withContext(io, anonymousClass1, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            return n.f10413a;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class j implements g0.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f7856a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7857b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f7858c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f7859d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String[] f7860e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f7861f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ g0.a f7862g;

        public j(Context context, String str, String str2, String str3, String[] strArr, String str4, g0.a aVar) {
            this.f7856a = context;
            this.f7857b = str;
            this.f7858c = str2;
            this.f7859d = str3;
            this.f7860e = strArr;
            this.f7861f = str4;
            this.f7862g = aVar;
        }

        @Override // stepos.support.v7.app.g0.a
        public final void onPermissionClick(DialogInterface dialogInterface, boolean z, boolean z3) {
            String str = z3 ? "2" : "0";
            if (z3) {
                PolicyManager.autoUploadRecord(this.f7856a, this.f7857b, this.f7858c, this.f7859d, this.f7860e, this.f7861f, str);
            }
            this.f7862g.onPermissionClick(dialogInterface, z, z3);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class k implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<stepos.support.v7.app.e> f7863a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener f7864b;

        public k(Ref$ObjectRef<stepos.support.v7.app.e> ref$ObjectRef, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
            this.f7863a = ref$ObjectRef;
            this.f7864b = onPermissionClickListener;
        }

        @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
        public final void onPermissionClick(DialogInterface dialogInterface, boolean z, boolean z3) {
            try {
                stepos.support.v7.app.e eVar = this.f7863a.f10076a;
                View viewFindViewById = eVar != null ? eVar.findViewById(R.id.stepos_permission_dialog_checkbox_first) : null;
                kotlin.jvm.internal.g.d(viewFindViewById, "null cannot be cast to non-null type android.widget.CheckBox");
                this.f7864b.onPermissionClick(dialogInterface, ((CheckBox) viewFindViewById).isChecked(), z3);
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class l implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<stepos.support.v7.app.e> f7865a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener f7866b;

        public l(Ref$ObjectRef<stepos.support.v7.app.e> ref$ObjectRef, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
            this.f7865a = ref$ObjectRef;
            this.f7866b = onPermissionClickListener;
        }

        @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
        public final void onPermissionClick(DialogInterface dialogInterface, boolean z, boolean z3) {
            Ref$ObjectRef<stepos.support.v7.app.e> ref$ObjectRef = this.f7865a;
            try {
                stepos.support.v7.app.e eVar = ref$ObjectRef.f10076a;
                View viewFindViewById = eVar != null ? eVar.findViewById(R.id.stepos_permission_dialog_checkbox_first) : null;
                kotlin.jvm.internal.g.d(viewFindViewById, "null cannot be cast to non-null type android.widget.CheckBox");
                boolean zIsChecked = ((CheckBox) viewFindViewById).isChecked();
                stepos.support.v7.app.e eVar2 = ref$ObjectRef.f10076a;
                View viewFindViewById2 = eVar2 != null ? eVar2.findViewById(R.id.stepos_permission_dialog_checkbox_second) : null;
                kotlin.jvm.internal.g.d(viewFindViewById2, "null cannot be cast to non-null type android.widget.CheckBox");
                this.f7866b.onPermissionClick(dialogInterface, z3, zIsChecked, ((CheckBox) viewFindViewById2).isChecked());
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {KeyCenterException.CODE_NOT_REGISTERED}, m = "loadCloudPolicyUidCategoryMap")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$loadCloudPolicyUidCategoryMap$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04271 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f7867a;

        /* renamed from: c, reason: collision with root package name */
        public int f7869c;

        public C04271(qb.b<? super C04271> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7867a = obj;
            this.f7869c |= Integer.MIN_VALUE;
            return PolicyManager.this.loadCloudPolicyUidCategoryMap(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class m extends kotlin.coroutines.a implements CoroutineExceptionHandler {
        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(kotlin.coroutines.d dVar, Throwable th) {
            PolicySdkLogUtils.Companion.d("exceptionHandler", dVar.get(CoroutineName.Key) + " 处理异常 ：" + th);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager$persistCloudPolicyUidCategoryMap$1", f = "PolicyManager.kt", l = {425}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$persistCloudPolicyUidCategoryMap$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04281 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f7870a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f7871b;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        @rb.c(c = "com.stepos.policy.sdk.PolicyManager$persistCloudPolicyUidCategoryMap$1$1", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.stepos.policy.sdk.PolicyManager$persistCloudPolicyUidCategoryMap$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00671 extends SuspendLambda implements p<MutablePreferences, qb.b<? super n>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f7872a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f7873b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00671(String str, qb.b<? super C00671> bVar) {
                super(2, bVar);
                this.f7873b = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final qb.b<n> create(Object obj, qb.b<?> bVar) {
                C00671 c00671 = new C00671(this.f7873b, bVar);
                c00671.f7872a = obj;
                return c00671;
            }

            @Override // zb.p
            public final Object invoke(MutablePreferences mutablePreferences, qb.b<? super n> bVar) {
                return ((C00671) create(mutablePreferences, bVar)).invokeSuspend(n.f10413a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
                kotlin.c.b(obj);
                MutablePreferences mutablePreferences = (MutablePreferences) this.f7872a;
                a.C0083a<String> key = com.stepos.policy.sdk.c.f7970g;
                String json = this.f7873b;
                kotlin.jvm.internal.g.e(json, "json");
                mutablePreferences.getClass();
                kotlin.jvm.internal.g.f(key, "key");
                mutablePreferences.c(key, json);
                return n.f10413a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04281(Context context, qb.b<? super C04281> bVar) {
            super(2, bVar);
            this.f7871b = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new C04281(this.f7871b, bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C04281) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.f7870a;
            try {
                if (i10 == 0) {
                    kotlin.c.b(obj);
                    String strH = new d5.i().h(PolicyCloudPolicyIndex.snapshot());
                    d1.c cVarA = com.stepos.policy.sdk.c.a(this.f7871b);
                    C00671 c00671 = new C00671(strH, null);
                    this.f7870a = 1;
                    if (PreferencesKt.a(cVarA, c00671, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.c.b(obj);
                }
            } catch (Exception e10) {
                PolicySdkLogUtils.Companion.e("CloudPolicyIndex", "persist failed: " + e10);
            }
            return n.f10413a;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager$reTryUploadRecord$1", f = "PolicyManager.kt", l = {1132, 1135}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$reTryUploadRecord$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04291 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f7874a;

        /* renamed from: b, reason: collision with root package name */
        public int f7875b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f7876c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ PolicyManager f7877d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04291(PolicyManager policyManager, Context context, qb.b bVar) {
            super(2, bVar);
            this.f7876c = context;
            this.f7877d = policyManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new C04291(this.f7877d, this.f7876c, bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C04291) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x007c  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r9.f7875b
                java.lang.String r2 = "isNeedReTry= "
                java.lang.String r3 = "reTryUploadRecord"
                r4 = 2
                android.content.Context r5 = r9.f7876c
                r6 = 1
                if (r1 == 0) goto L24
                if (r1 == r6) goto L20
                if (r1 != r4) goto L18
                int r0 = r9.f7874a
                kotlin.c.b(r10)
                goto L5b
            L18:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L20:
                kotlin.c.b(r10)
                goto L32
            L24:
                kotlin.c.b(r10)
                com.stepos.policy.sdk.PolicyManager r10 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                r9.f7875b = r6
                java.lang.Object r10 = r10.getPolicyOperate(r5, r9)
                if (r10 != r0) goto L32
                goto L59
            L32:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                r1 = r10 ^ 1
                com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r7 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>(r2)
                r8.append(r1)
                java.lang.String r8 = r8.toString()
                r7.d(r3, r8)
                if (r10 != 0) goto La4
                com.stepos.policy.sdk.PolicyManager r10 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                r9.f7874a = r1
                r9.f7875b = r4
                java.lang.Object r10 = r10.getPolicyOperateJson(r5, r9)
                if (r10 != r0) goto L5a
            L59:
                return r0
            L5a:
                r0 = r1
            L5b:
                java.lang.String r10 = (java.lang.String) r10
                if (r10 == 0) goto La4
                int r1 = r10.length()
                if (r1 <= 0) goto La4
                d5.i r1 = new d5.i
                r1.<init>()
                java.lang.Class<com.stepos.policy.sdk.bean.PolicyRecordRequest> r4 = com.stepos.policy.sdk.bean.PolicyRecordRequest.class
                java.lang.Object r10 = r1.b(r4, r10)
                com.stepos.policy.sdk.bean.PolicyRecordRequest r10 = (com.stepos.policy.sdk.bean.PolicyRecordRequest) r10
                com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r1 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>(r2)
                if (r0 == 0) goto L7c
                goto L7d
            L7c:
                r6 = 0
            L7d:
                r4.append(r6)
                java.lang.String r0 = r4.toString()
                r1.d(r3, r0)
                com.stepos.policy.sdk.PolicyManager r0 = com.stepos.policy.sdk.PolicyManager.INSTANCE
                java.lang.String r1 = r0.getMAppId()
                java.lang.String r2 = r0.getMAppSecret()
                java.lang.String r0 = r0.getMAppVersionName()
                java.lang.String r3 = "policyRecordRequest"
                kotlin.jvm.internal.g.e(r10, r3)
                com.stepos.policy.sdk.PolicyManager$reTryUploadRecord$1$1 r3 = new com.stepos.policy.sdk.PolicyManager$reTryUploadRecord$1$1
                com.stepos.policy.sdk.PolicyManager r9 = r9.f7877d
                r3.<init>()
                com.stepos.policy.sdk.PolicyManager.uploadPolicyOperateRecord(r1, r2, r0, r10, r3)
            La4:
                lb.n r9 = lb.n.f10413a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C04291.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {TraceIdKeys.MAX_LENGTH}, m = "resolveSignSecret")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$resolveSignSecret$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04301 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public String f7884a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f7885b;

        /* renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f7886c;

        /* renamed from: e, reason: collision with root package name */
        public int f7888e;

        public C04301(qb.b<? super C04301> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7886c = obj;
            this.f7888e |= Integer.MIN_VALUE;
            return PolicyManager.this.resolveSignSecret(null, null, null, false, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager$saveAgreeStatus$1", f = "PolicyManager.kt", l = {379}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$saveAgreeStatus$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04311 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f7889a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f7890b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f7891c;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        @rb.c(c = "com.stepos.policy.sdk.PolicyManager$saveAgreeStatus$1$1", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.stepos.policy.sdk.PolicyManager$saveAgreeStatus$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00701 extends SuspendLambda implements p<MutablePreferences, qb.b<? super n>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f7892a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f7893b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00701(int i10, qb.b<? super C00701> bVar) {
                super(2, bVar);
                this.f7893b = i10;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final qb.b<n> create(Object obj, qb.b<?> bVar) {
                C00701 c00701 = new C00701(this.f7893b, bVar);
                c00701.f7892a = obj;
                return c00701;
            }

            @Override // zb.p
            public final Object invoke(MutablePreferences mutablePreferences, qb.b<? super n> bVar) {
                return ((C00701) create(mutablePreferences, bVar)).invokeSuspend(n.f10413a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
                kotlin.c.b(obj);
                MutablePreferences mutablePreferences = (MutablePreferences) this.f7892a;
                a.C0083a<Integer> key = com.stepos.policy.sdk.c.f7968e;
                Integer num = new Integer(this.f7893b);
                mutablePreferences.getClass();
                kotlin.jvm.internal.g.f(key, "key");
                mutablePreferences.c(key, num);
                return n.f10413a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04311(Context context, int i10, qb.b<? super C04311> bVar) {
            super(2, bVar);
            this.f7890b = context;
            this.f7891c = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new C04311(this.f7890b, this.f7891c, bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C04311) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.f7889a;
            try {
                if (i10 == 0) {
                    kotlin.c.b(obj);
                    d1.c cVarA = com.stepos.policy.sdk.c.a(this.f7890b);
                    C00701 c00701 = new C00701(this.f7891c, null);
                    this.f7889a = 1;
                    if (PreferencesKt.a(cVarA, c00701, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.c.b(obj);
                }
            } catch (Exception e10) {
                PolicySdkLogUtils.Companion.e("savePolicyCategoryVersion", "error =" + e10 + ' ');
            }
            return n.f10413a;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager$saveDataStoreString$2", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$saveDataStoreString$2, reason: invalid class name and case insensitive filesystem */
    public static final class C04322 extends SuspendLambda implements p<MutablePreferences, qb.b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f7894a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a.C0083a<String> f7895b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f7896c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04322(a.C0083a<String> c0083a, String str, qb.b<? super C04322> bVar) {
            super(2, bVar);
            this.f7895b = c0083a;
            this.f7896c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            C04322 c04322 = new C04322(this.f7895b, this.f7896c, bVar);
            c04322.f7894a = obj;
            return c04322;
        }

        @Override // zb.p
        public final Object invoke(MutablePreferences mutablePreferences, qb.b<? super n> bVar) {
            return ((C04322) create(mutablePreferences, bVar)).invokeSuspend(n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            kotlin.c.b(obj);
            MutablePreferences mutablePreferences = (MutablePreferences) this.f7894a;
            String str = this.f7896c;
            if (str == null) {
                str = "";
            }
            mutablePreferences.getClass();
            a.C0083a<String> key = this.f7895b;
            kotlin.jvm.internal.g.f(key, "key");
            mutablePreferences.c(key, str);
            return n.f10413a;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager$saveLocalCategoryMd5$1", f = "PolicyManager.kt", l = {2583}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$saveLocalCategoryMd5$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04331 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f7897a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7898b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f7899c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f7900d;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        @rb.c(c = "com.stepos.policy.sdk.PolicyManager$saveLocalCategoryMd5$1$1", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.stepos.policy.sdk.PolicyManager$saveLocalCategoryMd5$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00711 extends SuspendLambda implements p<MutablePreferences, qb.b<? super n>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f7901a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f7902b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f7903c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00711(String str, String str2, qb.b<? super C00711> bVar) {
                super(2, bVar);
                this.f7902b = str;
                this.f7903c = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final qb.b<n> create(Object obj, qb.b<?> bVar) {
                C00711 c00711 = new C00711(this.f7902b, this.f7903c, bVar);
                c00711.f7901a = obj;
                return c00711;
            }

            @Override // zb.p
            public final Object invoke(MutablePreferences mutablePreferences, qb.b<? super n> bVar) {
                return ((C00711) create(mutablePreferences, bVar)).invokeSuspend(n.f10413a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
                kotlin.c.b(obj);
                MutablePreferences mutablePreferences = (MutablePreferences) this.f7901a;
                a.C0083a<?> c0083aV = a4.a.v("local_" + this.f7902b);
                mutablePreferences.getClass();
                mutablePreferences.c(c0083aV, this.f7903c);
                return n.f10413a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04331(Context context, String str, String str2, qb.b bVar) {
            super(2, bVar);
            this.f7898b = str;
            this.f7899c = str2;
            this.f7900d = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new C04331(this.f7900d, this.f7898b, this.f7899c, bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C04331) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.f7897a;
            try {
            } catch (Exception e10) {
                PolicySdkLogUtils.Companion.e("saveLocalCategoryMd5", "error =" + e10 + ' ');
            }
            if (i10 == 0) {
                kotlin.c.b(obj);
                PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                String str = this.f7898b;
                String str2 = this.f7899c;
                companion.d("saveLocalCategoryMd5", ai.onnxruntime.a.l("the ", str, " save local md5 is ", str2));
                if (str2 != null) {
                    if (str2.length() != 0) {
                        d1.c cVarA = com.stepos.policy.sdk.c.a(this.f7900d);
                        C00711 c00711 = new C00711(str, str2, null);
                        this.f7897a = 1;
                        if (PreferencesKt.a(cVarA, c00711, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                }
                return n.f10413a;
            }
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            return n.f10413a;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager", f = "PolicyManager.kt", l = {345, 349}, m = "savePolicyOperate")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$savePolicyOperate$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04341 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Context f7904a;

        /* renamed from: b, reason: collision with root package name */
        public String f7905b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f7906c;

        /* renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f7907d;
        public int h;

        public C04341(qb.b<? super C04341> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7907d = obj;
            this.h |= Integer.MIN_VALUE;
            return PolicyManager.this.savePolicyOperate(null, false, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager$savePolicyOperate$2", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$savePolicyOperate$2, reason: invalid class name and case insensitive filesystem */
    public static final class C04352 extends SuspendLambda implements p<MutablePreferences, qb.b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f7909a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f7910b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04352(boolean z, qb.b<? super C04352> bVar) {
            super(2, bVar);
            this.f7910b = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            C04352 c04352 = new C04352(this.f7910b, bVar);
            c04352.f7909a = obj;
            return c04352;
        }

        @Override // zb.p
        public final Object invoke(MutablePreferences mutablePreferences, qb.b<? super n> bVar) {
            return ((C04352) create(mutablePreferences, bVar)).invokeSuspend(n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            kotlin.c.b(obj);
            MutablePreferences mutablePreferences = (MutablePreferences) this.f7909a;
            a.C0083a<Boolean> key = com.stepos.policy.sdk.c.f7966c;
            Boolean boolValueOf = Boolean.valueOf(this.f7910b);
            mutablePreferences.getClass();
            kotlin.jvm.internal.g.f(key, "key");
            mutablePreferences.c(key, boolValueOf);
            return n.f10413a;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager$savePolicyOperate$3", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$savePolicyOperate$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p<MutablePreferences, qb.b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f7911a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7912b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str, qb.b<? super AnonymousClass3> bVar) {
            super(2, bVar);
            this.f7912b = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.f7912b, bVar);
            anonymousClass3.f7911a = obj;
            return anonymousClass3;
        }

        @Override // zb.p
        public final Object invoke(MutablePreferences mutablePreferences, qb.b<? super n> bVar) {
            return ((AnonymousClass3) create(mutablePreferences, bVar)).invokeSuspend(n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            kotlin.c.b(obj);
            MutablePreferences mutablePreferences = (MutablePreferences) this.f7911a;
            a.C0083a<String> key = com.stepos.policy.sdk.c.f7967d;
            mutablePreferences.getClass();
            kotlin.jvm.internal.g.f(key, "key");
            mutablePreferences.c(key, this.f7912b);
            return n.f10413a;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager$uploadPolicyOperateRecord$1", f = "PolicyManager.kt", l = {504, 513}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$uploadPolicyOperateRecord$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04361 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public PolicySdkResultBean f7913a;

        /* renamed from: b, reason: collision with root package name */
        public int f7914b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f7915c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f7916d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ zb.l<PolicySdkResultBean, n> f7917e;
        public final /* synthetic */ PolicyRecordRequest h;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f7918j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C04361(String str, String str2, zb.l<? super PolicySdkResultBean, n> lVar, PolicyRecordRequest policyRecordRequest, String str3, qb.b<? super C04361> bVar) {
            super(2, bVar);
            this.f7915c = str;
            this.f7916d = str2;
            this.f7917e = lVar;
            this.h = policyRecordRequest;
            this.f7918j = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new C04361(this.f7915c, this.f7916d, this.f7917e, this.h, this.f7918j, bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C04361) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0090 A[Catch: Exception -> 0x0151, TRY_ENTER, TRY_LEAVE, TryCatch #10 {Exception -> 0x0151, blocks: (B:28:0x0076, B:36:0x0090), top: B:96:0x0076 }] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00e8 A[Catch: Exception -> 0x0128, TryCatch #4 {Exception -> 0x0128, blocks: (B:46:0x00dd, B:48:0x00e8, B:50:0x011b, B:52:0x0123, B:56:0x0131, B:55:0x012a, B:57:0x0136), top: B:85:0x00dd }] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0136 A[Catch: Exception -> 0x0128, TRY_LEAVE, TryCatch #4 {Exception -> 0x0128, blocks: (B:46:0x00dd, B:48:0x00e8, B:50:0x011b, B:52:0x0123, B:56:0x0131, B:55:0x012a, B:57:0x0136), top: B:85:0x00dd }] */
        /* JADX WARN: Type inference failed for: r0v12, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instructions count: 401
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.C04361.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager$uploadRecordToCleanServiceData$1", f = "PolicyManager.kt", l = {1282}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$uploadRecordToCleanServiceData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04381 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public PolicyRecordRequest f7925a;

        /* renamed from: b, reason: collision with root package name */
        public int f7926b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f7927c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String[] f7928d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f7929e;
        public final /* synthetic */ String h;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f7930j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ String f7931k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ String f7932l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ ArrayList<DeleteInfoBean> f7933m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ String f7934n;

        /* renamed from: o, reason: collision with root package name */
        public final /* synthetic */ String f7935o;

        /* renamed from: p, reason: collision with root package name */
        public final /* synthetic */ String f7936p;

        /* renamed from: q, reason: collision with root package name */
        public final /* synthetic */ zb.l<PolicySdkResultBean, n> f7937q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C04381(Context context, String[] strArr, String str, String str2, String str3, String str4, String str5, ArrayList<DeleteInfoBean> arrayList, String str6, String str7, String str8, zb.l<? super PolicySdkResultBean, n> lVar, qb.b<? super C04381> bVar) {
            super(2, bVar);
            this.f7927c = context;
            this.f7928d = strArr;
            this.f7929e = str;
            this.h = str2;
            this.f7930j = str3;
            this.f7931k = str4;
            this.f7932l = str5;
            this.f7933m = arrayList;
            this.f7934n = str6;
            this.f7935o = str7;
            this.f7936p = str8;
            this.f7937q = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new C04381(this.f7927c, this.f7928d, this.f7929e, this.h, this.f7930j, this.f7931k, this.f7932l, this.f7933m, this.f7934n, this.f7935o, this.f7936p, this.f7937q, bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C04381) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PolicyRecordRequest policyRecordRequest;
            PolicyRecordRequest policyRecordRequest2;
            ArrayList<DeleteInfoBean> arrayList;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.f7926b;
            Context context = this.f7927c;
            String str = this.f7930j;
            if (i10 == 0) {
                kotlin.c.b(obj);
                PolicyRecordRequest policyRecordRequestCreateRecordRequest = PolicyManager.createRecordRequest(context, this.f7928d, this.f7929e, this.h);
                policyRecordRequestCreateRecordRequest.setVerify_type(str);
                policyRecordRequestCreateRecordRequest.setServiceName(this.f7931k);
                policyRecordRequestCreateRecordRequest.setValidateCode(this.f7932l);
                if (!str.equals("0") && (arrayList = this.f7933m) != null && arrayList.size() > 0) {
                    policyRecordRequestCreateRecordRequest.setDeleteInfoList(arrayList);
                }
                if (!str.equals("1") && !str.equals("3")) {
                    policyRecordRequest2 = policyRecordRequestCreateRecordRequest;
                    PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                    StringBuilder sbQ = a0.a.q("verifyType ", str, " | policyRecordRequest.deleteInfoList = ");
                    sbQ.append(policyRecordRequest2.getDeleteInfoList());
                    companion.d("uploadRecordToCleanServiceData", sbQ.toString());
                    PolicyManager.uploadRecordByCustomRecordRequest(context, this.f7934n, this.f7935o, this.f7936p, policyRecordRequest2, this.f7937q);
                    return n.f10413a;
                }
                PolicyManager policyManager = PolicyManager.INSTANCE;
                a.C0083a<String> c0083a = com.stepos.policy.sdk.c.f7969f;
                this.f7925a = policyRecordRequestCreateRecordRequest;
                this.f7926b = 1;
                Object dataStoreString = policyManager.getDataStoreString(context, c0083a, this);
                if (dataStoreString == coroutineSingletons) {
                    return coroutineSingletons;
                }
                policyRecordRequest = policyRecordRequestCreateRecordRequest;
                obj = dataStoreString;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                policyRecordRequest = this.f7925a;
                kotlin.c.b(obj);
            }
            String str2 = (String) obj;
            if (str2 != null && !TextUtils.isEmpty(str2)) {
                ArrayList<DeleteInfoBean> deleteInfoBeanByGson = PolicySdkToolsUtils.Companion.getDeleteInfoBeanByGson(str2);
                PolicySdkLogUtils.Companion.d("uploadRecordToCleanServiceData", "commonDeleteInfoList = " + deleteInfoBeanByGson);
                policyRecordRequest.setDeleteInfoList(kotlin.collections.a.P0(kotlin.collections.a.D0(policyRecordRequest.getDeleteInfoList(), deleteInfoBeanByGson)));
            }
            policyRecordRequest2 = policyRecordRequest;
            PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
            StringBuilder sbQ2 = a0.a.q("verifyType ", str, " | policyRecordRequest.deleteInfoList = ");
            sbQ2.append(policyRecordRequest2.getDeleteInfoList());
            companion2.d("uploadRecordToCleanServiceData", sbQ2.toString());
            PolicyManager.uploadRecordByCustomRecordRequest(context, this.f7934n, this.f7935o, this.f7936p, policyRecordRequest2, this.f7937q);
            return n.f10413a;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.policy.sdk.PolicyManager$uploadRecordWithoutSecureService$1", f = "PolicyManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.PolicyManager$uploadRecordWithoutSecureService$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04391 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f7938a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String[] f7939b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f7940c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f7941d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f7942e;
        public final /* synthetic */ String h;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f7943j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ ArrayList<DeleteInfoBean> f7944k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ String f7945l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f7946m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ String f7947n;

        /* renamed from: o, reason: collision with root package name */
        public final /* synthetic */ zb.l<PolicySdkResultBean, n> f7948o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C04391(Context context, String[] strArr, String str, String str2, String str3, String str4, String str5, ArrayList<DeleteInfoBean> arrayList, String str6, String str7, String str8, zb.l<? super PolicySdkResultBean, n> lVar, qb.b<? super C04391> bVar) {
            super(2, bVar);
            this.f7938a = context;
            this.f7939b = strArr;
            this.f7940c = str;
            this.f7941d = str2;
            this.f7942e = str3;
            this.h = str4;
            this.f7943j = str5;
            this.f7944k = arrayList;
            this.f7945l = str6;
            this.f7946m = str7;
            this.f7947n = str8;
            this.f7948o = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new C04391(this.f7938a, this.f7939b, this.f7940c, this.f7941d, this.f7942e, this.h, this.f7943j, this.f7944k, this.f7945l, this.f7946m, this.f7947n, this.f7948o, bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C04391) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ArrayList<DeleteInfoBean> arrayList;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            kotlin.c.b(obj);
            PolicyRecordRequest policyRecordRequestCreateRecordRequest = PolicyManager.createRecordRequest(this.f7938a, this.f7939b, this.f7940c, this.f7941d);
            String str = this.f7942e;
            policyRecordRequestCreateRecordRequest.setVerify_type(str);
            policyRecordRequestCreateRecordRequest.setServiceName(this.h);
            policyRecordRequestCreateRecordRequest.setValidateCode(this.f7943j);
            if (!kotlin.jvm.internal.g.b(str, "0") && (arrayList = this.f7944k) != null && arrayList.size() > 0) {
                policyRecordRequestCreateRecordRequest.setDeleteInfoList(arrayList);
            }
            PolicySdkLogUtils.Companion.d("uploadRecordToCleanServiceData", "verifyType " + str + " | policyRecordRequest.deleteInfoList = " + policyRecordRequestCreateRecordRequest.getDeleteInfoList());
            PolicyManager.uploadRecordByCustomRecordRequest(this.f7938a, this.f7945l, this.f7946m, this.f7947n, policyRecordRequestCreateRecordRequest, this.f7948o);
            return n.f10413a;
        }
    }

    static {
        String channelToBrand = PolicySdkToolsUtils.Companion.getChannelToBrand();
        companyCode = channelToBrand;
        brand = channelToBrand;
        model = "";
        osVersion = "";
        exceptionHandler = new m(CoroutineExceptionHandler.Key);
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
    public static final void autoUploadRecord(final Context context, String appId, String appSecret, String versionName, String[] categoryList, String str, String operationType) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(appId, "appId");
        kotlin.jvm.internal.g.f(appSecret, "appSecret");
        kotlin.jvm.internal.g.f(versionName, "versionName");
        kotlin.jvm.internal.g.f(categoryList, "categoryList");
        kotlin.jvm.internal.g.f(operationType, "operationType");
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.f10076a = createRecordRequest(context, categoryList, str, operationType);
        if (PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            uploadPolicyOperateRecord(appId, appSecret, versionName, (PolicyRecordRequest) ref$ObjectRef.f10076a, new zb.l<PolicySdkResultBean, n>() { // from class: com.stepos.policy.sdk.PolicyManager.autoUploadRecord.1

                /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
                @rb.c(c = "com.stepos.policy.sdk.PolicyManager$autoUploadRecord$1$1", f = "PolicyManager.kt", l = {1343}, m = "invokeSuspend")
                /* renamed from: com.stepos.policy.sdk.PolicyManager$autoUploadRecord$1$1, reason: invalid class name and collision with other inner class name */
                final class C00651 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

                    /* renamed from: a, reason: collision with root package name */
                    public int f7688a;

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ PolicySdkResultBean f7689b;

                    /* renamed from: c, reason: collision with root package name */
                    public final /* synthetic */ Ref$ObjectRef<PolicyRecordRequest> f7690c;

                    /* renamed from: d, reason: collision with root package name */
                    public final /* synthetic */ Context f7691d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C00651(PolicySdkResultBean policySdkResultBean, Ref$ObjectRef<PolicyRecordRequest> ref$ObjectRef, Context context, qb.b<? super C00651> bVar) {
                        super(2, bVar);
                        this.f7689b = policySdkResultBean;
                        this.f7690c = ref$ObjectRef;
                        this.f7691d = context;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
                        return new C00651(this.f7689b, this.f7690c, this.f7691d, bVar);
                    }

                    @Override // zb.p
                    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
                        return ((C00651) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        String strH;
                        boolean z;
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
                        int i10 = this.f7688a;
                        if (i10 == 0) {
                            kotlin.c.b(obj);
                            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                            StringBuilder sb2 = new StringBuilder("policySdkResultBean.code ");
                            PolicySdkResultBean policySdkResultBean = this.f7689b;
                            sb2.append(policySdkResultBean.getCode());
                            companion.d("autoUploadRecord", sb2.toString());
                            if (policySdkResultBean.getCode() == 0) {
                                strH = "";
                                z = true;
                            } else {
                                strH = new d5.i().h(this.f7690c.f10076a);
                                kotlin.jvm.internal.g.e(strH, "gson.toJson(policyRecordRequest)");
                                z = false;
                            }
                            companion.d("autoUploadRecord", "isOperateSuccess " + z);
                            PolicyManager policyManager = PolicyManager.INSTANCE;
                            this.f7688a = 1;
                            if (policyManager.savePolicyOperate(this.f7691d, z, strH, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            kotlin.c.b(obj);
                        }
                        return n.f10413a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // zb.l
                public final n invoke(PolicySdkResultBean policySdkResultBean) {
                    PolicySdkResultBean policySdkResultBean2 = policySdkResultBean;
                    kotlin.jvm.internal.g.f(policySdkResultBean2, "policySdkResultBean");
                    BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, PolicyManager.INSTANCE.getExceptionHandler(), null, new C00651(policySdkResultBean2, ref$ObjectRef, context, null), 2, null);
                    return n.f10413a;
                }
            });
        } else {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, exceptionHandler, null, new AnonymousClass2(ref$ObjectRef, context, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x004a -> B:22:0x004d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object awaitSyncLocalFileFinished(qb.b<? super lb.n> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.stepos.policy.sdk.PolicyManager.C04111
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.policy.sdk.PolicyManager$awaitSyncLocalFileFinished$1 r0 = (com.stepos.policy.sdk.PolicyManager.C04111) r0
            int r1 = r0.f7698d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7698d = r1
            goto L18
        L13:
            com.stepos.policy.sdk.PolicyManager$awaitSyncLocalFileFinished$1 r0 = new com.stepos.policy.sdk.PolicyManager$awaitSyncLocalFileFinished$1
            r0.<init>(r10)
        L18:
            java.lang.Object r9 = r0.f7696b
            kotlin.coroutines.intrinsics.CoroutineSingletons r10 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r0.f7698d
            r2 = 200(0xc8, double:9.9E-322)
            r4 = 1
            if (r1 == 0) goto L33
            if (r1 != r4) goto L2b
            long r5 = r0.f7695a
            kotlin.c.b(r9)
            goto L4d
        L2b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L33:
            kotlin.c.b(r9)
            r5 = 0
        L38:
            boolean r9 = com.stepos.policy.sdk.PolicyManager.syncLocalFileFinished
            if (r9 != 0) goto L4f
            r7 = 10000(0x2710, double:4.9407E-320)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 >= 0) goto L4f
            r0.f7695a = r5
            r0.f7698d = r4
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r2, r0)
            if (r9 != r10) goto L4d
            return r10
        L4d:
            long r5 = r5 + r2
            goto L38
        L4f:
            lb.n r9 = lb.n.f10413a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.awaitSyncLocalFileFinished(qb.b):java.lang.Object");
    }

    public static final void checkNewestPolicy(Context context, boolean z, String appId, String appSecret, String language, String category, String versionName, zb.l<? super PolicySdkResultBean, n> callBackPolicyResult) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(appId, "appId");
        kotlin.jvm.internal.g.f(appSecret, "appSecret");
        kotlin.jvm.internal.g.f(language, "language");
        kotlin.jvm.internal.g.f(category, "category");
        kotlin.jvm.internal.g.f(versionName, "versionName");
        kotlin.jvm.internal.g.f(callBackPolicyResult, "callBackPolicyResult");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, exceptionHandler, null, new C04121(context, category, language, z, appId, appSecret, versionName, callBackPolicyResult, null), 2, null);
    }

    public static final String copyPolicyFile(Context context, String category, String toPath) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(category, "category");
        kotlin.jvm.internal.g.f(toPath, "toPath");
        PolicySdkFileUtils.Companion companion = PolicySdkFileUtils.Companion;
        PolicyNewestPathResultBean policyNewestPathResultBeanIsNewestPolicyFileIsExists = companion.isNewestPolicyFileIsExists(context, category);
        PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
        companion2.d("copyPolicyFile", "policyNewestPathResultBean.isExists = " + policyNewestPathResultBeanIsNewestPolicyFileIsExists.isExists());
        String strCopyPolicyFile = policyNewestPathResultBeanIsNewestPolicyFileIsExists.isExists() ? companion.copyPolicyFile(policyNewestPathResultBeanIsNewestPolicyFileIsExists.getNewestPolicyPath(), toPath) : "";
        companion2.d("copyPolicyFile", "successPath = " + strCopyPolicyFile);
        return strCopyPolicyFile;
    }

    private final g0 createReGrantDialogBuilder(Context context, boolean z, boolean z3, String str, String str2, String str3, g0.a aVar) {
        g0 g0Var = new g0(context);
        g0Var.f12118m = str2;
        g0Var.f12109c = str;
        g0Var.f12115j = aVar;
        g0Var.f12117l = z3;
        g0Var.f12112f = new com.stepos.policy.sdk.a(context, z, str2, str3, 0);
        return g0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createReGrantDialogBuilder$lambda$8(Context context, boolean z, String privacyPolicyName, String category, View view) {
        kotlin.jvm.internal.g.f(context, "$context");
        kotlin.jvm.internal.g.f(privacyPolicyName, "$privacyPolicyName");
        kotlin.jvm.internal.g.f(category, "$category");
        openPolicyMethod(context, z, privacyPolicyName, category);
    }

    public static final PolicyRecordRequest createRecordRequest(Context context, String[] categoryList, String str, String operationType) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(categoryList, "categoryList");
        kotlin.jvm.internal.g.f(operationType, "operationType");
        PolicyRecordRequest policyRecordRequest = new PolicyRecordRequest();
        if (readAndroidIdEnabled) {
            String androidId = Settings.System.getString(context.getContentResolver(), "android_id");
            kotlin.jvm.internal.g.e(androidId, "androidId");
            policyRecordRequest.setBusinessId(androidId);
        }
        policyRecordRequest.setType("phone");
        if (str != null) {
            policyRecordRequest.setUseId(str);
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : categoryList) {
            PolicyRecordBaseInfo policyRecordBaseInfo = new PolicyRecordBaseInfo(null, null, null, 7, null);
            policyRecordBaseInfo.setVersion(PolicySdkFileUtils.Companion.getPolicyVersion(context, str2));
            policyRecordBaseInfo.setCategory(str2);
            arrayList.add(policyRecordBaseInfo);
        }
        policyRecordRequest.setBaseInfoList(arrayList);
        policyRecordRequest.setOperation(operationType);
        return policyRecordRequest;
    }

    public static final void encryptCustomDeleteInfoListBySecure(Context context, final ArrayList<CustomDeleteInfoBean> customDeleteInfoList, final zb.l<? super ArrayList<DeleteInfoBean>, n> callBackPolicyResult) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(customDeleteInfoList, "customDeleteInfoList");
        kotlin.jvm.internal.g.f(callBackPolicyResult, "callBackPolicyResult");
        final ArrayList arrayList = new ArrayList();
        WithdrawalManager.INSTANCE.encryptCustomDeleteInfoListBySecure(context, customDeleteInfoList, new zb.l<DeleteInfoBean, n>() { // from class: com.stepos.policy.sdk.PolicyManager.encryptCustomDeleteInfoListBySecure.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // zb.l
            public final n invoke(DeleteInfoBean deleteInfoBean) {
                DeleteInfoBean deleteInfoBean2 = deleteInfoBean;
                kotlin.jvm.internal.g.f(deleteInfoBean2, "deleteInfoBean");
                PolicyManager policyManager = PolicyManager.INSTANCE;
                ArrayList<DeleteInfoBean> arrayList2 = arrayList;
                arrayList2.add(deleteInfoBean2);
                if (arrayList2.size() == customDeleteInfoList.size()) {
                    callBackPolicyResult.invoke(arrayList2);
                }
                return n.f10413a;
            }
        });
    }

    public static final ArrayList<DeleteInfoBean> encryptDeleteInfoWithoutSecureService(Context context, ArrayList<DeleteInfoEncryptMultiBean> customDeleteInfoList) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(customDeleteInfoList, "customDeleteInfoList");
        return WithdrawalManagerWithoutSecureService.INSTANCE.getEncryptByDeleteInfoList(context, customDeleteInfoList);
    }

    public static final void encryptMultiDeleteListBySecure(Context context, final ArrayList<DeleteInfoEncryptMultiBean> customDeleteInfoList, final zb.l<? super ArrayList<DeleteInfoBean>, n> callBackPolicyResult) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(customDeleteInfoList, "customDeleteInfoList");
        kotlin.jvm.internal.g.f(callBackPolicyResult, "callBackPolicyResult");
        final ArrayList arrayList = new ArrayList();
        WithdrawalManager.INSTANCE.encryptMultiCustomDeleteInfoListBySecure(context, customDeleteInfoList, new zb.l<DeleteInfoBean, n>() { // from class: com.stepos.policy.sdk.PolicyManager.encryptMultiDeleteListBySecure.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // zb.l
            public final n invoke(DeleteInfoBean deleteInfoBean) {
                DeleteInfoBean deleteInfoBean2 = deleteInfoBean;
                kotlin.jvm.internal.g.f(deleteInfoBean2, "deleteInfoBean");
                PolicyManager policyManager = PolicyManager.INSTANCE;
                ArrayList<DeleteInfoBean> arrayList2 = arrayList;
                arrayList2.add(deleteInfoBean2);
                if (arrayList2.size() == customDeleteInfoList.size()) {
                    callBackPolicyResult.invoke(arrayList2);
                }
                return n.f10413a;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PolicyNewestPathResultBean findNewestPolicyFile(Context context, String str) {
        Context contextResolvePolicyContext = resolvePolicyContext(context);
        PolicySdkFileUtils.Companion companion = PolicySdkFileUtils.Companion;
        PolicyNewestPathResultBean policyNewestPathResultBeanIsNewestPolicyFileIsExists = companion.isNewestPolicyFileIsExists(contextResolvePolicyContext, str);
        if (!policyNewestPathResultBeanIsNewestPolicyFileIsExists.isExists()) {
            Context alternateContext = isDeviceProtectedStorageContext(contextResolvePolicyContext) ? context.getApplicationContext() : context.getApplicationContext().createDeviceProtectedStorageContext();
            kotlin.jvm.internal.g.e(alternateContext, "alternateContext");
            PolicyNewestPathResultBean policyNewestPathResultBeanIsNewestPolicyFileIsExists2 = companion.isNewestPolicyFileIsExists(alternateContext, str);
            if (policyNewestPathResultBeanIsNewestPolicyFileIsExists2.isExists()) {
                PolicySdkLogUtils.Companion.d("PolicyManager", "findNewestPolicyFile fallback hit: " + policyNewestPathResultBeanIsNewestPolicyFileIsExists2.getNewestPolicyPath());
                return policyNewestPathResultBeanIsNewestPolicyFileIsExists2;
            }
        }
        return policyNewestPathResultBeanIsNewestPolicyFileIsExists;
    }

    public static final void getCommonDeleteInfoList(Context mContext, String businessType, int i10) {
        kotlin.jvm.internal.g.f(mContext, "mContext");
        kotlin.jvm.internal.g.f(businessType, "businessType");
        final Context context = (Context) new WeakReference(mContext.getApplicationContext()).get();
        WithdrawalManager.INSTANCE.getCommonDeleteInfoListBySecure(mContext, businessType, i10, new zb.l<String, n>() { // from class: com.stepos.policy.sdk.PolicyManager.getCommonDeleteInfoList.1

            /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
            @rb.c(c = "com.stepos.policy.sdk.PolicyManager$getCommonDeleteInfoList$1$1", f = "PolicyManager.kt", l = {2457}, m = "invokeSuspend")
            /* renamed from: com.stepos.policy.sdk.PolicyManager$getCommonDeleteInfoList$1$1, reason: invalid class name and collision with other inner class name */
            final class C00661 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public int f7760a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ String f7761b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ Context f7762c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00661(Context context, String str, qb.b bVar) {
                    super(2, bVar);
                    this.f7761b = str;
                    this.f7762c = context;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final qb.b<n> create(Object obj, qb.b<?> bVar) {
                    return new C00661(this.f7762c, this.f7761b, bVar);
                }

                @Override // zb.p
                public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
                    return ((C00661) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
                    int i10 = this.f7760a;
                    if (i10 == 0) {
                        kotlin.c.b(obj);
                        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                        StringBuilder sb2 = new StringBuilder("result = ");
                        String str = this.f7761b;
                        sb2.append(str);
                        companion.d("getCommonDeleteInfoList", sb2.toString());
                        Context context = this.f7762c;
                        if (context != null) {
                            PolicyManager policyManager = PolicyManager.INSTANCE;
                            a.C0083a<String> c0083a = com.stepos.policy.sdk.c.f7969f;
                            this.f7760a = 1;
                            if (policyManager.saveDataStoreString(context, c0083a, str, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.c.b(obj);
                    }
                    return n.f10413a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // zb.l
            public final n invoke(String str) {
                String deleteInfoListJson = str;
                kotlin.jvm.internal.g.f(deleteInfoListJson, "deleteInfoListJson");
                PolicyManager policyManager = PolicyManager.INSTANCE;
                BuildersKt__Builders_commonKt.launch$default(policyManager.getLifecycleScope(), policyManager.getExceptionHandler(), null, new C00661(context, deleteInfoListJson, null), 2, null);
                return n.f10413a;
            }
        });
    }

    private final String getLocalCategoryMd5(Context context, String str) {
        return (String) BuildersKt__BuildersKt.runBlocking$default(null, new C04171(context, str, null), 1, null);
    }

    public static final void getPolicyByVersion(String appId, String appSecret, String language, Long l10, String str, zb.l<? super PolicySdkResultBean, PolicySdkResultBean> callBackPolicyResult) {
        kotlin.jvm.internal.g.f(appId, "appId");
        kotlin.jvm.internal.g.f(appSecret, "appSecret");
        kotlin.jvm.internal.g.f(language, "language");
        kotlin.jvm.internal.g.f(callBackPolicyResult, "callBackPolicyResult");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, exceptionHandler, null, new C04181(l10, str, appId, appSecret, callBackPolicyResult, language, null), 2, null);
    }

    public static final void getPolicyData(String appId, String appSecret, String language, String str, Long l10, String str2, zb.l<? super PolicySdkResultBean, n> callBackPolicyResult) {
        kotlin.jvm.internal.g.f(appId, "appId");
        kotlin.jvm.internal.g.f(appSecret, "appSecret");
        kotlin.jvm.internal.g.f(language, "language");
        kotlin.jvm.internal.g.f(callBackPolicyResult, "callBackPolicyResult");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, exceptionHandler, null, new C04191(str, l10, str2, appId, appSecret, callBackPolicyResult, language, null), 2, null);
    }

    public static final void getPolicyHistoryList(String appId, String appSecret, String language, String str, long j10, String str2, zb.l<? super PolicySdkResultBean, PolicySdkResultBean> callBackPolicyResult) {
        kotlin.jvm.internal.g.f(appId, "appId");
        kotlin.jvm.internal.g.f(appSecret, "appSecret");
        kotlin.jvm.internal.g.f(language, "language");
        kotlin.jvm.internal.g.f(callBackPolicyResult, "callBackPolicyResult");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, exceptionHandler, null, new C04201(str, str2, appId, appSecret, callBackPolicyResult, language, j10, null), 2, null);
    }

    public static final String getPolicyHistoryUrl(String appId, String category, long j10, String language) {
        kotlin.jvm.internal.g.f(appId, "appId");
        kotlin.jvm.internal.g.f(category, "category");
        kotlin.jvm.internal.g.f(language, "language");
        StringBuilder sb2 = new StringBuilder("https://policy-h5.stepaos.com/?appId=");
        ai.onnxruntime.a.z(sb2, appId, "&category=", category, "&version=");
        sb2.append(j10);
        sb2.append("&language=");
        sb2.append(language);
        String string = sb2.toString();
        PolicySdkLogUtils.Companion.d("getPolicyHistoryUrl", string);
        return string;
    }

    public static final PolicySdkResultBean getPolicyNewestPath(Context context, String category) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(category, "category");
        PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
        PolicyNewestPathResultBean policyNewestPathResultBeanFindNewestPolicyFile = INSTANCE.findNewestPolicyFile(context, category);
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
            kotlin.jvm.internal.g.e(name, "myFile.name");
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

    public static final PolicySdkResultBean getPolicyNewestPathByCustom(Context context, String category) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(category, "category");
        PolicySdkLogUtils.Companion.d("getPolicyNewestPathByCustom", " initSDKByDeviceProtectedStorageContext= " + initSDKByDeviceProtectedStorageContext);
        return getPolicyNewestPath(context, category);
    }

    public static final void getPolicyServiceConfig(Context context, String appId, String appSecret, String language, String str, zb.l<? super PolicySdkResultBean, PolicySdkResultBean> callBackPolicyResult) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(appId, "appId");
        kotlin.jvm.internal.g.f(appSecret, "appSecret");
        kotlin.jvm.internal.g.f(language, "language");
        kotlin.jvm.internal.g.f(callBackPolicyResult, "callBackPolicyResult");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, exceptionHandler, null, new C04221(str, appId, appSecret, callBackPolicyResult, language, context, null), 2, null);
    }

    public static final void getPrivateDeleteInfoList(Context context, String appId, String businessType, int i10, final zb.l<? super ArrayList<DeleteInfoBean>, n> callBackPolicyResult) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(appId, "appId");
        kotlin.jvm.internal.g.f(businessType, "businessType");
        kotlin.jvm.internal.g.f(callBackPolicyResult, "callBackPolicyResult");
        WithdrawalManager.INSTANCE.getPrivateDeleteInfoListBySecure(context, appId, businessType, i10, new zb.l<ArrayList<DeleteInfoBean>, n>() { // from class: com.stepos.policy.sdk.PolicyManager.getPrivateDeleteInfoList.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // zb.l
            public final n invoke(ArrayList<DeleteInfoBean> arrayList) {
                ArrayList<DeleteInfoBean> arrayList2 = arrayList;
                PolicyManager policyManager = PolicyManager.INSTANCE;
                PolicySdkLogUtils.Companion.d("getPrivateDeleteInfoList", "result = " + arrayList2);
                callBackPolicyResult.invoke(arrayList2);
                return n.f10413a;
            }
        });
    }

    public static final boolean getReadAndroidIdEnabled() {
        return readAndroidIdEnabled;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0139 A[Catch: Exception -> 0x0151, TryCatch #0 {Exception -> 0x0151, blocks: (B:47:0x011f, B:49:0x0139, B:51:0x0144, B:53:0x0149), top: B:57:0x011f }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0149 A[Catch: Exception -> 0x0151, TRY_LEAVE, TryCatch #0 {Exception -> 0x0151, blocks: (B:47:0x011f, B:49:0x0139, B:51:0x0144, B:53:0x0149), top: B:57:0x011f }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object initPolicyNewestPath(android.content.Context r10, java.lang.String r11, java.lang.String r12, qb.b<? super com.stepos.policy.sdk.bean.PolicySdkResultBean> r13) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.initPolicyNewestPath(android.content.Context, java.lang.String, java.lang.String, qb.b):java.lang.Object");
    }

    public static final void initSDK(Context context, String appId, String appSecret, String versionName, HashMap<String, String> policyCategoryMap) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(appId, "appId");
        kotlin.jvm.internal.g.f(appSecret, "appSecret");
        kotlin.jvm.internal.g.f(versionName, "versionName");
        kotlin.jvm.internal.g.f(policyCategoryMap, "policyCategoryMap");
        PolicySdkRetrofitCreator.INSTANCE.init(context);
        mAppId = appId;
        mAppSecret = appSecret;
        PolicyAppSecretResolver.INSTANCE.reset(mAppSecret);
        mAppVersionName = versionName;
        PolicySdkToolsUtils.Companion companion = PolicySdkToolsUtils.Companion;
        model = companion.getSystemModel(context);
        osVersion = companion.getSystemVersion(context);
        Context contextResolvePolicyContext = resolvePolicyContext(context);
        localAssetsCategoryPathMap = policyCategoryMap;
        try {
            BuildersKt__BuildersKt.runBlocking$default(null, new C04251(contextResolvePolicyContext, null), 1, null);
        } catch (Exception e10) {
            PolicySdkLogUtils.Companion.e("initSDK", "load agreeStatus/uidMap failed: " + e10);
        }
        PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
        StringBuilder sb2 = new StringBuilder("policyCategoryMap=");
        sb2.append(policyCategoryMap);
        sb2.append(", policyContext=");
        File dataDir = contextResolvePolicyContext.getDataDir();
        sb2.append(dataDir != null ? dataDir.getPath() : null);
        companion2.d("initSDK", sb2.toString());
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, exceptionHandler, null, new C04262(contextResolvePolicyContext, policyCategoryMap, null), 2, null);
    }

    private final boolean isDeviceProtectedStorageContext(Context context) {
        String path;
        File dataDir = context.getDataDir();
        return (dataDir == null || (path = dataDir.getPath()) == null || !q.l0(path, "user_de", false)) ? false : true;
    }

    public static final boolean isSupportSecureService(Context context, int i10) {
        kotlin.jvm.internal.g.f(context, "context");
        return INSTANCE.getSecureServiceVersionCode(context) >= i10;
    }

    public static final boolean isSupportSecureService31(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        try {
            int secureServiceVersionCode = INSTANCE.getSecureServiceVersionCode(context);
            PolicySdkLogUtils.Companion.d("PolicyManager", "com.stepos.secureservice versionCode : " + secureServiceVersionCode + ' ');
            return secureServiceVersionCode >= 11000031;
        } catch (Exception e10) {
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            StringBuilder sb2 = new StringBuilder("exception : ");
            e10.getMessage();
            n nVar = n.f10413a;
            sb2.append(e10);
            companion.e("PolicyManager", sb2.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object loadCloudPolicyUidCategoryMap(android.content.Context r7, qb.b<? super lb.n> r8) {
        /*
            r6 = this;
            java.lang.String r0 = "CloudPolicyIndex"
            java.lang.String r1 = "loaded "
            boolean r2 = r8 instanceof com.stepos.policy.sdk.PolicyManager.C04271
            if (r2 == 0) goto L17
            r2 = r8
            com.stepos.policy.sdk.PolicyManager$loadCloudPolicyUidCategoryMap$1 r2 = (com.stepos.policy.sdk.PolicyManager.C04271) r2
            int r3 = r2.f7869c
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.f7869c = r3
            goto L1c
        L17:
            com.stepos.policy.sdk.PolicyManager$loadCloudPolicyUidCategoryMap$1 r2 = new com.stepos.policy.sdk.PolicyManager$loadCloudPolicyUidCategoryMap$1
            r2.<init>(r8)
        L1c:
            java.lang.Object r6 = r2.f7867a
            kotlin.coroutines.intrinsics.CoroutineSingletons r8 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r3 = r2.f7869c
            r4 = 1
            if (r3 == 0) goto L33
            if (r3 != r4) goto L2b
            kotlin.c.b(r6)
            goto L4e
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            kotlin.c.b(r6)
            d1.c r6 = com.stepos.policy.sdk.c.a(r7)
            androidx.datastore.preferences.core.PreferenceDataStore r6 = (androidx.datastore.preferences.core.PreferenceDataStore) r6
            androidx.datastore.core.c r6 = r6.f1709a
            kotlinx.coroutines.flow.Flow<T> r6 = r6.f1677d
            com.stepos.policy.sdk.PolicyManager$loadCloudPolicyUidCategoryMap$$inlined$map$1 r7 = new com.stepos.policy.sdk.PolicyManager$loadCloudPolicyUidCategoryMap$$inlined$map$1
            r7.<init>()
            r2.f7869c = r4
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.first(r7, r2)
            if (r6 != r8) goto L4e
            return r8
        L4e:
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto Lac
            boolean r7 = gc.q.t0(r6)
            if (r7 == 0) goto L59
            goto Lac
        L59:
            com.stepos.policy.sdk.PolicyManager$loadCloudPolicyUidCategoryMap$type$1 r7 = new com.stepos.policy.sdk.PolicyManager$loadCloudPolicyUidCategoryMap$type$1     // Catch: java.lang.Exception -> L76
            r7.<init>()     // Catch: java.lang.Exception -> L76
            java.lang.reflect.Type r7 = r7.getType()     // Catch: java.lang.Exception -> L76
            d5.i r8 = new d5.i     // Catch: java.lang.Exception -> L76
            r8.<init>()     // Catch: java.lang.Exception -> L76
            com.google.gson.reflect.TypeToken r7 = com.google.gson.reflect.TypeToken.get(r7)     // Catch: java.lang.Exception -> L76
            java.lang.Object r6 = r8.c(r6, r7)     // Catch: java.lang.Exception -> L76
            java.util.Map r6 = (java.util.Map) r6     // Catch: java.lang.Exception -> L76
            if (r6 != 0) goto L78
            lb.n r6 = lb.n.f10413a     // Catch: java.lang.Exception -> L76
            return r6
        L76:
            r6 = move-exception
            goto L96
        L78:
            com.stepos.policy.sdk.util.PolicyCloudPolicyIndex.putAll(r6)     // Catch: java.lang.Exception -> L76
            com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r7 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion     // Catch: java.lang.Exception -> L76
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L76
            r8.<init>(r1)     // Catch: java.lang.Exception -> L76
            int r6 = r6.size()     // Catch: java.lang.Exception -> L76
            r8.append(r6)     // Catch: java.lang.Exception -> L76
            java.lang.String r6 = " uid→category from DataStore"
            r8.append(r6)     // Catch: java.lang.Exception -> L76
            java.lang.String r6 = r8.toString()     // Catch: java.lang.Exception -> L76
            r7.d(r0, r6)     // Catch: java.lang.Exception -> L76
            goto La9
        L96:
            com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r7 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r1 = "load failed: "
            r8.<init>(r1)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r7.e(r0, r6)
        La9:
            lb.n r6 = lb.n.f10413a
            return r6
        Lac:
            lb.n r6 = lb.n.f10413a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.loadCloudPolicyUidCategoryMap(android.content.Context, qb.b):java.lang.Object");
    }

    @SuppressLint({"SuspiciousIndentation"})
    public static final PolicySdkResultBean openPolicyDataByBrowser(Context context, String category, String title) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(category, "category");
        kotlin.jvm.internal.g.f(title, "title");
        PolicySdkResultBean policyNewestPathByCustom = getPolicyNewestPathByCustom(context, category);
        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
        companion.d("PolicyManager", "openPolicyDataByBrowser " + policyNewestPathByCustom.getPolicyNewestPath() + '}');
        PolicyCheckLogUtils.Companion companion2 = PolicyCheckLogUtils.Companion;
        StringBuilder sbQ = a0.a.q(">>> START category=", category, " method=BROWSER syncDone=");
        sbQ.append(syncLocalFileFinished);
        companion2.i("openPolicy", sbQ.toString());
        if (policyNewestPathByCustom.getCode() != 0) {
            companion2.e("openPolicy", ">>> END category=" + category + " code=FAILED 未打开页面(无反应)");
            StringBuilder sbQ2 = a0.a.q("原因: 本地无 ", category, " 缓存文件; syncDone=");
            sbQ2.append(syncLocalFileFinished);
            sbQ2.append("; code=");
            sbQ2.append(policyNewestPathByCustom.getCode());
            companion2.e("openPolicy", sbQ2.toString());
            StringBuilder sb2 = new StringBuilder("建议: 1)确认 assets 有对应 ");
            sb2.append(category);
            companion2.e("openPolicy", ai.onnxruntime.a.p(sb2, "_x.html 且 initSDK 已 put(\"", category, "\",...); 2)syncDone=false 时查启动自检(selfCheck)是否有 ⚠️ 缺文件导致同步中断; 3)确认打开与登记的 category 完全一致"));
            return policyNewestPathByCustom;
        }
        String policyNewestPath = policyNewestPathByCustom.getPolicyNewestPath();
        companion.d("PolicyManager", "openPolicyDataByBrowser policyNewestPath path = " + policyNewestPath + ' ');
        Uri uriForFile = androidx.core.content.b.getUriForFile(context, context.getPackageName() + ".PolicySdk.FileProvider", new File(policyNewestPath));
        if (uriForFile != null) {
            PolicySdkToolsUtils.Companion.startBrowser(context, uriForFile);
        }
        companion2.i("openPolicy", ai.onnxruntime.a.l(">>> END category=", category, " code=SUCCESS 已唤起浏览器 path=", policyNewestPath));
        return policyNewestPathByCustom;
    }

    @SuppressLint({"SuspiciousIndentation"})
    public static final PolicySdkResultBean openPolicyDataByWebView(Context context, String category, String title) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(category, "category");
        kotlin.jvm.internal.g.f(title, "title");
        PolicySdkResultBean policyNewestPathByCustom = getPolicyNewestPathByCustom(context, category);
        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
        companion.d("PolicyManager", "openPolicyDataByWebView " + policyNewestPathByCustom.getPolicyNewestPath() + '}');
        PolicyCheckLogUtils.Companion companion2 = PolicyCheckLogUtils.Companion;
        StringBuilder sbQ = a0.a.q(">>> START category=", category, " method=IN_APP syncDone=");
        sbQ.append(syncLocalFileFinished);
        companion2.i("openPolicy", sbQ.toString());
        if (policyNewestPathByCustom.getCode() != 0) {
            companion2.e("openPolicy", ">>> END category=" + category + " code=FAILED 未打开页面(无反应)");
            StringBuilder sbQ2 = a0.a.q("原因: 本地无 ", category, " 缓存文件; syncDone=");
            sbQ2.append(syncLocalFileFinished);
            sbQ2.append("; code=");
            sbQ2.append(policyNewestPathByCustom.getCode());
            companion2.e("openPolicy", sbQ2.toString());
            StringBuilder sb2 = new StringBuilder("建议: 1)确认 assets 有对应 ");
            sb2.append(category);
            companion2.e("openPolicy", ai.onnxruntime.a.p(sb2, "_x.html 且 initSDK 已 put(\"", category, "\",...); 2)syncDone=false 时查启动自检(selfCheck)是否有 ⚠️ 缺文件导致同步中断; 3)确认打开与登记的 category 完全一致"));
            return policyNewestPathByCustom;
        }
        String policyNewestPath = policyNewestPathByCustom.getPolicyNewestPath();
        Uri uriForFile = androidx.core.content.b.getUriForFile(context, context.getPackageName() + ".PolicySdk.FileProvider", new File(policyNewestPath));
        companion.d("PolicyManager", "save sucessful path = " + policyNewestPath + ' ');
        String string = uriForFile.toString();
        kotlin.jvm.internal.g.e(string, "contentUri.toString()");
        if (!syncLocalFileFinished && localAssetsCategoryPathMap.containsKey(category) && localAssetsCategoryPathMap.get(category) != null && !"".equals(localAssetsCategoryPathMap.get(category))) {
            string = String.valueOf(localAssetsCategoryPathMap.get(category));
        }
        companion.d("openPolicyDataByWebView", "initSDK syncLocalFileFinished " + syncLocalFileFinished + " |  policyPath = " + string);
        PolicyHtmlViewerActivity.Companion.openPolicy(context, string, title, null);
        companion2.i("openPolicy", ai.onnxruntime.a.l(">>> END category=", category, " code=SUCCESS 已打开页面 path=", string));
        return policyNewestPathByCustom;
    }

    public static final PolicySdkResultBean openPolicyMethod(Context context, boolean z, String title, String category) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(title, "title");
        kotlin.jvm.internal.g.f(category, "category");
        return z ? openPolicyDataByWebView(context, category, title) : openPolicyDataByBrowser(context, category, title);
    }

    private final void persistCloudPolicyUidCategoryMap(Context context) {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, exceptionHandler, null, new C04281(context, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reTryUploadRecord(Context context) {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, exceptionHandler, null, new C04291(this, context, null), 2, null);
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
            boolean r0 = gc.q.t0(r5)
            if (r0 == 0) goto L9
            goto L36
        L9:
            r0 = 0
            if (r6 == 0) goto L19
            boolean r1 = gc.q.t0(r6)
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
            boolean r4 = gc.q.t0(r0)
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
        kotlin.jvm.internal.g.f(context, "context");
        if (INSTANCE.isDeviceProtectedStorageContext(context)) {
            initSDKByDeviceProtectedStorageContext = true;
            return context;
        }
        if (!initSDKByDeviceProtectedStorageContext) {
            return context;
        }
        Context contextCreateDeviceProtectedStorageContext = context.getApplicationContext().createDeviceProtectedStorageContext();
        kotlin.jvm.internal.g.e(contextCreateDeviceProtectedStorageContext, "{\n            context.ap…torageContext()\n        }");
        return contextCreateDeviceProtectedStorageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object resolveSignSecret(java.lang.String r5, java.lang.String r6, java.lang.String r7, boolean r8, qb.b<? super java.lang.String> r9) {
        /*
            r4 = this;
            boolean r0 = r9 instanceof com.stepos.policy.sdk.PolicyManager.C04301
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.policy.sdk.PolicyManager$resolveSignSecret$1 r0 = (com.stepos.policy.sdk.PolicyManager.C04301) r0
            int r1 = r0.f7888e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7888e = r1
            goto L18
        L13:
            com.stepos.policy.sdk.PolicyManager$resolveSignSecret$1 r0 = new com.stepos.policy.sdk.PolicyManager$resolveSignSecret$1
            r0.<init>(r9)
        L18:
            java.lang.Object r4 = r0.f7886c
            kotlin.coroutines.intrinsics.CoroutineSingletons r9 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r0.f7888e
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            boolean r8 = r0.f7885b
            java.lang.String r7 = r0.f7884a
            kotlin.c.b(r4)
            goto L45
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.c.b(r4)
            com.stepos.policy.sdk.util.PolicyAppSecretResolver r4 = com.stepos.policy.sdk.util.PolicyAppSecretResolver.INSTANCE
            r0.f7884a = r7
            r0.f7885b = r8
            r0.f7888e = r2
            java.lang.Object r4 = r4.resolveForSign(r5, r6, r0)
            if (r4 != r9) goto L45
            return r9
        L45:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r4.length()
            if (r5 <= 0) goto L50
            com.stepos.policy.sdk.PolicyManager.mAppSecret = r4
            return r4
        L50:
            boolean r5 = com.stepos.policy.sdk.util.PolicySdkNetworkGate.shouldBlock()
            if (r5 == 0) goto L59
            java.lang.String r5 = "未同意前禁网且无 initSDK 兜底"
            goto L5b
        L59:
            java.lang.String r5 = "换密钥失败且无 initSDK 兜底"
        L5b:
            if (r8 == 0) goto L60
            java.lang.String r6 = "，已返回本地缓存"
            goto L62
        L60:
            java.lang.String r6 = ""
        L62:
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
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.resolveSignSecret(java.lang.String, java.lang.String, java.lang.String, boolean, qb.b):java.lang.Object");
    }

    public static /* synthetic */ Object resolveSignSecret$default(PolicyManager policyManager, String str, String str2, String str3, boolean z, qb.b bVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z = false;
        }
        return policyManager.resolveSignSecret(str, str2, str3, z, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveDataStoreString(Context context, a.C0083a<String> c0083a, String str, qb.b<? super n> bVar) {
        PolicySdkLogUtils.Companion.d("saveDataStoreString", " " + c0083a + " | dataStoreValue =" + str + ' ');
        Object objA = PreferencesKt.a(com.stepos.policy.sdk.c.a(context), new C04322(c0083a, str, null), bVar);
        return objA == CoroutineSingletons.f10059a ? objA : n.f10413a;
    }

    private final void saveLocalCategoryMd5(Context context, String str, String str2) {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, exceptionHandler, null, new C04331(context, str, str2, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0092, code lost:
    
        if (androidx.datastore.preferences.core.PreferencesKt.a(r6, r7, r0) == r10) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object savePolicyOperate(android.content.Context r7, boolean r8, java.lang.String r9, qb.b<? super lb.n> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.stepos.policy.sdk.PolicyManager.C04341
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.policy.sdk.PolicyManager$savePolicyOperate$1 r0 = (com.stepos.policy.sdk.PolicyManager.C04341) r0
            int r1 = r0.h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.h = r1
            goto L18
        L13:
            com.stepos.policy.sdk.PolicyManager$savePolicyOperate$1 r0 = new com.stepos.policy.sdk.PolicyManager$savePolicyOperate$1
            r0.<init>(r10)
        L18:
            java.lang.Object r6 = r0.f7907d
            kotlin.coroutines.intrinsics.CoroutineSingletons r10 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r0.h
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L3d
            if (r1 == r3) goto L33
            if (r1 != r2) goto L2b
            kotlin.c.b(r6)
            goto L95
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            boolean r8 = r0.f7906c
            java.lang.String r9 = r0.f7905b
            android.content.Context r7 = r0.f7904a
            kotlin.c.b(r6)
            goto L75
        L3d:
            kotlin.c.b(r6)
            com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r6 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r5 = "isOperateSuccess ="
            r1.<init>(r5)
            r1.append(r8)
            java.lang.String r5 = " |operateJson = "
            r1.append(r5)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            java.lang.String r5 = "savePolicyOperate"
            r6.d(r5, r1)
            d1.c r6 = com.stepos.policy.sdk.c.a(r7)
            com.stepos.policy.sdk.PolicyManager$savePolicyOperate$2 r1 = new com.stepos.policy.sdk.PolicyManager$savePolicyOperate$2
            r1.<init>(r8, r4)
            r0.f7904a = r7
            r0.f7905b = r9
            r0.f7906c = r8
            r0.h = r3
            java.lang.Object r6 = androidx.datastore.preferences.core.PreferencesKt.a(r6, r1, r0)
            if (r6 != r10) goto L75
            goto L94
        L75:
            if (r8 != 0) goto L98
            if (r9 == 0) goto L98
            int r6 = r9.length()
            if (r6 <= 0) goto L98
            d1.c r6 = com.stepos.policy.sdk.c.a(r7)
            com.stepos.policy.sdk.PolicyManager$savePolicyOperate$3 r7 = new com.stepos.policy.sdk.PolicyManager$savePolicyOperate$3
            r7.<init>(r9, r4)
            r0.f7904a = r4
            r0.f7905b = r4
            r0.h = r2
            java.lang.Object r6 = androidx.datastore.preferences.core.PreferencesKt.a(r6, r7, r0)
            if (r6 != r10) goto L95
        L94:
            return r10
        L95:
            lb.n r6 = lb.n.f10413a
            return r6
        L98:
            lb.n r6 = lb.n.f10413a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.savePolicyOperate(android.content.Context, boolean, java.lang.String, qb.b):java.lang.Object");
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
                } else if (q.l0(value, "file:////android_asset", false)) {
                    String strI0 = o.i0(value, "file:////android_asset/", "");
                    if (assetExists(context, strI0)) {
                        PolicyCheckLogUtils.Companion.i("selfCheck", "category=" + key + " asset=" + strI0 + " present=true");
                    } else {
                        arrayList.add(key);
                        PolicyCheckLogUtils.Companion.w("selfCheck", "category=" + key + " asset=" + strI0 + " present=FALSE ⚠️ 缺失会中断同步(其后 category 不再同步)且该 category 无法本地打开");
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

    public static final void setReadAndroidIdEnabled(boolean z) {
        readAndroidIdEnabled = z;
    }

    public static final stepos.support.v7.app.e showCustomPolicyDialog(Context context, boolean z, String[] strArr, String[] strArr2, String title, CharSequence charSequence, CharSequence customTerms, PolicyPermissionDialogBuilder.OnPermissionClickListener permissionDialogClickListener) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(title, "title");
        kotlin.jvm.internal.g.f(customTerms, "customTerms");
        kotlin.jvm.internal.g.f(permissionDialogClickListener, "permissionDialogClickListener");
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        policyPermissionDialogBuilder.setAppName(title).setOnPermissionListener(new a(context, permissionDialogClickListener)).setSecondaryConfirmation(z).setCustomTerms(customTerms);
        if (charSequence != null && !TextUtils.isEmpty(charSequence)) {
            policyPermissionDialogBuilder.setReminder(charSequence);
        }
        if (strArr != null && strArr2 != null) {
            policyPermissionDialogBuilder.setPermission(strArr, strArr2);
        }
        return policyPermissionDialogBuilder.create();
    }

    public static final stepos.support.v7.app.e showCustomPolicyDialogAndUploadRecord(Context context, boolean z, String[] strArr, String[] strArr2, String title, CharSequence charSequence, CharSequence customTerms, String appId, String appSecret, String versionName, String[] categoryList, String str, PolicyPermissionDialogBuilder.OnPermissionClickListener permissionDialogClickListener) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(title, "title");
        kotlin.jvm.internal.g.f(customTerms, "customTerms");
        kotlin.jvm.internal.g.f(appId, "appId");
        kotlin.jvm.internal.g.f(appSecret, "appSecret");
        kotlin.jvm.internal.g.f(versionName, "versionName");
        kotlin.jvm.internal.g.f(categoryList, "categoryList");
        kotlin.jvm.internal.g.f(permissionDialogClickListener, "permissionDialogClickListener");
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        policyPermissionDialogBuilder.setAppName(title).setOnPermissionListener(new b(context, appId, appSecret, versionName, categoryList, str, permissionDialogClickListener)).setSecondaryConfirmation(z).setCustomTerms(customTerms);
        if (charSequence != null && !TextUtils.isEmpty(charSequence)) {
            policyPermissionDialogBuilder.setReminder(charSequence);
        }
        if (strArr != null && strArr2 != null) {
            policyPermissionDialogBuilder.setPermission(strArr, strArr2);
        }
        return policyPermissionDialogBuilder.create();
    }

    public static final stepos.support.v7.app.e showCustomPolicyThreeButtonDialogAndUploadRecord(Context context, boolean z, String[] strArr, String[] strArr2, String title, CharSequence charSequence, CharSequence customTerms, String appId, String appSecret, String versionName, String[] categoryList, String str, PolicyPermissionDialogBuilder.OnPermissionClickListener fullAgreeListener, g0.a basicListener) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(title, "title");
        kotlin.jvm.internal.g.f(customTerms, "customTerms");
        kotlin.jvm.internal.g.f(appId, "appId");
        kotlin.jvm.internal.g.f(appSecret, "appSecret");
        kotlin.jvm.internal.g.f(versionName, "versionName");
        kotlin.jvm.internal.g.f(categoryList, "categoryList");
        kotlin.jvm.internal.g.f(fullAgreeListener, "fullAgreeListener");
        kotlin.jvm.internal.g.f(basicListener, "basicListener");
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        policyPermissionDialogBuilder.setDark(PolicyHtmlDisplayAdapter.isDarkMode(context));
        policyPermissionDialogBuilder.setAppName(title).setOnPermissionListener(new c()).setSecondaryConfirmation(z).setCustomTerms(customTerms);
        if (charSequence != null && !TextUtils.isEmpty(charSequence)) {
            policyPermissionDialogBuilder.setReminder(charSequence);
        }
        if (strArr != null && strArr2 != null) {
            policyPermissionDialogBuilder.setPermission(strArr, strArr2);
        }
        return policyPermissionDialogBuilder.createThreeButton(new d(context, appId, appSecret, versionName, categoryList, str, fullAgreeListener, basicListener));
    }

    public static final g0 showDialogByCustomThemeViewBuilder(Context context, int i10, String title, CharSequence customTerms, String customNegativeButtonText, String customPositiveButtonText, g0.a permissionDialogClickListener) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(title, "title");
        kotlin.jvm.internal.g.f(customTerms, "customTerms");
        kotlin.jvm.internal.g.f(customNegativeButtonText, "customNegativeButtonText");
        kotlin.jvm.internal.g.f(customPositiveButtonText, "customPositiveButtonText");
        kotlin.jvm.internal.g.f(permissionDialogClickListener, "permissionDialogClickListener");
        g0 g0Var = new g0(context);
        g0Var.f12109c = title;
        g0Var.f12115j = permissionDialogClickListener;
        g0Var.f12116k = customTerms;
        g0Var.f12120o = customNegativeButtonText;
        g0Var.f12121p = customPositiveButtonText;
        return g0Var;
    }

    public static final stepos.support.v7.app.e showDialogByCustomView(Context context, String title, CharSequence customTerms, String customNegativeButtonText, String customPositiveButtonText, g0.a permissionDialogClickListener) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(title, "title");
        kotlin.jvm.internal.g.f(customTerms, "customTerms");
        kotlin.jvm.internal.g.f(customNegativeButtonText, "customNegativeButtonText");
        kotlin.jvm.internal.g.f(customPositiveButtonText, "customPositiveButtonText");
        kotlin.jvm.internal.g.f(permissionDialogClickListener, "permissionDialogClickListener");
        g0 g0VarShowDialogByCustomViewBuilder = showDialogByCustomViewBuilder(context, title, customTerms, customNegativeButtonText, customPositiveButtonText, "2", permissionDialogClickListener);
        if (g0VarShowDialogByCustomViewBuilder != null) {
            return g0VarShowDialogByCustomViewBuilder.a();
        }
        return null;
    }

    public static final stepos.support.v7.app.e showDialogByCustomViewAndUploadRecord(Context context, String title, CharSequence customTerms, String customNegativeButtonText, String customPositiveButtonText, String appId, String appSecret, String versionName, String[] categoryList, String str, String operationType, g0.a permissionDialogClickListener) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(title, "title");
        kotlin.jvm.internal.g.f(customTerms, "customTerms");
        kotlin.jvm.internal.g.f(customNegativeButtonText, "customNegativeButtonText");
        kotlin.jvm.internal.g.f(customPositiveButtonText, "customPositiveButtonText");
        kotlin.jvm.internal.g.f(appId, "appId");
        kotlin.jvm.internal.g.f(appSecret, "appSecret");
        kotlin.jvm.internal.g.f(versionName, "versionName");
        kotlin.jvm.internal.g.f(categoryList, "categoryList");
        kotlin.jvm.internal.g.f(operationType, "operationType");
        kotlin.jvm.internal.g.f(permissionDialogClickListener, "permissionDialogClickListener");
        g0 g0VarShowDialogUploadRecordBuilder = showDialogUploadRecordBuilder(context, title, customTerms, customNegativeButtonText, customPositiveButtonText, appId, appSecret, versionName, categoryList, str, operationType, permissionDialogClickListener);
        if (g0VarShowDialogUploadRecordBuilder != null) {
            return g0VarShowDialogUploadRecordBuilder.a();
        }
        return null;
    }

    public static final g0 showDialogByCustomViewBuilder(Context context, String title, CharSequence customTerms, String customNegativeButtonText, String customPositiveButtonText, String operationType, g0.a permissionDialogClickListener) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(title, "title");
        kotlin.jvm.internal.g.f(customTerms, "customTerms");
        kotlin.jvm.internal.g.f(customNegativeButtonText, "customNegativeButtonText");
        kotlin.jvm.internal.g.f(customPositiveButtonText, "customPositiveButtonText");
        kotlin.jvm.internal.g.f(operationType, "operationType");
        kotlin.jvm.internal.g.f(permissionDialogClickListener, "permissionDialogClickListener");
        g0 g0Var = new g0(context);
        g0Var.f12109c = title;
        g0Var.f12115j = new e(operationType, context, permissionDialogClickListener);
        g0Var.f12116k = customTerms;
        g0Var.f12120o = customNegativeButtonText;
        g0Var.f12121p = customPositiveButtonText;
        return g0Var;
    }

    public static final g0 showDialogByCustomViewBuilderRecord(Context context, String title, CharSequence customTerms, String customNegativeButtonText, String customPositiveButtonText, String appId, String appSecret, String versionName, String[] categoryList, String str, g0.a permissionDialogClickListener) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(title, "title");
        kotlin.jvm.internal.g.f(customTerms, "customTerms");
        kotlin.jvm.internal.g.f(customNegativeButtonText, "customNegativeButtonText");
        kotlin.jvm.internal.g.f(customPositiveButtonText, "customPositiveButtonText");
        kotlin.jvm.internal.g.f(appId, "appId");
        kotlin.jvm.internal.g.f(appSecret, "appSecret");
        kotlin.jvm.internal.g.f(versionName, "versionName");
        kotlin.jvm.internal.g.f(categoryList, "categoryList");
        kotlin.jvm.internal.g.f(permissionDialogClickListener, "permissionDialogClickListener");
        g0 g0Var = new g0(context);
        g0Var.f12109c = title;
        g0Var.f12115j = new f(context, appId, appSecret, versionName, categoryList, str, permissionDialogClickListener);
        g0Var.f12116k = customTerms;
        g0Var.f12120o = customNegativeButtonText;
        g0Var.f12121p = customPositiveButtonText;
        return g0Var;
    }

    public static final g0 showDialogUploadRecordBuilder(Context context, String title, CharSequence customTerms, String customNegativeButtonText, String customPositiveButtonText, String appId, String appSecret, String versionName, String[] categoryList, String str, String operationType, g0.a permissionDialogClickListener) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(title, "title");
        kotlin.jvm.internal.g.f(customTerms, "customTerms");
        kotlin.jvm.internal.g.f(customNegativeButtonText, "customNegativeButtonText");
        kotlin.jvm.internal.g.f(customPositiveButtonText, "customPositiveButtonText");
        kotlin.jvm.internal.g.f(appId, "appId");
        kotlin.jvm.internal.g.f(appSecret, "appSecret");
        kotlin.jvm.internal.g.f(versionName, "versionName");
        kotlin.jvm.internal.g.f(categoryList, "categoryList");
        kotlin.jvm.internal.g.f(operationType, "operationType");
        kotlin.jvm.internal.g.f(permissionDialogClickListener, "permissionDialogClickListener");
        g0 g0Var = new g0(context);
        g0Var.f12109c = title;
        g0Var.f12115j = new g(operationType, context, appId, appSecret, versionName, categoryList, str, permissionDialogClickListener);
        g0Var.f12116k = customTerms;
        g0Var.f12120o = customNegativeButtonText;
        g0Var.f12121p = customPositiveButtonText;
        return g0Var;
    }

    public static final stepos.support.v7.app.e showNewestDialogAndUploadRecord(Context context, String dialogTitle, String appId, String appSecret, String versionName, String[] categoryList, String str, boolean z, CharSequence customTerms, String btnNegative, String btnPositive, g0.a permissionDialogClickListener) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(dialogTitle, "dialogTitle");
        kotlin.jvm.internal.g.f(appId, "appId");
        kotlin.jvm.internal.g.f(appSecret, "appSecret");
        kotlin.jvm.internal.g.f(versionName, "versionName");
        kotlin.jvm.internal.g.f(categoryList, "categoryList");
        kotlin.jvm.internal.g.f(customTerms, "customTerms");
        kotlin.jvm.internal.g.f(btnNegative, "btnNegative");
        kotlin.jvm.internal.g.f(btnPositive, "btnPositive");
        kotlin.jvm.internal.g.f(permissionDialogClickListener, "permissionDialogClickListener");
        g0 g0Var = new g0(context);
        g0Var.f12109c = dialogTitle;
        g0Var.f12115j = new h(z, context, appId, appSecret, versionName, categoryList, str, permissionDialogClickListener);
        g0Var.f12116k = customTerms;
        g0Var.f12120o = btnNegative;
        g0Var.f12121p = btnPositive;
        return g0Var.a();
    }

    public static final stepos.support.v7.app.e showReGrantDialog(Context context, boolean z, boolean z3, String title, String privacyPolicyName, String category, g0.a permissionDialogClickListener) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(title, "title");
        kotlin.jvm.internal.g.f(privacyPolicyName, "privacyPolicyName");
        kotlin.jvm.internal.g.f(category, "category");
        kotlin.jvm.internal.g.f(permissionDialogClickListener, "permissionDialogClickListener");
        return INSTANCE.createReGrantDialogBuilder(context, z, z3, title, privacyPolicyName, category, permissionDialogClickListener).a();
    }

    public static final stepos.support.v7.app.e showReGrantDialogAndUploadRecord(Context context, boolean z, boolean z3, String title, String privacyPolicyName, String category, String appId, String appSecret, String versionName, String[] categoryList, String str, g0.a permissionDialogClickListener) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(title, "title");
        kotlin.jvm.internal.g.f(privacyPolicyName, "privacyPolicyName");
        kotlin.jvm.internal.g.f(category, "category");
        kotlin.jvm.internal.g.f(appId, "appId");
        kotlin.jvm.internal.g.f(appSecret, "appSecret");
        kotlin.jvm.internal.g.f(versionName, "versionName");
        kotlin.jvm.internal.g.f(categoryList, "categoryList");
        kotlin.jvm.internal.g.f(permissionDialogClickListener, "permissionDialogClickListener");
        return INSTANCE.createReGrantDialogBuilder(context, z, z3, title, privacyPolicyName, category, new i(context, appId, appSecret, versionName, categoryList, str, permissionDialogClickListener)).a();
    }

    public static final stepos.support.v7.app.e showReGrantTwoPolicyDialog(Context context, boolean z, boolean z3, String title, String userPrivacyPolicyName, String userCategory, String privacyPolicyName, String category, g0.a permissionDialogClickListener) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(title, "title");
        kotlin.jvm.internal.g.f(userPrivacyPolicyName, "userPrivacyPolicyName");
        kotlin.jvm.internal.g.f(userCategory, "userCategory");
        kotlin.jvm.internal.g.f(privacyPolicyName, "privacyPolicyName");
        kotlin.jvm.internal.g.f(category, "category");
        kotlin.jvm.internal.g.f(permissionDialogClickListener, "permissionDialogClickListener");
        g0 g0VarCreateReGrantDialogBuilder = INSTANCE.createReGrantDialogBuilder(context, z, z3, title, privacyPolicyName, category, permissionDialogClickListener);
        g0VarCreateReGrantDialogBuilder.f12119n = userPrivacyPolicyName;
        g0VarCreateReGrantDialogBuilder.f12113g = new com.stepos.policy.sdk.a(context, z, userPrivacyPolicyName, userCategory, 1);
        return g0VarCreateReGrantDialogBuilder.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showReGrantTwoPolicyDialog$lambda$7(Context context, boolean z, String userPrivacyPolicyName, String userCategory, View view) {
        kotlin.jvm.internal.g.f(context, "$context");
        kotlin.jvm.internal.g.f(userPrivacyPolicyName, "$userPrivacyPolicyName");
        kotlin.jvm.internal.g.f(userCategory, "$userCategory");
        openPolicyMethod(context, z, userPrivacyPolicyName, userCategory);
    }

    public static final stepos.support.v7.app.e showReGrantTwoPolicyDialogAndUploadRecord(final Context context, final boolean z, boolean z3, String title, final String userPrivacyPolicyName, final String userCategory, String privacyPolicyName, String category, String appId, String appSecret, String versionName, String[] categoryList, String str, g0.a permissionDialogClickListener) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(title, "title");
        kotlin.jvm.internal.g.f(userPrivacyPolicyName, "userPrivacyPolicyName");
        kotlin.jvm.internal.g.f(userCategory, "userCategory");
        kotlin.jvm.internal.g.f(privacyPolicyName, "privacyPolicyName");
        kotlin.jvm.internal.g.f(category, "category");
        kotlin.jvm.internal.g.f(appId, "appId");
        kotlin.jvm.internal.g.f(appSecret, "appSecret");
        kotlin.jvm.internal.g.f(versionName, "versionName");
        kotlin.jvm.internal.g.f(categoryList, "categoryList");
        kotlin.jvm.internal.g.f(permissionDialogClickListener, "permissionDialogClickListener");
        g0 g0VarCreateReGrantDialogBuilder = INSTANCE.createReGrantDialogBuilder(context, z, z3, title, privacyPolicyName, category, new j(context, appId, appSecret, versionName, categoryList, str, permissionDialogClickListener));
        g0VarCreateReGrantDialogBuilder.f12119n = userPrivacyPolicyName;
        g0VarCreateReGrantDialogBuilder.f12113g = new View.OnClickListener() { // from class: com.stepos.policy.sdk.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PolicyManager.showReGrantTwoPolicyDialogAndUploadRecord$lambda$6(context, z, userPrivacyPolicyName, userCategory, view);
            }
        };
        return g0VarCreateReGrantDialogBuilder.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showReGrantTwoPolicyDialogAndUploadRecord$lambda$6(Context context, boolean z, String userPrivacyPolicyName, String userCategory, View view) {
        kotlin.jvm.internal.g.f(context, "$context");
        kotlin.jvm.internal.g.f(userPrivacyPolicyName, "$userPrivacyPolicyName");
        kotlin.jvm.internal.g.f(userCategory, "$userCategory");
        openPolicyMethod(context, z, userPrivacyPolicyName, userCategory);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, stepos.support.v7.app.e] */
    /* JADX WARN: Type inference failed for: r4v8, types: [T, stepos.support.v7.app.e] */
    /* JADX WARN: Type inference failed for: r4v9, types: [T, stepos.support.v7.app.e] */
    public static final stepos.support.v7.app.e showWithdrawalAndCleanServiceDataDialog(Context context, String title, CharSequence customTerms, String customNegativeButtonText, String customPositiveButtonText, String checkButtonMessage, PolicyPermissionDialogBuilder.OnPermissionClickListener permissionDialogClickListener) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(title, "title");
        kotlin.jvm.internal.g.f(customTerms, "customTerms");
        kotlin.jvm.internal.g.f(customNegativeButtonText, "customNegativeButtonText");
        kotlin.jvm.internal.g.f(customPositiveButtonText, "customPositiveButtonText");
        kotlin.jvm.internal.g.f(checkButtonMessage, "checkButtonMessage");
        kotlin.jvm.internal.g.f(permissionDialogClickListener, "permissionDialogClickListener");
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        policyPermissionDialogBuilder.setAppName(title).setOnPermissionListener(new k(ref$ObjectRef, permissionDialogClickListener)).setCustomTerms(customTerms).setShowAlmostDenyBtn(true).setCustomNegativeButtonText(customNegativeButtonText).setCustomPositiveButtonText(customPositiveButtonText).setCancelable(true).setCheckEnableConfirmBtn(true);
        ref$ObjectRef.f10076a = policyPermissionDialogBuilder.create();
        ?? Create = policyPermissionDialogBuilder.create();
        ref$ObjectRef.f10076a = Create;
        ?? InitWithdrawalCleanDataOneCheckBox = PolicySdkToolsUtils.Companion.initWithdrawalCleanDataOneCheckBox(context, Create, checkButtonMessage);
        ref$ObjectRef.f10076a = InitWithdrawalCleanDataOneCheckBox;
        return InitWithdrawalCleanDataOneCheckBox;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [T, stepos.support.v7.app.e] */
    /* JADX WARN: Type inference failed for: r8v1, types: [T, stepos.support.v7.app.e] */
    public static final stepos.support.v7.app.e showWithdrawalAndCleanServiceDataDialogByAccount(Context context, boolean z, String title, CharSequence customTerms, String customNegativeButtonText, String customPositiveButtonText, String checkButtonMessage, String secondCheckButtonMessage, PolicyPermissionDialogBuilder.OnPermissionClickListener permissionDialogClickListener) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(title, "title");
        kotlin.jvm.internal.g.f(customTerms, "customTerms");
        kotlin.jvm.internal.g.f(customNegativeButtonText, "customNegativeButtonText");
        kotlin.jvm.internal.g.f(customPositiveButtonText, "customPositiveButtonText");
        kotlin.jvm.internal.g.f(checkButtonMessage, "checkButtonMessage");
        kotlin.jvm.internal.g.f(secondCheckButtonMessage, "secondCheckButtonMessage");
        kotlin.jvm.internal.g.f(permissionDialogClickListener, "permissionDialogClickListener");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        PolicyPermissionDialogBuilder policyPermissionDialogBuilder = new PolicyPermissionDialogBuilder(context);
        policyPermissionDialogBuilder.setAppName(title).setOnPermissionListener(new l(ref$ObjectRef, permissionDialogClickListener)).setCustomTerms(customTerms).setShowAlmostDenyBtn(true).setCustomNegativeButtonText(customNegativeButtonText).setCustomPositiveButtonText(customPositiveButtonText).setCancelable(true).setCheckEnableConfirmBtn(true);
        ?? Create = policyPermissionDialogBuilder.create();
        ref$ObjectRef.f10076a = Create;
        ?? InitWithdrawalCleanDataTwoCheckBox = PolicySdkToolsUtils.Companion.initWithdrawalCleanDataTwoCheckBox(context, Create, z, checkButtonMessage, secondCheckButtonMessage);
        ref$ObjectRef.f10076a = InitWithdrawalCleanDataTwoCheckBox;
        return InitWithdrawalCleanDataTwoCheckBox;
    }

    public static final void uploadPolicyOperateRecord(String appId, String appSecret, String versionName, PolicyRecordRequest policyRecordRequest, zb.l<? super PolicySdkResultBean, n> callBackPolicyResult) {
        kotlin.jvm.internal.g.f(appId, "appId");
        kotlin.jvm.internal.g.f(appSecret, "appSecret");
        kotlin.jvm.internal.g.f(versionName, "versionName");
        kotlin.jvm.internal.g.f(policyRecordRequest, "policyRecordRequest");
        kotlin.jvm.internal.g.f(callBackPolicyResult, "callBackPolicyResult");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, exceptionHandler, null, new C04361(appId, appSecret, callBackPolicyResult, policyRecordRequest, versionName, null), 2, null);
    }

    public static final void uploadRecordByCustomRecordRequest(Context context, String appId, String appSecret, String versionName, PolicyRecordRequest policyRecordRequest, final zb.l<? super PolicySdkResultBean, n> callBackPolicyResult) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(appId, "appId");
        kotlin.jvm.internal.g.f(appSecret, "appSecret");
        kotlin.jvm.internal.g.f(versionName, "versionName");
        kotlin.jvm.internal.g.f(policyRecordRequest, "policyRecordRequest");
        kotlin.jvm.internal.g.f(callBackPolicyResult, "callBackPolicyResult");
        if (PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            uploadPolicyOperateRecord(appId, appSecret, versionName, policyRecordRequest, new zb.l<PolicySdkResultBean, n>() { // from class: com.stepos.policy.sdk.PolicyManager.uploadRecordByCustomRecordRequest.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // zb.l
                public final n invoke(PolicySdkResultBean policySdkResultBean) {
                    PolicySdkResultBean policySdkResultBean2 = policySdkResultBean;
                    kotlin.jvm.internal.g.f(policySdkResultBean2, "policySdkResultBean");
                    PolicySdkLogUtils.Companion.d("uploadRecordToCleanServiceData", "policySdkResultBean.code " + policySdkResultBean2.getCode());
                    callBackPolicyResult.invoke(policySdkResultBean2);
                    return n.f10413a;
                }
            });
        }
    }

    public static final void uploadRecordToCleanServiceData(Context context, String serviceName, String validateCode, String verifyType, ArrayList<DeleteInfoBean> arrayList, String appId, String appSecret, String versionName, String[] categoryList, String str, String operationType, zb.l<? super PolicySdkResultBean, n> callBackPolicyResult) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(serviceName, "serviceName");
        kotlin.jvm.internal.g.f(validateCode, "validateCode");
        kotlin.jvm.internal.g.f(verifyType, "verifyType");
        kotlin.jvm.internal.g.f(appId, "appId");
        kotlin.jvm.internal.g.f(appSecret, "appSecret");
        kotlin.jvm.internal.g.f(versionName, "versionName");
        kotlin.jvm.internal.g.f(categoryList, "categoryList");
        kotlin.jvm.internal.g.f(operationType, "operationType");
        kotlin.jvm.internal.g.f(callBackPolicyResult, "callBackPolicyResult");
        BuildersKt__Builders_commonKt.launch$default(scope, exceptionHandler, null, new C04381(context, categoryList, str, operationType, verifyType, serviceName, validateCode, arrayList, appId, appSecret, versionName, callBackPolicyResult, null), 2, null);
    }

    public static final void uploadRecordWithoutSecureService(Context context, String serviceName, String validateCode, String verifyType, ArrayList<DeleteInfoBean> arrayList, String appId, String appSecret, String versionName, String[] categoryList, String str, String operationType, zb.l<? super PolicySdkResultBean, n> callBackPolicyResult) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(serviceName, "serviceName");
        kotlin.jvm.internal.g.f(validateCode, "validateCode");
        kotlin.jvm.internal.g.f(verifyType, "verifyType");
        kotlin.jvm.internal.g.f(appId, "appId");
        kotlin.jvm.internal.g.f(appSecret, "appSecret");
        kotlin.jvm.internal.g.f(versionName, "versionName");
        kotlin.jvm.internal.g.f(categoryList, "categoryList");
        kotlin.jvm.internal.g.f(operationType, "operationType");
        kotlin.jvm.internal.g.f(callBackPolicyResult, "callBackPolicyResult");
        BuildersKt__Builders_commonKt.launch$default(scope, exceptionHandler, null, new C04391(context, categoryList, str, operationType, verifyType, serviceName, validateCode, arrayList, appId, appSecret, versionName, callBackPolicyResult, null), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getAgreeStatus(android.content.Context r5, qb.b<? super java.lang.Integer> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.policy.sdk.PolicyManager.C04151
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.policy.sdk.PolicyManager$getAgreeStatus$1 r0 = (com.stepos.policy.sdk.PolicyManager.C04151) r0
            int r1 = r0.f7758c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7758c = r1
            goto L18
        L13:
            com.stepos.policy.sdk.PolicyManager$getAgreeStatus$1 r0 = new com.stepos.policy.sdk.PolicyManager$getAgreeStatus$1
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.f7756a
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r0.f7758c
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            kotlin.c.b(r4)
            goto L4a
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.c.b(r4)
            d1.c r4 = com.stepos.policy.sdk.c.a(r5)
            androidx.datastore.preferences.core.PreferenceDataStore r4 = (androidx.datastore.preferences.core.PreferenceDataStore) r4
            androidx.datastore.core.c r4 = r4.f1709a
            kotlinx.coroutines.flow.Flow<T> r4 = r4.f1677d
            com.stepos.policy.sdk.PolicyManager$getAgreeStatus$$inlined$map$1 r5 = new com.stepos.policy.sdk.PolicyManager$getAgreeStatus$$inlined$map$1
            r5.<init>()
            r0.f7758c = r2
            java.lang.Object r4 = kotlinx.coroutines.flow.FlowKt.first(r5, r0)
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
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.getAgreeStatus(android.content.Context, qb.b):java.lang.Object");
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

    public final Object getDataStoreString(Context context, final a.C0083a<String> c0083a, qb.b<? super String> bVar) {
        final Flow<T> flow = ((PreferenceDataStore) com.stepos.policy.sdk.c.a(context)).f1709a.f1677d;
        return FlowKt.first(new Flow<String>() { // from class: com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1

            /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
            /* renamed from: com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ FlowCollector f7657a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ a.C0083a f7658b;

                /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
                @rb.c(c = "com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1$2", f = "PolicyManager.kt", l = {223}, m = "emit")
                /* renamed from: com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: a, reason: collision with root package name */
                    public /* synthetic */ Object f7659a;

                    /* renamed from: b, reason: collision with root package name */
                    public int f7660b;

                    public AnonymousClass1(qb.b bVar) {
                        super(bVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f7659a = obj;
                        this.f7660b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, a.C0083a c0083a) {
                    this.f7657a = flowCollector;
                    this.f7658b = c0083a;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, qb.b r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1$2$1 r0 = (com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f7660b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f7660b = r1
                        goto L18
                    L13:
                        com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1$2$1 r0 = new com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f7659a
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                        int r2 = r0.f7660b
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.c.b(r6)
                        goto L45
                    L27:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L2f:
                        kotlin.c.b(r6)
                        g1.a r5 = (g1.a) r5
                        g1.a$a r6 = r4.f7658b
                        java.lang.Object r5 = r5.b(r6)
                        r0.f7660b = r3
                        kotlinx.coroutines.flow.FlowCollector r4 = r4.f7657a
                        java.lang.Object r4 = r4.emit(r5, r0)
                        if (r4 != r1) goto L45
                        return r1
                    L45:
                        lb.n r4 = lb.n.f10413a
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager$getDataStoreString$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, qb.b):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super String> flowCollector, qb.b bVar2) {
                Object objCollect = flow.collect(new AnonymousClass2(flowCollector, c0083a), bVar2);
                return objCollect == CoroutineSingletons.f10059a ? objCollect : n.f10413a;
            }
        }, bVar);
    }

    public final CoroutineExceptionHandler getExceptionHandler() {
        return exceptionHandler;
    }

    public final boolean getInitSDKByDeviceProtectedStorageContext() {
        return initSDKByDeviceProtectedStorageContext;
    }

    public final CoroutineScope getLifecycleScope() {
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
    public final java.lang.Object getPolicyOperate(android.content.Context r5, qb.b<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.policy.sdk.PolicyManager.C04211
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.policy.sdk.PolicyManager$getPolicyOperate$1 r0 = (com.stepos.policy.sdk.PolicyManager.C04211) r0
            int r1 = r0.f7811c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7811c = r1
            goto L18
        L13:
            com.stepos.policy.sdk.PolicyManager$getPolicyOperate$1 r0 = new com.stepos.policy.sdk.PolicyManager$getPolicyOperate$1
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.f7809a
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r0.f7811c
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            kotlin.c.b(r4)
            goto L4a
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.c.b(r4)
            d1.c r4 = com.stepos.policy.sdk.c.a(r5)
            androidx.datastore.preferences.core.PreferenceDataStore r4 = (androidx.datastore.preferences.core.PreferenceDataStore) r4
            androidx.datastore.core.c r4 = r4.f1709a
            kotlinx.coroutines.flow.Flow<T> r4 = r4.f1677d
            com.stepos.policy.sdk.PolicyManager$getPolicyOperate$$inlined$map$1 r5 = new com.stepos.policy.sdk.PolicyManager$getPolicyOperate$$inlined$map$1
            r5.<init>()
            r0.f7811c = r2
            java.lang.Object r4 = kotlinx.coroutines.flow.FlowKt.first(r5, r0)
            if (r4 != r6) goto L4a
            return r6
        L4a:
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            boolean r4 = kotlin.jvm.internal.g.b(r4, r5)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager.getPolicyOperate(android.content.Context, qb.b):java.lang.Object");
    }

    public final Object getPolicyOperateJson(Context context, qb.b<? super String> bVar) {
        final Flow<T> flow = ((PreferenceDataStore) com.stepos.policy.sdk.c.a(context)).f1709a.f1677d;
        return FlowKt.first(new Flow<String>() { // from class: com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1

            /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
            /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ FlowCollector f7675a;

                /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
                @rb.c(c = "com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1$2", f = "PolicyManager.kt", l = {223}, m = "emit")
                /* renamed from: com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: a, reason: collision with root package name */
                    public /* synthetic */ Object f7676a;

                    /* renamed from: b, reason: collision with root package name */
                    public int f7677b;

                    public AnonymousClass1(qb.b bVar) {
                        super(bVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f7676a = obj;
                        this.f7677b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f7675a = flowCollector;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, qb.b r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1$2$1 r0 = (com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f7677b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f7677b = r1
                        goto L18
                    L13:
                        com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1$2$1 r0 = new com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f7676a
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                        int r2 = r0.f7677b
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.c.b(r6)
                        goto L45
                    L27:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L2f:
                        kotlin.c.b(r6)
                        g1.a r5 = (g1.a) r5
                        g1.a$a<java.lang.String> r6 = com.stepos.policy.sdk.c.f7967d
                        java.lang.Object r5 = r5.b(r6)
                        r0.f7677b = r3
                        kotlinx.coroutines.flow.FlowCollector r4 = r4.f7675a
                        java.lang.Object r4 = r4.emit(r5, r0)
                        if (r4 != r1) goto L45
                        return r1
                    L45:
                        lb.n r4 = lb.n.f10413a
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.PolicyManager$getPolicyOperateJson$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, qb.b):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super String> flowCollector, qb.b bVar2) {
                Object objCollect = flow.collect(new AnonymousClass2(flowCollector), bVar2);
                return objCollect == CoroutineSingletons.f10059a ? objCollect : n.f10413a;
            }
        }, bVar);
    }

    public final CoroutineScope getScope() {
        return scope;
    }

    public final int getSecureServiceVersionCode(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        int i10 = context.getApplicationContext().getPackageManager().getPackageInfo("com.stepos.secureservice", TraceIdKeys.MAX_LENGTH).versionCode;
        PolicySdkLogUtils.Companion.d("PolicyManager", "com.stepos.secureservice versionCode : " + i10 + ' ');
        return i10;
    }

    public final boolean getSyncLocalFileFinished() {
        return syncLocalFileFinished;
    }

    public final void saveAgreeStatus(Context context, int i10) {
        kotlin.jvm.internal.g.f(context, "context");
        PolicySdkNetworkGate.updateAgreeStatusCache(i10);
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, exceptionHandler, null, new C04311(context, i10, null), 2, null);
    }

    public final void setBrand(String str) {
        kotlin.jvm.internal.g.f(str, "<set-?>");
        brand = str;
    }

    public final void setCompanyCode(String str) {
        kotlin.jvm.internal.g.f(str, "<set-?>");
        companyCode = str;
    }

    public final void setCustomPolicyCSSFileName(String str) {
        kotlin.jvm.internal.g.f(str, "<set-?>");
        customPolicyCSSFileName = str;
    }

    public final void setInitSDKByDeviceProtectedStorageContext(boolean z) {
        initSDKByDeviceProtectedStorageContext = z;
    }

    public final void setLocalAssetsCategoryPathMap(HashMap<String, String> map) {
        kotlin.jvm.internal.g.f(map, "<set-?>");
        localAssetsCategoryPathMap = map;
    }

    public final void setMAppId(String str) {
        kotlin.jvm.internal.g.f(str, "<set-?>");
        mAppId = str;
    }

    public final void setMAppSecret(String str) {
        kotlin.jvm.internal.g.f(str, "<set-?>");
        mAppSecret = str;
    }

    public final void setMAppVersionName(String str) {
        kotlin.jvm.internal.g.f(str, "<set-?>");
        mAppVersionName = str;
    }

    public final void setModel(String str) {
        kotlin.jvm.internal.g.f(str, "<set-?>");
        model = str;
    }

    public final void setOsVersion(String str) {
        kotlin.jvm.internal.g.f(str, "<set-?>");
        osVersion = str;
    }

    public final void setSyncLocalFileFinished(boolean z) {
        syncLocalFileFinished = z;
    }

    public static /* synthetic */ void getReadAndroidIdEnabled$annotations() {
    }
}
