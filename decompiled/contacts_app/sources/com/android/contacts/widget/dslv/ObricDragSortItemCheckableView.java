package com.android.contacts.widget.dslv;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.Checkable;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;

/* JADX INFO: compiled from: ObricDragSortItemCheckableView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\f"}, d2 = {"Lcom/android/contacts/widget/dslv/ObricDragSortItemCheckableView;", "Lcom/android/contacts/widget/dslv/DragSortItemView;", "Landroid/widget/Checkable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isChecked", "", "setChecked", "", MaterialConfigFormatNames.CHECKED, "toggle", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ObricDragSortItemCheckableView extends DragSortItemView implements Checkable {
    public ObricDragSortItemCheckableView(Context r1) {
        super(r1);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        KeyEvent.Callback r2 = getChildAt(0);
        if (r2 != null) goto L5;
    L8:
        return false;
    L5:
        if ((r2 instanceof Checkable) == false) goto L8;
        return ((Checkable) r2).isChecked();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r2) {
        KeyEvent.Callback r1 = getChildAt(0);
        if (r1 != null) goto L5;
        return;
    L5:
        if ((r1 instanceof Checkable) == false) goto L9;
        ((Checkable) r1).setChecked(r2);
        return;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        KeyEvent.Callback r1 = getChildAt(0);
        if (r1 != null) goto L5;
        return;
    L5:
        if ((r1 instanceof Checkable) == false) goto L9;
        ((Checkable) r1).toggle();
        return;
    }
}
