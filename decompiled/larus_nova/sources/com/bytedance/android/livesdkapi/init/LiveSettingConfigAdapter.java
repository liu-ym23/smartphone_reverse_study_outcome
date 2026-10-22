package com.bytedance.android.livesdkapi.init;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/init/LiveSettingConfigAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/bytedance/android/livesdkapi/init/LiveInitializeSettingConfig;", "()V", "read", "src", "Lcom/google/gson/stream/JsonReader;", "write", "", "dst", "Lcom/google/gson/stream/JsonWriter;", "config", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSettingConfigAdapter extends TypeAdapter<LiveInitializeSettingConfig> {
    public static final LiveSettingConfigAdapter INSTANCE = null;

    static {
        INSTANCE = new LiveSettingConfigAdapter();
    }

    private LiveSettingConfigAdapter() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public LiveInitializeSettingConfig read(JsonReader r100) {
        Intrinsics.checkNotNullParameter(r100, "src");
        LiveInitializeSettingConfig r101 = new LiveInitializeSettingConfig();
        r100.beginObject();
    L4:
        if (r100.hasNext() == false) goto L42;
        String r102 = r100.nextName();
        if (r102 == null) goto L41;
        switch(r102.hashCode()) {
            case -2103989600: goto L39;
            case -1305375429: goto L36;
            case -853563657: goto L33;
            case -673537112: goto L30;
            case -491431540: goto L27;
            case 582024268: goto L24;
            case 632794624: goto L21;
            case 1059140829: goto L18;
            case 1149494829: goto L15;
            case 1356556288: goto L12;
            default: goto L41;
        };
    L15:
        if (r102.equals("feature_init_opt") == false) goto L41;
        r101.setFeatureInitOpt(r100.nextBoolean());
        goto L4
    L18:
        if (r102.equals("strategy_optimizer_opt") == false) goto L41;
        r101.setStrategyOptimizerOpt(r100.nextBoolean());
        goto L4
    L21:
        if (r102.equals("sdk_launch_task_opt") == false) goto L41;
        r101.setSdkLaunchTaskOpt(r100.nextBoolean());
        goto L4
    L24:
        if (r102.equals("res_util_get_opt") == false) goto L41;
        r101.setResUtilGetOpt(r100.nextBoolean());
        goto L4
    L27:
        if (r102.equals("handle_schema_opt") == false) goto L41;
        r101.setHandleSchemaOpt(r100.nextBoolean());
        goto L4
    L30:
        if (r102.equals("pre_init_live_opt_v2") == false) goto L41;
        r101.setPreInitLiveOptV2(r100.nextBoolean());
        goto L4
    L33:
        if (r102.equals("schedule_thread_pool_size") == false) goto L41;
        r101.setThreadPoolSize(r100.nextInt());
        goto L4
    L36:
        if (r102.equals("ai_init_opt") == false) goto L41;
        r101.setAiInitOpt(r100.nextBoolean());
        goto L4
    L39:
        if (r102.equals("schedule_io_thread_pool_size") == false) goto L41;
        r101.setIoThreadPoolSize(r100.nextInt());
        goto L4
    L12:
        if (r102.equals("live_register_service_opt") == false) goto L41;
        r101.setLiveRegisterServiceOpt(r100.nextBoolean());
    L41:
        r100.skipValue();
        goto L4
    L42:
        r100.endObject();
        return r101;
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ LiveInitializeSettingConfig read(JsonReader r100) {
        return read(r100);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter r100, LiveInitializeSettingConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "dst");
        Intrinsics.checkNotNullParameter(r101, "config");
        throw new UnsupportedOperationException("not implemented");
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r100, LiveInitializeSettingConfig r101) {
        write2(r100, r101);
    }
}
