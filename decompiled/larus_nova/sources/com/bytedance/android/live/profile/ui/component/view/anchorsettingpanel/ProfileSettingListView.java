package com.bytedance.android.live.profile.ui.component.view.anchorsettingpanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u000fH\u0002J\u0006\u0010\u001c\u001a\u00020\u000fJ\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\u0012\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u000e\u0010!\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000bJ)\u0010\"\u001a\u00020\u000f2!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000f0\nJ\u0012\u0010$\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002R+\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/anchorsettingpanel/ProfileSettingListView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "itemClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "tagInt", "", "items", "", "Lcom/bytedance/android/live/profile/ui/component/view/anchorsettingpanel/ProfileNewSettingItemView;", RootDescription.ROOT_ELEMENT, "Landroid/widget/LinearLayout;", "createItem", "itemTag", "itemText", "", "isChecked", "", "init", "layout", "spaceWidth", SendEventContainerMethodParamModel.EventKinds.onClick, "view", "Landroid/view/View;", "setItemChecked", "setItemClickListener", "action", "setSpaceAdaptation", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProfileSettingListView extends FrameLayout {
    private Function1<? super Long, Unit> itemClickListener;
    private final Map<Long, ProfileNewSettingItemView> items;
    private LinearLayout root;

    public final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f86851a;

        public a(Function1 r100) {
            this.f86851a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final /* synthetic */ void onClick(View r100) {
            this.f86851a.invoke(r100);
        }
    }

    public ProfileSettingListView(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public ProfileSettingListView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    public final void layout() {
        int r100 = this.items.size();
        if (r100 != 2) goto L5;
        layout(UtilityKotlinExtentionsKt.i(60));
        return;
    L5:
        if (r100 != 3) goto L11;
        layout(UtilityKotlinExtentionsKt.i(40));
        return;
    }

    private final void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_profile_anchor_setting_panel_list_view, this, true);
        this.root = (LinearLayout) findViewById(R.id.root);
    }

    private final void layout(int r100) {
        Iterator<Map.Entry<Long, ProfileNewSettingItemView>> r101 = this.items.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Map.Entry<Long, ProfileNewSettingItemView> r102 = r101.next();
        LinearLayout r103 = this.root;
        if (r103 == null) goto L8;
        r103.addView(new Space(getContext()), new LinearLayout.LayoutParams(r100, 1));
    L8:
        LinearLayout r104 = this.root;
        if (r104 == null) goto L4;
        r104.addView(r102.getValue());
        goto L4
    L11:
        LinearLayout r105 = this.root;
        if (r105 == null) goto L14;
        r105.addView(new Space(getContext()));
    L14:
        LinearLayout r106 = this.root;
        int r107 = 0;
        View r108 = null;
        if (r106 == null) goto L17;
        View r109 = r106.getChildAt(0);
    L18:
        setSpaceAdaptation(r109);
        LinearLayout r110 = this.root;
        if (r110 == null) goto L23;
        if (r110 == null) goto L22;
        r107 = r110.getChildCount();
    L22:
        r108 = r110.getChildAt(r107 - 1);
    L23:
        setSpaceAdaptation(r108);
        return;
    L17:
        r109 = null;
        goto L18
    }

    private final void onClick(View r100) {
        Object r101 = null;
        if ((r100 instanceof ProfileNewSettingItemView) == true) goto L5;
        r100 = null;
    L5:
        ProfileNewSettingItemView r102 = (ProfileNewSettingItemView) r100;
        if (r102 != null) goto L8;
        return;
    L8:
        Object r103 = r102.getTag();
        if ((r103 instanceof Long) == false) goto L12;
        r101 = r103;
    L12:
        Long r104 = (Long) r101;
        if (r104 == null) goto L32;
        long r105 = r104.longValue();
        if (r102.f86847a == false) goto L17;
        return;
    L17:
        r102.setCheckState(true);
        Iterator<Map.Entry<Long, ProfileNewSettingItemView>> r106 = this.items.entrySet().iterator();
    L19:
        if (r106.hasNext() == false) goto L23;
        Map.Entry<Long, ProfileNewSettingItemView> r107 = r106.next();
        if (r107.getKey().longValue() == r105) goto L19;
        r107.getValue().setCheckState(false);
        goto L19
    L23:
        Function1<? super Long, Unit> r108 = this.itemClickListener;
        if (r108 == null) goto L33;
        Unit r109 = r108.invoke(Long.valueOf(r105));
        return;
    L33:
        return;
    }

    private final void setSpaceAdaptation(View r100) {
        ViewGroup.LayoutParams r101 = null;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
    L7:
        if ((r102 instanceof LinearLayout.LayoutParams) == false) goto L10;
        r101 = r102;
    L10:
        LinearLayout.LayoutParams r103 = (LinearLayout.LayoutParams) r101;
        if (r103 != null) goto L13;
        return;
    L13:
        r103.width = 0;
        r103.weight = 1.0f;
        r100.setLayoutParams(r103);
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final void setItemChecked(long r100) {
        Iterator<Map.Entry<Long, ProfileNewSettingItemView>> r101 = this.items.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        Map.Entry<Long, ProfileNewSettingItemView> r102 = r101.next();
        ProfileNewSettingItemView r103 = r102.getValue();
        if (r102.getKey().longValue() != r100) goto L8;
        boolean r104 = true;
    L9:
        r103.setCheckState(r104);
        goto L4
    L8:
        r104 = false;
        goto L9
    }

    public final void setItemClickListener(Function1<? super Long, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.itemClickListener = r100;
    }

    public static final /* synthetic */ void access$onClick(ProfileSettingListView r100, View r101) {
        r100.onClick(r101);
    }

    public ProfileSettingListView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.items = new LinkedHashMap();
        init();
    }

    public final long createItem(long r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "itemText");
        ProfileNewSettingItemView r103 = new ProfileNewSettingItemView(getContext(), null, 6, 0);
        Intrinsics.checkNotNullParameter(r101, "text");
        TextView r104 = r103.f86850d;
        if (r104 == null) goto L5;
        r104.setText(r101);
    L5:
        r103.setCheckState(r102);
        r103.setOnClickListener(new a(new ProfileSettingListView$createItem$item$1$1(this)));
        r103.setTag(Long.valueOf(r100));
        this.items.put(Long.valueOf(r100), r103);
        return r100;
    }

    public /* synthetic */ ProfileSettingListView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }

    public static /* synthetic */ long createItem$default(ProfileSettingListView r100, long r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = false;
    L6:
        return r100.createItem(r101, r102, r103);
    }
}
