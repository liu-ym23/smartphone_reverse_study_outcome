package com.stepos.aiengine.clients;

import D7.w;
import H4.o;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.autofill.HintConstants;
import androidx.core.os.EnvironmentCompat;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.aiengine.client.AbilityServiceClient;
import com.stepos.aiengine.update.AlgorithmUpdater;
import com.stepos.core.ability.AbilityInfo;
import j9.m;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.b;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d¢\u0006\u0004\b \u0010!J#\u0010\"\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/stepos/aiengine/clients/AICapabilityProvider;", "", "Landroid/content/Context;", "context", "", "algorithm", "", "isDeviceSupported", "(Landroid/content/Context;Ljava/lang/String;)Z", "", "checkResources", "(Landroid/content/Context;Ljava/lang/String;)I", "hasCTAPermission", "(Landroid/content/Context;)Z", "Landroid/content/Intent;", "getCTADialogIntent", "(Landroid/content/Context;)Landroid/content/Intent;", HintConstants.AUTOFILL_HINT_NAME, "getAlgorithmProperty", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Landroid/os/Bundle;", "bundle", "", "Lcom/stepos/aiengine/clients/AlgorithmAbilities;", "queryAlgorithm", "(Landroid/content/Context;Landroid/os/Bundle;)Ljava/util/List;", "Lcom/stepos/aiengine/clients/EngineInfoBundle;", "getEngineInfo", "(Landroid/content/Context;)Lcom/stepos/aiengine/clients/EngineInfoBundle;", "", "algorithms", "", "checkUpdates", "(Landroid/content/Context;[Ljava/lang/String;)J", "getUpdates", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/os/Bundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AICapabilityProvider {
    public static final AICapabilityProvider INSTANCE = new AICapabilityProvider();

    /* renamed from: a, reason: collision with root package name */
    public static final List f3512a = o.N("SM8550", "SM8650", "SM8750", "SM7435", "SM7635", "MT6983", "MT6989", "MT6991", "T765", "T775");

    public static boolean a() {
        Object objA;
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class);
            Object objInvoke = method.invoke(null, "ro.board.platform", "");
            k.d(objInvoke, "null cannot be cast to non-null type kotlin.String");
            String str = (String) objInvoke;
            if (m.s0(str)) {
                Object objInvoke2 = method.invoke(null, "ro.hardware", "");
                k.d(objInvoke2, "null cannot be cast to non-null type kotlin.String");
                objA = (String) objInvoke2;
            } else {
                objA = str;
            }
        } catch (Throwable th) {
            objA = b.a(th);
        }
        String upperCase = ((String) (objA instanceof Result.Failure ? "" : objA)).toUpperCase(Locale.ROOT);
        k.e(upperCase, "toUpperCase(...)");
        if (m.s0(upperCase)) {
            return true;
        }
        List list = f3512a;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (m.h0(upperCase, (String) it.next(), false)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int checkResources(Context context, String algorithm) {
        k.f(context, "context");
        k.f(algorithm, "algorithm");
        Boolean boolCheckModelReady = AbilityServiceClient.INSTANCE.get(context).checkModelReady(algorithm);
        if (boolCheckModelReady == null) {
            return -2;
        }
        if (boolCheckModelReady.equals(Boolean.TRUE)) {
            return 1;
        }
        if (boolCheckModelReady.equals(Boolean.FALSE)) {
            return 0;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final long checkUpdates(Context context, String[] algorithms) {
        k.f(context, "context");
        k.f(algorithms, "algorithms");
        return AlgorithmUpdater.INSTANCE.checkUpdates(context, algorithms);
    }

    public final String getAlgorithmProperty(Context context, String algorithm, String name) {
        k.f(context, "context");
        k.f(algorithm, "algorithm");
        k.f(name, "name");
        return AbilityServiceClient.INSTANCE.get(context).getAbilityProperty(algorithm, name);
    }

    public final Intent getCTADialogIntent(Context context) {
        Object objA;
        k.f(context, "context");
        try {
            Bundle bundleCall = context.getContentResolver().call(Uri.parse("content://com.stepos.aiengine.DEEP_BINDER_IPC_CALL"), "getCtaDialogIntent", (String) null, (Bundle) null);
            objA = bundleCall != null ? (Intent) bundleCall.getParcelable("intent") : null;
        } catch (Throwable th) {
            objA = b.a(th);
        }
        return (Intent) (objA instanceof Result.Failure ? null : objA);
    }

    public final EngineInfoBundle getEngineInfo(Context context) throws PackageManager.NameNotFoundException {
        k.f(context, "context");
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String packageName = packageInfo.packageName;
            k.e(packageName, "packageName");
            String str = packageInfo.versionName;
            if (str == null) {
                str = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            return new EngineInfoBundle(packageName, str, packageInfo.getLongVersionCode(), 1);
        } catch (PackageManager.NameNotFoundException unused) {
            String packageName2 = context.getPackageName();
            k.e(packageName2, "getPackageName(...)");
            return new EngineInfoBundle(packageName2, EnvironmentCompat.MEDIA_UNKNOWN, 0L, 1);
        }
    }

    public final Bundle getUpdates(Context context, String[] algorithms) {
        k.f(context, "context");
        k.f(algorithms, "algorithms");
        return AlgorithmUpdater.INSTANCE.getUpdates(context, algorithms);
    }

    public final boolean hasCTAPermission(Context context) {
        Object objA;
        k.f(context, "context");
        try {
            Bundle bundleCall = context.getContentResolver().call(Uri.parse("content://com.stepos.aiengine.DEEP_BINDER_IPC_CALL"), "checkCTA", (String) null, (Bundle) null);
            objA = Boolean.valueOf(bundleCall != null ? bundleCall.getBoolean("result", false) : false);
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    public final boolean isDeviceSupported(Context context, String algorithm) {
        k.f(context, "context");
        k.f(algorithm, "algorithm");
        if (AbilityServiceClient.INSTANCE.get(context).containsAbility(algorithm)) {
            return a();
        }
        return false;
    }

    public final List<AlgorithmAbilities> queryAlgorithm(Context context, Bundle bundle) {
        k.f(context, "context");
        k.f(bundle, "bundle");
        String string = bundle.getString(QueryAlgorithmBundle.KEY_CATEGORY);
        ArrayList<String> stringArrayList = bundle.getStringArrayList("abilities");
        boolean z10 = bundle.getBoolean(QueryAlgorithmBundle.KEY_SUPPORTED_ONLY, false);
        boolean zA = a();
        List<AbilityInfo> abilities = AbilityServiceClient.INSTANCE.get(context).getAbilities();
        ArrayList arrayList = new ArrayList();
        for (Object obj : abilities) {
            AbilityInfo abilityInfo = (AbilityInfo) obj;
            boolean z11 = true;
            boolean z12 = string == null || k.b(abilityInfo.getName(), string);
            if (stringArrayList != null && !stringArrayList.contains(abilityInfo.getId())) {
                z11 = false;
            }
            if (z12 && z11) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(w.c0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            AbilityInfo abilityInfo2 = (AbilityInfo) it.next();
            String id = abilityInfo2.getId();
            String str = "";
            if (id == null) {
                id = "";
            }
            String name = abilityInfo2.getName();
            if (name == null) {
                name = "";
            }
            String description = abilityInfo2.getDescription();
            if (description != null) {
                str = description;
            }
            arrayList2.add(new AlgorithmAbilities(id, name, str, zA));
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            AlgorithmAbilities algorithmAbilities = (AlgorithmAbilities) next;
            if (!z10 || algorithmAbilities.getSupported()) {
                arrayList3.add(next);
            }
        }
        return arrayList3;
    }
}
