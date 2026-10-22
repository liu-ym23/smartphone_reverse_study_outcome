package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/a1;", "", "", "Lcom/bytedance/android/live/ktv/common/model/api/z0;", "songList", "Ljava/util/List;", "d", "()Ljava/util/List;", "setSongList", "(Ljava/util/List;)V", "", "hasMore", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setHasMore", "(Z)V", "", "nextCursor", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setNextCursor", "(Ljava/lang/String;)V", "", "totalCount", "J", "e", "()J", "setTotalCount", "(J)V", "Lcom/bytedance/android/live/ktv/common/model/api/k0;", "multiChorusSongListItem", "Lcom/bytedance/android/live/ktv/common/model/api/k0;", "b", "()Lcom/bytedance/android/live/ktv/common/model/api/k0;", "setMultiChorusSongListItem", "(Lcom/bytedance/android/live/ktv/common/model/api/k0;)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a1 implements vh7.h {

    @SerializedName("has_more")
    protected boolean hasMore;

    @SerializedName("multi_chorus_song_list_item")
    protected k0 multiChorusSongListItem;

    @SerializedName("next_cursor")
    protected String nextCursor;

    @SerializedName("items")
    protected List<z0> songList;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT)
    protected long totalCount;

    public a1() {
        this.songList = new ArrayList();
        this.nextCursor = "";
    }

    public final boolean a() {
        return this.hasMore;
    }

    public final k0 b() {
        return this.multiChorusSongListItem;
    }

    public final String c() {
        return this.nextCursor;
    }

    public final List<z0> d() {
        return this.songList;
    }

    public final long e() {
        return this.totalCount;
    }

    public a1(am3.g r100) {
        this.songList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.songList.add(new z0(r100));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.hasMore = am3.h.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.nextCursor = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.totalCount = r100.j();
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.multiChorusSongListItem = new k0(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        if (this.songList.isEmpty() == false) goto L25;
        this.songList = new ArrayList();
    L25:
        if (this.nextCursor != null) goto L46;
        this.nextCursor = "";
        return;
    }
}
