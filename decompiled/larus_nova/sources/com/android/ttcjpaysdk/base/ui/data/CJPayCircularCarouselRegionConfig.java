package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CJPayCircularCarouselRegionConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "animation_time", "", "component_list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo$CJCircularCarouselComponent;", "Lkotlin/collections/ArrayList;", "interval_time", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayCircularCarouselRegionConfig implements CJPayObject, Serializable {
    public long animation_time;
    public ArrayList<CJPayPayInfo.CJCircularCarouselComponent> component_list;
    public long interval_time;

    public CJPayCircularCarouselRegionConfig() {
        this.component_list = new ArrayList();
    }
}
