package com.zyql.protobuf.task.engine;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import w7.e;

/* loaded from: classes2.dex */
public final class TaskDealReq$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ TaskDealReq$Builder(int i) {
        this();
    }

    public TaskDealReq$Builder clearCommond() {
        copyOnWrite();
        e.D((e) this.instance);
        return this;
    }

    public TaskDealReq$Builder clearTaskId() {
        copyOnWrite();
        e.E((e) this.instance);
        return this;
    }

    public String getCommond() {
        return ((e) this.instance).K();
    }

    public ByteString getCommondBytes() {
        return ((e) this.instance).L();
    }

    public String getTaskId() {
        return ((e) this.instance).M();
    }

    public ByteString getTaskIdBytes() {
        return ((e) this.instance).N();
    }

    public TaskDealReq$Builder setCommond(String str) {
        copyOnWrite();
        e.F((e) this.instance, str);
        return this;
    }

    public TaskDealReq$Builder setCommondBytes(ByteString byteString) {
        copyOnWrite();
        e.G((e) this.instance, byteString);
        return this;
    }

    public TaskDealReq$Builder setTaskId(String str) {
        copyOnWrite();
        e.H((e) this.instance, str);
        return this;
    }

    public TaskDealReq$Builder setTaskIdBytes(ByteString byteString) {
        copyOnWrite();
        e.I((e) this.instance, byteString);
        return this;
    }

    private TaskDealReq$Builder() {
        super(e.DEFAULT_INSTANCE);
    }
}
