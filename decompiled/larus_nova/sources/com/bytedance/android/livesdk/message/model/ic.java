package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u000f8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ic;", "", "", "chest_id", "J", "getChest_id", "()J", "open_time", "getOpen_time", "Lcom/bytedance/android/livesdk/message/model/y6;", "task", "Lcom/bytedance/android/livesdk/message/model/y6;", "getTask", "()Lcom/bytedance/android/livesdk/message/model/y6;", "", "", "desc_list", "Ljava/util/List;", "getDesc_list", "()Ljava/util/List;", "Lcom/bytedance/android/livesdk/message/model/h;", "achieve_task_users", "getAchieve_task_users", "extra", "Ljava/lang/String;", "getExtra", "()Ljava/lang/String;", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ic implements vh7.h {

    @SerializedName("achieve_task_users")
    protected List<h> achieve_task_users;

    @SerializedName("chest_id")
    protected long chest_id;

    @SerializedName("desc_list")
    protected List<String> desc_list;

    @SerializedName("extra")
    protected String extra;

    @SerializedName("open_time")
    protected long open_time;

    @SerializedName("task")
    protected y6 task;

    public ic() {
        this.extra = "";
    }

    public ic(am3.g r100) {
        this.desc_list = new ArrayList();
        this.achieve_task_users = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L25;
        if (r102 != 1) goto L8;
        this.chest_id = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.open_time = r100.j();
        goto L3
    L10:
        if (r102 != 4) goto L12;
        this.task = new y6(r100);
        goto L3
    L12:
        if (r102 == 5) goto L20;
        if (r102 != 100) goto L16;
        this.extra = am3.h.c(r100);
        goto L3
    L16:
        if (r102 != 255) goto L17;
        List r103 = this.achieve_task_users;
        Object r104 = new h(r100);
    L21:
        r103.add(r104);
        goto L3
    L17:
        am3.h.e(r100);
        goto L3
    L20:
        r103 = this.desc_list;
        r104 = am3.h.c(r100);
        goto L21
    L25:
        r100.d(r101);
        if (this.extra != null) goto L48;
        this.extra = "";
        return;
    }
}
