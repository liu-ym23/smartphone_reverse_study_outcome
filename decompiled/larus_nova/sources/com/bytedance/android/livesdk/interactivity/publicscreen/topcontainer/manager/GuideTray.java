package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.manager;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/manager/GuideTray;", "", "", "priority", "I", "getPriority", "()I", "HotMsgGather", "BusinessMsg", "ChatCarnival", "LikeEgg", "Confront", "MatchDynamicHotMsg", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GuideTray extends Enum<GuideTray> {
    public static final GuideTray BusinessMsg = null;
    public static final GuideTray ChatCarnival = null;
    public static final GuideTray Confront = null;
    public static final GuideTray HotMsgGather = null;
    public static final GuideTray LikeEgg = null;
    public static final GuideTray MatchDynamicHotMsg = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GuideTray[] f140048a = null;
    private final int priority;

    static {
        GuideTray r100 = new GuideTray("HotMsgGather", 0, 0, 1, null);
        HotMsgGather = r100;
        GuideTray r101 = new GuideTray("BusinessMsg", 1, 0, 1, null);
        BusinessMsg = r101;
        int r102 = 0;
        int r103 = 1;
        DefaultConstructorMarker r104 = null;
        GuideTray r105 = new GuideTray("ChatCarnival", 2, r102, r103, r104);
        ChatCarnival = r105;
        GuideTray r106 = new GuideTray("LikeEgg", 3, r102, r103, r104);
        LikeEgg = r106;
        GuideTray r107 = new GuideTray("Confront", 4, 100);
        Confront = r107;
        GuideTray r108 = new GuideTray("MatchDynamicHotMsg", 5, 99);
        MatchDynamicHotMsg = r108;
        f140048a = new GuideTray[]{r100, r101, r105, r106, r107, r108};
    }

    public static GuideTray valueOf(String r100) {
        return (GuideTray) r27.a.a(GuideTray.class, r100);
    }

    public static GuideTray[] values() {
        return (GuideTray[]) f140048a.clone();
    }

    public final int getPriority() {
        return this.priority;
    }

    public GuideTray(String r100, int r101, int r102) {
        super(r100, r101);
        this.priority = r102;
    }

    public /* synthetic */ GuideTray(String r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r102 = 0;
    L5:
        this(r100, r101, r102);
    }
}
