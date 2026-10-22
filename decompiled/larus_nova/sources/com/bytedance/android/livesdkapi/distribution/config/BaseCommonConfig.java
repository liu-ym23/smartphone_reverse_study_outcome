package com.bytedance.android.livesdkapi.distribution.config;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0016\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0012\u0010\u0016\u001a\u00020\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\bJ\u0012\u0010\u0018\u001a\u00020\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/distribution/config/BaseCommonConfig;", "", "enable", "", "shieldMode", "Lcom/bytedance/android/livesdkapi/distribution/config/ShieldMode;", "whiteOrBlackList", "", "", "(ZLcom/bytedance/android/livesdkapi/distribution/config/ShieldMode;Ljava/util/List;)V", "getEnable", "()Z", "setEnable", "(Z)V", "getShieldMode", "()Lcom/bytedance/android/livesdkapi/distribution/config/ShieldMode;", "setShieldMode", "(Lcom/bytedance/android/livesdkapi/distribution/config/ShieldMode;)V", "getWhiteOrBlackList", "()Ljava/util/List;", "setWhiteOrBlackList", "(Ljava/util/List;)V", "canUse", "action", "disable", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseCommonConfig {
    private boolean enable;
    private ShieldMode shieldMode;
    private List<String> whiteOrBlackList;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r100 = new int[ShieldMode.values().length];
            $EnumSwitchMapping$0 = r100;
            ShieldMode r101 = ShieldMode.NONE;
            r100[r101.ordinal()] = 1;
            ShieldMode r102 = ShieldMode.BLACK;
            r100[r102.ordinal()] = 2;
            ShieldMode r103 = ShieldMode.WHITE;
            r100[r103.ordinal()] = 3;
            int[] r104 = new int[ShieldMode.values().length];
            $EnumSwitchMapping$1 = r104;
            r104[r101.ordinal()] = 1;
            r104[r102.ordinal()] = 2;
            r104[r103.ordinal()] = 3;
        }
    }

    public BaseCommonConfig() {
        this(false, null, null, 7, null);
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final ShieldMode getShieldMode() {
        return this.shieldMode;
    }

    public final List<String> getWhiteOrBlackList() {
        return this.whiteOrBlackList;
    }

    public final boolean canUse(String r100) {
        if (this.enable == true) goto L5;
        return false;
    L5:
        ShieldMode r101 = this.shieldMode;
        int r102 = WhenMappings.$EnumSwitchMapping$0[r101.ordinal()];
        if (r102 != 1) goto L8;
    L21:
        return true;
    L8:
        if (r102 != 2) goto L10;
        List<String> r103 = this.whiteOrBlackList;
        if (r103 == null) goto L21;
        if (CollectionsKt.contains(r103, r100) != true) goto L21;
        return false;
    L10:
        if (r102 != 3) goto L21;
        List<String> r104 = this.whiteOrBlackList;
        if (r104 != null) goto L15;
        return false;
    L15:
        if (CollectionsKt.contains(r104, r100) == true) goto L21;
        return false;
    }

    public final boolean disable(String r100) {
        if (this.enable == true) goto L5;
        return true;
    L5:
        ShieldMode r101 = this.shieldMode;
        int r102 = WhenMappings.$EnumSwitchMapping$1[r101.ordinal()];
        if (r102 != 1) goto L8;
    L18:
        return false;
    L8:
        if (r102 != 2) goto L10;
        List<String> r103 = this.whiteOrBlackList;
        if (r103 == null) goto L18;
        return CollectionsKt.contains(r103, r100);
    L10:
        if (r102 != 3) goto L18;
        List<String> r104 = this.whiteOrBlackList;
        if (r104 != null) goto L21;
        return true;
    L21:
        return true ^ CollectionsKt.contains(r104, r100);
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setShieldMode(ShieldMode r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.shieldMode = r100;
    }

    public final void setWhiteOrBlackList(List<String> r100) {
        this.whiteOrBlackList = r100;
    }

    public BaseCommonConfig(boolean r100, ShieldMode r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r101, "shieldMode");
        this.enable = r100;
        this.shieldMode = r101;
        this.whiteOrBlackList = r102;
    }

    public static /* synthetic */ boolean canUse$default(BaseCommonConfig r100, String r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L7;
        r101 = null;
    L7:
        return r100.canUse(r101);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: canUse");
    }

    public static /* synthetic */ boolean disable$default(BaseCommonConfig r100, String r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L7;
        r101 = null;
    L7:
        return r100.disable(r101);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: disable");
    }

    public /* synthetic */ BaseCommonConfig(boolean r100, ShieldMode r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = ShieldMode.NONE;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
