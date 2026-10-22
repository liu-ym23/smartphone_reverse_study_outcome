package com.bytedance.android.live.emoji.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends BaseEmoji> f68950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<String> f68951b;

    public static final class a {
    }

    static {
    }

    public final List<BaseEmoji> a() {
        List<? extends BaseEmoji> r100 = this.f68950a;
        if (r100 != null) goto L5;
    L6:
        this.f68950a = r90.a.a().b();
    L7:
        Iterable r101 = this.f68950a;
        if (r101 != null) goto L10;
        r101 = new ArrayList();
    L10:
        List<String> r102 = com.bytedance.android.livesdk.sharedpref.b.C1.getValue();
        int r103 = 0;
        if (r102.size() >= 8) goto L13;
        r102.addAll(this.f68951b.subList(0, 8 - r102.size()));
    L13:
        LinkedHashSet r104 = new LinkedHashSet();
        Iterator<T> r105 = r102.iterator();
    L15:
        if (r105.hasNext() == false) goto L27;
        String r106 = (String) r105.next();
        Iterator r107 = r101.iterator();
    L18:
        if (r107.hasNext() == false) goto L22;
        Object r108 = r107.next();
        if (Intrinsics.areEqual(((BaseEmoji) r108).getDescription(), r106) == false) goto L18;
    L23:
        BaseEmoji r109 = (BaseEmoji) r108;
        if (r109 == null) goto L15;
        r104.add(r109);
        goto L15
    L22:
        r108 = null;
        goto L23
    L27:
        if (r104.size() >= 8) goto L37;
        ALogger.e("EmojiLocalRecentManager", "recent data is error!");
        Iterator r110 = r101.iterator();
        if (r110.hasNext() == false) goto L37;
        BaseEmoji r111 = (BaseEmoji) r110.next();
        int r112 = 8 - r104.size();
    L31:
        if (r103 >= r112) goto L37;
        if (r104.contains(r111) == true) goto L35;
        r104.add(r111);
    L35:
        r103 = r103 + 1;
    L37:
        return CollectionsKt.toList(r104);
    L5:
        if (r100.isEmpty() != true) goto L7;
        goto L6
    }

    public b() {
        this.f68951b = CollectionsKt.arrayListOf(new String[]{"[赞]", "[玫瑰]", "[捂脸]", "[666]", "[鼓掌]", "[呲牙]", "[微笑]", "[耶]", "[爱心]"});
    }
}
