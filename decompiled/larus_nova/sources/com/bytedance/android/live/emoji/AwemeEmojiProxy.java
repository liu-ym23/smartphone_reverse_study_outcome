package com.bytedance.android.live.emoji;

import android.graphics.drawable.Drawable;
import bolts.Task;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.emoji.api.IAwemeEmojiProxy;
import com.bytedance.android.live.emoji.online.OnlineEmojiApi;
import com.bytedance.android.live.emoji.online.OnlineSmallEmojiResManager;
import com.bytedance.android.live.emoji.online.h;
import com.bytedance.android.live.emoji.online.i;
import com.bytedance.android.live.emoji.utils.EmojiResHelper;
import com.bytedance.android.live.emoji.utils.a;
import com.bytedance.android.live.emoji.utils.d;
import com.bytedance.android.live.network.c;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import r90.e;
import r90.f;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/emoji/AwemeEmojiProxy;", "Lcom/bytedance/android/live/emoji/api/IAwemeEmojiProxy;", "()V", "getRealDrawable", "Landroid/graphics/drawable/Drawable;", "emojiText", "", "getRecommendEmojiList", "", "Lcom/bytedance/android/livehostapi/business/model/emoji/BaseEmoji;", "loadAllBaseEmoji", "preloadOnlineEmoji", "", "updateRecentEmoji", "liveemoji-impl_release"}, k = 1, mv = {1, 4, 3})
public class AwemeEmojiProxy implements IAwemeEmojiProxy {
    public AwemeEmojiProxy() {
    }

    @Override // com.bytedance.android.live.emoji.api.IAwemeEmojiProxy
    public List<BaseEmoji> getRecommendEmojiList() {
        List<String> r100 = f.f536687a;
        IUserService r101 = (IUserService) k.f(IUserService.class);
        if (r101 == null) goto L8;
        com.bytedance.android.livesdk.user.f r102 = r101.user();
        if (r102 == null) goto L8;
        String r103 = r102.n();
        if (r103 == null) goto L8;
    L10:
        if ((!Intrinsics.areEqual(f.f536688b, r103)) == false) goto L21;
        f.f536688b = r103;
        String r104 = a.a().f68948a.getString("recent_system_small_emojis", "");
        Gson r105 = d.f68953a;     // Catch: Exception -> L18
        Intrinsics.checkNotNullParameter(String[].class, "clazz");     // Catch: Exception -> L18
        Object[] r106 = (Object[]) GsonProtectorUtils.fromJson(d.f68953a, r104, String[].class);     // Catch: Exception -> L18
        if (r106 == null) goto L16;
        List<String> r107 = ArraysKt.toMutableList(r106);     // Catch: Exception -> L18
        if (r107 == null) goto L16;
    L20:
        f.f536687a = r107;
    L16:
        r107 = new ArrayList();     // Catch: Exception -> L18
    L18:
        e = move-exception;
        ArrayList r108 = new ArrayList();
        ALogger.e("BusinessEmojiSPUtils", e);
        r107 = r108;
    L21:
        List<String> r109 = f.f536687a;
        if (r109 != null) goto L24;
        r109 = CollectionsKt.emptyList();
    L24:
        EmojiResHelper r110 = EmojiResHelper.f68943c;
        List<BaseEmoji> r111 = EmojiResHelper.a.a(jc1.a.b()).b(r109);
        if (r111.size() > 8) goto L27;
        return r111;
    L27:
        return r111.subList(0, 8);
    L8:
        r103 = "0";
        goto L10
    }

    @Override // com.bytedance.android.live.emoji.api.IAwemeEmojiProxy
    public List<BaseEmoji> loadAllBaseEmoji() {
        EmojiResHelper r100 = EmojiResHelper.f68943c;
        EmojiResHelper r101 = EmojiResHelper.a.a(jc1.a.b().getApplicationContext());
        return r101.d(r101.c());
    }

    @Override // com.bytedance.android.live.emoji.api.IAwemeEmojiProxy
    public void preloadOnlineEmoji() {
        a r100 = a.a();
        r100.getClass();
        if ((System.currentTimeMillis() - r100.f68949b.getLong("refresh_online_emoji_time", 0)) <= 86400000) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L11;
        OnlineSmallEmojiResManager r102 = OnlineSmallEmojiResManager.f68913i;
        if (r102.f68920g == true) goto L11;
        r102.f68920g = true;
        a.a().f68949b.edit().putLong("refresh_online_emoji_time", System.currentTimeMillis()).commit();
        ALogger.d("OnlineEmojiResManager", "  refreshEmoji start");
        l.d().getClass();
        ((OnlineEmojiApi) c.b().e(OnlineEmojiApi.class)).getSmallEmojiResources().subscribe(new i(r102));
    L11:
        OnlineSmallEmojiResManager r103 = OnlineSmallEmojiResManager.f68913i;
        r103.getClass();
        Task.call(new h(r103, false), Task.UI_THREAD_EXECUTOR);
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.emoji.api.IAwemeEmojiProxy
    public Drawable getRealDrawable(String r100) {
        EmojiResHelper r101 = EmojiResHelper.f68943c;
        return EmojiResHelper.a.a(jc1.a.b()).a(jc1.a.b(), r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.util.ArrayList] */
    @Override // com.bytedance.android.live.emoji.api.IAwemeEmojiProxy
    public void updateRecentEmoji(String r100) {
        List<String> r101 = f.f536687a;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L22;
        Ref.ObjectRef r103 = new Ref.ObjectRef();
        ?? r104 = new ArrayList();
        r103.element = r104;
        List<String> r105 = f.f536687a;
        if (r105 == null) goto L15;
        r104.addAll(r105);
    L15:
        if (((ArrayList) r103.element).isEmpty() == false) goto L17;
        ((ArrayList) r103.element).add(r100);
    L20:
        f.f536687a = (ArrayList) r103.element;
        Observable.create(new e(r103)).subscribeOn(Schedulers.io()).subscribe();
        return;
    L17:
        ((ArrayList) r103.element).remove(r100);
        ListProtector.add((ArrayList) r103.element, 0, r100);
        if (((ArrayList) r103.element).size() <= 8) goto L20;
        List r106 = ((ArrayList) r103.element).subList(0, 8);
        ?? r107 = new ArrayList();
        r107.addAll(r106);
        r103.element = r107;
        goto L20
    L22:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
