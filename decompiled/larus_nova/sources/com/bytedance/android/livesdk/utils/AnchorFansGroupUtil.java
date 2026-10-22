package com.bytedance.android.livesdk.utils;

import com.bytedance.android.livesdk.config.iv;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
public final class AnchorFansGroupUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f158745a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/utils/AnchorFansGroupUtil$IMManagePageState;", "", "STATE_UNKNOWN", "STATE_OPEN", "STATE_CLOSE", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum IMManagePageState extends Enum<IMManagePageState> {
        public static final IMManagePageState STATE_CLOSE = null;
        public static final IMManagePageState STATE_OPEN = null;
        public static final IMManagePageState STATE_UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ IMManagePageState[] f158746a = null;

        static {
            IMManagePageState r100 = new IMManagePageState("STATE_UNKNOWN", 0);
            STATE_UNKNOWN = r100;
            IMManagePageState r101 = new IMManagePageState("STATE_OPEN", 1);
            STATE_OPEN = r101;
            IMManagePageState r102 = new IMManagePageState("STATE_CLOSE", 2);
            STATE_CLOSE = r102;
            f158746a = new IMManagePageState[]{r100, r101, r102};
        }

        public static IMManagePageState valueOf(String r100) {
            return (IMManagePageState) r27.a.a(IMManagePageState.class, r100);
        }

        public static IMManagePageState[] values() {
            return (IMManagePageState[]) f158746a.clone();
        }

        public IMManagePageState(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        IMManagePageState r100 = IMManagePageState.STATE_UNKNOWN;
    }

    @JvmStatic
    public static final boolean a() {
        return iv.f120481a.getValue().booleanValue();
    }
}
