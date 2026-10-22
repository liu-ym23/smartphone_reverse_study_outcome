package androidx.fragment.app;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

/* JADX INFO: loaded from: classes17.dex */
public class ListFragment extends Fragment {
    static final int INTERNAL_EMPTY_ID = 16711681;
    static final int INTERNAL_LIST_CONTAINER_ID = 16711683;
    static final int INTERNAL_PROGRESS_CONTAINER_ID = 16711682;
    ListAdapter mAdapter;
    CharSequence mEmptyText;
    View mEmptyView;
    private final Handler mHandler;
    ListView mList;
    View mListContainer;
    boolean mListShown;
    private final AdapterView.OnItemClickListener mOnClickListener;
    View mProgressContainer;
    private final Runnable mRequestFocus;
    TextView mStandardEmptyView;

    public void onListItemClick(ListView r100, View r101, int r102, long r103) {
    }

    private void ensureList() {
        if (this.mList == null) goto L5;
        return;
    L5:
        View r100 = getView();
        if (r100 == null) goto L36;
        if ((r100 instanceof ListView) == false) goto L10;
        this.mList = (ListView) r100;
    L27:
        this.mListShown = true;
        this.mList.setOnItemClickListener(this.mOnClickListener);
        ListAdapter r101 = this.mAdapter;
        if (r101 == null) goto L31;
        this.mAdapter = null;
        setListAdapter(r101);
    L33:
        this.mHandler.post(this.mRequestFocus);
        return;
    L31:
        if (this.mProgressContainer == null) goto L33;
        setListShown(false, false);
        goto L33
    L10:
        TextView r102 = (TextView) r100.findViewById(INTERNAL_EMPTY_ID);
        this.mStandardEmptyView = r102;
        if (r102 != null) goto L13;
        this.mEmptyView = r100.findViewById(R.id.empty);
    L14:
        this.mProgressContainer = r100.findViewById(INTERNAL_PROGRESS_CONTAINER_ID);
        this.mListContainer = r100.findViewById(INTERNAL_LIST_CONTAINER_ID);
        View r103 = r100.findViewById(R.id.list);
        if ((r103 instanceof ListView) == true) goto L21;
        if (r103 != null) goto L20;
        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
    L20:
        throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
    L21:
        ListView r104 = (ListView) r103;
        this.mList = r104;
        View r105 = this.mEmptyView;
        if (r105 == null) goto L24;
        r104.setEmptyView(r105);
        goto L27
    L24:
        CharSequence r106 = this.mEmptyText;
        if (r106 == null) goto L27;
        this.mStandardEmptyView.setText(r106);
        this.mList.setEmptyView(this.mStandardEmptyView);
        goto L27
    L13:
        r102.setVisibility(8);
        goto L14
    L36:
        throw new IllegalStateException("Content view not yet created");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mList = null;
        this.mListShown = false;
        this.mListContainer = null;
        this.mProgressContainer = null;
        this.mEmptyView = null;
        this.mStandardEmptyView = null;
        super.onDestroyView();
    }

    public ListFragment() {
        this.mHandler = new Handler();
        this.mRequestFocus = new AnonymousClass1(this);
        this.mOnClickListener = new AnonymousClass2(this);
    }

    public ListView getListView() {
        ensureList();
        return this.mList;
    }

    public long getSelectedItemId() {
        ensureList();
        return this.mList.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        ensureList();
        return this.mList.getSelectedItemPosition();
    }

    public final ListAdapter requireListAdapter() {
        ListAdapter r100 = getListAdapter();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("ListFragment " + this + " does not have a ListAdapter.");
    }

    public ListAdapter getListAdapter() {
        return this.mAdapter;
    }

    public void setEmptyText(CharSequence r100) {
        ensureList();
        TextView r101 = this.mStandardEmptyView;
        if (r101 == null) goto L10;
        r101.setText(r100);
        if (this.mEmptyText != null) goto L7;
        this.mList.setEmptyView(this.mStandardEmptyView);
    L7:
        this.mEmptyText = r100;
        return;
    L10:
        throw new IllegalStateException("Can't be used with a custom content view");
    }

    public void setListAdapter(ListAdapter r100) {
        boolean r101 = false;
        if (this.mAdapter == null) goto L5;
        boolean r102 = true;
    L6:
        this.mAdapter = r100;
        ListView r103 = this.mList;
        if (r103 == null) goto L16;
        r103.setAdapter(r100);
        if (this.mListShown == true) goto L17;
        if (r102 == false) goto L12;
        return;
    L12:
        if (requireView().getWindowToken() == null) goto L14;
        r101 = true;
    L14:
        setListShown(true, r101);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public void setListShown(boolean r100) {
        setListShown(r100, true);
    }

    public void setListShownNoAnimation(boolean r100) {
        setListShown(r100, false);
    }

    public void setSelection(int r100) {
        ensureList();
        this.mList.setSelection(r100);
    }

    private void setListShown(boolean r100, boolean r101) {
        ensureList();
        View r102 = this.mProgressContainer;
        if (r102 == null) goto L19;
        if (this.mListShown != r100) goto L7;
        return;
    L7:
        this.mListShown = r100;
        if (r100 == false) goto L13;
        if (r101 == false) goto L11;
        r102.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
        this.mListContainer.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
    L12:
        this.mProgressContainer.setVisibility(8);
        this.mListContainer.setVisibility(0);
        return;
    L11:
        r102.clearAnimation();
        this.mListContainer.clearAnimation();
        goto L12
    L13:
        if (r101 == false) goto L15;
        r102.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
        this.mListContainer.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
    L16:
        this.mProgressContainer.setVisibility(0);
        this.mListContainer.setVisibility(8);
        return;
    L15:
        r102.clearAnimation();
        this.mListContainer.clearAnimation();
        goto L16
    L19:
        throw new IllegalStateException("Can't be used with a custom content view");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        ensureList();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Context r103 = requireContext();
        FrameLayout r104 = new FrameLayout(r103);
        LinearLayout r105 = new LinearLayout(r103);
        r105.setId(INTERNAL_PROGRESS_CONTAINER_ID);
        r105.setOrientation(1);
        r105.setVisibility(8);
        r105.setGravity(17);
        r105.addView(new ProgressBar(r103, null, R.attr.progressBarStyleLarge), new FrameLayout.LayoutParams(-2, -2));
        r104.addView(r105, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout r106 = new FrameLayout(r103);
        r106.setId(INTERNAL_LIST_CONTAINER_ID);
        TextView r107 = new TextView(r103);
        r107.setId(INTERNAL_EMPTY_ID);
        r107.setGravity(17);
        r106.addView(r107, new FrameLayout.LayoutParams(-1, -1));
        ListView r108 = new ListView(r103);
        r108.setId(R.id.list);
        r108.setDrawSelectorOnTop(false);
        r106.addView(r108, new FrameLayout.LayoutParams(-1, -1));
        r104.addView(r106, new FrameLayout.LayoutParams(-1, -1));
        r104.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return r104;
    }
}
