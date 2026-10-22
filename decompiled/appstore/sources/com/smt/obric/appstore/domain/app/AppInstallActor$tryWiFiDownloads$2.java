package com.smt.obric.appstore.domain.app;

import com.obric.download.base.DownloadTask;
import com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO;
import com.smt.obric.appstore.domain.downloader.ODownloader;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor$tryWiFiDownloads$2", f = "AppInstallActor.kt", i = {1, 2}, l = {497, 502, 512, 530, 532}, m = "invokeSuspend", n = {"task", "task"}, s = {"L$2", "L$2"})
@SourceDebugExtension({"SMAP\nAppInstallActor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppInstallActor.kt\ncom/smt/obric/appstore/domain/app/AppInstallActor$tryWiFiDownloads$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1261:1\n1855#2,2:1262\n*S KotlinDebug\n*F\n+ 1 AppInstallActor.kt\ncom/smt/obric/appstore/domain/app/AppInstallActor$tryWiFiDownloads$2\n*L\n499#1:1262,2\n*E\n"})
public final class AppInstallActor$tryWiFiDownloads$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AppInstallActor this$0;

    public AppInstallActor$tryWiFiDownloads$2(AppInstallActor r10, Continuation<? super AppInstallActor$tryWiFiDownloads$2> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppInstallActor$tryWiFiDownloads$2(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00c3 -> B:20:0x0087). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0119 -> B:20:0x0087). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x014b -> B:20:0x0087). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x019f -> B:20:0x0087). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r15) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        if (r11 == 0) goto L16;
        if (r11 == 1) goto L15;
        if (r11 == 2) goto L14;
        if (r11 == 3) goto L13;
        if (r11 == 4) goto L12;
        if (r11 == 5) goto L12;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        Iterator r12 = (Iterator) this.L$1;
        AppInstallActor r13 = (AppInstallActor) this.L$0;
        kotlin.c.b(r15);
    L55:
        AppInstallActor r14 = r13;
        Iterator r16 = r12;
    L21:
        if (r16.hasNext() == false) goto L61;
        com.smt.obric.appstore.domain.app.entity.a r17 = (com.smt.obric.appstore.domain.app.entity.a) r16.next();
        if (h.a() == false) goto L36;
        if (r17.N() == false) goto L36;
        Flow r18 = kotlinx.coroutines.flow.c.t(AppInstallActor.s(r14));
        this.L$0 = r14;
        this.L$1 = r16;
        this.L$2 = r17;
        this.label = 2;
        r15 = kotlinx.coroutines.flow.c.w(r18, this);
        if (r15 != r10) goto L29;
        return r10;
    L29:
        Boolean r19 = (Boolean) r15;
        if (r19 == null) goto L32;
        boolean r110 = r19.booleanValue();
    L33:
        if (r110 == true) goto L36;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][wifiDownloader] skip. sysapp wifi auto update disabled by user switch, task=" + r17.P());
        goto L21
    L32:
        r110 = true;
    L36:
        if (com.smt.obric.appstore.domain.downloader.d.b(r17.o()) == true) goto L44;
        DownloadTask r111 = n.a(r17);
        if (r111 == null) goto L43;
        ODownloader r112 = ODownloader.f18038a;
        this.L$0 = r14;
        this.L$1 = r16;
        this.L$2 = r17;
        this.label = 3;
        if (r112.A(r111, this) != r10) goto L42;
        return r10;
    L42:
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][wifiDownloader] submitWiFiDownloads, task=" + r17.P());
        goto L21
    L43:
        com.bytedanceos.common.toolbox.j.p("[AppStatus][AppInstallActor][wifiDownloader] submitWiFiDownloads failed, buildDownloadTask err, task=" + r17.P());
        goto L21
    L44:
        je.a r113 = je.a.f20999a;
        if (r113.b(r17.o(), r17.s(), r17.l()) == false) goto L59;
        Long r114 = r17.o();
        if (r114 != null) goto L50;
        com.bytedanceos.common.toolbox.j.p("[AppStatus][AppInstallActor][wifiDownloader] submitWiFiDownloads failed, dlId is null, task=" + r17.P());
        goto L21
    L50:
        if (r113.a(r17.s()) == false) goto L56;
        ODownloader r115 = ODownloader.f18038a;
        long r116 = r114.longValue();
        this.L$0 = r14;
        this.L$1 = r16;
        this.L$2 = null;
        this.label = 4;
        if (r115.w(r116, this) != r10) goto L54;
        return r10;
    L54:
        r12 = r16;
        r13 = r14;
        goto L55
    L56:
        ODownloader r117 = ODownloader.f18038a;
        long r118 = r114.longValue();
        this.L$0 = r14;
        this.L$1 = r16;
        this.L$2 = null;
        this.label = 5;
        if (r117.x(r118, this) != r10) goto L54;
        return r10;
    L63:
        r12 = r16;
        r13 = r14;
        goto L55
    L59:
        com.bytedanceos.common.toolbox.j.p("[AppStatus][AppInstallActor][wifiDownloader] submitWiFiDownloads failed, buildDownloadTask err, task=" + r17.P());
        goto L21
    L61:
        return Unit.f21064a;
    L13:
        com.smt.obric.appstore.domain.app.entity.a r20 = (com.smt.obric.appstore.domain.app.entity.a) this.L$2;
        r16 = (Iterator) this.L$1;
        r14 = (AppInstallActor) this.L$0;
        kotlin.c.b(r15);
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][wifiDownloader] submitWiFiDownloads, task=" + r20.P());
        goto L21
    L14:
        r17 = (com.smt.obric.appstore.domain.app.entity.a) this.L$2;
        r16 = (Iterator) this.L$1;
        r14 = (AppInstallActor) this.L$0;
        kotlin.c.b(r15);
        goto L29
    L15:
        kotlin.c.b(r15);
    L19:
        List r119 = (List) r15;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][wifiDownloader] tryWiFiDownloads, tasks=" + r119.size());
        AppInstallActor r21 = this.this$0;
        r16 = r119.iterator();
        r14 = r21;
        goto L21
    L16:
        kotlin.c.b(r15);
        AppInstallTaskDAO r120 = AppInstallActor.t(this.this$0);
        this.label = 1;
        r15 = AppInstallTaskDAO.a.a(r120, null, this, 1, null);
        if (r15 != r10) goto L19;
        return r10;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppInstallActor$tryWiFiDownloads$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
