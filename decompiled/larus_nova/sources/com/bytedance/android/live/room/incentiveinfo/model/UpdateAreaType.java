package com.bytedance.android.live.room.incentiveinfo.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/room/incentiveinfo/model/UpdateAreaType;", "", "", "value", "I", "getValue", "()I", "FIRST_LINE", "SECOND_LINE", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum UpdateAreaType extends Enum<UpdateAreaType> {
    public static final UpdateAreaType FIRST_LINE = null;
    public static final UpdateAreaType SECOND_LINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UpdateAreaType[] f99704a = null;
    private final int value;

    static {
        UpdateAreaType r100 = new UpdateAreaType("FIRST_LINE", 0, 0);
        FIRST_LINE = r100;
        UpdateAreaType r101 = new UpdateAreaType("SECOND_LINE", 1, 1);
        SECOND_LINE = r101;
        f99704a = new UpdateAreaType[]{r100, r101};
    }

    public static UpdateAreaType valueOf(String r100) {
        return (UpdateAreaType) a.a(UpdateAreaType.class, r100);
    }

    public static UpdateAreaType[] values() {
        return (UpdateAreaType[]) f99704a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public UpdateAreaType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
