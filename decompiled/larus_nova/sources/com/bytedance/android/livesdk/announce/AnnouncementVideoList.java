package com.bytedance.android.livesdk.announce;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.anchor.AnnouncementVideoListResponse.Data")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/announce/AnnouncementVideoList;", "Ljava/io/Serializable;", "()V", "videoList", "", "Lcom/bytedance/android/livesdk/announce/AnnouncementVideo;", "getVideoList", "()Ljava/util/List;", "setVideoList", "(Ljava/util/List;)V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnnouncementVideoList implements Serializable, h {

    @SerializedName("video_list")
    protected List<AnnouncementVideo> videoList;

    public AnnouncementVideoList() {
        this.videoList = new ArrayList();
    }

    public final List<AnnouncementVideo> getVideoList() {
        return this.videoList;
    }

    public AnnouncementVideoList(g r100) {
        this.videoList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.videoList.add(new AnnouncementVideo(r100));
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
        if (this.videoList.isEmpty() == false) goto L19;
        this.videoList = new ArrayList();
        return;
    }

    public final void setVideoList(List<AnnouncementVideo> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.videoList = r100;
    }
}
