package com.stepos.ailauncher.agent.skill.installer;

import Ua.M;
import Y8.t;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.skill.SkillItem;
import e9.InterfaceC4014c;
import f9.C4063a;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\r\u0010\fJ\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u000e\u0010\fJ\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u000f\u0010\fJ\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u0010\u0010\fJ \u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installer/c;", "Lcom/stepos/ailauncher/agent/skill/installer/d;", "Landroid/content/Context;", "context", "LUa/M;", "scope", "<init>", "(Landroid/content/Context;LUa/M;)V", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "item", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "c", "e", "", x5.d.EXTRA_ENABLED, "f", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;ZLe9/c;)Ljava/lang/Object;", "Companion", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c implements d {
    private static final String TAG = "LocalSkillClient";

    public c(Context context, M scope) {
        p.i(context, "context");
        p.i(scope, "scope");
    }

    @Override // com.stepos.ailauncher.agent.skill.installer.d
    public Object a(SkillItem skillItem, InterfaceC4014c<? super t> interfaceC4014c) {
        return t.f7040a;
    }

    @Override // com.stepos.ailauncher.agent.skill.installer.d
    public Object b(SkillItem skillItem, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objF = f(skillItem, true, interfaceC4014c);
        return objF == C4063a.g() ? objF : t.f7040a;
    }

    @Override // com.stepos.ailauncher.agent.skill.installer.d
    public Object c(SkillItem skillItem, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objF = f(skillItem, false, interfaceC4014c);
        return objF == C4063a.g() ? objF : t.f7040a;
    }

    @Override // com.stepos.ailauncher.agent.skill.installer.d
    public Object d(SkillItem skillItem, InterfaceC4014c<? super t> interfaceC4014c) {
        C4148a.d(TAG, "cancel no-op for slug=" + skillItem.getSlug(), false, 4, null);
        return t.f7040a;
    }

    @Override // com.stepos.ailauncher.agent.skill.installer.d
    public Object e(SkillItem skillItem, InterfaceC4014c<? super t> interfaceC4014c) {
        return t.f7040a;
    }

    public final Object f(SkillItem skillItem, boolean z10, InterfaceC4014c<? super t> interfaceC4014c) {
        return t.f7040a;
    }
}
