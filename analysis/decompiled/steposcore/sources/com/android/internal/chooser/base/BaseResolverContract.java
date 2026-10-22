package com.android.internal.chooser.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.android.internal.chooser.bean.ChooserTargets;
import java.util.List;

/* loaded from: classes.dex */
public class BaseResolverContract {

    public interface Presenter {
        void fetchSortedNormalTargets(Context context, ChooserTargets chooserTargets);

        void fetchUnsortedNormalTargets(Context context, Intent intent, Intent[] intentArr, List<ResolveInfo> list);
    }

    public interface View {
        void showNormalTargets(ChooserTargets chooserTargets, boolean z, boolean z2);
    }
}
