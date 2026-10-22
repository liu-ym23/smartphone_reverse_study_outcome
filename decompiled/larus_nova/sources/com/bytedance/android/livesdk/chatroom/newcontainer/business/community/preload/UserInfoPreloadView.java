package com.bytedance.android.livesdk.chatroom.newcontainer.business.community.preload;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fB\u001b\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000e\u0010\u0012B#\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u000e\u0010\u0015J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0003J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/newcontainer/business/community/preload/UserInfoPreloadView;", "Landroid/widget/RelativeLayout;", "Lpy/k;", "avatarThumb", "", "setAvatarThumb", "", "remarkNameOrNickname", "setUserName", "", "isUse", "setViewInUse", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdkshell_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoPreloadView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HSImageView f107416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f107417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f107418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DataCenter f107419d;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserInfoPreloadView f107420a;

        public a(UserInfoPreloadView r100) {
            this.f107420a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            DataCenter r101 = this.f107420a.f107419d;
            if (r101 == null) goto L6;
            r101.put("cmd_has_click_anchor_profile", Boolean.TRUE);
            return;
        }
    }

    public final void b() {
        RelativeLayout.inflate(getContext(), R.layout.ttlive_view_user_info_preload, this);
        this.f107416a = (HSImageView) findViewById(R.id.head);
        this.f107417b = (TextView) findViewById(R.id.user_name);
        View r100 = getRootView();
        if (r100 == null) goto L6;
        r100.setOnClickListener(new a(this));
        return;
    }

    public UserInfoPreloadView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        b();
    }

    private final void setAvatarThumb(k r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (ImageUtil.isActivityOK(getContext()) == false) goto L8;
        FrescoLoader r101 = FrescoLoader.with(getContext()).load(r100).placeholder(R.drawable.ttlive_ic_default_head_small).roundAsCircle().actualScaleType(ImageView.ScaleType.CENTER_CROP);
        int r102 = s1.f(32.0f);
        r101.resize(r102, r102);
        r101.into(this.f107416a);
        return;
    }

    private final void setUserName(String r100) {
        TextView r101 = this.f107417b;
        if (r101 != null) goto L5;
        return;
    L5:
        CharSequence r102 = null;
        if (r101 == null) goto L8;
        CharSequence r103 = r101.getText();
    L10:
        if (TextUtils.isEmpty(r103) == true) goto L17;
        TextView r104 = this.f107417b;
        if (r104 == null) goto L15;
        r102 = r104.getText();
    L15:
        if (TextUtils.equals(r102, r100) == false) goto L17;
        return;
    L17:
        TextView r105 = this.f107417b;
        if (r105 == null) goto L20;
        r105.setText(r100);
    L20:
        TextView r106 = this.f107417b;
        Intrinsics.checkNotNull(r106);
        if (r106.getIncludeFontPadding() == true) goto L27;
        TextView r107 = this.f107417b;
        Intrinsics.checkNotNull(r107);
        boolean r108 = false;
        r107.measure(0, 0);
        TextView r109 = this.f107417b;
        Intrinsics.checkNotNull(r109);
        TextView r110 = this.f107417b;
        Intrinsics.checkNotNull(r110);
        if (r110.getMeasuredHeight() <= s1.f(18.0f)) goto L25;
        r108 = true;
    L25:
        r109.setIncludeFontPadding(r108);
        return;
    L27:
        return;
    L8:
        r103 = null;
        goto L10
    }

    public final void setViewInUse(boolean r100) {
        this.f107418c = r100;
    }

    public UserInfoPreloadView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        b();
    }

    public UserInfoPreloadView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        b();
    }

    public final void a(DataCenter r100, String r101, k r102) {
        this.f107419d = r100;
        setAvatarThumb(r102);
        setUserName(r101);
    }
}
