package com.bytedance.android.live.ktv.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J*\u0010\t\u001a\u00020\u00042\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0007R\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/ktv/common/view/LiveOnlineAvatarView;", "Landroid/widget/FrameLayout;", "", "roomId", "", "setRoomId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "map", "setEnterParamMap", "Lcom/bytedance/android/live/core/widget/HSImageView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/live/core/widget/HSImageView;", "getAvatarView", "()Lcom/bytedance/android/live/core/widget/HSImageView;", "avatarView", "Lkotlin/Function0;", "b", "Lkotlin/jvm/functions/Function0;", "getOnClickAvatarCb", "()Lkotlin/jvm/functions/Function0;", "setOnClickAvatarCb", "(Lkotlin/jvm/functions/Function0;)V", "onClickAvatarCb", "Landroid/graphics/Paint;", "c", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveOnlineAvatarView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f70750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f70751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f70752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HashMap<String, String> f70753d;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HSImageView f70754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveOnlineAvatarView f70755b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f70756c;

        public a(HSImageView r100, LiveOnlineAvatarView r101, String r102) {
            this.f70754a = r100;
            this.f70755b = r101;
            this.f70756c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function0<Unit> r101 = this.f70755b.getOnClickAvatarCb();
            if (r101 == null) goto L5;
            Unit r102 = r101.invoke();
        L5:
            String r103 = "sslocal://webcast_room?room_id=" + this.f70756c + "&enter_from_merge=chat&enter_method=ktv_friend_live_link";
            IMiddlewareLiveService r104 = TTLiveServiceMiddleware.getLiveService();
            if (r104 == null) goto L9;
            r104.handleSchema(this.f70754a.getContext(), UriProtector.parse(r103));
            return;
        }
    }

    public final HSImageView getAvatarView() {
        return this.f70750a;
    }

    public final Function0<Unit> getOnClickAvatarCb() {
        return this.f70751b;
    }

    public final Paint getPaint() {
        return this.f70752c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        float r101 = getMeasuredWidth() / 2;
        r100.drawCircle(r101, getMeasuredHeight() / 2, r101, this.f70752c);
    }

    public final void setEnterParamMap(HashMap<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this.f70753d = r100;
    }

    public final void setOnClickAvatarCb(Function0<Unit> r100) {
        this.f70751b = r100;
    }

    public final void setRoomId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        HSImageView r101 = this.f70750a;
        r101.setOnClickListener(new a(r101, this, r100));
    }

    public LiveOnlineAvatarView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        Paint r102 = new Paint();
        r102.setColor(ColorProtector.parseColor("#FF358D"));
        r102.setStyle(Paint.Style.STROKE);
        r102.setTextSize(s1.f(6.0f));
        r102.setStrokeWidth(s1.f(2.0f));
        Unit r103 = Unit.INSTANCE;
        this.f70752c = r102;
        this.f70750a = (HSImageView) View.inflate(r100, R.layout.ttlive_online_avatar_view, this).findViewById(R.id.avatar_image);
    }
}
