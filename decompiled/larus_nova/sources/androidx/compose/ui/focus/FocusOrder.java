package androidx.compose.ui.focus;

import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Deprecated(message = "Use FocusProperties instead")
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR$\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR$\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR$\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR$\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR$\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\fR$\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\f¨\u0006\""}, d2 = {"Landroidx/compose/ui/focus/FocusOrder;", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "<init>", "(Landroidx/compose/ui/focus/FocusProperties;)V", "()V", TeaEventTrack.ACTION_DRAMA_NEXT, "Landroidx/compose/ui/focus/FocusRequester;", "getNext", "()Landroidx/compose/ui/focus/FocusRequester;", "setNext", "(Landroidx/compose/ui/focus/FocusRequester;)V", "previous", "getPrevious", "setPrevious", "up", "getUp", "setUp", ILiveRoomPlayFragmentConstant.LOG_DIRECTION_DOWN, "getDown", "setDown", "left", "getLeft", "setLeft", "right", "getRight", "setRight", "start", "getStart", "setStart", "end", "getEnd", "setEnd", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FocusOrder {
    public static final int $stable = 8;
    private final FocusProperties focusProperties;

    public FocusOrder() {
        this(new FocusPropertiesImpl());
    }

    public final FocusRequester getDown() {
        return this.focusProperties.getDown();
    }

    public final FocusRequester getEnd() {
        return this.focusProperties.getEnd();
    }

    public final FocusRequester getLeft() {
        return this.focusProperties.getLeft();
    }

    public final FocusRequester getNext() {
        return this.focusProperties.getNext();
    }

    public final FocusRequester getPrevious() {
        return this.focusProperties.getPrevious();
    }

    public final FocusRequester getRight() {
        return this.focusProperties.getRight();
    }

    public final FocusRequester getStart() {
        return this.focusProperties.getStart();
    }

    public final FocusRequester getUp() {
        return this.focusProperties.getUp();
    }

    public FocusOrder(FocusProperties r100) {
        this.focusProperties = r100;
    }

    public final void setDown(FocusRequester r100) {
        this.focusProperties.setDown(r100);
    }

    public final void setEnd(FocusRequester r100) {
        this.focusProperties.setEnd(r100);
    }

    public final void setLeft(FocusRequester r100) {
        this.focusProperties.setLeft(r100);
    }

    public final void setNext(FocusRequester r100) {
        this.focusProperties.setNext(r100);
    }

    public final void setPrevious(FocusRequester r100) {
        this.focusProperties.setPrevious(r100);
    }

    public final void setRight(FocusRequester r100) {
        this.focusProperties.setRight(r100);
    }

    public final void setStart(FocusRequester r100) {
        this.focusProperties.setStart(r100);
    }

    public final void setUp(FocusRequester r100) {
        this.focusProperties.setUp(r100);
    }
}
