package com.android.contacts.quickcontact;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.android.contacts.R;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class QuickContactListFragment extends Fragment {
    private List<Action> mActions;
    private RelativeLayout mFragmentContainer;
    private ListView mListView;
    private Listener mListener;
    private String mMimeType;
    private final View.OnClickListener mOutsideClickListener;
    protected final View.OnClickListener mPrimaryActionClickListener;
    protected final View.OnClickListener mSecondaryActionClickListener;

    public interface Listener {
        void onItemClicked(Action r1, boolean r2);

        void onOutsideClick();
    }

    static /* synthetic */ List access$000(QuickContactListFragment r0) {
        return r0.mActions;
    }

    static /* synthetic */ Listener access$100(QuickContactListFragment r0) {
        return r0.mListener;
    }

    public QuickContactListFragment(String r2) {
        this.mPrimaryActionClickListener = new AnonymousClass2(this);
        this.mSecondaryActionClickListener = new AnonymousClass3(this);
        this.mOutsideClickListener = new AnonymousClass4(this);
        setRetainInstance(true);
        this.mMimeType = r2;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        RelativeLayout r5 = (RelativeLayout) r2.inflate(R.layout.quickcontact_list_fragment, r3, false);
        this.mFragmentContainer = r5;
        ListView r6 = (ListView) r5.findViewById(R.id.list);
        this.mListView = r6;
        r6.setItemsCanFocus(true);
        this.mFragmentContainer.setOnClickListener(this.mOutsideClickListener);
        configureAdapter();
        return this.mFragmentContainer;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public void setActions(List<Action> r1) {
        this.mActions = r1;
        configureAdapter();
    }

    public void setListener(Listener r1) {
        this.mListener = r1;
    }

    private void configureAdapter() {
        if (this.mActions == null) goto L9;
        ListView r0 = this.mListView;
        if (r0 == null) goto L10;
        r0.setAdapter(new AnonymousClass1(this));
        return;
    L10:
        return;
    }
}
