package androidx.compose.ui.autofill;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.collection.ObjectListKt;
import androidx.compose.ui.focus.FocusListener;
import androidx.compose.ui.focus.FocusTargetModifierNode;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.platform.coreshims.AutofillIdCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsInfo;
import androidx.compose.ui.semantics.SemanticsListener;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.text.AnnotatedString;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u001c\u0010\u001b\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u000e\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&J\u0014\u0010'\u001a\u00020\u00192\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)J\u0015\u0010-\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\b.J\u0015\u0010/\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\b0J\u001d\u00101\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\u0006\u00102\u001a\u000203H\u0000¢\u0006\u0002\b4J\u0015\u00105\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\b6J\u0015\u00107\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\b8J\r\u0010;\u001a\u00020\u0019H\u0000¢\u0006\u0002\b<R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Landroidx/compose/ui/autofill/AndroidAutofillManager;", "Landroidx/compose/ui/autofill/AutofillManager;", "Landroidx/compose/ui/semantics/SemanticsListener;", "Landroidx/compose/ui/focus/FocusListener;", "platformAutofillManager", "Landroidx/compose/ui/autofill/PlatformAutofillManager;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "view", "Landroid/view/View;", "rectManager", "Landroidx/compose/ui/spatial/RectManager;", "packageName", "", "<init>", "(Landroidx/compose/ui/autofill/PlatformAutofillManager;Landroidx/compose/ui/semantics/SemanticsOwner;Landroid/view/View;Landroidx/compose/ui/spatial/RectManager;Ljava/lang/String;)V", "getPlatformAutofillManager", "()Landroidx/compose/ui/autofill/PlatformAutofillManager;", "setPlatformAutofillManager", "(Landroidx/compose/ui/autofill/PlatformAutofillManager;)V", "reusableRect", "Landroid/graphics/Rect;", "rootAutofillId", "Landroid/view/autofill/AutofillId;", "commit", "", "cancel", "onFocusChanged", "previous", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "current", "onSemanticsChanged", "semanticsInfo", "Landroidx/compose/ui/semantics/SemanticsInfo;", "previousSemanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "populateViewStructure", "rootViewStructure", "Landroid/view/ViewStructure;", "performAutofill", "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "currentlyDisplayedIDs", "Landroidx/collection/MutableIntSet;", "requestAutofill", "requestAutofill$ui_release", "onPostAttach", "onPostAttach$ui_release", "onPostLayoutNodeReused", "previousSemanticsId", "", "onPostLayoutNodeReused$ui_release", "onLayoutNodeDeactivated", "onLayoutNodeDeactivated$ui_release", "onDetach", "onDetach$ui_release", "pendingAutofillCommit", "", "onEndApplyChanges", "onEndApplyChanges$ui_release", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidAutofillManager extends AutofillManager implements SemanticsListener, FocusListener {
    public static final int $stable = 8;
    private MutableIntSet currentlyDisplayedIDs;
    private final String packageName;
    private boolean pendingAutofillCommit;
    private PlatformAutofillManager platformAutofillManager;
    private final RectManager rectManager;
    private Rect reusableRect;
    private AutofillId rootAutofillId;
    private final SemanticsOwner semanticsOwner;
    private final View view;

    @Override // androidx.compose.ui.autofill.AutofillManager
    public void cancel() {
        this.platformAutofillManager.cancel();
    }

    @Override // androidx.compose.ui.autofill.AutofillManager
    public void commit() {
        this.platformAutofillManager.commit();
    }

    public final void onEndApplyChanges$ui_release() {
        if (this.currentlyDisplayedIDs.isEmpty() == false) goto L8;
        if (this.pendingAutofillCommit == false) goto L8;
        this.platformAutofillManager.commit();
        this.pendingAutofillCommit = false;
    L8:
        if (this.currentlyDisplayedIDs.isNotEmpty() == false) goto L11;
        this.pendingAutofillCommit = true;
        return;
    }

    public final PlatformAutofillManager getPlatformAutofillManager() {
        return this.platformAutofillManager;
    }

    public static final /* synthetic */ Rect access$getReusableRect$p(AndroidAutofillManager r100) {
        return r100.reusableRect;
    }

    public static final /* synthetic */ View access$getView$p(AndroidAutofillManager r100) {
        return r100.view;
    }

    public final void onDetach$ui_release(SemanticsInfo r100) {
        if (this.currentlyDisplayedIDs.remove(r100.getSemanticsId()) == false) goto L6;
        this.platformAutofillManager.notifyViewVisibilityChanged(this.view, r100.getSemanticsId(), false);
        return;
    }

    public final void onLayoutNodeDeactivated$ui_release(SemanticsInfo r100) {
        if (this.currentlyDisplayedIDs.remove(r100.getSemanticsId()) == false) goto L6;
        this.platformAutofillManager.notifyViewVisibilityChanged(this.view, r100.getSemanticsId(), false);
        return;
    }

    public final void onPostAttach$ui_release(SemanticsInfo r100) {
        SemanticsConfiguration r101 = r100.getSemanticsConfiguration();
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        if (r102 == false) goto L10;
        this.currentlyDisplayedIDs.add(r100.getSemanticsId());
        this.platformAutofillManager.notifyViewVisibilityChanged(this.view, r100.getSemanticsId(), true);
        return;
    L10:
        return;
    L5:
        if (AndroidAutofillManager_androidKt.access$isRelatedToAutoCommit(r101) != true) goto L7;
        r102 = true;
        goto L7
    }

    public final void performAutofill(SparseArray<AutofillValue> r100) {
        int r101 = r100.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L23;
        int r103 = r100.keyAt(r102);
        AutofillValue r104 = r100.get(r103);
        AutofillApi26Helper r105 = AutofillApi26Helper.INSTANCE;
        if (r105.isText(r104) == false) goto L16;
        SemanticsInfo r106 = this.semanticsOwner.get$ui_release(r103);
        if (r106 == null) goto L22;
        SemanticsConfiguration r107 = r106.getSemanticsConfiguration();
        if (r107 == null) goto L22;
        AccessibilityAction r108 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(r107, SemanticsActions.INSTANCE.getOnAutofillText());
        if (r108 == null) goto L22;
        Function1 r109 = (Function1) r108.getAction();
        if (r109 == null) goto L22;
        Boolean r110 = (Boolean) r109.invoke(new AnnotatedString(r105.textValue(r104).toString(), null, 2, null));
    L22:
        r102 = r102 + 1;
        goto L3
    L16:
        if (r105.isDate(r104) == true) goto L22;
        if (r105.isList(r104) == true) goto L22;
        r105.isToggle(r104);
        goto L22
    }

    public final void populateViewStructure(ViewStructure r110) {
        AutofillApi26Helper r100 = AutofillApi26Helper.INSTANCE;
        SemanticsInfo r101 = this.semanticsOwner.getRootInfo$ui_release();
        PopulateViewStructure_androidKt.populate(r110, r101, this.rootAutofillId, this.packageName, this.rectManager);
        MutableObjectList r111 = ObjectListKt.mutableObjectListOf(r101, r110);
    L4:
        if (r111.isNotEmpty() == false) goto L24;
        Object r102 = r111.removeAt(r111._size - 1);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.ViewStructure");
        ViewStructure r103 = (ViewStructure) r102;
        Object r104 = r111.removeAt(r111._size - 1);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsInfo");
        List<SemanticsInfo> r105 = ((SemanticsInfo) r104).getChildrenInfo();
        int r106 = r105.size();
        int r107 = 0;
    L6:
        if (r107 >= r106) goto L4;
        SemanticsInfo r108 = (SemanticsInfo) ListProtector.get(r105, r107);
        if (r108.isDeactivated() == false) goto L10;
    L23:
        r107 = r107 + 1;
        goto L6
    L10:
        if (r108.isAttached() == false) goto L23;
        if (r108.isPlaced() == false) goto L23;
        SemanticsConfiguration r109 = r108.getSemanticsConfiguration();
        if (r109 != null) goto L17;
    L19:
        boolean r112 = false;
    L20:
        if (r112 == true) goto L22;
        r111.add(r108);
        r111.add(r103);
        goto L23
    L22:
        ViewStructure r113 = r100.newChild(r103, r100.addChildCount(r103, 1));
        PopulateViewStructure_androidKt.populate(r113, r108, this.rootAutofillId, this.packageName, this.rectManager);
        r111.add(r108);
        r111.add(r113);
        goto L23
    L17:
        if (AndroidAutofillManager_androidKt.access$isRelatedToAutofill(r109) != true) goto L19;
        r112 = true;
        goto L20
    }

    public final void requestAutofill$ui_release(final SemanticsInfo r100) {
        this.rectManager.getRects().withRect(r100.getSemanticsId(), new AndroidAutofillManager$requestAutofill$1(this, r100));
    }

    public final void setPlatformAutofillManager(PlatformAutofillManager r100) {
        this.platformAutofillManager = r100;
    }

    @Override // androidx.compose.ui.focus.FocusListener
    public void onFocusChanged(FocusTargetModifierNode r100, FocusTargetModifierNode r101) {
        boolean r102 = true;
        if (r100 == null) goto L14;
        SemanticsInfo r103 = DelegatableNodeKt.requireSemanticsInfo(r100);
        if (r103 == null) goto L14;
        SemanticsConfiguration r104 = r103.getSemanticsConfiguration();
        if (r104 != null) goto L9;
    L11:
        boolean r105 = false;
    L12:
        if (r105 == false) goto L14;
        this.platformAutofillManager.notifyViewExited(this.view, r103.getSemanticsId());
        goto L14
    L9:
        if (AndroidAutofillManager_androidKt.access$isAutofillable(r104) != true) goto L11;
        r105 = true;
    L14:
        if (r101 == null) goto L26;
        SemanticsInfo r106 = DelegatableNodeKt.requireSemanticsInfo(r101);
        if (r106 == null) goto L27;
        SemanticsConfiguration r107 = r106.getSemanticsConfiguration();
        if (r107 != null) goto L20;
    L22:
        r102 = false;
    L23:
        if (r102 == false) goto L28;
        final int r108 = r106.getSemanticsId();
        this.rectManager.getRects().withRect(r108, new AndroidAutofillManager$onFocusChanged$2$1(this, r108));
        return;
    L28:
        return;
    L20:
        if (AndroidAutofillManager_androidKt.access$isAutofillable(r107) != true) goto L22;
    L27:
        return;
    }

    public final void onPostLayoutNodeReused$ui_release(SemanticsInfo r100, int r101) {
        boolean r102 = false;
        if (this.currentlyDisplayedIDs.remove(r101) == false) goto L5;
        this.platformAutofillManager.notifyViewVisibilityChanged(this.view, r101, false);
    L5:
        SemanticsConfiguration r103 = r100.getSemanticsConfiguration();
        if (r103 != null) goto L8;
    L10:
        if (r102 == false) goto L13;
        this.currentlyDisplayedIDs.add(r100.getSemanticsId());
        this.platformAutofillManager.notifyViewVisibilityChanged(this.view, r100.getSemanticsId(), true);
        return;
    L13:
        return;
    L8:
        if (AndroidAutofillManager_androidKt.access$isRelatedToAutoCommit(r103) != true) goto L10;
        r102 = true;
        goto L10
    }

    @Override // androidx.compose.ui.semantics.SemanticsListener
    public void onSemanticsChanged(SemanticsInfo r100, SemanticsConfiguration r101) {
        SemanticsConfiguration r102 = r100.getSemanticsConfiguration();
        int r103 = r100.getSemanticsId();
        String r104 = null;
        if (r101 == null) goto L7;
        AnnotatedString r105 = (AnnotatedString) SemanticsConfigurationKt.getOrNull(r101, SemanticsProperties.INSTANCE.getInputText());
        if (r105 == null) goto L7;
        String r106 = r105.getText();
    L8:
        if (r102 == null) goto L12;
        AnnotatedString r107 = (AnnotatedString) SemanticsConfigurationKt.getOrNull(r102, SemanticsProperties.INSTANCE.getInputText());
        if (r107 == null) goto L12;
        r104 = r107.getText();
    L12:
        boolean r108 = true;
        if (r106 == r104) goto L21;
        if (r106 != null) goto L16;
        this.platformAutofillManager.notifyViewVisibilityChanged(this.view, r103, true);
        goto L21
    L16:
        if (r104 != null) goto L19;
        this.platformAutofillManager.notifyViewVisibilityChanged(this.view, r103, false);
        goto L21
    L19:
        if (Intrinsics.areEqual((ContentDataType) SemanticsConfigurationKt.getOrNull(r102, SemanticsProperties.INSTANCE.getContentDataType()), ContentDataType.Companion.getText()) == false) goto L21;
        this.platformAutofillManager.notifyValueChanged(this.view, r103, AutofillApi26Helper.INSTANCE.getAutofillTextValue(r104));
    L21:
        if (r101 != null) goto L23;
    L25:
        boolean r109 = false;
    L26:
        if (r102 != null) goto L28;
    L30:
        r108 = false;
    L31:
        if (r109 == r108) goto L36;
        if (r108 == false) goto L34;
        this.currentlyDisplayedIDs.add(r103);
        return;
    L34:
        this.currentlyDisplayedIDs.remove(r103);
        return;
    L36:
        return;
    L28:
        if (AndroidAutofillManager_androidKt.access$isRelatedToAutoCommit(r102) != true) goto L30;
    L23:
        if (AndroidAutofillManager_androidKt.access$isRelatedToAutoCommit(r101) != true) goto L25;
        r109 = true;
    L7:
        r106 = null;
        goto L8
    }

    public AndroidAutofillManager(PlatformAutofillManager r100, SemanticsOwner r101, View r102, RectManager r103, String r104) {
        this.platformAutofillManager = r100;
        this.semanticsOwner = r101;
        this.view = r102;
        this.rectManager = r103;
        this.packageName = r104;
        this.reusableRect = new Rect();
        r102.setImportantForAutofill(1);
        AutofillIdCompat r105 = ViewCompatShims.getAutofillId(r102);
        if (r105 == null) goto L5;
        AutofillId r106 = r105.toAutofillId();
    L6:
        if (r106 == null) goto L9;
        this.rootAutofillId = r106;
        this.currentlyDisplayedIDs = new MutableIntSet(0, 1, null);
        return;
    L9:
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    L5:
        r106 = null;
        goto L6
    }
}
