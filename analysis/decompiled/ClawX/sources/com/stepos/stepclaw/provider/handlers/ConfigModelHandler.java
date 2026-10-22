package com.stepos.stepclaw.provider.handlers;

import a6.i0;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import com.stepos.stepclaw.provider.backend.ConfigData;
import com.stepos.stepclaw.provider.backend.IConfigStore;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import f5.i;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stepos/stepclaw/provider/handlers/ConfigModelHandler;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "configStore", "Lcom/stepos/stepclaw/provider/backend/IConfigStore;", "<init>", "(Lcom/stepos/stepclaw/provider/backend/IConfigStore;)V", "query", "Landroid/database/Cursor;", ExtensionCallContract.OP_UPDATE, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "values", "Landroid/content/ContentValues;", "resolveApiFormat", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_PROVIDER, "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ConfigModelHandler {
    private final IConfigStore configStore;

    public ConfigModelHandler(IConfigStore configStore) {
        p.e(configStore, "configStore");
        this.configStore = configStore;
    }

    private final String resolveApiFormat(String provider) {
        return p.a(provider, "anthropic") ? "anthropic-messages" : p.a(provider, "google") ? "google-generative-ai" : "openai-completions";
    }

    public final Cursor query() {
        ConfigData configData = (ConfigData) i0.u(i.f2626a, new ConfigModelHandler$query$config$1(this, null));
        String api = configData.getApi();
        if (api == null) {
            api = resolveApiFormat(configData.getProvider());
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{ConfigIpcContract.KEY_PROVIDER, ConfigIpcContract.KEY_MODEL, ConfigIpcContract.KEY_BASE_URL, ConfigIpcContract.KEY_API_FORMAT, ConfigIpcContract.KEY_API_KEY});
        matrixCursor.addRow(new String[]{configData.getProvider(), configData.getModel(), configData.getBaseUrl(), api, configData.getApiKey()});
        return matrixCursor;
    }

    public final int update(ContentValues values) {
        p.e(values, "values");
        this.configStore.syncToRootfs((ConfigData) i0.u(i.f2626a, new ConfigModelHandler$update$updated$1(this, values, null)));
        return 1;
    }
}
