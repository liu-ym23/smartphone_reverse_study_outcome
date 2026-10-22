package com.bytedance.android.ecom.bcm.track.impl.setting;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ecom/bcm/track/impl/setting/a;", "", "", "switch", "I", "getSwitch", "()I", DocumentType.MINUTES_NAME, "getMinutes", "delayMinutes", "getDelayMinutes", "", "", "btmPageList", "Ljava/util/List;", "getBtmPageList", "()Ljava/util/List;", "bstFormInfoList", "getBstFormInfoList", "<init>", "()V", "bcm-track-impl_release"}, k = 1, mv = {1, 4, 0})
public final class a {

    @SerializedName("bst_form_info_list")
    private final List<String> bstFormInfoList;

    @SerializedName("btm_page_list")
    private final List<String> btmPageList;

    @SerializedName("delay_minutes")
    private final int delayMinutes;

    @SerializedName(DocumentType.MINUTES_NAME)
    private final int minutes;

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    @SerializedName("switch")
    private final int f66switch;

    public a() {
        this.f66switch = 1;
        this.minutes = 10;
        this.delayMinutes = 1;
        this.btmPageList = CollectionsKt.emptyList();
        this.bstFormInfoList = CollectionsKt.emptyList();
    }
}
