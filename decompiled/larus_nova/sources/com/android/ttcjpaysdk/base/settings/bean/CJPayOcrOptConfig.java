package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayOcrOptConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "camera_permission_opt", "", "compress_opt", "default_compress_size_kb", "", "frame_pre_check_enable", "network_recovery_enable", "sample_rate_boost_enable", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayOcrOptConfig implements CJPayObject, Serializable {
    public String camera_permission_opt;
    public String compress_opt;
    public int default_compress_size_kb;
    public String frame_pre_check_enable;
    public String network_recovery_enable;
    public String sample_rate_boost_enable;

    public CJPayOcrOptConfig() {
        this.camera_permission_opt = "0";
        this.sample_rate_boost_enable = "0";
        this.frame_pre_check_enable = "0";
        this.compress_opt = "0";
        this.network_recovery_enable = "0";
        this.default_compress_size_kb = 150;
    }
}
