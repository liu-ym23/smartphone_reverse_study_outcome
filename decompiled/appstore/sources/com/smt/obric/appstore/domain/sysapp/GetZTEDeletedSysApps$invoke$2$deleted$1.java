package com.smt.obric.appstore.domain.sysapp;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/bytedanceos/common/model/AppInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.sysapp.GetZTEDeletedSysApps$invoke$2$deleted$1", f = "GetZTEDeletedSysApps.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nGetZTEDeletedSysApps.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GetZTEDeletedSysApps.kt\ncom/smt/obric/appstore/domain/sysapp/GetZTEDeletedSysApps$invoke$2$deleted$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,49:1\n1603#2,9:50\n1855#2:59\n1856#2:61\n1612#2:62\n1#3:60\n*S KotlinDebug\n*F\n+ 1 GetZTEDeletedSysApps.kt\ncom/smt/obric/appstore/domain/sysapp/GetZTEDeletedSysApps$invoke$2$deleted$1\n*L\n24#1:50,9\n24#1:59\n24#1:61\n24#1:62\n24#1:60\n*E\n"})
public final class GetZTEDeletedSysApps$invoke$2$deleted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends AppInfo>>, Object> {
    final /* synthetic */ GetZTEDeletedSysApps $this_runCatching;
    private /* synthetic */ Object L$0;
    int label;

    public GetZTEDeletedSysApps$invoke$2$deleted$1(GetZTEDeletedSysApps r10, Continuation<? super GetZTEDeletedSysApps$invoke$2$deleted$1> r11) {
        this.$this_runCatching = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        GetZTEDeletedSysApps$invoke$2$deleted$1 r12 = new GetZTEDeletedSysApps$invoke$2$deleted$1(this.$this_runCatching, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super List<? extends AppInfo>> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L39;
        kotlin.c.b(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        List r12 = ObricPreloadApks.b.a.f18101a.b();
        GetZTEDeletedSysApps r13 = this.$this_runCatching;
        ArrayList r14 = new ArrayList();
        Iterator r15 = r12.iterator();
    L6:
        if (r15.hasNext() == false) goto L37;
        PackageInfo r16 = (PackageInfo) r15.next();
        ApplicationInfo r17 = r16.applicationInfo;
        AppInfo r18 = null;
        if (r17 == null) goto L10;
        String r19 = r17.getCodePath();
    L12:
        if (r19 != null) goto L18;
        StringBuilder r20 = new StringBuilder();
        r20.append("[ZTE][GetZTEDeletedSysApps] Get deleted sys app apk path failed, app: ");
        r20.append(r16.packageName);
        r20.append(", ");
        ApplicationInfo r21 = r16.applicationInfo;
        if (r21 == null) goto L16;
        String r22 = r21.name;
    L17:
        r20.append(r22);
        j.s(r20.toString());
    L35:
        if (r18 == null) goto L6;
        r14.add(r18);
        goto L6
    L16:
        r22 = null;
        goto L17
    L18:
        q.d(r19);
        ApplicationInfo r23 = r16.applicationInfo;
        if (r23 == null) goto L23;
        String r24 = r23.publicSourceDir;
        if (r24 == null) goto L23;
        q.d(r24);
        String r25 = ke.b.f21055b.b(r24);
    L24:
        if (r25 != null) goto L26;
    L27:
        StringBuilder r26 = new StringBuilder();
        r26.append("[ZTE][GetZTEDeletedSysApps] Build deleted sys app icon uri failed, app: ");
        r26.append(r16.packageName);
        r26.append(", ");
        ApplicationInfo r27 = r16.applicationInfo;
        if (r27 == null) goto L30;
        String r28 = r27.name;
    L31:
        r26.append(r28);
        j.s(r26.toString());
    L32:
        AppInfo r29 = a.c(r16, GetZTEDeletedSysApps.a(r13));
        if (r29 == null) goto L35;
        r29.appIcon = r25;
        r29.obricPreloadApkFilePath = ObricPreloadApks.b.f18100a.a(r19);
        r18 = r29;
        goto L35
    L30:
        r28 = null;
        goto L31
    L26:
        if (o.r(r25) == false) goto L32;
    L23:
        r25 = null;
        goto L24
    L10:
        r19 = null;
        goto L12
    L37:
        return r14;
    L39:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super List<? extends AppInfo>> r11) {
        return ((GetZTEDeletedSysApps$invoke$2$deleted$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
