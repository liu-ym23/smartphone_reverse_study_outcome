package androidx.compose.ui.semantics;

import C7.c;
import S7.a;
import S7.k;
import S7.n;
import S7.o;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R5\u0010\n\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u00060\u00050\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR)\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR)\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\rR5\u0010\u0015\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u00130\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR9\u0010\u0019\u001a$\u0012 \u0012\u001e\b\u0001\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00130\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\rR/\u0010\u001c\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t0\u00060\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\rR/\u0010\u001f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\t0\u00060\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\rR/\u0010!\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u00060\u00050\u00048\u0006¢\u0006\f\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010\rR;\u0010$\u001a&\u0012\"\u0012 \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0#0\u00050\u00048\u0006¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b%\u0010\rR/\u0010&\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\t0\u00060\u00050\u00048\u0006¢\u0006\f\n\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\rR/\u0010(\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\t0\u00060\u00050\u00048\u0006¢\u0006\f\n\u0004\b(\u0010\u000b\u001a\u0004\b)\u0010\rR/\u0010*\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00060\u00050\u00048\u0006¢\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b+\u0010\rR)\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010\rR/\u0010.\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\t0\u00060\u00050\u00048\u0006¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b/\u0010\rR)\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\b0\u0010\u000b\u001a\u0004\b1\u0010\rR2\u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b2\u0010\u000b\u0012\u0004\b4\u0010\u0003\u001a\u0004\b3\u0010\rR)\u00105\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\rR)\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\b7\u0010\u000b\u001a\u0004\b8\u0010\rR)\u00109\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\b9\u0010\u000b\u001a\u0004\b:\u0010\rR)\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\b;\u0010\u000b\u001a\u0004\b<\u0010\rR)\u0010=\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\b=\u0010\u000b\u001a\u0004\b>\u0010\rR)\u0010?\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\b?\u0010\u000b\u001a\u0004\b@\u0010\rR)\u0010A\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\bA\u0010\u000b\u001a\u0004\bB\u0010\rR#\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0C0\u00048\u0006¢\u0006\f\n\u0004\bE\u0010\u000b\u001a\u0004\bF\u0010\rR)\u0010G\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\bG\u0010\u000b\u001a\u0004\bH\u0010\rR)\u0010I\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\bI\u0010\u000b\u001a\u0004\bJ\u0010\rR)\u0010K\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\bK\u0010\u000b\u001a\u0004\bL\u0010\rR)\u0010M\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\bM\u0010\u000b\u001a\u0004\bN\u0010\rR5\u0010O\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0007\u0012\u0004\u0012\u00020\t0\u00060\u00050\u00048\u0006¢\u0006\f\n\u0004\bO\u0010\u000b\u001a\u0004\bP\u0010\r¨\u0006Q"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsActions;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/compose/ui/semantics/AccessibilityAction;", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/TextLayoutResult;", "", "GetTextLayoutResult", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "getGetTextLayoutResult", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Lkotlin/Function0;", "OnClick", "getOnClick", "OnLongClick", "getOnLongClick", "Lkotlin/Function2;", "", "ScrollBy", "getScrollBy", "Landroidx/compose/ui/geometry/Offset;", "LH7/c;", "ScrollByOffset", "getScrollByOffset", "", "ScrollToIndex", "getScrollToIndex", "Landroidx/compose/ui/text/AnnotatedString;", "OnAutofillText", "getOnAutofillText", "SetProgress", "getSetProgress", "Lkotlin/Function3;", "SetSelection", "getSetSelection", "SetText", "getSetText", "SetTextSubstitution", "getSetTextSubstitution", "ShowTextSubstitution", "getShowTextSubstitution", "ClearTextSubstitution", "getClearTextSubstitution", "InsertTextAtCursor", "getInsertTextAtCursor", "OnImeAction", "getOnImeAction", "PerformImeAction", "getPerformImeAction", "getPerformImeAction$annotations", "CopyText", "getCopyText", "CutText", "getCutText", "PasteText", "getPasteText", "Expand", "getExpand", "Collapse", "getCollapse", "Dismiss", "getDismiss", "RequestFocus", "getRequestFocus", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "CustomActions", "getCustomActions", "PageUp", "getPageUp", "PageLeft", "getPageLeft", "PageDown", "getPageDown", "PageRight", "getPageRight", "GetScrollViewportLength", "getGetScrollViewportLength", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SemanticsActions {
    public static final int $stable;
    private static final SemanticsPropertyKey<AccessibilityAction<a>> ClearTextSubstitution;
    private static final SemanticsPropertyKey<AccessibilityAction<a>> Collapse;
    private static final SemanticsPropertyKey<AccessibilityAction<a>> CopyText;
    private static final SemanticsPropertyKey<List<CustomAccessibilityAction>> CustomActions;
    private static final SemanticsPropertyKey<AccessibilityAction<a>> CutText;
    private static final SemanticsPropertyKey<AccessibilityAction<a>> Dismiss;
    private static final SemanticsPropertyKey<AccessibilityAction<a>> Expand;
    private static final SemanticsPropertyKey<AccessibilityAction<k>> GetScrollViewportLength;
    private static final SemanticsPropertyKey<AccessibilityAction<k>> GetTextLayoutResult;
    public static final SemanticsActions INSTANCE = new SemanticsActions();
    private static final SemanticsPropertyKey<AccessibilityAction<k>> InsertTextAtCursor;
    private static final SemanticsPropertyKey<AccessibilityAction<k>> OnAutofillText;
    private static final SemanticsPropertyKey<AccessibilityAction<a>> OnClick;
    private static final SemanticsPropertyKey<AccessibilityAction<a>> OnImeAction;
    private static final SemanticsPropertyKey<AccessibilityAction<a>> OnLongClick;
    private static final SemanticsPropertyKey<AccessibilityAction<a>> PageDown;
    private static final SemanticsPropertyKey<AccessibilityAction<a>> PageLeft;
    private static final SemanticsPropertyKey<AccessibilityAction<a>> PageRight;
    private static final SemanticsPropertyKey<AccessibilityAction<a>> PageUp;
    private static final SemanticsPropertyKey<AccessibilityAction<a>> PasteText;
    private static final SemanticsPropertyKey<AccessibilityAction<a>> PerformImeAction;
    private static final SemanticsPropertyKey<AccessibilityAction<a>> RequestFocus;
    private static final SemanticsPropertyKey<AccessibilityAction<n>> ScrollBy;
    private static final SemanticsPropertyKey<n> ScrollByOffset;
    private static final SemanticsPropertyKey<AccessibilityAction<k>> ScrollToIndex;
    private static final SemanticsPropertyKey<AccessibilityAction<k>> SetProgress;
    private static final SemanticsPropertyKey<AccessibilityAction<o>> SetSelection;
    private static final SemanticsPropertyKey<AccessibilityAction<k>> SetText;
    private static final SemanticsPropertyKey<AccessibilityAction<k>> SetTextSubstitution;
    private static final SemanticsPropertyKey<AccessibilityAction<k>> ShowTextSubstitution;

    static {
        SemanticsPropertiesKt.AnonymousClass1 anonymousClass1 = SemanticsPropertiesKt.AnonymousClass1.INSTANCE;
        GetTextLayoutResult = new SemanticsPropertyKey<>("GetTextLayoutResult", true, anonymousClass1, null, 8, null);
        OnClick = new SemanticsPropertyKey<>("OnClick", true, anonymousClass1, null, 8, null);
        OnLongClick = new SemanticsPropertyKey<>("OnLongClick", true, anonymousClass1, null, 8, null);
        ScrollBy = new SemanticsPropertyKey<>("ScrollBy", true, anonymousClass1, null, 8, null);
        ScrollByOffset = new SemanticsPropertyKey<>("ScrollByOffset", (n) null, 2, (e) null);
        ScrollToIndex = new SemanticsPropertyKey<>("ScrollToIndex", true, anonymousClass1, null, 8, null);
        OnAutofillText = new SemanticsPropertyKey<>("OnAutofillText", true, anonymousClass1, null, 8, null);
        SetProgress = new SemanticsPropertyKey<>("SetProgress", true, anonymousClass1, null, 8, null);
        SetSelection = new SemanticsPropertyKey<>("SetSelection", true, anonymousClass1, null, 8, null);
        SetText = new SemanticsPropertyKey<>("SetText", true, anonymousClass1, null, 8, null);
        SetTextSubstitution = new SemanticsPropertyKey<>("SetTextSubstitution", true, anonymousClass1, null, 8, null);
        ShowTextSubstitution = new SemanticsPropertyKey<>("ShowTextSubstitution", true, anonymousClass1, null, 8, null);
        ClearTextSubstitution = new SemanticsPropertyKey<>("ClearTextSubstitution", true, anonymousClass1, null, 8, null);
        InsertTextAtCursor = new SemanticsPropertyKey<>("InsertTextAtCursor", true, anonymousClass1, null, 8, null);
        OnImeAction = new SemanticsPropertyKey<>("PerformImeAction", true, anonymousClass1, null, 8, null);
        PerformImeAction = new SemanticsPropertyKey<>("PerformImeAction", true, anonymousClass1, null, 8, null);
        CopyText = new SemanticsPropertyKey<>("CopyText", true, anonymousClass1, null, 8, null);
        CutText = new SemanticsPropertyKey<>("CutText", true, anonymousClass1, null, 8, null);
        PasteText = new SemanticsPropertyKey<>("PasteText", true, anonymousClass1, null, 8, null);
        Expand = new SemanticsPropertyKey<>("Expand", true, anonymousClass1, null, 8, null);
        Collapse = new SemanticsPropertyKey<>("Collapse", true, anonymousClass1, null, 8, null);
        Dismiss = new SemanticsPropertyKey<>("Dismiss", true, anonymousClass1, null, 8, null);
        RequestFocus = new SemanticsPropertyKey<>("RequestFocus", true, anonymousClass1, null, 8, null);
        CustomActions = new SemanticsPropertyKey<>("CustomActions", true);
        PageUp = new SemanticsPropertyKey<>("PageUp", true, anonymousClass1, null, 8, null);
        PageLeft = new SemanticsPropertyKey<>("PageLeft", true, anonymousClass1, null, 8, null);
        PageDown = new SemanticsPropertyKey<>("PageDown", true, anonymousClass1, null, 8, null);
        PageRight = new SemanticsPropertyKey<>("PageRight", true, anonymousClass1, null, 8, null);
        GetScrollViewportLength = new SemanticsPropertyKey<>("GetScrollViewportLength", true, anonymousClass1, null, 8, null);
        $stable = 8;
    }

    private SemanticsActions() {
    }

    @c
    public static /* synthetic */ void getPerformImeAction$annotations() {
    }

    public final SemanticsPropertyKey<AccessibilityAction<a>> getClearTextSubstitution() {
        return ClearTextSubstitution;
    }

    public final SemanticsPropertyKey<AccessibilityAction<a>> getCollapse() {
        return Collapse;
    }

    public final SemanticsPropertyKey<AccessibilityAction<a>> getCopyText() {
        return CopyText;
    }

    public final SemanticsPropertyKey<List<CustomAccessibilityAction>> getCustomActions() {
        return CustomActions;
    }

    public final SemanticsPropertyKey<AccessibilityAction<a>> getCutText() {
        return CutText;
    }

    public final SemanticsPropertyKey<AccessibilityAction<a>> getDismiss() {
        return Dismiss;
    }

    public final SemanticsPropertyKey<AccessibilityAction<a>> getExpand() {
        return Expand;
    }

    public final SemanticsPropertyKey<AccessibilityAction<k>> getGetScrollViewportLength() {
        return GetScrollViewportLength;
    }

    public final SemanticsPropertyKey<AccessibilityAction<k>> getGetTextLayoutResult() {
        return GetTextLayoutResult;
    }

    public final SemanticsPropertyKey<AccessibilityAction<k>> getInsertTextAtCursor() {
        return InsertTextAtCursor;
    }

    public final SemanticsPropertyKey<AccessibilityAction<k>> getOnAutofillText() {
        return OnAutofillText;
    }

    public final SemanticsPropertyKey<AccessibilityAction<a>> getOnClick() {
        return OnClick;
    }

    public final SemanticsPropertyKey<AccessibilityAction<a>> getOnImeAction() {
        return OnImeAction;
    }

    public final SemanticsPropertyKey<AccessibilityAction<a>> getOnLongClick() {
        return OnLongClick;
    }

    public final SemanticsPropertyKey<AccessibilityAction<a>> getPageDown() {
        return PageDown;
    }

    public final SemanticsPropertyKey<AccessibilityAction<a>> getPageLeft() {
        return PageLeft;
    }

    public final SemanticsPropertyKey<AccessibilityAction<a>> getPageRight() {
        return PageRight;
    }

    public final SemanticsPropertyKey<AccessibilityAction<a>> getPageUp() {
        return PageUp;
    }

    public final SemanticsPropertyKey<AccessibilityAction<a>> getPasteText() {
        return PasteText;
    }

    public final SemanticsPropertyKey<AccessibilityAction<a>> getPerformImeAction() {
        return PerformImeAction;
    }

    public final SemanticsPropertyKey<AccessibilityAction<a>> getRequestFocus() {
        return RequestFocus;
    }

    public final SemanticsPropertyKey<AccessibilityAction<n>> getScrollBy() {
        return ScrollBy;
    }

    public final SemanticsPropertyKey<n> getScrollByOffset() {
        return ScrollByOffset;
    }

    public final SemanticsPropertyKey<AccessibilityAction<k>> getScrollToIndex() {
        return ScrollToIndex;
    }

    public final SemanticsPropertyKey<AccessibilityAction<k>> getSetProgress() {
        return SetProgress;
    }

    public final SemanticsPropertyKey<AccessibilityAction<o>> getSetSelection() {
        return SetSelection;
    }

    public final SemanticsPropertyKey<AccessibilityAction<k>> getSetText() {
        return SetText;
    }

    public final SemanticsPropertyKey<AccessibilityAction<k>> getSetTextSubstitution() {
        return SetTextSubstitution;
    }

    public final SemanticsPropertyKey<AccessibilityAction<k>> getShowTextSubstitution() {
        return ShowTextSubstitution;
    }
}
