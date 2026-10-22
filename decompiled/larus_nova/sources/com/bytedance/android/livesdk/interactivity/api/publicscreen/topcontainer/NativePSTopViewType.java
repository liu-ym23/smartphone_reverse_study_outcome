package com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer;

import com.tencent.open.SocialConstants;
import f52.f;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/topcontainer/NativePSTopViewType;", "", "Lf52/f;", "", "priority", "I", "getPriority", "()I", "", "getDesc", "()Ljava/lang/String;", SocialConstants.PARAM_APP_DESC, "HotMsgGather", "NewHotMsg", "BusinessMsg", "LikeEgg", "ChatCarnival", "MatchDynamicHotMsg", "Confront", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum NativePSTopViewType extends Enum<NativePSTopViewType> implements f {
    public static final NativePSTopViewType BusinessMsg = null;
    public static final NativePSTopViewType ChatCarnival = null;
    public static final NativePSTopViewType Confront = null;
    public static final NativePSTopViewType HotMsgGather = null;
    public static final NativePSTopViewType LikeEgg = null;
    public static final NativePSTopViewType MatchDynamicHotMsg = null;
    public static final NativePSTopViewType NewHotMsg = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NativePSTopViewType[] f133549a = null;
    private final int priority;

    static {
        NativePSTopViewType r100 = new NativePSTopViewType("HotMsgGather", 0, 0);
        HotMsgGather = r100;
        NativePSTopViewType r101 = new NativePSTopViewType("NewHotMsg", 1, 1);
        NewHotMsg = r101;
        NativePSTopViewType r102 = new NativePSTopViewType("BusinessMsg", 2, 40);
        BusinessMsg = r102;
        NativePSTopViewType r103 = new NativePSTopViewType("LikeEgg", 3, 50);
        LikeEgg = r103;
        NativePSTopViewType r104 = new NativePSTopViewType("ChatCarnival", 4, 100);
        ChatCarnival = r104;
        NativePSTopViewType r105 = new NativePSTopViewType("MatchDynamicHotMsg", 5, 75);
        MatchDynamicHotMsg = r105;
        NativePSTopViewType r106 = new NativePSTopViewType("Confront", 6, 100);
        Confront = r106;
        f133549a = new NativePSTopViewType[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static NativePSTopViewType valueOf(String r100) {
        return (NativePSTopViewType) a.a(NativePSTopViewType.class, r100);
    }

    public static NativePSTopViewType[] values() {
        return (NativePSTopViewType[]) f133549a.clone();
    }

    public String getDesc() {
        return name();
    }

    @Override // f52.f
    public int getPriority() {
        return this.priority;
    }

    public NativePSTopViewType(String r100, int r101, int r102) {
        super(r100, r101);
        this.priority = r102;
    }
}
