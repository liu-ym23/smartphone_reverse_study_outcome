package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import q7.C1810h;
import q7.F;

/* loaded from: classes2.dex */
public final class ModelCallPreHookData$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ ModelCallPreHookData$Builder(int i) {
        this();
    }

    public ModelCallPreHookData$Builder addAllToolCalls(Iterable<? extends C1810h> iterable) {
        copyOnWrite();
        F.D((F) this.instance, iterable);
        return this;
    }

    public ModelCallPreHookData$Builder addToolCalls(C1810h c1810h) {
        copyOnWrite();
        F.F((F) this.instance, c1810h);
        return this;
    }

    public ModelCallPreHookData$Builder clearAgentId() {
        copyOnWrite();
        F.G((F) this.instance);
        return this;
    }

    public ModelCallPreHookData$Builder clearModelName() {
        copyOnWrite();
        F.H((F) this.instance);
        return this;
    }

    public ModelCallPreHookData$Builder clearProvider() {
        copyOnWrite();
        F.I((F) this.instance);
        return this;
    }

    public ModelCallPreHookData$Builder clearSessionId() {
        copyOnWrite();
        F.J((F) this.instance);
        return this;
    }

    public ModelCallPreHookData$Builder clearSettings() {
        copyOnWrite();
        F.L((F) this.instance).clear();
        return this;
    }

    public ModelCallPreHookData$Builder clearToolCalls() {
        copyOnWrite();
        F.K((F) this.instance);
        return this;
    }

    public boolean containsSettings(String str) {
        str.getClass();
        return ((F) this.instance).h0().containsKey(str);
    }

    public String getAgentId() {
        return ((F) this.instance).Y();
    }

    public ByteString getAgentIdBytes() {
        return ((F) this.instance).Z();
    }

    public String getModelName() {
        return ((F) this.instance).b0();
    }

    public ByteString getModelNameBytes() {
        return ((F) this.instance).c0();
    }

    public String getProvider() {
        return ((F) this.instance).d0();
    }

    public ByteString getProviderBytes() {
        return ((F) this.instance).e0();
    }

    public String getSessionId() {
        return ((F) this.instance).f0();
    }

    public ByteString getSessionIdBytes() {
        return ((F) this.instance).g0();
    }

    @Deprecated
    public Map<String, String> getSettings() {
        return getSettingsMap();
    }

    public int getSettingsCount() {
        return ((F) this.instance).h0().size();
    }

    public Map<String, String> getSettingsMap() {
        return Collections.unmodifiableMap(((F) this.instance).h0());
    }

    public String getSettingsOrDefault(String str, String str2) {
        str.getClass();
        Map mapH0 = ((F) this.instance).h0();
        return mapH0.containsKey(str) ? (String) mapH0.get(str) : str2;
    }

    public String getSettingsOrThrow(String str) {
        str.getClass();
        Map mapH0 = ((F) this.instance).h0();
        if (mapH0.containsKey(str)) {
            return (String) mapH0.get(str);
        }
        throw new IllegalArgumentException();
    }

    public C1810h getToolCalls(int i) {
        return ((F) this.instance).i0(i);
    }

    public int getToolCallsCount() {
        return ((F) this.instance).j0();
    }

    public List<C1810h> getToolCallsList() {
        return Collections.unmodifiableList(((F) this.instance).k0());
    }

    public ModelCallPreHookData$Builder putAllSettings(Map<String, String> map) {
        copyOnWrite();
        F.L((F) this.instance).putAll(map);
        return this;
    }

    public ModelCallPreHookData$Builder putSettings(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        F.L((F) this.instance).put(str, str2);
        return this;
    }

    public ModelCallPreHookData$Builder removeSettings(String str) {
        str.getClass();
        copyOnWrite();
        F.L((F) this.instance).remove(str);
        return this;
    }

    public ModelCallPreHookData$Builder removeToolCalls(int i) {
        copyOnWrite();
        F.M((F) this.instance, i);
        return this;
    }

    public ModelCallPreHookData$Builder setAgentId(String str) {
        copyOnWrite();
        F.N((F) this.instance, str);
        return this;
    }

    public ModelCallPreHookData$Builder setAgentIdBytes(ByteString byteString) {
        copyOnWrite();
        F.O((F) this.instance, byteString);
        return this;
    }

    public ModelCallPreHookData$Builder setModelName(String str) {
        copyOnWrite();
        F.P((F) this.instance, str);
        return this;
    }

    public ModelCallPreHookData$Builder setModelNameBytes(ByteString byteString) {
        copyOnWrite();
        F.Q((F) this.instance, byteString);
        return this;
    }

    public ModelCallPreHookData$Builder setProvider(String str) {
        copyOnWrite();
        F.R((F) this.instance, str);
        return this;
    }

    public ModelCallPreHookData$Builder setProviderBytes(ByteString byteString) {
        copyOnWrite();
        F.S((F) this.instance, byteString);
        return this;
    }

    public ModelCallPreHookData$Builder setSessionId(String str) {
        copyOnWrite();
        F.T((F) this.instance, str);
        return this;
    }

    public ModelCallPreHookData$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        F.U((F) this.instance, byteString);
        return this;
    }

    public ModelCallPreHookData$Builder setToolCalls(int i, C1810h c1810h) {
        copyOnWrite();
        F.V((F) this.instance, i, c1810h);
        return this;
    }

    private ModelCallPreHookData$Builder() {
        super(F.DEFAULT_INSTANCE);
    }

    public ModelCallPreHookData$Builder addToolCalls(int i, C1810h c1810h) {
        copyOnWrite();
        F.E((F) this.instance, i, c1810h);
        return this;
    }

    public ModelCallPreHookData$Builder setToolCalls(int i, FunctionCall$Builder functionCall$Builder) {
        copyOnWrite();
        F.V((F) this.instance, i, (C1810h) functionCall$Builder.k());
        return this;
    }

    public ModelCallPreHookData$Builder addToolCalls(FunctionCall$Builder functionCall$Builder) {
        copyOnWrite();
        F.F((F) this.instance, (C1810h) functionCall$Builder.k());
        return this;
    }

    public ModelCallPreHookData$Builder addToolCalls(int i, FunctionCall$Builder functionCall$Builder) {
        copyOnWrite();
        F.E((F) this.instance, i, (C1810h) functionCall$Builder.k());
        return this;
    }
}
