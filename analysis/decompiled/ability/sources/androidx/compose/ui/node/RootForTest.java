package androidx.compose.ui.node;

import C7.c;
import android.view.KeyEvent;
import androidx.compose.ui.ExperimentalIndirectTouchTypeApi;
import androidx.compose.ui.input.indirect.IndirectTouchEvent;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001'J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001e\u001a\u00020\u001a8&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\"\u001a\u00020\u001f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006(À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/RootForTest;", "", "Landroidx/compose/ui/input/key/KeyEvent;", "keyEvent", "", "sendKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "sendKeyEvent", "Landroidx/compose/ui/input/indirect/IndirectTouchEvent;", "indirectTouchEvent", "sendIndirectTouchEvent", "(Landroidx/compose/ui/input/indirect/IndirectTouchEvent;)Z", "enable", "LC7/r;", "forceAccessibilityForTesting", "(Z)V", "", "intervalMillis", "setAccessibilityEventBatchIntervalMillis", "(J)V", "measureAndLayoutForTest", "()V", "Landroidx/compose/ui/node/RootForTest$UncaughtExceptionHandler;", "handler", "setUncaughtExceptionHandler", "(Landroidx/compose/ui/node/RootForTest$UncaughtExceptionHandler;)V", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "getTextInputService$annotations", "textInputService", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/semantics/SemanticsOwner;", "getSemanticsOwner", "()Landroidx/compose/ui/semantics/SemanticsOwner;", "semanticsOwner", "UncaughtExceptionHandler", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface RootForTest {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/RootForTest$UncaughtExceptionHandler;", "", "", "t", "LC7/r;", "onUncaughtException", "(Ljava/lang/Throwable;)V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface UncaughtExceptionHandler {
        void onUncaughtException(Throwable t9);
    }

    @c
    static /* synthetic */ void getTextInputService$annotations() {
    }

    default void forceAccessibilityForTesting(boolean enable) {
    }

    Density getDensity();

    SemanticsOwner getSemanticsOwner();

    TextInputService getTextInputService();

    default void measureAndLayoutForTest() {
    }

    @ExperimentalIndirectTouchTypeApi
    default boolean sendIndirectTouchEvent(IndirectTouchEvent indirectTouchEvent) {
        return false;
    }

    /* renamed from: sendKeyEvent-ZmokQxo, reason: not valid java name */
    boolean mo5926sendKeyEventZmokQxo(KeyEvent keyEvent);

    default void setAccessibilityEventBatchIntervalMillis(long intervalMillis) {
    }

    default void setUncaughtExceptionHandler(UncaughtExceptionHandler handler) {
    }
}
