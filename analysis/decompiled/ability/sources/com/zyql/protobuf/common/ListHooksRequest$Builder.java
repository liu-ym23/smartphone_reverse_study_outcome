package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import q7.C1822u;

/* loaded from: classes2.dex */
public final class ListHooksRequest$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ ListHooksRequest$Builder(int i) {
        this();
    }

    public ListHooksRequest$Builder clearHookPoint() {
        copyOnWrite();
        C1822u.D((C1822u) this.instance);
        return this;
    }

    public ListHooksRequest$Builder clearLayer() {
        copyOnWrite();
        C1822u.E((C1822u) this.instance);
        return this;
    }

    public ListHooksRequest$Builder clearSessionId() {
        copyOnWrite();
        C1822u.F((C1822u) this.instance);
        return this;
    }

    public HookPoint getHookPoint() {
        return ((C1822u) this.instance).N();
    }

    public int getHookPointValue() {
        return ((C1822u) this.instance).O();
    }

    public HookLayer getLayer() {
        return ((C1822u) this.instance).P();
    }

    public int getLayerValue() {
        return ((C1822u) this.instance).Q();
    }

    public String getSessionId() {
        return ((C1822u) this.instance).R();
    }

    public ByteString getSessionIdBytes() {
        return ((C1822u) this.instance).S();
    }

    public ListHooksRequest$Builder setHookPoint(HookPoint hookPoint) {
        copyOnWrite();
        C1822u.G((C1822u) this.instance, hookPoint);
        return this;
    }

    public ListHooksRequest$Builder setHookPointValue(int i) {
        copyOnWrite();
        C1822u.H((C1822u) this.instance, i);
        return this;
    }

    public ListHooksRequest$Builder setLayer(HookLayer hookLayer) {
        copyOnWrite();
        C1822u.I((C1822u) this.instance, hookLayer);
        return this;
    }

    public ListHooksRequest$Builder setLayerValue(int i) {
        copyOnWrite();
        C1822u.J((C1822u) this.instance, i);
        return this;
    }

    public ListHooksRequest$Builder setSessionId(String str) {
        copyOnWrite();
        C1822u.K((C1822u) this.instance, str);
        return this;
    }

    public ListHooksRequest$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        C1822u.L((C1822u) this.instance, byteString);
        return this;
    }

    private ListHooksRequest$Builder() {
        super(C1822u.DEFAULT_INSTANCE);
    }
}
