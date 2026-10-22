package com.bytedance.android.live.broadcastgame.opengame.panel;

import com.bytedance.android.live.broadcastgame.opengame.utils.n;
import com.bytedance.android.live.core.utils.s1;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\u0001\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/panel/PanelType;", "", "", "w", "h", "", "updateWH", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "width", "I", "getWidth", "()I", "setWidth", "(I)V", "height", "getHeight", "setHeight", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "PANEL_TYPE_X_SCREEN_LOW", "PANEL_TYPE_PORTRAIT", "PANEL_TYPE_X_SCREEN", "PANEL_TYPE_LANDSCAPE", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PanelType extends Enum<PanelType> {
    public static final a Companion = null;
    public static final PanelType PANEL_TYPE_LANDSCAPE = null;
    public static final PanelType PANEL_TYPE_PORTRAIT = null;
    public static final PanelType PANEL_TYPE_X_SCREEN = null;
    public static final PanelType PANEL_TYPE_X_SCREEN_LOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PanelType[] f60659a = null;
    private int height;
    private final String type;
    private int width;

    public static final class a {
        public a() {
        }

        public static boolean a(PanelType r100) {
            if (r100 != PanelType.PANEL_TYPE_PORTRAIT) goto L5;
        L8:
            return true;
        L5:
            if (r100 == PanelType.PANEL_TYPE_LANDSCAPE) goto L8;
            return false;
        }

        public final PanelType getType(String r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            PanelType[] r101 = PanelType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            PanelType r104 = r101[r103];
            if (Intrinsics.areEqual(r100, r104.getType()) == true) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L8:
            return null;
        }

        public static boolean b(PanelType r100, PanelType r101) {
            Intrinsics.checkNotNullParameter(r100, "fromType");
            Intrinsics.checkNotNullParameter(r101, "toType");
            int r102 = j.f60682a[r100.ordinal()];
            if (r102 == 1) goto L20;
            if (r102 == 2) goto L20;
            if (r102 == 3) goto L20;
            if (r102 != 4) goto L18;
            if (r101 != PanelType.PANEL_TYPE_PORTRAIT) goto L13;
            return true;
        L13:
            if (r101 != PanelType.PANEL_TYPE_X_SCREEN_LOW) goto L15;
            return true;
        L15:
            if (r101 == PanelType.PANEL_TYPE_X_SCREEN) goto L26;
        L22:
            return false;
        L26:
            return true;
        L18:
            throw new NoWhenBranchMatchedException();
        L20:
            if (r101 != PanelType.PANEL_TYPE_LANDSCAPE) goto L22;
            return true;
        }
    }

    static {
        PanelType r100 = new PanelType("PANEL_TYPE_X_SCREEN_LOW", 0, "xscreen_low", s1.y(), (int) ((((double) s1.y()) * 0.736d) + ((double) s1.f(68.0f))));
        PANEL_TYPE_X_SCREEN_LOW = r100;
        PanelType r101 = new PanelType("PANEL_TYPE_PORTRAIT", 1, "portrait", s1.y(), s1.w());
        PANEL_TYPE_PORTRAIT = r101;
        int r102 = s1.y();
        int r103 = n.f61176a;
        PanelType r104 = new PanelType("PANEL_TYPE_X_SCREEN", 2, "xscreen", r102, s1.f(484.0f));
        PANEL_TYPE_X_SCREEN = r104;
        PanelType r105 = new PanelType("PANEL_TYPE_LANDSCAPE", 3, "landscape", s1.w(), s1.y());
        PANEL_TYPE_LANDSCAPE = r105;
        f60659a = new PanelType[]{r100, r101, r104, r105};
        Companion = new a();
    }

    public static PanelType valueOf(String r100) {
        return (PanelType) r27.a.a(PanelType.class, r100);
    }

    public static PanelType[] values() {
        return (PanelType[]) f60659a.clone();
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getType() {
        return this.type;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }

    public final void updateWH(int r100, int r101) {
        this.width = r100;
        this.height = r101;
    }

    public PanelType(String r100, int r101, String r102, int r103, int r104) {
        super(r100, r101);
        this.type = r102;
        this.width = r103;
        this.height = r104;
    }
}
