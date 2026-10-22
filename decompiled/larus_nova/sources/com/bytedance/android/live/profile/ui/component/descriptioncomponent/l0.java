package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.core.view.GravityCompat;
import com.bytedance.android.live.base.model.user.DressSuitInfo;
import com.bytedance.android.live.base.model.user.DressVisitorInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.base.model.user.VisitorStatistic;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.i2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.model.EnterExitStateType;
import com.bytedance.android.live.profile.p004enum.TrackArea;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.room.api.view.SimpleIndicatorTextSwitcher;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.tencent.connect.common.Constants;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes47.dex */
public final class l0 extends com.bytedance.android.live.profile.ui.base.k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f86551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f86552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f86553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SimpleIndicatorTextSwitcher f86554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f86555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f86556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f86557h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Context f86558i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Disposable f86559j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Disposable f86560k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f86561l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f86562m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f86563n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f86564o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f86565p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.android.live.profile.ui.base.h f86566q;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l0 f86567a;

        public a(l0 r100) {
            this.f86567a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.profile.model.a r101 = (com.bytedance.android.live.profile.model.a) r100;
            if (r101 != null) goto L6;
            return;
        L6:
            if (r101.f86063a != EnterExitStateType.ENTER_END) goto L23;
            Disposable r102 = this.f86567a.f86560k;
            Disposable r103 = null;
            if (r102 != null) goto L10;
        L15:
            this.f86567a.f86560k = Observable.timer(1, TimeUnit.SECONDS).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k0(this));
            Disposable r104 = this.f86567a.f86559j;
            if (r104 != null) goto L18;
            return;
        L18:
            if ((!r104.isDisposed()) == false) goto L20;
            r103 = r104;
        L20:
            if (r103 == null) goto L25;
            r103.dispose();
            return;
        L25:
            return;
        L10:
            if ((!r102.isDisposed()) == true) goto L13;
            r102 = null;
        L13:
            if (r102 == null) goto L15;
            r102.dispose();
            goto L15
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l0 f86568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HashMap f86569b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ NewProfileUser f86570c;

        public b(l0 r100, HashMap r101, NewProfileUser r102) {
            this.f86568a = r100;
            this.f86569b = r101;
            this.f86570c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            String r100 = null;
            this.f86568a.f86566q.recordBusinessClick("visitor_entrance", null);
            if (this.f86568a.getContext() == null) goto L37;
            boolean r101 = false;
            this.f86568a.f86566q.sendLog("livesdk_profile_card_visitor_entrance_click", this.f86569b, new Object[0]);
            l0 r111 = this.f86568a;
            Context r102 = r111.getContext();
            NewProfileUser r103 = this.f86570c;
            if (r102 == null) goto L38;
            DressVisitorInfo r104 = r103.dressVisitorInfo;
            String r105 = "";
            if (r104 == null) goto L11;
            String r106 = r104.jumpSchema;
            if (r106 == null) goto L11;
        L12:
            Uri r107 = UriProtector.parse(r106);
            String r108 = UriProtector.getQueryParameter(r107, "url");
            if (r108 != null) goto L15;
            r108 = "";
        L15:
            Uri.Builder r109 = UriProtector.parse(r108).buildUpon();
            DressSuitInfo r112 = r103.getDressSuitInfo();
            if (r112 == null) goto L18;
            String r113 = r112.getUserSuitId();
        L19:
            if (r113 != null) goto L21;
        L22:
            r101 = true;
        L23:
            if (r101 == false) goto L25;
            r100 = "none";
        L29:
            r109.appendQueryParameter(Constants.PACKAGE_ID, r100);
            UserProfileEvent r114 = r111.f86566q.getUserProfileEvent();
            if (r114 == null) goto L35;
            String r115 = r114.mClickUserPosition;
            if (r115 == null) goto L35;
            r105 = r115;
        L35:
            r109.appendQueryParameter("click_user_position", r105);
            ((IBaseLiveActionHandler) jc1.k.n(IBaseLiveActionHandler.class)).handle(r102, i2.e(r107, "url").buildUpon().appendQueryParameter("url", r109.build().toString()).build().toString());
            return;
        L25:
            DressSuitInfo r116 = r103.getDressSuitInfo();
            if (r116 == null) goto L28;
            r100 = r116.getUserSuitId();
        L28:
            Intrinsics.checkNotNull(r100);
            goto L29
        L21:
            if (r113.length() != 0) goto L23;
        L18:
            r113 = null;
        L11:
            r106 = "";
            goto L12
        L38:
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l0 f86571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HashMap f86572b;

        public c(l0 r100, HashMap r101) {
            this.f86571a = r100;
            this.f86572b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f86571a.f86566q.recordBusinessClick("visitor_entrance", null);
            f2.b(R.string.ttlive_profile_toast_visitor_count_locked, 0);
            this.f86571a.f86566q.sendLog("livesdk_profile_card_visitor_entrance_click", this.f86572b, new Object[0]);
        }
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        Disposable r100 = this.f86559j;
        Disposable r101 = null;
        if (r100 != null) goto L5;
    L10:
        Disposable r102 = this.f86560k;
        if (r102 != null) goto L13;
        return;
    L13:
        if ((!r102.isDisposed()) == false) goto L15;
        r101 = r102;
    L15:
        if (r101 == null) goto L19;
        r101.dispose();
        return;
    L19:
        return;
    L5:
        if ((!r100.isDisposed()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        r100.dispose();
        goto L10
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.VisitorCount.INSTANCE;
    }

    public final Context getContext() {
        return this.f86558i;
    }

    public l0(com.bytedance.android.live.profile.profilecontext.a r100) {
        Intrinsics.checkNotNullParameter(r100, "profileContext");
        this.f86566q = r100;
        this.f86561l = ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE;
        this.f86562m = "red_dot";
        this.f86563n = "visitor_number";
        this.f86564o = "click_user_position";
        this.f86565p = Constants.PACKAGE_ID;
    }

    public static String j(long r100) {
        if (r100 <= 9999) goto L10;
        double r101 = Math.round((r100 / ((double) 10000)) * ((double) 100)) / 100.0d;
        if ((r101 % ((double) 1)) == AudioStats.AUDIO_AMPLITUDE_NONE) goto L11;
        StringBuilder r102 = new StringBuilder();
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        r102.append(StringsKt.trimEnd(StringsKt.trimEnd(String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r101)}, 1)), new char[]{'0'}), new char[]{'.'}));
        r102.append("万");
        return r102.toString();
    L11:
        return String.valueOf((int) r101) + "万";
    L10:
        return String.valueOf(r100);
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r100) {
        this.f86558i = r100.getContext();
        if (ProfilePreInflateUtil.a() == false) goto L5;
        View r101 = ((com.bytedance.android.live.profile.ui.base.e) r100).b(ProfilePreInflateViewInfo.TTLIVE_PROFILE_VISITOR_COUNT, true);
    L6:
        View r102 = null;
        if (r101 == null) goto L9;
        SimpleIndicatorTextSwitcher r103 = (SimpleIndicatorTextSwitcher) r101.findViewById(R.id.ttlive_visitor_count);
    L10:
        this.f86554e = r103;
        if (r101 == null) goto L13;
        ImageView r104 = (ImageView) r101.findViewById(R.id.ttlive_profile_visitor_count_locked_icon);
    L14:
        this.f86551b = r104;
        if (r101 == null) goto L17;
        TextView r105 = (TextView) r101.findViewById(R.id.ttlive_visitor_count_text);
    L18:
        this.f86552c = r105;
        if (r101 == null) goto L21;
        TextView r106 = (TextView) r101.findViewById(R.id.ttlive_visitor_locked_text);
    L22:
        this.f86553d = r106;
        if (r101 == null) goto L25;
        View r107 = r101.findViewById(R.id.ttlive_right_arrow);
    L26:
        this.f86555f = r107;
        if (r101 == null) goto L29;
        View r108 = r101.findViewById(R.id.ttlive_visitor_count_button);
    L30:
        this.f86556g = r108;
        if (r101 == null) goto L33;
        r102 = r101.findViewById(R.id.ttlive_visitor_count_yellow_dot);
    L33:
        this.f86557h = r102;
        SimpleIndicatorTextSwitcher r109 = this.f86554e;
        if (r109 == null) goto L37;
        r109.setAnimateFirstView(false);
        return;
    L37:
        return;
    L29:
        r108 = null;
        goto L30
    L25:
        r107 = null;
        goto L26
    L21:
        r106 = null;
        goto L22
    L17:
        r105 = null;
        goto L18
    L13:
        r104 = null;
        goto L14
    L9:
        r103 = null;
        goto L10
    L5:
        r101 = ((com.bytedance.android.live.profile.ui.base.e) r100).f(R.layout.ttlive_profile_v3_visitor_count_layout, true);
        goto L6
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        this.f86566q.recordBusinessShow(TrackArea.TopWhiteArea, "visitor_entrance");
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r110) {
        Intrinsics.checkNotNullParameter(r110, "user");
        ProfileSkin r100 = r110.mProfileSkin;
        if (r100 == null) goto L7;
        ProfileCustomSkin r101 = r100.skin;
        if (r101 == null) goto L7;
        String r102 = r101.visitorButtonColor;
    L8:
        View r103 = this.f86556g;
        if (r103 == null) goto L11;
        com.bytedance.android.live.profile.ui.util.m.f(r103, r102);
    L11:
        HashMap r104 = new HashMap();
        String r105 = this.f86564o;
        UserProfileEvent r106 = this.f86566q.getUserProfileEvent();
        if (r106 == null) goto L15;
        String r107 = r106.mClickUserPosition;
        if (r107 == null) goto L15;
    L16:
        r104.put(r105, r107);
        String r108 = this.f86565p;
        DressSuitInfo r109 = r110.getDressSuitInfo();
        if (r109 == null) goto L19;
        String r111 = r109.getUserSuitId();
    L21:
        if (r111 != null) goto L23;
    L26:
        boolean r112 = true;
    L27:
        if (r112 == false) goto L29;
        String r113 = "none";
    L34:
        r104.put(r108, r113);
        DressVisitorInfo r114 = r110.dressVisitorInfo;
        if (r114 == null) goto L37;
        Integer r115 = Integer.valueOf(r114.buttonStatus);
    L38:
        if (r115 == null) goto L46;
        if (r115.intValue() != 0) goto L46;
        View r116 = this.f86556g;
        if (r116 == null) goto L175;
        r116.setVisibility(8);
    L175:
        this.f86566q.sendLog("livesdk_profile_card_visitor_entrance_show", r104, new Object[0]);
        return;
    L46:
        if (r115 != null) goto L49;
    L153:
        if (r115 == null) goto L175;
        if (r115.intValue() != 2) goto L175;
        r104.put(this.f86562m, "0");
        r104.put(this.f86561l, "unavailable");
        String r117 = this.f86563n;
        DressVisitorInfo r118 = r110.dressVisitorInfo;
        if (r118 == null) goto L162;
        VisitorStatistic r119 = r118.visitorStatistic;
        if (r119 == null) goto L162;
        long r120 = r119.visitorCount;
    L163:
        r104.put(r117, String.valueOf(r120));
        ImageView r121 = this.f86551b;
        if (r121 == null) goto L166;
        r121.setVisibility(0);
    L166:
        TextView r122 = this.f86553d;
        if (r122 == null) goto L169;
        r122.setVisibility(0);
    L169:
        TextView r123 = this.f86553d;
        if (r123 == null) goto L172;
        r123.setText(s1.B(R.string.ttlive_profile_visitor_count_visible_locked));
    L172:
        View r124 = this.f86556g;
        if (r124 == null) goto L175;
        r124.setOnClickListener(new c(this, r104));
    L162:
        r120 = 0;
        goto L163
    L49:
        if (r115.intValue() != 1) goto L153;
        com.bytedance.android.live.profile.ui.util.w.a r125 = com.bytedance.android.live.profile.ui.util.w.f86964a;
        Context r126 = this.f86558i;
        r125.getClass();
        if (r126 != null) goto L54;
    L56:
        boolean r127 = false;
    L57:
        if (r127 == false) goto L68;
        TextView r128 = this.f86552c;
        if (r128 == null) goto L61;
        r128.setVisibility(0);
    L61:
        View r129 = this.f86555f;
        if (r129 == null) goto L64;
        r129.setVisibility(0);
    L64:
        TextView r130 = this.f86552c;
        if (r130 == null) goto L67;
        r130.setText(s1.B(R.string.ttlive_profile_visitor_count_visible_first_show));
    L67:
        r104.put(this.f86561l, "unlock");
        SharedPrefHelper r131 = SharedPrefHelper.b(this.f86558i);
        r131.l("live.pref.PREF_PROFILE_VISITOR_COUNT_ENTRANCE_FIRST_SHOW", 1);
        r131.a();
        r104.put(this.f86562m, "0");
    L144:
        String r132 = this.f86563n;
        DressVisitorInfo r133 = r110.dressVisitorInfo;
        if (r133 == null) goto L149;
        VisitorStatistic r134 = r133.visitorStatistic;
        if (r134 == null) goto L149;
        long r135 = r134.visitorCount;
    L150:
        r104.put(r132, String.valueOf(r135));
        View r136 = this.f86556g;
        if (r136 == null) goto L175;
        r136.setOnClickListener(new b(this, r104, r110));
    L149:
        r135 = 0;
        goto L150
    L68:
        TextView r137 = this.f86552c;
        if (r137 == null) goto L71;
        r137.setVisibility(0);
    L71:
        SimpleIndicatorTextSwitcher r138 = this.f86554e;
        if (r138 == null) goto L74;
        r138.setVisibility(0);
    L74:
        View r139 = this.f86555f;
        if (r139 == null) goto L77;
        r139.setVisibility(0);
    L77:
        TextView r140 = this.f86552c;
        if (r140 == null) goto L80;
        r140.setText(s1.B(R.string.ttlive_profile_visitor_count_visible_show));
    L80:
        r104.put(this.f86561l, "visitor");
        DressVisitorInfo r141 = r110.dressVisitorInfo;
        if (r141 == null) goto L83;
        int r142 = r141.achievementType;
    L85:
        if (r142 == 0) goto L87;
        boolean r143 = com.bytedance.android.live.profile.ui.util.w.a.a(this.f86558i, "live.pref.PREF_PROFILE_VISITOR_COUNT_ACHIEVEMENT_TYPE" + r142);
    L88:
        if (r143 == false) goto L97;
        View r144 = this.f86557h;
        if (r144 == null) goto L92;
        r144.setVisibility(0);
    L92:
        r104.put(this.f86562m, "1");
        DressVisitorInfo r145 = r110.dressVisitorInfo;
        if (r145 == null) goto L95;
        int r146 = r145.achievementType;
    L96:
        SharedPrefHelper r147 = SharedPrefHelper.b(this.f86558i);
        r147.l("live.pref.PREF_PROFILE_VISITOR_COUNT_ACHIEVEMENT_TYPE" + r146, Long.valueOf(System.currentTimeMillis()));
        r147.a();
    L98:
        Context r148 = this.f86558i;
        if (r148 != null) goto L101;
        long r149 = 0;
    L102:
        DressVisitorInfo r150 = r110.dressVisitorInfo;
        if (r150 == null) goto L107;
        VisitorStatistic r151 = r150.visitorStatistic;
        if (r151 == null) goto L107;
        long r152 = r151.visitorCount;
    L108:
        long r153 = r152 - r149;
        if (com.bytedance.android.live.profile.ui.util.w.a.a(this.f86558i, "live.pref.PREF_PROFILE_VISITOR_COUNT_SHOW_TIME") == false) goto L111;
    L127:
        SimpleIndicatorTextSwitcher r154 = this.f86554e;
        if (r154 == null) goto L143;
        Context r155 = this.f86558i;
        Intrinsics.checkNotNullParameter(r110, "user");
        if (r155 != null) goto L132;
        long r156 = 0;
    L139:
        String r157 = j(r156);
        Intrinsics.checkNotNullParameter(r157, "text1");
        if (r154.getChildCount() == 0) goto L142;
        r154.removeAllViews();
    L142:
        r154.addView(r154.a(r157), 0);
        goto L143
    L132:
        SharedPrefHelper r158 = SharedPrefHelper.b(r155);
        DressVisitorInfo r159 = r110.dressVisitorInfo;
        if (r159 == null) goto L137;
        VisitorStatistic r160 = r159.visitorStatistic;
        if (r160 == null) goto L137;
        r156 = r160.visitorCount;
    L138:
        r158.l("live.pref.PREF_PROFILE_VISITOR_COUNT_SEE_SELF", Long.valueOf(r156));
        r158.a();
    L137:
        r156 = 0;
    L143:
        SharedPrefHelper r161 = SharedPrefHelper.b(this.f86558i);
        r161.l("live.pref.PREF_PROFILE_VISITOR_COUNT_SHOW_TIME", Long.valueOf(System.currentTimeMillis()));
        r161.a();
        goto L144
    L111:
        if (r153 <= 0) goto L127;
        SimpleIndicatorTextSwitcher r162 = this.f86554e;
        if (r162 == null) goto L118;
        String r163 = Marker.ANY_NON_NULL_MARKER + j(r153);
        String r164 = j(r152);
        Intrinsics.checkNotNullParameter(r163, "text1");
        Intrinsics.checkNotNullParameter(r164, "text2");
        if (r162.getChildCount() == 0) goto L117;
        r162.removeAllViews();
    L117:
        TextView r165 = new TextView(r162.getContext());
        r165.setSingleLine();
        r165.setTextSize(1, 15.0f);
        r165.setTextColor(r165.getResources().getColor(R.color.ttlive_profile_new_visitor));
        r165.setText(r163);
        r165.setSingleLine(true);
        r165.setIncludeFontPadding(false);
        r165.setGravity(GravityCompat.END);
        r165.setIncludeFontPadding(false);
        r162.addView(r165, 0);
        r162.addView(r162.a(r164), 1);
    L118:
        Disposable r166 = this.f86559j;
        if (r166 != null) goto L121;
    L126:
        this.f86559j = this.f86566q.getEnterExitState().subscribe(new a(this));
        SharedPrefHelper r167 = SharedPrefHelper.b(this.f86558i);
        r167.l("live.pref.PREF_PROFILE_VISITOR_COUNT_SEE_SELF", Long.valueOf(r152));
        r167.a();
        SharedPrefHelper r168 = SharedPrefHelper.b(this.f86558i);
        r168.l("live.pref.PREF_PROFILE_VISITOR_COUNT_SHOW_TIME", Long.valueOf(System.currentTimeMillis()));
        r168.a();
        goto L144
    L121:
        if ((!r166.isDisposed()) == false) goto L123;
        Disposable r169 = r166;
    L124:
        if (r169 == null) goto L126;
        r169.dispose();
        goto L126
    L123:
        r169 = null;
    L107:
        r152 = 0;
        goto L108
    L101:
        r149 = SharedPrefHelper.b(r148).i("live.pref.PREF_PROFILE_VISITOR_COUNT_SEE_SELF", -1);
        goto L102
    L95:
        r146 = 0;
        goto L96
    L97:
        r104.put(this.f86562m, "0");
        goto L98
    L87:
        r143 = false;
        goto L88
    L83:
        r142 = 0;
        goto L85
    L54:
        if (SharedPrefHelper.b(r126).h("live.pref.PREF_PROFILE_VISITOR_COUNT_ENTRANCE_FIRST_SHOW", -1) != (-1)) goto L56;
        r127 = true;
        goto L57
    L37:
        r115 = null;
        goto L38
    L29:
        DressSuitInfo r170 = r110.getDressSuitInfo();
        if (r170 == null) goto L32;
        r113 = r170.getUserSuitId();
    L33:
        Intrinsics.checkNotNull(r113);
        goto L34
    L32:
        r113 = null;
        goto L33
    L23:
        if (r111.length() == 0) goto L26;
        r112 = false;
        goto L27
    L19:
        r111 = null;
    L15:
        r107 = "";
    L7:
        r102 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r100) {
        Intrinsics.checkNotNullParameter(r100, "newUser");
        ALogger.i("NewUserProfile_ProfilePre", "ProfileVisitorCountComponent update");
    }
}
