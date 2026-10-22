package com.bytedance.android.livesdk.announce;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.anchor.AnnouncementVideoListResponse.Video")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/announce/AnnouncementVideo;", "Ljava/io/Serializable;", "()V", "coverUrls", "", "", "getCoverUrls", "()Ljava/util/List;", "setCoverUrls", "(Ljava/util/List;)V", "itemId", "", "getItemId", "()J", "setItemId", "(J)V", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnnouncementVideo implements Serializable, h {

    @SerializedName("cover_urls")
    protected List<String> coverUrls;

    @SerializedName("item_id")
    protected long itemId;
    private boolean selected;

    public AnnouncementVideo() {
    }

    public final List<String> getCoverUrls() {
        return this.coverUrls;
    }

    public final long getItemId() {
        return this.itemId;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public AnnouncementVideo(g r100) {
        this.coverUrls = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.itemId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.coverUrls.add(am3.h.c(r100));
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final void setCoverUrls(List<String> r100) {
        this.coverUrls = r100;
    }

    public final void setItemId(long r100) {
        this.itemId = r100;
    }

    public final void setSelected(boolean r100) {
        this.selected = r100;
    }
}
