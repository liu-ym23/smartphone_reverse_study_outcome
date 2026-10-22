package com.android.internal.chooser.chooser;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.Looper;
import com.android.internal.chooser.base.BaseResolverContract;
import com.android.internal.chooser.base.ChooserTargetsFinder;
import com.android.internal.chooser.bean.ChooserTargets;
import com.android.internal.chooser.utils.Executor;
import java.util.List;

/* loaded from: classes.dex */
public class ChooserPresenter implements BaseResolverContract.Presenter {
    private ChooserTargetsFinder mFinder;
    private Handler mMainHandler = new Handler(Looper.getMainLooper());
    private BaseResolverContract.View mView;

    public ChooserPresenter(BaseResolverContract.View view, ChooserTargetsFinder finder) {
        this.mView = view;
        this.mFinder = finder;
    }

    @Override // com.android.internal.chooser.base.BaseResolverContract.Presenter
    public void fetchUnsortedNormalTargets(Context context, Intent intent, Intent[] initIntents, List<ResolveInfo> rList) {
        ChooserTargets targets = this.mFinder.loadResolveInfo(context, intent, initIntents, rList);
        this.mView.showNormalTargets(targets, false, false);
    }

    @Override // com.android.internal.chooser.base.BaseResolverContract.Presenter
    public void fetchSortedNormalTargets(Context context, final ChooserTargets targets) {
        Executor.getInstance().execute(new Runnable() { // from class: com.android.internal.chooser.chooser.ChooserPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                final ChooserTargets sortedTarget = ChooserPresenter.this.mFinder.sortAndLoadDisplayInfo(targets);
                ChooserPresenter.this.mMainHandler.post(new Runnable() { // from class: com.android.internal.chooser.chooser.ChooserPresenter.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChooserPresenter.this.mView.showNormalTargets(sortedTarget, true, true);
                    }
                });
            }
        });
    }
}
