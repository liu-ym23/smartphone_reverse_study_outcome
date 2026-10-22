package com.android.contacts.widget;

import android.content.Context;
import android.view.View;
import com.android.contacts.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import obric.app.MenuDialog;
import obric.app.MenuDialogListAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class UnmarkMenuDialog extends MenuDialog {
    private Context mContext;
    private ArrayList<View.OnClickListener> mListeners;
    private MenuDialogListAdapter mMenuDialogListAdapter;
    private ArrayList<String> mTitles;

    public static class ActionItem {
        public View.OnClickListener listener;
        public int title;

        public ActionItem(int r1, View.OnClickListener r2) {
            this.title = r1;
            this.listener = r2;
        }
    }

    public UnmarkMenuDialog(Context r4) {
        super(r4);
        this.mListeners = new ArrayList();
        this.mTitles = new ArrayList();
        this.mContext = r4;
        setTitle(R.string.mark_actions_title);
        MenuDialogListAdapter r5 = new MenuDialogListAdapter(this.mContext, this.mTitles, this.mListeners);
        this.mMenuDialogListAdapter = r5;
        setAdapter(r5);
    }

    public void setActionItem(List<ActionItem> r5) {
        this.mListeners.clear();
        this.mTitles.clear();
        Iterator<ActionItem> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        ActionItem r0 = r6.next();
        this.mTitles.add(this.mContext.getResources().getString(r0.title));
        this.mListeners.add(r0.listener);
        goto L4
    L6:
        this.mMenuDialogListAdapter.notifyDataSetChanged();
    }
}
