package androidx.compose.foundation;

import android.content.Context;
import android.widget.EdgeEffect;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.unit.IntSize;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\bJ\u0006\u0010\u0018\u001a\u00020\u0015J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u001aJ\u0006\u0010\u001d\u001a\u00020\u001aJ\u0006\u0010\u001e\u001a\u00020\u001aJ\u0006\u0010\u001f\u001a\u00020\u001aJ\u0006\u0010 \u001a\u00020\u001aJ\u0006\u0010!\u001a\u00020\u001aJ\u0006\u0010$\u001a\u00020\u001aJ\u0006\u0010%\u001a\u00020\u001aJ\u0006\u0010&\u001a\u00020\u001aJ\u0006\u0010'\u001a\u00020\u001aJ\u0006\u0010)\u001a\u00020\fJ\u0006\u0010*\u001a\u00020\fJ\u0006\u0010+\u001a\u00020\fJ\u0006\u0010,\u001a\u00020\fJ\u0006\u0010-\u001a\u00020\fJ\u0006\u0010.\u001a\u00020\fJ\u0006\u0010/\u001a\u00020\fJ\u0006\u00100\u001a\u00020\fJ\u0010\u00101\u001a\u00020\f2\u0006\u00102\u001a\u000203H\u0002J\u0015\u00104\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b5\u00106R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\u001a*\u0004\u0018\u00010\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001a\u0010(\u001a\u00020\u001a*\u0004\u0018\u00010\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010#¨\u00067"}, d2 = {"Landroidx/compose/foundation/EdgeEffectWrapper;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "glowColor", "", "<init>", "(Landroid/content/Context;I)V", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "topEffect", "Landroid/widget/EdgeEffect;", "bottomEffect", "leftEffect", "rightEffect", "topEffectNegation", "bottomEffectNegation", "leftEffectNegation", "rightEffectNegation", "forEachEffect", "", "action", "Lkotlin/Function1;", "finishAll", "isTopStretched", "", "isBottomStretched", "isLeftStretched", "isRightStretched", "isTopNegationStretched", "isBottomNegationStretched", "isLeftNegationStretched", "isRightNegationStretched", "isStretched", "(Landroid/widget/EdgeEffect;)Z", "isTopAnimating", "isBottomAnimating", "isLeftAnimating", "isRightAnimating", "isAnimating", "getOrCreateTopEffect", "getOrCreateBottomEffect", "getOrCreateLeftEffect", "getOrCreateRightEffect", "getOrCreateTopEffectNegation", "getOrCreateBottomEffectNegation", "getOrCreateLeftEffectNegation", "getOrCreateRightEffectNegation", "createEdgeEffect", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "updateSize", "updateSize-ozmzZPI", "(J)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class EdgeEffectWrapper {
    private EdgeEffect bottomEffect;
    private EdgeEffect bottomEffectNegation;
    private final Context context;
    private final int glowColor;
    private EdgeEffect leftEffect;
    private EdgeEffect leftEffectNegation;
    private EdgeEffect rightEffect;
    private EdgeEffect rightEffectNegation;
    private long size;
    private EdgeEffect topEffect;
    private EdgeEffect topEffectNegation;

    public final void finishAll() {
        EdgeEffect r100 = this.topEffect;
        if (r100 == null) goto L5;
        r100.finish();
    L5:
        EdgeEffect r101 = this.bottomEffect;
        if (r101 == null) goto L8;
        r101.finish();
    L8:
        EdgeEffect r102 = this.leftEffect;
        if (r102 == null) goto L11;
        r102.finish();
    L11:
        EdgeEffect r103 = this.rightEffect;
        if (r103 == null) goto L14;
        r103.finish();
    L14:
        EdgeEffect r104 = this.topEffectNegation;
        if (r104 == null) goto L17;
        r104.finish();
    L17:
        EdgeEffect r105 = this.bottomEffectNegation;
        if (r105 == null) goto L20;
        r105.finish();
    L20:
        EdgeEffect r106 = this.leftEffectNegation;
        if (r106 == null) goto L23;
        r106.finish();
    L23:
        EdgeEffect r107 = this.rightEffectNegation;
        if (r107 == null) goto L27;
        r107.finish();
        return;
    }

    public final EdgeEffect getOrCreateBottomEffect() {
        EdgeEffect r100 = this.bottomEffect;
        if (r100 != null) goto L6;
        EdgeEffect r101 = createEdgeEffect(Orientation.Vertical);
        this.bottomEffect = r101;
        return r101;
    L6:
        return r100;
    }

    public final EdgeEffect getOrCreateBottomEffectNegation() {
        EdgeEffect r100 = this.bottomEffectNegation;
        if (r100 != null) goto L6;
        EdgeEffect r101 = createEdgeEffect(Orientation.Vertical);
        this.bottomEffectNegation = r101;
        return r101;
    L6:
        return r100;
    }

    public final EdgeEffect getOrCreateLeftEffect() {
        EdgeEffect r100 = this.leftEffect;
        if (r100 != null) goto L6;
        EdgeEffect r101 = createEdgeEffect(Orientation.Horizontal);
        this.leftEffect = r101;
        return r101;
    L6:
        return r100;
    }

    public final EdgeEffect getOrCreateLeftEffectNegation() {
        EdgeEffect r100 = this.leftEffectNegation;
        if (r100 != null) goto L6;
        EdgeEffect r101 = createEdgeEffect(Orientation.Horizontal);
        this.leftEffectNegation = r101;
        return r101;
    L6:
        return r100;
    }

    public final EdgeEffect getOrCreateRightEffect() {
        EdgeEffect r100 = this.rightEffect;
        if (r100 != null) goto L6;
        EdgeEffect r101 = createEdgeEffect(Orientation.Horizontal);
        this.rightEffect = r101;
        return r101;
    L6:
        return r100;
    }

    public final EdgeEffect getOrCreateRightEffectNegation() {
        EdgeEffect r100 = this.rightEffectNegation;
        if (r100 != null) goto L6;
        EdgeEffect r101 = createEdgeEffect(Orientation.Horizontal);
        this.rightEffectNegation = r101;
        return r101;
    L6:
        return r100;
    }

    public final EdgeEffect getOrCreateTopEffect() {
        EdgeEffect r100 = this.topEffect;
        if (r100 != null) goto L6;
        EdgeEffect r101 = createEdgeEffect(Orientation.Vertical);
        this.topEffect = r101;
        return r101;
    L6:
        return r100;
    }

    public final EdgeEffect getOrCreateTopEffectNegation() {
        EdgeEffect r100 = this.topEffectNegation;
        if (r100 != null) goto L6;
        EdgeEffect r101 = createEdgeEffect(Orientation.Vertical);
        this.topEffectNegation = r101;
        return r101;
    L6:
        return r100;
    }

    public final boolean isBottomAnimating() {
        return isAnimating(this.bottomEffect);
    }

    public final boolean isBottomNegationStretched() {
        return isStretched(this.bottomEffectNegation);
    }

    public final boolean isBottomStretched() {
        return isStretched(this.bottomEffect);
    }

    public final boolean isLeftAnimating() {
        return isAnimating(this.leftEffect);
    }

    public final boolean isLeftNegationStretched() {
        return isStretched(this.leftEffectNegation);
    }

    public final boolean isLeftStretched() {
        return isStretched(this.leftEffect);
    }

    public final boolean isRightAnimating() {
        return isAnimating(this.rightEffect);
    }

    public final boolean isRightNegationStretched() {
        return isStretched(this.rightEffectNegation);
    }

    public final boolean isRightStretched() {
        return isStretched(this.rightEffect);
    }

    public final boolean isTopAnimating() {
        return isAnimating(this.topEffect);
    }

    public final boolean isTopNegationStretched() {
        return isStretched(this.topEffectNegation);
    }

    public final boolean isTopStretched() {
        return isStretched(this.topEffect);
    }

    public static final /* synthetic */ EdgeEffect access$getBottomEffect$p(EdgeEffectWrapper r100) {
        return r100.bottomEffect;
    }

    public static final /* synthetic */ EdgeEffect access$getLeftEffect$p(EdgeEffectWrapper r100) {
        return r100.leftEffect;
    }

    public static final /* synthetic */ EdgeEffect access$getRightEffect$p(EdgeEffectWrapper r100) {
        return r100.rightEffect;
    }

    public static final /* synthetic */ EdgeEffect access$getTopEffect$p(EdgeEffectWrapper r100) {
        return r100.topEffect;
    }

    private final EdgeEffect createEdgeEffect(Orientation r100) {
        EdgeEffect r101 = EdgeEffectCompat.INSTANCE.create(this.context);
        r101.setColor(this.glowColor);
        if (IntSize.m7717equalsimpl0(this.size, IntSize.Companion.m7724getZeroYbymL2g()) == false) goto L5;
    L8:
        return r101;
    L5:
        if (r100 != Orientation.Vertical) goto L7;
        long r102 = this.size;
        r101.setSize((int) (r102 >> 32), (int) (r102 & BodyPartID.bodyIdMax));
        goto L8
    L7:
        long r103 = this.size;
        r101.setSize((int) (BodyPartID.bodyIdMax & r103), (int) (r103 >> 32));
        goto L8
    }

    private final boolean isAnimating(EdgeEffect r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return !r100.isFinished();
    }

    private final boolean isStretched(EdgeEffect r100) {
        boolean r101 = false;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(r100) != 0.0f) goto L9;
        r101 = true;
    L9:
        return !r101;
    }

    public final void forEachEffect(Function1<? super EdgeEffect, Unit> r100) {
        EdgeEffect r101 = access$getTopEffect$p(this);
        if (r101 == null) goto L5;
        r100.invoke(r101);
    L5:
        EdgeEffect r102 = access$getBottomEffect$p(this);
        if (r102 == null) goto L8;
        r100.invoke(r102);
    L8:
        EdgeEffect r103 = access$getLeftEffect$p(this);
        if (r103 == null) goto L11;
        r100.invoke(r103);
    L11:
        EdgeEffect r104 = access$getRightEffect$p(this);
        if (r104 == null) goto L15;
        r100.invoke(r104);
        return;
    }

    /* JADX INFO: renamed from: updateSize-ozmzZPI, reason: not valid java name */
    public final void m286updateSizeozmzZPI(long r100) {
        this.size = r100;
        EdgeEffect r101 = this.topEffect;
        if (r101 == null) goto L5;
        r101.setSize((int) (r100 >> 32), (int) (r100 & BodyPartID.bodyIdMax));
    L5:
        EdgeEffect r102 = this.bottomEffect;
        if (r102 == null) goto L8;
        r102.setSize((int) (r100 >> 32), (int) (r100 & BodyPartID.bodyIdMax));
    L8:
        EdgeEffect r103 = this.leftEffect;
        if (r103 == null) goto L11;
        r103.setSize((int) (r100 & BodyPartID.bodyIdMax), (int) (r100 >> 32));
    L11:
        EdgeEffect r104 = this.rightEffect;
        if (r104 == null) goto L14;
        r104.setSize((int) (r100 & BodyPartID.bodyIdMax), (int) (r100 >> 32));
    L14:
        EdgeEffect r105 = this.topEffectNegation;
        if (r105 == null) goto L17;
        r105.setSize((int) (r100 >> 32), (int) (r100 & BodyPartID.bodyIdMax));
    L17:
        EdgeEffect r106 = this.bottomEffectNegation;
        if (r106 == null) goto L20;
        r106.setSize((int) (r100 >> 32), (int) (r100 & BodyPartID.bodyIdMax));
    L20:
        EdgeEffect r107 = this.leftEffectNegation;
        if (r107 == null) goto L23;
        r107.setSize((int) (r100 & BodyPartID.bodyIdMax), (int) (r100 >> 32));
    L23:
        EdgeEffect r108 = this.rightEffectNegation;
        if (r108 == null) goto L27;
        r108.setSize((int) (BodyPartID.bodyIdMax & r100), (int) (r100 >> 32));
        return;
    }

    public EdgeEffectWrapper(Context r100, int r101) {
        this.context = r100;
        this.glowColor = r101;
        this.size = IntSize.Companion.m7724getZeroYbymL2g();
    }
}
