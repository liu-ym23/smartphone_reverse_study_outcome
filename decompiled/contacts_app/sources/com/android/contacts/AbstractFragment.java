package com.android.contacts;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.android.contacts.util.SmtPcUtils;
import com.obric.legacy.DestroyObservable;
import com.obricOld.contacts.menus.LongMenuHelper;
import obric.app.tracker.Agent;

/* JADX INFO: loaded from: classes.dex */
public class AbstractFragment extends Fragment implements LongMenuHelper.OnMenuItemClickedListener {
    private String mClassName;
    private DestroyObservable mDestroyObservable;
    private boolean mHasTrackerSubTag;
    protected boolean mIsPcMode;
    protected LongMenuHelper mLongMenuHelper;
    private String mTrackerSubTag;

    protected String getTrackerSubTag() {
        return "";
    }

    @Override // com.obricOld.contacts.menus.LongMenuHelper.OnMenuItemClickedListener
    public boolean onMenuItemClicked(LongMenuHelper.MenuType r1, View r2, Object r3) {
        return false;
    }

    public AbstractFragment() {
        this.mClassName = "";
        this.mTrackerSubTag = "";
        this.mHasTrackerSubTag = false;
        this.mIsPcMode = false;
        this.mDestroyObservable = new DestroyObservable(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r3) {
        if (this.mDestroyObservable.isDestroyed() == false) goto L5;
        this.mDestroyObservable = new DestroyObservable(this);
    L5:
        super.onCreate(r3);
        this.mClassName = getClass().getSimpleName();
        String r4 = getTrackerSubTag();
        this.mTrackerSubTag = r4;
        boolean r5 = !TextUtils.isEmpty(r4);
        this.mHasTrackerSubTag = r5;
        if (r5 == false) goto L8;
        Agent.getInstance().onAttach(this.mClassName, this.mTrackerSubTag);
    L9:
        this.mIsPcMode = SmtPcUtils.isPcMode(getContext());
        return;
    L8:
        Agent.getInstance().onAttach(this.mClassName);
        goto L9
    }

    protected void setupLongMenu() {
        this.mLongMenuHelper = new LongMenuHelper(getActivity(), this);
    }

    public void dismissLongMenu() {
        LongMenuHelper r0 = this.mLongMenuHelper;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        this.mLongMenuHelper.dismiss();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mHasTrackerSubTag == false) goto L5;
        Agent.getInstance().onDetach(this.mClassName, this.mTrackerSubTag);
    L6:
        Agent.getInstance().flush();
        this.mDestroyObservable.onDestroy();
        return;
    L5:
        Agent.getInstance().onDetach(this.mClassName);
        goto L6
    }

    public DestroyObservable getDestroyObservable() {
        return this.mDestroyObservable;
    }
}
