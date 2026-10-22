package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.model.response.anchorv3.GroupAvatarTimeStruct;
import com.bytedance.android.ec.model.response.anchorv3.GroupInfo;
import com.facebook.drawee.view.SimpleDraweeView;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class i implements CompletableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f167964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GroupInfo f167965b;

    public i(ViewGroup r100, GroupInfo r101) {
        this.f167964a = r100;
        this.f167965b = r101;
    }

    @Override // io.reactivex.CompletableOnSubscribe
    public final void subscribe(CompletableEmitter r110) {
        Intrinsics.checkNotNullParameter(r110, "emitter");
    L39:
        th = move-exception;
        r110.onError(th);
        return;
    L4:
        if (this.f167964a.getChildCount() <= 0) goto L6;
        this.f167964a.removeAllViews();     // Catch: Throwable -> L39
    L6:
        List<GroupAvatarTimeStruct> r100 = this.f167965b.getAvatars();     // Catch: Throwable -> L39
        List<GroupAvatarTimeStruct> r101 = r100;     // Catch: Throwable -> L39
        if (r101 != null) goto L9;
    L12:
        boolean r102 = true;
    L13:
        if (r102 == false) goto L15;
        List r103 = CollectionsKt.listOf(new GroupAvatarTimeStruct("https://p26-item.ecombdimg.com/tos-cn-i-5mmsx3fupr/2b7995a8c4a1a9776150d9cb2461ddae.png~tplv-5mmsx3fupr-origin-png.png", 0, 2, null));     // Catch: Throwable -> L39
    L16:
        List r104 = r103;     // Catch: Throwable -> L39
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));     // Catch: Throwable -> L39
        Iterator r106 = r104.iterator();     // Catch: Throwable -> L39
        int r107 = 0;
    L18:
        if (r106.hasNext() == false) goto L33;
        Object r108 = r106.next();     // Catch: Throwable -> L39
        int r109 = r107 + 1;     // Catch: Throwable -> L39
        if (r107 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L39
    L22:
        Context r111 = this.f167964a.getContext();     // Catch: Throwable -> L39
        SimpleDraweeView r112 = l.a(r111, (GroupAvatarTimeStruct) r108);     // Catch: Throwable -> L39
        if (r107 != 0) goto L25;
        int r113 = 0;
    L26:
        ViewGroup.LayoutParams r114 = r112.getLayoutParams();     // Catch: Throwable -> L39
        if ((r114 instanceof ViewGroup.MarginLayoutParams) == true) goto L29;
        r114 = null;
    L29:
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r114;     // Catch: Throwable -> L39
        if (r115 == null) goto L32;
        r115.leftMargin = r113;     // Catch: Throwable -> L39
    L32:
        r105.add(r112);     // Catch: Throwable -> L39
        r107 = r109;
        goto L18
    L25:
        r113 = vf4.a.b(-8);     // Catch: Throwable -> L39
        goto L26
    L33:
        Iterator r116 = r105.iterator();     // Catch: Throwable -> L39
    L35:
        if (r116.hasNext() == false) goto L37;
        View r117 = (View) r116.next();     // Catch: Throwable -> L39
        this.f167964a.addView(r117);     // Catch: Throwable -> L39
        goto L35
    L37:
        r110.onComplete();     // Catch: Throwable -> L39
        return;
    L15:
        r103 = CollectionsKt.take(r100, 5);     // Catch: Throwable -> L39
        goto L16
    L9:
        if (r101.isEmpty() == true) goto L12;
        r102 = false;
        goto L13
    }
}
