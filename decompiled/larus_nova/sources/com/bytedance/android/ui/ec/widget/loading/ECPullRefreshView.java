package com.bytedance.android.ui.ec.widget.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/loading/ECPullRefreshView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "refreshTextConfig", "Lcom/bytedance/android/ui/ec/widget/loading/RefreshTextConfig;", "statusTextView", "Landroid/widget/TextView;", "initLayoutParams", "", "initViews", "setRefreshState", "targetState", "Lcom/bytedance/android/ui/ec/widget/loading/ECPullRefreshView$RefreshState;", "setRefreshTextConfig", "Companion", "RefreshState", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPullRefreshView extends LinearLayout {
    public static final Companion Companion = null;
    private static final float LOAD_REFRESH_TEXT_SIZE = 12.0f;
    private RefreshTextConfig refreshTextConfig;
    private TextView statusTextView;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/loading/ECPullRefreshView$Companion;", "", "()V", "LOAD_REFRESH_TEXT_SIZE", "", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/loading/ECPullRefreshView$RefreshState;", "", "(Ljava/lang/String;I)V", "PULL", "REFRESHING", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum RefreshState extends Enum<RefreshState> {
        private static final /* synthetic */ RefreshState[] $VALUES = null;
        public static final RefreshState PULL = null;
        public static final RefreshState REFRESHING = null;

        static {
            RefreshState r100 = new RefreshState("PULL", 0);
            PULL = r100;
            RefreshState r101 = new RefreshState("REFRESHING", 1);
            REFRESHING = r101;
            $VALUES = new RefreshState[]{r100, r101};
        }

        public static RefreshState valueOf(String r100) {
            return (RefreshState) a.a(RefreshState.class, r100);
        }

        public static RefreshState[] values() {
            return (RefreshState[]) $VALUES.clone();
        }

        private RefreshState(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[RefreshState.values().length];
            $EnumSwitchMapping$0 = r100;
            r100[RefreshState.PULL.ordinal()] = 1;
            r100[RefreshState.REFRESHING.ordinal()] = 2;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ECPullRefreshView(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public ECPullRefreshView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    private final void initViews() {
        addView(new ECDuxLoadingAnimationView(getContext(), null, 0, 6, null));
        TextView r100 = new TextView(getContext());
        r100.setTextSize(1, 12.0f);
        r100.setTextColor(ContextCompat.getColor(r100.getContext(), R.color.ec_dux_black_161823_60));
        Unit r101 = Unit.INSTANCE;
        this.statusTextView = r100;
        addView(r100);
        setRefreshState(RefreshState.REFRESHING);
    }

    private final void initLayoutParams() {
        ViewGroup.LayoutParams r100 = getLayoutParams();
        if (r100 == null) goto L5;
        r100.width = -2;
        r100.height = -2;
        setLayoutParams(r100);
    L5:
        setOrientation(0);
    }

    public final void setRefreshState(RefreshState r100) {
        Intrinsics.checkNotNullParameter(r100, "targetState");
        int r101 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        if (r101 != 1) goto L5;
        TextView r102 = this.statusTextView;
        if (r102 == null) goto L22;
        CharSequence r103 = this.refreshTextConfig.getPullText();
        if (r103 != null) goto L18;
        r103 = getContext().getString(R.string.ec_pull_refresh);
    L18:
        r102.setText(r103);
        return;
    L22:
        return;
    L5:
        if (r101 != 2) goto L23;
        TextView r104 = this.statusTextView;
        if (r104 == null) goto L20;
        CharSequence r105 = this.refreshTextConfig.getLoadingText();
        if (r105 != null) goto L12;
        r105 = getContext().getString(R.string.ec_is_refreshing);
    L12:
        r104.setText(r105);
        return;
    L20:
        return;
    }

    public final void setRefreshTextConfig(RefreshTextConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "refreshTextConfig");
        this.refreshTextConfig = r100;
    }

    public ECPullRefreshView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.refreshTextConfig = new RefreshTextConfig(null, null, 3, null);
        initLayoutParams();
        setGravity(17);
        initViews();
    }

    public /* synthetic */ ECPullRefreshView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
