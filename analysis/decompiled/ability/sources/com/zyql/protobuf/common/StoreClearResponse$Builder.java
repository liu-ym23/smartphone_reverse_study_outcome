package com.zyql.protobuf.common;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import q7.O;

/* loaded from: classes2.dex */
public final class StoreClearResponse$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ StoreClearResponse$Builder(int i) {
        this();
    }

    public StoreClearResponse$Builder clearDeletedCount() {
        copyOnWrite();
        O.D((O) this.instance);
        return this;
    }

    public int getDeletedCount() {
        return ((O) this.instance).G();
    }

    public StoreClearResponse$Builder setDeletedCount(int i) {
        copyOnWrite();
        O.E((O) this.instance, i);
        return this;
    }

    private StoreClearResponse$Builder() {
        super(O.DEFAULT_INSTANCE);
    }
}
