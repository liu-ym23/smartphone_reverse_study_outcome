package androidx.compose.ui.autofill;

import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.RequestInfo;
import kotlin.Metadata;

@StabilityInferred(parameters = 1)
@RequiresApi(26)
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b3\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\fJ=\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u0013\u0010\u0014JG\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\b%\u0010$J\u0017\u0010&\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\b&\u0010$J\u0017\u0010'\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\b'\u0010$J\u001f\u0010*\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H\u0007¢\u0006\u0004\b*\u0010+J%\u0010.\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000e0,H\u0007¢\u0006\u0004\b.\u0010/J'\u00102\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u0006H\u0007¢\u0006\u0004\b2\u00103J\u001f\u00105\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u0006H\u0007¢\u0006\u0004\b5\u00106J\u001f\u00107\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\b7\u00108J\u001f\u0010:\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00109\u001a\u00020\"H\u0007¢\u0006\u0004\b:\u0010;J\u001f\u0010=\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\"H\u0007¢\u0006\u0004\b=\u0010;J\u001f\u0010?\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u0006H\u0007¢\u0006\u0004\b?\u00106J\u001f\u0010A\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u000eH\u0007¢\u0006\u0004\bA\u0010BJ\u001f\u0010D\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\"H\u0007¢\u0006\u0004\bD\u0010;J\u001f\u0010F\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\"H\u0007¢\u0006\u0004\bF\u0010;J\u001f\u0010H\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\"H\u0007¢\u0006\u0004\bH\u0010;J\u001f\u0010J\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\"H\u0007¢\u0006\u0004\bJ\u0010;J\u001f\u0010L\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\"H\u0007¢\u0006\u0004\bL\u0010;J\u001f\u0010M\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u0006H\u0007¢\u0006\u0004\bM\u00106J\u001f\u0010O\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\"H\u0007¢\u0006\u0004\bO\u0010;J\u001f\u0010Q\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\"H\u0007¢\u0006\u0004\bQ\u0010;J\u001f\u0010S\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\"H\u0007¢\u0006\u0004\bS\u0010;J\u001f\u0010U\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010T\u001a\u00020(H\u0007¢\u0006\u0004\bU\u0010+J\u001f\u0010W\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010V\u001a\u00020\u0006H\u0007¢\u0006\u0004\bW\u00106J\u0017\u0010X\u001a\u00020(2\u0006\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\bX\u0010YJ\u0017\u0010Z\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\bZ\u0010$J\u0017\u0010[\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\b[\u0010\\J\u0017\u0010]\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000eH\u0007¢\u0006\u0004\b]\u0010^¨\u0006_"}, d2 = {"Landroidx/compose/ui/autofill/AutofillApi26Helper;", "", AppAgent.CONSTRUCT, "()V", "Landroid/view/ViewStructure;", "structure", "", "index", "newChild", "(Landroid/view/ViewStructure;I)Landroid/view/ViewStructure;", "num", "addChildCount", "(Landroid/view/ViewStructure;I)I", "id", "", "packageName", "typeName", "entryName", "LC7/r;", "setId", "(Landroid/view/ViewStructure;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "left", "top", "scrollX", "scrollY", "width", "height", "setDimens", "(Landroid/view/ViewStructure;IIIIII)V", "Landroid/view/autofill/AutofillId;", "getAutofillId", "(Landroid/view/ViewStructure;)Landroid/view/autofill/AutofillId;", "Landroid/view/autofill/AutofillValue;", "value", "", "isDate", "(Landroid/view/autofill/AutofillValue;)Z", "isList", "isText", "isToggle", "", "contentDescription", "setContentDescription", "(Landroid/view/ViewStructure;Ljava/lang/CharSequence;)V", "", "hints", "setAutofillHints", "(Landroid/view/ViewStructure;[Ljava/lang/String;)V", "parent", "virtualId", "setAutofillId", "(Landroid/view/ViewStructure;Landroid/view/autofill/AutofillId;I)V", "type", "setAutofillType", "(Landroid/view/ViewStructure;I)V", "setAutofillValue", "(Landroid/view/ViewStructure;Landroid/view/autofill/AutofillValue;)V", "checkable", "setCheckable", "(Landroid/view/ViewStructure;Z)V", "checked", "setChecked", "numChildren", "setChildCount", "classname", "setClassName", "(Landroid/view/ViewStructure;Ljava/lang/String;)V", "clickable", "setClickable", "isSensitive", "setDataIsSensitive", "enabled", "setEnabled", "focusable", "setFocusable", "focused", "setFocused", "setInputType", "longClickable", "setLongClickable", "isOpaque", "setOpaque", "isSelected", "setSelected", "text", RequestInfo.FUNCTION_SET_TEXT, "visibility", "setVisibility", "textValue", "(Landroid/view/autofill/AutofillValue;)Ljava/lang/CharSequence;", "booleanValue", "listValue", "(Landroid/view/autofill/AutofillValue;)I", "getAutofillTextValue", "(Ljava/lang/String;)Landroid/view/autofill/AutofillValue;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AutofillApi26Helper {
    public static final int $stable = 0;
    public static final AutofillApi26Helper INSTANCE = new AutofillApi26Helper();

    private AutofillApi26Helper() {
    }

    @RequiresApi(26)
    public final int addChildCount(ViewStructure structure, int num) {
        return structure.addChildCount(num);
    }

    @RequiresApi(26)
    public final boolean booleanValue(AutofillValue value) {
        return value.getToggleValue();
    }

    @RequiresApi(26)
    public final AutofillId getAutofillId(ViewStructure structure) {
        return structure.getAutofillId();
    }

    @RequiresApi(26)
    public final AutofillValue getAutofillTextValue(String value) {
        return AutofillValue.forText(value);
    }

    @RequiresApi(26)
    public final boolean isDate(AutofillValue value) {
        return value.isDate();
    }

    @RequiresApi(26)
    public final boolean isList(AutofillValue value) {
        return value.isList();
    }

    @RequiresApi(26)
    public final boolean isText(AutofillValue value) {
        return value.isText();
    }

    @RequiresApi(26)
    public final boolean isToggle(AutofillValue value) {
        return value.isToggle();
    }

    @RequiresApi(26)
    public final int listValue(AutofillValue value) {
        return value.getListValue();
    }

    @RequiresApi(26)
    public final ViewStructure newChild(ViewStructure structure, int index) {
        return structure.newChild(index);
    }

    @RequiresApi(26)
    public final void setAutofillHints(ViewStructure structure, String[] hints) {
        structure.setAutofillHints(hints);
    }

    @RequiresApi(26)
    public final void setAutofillId(ViewStructure structure, AutofillId parent, int virtualId) {
        structure.setAutofillId(parent, virtualId);
    }

    @RequiresApi(26)
    public final void setAutofillType(ViewStructure structure, int type) {
        structure.setAutofillType(type);
    }

    @RequiresApi(26)
    public final void setAutofillValue(ViewStructure structure, AutofillValue value) {
        structure.setAutofillValue(value);
    }

    @RequiresApi(26)
    public final void setCheckable(ViewStructure structure, boolean checkable) {
        structure.setCheckable(checkable);
    }

    @RequiresApi(26)
    public final void setChecked(ViewStructure structure, boolean checked) {
        structure.setChecked(checked);
    }

    @RequiresApi(26)
    public final void setChildCount(ViewStructure structure, int numChildren) {
        structure.setChildCount(numChildren);
    }

    @RequiresApi(26)
    public final void setClassName(ViewStructure structure, String classname) {
        structure.setClassName(classname);
    }

    @RequiresApi(26)
    public final void setClickable(ViewStructure structure, boolean clickable) {
        structure.setClickable(clickable);
    }

    @RequiresApi(26)
    public final void setContentDescription(ViewStructure structure, CharSequence contentDescription) {
        structure.setContentDescription(contentDescription);
    }

    @RequiresApi(26)
    public final void setDataIsSensitive(ViewStructure structure, boolean isSensitive) {
        structure.setDataIsSensitive(isSensitive);
    }

    @RequiresApi(26)
    public final void setDimens(ViewStructure structure, int left, int top, int scrollX, int scrollY, int width, int height) {
        structure.setDimens(left, top, scrollX, scrollY, width, height);
    }

    @RequiresApi(26)
    public final void setEnabled(ViewStructure structure, boolean enabled) {
        structure.setEnabled(enabled);
    }

    @RequiresApi(26)
    public final void setFocusable(ViewStructure structure, boolean focusable) {
        structure.setFocusable(focusable);
    }

    @RequiresApi(26)
    public final void setFocused(ViewStructure structure, boolean focused) {
        structure.setFocused(focused);
    }

    @RequiresApi(26)
    public final void setId(ViewStructure structure, int id, String packageName, String typeName, String entryName) {
        structure.setId(id, packageName, typeName, entryName);
    }

    @RequiresApi(26)
    public final void setInputType(ViewStructure structure, int type) {
        structure.setInputType(type);
    }

    @RequiresApi(26)
    public final void setLongClickable(ViewStructure structure, boolean longClickable) {
        structure.setLongClickable(longClickable);
    }

    @RequiresApi(26)
    public final void setOpaque(ViewStructure structure, boolean isOpaque) {
        structure.setOpaque(isOpaque);
    }

    @RequiresApi(26)
    public final void setSelected(ViewStructure structure, boolean isSelected) {
        structure.setSelected(isSelected);
    }

    @RequiresApi(26)
    public final void setText(ViewStructure structure, CharSequence text) {
        structure.setText(text);
    }

    @RequiresApi(26)
    public final void setVisibility(ViewStructure structure, int visibility) {
        structure.setVisibility(visibility);
    }

    @RequiresApi(26)
    public final CharSequence textValue(AutofillValue value) {
        return value.getTextValue();
    }
}
