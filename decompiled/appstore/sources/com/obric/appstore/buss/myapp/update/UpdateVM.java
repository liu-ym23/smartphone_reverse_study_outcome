package com.obric.appstore.buss.myapp.update;

import androidx.lifecycle.l0;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.CommonCache;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.AppInfoKtxKt;
import com.obric.appstore.buss.apps.AppsManager;
import com.smt.obric.appstore.domain.app.AppInstallActor;
import com.smt.obric.appstore.domain.app.entity.AppStatus;
import com.smt.obric.appstore.domain.app.n;
import com.smt.obric.appstore.domain.usecase.app.install.EnqueueAppInstallTaskUseCase;
import com.smt.obric.appstore.domain.usecase.app.install.ResumeAppDownloadUseCase;
import com.smt.obric.appstore.ktx.PackageInfoKTxKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.f1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class UpdateVM extends com.obric.appstore.base.k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableStateFlow f10759i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final StateFlow f10760j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LoadType f10761k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final EnqueueAppInstallTaskUseCase f10762l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ResumeAppDownloadUseCase f10763m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Job f10764n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/appstore/buss/myapp/update/UpdateVM$LoadType;", "", "(Ljava/lang/String;I)V", "IGNORE_UPDATE", "DEFAULT", "SIGN_NOT_MATCH", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final enum LoadType extends Enum<LoadType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ LoadType[] $VALUES = null;
        public static final LoadType DEFAULT = null;
        public static final LoadType IGNORE_UPDATE = null;
        public static final LoadType SIGN_NOT_MATCH = null;

        private static final /* synthetic */ LoadType[] $values() {
            return new LoadType[]{IGNORE_UPDATE, DEFAULT, SIGN_NOT_MATCH};
        }

        static {
            IGNORE_UPDATE = new LoadType("IGNORE_UPDATE", 0);
            DEFAULT = new LoadType("DEFAULT", 1);
            SIGN_NOT_MATCH = new LoadType("SIGN_NOT_MATCH", 2);
            LoadType[] r10 = $values();
            $VALUES = r10;
            $ENTRIES = kotlin.enums.a.a(r10);
        }

        private LoadType(String r10, int r11) {
            super(r10, r11);
        }

        @NotNull
        public static EnumEntries<LoadType> getEntries() {
            return $ENTRIES;
        }

        public static LoadType valueOf(String r10) {
            return (LoadType) Enum.valueOf(LoadType.class, r10);
        }

        public static LoadType[] values() {
            return (LoadType[]) $VALUES.clone();
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10765a = null;

        static {
            int[] r10 = new int[LoadType.values().length];
            r10[LoadType.IGNORE_UPDATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r10[LoadType.DEFAULT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r10[LoadType.SIGN_NOT_MATCH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f10765a = r10;
        }
    }

    public UpdateVM() {
        MutableStateFlow r10 = f1.a(null);
        this.f10759i = r10;
        this.f10760j = kotlinx.coroutines.flow.c.b(r10);
        this.f10761k = LoadType.DEFAULT;
        AppInstallActor.Companion r11 = AppInstallActor.f17891n;
        this.f10762l = new EnqueueAppInstallTaskUseCase(r11.b());
        this.f10763m = new ResumeAppDownloadUseCase(r11.b());
    }

    public static /* synthetic */ List B(UpdateVM r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = false;
    L6:
        return r10.A(r11);
    }

    public static final /* synthetic */ EnqueueAppInstallTaskUseCase v(UpdateVM r10) {
        return r10.f10762l;
    }

    public static final /* synthetic */ Object w(UpdateVM r10, List r11, boolean r12, Continuation r13) {
        return r10.E(r11, r12, r13);
    }

    public final List A(boolean r17) {
        BaseApplication r10 = BaseApplication.c();
        CommonCache r11 = r10.b();
        List r12 = r11.v("UPDATE");
        if (r12 != null) goto L5;
        r12 = t.i();
    L5:
        List r13 = r11.v("HIDE");
        if (r13 != null) goto L9;
        r13 = t.i();
    L9:
        if (r12.isEmpty() == true) goto L11;
    L14:
        ArrayList r14 = new ArrayList();
        ArrayList r15 = new ArrayList();
        Integer r16 = null;
        if (r12.isEmpty() == true) goto L58;
        LinkedHashMap r18 = new LinkedHashMap();
        Iterator r19 = r12.iterator();
    L18:
        if (r19.hasNext() == false) goto L23;
        Object r110 = r19.next();
        AppInfo r111 = (AppInfo) r110;
        q.d(r10);
        String r112 = r111.appPackageName;
        q.f(r112, "appPackageName");
        Boolean r113 = Boolean.valueOf(PackageInfoKTxKt.d(r10, r112, r111.sha256));
        Object r114 = r18.get(r113);
        if (r114 != null) goto L22;
        r114 = new ArrayList();
        r18.put(r113, r114);
    L22:
        ((List) r114).add(r110);
        goto L18
    L23:
        List r20 = (List) r18.get(Boolean.TRUE);
        if (r20 == null) goto L36;
        Iterator r21 = r20.iterator();
        int r115 = 0;
    L27:
        if (r21.hasNext() == false) goto L36;
        Object r116 = r21.next();
        int r117 = r115 + 1;
        if (r115 >= 0) goto L31;
        t.q();
    L31:
        AppInfo r118 = (AppInfo) r116;
        q.d(r118);
        if (r115 == t.k(r12)) goto L34;
        boolean r119 = true;
    L35:
        r15.add(new e.a(r118, r119));
        r115 = r117;
        goto L27
    L34:
        r119 = false;
    L36:
        List r22 = (List) r18.get(Boolean.FALSE);
        if (r22 == null) goto L49;
        Iterator r23 = r22.iterator();
        int r24 = 0;
    L40:
        if (r23.hasNext() == false) goto L49;
        Object r120 = r23.next();
        int r121 = r24 + 1;
        if (r24 >= 0) goto L44;
        t.q();
    L44:
        AppInfo r122 = (AppInfo) r120;
        q.d(r122);
        if (r24 == t.k(r12)) goto L47;
        boolean r25 = true;
    L48:
        r14.add(new e.a(r122, r25));
        r24 = r121;
        goto L40
    L47:
        r25 = false;
    L49:
        ArrayList r26 = new ArrayList(u.r(r14, 10));
        Iterator r27 = r14.iterator();
    L51:
        if (r27.hasNext() == false) goto L53;
        r26.add(((e) r27.next()).getAppInfo());
        goto L51
    L53:
        MutableStateFlow r28 = this.f10759i;
        if (r14.isEmpty() == true) goto L57;
        r16 = Integer.valueOf(r11.j(r26));
    L57:
        r28.setValue(r16);
    L60:
        if (r13.isEmpty() == true) goto L62;
        r14.add(new e.b(r13.size(), !r14.isEmpty()));
    L62:
        if (r17 == false) goto L64;
    L66:
        if (r17 == true) goto L68;
        return r14;
    L68:
        return r15;
    L64:
        if (r15.isEmpty() == true) goto L66;
        r14.add(new e.c(r15.size(), r14.isEmpty() ^ r13.isEmpty()));
        goto L66
    L58:
        this.f10759i.setValue(null);
        goto L60
    L11:
        if (r13.isEmpty() == false) goto L14;
        return t.i();
    }

    public final void C() {
        Job r10 = this.f10764n;
        if (r10 != null) goto L5;
    L8:
        this.f10764n = kotlinx.coroutines.h.d(l0.a(this), null, null, new UpdateVM$pauseAllUpdates$1(null), 3, null);
        return;
    L5:
        if (r10.isActive() != true) goto L8;
        com.bytedanceos.common.toolbox.j.n("UpdateVM pauseAllUpdates ignore while running");
    }

    public final void D(LoadType r10) {
        q.g(r10, "<set-?>");
        this.f10761k = r10;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0166 -> B:36:0x0104). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0189 -> B:61:0x018b). Please report as a decompilation issue!!! */
    public final Object E(List r13, boolean r14, Continuation r15) {
        if ((r15 instanceof UpdateVM$updateAll$2) == false) goto L7;
        UpdateVM$updateAll$2 r10 = (UpdateVM$updateAll$2) r15;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r16 = r10.result;
        Object r12 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r10.label;
        if (r17 == 0) goto L16;
        if (r17 == 1) goto L15;
        if (r17 != 2) goto L14;
        boolean r18 = r10.Z$0;
        Iterator r19 = (Iterator) r10.L$2;
        Map r110 = (Map) r10.L$1;
        UpdateVM r20 = (UpdateVM) r10.L$0;
        kotlin.c.b(r16);
    L61:
        boolean r111 = r18;
        UpdateVM this = r20;
    L37:
        if (r19.hasNext() == false) goto L63;
        AppInfo r21 = (AppInfo) r19.next();
        BaseApplication r22 = BaseApplication.c();
        String r23 = r21.appPackageName;
        if (r23 == null) goto L37;
        q.d(r22);
        if (PackageInfoKTxKt.d(r22, r23, r21.sha256) == true) goto L37;
        if (r21.mAppUpdateType == 0) goto L37;
        if (r110.containsKey(r23) == false) goto L57;
        List r24 = (List) r110.get(r23);
        if (r24 == null) goto L37;
        UpdateVM r25 = this;
        boolean r112 = r111;
        Map r113 = r110;
        Iterator r114 = r19;
        Iterator r115 = r24.iterator();
        Map r26 = r113;
    L52:
        if (r115.hasNext() == false) goto L56;
        com.smt.obric.appstore.domain.app.entity.a r116 = (com.smt.obric.appstore.domain.app.entity.a) r115.next();
        ResumeAppDownloadUseCase r27 = r25.f10763m;
        String r117 = r116.E();
        r10.L$0 = r25;
        r10.L$1 = r26;
        r10.L$2 = r114;
        r10.L$3 = r115;
        r10.Z$0 = r112;
        r10.label = 1;
        if (r27.a(r117, r112, r10) != r12) goto L52;
        return r12;
    L56:
        r111 = r112;
        r19 = r114;
        r110 = r26;
        this = r25;
        goto L37
    L57:
        com.smt.obric.appstore.domain.app.entity.a r28 = n.c(AppInfoKtxKt.newDomainEntity$default(r21, null, 1, null), r111, false, 2, null);
        EnqueueAppInstallTaskUseCase r29 = this.f10762l;
        r10.L$0 = this;
        r10.L$1 = r110;
        r10.L$2 = r19;
        r10.L$3 = null;
        r10.Z$0 = r111;
        r10.label = 2;
        if (r29.a(r28, r10) != r12) goto L60;
        return r12;
    L60:
        r20 = this;
        r18 = r111;
        goto L61
    L63:
        return Unit.f21064a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r112 = r10.Z$0;
        r115 = (Iterator) r10.L$3;
        r114 = (Iterator) r10.L$2;
        r26 = (Map) r10.L$1;
        r25 = (UpdateVM) r10.L$0;
        kotlin.c.b(r16);
        goto L52
    L16:
        kotlin.c.b(r16);
        ArrayList r118 = new ArrayList(u.r(r13, 10));
        Iterator r30 = r13.iterator();
    L18:
        if (r30.hasNext() == false) goto L20;
        r118.add(((AppInfo) r30.next()).appPackageName);
        goto L18
    L20:
        Set r119 = b0.B0(r118);
        List r31 = t.l(new AppStatus.DownloadStatus[]{AppStatus.a.f17968a, AppStatus.b.f17970a});
        Iterable r32 = (Iterable) AppInstallActor.f17891n.b().S().getValue();
        ArrayList r33 = new ArrayList();
        Iterator r34 = r32.iterator();
    L22:
        if (r34.hasNext() == false) goto L28;
        Object r35 = r34.next();
        com.smt.obric.appstore.domain.app.entity.a r36 = (com.smt.obric.appstore.domain.app.entity.a) r35;
        if (r119.contains(r36.E()) == false) goto L22;
        if (b0.S(r31, r36.G()) == false) goto L22;
        r33.add(r35);
        goto L22
    L28:
        LinkedHashMap r120 = new LinkedHashMap();
        Iterator r37 = r33.iterator();
    L30:
        if (r37.hasNext() == false) goto L35;
        Object r38 = r37.next();
        String r39 = ((com.smt.obric.appstore.domain.app.entity.a) r38).E();
        Object r40 = r120.get(r39);
        if (r40 != null) goto L34;
        r40 = new ArrayList();
        r120.put(r39, r40);
    L34:
        ((List) r40).add(r38);
        goto L30
    L35:
        r19 = r13.iterator();
        r111 = r14;
        r110 = r120;
    L7:
        r10 = new UpdateVM$updateAll$2(this, r15);
        goto L8
    }

    public final void F(boolean r10) {
        Job r11 = this.f10764n;
        if (r11 != null) goto L5;
    L8:
        this.f10764n = kotlinx.coroutines.h.d(l0.a(this), null, null, new UpdateVM$updateAll$1(this, r10, null), 3, null);
        return;
    L5:
        if (r11.isActive() != true) goto L8;
        com.bytedanceos.common.toolbox.j.n("UpdateVM updateAll ignore while running");
    }

    public final void G() {
        Job r10 = this.f10764n;
        if (r10 != null) goto L5;
    L8:
        this.f10764n = kotlinx.coroutines.h.d(l0.a(this), null, null, new UpdateVM$updateAllWaitWiFi$1(this, null), 3, null);
        return;
    L5:
        if (r10.isActive() != true) goto L8;
        com.bytedanceos.common.toolbox.j.n("UpdateVM pauseAllUpdates ignore while running");
    }

    @Override // com.obric.appstore.base.ILoadViewModel
    public Object j(com.obric.appstore.base.j r10, Continuation r11) {
        if ((r11 instanceof UpdateVM$doLoad$1) == false) goto L7;
        UpdateVM$doLoad$1 r12 = (UpdateVM$doLoad$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L16;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L14;
        com.obric.appstore.base.j r17 = (com.obric.appstore.base.j) r12.L$1;
        UpdateVM r18 = (UpdateVM) r12.L$0;
        kotlin.c.b(r14);
    L23:
        com.bytedanceos.common.toolbox.j.n("UpdateVM doLoad() updateCache loaded: loadParams = " + r17);
        int r19 = a.f10765a[r18.f10761k.ordinal()];
        if (r19 == 1) goto L32;
        if (r19 != 2) goto L27;
        List r20 = B(r18, false, 1, null);
    L34:
        return new com.obric.appstore.network.g.d(r20);
    L27:
        if (r19 != 3) goto L30;
        r20 = r18.A(true);
        goto L34
    L30:
        throw new NoWhenBranchMatchedException();
    L32:
        r20 = r18.z();
        goto L34
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = (com.obric.appstore.base.j) r12.L$1;
        UpdateVM this = (UpdateVM) r12.L$0;
        kotlin.c.b(r14);
    L19:
        com.bytedanceos.common.toolbox.j.n("UpdateVM doLoad() localCache loaded: loadParams = " + r10);
        AppsManager r21 = AppsManager.f10585a;
        r12.L$0 = this;
        r12.L$1 = r10;
        r12.label = 2;
        if (r21.s(r12) != r15) goto L22;
        return r15;
    L22:
        com.obric.appstore.base.j r22 = r10;
        r18 = this;
        r17 = r22;
        goto L23
    L16:
        kotlin.c.b(r14);
        AppsManager r23 = AppsManager.f10585a;
        r12.L$0 = this;
        r12.L$1 = r10;
        r12.label = 1;
        if (r23.r(r12) != r15) goto L19;
        return r15;
    L7:
        r12 = new UpdateVM$doLoad$1(this, r11);
        goto L8
    }

    public final StateFlow x() {
        return this.f10760j;
    }

    public final void y(AppInfo r10, boolean r11) {
        q.g(r10, "appInfo");
        kotlinx.coroutines.h.d(l0.a(this), null, null, new UpdateVM$hideUpdateApp$1(this, r10, r11, null), 3, null);
    }

    public final List z() {
        List r10 = BaseApplication.c().b().v("HIDE");
        if (r10 != null) goto L5;
        r10 = t.i();
    L5:
        ArrayList r11 = new ArrayList(u.r(r10, 10));
        Iterator r12 = r10.iterator();
        int r13 = 0;
    L7:
        if (r12.hasNext() == false) goto L16;
        Object r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L11;
        t.q();
    L11:
        AppInfo r16 = (AppInfo) r14;
        q.d(r16);
        if (r13 == t.k(r10)) goto L14;
        boolean r17 = true;
    L15:
        r11.add(new e.a(r16, r17));
        r13 = r15;
        goto L7
    L14:
        r17 = false;
        goto L15
    L16:
        return r11;
    }
}
