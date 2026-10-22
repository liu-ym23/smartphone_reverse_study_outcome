package com.bytedance.android.live.ktv.common.music.control;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public interface IMusicControlNode {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/ktv/common/music/control/IMusicControlNode$OperationType;", "", "ADD_MUSIC", "CUT_MUSIC", "PAUSE_MUSIC", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum OperationType extends Enum<OperationType> {
        public static final OperationType ADD_MUSIC = null;
        public static final OperationType CUT_MUSIC = null;
        public static final OperationType PAUSE_MUSIC = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ OperationType[] f70000a = null;

        static {
            OperationType r100 = new OperationType("ADD_MUSIC", 0);
            ADD_MUSIC = r100;
            OperationType r101 = new OperationType("CUT_MUSIC", 1);
            CUT_MUSIC = r101;
            OperationType r102 = new OperationType("PAUSE_MUSIC", 2);
            PAUSE_MUSIC = r102;
            f70000a = new OperationType[]{r100, r101, r102};
        }

        public static OperationType valueOf(String r100) {
            return (OperationType) r27.a.a(OperationType.class, r100);
        }

        public static OperationType[] values() {
            return (OperationType[]) f70000a.clone();
        }

        public OperationType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void a(b r100);

        void b(b r100);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OperationType f70001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MusicPanel f70002b;

        public final OperationType getType() {
            return this.f70001a;
        }

        public b(OperationType r100, MusicPanel r101) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "panel");
            this.f70001a = r100;
            this.f70002b = r101;
        }
    }

    void a();

    void b(g r100);

    OperationType getType();
}
