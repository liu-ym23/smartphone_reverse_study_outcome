package com.bytedance.android.livesdkapi.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.GameImage")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/GameImage;", "", "()V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "rotation", "getRotation", "setRotation", "uri", "", "getUri", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "urls", "", "getUrls", "()Ljava/util/List;", "setUrls", "(Ljava/util/List;)V", "width", "getWidth", "setWidth", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameImage implements h {

    @SerializedName("height")
    protected int height;

    @SerializedName("rotation")
    protected int rotation;

    @SerializedName("uri")
    protected String uri;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    protected List<String> urls;

    @SerializedName("width")
    protected int width;

    public GameImage() {
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getRotation() {
        return this.rotation;
    }

    public final String getUri() {
        return this.uri;
    }

    public final List<String> getUrls() {
        return this.urls;
    }

    public final int getWidth() {
        return this.width;
    }

    public GameImage(g r100) {
        this.urls = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.urls.add(am3.h.c(r100));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.uri = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.height = (int) r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.width = (int) r100.j();
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.rotation = (int) r100.j();
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setRotation(int r100) {
        this.rotation = r100;
    }

    public final void setUri(String r100) {
        this.uri = r100;
    }

    public final void setUrls(List<String> r100) {
        this.urls = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }
}
