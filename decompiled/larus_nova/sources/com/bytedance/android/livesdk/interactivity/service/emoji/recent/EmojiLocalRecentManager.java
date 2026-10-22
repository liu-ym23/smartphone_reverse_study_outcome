package com.bytedance.android.livesdk.interactivity.service.emoji.recent;

import com.bytedance.android.livehostapi.business.IMiddleWareHostEmoji;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class EmojiLocalRecentManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<c> f140846a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List<? extends BaseEmoji> f140847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, BaseEmoji> f140848c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ArrayList<String> f140849d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static LinkedHashMap<String, b> f140850e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final EmojiLocalRecentManager f140851f = null;

    public EmojiLocalRecentManager() {
    }

    static {
        f140851f = new EmojiLocalRecentManager();
        f140846a = new e("live_input_recent_emoji_data", new c(new ArrayList()));
        f140848c = new HashMap();
        f140849d = CollectionsKt.arrayListOf(new String[]{"[赞]", "[玫瑰]", "[捂脸]", "[666]", "[鼓掌]", "[呲牙]", "[微笑]", "[耶]", "[爱心]"});
    }

    public static List a() {
        List<? extends BaseEmoji> r100 = f140847b;
        if (r100 != null) goto L5;
    L6:
        ab2.b.a().f2471a.getClass();
        IMiddleWareHostEmoji r101 = (IMiddleWareHostEmoji) k.f(IMiddleWareHostEmoji.class);
        if (r101 == null) goto L9;
        List<BaseEmoji> r102 = r101.loadAllBaseEmoji();
    L10:
        f140847b = r102;
        ((HashMap) f140848c).clear();
        List<? extends BaseEmoji> r103 = f140847b;
        if (r103 == null) goto L26;
        Iterator<T> r104 = r103.iterator();
    L14:
        if (r104.hasNext() == false) goto L26;
        BaseEmoji r105 = (BaseEmoji) r104.next();
        if (r105 == null) goto L14;
        String r106 = r105.getDescription();
        if (r106 != null) goto L20;
    L23:
        boolean r107 = true;
    L24:
        if (r107 == true) goto L14;
        Map<String, BaseEmoji> r108 = f140848c;
        HashMap r109 = (HashMap) r108;
        r109.put(r105.getDescription(), r105);
        goto L14
    L20:
        if (r106.length() == 0) goto L23;
        r107 = false;
    L26:
        List<? extends BaseEmoji> r110 = f140847b;
        if (r110 == null) goto L29;
        return r110;
    L29:
        return new ArrayList();
    L9:
        r102 = new ArrayList();
        goto L10
    L5:
        if (r100.isEmpty() != true) goto L26;
        goto L6
    }

    public static void c() {
        if (f140850e != null) goto L12;
        f140850e = new LinkedHashMap();
        Iterator r100 = b().iterator();
    L6:
        if (r100.hasNext() == false) goto L20;
        b r101 = (b) r100.next();
        String r102 = r101.b();
        if (r102 == null) goto L6;
        LinkedHashMap<String, b> r103 = f140850e;
        if (r103 == null) goto L6;
        b r104 = r103.put(r102, r101);
        goto L6
    L20:
        return;
    }

    public static List b() {
        List r100 = a();
        List<b> r101 = f140846a.getValue().a();     // Catch: Throwable -> L7
        if (r101 != null) goto L8;
        r101 = new ArrayList();     // Catch: Throwable -> L7
    L8:
        int r102 = 0;
        if (r101.size() >= 8) goto L16;
        List<String> r103 = f140849d.subList(0, 8 - r101.size());
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L12:
        if (r105.hasNext() == false) goto L14;
        r104.add(new b((String) r105.next(), 0, new ArrayList()));
        goto L12
    L14:
        r101.addAll(r104);
    L16:
        if (r101.size() >= 8) goto L28;
        pm0.b r106 = om0.c.f();
        if (r106 == null) goto L20;
        r106.e("EmojiLocalRecentManager", "recent data is error!");
    L20:
        Iterator r107 = r100.iterator();
        if (r107.hasNext() == false) goto L28;
        BaseEmoji r108 = (BaseEmoji) r107.next();
        int r109 = 8 - r101.size();
    L23:
        if (r102 >= r109) goto L28;
        b r110 = new b(r108.getDescription(), 0, new ArrayList());
        if (r101.contains(r110) == true) goto L27;
        r101.add(r110);
    L27:
        r102 = r102 + 1;
    L28:
        return r101;
    L7:
        r101 = new ArrayList();
        goto L8
    }

    public static void d(BaseEmoji r100) {
        Intrinsics.checkNotNullParameter(r100, "emoji");
        c();
        LinkedHashMap<String, b> r101 = f140850e;
        if (r101 == null) goto L6;
        b r102 = r101.remove(r100.getDescription());
        if (r102 == null) goto L6;
    L7:
        r102.e(System.currentTimeMillis());
        final long r103 = System.currentTimeMillis() / 86400000;
        ArrayList<a> r104 = r102.c();
        if (r104 == null) goto L22;
        CollectionsKt.removeAll(r104, new EmojiLocalRecentManager$updateRecentEmoji$1(r103));
        a r105 = (a) CollectionsKt.lastOrNull(r104);
        if (r105 == null) goto L15;
        if (r105.b() != r103) goto L15;
        r105.c(r105.a() + 1);
    L18:
        LinkedHashMap<String, b> r106 = f140850e;
        if (r106 == null) goto L23;
        b r107 = r106.put(r100.getDescription(), r102);
        return;
    L23:
        return;
    L15:
        if (r104.size() < 7) goto L17;
        ListProtector.remove(r104, 0);
        r104.add(new a(r103));
        goto L18
    L17:
        r104.add(new a(r103));
        goto L18
    L22:
        return;
    L6:
        r102 = new b(r100.getDescription(), 0, new ArrayList());
        goto L7
    }
}
