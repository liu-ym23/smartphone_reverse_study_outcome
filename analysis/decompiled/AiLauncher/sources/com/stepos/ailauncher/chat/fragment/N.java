package com.stepos.ailauncher.chat.fragment;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.model.SkillItemBrief;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u0014\u0010\u000bJ\u001d\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\rR<\u0010\u0018\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0016j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R<\u0010\u001a\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0016j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/N;", "", "<init>", "()V", "", "key", "", "Lcom/stepos/ailauncher/contract/model/SkillItemBrief;", DidiCardProvider.KEY_ITEMS, "LY8/t;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/util/List;)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/util/List;", "", "necessary", "", "testing", Const.INTENT_KEY_PKGNAME, "(IZ)Ljava/lang/String;", "e", "c", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "previews", "Ljava/util/HashMap;", "lastLoaded", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class N {
    public static final N INSTANCE = new N();
    private static final HashMap<String, List<SkillItemBrief>> previews = new HashMap<>();
    private static final HashMap<String, List<SkillItemBrief>> lastLoaded = new HashMap<>();

    public final List<SkillItemBrief> a(String key) {
        if (key != null) {
            return previews.remove(key);
        }
        return null;
    }

    public final String b(int necessary, boolean testing) {
        if (testing) {
            return "testing";
        }
        return "necessary_" + necessary;
    }

    public final List<SkillItemBrief> c(String key) {
        kotlin.jvm.internal.p.i(key, "key");
        return lastLoaded.get(key);
    }

    public final void d(String key, List<SkillItemBrief> items) {
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(items, "items");
        previews.put(key, items);
    }

    public final void e(String key, List<SkillItemBrief> items) {
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(items, "items");
        if (items.isEmpty()) {
            return;
        }
        lastLoaded.put(key, items);
    }
}
