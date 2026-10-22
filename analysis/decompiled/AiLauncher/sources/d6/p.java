package d6;

import La.H;
import Y8.t;
import Z8.C1173v;
import Z8.F;
import Z8.M;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.common.imageloader.ImageRequest;
import com.stepos.ailauncher.migu.R$drawable;
import com.stepos.ailauncher.migu.play.C3354b;
import com.stepos.ailauncher.migu.play.C3369q;
import com.stepos.ailauncher.migu.play.C3372u;
import com.stepos.ailauncher.migu.play.MiguCardSurface;
import com.stepos.ailauncher.migu.play.MiguInstallState;
import com.stepos.ailauncher.migu.play.MiguPlayController;
import com.stepos.ailauncher.migu.play.MiguPlaybackProgress;
import com.stepos.ailauncher.migu.play.MiguPlaybackSnapshot;
import com.stepos.ailauncher.migu.play.a0;
import com.stepos.ailauncher.migu.play.g0;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u0083\u00012\u00020\u00012\u00020\u0002:\u000b\u0084\u0001\u0085\u0001\u0016\u0086\u0001\u0014\u0017\u0087\u0001B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0017\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0018\u0010\u0015J\u000f\u0010\u0019\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0019\u0010\u0015J\u0017\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001d\u0010\u0015J\u0017\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\r2\u0006\u0010#\u001a\u00020 H\u0002¢\u0006\u0004\b$\u0010%J\u0011\u0010'\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020&H\u0002¢\u0006\u0004\b,\u0010(J\u000f\u0010-\u001a\u00020\rH\u0002¢\u0006\u0004\b-\u0010\u0015J\u001b\u00100\u001a\u0004\u0018\u00010&2\b\u0010/\u001a\u0004\u0018\u00010.H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\rH\u0002¢\u0006\u0004\b2\u0010\u0015J\u001f\u00106\u001a\u00020&2\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\u0007H\u0002¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020\r2\u0006\u00105\u001a\u00020\u0007H\u0002¢\u0006\u0004\b8\u0010\u001cJ\u0017\u00109\u001a\u00020\r2\u0006\u00105\u001a\u00020\u0007H\u0002¢\u0006\u0004\b9\u0010\u001cJ\u000f\u0010:\u001a\u00020\rH\u0002¢\u0006\u0004\b:\u0010\u0015J\u000f\u0010;\u001a\u00020\rH\u0002¢\u0006\u0004\b;\u0010\u0015J\u001b\u0010>\u001a\u0004\u0018\u00010=2\b\u0010<\u001a\u0004\u0018\u00010.H\u0002¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u0007H\u0002¢\u0006\u0004\bA\u0010\u001cJ\u000f\u0010B\u001a\u00020 H\u0002¢\u0006\u0004\bB\u0010CJ\u0017\u0010D\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u0007H\u0002¢\u0006\u0004\bD\u0010\u001cJ\u000f\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\rH\u0002¢\u0006\u0004\bH\u0010\u0015J\u000f\u0010I\u001a\u00020\rH\u0002¢\u0006\u0004\bI\u0010\u0015J\u000f\u0010J\u001a\u00020\rH\u0002¢\u0006\u0004\bJ\u0010\u0015J\u0017\u0010K\u001a\u00020.2\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\bK\u0010LJ!\u0010P\u001a\u00020\r2\u0006\u0010N\u001a\u00020M2\b\u0010O\u001a\u0004\u0018\u00010.H\u0002¢\u0006\u0004\bP\u0010QJ\u0017\u0010S\u001a\u00020\u00072\u0006\u0010R\u001a\u00020=H\u0002¢\u0006\u0004\bS\u0010TR\u0016\u0010U\u001a\u00020\u000b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010W\u001a\u00020E8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010Y\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010[\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u001a\u0010^\u001a\b\u0012\u0004\u0012\u00020\r0]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010`\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010b\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010d\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010cR\u001a\u0010g\u001a\b\u0012\u0004\u0012\u00020f0e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u001a\u0010j\u001a\b\u0012\u0004\u0012\u00020i0e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010hR\u001c\u0010l\u001a\b\u0012\u0004\u0012\u0002030k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010hR\u0016\u0010m\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010cR\u0016\u0010n\u001a\u00020E8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bn\u0010XR\u0018\u0010p\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010r\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u001a\u0010t\u001a\b\u0012\u0004\u0012\u00020&0e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010hR\u0016\u0010v\u001a\u00020u8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010x\u001a\u00020E8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bx\u0010XR\u0016\u0010z\u001a\u00020y8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010|\u001a\u00020y8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b|\u0010{R\u0014\u0010~\u001a\u00020}8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0018\u0010\u0081\u0001\u001a\u00030\u0080\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001¨\u0006\u0088\u0001"}, d2 = {"Ld6/p;", "LN5/d;", "Lcom/stepos/ailauncher/migu/play/a0;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/widget/FrameLayout;", "container", "LY8/t;", ExifInterface.LONGITUDE_EAST, "(Landroid/widget/FrameLayout;)V", "LN5/n;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "C", "(LN5/n;)V", "c", "()V", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "onAttachedToWindow", "onDetachedFromWindow", "visibility", "onWindowVisibilityChanged", "(I)V", "j0", "Lcom/stepos/ailauncher/migu/play/MiguCardSurface;", "surface", "", "O0", "(Lcom/stepos/ailauncher/migu/play/MiguCardSurface;)Z", "showReply", "Q0", "(Z)V", "Landroid/view/View;", "z0", "()Landroid/view/View;", "Lcom/stepos/ailauncher/migu/play/g0$a;", "w0", "()Lcom/stepos/ailauncher/migu/play/g0$a;", "u0", "E0", "", "title", "o0", "(Ljava/lang/String;)Landroid/view/View;", "I0", "Ld6/q;", "song", "index", "q0", "(Ld6/q;I)Landroid/view/View;", "J0", "S0", "L0", "M0", "playingSongId", "", "K0", "(Ljava/lang/String;)Ljava/lang/Float;", "scrollY", "H0", "N0", "()Z", "U0", "Landroid/widget/LinearLayout;", "m0", "()Landroid/widget/LinearLayout;", "l0", "T0", "R0", "P0", "(Ld6/q;)Ljava/lang/String;", "Landroid/widget/ImageView;", "target", "url", "D0", "(Landroid/widget/ImageView;Ljava/lang/String;)V", UxipConstants.f30680s, "t0", "(F)I", "stack", "Landroid/widget/FrameLayout;", "column", "Landroid/widget/LinearLayout;", "loginCard", "Landroid/view/View;", "storeGuideHolder", "Lcom/stepos/ailauncher/migu/play/g0$a;", "Lkotlin/Function0;", "installObserver", "Lp9/a;", "cardId", "Ljava/lang/String;", "autoPlayStarted", "Z", "autoPlayRequested", "", "Ld6/p$e;", "playButtons", "Ljava/util/List;", "Ld6/p$g;", "playingIndicators", "", "songs", "expanded", "expandBtn", "Landroid/widget/TextView;", "expandLabel", "Landroid/widget/TextView;", "expandChevron", "Landroid/widget/ImageView;", "rowViews", "Ld6/p$c;", "scrollView", "Ld6/p$c;", "listContainer", "Ld6/p$b;", "topFade", "Ld6/p$b;", "bottomFade", "Ljava/lang/Runnable;", "hideScrollbarRunnable", "Ljava/lang/Runnable;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Companion", "e", "f", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_APIKEY, "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class p extends N5.d implements a0 {
    private static final int COLLAPSED_ROWS = 4;
    private static final float HEADER_TEXT_SP = 14.0f;
    private static final long SCROLLBAR_HIDE_DELAY_MS = 1500;
    private static final String TAG = "MiguMusicList";
    private boolean autoPlayRequested;
    private boolean autoPlayStarted;
    private b bottomFade;
    private String cardId;
    private LinearLayout column;
    private LinearLayout expandBtn;
    private ImageView expandChevron;
    private TextView expandLabel;
    private boolean expanded;
    private final Handler handler;
    private final Runnable hideScrollbarRunnable;
    private final InterfaceC5063a<t> installObserver;
    private LinearLayout listContainer;
    private View loginCard;
    private final List<e> playButtons;
    private final List<g> playingIndicators;
    private final List<View> rowViews;
    private c scrollView;
    private List<MusicSongItem> songs;
    private FrameLayout stack;
    private g0.a storeGuideHolder;
    private b topFade;
    private static final int COLOR_CARD_BG = Color.parseColor("#14E4E4F0");
    private static final int COLOR_TEXT_PRIMARY = Color.parseColor("#FFFFFF");
    private static final int COLOR_TEXT_SECONDARY = Color.parseColor("#9A9A9E");
    private static final int COLOR_TEXT_ACTION = Color.parseColor("#9A9A9E");
    private static final int COLOR_PLAY_BG = Color.argb(26, 255, 255, 255);

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\r¨\u0006\u000e"}, d2 = {"Ld6/p$b;", "Landroid/view/View;", "Landroid/content/Context;", "context", "", "bottom", "<init>", "(Landroid/content/Context;Z)V", "Landroid/graphics/Canvas;", "canvas", "LY8/t;", "onDraw", "(Landroid/graphics/Canvas;)V", "Z", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends View {
        private final boolean bottom;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, boolean z10) {
            super(context);
            kotlin.jvm.internal.p.i(context, "context");
            this.bottom = z10;
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, z10 ? new int[]{0, 0, p.COLOR_CARD_BG} : new int[]{p.COLOR_CARD_BG, p.COLOR_CARD_BG, 0});
            gradientDrawable.setCornerRadius(0.0f);
            setBackground(gradientDrawable);
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            kotlin.jvm.internal.p.i(canvas, "canvas");
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\u00020\b2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010\u001eR\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010&R\u0016\u0010(\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010\u000eR\u0018\u0010*\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010 R\u0014\u0010-\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010 R\u0018\u0010.\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R$\u00100\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101¨\u00062"}, d2 = {"Ld6/p$c;", "Landroidx/core/widget/NestedScrollView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "disallow", "LY8/t;", ExifInterface.LONGITUDE_WEST, "(Z)V", "Lkotlin/Function1;", "", "l", "Z", "(Lp9/l;)V", "Landroidx/recyclerview/widget/RecyclerView;", "r", "Y", "(Landroidx/recyclerview/widget/RecyclerView;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "velocityY", "p", "(I)V", "maxHeightPx", "I", "getMaxHeightPx", "()I", "X", "", "lastY", "F", "downX", "downY", "dragAxisDecided", "grabbing", "Ljava/lang/Boolean;", "touchSlop", "axisSlop", "outerRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "scrollListener", "Lp9/l;", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends NestedScrollView {
        private final int axisSlop;
        private float downX;
        private float downY;
        private boolean dragAxisDecided;
        private Boolean grabbing;
        private float lastY;
        private int maxHeightPx;
        private RecyclerView outerRecycler;
        private InterfaceC5074l<? super Integer, t> scrollListener;
        private final int touchSlop;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context) {
            super(context);
            kotlin.jvm.internal.p.i(context, "context");
            this.maxHeightPx = Integer.MAX_VALUE;
            int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
            this.touchSlop = scaledTouchSlop;
            this.axisSlop = C5685n.f(scaledTouchSlop / 2, 1);
        }

        private final void W(boolean disallow) {
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(disallow);
            }
        }

        public final void X(int i10) {
            this.maxHeightPx = i10;
        }

        public final void Y(RecyclerView r10) {
            this.outerRecycler = r10;
        }

        public final void Z(InterfaceC5074l<? super Integer, t> l10) {
            this.scrollListener = l10;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent ev) {
            kotlin.jvm.internal.p.i(ev, "ev");
            int actionMasked = ev.getActionMasked();
            boolean z10 = true;
            if (actionMasked == 0) {
                this.downX = ev.getX();
                this.downY = ev.getY();
                this.lastY = ev.getY();
                this.dragAxisDecided = false;
                this.grabbing = null;
                if (!canScrollVertically(1) && !canScrollVertically(-1)) {
                    z10 = false;
                }
                W(z10);
                C4148a.k(p.TAG, "scroll.down scrollable=" + z10 + " x=" + this.downX + " y=" + this.downY, false, 4, null);
                return super.dispatchTouchEvent(ev);
            }
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    float fAbs = Math.abs(ev.getX() - this.downX);
                    float fAbs2 = Math.abs(ev.getY() - this.downY);
                    if (!this.dragAxisDecided) {
                        int i10 = this.axisSlop;
                        if (fAbs > i10 || fAbs2 > i10) {
                            this.dragAxisDecided = true;
                            Boolean boolValueOf = Boolean.valueOf(fAbs2 > fAbs);
                            this.grabbing = boolValueOf;
                            C4148a.k(p.TAG, "scroll.move.decided grabbing=" + boolValueOf + " dx=" + fAbs + " dy=" + fAbs2 + " axisSlop=" + this.axisSlop, false, 4, null);
                        }
                    }
                    if (!kotlin.jvm.internal.p.d(this.grabbing, Boolean.TRUE)) {
                        W(false);
                        this.lastY = ev.getY();
                        return super.dispatchTouchEvent(ev);
                    }
                    float y10 = ev.getY() - this.lastY;
                    boolean zCanScrollVertically = canScrollVertically(-1);
                    boolean zCanScrollVertically2 = canScrollVertically(1);
                    boolean z11 = y10 > 0.0f ? zCanScrollVertically : zCanScrollVertically2;
                    if (z11) {
                        scrollBy(0, (int) (-y10));
                        C4148a.k(p.TAG, "scroll.manualScrollBy dy=" + y10 + " scrollY=" + getScrollY(), false, 4, null);
                        W(true);
                    } else {
                        W(false);
                    }
                    C4148a.k(p.TAG, "scroll.move.disallow canScrollThisWay=" + z11 + " dy=" + y10 + " canUp=" + zCanScrollVertically + " canDown=" + zCanScrollVertically2, false, 4, null);
                    this.lastY = ev.getY();
                    return true;
                }
                if (actionMasked != 3) {
                    InterfaceC5074l<? super Integer, t> interfaceC5074l = this.scrollListener;
                    if (interfaceC5074l != null) {
                        interfaceC5074l.invoke(Integer.valueOf(getScrollY()));
                    }
                    return super.dispatchTouchEvent(ev);
                }
            }
            C4148a.k(p.TAG, "scroll.up/cancel scrollY=" + getScrollY(), false, 4, null);
            W(false);
            return super.dispatchTouchEvent(ev);
        }

        @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.View
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int i10 = this.maxHeightPx;
            if (i10 != Integer.MAX_VALUE) {
                heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE);
            }
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            C4148a.k(p.TAG, "scroll.measure maxHeightPx=" + this.maxHeightPx + " measured=" + getMeasuredWidth() + "x" + getMeasuredHeight(), false, 4, null);
        }

        @Override // androidx.core.widget.NestedScrollView
        public void p(int velocityY) {
            if (canScrollVertically(velocityY > 0 ? 1 : -1)) {
                super.p(velocityY);
                return;
            }
            RecyclerView recyclerView = this.outerRecycler;
            if (recyclerView != null) {
                recyclerView.fling(0, velocityY);
            }
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ld6/p$d;", "Landroid/view/View;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/graphics/Canvas;", "canvas", "LY8/t;", "onDraw", "(Landroid/graphics/Canvas;)V", "", "density", "F", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends View {
        private final float density;
        private final Paint paint;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context) {
            super(context);
            kotlin.jvm.internal.p.i(context, "context");
            this.density = getResources().getDisplayMetrics().density;
            Paint paint = new Paint(1);
            paint.setColor(p.COLOR_TEXT_PRIMARY);
            paint.setStyle(Paint.Style.FILL);
            this.paint = paint;
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            kotlin.jvm.internal.p.i(canvas, "canvas");
            f.INSTANCE.a(canvas, this.paint, getWidth() / 2.0f, getHeight() / 2.0f, this.density);
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 92\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\u0013J/\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0013R*\u0010\u0019\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u00188\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R*\u0010%\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u00188\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001eR\u0014\u0010(\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010 R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010+R\u0014\u0010-\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010+R\u0014\u0010.\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010+R\u0014\u0010/\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010+R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006:"}, d2 = {"Ld6/p$e;", "Landroid/view/View;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/graphics/Canvas;", "canvas", "LY8/t;", "onDraw", "(Landroid/graphics/Canvas;)V", "", UxipConstants.f30680s, Const.INTENT_KEY_APIKEY, "(F)F", "cx", "cy", ContentDisposition.Parameters.Size, Const.INTENT_KEY_UMID, "(Landroid/graphics/Canvas;FFF)V", ConstConfig.KEY_VIEW_SCALE_PROPERTY, Const.INTENT_KEY_PKGNAME, "diameter", "c", "", "playing", "Z", "getPlaying", "()Z", "e", "(Z)V", "progress", "F", "getProgress", "()F", "f", "(F)V", "sounding", "getSounding", Const.INTENT_KEY_BACKGROUND_COMMAND, "density", "Landroid/graphics/Paint;", "bgPaint", "Landroid/graphics/Paint;", "trianglePaint", "barPaint", "ringPaint", "progressPaint", "Landroid/graphics/RectF;", "ringRect", "Landroid/graphics/RectF;", "Landroid/graphics/Path;", "trianglePath", "Landroid/graphics/Path;", "Landroid/graphics/Matrix;", "triangleMatrix", "Landroid/graphics/Matrix;", "Companion", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e extends View {
        private static final int ALPHA_BAR = 230;
        private static final int ALPHA_RING_TRACK = 102;
        private static final float ANGLE_TWELVE_OCLOCK = -90.0f;
        private static final float BAR_GAP = 3.3333333f;
        private static final float BAR_HEIGHT = 10.0f;
        private static final float BAR_WIDTH = 3.3333333f;
        private static final a Companion = new a(null);
        private static final float FIGMA_BTN_SIZE = 32.0f;
        private static final float MIN_VISIBLE_PROGRESS = 0.01f;
        private static final float RING_DIAMETER = 30.0f;
        private static final float RING_STROKE = 2.0f;
        private final Paint barPaint;
        private final Paint bgPaint;
        private final float density;
        private boolean playing;
        private float progress;
        private final Paint progressPaint;
        private final Paint ringPaint;
        private final RectF ringRect;
        private boolean sounding;
        private final Matrix triangleMatrix;
        private final Paint trianglePaint;
        private final Path trianglePath;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0006R\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, d2 = {"Ld6/p$e$a;", "", "<init>", "()V", "", "FIGMA_BTN_SIZE", "F", "RING_DIAMETER", "RING_STROKE", "", "ALPHA_RING_TRACK", "I", "ALPHA_BAR", "BAR_WIDTH", "BAR_HEIGHT", "BAR_GAP", "ANGLE_TWELVE_OCLOCK", "MIN_VISIBLE_PROGRESS", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class a {
            public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
                this();
            }

            public a() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context) {
            super(context);
            kotlin.jvm.internal.p.i(context, "context");
            this.density = getResources().getDisplayMetrics().density;
            Paint paint = new Paint(1);
            paint.setColor(p.COLOR_PLAY_BG);
            Paint.Style style = Paint.Style.FILL;
            paint.setStyle(style);
            this.bgPaint = paint;
            Paint paint2 = new Paint(1);
            paint2.setColor(-1);
            paint2.setStyle(style);
            this.trianglePaint = paint2;
            Paint paint3 = new Paint(1);
            paint3.setColor(-1);
            paint3.setAlpha(ALPHA_BAR);
            paint3.setStyle(style);
            this.barPaint = paint3;
            Paint paint4 = new Paint(1);
            paint4.setColor(-1);
            paint4.setAlpha(102);
            Paint.Style style2 = Paint.Style.STROKE;
            paint4.setStyle(style2);
            this.ringPaint = paint4;
            Paint paint5 = new Paint(1);
            paint5.setColor(-1);
            paint5.setStyle(style2);
            paint5.setStrokeCap(Paint.Cap.ROUND);
            this.progressPaint = paint5;
            this.ringRect = new RectF();
            this.trianglePath = new Path();
            this.triangleMatrix = new Matrix();
        }

        public final float a(float value) {
            return value * this.density;
        }

        public final void b(Canvas canvas, float cx, float cy, float scale) {
            float f10 = 3.3333333f * scale;
            float f11 = scale * 10.0f;
            float f12 = cy - (f11 / 2.0f);
            float f13 = f10 / 2.0f;
            float f14 = (cx - f13) - f10;
            float f15 = cx + f13;
            float f16 = f12 + f11;
            canvas.drawRoundRect(f14, f12, f14 + f10, f16, f13, f13, this.barPaint);
            canvas.drawRoundRect(f15, f12, f15 + f10, f16, f13, f13, this.barPaint);
        }

        public final void c(Canvas canvas, float cx, float cy, float diameter) {
            f.INSTANCE.a(canvas, this.trianglePaint, cx, cy, diameter / FIGMA_BTN_SIZE);
        }

        public final void d(Canvas canvas, float cx, float cy, float size) {
            float f10 = size / FIGMA_BTN_SIZE;
            float f11 = f10 * 2.0f;
            float f12 = (f10 * 30.0f) / 2.0f;
            this.ringPaint.setStrokeWidth(f11);
            canvas.drawCircle(cx, cy, f12, this.ringPaint);
            if (this.sounding) {
                this.progressPaint.setStrokeWidth(f11);
                this.ringRect.set(cx - f12, cy - f12, cx + f12, cy + f12);
                canvas.drawArc(this.ringRect, ANGLE_TWELVE_OCLOCK, ((this.progress * 0.99f) + 0.01f) * 360.0f, false, this.progressPaint);
            }
        }

        public final void e(boolean z10) {
            if (this.playing != z10) {
                this.playing = z10;
                invalidate();
            }
        }

        public final void f(float f10) {
            float fM = C5685n.m(f10, 0.0f, 1.0f);
            if (this.progress == fM) {
                return;
            }
            this.progress = fM;
            if (this.playing) {
                invalidate();
            }
        }

        public final void g(boolean z10) {
            if (this.sounding != z10) {
                this.sounding = z10;
                if (this.playing) {
                    invalidate();
                }
            }
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            kotlin.jvm.internal.p.i(canvas, "canvas");
            float width = getWidth() / 2.0f;
            float height = getHeight() / 2.0f;
            float fMin = Math.min(getWidth(), getHeight());
            if (this.playing) {
                d(canvas, width, height, fMin);
                b(canvas, width, height, fMin / FIGMA_BTN_SIZE);
            } else {
                canvas.drawCircle(width, height, (fMin / 2.0f) - a(0.5f), this.bgPaint);
                c(canvas, width, height, fMin);
            }
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0011¨\u0006\u001a"}, d2 = {"Ld6/p$f;", "", "<init>", "()V", "Landroid/graphics/Canvas;", "canvas", "Landroid/graphics/Paint;", "paint", "", "cx", "cy", ConstConfig.KEY_VIEW_SCALE_PROPERTY, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/graphics/Canvas;Landroid/graphics/Paint;FFF)V", "Landroid/graphics/Path;", "path", "Landroid/graphics/Path;", "Landroid/graphics/Matrix;", "matrix", "Landroid/graphics/Matrix;", "INK_CENTER_X", "F", "INK_CENTER_Y", "INK_OFFSET_X", "FIGMA_PLAY_TRIANGLE", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f {
        private static final Path FIGMA_PLAY_TRIANGLE;
        private static final float INK_CENTER_X = 7.084f;
        private static final float INK_CENTER_Y = 6.115f;
        private static final float INK_OFFSET_X = 0.88f;
        public static final f INSTANCE = new f();
        private static final Path path = new Path();
        private static final Matrix matrix = new Matrix();

        static {
            Path path2 = new Path();
            path2.moveTo(3.30092f, 5.69632f);
            path2.lineTo(4.4183f, 4.01384f);
            path2.cubicTo(5.30916f, 2.67243f, 5.75459f, 2.00172f, 6.31654f, 1.76822f);
            path2.cubicTo(6.80781f, 1.56408f, 7.36016f, 1.56408f, 7.85143f, 1.76822f);
            path2.cubicTo(8.41338f, 2.00172f, 8.85881f, 2.67243f, 9.74967f, 4.01384f);
            path2.lineTo(10.867f, 5.69632f);
            path2.cubicTo(11.9396f, 7.31137f, 12.4759f, 8.1189f, 12.4351f, 8.78833f);
            path2.cubicTo(12.3996f, 9.37155f, 12.1108f, 9.91006f, 11.6446f, 10.2623f);
            path2.cubicTo(11.1095f, 10.6667f, 10.1401f, 10.6667f, 8.20136f, 10.6667f);
            path2.lineTo(5.96661f, 10.6667f);
            path2.cubicTo(4.02784f, 10.6667f, 3.05845f, 10.6667f, 2.52336f, 10.2623f);
            path2.cubicTo(2.05719f, 9.91006f, 1.76838f, 9.37155f, 1.73283f, 8.78833f);
            path2.cubicTo(1.69203f, 8.1189f, 2.22833f, 7.31137f, 3.30092f, 5.69632f);
            path2.close();
            FIGMA_PLAY_TRIANGLE = path2;
        }

        public final void a(Canvas canvas, Paint paint, float cx, float cy, float scale) {
            kotlin.jvm.internal.p.i(canvas, "canvas");
            kotlin.jvm.internal.p.i(paint, "paint");
            Matrix matrix2 = matrix;
            matrix2.setRotate(90.0f);
            matrix2.postScale(scale, scale);
            matrix2.postTranslate(cx + (6.995f * scale), cy - (scale * INK_CENTER_X));
            Path path2 = path;
            path2.set(FIGMA_PLAY_TRIANGLE);
            path2.transform(matrix2);
            canvas.drawPath(path2, paint);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nR*\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018¨\u0006\u001b"}, d2 = {"Ld6/p$g;", "Landroid/view/View;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/graphics/Canvas;", "canvas", "LY8/t;", "onDraw", "(Landroid/graphics/Canvas;)V", "", UxipConstants.f30680s, "playing", "Z", "getPlaying", "()Z", Const.INTENT_KEY_APIKEY, "(Z)V", "", "density", "F", "Landroid/graphics/Paint;", "maskPaint", "Landroid/graphics/Paint;", "barPaint", "Companion", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class g extends View {
        private static final int ALPHA_MASK = 51;
        private static final int BAR_COUNT = 3;
        private static final float BOX_RATIO = 0.17857143f;
        private static final float COVER_CORNER_DP = 12.0f;
        private static final float DESIGN_BAR_MAX = 10.0f;
        private static final float DESIGN_BAR_MIN = 2.0f;
        private static final float DESIGN_BAR_PITCH = 4.0f;
        private static final float DESIGN_BAR_WIDTH = 2.0f;
        private static final float DESIGN_BOX = 10.0f;
        private static final long FRAME_INTERVAL_MS = 50;
        private final Paint barPaint;
        private final float density;
        private final Paint maskPaint;
        private boolean playing;
        private static final a Companion = new a(null);
        private static final long[] PERIODS_MS = {620, 500, 760};
        private static final int COLOR_BAR = Color.parseColor("#D9D9D9");

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\fR\u0014\u0010\u0016\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\fR\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0006¨\u0006\u0018"}, d2 = {"Ld6/p$g$a;", "", "<init>", "()V", "", "DESIGN_BOX", "F", "BOX_RATIO", "DESIGN_BAR_WIDTH", "DESIGN_BAR_PITCH", "", "BAR_COUNT", "I", "DESIGN_BAR_MIN", "DESIGN_BAR_MAX", "", "PERIODS_MS", "[J", "", "FRAME_INTERVAL_MS", "J", "ALPHA_MASK", "COLOR_BAR", "COVER_CORNER_DP", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class a {
            public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
                this();
            }

            public a() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Context context) {
            super(context);
            kotlin.jvm.internal.p.i(context, "context");
            this.density = getResources().getDisplayMetrics().density;
            Paint paint = new Paint(1);
            paint.setColor(-16777216);
            paint.setAlpha(51);
            Paint.Style style = Paint.Style.FILL;
            paint.setStyle(style);
            this.maskPaint = paint;
            Paint paint2 = new Paint(1);
            paint2.setColor(COLOR_BAR);
            paint2.setStyle(style);
            this.barPaint = paint2;
        }

        public final void a(boolean z10) {
            if (this.playing != z10) {
                this.playing = z10;
                invalidate();
            }
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            kotlin.jvm.internal.p.i(canvas, "canvas");
            if (this.playing) {
                float width = getWidth();
                float height = getHeight();
                float f10 = this.density * 12.0f;
                canvas.drawRoundRect(0.0f, 0.0f, width, height, f10, f10, this.maskPaint);
                float fMin = Math.min(width, height) * BOX_RATIO;
                float f11 = fMin / 10.0f;
                float f12 = f11 * 2.0f;
                float f13 = f11 * 4.0f;
                float f14 = f12 / 2.0f;
                float f15 = (height + fMin) / 2.0f;
                long jUptimeMillis = SystemClock.uptimeMillis();
                float f16 = (width - ((2 * f13) + f12)) / 2.0f;
                for (int i10 = 0; i10 < 3; i10++) {
                    long j10 = PERIODS_MS[i10];
                    canvas.drawRoundRect(f16, f15 - (((((((float) Math.sin((((jUptimeMillis % j10) / j10) * 2.0f) * 3.1415927f)) * 0.5f) + 0.5f) * 8.0f) + 2.0f) * f11), f16 + f12, f15, f14, f14, this.barPaint);
                    f16 += f13;
                }
                if (isShown()) {
                    postInvalidateDelayed(50L);
                }
            }
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class h {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MiguCardSurface.values().length];
            try {
                iArr[MiguCardSurface.INSTALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MiguCardSurface.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MiguCardSurface.DONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MiguCardSurface.LOGIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MiguCardSurface.PLAYLIST.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MiguCardSurface.HIDDEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(final Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.installObserver = new InterfaceC5063a() { // from class: d6.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return p.B0(this.f32118a, context);
            }
        };
        this.playButtons = new ArrayList();
        this.playingIndicators = new ArrayList();
        this.songs = C1173v.m();
        this.rowViews = new ArrayList();
        this.hideScrollbarRunnable = new Runnable() { // from class: d6.g
            @Override // java.lang.Runnable
            public final void run() {
                p.A0(this.f32125a);
            }
        };
        this.handler = new Handler(Looper.getMainLooper());
    }

    public static final void A0(p pVar) {
        c cVar = pVar.scrollView;
        if (cVar == null) {
            kotlin.jvm.internal.p.A("scrollView");
            cVar = null;
        }
        cVar.setVerticalScrollBarEnabled(false);
    }

    public static final t B0(final p pVar, final Context context) {
        pVar.post(new Runnable() { // from class: d6.l
            @Override // java.lang.Runnable
            public final void run() {
                p.C0(this.f32132a, context);
            }
        });
        return t.f7040a;
    }

    public static final void C0(p pVar, Context context) {
        pVar.j0();
        MiguPlayController.INSTANCE.S(context);
    }

    public static final void F0(p pVar, String str, List list) {
        if (kotlin.jvm.internal.p.d(pVar.cardId, str)) {
            MiguPlayController miguPlayController = MiguPlayController.INSTANCE;
            Context context = pVar.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            if (miguPlayController.z0(context)) {
                return;
            }
            Context context2 = pVar.getContext();
            kotlin.jvm.internal.p.h(context2, "getContext(...)");
            miguPlayController.m0(context2, list);
        }
    }

    public static final t G0(p pVar, int i10) {
        pVar.H0(i10);
        return t.f7040a;
    }

    public static final void k0(p pVar) {
        MiguPlayController miguPlayController = MiguPlayController.INSTANCE;
        Context context = pVar.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        pVar.Q0(pVar.O0(miguPlayController.y0(context)));
    }

    public static final void n0(p pVar, View view) {
        pVar.R0();
    }

    public static final void p0(p pVar, View view) {
        pVar.I0();
    }

    public static final void r0(p pVar, int i10, View view) {
        pVar.J0(i10);
    }

    public static final void s0(p pVar, int i10, View view) {
        pVar.S0(i10);
    }

    public static final t v0(p pVar) {
        C3354b c3354b = C3354b.INSTANCE;
        Context context = pVar.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        c3354b.f(context, "loginCard");
        return t.f7040a;
    }

    public static final t x0(p pVar) {
        C3354b c3354b = C3354b.INSTANCE;
        Context context = pVar.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        c3354b.b(context, "storeGuide");
        pVar.j0();
        return t.f7040a;
    }

    public static final t y0(p pVar) {
        MiguInstallState.INSTANCE.b();
        C3354b c3354b = C3354b.INSTANCE;
        Context context = pVar.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        c3354b.f(context, "storeGuideOpen");
        pVar.j0();
        MiguPlayController miguPlayController = MiguPlayController.INSTANCE;
        Context context2 = pVar.getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        miguPlayController.S(context2);
        return t.f7040a;
    }

    @Override // N5.d
    public void C(N5.n model) {
        RecyclerView recyclerView;
        kotlin.jvm.internal.p.i(model, "model");
        if (model instanceof C3958b) {
            this.playButtons.clear();
            this.playingIndicators.clear();
            C3958b c3958b = (C3958b) model;
            if (!kotlin.jvm.internal.p.d(c3958b.getCardId(), this.cardId)) {
                this.autoPlayStarted = false;
                this.autoPlayRequested = false;
            }
            this.cardId = c3958b.getCardId();
            this.autoPlayRequested = c3958b.getAutoPlay();
            this.songs = c3958b.c();
            LinearLayout linearLayout = this.column;
            ViewGroup viewGroup = null;
            if (linearLayout == null) {
                kotlin.jvm.internal.p.A("column");
                linearLayout = null;
            }
            linearLayout.removeAllViews();
            View viewO0 = o0(c3958b.getTitle());
            if (viewO0 != null) {
                LinearLayout linearLayout2 = this.column;
                if (linearLayout2 == null) {
                    kotlin.jvm.internal.p.A("column");
                    linearLayout2 = null;
                }
                linearLayout2.addView(viewO0);
            }
            if (this.songs.isEmpty()) {
                LinearLayout linearLayout3 = this.column;
                if (linearLayout3 == null) {
                    kotlin.jvm.internal.p.A("column");
                } else {
                    viewGroup = linearLayout3;
                }
                TextView textView = new TextView(getContext());
                textView.setText("暂无歌曲");
                textView.setTextColor(COLOR_TEXT_SECONDARY);
                textView.setTextSize(2, 13.0f);
                textView.setPadding(t0(14.0f), t0(16.0f), t0(14.0f), t0(16.0f));
                viewGroup.addView(textView);
                L0();
                if (isAttachedToWindow() && getWindowVisibility() == 0) {
                    MiguPlayController.INSTANCE.E0(this);
                }
                j0();
                MiguPlayController miguPlayController = MiguPlayController.INSTANCE;
                Context context = getContext();
                kotlin.jvm.internal.p.h(context, "getContext(...)");
                miguPlayController.S(context);
                return;
            }
            this.expanded = this.songs.size() <= 4;
            this.rowViews.clear();
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            LinearLayout linearLayout4 = new LinearLayout(getContext());
            linearLayout4.setOrientation(1);
            linearLayout4.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            this.listContainer = linearLayout4;
            int i10 = 0;
            for (Object obj : this.songs) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    C1173v.w();
                }
                MusicSongItem musicSongItem = (MusicSongItem) obj;
                LinearLayout linearLayout5 = this.listContainer;
                if (linearLayout5 == null) {
                    kotlin.jvm.internal.p.A("listContainer");
                    linearLayout5 = null;
                }
                View viewQ0 = q0(musicSongItem, i10);
                this.rowViews.add(viewQ0);
                linearLayout5.addView(viewQ0);
                i10 = i11;
            }
            Context context2 = getContext();
            kotlin.jvm.internal.p.h(context2, "getContext(...)");
            c cVar = new c(context2);
            cVar.setVerticalScrollBarEnabled(false);
            cVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            LinearLayout linearLayout6 = this.listContainer;
            if (linearLayout6 == null) {
                kotlin.jvm.internal.p.A("listContainer");
                linearLayout6 = null;
            }
            cVar.addView(linearLayout6);
            cVar.X(Integer.MAX_VALUE);
            cVar.setNestedScrollingEnabled(false);
            cVar.Z(new InterfaceC5074l() { // from class: d6.i
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return p.G0(this.f32127a, ((Integer) obj2).intValue());
                }
            });
            this.scrollView = cVar;
            frameLayout.addView(cVar);
            Object parent = getParent();
            if (parent == null) {
                parent = null;
            }
            if (parent == null) {
                recyclerView = null;
            } else {
                while (parent != null) {
                    if (parent instanceof RecyclerView) {
                        recyclerView = (RecyclerView) parent;
                        break;
                    }
                    View view = parent instanceof View ? (View) parent : null;
                    parent = view != null ? view.getParent() : null;
                    if (parent == null) {
                        parent = null;
                    }
                }
                recyclerView = null;
            }
            c cVar2 = this.scrollView;
            if (cVar2 == null) {
                kotlin.jvm.internal.p.A("scrollView");
                cVar2 = null;
            }
            cVar2.Y(recyclerView);
            Context context3 = getContext();
            kotlin.jvm.internal.p.h(context3, "getContext(...)");
            b bVar = new b(context3, false);
            bVar.setLayoutParams(new FrameLayout.LayoutParams(-1, t0(20.0f), 48));
            bVar.setVisibility(8);
            this.topFade = bVar;
            Context context4 = getContext();
            kotlin.jvm.internal.p.h(context4, "getContext(...)");
            b bVar2 = new b(context4, true);
            bVar2.setLayoutParams(new FrameLayout.LayoutParams(-1, t0(20.0f), 80));
            bVar2.setVisibility(8);
            this.bottomFade = bVar2;
            b bVar3 = this.topFade;
            if (bVar3 == null) {
                kotlin.jvm.internal.p.A("topFade");
                bVar3 = null;
            }
            frameLayout.addView(bVar3);
            b bVar4 = this.bottomFade;
            if (bVar4 == null) {
                kotlin.jvm.internal.p.A("bottomFade");
                bVar4 = null;
            }
            frameLayout.addView(bVar4);
            LinearLayout linearLayout7 = this.column;
            if (linearLayout7 == null) {
                kotlin.jvm.internal.p.A("column");
                linearLayout7 = null;
            }
            linearLayout7.addView(frameLayout);
            LinearLayout linearLayout8 = this.column;
            if (linearLayout8 == null) {
                kotlin.jvm.internal.p.A("column");
            } else {
                viewGroup = linearLayout8;
            }
            viewGroup.addView(m0());
            l0();
            R5.b.INSTANCE.c("music.bind", Y8.j.a("cardId", c3958b.getCardId()), Y8.j.a("itemCount", Integer.valueOf(c3958b.c().size())), Y8.j.a("autoPlay", Boolean.valueOf(c3958b.getAutoPlay())));
            L0();
            if (isAttachedToWindow() && getWindowVisibility() == 0) {
                MiguPlayController.INSTANCE.E0(this);
            }
            j0();
            MiguPlayController miguPlayController2 = MiguPlayController.INSTANCE;
            Context context5 = getContext();
            kotlin.jvm.internal.p.h(context5, "getContext(...)");
            miguPlayController2.S(context5);
            E0();
        }
    }

    public final void D0(ImageView target, String url) {
        if (url == null || url.length() == 0) {
            target.setImageDrawable(null);
        } else {
            com.stepos.ailauncher.common.imageloader.g.s(com.stepos.ailauncher.common.imageloader.g.INSTANCE, target, new ImageRequest(url, 0, 0, null, null, 12, 0, t0(112.0f), t0(112.0f), true, null, false, false, false, false, null, 0.0f, false, 261214, null), null, null, getContext().getApplicationContext(), 12, null);
        }
    }

    @Override // N5.d
    public void E(FrameLayout container) {
        kotlin.jvm.internal.p.i(container, "container");
        T5.j binding = getBinding();
        binding.llSearchHeader.setVisibility(8);
        binding.llCardBody.setVisibility(0);
        binding.tvCardTitle.setVisibility(8);
        binding.tvCardStatus.setVisibility(8);
        binding.tvSummaryTitle.setVisibility(8);
        binding.tvSummaryDesc.setVisibility(8);
        binding.tvUpdatedAt.setVisibility(8);
        binding.llLinks.setVisibility(8);
        binding.b().setPadding(binding.b().getPaddingLeft(), 0, binding.b().getPaddingRight(), 0);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.stack = frameLayout;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(t0(20.0f));
        gradientDrawable.setColor(COLOR_CARD_BG);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setPadding(t0(16.0f), 0, t0(16.0f), t0(16.0f));
        linearLayout.setVisibility(8);
        this.column = linearLayout;
        FrameLayout frameLayout2 = this.stack;
        FrameLayout frameLayout3 = null;
        if (frameLayout2 == null) {
            kotlin.jvm.internal.p.A("stack");
            frameLayout2 = null;
        }
        LinearLayout linearLayout2 = this.column;
        if (linearLayout2 == null) {
            kotlin.jvm.internal.p.A("column");
            linearLayout2 = null;
        }
        frameLayout2.addView(linearLayout2);
        FrameLayout frameLayout4 = this.stack;
        if (frameLayout4 == null) {
            kotlin.jvm.internal.p.A("stack");
        } else {
            frameLayout3 = frameLayout4;
        }
        container.addView(frameLayout3);
        j0();
        MiguPlayController miguPlayController = MiguPlayController.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        miguPlayController.S(context);
    }

    public final void E0() {
        if (!this.autoPlayStarted && this.autoPlayRequested) {
            MiguPlayController miguPlayController = MiguPlayController.INSTANCE;
            Context context = getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            if (miguPlayController.z0(context)) {
                return;
            }
            List<MusicSongItem> list = this.songs;
            final ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                String id = ((MusicSongItem) it.next()).getId();
                if (id == null || id.length() <= 0) {
                    id = null;
                }
                if (id != null) {
                    arrayList.add(id);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.autoPlayStarted = true;
            final String str = this.cardId;
            R5.b.INSTANCE.c("music.autoPlay", Y8.j.a("cardId", str), Y8.j.a("playable", Integer.valueOf(arrayList.size())));
            post(new Runnable() { // from class: d6.j
                @Override // java.lang.Runnable
                public final void run() {
                    p.F0(this.f32128a, str, arrayList);
                }
            });
        }
    }

    public final void H0(int scrollY) {
        c cVar = this.scrollView;
        b bVar = null;
        if (cVar == null) {
            kotlin.jvm.internal.p.A("scrollView");
            cVar = null;
        }
        cVar.setVerticalScrollBarEnabled(true);
        this.handler.removeCallbacks(this.hideScrollbarRunnable);
        this.handler.postDelayed(this.hideScrollbarRunnable, 1500L);
        if (N0()) {
            U0(scrollY);
            return;
        }
        b bVar2 = this.topFade;
        if (bVar2 == null) {
            kotlin.jvm.internal.p.A("topFade");
            bVar2 = null;
        }
        bVar2.setVisibility(8);
        b bVar3 = this.bottomFade;
        if (bVar3 == null) {
            kotlin.jvm.internal.p.A("bottomFade");
        } else {
            bVar = bVar3;
        }
        bVar.setVisibility(8);
    }

    public final void I0() {
        List<MusicSongItem> list = this.songs;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String id = ((MusicSongItem) it.next()).getId();
            if (id == null || id.length() <= 0) {
                id = null;
            }
            if (id != null) {
                arrayList.add(id);
            }
        }
        R5.b.INSTANCE.c("music.playAll.click", Y8.j.a("cardId", this.cardId), Y8.j.a("total", Integer.valueOf(this.songs.size())), Y8.j.a("playable", Integer.valueOf(arrayList.size())));
        MiguPlayController miguPlayController = MiguPlayController.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        miguPlayController.m0(context, arrayList);
    }

    public final void J0(int index) {
        R5.b.INSTANCE.c("music.row.click", Y8.j.a("cardId", this.cardId), Y8.j.a("index", Integer.valueOf(index)));
        C3354b c3354b = C3354b.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        c3354b.e(context, "songRow");
    }

    public final Float K0(String playingSongId) {
        if (playingSongId == null) {
            return null;
        }
        MiguPlaybackProgress miguPlaybackProgressP0 = MiguPlayController.INSTANCE.p0();
        if (kotlin.jvm.internal.p.d(miguPlaybackProgressP0.getSongId(), playingSongId)) {
            return Float.valueOf(miguPlaybackProgressP0.c());
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void L0() {
        /*
            r13 = this;
            com.stepos.ailauncher.migu.play.MiguPlayController r0 = com.stepos.ailauncher.migu.play.MiguPlayController.INSTANCE
            com.stepos.ailauncher.migu.play.c0 r0 = r0.B0()
            java.lang.String r1 = r0.getSongId()
            r2 = 0
            if (r1 == 0) goto L14
            boolean r3 = r0.getIsPlaying()
            if (r3 == 0) goto L14
            goto L15
        L14:
            r1 = r2
        L15:
            java.lang.Float r3 = r13.K0(r1)
            r4 = 0
            if (r3 == 0) goto L21
            float r3 = r3.floatValue()
            goto L22
        L21:
            r3 = r4
        L22:
            java.util.List<d6.p$e> r5 = r13.playButtons
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
            r6 = 0
            r7 = r6
        L2c:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L90
            java.lang.Object r8 = r5.next()
            int r9 = r7 + 1
            if (r7 >= 0) goto L3d
            Z8.C1173v.w()
        L3d:
            d6.p$e r8 = (d6.p.e) r8
            r10 = 1
            if (r1 == 0) goto L5a
            java.util.List<d6.q> r11 = r13.songs
            java.lang.Object r11 = Z8.F.t0(r11, r7)
            d6.q r11 = (d6.MusicSongItem) r11
            if (r11 == 0) goto L51
            java.lang.String r11 = r11.getId()
            goto L52
        L51:
            r11 = r2
        L52:
            boolean r11 = kotlin.jvm.internal.p.d(r11, r1)
            if (r11 == 0) goto L5a
            r11 = r10
            goto L5b
        L5a:
            r11 = r6
        L5b:
            if (r11 == 0) goto L64
            boolean r12 = r0.getConfirmed()
            if (r12 == 0) goto L64
            goto L65
        L64:
            r10 = r6
        L65:
            r8.e(r11)
            r8.g(r10)
            if (r11 == 0) goto L6f
            r11 = r3
            goto L70
        L6f:
            r11 = r4
        L70:
            r8.f(r11)
            java.util.List<d6.p$g> r8 = r13.playingIndicators
            java.lang.Object r7 = Z8.F.t0(r8, r7)
            d6.p$g r7 = (d6.p.g) r7
            if (r7 == 0) goto L8e
            r7.a(r10)
            if (r10 == 0) goto L84
            r8 = r6
            goto L86
        L84:
            r8 = 8
        L86:
            r7.setVisibility(r8)
            if (r10 == 0) goto L8e
            r7.invalidate()
        L8e:
            r7 = r9
            goto L2c
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.p.L0():void");
    }

    public final void M0() {
        Float fK0;
        MiguPlaybackSnapshot miguPlaybackSnapshotB0 = MiguPlayController.INSTANCE.B0();
        String songId = miguPlaybackSnapshotB0.getSongId();
        if (songId != null) {
            if (!miguPlaybackSnapshotB0.getIsPlaying()) {
                songId = null;
            }
            if (songId == null || (fK0 = K0(songId)) == null) {
                return;
            }
            float fFloatValue = fK0.floatValue();
            int i10 = 0;
            for (Object obj : this.playButtons) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    C1173v.w();
                }
                e eVar = (e) obj;
                MusicSongItem musicSongItem = (MusicSongItem) F.t0(this.songs, i10);
                if (kotlin.jvm.internal.p.d(musicSongItem != null ? musicSongItem.getId() : null, songId)) {
                    eVar.f(fFloatValue);
                }
                i10 = i11;
            }
        }
    }

    public final boolean N0() {
        return this.topFade != null && this.expanded && this.songs.size() > 4;
    }

    public final boolean O0(MiguCardSurface surface) {
        switch (h.$EnumSwitchMapping$0[surface.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
                return false;
            case 5:
                return true;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final String P0(MusicSongItem song) {
        List<String> listA = song.a();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listA) {
            if (!H.x0((String) obj)) {
                arrayList.add(obj);
            }
        }
        return F.A0(arrayList, " / ", null, null, 0, null, null, 62, null);
    }

    public final void Q0(boolean showReply) {
        int iIndexOfChild;
        View viewZ0 = z0();
        if (viewZ0 == null) {
            return;
        }
        ViewParent parent = viewZ0.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null && (iIndexOfChild = viewGroup.indexOfChild(viewZ0)) >= 0) {
            int i10 = showReply ? 0 : 8;
            int childCount = viewGroup.getChildCount();
            for (int i11 = iIndexOfChild + 1; i11 < childCount; i11++) {
                View childAt = viewGroup.getChildAt(i11);
                if (kotlin.jvm.internal.p.d(childAt.getClass().getSimpleName(), "AIMDTextView") && childAt.getVisibility() != i10) {
                    childAt.setVisibility(i10);
                }
            }
        }
    }

    public final void R0() {
        this.expanded = !this.expanded;
        l0();
        c cVar = this.scrollView;
        if (cVar == null) {
            kotlin.jvm.internal.p.A("scrollView");
            cVar = null;
        }
        cVar.setScrollY(0);
    }

    public final void S0(int index) {
        MusicSongItem musicSongItem = (MusicSongItem) F.t0(this.songs, index);
        String id = musicSongItem != null ? musicSongItem.getId() : null;
        if (id == null || id.length() == 0) {
            R5.b.INSTANCE.h("music.play.skip", Y8.j.a("cardId", this.cardId), Y8.j.a("reason", "no_song_id"), Y8.j.a("index", Integer.valueOf(index)));
            return;
        }
        MiguPlayController miguPlayController = MiguPlayController.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        miguPlayController.G0(context, id);
    }

    public final void T0() {
        LinearLayout linearLayout = null;
        if (this.songs.size() <= 4) {
            LinearLayout linearLayout2 = this.expandBtn;
            if (linearLayout2 == null) {
                kotlin.jvm.internal.p.A("expandBtn");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout3 = this.expandBtn;
        if (linearLayout3 == null) {
            kotlin.jvm.internal.p.A("expandBtn");
        } else {
            linearLayout = linearLayout3;
        }
        linearLayout.setVisibility(0);
        TextView textView = this.expandLabel;
        if (textView != null) {
            textView.setText(this.expanded ? "收起" : "展开全部");
        }
        ImageView imageView = this.expandChevron;
        if (imageView != null) {
            imageView.setRotation(this.expanded ? 180.0f : 0.0f);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void U0(int r7) {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            if (r7 <= 0) goto L6
            r7 = r0
            goto L7
        L6:
            r7 = r1
        L7:
            java.lang.String r2 = "scrollView"
            r3 = 0
            if (r7 == 0) goto L1e
            d6.p$c r4 = r6.scrollView
            if (r4 != 0) goto L15
            kotlin.jvm.internal.p.A(r2)
            r4 = r3
        L15:
            r5 = -1
            boolean r4 = r4.canScrollVertically(r5)
            if (r4 == 0) goto L1e
            r4 = r0
            goto L1f
        L1e:
            r4 = r1
        L1f:
            d6.p$c r5 = r6.scrollView
            if (r5 != 0) goto L27
            kotlin.jvm.internal.p.A(r2)
            r5 = r3
        L27:
            boolean r0 = r5.canScrollVertically(r0)
            d6.p$b r2 = r6.topFade
            if (r2 != 0) goto L36
            java.lang.String r2 = "topFade"
            kotlin.jvm.internal.p.A(r2)
            r2 = r3
        L36:
            r5 = 8
            if (r4 == 0) goto L3c
            r4 = r1
            goto L3d
        L3c:
            r4 = r5
        L3d:
            r2.setVisibility(r4)
            d6.p$b r6 = r6.bottomFade
            if (r6 != 0) goto L4a
            java.lang.String r6 = "bottomFade"
            kotlin.jvm.internal.p.A(r6)
            goto L4b
        L4a:
            r3 = r6
        L4b:
            if (r0 == 0) goto L50
            if (r7 == 0) goto L50
            goto L51
        L50:
            r1 = r5
        L51:
            r3.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.p.U0(int):void");
    }

    @Override // com.stepos.ailauncher.migu.play.a0
    public void b() {
        M0();
    }

    @Override // com.stepos.ailauncher.migu.play.a0
    public void c() {
        j0();
    }

    @Override // com.stepos.ailauncher.migu.play.a0
    public void d() {
        L0();
    }

    public final void j0() {
        View viewI;
        if (this.column == null || this.stack == null) {
            return;
        }
        MiguPlayController miguPlayController = MiguPlayController.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        MiguCardSurface miguCardSurfaceY0 = miguPlayController.y0(context);
        LinearLayout linearLayout = this.column;
        if (linearLayout == null) {
            kotlin.jvm.internal.p.A("column");
            linearLayout = null;
        }
        linearLayout.setVisibility(miguCardSurfaceY0 == MiguCardSurface.PLAYLIST ? 0 : 8);
        g0.a aVar = this.storeGuideHolder;
        if (aVar != null && (viewI = aVar.getRoot()) != null) {
            viewI.setVisibility(8);
        }
        View view = this.loginCard;
        if (view != null) {
            view.setVisibility(8);
        }
        switch (h.$EnumSwitchMapping$0[miguCardSurfaceY0.ordinal()]) {
            case 1:
            case 2:
            case 3:
                g0.a aVarW0 = w0();
                aVarW0.getRoot().setVisibility(0);
                aVarW0.d(miguCardSurfaceY0);
                aVarW0.g();
                C3369q c3369q = C3369q.INSTANCE;
                Context context2 = getContext();
                kotlin.jvm.internal.p.h(context2, "getContext(...)");
                c3369q.o(context2);
                break;
            case 4:
                u0().setVisibility(0);
                break;
            case 5:
                E0();
                break;
            case 6:
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        R5.b.INSTANCE.c("music.cardSurface", Y8.j.a("cardId", this.cardId), Y8.j.a("surface", miguCardSurfaceY0.name()));
        Q0(O0(miguCardSurfaceY0));
        post(new Runnable() { // from class: d6.h
            @Override // java.lang.Runnable
            public final void run() {
                p.k0(this.f32126a);
            }
        });
    }

    public final void l0() {
        int size = (this.songs.size() <= 4 || this.expanded) ? this.songs.size() : 4;
        int i10 = 0;
        for (Object obj : this.rowViews) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            ((View) obj).setVisibility(i10 < size ? 0 : 8);
            i10 = i11;
        }
        T0();
        c cVar = this.scrollView;
        if (cVar == null) {
            kotlin.jvm.internal.p.A("scrollView");
            cVar = null;
        }
        U0(cVar.getScrollY());
    }

    public final LinearLayout m0() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = t0(6.0f);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setMinimumHeight(t0(18.0f));
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: d6.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.n0(this.f32134a, view);
            }
        });
        this.expandBtn = linearLayout;
        TextView textView = new TextView(getContext());
        textView.setTextColor(COLOR_TEXT_ACTION);
        textView.setTextSize(2, 13.0f);
        textView.setText("展开全部");
        this.expandLabel = textView;
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R$drawable.ic_migu_expand_chevron);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(t0(16.0f), t0(16.0f));
        layoutParams2.setMarginStart(t0(4.0f));
        imageView.setLayoutParams(layoutParams2);
        imageView.setImportantForAccessibility(2);
        this.expandChevron = imageView;
        LinearLayout linearLayout2 = this.expandBtn;
        if (linearLayout2 == null) {
            kotlin.jvm.internal.p.A("expandBtn");
            linearLayout2 = null;
        }
        linearLayout2.addView(this.expandLabel);
        LinearLayout linearLayout3 = this.expandBtn;
        if (linearLayout3 == null) {
            kotlin.jvm.internal.p.A("expandBtn");
            linearLayout3 = null;
        }
        linearLayout3.addView(this.expandChevron);
        LinearLayout linearLayout4 = this.expandBtn;
        if (linearLayout4 != null) {
            return linearLayout4;
        }
        kotlin.jvm.internal.p.A("expandBtn");
        return null;
    }

    public final View o0(String title) {
        boolean z10 = title == null || H.x0(title);
        if (z10 && this.songs.isEmpty()) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = t0(16.0f);
        layoutParams.bottomMargin = t0(6.0f);
        linearLayout.setLayoutParams(layoutParams);
        TextView textView = new TextView(getContext());
        if (title == null) {
            title = "";
        }
        textView.setText(title);
        int i10 = COLOR_TEXT_PRIMARY;
        textView.setTextColor(i10);
        textView.setTextSize(2, 14.0f);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setVisibility(!z10 ? 0 : 4);
        textView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(textView);
        if (this.songs.isEmpty()) {
            return linearLayout;
        }
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setClickable(true);
        linearLayout2.setFocusable(true);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMarginStart(t0(16.0f));
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: d6.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.p0(this.f32131a, view);
            }
        });
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        View dVar = new d(context);
        dVar.setLayoutParams(new LinearLayout.LayoutParams(t0(16.0f), t0(16.0f)));
        linearLayout2.addView(dVar);
        TextView textView2 = new TextView(getContext());
        textView2.setText("播放全部");
        textView2.setTextColor(i10);
        textView2.setTextSize(2, 14.0f);
        textView2.setMaxLines(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMarginStart(t0(2.0f));
        textView2.setLayoutParams(layoutParams3);
        linearLayout2.addView(textView2);
        linearLayout.addView(linearLayout2);
        return linearLayout;
    }

    @Override // N5.d, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MiguPlayController miguPlayController = MiguPlayController.INSTANCE;
        miguPlayController.E0(this);
        MiguInstallState.INSTANCE.a(this.installObserver);
        L0();
        j0();
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        miguPlayController.S(context);
    }

    @Override // N5.d, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MiguPlayController.INSTANCE.K0(this);
        MiguInstallState.INSTANCE.h(this.installObserver);
    }

    @Override // N5.d, android.view.View
    public void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        if (visibility != 0) {
            MiguPlayController.INSTANCE.K0(this);
            MiguInstallState.INSTANCE.h(this.installObserver);
            return;
        }
        MiguPlayController miguPlayController = MiguPlayController.INSTANCE;
        miguPlayController.E0(this);
        MiguInstallState.INSTANCE.a(this.installObserver);
        L0();
        j0();
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        miguPlayController.S(context);
    }

    public final View q0(MusicSongItem song, final int index) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, t0(76.0f)));
        linearLayout.setPadding(0, t0(10.0f), 0, t0(10.0f));
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: d6.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.r0(this.f32120a, index, view);
            }
        });
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(t0(56.0f), t0(56.0f));
        layoutParams.setMarginEnd(t0(12.0f));
        frameLayout.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        D0(imageView, song.getCoverUrl());
        frameLayout.addView(imageView);
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        g gVar = new g(context);
        gVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        gVar.setVisibility(8);
        frameLayout.addView(gVar);
        this.playingIndicators.add(gVar);
        linearLayout.addView(frameLayout);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView textView = new TextView(getContext());
        String title = song.getTitle();
        if (title == null) {
            title = "";
        }
        textView.setText(title);
        textView.setTextColor(COLOR_TEXT_PRIMARY);
        textView.setTextSize(2, 15.0f);
        textView.setMaxLines(1);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(getContext());
        textView2.setText(P0(song));
        textView2.setTextColor(COLOR_TEXT_SECONDARY);
        textView2.setTextSize(2, 12.0f);
        textView2.setMaxLines(1);
        textView2.setEllipsize(truncateAt);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = t0(2.0f);
        textView2.setLayoutParams(layoutParams2);
        linearLayout2.addView(textView2);
        linearLayout.addView(linearLayout2);
        Context context2 = getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        e eVar = new e(context2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(t0(32.0f), t0(32.0f));
        layoutParams3.setMarginStart(t0(10.0f));
        eVar.setLayoutParams(layoutParams3);
        eVar.setClickable(true);
        eVar.setOnClickListener(new View.OnClickListener() { // from class: d6.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.s0(this.f32122a, index, view);
            }
        });
        this.playButtons.add(eVar);
        linearLayout.addView(eVar);
        return linearLayout;
    }

    public final int t0(float value) {
        return (int) ((value * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final View u0() {
        View view = this.loginCard;
        if (view != null) {
            return view;
        }
        C3372u c3372u = C3372u.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        View viewE = c3372u.e(context, new InterfaceC5063a() { // from class: d6.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return p.v0(this.f32124a);
            }
        });
        viewE.setVisibility(8);
        FrameLayout frameLayout = this.stack;
        if (frameLayout == null) {
            kotlin.jvm.internal.p.A("stack");
            frameLayout = null;
        }
        frameLayout.addView(viewE);
        this.loginCard = viewE;
        return viewE;
    }

    public final g0.a w0() {
        g0.a aVar = this.storeGuideHolder;
        if (aVar != null) {
            return aVar;
        }
        g0 g0Var = g0.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        g0.a aVarC = g0Var.c(context);
        aVarC.getRoot().setVisibility(8);
        aVarC.e(new InterfaceC5063a() { // from class: d6.n
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return p.x0(this.f32135a);
            }
        }, new InterfaceC5063a() { // from class: d6.o
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return p.y0(this.f32136a);
            }
        });
        FrameLayout frameLayout = this.stack;
        if (frameLayout == null) {
            kotlin.jvm.internal.p.A("stack");
            frameLayout = null;
        }
        frameLayout.addView(aVarC.getRoot());
        this.storeGuideHolder = aVarC;
        return aVarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    public final View z0() {
        ViewParent parent = getParent();
        ?? r52 = this;
        while (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            Iterable iterableS = C5685n.s(0, viewGroup.getChildCount());
            if (!(iterableS instanceof Collection) || !((Collection) iterableS).isEmpty()) {
                Iterator it = iterableS.iterator();
                while (it.hasNext()) {
                    if (kotlin.jvm.internal.p.d(viewGroup.getChildAt(((M) it).nextInt()).getClass().getSimpleName(), "AIMDTextView")) {
                        return r52;
                    }
                }
            }
            View view = (View) parent;
            parent = ((ViewGroup) view).getParent();
            r52 = view;
        }
        return null;
    }

    public /* synthetic */ p(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
