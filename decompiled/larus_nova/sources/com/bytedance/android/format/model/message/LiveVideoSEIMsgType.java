package com.bytedance.android.format.model.message;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/format/model/message/LiveVideoSEIMsgType;", "", "", "type", "I", "getType", "()I", "LiveVideoSEIMsgType_Invalid", "LiveVideoSEIMsgType_Subtitle", "LiveVideoSEIMsgType_Product", "LiveVideoSEIMsgType_ProductFlush", "LiveVideoSEIMsgType_LiveContent", "LiveVideoSEIMsgType_LiveContentEnd", "LiveVideoSEIMSgType_SentenceEnd", "LiveVideoSEIMsgType_Action", "LiveVideoSEIMsgType_GuideLike", "LiveVideoSEIMsgType_SugDisplay", "LiveVideoSEIMsgType_CarouselComponents", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveVideoSEIMsgType extends Enum<LiveVideoSEIMsgType> {
    public static final LiveVideoSEIMsgType LiveVideoSEIMSgType_SentenceEnd = null;
    public static final LiveVideoSEIMsgType LiveVideoSEIMsgType_Action = null;
    public static final LiveVideoSEIMsgType LiveVideoSEIMsgType_CarouselComponents = null;
    public static final LiveVideoSEIMsgType LiveVideoSEIMsgType_GuideLike = null;
    public static final LiveVideoSEIMsgType LiveVideoSEIMsgType_Invalid = null;
    public static final LiveVideoSEIMsgType LiveVideoSEIMsgType_LiveContent = null;
    public static final LiveVideoSEIMsgType LiveVideoSEIMsgType_LiveContentEnd = null;
    public static final LiveVideoSEIMsgType LiveVideoSEIMsgType_Product = null;
    public static final LiveVideoSEIMsgType LiveVideoSEIMsgType_ProductFlush = null;
    public static final LiveVideoSEIMsgType LiveVideoSEIMsgType_Subtitle = null;
    public static final LiveVideoSEIMsgType LiveVideoSEIMsgType_SugDisplay = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveVideoSEIMsgType[] f51361a = null;
    private final int type;

    public static LiveVideoSEIMsgType valueOf(String r100) {
        return (LiveVideoSEIMsgType) a.a(LiveVideoSEIMsgType.class, r100);
    }

    public static LiveVideoSEIMsgType[] values() {
        return (LiveVideoSEIMsgType[]) f51361a.clone();
    }

    static {
        LiveVideoSEIMsgType r100 = new LiveVideoSEIMsgType("LiveVideoSEIMsgType_Invalid", 0, 0);
        LiveVideoSEIMsgType_Invalid = r100;
        LiveVideoSEIMsgType r101 = new LiveVideoSEIMsgType("LiveVideoSEIMsgType_Subtitle", 1, 1);
        LiveVideoSEIMsgType_Subtitle = r101;
        LiveVideoSEIMsgType r102 = new LiveVideoSEIMsgType("LiveVideoSEIMsgType_Product", 2, 4);
        LiveVideoSEIMsgType_Product = r102;
        LiveVideoSEIMsgType r103 = new LiveVideoSEIMsgType("LiveVideoSEIMsgType_ProductFlush", 3, 5);
        LiveVideoSEIMsgType_ProductFlush = r103;
        LiveVideoSEIMsgType r104 = new LiveVideoSEIMsgType("LiveVideoSEIMsgType_LiveContent", 4, 6);
        LiveVideoSEIMsgType_LiveContent = r104;
        LiveVideoSEIMsgType r105 = new LiveVideoSEIMsgType("LiveVideoSEIMsgType_LiveContentEnd", 5, 7);
        LiveVideoSEIMsgType_LiveContentEnd = r105;
        LiveVideoSEIMsgType r106 = new LiveVideoSEIMsgType("LiveVideoSEIMSgType_SentenceEnd", 6, 8);
        LiveVideoSEIMSgType_SentenceEnd = r106;
        LiveVideoSEIMsgType r107 = new LiveVideoSEIMsgType("LiveVideoSEIMsgType_Action", 7, 10);
        LiveVideoSEIMsgType_Action = r107;
        LiveVideoSEIMsgType r108 = new LiveVideoSEIMsgType("LiveVideoSEIMsgType_GuideLike", 8, 20);
        LiveVideoSEIMsgType_GuideLike = r108;
        LiveVideoSEIMsgType r109 = new LiveVideoSEIMsgType("LiveVideoSEIMsgType_SugDisplay", 9, 21);
        LiveVideoSEIMsgType_SugDisplay = r109;
        LiveVideoSEIMsgType r110 = new LiveVideoSEIMsgType("LiveVideoSEIMsgType_CarouselComponents", 10, 22);
        LiveVideoSEIMsgType_CarouselComponents = r110;
        f51361a = new LiveVideoSEIMsgType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
    }

    public final int getType() {
        return this.type;
    }

    public LiveVideoSEIMsgType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
