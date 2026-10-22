package com.bytedance.ai.infra.thread_pool;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/infra/thread_pool/ThreadPriority;", "", "<init>", "(Ljava/lang/String;I)V", "LOW", EffectConstants.NORMAL, "HIGH", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ThreadPriority extends Enum<ThreadPriority> {
    public static final ThreadPriority HIGH = null;
    public static final ThreadPriority LOW = null;
    public static final ThreadPriority NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThreadPriority[] f36597a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f36598b = null;

    public static EnumEntries<ThreadPriority> getEntries() {
        return f36598b;
    }

    static {
        ThreadPriority r100 = new ThreadPriority("LOW", 0);
        LOW = r100;
        ThreadPriority r101 = new ThreadPriority(EffectConstants.NORMAL, 1);
        NORMAL = r101;
        ThreadPriority r102 = new ThreadPriority("HIGH", 2);
        HIGH = r102;
        ThreadPriority[] r103 = {r100, r101, r102};
        f36597a = r103;
        f36598b = EnumEntriesKt.enumEntries(r103);
    }

    public static ThreadPriority[] values() {
        return (ThreadPriority[]) f36597a.clone();
    }

    public static ThreadPriority valueOf(String r100) {
        return (ThreadPriority) r27.a.a(ThreadPriority.class, r100);
    }

    public ThreadPriority(String r100, int r101) {
        super(r100, r101);
    }
}
