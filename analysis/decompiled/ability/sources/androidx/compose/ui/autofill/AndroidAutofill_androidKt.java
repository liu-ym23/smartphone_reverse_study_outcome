package androidx.compose.ui.autofill;

import android.util.Log;
import android.util.SparseArray;
import android.view.ViewStructure;
import android.view.autofill.AutofillValue;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.geometry.Rect;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a!\u0010\t\u001a\u00020\u0003*\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/autofill/AndroidAutofill;", "Landroid/view/ViewStructure;", "root", "LC7/r;", "populateViewStructure", "(Landroidx/compose/ui/autofill/AndroidAutofill;Landroid/view/ViewStructure;)V", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "values", "performAutofill", "(Landroidx/compose/ui/autofill/AndroidAutofill;Landroid/util/SparseArray;)V", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidAutofill_androidKt {
    @RequiresApi(26)
    public static final void performAutofill(AndroidAutofill androidAutofill, SparseArray<AutofillValue> sparseArray) {
        if (androidAutofill.getAutofillTree().getChildren().isEmpty()) {
            return;
        }
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int iKeyAt = sparseArray.keyAt(i);
            AutofillValue autofillValue = sparseArray.get(iKeyAt);
            AutofillApi26Helper autofillApi26Helper = AutofillApi26Helper.INSTANCE;
            if (autofillApi26Helper.isText(autofillValue)) {
                androidAutofill.getAutofillTree().performAutofill(iKeyAt, autofillApi26Helper.textValue(autofillValue).toString());
            } else {
                if (autofillApi26Helper.isDate(autofillValue)) {
                    throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for date");
                }
                if (autofillApi26Helper.isList(autofillValue)) {
                    throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for list");
                }
                if (autofillApi26Helper.isToggle(autofillValue)) {
                    throw new NotImplementedError("An operation is not implemented: b/138604541:  Add onFill() callback for toggle");
                }
            }
        }
    }

    @RequiresApi(26)
    public static final void populateViewStructure(AndroidAutofill androidAutofill, ViewStructure viewStructure) {
        if (androidAutofill.getAutofillTree().getChildren().isEmpty()) {
            return;
        }
        int iAddChildCount = AutofillApi26Helper.INSTANCE.addChildCount(viewStructure, androidAutofill.getAutofillTree().getChildren().size());
        for (Map.Entry<Integer, AutofillNode> entry : androidAutofill.getAutofillTree().getChildren().entrySet()) {
            int iIntValue = entry.getKey().intValue();
            AutofillNode value = entry.getValue();
            AutofillApi26Helper autofillApi26Helper = AutofillApi26Helper.INSTANCE;
            ViewStructure viewStructureNewChild = autofillApi26Helper.newChild(viewStructure, iAddChildCount);
            autofillApi26Helper.setAutofillId(viewStructureNewChild, androidAutofill.getRootAutofillId(), iIntValue);
            autofillApi26Helper.setId(viewStructureNewChild, iIntValue, androidAutofill.getView().getContext().getPackageName(), null, null);
            autofillApi26Helper.setAutofillType(viewStructureNewChild, ContentDataType_androidKt.getDataType(ContentDataType.INSTANCE.getText()));
            List<AutofillType> autofillTypes = value.getAutofillTypes();
            ArrayList arrayList = new ArrayList(autofillTypes.size());
            int size = autofillTypes.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(AndroidAutofillType_androidKt.getAndroidType(autofillTypes.get(i)));
            }
            autofillApi26Helper.setAutofillHints(viewStructureNewChild, (String[]) arrayList.toArray(new String[0]));
            Rect boundingBox = value.getBoundingBox();
            if (boundingBox == null) {
                Log.w("Autofill Warning", "Bounding box not set.\n                        Did you call perform autofillTree before the component was positioned? ");
            } else {
                int iRound = Math.round(boundingBox.getLeft());
                int iRound2 = Math.round(boundingBox.getTop());
                int iRound3 = Math.round(boundingBox.getRight());
                AutofillApi26Helper.INSTANCE.setDimens(viewStructureNewChild, iRound, iRound2, 0, 0, iRound3 - iRound, Math.round(boundingBox.getBottom()) - iRound2);
            }
            iAddChildCount++;
        }
    }
}
