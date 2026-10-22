package c4c;

import com.bytedance.lark.pb.basic.v1.OpenApp;
import com.bytedance.lark.pb.search.v2.AppMeta;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.OpenAppState;
import com.ss.android.lark.search.dto.info.SearchOpenAppInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: c4c.a$a, reason: collision with other inner class name */
    public static final class C0404a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22438a = null;

        static {
            int[] r100 = new int[OpenApp.Ability.values().length];
            r100[OpenApp.Ability.MICRO_APP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[OpenApp.Ability.H5.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[OpenApp.Ability.BOT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[OpenApp.Ability.LOCAL_COMPONENT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f22438a = r100;
        }
    }

    static {
    }

    public a() {
    }

    public static SearchOpenAppInfo a(AppMeta r100) {
        if (r100 == null) goto L33;
        SearchOpenAppInfo r101 = new SearchOpenAppInfo();
        Iterator<OpenApp.Ability> r102 = r100.app_abilities.iterator();
    L5:
        if (r102.hasNext() == false) goto L22;
        OpenApp.Ability r103 = r102.next();
        if (r103 != null) goto L9;
        int r104 = -1;
    L11:
        if (r104 != 1) goto L13;
        r101.getAbilities().add(new SearchOpenAppInfo.SearchOpenAppAbility(3, r100.app_url));
        goto L5
    L13:
        if (r104 != 2) goto L14;
        r101.getAbilities().add(new SearchOpenAppInfo.SearchOpenAppAbility(2, r100.app_url));
        goto L5
    L14:
        if (r104 != 3) goto L16;
        r101.getAbilities().add(new SearchOpenAppInfo.SearchOpenAppAbility(1, r100.bot_id));
        goto L5
    L16:
        if (r104 != 4) goto L17;
        r101.getAbilities().add(new SearchOpenAppInfo.SearchOpenAppAbility(4, r100.app_url));
        goto L5
    L17:
        Log.e("LarkSearch.Common.AppMetaParser", "wtf!!!");
        goto L5
    L9:
        r104 = b.f22438a[r103.ordinal()];
        goto L11
    L22:
        r101.setAppState(OpenAppState.forNumber(r100.state.getValue()));
        r101.setAppStoreUrl(r100.app_store_url);
        r101.available(r100.is_available.booleanValue());
        List<AppMeta.AppShortcutEntity> r105 = r100.app_shortcut_entities;
        if (r105 == null) goto L51;
        AppMeta.AppShortcutEntity r106 = (AppMeta.AppShortcutEntity) CollectionsKt.getOrNull(r105, 0);
        if (r106 == null) goto L52;
        List<AppMeta.AppShortcut> r107 = r106.android_items;
        if (r107 == null) goto L53;
        ArrayList r108 = new ArrayList();
        Iterator<T> r109 = r107.iterator();
    L30:
        if (r109.hasNext() == false) goto L32;
        AppMeta.AppShortcut r110 = (AppMeta.AppShortcut) r109.next();
        r108.add(new SearchOpenAppInfo.AppShortCut(r110.name, r110.app_link));
        goto L30
    L32:
        r101.setAppShortCuts(new ArrayList(r108));
        return r101;
    L53:
        return r101;
    L52:
        return r101;
    L51:
        return r101;
    L33:
        return null;
    }
}
