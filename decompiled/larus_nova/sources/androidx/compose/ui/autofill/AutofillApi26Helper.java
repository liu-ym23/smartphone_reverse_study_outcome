package androidx.compose.ui.autofill;

import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b)\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\bH\u0007J6\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0007J@\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0007J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0018\u0010\"\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$H\u0007J#\u0010%\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000f0'H\u0007¢\u0006\u0002\u0010(J \u0010)\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\bH\u0007J\u0018\u0010,\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\bH\u0007J\u0018\u0010.\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0018\u0010/\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u001cH\u0007J\u0018\u00101\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u001cH\u0007J\u0018\u00103\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u00104\u001a\u00020\bH\u0007J\u0018\u00105\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u000fH\u0007J\u0018\u00107\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u001cH\u0007J\u0018\u00109\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u001cH\u0007J\u0018\u0010;\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u001cH\u0007J\u0018\u0010=\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u001cH\u0007J\u0018\u0010?\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u001cH\u0007J\u0018\u0010A\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\bH\u0007J\u0018\u0010B\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u001cH\u0007J\u0018\u0010D\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u001cH\u0007J\u0018\u0010F\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u001cH\u0007J\u0018\u0010H\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010I\u001a\u00020$H\u0007J\u0018\u0010J\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\bH\u0007J\u0010\u0010L\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010M\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010N\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010O\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u000fH\u0007¨\u0006P"}, d2 = {"Landroidx/compose/ui/autofill/AutofillApi26Helper;", "", "<init>", "()V", "newChild", "Landroid/view/ViewStructure;", "structure", "index", "", "addChildCount", "num", "setId", "", "id", "packageName", "", "typeName", "entryName", "setDimens", "left", "top", "scrollX", "scrollY", "width", "height", "getAutofillId", "Landroid/view/autofill/AutofillId;", "isDate", "", "value", "Landroid/view/autofill/AutofillValue;", "isList", "isText", "isToggle", "setContentDescription", "contentDescription", "", "setAutofillHints", "hints", "", "(Landroid/view/ViewStructure;[Ljava/lang/String;)V", "setAutofillId", "parent", "virtualId", "setAutofillType", "type", "setAutofillValue", "setCheckable", "checkable", "setChecked", "checked", "setChildCount", "numChildren", "setClassName", "classname", "setClickable", "clickable", "setDataIsSensitive", "isSensitive", "setEnabled", "enabled", "setFocusable", "focusable", "setFocused", "focused", "setInputType", "setLongClickable", "longClickable", "setOpaque", "isOpaque", "setSelected", "isSelected", "setText", "text", "setVisibility", RemoteMessageConst.Notification.VISIBILITY, "textValue", "booleanValue", "listValue", "getAutofillTextValue", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutofillApi26Helper {
    public static final int $stable = 0;
    public static final AutofillApi26Helper INSTANCE = null;

    static {
        INSTANCE = new AutofillApi26Helper();
    }

    private AutofillApi26Helper() {
    }

    public final boolean booleanValue(AutofillValue r100) {
        return r100.getToggleValue();
    }

    public final AutofillId getAutofillId(ViewStructure r100) {
        return r100.getAutofillId();
    }

    public final AutofillValue getAutofillTextValue(String r100) {
        return AutofillValue.forText(r100);
    }

    public final boolean isDate(AutofillValue r100) {
        return r100.isDate();
    }

    public final boolean isList(AutofillValue r100) {
        return r100.isList();
    }

    public final boolean isText(AutofillValue r100) {
        return r100.isText();
    }

    public final boolean isToggle(AutofillValue r100) {
        return r100.isToggle();
    }

    public final int listValue(AutofillValue r100) {
        return r100.getListValue();
    }

    public final CharSequence textValue(AutofillValue r100) {
        return r100.getTextValue();
    }

    public final int addChildCount(ViewStructure r100, int r101) {
        return r100.addChildCount(r101);
    }

    public final ViewStructure newChild(ViewStructure r100, int r101) {
        return r100.newChild(r101);
    }

    public final void setAutofillHints(ViewStructure r100, String[] r101) {
        r100.setAutofillHints(r101);
    }

    public final void setAutofillType(ViewStructure r100, int r101) {
        r100.setAutofillType(r101);
    }

    public final void setAutofillValue(ViewStructure r100, AutofillValue r101) {
        r100.setAutofillValue(r101);
    }

    public final void setCheckable(ViewStructure r100, boolean r101) {
        r100.setCheckable(r101);
    }

    public final void setChecked(ViewStructure r100, boolean r101) {
        r100.setChecked(r101);
    }

    public final void setChildCount(ViewStructure r100, int r101) {
        r100.setChildCount(r101);
    }

    public final void setClassName(ViewStructure r100, String r101) {
        r100.setClassName(r101);
    }

    public final void setClickable(ViewStructure r100, boolean r101) {
        r100.setClickable(r101);
    }

    public final void setContentDescription(ViewStructure r100, CharSequence r101) {
        r100.setContentDescription(r101);
    }

    public final void setDataIsSensitive(ViewStructure r100, boolean r101) {
        r100.setDataIsSensitive(r101);
    }

    public final void setEnabled(ViewStructure r100, boolean r101) {
        r100.setEnabled(r101);
    }

    public final void setFocusable(ViewStructure r100, boolean r101) {
        r100.setFocusable(r101);
    }

    public final void setFocused(ViewStructure r100, boolean r101) {
        r100.setFocused(r101);
    }

    public final void setInputType(ViewStructure r100, int r101) {
        r100.setInputType(r101);
    }

    public final void setLongClickable(ViewStructure r100, boolean r101) {
        r100.setLongClickable(r101);
    }

    public final void setOpaque(ViewStructure r100, boolean r101) {
        r100.setOpaque(r101);
    }

    public final void setSelected(ViewStructure r100, boolean r101) {
        r100.setSelected(r101);
    }

    public final void setText(ViewStructure r100, CharSequence r101) {
        r100.setText(r101);
    }

    public final void setVisibility(ViewStructure r100, int r101) {
        r100.setVisibility(r101);
    }

    public final void setAutofillId(ViewStructure r100, AutofillId r101, int r102) {
        r100.setAutofillId(r101, r102);
    }

    public final void setId(ViewStructure r100, int r101, String r102, String r103, String r104) {
        r100.setId(r101, r102, r103, r104);
    }

    public final void setDimens(ViewStructure r100, int r101, int r102, int r103, int r104, int r105, int r106) {
        r100.setDimens(r101, r102, r103, r104, r105, r106);
    }
}
