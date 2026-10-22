package com.stepos.core.ota.download.control;

import android.content.Context;
import android.util.Log;
import com.stepos.core.ability.speech.PcmDumpBudget;
import d5.i;
import gc.a;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import jd.b;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ThermalConfigStore {
    public static final String ASSET = "thermal_download_config.json";
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ThermalConfigStore";
    private volatile ThermalRateConfig config;
    private final i gson;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ThermalConfigStore() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void loadFromAssets$default(ThermalConfigStore thermalConfigStore, Context context, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = ASSET;
        }
        thermalConfigStore.loadFromAssets(context, str);
    }

    private final ThermalRateConfig parse(String str) {
        ThermalRateConfig thermalRateConfig = (ThermalRateConfig) this.gson.b(ThermalRateConfig.class, str);
        if (thermalRateConfig != null) {
            return thermalRateConfig;
        }
        throw new IllegalArgumentException("empty thermal config");
    }

    public final ThermalRateConfig active() {
        return this.config;
    }

    public final void loadFromAssets(Context context, String assetName) {
        Object objA;
        Object objA2;
        g.f(context, "context");
        g.f(assetName, "assetName");
        try {
            InputStream inputStreamOpen = context.getAssets().open(assetName);
            g.e(inputStreamOpen, "open(...)");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, a.f9106b), PcmDumpBudget.HARD_MAX_DIR_MB);
            try {
                objA = b.F(bufferedReader);
                bufferedReader.close();
            } finally {
            }
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (!(objA instanceof Result.Failure)) {
            try {
                objA2 = parse((String) objA);
            } catch (Throwable th2) {
                objA2 = c.a(th2);
            }
            objA = objA2;
        }
        if (!(objA instanceof Result.Failure)) {
            ThermalRateConfig thermalRateConfig = (ThermalRateConfig) objA;
            this.config = thermalRateConfig;
            a0.a.y("thermal config loaded from asset: active=", thermalRateConfig.getActive(), TAG);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            Log.w(TAG, "thermal config asset load failed, use " + this.config.getActive(), thB);
        }
    }

    public final boolean selectScheme(String name) {
        g.f(name, "name");
        ThermalRateConfig thermalRateConfig = this.config;
        if (!thermalRateConfig.getSchemes().containsKey(name)) {
            return false;
        }
        this.config = ThermalRateConfig.copy$default(thermalRateConfig, name, null, 2, null);
        return true;
    }

    public final boolean setRateForTemp(float f8, int i10) {
        int iNextIndex;
        ThermalRateConfig thermalRateConfig = this.config;
        List<ThermalBand> list = thermalRateConfig.getSchemes().get(thermalRateConfig.getActive());
        if (list != null) {
            Iterator<ThermalBand> it = list.iterator();
            int i11 = 0;
            while (true) {
                iNextIndex = -1;
                if (!it.hasNext()) {
                    i11 = -1;
                    break;
                }
                ThermalBand next = it.next();
                if (next.getBelow() != null && f8 < next.getBelow().floatValue()) {
                    break;
                }
                i11++;
            }
            if (i11 < 0) {
                ListIterator<ThermalBand> listIterator = list.listIterator(list.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        break;
                    }
                    if (listIterator.previous().getBelow() == null) {
                        iNextIndex = listIterator.nextIndex();
                        break;
                    }
                }
                i11 = iNextIndex;
            }
            if (i11 >= 0) {
                ThermalBand thermalBandCopy$default = ThermalBand.copy$default(list.get(i11), null, i10 > 0 ? "throttle" : "stop", i10 < 0 ? 0 : i10, 1, null);
                ArrayList arrayListP0 = kotlin.collections.a.P0(list);
                arrayListP0.set(i11, thermalBandCopy$default);
                LinkedHashMap linkedHashMapO0 = kotlin.collections.b.o0(thermalRateConfig.getSchemes());
                linkedHashMapO0.put(thermalRateConfig.getActive(), arrayListP0);
                n nVar = n.f10413a;
                this.config = ThermalRateConfig.copy$default(thermalRateConfig, null, linkedHashMapO0, 1, null);
                Log.i(TAG, "setRateForTemp " + f8 + "℃ -> " + thermalBandCopy$default.getMode() + " " + thermalBandCopy$default.getRateMBps() + "MB/s @" + thermalRateConfig.getActive());
                return true;
            }
        }
        return false;
    }

    public final boolean update(String json) {
        Object objA;
        g.f(json, "json");
        try {
            objA = parse(json);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (!(objA instanceof Result.Failure)) {
            ThermalRateConfig thermalRateConfig = (ThermalRateConfig) objA;
            this.config = thermalRateConfig;
            a0.a.y("thermal config updated: active=", thermalRateConfig.getActive(), TAG);
            objA = Boolean.TRUE;
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            Log.w(TAG, "thermal config update failed (json invalid)", thB);
            objA = Boolean.FALSE;
        }
        return ((Boolean) objA).booleanValue();
    }

    public ThermalConfigStore(i gson) {
        g.f(gson, "gson");
        this.gson = gson;
        this.config = ThermalRateConfig.Companion.getDEFAULT();
    }

    public /* synthetic */ ThermalConfigStore(i iVar, int i10, e eVar) {
        this((i10 & 1) != 0 ? new i() : iVar);
    }
}
