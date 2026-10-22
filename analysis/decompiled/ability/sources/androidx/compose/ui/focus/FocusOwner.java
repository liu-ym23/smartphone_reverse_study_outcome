package androidx.compose.ui.focus;

import S7.a;
import S7.k;
import android.view.KeyEvent;
import androidx.collection.MutableObjectList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.indirect.IndirectTouchEvent;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b`\u0018\u00002\u00020\u0001J#\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ7\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0019\u001a\u00020\u0014H&¢\u0006\u0004\b\u0019\u0010\u0016J\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010%\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060!H&¢\u0006\u0004\b#\u0010$J\u0017\u0010(\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b&\u0010'J'\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060!H&¢\u0006\u0004\b+\u0010,J'\u0010.\u001a\u00020\u00062\u0006\u0010*\u001a\u00020-2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060!H&¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\u00142\u0006\u00100\u001a\u00020\fH&¢\u0006\u0004\b1\u00102J\u0017\u00101\u001a\u00020\u00142\u0006\u00100\u001a\u000203H&¢\u0006\u0004\b1\u00104J\u000f\u00105\u001a\u00020\u0014H&¢\u0006\u0004\b5\u0010\u0016R\u0014\u00109\u001a\u0002068&X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020;0:8&X¦\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8&X¦\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u001e\u0010F\u001a\u0004\u0018\u00010\f8&@&X¦\u000e¢\u0006\f\u001a\u0004\bC\u0010D\"\u0004\bE\u00102R\u001c\u0010G\u001a\u00020\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\bG\u0010H\"\u0004\bI\u0010Jø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006KÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/focus/FocusOwner;", "Landroidx/compose/ui/focus/FocusManager;", "Landroidx/compose/ui/focus/FocusDirection;", "focusDirection", "Landroidx/compose/ui/geometry/Rect;", "previouslyFocusedRect", "", "requestOwnerFocus-7o62pno", "(Landroidx/compose/ui/focus/FocusDirection;Landroidx/compose/ui/geometry/Rect;)Z", "requestOwnerFocus", "focusedRect", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusTargetNode;", "onFound", "focusSearch-ULY8qGw", "(ILandroidx/compose/ui/geometry/Rect;LS7/k;)Ljava/lang/Boolean;", "focusSearch", "takeFocus-aToIllA", "(ILandroidx/compose/ui/geometry/Rect;)Z", "takeFocus", "LC7/r;", "releaseFocus", "()V", "force", "refreshFocusEvents", "clearOwnerFocus", "clearFocus-I7lrPNg", "(ZZZI)Z", "clearFocus", "getFocusRect", "()Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/input/key/KeyEvent;", "keyEvent", "Lkotlin/Function0;", "onFocusedItem", "dispatchKeyEvent-YhN2O0w", "(Landroid/view/KeyEvent;LS7/a;)Z", "dispatchKeyEvent", "dispatchInterceptedSoftKeyboardEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchInterceptedSoftKeyboardEvent", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", NotificationCompat.CATEGORY_EVENT, "dispatchRotaryEvent", "(Landroidx/compose/ui/input/rotary/RotaryScrollEvent;LS7/a;)Z", "Landroidx/compose/ui/input/indirect/IndirectTouchEvent;", "dispatchIndirectTouchEvent", "(Landroidx/compose/ui/input/indirect/IndirectTouchEvent;LS7/a;)Z", "node", "scheduleInvalidation", "(Landroidx/compose/ui/focus/FocusTargetNode;)V", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "(Landroidx/compose/ui/focus/FocusEventModifierNode;)V", "scheduleInvalidationForOwner", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/focus/FocusListener;", "getListeners", "()Landroidx/collection/MutableObjectList;", "listeners", "Landroidx/compose/ui/focus/FocusState;", "getRootState", "()Landroidx/compose/ui/focus/FocusState;", "rootState", "getActiveFocusTargetNode", "()Landroidx/compose/ui/focus/FocusTargetNode;", "setActiveFocusTargetNode", "activeFocusTargetNode", "isFocusCaptured", "()Z", "setFocusCaptured", "(Z)V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface FocusOwner extends FocusManager {
    static /* synthetic */ boolean dispatchIndirectTouchEvent$default(FocusOwner focusOwner, IndirectTouchEvent indirectTouchEvent, a aVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchIndirectTouchEvent");
        }
        if ((i & 2) != 0) {
            aVar = new a() { // from class: androidx.compose.ui.focus.FocusOwner.dispatchIndirectTouchEvent.1
                @Override // S7.a
                public final Boolean invoke() {
                    return Boolean.FALSE;
                }
            };
        }
        return focusOwner.dispatchIndirectTouchEvent(indirectTouchEvent, aVar);
    }

    /* renamed from: dispatchKeyEvent-YhN2O0w$default, reason: not valid java name */
    static /* synthetic */ boolean m3787dispatchKeyEventYhN2O0w$default(FocusOwner focusOwner, KeyEvent keyEvent, a aVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchKeyEvent-YhN2O0w");
        }
        if ((i & 2) != 0) {
            aVar = new a() { // from class: androidx.compose.ui.focus.FocusOwner$dispatchKeyEvent$1
                @Override // S7.a
                public final Boolean invoke() {
                    return Boolean.FALSE;
                }
            };
        }
        return focusOwner.mo3790dispatchKeyEventYhN2O0w(keyEvent, aVar);
    }

    static /* synthetic */ boolean dispatchRotaryEvent$default(FocusOwner focusOwner, RotaryScrollEvent rotaryScrollEvent, a aVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchRotaryEvent");
        }
        if ((i & 2) != 0) {
            aVar = new a() { // from class: androidx.compose.ui.focus.FocusOwner.dispatchRotaryEvent.1
                @Override // S7.a
                public final Boolean invoke() {
                    return Boolean.FALSE;
                }
            };
        }
        return focusOwner.dispatchRotaryEvent(rotaryScrollEvent, aVar);
    }

    /* renamed from: clearFocus-I7lrPNg, reason: not valid java name */
    boolean mo3788clearFocusI7lrPNg(boolean force, boolean refreshFocusEvents, boolean clearOwnerFocus, int focusDirection);

    void clearOwnerFocus();

    boolean dispatchIndirectTouchEvent(IndirectTouchEvent event, a onFocusedItem);

    /* renamed from: dispatchInterceptedSoftKeyboardEvent-ZmokQxo, reason: not valid java name */
    boolean mo3789dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent keyEvent);

    /* renamed from: dispatchKeyEvent-YhN2O0w, reason: not valid java name */
    boolean mo3790dispatchKeyEventYhN2O0w(KeyEvent keyEvent, a onFocusedItem);

    boolean dispatchRotaryEvent(RotaryScrollEvent event, a onFocusedItem);

    /* renamed from: focusSearch-ULY8qGw, reason: not valid java name */
    Boolean mo3791focusSearchULY8qGw(int focusDirection, Rect focusedRect, k onFound);

    FocusTargetNode getActiveFocusTargetNode();

    Rect getFocusRect();

    MutableObjectList<FocusListener> getListeners();

    Modifier getModifier();

    FocusState getRootState();

    boolean isFocusCaptured();

    void releaseFocus();

    /* renamed from: requestOwnerFocus-7o62pno, reason: not valid java name */
    boolean mo3792requestOwnerFocus7o62pno(FocusDirection focusDirection, Rect previouslyFocusedRect);

    void scheduleInvalidation(FocusEventModifierNode node);

    void scheduleInvalidation(FocusTargetNode node);

    void scheduleInvalidationForOwner();

    void setActiveFocusTargetNode(FocusTargetNode focusTargetNode);

    void setFocusCaptured(boolean z10);

    /* renamed from: takeFocus-aToIllA, reason: not valid java name */
    boolean mo3793takeFocusaToIllA(int focusDirection, Rect previouslyFocusedRect);
}
