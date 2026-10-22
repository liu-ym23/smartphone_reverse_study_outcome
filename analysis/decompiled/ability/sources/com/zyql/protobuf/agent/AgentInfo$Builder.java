package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.HookDefinition$Builder;
import java.util.Collections;
import java.util.List;
import o7.C1765a;
import o7.v;
import o7.x;
import o7.z;
import q7.C1816n;

/* loaded from: classes2.dex */
public final class AgentInfo$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ AgentInfo$Builder(int i) {
        this();
    }

    public AgentInfo$Builder addAllHooks(Iterable<? extends C1816n> iterable) {
        copyOnWrite();
        C1765a.D((C1765a) this.instance, iterable);
        return this;
    }

    public AgentInfo$Builder addAllSkills(Iterable<? extends x> iterable) {
        copyOnWrite();
        C1765a.E((C1765a) this.instance, iterable);
        return this;
    }

    public AgentInfo$Builder addAllSubAgents(Iterable<? extends C1765a> iterable) {
        copyOnWrite();
        C1765a.F((C1765a) this.instance, iterable);
        return this;
    }

    public AgentInfo$Builder addAllTools(Iterable<? extends z> iterable) {
        copyOnWrite();
        C1765a.G((C1765a) this.instance, iterable);
        return this;
    }

    public AgentInfo$Builder addHooks(C1816n c1816n) {
        copyOnWrite();
        C1765a.I((C1765a) this.instance, c1816n);
        return this;
    }

    public AgentInfo$Builder addSkills(x xVar) {
        copyOnWrite();
        C1765a.K((C1765a) this.instance, xVar);
        return this;
    }

    public AgentInfo$Builder addSubAgents(C1765a c1765a) {
        copyOnWrite();
        C1765a.M((C1765a) this.instance, c1765a);
        return this;
    }

    public AgentInfo$Builder addTools(z zVar) {
        copyOnWrite();
        C1765a.O((C1765a) this.instance, zVar);
        return this;
    }

    public AgentInfo$Builder clearAgentId() {
        copyOnWrite();
        C1765a.P((C1765a) this.instance);
        return this;
    }

    public AgentInfo$Builder clearDescription() {
        copyOnWrite();
        C1765a.Q((C1765a) this.instance);
        return this;
    }

    public AgentInfo$Builder clearHooks() {
        copyOnWrite();
        C1765a.R((C1765a) this.instance);
        return this;
    }

    public AgentInfo$Builder clearInstructions() {
        copyOnWrite();
        C1765a.S((C1765a) this.instance);
        return this;
    }

    public AgentInfo$Builder clearModelConfig() {
        copyOnWrite();
        C1765a.T((C1765a) this.instance);
        return this;
    }

    public AgentInfo$Builder clearName() {
        copyOnWrite();
        C1765a.U((C1765a) this.instance);
        return this;
    }

    public AgentInfo$Builder clearSkills() {
        copyOnWrite();
        C1765a.V((C1765a) this.instance);
        return this;
    }

    public AgentInfo$Builder clearSubAgents() {
        copyOnWrite();
        C1765a.W((C1765a) this.instance);
        return this;
    }

    public AgentInfo$Builder clearTools() {
        copyOnWrite();
        C1765a.X((C1765a) this.instance);
        return this;
    }

    public AgentInfo$Builder clearVersion() {
        copyOnWrite();
        C1765a.Y((C1765a) this.instance);
        return this;
    }

    public String getAgentId() {
        return ((C1765a) this.instance).y0();
    }

    public ByteString getAgentIdBytes() {
        return ((C1765a) this.instance).z0();
    }

    public String getDescription() {
        return ((C1765a) this.instance).B0();
    }

    public ByteString getDescriptionBytes() {
        return ((C1765a) this.instance).C0();
    }

    public C1816n getHooks(int i) {
        return ((C1765a) this.instance).D0(i);
    }

    public int getHooksCount() {
        return ((C1765a) this.instance).E0();
    }

    public List<C1816n> getHooksList() {
        return Collections.unmodifiableList(((C1765a) this.instance).F0());
    }

    public String getInstructions() {
        return ((C1765a) this.instance).G0();
    }

    public ByteString getInstructionsBytes() {
        return ((C1765a) this.instance).H0();
    }

    public v getModelConfig() {
        return ((C1765a) this.instance).I0();
    }

    public String getName() {
        return ((C1765a) this.instance).J0();
    }

    public ByteString getNameBytes() {
        return ((C1765a) this.instance).K0();
    }

    public x getSkills(int i) {
        return ((C1765a) this.instance).L0(i);
    }

    public int getSkillsCount() {
        return ((C1765a) this.instance).M0();
    }

    public List<x> getSkillsList() {
        return Collections.unmodifiableList(((C1765a) this.instance).N0());
    }

    public C1765a getSubAgents(int i) {
        return ((C1765a) this.instance).O0(i);
    }

    public int getSubAgentsCount() {
        return ((C1765a) this.instance).P0();
    }

    public List<C1765a> getSubAgentsList() {
        return Collections.unmodifiableList(((C1765a) this.instance).Q0());
    }

    public z getTools(int i) {
        return ((C1765a) this.instance).R0(i);
    }

    public int getToolsCount() {
        return ((C1765a) this.instance).S0();
    }

    public List<z> getToolsList() {
        return Collections.unmodifiableList(((C1765a) this.instance).T0());
    }

    public String getVersion() {
        return ((C1765a) this.instance).U0();
    }

    public ByteString getVersionBytes() {
        return ((C1765a) this.instance).V0();
    }

    public boolean hasModelConfig() {
        return ((C1765a) this.instance).W0();
    }

    public AgentInfo$Builder mergeModelConfig(v vVar) {
        copyOnWrite();
        C1765a.Z((C1765a) this.instance, vVar);
        return this;
    }

    public AgentInfo$Builder removeHooks(int i) {
        copyOnWrite();
        C1765a.a0(i, (C1765a) this.instance);
        return this;
    }

    public AgentInfo$Builder removeSkills(int i) {
        copyOnWrite();
        C1765a.b0(i, (C1765a) this.instance);
        return this;
    }

    public AgentInfo$Builder removeSubAgents(int i) {
        copyOnWrite();
        C1765a.c0(i, (C1765a) this.instance);
        return this;
    }

    public AgentInfo$Builder removeTools(int i) {
        copyOnWrite();
        C1765a.d0(i, (C1765a) this.instance);
        return this;
    }

    public AgentInfo$Builder setAgentId(String str) {
        copyOnWrite();
        C1765a.e0((C1765a) this.instance, str);
        return this;
    }

    public AgentInfo$Builder setAgentIdBytes(ByteString byteString) {
        copyOnWrite();
        C1765a.f0((C1765a) this.instance, byteString);
        return this;
    }

    public AgentInfo$Builder setDescription(String str) {
        copyOnWrite();
        C1765a.g0((C1765a) this.instance, str);
        return this;
    }

    public AgentInfo$Builder setDescriptionBytes(ByteString byteString) {
        copyOnWrite();
        C1765a.h0((C1765a) this.instance, byteString);
        return this;
    }

    public AgentInfo$Builder setHooks(int i, C1816n c1816n) {
        copyOnWrite();
        C1765a.i0((C1765a) this.instance, i, c1816n);
        return this;
    }

    public AgentInfo$Builder setInstructions(String str) {
        copyOnWrite();
        C1765a.j0((C1765a) this.instance, str);
        return this;
    }

    public AgentInfo$Builder setInstructionsBytes(ByteString byteString) {
        copyOnWrite();
        C1765a.k0((C1765a) this.instance, byteString);
        return this;
    }

    public AgentInfo$Builder setModelConfig(v vVar) {
        copyOnWrite();
        C1765a.l0((C1765a) this.instance, vVar);
        return this;
    }

    public AgentInfo$Builder setName(String str) {
        copyOnWrite();
        C1765a.m0((C1765a) this.instance, str);
        return this;
    }

    public AgentInfo$Builder setNameBytes(ByteString byteString) {
        copyOnWrite();
        C1765a.n0((C1765a) this.instance, byteString);
        return this;
    }

    public AgentInfo$Builder setSkills(int i, x xVar) {
        copyOnWrite();
        C1765a.o0((C1765a) this.instance, i, xVar);
        return this;
    }

    public AgentInfo$Builder setSubAgents(int i, C1765a c1765a) {
        copyOnWrite();
        C1765a.p0((C1765a) this.instance, i, c1765a);
        return this;
    }

    public AgentInfo$Builder setTools(int i, z zVar) {
        copyOnWrite();
        C1765a.q0((C1765a) this.instance, i, zVar);
        return this;
    }

    public AgentInfo$Builder setVersion(String str) {
        copyOnWrite();
        C1765a.r0((C1765a) this.instance, str);
        return this;
    }

    public AgentInfo$Builder setVersionBytes(ByteString byteString) {
        copyOnWrite();
        C1765a.s0((C1765a) this.instance, byteString);
        return this;
    }

    private AgentInfo$Builder() {
        super(C1765a.DEFAULT_INSTANCE);
    }

    public AgentInfo$Builder addHooks(int i, C1816n c1816n) {
        copyOnWrite();
        C1765a.H((C1765a) this.instance, i, c1816n);
        return this;
    }

    public AgentInfo$Builder addSkills(int i, x xVar) {
        copyOnWrite();
        C1765a.J((C1765a) this.instance, i, xVar);
        return this;
    }

    public AgentInfo$Builder addSubAgents(int i, C1765a c1765a) {
        copyOnWrite();
        C1765a.L((C1765a) this.instance, i, c1765a);
        return this;
    }

    public AgentInfo$Builder addTools(int i, z zVar) {
        copyOnWrite();
        C1765a.N((C1765a) this.instance, i, zVar);
        return this;
    }

    public AgentInfo$Builder setHooks(int i, HookDefinition$Builder hookDefinition$Builder) {
        copyOnWrite();
        C1765a.i0((C1765a) this.instance, i, (C1816n) hookDefinition$Builder.k());
        return this;
    }

    public AgentInfo$Builder setModelConfig(ModelConfig$Builder modelConfig$Builder) {
        copyOnWrite();
        C1765a.l0((C1765a) this.instance, (v) modelConfig$Builder.k());
        return this;
    }

    public AgentInfo$Builder setSkills(int i, Skill$Builder skill$Builder) {
        copyOnWrite();
        C1765a.o0((C1765a) this.instance, i, (x) skill$Builder.k());
        return this;
    }

    public AgentInfo$Builder setSubAgents(int i, AgentInfo$Builder agentInfo$Builder) {
        copyOnWrite();
        C1765a.p0((C1765a) this.instance, i, (C1765a) agentInfo$Builder.k());
        return this;
    }

    public AgentInfo$Builder setTools(int i, ToolDefinition$Builder toolDefinition$Builder) {
        copyOnWrite();
        C1765a.q0((C1765a) this.instance, i, (z) toolDefinition$Builder.k());
        return this;
    }

    public AgentInfo$Builder addHooks(HookDefinition$Builder hookDefinition$Builder) {
        copyOnWrite();
        C1765a.I((C1765a) this.instance, (C1816n) hookDefinition$Builder.k());
        return this;
    }

    public AgentInfo$Builder addSkills(Skill$Builder skill$Builder) {
        copyOnWrite();
        C1765a.K((C1765a) this.instance, (x) skill$Builder.k());
        return this;
    }

    public AgentInfo$Builder addSubAgents(AgentInfo$Builder agentInfo$Builder) {
        copyOnWrite();
        C1765a.M((C1765a) this.instance, (C1765a) agentInfo$Builder.k());
        return this;
    }

    public AgentInfo$Builder addTools(ToolDefinition$Builder toolDefinition$Builder) {
        copyOnWrite();
        C1765a.O((C1765a) this.instance, (z) toolDefinition$Builder.k());
        return this;
    }

    public AgentInfo$Builder addHooks(int i, HookDefinition$Builder hookDefinition$Builder) {
        copyOnWrite();
        C1765a.H((C1765a) this.instance, i, (C1816n) hookDefinition$Builder.k());
        return this;
    }

    public AgentInfo$Builder addSkills(int i, Skill$Builder skill$Builder) {
        copyOnWrite();
        C1765a.J((C1765a) this.instance, i, (x) skill$Builder.k());
        return this;
    }

    public AgentInfo$Builder addSubAgents(int i, AgentInfo$Builder agentInfo$Builder) {
        copyOnWrite();
        C1765a.L((C1765a) this.instance, i, (C1765a) agentInfo$Builder.k());
        return this;
    }

    public AgentInfo$Builder addTools(int i, ToolDefinition$Builder toolDefinition$Builder) {
        copyOnWrite();
        C1765a.N((C1765a) this.instance, i, (z) toolDefinition$Builder.k());
        return this;
    }
}
