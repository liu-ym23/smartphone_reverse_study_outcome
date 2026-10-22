package com.bytedance.android.livesdk.dislike.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.config.jm0;
import com.bytedance.android.livesdk.config.m70;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdk.dislike.action.OptionAction;
import com.bytedance.android.livesdk.dislike.action.RecommendToFriendsAction;
import com.bytedance.android.livesdk.dislike.m;
import com.bytedance.android.livesdk.dislike.recommendlive.RecommendLiveHelper;
import com.bytedance.android.livesdk.dislike.y;
import com.bytedance.android.livesdk.widget.CircleImageView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveLongPressPanelItemConfig;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nt1.d;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/layout/RecommendToFriendsLayout;", "Landroid/widget/FrameLayout;", "", "getRecommendStatus", "status", "", "setRecommendStatus", "Lcom/bytedance/android/livesdk/dislike/y;", MapController.ITEM_LAYER_TAG, "update", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecommendToFriendsLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f122146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f122147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CircleImageView f122148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HSImageView f122149d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OptionAction f122150e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f122151f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f122152g;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecommendToFriendsLayout f122153a;

        public a(RecommendToFriendsLayout r100) {
            this.f122153a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            OptionAction r101 = this.f122153a.f122150e;
            if (r101 == null) goto L6;
            r101.b(r100);
            return;
        }
    }

    public RecommendToFriendsLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RecommendToFriendsLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final boolean getRecommendStatus() {
        int r100 = RecommendLiveHelper.f122216a;
        boolean r101 = RecommendLiveHelper.g(this.f122152g);
        setRecommendStatus(r101);
        return r101;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        int r100 = RecommendLiveHelper.f122216a;
        OptionAction r101 = this.f122150e;
        String r102 = null;
        if (r101 == null) goto L5;
        Room r103 = r101.f122048b;
    L6:
        RecommendToFriendsAction r104 = (RecommendToFriendsAction) r101;
        if (r104 != null) goto L9;
    L11:
        String r105 = "not_shared";
    L12:
        if (r104 == null) goto L18;
        ActionsManager r106 = r104.f122053g;
        if (r106 == null) goto L18;
        m r107 = r106.f121950c;
        if (r107 == null) goto L18;
        r102 = r107.a();
    L18:
        RecommendLiveHelper.i(r103, r105, com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK, r102);
        return;
    L9:
        if (r104.f122051e != true) goto L11;
        r105 = "shared";
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r100 = this.f122151f;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    private final void setRecommendStatus(boolean r100) {
        RecommendToFriendsAction r101 = (RecommendToFriendsAction) this.f122150e;
        if (r101 == null) goto L6;
        r101.f122051e = r100;
        return;
    }

    public final void b(boolean r100) {
        CircleImageView r101 = this.f122148c;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        HSImageView r102 = this.f122149d;
        if (r102 == null) goto L8;
        r102.setVisibility(4);
    L8:
        LiveLongPressPanelItemConfig r103 = m70.f120734a.getValue();
        if (r100 == true) goto L19;
        TextView r104 = this.f122146a;
        if (r104 == null) goto L13;
        r104.setText(R.string.ttlive_recommend_to_friends_item_title);
    L13:
        if (r103 == null) goto L29;
        String r105 = r103.getLiveRecommendToFriendText();
        if (r105 == null) goto L29;
        TextView r106 = this.f122146a;
        if (r106 == null) goto L29;
        r106.setText(r105);
    L29:
        if (jm0.f120537a.getValue().getEnable() == false) goto L33;
        TextView r107 = this.f122147b;
        if (r107 == null) goto L33;
        r107.setVisibility(0);
    L33:
        if (r103 == null) goto L39;
        String r108 = r103.getLiveRecommendToFriendDetailTextInRoom();
        if (r108 == null) goto L39;
        TextView r109 = this.f122147b;
        if (r109 == null) goto L39;
        r109.setText(r108);
    L39:
        CircleImageView r110 = this.f122148c;
        if (r110 == null) goto L45;
        if (r100 == false) goto L43;
        int r111 = R.drawable.common_feed_ic_familiar_recommend_cancel_green;
    L44:
        r110.setImageResource(r111);
        goto L45
    L43:
        r111 = R.drawable.common_feed_ic_familiar_recommend_green;
    L45:
        String r112 = null;
        if (r100 == true) goto L49;
        if (r103 == null) goto L51;
        r112 = r103.getLiveRecommendToFriendIcon();
    L51:
        if (r112 == null) goto L60;
        CircleImageView r113 = this.f122148c;
        if (r113 == null) goto L55;
        r113.setVisibility(4);
    L55:
        HSImageView r114 = this.f122149d;
        if (r114 == null) goto L58;
        r114.setVisibility(0);
    L58:
        ImageLoader.bindImage(this.f122149d, r112);
        return;
    L60:
        return;
    L49:
        if (r103 == null) goto L51;
        r112 = r103.getLiveRecommendToFriendRecommendedIcon();
        goto L51
    L19:
        TextView r115 = this.f122146a;
        if (r115 == null) goto L22;
        r115.setText(R.string.ttlive_recommend_live_to_friends_cancel);
    L22:
        if (r103 == null) goto L29;
        String r116 = r103.getLiveRecommendToFriendRecommendedText();
        if (r116 == null) goto L29;
        TextView r117 = this.f122146a;
        if (r117 == null) goto L29;
        r117.setText(r116);
        goto L29
    }

    public final void update(y r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        OptionAction r101 = r100.f122167b;
        this.f122150e = r101;
        if (r101 == null) goto L7;
        Room r102 = r101.f122048b;
        if (r102 == null) goto L7;
        long r103 = r102.getRoomId();
    L8:
        this.f122152g = r103;
        b(getRecommendStatus());
        int r104 = RecommendLiveHelper.f122216a;
        this.f122151f = RecommendLiveHelper.c(this.f122152g, new d(this), "RecommendToFriendsLayout");
        return;
    L7:
        r103 = 0;
        goto L8
    }

    public static final /* synthetic */ void a(RecommendToFriendsLayout r100, boolean r101) {
        r100.setRecommendStatus(r101);
    }

    public RecommendToFriendsLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View.inflate(r100, R.layout.ttlive_dialog_recommend_to_friends_item, this);
        setOnClickListener(new a(this));
        TextView r103 = (TextView) findViewById(R.id.title);
        CircleImageView r104 = null;
        if (r103 == null) goto L5;
        r103.setText(R.string.ttlive_recommend_to_friends_item_title);
        Unit r105 = Unit.INSTANCE;
    L6:
        this.f122146a = r103;
        CircleImageView r106 = (CircleImageView) findViewById(R.id.icon);
        if (r106 == null) goto L9;
        r106.setImageResource(R.drawable.common_feed_ic_familiar_recommend_green);
        Unit r107 = Unit.INSTANCE;
        r104 = r106;
    L9:
        this.f122148c = r104;
        this.f122147b = (TextView) findViewById(R.id.anonymous_title);
        this.f122149d = (HSImageView) findViewById(R.id.config_icon);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public /* synthetic */ RecommendToFriendsLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
