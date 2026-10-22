package com.bytedance.android.format.model.message;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/format/model/message/LiveMsgTouchGuide;", "", "", "", "displayGuide", "Ljava/util/List;", "getDisplayGuide", "()Ljava/util/List;", "<init>", "()V", "MotionLiveTouchAction", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMsgTouchGuide {

    @SerializedName("display_guide")
    private final List<Integer> displayGuide;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/format/model/message/LiveMsgTouchGuide$MotionLiveTouchAction;", "", "", "action", "I", "getAction", "()I", "MotionLiveTouchAction_Invalid", "MotionLiveTouchAction_ZoomIn", "MotionLiveTouchAction_RotateDizzy", "MotionLiveTouchAction_PetMer", "MotionLiveTouchAction_HoldHand", "MotionLiveTouchAction_PokeFace", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum MotionLiveTouchAction extends Enum<MotionLiveTouchAction> {
        public static final MotionLiveTouchAction MotionLiveTouchAction_HoldHand = null;
        public static final MotionLiveTouchAction MotionLiveTouchAction_Invalid = null;
        public static final MotionLiveTouchAction MotionLiveTouchAction_PetMer = null;
        public static final MotionLiveTouchAction MotionLiveTouchAction_PokeFace = null;
        public static final MotionLiveTouchAction MotionLiveTouchAction_RotateDizzy = null;
        public static final MotionLiveTouchAction MotionLiveTouchAction_ZoomIn = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MotionLiveTouchAction[] f51356a = null;
        private final int action;

        static {
            MotionLiveTouchAction r100 = new MotionLiveTouchAction("MotionLiveTouchAction_Invalid", 0, 0);
            MotionLiveTouchAction_Invalid = r100;
            MotionLiveTouchAction r101 = new MotionLiveTouchAction("MotionLiveTouchAction_ZoomIn", 1, 1);
            MotionLiveTouchAction_ZoomIn = r101;
            MotionLiveTouchAction r102 = new MotionLiveTouchAction("MotionLiveTouchAction_RotateDizzy", 2, 2);
            MotionLiveTouchAction_RotateDizzy = r102;
            MotionLiveTouchAction r103 = new MotionLiveTouchAction("MotionLiveTouchAction_PetMer", 3, 3);
            MotionLiveTouchAction_PetMer = r103;
            MotionLiveTouchAction r104 = new MotionLiveTouchAction("MotionLiveTouchAction_HoldHand", 4, 4);
            MotionLiveTouchAction_HoldHand = r104;
            MotionLiveTouchAction r105 = new MotionLiveTouchAction("MotionLiveTouchAction_PokeFace", 5, 5);
            MotionLiveTouchAction_PokeFace = r105;
            f51356a = new MotionLiveTouchAction[]{r100, r101, r102, r103, r104, r105};
        }

        public static MotionLiveTouchAction valueOf(String r100) {
            return (MotionLiveTouchAction) a.a(MotionLiveTouchAction.class, r100);
        }

        public static MotionLiveTouchAction[] values() {
            return (MotionLiveTouchAction[]) f51356a.clone();
        }

        public final int getAction() {
            return this.action;
        }

        public MotionLiveTouchAction(String r100, int r101, int r102) {
            super(r100, r101);
            this.action = r102;
        }
    }

    public LiveMsgTouchGuide() {
    }
}
