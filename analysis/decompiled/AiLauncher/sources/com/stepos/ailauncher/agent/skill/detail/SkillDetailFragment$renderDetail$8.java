package com.stepos.ailauncher.agent.skill.detail;

import Y4.C1125i;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.agent.R$string;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$renderDetail$8", f = "SkillDetailFragment.kt", l = {604}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SkillDetailFragment$renderDetail$8 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $md;
    int label;
    final /* synthetic */ SkillDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkillDetailFragment$renderDetail$8(SkillDetailFragment skillDetailFragment, String str, InterfaceC4014c<? super SkillDetailFragment$renderDetail$8> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = skillDetailFragment;
        this.$md = str;
    }

    public static final Y8.t i(final SkillDetailFragment skillDetailFragment, final String str, boolean z10) {
        C1125i c1125i = skillDetailFragment.binding;
        C1125i c1125i2 = null;
        if (c1125i == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i = null;
        }
        LinearLayout cardReadme = c1125i.cardReadme;
        kotlin.jvm.internal.p.h(cardReadme, "cardReadme");
        C1125i c1125i3 = skillDetailFragment.binding;
        if (c1125i3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1125i3 = null;
        }
        TextView btnReadmeViewFull = c1125i3.btnReadmeViewFull;
        kotlin.jvm.internal.p.h(btnReadmeViewFull, "btnReadmeViewFull");
        SkillMarkwonFactoryKt.e(cardReadme, btnReadmeViewFull, z10);
        if (z10) {
            C1125i c1125i4 = skillDetailFragment.binding;
            if (c1125i4 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c1125i2 = c1125i4;
            }
            c1125i2.btnReadmeViewFull.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.detail.h0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SkillDetailFragment$renderDetail$8.n(skillDetailFragment, str, view);
                }
            });
        }
        return Y8.t.f7040a;
    }

    public static final void n(SkillDetailFragment skillDetailFragment, String str, View view) {
        com.stepos.ailauncher.sheet.nav.a.z(skillDetailFragment, y0.INSTANCE.a(str, skillDetailFragment.getString(R$string.skill_detail_section_readme)), "skill_readme", null, null, null, 28, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SkillDetailFragment$renderDetail$8(this.this$0, this.$md, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SkillDetailFragment$renderDetail$8) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            C1125i c1125i = this.this$0.binding;
            if (c1125i == null) {
                kotlin.jvm.internal.p.A("binding");
                c1125i = null;
            }
            TextView tvReadme = c1125i.tvReadme;
            kotlin.jvm.internal.p.h(tvReadme, "tvReadme");
            u8.e eVarC0 = this.this$0.C0();
            final String str = this.$md;
            final SkillDetailFragment skillDetailFragment = this.this$0;
            InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.detail.i0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return SkillDetailFragment$renderDetail$8.i(skillDetailFragment, str, ((Boolean) obj2).booleanValue());
                }
            };
            this.label = 1;
            if (SkillMarkwonFactoryKt.c(tvReadme, eVarC0, str, 200, interfaceC5074l, this) == objG) {
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
