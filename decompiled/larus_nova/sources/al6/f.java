package al6;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import zk6.n;

/* JADX INFO: loaded from: classes20.dex */
public final class f implements n {
    public f() {
    }

    @Override // zk6.n
    public final bl6.f b(List<bl6.f> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.SEGMENT_TABLE_NAME);
        int r102 = r100.size() - 1;
        if (r102 >= 0) goto L5;
        return null;
    L5:
        ((bl6.f) ListProtector.get(r100, (0 + r102) >>> 1)).getClass();
        throw null;
    }

    @Override // zk6.n
    public final List<bl6.f> a(List<bl6.f> r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.SEGMENT_TABLE_NAME);
        int r103 = r100.size() - 1;
        int r104 = r100.size();
        if (r103 >= 0) goto L9;
        int r105 = Math.max(0, r104 - 1);
        ArrayList r106 = new ArrayList();
        if (r105 < r100.size()) goto L7;
        return r106;
    L7:
        ((bl6.f) ListProtector.get(r100, r105)).getClass();
        throw null;
    L9:
        ((bl6.f) ListProtector.get(r100, (0 + r103) >>> 1)).getClass();
        throw null;
    }
}
