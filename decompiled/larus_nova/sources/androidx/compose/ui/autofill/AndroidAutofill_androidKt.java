package androidx.compose.ui.autofill;

import android.util.SparseArray;
import android.view.ViewStructure;
import android.view.autofill.AutofillValue;
import androidx.compose.ui.geometry.Rect;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0001¨\u0006\t"}, d2 = {"populateViewStructure", "", "Landroidx/compose/ui/autofill/AndroidAutofill;", RootDescription.ROOT_ELEMENT, "Landroid/view/ViewStructure;", "performAutofill", "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidAutofill_androidKt {
    public static final void performAutofill(AndroidAutofill r100, SparseArray<AutofillValue> r101) {
        if (r100.getAutofillTree().getChildren().isEmpty() == false) goto L5;
        return;
    L5:
        int r102 = r101.size();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L23;
        int r104 = r101.keyAt(r103);
        AutofillValue r105 = r101.get(r104);
        AutofillApi26Helper r106 = AutofillApi26Helper.INSTANCE;
        if (r106.isText(r105) == false) goto L11;
        r100.getAutofillTree().performAutofill(r104, r106.textValue(r105).toString());
    L16:
        r103 = r103 + 1;
        goto L6
    L11:
        if (r106.isDate(r105) == true) goto L22;
        if (r106.isList(r105) == true) goto L20;
        if (r106.isToggle(r105) == false) goto L16;
        throw new NotImplementedError("An operation is not implemented: b/138604541:  Add onFill() callback for toggle");
    L20:
        throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for list");
    L22:
        throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for date");
    }

    public static final void populateViewStructure(AndroidAutofill r110, ViewStructure r111) {
        if (r110.getAutofillTree().getChildren().isEmpty() == false) goto L5;
        return;
    L5:
        int r100 = AutofillApi26Helper.INSTANCE.addChildCount(r111, r110.getAutofillTree().getChildren().size());
        Iterator<Map.Entry<Integer, AutofillNode>> r101 = r110.getAutofillTree().getChildren().entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L16;
        Map.Entry<Integer, AutofillNode> r102 = r101.next();
        int r103 = r102.getKey().intValue();
        AutofillNode r104 = r102.getValue();
        AutofillApi26Helper r105 = AutofillApi26Helper.INSTANCE;
        ViewStructure r112 = r105.newChild(r111, r100);
        r105.setAutofillId(r112, r110.getRootAutofillId(), r103);
        r105.setId(r112, r103, r110.getView().getContext().getPackageName(), null, null);
        r105.setAutofillType(r112, ContentDataType_androidKt.getDataType(ContentDataType.Companion.getText()));
        List<AutofillType> r106 = r104.getAutofillTypes();
        ArrayList r107 = new ArrayList(r106.size());
        int r108 = r106.size();
        int r109 = 0;
    L9:
        if (r109 >= r108) goto L11;
        r107.add(AndroidAutofillType_androidKt.getAndroidType((AutofillType) ListProtector.get(r106, r109)));
        r109 = r109 + 1;
        goto L9
    L11:
        r105.setAutofillHints(r112, (String[]) r107.toArray(new String[0]));
        Rect r113 = r104.getBoundingBox();
        if (r113 == null) goto L15;
        int r114 = Math.round(r113.getLeft());
        int r115 = Math.round(r113.getTop());
        int r116 = Math.round(r113.getRight());
        int r117 = Math.round(r113.getBottom()) - r115;
        AutofillApi26Helper r118 = AutofillApi26Helper.INSTANCE;
        r118.setDimens(r112, r114, r115, 0, 0, r116 - r114, r117);
    L15:
        r100 = r100 + 1;
        goto L7
    }
}
