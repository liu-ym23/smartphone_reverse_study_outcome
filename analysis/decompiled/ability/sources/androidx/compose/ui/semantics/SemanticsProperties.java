package androidx.compose.ui.semantics;

import C7.c;
import C7.r;
import D7.v;
import S7.k;
import S7.n;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.autofill.ContentDataType;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\nR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\nR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0011\u0010\nR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0014\u0010\nR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0017\u0010\nR\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\b\u001a\u0004\b\u001a\u0010\nR\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u00048\u0006¢\u0006\f\n\u0004\b\u001b\u0010\b\u001a\u0004\b\u001c\u0010\nR\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u00048\u0006¢\u0006\f\n\u0004\b\u001d\u0010\b\u001a\u0004\b\u001e\u0010\nR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00048\u0006¢\u0006\f\n\u0004\b \u0010\b\u001a\u0004\b!\u0010\nR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00048\u0006¢\u0006\f\n\u0004\b#\u0010\b\u001a\u0004\b$\u0010\nR&\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b%\u0010\b\u0012\u0004\b'\u0010\u0003\u001a\u0004\b&\u0010\nR\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\"0\u00048\u0006¢\u0006\f\n\u0004\b(\u0010\b\u001a\u0004\b)\u0010\nR\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\"0\u00048\u0006¢\u0006\f\n\u0004\b*\u0010\b\u001a\u0004\b+\u0010\nR&\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b,\u0010\b\u0012\u0004\b.\u0010\u0003\u001a\u0004\b-\u0010\nR\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00120\u00048\u0006¢\u0006\f\n\u0004\b/\u0010\b\u001a\u0004\b0\u0010\nR\u001d\u00102\u001a\b\u0012\u0004\u0012\u0002010\u00048\u0006¢\u0006\f\n\u0004\b2\u0010\b\u001a\u0004\b3\u0010\nR\u001d\u00105\u001a\b\u0012\u0004\u0012\u0002040\u00048\u0006¢\u0006\f\n\u0004\b5\u0010\b\u001a\u0004\b6\u0010\nR\u001d\u00108\u001a\b\u0012\u0004\u0012\u0002070\u00048\u0006¢\u0006\f\n\u0004\b8\u0010\b\u001a\u0004\b9\u0010\nR\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020:0\u00048\u0006¢\u0006\f\n\u0004\b;\u0010\b\u001a\u0004\b<\u0010\nR\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020:0\u00048\u0006¢\u0006\f\n\u0004\b=\u0010\b\u001a\u0004\b>\u0010\nR\u001d\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00120\u00048\u0006¢\u0006\f\n\u0004\b?\u0010\b\u001a\u0004\b@\u0010\nR\u001d\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00120\u00048\u0006¢\u0006\f\n\u0004\bA\u0010\b\u001a\u0004\bB\u0010\nR\u001d\u0010D\u001a\b\u0012\u0004\u0012\u00020C0\u00048\u0006¢\u0006\f\n\u0004\bD\u0010\b\u001a\u0004\bE\u0010\nR\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\bF\u0010\b\u001a\u0004\bG\u0010\nR\u001d\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00120\u00048\u0006¢\u0006\f\n\u0004\bH\u0010\b\u001a\u0004\bI\u0010\nR#\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0\u00050\u00048\u0006¢\u0006\f\n\u0004\bK\u0010\b\u001a\u0004\bL\u0010\nR\u001d\u0010M\u001a\b\u0012\u0004\u0012\u00020J0\u00048\u0006¢\u0006\f\n\u0004\bM\u0010\b\u001a\u0004\bN\u0010\nR\u001d\u0010O\u001a\b\u0012\u0004\u0012\u00020\"0\u00048\u0006¢\u0006\f\n\u0004\bO\u0010\b\u001a\u0004\bP\u0010\nR\u001d\u0010Q\u001a\b\u0012\u0004\u0012\u00020J0\u00048\u0006¢\u0006\f\n\u0004\bQ\u0010\b\u001a\u0004\bR\u0010\nR\u001d\u0010S\u001a\b\u0012\u0004\u0012\u00020J0\u00048\u0006¢\u0006\f\n\u0004\bS\u0010\b\u001a\u0004\bT\u0010\nR\u001d\u0010V\u001a\b\u0012\u0004\u0012\u00020U0\u00048\u0006¢\u0006\f\n\u0004\bV\u0010\b\u001a\u0004\bW\u0010\nR\u001d\u0010Y\u001a\b\u0012\u0004\u0012\u00020X0\u00048\u0006¢\u0006\f\n\u0004\bY\u0010\b\u001a\u0004\bZ\u0010\nR\u001d\u0010[\u001a\b\u0012\u0004\u0012\u00020\"0\u00048\u0006¢\u0006\f\n\u0004\b[\u0010\b\u001a\u0004\b\\\u0010\nR\u001d\u0010^\u001a\b\u0012\u0004\u0012\u00020]0\u00048\u0006¢\u0006\f\n\u0004\b^\u0010\b\u001a\u0004\b_\u0010\nR\u001d\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00120\u00048\u0006¢\u0006\f\n\u0004\b`\u0010\b\u001a\u0004\ba\u0010\nR\u001d\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\bb\u0010\b\u001a\u0004\bc\u0010\nR)\u0010f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020e0d0\u00048\u0006¢\u0006\f\n\u0004\bf\u0010\b\u001a\u0004\bg\u0010\nR\u001d\u0010h\u001a\b\u0012\u0004\u0012\u00020\"0\u00048\u0006¢\u0006\f\n\u0004\bh\u0010\b\u001a\u0004\bi\u0010\nR\u001d\u0010j\u001a\b\u0012\u0004\u0012\u00020e0\u00048\u0006¢\u0006\f\n\u0004\bj\u0010\b\u001a\u0004\bk\u0010\nR\u001d\u0010m\u001a\b\u0012\u0004\u0012\u00020l0\u00048\u0006¢\u0006\f\n\u0004\bm\u0010\b\u001a\u0004\bn\u0010\n¨\u0006o"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsProperties;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "", "", "ContentDescription", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "getContentDescription", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "StateDescription", "getStateDescription", "Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "ProgressBarRangeInfo", "getProgressBarRangeInfo", "PaneTitle", "getPaneTitle", "LC7/r;", "SelectableGroup", "getSelectableGroup", "Landroidx/compose/ui/semantics/CollectionInfo;", "CollectionInfo", "getCollectionInfo", "Landroidx/compose/ui/semantics/CollectionItemInfo;", "CollectionItemInfo", "getCollectionItemInfo", "Heading", "getHeading", "Disabled", "getDisabled", "Landroidx/compose/ui/semantics/LiveRegionMode;", "LiveRegion", "getLiveRegion", "", "Focused", "getFocused", "IsContainer", "getIsContainer", "getIsContainer$annotations", "IsTraversalGroup", "getIsTraversalGroup", "IsSensitiveData", "getIsSensitiveData", "InvisibleToUser", "getInvisibleToUser", "getInvisibleToUser$annotations", "HideFromAccessibility", "getHideFromAccessibility", "Landroidx/compose/ui/autofill/ContentType;", "ContentType", "getContentType", "Landroidx/compose/ui/autofill/ContentDataType;", "ContentDataType", "getContentDataType", "", "TraversalIndex", "getTraversalIndex", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "HorizontalScrollAxisRange", "getHorizontalScrollAxisRange", "VerticalScrollAxisRange", "getVerticalScrollAxisRange", "IsPopup", "getIsPopup", "IsDialog", "getIsDialog", "Landroidx/compose/ui/semantics/Role;", "Role", "getRole", "TestTag", "getTestTag", "LinkTestMarker", "getLinkTestMarker", "Landroidx/compose/ui/text/AnnotatedString;", "Text", "getText", "TextSubstitution", "getTextSubstitution", "IsShowingTextSubstitution", "getIsShowingTextSubstitution", "InputText", "getInputText", "EditableText", "getEditableText", "Landroidx/compose/ui/text/TextRange;", "TextSelectionRange", "getTextSelectionRange", "Landroidx/compose/ui/text/input/ImeAction;", "ImeAction", "getImeAction", "Selected", "getSelected", "Landroidx/compose/ui/state/ToggleableState;", "ToggleableState", "getToggleableState", "Password", "getPassword", "Error", "getError", "Lkotlin/Function1;", "", "IndexForKey", "getIndexForKey", "IsEditable", "getIsEditable", "MaxTextLength", "getMaxTextLength", "Landroidx/compose/ui/graphics/Shape;", "Shape", "getShape", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SemanticsProperties {
    public static final SemanticsProperties INSTANCE = new SemanticsProperties();
    private static final SemanticsPropertyKey<List<String>> ContentDescription = new SemanticsPropertyKey<>("ContentDescription", true, new n() { // from class: androidx.compose.ui.semantics.SemanticsProperties$ContentDescription$1
        @Override // S7.n
        public final List<String> invoke(List<String> list, List<String> list2) {
            if (list == null) {
                return list2;
            }
            ArrayList arrayListG1 = v.g1(list);
            arrayListG1.addAll(list2);
            return arrayListG1;
        }
    }, null, 8, null);
    private static final SemanticsPropertyKey<String> StateDescription = new SemanticsPropertyKey<>("StateDescription", true);
    private static final SemanticsPropertyKey<ProgressBarRangeInfo> ProgressBarRangeInfo = new SemanticsPropertyKey<>("ProgressBarRangeInfo", true);
    private static final SemanticsPropertyKey<String> PaneTitle = new SemanticsPropertyKey<>("PaneTitle", true, new n() { // from class: androidx.compose.ui.semantics.SemanticsProperties$PaneTitle$1
        @Override // S7.n
        public final String invoke(String str, String str2) {
            throw new IllegalStateException("merge function called on unmergeable property PaneTitle.");
        }
    }, null, 8, null);
    private static final SemanticsPropertyKey<r> SelectableGroup = new SemanticsPropertyKey<>("SelectableGroup", true);
    private static final SemanticsPropertyKey<CollectionInfo> CollectionInfo = new SemanticsPropertyKey<>("CollectionInfo", true);
    private static final SemanticsPropertyKey<CollectionItemInfo> CollectionItemInfo = new SemanticsPropertyKey<>("CollectionItemInfo", true);
    private static final SemanticsPropertyKey<r> Heading = new SemanticsPropertyKey<>("Heading", true);
    private static final SemanticsPropertyKey<r> Disabled = new SemanticsPropertyKey<>("Disabled", true);
    private static final SemanticsPropertyKey<LiveRegionMode> LiveRegion = new SemanticsPropertyKey<>("LiveRegion", true);
    private static final SemanticsPropertyKey<Boolean> Focused = new SemanticsPropertyKey<>("Focused", true);
    private static final SemanticsPropertyKey<Boolean> IsContainer = new SemanticsPropertyKey<>("IsContainer", true);
    private static final SemanticsPropertyKey<Boolean> IsTraversalGroup = new SemanticsPropertyKey<>("IsTraversalGroup", (n) null, 2, (e) null);
    private static final SemanticsPropertyKey<Boolean> IsSensitiveData = new SemanticsPropertyKey<>("IsSensitiveData", (n) null, 2, (e) null);
    private static final SemanticsPropertyKey<r> InvisibleToUser = new SemanticsPropertyKey<>("InvisibleToUser", new n() { // from class: androidx.compose.ui.semantics.SemanticsProperties$InvisibleToUser$1
        @Override // S7.n
        public final r invoke(r rVar, r rVar2) {
            return rVar;
        }
    });
    private static final SemanticsPropertyKey<r> HideFromAccessibility = new SemanticsPropertyKey<>("HideFromAccessibility", new n() { // from class: androidx.compose.ui.semantics.SemanticsProperties$HideFromAccessibility$1
        @Override // S7.n
        public final r invoke(r rVar, r rVar2) {
            return rVar;
        }
    });
    private static final SemanticsPropertyKey<ContentType> ContentType = new SemanticsPropertyKey<>("ContentType", new n() { // from class: androidx.compose.ui.semantics.SemanticsProperties$ContentType$1
        @Override // S7.n
        public final ContentType invoke(ContentType contentType, ContentType contentType2) {
            return contentType;
        }
    });
    private static final SemanticsPropertyKey<ContentDataType> ContentDataType = new SemanticsPropertyKey<>("ContentDataType", new n() { // from class: androidx.compose.ui.semantics.SemanticsProperties$ContentDataType$1
        @Override // S7.n
        public final ContentDataType invoke(ContentDataType contentDataType, ContentDataType contentDataType2) {
            return contentDataType;
        }
    });
    private static final SemanticsPropertyKey<Float> TraversalIndex = new SemanticsPropertyKey<>("TraversalIndex", new n() { // from class: androidx.compose.ui.semantics.SemanticsProperties$TraversalIndex$1
        public final Float invoke(Float f, float f7) {
            return f;
        }

        @Override // S7.n
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke((Float) obj, ((Number) obj2).floatValue());
        }
    });
    private static final SemanticsPropertyKey<ScrollAxisRange> HorizontalScrollAxisRange = new SemanticsPropertyKey<>("HorizontalScrollAxisRange", true);
    private static final SemanticsPropertyKey<ScrollAxisRange> VerticalScrollAxisRange = new SemanticsPropertyKey<>("VerticalScrollAxisRange", true);
    private static final SemanticsPropertyKey<r> IsPopup = new SemanticsPropertyKey<>("IsPopup", true, new n() { // from class: androidx.compose.ui.semantics.SemanticsProperties$IsPopup$1
        @Override // S7.n
        public final r invoke(r rVar, r rVar2) {
            throw new IllegalStateException("merge function called on unmergeable property IsPopup. A popup should not be a child of a clickable/focusable node.");
        }
    }, null, 8, null);
    private static final SemanticsPropertyKey<r> IsDialog = new SemanticsPropertyKey<>("IsDialog", true, new n() { // from class: androidx.compose.ui.semantics.SemanticsProperties$IsDialog$1
        @Override // S7.n
        public final r invoke(r rVar, r rVar2) {
            throw new IllegalStateException("merge function called on unmergeable property IsDialog. A dialog should not be a child of a clickable/focusable node.");
        }
    }, null, 8, null);
    private static final SemanticsPropertyKey<Role> Role = new SemanticsPropertyKey<>("Role", true, new n() { // from class: androidx.compose.ui.semantics.SemanticsProperties$Role$1
        @Override // S7.n
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m6095invokeqtAw6s((Role) obj, ((Role) obj2).getValue());
        }

        /* renamed from: invoke-qtA-w6s, reason: not valid java name */
        public final Role m6095invokeqtAw6s(Role role, int i) {
            return role;
        }
    }, null, 8, null);
    private static final SemanticsPropertyKey<String> TestTag = new SemanticsPropertyKey<>("TestTag", false, new n() { // from class: androidx.compose.ui.semantics.SemanticsProperties$TestTag$1
        @Override // S7.n
        public final String invoke(String str, String str2) {
            return str;
        }
    }, null, 8, null);
    private static final SemanticsPropertyKey<r> LinkTestMarker = new SemanticsPropertyKey<>("LinkTestMarker", false, new n() { // from class: androidx.compose.ui.semantics.SemanticsProperties$LinkTestMarker$1
        @Override // S7.n
        public final r invoke(r rVar, r rVar2) {
            return rVar;
        }
    }, null, 8, null);
    private static final SemanticsPropertyKey<List<AnnotatedString>> Text = new SemanticsPropertyKey<>("Text", true, new n() { // from class: androidx.compose.ui.semantics.SemanticsProperties$Text$1
        @Override // S7.n
        public final List<AnnotatedString> invoke(List<AnnotatedString> list, List<AnnotatedString> list2) {
            if (list == null) {
                return list2;
            }
            ArrayList arrayListG1 = v.g1(list);
            arrayListG1.addAll(list2);
            return arrayListG1;
        }
    }, null, 8, null);
    private static final SemanticsPropertyKey<AnnotatedString> TextSubstitution = new SemanticsPropertyKey<>("TextSubstitution", (n) null, 2, (e) null);
    private static final SemanticsPropertyKey<Boolean> IsShowingTextSubstitution = new SemanticsPropertyKey<>("IsShowingTextSubstitution", (n) null, 2, (e) null);
    private static final SemanticsPropertyKey<AnnotatedString> InputText = new SemanticsPropertyKey<>("InputText", true);
    private static final SemanticsPropertyKey<AnnotatedString> EditableText = new SemanticsPropertyKey<>("EditableText", true);
    private static final SemanticsPropertyKey<TextRange> TextSelectionRange = new SemanticsPropertyKey<>("TextSelectionRange", true);
    private static final SemanticsPropertyKey<ImeAction> ImeAction = new SemanticsPropertyKey<>("ImeAction", true);
    private static final SemanticsPropertyKey<Boolean> Selected = new SemanticsPropertyKey<>("Selected", true);
    private static final SemanticsPropertyKey<ToggleableState> ToggleableState = new SemanticsPropertyKey<>("ToggleableState", true);
    private static final SemanticsPropertyKey<r> Password = new SemanticsPropertyKey<>("Password", true);
    private static final SemanticsPropertyKey<String> Error = new SemanticsPropertyKey<>("Error", true);
    private static final SemanticsPropertyKey<k> IndexForKey = new SemanticsPropertyKey<>("IndexForKey", (n) null, 2, (e) null);
    private static final SemanticsPropertyKey<Boolean> IsEditable = new SemanticsPropertyKey<>("IsEditable", (n) null, 2, (e) null);
    private static final SemanticsPropertyKey<Integer> MaxTextLength = new SemanticsPropertyKey<>("MaxTextLength", (n) null, 2, (e) null);
    private static final SemanticsPropertyKey<Shape> Shape = new SemanticsPropertyKey<>("Shape", false, new n() { // from class: androidx.compose.ui.semantics.SemanticsProperties$Shape$1
        @Override // S7.n
        public final Shape invoke(Shape shape, Shape shape2) {
            return shape;
        }
    }, null, 8, null);
    public static final int $stable = 8;

    private SemanticsProperties() {
    }

    @c
    public static /* synthetic */ void getInvisibleToUser$annotations() {
    }

    @c
    public static /* synthetic */ void getIsContainer$annotations() {
    }

    public final SemanticsPropertyKey<CollectionInfo> getCollectionInfo() {
        return CollectionInfo;
    }

    public final SemanticsPropertyKey<CollectionItemInfo> getCollectionItemInfo() {
        return CollectionItemInfo;
    }

    public final SemanticsPropertyKey<ContentDataType> getContentDataType() {
        return ContentDataType;
    }

    public final SemanticsPropertyKey<List<String>> getContentDescription() {
        return ContentDescription;
    }

    public final SemanticsPropertyKey<ContentType> getContentType() {
        return ContentType;
    }

    public final SemanticsPropertyKey<r> getDisabled() {
        return Disabled;
    }

    public final SemanticsPropertyKey<AnnotatedString> getEditableText() {
        return EditableText;
    }

    public final SemanticsPropertyKey<String> getError() {
        return Error;
    }

    public final SemanticsPropertyKey<Boolean> getFocused() {
        return Focused;
    }

    public final SemanticsPropertyKey<r> getHeading() {
        return Heading;
    }

    public final SemanticsPropertyKey<r> getHideFromAccessibility() {
        return HideFromAccessibility;
    }

    public final SemanticsPropertyKey<ScrollAxisRange> getHorizontalScrollAxisRange() {
        return HorizontalScrollAxisRange;
    }

    public final SemanticsPropertyKey<ImeAction> getImeAction() {
        return ImeAction;
    }

    public final SemanticsPropertyKey<k> getIndexForKey() {
        return IndexForKey;
    }

    public final SemanticsPropertyKey<AnnotatedString> getInputText() {
        return InputText;
    }

    public final SemanticsPropertyKey<r> getInvisibleToUser() {
        return InvisibleToUser;
    }

    public final SemanticsPropertyKey<Boolean> getIsContainer() {
        return IsContainer;
    }

    public final SemanticsPropertyKey<r> getIsDialog() {
        return IsDialog;
    }

    public final SemanticsPropertyKey<Boolean> getIsEditable() {
        return IsEditable;
    }

    public final SemanticsPropertyKey<r> getIsPopup() {
        return IsPopup;
    }

    public final SemanticsPropertyKey<Boolean> getIsSensitiveData() {
        return IsSensitiveData;
    }

    public final SemanticsPropertyKey<Boolean> getIsShowingTextSubstitution() {
        return IsShowingTextSubstitution;
    }

    public final SemanticsPropertyKey<Boolean> getIsTraversalGroup() {
        return IsTraversalGroup;
    }

    public final SemanticsPropertyKey<r> getLinkTestMarker() {
        return LinkTestMarker;
    }

    public final SemanticsPropertyKey<LiveRegionMode> getLiveRegion() {
        return LiveRegion;
    }

    public final SemanticsPropertyKey<Integer> getMaxTextLength() {
        return MaxTextLength;
    }

    public final SemanticsPropertyKey<String> getPaneTitle() {
        return PaneTitle;
    }

    public final SemanticsPropertyKey<r> getPassword() {
        return Password;
    }

    public final SemanticsPropertyKey<ProgressBarRangeInfo> getProgressBarRangeInfo() {
        return ProgressBarRangeInfo;
    }

    public final SemanticsPropertyKey<Role> getRole() {
        return Role;
    }

    public final SemanticsPropertyKey<r> getSelectableGroup() {
        return SelectableGroup;
    }

    public final SemanticsPropertyKey<Boolean> getSelected() {
        return Selected;
    }

    public final SemanticsPropertyKey<Shape> getShape() {
        return Shape;
    }

    public final SemanticsPropertyKey<String> getStateDescription() {
        return StateDescription;
    }

    public final SemanticsPropertyKey<String> getTestTag() {
        return TestTag;
    }

    public final SemanticsPropertyKey<List<AnnotatedString>> getText() {
        return Text;
    }

    public final SemanticsPropertyKey<TextRange> getTextSelectionRange() {
        return TextSelectionRange;
    }

    public final SemanticsPropertyKey<AnnotatedString> getTextSubstitution() {
        return TextSubstitution;
    }

    public final SemanticsPropertyKey<ToggleableState> getToggleableState() {
        return ToggleableState;
    }

    public final SemanticsPropertyKey<Float> getTraversalIndex() {
        return TraversalIndex;
    }

    public final SemanticsPropertyKey<ScrollAxisRange> getVerticalScrollAxisRange() {
        return VerticalScrollAxisRange;
    }
}
