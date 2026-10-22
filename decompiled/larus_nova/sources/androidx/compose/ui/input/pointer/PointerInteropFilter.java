package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0096\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInteropFilter;", "Landroidx/compose/ui/input/pointer/PointerInputModifier;", "<init>", "()V", "onTouchEvent", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "", "getOnTouchEvent", "()Lkotlin/jvm/functions/Function1;", "setOnTouchEvent", "(Lkotlin/jvm/functions/Function1;)V", "value", "Landroidx/compose/ui/input/pointer/RequestDisallowInterceptTouchEvent;", "requestDisallowInterceptTouchEvent", "getRequestDisallowInterceptTouchEvent", "()Landroidx/compose/ui/input/pointer/RequestDisallowInterceptTouchEvent;", "setRequestDisallowInterceptTouchEvent", "(Landroidx/compose/ui/input/pointer/RequestDisallowInterceptTouchEvent;)V", "disallowIntercept", "getDisallowIntercept$ui_release", "()Z", "setDisallowIntercept$ui_release", "(Z)V", "pointerInputFilter", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "getPointerInputFilter$annotations", "getPointerInputFilter", "()Landroidx/compose/ui/input/pointer/PointerInputFilter;", "DispatchToViewState", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PointerInteropFilter implements PointerInputModifier {
    public static final int $stable = 0;
    private boolean disallowIntercept;
    public Function1<? super MotionEvent, Boolean> onTouchEvent;
    private final PointerInputFilter pointerInputFilter;
    private RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInteropFilter$DispatchToViewState;", "", "<init>", "(Ljava/lang/String;I)V", "Unknown", "Dispatching", "NotDispatching", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum DispatchToViewState extends Enum<DispatchToViewState> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ DispatchToViewState[] $VALUES = null;
        public static final DispatchToViewState Dispatching = null;
        public static final DispatchToViewState NotDispatching = null;
        public static final DispatchToViewState Unknown = null;

        private static final /* synthetic */ DispatchToViewState[] $values() {
            return new DispatchToViewState[]{Unknown, Dispatching, NotDispatching};
        }

        public static EnumEntries<DispatchToViewState> getEntries() {
            return $ENTRIES;
        }

        static {
            Unknown = new DispatchToViewState("Unknown", 0);
            Dispatching = new DispatchToViewState("Dispatching", 1);
            NotDispatching = new DispatchToViewState("NotDispatching", 2);
            DispatchToViewState[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static DispatchToViewState[] values() {
            return (DispatchToViewState[]) $VALUES.clone();
        }

        public static DispatchToViewState valueOf(String r100) {
            return (DispatchToViewState) a.a(DispatchToViewState.class, r100);
        }

        private DispatchToViewState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ void getPointerInputFilter$annotations() {
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public final /* synthetic */ boolean all(Function1 r100) {
        return Modifier.Element.CC.$default$all(this, r100);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public final /* synthetic */ boolean any(Function1 r100) {
        return Modifier.Element.CC.$default$any(this, r100);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public final /* synthetic */ Object foldIn(Object r100, Function2 r101) {
        return Modifier.Element.CC.$default$foldIn(this, r100, r101);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public final /* synthetic */ Object foldOut(Object r100, Function2 r101) {
        return Modifier.Element.CC.$default$foldOut(this, r100, r101);
    }

    @Override // androidx.compose.ui.Modifier
    public final /* synthetic */ Modifier then(Modifier r100) {
        return Modifier.CC.$default$then(this, r100);
    }

    public final Function1<MotionEvent, Boolean> getOnTouchEvent() {
        Function1 r100 = this.onTouchEvent;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("onTouchEvent");
        return null;
    }

    public PointerInteropFilter() {
        this.pointerInputFilter = new PointerInteropFilter$pointerInputFilter$1(this);
    }

    public final boolean getDisallowIntercept$ui_release() {
        return this.disallowIntercept;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputModifier
    public PointerInputFilter getPointerInputFilter() {
        return this.pointerInputFilter;
    }

    public final RequestDisallowInterceptTouchEvent getRequestDisallowInterceptTouchEvent() {
        return this.requestDisallowInterceptTouchEvent;
    }

    public final void setDisallowIntercept$ui_release(boolean r100) {
        this.disallowIntercept = r100;
    }

    public final void setOnTouchEvent(Function1<? super MotionEvent, Boolean> r100) {
        this.onTouchEvent = r100;
    }

    public final void setRequestDisallowInterceptTouchEvent(RequestDisallowInterceptTouchEvent r100) {
        RequestDisallowInterceptTouchEvent r101 = this.requestDisallowInterceptTouchEvent;
        if (r101 == null) goto L5;
        r101.setPointerInteropFilter$ui_release(null);
    L5:
        this.requestDisallowInterceptTouchEvent = r100;
        if (r100 == null) goto L9;
        r100.setPointerInteropFilter$ui_release(this);
        return;
    }
}
