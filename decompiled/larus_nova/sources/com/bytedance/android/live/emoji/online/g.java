package com.bytedance.android.live.emoji.online;

import bolts.Continuation;
import bolts.Task;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.emoji.online.model.OnlineSmallEmoji;
import com.bytedance.android.live.emoji.online.model.OnlineSmallEmojiResInfo;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes45.dex */
public final class g<TTaskResult, TContinuationResult> implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OnlineSmallEmojiResManager f68934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f68935b;

    public g(OnlineSmallEmojiResManager r100, String r101) {
        this.f68934a = r100;
        this.f68935b = r101;
    }

    @Override // bolts.Continuation
    public final Object then(Task r110) {
        ALogger.d("OnlineEmojiResManager", "  preloadResourceInfo: " + this.f68935b + ", result=" + ((OnlineSmallEmojiResInfo) r110.getResult()));
        OnlineSmallEmojiResInfo r111 = (OnlineSmallEmojiResInfo) r110.getResult();
        boolean r100 = false;
        if (r111 != null) goto L5;
    L50:
        this.f68934a.f68919f = 3;
        this.f68934a.f68921h = false;
        Unit r112 = Unit.INSTANCE;
    L51:
        return null;
    L5:
        if (r111.isValid() == true) goto L8;
        r111 = null;
    L8:
        if (r111 == null) goto L50;
        this.f68934a.f68914a = r111;
        List<OnlineSmallEmoji> r101 = r111.getStickers();
        if (r101 == null) goto L17;
        Iterator<T> r102 = r101.iterator();
    L13:
        if (r102.hasNext() == false) goto L17;
        OnlineSmallEmoji r103 = (OnlineSmallEmoji) r102.next();
        ((LinkedHashMap) this.f68934a.f68915b.getValue()).put(r103.getDisplayName(), r103.getUri());
        if (r103.showInPanel() == false) goto L13;
        this.f68934a.b().put(r103.getDisplayName(), r103.getUri());
    L17:
        OnlineSmallEmojiResManager r104 = this.f68934a;
        int r105 = OnlineSmallEmojiCache.f68909d;
        Intrinsics.checkNotNullParameter(r111, "resInfo");
        OnlineSmallEmojiCache r106 = new OnlineSmallEmojiCache(r111);
        LinkedHashMap<String, String> r107 = a.f68922a;
        Intrinsics.checkNotNullParameter(r111, "info");
        a.f68924c = r111;
        List<OnlineSmallEmoji> r113 = r111.getStickers();
        List<OnlineSmallEmoji> r108 = r113;
        if (r108 != null) goto L20;
    L21:
        r100 = true;
    L22:
        if (r100 == true) goto L35;
        LinkedHashMap r109 = new LinkedHashMap(256);
        Iterator r114 = SequencesKt.filter(CollectionsKt.asSequence(r113), HadesEmojiResManager$initEmojiNameMap$1.INSTANCE).iterator();
    L26:
        if (r114.hasNext() == false) goto L28;
        OnlineSmallEmoji r115 = (OnlineSmallEmoji) r114.next();
        r109.put(r115.getDisplayName(), r115.getUri());
        goto L26
    L28:
        Iterator r116 = CollectionsKt.listOf(new String[]{"[爱心]", "[赞]", "[看]", "[笑哭]", "[比心]", "[屎]", "[绝]", "[666]"}).iterator();
    L30:
        if (r116.hasNext() == false) goto L34;
        String r117 = (String) r116.next();
        String r118 = (String) r109.remove(r117);
        if (r118 == null) goto L30;
        a.f68922a.put(r117, r118);
        goto L30
    L34:
        a.f68922a.putAll(r109);
    L35:
        com.bytedance.android.live.emoji.utils.a r119 = com.bytedance.android.live.emoji.utils.a.a();
        r119.getClass();
        String r120 = r119.f68948a.getString("recent_hades_emoji_list", "");     // Catch: Exception -> L42
        Gson r121 = com.bytedance.android.live.emoji.utils.d.f68953a;     // Catch: Exception -> L42
        Intrinsics.checkNotNullParameter(String[].class, "clazz");     // Catch: Exception -> L42
        Object[] r122 = (Object[]) GsonProtectorUtils.fromJson(com.bytedance.android.live.emoji.utils.d.f68953a, r120, String[].class);     // Catch: Exception -> L42
        if (r122 == null) goto L40;
        List<String> r123 = ArraysKt.toMutableList(r122);     // Catch: Exception -> L42
        if (r123 == null) goto L40;
    L43:
        if (r123 != null) goto L46;
        r123 = CollectionsKt.emptyList();
    L46:
        if (r123.size() >= 6) goto L49;
        r123 = CollectionsKt.listOf(new String[]{"[爱心]", "[赞]", "[大笑]", "[捂脸]", "[看]", "[屎]"});
    L49:
        a.f68923b = r123;
        Unit r124 = Unit.INSTANCE;
        r104.f68917d = r106;
        this.f68934a.f68919f = 2;
    L40:
        r123 = new ArrayList();     // Catch: Exception -> L42
    L42:
        r123 = null;
        goto L43
    L20:
        if (r108.isEmpty() == false) goto L22;
        goto L21
    }
}
