package com.bytedance.android.livesdk.announce;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.appointment.AnnouncementAnchorGetResponse.FansGroupInfoStruct")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/announce/AnnouncementFanGroupInfo;", "Ljava/io/Serializable;", "()V", "groupId", "", "groupNumber", "imageUrl", "", "name", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnnouncementFanGroupInfo implements Serializable, h {

    @SerializedName("group_id")
    public long groupId;

    @SerializedName("group_number")
    public long groupNumber;

    @SerializedName("image_url")
    public String imageUrl;

    @SerializedName("name")
    public String name;

    public AnnouncementFanGroupInfo() {
        this.groupId = -1;
        this.groupNumber = -1;
    }

    public AnnouncementFanGroupInfo(g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L17;
        if (r103 != 1) goto L7;
        this.groupId = r100.j();
        r102 = r102 | 1;
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.name = am3.h.c(r100);
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.imageUrl = am3.h.c(r100);
        goto L3
    L11:
        if (r103 != 4) goto L12;
        this.groupNumber = r100.j();
        r102 = r102 | 2;
        goto L3
    L12:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L21;
        this.groupId = -1;
    L21:
        if ((r102 & 2) != 0) goto L39;
        this.groupNumber = -1;
        return;
    }
}
