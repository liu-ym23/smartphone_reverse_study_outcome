package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0011R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0018\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0019\u0010\u0011R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u001e\u0010\u0011¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/W;", "", "", "titleToMetaDp", "metaToInfoBlockDp", "infoRowGapDp", "infoToDescDp", "", "ctaGravityEnd", "ctaCompact", "footerMinHeightDp", "<init>", "(IIIIZZI)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "f", Const.INTENT_KEY_BACKGROUND_COMMAND, "Z", Const.INTENT_KEY_UMID, "()Z", "c", "e", "Companion", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.W, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class PoiDetailStyle {
    private final boolean ctaCompact;
    private final boolean ctaGravityEnd;
    private final int footerMinHeightDp;
    private final int infoRowGapDp;
    private final int infoToDescDp;
    private final int metaToInfoBlockDp;
    private final int titleToMetaDp;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final PoiDetailStyle CARD = new PoiDetailStyle(6, 16, 12, 16, true, true, 0);
    private static final PoiDetailStyle SHEET = new PoiDetailStyle(4, 29, 27, 33, false, false, 104);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/W$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/W;", "CARD", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/W;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/W;", "SHEET", Const.INTENT_KEY_PKGNAME, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.W$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final PoiDetailStyle a() {
            return PoiDetailStyle.CARD;
        }

        public final PoiDetailStyle b() {
            return PoiDetailStyle.SHEET;
        }

        public Companion() {
        }
    }

    public PoiDetailStyle(int i10, int i11, int i12, int i13, boolean z10, boolean z11, int i14) {
        this.titleToMetaDp = i10;
        this.metaToInfoBlockDp = i11;
        this.infoRowGapDp = i12;
        this.infoToDescDp = i13;
        this.ctaGravityEnd = z10;
        this.ctaCompact = z11;
        this.footerMinHeightDp = i14;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getCtaCompact() {
        return this.ctaCompact;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getCtaGravityEnd() {
        return this.ctaGravityEnd;
    }

    /* renamed from: e, reason: from getter */
    public final int getFooterMinHeightDp() {
        return this.footerMinHeightDp;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PoiDetailStyle)) {
            return false;
        }
        PoiDetailStyle poiDetailStyle = (PoiDetailStyle) other;
        return this.titleToMetaDp == poiDetailStyle.titleToMetaDp && this.metaToInfoBlockDp == poiDetailStyle.metaToInfoBlockDp && this.infoRowGapDp == poiDetailStyle.infoRowGapDp && this.infoToDescDp == poiDetailStyle.infoToDescDp && this.ctaGravityEnd == poiDetailStyle.ctaGravityEnd && this.ctaCompact == poiDetailStyle.ctaCompact && this.footerMinHeightDp == poiDetailStyle.footerMinHeightDp;
    }

    /* renamed from: f, reason: from getter */
    public final int getInfoRowGapDp() {
        return this.infoRowGapDp;
    }

    /* renamed from: g, reason: from getter */
    public final int getInfoToDescDp() {
        return this.infoToDescDp;
    }

    /* renamed from: h, reason: from getter */
    public final int getMetaToInfoBlockDp() {
        return this.metaToInfoBlockDp;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.titleToMetaDp) * 31) + Integer.hashCode(this.metaToInfoBlockDp)) * 31) + Integer.hashCode(this.infoRowGapDp)) * 31) + Integer.hashCode(this.infoToDescDp)) * 31) + Boolean.hashCode(this.ctaGravityEnd)) * 31) + Boolean.hashCode(this.ctaCompact)) * 31) + Integer.hashCode(this.footerMinHeightDp);
    }

    /* renamed from: i, reason: from getter */
    public final int getTitleToMetaDp() {
        return this.titleToMetaDp;
    }

    public String toString() {
        return "PoiDetailStyle(titleToMetaDp=" + this.titleToMetaDp + ", metaToInfoBlockDp=" + this.metaToInfoBlockDp + ", infoRowGapDp=" + this.infoRowGapDp + ", infoToDescDp=" + this.infoToDescDp + ", ctaGravityEnd=" + this.ctaGravityEnd + ", ctaCompact=" + this.ctaCompact + ", footerMinHeightDp=" + this.footerMinHeightDp + ")";
    }
}
