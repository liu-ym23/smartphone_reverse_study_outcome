package com.stepos.statsapp.v3.lib.plugin.emitter;

import Z5.b;
import android.content.Context;
import android.content.SharedPreferences;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.statsapp.v3.lib.plugin.emitter.remote.V3OfflineEmitter;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.statsapp.v3.utils.SharedPreferencesHelper;
import com.stepos.statsapp.v3.utils.log.Logger;

/* loaded from: classes2.dex */
public abstract class Emitter {
    private static final String TAG = "Emitter";
    protected EmitterConfig emitterConfig;
    protected Context mContext;
    private final SharedPreferencesHelper sharedPreferencesHelper;

    public Emitter(Context context, String str, String str2) {
        this.mContext = context;
        this.sharedPreferencesHelper = new SharedPreferencesHelper(context, UxipConstants.f30652P);
        this.emitterConfig = new EmitterConfig(str, str2);
        readConfigFromPreference();
    }

    public static Emitter createEmitter(Context context, String str, String str2) {
        V3OfflineEmitter v3OfflineEmitter = new V3OfflineEmitter(context, str, str2);
        Logger.i(TAG, "buildEmitter emitter is V3OfflineEmitter");
        return v3OfflineEmitter;
    }

    private void readConfigFromPreference() {
        this.emitterConfig.active = this.sharedPreferencesHelper.getConfig("active", true);
        this.emitterConfig.flushOnStart = this.sharedPreferencesHelper.getConfig("flushOnStart", true);
        this.emitterConfig.flushOnReconnect = this.sharedPreferencesHelper.getConfig("flushOnReconnect", true);
        this.emitterConfig.flushOnCharge = this.sharedPreferencesHelper.getConfig("flushOnCharge", true);
        this.emitterConfig.flushDelayInterval = this.sharedPreferencesHelper.getConfig("flushDelayInterval", b.IDLE_AGENT_PERIOD);
        this.emitterConfig.flushCacheLimit = this.sharedPreferencesHelper.getConfig("flushCacheLimit", 50);
        this.emitterConfig.flushMobileTrafficLimit = this.sharedPreferencesHelper.getConfig("flushMobileTrafficLimit", 2097152L);
        this.emitterConfig.neartimeInterval = this.sharedPreferencesHelper.getConfig(UxipConstants.f30646J, 5);
    }

    public abstract void add(TrackerPayload trackerPayload);

    public abstract void addNeartime(TrackerPayload trackerPayload);

    public abstract void addRealtime(TrackerPayload trackerPayload);

    public abstract void flush();

    public abstract String getUMID();

    public abstract void init();

    public abstract void setEncrypt(boolean z10);

    public void updateConfig(boolean z10, boolean z11, boolean z12, boolean z13, long j10, int i10, long j11, int i11) {
        SharedPreferences.Editor editorEdit = this.sharedPreferencesHelper.edit();
        editorEdit.putBoolean("active", z10);
        editorEdit.putBoolean("flushOnStart", z11);
        editorEdit.putBoolean("flushOnReconnect", z12);
        editorEdit.putBoolean("flushOnCharge", z13);
        editorEdit.putLong("flushDelayInterval", j10);
        editorEdit.putLong("flushMobileTrafficLimit", j11);
        editorEdit.putInt("flushCacheLimit", i10);
        editorEdit.putInt(UxipConstants.f30646J, i11);
        editorEdit.apply();
        readConfigFromPreference();
    }

    public abstract void updateEventSource(String str, String str2);
}
