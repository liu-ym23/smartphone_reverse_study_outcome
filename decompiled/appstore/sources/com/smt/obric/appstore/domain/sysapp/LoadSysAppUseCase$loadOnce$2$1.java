package com.smt.obric.appstore.domain.sysapp;

import com.bytedanceos.common.d;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.widget.SearchChipsView;
import com.bytedanceos.common.utils.i;
import com.smt.obric.appstore.domain.sysapp.autoupdate.GetSysAppAutoUpdateWhitelistUseCase;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.collections.j0;
import kotlin.collections.s0;
import kotlin.collections.t;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import org.apache.http.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/bytedanceos/common/model/AppInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.sysapp.LoadSysAppUseCase$loadOnce$2$1", f = "LoadSysAppUseCase.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5}, l = {88, 89, 90, 134, 137, SearchChipsView.GRAY}, m = "invokeSuspend", n = {"$this$coroutineScope", "preloadsMediaAppAsync", "zteDeletedAsync", "installedAsync", "oAppletsAsync", "$this$coroutineScope", "zteDeletedAsync", "installedAsync", "oAppletsAsync", "preloads", "$this$coroutineScope", "installedAsync", "oAppletsAsync", "preloads", "preloadsMediaApp", "oAppletsAsync", "preloads", "preloadsMediaApp", "zteDeleted", "preloads", "preloadsMediaApp", "zteDeleted", "installed", "preloads", "preloadsMediaApp", "zteDeleted", "installed", "oApplets"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"})
@SourceDebugExtension({"SMAP\nLoadSysAppUseCase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LoadSysAppUseCase.kt\ncom/smt/obric/appstore/domain/sysapp/LoadSysAppUseCase$loadOnce$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 LoadSysAppUseCase.kt\ncom/smt/obric/appstore/domain/sysapp/LoadSysAppUseCase\n*L\n1#1,226:1\n1603#2,9:227\n1855#2:236\n1856#2:238\n1612#2:239\n1603#2,9:240\n1855#2:249\n1856#2:251\n1612#2:252\n1774#2,4:253\n1855#2,2:257\n1855#2,2:259\n1855#2,2:261\n1855#2,2:263\n1855#2,2:265\n1855#2,2:267\n766#2:269\n857#2,2:270\n766#2:272\n857#2,2:273\n1045#2:275\n1864#2,2:276\n1866#2:282\n1#3:237\n1#3:250\n216#4,4:278\n*S KotlinDebug\n*F\n+ 1 LoadSysAppUseCase.kt\ncom/smt/obric/appstore/domain/sysapp/LoadSysAppUseCase$loadOnce$2$1\n*L\n96#1:227,9\n96#1:236\n96#1:238\n96#1:239\n97#1:240,9\n97#1:249\n97#1:251\n97#1:252\n140#1:253,4\n142#1:257,2\n153#1:259,2\n154#1:261,2\n156#1:263,2\n158#1:265,2\n161#1:267,2\n170#1:269\n170#1:270,2\n174#1:272\n174#1:273,2\n179#1:275\n181#1:276,2\n181#1:282\n96#1:237\n97#1:250\n182#1:278,4\n*E\n"})
public final class LoadSysAppUseCase$loadOnce$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends AppInfo>>, Object> {
    final /* synthetic */ boolean $gmsEnabled;
    final /* synthetic */ LoadSysAppUseCase $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    public static final class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r10, Object r11) {
            AppInfo r12 = (AppInfo) r10;
            AppInfo r13 = (AppInfo) r11;
            return sf.a.a(qe.a.b(r12.appName) + '@' + r12.appPackageName, qe.a.b(r13.appName) + '@' + r13.appPackageName);
        }
    }

    public LoadSysAppUseCase$loadOnce$2$1(LoadSysAppUseCase r10, boolean r11, Continuation<? super LoadSysAppUseCase$loadOnce$2$1> r12) {
        this.$this_runCatching = r10;
        this.$gmsEnabled = r11;
        super(2, r12);
    }

    public static final /* synthetic */ boolean access$invokeSuspend$isRemovable(Set r10, CoroutineScope r11, String r12) {
        return invokeSuspend$isRemovable(r10, r11, r12);
    }

    private static final boolean invokeSuspend$isRemovable(Set<String> r10, CoroutineScope r11, String r12) {
        if (r12.length() != 0) goto L6;
        return false;
    L6:
        if (r10.contains(r12) == false) goto L9;
        return true;
    L9:
        if (i.f10206a.b() == true) goto L24;
    L23:
        return false;
    L24:
        Result.a r13 = Result.Companion;     // Catch: Throwable -> L12
        Object r14 = Result.m35constructorimpl(ObricPreloadApks.b.a.f18101a.f(r12));     // Catch: Throwable -> L12
    L15:
        if (Result.m41isFailureimpl(r14) == false) goto L17;
        r14 = null;
    L17:
        Boolean r15 = (Boolean) r14;
        if (r15 == null) goto L20;
        boolean r16 = r15.booleanValue();
    L21:
        if (r16 == false) goto L23;
        return true;
    L20:
        r16 = false;
    L12:
        th = move-exception;
        Result.a r17 = Result.Companion;
        r14 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L15
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        LoadSysAppUseCase$loadOnce$2$1 r12 = new LoadSysAppUseCase$loadOnce$2$1(this.$this_runCatching, this.$gmsEnabled, r11);
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
    public final Object invokeSuspend(@NotNull Object r26) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        switch(this.label) {
            case 0: goto L12;
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        List r11 = (List) this.L$4;
        List r12 = (List) this.L$3;
        List r13 = (List) this.L$2;
        List r14 = (List) this.L$1;
        List r15 = (List) this.L$0;
        kotlin.c.b(r26);
        Object r16 = r26;
        List r17 = r15;
        boolean r18 = true;
    L63:
        Set r19 = (Set) r16;
        LoadSysAppUseCase r20 = this.$this_runCatching;
        Map r110 = j0.c();
        Iterator r21 = r17.iterator();
    L65:
        if (r21.hasNext() == false) goto L67;
        LoadSysAppUseCase.j(r20, r110, "preload_obric", (AppInfo) r21.next());
        goto L65
    L67:
        Iterator r22 = r14.iterator();
    L69:
        if (r22.hasNext() == false) goto L71;
        LoadSysAppUseCase.j(r20, r110, "preload_media", (AppInfo) r22.next());
        goto L69
    L71:
        Iterator r23 = r13.iterator();
    L73:
        if (r23.hasNext() == false) goto L75;
        LoadSysAppUseCase.j(r20, r110, "zte_deleted", (AppInfo) r23.next());
        goto L73
    L75:
        Iterator r24 = r11.iterator();
    L77:
        if (r24.hasNext() == false) goto L79;
        LoadSysAppUseCase.j(r20, r110, "oapplet", (AppInfo) r24.next());
        goto L77
    L79:
        Iterator r25 = r12.iterator();
    L81:
        if (r25.hasNext() == false) goto L83;
        LoadSysAppUseCase.j(r20, r110, "installed", (AppInfo) r25.next());
        goto L81
    L83:
        List r27 = b0.x0(j0.b(r110).values());
        boolean r28 = this.$gmsEnabled;
        ArrayList r29 = new ArrayList();
        Iterator r30 = r27.iterator();
    L85:
        if (r30.hasNext() == false) goto L91;
        Object r31 = r30.next();
        AppInfo r32 = (AppInfo) r31;
        if (r28 == true) goto L90;
        if (GmsUtil.f18070a.b().contains(r32.appPackageName) == true) goto L85;
    L90:
        r29.add(r31);
        goto L85
    L91:
        LoadSysAppUseCase r33 = this.$this_runCatching;
        ArrayList r34 = new ArrayList();
        Iterator r35 = r29.iterator();
    L93:
        if (r35.hasNext() == false) goto L100;
        Object r36 = r35.next();
        AppInfo r37 = (AppInfo) r36;
        if (LoadSysAppUseCase.a(r33) != LoadSysAppUseCase.Filter.AutoUpdate) goto L97;
        boolean r38 = r19.contains(r37.appPackageName);
    L98:
        if (r38 == false) goto L93;
        r34.add(r36);
        goto L93
    L97:
        r38 = r18;
        goto L98
    L100:
        List r39 = b0.t0(r34, new a());
        LoadSysAppUseCase r40 = this.$this_runCatching;
        Iterator r41 = r39.iterator();
        int r42 = 0;
    L102:
        if (r41.hasNext() == false) goto L110;
        Object r43 = r41.next();
        int r44 = r42 + 1;
        if (r42 >= 0) goto L106;
        t.q();
    L106:
        AppInfo r45 = (AppInfo) r43;
        if (LoadSysAppUseCase.k(r40, r45) == false) goto L109;
        j.n("[SysAppNameDebug][LoadSysAppUseCase] final[" + r42 + "] " + LoadSysAppUseCase.i(r40, r45));
    L109:
        r42 = r44;
        goto L102
    L110:
        return r39;
    L7:
        r12 = (List) this.L$3;
        r13 = (List) this.L$2;
        r14 = (List) this.L$1;
        List r111 = (List) this.L$0;
        kotlin.c.b(r26);
        Object r46 = r26;
        r17 = r111;
        r18 = true;
    L44:
        List r47 = (List) r46;
        StringBuilder r112 = new StringBuilder();
        r112.append("[OApplet][LoadSysAppUseCase] loaded=");
        r112.append(r47.size());
        r112.append(", installed=");
        if (r47.isEmpty() == false) goto L47;
        int r113 = 0;
    L55:
        r112.append(r113);
        j.n(r112.toString());
        Iterator r114 = r47.iterator();
    L57:
        if (r114.hasNext() == false) goto L59;
        AppInfo r115 = (AppInfo) r114.next();
        j.n("[OApplet][LoadSysAppUseCase] pkg=" + r115.appPackageName + " name=" + r115.appName + " appState=" + r115.appState + TokenParser.SP + d.a(r115));
        goto L57
    L59:
        GetSysAppAutoUpdateWhitelistUseCase r116 = LoadSysAppUseCase.b(this.$this_runCatching);
        this.L$0 = r17;
        this.L$1 = r14;
        this.L$2 = r13;
        this.L$3 = r12;
        this.L$4 = r47;
        this.label = 6;
        r16 = r116.c(this);
        if (r16 != r10) goto L62;
        return r10;
    L62:
        r11 = r47;
        goto L63
    L47:
        Iterator r117 = r47.iterator();
        r113 = 0;
    L49:
        if (r117.hasNext() == false) goto L55;
        if (((AppInfo) r117.next()).appState != 128) goto L49;
        r113 = r113 + 1;
        if (r113 >= 0) goto L49;
        t.p();
        goto L49
    L8:
        List r48 = (List) this.L$3;
        List r49 = (List) this.L$2;
        List r50 = (List) this.L$1;
        Deferred r118 = (Deferred) this.L$0;
        kotlin.c.b(r26);
        List r51 = r49;
        Deferred r52 = r118;
        r18 = true;
        Object r53 = r26;
    L40:
        List r54 = (List) r53;
        LoadSysAppUseCase.h(this.$this_runCatching, "installed_filtered", r54);
        this.L$0 = r50;
        this.L$1 = r51;
        this.L$2 = r48;
        this.L$3 = r54;
        this.label = 5;
        r46 = r52.await(this);
        if (r46 != r10) goto L43;
        return r10;
    L43:
        r13 = r48;
        r12 = r54;
        List r210 = r50;
        r14 = r51;
        r17 = r210;
        goto L44
    L9:
        List r55 = (List) this.L$4;
        r50 = (List) this.L$3;
        Deferred r119 = (Deferred) this.L$2;
        Deferred r120 = (Deferred) this.L$1;
        CoroutineScope r121 = (CoroutineScope) this.L$0;
        kotlin.c.b(r26);
        Object r56 = r26;
        Deferred r57 = r119;
        CoroutineScope r122 = r121;
        r18 = true;
        Deferred r123 = r120;
    L24:
        List r58 = (List) r56;
        LoadSysAppUseCase.h(this.$this_runCatching, "preload_obric", r50);
        LoadSysAppUseCase.h(this.$this_runCatching, "preload_media", r55);
        LoadSysAppUseCase.h(this.$this_runCatching, "zte_deleted", r58);
        ArrayList r59 = new ArrayList();
        Iterator r124 = r50.iterator();
    L26:
        if (r124.hasNext() == false) goto L30;
        String r125 = ((AppInfo) r124.next()).appPackageName;
        if (r125 == null) goto L26;
        r59.add(r125);
        goto L26
    L30:
        Set r60 = b0.B0(r59);
        ArrayList r126 = new ArrayList();
        Iterator r127 = r55.iterator();
    L32:
        if (r127.hasNext() == false) goto L36;
        String r128 = ((AppInfo) r127.next()).appPackageName;
        if (r128 == null) goto L32;
        r126.add(r128);
        goto L32
    L36:
        Deferred r61 = h.b(r122, l0.b(), null, new LoadSysAppUseCase$loadOnce$2$1$installed$1(r123, this.$this_runCatching, s0.k(r60, b0.B0(r126)), r122, null), 2, null);
        this.L$0 = r57;
        this.L$1 = r50;
        this.L$2 = r55;
        this.L$3 = r58;
        this.L$4 = null;
        this.label = 4;
        r53 = r61.await(this);
        if (r53 != r10) goto L39;
        return r10;
    L39:
        Deferred r211 = r57;
        r51 = r55;
        r48 = r58;
        r52 = r211;
        goto L40
    L10:
        List r62 = (List) this.L$4;
        Deferred r63 = (Deferred) this.L$3;
        Deferred r129 = (Deferred) this.L$2;
        Deferred r130 = (Deferred) this.L$1;
        CoroutineScope r131 = (CoroutineScope) this.L$0;
        kotlin.c.b(r26);
        Object r64 = r26;
        Deferred r65 = r129;
        r18 = true;
    L20:
        List r66 = (List) r64;
        this.L$0 = r131;
        this.L$1 = r65;
        this.L$2 = r63;
        this.L$3 = r62;
        this.L$4 = r66;
        this.label = 3;
        r56 = r130.await(this);
        if (r56 != r10) goto L23;
        return r10;
    L23:
        r122 = r131;
        r123 = r65;
        Deferred r212 = r63;
        r50 = r62;
        r55 = r66;
        r57 = r212;
        goto L24
    L11:
        Deferred r67 = (Deferred) this.L$4;
        Deferred r68 = (Deferred) this.L$3;
        Deferred r132 = (Deferred) this.L$2;
        Deferred r133 = (Deferred) this.L$1;
        r131 = (CoroutineScope) this.L$0;
        kotlin.c.b(r26);
        Deferred r69 = r132;
        Deferred r70 = r133;
        r18 = true;
        Object r134 = r26;
    L16:
        List r71 = (List) r134;
        this.L$0 = r131;
        this.L$1 = r69;
        this.L$2 = r68;
        this.L$3 = r67;
        this.L$4 = r71;
        this.label = 2;
        r64 = r70.await(this);
        if (r64 != r10) goto L19;
        return r10;
    L19:
        r130 = r69;
        r65 = r68;
        r63 = r67;
        r62 = r71;
        goto L20
    L12:
        kotlin.c.b(r26);
        CoroutineScope r72 = (CoroutineScope) this.L$0;
        Deferred r135 = h.b(r72, null, null, new LoadSysAppUseCase$loadOnce$2$1$preloadsAsync$1(this.$this_runCatching, null), 3, null);
        r70 = h.b(r72, null, null, new LoadSysAppUseCase$loadOnce$2$1$preloadsMediaAppAsync$1(this.$this_runCatching, null), 3, null);
        r69 = h.b(r72, null, null, new LoadSysAppUseCase$loadOnce$2$1$zteDeletedAsync$1(this.$this_runCatching, null), 3, null);
        Deferred r136 = h.b(r72, null, null, new LoadSysAppUseCase$loadOnce$2$1$installedAsync$1(this.$this_runCatching, null), 3, null);
        Deferred r73 = h.b(r72, null, null, new LoadSysAppUseCase$loadOnce$2$1$oAppletsAsync$1(this.$this_runCatching, null), 3, null);
        this.L$0 = r72;
        this.L$1 = r70;
        this.L$2 = r69;
        this.L$3 = r136;
        this.L$4 = r73;
        r18 = true;
        this.label = 1;
        r134 = r135.await(this);
        if (r134 != r10) goto L15;
        return r10;
    L15:
        r131 = r72;
        r67 = r73;
        r68 = r136;
        goto L16
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super List<? extends AppInfo>> r11) {
        return ((LoadSysAppUseCase$loadOnce$2$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
