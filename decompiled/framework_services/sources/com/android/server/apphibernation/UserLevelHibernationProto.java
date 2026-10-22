package com.android.server.apphibernation;

import android.util.Slog;
import android.util.proto.ProtoInputStream;
import android.util.proto.ProtoOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class UserLevelHibernationProto implements ProtoReadWriter<List<UserLevelState>> {
    private static final String TAG = "UserLevelHibernationProtoReadWriter";

    UserLevelHibernationProto() {
    }

    @Override // com.android.server.apphibernation.ProtoReadWriter
    public /* bridge */ /* synthetic */ List<UserLevelState> readFromProto(ProtoInputStream r1) throws IOException {
        return readFromProto2(r1);
    }

    @Override // com.android.server.apphibernation.ProtoReadWriter
    public /* bridge */ /* synthetic */ void writeToProto(ProtoOutputStream r1, List<UserLevelState> r2) {
        writeToProto2(r1, r2);
    }

    /* JADX INFO: renamed from: writeToProto, reason: avoid collision after fix types in other method */
    public void writeToProto2(ProtoOutputStream stream, List<UserLevelState> data) {
        int i = 0;
        int size = data.size();
    L3:
        if (i >= size) goto L6;
        long token = stream.start(2246267895809L);
        UserLevelState state = data.get(i);
        stream.write(1138166333441L, state.packageName);
        stream.write(1133871366146L, state.hibernated);
        stream.end(token);
        i = i + 1;
        goto L3
    }

    @Override // com.android.server.apphibernation.ProtoReadWriter
    /* JADX INFO: renamed from: readFromProto, reason: avoid collision after fix types in other method */
    public List<UserLevelState> readFromProto2(ProtoInputStream stream) throws IOException {
        List<UserLevelState> list = new ArrayList();
    L4:
        if (stream.nextField() == (-1)) goto L17;
        if (stream.getFieldNumber() != 1) goto L4;
        UserLevelState state = new UserLevelState();
        long token = stream.start(2246267895809L);
    L10:
        if (stream.nextField() == (-1)) goto L16;
        switch(stream.getFieldNumber()) {
            case 1: goto L15;
            case 2: goto L14;
            default: goto L13;
        };
    L14:
        state.hibernated = stream.readBoolean(1133871366146L);
        goto L10
    L15:
        state.packageName = stream.readString(1138166333441L);
        goto L10
    L13:
        Slog.w(TAG, "Undefined field in proto: " + stream.getFieldNumber());
        goto L10
    L16:
        stream.end(token);
        list.add(state);
        goto L4
    L17:
        return list;
    }
}
