package com.bytedance.android.livesdk.interactivity.interactive.dialog.framework;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdk.utils.t2;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.ttm.player.MediaPlayer;
import i40.c;
import i40.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import k82.d;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u00021\fB'\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020\u0011¢\u0006\u0004\b/\u00100J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR$\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00118\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R3\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00180\u0017j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0018`\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR7\u0010\"\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0017j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u001f`\u00198\u0006¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001dR\u0014\u0010%\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0013\u0010)\u001a\u0004\u0018\u00010&8F¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u00062"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/framework/VSInputPanelSectionContainer;", "Landroid/widget/FrameLayout;", "Li40/c;", "", "Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/framework/VSInputSectionType;", "sections", "", "setSupportSections", "", "block", "setCanBlockTouchEvent", "<set-?>", "b", "Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/framework/VSInputSectionType;", "getCurrentSectionType", "()Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/framework/VSInputSectionType;", "currentSectionType", "", "e", "I", "getKeyboardHeight", "()I", "keyboardHeight", "Ljava/util/HashMap;", "Lk82/d;", "Lkotlin/collections/HashMap;", "h", "Ljava/util/HashMap;", "getSectionProviders", "()Ljava/util/HashMap;", "sectionProviders", "Lk82/c;", RXScreenCaptureService.KEY_INDEX, "getSectionControllers", "sectionControllers", "getSupportKeyboard", "()Z", "supportKeyboard", "Landroid/view/View;", "getCurrentSectionView", "()Landroid/view/View;", "currentSectionView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSInputPanelSectionContainer extends FrameLayout implements c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f137221k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<VSInputSectionType> f137222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VSInputSectionType f137223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VSInputSectionType f137224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f137225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f137226e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k82.a f137227f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<VSInputSectionType, View> f137228g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap<VSInputSectionType, d> f137229h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashMap<VSInputSectionType, k82.c> f137230i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f137231j;

    public static final class a {
    }

    public interface b {
        void a(VSInputSectionType r100, VSInputSectionType r101);
    }

    public VSInputPanelSectionContainer(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VSInputPanelSectionContainer(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    static {
        f137221k = UtilityKotlinExtentionsKt.i(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME);
    }

    private final boolean getSupportKeyboard() {
        return this.f137222a.contains(VSInputSectionType.KEYBOARD);
    }

    public final void c() {
        Iterator<Map.Entry<VSInputSectionType, View>> r100 = this.f137228g.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        UtilityKotlinExtentionsKt.t(r100.next().getValue());
        goto L4
    }

    public final View getCurrentSectionView() {
        return this.f137228g.get(this.f137223b);
    }

    public final VSInputSectionType getCurrentSectionType() {
        return this.f137223b;
    }

    public final int getKeyboardHeight() {
        return this.f137226e;
    }

    public final HashMap<VSInputSectionType, k82.c> getSectionControllers() {
        return this.f137230i;
    }

    public final HashMap<VSInputSectionType, d> getSectionProviders() {
        return this.f137229h;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f137225d == false) goto L6;
        return true;
    L6:
        return super.onInterceptTouchEvent(r100);
    }

    public final void setCanBlockTouchEvent(boolean r100) {
        this.f137225d = r100;
    }

    public final void setSupportSections(Set<? extends VSInputSectionType> r100) {
        Intrinsics.checkNotNullParameter(r100, "sections");
        removeAllViews();
        this.f137222a.clear();
        this.f137222a.add(VSInputSectionType.NONE);
        this.f137222a.addAll(r100);
    }

    @Override // i40.c
    public final void X6(boolean r100, int r101) {
        if (r100 == false) goto L22;
        int r102 = 0;
        if (r101 >= s1.w()) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == true) goto L9;
    L18:
        VSInputSectionType r104 = this.f137223b;
        VSInputSectionType r105 = this.f137224c;
        VSInputSectionType r106 = VSInputSectionType.KEYBOARD;
        if (r105 != r106) goto L21;
        this.f137224c = VSInputSectionType.NONE;
    L21:
        this.f137223b = r106;
        c();
        UtilityKotlinExtentionsKt.t(this);
        b(r104, this.f137223b);
        return;
    L9:
        if (VSSettingKeys.LIVE_INPUT_KEYBOARD_HEIGHT_STATUS_BAR_ADJUST.getValue().booleanValue() == false) goto L12;
        r102 = StatusBarUtil.getStatusBarHeight(getContext());
    L12:
        if (this.f137226e > 0) goto L14;
        this.f137226e = r101 - r102;
    L14:
        k82.a r107 = this.f137227f;
        if (r107 == null) goto L17;
        r107.v();
        e<Integer> r108 = nq1.d.f520113v;
        Integer r109 = Integer.valueOf(this.f137226e);
        r108.getClass();
        f.d(r108, r109);
        goto L18
    L17:
        e<Integer> r110 = nq1.d.f520114w;
        Integer r111 = Integer.valueOf(this.f137226e);
        r110.getClass();
        f.d(r110, r111);
        goto L18
    L6:
        r103 = false;
        goto L7
    L22:
        VSInputSectionType r112 = this.f137223b;
        VSInputSectionType r113 = VSInputSectionType.KEYBOARD;
        if (r112 != r113) goto L30;
        View r114 = this.f137228g.get(this.f137224c);
        if (r114 == null) goto L27;
        UtilityKotlinExtentionsKt.w(r114);
    L27:
        this.f137223b = this.f137224c;
        this.f137224c = VSInputSectionType.NONE;
        UtilityKotlinExtentionsKt.w(this);
        b(r113, this.f137223b);
        return;
    }

    public final void a(h82.b r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "panelBridge");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        VSInputSectionType r102 = r101.b();
        View r103 = r101.g(r100);
        if (r103 != null) goto L6;
        return;
    L6:
        if (this.f137222a.contains(r102) == true) goto L10;
        r101.h(r102, r103);
        return;
    L10:
        if (this.f137228g.get(r102) == null) goto L12;
        return;
    L12:
        this.f137227f = r100;
        this.f137229h.put(r102, r101);
        this.f137228g.put(r102, r103);
        this.f137230i.put(r102, r101.c());
        addView(r103);
        r103.setVisibility(8);
    }

    public final void b(VSInputSectionType r100, VSInputSectionType r101) {
        d r102 = this.f137229h.get(r101);
        if (r102 == null) goto L5;
        r102.e();
    L5:
        d r103 = this.f137229h.get(r100);
        if (r103 == null) goto L8;
        r103.a();
    L8:
        Iterator<b> r104 = this.f137231j.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        b r105 = r104.next();
        View r106 = this.f137228g.get(r100);
        View r107 = this.f137228g.get(r101);
        r105.a(r100, r101);
        goto L10
    }

    public VSInputPanelSectionContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        VSInputSectionType r103 = VSInputSectionType.NONE;
        this.f137222a = SetsKt.hashSetOf(new VSInputSectionType[]{r103});
        this.f137223b = r103;
        this.f137224c = r103;
        this.f137228g = new HashMap();
        this.f137229h = new HashMap();
        this.f137230i = new HashMap();
        this.f137231j = new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
        d(this, r103, null, 4);
    }

    public /* synthetic */ VSInputPanelSectionContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void d(VSInputPanelSectionContainer r100, VSInputSectionType r101, EditText r102, int r103) {
        EditText r104 = null;
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        boolean r105 = true;
    L9:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "sectionType");
        if (r100.f137222a.contains(r101) == false) goto L43;
        VSInputSectionType r106 = r100.f137223b;
        if (r106 == r101) goto L44;
        r100.f137224c = r101;
        if (r102 != null) goto L20;
        k82.a r107 = r100.f137227f;
        if (r107 == null) goto L21;
        r104 = r107.f502082a;
    L21:
        h.a("switch to section: " + r101.getTypeName() + ", current panel: " + r100.f137223b.getTypeName());
        int r108 = k82.b.f502089a[r101.ordinal()];
        if (r108 != 1) goto L24;
        r100.f137223b = VSInputSectionType.NONE;
        if (r100.getSupportKeyboard() == false) goto L38;
        t2.a(r100.getContext(), r104);
    L38:
        UtilityKotlinExtentionsKt.t(r100);
        return;
    L24:
        if (r108 != 2) goto L26;
        t2.b(r100.getContext(), r104);
        return;
    L26:
        if (r100.f137223b != VSInputSectionType.KEYBOARD) goto L28;
        t2.a(r100.getContext(), r104);
        return;
    L28:
        r100.c();
        if (r105 == false) goto L33;
        View r109 = r100.f137228g.get(r100.f137224c);
        if (r109 == null) goto L33;
        UtilityKotlinExtentionsKt.w(r109);
    L33:
        r100.f137224c = VSInputSectionType.NONE;
        r100.f137223b = r101;
        UtilityKotlinExtentionsKt.w(r100);
        r100.b(r106, r101);
        return;
    L20:
        r104 = r102;
        goto L21
    L44:
        return;
    L43:
        return;
    L8:
        r105 = false;
        goto L9
    }
}
