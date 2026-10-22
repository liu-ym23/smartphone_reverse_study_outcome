package com.stepos.ailauncher.agent.aispace.skill.feishu;

import android.content.Context;
import com.stepos.ailauncher.agent.R$string;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/f;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/l;", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "LY8/t;", "onTryNow", "<init>", "(Landroid/content/Context;Lp9/a;)V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class DialogC2310f extends DialogC2316l {
    /* JADX WARN: Illegal instructions before constructor call */
    public DialogC2310f(Context context, InterfaceC5063a<Y8.t> onTryNow) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(onTryNow, "onTryNow");
        String string = context.getString(R$string.feishu_cli_auto_summary_title);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        String string2 = context.getString(R$string.feishu_cli_auto_summary_desc);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        String string3 = context.getString(R$string.feishu_cli_auto_summary_later);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        String string4 = context.getString(R$string.feishu_cli_auto_summary_try_now);
        kotlin.jvm.internal.p.h(string4, "getString(...)");
        super(context, string, string2, string3, string4, onTryNow);
    }
}
