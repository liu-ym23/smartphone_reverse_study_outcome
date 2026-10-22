package com.bytedance.android.livesdk.interactivity.comment;

import com.bytedance.android.livesdk.interactivity.api.comment.CommentComponentType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class t implements t22.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CommentComponentType f136242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.interactivity.c> f136243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.e f136244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DataCenter f136245d;

    public final x22.a a() {
        Iterator<T> r100 = this.f136243b.iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.android.livesdk.interactivity.c) r101).a() == null) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.android.livesdk.interactivity.c r103 = (com.bytedance.android.livesdk.interactivity.c) r101;
        if (r103 != null) goto L15;
        return null;
    L15:
        return r103.a();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    @Override // t22.a
    public final void onLoad() {
        com.bytedance.android.livesdk.interactivity.api.h r100 = com.bytedance.android.livesdk.interactivity.api.i.b(this.f136245d, 1);
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.j<t22.g> r101 = r100.getTopicTipManager();
        if (r101 == null) goto L9;
        t22.g r102 = r101.getValue();
        if (r102 == null) goto L9;
        ((ArrayList) this.f136243b).add(r102);
    L9:
        Iterator r103 = ((ArrayList) this.f136243b).iterator();
    L11:
        if (r103.hasNext() == false) goto L13;
        ((com.bytedance.android.livesdk.interactivity.c) r103.next()).b(this.f136244c);
        goto L11
    }

    @Override // t22.a
    public final void onUnload() {
        Iterator<T> r100 = this.f136243b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.interactivity.c) r100.next()).b(null);
        goto L4
    L6:
        ((ArrayList) this.f136243b).clear();
    }

    @Override // t22.a
    public CommentComponentType getType() {
        return this.f136242a;
    }

    public t(i0 r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "updateCb");
        this.f136244c = r100;
        this.f136245d = r101;
        this.f136242a = CommentComponentType.Tip;
        this.f136243b = new ArrayList();
    }
}
