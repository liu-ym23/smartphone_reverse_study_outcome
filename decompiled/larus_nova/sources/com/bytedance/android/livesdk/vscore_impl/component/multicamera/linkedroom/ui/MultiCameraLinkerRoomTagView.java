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
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.MultiCameraLinkedRoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.RoomKt;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSLinkedRoomInfo;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.MultiCameraBasicInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vr1.u;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/multicamera/linkedroom/ui/MultiCameraLinkerRoomTagView;", "Landroid/widget/FrameLayout;", "", "getCameraDefaultText", "()Ljava/lang/String;", "cameraDefaultText", "", "getTabsEntranceWidth", "()I", "tabsEntranceWidth", "getIconMarginLeft", "iconMarginLeft", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Location", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiCameraLinkerRoomTagView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f159687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f159688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HSImageView f159689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f159690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f159691e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f159692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DataCenter f159693g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IRoom f159694h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CompositeDisposable f159695i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/multicamera/linkedroom/ui/MultiCameraLinkerRoomTagView$Location;", "", "TABS_ENTRANCE", "NO_TABS_ENTRANCE", "PANEL", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Location extends Enum<Location> {
        public static final Location NO_TABS_ENTRANCE = null;
        public static final Location PANEL = null;
        public static final Location TABS_ENTRANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Location[] f159696a = null;

        static {
            Location r100 = new Location("TABS_ENTRANCE", 0);
            TABS_ENTRANCE = r100;
            Location r101 = new Location("NO_TABS_ENTRANCE", 1);
            NO_TABS_ENTRANCE = r101;
            Location r102 = new Location("PANEL", 2);
            PANEL = r102;
            f159696a = new Location[]{r100, r101, r102};
        }

        public static Location valueOf(String r100) {
            return (Location) r27.a.a(Location.class, r100);
        }

        public static Location[] values() {
            return (Location[]) f159696a.clone();
        }

        public Location(String r100, int r101) {
            super(r100, r101);
        }
    }

    public MultiCameraLinkerRoomTagView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MultiCameraLinkerRoomTagView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final String getCameraDefaultText() {
        return s1.B(R.string.ttlive_vs_camera_text_default);
    }

    private final int getIconMarginLeft() {
        if (PadConfigUtils.c() == false) goto L6;
        return UtilityKotlinExtentionsKt.i(22);
    L6:
        return UtilityKotlinExtentionsKt.i(12);
    }

    private final int getTabsEntranceWidth() {
        if (PadConfigUtils.c() == false) goto L6;
        return UtilityKotlinExtentionsKt.i(108);
    L6:
        return UtilityKotlinExtentionsKt.i(100);
    }

    public final void a(Location r100) {
        int r101 = j.f159766a[r100.ordinal()];
        if (r101 != 1) goto L5;
        HSImageView r102 = this.f159689c;
        if (r102 == null) goto L27;
        a1.m(r102, getIconMarginLeft());
    L27:
        a1.p(this, getTabsEntranceWidth());
        TextView r103 = this.f159688b;
        if (r103 == null) goto L30;
        r103.setTextSize(1, 12.0f);
    L30:
        TextView r104 = this.f159692f;
        if (r104 == null) goto L34;
        r104.setTextSize(1, 12.0f);
    L34:
        if (PadConfigUtils.c() == true) goto L41;
        View r105 = this.f159690d;
        if (r105 == null) goto L42;
        r105.setTranslationX(0.0f);
        r105.setTranslationY(0.0f);
        a1.n(r105, UtilityKotlinExtentionsKt.i(4));
        a1.o(r105, UtilityKotlinExtentionsKt.i(4));
        return;
    L42:
        return;
    L41:
        return;
    L5:
        if (r101 != 2) goto L7;
    L9:
        TextView r106 = this.f159688b;
        if (r106 == null) goto L12;
        r106.setMaxEms(4);
    L12:
        TextView r107 = this.f159692f;
        if (r107 == null) goto L15;
        r107.setMaxEms(4);
    L15:
        TextView r108 = this.f159688b;
        if (r108 == null) goto L18;
        r108.setTextSize(1, 13.0f);
    L18:
        TextView r109 = this.f159692f;
        if (r109 == null) goto L21;
        r109.setTextSize(1, 13.0f);
    L21:
        TextView r110 = this.f159688b;
        if (r110 == null) goto L39;
        r110.setTypeface(Typeface.DEFAULT_BOLD);
        return;
    L39:
        return;
    L7:
        if (r101 == 3) goto L9;
    }

    public final boolean b(DataCenter r100, final Location r101) {
        Intrinsics.checkNotNullParameter(r101, "location");
        this.f159693g = r100;
        ViewModel r102 = null;
        u r103 = r.u(r100, null, 2);
        if (r103 == null) goto L5;
        IRoom r104 = r103.k2();
    L6:
        this.f159694h = r104;
        boolean r105 = false;
        if (RoomKt.hasMultiCamera(r104) == false) goto L71;
        ViewGroup r106 = this.f159687a;
        if (r106 == null) goto L11;
        UtilityKotlinExtentionsKt.w(r106);
    L11:
        ViewGroup r107 = this.f159691e;
        if (r107 == null) goto L14;
        UtilityKotlinExtentionsKt.t(r107);
    L14:
        IRoom r108 = this.f159694h;
        if (r108 == null) goto L98;
        EpisodeExtraInfo r109 = lu2.c.a(r108);
        if (r109 == null) goto L19;
        MultiCameraBasicInfo r110 = r109.getMultiCameraBasicInfo();
    L20:
        if (r110 == null) goto L26;
        py.k r111 = r110.getIcon();
        if (r111 == null) goto L26;
        if (r111.isValid() != true) goto L26;
        ImageUtil.loadImage(this.f159689c, r110.getIcon(), 0);
    L30:
        if (RoomKt.hasMultiCamera(this.f159694h) == true) goto L32;
    L35:
        EpisodeExtraInfo r112 = lu2.c.a(r108);
        if (r112 == null) goto L38;
        String r113 = r112.getCameraInfosTableTitle();
    L39:
        TextView r114 = this.f159688b;
        if (r114 == null) goto L46;
        if (r113 != null) goto L44;
        r113 = getCameraDefaultText();
    L44:
        r114.setText(r113);
    L46:
        if (lu2.b.j(this.f159694h) == true) goto L48;
    L66:
        View r115 = this.f159690d;
        if (r115 == null) goto L69;
        UtilityKotlinExtentionsKt.t(r115);
    L69:
        a(r101);
        return true;
    L48:
        if (r101 == Location.PANEL) goto L66;
        u r116 = r.u(this.f159693g, null, 2);
        if (r116 == null) goto L54;
        com.bytedance.live.datacontext.j<ViewModel> r117 = r116.E();
        if (r117 == null) goto L54;
        ViewModel r118 = r117.getValue();
    L56:
        if ((r118 instanceof MultiCameraLinkedRoomContext) == false) goto L59;
        r102 = r118;
    L59:
        MultiCameraLinkedRoomContext r119 = (MultiCameraLinkedRoomContext) r102;
        if (r119 == null) goto L69;
        com.bytedance.live.datacontext.m<Boolean> r120 = r119.getOpenPanelFromUser();
        if (r120 == null) goto L69;
        Disposable r121 = i80.a.a(r120, new MultiCameraLinkerRoomTagView$showMultiCamera$$inlined$let$lambda$1(this, r101));
        if (r121 == null) goto L69;
        RxUtilKt.c(r121, this.f159695i);
    L54:
        r118 = null;
    L38:
        r113 = null;
        goto L39
    L32:
        if (lu2.c.b(this.f159694h) == false) goto L35;
        if (r110 == null) goto L38;
        r113 = r110.getName();
    L26:
        HSImageView r122 = this.f159689c;
        if (r122 == null) goto L30;
        r122.setActualImageResource(R.drawable.ttlive_icon_multi_camera);
        goto L30
    L19:
        r110 = null;
        goto L20
    L98:
        return true;
    L71:
        if (lu2.c.b(this.f159694h) == false) goto L96;
        ViewGroup r123 = this.f159691e;
        if (r123 == null) goto L75;
        UtilityKotlinExtentionsKt.w(r123);
    L75:
        ViewGroup r124 = this.f159687a;
        if (r124 == null) goto L78;
        UtilityKotlinExtentionsKt.t(r124);
    L78:
        IRoom r125 = this.f159694h;
        if (r125 == null) goto L100;
        EpisodeExtraInfo r126 = lu2.c.a(r125);
        if (r126 == null) goto L86;
        VSLinkedRoomInfo r127 = r126.getVsLinkedRoomInfo();
        if (r127 == null) goto L86;
        String r128 = r127.getTitle();
        if (r128 == null) goto L86;
    L87:
        TextView r129 = this.f159692f;
        if (r129 != null) goto L90;
    L95:
        a(r101);
        return true;
    L90:
        if (r128.length() != 0) goto L92;
        r105 = true;
    L92:
        if (r105 == false) goto L94;
        r128 = "相关直播";
    L94:
        r129.setText(r128);
    L86:
        r128 = "";
        goto L87
    L100:
        return true;
    L96:
        return false;
    L5:
        r104 = null;
        goto L6
    }

    public MultiCameraLinkerRoomTagView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f159695i = new CompositeDisposable();
        LayoutInflater.from(r100).inflate(R.layout.ttlive_vs_linked_camera_tag, this);
        this.f159687a = (ViewGroup) findViewById(R.id.camera_container);
        this.f159688b = (TextView) findViewById(R.id.camera_text);
        this.f159689c = (HSImageView) findViewById(R.id.camera_icon);
        this.f159690d = findViewById(R.id.paid_tips);
        this.f159691e = (ViewGroup) findViewById(R.id.linked_room_container);
        this.f159692f = (TextView) findViewById(R.id.linked_room_text);
        ImageView r103 = (ImageView) findViewById(R.id.linked_image);
        SimpleDraweeView r104 = (SimpleDraweeView) findViewById(R.id.living_view);
        if (Build.VERSION.SDK_INT <= 26) goto L5;
        setFocusable(1);
    L5:
        ViewCompat.setAccessibilityDelegate(this, new MultiCameraLinkerRoomTagView$setupAccessibility$1(this));
    }

    public /* synthetic */ MultiCameraLinkerRoomTagView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
