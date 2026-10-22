package com.bytedance.android.window.shop.widget;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class ClickSeparatedTabSelectListener implements ECTabLayout.OnTabSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<ECTabLayout.Tab, Boolean> f189822a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/widget/ClickSeparatedTabSelectListener$ActionType;", "", "SCROLL", "CLICK", UserProfileEvent.POSITION_NONE, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ActionType extends Enum<ActionType> {
        public static final ActionType CLICK = null;
        public static final ActionType NONE = null;
        public static final ActionType SCROLL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ActionType[] f189823a = null;

        static {
            ActionType r100 = new ActionType("SCROLL", 0);
            SCROLL = r100;
            ActionType r101 = new ActionType("CLICK", 1);
            CLICK = r101;
            ActionType r102 = new ActionType(UserProfileEvent.POSITION_NONE, 2);
            NONE = r102;
            f189823a = new ActionType[]{r100, r101, r102};
        }

        public static ActionType valueOf(String r100) {
            return (ActionType) r27.a.a(ActionType.class, r100);
        }

        public static ActionType[] values() {
            return (ActionType[]) f189823a.clone();
        }

        public ActionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public void a(ECTabLayout.Tab r100, ActionType r101) {
        Intrinsics.checkNotNullParameter(r101, ReportConstant.COMMON_ACTION_TYPE);
    }

    public abstract void b(ECTabLayout.Tab r100, ActionType r101);

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final void onTabReselected(ECTabLayout.Tab r100) {
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final /* synthetic */ void onTabSelected(ECTabLayout.Tab r100, boolean r101) {
        ECTabLayout.BaseOnTabSelectedListener.CC.$default$onTabSelected(this, r100, r101);
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final void onTabUnselected(ECTabLayout.Tab r100) {
    }

    public ClickSeparatedTabSelectListener() {
        this.f189822a = new LinkedHashMap();
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final void onTabSelected(ECTabLayout.Tab r100) {
        Map<ECTabLayout.Tab, Boolean> r101 = this.f189822a;
        if (r101 == null) goto L27;
        boolean r102 = Intrinsics.areEqual((Boolean) TypeIntrinsics.asMutableMap(r101).remove(r100), Boolean.TRUE);
        if (r100 == null) goto L7;
        ECTabLayout.TabView r103 = r100.view;
    L8:
        if (r103 == null) goto L10;
        Object r104 = r103.getTag();
    L12:
        if ((r104 instanceof ActionType) == true) goto L14;
        r104 = null;
    L14:
        ActionType r105 = (ActionType) r104;
        if (r105 != null) goto L19;
        if (r102 == false) goto L18;
        r105 = ActionType.CLICK;
        goto L19
    L18:
        r105 = ActionType.SCROLL;
    L19:
        if (r100 == null) goto L21;
        ECTabLayout.TabView r106 = r100.view;
    L22:
        if (r106 == null) goto L24;
        r106.setTag(null);
    L24:
        b(r100, r105);
        return;
    L21:
        r106 = null;
        goto L22
    L10:
        r104 = null;
        goto L12
    L7:
        r103 = null;
        goto L8
    L27:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }
}
