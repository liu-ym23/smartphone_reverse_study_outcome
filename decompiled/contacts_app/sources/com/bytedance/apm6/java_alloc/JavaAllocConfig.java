package com.bytedance.apm6.java_alloc;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class JavaAllocConfig {
    public static final String KEY_CONF_COLLECT = "enable_alloc_collect";
    public static final String KEY_CONF_COLLECT_PER_THOUSAND_ALLOC = "alloc_collect_per_thousand_alloc";
    public static final String KEY_CONF_DUMP_PER_THOUSAND_COLLECT = "alloc_dump_per_thousand_collect";
    public static final String KEY_CONF_THRESHOLD_ALLOC_FREQ = "alloc_threshold_alloc_frequency";
    public static final String KEY_CONF_THRESHOLD_ALLOC_SIZE = "alloc_threshold_alloc_size";
    public static final String KEY_CONF_UPLOAD = "enable_alloc_upload";
    public int collect_per_thousand_alloc;
    public int dump_per_thousand_collect;
    public boolean enable_collect;
    public boolean enable_upload;
    public int threshold_alloc_frequency;
    public long threshold_alloc_size;

    public JavaAllocConfig(boolean r1, boolean r2, int r3, int r4, int r5, long r6) {
        this.enable_collect = r1;
        this.enable_upload = r2;
        this.collect_per_thousand_alloc = r3;
        this.dump_per_thousand_collect = r4;
        this.threshold_alloc_frequency = r5;
        this.threshold_alloc_size = r6;
    }

    public JSONObject packJson() {
        JSONObject r0 = new JSONObject();
        r0.put(KEY_CONF_COLLECT, this.enable_collect);     // Catch: JSONException -> L5
        r0.put(KEY_CONF_UPLOAD, this.enable_upload);     // Catch: JSONException -> L5
        r0.put(KEY_CONF_COLLECT_PER_THOUSAND_ALLOC, this.collect_per_thousand_alloc);     // Catch: JSONException -> L5
        r0.put(KEY_CONF_DUMP_PER_THOUSAND_COLLECT, this.dump_per_thousand_collect);     // Catch: JSONException -> L5
        r0.put(KEY_CONF_THRESHOLD_ALLOC_FREQ, this.threshold_alloc_frequency);     // Catch: JSONException -> L5
        r0.put(KEY_CONF_THRESHOLD_ALLOC_SIZE, this.threshold_alloc_size);     // Catch: JSONException -> L5
    L4:
        return r0;
    }
}
