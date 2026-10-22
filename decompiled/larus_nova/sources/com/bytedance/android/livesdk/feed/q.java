package com.bytedance.android.livesdk.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerFollowViewHolder;
import com.larus.nova.R;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: classes8.dex */
public final class q implements b90.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f124305a = null;

    static {
        f124305a = new q();
    }

    public q() {
    }

    @Override // b90.a
    public final BaseViewHolder<Object> a(ViewGroup r100, Object[] r101) {
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_feed_drawer_follow_layout, r100, false);
        if (r101.length <= 4) goto L11;
        Object r103 = r101[4];
        if ((r103 instanceof PublishSubject) == false) goto L11;
        if (r103 == null) goto L9;
        PublishSubject r104 = (PublishSubject) r103;
        goto L11
    L9:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Boolean?>");
    L11:
        return new DrawerFollowViewHolder(r102);
    }
}
