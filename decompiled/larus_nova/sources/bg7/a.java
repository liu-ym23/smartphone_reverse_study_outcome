package bg7;

import com.bytedance.sync.model.DataType;

/* JADX INFO: loaded from: classes22.dex */
public final class a {
    public static DataType a(int r100) {
        DataType r101 = DataType.fromValue(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return DataType.ORIGIN;
    }
}
