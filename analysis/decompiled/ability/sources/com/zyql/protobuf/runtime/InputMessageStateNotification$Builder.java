package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import u7.i;

/* loaded from: classes2.dex */
public final class InputMessageStateNotification$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ InputMessageStateNotification$Builder(int i) {
        this();
    }

    public InputMessageStateNotification$Builder clearDetails() {
        copyOnWrite();
        i.D((i) this.instance);
        return this;
    }

    public InputMessageStateNotification$Builder clearState() {
        copyOnWrite();
        i.E((i) this.instance);
        return this;
    }

    public String getDetails() {
        return ((i) this.instance).L();
    }

    public ByteString getDetailsBytes() {
        return ((i) this.instance).M();
    }

    public InputMessageStateNotification$State getState() {
        return ((i) this.instance).N();
    }

    public int getStateValue() {
        return ((i) this.instance).O();
    }

    public boolean hasDetails() {
        return ((i) this.instance).P();
    }

    public InputMessageStateNotification$Builder setDetails(String str) {
        copyOnWrite();
        i.F((i) this.instance, str);
        return this;
    }

    public InputMessageStateNotification$Builder setDetailsBytes(ByteString byteString) {
        copyOnWrite();
        i.G((i) this.instance, byteString);
        return this;
    }

    public InputMessageStateNotification$Builder setState(InputMessageStateNotification$State inputMessageStateNotification$State) {
        copyOnWrite();
        i.H((i) this.instance, inputMessageStateNotification$State);
        return this;
    }

    public InputMessageStateNotification$Builder setStateValue(int i) {
        copyOnWrite();
        i.I((i) this.instance, i);
        return this;
    }

    private InputMessageStateNotification$Builder() {
        super(i.DEFAULT_INSTANCE);
    }
}
