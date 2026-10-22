package au9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/larus/settings/provider/bot/BotsOptimizeConfig;", "", "enableCreateBotGotoChatOpt", "", "enableEnterBotCreatePageOpt", "botsApiRetryCount", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getEnableCreateBotGotoChatOpt", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableEnterBotCreatePageOpt", "getBotsApiRetryCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/larus/settings/provider/bot/BotsOptimizeConfig;", "equals", "other", "hashCode", "toString", "", "Companion", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f16326a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f16327b = null;

    @SerializedName("bots_api_retry_count")
    private final Integer botsApiRetryCount;

    @SerializedName("enable_create_bot_goto_chat_optimize")
    private final Boolean enableCreateBotGotoChatOpt;

    @SerializedName("enable_enter_bot_create_page_optimize")
    private final Boolean enableEnterBotCreatePageOpt;

    public static final class a {
    }

    public i() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.enableCreateBotGotoChatOpt, r101.enableCreateBotGotoChatOpt) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enableEnterBotCreatePageOpt, r101.enableEnterBotCreatePageOpt) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.botsApiRetryCount, r101.botsApiRetryCount) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.enableCreateBotGotoChatOpt;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.enableEnterBotCreatePageOpt;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.botsApiRetryCount;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BotsOptimizeConfig(enableCreateBotGotoChatOpt=" + this.enableCreateBotGotoChatOpt + ", enableEnterBotCreatePageOpt=" + this.enableEnterBotCreatePageOpt + ", botsApiRetryCount=" + this.botsApiRetryCount + ')';
    }

    static {
        Boolean r100 = Boolean.TRUE;
        f16326a = new i(r100, r100, 0);
        f16327b = new i(0);
    }

    public final Integer a() {
        return this.botsApiRetryCount;
    }

    public final Boolean b() {
        return this.enableCreateBotGotoChatOpt;
    }

    public /* synthetic */ i(int r100) {
        Boolean r101 = Boolean.FALSE;
        this(r101, r101, 0);
    }

    public i(Boolean r100, Boolean r101, Integer r102) {
        this.enableCreateBotGotoChatOpt = r100;
        this.enableEnterBotCreatePageOpt = r101;
        this.botsApiRetryCount = r102;
    }
}
