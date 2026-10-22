package com.bytedance.android.livesdkapi.depend.model.live.matchroom;

import am3.g;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/SharePosterInfo;", "", "()V", "posterData", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/SharePosterInfo$PosterData;", "getPosterData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/SharePosterInfo$PosterData;", "setPosterData", "(Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/SharePosterInfo$PosterData;)V", "PosterData", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SharePosterInfo implements h {

    @SerializedName("data")
    protected PosterData posterData;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/SharePosterInfo$PosterData;", "", "", "Lpy/k;", "posters", "Ljava/util/List;", "getPosters", "()Ljava/util/List;", "setPosters", "(Ljava/util/List;)V", "decorators", "getDecorators", "setDecorators", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PosterData implements h {

        @SerializedName("decorator")
        protected List<? extends k> decorators;

        @SerializedName("poster")
        protected List<? extends k> posters;

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
            List<? extends k> r103 = this.decorators;
        L12:
            r103.add(f.a(r100, k.class));
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

        public final List<k> getDecorators() {
            return this.decorators;
        }

        public final List<k> getPosters() {
            return this.posters;
        }

        public final void setDecorators(List<? extends k> r100) {
            this.decorators = r100;
        }

        public final void setPosters(List<? extends k> r100) {
            this.posters = r100;
        }
    }

    public SharePosterInfo() {
    }

    public SharePosterInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.posterData = new PosterData(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }

    public final PosterData getPosterData() {
        return this.posterData;
    }

    public final void setPosterData(PosterData r100) {
        this.posterData = r100;
    }
}
