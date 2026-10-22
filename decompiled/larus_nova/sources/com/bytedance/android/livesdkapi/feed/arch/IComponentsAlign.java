package com.bytedance.android.livesdkapi.feed.arch;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdkapi.arch.CommonRoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomMessageHandler;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.ILayoutConstraint;
import com.bytedance.android.livesdkapi.room.state.IRoomState;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;
import wlc.c;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002;<JC\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0014\u001a\u00020\u0013H&J\u001a\u0010\u0017\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u0015H&J\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J*\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH&J\u001c\u0010\u001e\u001a\u00020\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001fH&J9\u0010&\u001a\u00020\u0013\"\u0004\b\u0000\u0010!2\u0006\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b&\u0010'J\u001c\u0010(\u001a\u00020\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&J(\u0010+\u001a\u0004\u0018\u00010*2\b\u0010)\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0014\u0010-\u001a\u0004\u0018\u00010,2\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u001c\u00100\u001a\u0004\u0018\u00010/2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010.\u001a\u00020\u0011H&J\u001e\u00102\u001a\u0004\u0018\u0001012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J,\u00105\u001a\u00020\u00132\b\u00103\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u00104\u001a\u00020*H&J,\u0010:\u001a\u00020\u00132\b\u00103\u001a\u0004\u0018\u00010\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u00107\u001a\u0002062\u0006\u00109\u001a\u000208H&¨\u0006="}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/arch/IComponentsAlign;", "", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "roomId", "", "code", "Lvlc/d;", "messageManager", "Lwlc/c;", "streamMessageManager", "", "createRoomContext", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;JLjava/lang/Integer;Lvlc/d;Lwlc/c;)Z", "Landroidx/fragment/app/Fragment;", WidgetService.PARAM_FRAGMENT, "Lcom/bytedance/live/datacontext/DataContext;", "createInteractionContext", "", "disRoomContext", "Lcom/bytedance/android/livesdkapi/arch/CommonRoomContext;", "commonRoomContext", "initCommonRoomContext", "getCommonRoomContext", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "injectPreviewBusinessContext", "injectPreviewBusinessDataCenter", "Lcom/bytedance/android/livesdkapi/feed/arch/IInjectBusinessContext;", "registerInjectContext", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/livesdkapi/feed/arch/PreViewRoomControllerLifeCycle;", "lifeCycle", "extra", "indentCode", "callController", "(Lcom/bytedance/android/livesdkapi/feed/arch/PreViewRoomControllerLifeCycle;Ljava/lang/Object;JLjava/lang/Integer;)V", "injectPreviewRoomControllerProvider", "interactionContext", "Lcom/bytedance/android/livesdkapi/room/handler/ILiveRoomViewHandler;", "createRoomViewHandler", "Lcom/bytedance/android/livesdkapi/room/handler/ILiveRoomMessageHandler;", "createLiveRoomMessageHandler", "mergeDataContext", "Lcom/bytedance/android/livesdkapi/room/handler/IBaseLiveRoomFunctionHandler;", "createFunctionHandler", "Lcom/bytedance/android/livesdkapi/room/state/IRoomState;", "createRoomStats", "dataContext", "roomViewHandler", "updateRoomControllerHandler", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/constraint/ILayoutConstraint;", "constraint", "Lcom/bytedance/android/livesdk/room/placeholder/widget/d;", "placeHolder", "addPlaceHolderWidget", "BindStartExtra", "ToolbarBehavior", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IComponentsAlign {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000bHÆ\u0003JC\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\b\u0010\"\u001a\u00020#H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/arch/IComponentsAlign$BindStartExtra;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "event", "Lcom/bytedance/android/livesdkapi/roomplayer/IRoomEventHub;", "handler", "Lcom/bytedance/android/livesdkapi/room/handler/ILiveRoomViewHandler;", "roomState", "Lcom/bytedance/android/livesdkapi/room/state/IRoomState;", "messageHandler", "Lcom/bytedance/android/livesdkapi/room/handler/ILiveRoomMessageHandler;", "(Landroid/content/Context;Lcom/bytedance/android/livesdkapi/roomplayer/IRoomEventHub;Lcom/bytedance/android/livesdkapi/room/handler/ILiveRoomViewHandler;Lcom/bytedance/android/livesdkapi/room/state/IRoomState;Lcom/bytedance/android/livesdkapi/room/handler/ILiveRoomMessageHandler;)V", "getContext", "()Landroid/content/Context;", "getEvent", "()Lcom/bytedance/android/livesdkapi/roomplayer/IRoomEventHub;", "getHandler", "()Lcom/bytedance/android/livesdkapi/room/handler/ILiveRoomViewHandler;", "getMessageHandler", "()Lcom/bytedance/android/livesdkapi/room/handler/ILiveRoomMessageHandler;", "getRoomState", "()Lcom/bytedance/android/livesdkapi/room/state/IRoomState;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class BindStartExtra {
        private final Context context;
        private final IRoomEventHub event;
        private final ILiveRoomViewHandler handler;
        private final ILiveRoomMessageHandler messageHandler;
        private final IRoomState roomState;

        public static /* synthetic */ BindStartExtra copy$default(BindStartExtra r100, Context r101, IRoomEventHub r102, ILiveRoomViewHandler r103, IRoomState r104, ILiveRoomMessageHandler r105, int r106, Object r110) {
            if ((r106 & 1) == 0) goto L6;
            r101 = r100.context;
        L6:
            if ((r106 & 2) == 0) goto L8;
            r102 = r100.event;
        L8:
            IRoomEventHub r111 = r102;
            if ((r106 & 4) == 0) goto L11;
            r103 = r100.handler;
        L11:
            ILiveRoomViewHandler r107 = r103;
            if ((r106 & 8) == 0) goto L14;
            r104 = r100.roomState;
        L14:
            IRoomState r108 = r104;
            if ((r106 & 16) == 0) goto L17;
            r105 = r100.messageHandler;
        L17:
            Context r109 = r101;
            return r100.copy(r109, r111, r107, r108, r105);
        }

        public final Context component1() {
            return this.context;
        }

        public final IRoomEventHub component2() {
            return this.event;
        }

        public final ILiveRoomViewHandler component3() {
            return this.handler;
        }

        public final IRoomState component4() {
            return this.roomState;
        }

        public final ILiveRoomMessageHandler component5() {
            return this.messageHandler;
        }

        public final BindStartExtra copy(Context r100, IRoomEventHub r101, ILiveRoomViewHandler r110, IRoomState r111, ILiveRoomMessageHandler r112) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new BindStartExtra(r100, r101, r110, r111, r112);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof BindStartExtra) == false) goto L16;
            BindStartExtra r101 = (BindStartExtra) r100;
            if (Intrinsics.areEqual(this.context, r101.context) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.event, r101.event) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.handler, r101.handler) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.roomState, r101.roomState) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.messageHandler, r101.messageHandler) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            Context r100 = this.context;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            IRoomEventHub r104 = this.event;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            ILiveRoomViewHandler r107 = this.handler;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            IRoomState r110 = this.roomState;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            ILiveRoomMessageHandler r113 = this.messageHandler;
            if (r113 == null) goto L22;
            r101 = r113.hashCode();
        L22:
            return r112 + r101;
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "context=" + this.context + ", event = " + this.event;
        }

        public final Context getContext() {
            return this.context;
        }

        public final IRoomEventHub getEvent() {
            return this.event;
        }

        public final ILiveRoomViewHandler getHandler() {
            return this.handler;
        }

        public final ILiveRoomMessageHandler getMessageHandler() {
            return this.messageHandler;
        }

        public final IRoomState getRoomState() {
            return this.roomState;
        }

        public BindStartExtra(Context r100, IRoomEventHub r101, ILiveRoomViewHandler r102, IRoomState r103, ILiveRoomMessageHandler r104) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.context = r100;
            this.event = r101;
            this.handler = r102;
            this.roomState = r103;
            this.messageHandler = r104;
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ CommonRoomContext getCommonRoomContext$default(IComponentsAlign r100, DataCenter r101, long r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 1) == 0) goto L7;
            r101 = null;
        L7:
            return r100.getCommonRoomContext(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCommonRoomContext");
        }

        public static /* synthetic */ boolean createRoomContext$default(IComponentsAlign r100, DataCenter r101, long r102, Integer r110, d r111, c r112, int r113, Object r114) {
            if (r114 != null) goto L12;
            if ((r113 & 1) == 0) goto L6;
            r101 = null;
        L6:
            DataCenter r103 = r101;
            if ((r113 & 2) == 0) goto L10;
            r102 = 0;
        L10:
            return r100.createRoomContext(r103, r102, r110, r111, r112);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createRoomContext");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/arch/IComponentsAlign$ToolbarBehavior;", "", "behaviorClassName", "", "isFold", "", "isFromMsg", "(Ljava/lang/String;ZZ)V", "getBehaviorClassName", "()Ljava/lang/String;", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolbarBehavior {
        private final String behaviorClassName;
        private final boolean isFold;
        private final boolean isFromMsg;

        public static /* synthetic */ ToolbarBehavior copy$default(ToolbarBehavior r100, String r101, boolean r102, boolean r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.behaviorClassName;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.isFold;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.isFromMsg;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.behaviorClassName;
        }

        public final boolean component2() {
            return this.isFold;
        }

        public final boolean component3() {
            return this.isFromMsg;
        }

        public final ToolbarBehavior copy(String r100, boolean r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "behaviorClassName");
            return new ToolbarBehavior(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof ToolbarBehavior) == false) goto L12;
            ToolbarBehavior r101 = (ToolbarBehavior) r100;
            if (Intrinsics.areEqual(this.behaviorClassName, r101.behaviorClassName) == true) goto L8;
            return false;
        L8:
            if (this.isFold == r101.isFold) goto L10;
            return false;
        L10:
            if (this.isFromMsg == r101.isFromMsg) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            String r100 = this.behaviorClassName;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            int r102 = r101 * 31;
            boolean r103 = this.isFold;
            ?? r104 = 1;
            ?? r105 = r103;
            if (r103 == false) goto L9;
            r105 = 1;
        L9:
            int r106 = (r102 + r105) * 31;
            boolean r107 = this.isFromMsg;
            if (r107 == true) goto L14;
            r104 = r107;
        L14:
            return r106 + r104;
        L5:
            r101 = 0;
            goto L6
        }

        public String toString() {
            return "behaviorClassName=" + this.behaviorClassName + ", isFold = " + this.isFold + ", isFromMsg = " + this.isFromMsg + ',';
        }

        public final String getBehaviorClassName() {
            return this.behaviorClassName;
        }

        public final boolean isFold() {
            return this.isFold;
        }

        public final boolean isFromMsg() {
            return this.isFromMsg;
        }

        public ToolbarBehavior(String r100, boolean r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "behaviorClassName");
            this.behaviorClassName = r100;
            this.isFold = r101;
            this.isFromMsg = r102;
        }
    }

    void addPlaceHolderWidget(DataContext r100, DataCenter r101, ILayoutConstraint r102, com.bytedance.android.livesdk.room.placeholder.widget.d r103);

    <T> void callController(PreViewRoomControllerLifeCycle r100, T r101, long r102, Integer r103);

    IBaseLiveRoomFunctionHandler createFunctionHandler(DataCenter r100, DataContext r101);

    DataContext createInteractionContext(DataCenter r100, Fragment r101);

    ILiveRoomMessageHandler createLiveRoomMessageHandler(d r100);

    boolean createRoomContext(DataCenter r100, long r101, Integer r102, d r103, c r104);

    IRoomState createRoomStats(Room r100, DataCenter r101);

    ILiveRoomViewHandler createRoomViewHandler(DataContext r100, Fragment r101, DataCenter r102);

    void disRoomContext();

    CommonRoomContext getCommonRoomContext(DataCenter r100, long r101);

    boolean initCommonRoomContext(DataCenter r100, CommonRoomContext r101);

    void injectPreviewBusinessContext(Context r100, DataCenter r101, long r102, Room r103);

    void injectPreviewBusinessDataCenter(DataCenter r100, Room r101);

    void injectPreviewRoomControllerProvider(DataCenter r100, Room r101);

    void registerInjectContext(IInjectBusinessContext r100);

    void updateRoomControllerHandler(DataContext r100, DataCenter r101, Fragment r102, ILiveRoomViewHandler r103);
}
