package com.stepos.ailauncher.agent.skill.essential;

import La.H;
import Ua.C1060i;
import Ua.M;
import X4.OperaError;
import Xa.t;
import Xa.u;
import Z8.C1174w;
import Z8.Y;
import android.view.Q;
import android.view.S;
import androidx.exifinterface.media.ExifInterface;
import b5.PagedSkillResponse;
import c5.x;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.contract.OperaErrorKind;
import com.stepos.ailauncher.agent.skill.InstallKind;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.AbstractC3297l;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import io.ktor.http.ContentDisposition;
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
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.p;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 e2\u00020\u0001:\u0001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0082@¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010 \u001a\u00020\u00062\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00040\u001eH\u0002¢\u0006\u0004\b \u0010!J\u001d\u0010$\u001a\u00020\u00062\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00180\"H\u0002¢\u0006\u0004\b$\u0010%J\u001d\u0010'\u001a\u00020\u00062\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00180\"H\u0002¢\u0006\u0004\b'\u0010%J\u001f\u0010*\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004H\u0002¢\u0006\u0004\b*\u0010+J\u0013\u0010-\u001a\u00020\u0018*\u00020,H\u0002¢\u0006\u0004\b-\u0010.J'\u00102\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u00020\u000b¢\u0006\u0004\b2\u00103J\r\u00104\u001a\u00020\u0006¢\u0006\u0004\b4\u0010\u0003J\r\u00105\u001a\u00020\u0006¢\u0006\u0004\b5\u0010\u0003J\u0015\u00107\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0004¢\u0006\u0004\b7\u0010\bJ\u0015\u00108\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0004¢\u0006\u0004\b8\u0010\bJ\u001d\u00109\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b9\u0010\u000eJ\u0015\u0010:\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0004¢\u0006\u0004\b:\u0010\bJ\r\u0010;\u001a\u00020\u0006¢\u0006\u0004\b;\u0010\u0003J\u0015\u0010=\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u0018¢\u0006\u0004\b=\u0010>J\u0015\u0010?\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u0018¢\u0006\u0004\b?\u0010>J\r\u0010@\u001a\u00020\u0006¢\u0006\u0004\b@\u0010\u0003R\u001b\u0010F\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001b\u0010K\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010C\u001a\u0004\bI\u0010JR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020M0L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u001d\u0010Q\u001a\b\u0012\u0004\u0012\u00020M0P8\u0006¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u0018\u0010V\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010WR\u0018\u0010Y\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010WR\u0018\u0010Z\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010WR\u0018\u0010[\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010WR\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00180L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010OR\u0016\u0010]\u001a\u0004\u0018\u00010\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010_\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u00104R\u0016\u00100\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010`R\u0016\u00101\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010`R\u0016\u0010d\u001a\u0004\u0018\u00010a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bb\u0010c¨\u0006g"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/essential/SkillEssentialViewModel;", "Landroidx/lifecycle/Q;", "<init>", "()V", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "item", "LY8/t;", "y", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;)V", "z", "x", "", "enable", "B", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Z)V", "isRefresh", "J", "(Z)V", "", "page", ContentDisposition.Parameters.Size, "Lb5/d;", "L", "(IILe9/c;)Ljava/lang/Object;", "", "itemId", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "newStatus", ExifInterface.LONGITUDE_WEST, "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/skill/SkillStatus;)V", "", "table", "u", "(Ljava/util/Map;)V", "", "togglingIds", "v", "(Ljava/util/Set;)V", "uninstallingIds", "w", "existing", "incoming", "M", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Lcom/stepos/ailauncher/agent/skill/SkillItem;)Lcom/stepos/ailauncher/agent/skill/SkillItem;", "LX4/b;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(LX4/b;)Ljava/lang/String;", "necessary", "showCli", "testing", "C", "(IZZ)V", "I", "N", "skillItem", "Q", "P", ExifInterface.LATITUDE_SOUTH, "R", "D", "subscriberId", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;)V", "U", "K", "Lcom/stepos/ailauncher/agent/skill/repository/e;", "repository$delegate", "LY8/h;", "G", "()Lcom/stepos/ailauncher/agent/skill/repository/e;", "repository", "Lcom/stepos/ailauncher/agent/skill/cli/d;", "cliRepository$delegate", ExifInterface.LONGITUDE_EAST, "()Lcom/stepos/ailauncher/agent/skill/cli/d;", "cliRepository", "LXa/k;", "Lcom/stepos/ailauncher/agent/skill/essential/k;", "_uiState", "LXa/k;", "LXa/t;", "uiState", "LXa/t;", "H", "()LXa/t;", "Lkotlinx/coroutines/g;", "loadJob", "Lkotlinx/coroutines/g;", "pollSubscriptionJob", "togglingSubscriptionJob", "uninstallingSubscriptionJob", "errorEventsJob", "searchQueryFlow", "fixedGroupId", "Ljava/lang/String;", "necessaryParam", "Z", "LX4/a;", "F", "()LX4/a;", "operaService", "Companion", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SkillEssentialViewModel extends Q {
    private static final int DEFAULT_PAGE_SIZE = 20;
    private final Xa.k<SkillEssentialUiState> _uiState;
    private kotlinx.coroutines.g errorEventsJob;
    private final String fixedGroupId;
    private kotlinx.coroutines.g loadJob;
    private int necessaryParam;
    private kotlinx.coroutines.g pollSubscriptionJob;
    private final Xa.k<String> searchQueryFlow;
    private boolean showCli;
    private boolean testing;
    private kotlinx.coroutines.g togglingSubscriptionJob;
    private final t<SkillEssentialUiState> uiState;
    private kotlinx.coroutines.g uninstallingSubscriptionJob;
    private static final Set<SkillStatus> AUTHORITATIVE_TERMINAL_STATUSES = Y.j(SkillStatus.INSTALLED_ENABLED, SkillStatus.INSTALLED_DISABLED, SkillStatus.INSTALLED);

    /* renamed from: repository$delegate, reason: from kotlin metadata */
    private final Y8.h repository = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.skill.essential.l
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return SkillEssentialViewModel.O();
        }
    });

    /* renamed from: cliRepository$delegate, reason: from kotlin metadata */
    private final Y8.h cliRepository = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.skill.essential.m
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return SkillEssentialViewModel.A();
        }
    });

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.essential.SkillEssentialViewModel$1", f = "SkillEssentialViewModel.kt", l = {113}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.skill.essential.SkillEssentialViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.agent.skill.essential.SkillEssentialViewModel$1$a */
        public static final class a<T> implements Xa.c {
            final /* synthetic */ SkillEssentialViewModel this$0;

            public a(SkillEssentialViewModel skillEssentialViewModel) {
                this.this$0 = skillEssentialViewModel;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // Xa.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(String str, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                Object value;
                boolean z10 = !H.x0(str);
                Xa.k kVar = this.this$0._uiState;
                do {
                    value = kVar.getValue();
                } while (!kVar.d(value, SkillEssentialUiState.b((SkillEssentialUiState) value, false, false, false, null, str, z10, null, 0, false, 0, 0, null, 4047, null)));
                this.this$0.J(true);
                return Y8.t.f7040a;
            }
        }

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return SkillEssentialViewModel.this.new AnonymousClass1(interfaceC4014c);
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
                Xa.b bVarP = Xa.d.p(SkillEssentialViewModel.this.searchQueryFlow, 300L);
                a aVar = new a(SkillEssentialViewModel.this);
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

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OperaErrorKind.values().length];
            try {
                iArr[OperaErrorKind.INSTALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OperaErrorKind.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OperaErrorKind.ENABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OperaErrorKind.DISABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[OperaErrorKind.UNINSTALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[OperaErrorKind.UPDATE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SkillEssentialViewModel() {
        Xa.k<SkillEssentialUiState> kVarA = u.a(new SkillEssentialUiState(false, false, false, null, null, false, null, 0, false, 0, 0, null, 4095, null));
        this._uiState = kVarA;
        this.uiState = Xa.d.c(kVarA);
        this.searchQueryFlow = u.a("");
        this.fixedGroupId = "0";
        this.necessaryParam = 1;
        this.showCli = true;
        C1060i.d(S.a(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public static final com.stepos.ailauncher.agent.skill.cli.d A() {
        return com.stepos.ailauncher.agent.skill.cli.f.INSTANCE.c();
    }

    public static final com.stepos.ailauncher.agent.skill.repository.e O() {
        return com.stepos.ailauncher.agent.skill.repository.g.INSTANCE.d();
    }

    public final void B(SkillItem item, boolean enable) {
        C4148a.d("SkillEssentialVM", "CLI toggle slug=" + item.getSlug() + " enable=" + enable, false, 4, null);
        W(item.getIdentifier(), enable ? SkillStatus.INSTALLED_ENABLED : SkillStatus.INSTALLED_DISABLED);
    }

    public final void C(int necessary, boolean showCli, boolean testing) {
        this.necessaryParam = necessary;
        this.showCli = showCli;
        this.testing = testing;
    }

    public final void D() {
        SkillEssentialUiState value;
        Xa.k<SkillEssentialUiState> kVar = this._uiState;
        do {
            value = kVar.getValue();
        } while (!kVar.d(value, SkillEssentialUiState.b(value, false, false, false, null, null, false, null, 0, false, 0, 0, null, 2047, null)));
    }

    public final com.stepos.ailauncher.agent.skill.cli.d E() {
        return (com.stepos.ailauncher.agent.skill.cli.d) this.cliRepository.getValue();
    }

    public final X4.a F() {
        return (X4.a) D5.a.INSTANCE.a(X4.a.class);
    }

    public final com.stepos.ailauncher.agent.skill.repository.e G() {
        return (com.stepos.ailauncher.agent.skill.repository.e) this.repository.getValue();
    }

    public final t<SkillEssentialUiState> H() {
        return this.uiState;
    }

    public final void I() {
        J(false);
    }

    public final void J(boolean isRefresh) {
        kotlinx.coroutines.g gVar = this.loadJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.loadJob = C1060i.d(S.a(this), null, null, new SkillEssentialViewModel$loadFirstPage$1(this, isRefresh, null), 3, null);
    }

    public final void K() {
        SkillEssentialUiState value = this._uiState.getValue();
        if (value.getIsLoadingMore() || !value.getHasMore()) {
            return;
        }
        C1060i.d(S.a(this), null, null, new SkillEssentialViewModel$loadMore$1(this, value, null), 3, null);
    }

    public final Object L(int i10, int i11, InterfaceC4014c<? super PagedSkillResponse> interfaceC4014c) {
        return this.testing ? G().g(i10, i11, null, C4109a.f(1), interfaceC4014c) : G().g(i10, i11, C4109a.f(this.necessaryParam), null, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.agent.skill.SkillItem M(com.stepos.ailauncher.agent.skill.SkillItem r47, com.stepos.ailauncher.agent.skill.SkillItem r48) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.essential.SkillEssentialViewModel.M(com.stepos.ailauncher.agent.skill.SkillItem, com.stepos.ailauncher.agent.skill.SkillItem):com.stepos.ailauncher.agent.skill.SkillItem");
    }

    public final void N() {
        J(true);
    }

    public final void P(SkillItem skillItem) {
        kotlin.jvm.internal.p.i(skillItem, "skillItem");
        if (skillItem.getInstallKind() == InstallKind.CLI) {
            x(skillItem);
            return;
        }
        X4.a aVarF = F();
        if (aVarF != null) {
            aVarF.f(skillItem);
        }
    }

    public final void Q(SkillItem skillItem) {
        kotlin.jvm.internal.p.i(skillItem, "skillItem");
        if (skillItem.getInstallKind() == InstallKind.CLI) {
            y(skillItem);
            return;
        }
        X4.a aVarF = F();
        if (aVarF != null) {
            aVarF.n(skillItem);
        }
    }

    public final void R(SkillItem skillItem) {
        kotlin.jvm.internal.p.i(skillItem, "skillItem");
        if (skillItem.getInstallKind() == InstallKind.CLI) {
            z(skillItem);
        } else {
            Q(skillItem);
        }
    }

    public final void S(SkillItem skillItem, boolean enable) {
        kotlin.jvm.internal.p.i(skillItem, "skillItem");
        if (skillItem.getInstallKind() == InstallKind.CLI) {
            B(skillItem, enable);
            return;
        }
        X4.a aVarF = F();
        if (aVarF == null) {
            return;
        }
        if (!aVarF.l().getValue().contains(skillItem.getIdentifier())) {
            if (enable) {
                aVarF.c(skillItem);
                return;
            } else {
                aVarF.b(skillItem);
                return;
            }
        }
        C4148a.d("SkillEssentialVM", "requestToggle ignored: id=" + skillItem.getIdentifier() + " already toggling", false, 4, null);
    }

    public final void T(String subscriberId) {
        kotlin.jvm.internal.p.i(subscriberId, "subscriberId");
        X4.a aVarF = F();
        if (aVarF == null) {
            C4148a.u("SkillEssentialVM", "startPollingSubscription: ISkillOperaService not registered", false, 4, null);
            return;
        }
        kotlinx.coroutines.g gVar = this.pollSubscriptionJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.pollSubscriptionJob = C1060i.d(S.a(this), null, null, new SkillEssentialViewModel$startPollingSubscription$1(aVarF, this, null), 3, null);
        kotlinx.coroutines.g gVar2 = this.togglingSubscriptionJob;
        if (gVar2 != null) {
            kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
        }
        this.togglingSubscriptionJob = C1060i.d(S.a(this), null, null, new SkillEssentialViewModel$startPollingSubscription$2(aVarF, this, null), 3, null);
        kotlinx.coroutines.g gVar3 = this.uninstallingSubscriptionJob;
        if (gVar3 != null) {
            kotlinx.coroutines.g.Y0(gVar3, null, 1, null);
        }
        this.uninstallingSubscriptionJob = C1060i.d(S.a(this), null, null, new SkillEssentialViewModel$startPollingSubscription$3(aVarF, this, null), 3, null);
        kotlinx.coroutines.g gVar4 = this.errorEventsJob;
        if (gVar4 != null) {
            kotlinx.coroutines.g.Y0(gVar4, null, 1, null);
        }
        this.errorEventsJob = C1060i.d(S.a(this), null, null, new SkillEssentialViewModel$startPollingSubscription$4(aVarF, this, null), 3, null);
        aVarF.e(subscriberId);
    }

    public final void U(String subscriberId) {
        kotlin.jvm.internal.p.i(subscriberId, "subscriberId");
        kotlinx.coroutines.g gVar = this.pollSubscriptionJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.pollSubscriptionJob = null;
        kotlinx.coroutines.g gVar2 = this.togglingSubscriptionJob;
        if (gVar2 != null) {
            kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
        }
        this.togglingSubscriptionJob = null;
        kotlinx.coroutines.g gVar3 = this.uninstallingSubscriptionJob;
        if (gVar3 != null) {
            kotlinx.coroutines.g.Y0(gVar3, null, 1, null);
        }
        this.uninstallingSubscriptionJob = null;
        kotlinx.coroutines.g gVar4 = this.errorEventsJob;
        if (gVar4 != null) {
            kotlinx.coroutines.g.Y0(gVar4, null, 1, null);
        }
        this.errorEventsJob = null;
        X4.a aVarF = F();
        if (aVarF != null) {
            aVarF.a(subscriberId);
        }
    }

    public final String V(OperaError operaError) {
        String str;
        switch (b.$EnumSwitchMapping$0[operaError.getKind().ordinal()]) {
            case 1:
                str = "安装";
                break;
            case 2:
                str = AbstractC3297l.LABEL_DIALOG_CANCEL;
                break;
            case 3:
                str = "启用";
                break;
            case 4:
                str = "禁用";
                break;
            case 5:
                str = "卸载";
                break;
            case 6:
                str = "更新";
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return operaError.getDisplayName() + str + "失败";
    }

    public final void W(String itemId, SkillStatus newStatus) {
        SkillEssentialUiState value;
        SkillEssentialUiState skillEssentialUiState;
        ArrayList arrayList;
        Xa.k<SkillEssentialUiState> kVar = this._uiState;
        do {
            value = kVar.getValue();
            skillEssentialUiState = value;
            List<x> listC = skillEssentialUiState.c();
            arrayList = new ArrayList(C1174w.x(listC, 10));
            for (Object objB : listC) {
                if (objB instanceof x.CliCard) {
                    x.CliCard cliCard = (x.CliCard) objB;
                    if (kotlin.jvm.internal.p.d(cliCard.getItem().getIdentifier(), itemId)) {
                        objB = x.CliCard.b(cliCard, SkillItem.copy$default(cliCard.getItem(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, 0, null, null, 0, null, null, null, null, null, null, null, newStatus, null, null, null, null, Integer.MAX_VALUE, 15, null), false, false, null, 14, null);
                    }
                }
                arrayList.add(objB);
            }
        } while (!kVar.d(value, SkillEssentialUiState.b(skillEssentialUiState, false, false, false, null, null, false, arrayList, 0, false, 0, 0, null, 4031, null)));
    }

    public final void u(Map<String, SkillItem> table) {
        SkillEssentialUiState value;
        SkillEssentialUiState skillEssentialUiState;
        ArrayList arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(Z8.Q.e(table.size()));
        Iterator<T> it = table.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), ((SkillItem) entry.getValue()).getStatus());
        }
        C4148a.d("SkillEssentialVM", "[overlay] table=" + linkedHashMap, false, 4, null);
        Xa.k<SkillEssentialUiState> kVar = this._uiState;
        do {
            value = kVar.getValue();
            skillEssentialUiState = value;
            List<x> listC = skillEssentialUiState.c();
            arrayList = new ArrayList(C1174w.x(listC, 10));
            for (Object objB : listC) {
                if (objB instanceof x.SkillCard) {
                    x.SkillCard skillCard = (x.SkillCard) objB;
                    SkillItem skillItem = table.get(skillCard.getItem().getIdentifier());
                    if (skillItem != null) {
                        objB = x.SkillCard.b(skillCard, M(skillCard.getItem(), skillItem), false, false, null, 14, null);
                    }
                } else if (objB instanceof x.CliCard) {
                    x.CliCard cliCard = (x.CliCard) objB;
                    SkillItem skillItem2 = table.get(cliCard.getItem().getIdentifier());
                    if (skillItem2 != null) {
                        objB = x.CliCard.b(cliCard, M(cliCard.getItem(), skillItem2), false, false, null, 14, null);
                    }
                }
                arrayList.add(objB);
            }
        } while (!kVar.d(value, SkillEssentialUiState.b(skillEssentialUiState, false, false, false, null, null, false, arrayList, 0, false, 0, 0, null, 4031, null)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void v(Set<String> togglingIds) {
        SkillEssentialUiState value;
        SkillEssentialUiState skillEssentialUiStateB;
        x xVarB;
        x.CliCard cliCard;
        Xa.k<SkillEssentialUiState> kVar = this._uiState;
        do {
            value = kVar.getValue();
            skillEssentialUiStateB = value;
            List<x> listC = skillEssentialUiStateB.c();
            ArrayList arrayList = new ArrayList(C1174w.x(listC, 10));
            boolean z10 = false;
            for (x xVar : listC) {
                if (xVar instanceof x.SkillCard) {
                    x.SkillCard skillCard = (x.SkillCard) xVar;
                    boolean zContains = togglingIds.contains(skillCard.getItem().getIdentifier());
                    boolean isToggling = skillCard.getIsToggling();
                    cliCard = skillCard;
                    if (isToggling != zContains) {
                        xVarB = x.SkillCard.b(skillCard, null, zContains, false, null, 13, null);
                        xVar = xVarB;
                        z10 = true;
                    }
                    xVar = cliCard;
                } else if (xVar instanceof x.CliCard) {
                    x.CliCard cliCard2 = (x.CliCard) xVar;
                    boolean zContains2 = togglingIds.contains(cliCard2.getItem().getIdentifier());
                    boolean isToggling2 = cliCard2.getIsToggling();
                    cliCard = cliCard2;
                    if (isToggling2 != zContains2) {
                        xVarB = x.CliCard.b(cliCard2, null, zContains2, false, null, 13, null);
                        xVar = xVarB;
                        z10 = true;
                    }
                    xVar = cliCard;
                }
                arrayList.add(xVar);
            }
            if (z10) {
                skillEssentialUiStateB = SkillEssentialUiState.b(skillEssentialUiStateB, false, false, false, null, null, false, arrayList, 0, false, 0, 0, null, 4031, null);
            }
        } while (!kVar.d(value, skillEssentialUiStateB));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w(Set<String> uninstallingIds) {
        SkillEssentialUiState value;
        SkillEssentialUiState skillEssentialUiStateB;
        x xVarB;
        x.CliCard cliCard;
        Xa.k<SkillEssentialUiState> kVar = this._uiState;
        do {
            value = kVar.getValue();
            skillEssentialUiStateB = value;
            List<x> listC = skillEssentialUiStateB.c();
            ArrayList arrayList = new ArrayList(C1174w.x(listC, 10));
            boolean z10 = false;
            for (x xVar : listC) {
                if (xVar instanceof x.SkillCard) {
                    x.SkillCard skillCard = (x.SkillCard) xVar;
                    boolean zContains = uninstallingIds.contains(skillCard.getItem().getIdentifier());
                    boolean isUninstalling = skillCard.getIsUninstalling();
                    cliCard = skillCard;
                    if (isUninstalling != zContains) {
                        xVarB = x.SkillCard.b(skillCard, null, false, zContains, null, 11, null);
                        xVar = xVarB;
                        z10 = true;
                    }
                    xVar = cliCard;
                } else if (xVar instanceof x.CliCard) {
                    x.CliCard cliCard2 = (x.CliCard) xVar;
                    boolean zContains2 = uninstallingIds.contains(cliCard2.getItem().getIdentifier());
                    boolean isUninstalling2 = cliCard2.getIsUninstalling();
                    cliCard = cliCard2;
                    if (isUninstalling2 != zContains2) {
                        xVarB = x.CliCard.b(cliCard2, null, false, zContains2, null, 11, null);
                        xVar = xVarB;
                        z10 = true;
                    }
                    xVar = cliCard;
                }
                arrayList.add(xVar);
            }
            if (z10) {
                skillEssentialUiStateB = SkillEssentialUiState.b(skillEssentialUiStateB, false, false, false, null, null, false, arrayList, 0, false, 0, 0, null, 4031, null);
            }
        } while (!kVar.d(value, skillEssentialUiStateB));
    }

    public final void x(SkillItem item) {
        C4148a.d("SkillEssentialVM", "CLI cancelReview slug=" + item.getSlug(), false, 4, null);
    }

    public final void y(SkillItem item) {
        SkillEssentialUiState value;
        C4148a.d("SkillEssentialVM", "CLI connect slug=" + item.getSlug(), false, 4, null);
        Xa.k<SkillEssentialUiState> kVar = this._uiState;
        do {
            value = kVar.getValue();
        } while (!kVar.d(value, SkillEssentialUiState.b(value, false, false, false, null, null, false, null, 0, false, 0, 0, item.getDisplayName() + "\nCLI 连接中…", 2047, null)));
    }

    public final void z(SkillItem item) {
        SkillEssentialUiState value;
        C4148a.d("SkillEssentialVM", "CLI reconnect slug=" + item.getSlug(), false, 4, null);
        Xa.k<SkillEssentialUiState> kVar = this._uiState;
        do {
            value = kVar.getValue();
        } while (!kVar.d(value, SkillEssentialUiState.b(value, false, false, false, null, null, false, null, 0, false, 0, 0, item.getDisplayName() + "\nCLI 重新连接…", 2047, null)));
    }
}
