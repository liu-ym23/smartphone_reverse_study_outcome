package com.stepos.taskrobot.settingsprovider;

import C7.f;
import C7.r;
import D6.i;
import D7.q;
import D7.v;
import D7.w;
import F6.c;
import S0.b;
import S7.a;
import S7.k;
import S7.n;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.stepos.taskrobot.dictionary.model.RedirectGroup;
import com.stepos.taskrobot.dictionary.model.WhitelistApp;
import com.stepos.taskrobot.dictionary.model.WhitelistData;
import com.stepos.taskrobot.settingsprovider.store.KeyValueStore;
import com.stepos.taskrobot.settingsprovider.store.MmkvKeyValueStore;
import com.stepos.taskrobot.settingsprovider.store.SettingsStoreMigration;
import com.tencent.mmkv.MMKV;
import f6.AbstractC1436a;
import j9.AbstractC1607a;
import j9.m;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import m9.r0;
import u9.d;
import z2.l;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0013\u0018\u0000 p2\u00020\u0001:\u0003qrpBQ\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0011J\u0010\u0010\u0015\u001a\u00020\fH\u0080@¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u001fJ\u001d\u0010\"\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u001d\u0010\"\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010$J\u001d\u0010%\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b%\u0010$J\r\u0010&\u001a\u00020 ¢\u0006\u0004\b&\u0010'J\u0015\u0010(\u001a\u00020\f2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020 ¢\u0006\u0004\b*\u0010'J\u0015\u0010+\u001a\u00020\f2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b+\u0010)J\u0015\u0010.\u001a\u00020\f2\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u0015\u00100\u001a\u00020\f2\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b0\u0010/J\u0015\u00102\u001a\u00020\f2\u0006\u0010-\u001a\u000201¢\u0006\u0004\b2\u00103J\u0015\u00104\u001a\u00020\f2\u0006\u0010-\u001a\u000201¢\u0006\u0004\b4\u00103J\r\u00105\u001a\u00020\f¢\u0006\u0004\b5\u0010\u0011J\r\u00106\u001a\u00020 ¢\u0006\u0004\b6\u0010'J\u0015\u00108\u001a\u00020\f2\u0006\u00107\u001a\u00020 ¢\u0006\u0004\b8\u0010)J\u0017\u00109\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\f2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b;\u0010)J7\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020 0=H\u0002¢\u0006\u0004\b?\u0010@J\u001d\u0010B\u001a\u00020\f2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002¢\u0006\u0004\bB\u0010CJ\u001d\u0010F\u001a\u00020\f2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020D0\u0016H\u0002¢\u0006\u0004\bF\u0010CJ\u000f\u0010G\u001a\u00020\fH\u0002¢\u0006\u0004\bG\u0010\u0011J\u001b\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020 0=H\u0002¢\u0006\u0004\bH\u0010IJ\u001f\u0010J\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\fH\u0002¢\u0006\u0004\bL\u0010\u0011J\u000f\u0010M\u001a\u00020\fH\u0002¢\u0006\u0004\bM\u0010\u0011J\u0017\u0010N\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002¢\u0006\u0004\bN\u0010:J\u0017\u0010O\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002¢\u0006\u0004\bO\u0010PR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010QR*\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010RR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010SR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010RR\u0014\u0010U\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010Z\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010\\\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010[R\u0016\u0010]\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010[R\u0016\u0010^\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010[R\u0016\u0010_\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010[R\u001a\u0010a\u001a\b\u0012\u0004\u0012\u00020,0`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u001a\u0010c\u001a\b\u0012\u0004\u0012\u0002010`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010bR\u0014\u0010d\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u001c\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010bR\u001c\u0010g\u001a\b\u0012\u0004\u0012\u00020D0\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010bR\"\u0010h\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u001b\u0010n\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010mR \u0010o\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010i¨\u0006s"}, d2 = {"Lcom/stepos/taskrobot/settingsprovider/WhitelistCacheManager;", "", "Lcom/stepos/taskrobot/settingsprovider/store/KeyValueStore;", "store", "Lkotlin/Function1;", "LH7/c;", "Lcom/stepos/taskrobot/dictionary/WhitelistResult;", "fetchWhitelist", "Lkotlin/Function0;", "Lcom/stepos/taskrobot/dictionary/model/WhitelistData;", "loadDefaultWhitelist", "", "LC7/r;", "notifyUriChange", AppAgent.CONSTRUCT, "(Lcom/stepos/taskrobot/settingsprovider/store/KeyValueStore;LS7/k;LS7/a;LS7/k;)V", "loadFromCache", "()V", "syncFromServer", "syncFromServerInternal$settingsprovider_release", "(LH7/c;)Ljava/lang/Object;", "syncFromServerInternal", "", "Lcom/stepos/taskrobot/dictionary/model/WhitelistApp;", "getWhitelist", "()Ljava/util/List;", "", "index", "getWhitelistItem", "(I)Lcom/stepos/taskrobot/dictionary/model/WhitelistApp;", "appName", "(Ljava/lang/String;)Lcom/stepos/taskrobot/dictionary/model/WhitelistApp;", "", "enabled", "setAppEnabled", "(IZ)Z", "(Ljava/lang/String;Z)Z", "addOrUpdateWhitelistItem", "getMasterSwitch", "()Z", "setMasterSwitch", "(Z)V", "getAllowAllApps", "setAllowAllApps", "Lcom/stepos/taskrobot/settingsprovider/WhitelistCacheManager$OnMasterSwitchChangedListener;", "listener", "addMasterSwitchListener", "(Lcom/stepos/taskrobot/settingsprovider/WhitelistCacheManager$OnMasterSwitchChangedListener;)V", "removeMasterSwitchListener", "Lcom/stepos/taskrobot/settingsprovider/WhitelistCacheManager$OnSafetySettingsDismissedListener;", "addSafetySettingsDismissedListener", "(Lcom/stepos/taskrobot/settingsprovider/WhitelistCacheManager$OnSafetySettingsDismissedListener;)V", "removeSafetySettingsDismissedListener", "notifyHostActivityDismissed", "getAuthorizationStatus", "authorized", "setAuthorizationStatus", "getRedirectTarget", "(Ljava/lang/String;)Ljava/lang/String;", "notifyMasterSwitchChanged", "serverApps", "", "overrides", "mergeWhitelist", "(Ljava/util/List;Ljava/util/Map;)Ljava/util/List;", "apps", "persistWhitelist", "(Ljava/util/List;)V", "Lcom/stepos/taskrobot/dictionary/model/RedirectGroup;", "groups", "persistRedirectGroups", "rebuildRedirectIndex", "loadOverrides", "()Ljava/util/Map;", "saveOverride", "(Ljava/lang/String;Z)V", "notifyMasterSwitchUriChanged", "notifyWhitelistChanged", "resolveCanonicalAppName", "indexOfApp", "(Ljava/lang/String;)I", "Lcom/stepos/taskrobot/settingsprovider/store/KeyValueStore;", "LS7/k;", "LS7/a;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "Lm9/z;", "syncScope", "Lm9/z;", "setMasterSwitchCallCount", "I", "notifyMasterSwitchChangedCallCount", "notifyMasterSwitchUriChangedCallCount", "addOrUpdateWhitelistItemCallCount", "notifyWhitelistChangedCallCount", "", "masterSwitchListeners", "Ljava/util/List;", "safetySettingsDismissedListeners", "listenersLock", "Ljava/lang/Object;", "cachedWhitelist", "cachedRedirectGroups", "redirectIndex", "Ljava/util/Map;", "defaultWhitelist$delegate", "LC7/f;", "getDefaultWhitelist", "()Lcom/stepos/taskrobot/dictionary/model/WhitelistData;", "defaultWhitelist", "appNameAliases", "Companion", "OnMasterSwitchChangedListener", "OnSafetySettingsDismissedListener", "settingsprovider_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WhitelistCacheManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DEFAULT_WHITELIST_FILE = "default_whitelist.json";
    private static volatile WhitelistCacheManager INSTANCE = null;
    private static final String STORE_ID = "taskrobot_settings";
    private static final String TAG = "WhitelistCacheManager";
    private int addOrUpdateWhitelistItemCallCount;
    private final Map<String, String> appNameAliases;
    private volatile List<RedirectGroup> cachedRedirectGroups;
    private volatile List<WhitelistApp> cachedWhitelist;

    /* renamed from: defaultWhitelist$delegate, reason: from kotlin metadata */
    private final f defaultWhitelist;
    private final k fetchWhitelist;
    private final Gson gson;
    private final Object listenersLock;
    private final a loadDefaultWhitelist;
    private final List<OnMasterSwitchChangedListener> masterSwitchListeners;
    private int notifyMasterSwitchChangedCallCount;
    private int notifyMasterSwitchUriChangedCallCount;
    private final k notifyUriChange;
    private int notifyWhitelistChangedCallCount;
    private volatile Map<String, String> redirectIndex;
    private final List<OnSafetySettingsDismissedListener> safetySettingsDismissedListeners;
    private int setMasterSwitchCallCount;
    private final KeyValueStore store;
    private final InterfaceC1733z syncScope;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stepos/taskrobot/settingsprovider/WhitelistCacheManager$Companion;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "DEFAULT_WHITELIST_FILE", "STORE_ID", "INSTANCE", "Lcom/stepos/taskrobot/settingsprovider/WhitelistCacheManager;", "getInstance", "context", "Landroid/content/Context;", "create", "appContext", "readDefaultWhitelist", "Lcom/stepos/taskrobot/dictionary/model/WhitelistData;", "settingsprovider_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private final WhitelistCacheManager create(Context appContext) throws RuntimeException {
            MMKV mmkvMmkvWithID = MMKV.mmkvWithID(WhitelistCacheManager.STORE_ID, 2);
            kotlin.jvm.internal.k.e(mmkvMmkvWithID, "mmkvWithID(...)");
            MmkvKeyValueStore mmkvKeyValueStore = new MmkvKeyValueStore(mmkvMmkvWithID);
            SettingsStoreMigration settingsStoreMigration = SettingsStoreMigration.INSTANCE;
            MMKV mmkvDefaultMMKV = MMKV.defaultMMKV();
            kotlin.jvm.internal.k.e(mmkvDefaultMMKV, "defaultMMKV(...)");
            settingsStoreMigration.migrateIfNeeded(new MmkvKeyValueStore(mmkvDefaultMMKV), mmkvKeyValueStore);
            return new WhitelistCacheManager(mmkvKeyValueStore, new WhitelistCacheManager$Companion$create$1(null), new c(appContext, 3), new com.stepos.agentframework.adapter.a(appContext, 1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final WhitelistData create$lambda$0(Context context) {
            return WhitelistCacheManager.INSTANCE.readDefaultWhitelist(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r create$lambda$1(Context context, String path) {
            kotlin.jvm.internal.k.f(path, "path");
            context.getContentResolver().notifyChange(Uri.parse("content://com.stepos.taskrobot.settingsprovider/".concat(path)), null);
            return r.f317a;
        }

        private final WhitelistData readDefaultWhitelist(Context context) throws IOException {
            try {
                InputStream inputStreamOpen = context.getAssets().open(WhitelistCacheManager.DEFAULT_WHITELIST_FILE);
                kotlin.jvm.internal.k.e(inputStreamOpen, "open(...)");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, AbstractC1607a.f4778a), 8192);
                try {
                    String strO1 = b.o1(bufferedReader);
                    bufferedReader.close();
                    WhitelistData whitelistData = (WhitelistData) new Gson().fromJson(strO1, WhitelistData.class);
                    if (whitelistData == null) {
                        whitelistData = new WhitelistData(null, null, 3, null);
                    }
                    Log.d(WhitelistCacheManager.TAG, "readDefaultWhitelist: loaded " + whitelistData.getApps().size() + " apps, " + whitelistData.getRedirectGroups().size() + " redirectGroups from assets");
                    return whitelistData;
                } finally {
                }
            } catch (Exception e) {
                Log.w(WhitelistCacheManager.TAG, "readDefaultWhitelist: failed to read default_whitelist.json", e);
                return new WhitelistData(null, null, 3, null);
            }
        }

        public final WhitelistCacheManager getInstance(Context context) {
            WhitelistCacheManager whitelistCacheManagerCreate;
            kotlin.jvm.internal.k.f(context, "context");
            WhitelistCacheManager whitelistCacheManager = WhitelistCacheManager.INSTANCE;
            if (whitelistCacheManager != null) {
                return whitelistCacheManager;
            }
            synchronized (this) {
                whitelistCacheManagerCreate = WhitelistCacheManager.INSTANCE;
                if (whitelistCacheManagerCreate == null) {
                    Companion companion = WhitelistCacheManager.INSTANCE;
                    Context applicationContext = context.getApplicationContext();
                    kotlin.jvm.internal.k.e(applicationContext, "getApplicationContext(...)");
                    whitelistCacheManagerCreate = companion.create(applicationContext);
                    WhitelistCacheManager.INSTANCE = whitelistCacheManagerCreate;
                }
            }
            return whitelistCacheManagerCreate;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/stepos/taskrobot/settingsprovider/WhitelistCacheManager$OnMasterSwitchChangedListener;", "", "", "enabled", "LC7/r;", "onMasterSwitchChanged", "(Z)V", "settingsprovider_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface OnMasterSwitchChangedListener {
        void onMasterSwitchChanged(boolean enabled);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/stepos/taskrobot/settingsprovider/WhitelistCacheManager$OnSafetySettingsDismissedListener;", "", "LC7/r;", "onSafetySettingsDismissed", "()V", "settingsprovider_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface OnSafetySettingsDismissedListener {
        void onSafetySettingsDismissed();
    }

    @J7.c(c = "com.stepos.taskrobot.settingsprovider.WhitelistCacheManager$syncFromServer$1", f = "WhitelistCacheManager.kt", l = {180}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.settingsprovider.WhitelistCacheManager$syncFromServer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        int label;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return WhitelistCacheManager.this.new AnonymousClass1(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                WhitelistCacheManager whitelistCacheManager = WhitelistCacheManager.this;
                this.label = 1;
                if (whitelistCacheManager.syncFromServerInternal$settingsprovider_release(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public WhitelistCacheManager(KeyValueStore store, k fetchWhitelist, a loadDefaultWhitelist, k notifyUriChange) {
        kotlin.jvm.internal.k.f(store, "store");
        kotlin.jvm.internal.k.f(fetchWhitelist, "fetchWhitelist");
        kotlin.jvm.internal.k.f(loadDefaultWhitelist, "loadDefaultWhitelist");
        kotlin.jvm.internal.k.f(notifyUriChange, "notifyUriChange");
        this.store = store;
        this.fetchWhitelist = fetchWhitelist;
        this.loadDefaultWhitelist = loadDefaultWhitelist;
        this.notifyUriChange = notifyUriChange;
        this.gson = new Gson();
        r0 r0VarC = AbstractC1683A.c();
        d dVar = AbstractC1691I.f5315a;
        this.syncScope = AbstractC1683A.b(l.H(r0VarC, u9.c.f6743a));
        this.masterSwitchListeners = new ArrayList();
        this.safetySettingsDismissedListeners = new ArrayList();
        this.listenersLock = new Object();
        EmptyList emptyList = EmptyList.f4893a;
        this.cachedWhitelist = emptyList;
        this.cachedRedirectGroups = emptyList;
        this.redirectIndex = kotlin.collections.a.M();
        this.defaultWhitelist = kotlin.a.a(new i(this, 24));
        this.appNameAliases = B7.a.x("阶跃ai", "阶跃AI");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WhitelistData defaultWhitelist_delegate$lambda$0(WhitelistCacheManager whitelistCacheManager) {
        return (WhitelistData) whitelistCacheManager.loadDefaultWhitelist.invoke();
    }

    private final WhitelistData getDefaultWhitelist() {
        return (WhitelistData) this.defaultWhitelist.getF4884a();
    }

    private final int indexOfApp(String appName) {
        String strResolveCanonicalAppName = resolveCanonicalAppName(appName);
        Iterator<WhitelistApp> it = this.cachedWhitelist.iterator();
        int i = 0;
        int i6 = 0;
        while (true) {
            if (!it.hasNext()) {
                i6 = -1;
                break;
            }
            if (kotlin.jvm.internal.k.b(it.next().getAppName(), strResolveCanonicalAppName)) {
                break;
            }
            i6++;
        }
        if (i6 >= 0) {
            return i6;
        }
        Iterator<WhitelistApp> it2 = this.cachedWhitelist.iterator();
        while (it2.hasNext()) {
            if (kotlin.jvm.internal.k.b(it2.next().getAppName(), appName)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private final Map<String, Boolean> loadOverrides() {
        String string = this.store.getString(SettingsConfig.MMKV_KEY_WHITELIST_OVERRIDES);
        if (string == null || m.s0(string)) {
            return kotlin.collections.a.M();
        }
        try {
            Object objFromJson = this.gson.fromJson(string, new TypeToken<Map<String, ? extends Boolean>>() { // from class: com.stepos.taskrobot.settingsprovider.WhitelistCacheManager$loadOverrides$type$1
            }.getType());
            kotlin.jvm.internal.k.c(objFromJson);
            return (Map) objFromJson;
        } catch (Exception e) {
            Log.w(TAG, "loadOverrides: parse failed", e);
            return kotlin.collections.a.M();
        }
    }

    private final List<WhitelistApp> mergeWhitelist(List<WhitelistApp> serverApps, Map<String, Boolean> overrides) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.collections.a.P(overrides.size()));
        Iterator<T> it = overrides.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(resolveCanonicalAppName((String) entry.getKey()), entry.getValue());
        }
        List<WhitelistApp> list = serverApps;
        ArrayList arrayList = new ArrayList(w.c0(list, 10));
        for (WhitelistApp whitelistAppCopy$default : list) {
            Boolean bool = (Boolean) linkedHashMap.get(resolveCanonicalAppName(whitelistAppCopy$default.getAppName()));
            if (bool != null) {
                whitelistAppCopy$default = WhitelistApp.copy$default(whitelistAppCopy$default, null, null, bool.booleanValue(), null, 11, null);
            }
            arrayList.add(whitelistAppCopy$default);
        }
        ArrayList arrayList2 = new ArrayList(w.c0(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(resolveCanonicalAppName(((WhitelistApp) it2.next()).getAppName()));
        }
        Set setJ1 = v.j1(arrayList2);
        List<WhitelistApp> list2 = this.cachedWhitelist;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : list2) {
            String strResolveCanonicalAppName = resolveCanonicalAppName(((WhitelistApp) obj).getAppName());
            if (!setJ1.contains(strResolveCanonicalAppName) && linkedHashMap.containsKey(strResolveCanonicalAppName)) {
                arrayList3.add(obj);
            }
        }
        return v.Q0(arrayList3, arrayList);
    }

    private final void notifyMasterSwitchChanged(boolean enabled) {
        List listF1;
        int i = this.notifyMasterSwitchChangedCallCount + 1;
        this.notifyMasterSwitchChangedCallCount = i;
        AbstractC1436a.d(TAG, "[LOOP-DEBUG] notifyMasterSwitchChanged: enabled=" + enabled + ", callCount=" + i + ", listeners=" + this.masterSwitchListeners.size(), true);
        int i6 = this.notifyMasterSwitchChangedCallCount;
        if (i6 % 10 == 0) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            kotlin.jvm.internal.k.e(stackTrace, "getStackTrace(...)");
            AbstractC1436a.b(TAG, androidx.constraintlayout.core.dsl.a.c(i6, "[LOOP-DEBUG] notifyMasterSwitchChanged SUSPECTED LOOP! callCount=", ", stackTrace=\n", v.I0(q.E0(stackTrace), "\n", null, null, null, 62)), true);
        }
        synchronized (this.listenersLock) {
            listF1 = v.f1(this.masterSwitchListeners);
        }
        Iterator it = listF1.iterator();
        while (it.hasNext()) {
            try {
                ((OnMasterSwitchChangedListener) it.next()).onMasterSwitchChanged(enabled);
            } catch (Exception e) {
                Log.w(TAG, "notifyMasterSwitchChanged: listener threw", e);
            }
        }
    }

    private final void notifyMasterSwitchUriChanged() {
        int i = this.notifyMasterSwitchUriChangedCallCount + 1;
        this.notifyMasterSwitchUriChangedCallCount = i;
        AbstractC1436a.d(TAG, "[LOOP-DEBUG] notifyMasterSwitchUriChanged: callCount=" + i, true);
        int i6 = this.notifyMasterSwitchUriChangedCallCount;
        if (i6 % 10 == 0) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            kotlin.jvm.internal.k.e(stackTrace, "getStackTrace(...)");
            AbstractC1436a.b(TAG, androidx.constraintlayout.core.dsl.a.c(i6, "[LOOP-DEBUG] notifyMasterSwitchUriChanged SUSPECTED LOOP! callCount=", ", stackTrace=\n", v.I0(q.E0(stackTrace), "\n", null, null, null, 62)), true);
        }
        try {
            this.notifyUriChange.invoke(SettingsConfig.PATH_MASTER_SWITCH);
        } catch (Exception e) {
            Log.w(TAG, "notifyMasterSwitchUriChanged: failed", e);
        }
    }

    private final void notifyWhitelistChanged() {
        int i = this.notifyWhitelistChangedCallCount + 1;
        this.notifyWhitelistChangedCallCount = i;
        AbstractC1436a.d(TAG, "[LOOP-DEBUG] notifyWhitelistChanged: callCount=" + i, true);
        int i6 = this.notifyWhitelistChangedCallCount;
        if (i6 % 10 == 0) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            kotlin.jvm.internal.k.e(stackTrace, "getStackTrace(...)");
            AbstractC1436a.b(TAG, androidx.constraintlayout.core.dsl.a.c(i6, "[LOOP-DEBUG] notifyWhitelistChanged SUSPECTED LOOP! callCount=", ", stackTrace=\n", v.I0(q.E0(stackTrace), "\n", null, null, null, 62)), true);
        }
        try {
            this.notifyUriChange.invoke(SettingsConfig.PATH_WHITELIST);
        } catch (Exception e) {
            Log.w(TAG, "notifyWhitelistChanged: failed", e);
        }
    }

    private final void persistRedirectGroups(List<RedirectGroup> groups) {
        String json = this.gson.toJson(groups);
        KeyValueStore keyValueStore = this.store;
        kotlin.jvm.internal.k.c(json);
        keyValueStore.putString(SettingsConfig.MMKV_KEY_REDIRECT_GROUPS_CACHE, json);
    }

    private final void persistWhitelist(List<WhitelistApp> apps) {
        String json = this.gson.toJson(apps);
        KeyValueStore keyValueStore = this.store;
        kotlin.jvm.internal.k.c(json);
        keyValueStore.putString(SettingsConfig.MMKV_KEY_WHITELIST_CACHE, json);
    }

    private final synchronized void rebuildRedirectIndex() {
        try {
            List<WhitelistApp> list = this.cachedWhitelist;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((WhitelistApp) obj).getEnabled()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(w.c0(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String lowerCase = resolveCanonicalAppName(((WhitelistApp) it.next()).getAppName()).toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.k.e(lowerCase, "toLowerCase(...)");
                arrayList2.add(lowerCase);
            }
            Set setJ1 = v.j1(arrayList2);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (RedirectGroup redirectGroup : this.cachedRedirectGroups) {
                if (m.s0(redirectGroup.getTarget())) {
                    Log.w(TAG, "rebuildRedirectIndex: group with blank target, skip");
                } else {
                    String strResolveCanonicalAppName = resolveCanonicalAppName(redirectGroup.getTarget());
                    String lowerCase2 = strResolveCanonicalAppName.toLowerCase(Locale.ROOT);
                    kotlin.jvm.internal.k.e(lowerCase2, "toLowerCase(...)");
                    if (setJ1.contains(lowerCase2)) {
                        for (String str : redirectGroup.getApps()) {
                            if (!m.s0(str)) {
                                String lowerCase3 = resolveCanonicalAppName(str).toLowerCase(Locale.ROOT);
                                kotlin.jvm.internal.k.e(lowerCase3, "toLowerCase(...)");
                                if (!lowerCase3.equals(lowerCase2)) {
                                    linkedHashMap.putIfAbsent(lowerCase3, strResolveCanonicalAppName);
                                }
                            }
                        }
                    } else {
                        Log.w(TAG, "rebuildRedirectIndex: target '" + redirectGroup.getTarget() + "' not enabled in whitelist, skip group");
                    }
                }
            }
            this.redirectIndex = linkedHashMap;
            Log.d(TAG, "rebuildRedirectIndex: " + linkedHashMap.size() + " entries from " + this.cachedRedirectGroups.size() + " groups");
        } catch (Throwable th) {
            throw th;
        }
    }

    private final String resolveCanonicalAppName(String appName) {
        Map<String, String> map = this.appNameAliases;
        String lowerCase = appName.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.k.e(lowerCase, "toLowerCase(...)");
        String str = map.get(lowerCase);
        return str == null ? appName : str;
    }

    private final void saveOverride(String appName, boolean enabled) {
        LinkedHashMap linkedHashMapA0 = kotlin.collections.a.a0(loadOverrides());
        linkedHashMapA0.put(appName, Boolean.valueOf(enabled));
        String json = this.gson.toJson(linkedHashMapA0);
        KeyValueStore keyValueStore = this.store;
        kotlin.jvm.internal.k.c(json);
        keyValueStore.putString(SettingsConfig.MMKV_KEY_WHITELIST_OVERRIDES, json);
    }

    public final void addMasterSwitchListener(OnMasterSwitchChangedListener listener) {
        kotlin.jvm.internal.k.f(listener, "listener");
        synchronized (this.listenersLock) {
            this.masterSwitchListeners.add(listener);
        }
    }

    public final boolean addOrUpdateWhitelistItem(String appName, boolean enabled) {
        boolean z10;
        kotlin.jvm.internal.k.f(appName, "appName");
        int i = this.addOrUpdateWhitelistItemCallCount + 1;
        this.addOrUpdateWhitelistItemCallCount = i;
        String name = Thread.currentThread().getName();
        StringBuilder sbL = androidx.constraintlayout.core.dsl.a.l("[LOOP-DEBUG] addOrUpdateWhitelistItem: appName=", appName, ", enabled=", ", callCount=", enabled);
        sbL.append(i);
        sbL.append(", thread=");
        sbL.append(name);
        AbstractC1436a.d(TAG, sbL.toString(), true);
        int i6 = this.addOrUpdateWhitelistItemCallCount;
        if (i6 % 10 == 0) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            kotlin.jvm.internal.k.e(stackTrace, "getStackTrace(...)");
            AbstractC1436a.b(TAG, androidx.constraintlayout.core.dsl.a.c(i6, "[LOOP-DEBUG] addOrUpdateWhitelistItem SUSPECTED LOOP! callCount=", ", stackTrace=\n", v.I0(q.E0(stackTrace), "\n", null, null, null, 62)), true);
        }
        String strResolveCanonicalAppName = resolveCanonicalAppName(appName);
        int iIndexOfApp = indexOfApp(appName);
        ArrayList arrayListG1 = v.g1(this.cachedWhitelist);
        if (iIndexOfApp >= 0) {
            z10 = enabled;
            arrayListG1.set(iIndexOfApp, WhitelistApp.copy$default((WhitelistApp) arrayListG1.get(iIndexOfApp), null, null, enabled, null, 11, null));
        } else {
            z10 = enabled;
            arrayListG1.add(new WhitelistApp(strResolveCanonicalAppName, "", z10, null, 8, null));
        }
        this.cachedWhitelist = arrayListG1;
        persistWhitelist(arrayListG1);
        saveOverride(strResolveCanonicalAppName, z10);
        notifyWhitelistChanged();
        return true;
    }

    public final void addSafetySettingsDismissedListener(OnSafetySettingsDismissedListener listener) {
        kotlin.jvm.internal.k.f(listener, "listener");
        synchronized (this.listenersLock) {
            this.safetySettingsDismissedListeners.add(listener);
        }
    }

    public final boolean getAllowAllApps() {
        return this.store.getBoolean(SettingsConfig.MMKV_KEY_ALLOW_ALL_APPS, false);
    }

    public final boolean getAuthorizationStatus() {
        return this.store.getBoolean("authorization_status", false);
    }

    public final boolean getMasterSwitch() {
        return this.store.getBoolean(SettingsConfig.MMKV_KEY_MASTER_SWITCH, false);
    }

    public final String getRedirectTarget(String appName) {
        kotlin.jvm.internal.k.f(appName, "appName");
        if (m.s0(appName)) {
            return null;
        }
        String strResolveCanonicalAppName = resolveCanonicalAppName(appName);
        Map<String, String> map = this.redirectIndex;
        String lowerCase = strResolveCanonicalAppName.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.k.e(lowerCase, "toLowerCase(...)");
        return map.get(lowerCase);
    }

    public final List<WhitelistApp> getWhitelist() {
        return this.cachedWhitelist;
    }

    public final WhitelistApp getWhitelistItem(int index) {
        return (WhitelistApp) v.D0(index, this.cachedWhitelist);
    }

    public final void loadFromCache() {
        List<RedirectGroup> redirectGroups;
        String string = this.store.getString(SettingsConfig.MMKV_KEY_WHITELIST_CACHE);
        if (string == null || m.s0(string)) {
            this.cachedWhitelist = getDefaultWhitelist().getApps();
            Log.d(TAG, "loadFromCache: no cache, using default whitelist (" + getDefaultWhitelist().getApps().size() + " apps)");
        } else {
            try {
                Object objFromJson = this.gson.fromJson(string, new TypeToken<List<? extends WhitelistApp>>() { // from class: com.stepos.taskrobot.settingsprovider.WhitelistCacheManager$loadFromCache$type$1
                }.getType());
                kotlin.jvm.internal.k.e(objFromJson, "fromJson(...)");
                this.cachedWhitelist = (List) objFromJson;
                Log.d(TAG, "loadFromCache: loaded " + this.cachedWhitelist.size() + " apps");
            } catch (Exception e) {
                Log.w(TAG, "loadFromCache: parse failed", e);
                this.cachedWhitelist = getDefaultWhitelist().getApps();
            }
        }
        String string2 = this.store.getString(SettingsConfig.MMKV_KEY_REDIRECT_GROUPS_CACHE);
        if (string2 == null || m.s0(string2)) {
            redirectGroups = getDefaultWhitelist().getRedirectGroups();
        } else {
            try {
                redirectGroups = (List) this.gson.fromJson(string2, new TypeToken<List<? extends RedirectGroup>>() { // from class: com.stepos.taskrobot.settingsprovider.WhitelistCacheManager$loadFromCache$type$2
                }.getType());
                if (redirectGroups == null) {
                    redirectGroups = EmptyList.f4893a;
                }
            } catch (Exception e6) {
                Log.w(TAG, "loadFromCache: redirectGroups parse failed", e6);
                redirectGroups = getDefaultWhitelist().getRedirectGroups();
            }
        }
        this.cachedRedirectGroups = redirectGroups;
        rebuildRedirectIndex();
    }

    public final void notifyHostActivityDismissed() {
        List listF1;
        synchronized (this.listenersLock) {
            listF1 = v.f1(this.safetySettingsDismissedListeners);
        }
        AbstractC1436a.d(TAG, "[RELAUNCH] notifyHostActivityDismissed: listeners=" + listF1.size(), true);
        Iterator it = listF1.iterator();
        while (it.hasNext()) {
            try {
                ((OnSafetySettingsDismissedListener) it.next()).onSafetySettingsDismissed();
            } catch (Exception e) {
                Log.w(TAG, "notifyHostActivityDismissed: listener threw", e);
            }
        }
    }

    public final void removeMasterSwitchListener(OnMasterSwitchChangedListener listener) {
        kotlin.jvm.internal.k.f(listener, "listener");
        synchronized (this.listenersLock) {
            this.masterSwitchListeners.remove(listener);
        }
    }

    public final void removeSafetySettingsDismissedListener(OnSafetySettingsDismissedListener listener) {
        kotlin.jvm.internal.k.f(listener, "listener");
        synchronized (this.listenersLock) {
            this.safetySettingsDismissedListeners.remove(listener);
        }
    }

    public final void setAllowAllApps(boolean enabled) {
        AbstractC1436a.d(TAG, "setAllowAllApps: enabled=" + enabled, true);
        this.store.putBoolean(SettingsConfig.MMKV_KEY_ALLOW_ALL_APPS, enabled);
    }

    public final boolean setAppEnabled(int index, boolean enabled) {
        WhitelistApp whitelistApp = (WhitelistApp) v.D0(index, this.cachedWhitelist);
        if (whitelistApp == null) {
            return false;
        }
        WhitelistApp whitelistAppCopy$default = WhitelistApp.copy$default(whitelistApp, null, null, enabled, null, 11, null);
        ArrayList arrayListG1 = v.g1(this.cachedWhitelist);
        arrayListG1.set(index, whitelistAppCopy$default);
        this.cachedWhitelist = arrayListG1;
        persistWhitelist(arrayListG1);
        saveOverride(resolveCanonicalAppName(whitelistApp.getAppName()), enabled);
        notifyWhitelistChanged();
        return true;
    }

    public final void setAuthorizationStatus(boolean authorized) {
        this.store.putBoolean("authorization_status", authorized);
    }

    public final void setMasterSwitch(boolean enabled) {
        int i = this.setMasterSwitchCallCount + 1;
        this.setMasterSwitchCallCount = i;
        AbstractC1436a.e(TAG, "[LOOP-DEBUG] setMasterSwitch: enabled=" + enabled + ", callCount=" + i + ", thread=" + Thread.currentThread().getName(), true);
        int i6 = this.setMasterSwitchCallCount;
        if (i6 % 10 == 0) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            kotlin.jvm.internal.k.e(stackTrace, "getStackTrace(...)");
            AbstractC1436a.b(TAG, androidx.constraintlayout.core.dsl.a.c(i6, "[LOOP-DEBUG] setMasterSwitch SUSPECTED LOOP! callCount=", ", stackTrace=\n", v.I0(q.E0(stackTrace), "\n", null, null, null, 62)), true);
        }
        this.store.putBoolean(SettingsConfig.MMKV_KEY_MASTER_SWITCH, enabled);
        notifyMasterSwitchChanged(enabled);
        notifyMasterSwitchUriChanged();
    }

    public final void syncFromServer() {
        AbstractC1683A.n(this.syncScope, null, new AnonymousClass1(null), 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object syncFromServerInternal$settingsprovider_release(H7.c<? super C7.r> r9) {
        /*
            r8 = this;
            C7.r r0 = C7.r.f317a
            java.lang.String r1 = "syncFromServer: synced "
            java.lang.String r2 = "syncFromServer: server has no redirectGroups, keep local ("
            boolean r3 = r9 instanceof com.stepos.taskrobot.settingsprovider.WhitelistCacheManager$syncFromServerInternal$1
            if (r3 == 0) goto L19
            r3 = r9
            com.stepos.taskrobot.settingsprovider.WhitelistCacheManager$syncFromServerInternal$1 r3 = (com.stepos.taskrobot.settingsprovider.WhitelistCacheManager$syncFromServerInternal$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.label = r4
            goto L1e
        L19:
            com.stepos.taskrobot.settingsprovider.WhitelistCacheManager$syncFromServerInternal$1 r3 = new com.stepos.taskrobot.settingsprovider.WhitelistCacheManager$syncFromServerInternal$1
            r3.<init>(r8, r9)
        L1e:
            java.lang.Object r9 = r3.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r5 = r3.label
            r6 = 1
            java.lang.String r7 = "WhitelistCacheManager"
            if (r5 == 0) goto L3a
            if (r5 != r6) goto L32
            kotlin.b.b(r9)     // Catch: java.lang.Exception -> L2f
            goto L48
        L2f:
            r8 = move-exception
            goto Lce
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            kotlin.b.b(r9)
            S7.k r9 = r8.fetchWhitelist     // Catch: java.lang.Exception -> L2f
            r3.label = r6     // Catch: java.lang.Exception -> L2f
            java.lang.Object r9 = r9.invoke(r3)     // Catch: java.lang.Exception -> L2f
            if (r9 != r4) goto L48
            return r4
        L48:
            com.stepos.taskrobot.dictionary.WhitelistResult r9 = (com.stepos.taskrobot.dictionary.WhitelistResult) r9     // Catch: java.lang.Exception -> L2f
            com.stepos.taskrobot.dictionary.model.DictionaryItem r3 = r9.getRawItem()     // Catch: java.lang.Exception -> L2f
            if (r3 != 0) goto L56
            java.lang.String r8 = "syncFromServer: fetch failed, keep local whitelist"
            android.util.Log.w(r7, r8)     // Catch: java.lang.Exception -> L2f
            return r0
        L56:
            java.util.List r3 = r9.getApps()     // Catch: java.lang.Exception -> L2f
            boolean r4 = r3.isEmpty()     // Catch: java.lang.Exception -> L2f
            if (r4 == 0) goto L66
            java.lang.String r8 = "syncFromServer: server returned empty whitelist, keep local"
            android.util.Log.w(r7, r8)     // Catch: java.lang.Exception -> L2f
            return r0
        L66:
            java.util.Map r4 = r8.loadOverrides()     // Catch: java.lang.Exception -> L2f
            java.util.List r3 = r8.mergeWhitelist(r3, r4)     // Catch: java.lang.Exception -> L2f
            r8.cachedWhitelist = r3     // Catch: java.lang.Exception -> L2f
            r8.persistWhitelist(r3)     // Catch: java.lang.Exception -> L2f
            java.util.List r9 = r9.getRedirectGroups()     // Catch: java.lang.Exception -> L2f
            r4 = r9
            java.util.Collection r4 = (java.util.Collection) r4     // Catch: java.lang.Exception -> L2f
            boolean r4 = r4.isEmpty()     // Catch: java.lang.Exception -> L2f
            if (r4 != 0) goto L86
            r8.cachedRedirectGroups = r9     // Catch: java.lang.Exception -> L2f
            r8.persistRedirectGroups(r9)     // Catch: java.lang.Exception -> L2f
            goto La4
        L86:
            java.util.List<com.stepos.taskrobot.dictionary.model.RedirectGroup> r9 = r8.cachedRedirectGroups     // Catch: java.lang.Exception -> L2f
            int r9 = r9.size()     // Catch: java.lang.Exception -> L2f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2f
            r4.<init>(r2)     // Catch: java.lang.Exception -> L2f
            r4.append(r9)     // Catch: java.lang.Exception -> L2f
            java.lang.String r9 = ")"
            r4.append(r9)     // Catch: java.lang.Exception -> L2f
            java.lang.String r9 = r4.toString()     // Catch: java.lang.Exception -> L2f
            int r9 = android.util.Log.d(r7, r9)     // Catch: java.lang.Exception -> L2f
            J7.d.a(r9)     // Catch: java.lang.Exception -> L2f
        La4:
            r8.rebuildRedirectIndex()     // Catch: java.lang.Exception -> L2f
            int r9 = r3.size()     // Catch: java.lang.Exception -> L2f
            java.util.List<com.stepos.taskrobot.dictionary.model.RedirectGroup> r8 = r8.cachedRedirectGroups     // Catch: java.lang.Exception -> L2f
            int r8 = r8.size()     // Catch: java.lang.Exception -> L2f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2f
            r2.<init>(r1)     // Catch: java.lang.Exception -> L2f
            r2.append(r9)     // Catch: java.lang.Exception -> L2f
            java.lang.String r9 = " apps, "
            r2.append(r9)     // Catch: java.lang.Exception -> L2f
            r2.append(r8)     // Catch: java.lang.Exception -> L2f
            java.lang.String r8 = " redirectGroups"
            r2.append(r8)     // Catch: java.lang.Exception -> L2f
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Exception -> L2f
            android.util.Log.d(r7, r8)     // Catch: java.lang.Exception -> L2f
            return r0
        Lce:
            java.lang.String r9 = "syncFromServer: failed"
            android.util.Log.e(r7, r9, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.settingsprovider.WhitelistCacheManager.syncFromServerInternal$settingsprovider_release(H7.c):java.lang.Object");
    }

    public final WhitelistApp getWhitelistItem(String appName) {
        Object obj;
        Object next;
        kotlin.jvm.internal.k.f(appName, "appName");
        Iterator<T> it = this.cachedWhitelist.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (kotlin.jvm.internal.k.b(((WhitelistApp) next).getAppName(), appName)) {
                break;
            }
        }
        WhitelistApp whitelistApp = (WhitelistApp) next;
        if (whitelistApp != null) {
            return whitelistApp;
        }
        Map<String, String> map = this.appNameAliases;
        String lowerCase = appName.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.k.e(lowerCase, "toLowerCase(...)");
        String str = map.get(lowerCase);
        if (str == null) {
            return null;
        }
        Iterator<T> it2 = this.cachedWhitelist.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (kotlin.jvm.internal.k.b(((WhitelistApp) next2).getAppName(), str)) {
                obj = next2;
                break;
            }
        }
        return (WhitelistApp) obj;
    }

    public final boolean setAppEnabled(String appName, boolean enabled) {
        kotlin.jvm.internal.k.f(appName, "appName");
        String strResolveCanonicalAppName = resolveCanonicalAppName(appName);
        int iIndexOfApp = indexOfApp(appName);
        if (iIndexOfApp < 0) {
            AbstractC1436a.b(TAG, androidx.appfunctions.metadata.a.m("setAppEnabled: appName=", appName, " (canonical=", strResolveCanonicalAppName, ") not in whitelist, write dropped"), true);
            return false;
        }
        WhitelistApp whitelistAppCopy$default = WhitelistApp.copy$default(this.cachedWhitelist.get(iIndexOfApp), null, null, enabled, null, 11, null);
        ArrayList arrayListG1 = v.g1(this.cachedWhitelist);
        arrayListG1.set(iIndexOfApp, whitelistAppCopy$default);
        this.cachedWhitelist = arrayListG1;
        persistWhitelist(arrayListG1);
        saveOverride(strResolveCanonicalAppName, enabled);
        notifyWhitelistChanged();
        return true;
    }
}
