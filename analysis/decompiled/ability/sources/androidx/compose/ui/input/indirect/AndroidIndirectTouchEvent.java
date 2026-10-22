package androidx.compose.ui.input.indirect;

import android.view.MotionEvent;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\t\u001a\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/input/indirect/AndroidIndirectTouchEvent;", "Landroidx/compose/ui/input/indirect/PlatformIndirectTouchEvent;", "Landroidx/compose/ui/geometry/Offset;", "position", "", "uptimeMillis", "Landroidx/compose/ui/input/indirect/IndirectTouchEventType;", "type", "Landroid/view/MotionEvent;", "nativeEvent", AppAgent.CONSTRUCT, "(JJILandroid/view/MotionEvent;Lkotlin/jvm/internal/e;)V", "J", "getPosition-F1C5BW0", "()J", "getUptimeMillis", "I", "getType-LxEHWp8", "()I", "Landroid/view/MotionEvent;", "getNativeEvent$ui_release", "()Landroid/view/MotionEvent;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidIndirectTouchEvent implements PlatformIndirectTouchEvent {
    public static final int $stable = 8;
    private final MotionEvent nativeEvent;
    private final long position;
    private final int type;
    private final long uptimeMillis;

    public /* synthetic */ AndroidIndirectTouchEvent(long j5, long j6, int i, MotionEvent motionEvent, e eVar) {
        this(j5, j6, i, motionEvent);
    }

    /* renamed from: getNativeEvent$ui_release, reason: from getter */
    public final MotionEvent getNativeEvent() {
        return this.nativeEvent;
    }

    @Override // androidx.compose.ui.input.indirect.IndirectTouchEvent
    /* renamed from: getPosition-F1C5BW0, reason: not valid java name and from getter */
    public long getPosition() {
        return this.position;
    }

    @Override // androidx.compose.ui.input.indirect.IndirectTouchEvent
    /* renamed from: getType-LxEHWp8, reason: not valid java name and from getter */
    public int getType() {
        return this.type;
    }

    @Override // androidx.compose.ui.input.indirect.IndirectTouchEvent
    public long getUptimeMillis() {
        return this.uptimeMillis;
    }

    private AndroidIndirectTouchEvent(long j5, long j6, int i, MotionEvent motionEvent) {
        this.position = j5;
        this.uptimeMillis = j6;
        this.type = i;
        this.nativeEvent = motionEvent;
    }
}
