package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import v7.C2062a;
import v7.h;
import v7.o;
import v7.r;
import v7.s;
import v7.y;

/* loaded from: classes2.dex */
public final class Task$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ Task$Builder(int i) {
        this();
    }

    public Task$Builder addAllChildTaskIds(Iterable<String> iterable) {
        copyOnWrite();
        o.D((o) this.instance, iterable);
        return this;
    }

    public Task$Builder addAllExecution(Iterable<? extends h> iterable) {
        copyOnWrite();
        o.E((o) this.instance, iterable);
        return this;
    }

    public Task$Builder addChildTaskIds(String str) {
        copyOnWrite();
        o.F((o) this.instance, str);
        return this;
    }

    public Task$Builder addChildTaskIdsBytes(ByteString byteString) {
        copyOnWrite();
        o.G((o) this.instance, byteString);
        return this;
    }

    public Task$Builder addExecution(h hVar) {
        copyOnWrite();
        o.I((o) this.instance, hVar);
        return this;
    }

    public Task$Builder clearAgent() {
        copyOnWrite();
        o.J((o) this.instance);
        return this;
    }

    public Task$Builder clearChildTaskIds() {
        copyOnWrite();
        o.K((o) this.instance);
        return this;
    }

    public Task$Builder clearError() {
        copyOnWrite();
        o.L((o) this.instance);
        return this;
    }

    public Task$Builder clearExecution() {
        copyOnWrite();
        o.M((o) this.instance);
        return this;
    }

    public Task$Builder clearInput() {
        copyOnWrite();
        o.N((o) this.instance);
        return this;
    }

    public Task$Builder clearMetaData() {
        copyOnWrite();
        o.U((o) this.instance).clear();
        return this;
    }

    public Task$Builder clearOriginTaskId() {
        copyOnWrite();
        o.O((o) this.instance);
        return this;
    }

    public Task$Builder clearOutput() {
        copyOnWrite();
        o.P((o) this.instance);
        return this;
    }

    public Task$Builder clearParentTaskId() {
        copyOnWrite();
        o.Q((o) this.instance);
        return this;
    }

    public Task$Builder clearStatus() {
        copyOnWrite();
        o.R((o) this.instance);
        return this;
    }

    public Task$Builder clearTaskId() {
        copyOnWrite();
        o.S((o) this.instance);
        return this;
    }

    public Task$Builder clearUser() {
        copyOnWrite();
        o.T((o) this.instance);
        return this;
    }

    public boolean containsMetaData(String str) {
        str.getClass();
        return ((o) this.instance).F0().containsKey(str);
    }

    public C2062a getAgent() {
        return ((o) this.instance).t0();
    }

    public String getChildTaskIds(int i) {
        return ((o) this.instance).u0(i);
    }

    public ByteString getChildTaskIdsBytes(int i) {
        return ((o) this.instance).v0(i);
    }

    public int getChildTaskIdsCount() {
        return ((o) this.instance).w0();
    }

    public List<String> getChildTaskIdsList() {
        return Collections.unmodifiableList(((o) this.instance).x0());
    }

    public String getError() {
        return ((o) this.instance).z0();
    }

    public ByteString getErrorBytes() {
        return ((o) this.instance).A0();
    }

    public h getExecution(int i) {
        return ((o) this.instance).B0(i);
    }

    public int getExecutionCount() {
        return ((o) this.instance).C0();
    }

    public List<h> getExecutionList() {
        return Collections.unmodifiableList(((o) this.instance).D0());
    }

    public r getInput() {
        return ((o) this.instance).E0();
    }

    @Deprecated
    public Map<String, String> getMetaData() {
        return getMetaDataMap();
    }

    public int getMetaDataCount() {
        return ((o) this.instance).F0().size();
    }

    public Map<String, String> getMetaDataMap() {
        return Collections.unmodifiableMap(((o) this.instance).F0());
    }

    public String getMetaDataOrDefault(String str, String str2) {
        str.getClass();
        Map mapF0 = ((o) this.instance).F0();
        return mapF0.containsKey(str) ? (String) mapF0.get(str) : str2;
    }

    public String getMetaDataOrThrow(String str) {
        str.getClass();
        Map mapF0 = ((o) this.instance).F0();
        if (mapF0.containsKey(str)) {
            return (String) mapF0.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getOriginTaskId() {
        return ((o) this.instance).G0();
    }

    public ByteString getOriginTaskIdBytes() {
        return ((o) this.instance).H0();
    }

    public s getOutput() {
        return ((o) this.instance).I0();
    }

    public String getParentTaskId() {
        return ((o) this.instance).J0();
    }

    public ByteString getParentTaskIdBytes() {
        return ((o) this.instance).K0();
    }

    public String getStatus() {
        return ((o) this.instance).L0();
    }

    public ByteString getStatusBytes() {
        return ((o) this.instance).M0();
    }

    public String getTaskId() {
        return ((o) this.instance).N0();
    }

    public ByteString getTaskIdBytes() {
        return ((o) this.instance).O0();
    }

    public y getUser() {
        return ((o) this.instance).P0();
    }

    public boolean hasAgent() {
        return ((o) this.instance).Q0();
    }

    public boolean hasInput() {
        return ((o) this.instance).R0();
    }

    public boolean hasOutput() {
        return ((o) this.instance).S0();
    }

    public boolean hasUser() {
        return ((o) this.instance).T0();
    }

    public Task$Builder mergeAgent(C2062a c2062a) {
        copyOnWrite();
        o.V((o) this.instance, c2062a);
        return this;
    }

    public Task$Builder mergeInput(r rVar) {
        copyOnWrite();
        o.W((o) this.instance, rVar);
        return this;
    }

    public Task$Builder mergeOutput(s sVar) {
        copyOnWrite();
        o.X((o) this.instance, sVar);
        return this;
    }

    public Task$Builder mergeUser(y yVar) {
        copyOnWrite();
        o.Y((o) this.instance, yVar);
        return this;
    }

    public Task$Builder putAllMetaData(Map<String, String> map) {
        copyOnWrite();
        o.U((o) this.instance).putAll(map);
        return this;
    }

    public Task$Builder putMetaData(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        o.U((o) this.instance).put(str, str2);
        return this;
    }

    public Task$Builder removeExecution(int i) {
        copyOnWrite();
        o.Z((o) this.instance, i);
        return this;
    }

    public Task$Builder removeMetaData(String str) {
        str.getClass();
        copyOnWrite();
        o.U((o) this.instance).remove(str);
        return this;
    }

    public Task$Builder setAgent(C2062a c2062a) {
        copyOnWrite();
        o.a0((o) this.instance, c2062a);
        return this;
    }

    public Task$Builder setChildTaskIds(int i, String str) {
        copyOnWrite();
        o.b0((o) this.instance, i, str);
        return this;
    }

    public Task$Builder setError(String str) {
        copyOnWrite();
        o.c0((o) this.instance, str);
        return this;
    }

    public Task$Builder setErrorBytes(ByteString byteString) {
        copyOnWrite();
        o.d0((o) this.instance, byteString);
        return this;
    }

    public Task$Builder setExecution(int i, h hVar) {
        copyOnWrite();
        o.e0((o) this.instance, i, hVar);
        return this;
    }

    public Task$Builder setInput(r rVar) {
        copyOnWrite();
        o.f0((o) this.instance, rVar);
        return this;
    }

    public Task$Builder setOriginTaskId(String str) {
        copyOnWrite();
        o.g0((o) this.instance, str);
        return this;
    }

    public Task$Builder setOriginTaskIdBytes(ByteString byteString) {
        copyOnWrite();
        o.h0((o) this.instance, byteString);
        return this;
    }

    public Task$Builder setOutput(s sVar) {
        copyOnWrite();
        o.i0((o) this.instance, sVar);
        return this;
    }

    public Task$Builder setParentTaskId(String str) {
        copyOnWrite();
        o.j0((o) this.instance, str);
        return this;
    }

    public Task$Builder setParentTaskIdBytes(ByteString byteString) {
        copyOnWrite();
        o.k0((o) this.instance, byteString);
        return this;
    }

    public Task$Builder setStatus(String str) {
        copyOnWrite();
        o.l0((o) this.instance, str);
        return this;
    }

    public Task$Builder setStatusBytes(ByteString byteString) {
        copyOnWrite();
        o.m0((o) this.instance, byteString);
        return this;
    }

    public Task$Builder setTaskId(String str) {
        copyOnWrite();
        o.n0((o) this.instance, str);
        return this;
    }

    public Task$Builder setTaskIdBytes(ByteString byteString) {
        copyOnWrite();
        o.o0((o) this.instance, byteString);
        return this;
    }

    public Task$Builder setUser(y yVar) {
        copyOnWrite();
        o.p0((o) this.instance, yVar);
        return this;
    }

    private Task$Builder() {
        super(o.DEFAULT_INSTANCE);
    }

    public Task$Builder addExecution(int i, h hVar) {
        copyOnWrite();
        o.H((o) this.instance, i, hVar);
        return this;
    }

    public Task$Builder setAgent(Agent$Builder agent$Builder) {
        copyOnWrite();
        o.a0((o) this.instance, (C2062a) agent$Builder.k());
        return this;
    }

    public Task$Builder setExecution(int i, Item$Builder item$Builder) {
        copyOnWrite();
        o.e0((o) this.instance, i, (h) item$Builder.k());
        return this;
    }

    public Task$Builder setInput(TaskInput$Builder taskInput$Builder) {
        copyOnWrite();
        o.f0((o) this.instance, (r) taskInput$Builder.k());
        return this;
    }

    public Task$Builder setOutput(TaskOutput$Builder taskOutput$Builder) {
        copyOnWrite();
        o.i0((o) this.instance, (s) taskOutput$Builder.k());
        return this;
    }

    public Task$Builder setUser(User$Builder user$Builder) {
        copyOnWrite();
        o.p0((o) this.instance, (y) user$Builder.k());
        return this;
    }

    public Task$Builder addExecution(Item$Builder item$Builder) {
        copyOnWrite();
        o.I((o) this.instance, (h) item$Builder.k());
        return this;
    }

    public Task$Builder addExecution(int i, Item$Builder item$Builder) {
        copyOnWrite();
        o.H((o) this.instance, i, (h) item$Builder.k());
        return this;
    }
}
