package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.C1014y2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Struct;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.Content$Builder;
import java.util.Collections;
import java.util.List;
import q7.C1808f;
import u7.o;

/* loaded from: classes2.dex */
public final class SendInputRequest$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ SendInputRequest$Builder(int i) {
        this();
    }

    public SendInputRequest$Builder addAllMessages(Iterable<? extends C1808f> iterable) {
        copyOnWrite();
        o.D((o) this.instance, iterable);
        return this;
    }

    public SendInputRequest$Builder addMessages(C1808f c1808f) {
        copyOnWrite();
        o.F((o) this.instance, c1808f);
        return this;
    }

    public SendInputRequest$Builder clearMessages() {
        copyOnWrite();
        o.G((o) this.instance);
        return this;
    }

    public SendInputRequest$Builder clearMetadata() {
        copyOnWrite();
        o.H((o) this.instance);
        return this;
    }

    public SendInputRequest$Builder clearSessionId() {
        copyOnWrite();
        o.I((o) this.instance);
        return this;
    }

    public C1808f getMessages(int i) {
        return ((o) this.instance).R(i);
    }

    public int getMessagesCount() {
        return ((o) this.instance).S();
    }

    public List<C1808f> getMessagesList() {
        return Collections.unmodifiableList(((o) this.instance).T());
    }

    public Struct getMetadata() {
        return ((o) this.instance).U();
    }

    public String getSessionId() {
        return ((o) this.instance).V();
    }

    public ByteString getSessionIdBytes() {
        return ((o) this.instance).W();
    }

    public boolean hasMetadata() {
        return ((o) this.instance).X();
    }

    public SendInputRequest$Builder mergeMetadata(Struct struct) {
        copyOnWrite();
        o oVar = (o) this.instance;
        int i = o.SESSION_ID_FIELD_NUMBER;
        oVar.Y(struct);
        return this;
    }

    public SendInputRequest$Builder removeMessages(int i) {
        copyOnWrite();
        o.J((o) this.instance, i);
        return this;
    }

    public SendInputRequest$Builder setMessages(int i, C1808f c1808f) {
        copyOnWrite();
        o.K((o) this.instance, i, c1808f);
        return this;
    }

    public SendInputRequest$Builder setMetadata(Struct struct) {
        copyOnWrite();
        o.L((o) this.instance, struct);
        return this;
    }

    public SendInputRequest$Builder setSessionId(String str) {
        copyOnWrite();
        o.M((o) this.instance, str);
        return this;
    }

    public SendInputRequest$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        o.N((o) this.instance, byteString);
        return this;
    }

    private SendInputRequest$Builder() {
        super(o.DEFAULT_INSTANCE);
    }

    public SendInputRequest$Builder addMessages(int i, C1808f c1808f) {
        copyOnWrite();
        o.E((o) this.instance, i, c1808f);
        return this;
    }

    public SendInputRequest$Builder setMessages(int i, Content$Builder content$Builder) {
        copyOnWrite();
        o.K((o) this.instance, i, (C1808f) content$Builder.k());
        return this;
    }

    public SendInputRequest$Builder setMetadata(C1014y2 c1014y2) {
        copyOnWrite();
        o.L((o) this.instance, (Struct) c1014y2.k());
        return this;
    }

    public SendInputRequest$Builder addMessages(Content$Builder content$Builder) {
        copyOnWrite();
        o.F((o) this.instance, (C1808f) content$Builder.k());
        return this;
    }

    public SendInputRequest$Builder addMessages(int i, Content$Builder content$Builder) {
        copyOnWrite();
        o.E((o) this.instance, i, (C1808f) content$Builder.k());
        return this;
    }
}
