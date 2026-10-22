package com.stepos.aiengine.clients;

import Z8.C1174w;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.stepos.aiengine.api.IAlgorithmProperties;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.aiengine.client.AbilityServiceClient;
import com.stepos.aiengine.update.AlgorithmUpdater;
import com.stepos.core.ability.AbilityInfo;
import com.stepos.core.deepbinder.IAIEngineDeepBinderService;
import java.util.ArrayList;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u0007J \u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tJ\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u0007J!\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001e¢\u0006\u0002\u0010\u001fJ!\u0010 \u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001e¢\u0006\u0002\u0010!¨\u0006\""}, d2 = {"Lcom/stepos/aiengine/clients/AICapabilityProvider;", "", "<init>", "()V", "isDeviceSupported", "", "context", "Landroid/content/Context;", "algorithm", "", "checkEnable", "checkCloudEnable", "isCloudSupported", "checkResources", "", "hasCTAPermission", "getCTADialogIntent", "Landroid/content/Intent;", "getAlgorithmProperty", "name", "queryAlgorithm", "", "Lcom/stepos/aiengine/clients/AlgorithmAbilities;", "bundle", "Landroid/os/Bundle;", "getEngineInfo", "Lcom/stepos/aiengine/clients/EngineInfoBundle;", "checkUpdates", "", "algorithms", "", "(Landroid/content/Context;[Ljava/lang/String;)J", "getUpdates", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/os/Bundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AICapabilityProvider {
    public static final AICapabilityProvider INSTANCE = new AICapabilityProvider();

    public final boolean checkCloudEnable(Context context, String algorithm) {
        p.i(context, "context");
        p.i(algorithm, "algorithm");
        return AbilityServiceClient.INSTANCE.get(context).checkCloudEnable(algorithm);
    }

    public final boolean checkEnable(Context context, String algorithm) {
        p.i(context, "context");
        p.i(algorithm, "algorithm");
        return AbilityServiceClient.INSTANCE.get(context).checkEnable(algorithm);
    }

    public final int checkResources(Context context, String algorithm) {
        p.i(context, "context");
        p.i(algorithm, "algorithm");
        Boolean boolCheckModelReady = AbilityServiceClient.INSTANCE.get(context).checkModelReady(algorithm);
        if (boolCheckModelReady == null) {
            return -2;
        }
        if (p.d(boolCheckModelReady, Boolean.TRUE)) {
            return 1;
        }
        if (p.d(boolCheckModelReady, Boolean.FALSE)) {
            return 0;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final long checkUpdates(Context context, String[] algorithms) {
        p.i(context, "context");
        p.i(algorithms, "algorithms");
        return AlgorithmUpdater.INSTANCE.checkUpdates(context, algorithms);
    }

    public final String getAlgorithmProperty(Context context, String algorithm, String name) {
        p.i(context, "context");
        p.i(algorithm, "algorithm");
        p.i(name, "name");
        return AbilityServiceClient.INSTANCE.get(context).getAbilityProperty(algorithm, name);
    }

    public final Intent getCTADialogIntent(Context context) {
        Object objB;
        p.i(context, "context");
        try {
            Result.Companion companion = Result.INSTANCE;
            Bundle bundleCall = context.getContentResolver().call(Uri.parse("content://com.stepos.aiengine.DEEP_BINDER_IPC_CALL"), "getCtaDialogIntent", (String) null, (Bundle) null);
            objB = Result.b(bundleCall != null ? (Intent) bundleCall.getParcelable("intent") : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (Intent) (Result.g(objB) ? null : objB);
    }

    public final EngineInfoBundle getEngineInfo(Context context) throws PackageManager.NameNotFoundException {
        p.i(context, "context");
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String packageName = packageInfo.packageName;
            p.h(packageName, "packageName");
            String str = packageInfo.versionName;
            if (str == null) {
                str = "unknown";
            }
            return new EngineInfoBundle(packageName, str, packageInfo.getLongVersionCode(), 1);
        } catch (PackageManager.NameNotFoundException unused) {
            String packageName2 = context.getPackageName();
            p.h(packageName2, "getPackageName(...)");
            return new EngineInfoBundle(packageName2, "unknown", 0L, 1);
        }
    }

    public final Bundle getUpdates(Context context, String[] algorithms) {
        p.i(context, "context");
        p.i(algorithms, "algorithms");
        return AlgorithmUpdater.INSTANCE.getUpdates(context, algorithms);
    }

    public final boolean hasCTAPermission(Context context) {
        Object objB;
        p.i(context, "context");
        try {
            Result.Companion companion = Result.INSTANCE;
            Bundle bundleCall = context.getContentResolver().call(Uri.parse("content://com.stepos.aiengine.DEEP_BINDER_IPC_CALL"), "checkCTA", (String) null, (Bundle) null);
            objB = Result.b(Boolean.valueOf(bundleCall != null ? bundleCall.getBoolean("result", false) : false));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final boolean isCloudSupported(Context context, String algorithm) {
        p.i(context, "context");
        p.i(algorithm, "algorithm");
        String abilityProperty = AbilityServiceClient.INSTANCE.get(context).getAbilityProperty(algorithm, IAlgorithmProperties.SUPPORT_CLOUD);
        if (abilityProperty != null) {
            return Boolean.parseBoolean(abilityProperty);
        }
        return false;
    }

    public final boolean isDeviceSupported(Context context, String algorithm) {
        p.i(context, "context");
        p.i(algorithm, "algorithm");
        return AbilityServiceClient.INSTANCE.get(context).isDeviceSupported(algorithm);
    }

    public final List<AlgorithmAbilities> queryAlgorithm(Context context, Bundle bundle) {
        p.i(context, "context");
        p.i(bundle, "bundle");
        String string = bundle.getString(QueryAlgorithmBundle.KEY_CATEGORY);
        ArrayList<String> stringArrayList = bundle.getStringArrayList("abilities");
        boolean z10 = bundle.getBoolean(QueryAlgorithmBundle.KEY_SUPPORTED_ONLY, false);
        IAIEngineDeepBinderService iAIEngineDeepBinderService = AbilityServiceClient.INSTANCE.get(context);
        List<AbilityInfo> abilities = iAIEngineDeepBinderService.getAbilities();
        ArrayList<AbilityInfo> arrayList = new ArrayList();
        for (Object obj : abilities) {
            AbilityInfo abilityInfo = (AbilityInfo) obj;
            boolean z11 = true;
            boolean z12 = string == null || p.d(abilityInfo.getName(), string);
            if (stringArrayList != null && !stringArrayList.contains(abilityInfo.getId())) {
                z11 = false;
            }
            if (z12 && z11) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        for (AbilityInfo abilityInfo2 : arrayList) {
            String id = abilityInfo2.getId();
            if (id == null) {
                id = "";
            }
            String name = abilityInfo2.getName();
            if (name == null) {
                name = "";
            }
            String description = abilityInfo2.getDescription();
            arrayList2.add(new AlgorithmAbilities(id, name, description != null ? description : "", id.length() > 0 ? iAIEngineDeepBinderService.isDeviceSupported(id) : false));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            AlgorithmAbilities algorithmAbilities = (AlgorithmAbilities) obj2;
            if (!z10 || algorithmAbilities.getSupported()) {
                arrayList3.add(obj2);
            }
        }
        return arrayList3;
    }
}
