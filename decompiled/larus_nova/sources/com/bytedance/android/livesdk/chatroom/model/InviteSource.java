package com.bytedance.android.livesdk.chatroom.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/InviteSource;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UNKNOWN", "FROM_MUTUAL_FOLLOW", "FROM_RECOMMEND", "FROM_SEARCH", "RANDOM_MATCH", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum InviteSource extends Enum<InviteSource> {
    public static final a Companion = null;
    public static final InviteSource FROM_MUTUAL_FOLLOW = null;
    public static final InviteSource FROM_RECOMMEND = null;
    public static final InviteSource FROM_SEARCH = null;
    public static final InviteSource RANDOM_MATCH = null;
    public static final InviteSource UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InviteSource[] f106896a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.chatroom.model.InviteSource$a] */
    static {
        InviteSource r100 = new InviteSource("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        InviteSource r101 = new InviteSource("FROM_MUTUAL_FOLLOW", 1, 1);
        FROM_MUTUAL_FOLLOW = r101;
        InviteSource r102 = new InviteSource("FROM_RECOMMEND", 2, 2);
        FROM_RECOMMEND = r102;
        InviteSource r103 = new InviteSource("FROM_SEARCH", 3, 3);
        FROM_SEARCH = r103;
        InviteSource r104 = new InviteSource("RANDOM_MATCH", 4, 4);
        RANDOM_MATCH = r104;
        f106896a = new InviteSource[]{r100, r101, r102, r103, r104};
        Companion = new a();
    }

    public static InviteSource valueOf(String r100) {
        return (InviteSource) r27.a.a(InviteSource.class, r100);
    }

    public static InviteSource[] values() {
        return (InviteSource[]) f106896a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public InviteSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
