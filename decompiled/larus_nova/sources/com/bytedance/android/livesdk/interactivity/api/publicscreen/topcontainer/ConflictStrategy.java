package com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/topcontainer/ConflictStrategy;", "", "DISCARD", "QUEUE", "INTERRUPT", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ConflictStrategy extends Enum<ConflictStrategy> {
    public static final ConflictStrategy DISCARD = null;
    public static final ConflictStrategy INTERRUPT = null;
    public static final ConflictStrategy QUEUE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConflictStrategy[] f133547a = null;

    static {
        ConflictStrategy r100 = new ConflictStrategy("DISCARD", 0);
        DISCARD = r100;
        ConflictStrategy r101 = new ConflictStrategy("QUEUE", 1);
        QUEUE = r101;
        ConflictStrategy r102 = new ConflictStrategy("INTERRUPT", 2);
        INTERRUPT = r102;
        f133547a = new ConflictStrategy[]{r100, r101, r102};
    }

    public static ConflictStrategy valueOf(String r100) {
        return (ConflictStrategy) a.a(ConflictStrategy.class, r100);
    }

    public static ConflictStrategy[] values() {
        return (ConflictStrategy[]) f133547a.clone();
    }

    public ConflictStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
