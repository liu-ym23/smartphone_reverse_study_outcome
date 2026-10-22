package com.bytedance.android.livesdkapi.sti.framework;

import android.view.View;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.doubao.relax.profile.edit.ProfileEditRelaxPage;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u000234J)\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0015\u001a\u00028\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&¢\u0006\u0002\u0010\u0018J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\b\u0010\u001b\u001a\u00020\u001cH\u0016J!\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001e\u001a\u00028\u00002\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020!H&J\u0017\u0010\"\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001e\u001a\u00028\u0000H&¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0013H&J\b\u0010'\u001a\u00020\u0013H&J\u0016\u0010(\u001a\u00020\u00132\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000*H&J\b\u0010+\u001a\u00020\u0013H&J\u0018\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/H&J\b\u00100\u001a\u00020\u0013H&J\u0010\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u0005H&R\u0018\u0010\u0004\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0012\u0010\r\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdkapi/sti/framework/IIconModel;", "STATE", "", "Lcom/bytedance/android/livesdkapi/sti/framework/IShortTouchLifeCycle;", "iconHeight", "", "getIconHeight", "()I", "setIconHeight", "(I)V", "iconWidth", "getIconWidth", "setIconWidth", "initialState", ProfileEditRelaxPage.METHOD_GET_INITIAL_STATE, "()Ljava/lang/Object;", "typeId", "getTypeId", "applyState", "", "prevState", "curState", "icon", "Lcom/bytedance/android/livesdkapi/sti/framework/IconTemplate;", "(Ljava/lang/Object;Ljava/lang/Object;Lcom/bytedance/android/livesdkapi/sti/framework/IconTemplate;)V", "getBigCardEntryViewForState", "Lcom/bytedance/android/livesdkapi/sti/framework/IIconModel$EntryView;", "getDynamicPriorityShortTouch", "", "getEntryViewForState", "state", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/bytedance/android/livesdkapi/sti/framework/IIconModel$EntryView;", "getIconDesc", "", "getViewForState", "(Ljava/lang/Object;)Lcom/bytedance/android/livesdkapi/sti/framework/IconTemplate;", "isEnhancedStyleShortTouch", "", LynxVideoManagerLite.EVENT_ON_APPEAR, SendEventContainerMethodParamModel.EventKinds.onClick, WidgetCostModule.TYPE_ON_CREATE, "service", "Lcom/bytedance/android/livesdkapi/sti/framework/IIconService;", LiveCommonConstants.REASON_ON_DEDTROY, "onEntryEvent", "entryView", "event", "Lcom/bytedance/android/livesdkapi/sti/framework/IIconModel$EntryEvent;", "onHideTempState", "onShowTempState", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "EntryEvent", "EntryView", "livedynamic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IIconModel<STATE> extends IShortTouchLifeCycle {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static <STATE> long getDynamicPriorityShortTouch(IIconModel<STATE> r100) {
            return 0;
        }

        public static <STATE> boolean isEnhancedStyleShortTouch(IIconModel<STATE> r100) {
            return false;
        }

        public static <STATE> void onPause(IIconModel<STATE> r100) {
            IShortTouchLifeCycle.DefaultImpls.onPause(r100);
        }

        public static <STATE> void onResume(IIconModel<STATE> r100) {
            IShortTouchLifeCycle.DefaultImpls.onResume(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/sti/framework/IIconModel$EntryEvent;", "", "(Ljava/lang/String;I)V", "Start", "End", "Skip", "livedynamic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum EntryEvent extends Enum<EntryEvent> {
        private static final /* synthetic */ EntryEvent[] $VALUES = null;
        public static final EntryEvent End = null;
        public static final EntryEvent Skip = null;
        public static final EntryEvent Start = null;

        static {
            EntryEvent r100 = new EntryEvent("Start", 0);
            Start = r100;
            EntryEvent r101 = new EntryEvent("End", 1);
            End = r101;
            EntryEvent r102 = new EntryEvent("Skip", 2);
            Skip = r102;
            $VALUES = new EntryEvent[]{r100, r101, r102};
        }

        public static EntryEvent valueOf(String r100) {
            return (EntryEvent) a.a(EntryEvent.class, r100);
        }

        public static EntryEvent[] values() {
            return (EntryEvent[]) $VALUES.clone();
        }

        private EntryEvent(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/sti/framework/IIconModel$EntryView;", "", "view", "Landroid/view/View;", "displayDuration", "", "clipToBounds", "", "(Landroid/view/View;JZ)V", "getClipToBounds", "()Z", "getDisplayDuration", "()J", "getView", "()Landroid/view/View;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "livedynamic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EntryView {
        private final boolean clipToBounds;
        private final long displayDuration;
        private final View view;

        public static /* synthetic */ EntryView copy$default(EntryView r100, View r101, long r102, boolean r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.view;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.displayDuration;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.clipToBounds;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final View component1() {
            return this.view;
        }

        public final long component2() {
            return this.displayDuration;
        }

        public final boolean component3() {
            return this.clipToBounds;
        }

        public final EntryView copy(View r100, long r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            return new EntryView(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof EntryView) == false) goto L12;
            EntryView r101 = (EntryView) r100;
            if (Intrinsics.areEqual(this.view, r101.view) == true) goto L8;
            return false;
        L8:
            if (this.displayDuration == r101.displayDuration) goto L10;
            return false;
        L10:
            if (this.clipToBounds == r101.clipToBounds) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        public int hashCode() {
            View r100 = this.view;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            long r102 = this.displayDuration;
            int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            boolean r104 = this.clipToBounds;
            ?? r105 = r104;
            if (r104 == false) goto L10;
            r105 = 1;
        L10:
            return r103 + r105;
        L5:
            r101 = 0;
            goto L6
        }

        public String toString() {
            return "EntryView(view=" + this.view + ", displayDuration=" + this.displayDuration + ", clipToBounds=" + this.clipToBounds + ")";
        }

        public final boolean getClipToBounds() {
            return this.clipToBounds;
        }

        public final long getDisplayDuration() {
            return this.displayDuration;
        }

        public final View getView() {
            return this.view;
        }

        public EntryView(View r100, long r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.view = r100;
            this.displayDuration = r101;
            this.clipToBounds = r102;
        }

        public /* synthetic */ EntryView(View r100, long r101, boolean r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 2) == 0) goto L6;
            r101 = 1000;
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = true;
        L8:
            this(r100, r101, r102);
        }
    }

    void applyState(STATE r100, STATE r101, IconTemplate r102);

    EntryView getBigCardEntryViewForState();

    long getDynamicPriorityShortTouch();

    EntryView getEntryViewForState(STATE r100, STATE r101);

    String getIconDesc();

    int getIconHeight();

    int getIconWidth();

    STATE getInitialState();

    int getTypeId();

    IconTemplate getViewForState(STATE r100);

    boolean isEnhancedStyleShortTouch();

    void onAppear();

    void onClick();

    void onCreate(IIconService<STATE> r100);

    void onDestroy();

    void onEntryEvent(EntryView r100, EntryEvent r101);

    void onHideTempState();

    void onShowTempState(int r100);

    void setIconHeight(int r100);

    void setIconWidth(int r100);
}
