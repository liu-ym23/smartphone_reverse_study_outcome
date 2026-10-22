package com.stepos.ailauncher.agent.skill.installed.viewmodel;

import Ua.M;
import Y8.t;
import Z8.F;
import com.stepos.ailauncher.agent.skill.InstallKind;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel$loadMore$2", f = "InstalledSkillViewModel.kt", l = {211}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class InstalledSkillViewModel$loadMore$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ InstalledSkillViewModel.TabState $curr;
    final /* synthetic */ int $generation;
    final /* synthetic */ InstallKind $kind;
    final /* synthetic */ InstalledSkillViewModel.InstalledSkillUiState $state;
    int I$0;
    int label;
    final /* synthetic */ InstalledSkillViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstalledSkillViewModel$loadMore$2(InstalledSkillViewModel.TabState tabState, InstalledSkillViewModel installedSkillViewModel, InstallKind installKind, InstalledSkillViewModel.InstalledSkillUiState installedSkillUiState, int i10, InterfaceC4014c<? super InstalledSkillViewModel$loadMore$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$curr = tabState;
        this.this$0 = installedSkillViewModel;
        this.$kind = installKind;
        this.$state = installedSkillUiState;
        this.$generation = i10;
    }

    public static final InstalledSkillViewModel.TabState h(InstalledSkillViewModel.PageResult pageResult, Pair pair, int i10, InstalledSkillViewModel.TabState tabState) {
        if (pageResult == null) {
            return InstalledSkillViewModel.TabState.b(tabState, null, 0, false, true, false, false, 0, false, 215, null);
        }
        List<SkillItem> listE = tabState.e();
        kotlin.jvm.internal.p.f(pair);
        List listS0 = F.S0(listE, (Iterable) pair.e());
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listS0) {
            if (hashSet.add(((SkillItem) obj).getIdentifier())) {
                arrayList.add(obj);
            }
        }
        return InstalledSkillViewModel.TabState.b(tabState, arrayList, i10, pageResult.getHasMore(), false, false, false, pageResult.getTotal(), true, 16, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new InstalledSkillViewModel$loadMore$2(this.$curr, this.this$0, this.$kind, this.$state, this.$generation, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((InstalledSkillViewModel$loadMore$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        InstalledSkillViewModel$loadMore$2 installedSkillViewModel$loadMore$2;
        final int i10;
        Object objG = C4063a.g();
        int i11 = this.label;
        if (i11 == 0) {
            C4849c.b(obj);
            int page = this.$curr.getPage() + 1;
            InstalledSkillViewModel installedSkillViewModel = this.this$0;
            InstallKind installKind = this.$kind;
            String searchQuery = this.$state.getSearchQuery();
            this.I$0 = page;
            this.label = 1;
            installedSkillViewModel$loadMore$2 = this;
            obj = installedSkillViewModel.B(installKind, searchQuery, page, 20, installedSkillViewModel$loadMore$2);
            if (obj == objG) {
                return objG;
            }
            i10 = page;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i10 = this.I$0;
            C4849c.b(obj);
            installedSkillViewModel$loadMore$2 = this;
        }
        final InstalledSkillViewModel.PageResult pageResult = (InstalledSkillViewModel.PageResult) obj;
        int i12 = installedSkillViewModel$loadMore$2.$generation;
        Integer num = (Integer) installedSkillViewModel$loadMore$2.this$0.generations.get(installedSkillViewModel$loadMore$2.$kind);
        if (num == null || i12 != num.intValue()) {
            return t.f7040a;
        }
        final Pair pairD = pageResult != null ? installedSkillViewModel$loadMore$2.this$0.D(pageResult.b()) : null;
        installedSkillViewModel$loadMore$2.this$0.b0(installedSkillViewModel$loadMore$2.$kind, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.installed.viewmodel.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return InstalledSkillViewModel$loadMore$2.h(pageResult, pairD, i10, (InstalledSkillViewModel.TabState) obj2);
            }
        });
        installedSkillViewModel$loadMore$2.this$0.N();
        return t.f7040a;
    }
}
