package com.android.server.pm;

import android.content.pm.SharedLibraryInfo;
import android.util.proto.ProtoOutputStream;
import com.android.server.utils.WatchedArrayMap;
import com.android.server.utils.WatchedLongSparseArray;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public interface SharedLibrariesRead {
    void dump(PrintWriter r1, DumpState r2);

    void dumpProto(ProtoOutputStream r1);

    WatchedArrayMap<String, WatchedLongSparseArray<SharedLibraryInfo>> getAll();

    SharedLibraryInfo getSharedLibraryInfo(String r1, long r2);

    WatchedLongSparseArray<SharedLibraryInfo> getSharedLibraryInfos(String r1);

    WatchedLongSparseArray<SharedLibraryInfo> getStaticLibraryInfos(String r1);
}
