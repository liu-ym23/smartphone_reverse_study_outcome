package com.stepos.ailauncher.agent.skill.api;

import Ac.a;
import Ac.o;
import Y8.t;
import b5.PagedSkillResponse;
import com.stepos.ailauncher.agent.skill.GetSkillInstallStatus;
import com.stepos.ailauncher.agent.skill.SearchSkillParams;
import com.stepos.ailauncher.agent.skill.SkillInstallParams;
import com.stepos.ailauncher.agent.skill.SkillInstallResponse;
import com.stepos.ailauncher.agent.skill.SkillInstallSingleResponse;
import com.stepos.ailauncher.agent.skill.SkillOperaParams;
import com.stepos.ailauncher.agent.skill.cli.CliParams;
import com.stepos.ailauncher.agent.skill.cli.CliResponse;
import com.stepos.ailauncher.agent.skill.cli.InstalledSkillParams;
import com.stepos.ailauncher.network.ApiResponse;
import e9.InterfaceC4014c;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J<\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062$\b\u0001\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u0004H§@¢\u0006\u0004\b\b\u0010\tJ \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u000b\u001a\u00020\nH§@¢\u0006\u0004\b\f\u0010\rJ \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u000eH§@¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0001\u0010\u0005\u001a\u00020\u0011H§@¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0001\u0010\u0005\u001a\u00020\u0011H§@¢\u0006\u0004\b\u0016\u0010\u0015J \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u0017H§@¢\u0006\u0004\b\u0018\u0010\u0019J \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u001aH§@¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u001eH§@¢\u0006\u0004\b \u0010!J,\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00062\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\"H§@¢\u0006\u0004\b$\u0010%J \u0010&\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u001eH§@¢\u0006\u0004\b&\u0010!J \u0010'\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u001eH§@¢\u0006\u0004\b'\u0010!¨\u0006(À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/api/SkillApi;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "body", "Lcom/stepos/ailauncher/agent/skill/api/SkillEnvelope;", "Lb5/d;", "loadSkills", "(Ljava/util/HashMap;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/skill/SearchSkillParams;", "request", "searchSkills", "(Lcom/stepos/ailauncher/agent/skill/SearchSkillParams;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/skill/cli/g;", "getUserInstalledSkillList", "(Lcom/stepos/ailauncher/agent/skill/cli/g;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/skill/cli/CliParams;", "Lcom/stepos/ailauncher/network/ApiResponse;", "Lcom/stepos/ailauncher/agent/skill/cli/CliResponse;", "getUserCliList", "(Lcom/stepos/ailauncher/agent/skill/cli/CliParams;Le9/c;)Ljava/lang/Object;", "searchUserCliList", "Lcom/stepos/ailauncher/agent/skill/GetSkillInstallStatus;", "queryInstallStatuses", "(Lcom/stepos/ailauncher/agent/skill/GetSkillInstallStatus;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/skill/SkillInstallParams;", "Lcom/stepos/ailauncher/agent/skill/SkillInstallSingleResponse;", "startInstall", "(Lcom/stepos/ailauncher/agent/skill/SkillInstallParams;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/skill/SkillOperaParams;", "Lcom/stepos/ailauncher/agent/skill/SkillInstallResponse;", "uninstall", "(Lcom/stepos/ailauncher/agent/skill/SkillOperaParams;Le9/c;)Ljava/lang/Object;", "", "LY8/t;", "cancelInstall", "(Ljava/util/Map;Le9/c;)Ljava/lang/Object;", "setEnabled", "setDisable", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface SkillApi {
    @o("skill/install/cancel")
    Object cancelInstall(@a Map<String, String> map, InterfaceC4014c<? super SkillEnvelope<t>> interfaceC4014c);

    @o("/botmsg/step.agi.botmsg.BotMsg/ListClis")
    Object getUserCliList(@a CliParams cliParams, InterfaceC4014c<? super ApiResponse<CliResponse>> interfaceC4014c);

    @o("/skillhub/skillmarket/step.otter.skillhub.skillmarket/GetUserInstalledSkillList")
    Object getUserInstalledSkillList(@a InstalledSkillParams installedSkillParams, InterfaceC4014c<? super SkillEnvelope<PagedSkillResponse>> interfaceC4014c);

    @o("/skillhub/skillmarket/step.otter.skillhub.skillmarket/GetSkillList")
    Object loadSkills(@a HashMap<String, Object> map, InterfaceC4014c<? super SkillEnvelope<PagedSkillResponse>> interfaceC4014c);

    @o("/botmsg/step.agi.botmsg.BotMsg/ListSkills")
    Object queryInstallStatuses(@a GetSkillInstallStatus getSkillInstallStatus, InterfaceC4014c<? super SkillEnvelope<PagedSkillResponse>> interfaceC4014c);

    @o("/skillhub/skillmarket/step.otter.skillhub.skillmarket/SearchSkill")
    Object searchSkills(@a SearchSkillParams searchSkillParams, InterfaceC4014c<? super SkillEnvelope<PagedSkillResponse>> interfaceC4014c);

    @o("/botmsg/step.agi.botmsg.BotMsg/SearchClis")
    Object searchUserCliList(@a CliParams cliParams, InterfaceC4014c<? super ApiResponse<CliResponse>> interfaceC4014c);

    @o("/botmsg/step.agi.botmsg.BotMsg/DisableSkill")
    Object setDisable(@a SkillOperaParams skillOperaParams, InterfaceC4014c<? super SkillEnvelope<SkillInstallResponse>> interfaceC4014c);

    @o("/botmsg/step.agi.botmsg.BotMsg/EnableSkill")
    Object setEnabled(@a SkillOperaParams skillOperaParams, InterfaceC4014c<? super SkillEnvelope<SkillInstallResponse>> interfaceC4014c);

    @o("/botmsg/step.agi.botmsg.BotMsg/InstallClawSkill")
    Object startInstall(@a SkillInstallParams skillInstallParams, InterfaceC4014c<? super SkillEnvelope<SkillInstallSingleResponse>> interfaceC4014c);

    @o("/botmsg/step.agi.botmsg.BotMsg/UninstallSkill")
    Object uninstall(@a SkillOperaParams skillOperaParams, InterfaceC4014c<? super SkillEnvelope<SkillInstallResponse>> interfaceC4014c);
}
