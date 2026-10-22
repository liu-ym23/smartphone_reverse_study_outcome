package com.android.contacts.editor;

import android.view.ViewGroup;
import com.android.contacts.model.DataKind;
import com.android.contacts.model.EntityDelta;

/* JADX INFO: loaded from: classes.dex */
public interface Editor {
    public static final int MAX_ITEM_COUNT = 10;

    public interface EditorListener {
        public static final int EDITOR_FORM_CHANGED = 5;
        public static final int FIELD_AUTO_LINK_LUNAR_SOLAR = 5;
        public static final int FIELD_CHANGED = 2;
        public static final int FIELD_TURNED_EMPTY = 3;
        public static final int FIELD_TURNED_NON_EMPTY = 4;
        public static final int REQUEST_PICK_PHOTO = 1;

        void onDeleteRequested(Editor r1);

        void onRequest(int r1);
    }

    void changeEditorBackground();

    void clearAllFields();

    void deleteEditor();

    void deleteEditor(ViewGroup r1);

    boolean isEmpty();

    void onFieldChanged(String r1, String r2);

    void setDeletable(boolean r1);

    void setEditorListener(EditorListener r1);

    void setValues(DataKind r1, EntityDelta.ValuesDelta r2, EntityDelta r3, boolean r4, ViewIdGenerator r5);
}
