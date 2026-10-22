package com.stepos.agentframework.util;

import La.H;
import Z8.C1173v;
import a2.C1223k;
import a2.InterfaceC1217e;
import a2.InterfaceC1218f;
import a2.InterfaceC1219g;
import android.animation.ObjectAnimator;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Outline;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.autonavi.aps.amapapi.config.Const;
import com.bumptech.glide.Glide;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.agentframework.R$drawable;
import com.stepos.agentframework.util.AgentImagePreviewActivity;
import com.stepos.agentframework.util.u;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.zyql.ai.selector.config.PictureMimeType;
import h8.C4148a;
import io.ktor.http.LinkHeader;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import l9.C4877a;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Y2\u00020\u0001:\u0004Z[\\]BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010 \u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0007H\u0002¢\u0006\u0004\b#\u0010$J\u0019\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010%\u001a\u00020\u0005H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0005H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0010H\u0002¢\u0006\u0004\b+\u0010\u0012J\u0017\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0007H\u0002¢\u0006\u0004\b/\u00100J\r\u00102\u001a\u000201¢\u0006\u0004\b2\u00103J\r\u00104\u001a\u00020\u0010¢\u0006\u0004\b4\u0010\u0012J\r\u00105\u001a\u00020\u0010¢\u0006\u0004\b5\u0010\u0012J\r\u00106\u001a\u00020\u0010¢\u0006\u0004\b6\u0010\u0012J\r\u00107\u001a\u00020\u000b¢\u0006\u0004\b7\u00108R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00109R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010:R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u00102R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010;R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010<R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u0002018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010C\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010I\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR*\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0014\u0010R\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020U0T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010:R\u0018\u0010W\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010X¨\u0006^"}, d2 = {"Lcom/stepos/agentframework/util/u;", "", "Landroid/content/Context;", "context", "", "", SystemDeleteBroadcastReceiver.EXTRA_SOURCES, "", "startPos", "Landroid/view/ViewGroup;", "container", "", "showTitleBar", "showDownloadButton", "<init>", "(Landroid/content/Context;Ljava/util/List;ILandroid/view/ViewGroup;ZZ)V", "LY8/t;", ExifInterface.LATITUDE_SOUTH, "()V", "Landroid/view/View;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Landroid/view/View;", "iconRes", "Lkotlin/Function0;", "onClick", "Landroid/widget/ImageView;", "x", "(ILp9/a;)Landroid/widget/ImageView;", "target", "w", "(Landroid/view/View;)V", "slideOut", ExifInterface.LONGITUDE_EAST, "(Z)V", "position", "P", "(I)V", "source", "Ljava/io/File;", "U", "(Ljava/lang/String;)Ljava/io/File;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Ljava/lang/String;)Z", "Y", UxipConstants.f30680s, "H", "(I)I", "c0", "()I", "Lcom/stepos/agentframework/util/u$c;", "I", "()Lcom/stepos/agentframework/util/u$c;", ExifInterface.GPS_DIRECTION_TRUE, "X", "D", "O", "()Z", "Landroid/content/Context;", "Ljava/util/List;", "Landroid/view/ViewGroup;", "Z", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "rootView", "Lcom/stepos/agentframework/util/u$c;", "Landroid/widget/TextView;", "indicator", "Landroid/widget/TextView;", "", "currentScale", "F", "Landroid/animation/ObjectAnimator;", "titleBarAlphaAnim", "Landroid/animation/ObjectAnimator;", "onEndAction", "Lp9/a;", "getOnEndAction", "()Lp9/a;", ExifInterface.LONGITUDE_WEST, "(Lp9/a;)V", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isShowingView", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "Ly7/E;", "glassHandles", "currentToast", "Landroid/view/View;", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "c", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class u {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long PREVIEW_FADE_MS = 83;
    private static final int PREVIEW_SLIDE_DP = 246;
    private static final long PREVIEW_SLIDE_MS = 167;
    private static final String TAG = "ImagePreviewViewHelper";
    private static volatile u currentInContainer;
    private ViewGroup container;
    private final Context context;
    private float currentScale;
    private View currentToast;
    private final List<y7.E> glassHandles;
    private TextView indicator;
    private final AtomicBoolean isShowingView;
    private InterfaceC5063a<Y8.t> onEndAction;
    private c rootView;
    private final boolean showDownloadButton;
    private final boolean showTitleBar;
    private final List<String> sources;
    private final int startPos;
    private ObjectAnimator titleBarAlphaAnim;
    private ViewPager2 viewPager;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/stepos/agentframework/util/u$a;", "", "<init>", "()V", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "", "", SystemDeleteBroadcastReceiver.EXTRA_SOURCES, "", "startPos", "", "showTitleBar", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/view/View;Ljava/util/List;IZ)V", "f", "()Z", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "source", "e", "(Ljava/lang/String;)Ljava/lang/String;", "ext", Const.INTENT_KEY_BACKGROUND_COMMAND, "TAG", "Ljava/lang/String;", "", "PREVIEW_SLIDE_MS", "J", "PREVIEW_FADE_MS", "PREVIEW_SLIDE_DP", "I", "Lcom/stepos/agentframework/util/u;", "currentInContainer", "Lcom/stepos/agentframework/util/u;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.util.u$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ void j(Companion companion, View view, List list, int i10, boolean z10, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                i10 = 0;
            }
            if ((i11 & 8) != 0) {
                z10 = false;
            }
            companion.i(view, list, i10, z10);
        }

        public static final Y8.t k(u uVar) {
            uVar.D();
            return Y8.t.f7040a;
        }

        public final boolean d() {
            u uVar = u.currentInContainer;
            if (uVar == null) {
                return false;
            }
            if (uVar.O()) {
                u.F(uVar, false, 1, null);
                return true;
            }
            u.currentInContainer = null;
            return false;
        }

        public final String e(String source) {
            String str = null;
            String strS1 = H.s1(H.w1(H.w1(source, '?', null, 2, null), '#', null, 2, null), JsonPointer.SEPARATOR, null, 2, null);
            int iA0 = H.A0(strS1, '.', 0, false, 6, null);
            if (iA0 < 0) {
                return PictureMimeType.JPG;
            }
            String strSubstring = strS1.substring(iA0);
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            int length = lowerCase.length();
            if (2 <= length && length < 6) {
                str = lowerCase;
            }
            return str == null ? PictureMimeType.JPG : str;
        }

        public final boolean f() {
            u uVar = u.currentInContainer;
            return uVar != null && uVar.O();
        }

        public final String g(String ext) {
            switch (ext.hashCode()) {
                case 1468055:
                    return !ext.equals(".bmp") ? "image/jpeg" : "image/bmp";
                case 1472726:
                    return !ext.equals(".gif") ? "image/jpeg" : "image/gif";
                case 1481531:
                    return ext.equals(PictureMimeType.PNG) ? PictureMimeType.PNG_Q : "image/jpeg";
                case 46127306:
                    return !ext.equals(PictureMimeType.WEBP) ? "image/jpeg" : "image/webp";
                default:
                    return "image/jpeg";
            }
        }

        public final void h() {
            u uVar = u.currentInContainer;
            if (uVar != null) {
                uVar.D();
            }
            u.currentInContainer = null;
        }

        public final void i(View anchor, List<String> sources, int startPos, boolean showTitleBar) {
            kotlin.jvm.internal.p.i(anchor, "anchor");
            kotlin.jvm.internal.p.i(sources, "sources");
            if (sources.isEmpty()) {
                return;
            }
            View rootView = anchor.getRootView();
            if (!anchor.isAttachedToWindow() || rootView == anchor) {
                rootView = null;
            }
            ViewGroup viewGroup = rootView instanceof ViewGroup ? (ViewGroup) rootView : null;
            if (viewGroup == null) {
                AgentImagePreviewActivity.a aVar = AgentImagePreviewActivity.Companion;
                Context context = anchor.getContext();
                kotlin.jvm.internal.p.h(context, "getContext(...)");
                aVar.a(context, startPos, sources, showTitleBar);
                return;
            }
            Context context2 = anchor.getContext();
            kotlin.jvm.internal.p.h(context2, "getContext(...)");
            final u uVar = new u(context2, sources, startPos, viewGroup, showTitleBar, false, 32, null);
            uVar.W(new InterfaceC5063a() { // from class: com.stepos.agentframework.util.t
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return u.Companion.k(uVar);
                }
            });
            uVar.X();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB7\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001bR \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/stepos/agentframework/util/u$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/agentframework/util/u$b$a;", "", "", SystemDeleteBroadcastReceiver.EXTRA_SOURCES, "Lkotlin/Function0;", "LY8/t;", "onPhotoTap", "Lkotlin/Function1;", "", "onScaleChanged", "<init>", "(Ljava/util/List;Lp9/a;Lp9/l;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/view/ViewGroup;I)Lcom/stepos/agentframework/util/u$b$a;", "holder", "position", "f", "(Lcom/stepos/agentframework/util/u$b$a;I)V", "getItemCount", "()I", "Ljava/util/List;", "Lp9/a;", "Lp9/l;", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends RecyclerView.Adapter<a> {
        private final InterfaceC5063a<Y8.t> onPhotoTap;
        private final InterfaceC5074l<Float, Y8.t> onScaleChanged;
        private final List<String> sources;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/agentframework/util/u$b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "La2/k;", "photoView", "<init>", "(La2/k;)V", "La2/k;", Const.INTENT_KEY_APIKEY, "()La2/k;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class a extends RecyclerView.ViewHolder {
            private final C1223k photoView;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(C1223k photoView) {
                super(photoView);
                kotlin.jvm.internal.p.i(photoView, "photoView");
                this.photoView = photoView;
            }

            /* renamed from: a, reason: from getter */
            public final C1223k getPhotoView() {
                return this.photoView;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<String> sources, InterfaceC5063a<Y8.t> onPhotoTap, InterfaceC5074l<? super Float, Y8.t> onScaleChanged) {
            kotlin.jvm.internal.p.i(sources, "sources");
            kotlin.jvm.internal.p.i(onPhotoTap, "onPhotoTap");
            kotlin.jvm.internal.p.i(onScaleChanged, "onScaleChanged");
            this.sources = sources;
            this.onPhotoTap = onPhotoTap;
            this.onScaleChanged = onScaleChanged;
        }

        public static final void h(b bVar, ImageView imageView, float f10, float f11) {
            bVar.onPhotoTap.invoke();
        }

        public static final void i(b bVar, ImageView imageView) {
            bVar.onPhotoTap.invoke();
        }

        public static final void j(b bVar, a aVar, float f10, float f11, float f12) {
            bVar.onScaleChanged.invoke(Float.valueOf(aVar.getPhotoView().getScale()));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a holder, int position) {
            kotlin.jvm.internal.p.i(holder, "holder");
            String str = this.sources.get(position);
            File file = new File(str);
            boolean zExists = file.exists();
            String str2 = file;
            if (!zExists) {
                str2 = null;
            }
            if (str2 == null) {
                kotlin.jvm.internal.p.g(str, "null cannot be cast to non-null type kotlin.Any");
            } else {
                str = str2;
            }
            Glide.with(holder.getPhotoView().getContext()).load((Object) str).into(holder.getPhotoView());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(ViewGroup parent, int viewType) {
            kotlin.jvm.internal.p.i(parent, "parent");
            Context context = parent.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            d dVar = new d(context);
            dVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            final a aVar = new a(dVar);
            dVar.setOnPhotoTapListener(new InterfaceC1218f() { // from class: com.stepos.agentframework.util.v
                @Override // a2.InterfaceC1218f
                public final void onPhotoTap(ImageView imageView, float f10, float f11) {
                    u.b.h(this.f23354a, imageView, f10, f11);
                }
            });
            dVar.setOnOutsidePhotoTapListener(new InterfaceC1217e() { // from class: com.stepos.agentframework.util.w
                @Override // a2.InterfaceC1217e
                public final void onOutsidePhotoTap(ImageView imageView) {
                    u.b.i(this.f23355a, imageView);
                }
            });
            dVar.setOnScaleChangeListener(new InterfaceC1219g() { // from class: com.stepos.agentframework.util.x
                @Override // a2.InterfaceC1219g
                public final void onScaleChange(float f10, float f11, float f12) {
                    u.b.j(this.f23356a, aVar, f10, f11, f12);
                }
            });
            return aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.sources.size();
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\rR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010(R\u0016\u0010*\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010.R\u0014\u00100\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010(¨\u00061"}, d2 = {"Lcom/stepos/agentframework/util/u$c;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "LY8/t;", "onDetachedFromWindow", "()V", "Landroid/view/MotionEvent;", "ev", "", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "event", "onTouchEvent", "Lkotlin/Function0;", "onDismiss", "Lp9/a;", "getOnDismiss", "()Lp9/a;", "setOnDismiss", "(Lp9/a;)V", "onDetach", "getOnDetach", "setOnDetach", "isPhotoZoomedProvider", "setPhotoZoomedProvider", "Landroid/view/View;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "titleBar", "getTitleBar", "setTitleBar", "", "downY", "F", "downX", "isDragging", "Z", "", "touchSlop", "I", "dismissThreshold", "titleFadeDistance", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends FrameLayout {
        private View contentView;
        private final int dismissThreshold;
        private float downX;
        private float downY;
        private boolean isDragging;
        private InterfaceC5063a<Boolean> isPhotoZoomedProvider;
        private InterfaceC5063a<Y8.t> onDetach;
        private InterfaceC5063a<Y8.t> onDismiss;
        private View titleBar;
        private final float titleFadeDistance;
        private final int touchSlop;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context) {
            super(context);
            kotlin.jvm.internal.p.i(context, "context");
            this.isPhotoZoomedProvider = new InterfaceC5063a() { // from class: com.stepos.agentframework.util.z
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(u.c.c());
                }
            };
            this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
            this.dismissThreshold = (int) (200 * context.getResources().getDisplayMetrics().density);
            this.titleFadeDistance = 48 * context.getResources().getDisplayMetrics().density;
        }

        public static final boolean c() {
            return false;
        }

        public static final void d(c cVar) {
            InterfaceC5063a<Y8.t> interfaceC5063a = cVar.onDismiss;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
        }

        public final View getContentView() {
            return this.contentView;
        }

        public final InterfaceC5063a<Y8.t> getOnDetach() {
            return this.onDetach;
        }

        public final InterfaceC5063a<Y8.t> getOnDismiss() {
            return this.onDismiss;
        }

        public final View getTitleBar() {
            return this.titleBar;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            InterfaceC5063a<Y8.t> interfaceC5063a = this.onDetach;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            kotlin.jvm.internal.p.i(ev, "ev");
            if (this.isPhotoZoomedProvider.invoke().booleanValue() || ev.getPointerCount() > 1) {
                return false;
            }
            int actionMasked = ev.getActionMasked();
            if (actionMasked == 0) {
                this.downY = ev.getRawY();
                this.downX = ev.getRawX();
                this.isDragging = false;
            } else if (actionMasked == 2) {
                float rawY = ev.getRawY() - this.downY;
                float rawX = ev.getRawX() - this.downX;
                if (!this.isDragging && rawY > this.touchSlop && Math.abs(rawY) > Math.abs(rawX) * 1.5f) {
                    this.isDragging = true;
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x005d  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouchEvent(android.view.MotionEvent r8) {
            /*
                r7 = this;
                java.lang.String r0 = "event"
                kotlin.jvm.internal.p.i(r8, r0)
                int r0 = r8.getActionMasked()
                r1 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                r2 = 1065353216(0x3f800000, float:1.0)
                r3 = 0
                r4 = 1
                if (r0 == r4) goto L5d
                r5 = 2
                if (r0 == r5) goto L19
                r5 = 3
                if (r0 == r5) goto L5d
                goto Ldc
            L19:
                float r8 = r8.getRawY()
                float r0 = r7.downY
                float r8 = r8 - r0
                float r8 = v9.C5685n.e(r8, r3)
                int r0 = r7.getHeight()
                float r0 = (float) r0
                float r0 = r8 / r0
                float r0 = v9.C5685n.m(r0, r3, r2)
                android.view.View r5 = r7.contentView
                if (r5 == 0) goto L36
                r5.setTranslationY(r8)
            L36:
                android.view.View r5 = r7.titleBar
                if (r5 == 0) goto L46
                float r6 = r7.titleFadeDistance
                float r8 = r8 / r6
                float r8 = r2 - r8
                float r8 = v9.C5685n.m(r8, r3, r2)
                r5.setAlpha(r8)
            L46:
                r8 = 1073741824(0x40000000, float:2.0)
                float r0 = r0 * r8
                float r8 = r2 - r0
                float r8 = v9.C5685n.m(r8, r3, r2)
                r0 = 255(0xff, float:3.57E-43)
                float r0 = (float) r0
                float r8 = r8 * r0
                int r8 = (int) r8
                int r8 = t0.C5502d.k(r1, r8)
                r7.setBackgroundColor(r8)
                goto Ldc
            L5d:
                float r8 = r8.getRawY()
                float r0 = r7.downY
                float r8 = r8 - r0
                int r0 = r7.dismissThreshold
                float r0 = (float) r0
                int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                r5 = 200(0xc8, double:9.9E-322)
                if (r8 <= 0) goto La4
                android.view.View r8 = r7.contentView
                if (r8 == 0) goto L8b
                android.view.ViewPropertyAnimator r8 = r8.animate()
                if (r8 == 0) goto L8b
                int r0 = r7.getHeight()
                float r0 = (float) r0
                android.view.ViewPropertyAnimator r8 = r8.translationY(r0)
                if (r8 == 0) goto L8b
                android.view.ViewPropertyAnimator r8 = r8.setDuration(r5)
                if (r8 == 0) goto L8b
                r8.start()
            L8b:
                android.view.ViewPropertyAnimator r8 = r7.animate()
                android.view.ViewPropertyAnimator r8 = r8.alpha(r3)
                android.view.ViewPropertyAnimator r8 = r8.setDuration(r5)
                com.stepos.agentframework.util.y r0 = new com.stepos.agentframework.util.y
                r0.<init>()
                android.view.ViewPropertyAnimator r8 = r8.withEndAction(r0)
                r8.start()
                goto Ld9
            La4:
                android.view.View r8 = r7.contentView
                if (r8 == 0) goto Lbd
                android.view.ViewPropertyAnimator r8 = r8.animate()
                if (r8 == 0) goto Lbd
                android.view.ViewPropertyAnimator r8 = r8.translationY(r3)
                if (r8 == 0) goto Lbd
                android.view.ViewPropertyAnimator r8 = r8.setDuration(r5)
                if (r8 == 0) goto Lbd
                r8.start()
            Lbd:
                android.view.View r8 = r7.titleBar
                if (r8 == 0) goto Ld6
                android.view.ViewPropertyAnimator r8 = r8.animate()
                if (r8 == 0) goto Ld6
                android.view.ViewPropertyAnimator r8 = r8.alpha(r2)
                if (r8 == 0) goto Ld6
                android.view.ViewPropertyAnimator r8 = r8.setDuration(r5)
                if (r8 == 0) goto Ld6
                r8.start()
            Ld6:
                r7.setBackgroundColor(r1)
            Ld9:
                r8 = 0
                r7.isDragging = r8
            Ldc:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.util.u.c.onTouchEvent(android.view.MotionEvent):boolean");
        }

        public final void setContentView(View view) {
            this.contentView = view;
        }

        public final void setOnDetach(InterfaceC5063a<Y8.t> interfaceC5063a) {
            this.onDetach = interfaceC5063a;
        }

        public final void setOnDismiss(InterfaceC5063a<Y8.t> interfaceC5063a) {
            this.onDismiss = interfaceC5063a;
        }

        public final void setPhotoZoomedProvider(InterfaceC5063a<Boolean> interfaceC5063a) {
            kotlin.jvm.internal.p.i(interfaceC5063a, "<set-?>");
            this.isPhotoZoomedProvider = interfaceC5063a;
        }

        public final void setTitleBar(View view) {
            this.titleBar = view;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/agentframework/util/u$d;", "La2/k;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends C1223k {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context) {
            super(context);
            kotlin.jvm.internal.p.i(context, "context");
        }

        @Override // android.view.View
        public boolean dispatchTouchEvent(MotionEvent ev) {
            Boolean bool;
            ViewParent parent;
            kotlin.jvm.internal.p.i(ev, "ev");
            int actionMasked = ev.getActionMasked();
            if (actionMasked == 1 || actionMasked == 3) {
                bool = Boolean.TRUE;
            } else if (actionMasked != 5) {
                bool = null;
                if (actionMasked == 6 && ev.getPointerCount() <= 2) {
                    bool = Boolean.TRUE;
                }
            } else {
                bool = Boolean.FALSE;
            }
            if (bool != null) {
                setAllowParentInterceptOnEdge(bool.booleanValue());
            }
            if (ev.getActionMasked() == 5 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            return super.dispatchTouchEvent(ev);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/agentframework/util/u$e", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e extends ViewOutlineProvider {
        final /* synthetic */ float $cornerRadiusPx;

        public e(float f10) {
            this.$cornerRadiusPx = f10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.$cornerRadiusPx);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/agentframework/util/u$f", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f implements View.OnAttachStateChangeListener {
        final /* synthetic */ y7.E $handle;

        public f(y7.E e10) {
            this.$handle = e10;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            v10.removeOnAttachStateChangeListener(this);
            if (u.this.glassHandles.remove(this.$handle)) {
                y7.E e10 = this.$handle;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    e10.g();
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/util/u$g", "Landroidx/viewpager2/widget/ViewPager2$i;", "", "position", "LY8/t;", "onPageSelected", "(I)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class g extends ViewPager2.i {
        public g() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageSelected(int position) {
            TextView textView = u.this.indicator;
            if (textView != null) {
                textView.setText((position + 1) + " / " + u.this.sources.size());
            }
            u.this.currentScale = 1.0f;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/agentframework/util/u$h", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "view", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class h implements View.OnAttachStateChangeListener {
        final /* synthetic */ View $this_doOnAttach;
        final /* synthetic */ u this$0;

        public h(View view, u uVar) {
            this.$this_doOnAttach = view;
            this.this$0 = uVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.$this_doOnAttach.removeOnAttachStateChangeListener(this);
            this.this$0.S();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public u(Context context, List<String> sources, int i10, ViewGroup viewGroup, boolean z10, boolean z11) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(sources, "sources");
        this.context = context;
        this.sources = sources;
        this.startPos = i10;
        this.container = viewGroup;
        this.showTitleBar = z10;
        this.showDownloadButton = z11;
        this.currentScale = 1.0f;
        this.isShowingView = new AtomicBoolean(false);
        this.glassHandles = new ArrayList();
    }

    public static final Y8.t B(u uVar) {
        F(uVar, false, 1, null);
        return Y8.t.f7040a;
    }

    public static final Y8.t C(u uVar) {
        ViewPager2 viewPager2 = uVar.viewPager;
        if (viewPager2 == null) {
            kotlin.jvm.internal.p.A("viewPager");
            viewPager2 = null;
        }
        uVar.P(viewPager2.getCurrentItem());
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void F(u uVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        uVar.E(z10);
    }

    public static final void G(u uVar) {
        uVar.T();
        InterfaceC5063a<Y8.t> interfaceC5063a = uVar.onEndAction;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final Y8.t J(u uVar) {
        uVar.E(false);
        return Y8.t.f7040a;
    }

    public static final boolean K(u uVar) {
        return uVar.currentScale > 1.05f;
    }

    public static final Y8.t L(u uVar) {
        uVar.T();
        return Y8.t.f7040a;
    }

    public static final Y8.t M(u uVar) {
        F(uVar, false, 1, null);
        return Y8.t.f7040a;
    }

    public static final Y8.t N(u uVar, float f10) {
        uVar.currentScale = f10;
        ViewPager2 viewPager2 = uVar.viewPager;
        if (viewPager2 == null) {
            kotlin.jvm.internal.p.A("viewPager");
            viewPager2 = null;
        }
        viewPager2.setUserInputEnabled(f10 <= 1.05f);
        return Y8.t.f7040a;
    }

    public static final void Q(final u uVar, String str) {
        final boolean zV = uVar.V(str);
        c cVar = uVar.rootView;
        if (cVar == null) {
            kotlin.jvm.internal.p.A("rootView");
            cVar = null;
        }
        cVar.post(new Runnable() { // from class: com.stepos.agentframework.util.g
            @Override // java.lang.Runnable
            public final void run() {
                u.R(zV, uVar);
            }
        });
    }

    public static final void R(boolean z10, u uVar) {
        if (z10) {
            uVar.Y();
        } else {
            Toast.makeText(uVar.context, "保存失败", 0).show();
        }
    }

    public static final void Z(final TextView textView, final u uVar) {
        textView.postDelayed(new Runnable() { // from class: com.stepos.agentframework.util.i
            @Override // java.lang.Runnable
            public final void run() {
                u.a0(textView, uVar);
            }
        }, 1500L);
    }

    public static final void a0(final TextView textView, final u uVar) {
        textView.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.stepos.agentframework.util.j
            @Override // java.lang.Runnable
            public final void run() {
                u.b0(this.f23341a, textView);
            }
        }).start();
    }

    public static final void b0(u uVar, TextView textView) {
        c cVar = uVar.rootView;
        if (cVar == null) {
            kotlin.jvm.internal.p.A("rootView");
            cVar = null;
        }
        cVar.removeView(textView);
        if (uVar.currentToast == textView) {
            uVar.currentToast = null;
        }
    }

    public static final void y(InterfaceC5063a interfaceC5063a, View view) {
        interfaceC5063a.invoke();
    }

    public static final void z(ImageView imageView, u uVar) {
        if (imageView.isAttachedToWindow()) {
            uVar.w(imageView);
        }
    }

    public final View A() {
        FrameLayout frameLayout = new FrameLayout(this.context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        layoutParams.topMargin = c0();
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.setElevation(H(4));
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        linearLayout.setPadding(H(16), H(14), H(16), H(6));
        LinearLayout linearLayout2 = new LinearLayout(this.context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout2.addView(x(R$drawable.ic_agent_preview_back, new InterfaceC5063a() { // from class: com.stepos.agentframework.util.p
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return u.B(this.f23348a);
            }
        }));
        TextView textView = new TextView(this.context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMarginStart(H(16));
        textView.setLayoutParams(layoutParams2);
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        textView.setShadowLayer(2.0f, 0.0f, 1.0f, 436207616);
        textView.setText((this.startPos + 1) + " / " + this.sources.size());
        textView.setVisibility(this.sources.size() <= 1 ? 8 : 0);
        this.indicator = textView;
        linearLayout2.addView(textView);
        linearLayout.addView(linearLayout2);
        if (this.showDownloadButton) {
            linearLayout.addView(x(R$drawable.ic_agent_preview_download, new InterfaceC5063a() { // from class: com.stepos.agentframework.util.q
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return u.C(this.f23349a);
                }
            }));
        }
        frameLayout.addView(linearLayout);
        if (this.sources.size() > 1) {
            ViewPager2 viewPager2 = this.viewPager;
            if (viewPager2 == null) {
                kotlin.jvm.internal.p.A("viewPager");
                viewPager2 = null;
            }
            viewPager2.j(new g());
        }
        return frameLayout;
    }

    public final void D() {
        if (this.container == null) {
            return;
        }
        if (this.rootView != null) {
            T();
            ViewGroup viewGroup = this.container;
            if (viewGroup != null) {
                c cVar = this.rootView;
                if (cVar == null) {
                    kotlin.jvm.internal.p.A("rootView");
                    cVar = null;
                }
                viewGroup.removeView(cVar);
            }
            this.isShowingView.set(false);
        }
        if (currentInContainer == this) {
            currentInContainer = null;
        }
    }

    public final void E(boolean slideOut) {
        ObjectAnimator objectAnimator = this.titleBarAlphaAnim;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        if (!slideOut) {
            T();
            InterfaceC5063a<Y8.t> interfaceC5063a = this.onEndAction;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
                return;
            }
            return;
        }
        float fH = H(PREVIEW_SLIDE_DP);
        c cVar = this.rootView;
        c cVar2 = null;
        if (cVar == null) {
            kotlin.jvm.internal.p.A("rootView");
            cVar = null;
        }
        View contentView = cVar.getContentView();
        c cVar3 = this.rootView;
        if (cVar3 == null) {
            kotlin.jvm.internal.p.A("rootView");
            cVar3 = null;
        }
        Iterator it = C1173v.r(contentView, cVar3.getTitleBar()).iterator();
        while (it.hasNext()) {
            ((View) it.next()).animate().translationX(fH).setDuration(PREVIEW_SLIDE_MS).setInterpolator(new PathInterpolator(0.48f, 0.0f, 0.54f, 1.0f)).start();
        }
        c cVar4 = this.rootView;
        if (cVar4 == null) {
            kotlin.jvm.internal.p.A("rootView");
            cVar4 = null;
        }
        View titleBar = cVar4.getTitleBar();
        if (titleBar != null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(titleBar, (Property<View, Float>) View.ALPHA, titleBar.getAlpha(), 0.0f);
            objectAnimatorOfFloat.setDuration(83L);
            objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            objectAnimatorOfFloat.start();
            this.titleBarAlphaAnim = objectAnimatorOfFloat;
        }
        c cVar5 = this.rootView;
        if (cVar5 == null) {
            kotlin.jvm.internal.p.A("rootView");
        } else {
            cVar2 = cVar5;
        }
        cVar2.animate().alpha(0.0f).setDuration(PREVIEW_SLIDE_MS).withEndAction(new Runnable() { // from class: com.stepos.agentframework.util.e
            @Override // java.lang.Runnable
            public final void run() {
                u.G(this.f23332a);
            }
        }).start();
    }

    public final int H(int value) {
        return (int) ((value * this.context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final c I() {
        c cVar = new c(this.context);
        cVar.setBackgroundColor(-16777216);
        cVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        cVar.setOnDismiss(new InterfaceC5063a() { // from class: com.stepos.agentframework.util.k
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return u.J(this.f23343a);
            }
        });
        cVar.setPhotoZoomedProvider(new InterfaceC5063a() { // from class: com.stepos.agentframework.util.l
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(u.K(this.f23344a));
            }
        });
        cVar.setOnDetach(new InterfaceC5063a() { // from class: com.stepos.agentframework.util.m
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return u.L(this.f23345a);
            }
        });
        this.rootView = cVar;
        ViewPager2 viewPager2 = new ViewPager2(this.context);
        viewPager2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        viewPager2.setAdapter(new b(this.sources, new InterfaceC5063a() { // from class: com.stepos.agentframework.util.n
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return u.M(this.f23346a);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.agentframework.util.o
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return u.N(this.f23347a, ((Float) obj).floatValue());
            }
        }));
        viewPager2.m(this.startPos, false);
        this.viewPager = viewPager2;
        c cVar2 = this.rootView;
        if (cVar2 == null) {
            kotlin.jvm.internal.p.A("rootView");
            cVar2 = null;
        }
        ViewPager2 viewPager22 = this.viewPager;
        if (viewPager22 == null) {
            kotlin.jvm.internal.p.A("viewPager");
            viewPager22 = null;
        }
        cVar2.addView(viewPager22);
        c cVar3 = this.rootView;
        if (cVar3 == null) {
            kotlin.jvm.internal.p.A("rootView");
            cVar3 = null;
        }
        ViewPager2 viewPager23 = this.viewPager;
        if (viewPager23 == null) {
            kotlin.jvm.internal.p.A("viewPager");
            viewPager23 = null;
        }
        cVar3.setContentView(viewPager23);
        if (this.showTitleBar) {
            View viewA = A();
            c cVar4 = this.rootView;
            if (cVar4 == null) {
                kotlin.jvm.internal.p.A("rootView");
                cVar4 = null;
            }
            cVar4.addView(viewA);
            c cVar5 = this.rootView;
            if (cVar5 == null) {
                kotlin.jvm.internal.p.A("rootView");
                cVar5 = null;
            }
            cVar5.setTitleBar(viewA);
        }
        c cVar6 = this.rootView;
        if (cVar6 == null) {
            kotlin.jvm.internal.p.A("rootView");
            cVar6 = null;
        }
        if (cVar6.isAttachedToWindow()) {
            S();
        } else {
            cVar6.addOnAttachStateChangeListener(new h(cVar6, this));
        }
        c cVar7 = this.rootView;
        if (cVar7 != null) {
            return cVar7;
        }
        kotlin.jvm.internal.p.A("rootView");
        return null;
    }

    public final boolean O() {
        return (this.container == null || this.rootView == null || !this.isShowingView.get()) ? false : true;
    }

    public final void P(int position) {
        if (position < 0 || position >= this.sources.size()) {
            return;
        }
        final String str = this.sources.get(position);
        new Thread(new Runnable() { // from class: com.stepos.agentframework.util.r
            @Override // java.lang.Runnable
            public final void run() {
                u.Q(this.f23350a, str);
            }
        }).start();
    }

    public final void S() {
        float fH = H(PREVIEW_SLIDE_DP);
        c cVar = this.rootView;
        c cVar2 = null;
        if (cVar == null) {
            kotlin.jvm.internal.p.A("rootView");
            cVar = null;
        }
        View contentView = cVar.getContentView();
        c cVar3 = this.rootView;
        if (cVar3 == null) {
            kotlin.jvm.internal.p.A("rootView");
            cVar3 = null;
        }
        for (View view : C1173v.r(contentView, cVar3.getTitleBar())) {
            view.setTranslationX(fH);
            view.animate().translationX(0.0f).setDuration(PREVIEW_SLIDE_MS).setInterpolator(new PathInterpolator(0.48f, 0.0f, 0.54f, 1.0f)).start();
        }
        c cVar4 = this.rootView;
        if (cVar4 == null) {
            kotlin.jvm.internal.p.A("rootView");
        } else {
            cVar2 = cVar4;
        }
        View titleBar = cVar2.getTitleBar();
        if (titleBar == null) {
            return;
        }
        titleBar.setAlpha(0.0f);
        ObjectAnimator objectAnimator = this.titleBarAlphaAnim;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(titleBar, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(83L);
        objectAnimatorOfFloat.setStartDelay(83L);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        objectAnimatorOfFloat.start();
        this.titleBarAlphaAnim = objectAnimatorOfFloat;
    }

    public final void T() {
        if (this.glassHandles.isEmpty()) {
            return;
        }
        for (y7.E e10 : this.glassHandles) {
            try {
                Result.Companion companion = Result.INSTANCE;
                e10.g();
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
        this.glassHandles.clear();
    }

    public final File U(String source) {
        File file = new File(source);
        if (!file.exists()) {
            file = null;
        }
        if (file != null) {
            return file;
        }
        try {
            return Glide.with(this.context).asFile().load(source).submit().get();
        } catch (Exception e10) {
            C4148a.u(TAG, "resolveFile download failed: " + e10.getMessage(), false, 4, null);
            return null;
        }
    }

    public final boolean V(String source) {
        OutputStream outputStreamOpenOutputStream;
        File fileU = U(source);
        if (fileU == null) {
            return false;
        }
        try {
            Companion companion = INSTANCE;
            String strE = companion.e(source);
            String strG = companion.g(strE);
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", "IMG_" + System.currentTimeMillis() + strE);
            contentValues.put("mime_type", strG);
            contentValues.put("relative_path", Environment.DIRECTORY_PICTURES);
            Uri uriInsert = this.context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            if (uriInsert == null || (outputStreamOpenOutputStream = this.context.getContentResolver().openOutputStream(uriInsert)) == null) {
                return false;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(fileU);
                try {
                    C4877a.b(fileInputStream, outputStreamOpenOutputStream, 0, 2, null);
                    l9.b.a(fileInputStream, null);
                    l9.b.a(outputStreamOpenOutputStream, null);
                    return true;
                } finally {
                }
            } finally {
            }
        } catch (Exception e10) {
            C4148a.u(TAG, "saveImage failed: " + e10.getMessage(), false, 4, null);
            return false;
        }
    }

    public final void W(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onEndAction = interfaceC5063a;
    }

    public final void X() {
        if (this.container == null) {
            throw new IllegalArgumentException("container can not be null");
        }
        if (this.rootView == null) {
            I();
        }
        ViewGroup viewGroup = this.container;
        if (viewGroup != null) {
            c cVar = this.rootView;
            if (cVar == null) {
                kotlin.jvm.internal.p.A("rootView");
                cVar = null;
            }
            viewGroup.addView(cVar);
        }
        this.isShowingView.set(true);
        currentInContainer = this;
    }

    public final void Y() {
        View view = this.currentToast;
        ViewGroup viewGroup = null;
        if (view != null) {
            c cVar = this.rootView;
            if (cVar == null) {
                kotlin.jvm.internal.p.A("rootView");
                cVar = null;
            }
            cVar.removeView(view);
        }
        final TextView textView = new TextView(this.context);
        textView.setText("已保存到本地");
        textView.setTextSize(14.0f);
        textView.setTextColor(-16777216);
        textView.setPadding(H(36), H(12), H(36), H(12));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(H(8));
        gradientDrawable.setColor(-1);
        gradientDrawable.setStroke(1, 218103808);
        textView.setBackground(gradientDrawable);
        textView.setElevation(H(8));
        textView.setAlpha(0.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = H(90);
        textView.setLayoutParams(layoutParams);
        this.currentToast = textView;
        c cVar2 = this.rootView;
        if (cVar2 == null) {
            kotlin.jvm.internal.p.A("rootView");
        } else {
            viewGroup = cVar2;
        }
        viewGroup.addView(textView);
        textView.animate().alpha(1.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.stepos.agentframework.util.h
            @Override // java.lang.Runnable
            public final void run() {
                u.Z(textView, this);
            }
        }).start();
    }

    public final int c0() {
        int identifier = this.context.getResources().getIdentifier("status_bar_height", "dimen", UxipConstants.f30662a);
        return identifier > 0 ? this.context.getResources().getDimensionPixelSize(identifier) : H(40);
    }

    public final void w(View target) {
        try {
            target.setOutlineProvider(new e(H(22)));
            target.setClipToOutline(true);
            y7.E eU = y7.H.a(s7.p.f40121a, target).x(false).i(y7.o.INSTANCE.l()).u();
            if (eU.c() == 0) {
                eU.g();
                C4148a.k(TAG, "attachButtonGlass: fully degraded, keep fallback bg", false, 4, null);
            } else {
                this.glassHandles.add(eU);
                target.addOnAttachStateChangeListener(new f(eU));
            }
        } catch (Throwable th) {
            C4148a.u(TAG, "attachButtonGlass: fallback to solid bg, " + th.getMessage(), false, 4, null);
        }
    }

    public final ImageView x(int iconRes, final InterfaceC5063a<Y8.t> onClick) {
        final ImageView imageView = new ImageView(this.context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(H(44), H(44)));
        imageView.setBackgroundResource(R$drawable.bg_agent_preview_top_btn);
        imageView.setPadding(H(11), H(11), H(11), H(11));
        imageView.setImageResource(iconRes);
        imageView.setImageTintList(ColorStateList.valueOf(-1));
        imageView.setClickable(true);
        imageView.setFocusable(true);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.util.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.y(onClick, view);
            }
        });
        imageView.post(new Runnable() { // from class: com.stepos.agentframework.util.f
            @Override // java.lang.Runnable
            public final void run() {
                u.z(imageView, this);
            }
        });
        return imageView;
    }

    public /* synthetic */ u(Context context, List list, int i10, ViewGroup viewGroup, boolean z10, boolean z11, int i11, kotlin.jvm.internal.i iVar) {
        this(context, list, (i11 & 4) != 0 ? 0 : i10, (i11 & 8) != 0 ? null : viewGroup, (i11 & 16) != 0 ? false : z10, (i11 & 32) != 0 ? true : z11);
    }
}
