package com.stepos.ailauncher.agent.skill.installed.viewmodel;

import La.H;
import Ua.C1060i;
import Ua.M;
import Xa.j;
import Xa.k;
import Xa.o;
import Xa.t;
import Xa.u;
import Z8.C1173v;
import Z8.C1174w;
import Z8.Y;
import android.view.Q;
import android.view.S;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;
import com.stepos.ailauncher.agent.skill.InstallKind;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import com.stepos.ailauncher.agent.skill.api.SkillApi;
import com.stepos.ailauncher.agent.skill.installed.adapter.InstalledRow;
import com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel;
import com.stepos.ailauncher.chat.wake.circle.F;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.net.HttpManager;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.channels.BufferOverflow;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import p9.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 r2\u00020\u0001:\u00040stuB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J#\u0010\u000e\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u001c\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0018\u0012\u0004\u0012\u00020\u001b0\u001a2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u0018H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J2\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001bH\u0082@¢\u0006\u0004\b&\u0010'J(\u0010(\u001a\u00020%2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001bH\u0082@¢\u0006\u0004\b(\u0010)J(\u0010*\u001a\u00020%2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001bH\u0082@¢\u0006\u0004\b*\u0010)J+\u0010-\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100+H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0004H\u0002¢\u0006\u0004\b/\u0010\u0003J\u000f\u00100\u001a\u00020\u0004H\u0014¢\u0006\u0004\b0\u0010\u0003J\u0015\u00101\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000b¢\u0006\u0004\b1\u00102J\u0015\u00103\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b3\u0010!J\r\u00104\u001a\u00020\u0004¢\u0006\u0004\b4\u0010\u0003J\u001d\u00108\u001a\u00020\u00042\u0006\u00105\u001a\u00020\f2\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J\u0015\u0010:\u001a\u00020\u00042\u0006\u00105\u001a\u00020\f¢\u0006\u0004\b:\u0010;R\u001d\u0010A\u001a\u0004\u0018\u00010<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001b\u0010F\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010>\u001a\u0004\bD\u0010ER\u001b\u0010K\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010>\u001a\u0004\bI\u0010JR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020M0L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u001d\u0010Q\u001a\b\u0012\u0004\u0012\u00020M0P8\u0006¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020\u000b0U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u001d\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u000b0X8\u0006¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u001a\u0010]\u001a\b\u0012\u0004\u0012\u00020\u000b0L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010OR\u0016\u0010_\u001a\u00020^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u00104R \u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020a0`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR \u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001b0`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010cR \u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020a0`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010cR\u0018\u0010f\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010h\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010gR\u0018\u0010i\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010gR\u0018\u0010j\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010gR\u0018\u0010k\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u001d\u0010n\u001a\b\u0012\u0004\u0012\u00020m0\u00188\u0006¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q¨\u0006v"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel;", "Landroidx/lifecycle/Q;", "<init>", "()V", "LY8/t;", "U", "X", "Y", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "", "", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "table", "y", "(Ljava/util/Map;)V", "Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel$d;", "tab", "M", "(Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel$d;Ljava/util/Map;)Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel$d;", "existing", "incoming", "L", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Lcom/stepos/ailauncher/agent/skill/SkillItem;)Lcom/stepos/ailauncher/agent/skill/SkillItem;", "", DidiCardProvider.KEY_ITEMS, "Lkotlin/Pair;", "", "D", "(Ljava/util/List;)Lkotlin/Pair;", "Lcom/stepos/ailauncher/agent/skill/InstallKind;", "kind", "O", "(Lcom/stepos/ailauncher/agent/skill/InstallKind;)V", "query", "page", "pageSize", "Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel$c;", "B", "(Lcom/stepos/ailauncher/agent/skill/InstallKind;Ljava/lang/String;IILe9/c;)Ljava/lang/Object;", "C", "(Ljava/lang/String;IILe9/c;)Ljava/lang/Object;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lkotlin/Function1;", "transform", "b0", "(Lcom/stepos/ailauncher/agent/skill/InstallKind;Lp9/l;)V", "N", Const.INTENT_KEY_UMID, "R", "(Ljava/lang/String;)V", "P", "J", "item", "", x5.d.EXTRA_ENABLED, "Q", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Z)V", "a0", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;)V", "LX4/a;", "svc$delegate", "LY8/h;", "H", "()LX4/a;", "svc", "Lcom/stepos/ailauncher/agent/skill/api/SkillApi;", "api$delegate", ExifInterface.LONGITUDE_EAST, "()Lcom/stepos/ailauncher/agent/skill/api/SkillApi;", "api", "Lcom/stepos/ailauncher/agent/skill/cli/d;", "cliRepository$delegate", "F", "()Lcom/stepos/ailauncher/agent/skill/cli/d;", "cliRepository", "LXa/k;", "Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel$b;", "_uiState", "LXa/k;", "LXa/t;", "uiState", "LXa/t;", "I", "()LXa/t;", "LXa/j;", "_operaError", "LXa/j;", "LXa/o;", "operaError", "LXa/o;", "G", "()LXa/o;", "searchQueryFlow", "", "lastSearchInputTs", "", "Lkotlinx/coroutines/g;", "pageJobs", "Ljava/util/Map;", "generations", "reloadJobs", "errorEventsJob", "Lkotlinx/coroutines/g;", "togglingSubscriptionJob", "uninstallingSubscriptionJob", "stateTableSubscriptionJob", "subscriberId", "Ljava/lang/String;", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "installStatus", "Ljava/util/List;", "getInstallStatus", "()Ljava/util/List;", "Companion", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InstalledSkillViewModel extends Q {
    private static final int PAGE_SIZE = 20;
    private final j<String> _operaError;
    private final k<InstalledSkillUiState> _uiState;
    private kotlinx.coroutines.g errorEventsJob;
    private final Map<InstallKind, Integer> generations;
    private final List<SkillStatus> installStatus;
    private long lastSearchInputTs;
    private final o<String> operaError;
    private final Map<InstallKind, kotlinx.coroutines.g> pageJobs;
    private final Map<InstallKind, kotlinx.coroutines.g> reloadJobs;
    private final k<String> searchQueryFlow;
    private kotlinx.coroutines.g stateTableSubscriptionJob;
    private String subscriberId;
    private kotlinx.coroutines.g togglingSubscriptionJob;
    private final t<InstalledSkillUiState> uiState;
    private kotlinx.coroutines.g uninstallingSubscriptionJob;
    private static final List<SkillStatus> INSTALLED_CLI_STATUSES = C1173v.p(SkillStatus.CONNECTED, SkillStatus.DISCONNECTED, SkillStatus.TOGGLING);
    private static final Set<SkillStatus> AUTHORITATIVE_TERMINAL_STATUSES = Y.j(SkillStatus.INSTALLED_ENABLED, SkillStatus.INSTALLED_DISABLED, SkillStatus.INSTALLED);

    /* renamed from: svc$delegate, reason: from kotlin metadata */
    private final Y8.h svc = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.skill.installed.viewmodel.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return InstalledSkillViewModel.Z();
        }
    });

    /* renamed from: api$delegate, reason: from kotlin metadata */
    private final Y8.h api = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.skill.installed.viewmodel.b
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return InstalledSkillViewModel.x(this.f24466a);
        }
    });

    /* renamed from: cliRepository$delegate, reason: from kotlin metadata */
    private final Y8.h cliRepository = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.skill.installed.viewmodel.c
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return InstalledSkillViewModel.z();
        }
    });

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel$1", f = "InstalledSkillViewModel.kt", l = {F.GESTURE_HEIGHT_DP}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel$1$a */
        public static final class a<T> implements Xa.c {
            final /* synthetic */ InstalledSkillViewModel this$0;

            public a(InstalledSkillViewModel installedSkillViewModel) {
                this.this$0 = installedSkillViewModel;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // Xa.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(String str, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                Object value;
                k kVar = this.this$0._uiState;
                do {
                    value = kVar.getValue();
                } while (!kVar.d(value, InstalledSkillUiState.b((InstalledSkillUiState) value, null, null, null, str, false, false, false, null, null, false, 1015, null)));
                this.this$0.O(InstallKind.SKILL);
                this.this$0.O(InstallKind.CLI);
                return Y8.t.f7040a;
            }
        }

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return InstalledSkillViewModel.this.new AnonymousClass1(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                Xa.b bVarP = Xa.d.p(Xa.d.s(InstalledSkillViewModel.this.searchQueryFlow, 1), 300L);
                a aVar = new a(InstalledSkillViewModel.this);
                this.label = 1;
                if (bVarP.collect(aVar, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\r\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0080\u0001\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\b\b\u0002\u0010\u0010\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b \u0010\u001fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b%\u0010\u0016R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\u000b\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010&\u001a\u0004\b)\u0010(R\u0017\u0010\f\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\f\u0010&\u001a\u0004\b*\u0010(R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010+\u001a\u0004\b,\u0010-R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010+\u001a\u0004\b.\u0010-R\u0017\u0010\u0010\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b/\u0010(R\u0014\u00101\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u001fR\u0017\u00106\u001a\b\u0012\u0004\u0012\u000203028F¢\u0006\u0006\u001a\u0004\b4\u00105R\u0011\u00108\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b7\u0010\u0019R\u0011\u0010:\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b9\u0010\u0019¨\u0006;"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel$b;", "", "Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel$d;", "skillTab", "cliTab", "Lcom/stepos/ailauncher/agent/skill/InstallKind;", "selectedTab", "", "searchQuery", "", "isEmptyAll", "isEmptySearch", "isEmptyTab", "", "togglingIds", "uninstallingIds", "feishuToggling", "<init>", "(Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel$d;Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel$d;Lcom/stepos/ailauncher/agent/skill/InstallKind;Ljava/lang/String;ZZZLjava/util/Set;Ljava/util/Set;Z)V", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel$d;Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel$d;Lcom/stepos/ailauncher/agent/skill/InstallKind;Ljava/lang/String;ZZZLjava/util/Set;Ljava/util/Set;Z)Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel$b;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel$d;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel$d;", Const.INTENT_KEY_UMID, "Lcom/stepos/ailauncher/agent/skill/InstallKind;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lcom/stepos/ailauncher/agent/skill/InstallKind;", "Ljava/lang/String;", "f", "Z", "l", "()Z", "m", "n", "Ljava/util/Set;", "getTogglingIds", "()Ljava/util/Set;", "k", "getFeishuToggling", "e", "currentTab", "", "Lcom/stepos/ailauncher/agent/skill/installed/adapter/a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/util/List;", "skillItems", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "skillCount", "c", "cliCount", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel$b, reason: from toString */
    public static final /* data */ class InstalledSkillUiState {
        private final TabState cliTab;
        private final boolean feishuToggling;
        private final boolean isEmptyAll;
        private final boolean isEmptySearch;
        private final boolean isEmptyTab;
        private final String searchQuery;
        private final InstallKind selectedTab;
        private final TabState skillTab;
        private final Set<String> togglingIds;
        private final Set<String> uninstallingIds;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel$b$a */
        public static final /* synthetic */ class a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[InstallKind.values().length];
                try {
                    iArr[InstallKind.SKILL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[InstallKind.CLI.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[InstallKind.AGENT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public InstalledSkillUiState() {
            this(null, null, null, null, false, false, false, null, null, false, FastDoubleMath.DOUBLE_EXPONENT_BIAS, null);
        }

        public static /* synthetic */ InstalledSkillUiState b(InstalledSkillUiState installedSkillUiState, TabState tabState, TabState tabState2, InstallKind installKind, String str, boolean z10, boolean z11, boolean z12, Set set, Set set2, boolean z13, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                tabState = installedSkillUiState.skillTab;
            }
            if ((i10 & 2) != 0) {
                tabState2 = installedSkillUiState.cliTab;
            }
            if ((i10 & 4) != 0) {
                installKind = installedSkillUiState.selectedTab;
            }
            if ((i10 & 8) != 0) {
                str = installedSkillUiState.searchQuery;
            }
            if ((i10 & 16) != 0) {
                z10 = installedSkillUiState.isEmptyAll;
            }
            if ((i10 & 32) != 0) {
                z11 = installedSkillUiState.isEmptySearch;
            }
            if ((i10 & 64) != 0) {
                z12 = installedSkillUiState.isEmptyTab;
            }
            if ((i10 & 128) != 0) {
                set = installedSkillUiState.togglingIds;
            }
            if ((i10 & 256) != 0) {
                set2 = installedSkillUiState.uninstallingIds;
            }
            if ((i10 & 512) != 0) {
                z13 = installedSkillUiState.feishuToggling;
            }
            Set set3 = set2;
            boolean z14 = z13;
            boolean z15 = z12;
            Set set4 = set;
            boolean z16 = z10;
            boolean z17 = z11;
            return installedSkillUiState.a(tabState, tabState2, installKind, str, z16, z17, z15, set4, set3, z14);
        }

        public final InstalledSkillUiState a(TabState skillTab, TabState cliTab, InstallKind selectedTab, String searchQuery, boolean isEmptyAll, boolean isEmptySearch, boolean isEmptyTab, Set<String> togglingIds, Set<String> uninstallingIds, boolean feishuToggling) {
            kotlin.jvm.internal.p.i(skillTab, "skillTab");
            kotlin.jvm.internal.p.i(cliTab, "cliTab");
            kotlin.jvm.internal.p.i(selectedTab, "selectedTab");
            kotlin.jvm.internal.p.i(searchQuery, "searchQuery");
            kotlin.jvm.internal.p.i(togglingIds, "togglingIds");
            kotlin.jvm.internal.p.i(uninstallingIds, "uninstallingIds");
            return new InstalledSkillUiState(skillTab, cliTab, selectedTab, searchQuery, isEmptyAll, isEmptySearch, isEmptyTab, togglingIds, uninstallingIds, feishuToggling);
        }

        public final int c() {
            return this.cliTab.getTotalCount();
        }

        /* renamed from: d, reason: from getter */
        public final TabState getCliTab() {
            return this.cliTab;
        }

        public final TabState e() {
            int i10 = a.$EnumSwitchMapping$0[this.selectedTab.ordinal()];
            if (i10 == 1) {
                return this.skillTab;
            }
            if (i10 == 2) {
                return this.cliTab;
            }
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            return new TabState(null, 0, false, false, false, false, 0, false, 255, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InstalledSkillUiState)) {
                return false;
            }
            InstalledSkillUiState installedSkillUiState = (InstalledSkillUiState) other;
            return kotlin.jvm.internal.p.d(this.skillTab, installedSkillUiState.skillTab) && kotlin.jvm.internal.p.d(this.cliTab, installedSkillUiState.cliTab) && this.selectedTab == installedSkillUiState.selectedTab && kotlin.jvm.internal.p.d(this.searchQuery, installedSkillUiState.searchQuery) && this.isEmptyAll == installedSkillUiState.isEmptyAll && this.isEmptySearch == installedSkillUiState.isEmptySearch && this.isEmptyTab == installedSkillUiState.isEmptyTab && kotlin.jvm.internal.p.d(this.togglingIds, installedSkillUiState.togglingIds) && kotlin.jvm.internal.p.d(this.uninstallingIds, installedSkillUiState.uninstallingIds) && this.feishuToggling == installedSkillUiState.feishuToggling;
        }

        /* renamed from: f, reason: from getter */
        public final String getSearchQuery() {
            return this.searchQuery;
        }

        /* renamed from: g, reason: from getter */
        public final InstallKind getSelectedTab() {
            return this.selectedTab;
        }

        public final int h() {
            return this.skillTab.getTotalCount();
        }

        public int hashCode() {
            return (((((((((((((((((this.skillTab.hashCode() * 31) + this.cliTab.hashCode()) * 31) + this.selectedTab.hashCode()) * 31) + this.searchQuery.hashCode()) * 31) + Boolean.hashCode(this.isEmptyAll)) * 31) + Boolean.hashCode(this.isEmptySearch)) * 31) + Boolean.hashCode(this.isEmptyTab)) * 31) + this.togglingIds.hashCode()) * 31) + this.uninstallingIds.hashCode()) * 31) + Boolean.hashCode(this.feishuToggling);
        }

        public final List<InstalledRow> i() {
            List<SkillItem> listE = e().e();
            ArrayList arrayList = new ArrayList(C1174w.x(listE, 10));
            for (SkillItem skillItem : listE) {
                arrayList.add(new InstalledRow(skillItem, this.togglingIds.contains(skillItem.getIdentifier()) || (kotlin.jvm.internal.p.d(skillItem.getIdentifier(), "lark-cli") && this.feishuToggling), this.uninstallingIds.contains(skillItem.getIdentifier())));
            }
            return arrayList;
        }

        /* renamed from: j, reason: from getter */
        public final TabState getSkillTab() {
            return this.skillTab;
        }

        public final Set<String> k() {
            return this.uninstallingIds;
        }

        /* renamed from: l, reason: from getter */
        public final boolean getIsEmptyAll() {
            return this.isEmptyAll;
        }

        /* renamed from: m, reason: from getter */
        public final boolean getIsEmptySearch() {
            return this.isEmptySearch;
        }

        /* renamed from: n, reason: from getter */
        public final boolean getIsEmptyTab() {
            return this.isEmptyTab;
        }

        public String toString() {
            return "InstalledSkillUiState(skillTab=" + this.skillTab + ", cliTab=" + this.cliTab + ", selectedTab=" + this.selectedTab + ", searchQuery=" + this.searchQuery + ", isEmptyAll=" + this.isEmptyAll + ", isEmptySearch=" + this.isEmptySearch + ", isEmptyTab=" + this.isEmptyTab + ", togglingIds=" + this.togglingIds + ", uninstallingIds=" + this.uninstallingIds + ", feishuToggling=" + this.feishuToggling + ")";
        }

        public InstalledSkillUiState(TabState skillTab, TabState cliTab, InstallKind selectedTab, String searchQuery, boolean z10, boolean z11, boolean z12, Set<String> togglingIds, Set<String> uninstallingIds, boolean z13) {
            kotlin.jvm.internal.p.i(skillTab, "skillTab");
            kotlin.jvm.internal.p.i(cliTab, "cliTab");
            kotlin.jvm.internal.p.i(selectedTab, "selectedTab");
            kotlin.jvm.internal.p.i(searchQuery, "searchQuery");
            kotlin.jvm.internal.p.i(togglingIds, "togglingIds");
            kotlin.jvm.internal.p.i(uninstallingIds, "uninstallingIds");
            this.skillTab = skillTab;
            this.cliTab = cliTab;
            this.selectedTab = selectedTab;
            this.searchQuery = searchQuery;
            this.isEmptyAll = z10;
            this.isEmptySearch = z11;
            this.isEmptyTab = z12;
            this.togglingIds = togglingIds;
            this.uninstallingIds = uninstallingIds;
            this.feishuToggling = z13;
        }

        public /* synthetic */ InstalledSkillUiState(TabState tabState, TabState tabState2, InstallKind installKind, String str, boolean z10, boolean z11, boolean z12, Set set, Set set2, boolean z13, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? new TabState(null, 0, false, false, false, false, 0, false, 255, null) : tabState, (i10 & 2) != 0 ? new TabState(null, 0, false, false, false, false, 0, false, 255, null) : tabState2, (i10 & 4) != 0 ? InstallKind.SKILL : installKind, (i10 & 8) != 0 ? "" : str, (i10 & 16) != 0 ? false : z10, (i10 & 32) != 0 ? false : z11, (i10 & 64) != 0 ? false : z12, (i10 & 128) != 0 ? Y.e() : set, (i10 & 256) != 0 ? Y.e() : set2, (i10 & 512) != 0 ? false : z13);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u000fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel$c;", "", "", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", DidiCardProvider.KEY_ITEMS, "", "total", "", "hasMore", "<init>", "(Ljava/util/List;IZ)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "I", "c", "Z", Const.INTENT_KEY_APIKEY, "()Z", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel$c, reason: from toString */
    public static final /* data */ class PageResult {
        private final boolean hasMore;
        private final List<SkillItem> items;
        private final int total;

        public PageResult(List<SkillItem> items, int i10, boolean z10) {
            kotlin.jvm.internal.p.i(items, "items");
            this.items = items;
            this.total = i10;
            this.hasMore = z10;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getHasMore() {
            return this.hasMore;
        }

        public final List<SkillItem> b() {
            return this.items;
        }

        /* renamed from: c, reason: from getter */
        public final int getTotal() {
            return this.total;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageResult)) {
                return false;
            }
            PageResult pageResult = (PageResult) other;
            return kotlin.jvm.internal.p.d(this.items, pageResult.items) && this.total == pageResult.total && this.hasMore == pageResult.hasMore;
        }

        public int hashCode() {
            return (((this.items.hashCode() * 31) + Integer.hashCode(this.total)) * 31) + Boolean.hashCode(this.hasMore);
        }

        public String toString() {
            return "PageResult(items=" + this.items + ", total=" + this.total + ", hasMore=" + this.hasMore + ")";
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJf\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u0016R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b\"\u0010!R\u0017\u0010\n\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b#\u0010!R\u0017\u0010\u000b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b$\u0010!R\u0017\u0010\f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b%\u0010\u0016R\u0017\u0010\r\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b&\u0010!¨\u0006'"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel$d;", "", "", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", DidiCardProvider.KEY_ITEMS, "", "page", "", "hasMore", "loadError", "isLoading", "isLoadingMore", "totalCount", "hasLoadedOnce", "<init>", "(Ljava/util/List;IZZZZIZ)V", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;IZZZZIZ)Lcom/stepos/ailauncher/agent/skill/installed/viewmodel/InstalledSkillViewModel$d;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "e", "()Ljava/util/List;", "I", Const.INTENT_KEY_BACKGROUND_COMMAND, "Z", Const.INTENT_KEY_UMID, "()Z", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "c", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel$d, reason: from toString */
    public static final /* data */ class TabState {
        private final boolean hasLoadedOnce;
        private final boolean hasMore;
        private final boolean isLoading;
        private final boolean isLoadingMore;
        private final List<SkillItem> items;
        private final boolean loadError;
        private final int page;
        private final int totalCount;

        public TabState() {
            this(null, 0, false, false, false, false, 0, false, 255, null);
        }

        public static /* synthetic */ TabState b(TabState tabState, List list, int i10, boolean z10, boolean z11, boolean z12, boolean z13, int i11, boolean z14, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                list = tabState.items;
            }
            if ((i12 & 2) != 0) {
                i10 = tabState.page;
            }
            if ((i12 & 4) != 0) {
                z10 = tabState.hasMore;
            }
            if ((i12 & 8) != 0) {
                z11 = tabState.loadError;
            }
            if ((i12 & 16) != 0) {
                z12 = tabState.isLoading;
            }
            if ((i12 & 32) != 0) {
                z13 = tabState.isLoadingMore;
            }
            if ((i12 & 64) != 0) {
                i11 = tabState.totalCount;
            }
            if ((i12 & 128) != 0) {
                z14 = tabState.hasLoadedOnce;
            }
            int i13 = i11;
            boolean z15 = z14;
            boolean z16 = z12;
            boolean z17 = z13;
            return tabState.a(list, i10, z10, z11, z16, z17, i13, z15);
        }

        public final TabState a(List<SkillItem> items, int page, boolean hasMore, boolean loadError, boolean isLoading, boolean isLoadingMore, int totalCount, boolean hasLoadedOnce) {
            kotlin.jvm.internal.p.i(items, "items");
            return new TabState(items, page, hasMore, loadError, isLoading, isLoadingMore, totalCount, hasLoadedOnce);
        }

        /* renamed from: c, reason: from getter */
        public final boolean getHasLoadedOnce() {
            return this.hasLoadedOnce;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getHasMore() {
            return this.hasMore;
        }

        public final List<SkillItem> e() {
            return this.items;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TabState)) {
                return false;
            }
            TabState tabState = (TabState) other;
            return kotlin.jvm.internal.p.d(this.items, tabState.items) && this.page == tabState.page && this.hasMore == tabState.hasMore && this.loadError == tabState.loadError && this.isLoading == tabState.isLoading && this.isLoadingMore == tabState.isLoadingMore && this.totalCount == tabState.totalCount && this.hasLoadedOnce == tabState.hasLoadedOnce;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getLoadError() {
            return this.loadError;
        }

        /* renamed from: g, reason: from getter */
        public final int getPage() {
            return this.page;
        }

        /* renamed from: h, reason: from getter */
        public final int getTotalCount() {
            return this.totalCount;
        }

        public int hashCode() {
            return (((((((((((((this.items.hashCode() * 31) + Integer.hashCode(this.page)) * 31) + Boolean.hashCode(this.hasMore)) * 31) + Boolean.hashCode(this.loadError)) * 31) + Boolean.hashCode(this.isLoading)) * 31) + Boolean.hashCode(this.isLoadingMore)) * 31) + Integer.hashCode(this.totalCount)) * 31) + Boolean.hashCode(this.hasLoadedOnce);
        }

        /* renamed from: i, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        /* renamed from: j, reason: from getter */
        public final boolean getIsLoadingMore() {
            return this.isLoadingMore;
        }

        public String toString() {
            return "TabState(items=" + this.items + ", page=" + this.page + ", hasMore=" + this.hasMore + ", loadError=" + this.loadError + ", isLoading=" + this.isLoading + ", isLoadingMore=" + this.isLoadingMore + ", totalCount=" + this.totalCount + ", hasLoadedOnce=" + this.hasLoadedOnce + ")";
        }

        public TabState(List<SkillItem> items, int i10, boolean z10, boolean z11, boolean z12, boolean z13, int i11, boolean z14) {
            kotlin.jvm.internal.p.i(items, "items");
            this.items = items;
            this.page = i10;
            this.hasMore = z10;
            this.loadError = z11;
            this.isLoading = z12;
            this.isLoadingMore = z13;
            this.totalCount = i11;
            this.hasLoadedOnce = z14;
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException
            */
        public /* synthetic */ TabState(java.util.List r2, int r3, boolean r4, boolean r5, boolean r6, boolean r7, int r8, boolean r9, int r10, kotlin.jvm.internal.i r11) {
            /*
                r1 = this;
                r11 = r10 & 1
                if (r11 == 0) goto L8
                java.util.List r2 = Z8.C1173v.m()
            L8:
                r11 = r10 & 2
                r0 = 0
                if (r11 == 0) goto Le
                r3 = r0
            Le:
                r11 = r10 & 4
                if (r11 == 0) goto L13
                r4 = 1
            L13:
                r11 = r10 & 8
                if (r11 == 0) goto L18
                r5 = r0
            L18:
                r11 = r10 & 16
                if (r11 == 0) goto L1d
                r6 = r0
            L1d:
                r11 = r10 & 32
                if (r11 == 0) goto L22
                r7 = r0
            L22:
                r11 = r10 & 64
                if (r11 == 0) goto L27
                r8 = r0
            L27:
                r10 = r10 & 128(0x80, float:1.8E-43)
                if (r10 == 0) goto L35
                r11 = r0
                r9 = r7
                r10 = r8
                r7 = r5
                r8 = r6
                r5 = r3
                r6 = r4
                r3 = r1
                r4 = r2
                goto L3e
            L35:
                r11 = r9
                r10 = r8
                r8 = r6
                r9 = r7
                r6 = r4
                r7 = r5
                r4 = r2
                r5 = r3
                r3 = r1
            L3e:
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel.TabState.<init>(java.util.List, int, boolean, boolean, boolean, boolean, int, boolean, int, kotlin.jvm.internal.i):void");
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class e {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InstallKind.values().length];
            try {
                iArr[InstallKind.SKILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InstallKind.CLI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InstallKind.AGENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public InstalledSkillViewModel() {
        k<InstalledSkillUiState> kVarA = u.a(new InstalledSkillUiState(null, null, null, null, false, false, false, null, null, false, FastDoubleMath.DOUBLE_EXPONENT_BIAS, null));
        this._uiState = kVarA;
        this.uiState = Xa.d.c(kVarA);
        j<String> jVarB = Xa.p.b(0, 8, BufferOverflow.DROP_OLDEST, 1, null);
        this._operaError = jVarB;
        this.operaError = jVarB;
        this.searchQueryFlow = u.a("");
        this.pageJobs = new LinkedHashMap();
        this.generations = new LinkedHashMap();
        this.reloadJobs = new LinkedHashMap();
        this.installStatus = C1173v.p(SkillStatus.CONNECTED, SkillStatus.TOGGLING, SkillStatus.DISCONNECTED, SkillStatus.INSTALLED_ENABLED, SkillStatus.INSTALLED_DISABLED);
        C1060i.d(S.a(this), null, null, new AnonymousClass1(null), 3, null);
        O(InstallKind.SKILL);
        O(InstallKind.CLI);
        U();
        X();
        Y();
        W();
        V();
        String str = "installed-" + System.currentTimeMillis();
        this.subscriberId = str;
        X4.a aVarH = H();
        if (aVarH != null) {
            aVarH.e(str);
        }
    }

    private final com.stepos.ailauncher.agent.skill.cli.d F() {
        return (com.stepos.ailauncher.agent.skill.cli.d) this.cliRepository.getValue();
    }

    public static final TabState K(TabState it) {
        kotlin.jvm.internal.p.i(it, "it");
        return TabState.b(it, null, 0, false, false, false, true, 0, false, 215, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
    
        if (r46.getDownloadCount() <= 0) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.stepos.ailauncher.agent.skill.SkillItem L(com.stepos.ailauncher.agent.skill.SkillItem r45, com.stepos.ailauncher.agent.skill.SkillItem r46) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel.L(com.stepos.ailauncher.agent.skill.SkillItem, com.stepos.ailauncher.agent.skill.SkillItem):com.stepos.ailauncher.agent.skill.SkillItem");
    }

    public static final TabState S(TabState it) {
        kotlin.jvm.internal.p.i(it, "it");
        return TabState.b(it, null, 0, false, false, true, false, 0, false, 207, null);
    }

    public static final TabState T(TabState it) {
        kotlin.jvm.internal.p.i(it, "it");
        return TabState.b(it, null, 0, false, false, true, false, 0, false, 207, null);
    }

    public static final X4.a Z() {
        return (X4.a) D5.a.INSTANCE.a(X4.a.class);
    }

    public static final SkillApi x(InstalledSkillViewModel installedSkillViewModel) throws Throwable {
        Object objB;
        C4148a.d("InstalledSkillVM", "create SkillApi via HttpManager(skillStore)", false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((SkillApi) HttpManager.INSTANCE.create(SkillApi.class, "skillStore"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g("InstalledSkillVM", "HttpManager.create<SkillApi> failed", thE, false, 8, null);
        }
        C4849c.b(objB);
        return (SkillApi) objB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.stepos.ailauncher.agent.skill.cli.d z() {
        return com.stepos.ailauncher.agent.skill.cli.f.INSTANCE.c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
    
        if (r9 == r1) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007b, code lost:
    
        if (r9 == r1) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object A(java.lang.String r6, int r7, int r8, e9.InterfaceC4014c<? super com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel.PageResult> r9) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel$fetchCliPage$1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel$fetchCliPage$1 r0 = (com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel$fetchCliPage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel$fetchCliPage$1 r0 = new com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel$fetchCliPage$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.C4849c.b(r9)
            goto L7e
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.C4849c.b(r9)
            goto L62
        L40:
            kotlin.C4849c.b(r9)
            boolean r9 = La.H.x0(r6)
            if (r9 == 0) goto L65
            com.stepos.ailauncher.agent.skill.cli.d r5 = r5.F()
            java.util.List<com.stepos.ailauncher.agent.skill.SkillStatus> r9 = com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel.INSTALLED_CLI_STATUSES
            java.lang.Object r6 = g9.h.a(r6)
            r0.L$0 = r6
            r0.I$0 = r7
            r0.I$1 = r8
            r0.label = r4
            java.lang.Object r9 = r5.b(r9, r0)
            if (r9 != r1) goto L62
            goto L7d
        L62:
            java.util.List r9 = (java.util.List) r9
            goto L80
        L65:
            com.stepos.ailauncher.agent.skill.cli.d r5 = r5.F()
            java.util.List<com.stepos.ailauncher.agent.skill.SkillStatus> r9 = com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel.INSTALLED_CLI_STATUSES
            java.lang.Object r2 = g9.h.a(r6)
            r0.L$0 = r2
            r0.I$0 = r7
            r0.I$1 = r8
            r0.label = r3
            java.lang.Object r9 = r5.c(r6, r9, r0)
            if (r9 != r1) goto L7e
        L7d:
            return r1
        L7e:
            java.util.List r9 = (java.util.List) r9
        L80:
            com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel$c r5 = new com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel$c
            int r6 = r9.size()
            r7 = 0
            r5.<init>(r9, r6, r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel.A(java.lang.String, int, int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0090, code lost:
    
        if (r15 == r1) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object B(com.stepos.ailauncher.agent.skill.InstallKind r11, java.lang.String r12, int r13, int r14, e9.InterfaceC4014c<? super com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel.PageResult> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 196
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel.B(com.stepos.ailauncher.agent.skill.InstallKind, java.lang.String, int, int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object C(java.lang.String r9, int r10, int r11, e9.InterfaceC4014c<? super com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel.PageResult> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel.C(java.lang.String, int, int, e9.c):java.lang.Object");
    }

    public final Pair<List<SkillItem>, Integer> D(List<SkillItem> items) {
        t<Map<String, SkillItem>> tVarJ;
        X4.a aVarH = H();
        Map<String, SkillItem> value = (aVarH == null || (tVarJ = aVarH.j()) == null) ? null : tVarJ.getValue();
        if (value == null) {
            value = kotlin.collections.a.i();
        }
        if (value.isEmpty()) {
            return Y8.j.a(items, 0);
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : items) {
            SkillItem skillItem = (SkillItem) obj;
            C4148a.d("InstalledSkillVM", "[filter] status id=" + skillItem.getIdentifier() + ", " + value.get(skillItem.getIdentifier()), false, 4, null);
            List<SkillStatus> list = this.installStatus;
            SkillItem skillItem2 = value.get(skillItem.getIdentifier());
            if (Z8.F.f0(list, skillItem2 != null ? skillItem2.getStatus() : null)) {
                arrayList.add(obj);
            } else {
                C4148a.d("InstalledSkillVM", "[filter] drop already-uninstalled id=" + skillItem.getIdentifier(), false, 4, null);
            }
        }
        return Y8.j.a(items, 0);
    }

    public final SkillApi E() {
        return (SkillApi) this.api.getValue();
    }

    public final o<String> G() {
        return this.operaError;
    }

    public final X4.a H() {
        return (X4.a) this.svc.getValue();
    }

    public final t<InstalledSkillUiState> I() {
        return this.uiState;
    }

    public final void J() {
        InstalledSkillUiState value = this._uiState.getValue();
        InstallKind selectedTab = value.getSelectedTab();
        if (selectedTab == InstallKind.AGENT) {
            return;
        }
        TabState skillTab = selectedTab == InstallKind.SKILL ? value.getSkillTab() : value.getCliTab();
        if (skillTab.getIsLoading() || skillTab.getIsLoadingMore() || !skillTab.getHasMore()) {
            return;
        }
        Integer num = this.generations.get(selectedTab);
        int iIntValue = num != null ? num.intValue() : 0;
        b0(selectedTab, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.installed.viewmodel.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return InstalledSkillViewModel.K((InstalledSkillViewModel.TabState) obj);
            }
        });
        this.pageJobs.put(selectedTab, C1060i.d(S.a(this), null, null, new InstalledSkillViewModel$loadMore$2(skillTab, this, selectedTab, value, iIntValue, null), 3, null));
    }

    public final TabState M(TabState tab, Map<String, SkillItem> table) {
        ArrayList arrayList = new ArrayList(tab.e().size());
        boolean z10 = false;
        int i10 = 0;
        for (SkillItem skillItem : tab.e()) {
            SkillItem skillItem2 = table.get(skillItem.getIdentifier());
            if (skillItem2 == null) {
                arrayList.add(skillItem);
            } else if (skillItem2.getStatus() == SkillStatus.UNINSTALLED) {
                C4148a.d("InstalledSkillVM", "[patch] drop UNINSTALLED id=" + skillItem.getIdentifier(), false, 4, null);
                i10 += -1;
                z10 = true;
            } else {
                SkillItem skillItemL = L(skillItem, skillItem2);
                if (skillItemL != skillItem) {
                    C4148a.d("InstalledSkillVM", "[patch] merge id=" + skillItem.getIdentifier() + " before=" + skillItem.getStatus() + " overlay=" + skillItem2.getStatus() + " after=" + skillItemL.getStatus(), false, 4, null);
                    z10 = true;
                }
                arrayList.add(skillItemL);
            }
        }
        return !z10 ? tab : TabState.b(tab, arrayList, 0, false, false, false, false, C5685n.f(tab.getTotalCount() + i10, 0), false, F.GESTURE_WIDTH_DP, null);
    }

    public final void N() {
        InstalledSkillUiState value;
        InstalledSkillUiState installedSkillUiState;
        boolean z10;
        boolean zX0;
        k<InstalledSkillUiState> kVar = this._uiState;
        do {
            value = kVar.getValue();
            installedSkillUiState = value;
            TabState skillTab = installedSkillUiState.getSelectedTab() == InstallKind.SKILL ? installedSkillUiState.getSkillTab() : installedSkillUiState.getCliTab();
            z10 = skillTab.getHasLoadedOnce() && !skillTab.getIsLoading() && skillTab.e().isEmpty();
            zX0 = H.x0(installedSkillUiState.getSearchQuery());
        } while (!kVar.d(value, InstalledSkillUiState.b(installedSkillUiState, null, null, null, null, z10 && zX0, z10 && !zX0, false, null, null, false, 911, null)));
    }

    public final void O(InstallKind kind) {
        kotlinx.coroutines.g gVar = this.reloadJobs.get(kind);
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        kotlinx.coroutines.g gVar2 = this.pageJobs.get(kind);
        if (gVar2 != null) {
            kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
        }
        Integer num = this.generations.get(kind);
        int iIntValue = (num != null ? num.intValue() : 0) + 1;
        this.generations.put(kind, Integer.valueOf(iIntValue));
        this.reloadJobs.put(kind, C1060i.d(S.a(this), null, null, new InstalledSkillViewModel$reloadTab$1(this, kind, iIntValue, null), 3, null));
    }

    public final void P(InstallKind kind) {
        InstallKind kind2 = kind;
        kotlin.jvm.internal.p.i(kind2, "kind");
        if (this._uiState.getValue().getSelectedTab() == kind2) {
            return;
        }
        k<InstalledSkillUiState> kVar = this._uiState;
        while (true) {
            InstalledSkillUiState value = kVar.getValue();
            if (kVar.d(value, InstalledSkillUiState.b(value, null, null, kind2, null, false, false, false, null, null, false, 1019, null))) {
                N();
                return;
            }
            kind2 = kind;
        }
    }

    public final void Q(SkillItem item, boolean enabled) {
        kotlin.jvm.internal.p.i(item, "item");
        X4.a aVarH = H();
        if (aVarH == null) {
            return;
        }
        if (!aVarH.l().getValue().contains(item.getIdentifier())) {
            if (enabled) {
                aVarH.c(item);
                return;
            } else {
                aVarH.b(item);
                return;
            }
        }
        C4148a.d("InstalledSkillVM", "setEnabled ignored: id=" + item.getIdentifier() + " already toggling", false, 4, null);
    }

    public final void R(String query) {
        kotlin.jvm.internal.p.i(query, "query");
        if (kotlin.jvm.internal.p.d(query, this.searchQueryFlow.getValue())) {
            return;
        }
        this.lastSearchInputTs = System.currentTimeMillis();
        Iterator<T> it = this.pageJobs.values().iterator();
        while (it.hasNext()) {
            kotlinx.coroutines.g.Y0((kotlinx.coroutines.g) it.next(), null, 1, null);
        }
        Iterator<T> it2 = this.reloadJobs.values().iterator();
        while (it2.hasNext()) {
            kotlinx.coroutines.g.Y0((kotlinx.coroutines.g) it2.next(), null, 1, null);
        }
        for (InstallKind installKind : InstallKind.getEntries()) {
            Map<InstallKind, Integer> map = this.generations;
            Integer num = map.get(installKind);
            map.put(installKind, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
        }
        b0(InstallKind.SKILL, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.installed.viewmodel.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return InstalledSkillViewModel.S((InstalledSkillViewModel.TabState) obj);
            }
        });
        b0(InstallKind.CLI, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.installed.viewmodel.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return InstalledSkillViewModel.T((InstalledSkillViewModel.TabState) obj);
            }
        });
        this.searchQueryFlow.setValue(query);
    }

    public final void U() {
        X4.a aVarH = H();
        if (aVarH == null) {
            return;
        }
        this.errorEventsJob = C1060i.d(S.a(this), null, null, new InstalledSkillViewModel$subscribeErrorEvents$1(aVarH, this, null), 3, null);
    }

    public final void V() {
        C1060i.d(S.a(this), null, null, new InstalledSkillViewModel$subscribeFeishuToggling$1(this, null), 3, null);
    }

    public final void W() {
        X4.a aVarH = H();
        if (aVarH == null) {
            return;
        }
        this.stateTableSubscriptionJob = C1060i.d(S.a(this), null, null, new InstalledSkillViewModel$subscribeStateTable$1(aVarH, this, null), 3, null);
    }

    public final void X() {
        X4.a aVarH = H();
        if (aVarH == null) {
            return;
        }
        this.togglingSubscriptionJob = C1060i.d(S.a(this), null, null, new InstalledSkillViewModel$subscribeToggling$1(aVarH, this, null), 3, null);
    }

    public final void Y() {
        X4.a aVarH = H();
        if (aVarH == null) {
            return;
        }
        this.uninstallingSubscriptionJob = C1060i.d(S.a(this), null, null, new InstalledSkillViewModel$subscribeUninstalling$1(aVarH, this, null), 3, null);
    }

    public final void a0(SkillItem item) {
        kotlin.jvm.internal.p.i(item, "item");
        X4.a aVarH = H();
        if (aVarH != null) {
            aVarH.h(item);
        }
    }

    public final void b0(InstallKind kind, InterfaceC5074l<? super TabState, TabState> transform) {
        InstalledSkillUiState value;
        InstalledSkillUiState installedSkillUiState;
        k<InstalledSkillUiState> kVar = this._uiState;
        do {
            value = kVar.getValue();
            installedSkillUiState = value;
        } while (!kVar.d(value, kind == InstallKind.SKILL ? InstalledSkillUiState.b(installedSkillUiState, transform.invoke(installedSkillUiState.getSkillTab()), null, null, null, false, false, false, null, null, false, 1022, null) : InstalledSkillUiState.b(installedSkillUiState, null, transform.invoke(installedSkillUiState.getCliTab()), null, null, false, false, false, null, null, false, 1021, null)));
    }

    @Override // android.view.Q
    public void d() {
        X4.a aVarH;
        super.d();
        String str = this.subscriberId;
        if (str == null || (aVarH = H()) == null) {
            return;
        }
        aVarH.a(str);
    }

    public final void y(Map<String, SkillItem> table) {
        InstalledSkillUiState value;
        InstalledSkillUiState installedSkillUiStateB;
        LinkedHashMap linkedHashMap = new LinkedHashMap(Z8.Q.e(table.size()));
        Iterator<T> it = table.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), ((SkillItem) entry.getValue()).getStatus());
        }
        C4148a.d("InstalledSkillVM", "[overlay] table=" + linkedHashMap, false, 4, null);
        k<InstalledSkillUiState> kVar = this._uiState;
        do {
            value = kVar.getValue();
            installedSkillUiStateB = value;
            List<SkillItem> listE = installedSkillUiStateB.getSkillTab().e();
            ArrayList arrayList = new ArrayList(C1174w.x(listE, 10));
            for (SkillItem skillItem : listE) {
                arrayList.add(Y8.j.a(skillItem.getIdentifier(), skillItem.getStatus()));
            }
            C4148a.d("InstalledSkillVM", "[overlay] tab.items=" + arrayList, false, 4, null);
            TabState tabStateM = M(installedSkillUiStateB.getSkillTab(), table);
            TabState tabStateM2 = M(installedSkillUiStateB.getCliTab(), table);
            if (tabStateM != installedSkillUiStateB.getSkillTab() || tabStateM2 != installedSkillUiStateB.getCliTab()) {
                installedSkillUiStateB = InstalledSkillUiState.b(installedSkillUiStateB, tabStateM, tabStateM2, null, null, false, false, false, null, null, false, 1020, null);
            }
        } while (!kVar.d(value, installedSkillUiStateB));
        N();
    }
}
