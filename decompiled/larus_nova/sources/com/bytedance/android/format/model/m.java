package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/format/model/m;", "", "", "Lcom/bytedance/android/format/model/l;", "carouselList", "Ljava/util/List;", "getCarouselList", "()Ljava/util/List;", "", "startSetTime", "J", "getStartSetTime", "()J", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m {

    @SerializedName("carousel_components")
    private final List<l> carouselList;

    @SerializedName("start_set_time")
    private final long startSetTime;

    public m() {
    }
}
