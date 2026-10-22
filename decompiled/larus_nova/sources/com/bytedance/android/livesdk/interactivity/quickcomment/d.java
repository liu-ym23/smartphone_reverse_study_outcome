package com.bytedance.android.livesdk.interactivity.quickcomment;

import com.bytedance.android.livesdk.interactivity.api.quickcomment.IQuickCommentShowWord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements com.bytedance.android.livesdk.interactivity.api.quickcomment.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<IQuickCommentShowWord> f140561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f140562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f140563d;

    @Override // com.bytedance.android.livesdk.interactivity.api.quickcomment.e
    public final List<IQuickCommentShowWord> a() {
        return this.f140561b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.quickcomment.e
    public final int getDuration() {
        return this.f140562c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.quickcomment.e
    public int getType() {
        return this.f140563d;
    }

    public d(com.bytedance.android.livesdk.interactivity.api.quickcomment.g r100) {
        Intrinsics.checkNotNullParameter(r100, "syncData");
        ArrayList r101 = new ArrayList();
        this.f140561b = r101;
        this.f140562c = 30;
        Intrinsics.checkNotNullParameter(r100, "syncData");
        List<String> r102 = r100.supportComments;
        if (r102 == null) goto L13;
        int r103 = r100.commentType;
        this.f140563d = r103;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.e.f133749a.getClass();
        if (r103 == 1) goto L7;
    L9:
        Iterator<String> r104 = r102.iterator();
    L11:
        if (r104.hasNext() == false) goto L16;
        String r105 = r104.next();
        this.f140561b.add(new QuickCommentShowWord(r105, r100.commentType, r100.backgroundColor));
        goto L11
    L16:
        return;
    L7:
        if (r102.size() <= 2) goto L9;
        ArrayList r106 = new ArrayList();
        r106.addAll(r102);
        Random.Default r107 = Random.Default;
        String r108 = (String) CollectionsKt.random(r106, r107);
        r101.add(new QuickCommentShowWord(r108, r100.commentType, r100.backgroundColor));
        r106.remove(r108);
        r101.add(new QuickCommentShowWord((String) CollectionsKt.random(r106, r107), r100.commentType, r100.backgroundColor));
        return;
    }
}
