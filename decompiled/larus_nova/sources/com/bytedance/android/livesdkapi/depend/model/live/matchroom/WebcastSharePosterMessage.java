package com.bytedance.android.livesdkapi.depend.model.live.matchroom;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.SharePosterMessage")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/WebcastSharePosterMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/WebcastSharePosterMessage$PosterData;", "posterData", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/WebcastSharePosterMessage$PosterData;", "<init>", "()V", "PosterData", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WebcastSharePosterMessage extends o0 implements h {

    @SerializedName("data")
    public PosterData posterData;

    @ProtoMessage("webcast.im.SharePosterMessage.PosterData")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/WebcastSharePosterMessage$PosterData;", "", "()V", "decorators", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "getDecorators", "()Ljava/util/List;", "setDecorators", "(Ljava/util/List;)V", "posters", "getPosters", "setPosters", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PosterData implements h {

        @SerializedName("decorator")
        protected List<? extends ImageModel> decorators;

        @SerializedName("poster")
        protected List<? extends ImageModel> posters;

        public PosterData() {
        }

        public PosterData(g r100) {
            this.posters = new ArrayList();
            this.decorators = new ArrayList();
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L13;
            if (r102 == 1) goto L11;
            if (r102 != 2) goto L9;
            List<? extends ImageModel> r103 = this.decorators;
        L12:
            r103.add(x.a(r100));
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L11:
            r103 = this.posters;
            goto L12
        L13:
            r100.d(r101);
        }

        public final List<ImageModel> getDecorators() {
            return this.decorators;
        }

        public final List<ImageModel> getPosters() {
            return this.posters;
        }

        public final void setDecorators(List<? extends ImageModel> r100) {
            this.decorators = r100;
        }

        public final void setPosters(List<? extends ImageModel> r100) {
            this.posters = r100;
        }
    }

    public WebcastSharePosterMessage() {
        this.type = MessageType.SHARE_POSTER_MESSAGE;
    }

    public WebcastSharePosterMessage(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.posterData = new PosterData(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        this.type = MessageType.SHARE_POSTER_MESSAGE;
    }
}
