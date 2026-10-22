package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\fJ\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0007H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/DeviceFeat;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "is_calling", "", "call_volume", "", "sim_carrier", "", "is_window_obscured", "is_silent_mode", "is_virtual_click", "intention_feat", "(Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "Ljava/lang/Double;", "Ljava/lang/Boolean;", "toJson", "Lorg/json/JSONObject;", "toString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeviceFeat implements CJPayObject {
    public Double call_volume;
    public final String intention_feat;
    public Boolean is_calling;
    public Boolean is_silent_mode;
    public Boolean is_virtual_click;
    public Boolean is_window_obscured;
    public String sim_carrier;

    public DeviceFeat() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public final JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r100, "is_calling", this.is_calling);
        KtSafeMethodExtensionKt.safePut(r100, "call_volume", this.call_volume);
        KtSafeMethodExtensionKt.safePut(r100, "sim_carrier", this.sim_carrier);
        KtSafeMethodExtensionKt.safePut(r100, "is_silent_mode", this.is_silent_mode);
        KtSafeMethodExtensionKt.safePut(r100, "is_window_obscured", this.is_window_obscured);
        Boolean r101 = this.is_virtual_click;
        if (r101 == null) goto L5;
        boolean r102 = r101.booleanValue();
    L6:
        if (r102 == false) goto L8;
        JSONObject r103 = r100;
    L9:
        if (r103 == null) goto L11;
        KtSafeMethodExtensionKt.safePut(r100, "is_virtual_click", this.is_virtual_click);
    L11:
        KtSafeMethodExtensionKt.safePut(r100, "intention_feat", this.intention_feat);
        return r100;
    L8:
        r103 = null;
        goto L9
    L5:
        r102 = false;
        goto L6
    }

    public String toString() {
        return "is_calling:" + this.is_calling + ",call_volume:" + this.call_volume + ",sim_carrier:" + this.sim_carrier + ",is_silent_mode:" + this.is_silent_mode + ",is_window_obscured:" + this.is_window_obscured + ",is_virtual_click:" + this.is_virtual_click + ",intention_feat:" + this.intention_feat;
    }

    public DeviceFeat(Boolean r100, Double r101, String r102, Boolean r103, Boolean r104, Boolean r105, String r106) {
        Intrinsics.checkNotNullParameter(r102, "sim_carrier");
        this.is_calling = r100;
        this.call_volume = r101;
        this.sim_carrier = r102;
        this.is_window_obscured = r103;
        this.is_silent_mode = r104;
        this.is_virtual_click = r105;
        this.intention_feat = r106;
    }

    public /* synthetic */ DeviceFeat(Boolean r100, Double r101, String r102, Boolean r110, Boolean r111, Boolean r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        Boolean r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        Double r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        r102 = "";
    L13:
        String r104 = r102;
        if ((r114 & 8) == 0) goto L16;
        Boolean r105 = null;
    L18:
        if ((r114 & 16) == 0) goto L20;
        Boolean r106 = null;
    L22:
        if ((r114 & 32) == 0) goto L24;
        Boolean r107 = null;
    L26:
        if ((r114 & 64) == 0) goto L28;
        String r117 = null;
    L29:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L28:
        r117 = r113;
        goto L29
    L24:
        r107 = r112;
        goto L26
    L20:
        r106 = r111;
        goto L22
    L16:
        r105 = r110;
        goto L18
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
