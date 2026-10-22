package androidx.appfunctions;

import C7.r;
import J7.c;
import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.appfunctions.ExecuteAppFunctionResponse;
import androidx.appfunctions.internal.AppFunctionManagerApi;
import androidx.appfunctions.internal.AppFunctionReader;
import androidx.appfunctions.internal.AppSearchAppFunctionReader;
import androidx.appfunctions.internal.Dependencies;
import androidx.appfunctions.internal.ExtensionAppFunctionManagerApi;
import androidx.appfunctions.internal.NullTranslatorSelector;
import androidx.appfunctions.internal.PlatformAppFunctionManagerApi;
import androidx.appfunctions.internal.Translator;
import androidx.appfunctions.internal.TranslatorSelector;
import androidx.appfunctions.metadata.AppFunctionMetadata;
import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 /2\u00020\u0001:\u00020/B+\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u0012\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0086@¢\u0006\u0004\b\u0017\u0010\u0018J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0087@¢\u0006\u0004\b\u0017\u0010\u001aJ \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001bH\u0086@¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\"\u001a\u00020\u00102\u0006\u0010!\u001a\u00020 H\u0087@¢\u0006\u0004\b\"\u0010#J#\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'0&2\u0006\u0010%\u001a\u00020$H\u0007¢\u0006\u0004\b)\u0010*R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010+R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010,R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010-R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010.¨\u00061"}, d2 = {"Landroidx/appfunctions/AppFunctionManager;", "", "Landroid/content/Context;", "context", "Landroidx/appfunctions/internal/AppFunctionReader;", "appFunctionReader", "Landroidx/appfunctions/internal/AppFunctionManagerApi;", "appFunctionManagerApi", "Landroidx/appfunctions/internal/TranslatorSelector;", "translatorSelector", AppAgent.CONSTRUCT, "(Landroid/content/Context;Landroidx/appfunctions/internal/AppFunctionReader;Landroidx/appfunctions/internal/AppFunctionManagerApi;Landroidx/appfunctions/internal/TranslatorSelector;)V", "Landroidx/appfunctions/internal/Translator;", "translator", "Landroidx/appfunctions/metadata/AppFunctionMetadata;", "functionMetadata", "Landroidx/appfunctions/ExecuteAppFunctionResponse;", "response", "processResponse", "(Landroidx/appfunctions/internal/Translator;Landroidx/appfunctions/metadata/AppFunctionMetadata;Landroidx/appfunctions/ExecuteAppFunctionResponse;)Landroidx/appfunctions/ExecuteAppFunctionResponse;", "", "functionId", "", "isAppFunctionEnabled", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "packageName", "(Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "", "newEnabledState", "LC7/r;", "setAppFunctionEnabled", "(Ljava/lang/String;ILH7/c;)Ljava/lang/Object;", "Landroidx/appfunctions/ExecuteAppFunctionRequest;", "request", "executeAppFunction", "(Landroidx/appfunctions/ExecuteAppFunctionRequest;LH7/c;)Ljava/lang/Object;", "Landroidx/appfunctions/AppFunctionSearchSpec;", "searchSpec", "Lp9/c;", "", "Landroidx/appfunctions/metadata/AppFunctionPackageMetadata;", "observeAppFunctions", "(Landroidx/appfunctions/AppFunctionSearchSpec;)Lp9/c;", "Landroid/content/Context;", "Landroidx/appfunctions/internal/AppFunctionReader;", "Landroidx/appfunctions/internal/AppFunctionManagerApi;", "Landroidx/appfunctions/internal/TranslatorSelector;", "Companion", "EnabledState", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppFunctionManager {
    public static final int APP_FUNCTION_STATE_DEFAULT = 0;
    public static final int APP_FUNCTION_STATE_DISABLED = 2;
    public static final int APP_FUNCTION_STATE_ENABLED = 1;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long LEGACY_SDK_GLOBAL_SCHEMA_VERSION = 1;
    private final AppFunctionManagerApi appFunctionManagerApi;
    private final AppFunctionReader appFunctionReader;
    private final Context context;
    private final TranslatorSelector translatorSelector;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/appfunctions/AppFunctionManager$Companion;", "", AppAgent.CONSTRUCT, "()V", "APP_FUNCTION_STATE_DEFAULT", "", "APP_FUNCTION_STATE_ENABLED", "APP_FUNCTION_STATE_DISABLED", "LEGACY_SDK_GLOBAL_SCHEMA_VERSION", "", "isExtensionLibraryAvailable", "", "getInstance", "Landroidx/appfunctions/AppFunctionManager;", "context", "Landroid/content/Context;", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private final boolean isExtensionLibraryAvailable() throws ClassNotFoundException {
            try {
                Class.forName("com.android.extensions.appfunctions.AppFunctionManager");
                return true;
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }

        public final AppFunctionManager getInstance(Context context) {
            k.f(context, "context");
            int i = Build.VERSION.SDK_INT;
            if (i >= 36) {
                Dependencies dependencies = Dependencies.INSTANCE;
                return new AppFunctionManager(context, new AppSearchAppFunctionReader(context, dependencies.getSchemaAppFunctionInventory$appfunctions()), new PlatformAppFunctionManagerApi(context), dependencies.getTranslatorSelector());
            }
            if (i < 34 || !isExtensionLibraryAvailable()) {
                return null;
            }
            Dependencies dependencies2 = Dependencies.INSTANCE;
            return new AppFunctionManager(context, new AppSearchAppFunctionReader(context, dependencies2.getSchemaAppFunctionInventory$appfunctions()), new ExtensionAppFunctionManagerApi(context), dependencies2.getTranslatorSelector());
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/appfunctions/AppFunctionManager$EnabledState;", "", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface EnabledState {
    }

    @c(c = "androidx.appfunctions.AppFunctionManager", f = "AppFunctionManager.kt", l = {114, 148}, m = "executeAppFunction", v = 1)
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.appfunctions.AppFunctionManager$executeAppFunction$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppFunctionManager.this.executeAppFunction(null, this);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public AppFunctionManager(Context context, AppFunctionReader appFunctionReader, AppFunctionManagerApi appFunctionManagerApi, TranslatorSelector translatorSelector) {
        k.f(context, "context");
        k.f(appFunctionReader, "appFunctionReader");
        k.f(appFunctionManagerApi, "appFunctionManagerApi");
        k.f(translatorSelector, "translatorSelector");
        this.context = context;
        this.appFunctionReader = appFunctionReader;
        this.appFunctionManagerApi = appFunctionManagerApi;
        this.translatorSelector = translatorSelector;
    }

    public static final AppFunctionManager getInstance(Context context) {
        return INSTANCE.getInstance(context);
    }

    private final ExecuteAppFunctionResponse processResponse(Translator translator, AppFunctionMetadata functionMetadata, ExecuteAppFunctionResponse response) {
        AppFunctionData returnValue;
        if (!(response instanceof ExecuteAppFunctionResponse.Success)) {
            return response;
        }
        if (translator == null || (returnValue = translator.upgradeResponse(((ExecuteAppFunctionResponse.Success) response).getReturnValue())) == null) {
            returnValue = ((ExecuteAppFunctionResponse.Success) response).getReturnValue();
        }
        return functionMetadata == null ? new ExecuteAppFunctionResponse.Success(returnValue) : new ExecuteAppFunctionResponse.Success(returnValue.replaceSpecWith$appfunctions(functionMetadata.getResponse(), functionMetadata.getComponents()));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @androidx.annotation.RequiresPermission(conditional = true, value = "android.permission.EXECUTE_APP_FUNCTIONS")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object executeAppFunction(androidx.appfunctions.ExecuteAppFunctionRequest r14, H7.c<? super androidx.appfunctions.ExecuteAppFunctionResponse> r15) throws androidx.appfunctions.AppFunctionFunctionNotFoundException {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appfunctions.AppFunctionManager.executeAppFunction(androidx.appfunctions.ExecuteAppFunctionRequest, H7.c):java.lang.Object");
    }

    public final Object isAppFunctionEnabled(String str, H7.c<? super Boolean> cVar) {
        String packageName = this.context.getPackageName();
        k.e(packageName, "getPackageName(...)");
        return isAppFunctionEnabled(packageName, str, cVar);
    }

    @RequiresPermission(conditional = true, value = "android.permission.EXECUTE_APP_FUNCTIONS")
    public final p9.c observeAppFunctions(AppFunctionSearchSpec searchSpec) {
        k.f(searchSpec, "searchSpec");
        return this.appFunctionReader.searchAppFunctions(searchSpec);
    }

    public final Object setAppFunctionEnabled(String str, int i, H7.c<? super r> cVar) {
        Object appFunctionEnabled = this.appFunctionManagerApi.setAppFunctionEnabled(str, i, cVar);
        return appFunctionEnabled == CoroutineSingletons.f4909a ? appFunctionEnabled : r.f317a;
    }

    @RequiresPermission(conditional = true, value = "android.permission.EXECUTE_APP_FUNCTIONS")
    public final Object isAppFunctionEnabled(String str, String str2, H7.c<? super Boolean> cVar) {
        return this.appFunctionManagerApi.isAppFunctionEnabled(str, str2, cVar);
    }

    public /* synthetic */ AppFunctionManager(Context context, AppFunctionReader appFunctionReader, AppFunctionManagerApi appFunctionManagerApi, TranslatorSelector translatorSelector, int i, e eVar) {
        this(context, appFunctionReader, appFunctionManagerApi, (i & 8) != 0 ? new NullTranslatorSelector() : translatorSelector);
    }
}
