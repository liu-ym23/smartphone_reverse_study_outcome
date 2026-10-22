package au9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/settings/provider/bot/BotDiscoverRefreshStrategy;", "", "needPreloadBeforeClickTab", "", "refreshIntervalSecond", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getNeedPreloadBeforeClickTab", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRefreshIntervalSecond", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/larus/settings/provider/bot/BotDiscoverRefreshStrategy;", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    @SerializedName("preload_before_click_tab")
    private final Boolean needPreloadBeforeClickTab;

    @SerializedName("refresh_interval_second")
    private final Integer refreshIntervalSecond;

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.needPreloadBeforeClickTab, r101.needPreloadBeforeClickTab) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.refreshIntervalSecond, r101.refreshIntervalSecond) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.needPreloadBeforeClickTab;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.refreshIntervalSecond;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BotDiscoverRefreshStrategy(needPreloadBeforeClickTab=" + this.needPreloadBeforeClickTab + ", refreshIntervalSecond=" + this.refreshIntervalSecond + ')';
    }

    public final Boolean a() {
        return this.needPreloadBeforeClickTab;
    }

    public final Integer b() {
        return this.refreshIntervalSecond;
    }

    public e(int r100) {
        this.needPreloadBeforeClickTab = Boolean.TRUE;
        this.refreshIntervalSecond = 300;
    }
}
