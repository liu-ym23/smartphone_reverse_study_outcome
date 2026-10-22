package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.NotifyMessage.Extra")
public class RoomNotifyMessageExtra {

    @SerializedName("background")
    Background background;

    @SerializedName("duration")
    long duration;

    @SerializedName("content_list")
    public qg highlightInfo;

    @SerializedName("need_gift_frequency")
    boolean needGiftCarnivalFrequency;

    @SerializedName("params")
    Map<String, String> params;

    @IgnoreProtoFieldCheck
    @ProtoMessage("webcast.im.NotifyMessage.Background")
    public static class Background extends ImageModel {
        public Background() {
        }

        public static /* synthetic */ Background access$000(ImageModel r100) {
            return fromImageModel(r100);
        }

        private static Background fromImageModel(ImageModel r100) {
            Background r101 = new Background();
            if (r100 != null) goto L5;
            return r101;
        L5:
            r101.width = r100.width;
            r101.height = r100.height;
            r101.setUrls(r100.getUrls());
            r101.setUri(r100.getUri());
            return r101;
        }
    }

    public RoomNotifyMessageExtra() {
        this.needGiftCarnivalFrequency = false;
    }

    public final Background a() {
        return this.background;
    }

    public final long b() {
        return this.duration;
    }

    public final Map<String, String> c() {
        return this.params;
    }

    public final void d(ImageModel r100) {
        this.background = Background.access$000(r100);
    }

    public final void e(long r100) {
        this.duration = r100;
    }
}
