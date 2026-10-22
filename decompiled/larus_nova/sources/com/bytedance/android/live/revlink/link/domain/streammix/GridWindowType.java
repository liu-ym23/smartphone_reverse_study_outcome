package com.bytedance.android.live.revlink.link.domain.streammix;

import com.ss.android.ugc.effectmanager.common.EffectTypeConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/link/domain/streammix/GridWindowType;", "", "Anchor", "Audience", EffectTypeConstants.TYPE_GAME, "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GridWindowType extends Enum<GridWindowType> {
    public static final GridWindowType Anchor = null;
    public static final GridWindowType Audience = null;
    public static final GridWindowType Game = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GridWindowType[] f98538a = null;

    static {
        GridWindowType r100 = new GridWindowType("Anchor", 0);
        Anchor = r100;
        GridWindowType r101 = new GridWindowType("Audience", 1);
        Audience = r101;
        GridWindowType r102 = new GridWindowType(EffectTypeConstants.TYPE_GAME, 2);
        Game = r102;
        f98538a = new GridWindowType[]{r100, r101, r102};
    }

    public static GridWindowType valueOf(String r100) {
        return (GridWindowType) r27.a.a(GridWindowType.class, r100);
    }

    public static GridWindowType[] values() {
        return (GridWindowType[]) f98538a.clone();
    }

    public GridWindowType(String r100, int r101) {
        super(r100, r101);
    }
}
