package com.smt.obric.appstore.domain.sysapp;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.t;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lcom/bytedanceos/common/model/AppInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.sysapp.LoadLaunchableSysAppUseCase$invoke$2", f = "LoadLaunchableSysAppUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nLoadLaunchableSysAppUseCase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LoadLaunchableSysAppUseCase.kt\ncom/smt/obric/appstore/domain/sysapp/LoadLaunchableSysAppUseCase$invoke$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 LoadLaunchableSysAppUseCase.kt\ncom/smt/obric/appstore/domain/sysapp/LoadLaunchableSysAppUseCaseKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,96:1\n766#2:97\n857#2:98\n858#2:103\n766#2:104\n857#2:105\n858#2:110\n1603#2,9:111\n1855#2:120\n1856#2:122\n1612#2:123\n92#3,4:99\n92#3,4:106\n1#4:121\n*S KotlinDebug\n*F\n+ 1 LoadLaunchableSysAppUseCase.kt\ncom/smt/obric/appstore/domain/sysapp/LoadLaunchableSysAppUseCase$invoke$2\n*L\n32#1:97\n32#1:98\n32#1:103\n44#1:104\n44#1:105\n44#1:110\n57#1:111,9\n57#1:120\n57#1:122\n57#1:123\n34#1:99,4\n50#1:106,4\n57#1:121\n*E\n"})
public final class LoadLaunchableSysAppUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends List<? extends AppInfo>>>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LoadLaunchableSysAppUseCase this$0;

    public LoadLaunchableSysAppUseCase$invoke$2(LoadLaunchableSysAppUseCase r10, Continuation<? super LoadLaunchableSysAppUseCase$invoke$2> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        LoadLaunchableSysAppUseCase$invoke$2 r12 = new LoadLaunchableSysAppUseCase$invoke$2(this.this$0, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Result<? extends List<? extends AppInfo>>> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r13) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L67;
        kotlin.c.b(r13);
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        LoadLaunchableSysAppUseCase r12 = this.this$0;
        Result.a r15 = Result.Companion;     // Catch: Throwable -> L8
        PackageManager r16 = LoadLaunchableSysAppUseCase.a(r12).getPackageManager();     // Catch: Throwable -> L8
        if (r16 != null) goto L10;
        List r17 = t.i();     // Catch: Throwable -> L8
    L61:
        Object r18 = Result.m35constructorimpl(r17);     // Catch: Throwable -> L8
    L65:
        return Result.m34boximpl(r18);
    L10:
        q.d(r16);     // Catch: Throwable -> L8
        List<PackageInfo> r10 = r16.getInstalledPackages(0);     // Catch: Throwable -> L8
        q.f(r10, "getInstalledPackages(...)");     // Catch: Throwable -> L8
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L8
        Iterator<T> r19 = r10.iterator();     // Catch: Throwable -> L8
    L13:
        if (r19.hasNext() == false) goto L38;
        Object r20 = r19.next();     // Catch: Throwable -> L8
        PackageInfo r21 = (PackageInfo) r20;     // Catch: Throwable -> L8
        q.d(r21);     // Catch: Throwable -> L8
        boolean r22 = SysAppUtilKt.f(r21);     // Catch: Throwable -> L8
        if (q.b(r21.packageName, "com.obric.recorder") == false) goto L36;
        StringBuilder r23 = new StringBuilder();     // Catch: Throwable -> L8
        r23.append("[SysAppNameDebug][LoadLaunchableSysAppUseCase] sysFilter pkg=");     // Catch: Throwable -> L8
        r23.append(r21.packageName);     // Catch: Throwable -> L8
        r23.append(" allowed=");     // Catch: Throwable -> L8
        r23.append(r22);     // Catch: Throwable -> L8
        r23.append(" label=");     // Catch: Throwable -> L8
        r23.append(a.a(r21, LoadLaunchableSysAppUseCase.a(r12)));     // Catch: Throwable -> L8
        r23.append(" version=");     // Catch: Throwable -> L8
        r23.append(r21.getLongVersionCode());     // Catch: Throwable -> L8
        r23.append('/');     // Catch: Throwable -> L8
        r23.append(r21.versionName);     // Catch: Throwable -> L8
        r23.append(" labelRes=");     // Catch: Throwable -> L8
        ApplicationInfo r24 = r21.applicationInfo;     // Catch: Throwable -> L8
        String r25 = null;
        if (r24 == null) goto L19;
        Integer r26 = tf.a.c(r24.labelRes);     // Catch: Throwable -> L8
    L20:
        r23.append(r26);     // Catch: Throwable -> L8
        r23.append(" nonLocalizedLabel=");     // Catch: Throwable -> L8
        ApplicationInfo r27 = r21.applicationInfo;     // Catch: Throwable -> L8
        if (r27 == null) goto L23;
        CharSequence r28 = r27.nonLocalizedLabel;     // Catch: Throwable -> L8
    L24:
        r23.append(r28);     // Catch: Throwable -> L8
        r23.append(" flags=");     // Catch: Throwable -> L8
        ApplicationInfo r29 = r21.applicationInfo;     // Catch: Throwable -> L8
        if (r29 == null) goto L27;
        Integer r30 = tf.a.c(r29.flags);     // Catch: Throwable -> L8
    L28:
        r23.append(r30);     // Catch: Throwable -> L8
        r23.append(" sourceDir=");     // Catch: Throwable -> L8
        ApplicationInfo r31 = r21.applicationInfo;     // Catch: Throwable -> L8
        if (r31 == null) goto L31;
        String r32 = r31.sourceDir;     // Catch: Throwable -> L8
    L32:
        r23.append(r32);     // Catch: Throwable -> L8
        r23.append(" publicSourceDir=");     // Catch: Throwable -> L8
        ApplicationInfo r33 = r21.applicationInfo;     // Catch: Throwable -> L8
        if (r33 == null) goto L35;
        r25 = r33.publicSourceDir;     // Catch: Throwable -> L8
    L35:
        r23.append(r25);     // Catch: Throwable -> L8
        j.n(r23.toString());     // Catch: Throwable -> L8
        goto L36
    L31:
        r32 = null;
        goto L32
    L27:
        r30 = null;
        goto L28
    L23:
        r28 = null;
        goto L24
    L19:
        r26 = null;
    L36:
        if (r22 == false) goto L13;
        r11.add(r20);     // Catch: Throwable -> L8
        goto L13
    L38:
        ArrayList r34 = new ArrayList();     // Catch: Throwable -> L8
        Iterator r35 = r11.iterator();     // Catch: Throwable -> L8
    L40:
        if (r35.hasNext() == false) goto L54;
        Object r36 = r35.next();     // Catch: Throwable -> L8
        PackageInfo r37 = (PackageInfo) r36;     // Catch: Throwable -> L8
        String r38 = r37.packageName;     // Catch: Throwable -> L8
        q.f(r38, "packageName");     // Catch: Throwable -> L8
        Intent r39 = r16.getLaunchIntentForPackage(r38);     // Catch: Throwable -> L8
        if (r39 != null) goto L44;
    L48:
        boolean r40 = false;
    L49:
        q.d(r37);     // Catch: Throwable -> L8
        if (q.b(r37.packageName, "com.obric.recorder") == false) goto L52;
        j.n("[SysAppNameDebug][LoadLaunchableSysAppUseCase] launcherFilter pkg=" + r38 + " launchable=" + r40 + " intent=" + r39 + " applicationLabel=" + a.a(r37, LoadLaunchableSysAppUseCase.a(r12)));     // Catch: Throwable -> L8
    L52:
        if (r40 == false) goto L40;
        r34.add(r36);     // Catch: Throwable -> L8
        goto L40
    L44:
        if (r39.getCategories().contains("android.intent.category.LAUNCHER") == false) goto L48;
        if (q.b("android.intent.action.MAIN", r39.getAction()) == false) goto L48;
        r40 = true;
        goto L49
    L54:
        ArrayList r110 = new ArrayList();     // Catch: Throwable -> L8
        Iterator r41 = r34.iterator();     // Catch: Throwable -> L8
    L56:
        if (r41.hasNext() == false) goto L60;
        PackageInfo r42 = (PackageInfo) r41.next();     // Catch: Throwable -> L8
        q.d(r42);     // Catch: Throwable -> L8
        AppInfo r43 = a.c(r42, LoadLaunchableSysAppUseCase.a(r12));     // Catch: Throwable -> L8
        if (r43 == null) goto L56;
        r110.add(r43);     // Catch: Throwable -> L8
        goto L56
    L60:
        r17 = r110;
    L8:
        th = move-exception;
        Result.a r111 = Result.Companion;
        r18 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L65
    L67:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Result<? extends List<? extends AppInfo>>> r11) {
        return ((LoadLaunchableSysAppUseCase$invoke$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
