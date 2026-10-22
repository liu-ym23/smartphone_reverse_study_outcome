package com.bytedance.android.live.revlink.impl.multianchor.pk.control;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/pk/control/TeamTaskBackgroundDef;", "", "VOTE_PAD", "VOTE", "PAD", EffectConstants.NORMAL, "SIMPLE_PAD", "SIMPLE", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum TeamTaskBackgroundDef extends Enum<TeamTaskBackgroundDef> {
    public static final TeamTaskBackgroundDef NORMAL = null;
    public static final TeamTaskBackgroundDef PAD = null;
    public static final TeamTaskBackgroundDef SIMPLE = null;
    public static final TeamTaskBackgroundDef SIMPLE_PAD = null;
    public static final TeamTaskBackgroundDef VOTE = null;
    public static final TeamTaskBackgroundDef VOTE_PAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TeamTaskBackgroundDef[] f94501a = null;

    static {
        TeamTaskBackgroundDef r100 = new TeamTaskBackgroundDef("VOTE_PAD", 0);
        VOTE_PAD = r100;
        TeamTaskBackgroundDef r101 = new TeamTaskBackgroundDef("VOTE", 1);
        VOTE = r101;
        TeamTaskBackgroundDef r102 = new TeamTaskBackgroundDef("PAD", 2);
        PAD = r102;
        TeamTaskBackgroundDef r103 = new TeamTaskBackgroundDef(EffectConstants.NORMAL, 3);
        NORMAL = r103;
        TeamTaskBackgroundDef r104 = new TeamTaskBackgroundDef("SIMPLE_PAD", 4);
        SIMPLE_PAD = r104;
        TeamTaskBackgroundDef r105 = new TeamTaskBackgroundDef("SIMPLE", 5);
        SIMPLE = r105;
        f94501a = new TeamTaskBackgroundDef[]{r100, r101, r102, r103, r104, r105};
    }

    public static TeamTaskBackgroundDef valueOf(String r100) {
        return (TeamTaskBackgroundDef) a.a(TeamTaskBackgroundDef.class, r100);
    }

    public static TeamTaskBackgroundDef[] values() {
        return (TeamTaskBackgroundDef[]) f94501a.clone();
    }

    public TeamTaskBackgroundDef(String r100, int r101) {
        super(r100, r101);
    }
}
