package androidx.compose.ui.node;

import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.internal.InlineClassHelperKt;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u000fR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R$\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/node/CanFocusChecker;", "Landroidx/compose/ui/focus/FocusProperties;", "<init>", "()V", "canFocusValue", "", "Ljava/lang/Boolean;", "value", "canFocus", "getCanFocus", "()Z", "setCanFocus", "(Z)V", "isCanFocusSet", BasicTestActionHandler.TEST_ACTION_RESET, "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class CanFocusChecker implements FocusProperties {
    public static final CanFocusChecker INSTANCE = null;
    private static Boolean canFocusValue;

    static {
        INSTANCE = new CanFocusChecker();
    }

    private CanFocusChecker() {
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ FocusRequester getDown() {
        return FocusProperties.CC.$default$getDown(this);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ FocusRequester getEnd() {
        return FocusProperties.CC.$default$getEnd(this);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ Function1 getEnter() {
        return FocusProperties.CC.$default$getEnter(this);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ Function1 getExit() {
        return FocusProperties.CC.$default$getExit(this);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ FocusRequester getLeft() {
        return FocusProperties.CC.$default$getLeft(this);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ FocusRequester getNext() {
        return FocusProperties.CC.$default$getNext(this);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ Function1 getOnEnter() {
        return FocusProperties.CC.$default$getOnEnter(this);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ Function1 getOnExit() {
        return FocusProperties.CC.$default$getOnExit(this);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ FocusRequester getPrevious() {
        return FocusProperties.CC.$default$getPrevious(this);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ FocusRequester getRight() {
        return FocusProperties.CC.$default$getRight(this);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ FocusRequester getStart() {
        return FocusProperties.CC.$default$getStart(this);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ FocusRequester getUp() {
        return FocusProperties.CC.$default$getUp(this);
    }

    public final void reset() {
        canFocusValue = null;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ void setDown(FocusRequester r100) {
        FocusProperties.CC.$default$setDown(this, r100);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ void setEnd(FocusRequester r100) {
        FocusProperties.CC.$default$setEnd(this, r100);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ void setEnter(Function1 r100) {
        FocusProperties.CC.$default$setEnter(this, r100);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ void setExit(Function1 r100) {
        FocusProperties.CC.$default$setExit(this, r100);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ void setLeft(FocusRequester r100) {
        FocusProperties.CC.$default$setLeft(this, r100);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ void setNext(FocusRequester r100) {
        FocusProperties.CC.$default$setNext(this, r100);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ void setOnEnter(Function1 r100) {
        FocusProperties.CC.$default$setOnEnter(this, r100);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ void setOnExit(Function1 r100) {
        FocusProperties.CC.$default$setOnExit(this, r100);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ void setPrevious(FocusRequester r100) {
        FocusProperties.CC.$default$setPrevious(this, r100);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ void setRight(FocusRequester r100) {
        FocusProperties.CC.$default$setRight(this, r100);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ void setStart(FocusRequester r100) {
        FocusProperties.CC.$default$setStart(this, r100);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ void setUp(FocusRequester r100) {
        FocusProperties.CC.$default$setUp(this, r100);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public boolean getCanFocus() {
        Boolean r100 = canFocusValue;
        if (r100 != null) goto L5;
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("canFocus is read before it is written");
        throw new KotlinNothingValueException();
    L5:
        return r100.booleanValue();
    }

    public final boolean isCanFocusSet() {
        if (canFocusValue == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setCanFocus(boolean r100) {
        canFocusValue = Boolean.valueOf(r100);
    }
}
