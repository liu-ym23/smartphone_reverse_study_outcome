package com.bytedance.android.shopping.anchorv3.commentv2.model;

import com.bytedance.android.shopping.anchorv3.comment.model.StatTagItem;
import com.bytedance.android.shopping.anchorv3.commentv2.monitor.CommentPerformanceMonitor;
import com.bytedance.android.shopping.anchorv3.commentv2.monitor.InteractionTypeEnum;
import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u001c\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/commentv2/model/CommentRefreshFrom;", "", "", "getPerfMobKey", "", "needUpdateTagVisibility", "needScrollToFirst", "Lcom/bytedance/android/shopping/anchorv3/comment/model/StatTagItem;", "statTagItem", "isLatest", "", "monitorInteractionStart", "needFetchTab", "", "refreshStartTime", "J", "", "from", "I", "getFrom", "()I", "setFrom", "(I)V", "SKU_CHANGED", "STAT_CHANGED", "TAG_CHANGED", "LOAD_MORE", "RE_SORT", "FROM_INIT", "FETCH_ALL", "REMOVE_NPS", "CLICK_MODE_SWITCH", "LIKE_STATUS_CHANGED", "TAB_CHANGED", FlowDoraWifiScene.OTHER, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CommentRefreshFrom extends Enum<CommentRefreshFrom> {
    public static final CommentRefreshFrom CLICK_MODE_SWITCH = null;
    public static final CommentRefreshFrom FETCH_ALL = null;
    public static final CommentRefreshFrom FROM_INIT = null;
    public static final CommentRefreshFrom LIKE_STATUS_CHANGED = null;
    public static final CommentRefreshFrom LOAD_MORE = null;
    public static final CommentRefreshFrom OTHER = null;
    public static final CommentRefreshFrom REMOVE_NPS = null;
    public static final CommentRefreshFrom RE_SORT = null;
    public static final CommentRefreshFrom SKU_CHANGED = null;
    public static final CommentRefreshFrom STAT_CHANGED = null;
    public static final CommentRefreshFrom TAB_CHANGED = null;
    public static final CommentRefreshFrom TAG_CHANGED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommentRefreshFrom[] f164723a = null;
    private int from;
    private final long refreshStartTime;

    public static CommentRefreshFrom valueOf(String r100) {
        return (CommentRefreshFrom) r27.a.a(CommentRefreshFrom.class, r100);
    }

    public static CommentRefreshFrom[] values() {
        return (CommentRefreshFrom[]) f164723a.clone();
    }

    static {
        CommentRefreshFrom r100 = new CommentRefreshFrom("SKU_CHANGED", 0, 0);
        SKU_CHANGED = r100;
        CommentRefreshFrom r101 = new CommentRefreshFrom("STAT_CHANGED", 1, 1);
        STAT_CHANGED = r101;
        CommentRefreshFrom r102 = new CommentRefreshFrom("TAG_CHANGED", 2, 2);
        TAG_CHANGED = r102;
        CommentRefreshFrom r103 = new CommentRefreshFrom("LOAD_MORE", 3, 3);
        LOAD_MORE = r103;
        CommentRefreshFrom r104 = new CommentRefreshFrom("RE_SORT", 4, 4);
        RE_SORT = r104;
        CommentRefreshFrom r105 = new CommentRefreshFrom("FROM_INIT", 5, 5);
        FROM_INIT = r105;
        CommentRefreshFrom r106 = new CommentRefreshFrom("FETCH_ALL", 6, 6);
        FETCH_ALL = r106;
        CommentRefreshFrom r107 = new CommentRefreshFrom("REMOVE_NPS", 7, 7);
        REMOVE_NPS = r107;
        CommentRefreshFrom r108 = new CommentRefreshFrom("CLICK_MODE_SWITCH", 8, 8);
        CLICK_MODE_SWITCH = r108;
        CommentRefreshFrom r109 = new CommentRefreshFrom("LIKE_STATUS_CHANGED", 9, 9);
        LIKE_STATUS_CHANGED = r109;
        CommentRefreshFrom r110 = new CommentRefreshFrom("TAB_CHANGED", 10, 10);
        TAB_CHANGED = r110;
        CommentRefreshFrom r111 = new CommentRefreshFrom(FlowDoraWifiScene.OTHER, 11, 11);
        OTHER = r111;
        f164723a = new CommentRefreshFrom[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111};
    }

    public final String getPerfMobKey() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.from);
        r100.append('-');
        r100.append(this.refreshStartTime);
        return r100.toString();
    }

    public final boolean needFetchTab() {
        int r100 = this.from;
        if (r100 != SKU_CHANGED.from) goto L5;
    L12:
        return true;
    L5:
        if (r100 == FROM_INIT.from) goto L12;
        if (r100 == FETCH_ALL.from) goto L12;
        if (r100 == OTHER.from) goto L12;
        return false;
    }

    public final boolean needScrollToFirst() {
        int r100 = this.from;
        if (r100 != LOAD_MORE.from) goto L5;
    L8:
        return false;
    L5:
        if (r100 == REMOVE_NPS.from) goto L8;
        return true;
    }

    public final boolean needUpdateTagVisibility() {
        int r100 = this.from;
        if (r100 != LOAD_MORE.from) goto L5;
    L8:
        return false;
    L5:
        if (r100 == REMOVE_NPS.from) goto L8;
        return true;
    }

    public final int getFrom() {
        return this.from;
    }

    public final void setFrom(int r100) {
        this.from = r100;
    }

    public final void monitorInteractionStart(StatTagItem r100, boolean r101) {
        InteractionTypeEnum.Companion.getClass();
        Intrinsics.checkNotNullParameter(this, "refreshFrom");
        int r102 = getFrom();
        CommentRefreshFrom r103 = STAT_CHANGED;
        String r104 = "";
        if (r102 != r103.getFrom()) goto L6;
        String r105 = InteractionTypeEnum.CLICK_TAB.getType();
    L21:
        int r106 = this.from;
        if (r106 != r103.from) goto L24;
    L25:
        if (r100 == null) goto L30;
        String r107 = r100.getName();
        if (r107 == null) goto L30;
        r104 = r107;
    L30:
        CommentPerformanceMonitor.a r108 = CommentPerformanceMonitor.f164734i;
        String r109 = getPerfMobKey();
        r108.getClass();
        CommentPerformanceMonitor r110 = CommentPerformanceMonitor.a.a(r109);
        Intrinsics.checkNotNullParameter(r105, "interactionType");
        Intrinsics.checkNotNullParameter(r104, "interactionContent");
        r110.f164737c = System.currentTimeMillis();
        r110.f164735a = r105;
        r110.f164736b = r104;
        return;
    L24:
        if (r106 != TAG_CHANGED.from) goto L30;
    L6:
        if (r102 != TAG_CHANGED.getFrom()) goto L9;
        r105 = InteractionTypeEnum.CLICK_IMPRESSION.getType();
        goto L21
    L9:
        if (r102 != SKU_CHANGED.getFrom()) goto L12;
        r105 = InteractionTypeEnum.CLICK_SKU.getType();
        goto L21
    L12:
        if (r102 != RE_SORT.getFrom()) goto L18;
        if (r101 == false) goto L15;
        InteractionTypeEnum r111 = InteractionTypeEnum.CLICK_LATEST_BTN;
    L16:
        r105 = r111.getType();
        goto L21
    L15:
        r111 = InteractionTypeEnum.CLICK_COMPLEX_BTN;
        goto L16
    L18:
        if (r102 != LOAD_MORE.getFrom()) goto L20;
        r105 = InteractionTypeEnum.LOAD_MORE.getType();
        goto L21
    L20:
        r105 = "";
        goto L21
    }

    public CommentRefreshFrom(String r100, int r101, int r102) {
        super(r100, r101);
        this.from = r102;
        this.refreshStartTime = System.currentTimeMillis();
    }

    public static /* synthetic */ void monitorInteractionStart$default(CommentRefreshFrom r100, StatTagItem r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = false;
    L8:
        r100.monitorInteractionStart(r101, r102);
    }
}
