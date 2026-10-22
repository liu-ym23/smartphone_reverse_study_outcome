package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import q7.C1816n;

/* loaded from: classes2.dex */
public final class HookDefinition$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ HookDefinition$Builder(int i) {
        this();
    }

    public HookDefinition$Builder clearDescription() {
        copyOnWrite();
        C1816n.D((C1816n) this.instance);
        return this;
    }

    public HookDefinition$Builder clearHookPoint() {
        copyOnWrite();
        C1816n.E((C1816n) this.instance);
        return this;
    }

    public HookDefinition$Builder clearLayer() {
        copyOnWrite();
        C1816n.F((C1816n) this.instance);
        return this;
    }

    public HookDefinition$Builder clearMode() {
        copyOnWrite();
        C1816n.G((C1816n) this.instance);
        return this;
    }

    public HookDefinition$Builder clearName() {
        copyOnWrite();
        C1816n.H((C1816n) this.instance);
        return this;
    }

    public HookDefinition$Builder clearTimeoutMs() {
        copyOnWrite();
        C1816n.I((C1816n) this.instance);
        return this;
    }

    public HookDefinition$Builder clearToolNamePattern() {
        copyOnWrite();
        C1816n.J((C1816n) this.instance);
        return this;
    }

    public String getDescription() {
        return ((C1816n) this.instance).Z();
    }

    public ByteString getDescriptionBytes() {
        return ((C1816n) this.instance).a0();
    }

    public HookPoint getHookPoint() {
        return ((C1816n) this.instance).b0();
    }

    public int getHookPointValue() {
        return ((C1816n) this.instance).c0();
    }

    public HookLayer getLayer() {
        return ((C1816n) this.instance).d0();
    }

    public int getLayerValue() {
        return ((C1816n) this.instance).e0();
    }

    public HookExecutionMode getMode() {
        return ((C1816n) this.instance).f0();
    }

    public int getModeValue() {
        return ((C1816n) this.instance).g0();
    }

    public String getName() {
        return ((C1816n) this.instance).h0();
    }

    public ByteString getNameBytes() {
        return ((C1816n) this.instance).i0();
    }

    public int getTimeoutMs() {
        return ((C1816n) this.instance).j0();
    }

    public String getToolNamePattern() {
        return ((C1816n) this.instance).k0();
    }

    public ByteString getToolNamePatternBytes() {
        return ((C1816n) this.instance).l0();
    }

    public boolean hasToolNamePattern() {
        return ((C1816n) this.instance).m0();
    }

    public HookDefinition$Builder setDescription(String str) {
        copyOnWrite();
        C1816n.K((C1816n) this.instance, str);
        return this;
    }

    public HookDefinition$Builder setDescriptionBytes(ByteString byteString) {
        copyOnWrite();
        C1816n.L((C1816n) this.instance, byteString);
        return this;
    }

    public HookDefinition$Builder setHookPoint(HookPoint hookPoint) {
        copyOnWrite();
        C1816n.M((C1816n) this.instance, hookPoint);
        return this;
    }

    public HookDefinition$Builder setHookPointValue(int i) {
        copyOnWrite();
        C1816n.N(i, (C1816n) this.instance);
        return this;
    }

    public HookDefinition$Builder setLayer(HookLayer hookLayer) {
        copyOnWrite();
        C1816n.O((C1816n) this.instance, hookLayer);
        return this;
    }

    public HookDefinition$Builder setLayerValue(int i) {
        copyOnWrite();
        C1816n.P(i, (C1816n) this.instance);
        return this;
    }

    public HookDefinition$Builder setMode(HookExecutionMode hookExecutionMode) {
        copyOnWrite();
        C1816n.Q((C1816n) this.instance, hookExecutionMode);
        return this;
    }

    public HookDefinition$Builder setModeValue(int i) {
        copyOnWrite();
        C1816n.R(i, (C1816n) this.instance);
        return this;
    }

    public HookDefinition$Builder setName(String str) {
        copyOnWrite();
        C1816n.S((C1816n) this.instance, str);
        return this;
    }

    public HookDefinition$Builder setNameBytes(ByteString byteString) {
        copyOnWrite();
        C1816n.T((C1816n) this.instance, byteString);
        return this;
    }

    public HookDefinition$Builder setTimeoutMs(int i) {
        copyOnWrite();
        C1816n.U(i, (C1816n) this.instance);
        return this;
    }

    public HookDefinition$Builder setToolNamePattern(String str) {
        copyOnWrite();
        C1816n.V((C1816n) this.instance, str);
        return this;
    }

    public HookDefinition$Builder setToolNamePatternBytes(ByteString byteString) {
        copyOnWrite();
        C1816n.W((C1816n) this.instance, byteString);
        return this;
    }

    private HookDefinition$Builder() {
        super(C1816n.DEFAULT_INSTANCE);
    }
}
