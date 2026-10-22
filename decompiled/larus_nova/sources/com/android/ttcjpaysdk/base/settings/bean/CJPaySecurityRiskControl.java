package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPaySecurityRiskControl;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "risk_control_parameter_upload_enabled", "", "check_window_obscured_status", "silent_mode_upload_enable", "(ZZZ)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySecurityRiskControl implements CJPayObject, Serializable {
    public boolean check_window_obscured_status;
    public boolean risk_control_parameter_upload_enabled;
    public boolean silent_mode_upload_enable;

    public CJPaySecurityRiskControl() {
        this(false, false, false, 7, null);
    }

    public CJPaySecurityRiskControl(boolean r100, boolean r101, boolean r102) {
        this.risk_control_parameter_upload_enabled = r100;
        this.check_window_obscured_status = r101;
        this.silent_mode_upload_enable = r102;
    }

    public /* synthetic */ CJPaySecurityRiskControl(boolean r100, boolean r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
