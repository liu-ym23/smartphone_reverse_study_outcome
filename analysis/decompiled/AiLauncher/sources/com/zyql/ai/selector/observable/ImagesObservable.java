package com.zyql.ai.selector.observable;

import com.zyql.ai.selector.entity.LocalMedia;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class ImagesObservable {
    private static ImagesObservable sObserver;
    private List<LocalMedia> mData = new ArrayList();

    public static ImagesObservable getInstance() {
        if (sObserver == null) {
            synchronized (ImagesObservable.class) {
                try {
                    if (sObserver == null) {
                        sObserver = new ImagesObservable();
                    }
                } finally {
                }
            }
        }
        return sObserver;
    }

    public void clearPreviewMediaData() {
        this.mData.clear();
    }

    public List<LocalMedia> readPreviewMediaData() {
        return this.mData;
    }

    public void savePreviewMediaData(List<LocalMedia> list) {
        this.mData = list;
    }
}
