package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayFaceGuideFinishEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "action", "Lcom/android/ttcjpaysdk/base/framework/event/CJPayFaceGuideFinishEvent$GuideProcessAction;", "hasAnim", "", "(Lcom/android/ttcjpaysdk/base/framework/event/CJPayFaceGuideFinishEvent$GuideProcessAction;Z)V", "getAction", "()Lcom/android/ttcjpaysdk/base/framework/event/CJPayFaceGuideFinishEvent$GuideProcessAction;", "getHasAnim", "()Z", "GuideProcessAction", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayFaceGuideFinishEvent extends BaseEvent {
    private final GuideProcessAction action;
    private final boolean hasAnim;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayFaceGuideFinishEvent$GuideProcessAction;", "", "(Ljava/lang/String;I)V", "FACE_GUIDE_FINISH", "FACE_GUIDE_HIDE", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum GuideProcessAction extends Enum<GuideProcessAction> {
        private static final /* synthetic */ GuideProcessAction[] $VALUES = null;
        public static final GuideProcessAction FACE_GUIDE_FINISH = null;
        public static final GuideProcessAction FACE_GUIDE_HIDE = null;

        private static final /* synthetic */ GuideProcessAction[] $values() {
            return new GuideProcessAction[]{FACE_GUIDE_FINISH, FACE_GUIDE_HIDE};
        }

        public static GuideProcessAction valueOf(String r100) {
            return (GuideProcessAction) a.a(GuideProcessAction.class, r100);
        }

        public static GuideProcessAction[] values() {
            return (GuideProcessAction[]) $VALUES.clone();
        }

        static {
            FACE_GUIDE_FINISH = new GuideProcessAction("FACE_GUIDE_FINISH", 0);
            FACE_GUIDE_HIDE = new GuideProcessAction("FACE_GUIDE_HIDE", 1);
            $VALUES = $values();
        }

        private GuideProcessAction(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CJPayFaceGuideFinishEvent() {
        GuideProcessAction r100 = null;
        this(r100, false, 3, 0 == true ? 1 : 0);
    }

    public final GuideProcessAction getAction() {
        return this.action;
    }

    public final boolean getHasAnim() {
        return this.hasAnim;
    }

    public CJPayFaceGuideFinishEvent(GuideProcessAction r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.action = r100;
        this.hasAnim = r101;
    }

    public /* synthetic */ CJPayFaceGuideFinishEvent(GuideProcessAction r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = GuideProcessAction.FACE_GUIDE_FINISH;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
