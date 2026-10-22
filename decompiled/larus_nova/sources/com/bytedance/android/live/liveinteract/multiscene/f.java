package com.bytedance.android.live.liveinteract.multiscene;

import com.bytedance.android.live.liveinteract.plantform.model.l;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\bg\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002/0R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0004\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001b\u001a\u00020\u00168&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010!\u001a\u00020\u001c8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010#\u001a\u00020\"8&@&X¦\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u00020\"8&@&X¦\u000e¢\u0006\f\u001a\u0004\b'\u0010$\"\u0004\b(\u0010&R\u001c\u0010)\u001a\u00020\"8&@&X¦\u000e¢\u0006\f\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R\u001c\u0010-\u001a\u00020\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014¨\u00061"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multiscene/f;", "Lvh7/c;", "", "getScoreStrFlex", "()Ljava/lang/String;", "scoreStrFlex", "getScoreFuzzyFlex", "scoreFuzzyFlex", "Lcom/bytedance/android/live/liveinteract/multiscene/f$b;", "getContributorsFlex", "()Lcom/bytedance/android/live/liveinteract/multiscene/f$b;", "contributorsFlex", "getUserIdString", "setUserIdString", "(Ljava/lang/String;)V", "userIdString", "", "getServerTeamId", "()J", "setServerTeamId", "(J)V", "serverTeamId", "", "getRole", "()I", "setRole", "(I)V", "role", "Lcom/bytedance/android/live/liveinteract/plantform/model/l;", "getQuickInteract", "()Lcom/bytedance/android/live/liveinteract/plantform/model/l;", "setQuickInteract", "(Lcom/bytedance/android/live/liveinteract/plantform/model/l;)V", "quickInteract", "", "isGrownUpgrade", "()Z", "setGrownUpgrade", "(Z)V", "isGrownDowngrade", "setGrownDowngrade", "isDressUpdated", "setDressUpdated", "getScoreFlex", "setScoreFlex", "scoreFlex", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface f extends vh7.c<f> {
    public static final a Companion = null;
    public static final int TEAMFIGHT_LAGGING_ROLE_MVP = 2;
    public static final int TEAMFIGHT_LEADING_ROLE_MVP = 1;
    public static final int TEAMFIGHT_ROLE_NONE = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f75474a = null;

        public a() {
        }

        static {
            f75474a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H¦\u0002R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multiscene/f$b;", "Lvh7/c;", "", "userId", "", "contains", "", "", "getUserIdsFlex", "()Ljava/util/List;", "userIdsFlex", "getUserIds", "userIds", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface b extends vh7.c<b> {
        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        boolean contains(String r100);

        List<String> getUserIds();

        List<Long> getUserIdsFlex();
    }

    static {
        Companion = a.f75474a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    b getContributorsFlex();

    l getQuickInteract();

    int getRole();

    long getScoreFlex();

    String getScoreFuzzyFlex();

    String getScoreStrFlex();

    long getServerTeamId();

    String getUserIdString();

    boolean isDressUpdated();

    boolean isGrownDowngrade();

    boolean isGrownUpgrade();

    void setDressUpdated(boolean r100);

    void setGrownDowngrade(boolean r100);

    void setGrownUpgrade(boolean r100);

    void setQuickInteract(l r100);

    void setRole(int r100);

    void setScoreFlex(long r100);

    void setServerTeamId(long r100);

    void setUserIdString(String r100);
}
