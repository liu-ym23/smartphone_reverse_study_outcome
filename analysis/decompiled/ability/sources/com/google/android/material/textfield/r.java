package com.google.android.material.textfield;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.ListPopupWindow;

/* loaded from: classes3.dex */
public final class r implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialAutoCompleteTextView f2697a;

    public r(MaterialAutoCompleteTextView materialAutoCompleteTextView) {
        this.f2697a = materialAutoCompleteTextView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j5) {
        MaterialAutoCompleteTextView materialAutoCompleteTextView = this.f2697a;
        ListPopupWindow listPopupWindow = materialAutoCompleteTextView.f2600a;
        materialAutoCompleteTextView.setText(materialAutoCompleteTextView.convertSelectionToString(i < 0 ? listPopupWindow.getSelectedItem() : materialAutoCompleteTextView.getAdapter().getItem(i)), false);
        AdapterView.OnItemClickListener onItemClickListener = materialAutoCompleteTextView.getOnItemClickListener();
        if (onItemClickListener != null) {
            if (view == null || i < 0) {
                view = listPopupWindow.getSelectedView();
                i = listPopupWindow.getSelectedItemPosition();
                j5 = listPopupWindow.getSelectedItemId();
            }
            onItemClickListener.onItemClick(listPopupWindow.getListView(), view, i, j5);
        }
        listPopupWindow.dismiss();
    }
}
