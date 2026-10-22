package com.stepos.ailauncher.agent.skill.repository;

import Y8.t;
import b5.PagedSkillResponse;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import e9.InterfaceC4014c;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J:\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002H¦@¢\u0006\u0004\b\b\u0010\tJ*\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H¦@¢\u0006\u0004\b\f\u0010\rJ(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H¦@¢\u0006\u0004\b\u0014\u0010\u0015J*\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\u00182\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0016H¦@¢\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00122\u0006\u0010\u000f\u001a\u00020\u000eH¦@¢\u0006\u0004\b\u001c\u0010\u001dJ\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u000f\u001a\u00020\u000eH¦@¢\u0006\u0004\b\u001e\u0010\u001dJ\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u000f\u001a\u00020\u000eH¦@¢\u0006\u0004\b\u001f\u0010\u001dJ\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u000f\u001a\u00020\u000eH¦@¢\u0006\u0004\b \u0010\u001d¨\u0006!À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/repository/e;", "", "", "page", "pageSize", "necessary", "testing", "Lb5/d;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(IILjava/lang/Integer;Ljava/lang/Integer;Le9/c;)Ljava/lang/Object;", "", "query", "c", "(Ljava/lang/String;IILe9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "skillItem", "", "forceFromCaller", "Lkotlin/Result;", "Lcom/stepos/ailauncher/agent/skill/installer/b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ailauncher/agent/skill/SkillItem;ZLe9/c;)Ljava/lang/Object;", "", DidiCardProvider.KEY_ITEMS, "", "e", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "LY8/t;", "f", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface e {
    Object a(SkillItem skillItem, InterfaceC4014c<? super Result<? extends com.stepos.ailauncher.agent.skill.installer.b>> interfaceC4014c);

    Object b(SkillItem skillItem, InterfaceC4014c<? super Result<? extends com.stepos.ailauncher.agent.skill.installer.b>> interfaceC4014c);

    Object c(String str, int i10, int i11, InterfaceC4014c<? super PagedSkillResponse> interfaceC4014c);

    Object d(SkillItem skillItem, InterfaceC4014c<? super Result<? extends com.stepos.ailauncher.agent.skill.installer.b>> interfaceC4014c);

    Object e(List<SkillItem> list, InterfaceC4014c<? super Map<String, SkillItem>> interfaceC4014c);

    Object f(SkillItem skillItem, InterfaceC4014c<? super Result<t>> interfaceC4014c);

    Object g(int i10, int i11, Integer num, Integer num2, InterfaceC4014c<? super PagedSkillResponse> interfaceC4014c);

    Object h(SkillItem skillItem, boolean z10, InterfaceC4014c<? super Result<? extends com.stepos.ailauncher.agent.skill.installer.b>> interfaceC4014c);
}
