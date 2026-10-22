package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0016\u0010\u000f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSItemBar;", "", "Lpy/k;", "iconDark", "Lpy/k;", "iconLight", "", "title", "Ljava/lang/String;", "seperator", "detail", "", "watchPv", "J", "watchInfoHeat", "collectionId", "", "tabId", "I", "contentType", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSItemBar implements h {

    @SerializedName("collection_id")
    public long collectionId;

    @SerializedName("content_type")
    public String contentType;

    @SerializedName("detail")
    public String detail;

    @SerializedName("icon_dark")
    public k iconDark;

    @SerializedName("icon_light")
    public k iconLight;

    @SerializedName("seperator")
    public String seperator;

    @SerializedName("tab_id")
    public int tabId;

    @SerializedName("title")
    public String title;

    @SerializedName("watch_info_heat")
    public String watchInfoHeat;

    @SerializedName("watch_info_pv")
    public long watchPv;

    public VSItemBar() {
        this.title = "";
        this.seperator = "";
        this.detail = "";
        this.watchInfoHeat = "";
        this.contentType = "";
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public VSItemBar(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L17;
        switch(r102) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        this.contentType = am3.h.c(r100);
        goto L3
    L8:
        this.tabId = r100.i();
        goto L3
    L9:
        this.collectionId = r100.j();
        goto L3
    L10:
        this.watchInfoHeat = am3.h.c(r100);
        goto L3
    L11:
        this.watchPv = r100.j();
        goto L3
    L12:
        this.detail = am3.h.c(r100);
        goto L3
    L13:
        this.seperator = am3.h.c(r100);
        goto L3
    L14:
        this.title = am3.h.c(r100);
        goto L3
    L15:
        this.iconLight = f.a(r100, k.class);
        goto L3
    L16:
        this.iconDark = f.a(r100, k.class);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if (this.title != null) goto L21;
        this.title = "";
    L21:
        if (this.seperator != null) goto L24;
        this.seperator = "";
    L24:
        if (this.detail != null) goto L27;
        this.detail = "";
    L27:
        if (this.watchInfoHeat != null) goto L30;
        this.watchInfoHeat = "";
    L30:
        if (this.contentType != null) goto L57;
        this.contentType = "";
        return;
    }
}
