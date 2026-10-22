package com.bytedance.android.livesdkapi.floatview;

import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/floatview/InnerFloatWindowHelper;", "", "()V", "triggerWindowCallBack", "", "listeners", "", "Lcom/bytedance/android/livesdkapi/view/IVideoFloatManager$VideoFloatManagerListener;", "action", "Lcom/bytedance/android/livesdkapi/floatview/InnerFloatWindowHelper$ActionType;", "type", "", "ActionType", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InnerFloatWindowHelper {
    public static final InnerFloatWindowHelper INSTANCE = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/floatview/InnerFloatWindowHelper$ActionType;", "", "(Ljava/lang/String;I)V", "SHOW", "CLICK", "MUTECLICK", "CLOSE", "RETURNCLICK", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ActionType extends Enum<ActionType> {
        private static final /* synthetic */ ActionType[] $VALUES = null;
        public static final ActionType CLICK = null;
        public static final ActionType CLOSE = null;
        public static final ActionType MUTECLICK = null;
        public static final ActionType RETURNCLICK = null;
        public static final ActionType SHOW = null;

        static {
            ActionType r100 = new ActionType("SHOW", 0);
            SHOW = r100;
            ActionType r101 = new ActionType("CLICK", 1);
            CLICK = r101;
            ActionType r102 = new ActionType("MUTECLICK", 2);
            MUTECLICK = r102;
            ActionType r103 = new ActionType("CLOSE", 3);
            CLOSE = r103;
            ActionType r104 = new ActionType("RETURNCLICK", 4);
            RETURNCLICK = r104;
            $VALUES = new ActionType[]{r100, r101, r102, r103, r104};
        }

        public static ActionType valueOf(String r100) {
            return (ActionType) a.a(ActionType.class, r100);
        }

        public static ActionType[] values() {
            return (ActionType[]) $VALUES.clone();
        }

        private ActionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[ActionType.values().length];
            $EnumSwitchMapping$0 = r100;
            r100[ActionType.SHOW.ordinal()] = 1;
            r100[ActionType.CLICK.ordinal()] = 2;
            r100[ActionType.MUTECLICK.ordinal()] = 3;
            r100[ActionType.CLOSE.ordinal()] = 4;
            r100[ActionType.RETURNCLICK.ordinal()] = 5;
        }
    }

    private InnerFloatWindowHelper() {
    }

    static {
        INSTANCE = new InnerFloatWindowHelper();
    }

    public final void triggerWindowCallBack(List<IVideoFloatManager.VideoFloatManagerListener> r100, ActionType r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "action");
        if (r100 != null) goto L5;
        return;
    L5:
        ArrayList r103 = new ArrayList(r100);
        int r104 = WhenMappings.$EnumSwitchMapping$0[r101.ordinal()];
        if (r104 != 1) goto L8;
        Iterator r105 = r103.iterator();
    L42:
        if (r105.hasNext() == false) goto L76;
        IVideoFloatManager.VideoFloatManagerListener r106 = (IVideoFloatManager.VideoFloatManagerListener) r105.next();
        if (r106 == null) goto L42;
        r106.onShow();
        goto L42
    L76:
        return;
    L8:
        if (r104 != 2) goto L10;
        Iterator r107 = r103.iterator();
    L36:
        if (r107.hasNext() == false) goto L75;
        IVideoFloatManager.VideoFloatManagerListener r108 = (IVideoFloatManager.VideoFloatManagerListener) r107.next();
        if (r108 == null) goto L36;
        r108.onClick();
        goto L36
    L75:
        return;
    L10:
        if (r104 != 3) goto L12;
        Iterator r109 = r103.iterator();
    L30:
        if (r109.hasNext() == false) goto L74;
        IVideoFloatManager.VideoFloatManagerListener r110 = (IVideoFloatManager.VideoFloatManagerListener) r109.next();
        if (r110 == null) goto L30;
        r110.onMuteButtonClick(r102);
        goto L30
    L74:
        return;
    L12:
        if (r104 != 4) goto L14;
        Iterator r111 = r103.iterator();
    L24:
        if (r111.hasNext() == false) goto L73;
        IVideoFloatManager.VideoFloatManagerListener r112 = (IVideoFloatManager.VideoFloatManagerListener) r111.next();
        if (r112 == null) goto L24;
        r112.onClose(r102);
        goto L24
    L73:
        return;
    L14:
        if (r104 != 5) goto L46;
        Iterator r113 = r103.iterator();
    L18:
        if (r113.hasNext() == false) goto L72;
        IVideoFloatManager.VideoFloatManagerListener r114 = (IVideoFloatManager.VideoFloatManagerListener) r113.next();
        if (r114 == null) goto L18;
        r114.onReturnClick();
        goto L18
    L72:
        return;
    }

    public static /* synthetic */ void triggerWindowCallBack$default(InnerFloatWindowHelper r100, List r101, ActionType r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = false;
    L5:
        r100.triggerWindowCallBack(r101, r102, r103);
    }
}
