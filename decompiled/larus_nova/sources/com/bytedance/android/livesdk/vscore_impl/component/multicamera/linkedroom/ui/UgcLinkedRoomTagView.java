package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSLinkedRoomInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSLinkedRoomNode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vr1.u;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/multicamera/linkedroom/ui/UgcLinkedRoomTagView;", "Landroid/widget/FrameLayout;", "", "getDefaultText", "()Ljava/lang/String;", "defaultText", "", "getIconMarginLeft", "()I", "iconMarginLeft", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Style", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UgcLinkedRoomTagView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f159741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f159742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HSImageView f159743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f159744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f159745e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f159746f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f159747g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f159748h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DataCenter f159749i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public IRoom f159750j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f159751k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f159752l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CompositeDisposable f159753m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/multicamera/linkedroom/ui/UgcLinkedRoomTagView$Style;", "", "ENTRANCE_WITH_TITLE", "ENTRANCE_WITHOUT_TITLE", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Style extends Enum<Style> {
        public static final Style ENTRANCE_WITHOUT_TITLE = null;
        public static final Style ENTRANCE_WITH_TITLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Style[] f159754a = null;

        static {
            Style r100 = new Style("ENTRANCE_WITH_TITLE", 0);
            ENTRANCE_WITH_TITLE = r100;
            Style r101 = new Style("ENTRANCE_WITHOUT_TITLE", 1);
            ENTRANCE_WITHOUT_TITLE = r101;
            f159754a = new Style[]{r100, r101};
        }

        public static Style valueOf(String r100) {
            return (Style) r27.a.a(Style.class, r100);
        }

        public static Style[] values() {
            return (Style[]) f159754a.clone();
        }

        public Style(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public UgcLinkedRoomTagView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public UgcLinkedRoomTagView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final String getDefaultText() {
        return s1.B(R.string.ttlive_linked_rooms);
    }

    private final int getIconMarginLeft() {
        if (PadConfigUtils.c() == false) goto L6;
        return UtilityKotlinExtentionsKt.i(22);
    L6:
        return UtilityKotlinExtentionsKt.i(12);
    }

    public final void a(DataCenter r100) {
        this.f159749i = r100;
        py.k r101 = null;
        u r102 = r.u(r100, null, 2);
        if (r102 == null) goto L5;
        IRoom r103 = r102.k2();
    L6:
        this.f159750j = r103;
        boolean r104 = false;
        if (r103 == null) goto L17;
        EpisodeExtraInfo r105 = lu2.c.a(r103);
        if (r105 == null) goto L17;
        VSLinkedRoomInfo r106 = r105.getVsLinkedRoomInfo();
        if (r106 == null) goto L17;
        String r107 = r106.getProjectName();
        if (r107 == null) goto L17;
        if (r107.length() <= 0) goto L17;
        boolean r108 = true;
    L18:
        if (r108 == false) goto L29;
        if (r103 == null) goto L25;
        EpisodeExtraInfo r109 = lu2.c.a(r103);
        if (r109 == null) goto L25;
        VSLinkedRoomInfo r110 = r109.getVsLinkedRoomInfo();
        if (r110 == null) goto L25;
        Boolean r111 = r110.isMainRoom();
    L27:
        if (Intrinsics.areEqual(r111, Boolean.FALSE) == false) goto L29;
        boolean r112 = true;
    L30:
        if (r112 == false) goto L32;
        Style r113 = Style.ENTRANCE_WITH_TITLE;
    L33:
        ViewGroup r114 = this.f159744d;
        if (r114 == null) goto L36;
        UtilityKotlinExtentionsKt.w(r114);
    L36:
        int r115 = q.f159777a[r113.ordinal()];
        if (r115 == 1) goto L67;
        if (r115 != 2) goto L120;
        ViewGroup r116 = this.f159741a;
        if (r116 == null) goto L43;
        UtilityKotlinExtentionsKt.t(r116);
    L43:
        View r117 = this.f159747g;
        if (r117 == null) goto L46;
        UtilityKotlinExtentionsKt.w(r117);
    L46:
        View r118 = this.f159748h;
        if (r118 == null) goto L49;
        UtilityKotlinExtentionsKt.t(r118);
    L49:
        TextView r119 = this.f159745e;
        if (r119 == null) goto L52;
        r119.setMaxEms(4);
    L52:
        TextView r120 = this.f159745e;
        if (r120 == null) goto L55;
        r120.setTextSize(1, 13.0f);
    L55:
        View r121 = this.f159746f;
        if (r121 == null) goto L58;
        r121.setBackgroundResource(R.drawable.ttlive_bg_linked_rooms_full);
    L58:
        ViewGroup r122 = this.f159744d;
        if (r122 == null) goto L61;
        a1.p(r122, -1);
    L61:
        ViewGroup r123 = this.f159744d;
        if (r123 == null) goto L64;
        r123.setPadding(UtilityKotlinExtentionsKt.i(12), 0, 0, 0);
    L64:
        TextView r124 = this.f159745e;
        if (r124 == null) goto L120;
        r124.setTypeface(Typeface.DEFAULT_BOLD);
    L120:
        IRoom r125 = this.f159750j;
        if (r125 == null) goto L128;
        EpisodeExtraInfo r126 = lu2.c.a(r125);
        if (r126 == null) goto L128;
        VSLinkedRoomInfo r127 = r126.getVsLinkedRoomInfo();
        if (r127 == null) goto L128;
        String r128 = r127.getTitle();
        if (r128 == null) goto L128;
    L129:
        TextView r129 = this.f159745e;
        if (r129 != null) goto L132;
    L137:
        r.z().h(this.f159749i, this.f159752l);
        return;
    L132:
        if (r128.length() != 0) goto L134;
        r104 = true;
    L134:
        if (r104 == false) goto L136;
        r128 = "相关直播";
    L136:
        r129.setText(r128);
    L128:
        r128 = "";
        goto L129
    L67:
        ViewGroup r130 = this.f159741a;
        if (r130 == null) goto L70;
        UtilityKotlinExtentionsKt.w(r130);
    L70:
        View r131 = this.f159747g;
        if (r131 == null) goto L73;
        UtilityKotlinExtentionsKt.t(r131);
    L73:
        TextView r132 = this.f159742b;
        if (r132 == null) goto L85;
        IRoom r133 = this.f159750j;
        if (r133 == null) goto L83;
        EpisodeExtraInfo r134 = lu2.c.a(r133);
        if (r134 == null) goto L83;
        VSLinkedRoomInfo r135 = r134.getVsLinkedRoomInfo();
        if (r135 == null) goto L83;
        String r136 = r135.getProjectName();
        if (r136 == null) goto L83;
    L84:
        r132.setText(r136);
    L83:
        r136 = getDefaultText();
    L85:
        HSImageView r137 = this.f159743c;
        if (r137 == null) goto L88;
        a1.m(r137, getIconMarginLeft());
    L88:
        ViewGroup r138 = this.f159744d;
        if (r138 == null) goto L91;
        a1.p(r138, this.f159751k);
    L91:
        ViewGroup r139 = this.f159744d;
        if (r139 == null) goto L94;
        r139.setPadding(UtilityKotlinExtentionsKt.i(10), 0, UtilityKotlinExtentionsKt.i(10), 0);
    L94:
        TextView r140 = this.f159745e;
        if (r140 == null) goto L97;
        r140.setTextSize(1, 12.0f);
    L97:
        View r141 = this.f159746f;
        if (r141 == null) goto L100;
        a1.p(r141, this.f159751k);
    L100:
        View r142 = this.f159748h;
        if (r142 == null) goto L103;
        UtilityKotlinExtentionsKt.w(r142);
    L103:
        IRoom r143 = this.f159750j;
        if (r143 == null) goto L117;
        EpisodeExtraInfo r144 = lu2.c.a(r143);
        if (r144 == null) goto L117;
        VSLinkedRoomInfo r145 = r144.getVsLinkedRoomInfo();
        if (r145 == null) goto L117;
        List<VSLinkedRoomNode> r146 = r145.getRooms();
        if (r146 == null) goto L117;
        VSLinkedRoomNode r147 = (VSLinkedRoomNode) ListProtector.get(r146, 0);
        if (r147 == null) goto L117;
        HSImageView r148 = this.f159743c;
        IBaseUser r149 = r147.getOwner();
        if (r149 == null) goto L116;
        r101 = r149.getAvatarMedium();
    L116:
        ImageLoader.bindAvatar(r148, r101, UtilityKotlinExtentionsKt.i(33), UtilityKotlinExtentionsKt.i(33));
    L117:
        View r150 = this.f159746f;
        if (r150 == null) goto L120;
        r150.setBackgroundResource(R.drawable.ttlive_bg_linked_rooms_section);
        goto L120
    L32:
        r113 = Style.ENTRANCE_WITHOUT_TITLE;
    L25:
        r111 = null;
    L29:
        r112 = false;
    L17:
        r108 = false;
        goto L18
    L5:
        r103 = null;
        goto L6
    }

    public UgcLinkedRoomTagView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f159751k = UtilityKotlinExtentionsKt.i(108);
        this.f159752l = UtilityKotlinExtentionsKt.i(36);
        this.f159753m = new CompositeDisposable();
        LayoutInflater.from(r100).inflate(R.layout.ttlive_vs_ugc_linked_room_tag, this);
        this.f159741a = (ViewGroup) findViewById(R.id.title_container);
        this.f159742b = (TextView) findViewById(R.id.title_text);
        this.f159743c = (HSImageView) findViewById(R.id.title_avatar);
        this.f159744d = (ViewGroup) findViewById(R.id.linked_room_container);
        this.f159745e = (TextView) findViewById(R.id.linked_room_text);
        ImageView r103 = (ImageView) findViewById(R.id.linked_image);
        this.f159746f = findViewById(R.id.linked_room_mask);
        this.f159747g = findViewById(R.id.arrow_img);
        this.f159748h = findViewById(R.id.linked_room_divider);
        if (Build.VERSION.SDK_INT <= 26) goto L5;
        setFocusable(1);
    L5:
        ViewCompat.setAccessibilityDelegate(this, new UgcLinkedRoomTagView$setupAccessibility$1(this));
    }

    public /* synthetic */ UgcLinkedRoomTagView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
