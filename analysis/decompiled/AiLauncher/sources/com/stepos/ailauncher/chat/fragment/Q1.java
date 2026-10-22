package com.stepos.ailauncher.chat.fragment;

import Z8.C1173v;
import Z8.C1174w;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.feishu.IFeishuConnectService;
import com.stepos.ailauncher.contract.api.skill.ISkillUiService;
import com.stepos.ailauncher.contract.api.wecom.IWecomConnectService;
import com.stepos.ailauncher.contract.model.SkillItemBrief;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001b\u0010\u0006\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001b\u0010\t\u001a\u00020\b*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0013\u0010\u000b\u001a\u00020\u0005*\u00020\u0001H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a)\u0010\u0010\u001a\u0004\u0018\u00010\u000f*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001b\u0010\u0014\u001a\u00020\u0013*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/contract/model/SkillItemBrief;", "Lcom/stepos/ailauncher/chat/fragment/CliKind;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/contract/model/SkillItemBrief;)Lcom/stepos/ailauncher/chat/fragment/CliKind;", "item", "", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/chat/fragment/CliKind;Lcom/stepos/ailauncher/contract/model/SkillItemBrief;)Z", "Lcom/stepos/ailauncher/contract/api/skill/ISkillUiService$SkillUiStatus;", "e", "(Lcom/stepos/ailauncher/chat/fragment/CliKind;Lcom/stepos/ailauncher/contract/model/SkillItemBrief;)Lcom/stepos/ailauncher/contract/api/skill/ISkillUiService$SkillUiStatus;", "f", "(Lcom/stepos/ailauncher/chat/fragment/CliKind;)Z", "Landroid/content/Context;", "hostContext", "Landroidx/fragment/app/Fragment;", "c", "(Lcom/stepos/ailauncher/chat/fragment/CliKind;Lcom/stepos/ailauncher/contract/model/SkillItemBrief;Landroid/content/Context;)Landroidx/fragment/app/Fragment;", "context", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/chat/fragment/CliKind;Landroid/content/Context;)V", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Q1 {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CliKind.values().length];
            try {
                iArr[CliKind.FEISHU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CliKind.WECOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final CliKind a(SkillItemBrief skillItemBrief) {
        kotlin.jvm.internal.p.i(skillItemBrief, "<this>");
        List listR = C1173v.r(skillItemBrief.getId(), skillItemBrief.getName());
        ArrayList<String> arrayList = new ArrayList(C1174w.x(listR, 10));
        Iterator it = listR.iterator();
        while (it.hasNext()) {
            String lowerCase = ((String) it.next()).toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            arrayList.add(lowerCase);
        }
        if (!arrayList.isEmpty()) {
            for (String str : arrayList) {
                if (kotlin.jvm.internal.p.d(str, "lark-cli") || La.H.g0(str, "飞书", false, 2, null) || La.H.g0(str, W4.b.TOOL_FEISHU, false, 2, null) || La.H.g0(str, "lark", false, 2, null)) {
                    return CliKind.FEISHU;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            for (String str2 : arrayList) {
                if (kotlin.jvm.internal.p.d(str2, "wecom-cli") || La.H.g0(str2, "企微", false, 2, null) || La.H.g0(str2, "企业微信", false, 2, null) || La.H.g0(str2, W4.b.TOOL_WECOM, false, 2, null)) {
                    return CliKind.WECOM;
                }
            }
        }
        return null;
    }

    public static final void b(CliKind cliKind, Context context) {
        kotlin.jvm.internal.p.i(cliKind, "<this>");
        kotlin.jvm.internal.p.i(context, "context");
        int i10 = a.$EnumSwitchMapping$0[cliKind.ordinal()];
        if (i10 == 1) {
            IFeishuConnectService iFeishuConnectService = (IFeishuConnectService) D5.a.INSTANCE.a(IFeishuConnectService.class);
            if (iFeishuConnectService != null) {
                iFeishuConnectService.confirmUninstall(context);
                return;
            }
            return;
        }
        if (i10 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        IWecomConnectService iWecomConnectService = (IWecomConnectService) D5.a.INSTANCE.a(IWecomConnectService.class);
        if (iWecomConnectService != null) {
            iWecomConnectService.confirmUninstall(context);
        }
    }

    public static final Fragment c(CliKind cliKind, SkillItemBrief item, Context context) {
        kotlin.jvm.internal.p.i(cliKind, "<this>");
        kotlin.jvm.internal.p.i(item, "item");
        boolean zD = d(cliKind, item);
        int i10 = a.$EnumSwitchMapping$0[cliKind.ordinal()];
        if (i10 == 1) {
            IFeishuConnectService iFeishuConnectService = (IFeishuConnectService) D5.a.INSTANCE.a(IFeishuConnectService.class);
            if (iFeishuConnectService != null) {
                return iFeishuConnectService.createConfigFragment(item.getId(), zD, context);
            }
            return null;
        }
        if (i10 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        IWecomConnectService iWecomConnectService = (IWecomConnectService) D5.a.INSTANCE.a(IWecomConnectService.class);
        if (iWecomConnectService != null) {
            return iWecomConnectService.createConfigFragment(item.getId(), zD, context);
        }
        return null;
    }

    public static final boolean d(CliKind cliKind, SkillItemBrief item) {
        kotlin.jvm.internal.p.i(cliKind, "<this>");
        kotlin.jvm.internal.p.i(item, "item");
        int i10 = a.$EnumSwitchMapping$0[cliKind.ordinal()];
        Boolean boolConnectedState = null;
        if (i10 == 1) {
            IFeishuConnectService iFeishuConnectService = (IFeishuConnectService) D5.a.INSTANCE.a(IFeishuConnectService.class);
            if (iFeishuConnectService != null) {
                boolConnectedState = iFeishuConnectService.connectedState();
            }
        } else {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            IWecomConnectService iWecomConnectService = (IWecomConnectService) D5.a.INSTANCE.a(IWecomConnectService.class);
            if (iWecomConnectService != null) {
                boolConnectedState = iWecomConnectService.connectedState();
            }
        }
        return boolConnectedState != null ? boolConnectedState.booleanValue() : item.getInstalled();
    }

    public static final ISkillUiService.SkillUiStatus e(CliKind cliKind, SkillItemBrief item) {
        kotlin.jvm.internal.p.i(cliKind, "<this>");
        kotlin.jvm.internal.p.i(item, "item");
        return f(cliKind) ? ISkillUiService.SkillUiStatus.UNINSTALLING : d(cliKind, item) ? ISkillUiService.SkillUiStatus.INSTALLED : ISkillUiService.SkillUiStatus.NOT_INSTALLED;
    }

    public static final boolean f(CliKind cliKind) {
        kotlin.jvm.internal.p.i(cliKind, "<this>");
        int i10 = a.$EnumSwitchMapping$0[cliKind.ordinal()];
        Boolean boolValueOf = null;
        if (i10 == 1) {
            IFeishuConnectService iFeishuConnectService = (IFeishuConnectService) D5.a.INSTANCE.a(IFeishuConnectService.class);
            if (iFeishuConnectService != null) {
                boolValueOf = Boolean.valueOf(iFeishuConnectService.uninstalling());
            }
        } else {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            IWecomConnectService iWecomConnectService = (IWecomConnectService) D5.a.INSTANCE.a(IWecomConnectService.class);
            if (iWecomConnectService != null) {
                boolValueOf = Boolean.valueOf(iWecomConnectService.uninstalling());
            }
        }
        return kotlin.jvm.internal.p.d(boolValueOf, Boolean.TRUE);
    }
}
