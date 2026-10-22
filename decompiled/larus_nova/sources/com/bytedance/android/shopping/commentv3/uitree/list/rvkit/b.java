package com.bytedance.android.shopping.commentv3.uitree.list.rvkit;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.commentv3.view.CommentSliceView;
import com.bytedance.android.shopping.commentv3.view.FilterCardSliceView;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Integer> f172846a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f172847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f172848c;

    static {
        f172846a = new ConcurrentHashMap();
        f172847b = 4;
        f172848c = 1;
    }

    public static CommentSliceView a(int r100, ViewGroup r101) {
        if (r100 == 1001) goto L5;
        CommentSliceView r102 = new CommentSliceView(r101.getContext(), null, 6, 0);
    L6:
        r102.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return r102;
    L5:
        r102 = new FilterCardSliceView(r101.getContext(), null, 6, 0);
        goto L6
    }
}
