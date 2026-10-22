package androidx.compose.foundation.text.selection;

import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.platform.ViewConfiguration;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rJ\u0016\u0010\u0019\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/text/selection/ClicksCounter;", "", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "<init>", "(Landroidx/compose/ui/platform/ViewConfiguration;)V", "clicks", "", "getClicks", "()I", "setClicks", "(I)V", "prevClick", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "getPrevClick", "()Landroidx/compose/ui/input/pointer/PointerInputChange;", "setPrevClick", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)V", "update", "", "event", "Landroidx/compose/ui/input/pointer/PointerEvent;", "timeIsTolerable", "", "newClick", "positionIsTolerable", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ClicksCounter {
    private int clicks;
    private PointerInputChange prevClick;
    private final ViewConfiguration viewConfiguration;

    public final int getClicks() {
        return this.clicks;
    }

    public final PointerInputChange getPrevClick() {
        return this.prevClick;
    }

    public ClicksCounter(ViewConfiguration r100) {
        this.viewConfiguration = r100;
    }

    public final void setClicks(int r100) {
        this.clicks = r100;
    }

    public final void setPrevClick(PointerInputChange r100) {
        this.prevClick = r100;
    }

    public final void update(PointerEvent r100) {
        PointerInputChange r101 = this.prevClick;
        PointerInputChange r102 = (PointerInputChange) ListProtector.get(r100.getChanges(), 0);
        if (r101 != null) goto L5;
    L9:
        this.clicks = 1;
    L10:
        this.prevClick = r102;
        return;
    L5:
        if (timeIsTolerable(r101, r102) == false) goto L9;
        if (positionIsTolerable(r101, r102) == false) goto L9;
        this.clicks++;
        goto L10
    }

    public final boolean positionIsTolerable(PointerInputChange r100, PointerInputChange r101) {
        return SelectionGesturesKt.access$distanceIsTolerable(this.viewConfiguration, r100, r101);
    }

    public final boolean timeIsTolerable(PointerInputChange r100, PointerInputChange r101) {
        if ((r101.getUptimeMillis() - r100.getUptimeMillis()) >= this.viewConfiguration.getDoubleTapTimeoutMillis()) goto L5;
        return true;
    L5:
        return false;
    }
}
