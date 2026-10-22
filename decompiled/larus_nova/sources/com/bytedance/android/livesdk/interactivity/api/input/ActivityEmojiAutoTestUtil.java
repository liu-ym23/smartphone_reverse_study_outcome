package com.bytedance.android.livesdk.interactivity.api.input;

import com.bytedance.android.live.base.model.data.activityemoji.b;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.b4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class ActivityEmojiAutoTestUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f133248a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f133249b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ActivityEmojiAutoTestUtil f133250c = null;

    public ActivityEmojiAutoTestUtil() {
    }

    static {
        f133250c = new ActivityEmojiAutoTestUtil();
        if (b4.f104233a.getValue().booleanValue() == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        f133248a = r100;
        f133249b = LazyKt.lazy(ActivityEmojiAutoTestUtil$bean$2.INSTANCE);
        return;
    L5:
        if (v.a() == false) goto L7;
        r100 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List<java.lang.Long>] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List<java.lang.Long>] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.ArrayList] */
    public static void a(List r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "from");
        if (v.a() == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r101, "EmojiArea") == false) goto L15;
        a r102 = (a) f133249b.getValue();
        if (r100 == null) goto L13;
        List r103 = r100;
        ?? r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L11:
        if (r105.hasNext() == false) goto L14;
        r104.add(Long.valueOf(((b) r105.next()).getId()));
    L14:
        r102.f133252a = r104;
        return;
    L13:
        r104 = CollectionsKt.emptyList();
        goto L14
    L15:
        a r106 = (a) f133249b.getValue();
        if (r100 == null) goto L21;
        List r107 = r100;
        ?? r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator r109 = r107.iterator();
    L19:
        if (r109.hasNext() == false) goto L22;
        r108.add(Long.valueOf(((b) r109.next()).getId()));
    L22:
        r106.f133253b = r108;
        return;
    L21:
        r108 = CollectionsKt.emptyList();
        goto L22
    }
}
