package com.stepos.taskrobot.settingsprovider.init;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.api.init.IInit;
import com.stepos.taskrobot.dictionary.DictionaryManager;
import com.stepos.taskrobot.settingsprovider.WhitelistCacheManager;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Singleton
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/stepos/taskrobot/settingsprovider/init/SettingsProviderInit;", "Lcom/stepos/ability/api/init/IInit;", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "LC7/r;", "init", "(Landroid/content/Context;)V", "Companion", "settingsprovider_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SettingsProviderInit implements IInit {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "SettingsProviderInit";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stepos/taskrobot/settingsprovider/init/SettingsProviderInit$Companion;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "isMainProcess", "", "processName", "packageName", "isMainProcess$settingsprovider_release", "settingsprovider_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final boolean isMainProcess$settingsprovider_release(String processName, String packageName) {
            return processName != null && processName.equals(packageName);
        }

        private Companion() {
        }
    }

    @Inject
    public SettingsProviderInit() {
    }

    @Override // com.stepos.ability.api.init.IInit
    public void init(Context context) {
        String processName;
        k.f(context, "context");
        try {
            processName = Application.getProcessName();
        } catch (Throwable unused) {
            processName = null;
        }
        if (!INSTANCE.isMainProcess$settingsprovider_release(processName, context.getPackageName())) {
            Log.d(TAG, "init: skip whitelist load/sync in non-main process (" + processName + ")");
            return;
        }
        DictionaryManager dictionaryManager = DictionaryManager.INSTANCE;
        if (!dictionaryManager.isInitialized()) {
            dictionaryManager.init(context, false);
            Log.d(TAG, "init: DictionaryManager initialized early (isDebug=false)");
        }
        WhitelistCacheManager companion = WhitelistCacheManager.INSTANCE.getInstance(context);
        companion.loadFromCache();
        companion.syncFromServer();
        Log.d(TAG, "init: cache loaded, server sync triggered");
    }
}
