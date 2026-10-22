package com.byted.cast.common.utils;

import com.byted.cast.common.bean.DramaBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class CommandUtils {
    public CommandUtils() {
    }

    public static int getType(List<DramaBean> r100) {
        if (r100 != null) goto L5;
    L10:
        return 0;
    L5:
        if (r100.size() == 0) goto L10;
        if (((DramaBean) ListProtector.get(r100, 0)).getMediaAssetBean() == null) goto L10;
        return ((DramaBean) ListProtector.get(r100, 0)).getMediaAssetBean().getMediaType();
    }

    public static DramaBean[] transferDramaListToArray(List<DramaBean> r100) {
        if (r100 == null) goto L10;
        if (r100.size() == 0) goto L10;
        return (DramaBean[]) r100.toArray(new DramaBean[0]);
    L10:
        return new DramaBean[0];
    }
}
