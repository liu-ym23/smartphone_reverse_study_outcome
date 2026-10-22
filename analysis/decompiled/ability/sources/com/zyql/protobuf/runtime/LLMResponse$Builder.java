package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.C1014y2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Struct;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.Content$Builder;
import q7.C1808f;
import u7.j;

/* loaded from: classes2.dex */
public final class LLMResponse$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ LLMResponse$Builder(int i) {
        this();
    }

    public LLMResponse$Builder clearContent() {
        copyOnWrite();
        j.D((j) this.instance);
        return this;
    }

    public LLMResponse$Builder clearFinishReason() {
        copyOnWrite();
        j.E((j) this.instance);
        return this;
    }

    public LLMResponse$Builder clearMetadata() {
        copyOnWrite();
        j.F((j) this.instance);
        return this;
    }

    public LLMResponse$Builder clearPartial() {
        copyOnWrite();
        j.G((j) this.instance);
        return this;
    }

    public LLMResponse$Builder clearSequenceIndex() {
        copyOnWrite();
        j.H((j) this.instance);
        return this;
    }

    public LLMResponse$Builder clearTurnComplete() {
        copyOnWrite();
        j.I((j) this.instance);
        return this;
    }

    public C1808f getContent() {
        return ((j) this.instance).S();
    }

    public String getFinishReason() {
        return ((j) this.instance).U();
    }

    public ByteString getFinishReasonBytes() {
        return ((j) this.instance).V();
    }

    public Struct getMetadata() {
        return ((j) this.instance).W();
    }

    public boolean getPartial() {
        return ((j) this.instance).X();
    }

    public long getSequenceIndex() {
        return ((j) this.instance).Y();
    }

    public boolean getTurnComplete() {
        return ((j) this.instance).Z();
    }

    public boolean hasContent() {
        return ((j) this.instance).a0();
    }

    public boolean hasFinishReason() {
        return ((j) this.instance).b0();
    }

    public boolean hasMetadata() {
        return ((j) this.instance).c0();
    }

    public boolean hasSequenceIndex() {
        return ((j) this.instance).d0();
    }

    public LLMResponse$Builder mergeContent(C1808f c1808f) {
        copyOnWrite();
        j.J((j) this.instance, c1808f);
        return this;
    }

    public LLMResponse$Builder mergeMetadata(Struct struct) {
        copyOnWrite();
        j jVar = (j) this.instance;
        int i = j.CONTENT_FIELD_NUMBER;
        jVar.e0(struct);
        return this;
    }

    public LLMResponse$Builder setContent(C1808f c1808f) {
        copyOnWrite();
        j.K((j) this.instance, c1808f);
        return this;
    }

    public LLMResponse$Builder setFinishReason(String str) {
        copyOnWrite();
        j.L((j) this.instance, str);
        return this;
    }

    public LLMResponse$Builder setFinishReasonBytes(ByteString byteString) {
        copyOnWrite();
        j.M((j) this.instance, byteString);
        return this;
    }

    public LLMResponse$Builder setMetadata(Struct struct) {
        copyOnWrite();
        j.N((j) this.instance, struct);
        return this;
    }

    public LLMResponse$Builder setPartial(boolean z10) {
        copyOnWrite();
        j.O((j) this.instance, z10);
        return this;
    }

    public LLMResponse$Builder setSequenceIndex(long j5) {
        copyOnWrite();
        j.P((j) this.instance, j5);
        return this;
    }

    public LLMResponse$Builder setTurnComplete(boolean z10) {
        copyOnWrite();
        j.Q((j) this.instance, z10);
        return this;
    }

    private LLMResponse$Builder() {
        super(j.DEFAULT_INSTANCE);
    }

    public LLMResponse$Builder setContent(Content$Builder content$Builder) {
        copyOnWrite();
        j.K((j) this.instance, (C1808f) content$Builder.k());
        return this;
    }

    public LLMResponse$Builder setMetadata(C1014y2 c1014y2) {
        copyOnWrite();
        j.N((j) this.instance, (Struct) c1014y2.k());
        return this;
    }
}
