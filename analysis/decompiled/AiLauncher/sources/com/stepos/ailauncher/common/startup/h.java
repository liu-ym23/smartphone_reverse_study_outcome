package com.stepos.ailauncher.common.startup;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b&\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/common/startup/h;", "", "", "id", "Lcom/stepos/ailauncher/common/startup/InitStrategy;", "strategy", "", "dependsOn", "", "delayMillis", "", "requiresPrivacy", "<init>", "(Ljava/lang/String;Lcom/stepos/ailauncher/common/startup/InitStrategy;Ljava/util/List;JZ)V", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "()Ljava/lang/String;", "Lcom/stepos/ailauncher/common/startup/InitStrategy;", "f", "()Lcom/stepos/ailauncher/common/startup/InitStrategy;", "Ljava/util/List;", "c", "()Ljava/util/List;", "J", Const.INTENT_KEY_PKGNAME, "()J", "Z", "e", "()Z", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class h {
    private final long delayMillis;
    private final List<String> dependsOn;
    private final String id;
    private final boolean requiresPrivacy;
    private final InitStrategy strategy;

    public h(String id, InitStrategy strategy, List<String> dependsOn, long j10, boolean z10) {
        p.i(id, "id");
        p.i(strategy, "strategy");
        p.i(dependsOn, "dependsOn");
        this.id = id;
        this.strategy = strategy;
        this.dependsOn = dependsOn;
        this.delayMillis = j10;
        this.requiresPrivacy = z10;
    }

    public abstract void a(Context context);

    /* renamed from: b, reason: from getter */
    public final long getDelayMillis() {
        return this.delayMillis;
    }

    public final List<String> c() {
        return this.dependsOn;
    }

    /* renamed from: d, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getRequiresPrivacy() {
        return this.requiresPrivacy;
    }

    /* renamed from: f, reason: from getter */
    public final InitStrategy getStrategy() {
        return this.strategy;
    }
}
