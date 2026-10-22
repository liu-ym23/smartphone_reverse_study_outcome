package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\u001d\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011j\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/AudiencePanelItemSymbol;", "", "", "id", "J", "getId", "()J", "priority", "getPriority", "setPriority", "(J)V", "", "showOutside", "Z", "getShowOutside", "()Z", "setShowOutside", "(Z)V", "", "", "outsideName", "Ljava/util/List;", "getOutsideName", "()Ljava/util/List;", "setOutsideName", "(Ljava/util/List;)V", "insideName", "getInsideName", "setInsideName", "canShow", "getCanShow", "setCanShow", "PROFILE", "LIKE", "DISLIKE", "AT", "COPY", "MORE", OpenNetMethod.REPORT, "SECRET_CHAT", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AudiencePanelItemSymbol extends Enum<AudiencePanelItemSymbol> {
    public static final AudiencePanelItemSymbol AT = null;
    public static final AudiencePanelItemSymbol COPY = null;
    public static final AudiencePanelItemSymbol DISLIKE = null;
    public static final AudiencePanelItemSymbol LIKE = null;
    public static final AudiencePanelItemSymbol MORE = null;
    public static final AudiencePanelItemSymbol PROFILE = null;
    public static final AudiencePanelItemSymbol REPORT = null;
    public static final AudiencePanelItemSymbol SECRET_CHAT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudiencePanelItemSymbol[] f133389a = null;
    private boolean canShow;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f133390id;
    private List<String> insideName;
    private List<String> outsideName;
    private long priority;
    private boolean showOutside;

    public static AudiencePanelItemSymbol valueOf(String r100) {
        return (AudiencePanelItemSymbol) r27.a.a(AudiencePanelItemSymbol.class, r100);
    }

    public static AudiencePanelItemSymbol[] values() {
        return (AudiencePanelItemSymbol[]) f133389a.clone();
    }

    static {
        AudiencePanelItemSymbol r110 = new AudiencePanelItemSymbol("PROFILE", 0, 1, 1000, true, CollectionsKt.mutableListOf(new String[]{"资料卡"}), CollectionsKt.mutableListOf(new String[]{"资料卡"}));
        PROFILE = r110;
        AudiencePanelItemSymbol r100 = new AudiencePanelItemSymbol("LIKE", 1, 2, 900, true, CollectionsKt.mutableListOf(new String[]{"点赞"}), CollectionsKt.mutableListOf(new String[]{"点赞"}));
        LIKE = r100;
        AudiencePanelItemSymbol r101 = new AudiencePanelItemSymbol("DISLIKE", 2, 3, 800, true, CollectionsKt.mutableListOf(new String[]{"不喜欢"}), CollectionsKt.mutableListOf(new String[]{"不喜欢"}));
        DISLIKE = r101;
        AudiencePanelItemSymbol r102 = new AudiencePanelItemSymbol("AT", 3, 4, 700, true, CollectionsKt.mutableListOf(new String[]{"@TA", "回复"}), CollectionsKt.mutableListOf(new String[]{"@TA", "回复"}));
        AT = r102;
        AudiencePanelItemSymbol r103 = new AudiencePanelItemSymbol("COPY", 4, 5, 600, false, CollectionsKt.mutableListOf(new String[]{"复制"}), CollectionsKt.mutableListOf(new String[]{"复制该评论"}));
        COPY = r103;
        AudiencePanelItemSymbol r104 = new AudiencePanelItemSymbol("MORE", 5, 99, 500, true, CollectionsKt.mutableListOf(new String[]{"更多"}), CollectionsKt.mutableListOf(new String[]{"更多"}));
        MORE = r104;
        AudiencePanelItemSymbol r105 = new AudiencePanelItemSymbol(OpenNetMethod.REPORT, 6, 6, 400, false, CollectionsKt.mutableListOf(new String[]{"举报"}), CollectionsKt.mutableListOf(new String[]{"举报"}));
        REPORT = r105;
        AudiencePanelItemSymbol r106 = new AudiencePanelItemSymbol("SECRET_CHAT", 7, 7, 750, true, CollectionsKt.mutableListOf(new String[]{"对TA说", "回复"}), CollectionsKt.mutableListOf(new String[]{"对TA说", "回复"}));
        SECRET_CHAT = r106;
        f133389a = new AudiencePanelItemSymbol[]{r110, r100, r101, r102, r103, r104, r105, r106};
    }

    public final boolean getCanShow() {
        return this.canShow;
    }

    public final long getId() {
        return this.f133390id;
    }

    public final List<String> getInsideName() {
        return this.insideName;
    }

    public final List<String> getOutsideName() {
        return this.outsideName;
    }

    public final long getPriority() {
        return this.priority;
    }

    public final boolean getShowOutside() {
        return this.showOutside;
    }

    public final void setCanShow(boolean r100) {
        this.canShow = r100;
    }

    public final void setInsideName(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.insideName = r100;
    }

    public final void setOutsideName(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.outsideName = r100;
    }

    public final void setPriority(long r100) {
        this.priority = r100;
    }

    public final void setShowOutside(boolean r100) {
        this.showOutside = r100;
    }

    public AudiencePanelItemSymbol(String r100, int r101, long r102, long r103, boolean r104, List r105, List r106) {
        super(r100, r101);
        this.f133390id = r102;
        this.priority = r103;
        this.showOutside = r104;
        this.outsideName = r105;
        this.insideName = r106;
        this.canShow = true;
    }
}
