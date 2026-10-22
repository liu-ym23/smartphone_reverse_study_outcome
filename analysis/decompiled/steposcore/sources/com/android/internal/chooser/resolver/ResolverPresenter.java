package com.android.internal.chooser.resolver;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.Looper;
import com.android.internal.chooser.base.BaseResolverContract;
import com.android.internal.chooser.bean.ChooserTargets;
import com.android.internal.chooser.utils.Executor;
import java.util.List;

/* loaded from: classes.dex */
public class ResolverPresenter implements BaseResolverContract.Presenter {
    private ResolverFinder mFinder;
    private Handler mMainHandler = new Handler(Looper.getMainLooper());
    private BaseResolverContract.View mView;

    public ResolverPresenter(BaseResolverContract.View view, ResolverFinder finder) {
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
        Executor.getInstance().execute(new Runnable() { // from class: com.android.internal.chooser.resolver.ResolverPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                final ChooserTargets sortedTarget = ResolverPresenter.this.mFinder.sortAndLoadDisplayInfo(targets);
                ResolverPresenter.this.mMainHandler.post(new Runnable() { // from class: com.android.internal.chooser.resolver.ResolverPresenter.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ResolverPresenter.this.mView.showNormalTargets(sortedTarget, true, true);
                    }
                });
            }
        });
    }
}
