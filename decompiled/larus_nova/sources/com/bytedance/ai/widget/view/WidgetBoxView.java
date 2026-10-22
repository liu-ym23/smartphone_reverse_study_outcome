package com.bytedance.ai.widget.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ai.utils.h;
import com.bytedance.ai.utils.i;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0003?@AB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0002J\b\u0010$\u001a\u00020!H\u0002J \u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020\fJ\u0010\u0010-\u001a\u00020!2\b\u0010.\u001a\u0004\u0018\u00010\u0017J\b\u0010/\u001a\u0004\u0018\u00010\u0017J\u0010\u00100\u001a\u00020!2\b\u00101\u001a\u0004\u0018\u00010\u0019J\u0010\u00102\u001a\u00020!2\u0006\u00103\u001a\u000204H\u0014J\u0012\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u00109\u001a\u0004\u0018\u00010:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0016\u0010=\u001a\u0004\u0018\u00010:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010<¨\u0006B"}, d2 = {"Lcom/bytedance/ai/widget/view/WidgetBoxView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/ai/utils/IMotionProvider;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "titleBar", "Landroid/view/View;", ItemStyle.ITEM_STYLE_DIVIDER, "appIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "appName", "Landroid/widget/TextView;", "floatTitleBar", "floatAppIcon", "floatAppName", "contentView", "debugOverlayDrawable", "Landroid/graphics/drawable/Drawable;", "touchEventCallback", "Lcom/bytedance/ai/widget/view/WidgetBoxView$TouchEventCallback;", "longPressController", "Lcom/bytedance/ai/utils/IWidgetLongPressController;", "getLongPressController", "()Lcom/bytedance/ai/utils/IWidgetLongPressController;", "setLongPressController", "(Lcom/bytedance/ai/utils/IWidgetLongPressController;)V", "setBorder", "", "backgroundColor", "strokeColor", "applyTheme", "setTitleBar", "name", "", "iconUrl", "titleType", "Lcom/bytedance/ai/widget/view/WidgetBoxView$TitleType;", "setContent", "view", "setDebugOverlay", "drawable", "getDebugOverlay", "listenTouchEvent", "callback", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "lastMotionX", "", "getLastMotionX", "()Ljava/lang/Float;", "lastMotionY", "getLastMotionY", "TouchEventCallback", "TitleType", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WidgetBoxView extends LinearLayout implements h {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float f38060l = 0.0f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f38061m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f38062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f38063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f38064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f38065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f38066e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SimpleDraweeView f38067f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f38068g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinearLayout f38069h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Drawable f38070i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f38071j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public i f38072k;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/widget/view/WidgetBoxView$TitleType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", EffectConstants.NORMAL, "FLOAT", UserProfileEvent.POSITION_NONE, "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TitleType extends Enum<TitleType> {
        public static final TitleType FLOAT = null;
        public static final TitleType NONE = null;
        public static final TitleType NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TitleType[] f38073a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f38074b = null;
        private final int value;

        public static EnumEntries<TitleType> getEntries() {
            return f38074b;
        }

        static {
            TitleType r100 = new TitleType(EffectConstants.NORMAL, 0, 0);
            NORMAL = r100;
            TitleType r101 = new TitleType("FLOAT", 1, 1);
            FLOAT = r101;
            TitleType r102 = new TitleType(UserProfileEvent.POSITION_NONE, 2, 2);
            NONE = r102;
            TitleType[] r103 = {r100, r101, r102};
            f38073a = r103;
            f38074b = EnumEntriesKt.enumEntries(r103);
        }

        public static TitleType[] values() {
            return (TitleType[]) f38073a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static TitleType valueOf(String r100) {
            return (TitleType) r27.a.a(TitleType.class, r100);
        }

        public TitleType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
    }

    public interface b {
        boolean onTouchEvent(MotionEvent r100);
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38075a = null;

        static {
            int[] r100 = new int[TitleType.values().length];
            r100[TitleType.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[TitleType.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[TitleType.FLOAT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f38075a = r100;
        }
    }

    public WidgetBoxView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public WidgetBoxView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    static {
        f38060l = n2.a.a(8);
        f38061m = n2.a.a(1);
    }

    @Override // com.bytedance.ai.utils.h
    public Float getLastMotionX() {
        i r100 = this.f38072k;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLastMotionX();
    }

    @Override // com.bytedance.ai.utils.h
    public Float getLastMotionY() {
        i r100 = this.f38072k;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLastMotionY();
    }

    public final Drawable getDebugOverlay() {
        return this.f38070i;
    }

    public final i getLongPressController() {
        return this.f38072k;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        Drawable r101 = this.f38070i;
        if (r101 == null) goto L6;
        r101.setBounds(0, 0, getWidth(), getHeight());
        r101.draw(r100);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        b r101 = this.f38071j;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r103 == false) goto L12;
        MotionEvent r104 = MotionEvent.obtain(r100);
        r104.setAction(3);
        super.dispatchTouchEvent(r104);
        r104.recycle();
        return true;
    L12:
        i r105 = this.f38072k;
        if (r105 != null) goto L15;
    L17:
        if (r102 == false) goto L21;
        MotionEvent r106 = MotionEvent.obtain(r100);
        r106.setAction(3);
        super.dispatchTouchEvent(r106);
        r106.recycle();
        return true;
    L21:
        return super.dispatchTouchEvent(r100);
    L15:
        if (r105.dispatchTouchEvent(r100) != true) goto L17;
        r102 = true;
        goto L17
    L5:
        if (r101.onTouchEvent(r100) != true) goto L7;
        r103 = true;
        goto L9
    }

    public final void setContent(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f38069h.addView(r100, -1, -2);
    }

    public final void setDebugOverlay(Drawable r100) {
        Drawable r101 = this.f38070i;
        if (r101 != r100) goto L6;
        return;
    L6:
        if (r101 == null) goto L8;
        r101.setCallback(null);
    L8:
        if (r100 == null) goto L10;
        r100.setCallback(this);
    L11:
        this.f38070i = r100;
        invalidate();
        return;
    L10:
        r100 = null;
        goto L11
    }

    public final void setLongPressController(i r100) {
        this.f38072k = r100;
    }

    public WidgetBoxView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.applet_widget_box_view, this, true);
        setOrientation(1);
        this.f38062a = findViewById(R.id.title_bar);
        this.f38063b = findViewById(R.id.divider);
        this.f38064c = (SimpleDraweeView) findViewById(R.id.app_icon);
        this.f38065d = (TextView) findViewById(R.id.app_name);
        this.f38066e = findViewById(R.id.float_title_bar);
        this.f38067f = (SimpleDraweeView) findViewById(R.id.float_app_icon);
        this.f38068g = (TextView) findViewById(R.id.float_app_name);
        this.f38069h = (LinearLayout) findViewById(R.id.widget_content);
    }

    public /* synthetic */ WidgetBoxView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
