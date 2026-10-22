package com.bytedance.android.livesdk.interactivity.api.quickcomment.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
public final class BackRoomViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChangeType f133751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f133752b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/event/BackRoomViewState$ChangeType;", "", "VISIBLE", "GONE", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ChangeType extends Enum<ChangeType> {
        public static final ChangeType GONE = null;
        public static final ChangeType VISIBLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChangeType[] f133753a = null;

        static {
            ChangeType r100 = new ChangeType("VISIBLE", 0);
            VISIBLE = r100;
            ChangeType r101 = new ChangeType("GONE", 1);
            GONE = r101;
            f133753a = new ChangeType[]{r100, r101};
        }

        public static ChangeType valueOf(String r100) {
            return (ChangeType) a.a(ChangeType.class, r100);
        }

        public static ChangeType[] values() {
            return (ChangeType[]) f133753a.clone();
        }

        public ChangeType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public BackRoomViewState(ChangeType r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changeType");
        this.f133751a = r100;
        this.f133752b = r101;
    }
}
