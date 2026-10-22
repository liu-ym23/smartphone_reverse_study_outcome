package com.android.ttcjpaysdk.thirdparty.utils;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class CJPaySpaceInsertTextWatcher implements TextWatcher {
    private StringBuffer buffer;
    public boolean isSelfChange;
    private String lastString;
    private int selectionIndex;
    private List<Integer> spaceIndexList;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public CJPaySpaceInsertTextWatcher(List<Integer> r100) {
        this.buffer = new StringBuffer();
        this.lastString = "";
        this.isSelfChange = false;
        this.selectionIndex = 0;
        this.spaceIndexList = r100;
    }

    private String reformat(CharSequence r100) {
        this.buffer = new StringBuffer(r100.toString());
        int r101 = 0;
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r101 >= this.buffer.length()) goto L12;
        r102 = r102 + 1;
        if (this.buffer.charAt(r101) == ' ') goto L8;
        r101 = r101 + 1;
        goto L4
    L8:
        if (r102 > this.selectionIndex) goto L10;
        r103 = r103 + 1;
    L10:
        this.buffer.deleteCharAt(r101);
        goto L4
    L12:
        int r104 = 0;
        int r105 = 0;
    L14:
        if (r104 >= this.buffer.length()) goto L26;
        int r106 = 0;
    L17:
        if (r106 >= this.spaceIndexList.size()) goto L25;
        if (r104 != (((Integer) ListProtector.get(this.spaceIndexList, r106)).intValue() + r106)) goto L24;
        if (r104 > this.selectionIndex) goto L23;
        r105 = r105 + 1;
    L23:
        this.buffer.insert(r104, ' ');
    L24:
        r106 = r106 + 1;
        goto L17
    L25:
        r104 = r104 + 1;
        goto L14
    L26:
        char[] r107 = new char[this.buffer.length()];
        StringBuffer r108 = this.buffer;
        r108.getChars(0, r108.length(), r107, 0);
        String r109 = this.buffer.toString();
        if (this.lastString.length() >= r109.length()) goto L30;
        this.selectionIndex += Math.max(r105 - r103, 0);
    L30:
        if (this.selectionIndex >= 0) goto L32;
        this.selectionIndex = 0;
    L32:
        return r109;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r100) {
        if (this.isSelfChange == true) goto L6;
        this.selectionIndex = Selection.getSelectionEnd(r100);
        String r101 = reformat(r100);
        this.lastString = r101;
        this.isSelfChange = true;
        r100.replace(0, r100.length(), r101, 0, r101.length());
        Selection.setSelection(r100, Math.min(this.selectionIndex, r100.length()));
        this.isSelfChange = false;
        return;
    }
}
