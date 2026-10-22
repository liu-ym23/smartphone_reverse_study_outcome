package com.bytedance.android.live.liveinteract.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i {
    public static final boolean a(FragmentManager r100) {
        Intrinsics.checkNotNullParameter(r100, "fragmentManager");
        Intrinsics.checkNotNullParameter("LivePlayFragment", "fragmentName");
        Iterator<Fragment> r101 = r100.getFragments().iterator();
    L4:
        if (r101.hasNext() == false) goto L15;
        Fragment r102 = r101.next();
        if (Intrinsics.areEqual("LivePlayFragment", r102.getClass().getSimpleName()) == false) goto L11;
        if (r102.isVisible() == false) goto L11;
        return true;
    L11:
        if (r102.isAdded() == false) goto L4;
        if (a(r102.getChildFragmentManager()) == false) goto L4;
        return true;
    L15:
        return false;
    }
}
