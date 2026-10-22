package com.android.contacts.setting;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.obric.oui.button.OButton;
import com.obric.oui.checkbox.OCheckBox;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ManualJoinContactAdapter extends BaseExpandableListAdapter {
    private static final String TAG = "ManualJoinContact";
    private Context mContext;
    private JoinedContactNameEditListener mJoinedContactNameEditListener;
    private List<List<AggregationSuggestionUnit>> mSuggestionsGroupList;

    class ChildViewHolder {
        OCheckBox checkBox;
        TextView nameView;
        TextView numberView;
        final /* synthetic */ ManualJoinContactAdapter this$0;

        ChildViewHolder(ManualJoinContactAdapter r1) {
            this.this$0 = r1;
        }
    }

    class GroupViewHolder {
        OButton nameEditor;
        TextView nameView;
        final /* synthetic */ ManualJoinContactAdapter this$0;

        GroupViewHolder(ManualJoinContactAdapter r1) {
            this.this$0 = r1;
        }
    }

    public interface JoinedContactNameEditListener {
        void onJoinedContactNameEdit(List<AggregationSuggestionUnit> r1);
    }

    class MyOnCheckedChangeListener implements OCheckBox.OnCheckedChangeListener {
        private AggregationSuggestionUnit mAggregationSuggestionUnit;
        final /* synthetic */ ManualJoinContactAdapter this$0;

        public MyOnCheckedChangeListener(ManualJoinContactAdapter r1, AggregationSuggestionUnit r2) {
            this.this$0 = r1;
            this.mAggregationSuggestionUnit = r2;
        }

        @Override // com.obric.oui.checkbox.OCheckBox.OnCheckedChangeListener
        public void onCheckedChanged(OCheckBox r1, boolean r2) {
            this.mAggregationSuggestionUnit.setChecked(r2);
        }
    }

    class MyOnClickListener implements View.OnClickListener {
        private List<AggregationSuggestionUnit> mAggregationSuggestionUnits;
        final /* synthetic */ ManualJoinContactAdapter this$0;

        public MyOnClickListener(ManualJoinContactAdapter r1, List<AggregationSuggestionUnit> r2) {
            this.this$0 = r1;
            this.mAggregationSuggestionUnits = r2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            if (ManualJoinContactAdapter.access$000(this.this$0) == null) goto L6;
            ManualJoinContactAdapter.access$000(this.this$0).onJoinedContactNameEdit(this.mAggregationSuggestionUnits);
            return;
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int r1, int r2) {
        return r2;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int r1) {
        return r1;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int r1, int r2) {
        return true;
    }

    static /* synthetic */ JoinedContactNameEditListener access$000(ManualJoinContactAdapter r0) {
        return r0.mJoinedContactNameEditListener;
    }

    public ManualJoinContactAdapter(ManualJoinContactFragment r2) {
        this.mSuggestionsGroupList = new ArrayList();
        this.mContext = r2.getActivity();
    }

    public void setSuggestionContacts(List<List<AggregationSuggestionUnit>> r1) {
        this.mSuggestionsGroupList = r1;
    }

    public void setJoinedContactNameEditListener(JoinedContactNameEditListener r1) {
        this.mJoinedContactNameEditListener = r1;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.mSuggestionsGroupList.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int r1) {
        return this.mSuggestionsGroupList.get(r1).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int r1) {
        return this.mSuggestionsGroupList.get(r1);
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int r1, int r2) {
        return this.mSuggestionsGroupList.get(r1).get(r2);
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int r5, boolean r6, View r7, ViewGroup r8) {
        if (r7 != null) goto L4;
        r7 = LayoutInflater.from(this.mContext).inflate(R.layout.aggregate_group_item_view, r8, false);
        GroupViewHolder r9 = new GroupViewHolder(this);
        r9.nameView = (TextView) r7.findViewById(R.id.joined_contact_name);
        r9.nameEditor = (OButton) r7.findViewById(R.id.joined_contact_name_editor);
        r7.setTag(r9);
    L5:
        List<AggregationSuggestionUnit> r0 = this.mSuggestionsGroupList.get(r5);
        Iterator<AggregationSuggestionUnit> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        AggregationSuggestionUnit r2 = r1.next();
        if (TextUtils.isEmpty(r2.getCurrentDisplayName()) == true) goto L7;
        String r3 = r2.getCurrentDisplayName();
    L12:
        r9.nameView.setText(r3);
        r9.nameEditor.setEnabled(true);
        r9.nameEditor.setOnClickListener(new MyOnClickListener(this, r0));
        ((ExpandableListView) r8).expandGroup(r5);
        return r7;
    L11:
        r3 = "";
        goto L12
    L4:
        r9 = (GroupViewHolder) r7.getTag();
        goto L5
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int r3, int r4, boolean r5, View r6, ViewGroup r7) {
        if (r6 != null) goto L5;
        r6 = LayoutInflater.from(this.mContext).inflate(R.layout.aggregate_child_item_view, r7, false);
        ChildViewHolder r8 = new ChildViewHolder(this);
        r8.checkBox = (OCheckBox) r6.findViewById(R.id.checkBox);
        r8.nameView = (TextView) r6.findViewById(R.id.contact_name);
        r8.numberView = (TextView) r6.findViewById(R.id.contact_number);
        r6.setTag(r8);
    L6:
        AggregationSuggestionUnit r9 = this.mSuggestionsGroupList.get(r3).get(r4);
        if (TextUtils.isEmpty(r9.getDisplayName()) == false) goto L9;
        r8.nameView.setText(this.mContext.getString(R.string.missing_name));
    L10:
        String r10 = r9.getMatchedField();
        if (TextUtils.isEmpty(r10) == true) goto L16;
        if (r10.equalsIgnoreCase(r9.getDisplayName()) == true) goto L16;
        r8.numberView.setText(r10);
    L27:
        r8.checkBox.setOnCheckedChangeListener(new MyOnCheckedChangeListener(this, r9));
        r8.checkBox.setChecked(r9.isChecked());
        return r6;
    L16:
        if (r9.getPhoneNumbers() == null) goto L21;
        if (r9.getPhoneNumbers().size() <= 0) goto L21;
        String r11 = ContactsUtils.formatNumber(r9.getPhoneNumbers().get(0));
    L26:
        r8.numberView.setText(r11);
    L21:
        if (r9.getEmails() != null) goto L23;
    L25:
        r11 = this.mContext.getString(R.string.joined_contact_phone_and_email_empty);
        goto L26
    L23:
        if (r9.getEmails().size() <= 0) goto L25;
        r11 = r9.getEmails().get(0);
        goto L26
    L9:
        r8.nameView.setText(r9.getDisplayName());
        goto L10
    L5:
        r8 = (ChildViewHolder) r6.getTag();
        goto L6
    }
}
