package com.android.internal.chooser.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.android.internal.chooser.bean.ChooserTargets;
import java.util.List;

/* loaded from: classes.dex */
public interface ChooserTargetsFinder {
    ChooserTargets loadResolveInfo(Context context, Intent intent, Intent[] intentArr, List<ResolveInfo> list);

    ChooserTargets sortAndLoadDisplayInfo(ChooserTargets chooserTargets);
}
