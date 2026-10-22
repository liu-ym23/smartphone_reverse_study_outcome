package com.zyql.protobuf.omni;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import t7.k;

/* loaded from: classes2.dex */
public final class SubscribeTaskRequest$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ SubscribeTaskRequest$Builder(int i) {
        this();
    }

    public SubscribeTaskRequest$Builder clearNeedTts() {
        copyOnWrite();
        k.D((k) this.instance);
        return this;
    }

    public SubscribeTaskRequest$Builder clearTaskEventId() {
        copyOnWrite();
        k.E((k) this.instance);
        return this;
    }

    public SubscribeTaskRequest$Builder clearTaskId() {
        copyOnWrite();
        k.F((k) this.instance);
        return this;
    }

    public boolean getNeedTts() {
        return ((k) this.instance).M();
    }

    public String getTaskEventId() {
        return ((k) this.instance).N();
    }

    public ByteString getTaskEventIdBytes() {
        return ((k) this.instance).O();
    }

    public String getTaskId() {
        return ((k) this.instance).P();
    }

    public ByteString getTaskIdBytes() {
        return ((k) this.instance).Q();
    }

    public SubscribeTaskRequest$Builder setNeedTts(boolean z10) {
        copyOnWrite();
        k.G((k) this.instance, z10);
        return this;
    }

    public SubscribeTaskRequest$Builder setTaskEventId(String str) {
        copyOnWrite();
        k.H((k) this.instance, str);
        return this;
    }

    public SubscribeTaskRequest$Builder setTaskEventIdBytes(ByteString byteString) {
        copyOnWrite();
        k.I((k) this.instance, byteString);
        return this;
    }

    public SubscribeTaskRequest$Builder setTaskId(String str) {
        copyOnWrite();
        k.J((k) this.instance, str);
        return this;
    }

    public SubscribeTaskRequest$Builder setTaskIdBytes(ByteString byteString) {
        copyOnWrite();
        k.K((k) this.instance, byteString);
        return this;
    }

    private SubscribeTaskRequest$Builder() {
        super(k.DEFAULT_INSTANCE);
    }
}
