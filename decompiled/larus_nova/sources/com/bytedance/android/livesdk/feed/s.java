package com.bytedance.android.livesdk.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.live.LiveNoticeViewHolder;
import com.larus.nova.R;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: classes8.dex */
public final class s implements b90.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f124346a = null;

    static {
        f124346a = new s();
    }

    public s() {
    }

    @Override // b90.a
    public final BaseViewHolder<Object> a(ViewGroup r100, Object[] r101) {
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_feed_drawer_notice_switcher_layout, r100, false);
        if (r101.length != 0) goto L5;
        boolean r103 = true;
    L7:
        if ((!r103) == false) goto L14;
        Object r104 = r101[0];
        if ((r104 instanceof mv1.l) == false) goto L14;
        if (r104 == null) goto L13;
        mv1.l r105 = (mv1.l) r104;
        r105.a();
        r105.b();
        goto L14
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.feed.adapter.IPayloadProvider");
    L14:
        PublishSubject r106 = null;
        if (r101.length <= 2) goto L22;
        Object r107 = r101[2];
        if ((r107 instanceof PublishSubject) == false) goto L22;
        if (r107 == null) goto L21;
        PublishSubject r108 = (PublishSubject) r107;
    L24:
        if (r101.length <= 3) goto L31;
        Object r109 = r101[3];
        if ((r109 instanceof PublishSubject) == false) goto L31;
        if (r109 == null) goto L30;
        PublishSubject r110 = (PublishSubject) r109;
    L33:
        if (r101.length <= 4) goto L41;
        Object r111 = r101[4];
        if ((r111 instanceof PublishSubject) == false) goto L41;
        if (r111 == null) goto L39;
        r106 = (PublishSubject) r111;
        goto L41
    L39:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Boolean?>");
    L41:
        return new LiveNoticeViewHolder(r102, r108, r110, r106);
    L30:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Any?>");
    L31:
        r110 = null;
        goto L33
    L21:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Any?>");
    L22:
        r108 = null;
        goto L24
    L5:
        r103 = false;
        goto L7
    }
}
