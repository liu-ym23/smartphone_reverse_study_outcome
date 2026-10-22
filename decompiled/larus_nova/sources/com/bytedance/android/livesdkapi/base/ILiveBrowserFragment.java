package com.bytedance.android.livesdkapi.base;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes12.dex */
public interface ILiveBrowserFragment extends ILiveWebCommonApi {
    Fragment getFragment();

    View getHybridView();

    void onBackPressed();

    void setDialogFragment(DialogFragment r100);

    void setEnableTouchEventCheck(boolean r100);
}
