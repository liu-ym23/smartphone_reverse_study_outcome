package com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel;

import com.bytedance.android.livesdk.gift.model.e3;
import java.util.ArrayList;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public abstract class AbsPanel<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f126613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<e3> f126614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f126615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GiftPanelSelectType f126616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f126617e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public GiftPanelIconSource f126618f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f126619g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final T f126620h;

    public static final enum GiftPanelIconSource extends Enum<GiftPanelIconSource> {
        public static final GiftPanelIconSource DIY_CARD = null;
        public static final GiftPanelIconSource GIFT_LIST = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GiftPanelIconSource[] f126621a = null;

        static {
            GiftPanelIconSource r100 = new GiftPanelIconSource("GIFT_LIST", 0);
            GIFT_LIST = r100;
            GiftPanelIconSource r101 = new GiftPanelIconSource("DIY_CARD", 1);
            DIY_CARD = r101;
            f126621a = new GiftPanelIconSource[]{r100, r101};
        }

        public static GiftPanelIconSource[] values() {
            return (GiftPanelIconSource[]) f126621a.clone();
        }

        public static GiftPanelIconSource valueOf(String r100) {
            return (GiftPanelIconSource) r27.a.a(GiftPanelIconSource.class, r100);
        }

        public GiftPanelIconSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum GiftPanelSelectType extends Enum<GiftPanelSelectType> {
        public static final GiftPanelSelectType DEFAULT_SELECTED = null;
        public static final GiftPanelSelectType IDLE = null;
        public static final GiftPanelSelectType JUST_SELECTED = null;
        public static final GiftPanelSelectType LOCATED = null;
        public static final GiftPanelSelectType NORMAL_SELECTED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GiftPanelSelectType[] f126622a = null;

        static {
            GiftPanelSelectType r100 = new GiftPanelSelectType("IDLE", 0);
            IDLE = r100;
            GiftPanelSelectType r101 = new GiftPanelSelectType("NORMAL_SELECTED", 1);
            NORMAL_SELECTED = r101;
            GiftPanelSelectType r102 = new GiftPanelSelectType("LOCATED", 2);
            LOCATED = r102;
            GiftPanelSelectType r103 = new GiftPanelSelectType("DEFAULT_SELECTED", 3);
            DEFAULT_SELECTED = r103;
            GiftPanelSelectType r104 = new GiftPanelSelectType("JUST_SELECTED", 4);
            JUST_SELECTED = r104;
            f126622a = new GiftPanelSelectType[]{r100, r101, r102, r103, r104};
        }

        public static GiftPanelSelectType[] values() {
            return (GiftPanelSelectType[]) f126622a.clone();
        }

        public static GiftPanelSelectType valueOf(String r100) {
            return (GiftPanelSelectType) r27.a.a(GiftPanelSelectType.class, r100);
        }

        public GiftPanelSelectType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public abstract String a();

    public k b() {
        return null;
    }

    public abstract long c();

    public abstract k d();

    public k e() {
        return null;
    }

    public abstract String f();

    public k g() {
        return null;
    }

    public boolean i() {
        return false;
    }

    public final boolean h() {
        if (this.f126616d == GiftPanelSelectType.IDLE) goto L5;
        return true;
    L5:
        return false;
    }

    public AbsPanel(int r100, T r101) {
        this.f126614b = null;
        this.f126615c = null;
        this.f126616d = GiftPanelSelectType.IDLE;
        this.f126617e = false;
        this.f126618f = GiftPanelIconSource.GIFT_LIST;
        this.f126619g = 0;
        this.f126613a = r100;
        this.f126620h = r101;
    }
}
