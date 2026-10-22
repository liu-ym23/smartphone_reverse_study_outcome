package com.bytedance.android.live.revlink.impl.behavior;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/behavior/PkPanelType;", "", "", "toConstInt", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "PK", "Anchor", "GAME", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PkPanelType extends Enum<PkPanelType> {
    public static final PkPanelType Anchor = null;
    public static final a Companion = null;
    public static final PkPanelType GAME = null;
    public static final PkPanelType PK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PkPanelType[] f92086a = null;

    public static final class a {
        public a() {
        }

        public static PkPanelType a(Integer r100) {
            if (r100 != null) goto L5;
        L7:
            if (r100 != null) goto L10;
        L12:
            if (r100 != null) goto L15;
        L17:
            return null;
        L15:
            if (r100.intValue() != 2) goto L17;
            return PkPanelType.GAME;
        L10:
            if (r100.intValue() != 1) goto L12;
            return PkPanelType.Anchor;
        L5:
            if (r100.intValue() != 0) goto L7;
            return PkPanelType.PK;
        }
    }

    static {
        PkPanelType r100 = new PkPanelType("PK", 0);
        PK = r100;
        PkPanelType r101 = new PkPanelType("Anchor", 1);
        Anchor = r101;
        PkPanelType r102 = new PkPanelType("GAME", 2);
        GAME = r102;
        f92086a = new PkPanelType[]{r100, r101, r102};
        Companion = new a();
    }

    public static PkPanelType valueOf(String r100) {
        return (PkPanelType) r27.a.a(PkPanelType.class, r100);
    }

    public static PkPanelType[] values() {
        return (PkPanelType[]) f92086a.clone();
    }

    public final int toConstInt() {
        int r100 = i.f92162a[ordinal()];
        if (r100 != 1) goto L5;
        return 0;
    L5:
        if (r100 != 2) goto L7;
        return 1;
    L7:
        if (r100 != 3) goto L10;
        return 2;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public PkPanelType(String r100, int r101) {
        super(r100, r101);
    }
}
