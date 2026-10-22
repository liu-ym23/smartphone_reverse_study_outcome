package com.stepos.core.ota.deepbinder;

import androidx.compose.runtime.g;
import b7.l;
import fc.f;
import java.io.File;
import java.util.Set;
import kotlin.collections.EmptySet;
import kotlin.io.FileWalkDirection;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaDeepBinderServiceImplKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final long totalBytes(File file, Set<String> set) {
        long length = 0;
        if (!file.exists()) {
            return 0L;
        }
        if (file.isFile()) {
            return file.length();
        }
        wb.c cVarB0 = wb.d.b0(file);
        f.a aVar = new f.a(new fc.f(new wb.c(cVarB0.f13655a, FileWalkDirection.f10069a, new l(set, 1)), new g(set, 14)));
        while (aVar.hasNext()) {
            length += ((File) aVar.next()).length();
        }
        return length;
    }

    public static long totalBytes$default(File file, Set set, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            set = EmptySet.f10003a;
        }
        return totalBytes(file, set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean totalBytes$lambda$0(Set set, File dir) {
        kotlin.jvm.internal.g.f(dir, "dir");
        return !set.contains(dir.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean totalBytes$lambda$1(Set set, File it) {
        kotlin.jvm.internal.g.f(it, "it");
        return it.isFile() && !set.contains(it.getName());
    }
}
