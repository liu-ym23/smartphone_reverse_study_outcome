package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import u7.e;
import u7.m;
import u7.r;

/* loaded from: classes2.dex */
public final class ChatResponse$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ ChatResponse$Builder(int i) {
        this();
    }

    public ChatResponse$Builder clearAck() {
        copyOnWrite();
        e.D((e) this.instance);
        return this;
    }

    public ChatResponse$Builder clearContent() {
        copyOnWrite();
        e.E((e) this.instance);
        return this;
    }

    public ChatResponse$Builder clearSessionId() {
        copyOnWrite();
        e.F((e) this.instance);
        return this;
    }

    public ChatResponse$Builder clearTask() {
        copyOnWrite();
        e.G((e) this.instance);
        return this;
    }

    public m getAck() {
        return ((e) this.instance).O();
    }

    public ChatResponse$ContentCase getContentCase() {
        return ((e) this.instance).P();
    }

    public String getSessionId() {
        return ((e) this.instance).Q();
    }

    public ByteString getSessionIdBytes() {
        return ((e) this.instance).R();
    }

    public r getTask() {
        return ((e) this.instance).S();
    }

    public boolean hasAck() {
        return ((e) this.instance).T();
    }

    public boolean hasSessionId() {
        return ((e) this.instance).U();
    }

    public boolean hasTask() {
        return ((e) this.instance).V();
    }

    public ChatResponse$Builder mergeAck(m mVar) {
        copyOnWrite();
        e.H((e) this.instance, mVar);
        return this;
    }

    public ChatResponse$Builder mergeTask(r rVar) {
        copyOnWrite();
        e.I((e) this.instance, rVar);
        return this;
    }

    public ChatResponse$Builder setAck(m mVar) {
        copyOnWrite();
        e.J((e) this.instance, mVar);
        return this;
    }

    public ChatResponse$Builder setSessionId(String str) {
        copyOnWrite();
        e.K((e) this.instance, str);
        return this;
    }

    public ChatResponse$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        e.L((e) this.instance, byteString);
        return this;
    }

    public ChatResponse$Builder setTask(r rVar) {
        copyOnWrite();
        e.M((e) this.instance, rVar);
        return this;
    }

    private ChatResponse$Builder() {
        super(e.DEFAULT_INSTANCE);
    }

    public ChatResponse$Builder setAck(RequestAck$Builder requestAck$Builder) {
        copyOnWrite();
        e.J((e) this.instance, (m) requestAck$Builder.k());
        return this;
    }

    public ChatResponse$Builder setTask(Task$Builder task$Builder) {
        copyOnWrite();
        e.M((e) this.instance, (r) task$Builder.k());
        return this;
    }
}
