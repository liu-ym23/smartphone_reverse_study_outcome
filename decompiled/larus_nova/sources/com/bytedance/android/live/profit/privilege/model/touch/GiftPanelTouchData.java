package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.android.live.base.model.message.a5;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0012B\u0013\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0015\u0010\u0005\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/GiftPanelTouchData;", "", "Lcom/bytedance/android/live/profit/privilege/model/touch/GiftPanelTouchData$a;", "component1", "rechargeButton", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/bytedance/android/live/profit/privilege/model/touch/GiftPanelTouchData$a;", "getRechargeButton", "()Lcom/bytedance/android/live/profit/privilege/model/touch/GiftPanelTouchData$a;", "<init>", "(Lcom/bytedance/android/live/profit/privilege/model/touch/GiftPanelTouchData$a;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftPanelTouchData {
    private final a rechargeButton;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a5 f88418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f88419b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, String> f88420c;

        public a() {
            this(null, null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f88418a, r101.f88418a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f88419b, r101.f88419b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f88420c, r101.f88420c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            a5 r100 = this.f88418a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f88419b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Map<String, String> r107 = this.f88420c;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "RechargeButton(buttonText=" + this.f88418a + ", schema=" + this.f88419b + ", extra=" + this.f88420c + ")";
        }

        public a(a5 r100, String r101, Map<String, String> r102) {
            this.f88418a = r100;
            this.f88419b = r101;
            this.f88420c = r102;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GiftPanelTouchData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ GiftPanelTouchData copy$default(GiftPanelTouchData r100, a r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.rechargeButton;
    L6:
        return r100.copy(r101);
    }

    public final a component1() {
        return this.rechargeButton;
    }

    public final GiftPanelTouchData copy(a r100) {
        return new GiftPanelTouchData(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GiftPanelTouchData) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.rechargeButton, ((GiftPanelTouchData) r100).rechargeButton) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        a r100 = this.rechargeButton;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "GiftPanelTouchData(rechargeButton=" + this.rechargeButton + ")";
    }

    public final a getRechargeButton() {
        return this.rechargeButton;
    }

    public GiftPanelTouchData(a r100) {
        this.rechargeButton = r100;
    }

    public /* synthetic */ GiftPanelTouchData(a r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
