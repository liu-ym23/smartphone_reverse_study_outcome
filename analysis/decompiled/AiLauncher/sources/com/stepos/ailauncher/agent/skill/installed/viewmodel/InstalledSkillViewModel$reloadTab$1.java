package com.stepos.ailauncher.agent.skill.installed.viewmodel;

import Ua.M;
import Y8.t;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.skill.InstallKind;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel$reloadTab$1", f = "InstalledSkillViewModel.kt", l = {445}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class InstalledSkillViewModel$reloadTab$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ int $generation;
    final /* synthetic */ InstallKind $kind;
    long J$0;
    Object L$0;
    int label;
    final /* synthetic */ InstalledSkillViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstalledSkillViewModel$reloadTab$1(InstalledSkillViewModel installedSkillViewModel, InstallKind installKind, int i10, InterfaceC4014c<? super InstalledSkillViewModel$reloadTab$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = installedSkillViewModel;
        this.$kind = installKind;
        this.$generation = i10;
    }

    public static final InstalledSkillViewModel.TabState i(InstalledSkillViewModel.TabState tabState) {
        return InstalledSkillViewModel.TabState.b(tabState, C1173v.m(), 0, true, false, true, false, 0, false, 192, null);
    }

    public static final InstalledSkillViewModel.TabState n(InstalledSkillViewModel.PageResult pageResult, Pair pair, InstalledSkillViewModel installedSkillViewModel, InstalledSkillViewModel.TabState tabState) {
        if (pageResult == null) {
            return InstalledSkillViewModel.TabState.b(tabState, null, 0, true, true, false, false, 0, true, 99, null);
        }
        kotlin.jvm.internal.p.f(pair);
        List list = (List) pair.a();
        int iIntValue = ((Number) pair.b()).intValue();
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (hashSet.add(((SkillItem) obj).getIdentifier())) {
                arrayList.add(obj);
            }
        }
        return InstalledSkillViewModel.TabState.b(tabState, arrayList, 1, pageResult.getHasMore(), false, false, false, (((InstalledSkillViewModel.InstalledSkillUiState) installedSkillViewModel._uiState.getValue()).k().isEmpty() || !tabState.getHasLoadedOnce()) ? C5685n.f(pageResult.getTotal() - iIntValue, 0) : tabState.getTotalCount(), true, 32, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new InstalledSkillViewModel$reloadTab$1(this.this$0, this.$kind, this.$generation, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((InstalledSkillViewModel$reloadTab$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        InstalledSkillViewModel$reloadTab$1 installedSkillViewModel$reloadTab$1;
        String str;
        long j10;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            String searchQuery = ((InstalledSkillViewModel.InstalledSkillUiState) this.this$0._uiState.getValue()).getSearchQuery();
            this.this$0.b0(this.$kind, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.installed.viewmodel.h
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return InstalledSkillViewModel$reloadTab$1.i((InstalledSkillViewModel.TabState) obj2);
                }
            });
            long jCurrentTimeMillis = System.currentTimeMillis();
            InstalledSkillViewModel installedSkillViewModel = this.this$0;
            InstallKind installKind = this.$kind;
            this.L$0 = searchQuery;
            this.J$0 = jCurrentTimeMillis;
            this.label = 1;
            installedSkillViewModel$reloadTab$1 = this;
            obj = installedSkillViewModel.B(installKind, searchQuery, 1, 20, installedSkillViewModel$reloadTab$1);
            if (obj == objG) {
                return objG;
            }
            str = searchQuery;
            j10 = jCurrentTimeMillis;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j10 = this.J$0;
            str = (String) this.L$0;
            C4849c.b(obj);
            installedSkillViewModel$reloadTab$1 = this;
        }
        final InstalledSkillViewModel.PageResult pageResult = (InstalledSkillViewModel.PageResult) obj;
        int i11 = installedSkillViewModel$reloadTab$1.$generation;
        Integer num = (Integer) installedSkillViewModel$reloadTab$1.this$0.generations.get(installedSkillViewModel$reloadTab$1.$kind);
        if (num == null || i11 != num.intValue()) {
            return t.f7040a;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - j10;
        final Pair pairD = pageResult != null ? installedSkillViewModel$reloadTab$1.this$0.D(pageResult.b()) : null;
        InstallKind installKind2 = installedSkillViewModel$reloadTab$1.$kind;
        Integer numF = pageResult != null ? C4109a.f(pageResult.getTotal()) : null;
        C4148a.s("InstalledSkillVM", "reloadTab " + installKind2 + " query='" + str + "' resp.total=" + numF + " elapsed=" + jCurrentTimeMillis2 + "ms total_since_last_input=" + (System.currentTimeMillis() - installedSkillViewModel$reloadTab$1.this$0.lastSearchInputTs) + Const.SP_KEY_GSM_UPLOAD_MXSIZE, true);
        final InstalledSkillViewModel installedSkillViewModel2 = installedSkillViewModel$reloadTab$1.this$0;
        installedSkillViewModel2.b0(installedSkillViewModel$reloadTab$1.$kind, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.installed.viewmodel.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return InstalledSkillViewModel$reloadTab$1.n(pageResult, pairD, installedSkillViewModel2, (InstalledSkillViewModel.TabState) obj2);
            }
        });
        installedSkillViewModel$reloadTab$1.this$0.N();
        return t.f7040a;
    }
}
