package androidx.compose.ui.focus;

import com.alipay.sdk.m.x.d;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001a\u0010\u001f\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001a\u0010\"\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR+\u0010%\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0&¢\u0006\u0002\b)X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R+\u0010.\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0&¢\u0006\u0002\b)X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-¨\u00061"}, d2 = {"Landroidx/compose/ui/focus/FocusPropertiesImpl;", "Landroidx/compose/ui/focus/FocusProperties;", "<init>", "()V", "canFocus", "", "getCanFocus", "()Z", "setCanFocus", "(Z)V", TeaEventTrack.ACTION_DRAMA_NEXT, "Landroidx/compose/ui/focus/FocusRequester;", "getNext", "()Landroidx/compose/ui/focus/FocusRequester;", "setNext", "(Landroidx/compose/ui/focus/FocusRequester;)V", "previous", "getPrevious", "setPrevious", "up", "getUp", "setUp", ILiveRoomPlayFragmentConstant.LOG_DIRECTION_DOWN, "getDown", "setDown", "left", "getLeft", "setLeft", "right", "getRight", "setRight", "start", "getStart", "setStart", "end", "getEnd", "setEnd", "onEnter", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusEnterExitScope;", "", "Lkotlin/ExtensionFunctionType;", "getOnEnter", "()Lkotlin/jvm/functions/Function1;", "setOnEnter", "(Lkotlin/jvm/functions/Function1;)V", d.f25928r, "getOnExit", "setOnExit", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FocusPropertiesImpl implements FocusProperties {
    public static final int $stable = 8;
    private boolean canFocus;
    private FocusRequester down;
    private FocusRequester end;
    private FocusRequester left;
    private FocusRequester next;
    private Function1<? super FocusEnterExitScope, Unit> onEnter;
    private Function1<? super FocusEnterExitScope, Unit> onExit;
    private FocusRequester previous;
    private FocusRequester right;
    private FocusRequester start;

    /* JADX INFO: renamed from: up, reason: collision with root package name */
    private FocusRequester f15179up;

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ Function1 getEnter() {
        return FocusProperties.CC.$default$getEnter(this);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ Function1 getExit() {
        return FocusProperties.CC.$default$getExit(this);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ void setEnter(Function1 r100) {
        FocusProperties.CC.$default$setEnter(this, r100);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ void setExit(Function1 r100) {
        FocusProperties.CC.$default$setExit(this, r100);
    }

    public FocusPropertiesImpl() {
        this.canFocus = true;
        FocusRequester.Companion r100 = FocusRequester.Companion;
        this.next = r100.getDefault();
        this.previous = r100.getDefault();
        this.f15179up = r100.getDefault();
        this.down = r100.getDefault();
        this.left = r100.getDefault();
        this.right = r100.getDefault();
        this.start = r100.getDefault();
        this.end = r100.getDefault();
        this.onEnter = FocusPropertiesImpl$onEnter$1.INSTANCE;
        this.onExit = FocusPropertiesImpl$onExit$1.INSTANCE;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public boolean getCanFocus() {
        return this.canFocus;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public FocusRequester getDown() {
        return this.down;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public FocusRequester getEnd() {
        return this.end;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public FocusRequester getLeft() {
        return this.left;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public FocusRequester getNext() {
        return this.next;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public Function1<FocusEnterExitScope, Unit> getOnEnter() {
        return this.onEnter;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public Function1<FocusEnterExitScope, Unit> getOnExit() {
        return this.onExit;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public FocusRequester getPrevious() {
        return this.previous;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public FocusRequester getRight() {
        return this.right;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public FocusRequester getStart() {
        return this.start;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public FocusRequester getUp() {
        return this.f15179up;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setCanFocus(boolean r100) {
        this.canFocus = r100;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setDown(FocusRequester r100) {
        this.down = r100;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setEnd(FocusRequester r100) {
        this.end = r100;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setLeft(FocusRequester r100) {
        this.left = r100;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setNext(FocusRequester r100) {
        this.next = r100;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setOnEnter(Function1<? super FocusEnterExitScope, Unit> r100) {
        this.onEnter = r100;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setOnExit(Function1<? super FocusEnterExitScope, Unit> r100) {
        this.onExit = r100;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setPrevious(FocusRequester r100) {
        this.previous = r100;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setRight(FocusRequester r100) {
        this.right = r100;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setStart(FocusRequester r100) {
        this.start = r100;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setUp(FocusRequester r100) {
        this.f15179up = r100;
    }
}
