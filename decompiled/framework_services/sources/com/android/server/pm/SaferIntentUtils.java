package com.android.server.pm;

import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.UserHandle;
import android.util.Printer;
import android.util.Slog;
import com.android.internal.pm.pkg.component.ParsedIntentInfo;
import com.android.internal.pm.pkg.component.ParsedMainComponent;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.IntentResolver;
import com.android.server.LocalServices;
import com.android.server.am.BroadcastFilter;
import com.android.server.compat.PlatformCompat;
import com.android.server.pm.resolution.ComponentResolverApi;
import com.android.server.pm.snapshot.PackageDataSnapshot;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SaferIntentUtils {
    public static final ThreadLocal<Boolean> DISABLE_ENFORCE_INTENTS_TO_MATCH_INTENT_FILTERS = null;
    private static final long ENFORCE_INTENTS_TO_MATCH_INTENT_FILTERS = 161252188;
    private static final long IMPLICIT_INTENTS_ONLY_MATCH_EXPORTED_COMPONENTS = 229362273;

    public static class IntentArgs {
        public int callingPid;
        public int callingUid;
        public Intent intent;
        public boolean isReceiver;
        public PlatformCompat platformCompat;
        public boolean resolveForStart;
        public String resolvedType;
        public PackageDataSnapshot snapshot;

        public IntentArgs(Intent intent, String resolvedType, boolean isReceiver, boolean resolveForStart, int callingUid, int callingPid) {
            this.isReceiver = isReceiver;
            this.intent = intent;
            this.resolvedType = resolvedType;
            this.resolveForStart = resolveForStart;
            this.callingUid = callingUid;
            if (resolveForStart == false) goto L5;
            int r0 = callingPid;
        L6:
            this.callingPid = r0;
            return;
        L5:
            r0 = -1;
            goto L6
        }

        boolean isChangeEnabled(long changeId) {
            if (this.platformCompat != null) goto L5;
        L8:
            return true;
        L5:
            if (this.platformCompat.isChangeEnabledByUidInternalNoLogging(changeId, this.callingUid) == true) goto L8;
            return false;
        }

        void reportEvent(int event, boolean blocked) {
            if (this.resolveForStart == false) goto L6;
            SaferIntentUtils.reportUnsafeIntentEvent(event, this.callingUid, this.callingPid, this.intent, this.resolvedType, blocked);
            return;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$ET4wDE7Im4gCE7ebSKX-kIwikNI, reason: not valid java name */
    public static /* synthetic */ Boolean m6888$r8$lambda$ET4wDE7Im4gCE7ebSKXkIwikNI() {
        return lambda$static$0();
    }

    public static /* synthetic */ String[] $r8$lambda$mGphpbTqJdvD1YYxyb0Qke4Jry4(int r0) {
        return lambda$reportUnsafeIntentEvent$1(r0);
    }

    public SaferIntentUtils() {
    }

    static {
        DISABLE_ENFORCE_INTENTS_TO_MATCH_INTENT_FILTERS = ThreadLocal.withInitial(new SaferIntentUtils$$ExternalSyntheticLambda1());
    }

    private static /* synthetic */ Boolean lambda$static$0() {
        return false;
    }

    private static ParsedMainComponent infoToComponent(ComponentInfo info, ComponentResolverApi resolver, boolean isReceiver) {
        if ((info instanceof ActivityInfo) == false) goto L10;
        if (isReceiver == false) goto L8;
        return resolver.getReceiver(info.getComponentName());
    L8:
        return resolver.getActivity(info.getComponentName());
    L10:
        if ((info instanceof ServiceInfo) == false) goto L14;
        return resolver.getService(info.getComponentName());
    L14:
        throw new IllegalArgumentException("Unsupported component type");
    }

    public static void reportUnsafeIntentEvent(int event, int callingUid, int callingPid, Intent intent, String resolvedType, boolean blocked) {
        if (intent.getCategories() != null) goto L5;
        String[] r0 = new String[0];
    L6:
        String[] categories = r0;
        if (intent.getComponent() != null) goto L9;
        String component = null;
    L10:
        FrameworkStatsLog.write(FrameworkStatsLog.UNSAFE_INTENT_EVENT_REPORTED, event, callingUid, component, intent.getPackage(), intent.getAction(), categories, resolvedType, intent.getScheme(), blocked);
        ((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).triggerUnsafeIntentStrictMode(callingPid, event, intent);
        return;
    L9:
        component = intent.getComponent().flattenToString();
        goto L10
    L5:
        r0 = (String[]) intent.getCategories().toArray(new SaferIntentUtils$$ExternalSyntheticLambda0());
        goto L6
    }

    private static /* synthetic */ String[] lambda$reportUnsafeIntentEvent$1(int x$0) {
        return new String[x$0];
    }

    public static void blockNullAction(IntentArgs args, List componentList) {
        if (args.intent.getAction() == null) goto L6;
        return;
    L6:
        if (ActivityManager.canAccessUnexportedComponents(args.callingUid) == false) goto L8;
        return;
    L8:
        Computer computer = (Computer) args.snapshot;
        ComponentResolverApi resolver = null;
        int i = componentList.size() - 1;
    L9:
        if (i < 0) goto L32;
        boolean match = true;
        Object c = componentList.get(i);
        if ((c instanceof ResolveInfo) == false) goto L24;
        ResolveInfo resolveInfo = (ResolveInfo) c;
        if (computer == null) goto L14;
        if (resolver != null) goto L17;
        resolver = computer.getComponentResolver();
    L17:
        ParsedMainComponent comp = infoToComponent(resolveInfo.getComponentInfo(), resolver, args.isReceiver);
        if (comp != null) goto L20;
    L26:
        if (match == true) goto L30;
        args.reportEvent(1, false);
        if (0 == 0) goto L30;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Blocking intent with null action: " + args.intent);
        componentList.remove(i);
    L30:
        i = i - 1;
        goto L9
    L20:
        if (comp.getIntents().isEmpty() == true) goto L26;
        match = false;
        goto L26
    L14:
        return;
    L24:
        if ((c instanceof IntentFilter) == false) goto L26;
        match = false;
        goto L26
    }

    public static void enforceIntentFilterMatching(IntentArgs args, List<ResolveInfo> resolveInfos) {
        enforceIntentFilterMatchingWithIntentMatchingFlags(args, resolveInfos);
    }

    private static void enforceIntentFilterMatchingWithIntentMatchingFlags(IntentArgs args, List<ResolveInfo> resolveInfos) {
        if (DISABLE_ENFORCE_INTENTS_TO_MATCH_INTENT_FILTERS.get().booleanValue() == false) goto L6;
        return;
    L6:
        if (ActivityManager.canAccessUnexportedComponents(args.callingUid) == false) goto L8;
        return;
    L8:
        Computer computer = (Computer) args.snapshot;
        ComponentResolverApi resolver = computer.getComponentResolver();
        int r6 = 1;
        int i = resolveInfos.size() - 1;
    L9:
        if (i < 0) goto L59;
        ComponentInfo info = resolveInfos.get(i).getComponentInfo();
        if (UserHandle.isSameApp(args.callingUid, info.applicationInfo.uid) == false) goto L13;
        Computer computer2 = computer;
        int r13 = r6;
    L57:
        i = i - 1;
        r6 = r13;
        computer = computer2;
        goto L9
    L13:
        ParsedMainComponent comp = infoToComponent(info, resolver, args.isReceiver);
        if (comp != null) goto L16;
        computer2 = computer;
        r13 = r6;
        goto L57
    L16:
        if (comp.getIntents().isEmpty() == false) goto L18;
        computer2 = computer;
        r13 = r6;
        goto L57
    L18:
        boolean enforceIntentFilter = true;
        boolean allowNullAction = false;
        int flags = comp.getIntentMatchingFlags();
        if (flags != 0) goto L21;
    L24:
        enforceIntentFilter = false;
    L26:
        if ((flags & 4) != 4) goto L29;
        allowNullAction = true;
    L29:
        if (args.intent.getAction() != null) goto L31;
        int r11 = r6;
    L32:
        boolean intentMatchesComponent = false;
        int j = 0;
        int size = comp.getIntents().size();
    L33:
        if (j >= size) goto L38;
        IntentFilter intentFilter = ((ParsedIntentInfo) comp.getIntents().get(j)).getIntentFilter();
        computer2 = computer;
        if (IntentResolver.intentMatchesFilter(intentFilter, args.intent, args.resolvedType) == true) goto L36;
        j = j + 1;
        computer = computer2;
        goto L33
    L36:
        intentMatchesComponent = true;
    L39:
        boolean blockIntent = false;
        if (enforceIntentFilter == false) goto L45;
        if (r11 == 0) goto L43;
        if (allowNullAction == true) goto L43;
    L44:
        blockIntent = true;
    L43:
        if (intentMatchesComponent == false) goto L44;
    L45:
        if (r11 == 0) goto L47;
        args.reportEvent(1, blockIntent);
    L49:
        if (r11 != 0) goto L53;
        if (intentMatchesComponent == false) goto L53;
        r13 = 1;
    L54:
        if (blockIntent == false) goto L57;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Intent does not match component's intent filter: " + args.intent);
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Access blocked: " + comp.getComponentName());
        resolveInfos.remove(i);
    L53:
        r13 = 1;
        args.intent.addExtendedFlags(1);
        goto L54
    L47:
        if (intentMatchesComponent == true) goto L49;
        args.reportEvent(3, blockIntent);
        goto L49
    L38:
        computer2 = computer;
        goto L39
    L31:
        r11 = 0;
        goto L32
    L21:
        if ((flags & 1) == r6) goto L24;
        if ((flags & 2) != 0) goto L26;
    }

    private static /* synthetic */ void lambda$enforceIntentFilterMatchingWithIntentMatchingFlags$2(Printer logPrinter, ParsedIntentInfo f) {
        f.getIntentFilter().dump(logPrinter, "  ");
    }

    private static void enforceIntentFilterMatchingWithAppCompat(IntentArgs r18, List<ResolveInfo> r19) {
        if (DISABLE_ENFORCE_INTENTS_TO_MATCH_INTENT_FILTERS.get().booleanValue() == false) goto L6;
        return;
    L6:
        if (ActivityManager.canAccessUnexportedComponents(r18.callingUid) == false) goto L8;
        return;
    L8:
        ComponentResolverApi r3 = ((Computer) r18.snapshot).getComponentResolver();
        boolean r6 = false;
        boolean r7 = true;
        if (r18.isChangeEnabled(ENFORCE_INTENTS_TO_MATCH_INTENT_FILTERS) == false) goto L11;
        boolean r5 = true;
    L12:
        int r9 = r19.size() - 1;
    L13:
        if (r9 < 0) goto L51;
        ComponentInfo r10 = r19.get(r9).getComponentInfo();
        if (UserHandle.isSameApp(r18.callingUid, r10.applicationInfo.uid) == false) goto L17;
        boolean r16 = r6;
    L49:
        r9 = r9 - 1;
        r6 = r16;
        goto L13
    L17:
        ParsedMainComponent r11 = infoToComponent(r10, r3, r18.isReceiver);
        if (r11 != null) goto L20;
        r16 = r6;
        goto L49
    L20:
        if (r11.getIntents().isEmpty() == false) goto L22;
        r16 = r6;
        goto L49
    L22:
        Boolean r12 = null;
        if (r18.intent.getAction() != null) goto L31;
        if (r5 == false) goto L27;
        if (0 == 0) goto L27;
        boolean r13 = r7 ? 1 : 0;
    L28:
        r18.reportEvent(r7 ? 1 : 0, r13);
        if (0 == 0) goto L31;
        r12 = Boolean.valueOf(r6);
    L27:
        r13 = r6;
    L31:
        if (r12 != null) goto L39;
        int r14 = 0;
        int r15 = r11.getIntents().size();
    L33:
        if (r14 >= r15) goto L38;
        r16 = r6;
        boolean r17 = r7;
        if (IntentResolver.intentMatchesFilter(((ParsedIntentInfo) r11.getIntents().get(r14)).getIntentFilter(), r18.intent, r18.resolvedType) == true) goto L36;
        r14 = r14 + 1;
        r6 = r16;
        r7 = r17 ? 1 : 0;
        goto L33
    L36:
        r12 = Boolean.valueOf(r17);
    L40:
        if (r12 != null) goto L43;
        r18.reportEvent(3, r5);
        r12 = Boolean.valueOf(r16);
    L43:
        if (r12.booleanValue() == true) goto L47;
        r7 = r17;
        r18.intent.addExtendedFlags(r7 ? 1 : 0);
        if (r5 == false) goto L49;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Intent does not match component's intent filter: " + r18.intent);
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Access blocked: " + r11.getComponentName());
        r19.remove(r9);
        goto L49
    L47:
        r7 = r17;
        goto L49
    L38:
        r16 = r6;
        r17 = r7;
        goto L40
    L39:
        r16 = r6;
        r17 = r7 ? 1 : 0;
        goto L40
    L51:
        return;
    L11:
        r5 = false;
        goto L12
    }

    private static /* synthetic */ void lambda$enforceIntentFilterMatchingWithAppCompat$3(Printer logPrinter, ParsedIntentInfo f) {
        f.getIntentFilter().dump(logPrinter, "  ");
    }

    public static void filterNonExportedComponents(IntentArgs args, List componentList) {
        if (componentList != null) goto L4;
        return;
    L4:
        if (args.intent.getPackage() == null) goto L6;
        return;
    L6:
        if (args.intent.getComponent() == null) goto L8;
        return;
    L8:
        if (ActivityManager.canAccessUnexportedComponents(args.callingUid) == true) goto L40;
        boolean enforce = args.isChangeEnabled(IMPLICIT_INTENTS_ONLY_MATCH_EXPORTED_COMPONENTS);
        boolean violated = false;
        int i = componentList.size() - 1;
    L11:
        if (i < 0) goto L27;
        Object c = componentList.get(i);
        if ((c instanceof ResolveInfo) == false) goto L18;
        ResolveInfo resolveInfo = (ResolveInfo) c;
        if (resolveInfo.getComponentInfo().exported == true) goto L26;
    L22:
        violated = true;
        if (enforce == false) goto L27;
        componentList.remove(i);
    L26:
        i = i - 1;
        goto L11
    L18:
        if ((c instanceof BroadcastFilter) == false) goto L26;
        BroadcastFilter broadcastFilter = (BroadcastFilter) c;
        if (broadcastFilter.exported == false) goto L22;
    L27:
        if (violated == false) goto L37;
        args.reportEvent(2, enforce);
        return;
    L37:
        return;
    }
}
