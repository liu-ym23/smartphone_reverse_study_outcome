package com.bytedanceos.appstore.network;

import android.os.Bundle;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.j;
import com.obric.appstore.buss.repo.StoreRepo;
import com.obric.appstore.network.entity.AutoUpdateInfo;
import com.obric.appstore.network.entity.UpdateAppInfoReq;
import com.obric.appstore.network.entity.UpdateAppInfoResp;
import com.obric.appstore.network.entity.UpdateAppListResp;
import com.obric.appstore.network.g;
import com.smt.obric.appstore.domain.analytics.autoupdate.SysAppAutoUpdateAnalytics;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.collections.s;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.network.ObricAPIHelper$getAutoUpdateAppBundleBlock$1", f = "ObricAPIHelper.kt", i = {}, l = {331}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nObricAPIHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObricAPIHelper.kt\ncom/bytedanceos/appstore/network/ObricAPIHelper$getAutoUpdateAppBundleBlock$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,366:1\n288#2,2:367\n*S KotlinDebug\n*F\n+ 1 ObricAPIHelper.kt\ncom/bytedanceos/appstore/network/ObricAPIHelper$getAutoUpdateAppBundleBlock$1\n*L\n333#1:367,2\n*E\n"})
public final class ObricAPIHelper$getAutoUpdateAppBundleBlock$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bundle>, Object> {
    final /* synthetic */ String $packageName;
    final /* synthetic */ int $versionCode;
    int label;

    public ObricAPIHelper$getAutoUpdateAppBundleBlock$1(String r10, int r11, Continuation<? super ObricAPIHelper$getAutoUpdateAppBundleBlock$1> r12) {
        this.$packageName = r10;
        this.$versionCode = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new ObricAPIHelper$getAutoUpdateAppBundleBlock$1(this.$packageName, this.$versionCode, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Bundle> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        c.b(r10);
    L11:
        g r13 = (g) r10;
        Object r14 = null;
        if ((r13 instanceof g.d) == false) goto L41;
        UpdateAppListResp r15 = (UpdateAppListResp) ((g.d) r13).a();
        if (r15 == null) goto L40;
        List<UpdateAppInfoResp> r16 = r15.getApps();
        if (r16 == null) goto L40;
        String r17 = this.$packageName;
        Iterator<T> r18 = r16.iterator();
    L19:
        if (r18.hasNext() == false) goto L29;
        Object r19 = r18.next();
        UpdateAppInfoResp r20 = (UpdateAppInfoResp) r19;
        if (r20.getAutoUpdateInfo() == null) goto L19;
        AutoUpdateInfo r21 = r20.getAutoUpdateInfo();
        if (r21 == null) goto L25;
        String r22 = r21.getPackageName();
    L27:
        if (q.b(r22, r17) == false) goto L19;
        r14 = r19;
        goto L29
    L25:
        r22 = null;
    L29:
        UpdateAppInfoResp r23 = (UpdateAppInfoResp) r14;
        if (r23 == null) goto L40;
        AutoUpdateInfo r24 = r23.getAutoUpdateInfo();
        if (r24 == null) goto L40;
        SysAppAutoUpdateAnalytics r25 = SysAppAutoUpdateAnalytics.Companion.a();
        AppInfo r26 = new AppInfo();
        r26.appPackageName = r24.getPackageName();
        r26.appVersionCode = r24.getVersionCode();
        r26.appId = r24.getAppId();
        r26.mUpdateModel = r24.getUpdateModel();
        r26.mSysAppAutoUpdateTaskId = r24.getTaskId();
        r25.onGetUpdateInfo(s.e(r26));
        Bundle r27 = new Bundle();
        r27.putString("auto_update_pkg", r24.getPackageName());
        r27.putString("auto_update_url", r24.getUrl());
        r27.putInt("auto_update_model", r24.getUpdateModel());
        r27.putInt("auto_update_compliance_model", r24.getComplianceMode());
        r27.putString("auto_update_md5", r24.getMd5());
        Long r28 = r24.getSize();
        if (r28 == null) goto L36;
        long r29 = r28.longValue();
    L37:
        r27.putLong("auto_update_size", r29);
        r27.putString("auto_update_version_name", r24.getVersionName());
        r27.putInt("auto_update_version_code", r24.getVersionCode());
        r27.putString("auto_update_log", r24.getLog());
        j.n("[AutoUpdate] auto update info:" + r27);
        return r27;
    L36:
        r29 = 0;
    L40:
        return new Bundle();
    L41:
        return null;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        c.b(r10);
        StoreRepo r30 = StoreRepo.f10831a;
        List r31 = s.e(new UpdateAppInfoReq(this.$packageName, this.$versionCode));
        this.label = 1;
        r10 = r30.p(r31, this);
        if (r10 != r11) goto L11;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Bundle> r11) {
        return ((ObricAPIHelper$getAutoUpdateAppBundleBlock$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
