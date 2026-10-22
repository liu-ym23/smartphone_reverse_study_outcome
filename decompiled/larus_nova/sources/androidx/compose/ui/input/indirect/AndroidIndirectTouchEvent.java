package androidx.compose.ui.input.indirect;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/input/indirect/AndroidIndirectTouchEvent;", "Landroidx/compose/ui/input/indirect/PlatformIndirectTouchEvent;", "position", "Landroidx/compose/ui/geometry/Offset;", "uptimeMillis", "", "type", "Landroidx/compose/ui/input/indirect/IndirectTouchEventType;", "nativeEvent", "Landroid/view/MotionEvent;", "<init>", "(JJILandroid/view/MotionEvent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPosition-F1C5BW0", "()J", "J", "getUptimeMillis", "getType-LxEHWp8", "()I", "I", "getNativeEvent$ui_release", "()Landroid/view/MotionEvent;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidIndirectTouchEvent implements PlatformIndirectTouchEvent {
    public static final int $stable = 8;
    private final MotionEvent nativeEvent;
    private final long position;
    private final int type;
    private final long uptimeMillis;

    public /* synthetic */ AndroidIndirectTouchEvent(long r100, long r101, int r102, MotionEvent r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    public final MotionEvent getNativeEvent$ui_release() {
        return this.nativeEvent;
    }

    @Override // androidx.compose.ui.input.indirect.IndirectTouchEvent
    /* JADX INFO: renamed from: getPosition-F1C5BW0, reason: not valid java name */
    public long mo5651getPositionF1C5BW0() {
        return this.position;
    }

    @Override // androidx.compose.ui.input.indirect.IndirectTouchEvent
    /* JADX INFO: renamed from: getType-LxEHWp8, reason: not valid java name */
    public int mo5652getTypeLxEHWp8() {
        return this.type;
    }

    @Override // androidx.compose.ui.input.indirect.IndirectTouchEvent
    public long getUptimeMillis() {
        return this.uptimeMillis;
    }

    private AndroidIndirectTouchEvent(long r100, long r101, int r102, MotionEvent r103) {
        this.position = r100;
        this.uptimeMillis = r101;
        this.type = r102;
        this.nativeEvent = r103;
    }
}
