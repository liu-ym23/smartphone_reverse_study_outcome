package androidx.compose.material.ripple;

import android.content.Context;
import android.view.ViewGroup;
import com.byted.cast.common.CastMonitor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0014J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0014J\b\u0010\u001a\u001a\u00020\u0010H\u0016J\n\u0010\u001b\u001a\u00020\n*\u00020\u001cJ\n\u0010\u001d\u001a\u00020\u0010*\u00020\u001cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/material/ripple/RippleContainer;", "Landroid/view/ViewGroup;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "MaxRippleHosts", "", "rippleHosts", "", "Landroidx/compose/material/ripple/RippleHostView;", "unusedRippleHosts", "rippleHostMap", "Landroidx/compose/material/ripple/RippleHostMap;", "nextHostIndex", "onLayout", "", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "requestLayout", "getRippleHostView", "Landroidx/compose/material/ripple/RippleHostKey;", "disposeRippleIfNeeded", "material-ripple"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RippleContainer extends ViewGroup {
    public static final int $stable = 8;
    private final int MaxRippleHosts;
    private int nextHostIndex;
    private final RippleHostMap rippleHostMap;
    private final List<RippleHostView> rippleHosts;
    private final List<RippleHostView> unusedRippleHosts;

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
    }

    public RippleContainer(Context r100) {
        super(r100);
        this.MaxRippleHosts = 5;
        ArrayList r101 = new ArrayList();
        this.rippleHosts = r101;
        ArrayList r102 = new ArrayList();
        this.unusedRippleHosts = r102;
        this.rippleHostMap = new RippleHostMap();
        setClipChildren(false);
        RippleHostView r103 = new RippleHostView(r100);
        addView(r103);
        r101.add(r103);
        r102.add(r103);
        this.nextHostIndex = 1;
        setTag(R.id.hide_in_inspector_tag, Boolean.TRUE);
    }

    public final void disposeRippleIfNeeded(RippleHostKey r100) {
        r100.onResetRippleHostView();
        RippleHostView r101 = this.rippleHostMap.get(r100);
        if (r101 == null) goto L6;
        r101.disposeRipple();
        this.rippleHostMap.remove(r100);
        this.unusedRippleHosts.add(r101);
        return;
    }

    public final RippleHostView getRippleHostView(RippleHostKey r100) {
        RippleHostView r101 = this.rippleHostMap.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        RippleHostView r102 = (RippleHostView) CollectionsKt.removeFirstOrNull(this.unusedRippleHosts);
        if (r102 == null) goto L8;
    L17:
        this.rippleHostMap.set(r100, r102);
        return r102;
    L8:
        if (this.nextHostIndex <= CollectionsKt.getLastIndex(this.rippleHosts)) goto L10;
        r102 = new RippleHostView(getContext());
        addView(r102);
        this.rippleHosts.add(r102);
    L13:
        int r103 = this.nextHostIndex;
        if (r103 >= (this.MaxRippleHosts - 1)) goto L16;
        this.nextHostIndex = r103 + 1;
        goto L17
    L16:
        this.nextHostIndex = 0;
        goto L17
    L10:
        r102 = (RippleHostView) ListProtector.get(this.rippleHosts, this.nextHostIndex);
        RippleHostKey r104 = this.rippleHostMap.get(r102);
        if (r104 == null) goto L13;
        r104.onResetRippleHostView();
        this.rippleHostMap.remove(r104);
        r102.disposeRipple();
        goto L13
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        setMeasuredDimension(0, 0);
    }
}
