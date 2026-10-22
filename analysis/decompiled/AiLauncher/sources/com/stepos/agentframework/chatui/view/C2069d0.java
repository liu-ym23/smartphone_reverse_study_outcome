package com.stepos.agentframework.chatui.view;

import android.content.ActivityNotFoundException;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.stepos.agentframework.R$anim;
import com.stepos.agentframework.R$drawable;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import com.stepos.agentframework.R$string;
import com.stepos.agentframework.chatui.panelui.PanelHomePolicy;
import com.stepos.agentframework.chatui.view.C2069d0;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ame.sdk.SkillStoreKt;
import h8.C4148a;
import io.ktor.http.LinkHeader;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.ReferenceSource;
import kotlin.Result;
import net.sqlcipher.database.SQLiteDatabase;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001I\u0018\u0000 L2\u00020\u0001:\u0002MNB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001f\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0004\b!\u0010\u000fJ\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\u0017J\u000f\u0010#\u001a\u00020\u000bH\u0002¢\u0006\u0004\b#\u0010\u000fJ\u000f\u0010$\u001a\u00020\u000bH\u0002¢\u0006\u0004\b$\u0010\u000fJ\u000f\u0010%\u001a\u00020\u000bH\u0002¢\u0006\u0004\b%\u0010\u000fJ\u0017\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\tH\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00102\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u000bH\u0002¢\u0006\u0004\b-\u0010\u000fJ\u0017\u0010.\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b.\u0010/J\u0011\u00101\u001a\u0004\u0018\u000100H\u0002¢\u0006\u0004\b1\u00102R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00103R\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00107\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u001e\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010?\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010\u0014R\u0018\u0010F\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010BR\u0014\u0010J\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006O"}, d2 = {"Lcom/stepos/agentframework/chatui/view/d0;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "", "LK6/A;", SystemDeleteBroadcastReceiver.EXTRA_SOURCES, "LY8/t;", "G", "(Landroid/view/View;Ljava/util/List;)V", "v", "()V", "", "z", "()Z", "Q", "F", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "p", "(Landroid/view/View;)V", "host", "", ExifInterface.LONGITUDE_EAST, "(Landroid/view/View;)I", "t", "()I", "leftMarginPx", "B", "(Landroid/view/View;I)I", "D", "r", "u", "C", "R", "source", "x", "(LK6/A;)V", "", "url", "y", "(Ljava/lang/String;)Z", "P", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;)V", "Lcom/stepos/agentframework/chatui/view/P;", "w", "()Lcom/stepos/agentframework/chatui/view/P;", "Landroid/content/Context;", "Landroid/view/ViewGroup;", "overlay", "Landroid/view/ViewGroup;", "panel", "Landroid/view/View;", "Ly7/E;", "materialHandle", "Ly7/E;", "Ljava/lang/ref/WeakReference;", "ownerRootRef", "Ljava/lang/ref/WeakReference;", "panelLayerId", "Ljava/lang/String;", "recentsSuspended", "Z", "", "recentsSavedAlpha", "Landroid/view/View$OnLayoutChangeListener;", "hostLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "configCallbacksRegistered", "com/stepos/agentframework/chatui/view/d0$e", "configCallbacks", "Lcom/stepos/agentframework/chatui/view/d0$e;", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.view.d0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2069d0 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float PANEL_CORNER_RADIUS_DP = 24.0f;
    private static final int PANEL_HEIGHT_DP = 424;
    private static final int PANEL_LEFT_MARGIN_DP = 8;
    private static final int PANEL_TOP_DP = 357;
    private static final int PANEL_WIDTH_DP = 352;
    private static final String TAG = "SourcesPanelPopup";
    private static final Set<C2069d0> activeInstances;
    private final e configCallbacks;
    private boolean configCallbacksRegistered;
    private final Context context;
    private View.OnLayoutChangeListener hostLayoutListener;
    private y7.E materialHandle;
    private ViewGroup overlay;
    private WeakReference<View> ownerRootRef;
    private View panel;
    private String panelLayerId;
    private float recentsSavedAlpha;
    private boolean recentsSuspended;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/agentframework/chatui/view/d0$a;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_APIKEY, "Landroid/view/View;", "ownerRoot", "", "c", "(Landroid/view/View;)Z", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "(Landroid/view/View;Landroid/view/View;)Z", "", "TAG", "Ljava/lang/String;", "", "Lcom/stepos/agentframework/chatui/view/d0;", "activeInstances", "Ljava/util/Set;", "", "PANEL_WIDTH_DP", "I", "PANEL_HEIGHT_DP", "PANEL_TOP_DP", "PANEL_LEFT_MARGIN_DP", "", "PANEL_CORNER_RADIUS_DP", "F", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.view.d0$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a() {
            Iterator it = Z8.F.m1(C2069d0.activeInstances).iterator();
            while (it.hasNext()) {
                try {
                    ((C2069d0) it.next()).v();
                } catch (Throwable th) {
                    C4148a.u(C2069d0.TAG, "dismissAll: dismiss threw " + th.getMessage(), false, 4, null);
                }
            }
        }

        public final boolean b(View ownerRoot) {
            return c(ownerRoot);
        }

        public final boolean c(View ownerRoot) {
            Object objB;
            boolean z10 = false;
            for (C2069d0 c2069d0 : Z8.F.m1(C2069d0.activeInstances)) {
                WeakReference weakReference = c2069d0.ownerRootRef;
                View view = weakReference != null ? (View) weakReference.get() : null;
                if (ownerRoot == null || view == null || C2069d0.INSTANCE.d(view, ownerRoot)) {
                    if (c2069d0.z()) {
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            c2069d0.v();
                            z10 = true;
                            objB = Result.b(Y8.t.f7040a);
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objB = Result.b(C4849c.a(th));
                        }
                        Throwable thE = Result.e(objB);
                        if (thE != null) {
                            C4148a.u(C2069d0.TAG, "dismissForOwner: dismiss threw " + thE.getMessage(), false, 4, null);
                        }
                    }
                }
            }
            return z10;
        }

        public final boolean d(View a10, View b10) {
            return a10 == b10 || a10.getRootView() == b10.getRootView();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB)\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/stepos/agentframework/chatui/view/d0$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/agentframework/chatui/view/d0$b$a;", "", "LK6/A;", "data", "Lkotlin/Function1;", "LY8/t;", "onItemClick", "<init>", "(Ljava/util/List;Lp9/l;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "f", "(Landroid/view/ViewGroup;I)Lcom/stepos/agentframework/chatui/view/d0$b$a;", "getItemCount", "()I", "holder", "position", Const.INTENT_KEY_UMID, "(Lcom/stepos/agentframework/chatui/view/d0$b$a;I)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/agentframework/chatui/view/d0$b$a;)V", "Ljava/util/List;", "Lp9/l;", "", "showSite", "Z", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.view.d0$b */
    public static final class b extends RecyclerView.Adapter<a> {
        private final List<ReferenceSource> data;
        private final InterfaceC5074l<ReferenceSource, Y8.t> onItemClick;
        private final boolean showSite;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/stepos/agentframework/chatui/view/d0$b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "Landroid/widget/ImageView;", "icon", "Landroid/widget/ImageView;", Const.INTENT_KEY_APIKEY, "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "site", "Landroid/widget/TextView;", Const.INTENT_KEY_PKGNAME, "()Landroid/widget/TextView;", "title", "getTitle", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.agentframework.chatui.view.d0$b$a */
        public static final class a extends RecyclerView.ViewHolder {
            private final ImageView icon;
            private final TextView site;
            private final TextView title;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(View view) {
                super(view);
                kotlin.jvm.internal.p.i(view, "view");
                View viewFindViewById = view.findViewById(R$id.iv_source_icon);
                kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
                this.icon = (ImageView) viewFindViewById;
                View viewFindViewById2 = view.findViewById(R$id.tv_source_site);
                kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
                this.site = (TextView) viewFindViewById2;
                View viewFindViewById3 = view.findViewById(R$id.tv_source_title);
                kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
                this.title = (TextView) viewFindViewById3;
            }

            /* renamed from: a, reason: from getter */
            public final ImageView getIcon() {
                return this.icon;
            }

            /* renamed from: b, reason: from getter */
            public final TextView getSite() {
                return this.site;
            }

            public final TextView getTitle() {
                return this.title;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<ReferenceSource> data, InterfaceC5074l<? super ReferenceSource, Y8.t> onItemClick) {
            kotlin.jvm.internal.p.i(data, "data");
            kotlin.jvm.internal.p.i(onItemClick, "onItemClick");
            this.data = data;
            this.onItemClick = onItemClick;
            List<ReferenceSource> list = data;
            boolean z10 = true;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (La.H.x0(((ReferenceSource) it.next()).getSiteName())) {
                        z10 = false;
                        break;
                    }
                }
            }
            this.showSite = z10;
        }

        public static final void e(b bVar, ReferenceSource referenceSource, View view) {
            bVar.onItemClick.invoke(referenceSource);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a holder, int position) {
            kotlin.jvm.internal.p.i(holder, "holder");
            final ReferenceSource referenceSource = this.data.get(position);
            holder.getSite().setVisibility(this.showSite ? 0 : 8);
            if (this.showSite) {
                holder.getSite().setText(referenceSource.getSiteName());
            }
            String pageTitle = referenceSource.getPageTitle();
            if (La.H.x0(pageTitle)) {
                pageTitle = referenceSource.getUrl();
            }
            holder.getTitle().setText(pageTitle);
            if (La.H.x0(referenceSource.getIconUrl())) {
                Glide.with(holder.getIcon()).clear(holder.getIcon());
                holder.getIcon().setImageResource(R$drawable.ic_source_globe);
            } else {
                RequestBuilder<Drawable> requestBuilderLoad = Glide.with(holder.getIcon()).load(referenceSource.getIconUrl());
                int i10 = R$drawable.ic_source_globe;
                kotlin.jvm.internal.p.f(requestBuilderLoad.placeholder(i10).error(i10).transform(new CircleCrop()).into(holder.getIcon()));
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.view.e0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C2069d0.b.e(this.f23116a, referenceSource, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(ViewGroup parent, int viewType) {
            kotlin.jvm.internal.p.i(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_source_row, parent, false);
            kotlin.jvm.internal.p.f(viewInflate);
            return new a(viewInflate);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onViewRecycled(a holder) {
            kotlin.jvm.internal.p.i(holder, "holder");
            Glide.with(holder.getIcon()).clear(holder.getIcon());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.data.size();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/agentframework/chatui/view/d0$c", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.view.d0$c */
    public static final class c extends ViewOutlineProvider {
        final /* synthetic */ float $radiusPx;

        public c(float f10) {
            this.$radiusPx = f10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.$radiusPx);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/agentframework/chatui/view/d0$d", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.view.d0$d */
    public static final class d implements View.OnAttachStateChangeListener {
        public d() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            v10.removeOnAttachStateChangeListener(this);
            y7.E e10 = C2069d0.this.materialHandle;
            C2069d0.this.materialHandle = null;
            if (e10 != null) {
                e10.g();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/agentframework/chatui/view/d0$e", "Landroid/content/ComponentCallbacks;", "Landroid/content/res/Configuration;", "newConfig", "LY8/t;", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onLowMemory", "()V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.view.d0$e */
    public static final class e implements ComponentCallbacks {
        public e() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration newConfig) {
            kotlin.jvm.internal.p.i(newConfig, "newConfig");
            C2069d0.this.D();
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }
    }

    static {
        Set<C2069d0> setNewSetFromMap = Collections.newSetFromMap(new WeakHashMap());
        kotlin.jvm.internal.p.h(setNewSetFromMap, "newSetFromMap(...)");
        activeInstances = setNewSetFromMap;
    }

    public C2069d0(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        this.context = context;
        this.recentsSavedAlpha = 1.0f;
        this.configCallbacks = new e();
    }

    public static final Y8.t H(C2069d0 c2069d0, ReferenceSource it) {
        kotlin.jvm.internal.p.i(it, "it");
        c2069d0.x(it);
        return Y8.t.f7040a;
    }

    public static final void I(C2069d0 c2069d0, View view) {
        c2069d0.v();
    }

    public static final boolean J(C2069d0 c2069d0, View view, int i10, KeyEvent keyEvent) {
        if (i10 != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        c2069d0.v();
        return true;
    }

    public static final void K(C2069d0 c2069d0, View view) {
        c2069d0.v();
    }

    public static final boolean L(C2069d0 c2069d0) {
        return c2069d0.z();
    }

    public static final Y8.t M(C2069d0 c2069d0) {
        c2069d0.v();
        return Y8.t.f7040a;
    }

    public static final boolean N(C2069d0 c2069d0) {
        return c2069d0.Q();
    }

    public static final boolean O(C2069d0 c2069d0) {
        return c2069d0.F();
    }

    public static final void q(View view, float f10, C2069d0 c2069d0) {
        if (!view.isAttachedToWindow()) {
            C4148a.k(TAG, "glass skipped: content already detached", false, 4, null);
            return;
        }
        y7.E eU = y7.H.a(s7.p.f40121a, view).x(false).i(y7.o.INSTANCE.h()).w(f10).u();
        if (eU.c() == 0) {
            C4148a.k(TAG, "glass fully degraded, fallback to bg_sources_panel", false, 4, null);
            eU.g();
            c2069d0.materialHandle = null;
            return;
        }
        c2069d0.materialHandle = eU;
        C4148a.d(TAG, "glass attached activeCount=" + eU.c() + " ids=" + eU.d(), false, 4, null);
        view.addOnAttachStateChangeListener(c2069d0.new d());
    }

    public static final void s(View view, C2069d0 c2069d0, View view2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int i18 = i16 - i14;
        int width = view.getWidth();
        if (width <= 0 || width == i18) {
            return;
        }
        c2069d0.D();
    }

    public final void A(String url) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        try {
            P pW = w();
            if (pW != null) {
                pW.a();
            }
            this.context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            C4148a.u(TAG, "no browser to open " + url, false, 4, null);
            P();
        } catch (Throwable th) {
            C4148a.u(TAG, "openInBrowser failed: " + th.getMessage(), false, 4, null);
            P();
        }
    }

    public final int B(View host, int leftMarginPx) {
        int iE = E(host);
        return C5685n.n(iE - (leftMarginPx * 2), 0, iE);
    }

    public final void C() {
        Object objB;
        if (this.configCallbacksRegistered) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            this.context.getApplicationContext().registerComponentCallbacks(this.configCallbacks);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u(TAG, "registerComponentCallbacks failed: " + thE.getMessage(), false, 4, null);
        }
        if (Result.h(objB)) {
            this.configCallbacksRegistered = true;
        }
    }

    public final void D() {
        View view = this.panel;
        if (view != null) {
            ViewGroup viewGroup = this.overlay;
            if (viewGroup == null || !viewGroup.isAttachedToWindow()) {
                view = null;
            }
            if (view == null) {
                return;
            }
            WeakReference<View> weakReference = this.ownerRootRef;
            View view2 = weakReference != null ? weakReference.get() : null;
            O6.d dVar = O6.d.INSTANCE;
            int iA = dVar.a(this.context, 8.0f);
            int iB = B(view2, iA);
            int iA2 = dVar.a(this.context, 424.0f);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 == null) {
                return;
            }
            int iA3 = dVar.a(this.context, 357.0f);
            int i10 = layoutParams2.width;
            if (i10 == iB && layoutParams2.height == iA2 && layoutParams2.leftMargin == iA && layoutParams2.topMargin == iA3) {
                return;
            }
            Integer numValueOf = view2 != null ? Integer.valueOf(view2.getWidth()) : null;
            C4148a.d(TAG, "relayout width=" + i10 + "->" + iB + " host=" + numValueOf + " screen=" + t(), false, 4, null);
            layoutParams2.width = iB;
            layoutParams2.height = iA2;
            layoutParams2.leftMargin = iA;
            layoutParams2.topMargin = iA3;
            view.setLayoutParams(layoutParams2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int E(android.view.View r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L19
            int r2 = r2.getWidth()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r0 = r2.intValue()
            if (r0 <= 0) goto L11
            goto L12
        L11:
            r2 = 0
        L12:
            if (r2 == 0) goto L19
            int r2 = r2.intValue()
            goto L1a
        L19:
            r2 = 0
        L1a:
            int r0 = r1.t()
            if (r2 <= 0) goto L27
            if (r0 <= 0) goto L27
            int r1 = java.lang.Math.min(r2, r0)
            return r1
        L27:
            if (r2 <= 0) goto L2a
            return r2
        L2a:
            if (r0 <= 0) goto L2d
            return r0
        L2d:
            android.content.Context r1 = r1.context
            android.content.res.Resources r1 = r1.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            int r2 = r1.widthPixels
            int r1 = r1.heightPixels
            int r1 = java.lang.Math.min(r2, r1)
            r2 = 1
            int r1 = v9.C5685n.f(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.view.C2069d0.E(android.view.View):int");
    }

    public final boolean F() {
        ViewGroup viewGroup = this.overlay;
        if (viewGroup != null) {
            if (!viewGroup.isAttachedToWindow()) {
                viewGroup = null;
            }
            if (viewGroup != null) {
                if (!this.recentsSuspended) {
                    return true;
                }
                viewGroup.setAlpha(this.recentsSavedAlpha);
                viewGroup.setClickable(true);
                viewGroup.setFocusable(true);
                viewGroup.setFocusableInTouchMode(true);
                this.recentsSuspended = false;
                return true;
            }
        }
        return false;
    }

    public final void G(View anchor, List<ReferenceSource> sources) {
        kotlin.jvm.internal.p.i(anchor, "anchor");
        kotlin.jvm.internal.p.i(sources, "sources");
        if (sources.isEmpty()) {
            return;
        }
        v();
        View rootView = anchor.getRootView();
        ViewGroup viewGroup = rootView instanceof ViewGroup ? (ViewGroup) rootView : null;
        if (viewGroup == null) {
            C4148a.u(TAG, "show skipped: rootView is not ViewGroup", false, 4, null);
            return;
        }
        View viewInflate = LayoutInflater.from(this.context).inflate(R$layout.layout_sources_panel, viewGroup, false);
        TextView textView = (TextView) viewInflate.findViewById(R$id.tv_sources_panel_title);
        ImageView imageView = (ImageView) viewInflate.findViewById(R$id.iv_sources_panel_close);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R$id.rv_sources_list);
        textView.setText(this.context.getString(R$string.chat_sources_count, Integer.valueOf(sources.size())));
        recyclerView.setLayoutManager(new LinearLayoutManager(this.context));
        recyclerView.setAdapter(new b(sources, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.view.T
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C2069d0.H(this.f23099a, (ReferenceSource) obj);
            }
        }));
        O6.d dVar = O6.d.INSTANCE;
        int iA = dVar.a(this.context, 8.0f);
        int iB = B(viewGroup, iA);
        int iA2 = dVar.a(this.context, 424.0f);
        int iA3 = dVar.a(this.context, 357.0f);
        FrameLayout frameLayout = new FrameLayout(this.context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setClickable(true);
        frameLayout.setFocusable(true);
        frameLayout.setFocusableInTouchMode(true);
        frameLayout.setBackgroundColor(0);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.view.U
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2069d0.I(this.f23100a, view);
            }
        });
        frameLayout.setOnKeyListener(new View.OnKeyListener() { // from class: com.stepos.agentframework.chatui.view.V
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
                return C2069d0.J(this.f23101a, view, i10, keyEvent);
            }
        });
        viewInflate.setClickable(true);
        viewInflate.setElevation(dVar.a(this.context, 8.0f));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iB, iA2);
        layoutParams.gravity = 8388659;
        layoutParams.leftMargin = iA;
        layoutParams.topMargin = iA3;
        Y8.t tVar = Y8.t.f7040a;
        frameLayout.addView(viewInflate, layoutParams);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.view.W
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2069d0.K(this.f23102a, view);
            }
        });
        try {
            viewGroup.addView(frameLayout);
            frameLayout.requestFocus();
            try {
                Result.Companion companion = Result.INSTANCE;
                viewInflate.startAnimation(AnimationUtils.loadAnimation(this.context, R$anim.sources_panel_enter));
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
            C4148a.d(TAG, "show in-window width=" + iB + " host=" + viewGroup.getWidth() + " screen=" + t() + " dm=" + this.context.getResources().getDisplayMetrics().widthPixels + "x" + this.context.getResources().getDisplayMetrics().heightPixels, false, 4, null);
            this.overlay = frameLayout;
            this.panel = viewInflate;
            this.recentsSuspended = false;
            this.ownerRootRef = new WeakReference<>(viewGroup);
            r(viewGroup);
            C();
            activeInstances.add(this);
            com.stepos.agentframework.chatui.panelui.f fVar = com.stepos.agentframework.chatui.panelui.f.INSTANCE;
            String strA = fVar.a("sources_panel");
            this.panelLayerId = strA;
            fVar.b(strA, PanelHomePolicy.DISMISS_TOP_ONLY, viewGroup, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.view.X
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(C2069d0.L(this.f23103a));
                }
            }, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.view.Y
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return C2069d0.M(this.f23104a);
                }
            }, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.view.Z
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(C2069d0.N(this.f23105a));
                }
            }, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.view.a0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(C2069d0.O(this.f23107a));
                }
            });
            kotlin.jvm.internal.p.f(viewInflate);
            p(viewInflate);
        } catch (Throwable th2) {
            C4148a.u(TAG, "host.addView failed: " + th2.getMessage(), false, 4, null);
        }
    }

    public final void P() {
        Toast.makeText(this.context.getApplicationContext(), R$string.chat_sources_link_unavailable, 0).show();
    }

    public final boolean Q() {
        ViewGroup viewGroup = this.overlay;
        if (viewGroup != null) {
            if (!viewGroup.isAttachedToWindow()) {
                viewGroup = null;
            }
            if (viewGroup != null) {
                if (this.recentsSuspended) {
                    return true;
                }
                this.recentsSavedAlpha = viewGroup.getAlpha();
                viewGroup.setAlpha(0.0f);
                viewGroup.setClickable(false);
                viewGroup.setFocusable(false);
                this.recentsSuspended = true;
                return true;
            }
        }
        return false;
    }

    public final void R() {
        if (this.configCallbacksRegistered) {
            try {
                Result.Companion companion = Result.INSTANCE;
                this.context.getApplicationContext().unregisterComponentCallbacks(this.configCallbacks);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
            this.configCallbacksRegistered = false;
        }
    }

    public final void p(final View content) {
        final float f10 = content.getResources().getDisplayMetrics().density * 24.0f;
        content.setClipToOutline(true);
        content.setOutlineProvider(new c(f10));
        content.post(new Runnable() { // from class: com.stepos.agentframework.chatui.view.c0
            @Override // java.lang.Runnable
            public final void run() {
                C2069d0.q(content, f10, this);
            }
        });
    }

    public final void r(final View host) {
        u();
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.stepos.agentframework.chatui.view.b0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                C2069d0.s(host, this, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        };
        this.hostLayoutListener = onLayoutChangeListener;
        host.addOnLayoutChangeListener(onLayoutChangeListener);
    }

    public final int t() {
        Object systemService = this.context.getSystemService("window");
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager == null) {
            return 0;
        }
        int iWidth = windowManager.getMaximumWindowMetrics().getBounds().width();
        if (iWidth > 0) {
            return iWidth;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        Integer numValueOf = Integer.valueOf(displayMetrics.widthPixels);
        Integer num = numValueOf.intValue() > 0 ? numValueOf : null;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final void u() {
        WeakReference<View> weakReference = this.ownerRootRef;
        View view = weakReference != null ? weakReference.get() : null;
        View.OnLayoutChangeListener onLayoutChangeListener = this.hostLayoutListener;
        if (view != null && onLayoutChangeListener != null) {
            view.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
        this.hostLayoutListener = null;
    }

    public final void v() {
        String str = this.panelLayerId;
        if (str != null) {
            com.stepos.agentframework.chatui.panelui.f.INSTANCE.c(str);
            this.panelLayerId = null;
        }
        u();
        R();
        ViewGroup viewGroup = this.overlay;
        this.overlay = null;
        this.panel = null;
        this.recentsSuspended = false;
        this.ownerRootRef = null;
        if (viewGroup != null) {
            ViewParent parent = viewGroup.getParent();
            ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup2 != null) {
                viewGroup2.removeView(viewGroup);
            }
        }
        y7.E e10 = this.materialHandle;
        if (e10 != null) {
            e10.g();
        }
        this.materialHandle = null;
        activeInstances.remove(this);
    }

    public final P w() {
        Object baseContext = this.context;
        while (baseContext != null) {
            if (baseContext instanceof P) {
                return (P) baseContext;
            }
            ContextWrapper contextWrapper = baseContext instanceof ContextWrapper ? (ContextWrapper) baseContext : null;
            baseContext = contextWrapper != null ? contextWrapper.getBaseContext() : null;
        }
        return null;
    }

    public final void x(ReferenceSource source) {
        String url = source.getUrl();
        if (y(url)) {
            v();
            A(url);
        } else {
            P();
            v();
        }
    }

    public final boolean y(String url) {
        if (La.H.x0(url)) {
            return false;
        }
        String str = null;
        try {
            String scheme = Uri.parse(url).getScheme();
            if (scheme != null) {
                String lowerCase = scheme.toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
                str = lowerCase;
            }
        } catch (Throwable unused) {
        }
        return kotlin.jvm.internal.p.d(str, "http") || kotlin.jvm.internal.p.d(str, "https");
    }

    public final boolean z() {
        ViewGroup viewGroup = this.overlay;
        return viewGroup != null && viewGroup.isAttachedToWindow();
    }
}
