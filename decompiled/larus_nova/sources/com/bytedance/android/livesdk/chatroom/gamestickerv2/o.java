package com.bytedance.android.livesdk.chatroom.gamestickerv2;

import androidx.collection.LruCache;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerTypeRoomCache;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class o implements IGameStickerTypeRoomCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<String, Set<Integer>> f106357a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f106358b = null;

    public o() {
    }

    static {
        f106358b = new o();
        f106357a = new LruCache(30);
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerTypeRoomCache
    public final Set<Integer> get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        Set<Integer> r102 = f106357a.get(r100);
        if (r102 == null) goto L12;
        return r102;
    L12:
        return SetsKt.emptySet();
    L8:
        return SetsKt.emptySet();
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerTypeRoomCache
    public final void cache(String r100, Set<Integer> r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "types");
        if (r101.isEmpty() == false) goto L5;
        return;
    L5:
        if (r100.length() != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L16;
        LruCache<String, Set<Integer>> r103 = f106357a;
        Set<Integer> r104 = r103.get(r100);
        if (r104 != null) goto L13;
        r104 = new LinkedHashSet();
    L13:
        r104.addAll(r101);
        r103.put(r100, r104);
        return;
    L16:
        return;
    L7:
        r102 = false;
        goto L8
    }
}
