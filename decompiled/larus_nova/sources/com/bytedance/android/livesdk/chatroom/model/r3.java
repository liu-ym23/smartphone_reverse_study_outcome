package com.bytedance.android.livesdk.chatroom.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/r3;", "", "", "index", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setIndex", "(I)V", "", "Lcom/bytedance/android/livesdk/chatroom/model/s3;", "itemList", "Ljava/util/List;", "c", "()Ljava/util/List;", "setItemList", "(Ljava/util/List;)V", "", "intervalDuration", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "setIntervalDuration", "(Ljava/lang/Long;)V", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r3 {

    @SerializedName("index")
    private int index;

    @SerializedName("interval_duration")
    private Long intervalDuration;

    @SerializedName("item_list")
    private List<s3> itemList;

    public r3() {
        this.index = -1;
    }

    public final int a() {
        return this.index;
    }

    public final Long b() {
        return this.intervalDuration;
    }

    public final List<s3> c() {
        return this.itemList;
    }
}
