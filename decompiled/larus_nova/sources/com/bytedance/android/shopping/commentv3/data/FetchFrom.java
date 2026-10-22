package com.bytedance.android.shopping.commentv3.data;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.bytedance.android.shopping.commentv3.utils.InteractionPerfMonitor;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0001\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/FetchFrom;", "", "", "getPerfMobKey", "", "needUpdateTagVisibility", "needScrollToFirst", "isLatest", "", "monitorInteractionStart", "needFetchTab", "", "refreshStartTime", "J", "", "from", "I", "getFrom", "()I", "setFrom", "(I)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "SKU_SWITCH", "TAB_CLICK", "LOAD_MORE", "RE_SORT", ErrorCode.INIT, "FETCH_ALL", "REMOVE_NPS", "LIKE_CLICKED", "FUSION", FlowDoraWifiScene.OTHER, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FetchFrom extends Enum<FetchFrom> {
    public static final a Companion = null;
    public static final FetchFrom FETCH_ALL = null;
    public static final FetchFrom FUSION = null;
    public static final FetchFrom INIT = null;
    public static final FetchFrom LIKE_CLICKED = null;
    public static final FetchFrom LOAD_MORE = null;
    public static final FetchFrom OTHER = null;
    public static final FetchFrom REMOVE_NPS = null;
    public static final FetchFrom RE_SORT = null;
    public static final FetchFrom SKU_SWITCH = null;
    public static final FetchFrom TAB_CLICK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FetchFrom[] f172722a = null;
    private int from;
    private final long refreshStartTime;

    public static final class a {
        public a() {
        }

        public static FetchFrom a(int r100) {
            FetchFrom r101 = FetchFrom.SKU_SWITCH;
            if (r100 == r101.getFrom()) goto L28;
            FetchFrom r102 = FetchFrom.TAB_CLICK;
            if (r100 == r102.getFrom()) goto L29;
            FetchFrom r103 = FetchFrom.LOAD_MORE;
            if (r100 == r103.getFrom()) goto L30;
            FetchFrom r104 = FetchFrom.RE_SORT;
            if (r100 == r104.getFrom()) goto L31;
            FetchFrom r105 = FetchFrom.INIT;
            if (r100 == r105.getFrom()) goto L32;
            FetchFrom r106 = FetchFrom.FETCH_ALL;
            if (r100 == r106.getFrom()) goto L33;
            FetchFrom r107 = FetchFrom.REMOVE_NPS;
            if (r100 == r107.getFrom()) goto L34;
            FetchFrom r108 = FetchFrom.FUSION;
            if (r100 != r108.getFrom()) goto L27;
            return r108;
        L27:
            return FetchFrom.OTHER;
        L34:
            return r107;
        L33:
            return r106;
        L32:
            return r105;
        L31:
            return r104;
        L30:
            return r103;
        L29:
            return r102;
        L28:
            return r101;
        }
    }

    public static FetchFrom valueOf(String r100) {
        return (FetchFrom) r27.a.a(FetchFrom.class, r100);
    }

    public static FetchFrom[] values() {
        return (FetchFrom[]) f172722a.clone();
    }

    static {
        FetchFrom r100 = new FetchFrom("SKU_SWITCH", 0, 1);
        SKU_SWITCH = r100;
        FetchFrom r101 = new FetchFrom("TAB_CLICK", 1, 2);
        TAB_CLICK = r101;
        FetchFrom r102 = new FetchFrom("LOAD_MORE", 2, 3);
        LOAD_MORE = r102;
        FetchFrom r103 = new FetchFrom("RE_SORT", 3, 4);
        RE_SORT = r103;
        FetchFrom r104 = new FetchFrom(ErrorCode.INIT, 4, 5);
        INIT = r104;
        FetchFrom r105 = new FetchFrom("FETCH_ALL", 5, 6);
        FETCH_ALL = r105;
        FetchFrom r106 = new FetchFrom("REMOVE_NPS", 6, 7);
        REMOVE_NPS = r106;
        FetchFrom r107 = new FetchFrom("LIKE_CLICKED", 7, 8);
        LIKE_CLICKED = r107;
        FetchFrom r108 = new FetchFrom("FUSION", 8, 9);
        FUSION = r108;
        FetchFrom r109 = new FetchFrom(FlowDoraWifiScene.OTHER, 9, 20);
        OTHER = r109;
        f172722a = new FetchFrom[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
        Companion = new a();
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
        if (r100 != SKU_SWITCH.from) goto L5;
    L14:
        return true;
    L5:
        if (r100 == INIT.from) goto L14;
        if (r100 == FETCH_ALL.from) goto L14;
        if (r100 == OTHER.from) goto L14;
        if (r100 == FUSION.from) goto L14;
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

    public final void monitorInteractionStart(boolean r100) {
        InteractionTypeEnum.Companion.getClass();
        Intrinsics.checkNotNullParameter(this, "refreshFrom");
        int r101 = getFrom();
        if (r101 != TAB_CLICK.getFrom()) goto L6;
        String r102 = InteractionTypeEnum.CLICK_IMPRESSION.getType();
    L18:
        InteractionPerfMonitor.a r103 = InteractionPerfMonitor.f172918j;
        String r104 = getPerfMobKey();
        r103.getClass();
        InteractionPerfMonitor r105 = InteractionPerfMonitor.a.a(r104);
        Intrinsics.checkNotNullParameter(r102, "interactionType");
        Intrinsics.checkNotNullParameter("", "interactionContent");
        r105.f172921c = System.currentTimeMillis();
        r105.f172919a = r102;
        r105.f172920b = "";
        return;
    L6:
        if (r101 != SKU_SWITCH.getFrom()) goto L9;
        r102 = InteractionTypeEnum.CLICK_SKU.getType();
        goto L18
    L9:
        if (r101 != RE_SORT.getFrom()) goto L15;
        if (r100 == false) goto L12;
        InteractionTypeEnum r106 = InteractionTypeEnum.CLICK_LATEST_BTN;
    L13:
        r102 = r106.getType();
        goto L18
    L12:
        r106 = InteractionTypeEnum.CLICK_COMPLEX_BTN;
        goto L13
    L15:
        if (r101 != LOAD_MORE.getFrom()) goto L17;
        r102 = InteractionTypeEnum.LOAD_MORE.getType();
        goto L18
    L17:
        r102 = "";
        goto L18
    }

    public final void setFrom(int r100) {
        this.from = r100;
    }

    public FetchFrom(String r100, int r101, int r102) {
        super(r100, r101);
        this.from = r102;
        this.refreshStartTime = System.currentTimeMillis();
    }

    public static /* synthetic */ void monitorInteractionStart$default(FetchFrom r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = false;
    L5:
        r100.monitorInteractionStart(r101);
    }
}
