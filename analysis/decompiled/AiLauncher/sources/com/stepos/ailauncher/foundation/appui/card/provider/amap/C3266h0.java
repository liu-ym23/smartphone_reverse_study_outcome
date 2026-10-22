package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import N5.CardAction;
import N5.CardEnvelope;
import Z8.C1173v;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.uikit.IndeterminateSpinnerView;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.amap.route.GeoPoint;
import com.stepos.ailauncher.common.imageloader.ImageRequest;
import com.stepos.ailauncher.foundation.R$color;
import com.stepos.ailauncher.foundation.R$dimen;
import com.stepos.ailauncher.foundation.R$drawable;
import com.stepos.ailauncher.foundation.appui.card.provider.amap.C3266h0;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000£\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001\\\u0018\u0000 _2\u00020\u0001:\u0002`aB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u0010J\u000f\u0010\u001b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001b\u0010\u0010J\u000f\u0010\u001c\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001c\u0010\u0010J\u000f\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u0010J\u000f\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u0010J\u000f\u0010\u001f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010\u0010J\u000f\u0010 \u001a\u00020\fH\u0002¢\u0006\u0004\b \u0010\u0010J\u000f\u0010!\u001a\u00020\fH\u0002¢\u0006\u0004\b!\u0010\u0010J\u000f\u0010\"\u001a\u00020\fH\u0002¢\u0006\u0004\b\"\u0010\u0010J\u000f\u0010#\u001a\u00020\fH\u0002¢\u0006\u0004\b#\u0010\u0010J\u0017\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J3\u0010.\u001a\b\u0012\u0004\u0012\u00020-0(2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\f2\u0006\u00100\u001a\u00020\u0006H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\f2\u0006\u00103\u001a\u00020\u0006H\u0002¢\u0006\u0004\b4\u00102J\u0019\u00107\u001a\u00020\f2\b\b\u0002\u00106\u001a\u000205H\u0002¢\u0006\u0004\b7\u00108J\u001f\u0010=\u001a\u00020\f2\u0006\u0010:\u001a\u0002092\u0006\u0010<\u001a\u00020;H\u0002¢\u0006\u0004\b=\u0010>J\u001f\u0010?\u001a\u00020\f2\u0006\u00103\u001a\u00020\u00062\u0006\u0010<\u001a\u00020;H\u0002¢\u0006\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020;0(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010J\u001a\u00020I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u001c\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010HR\u0016\u0010N\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010P\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010KR\u0016\u0010Q\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010RR\u0016\u0010T\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010Y\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010ZR\u0014\u0010]\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^¨\u0006b"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/h0;", "LN5/d;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/widget/FrameLayout;", "container", "LY8/t;", ExifInterface.LONGITUDE_EAST, "(Landroid/widget/FrameLayout;)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "LN5/n;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "C", "(LN5/n;)V", "LN5/i;", "envelope", "D", "(LN5/i;LN5/n;)V", "B0", "x0", "v0", "i0", "j0", "l0", "k0", "t0", "h0", "o0", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/k0;", "marker", "n0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/k0;)V", "", "Lcom/stepos/ailauncher/amap/route/x;", "points", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroid/graphics/PointF;", "s0", "(Ljava/util/List;II)Ljava/util/List;", "position", "q0", "(I)V", "index", "f0", "", "forceResnap", "setupPoiCardsPager", "(Z)V", "Landroid/widget/TextView;", "tv", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/L;", "poi", "g0", "(Landroid/widget/TextView;Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/L;)V", "r0", "(ILcom/stepos/ailauncher/foundation/appui/card/provider/amap/L;)V", "LT5/t;", "listBinding", "LT5/t;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/y;", "overviewBinder", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/y;", "poiItems", "Ljava/util/List;", "", "cardId", "Ljava/lang/String;", "", "markerViews", "selectedIndex", "I", "lastSignature", "mapOverlayShown", "Z", "mapVisualReady", "poiCardsPagerTouchInstalled", "Landroid/view/View$OnLayoutChangeListener;", "markerLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "Ljava/lang/Runnable;", "overlayRepinRunnable", "Ljava/lang/Runnable;", "overlayRefreshRunnable", "com/stepos/ailauncher/foundation/appui/card/provider/amap/h0$c", "pageChangeCallback", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/h0$c;", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.h0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3266h0 extends N5.d {
    private static final a Companion = new a(null);

    @Deprecated
    public static final long OVERLAY_REFRESH_DELAY_MS = 350;

    @Deprecated
    public static final long OVERLAY_REPIN_DELAY_MS = 500;

    @Deprecated
    public static final String TAG = "PoiListCardView";
    private String cardId;
    private String lastSignature;
    private T5.t listBinding;
    private boolean mapOverlayShown;
    private boolean mapVisualReady;
    private View.OnLayoutChangeListener markerLayoutListener;
    private final List<k0> markerViews;
    private Runnable overlayRefreshRunnable;
    private Runnable overlayRepinRunnable;
    private C3284y overviewBinder;
    private final c pageChangeCallback;
    private boolean poiCardsPagerTouchInstalled;
    private List<PoiBrief> poiItems;
    private int selectedIndex;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/h0$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "", "OVERLAY_REPIN_DELAY_MS", "J", "OVERLAY_REFRESH_DELAY_MS", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.h0$a */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u001bB\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\r\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0018\u001a\u00020\u00172\u000e\u0010\u0015\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/h0$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/h0$b$a;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/h0;", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/L;", DidiCardProvider.KEY_ITEMS, "<init>", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/h0;Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/h0$b$a;", "getItemCount", "()I", "other", "", Const.INTENT_KEY_UMID, "(Ljava/util/List;)Z", "holder", "position", "LY8/t;", "e", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/h0$b$a;I)V", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.h0$b */
    public final class b extends RecyclerView.Adapter<a> {
        private final List<PoiBrief> items;
        final /* synthetic */ C3266h0 this$0;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/h0$b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "LT5/r;", "binding", "<init>", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/h0$b;LT5/r;)V", "LT5/r;", Const.INTENT_KEY_APIKEY, "()LT5/r;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.h0$b$a */
        public final class a extends RecyclerView.ViewHolder {
            private final T5.r binding;
            final /* synthetic */ b this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, T5.r binding) {
                super(binding.b());
                kotlin.jvm.internal.p.i(binding, "binding");
                this.this$0 = bVar;
                this.binding = binding;
            }

            /* renamed from: a, reason: from getter */
            public final T5.r getBinding() {
                return this.binding;
            }
        }

        public b(C3266h0 c3266h0, List<PoiBrief> items) {
            kotlin.jvm.internal.p.i(items, "items");
            this.this$0 = c3266h0;
            this.items = items;
        }

        public static final void f(C3266h0 c3266h0, int i10, PoiBrief poiBrief, View view) {
            c3266h0.r0(i10, poiBrief);
        }

        public final boolean d(List<PoiBrief> other) {
            kotlin.jvm.internal.p.i(other, "other");
            List<PoiBrief> list = this.items;
            return list == other || kotlin.jvm.internal.p.d(list, other);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a holder, final int position) throws Resources.NotFoundException {
            List<String> listF;
            kotlin.jvm.internal.p.i(holder, "holder");
            final PoiBrief poiBrief = this.items.get(position);
            TextView textView = holder.getBinding().tvPoiCardName;
            String strD = N5.j.INSTANCE.d(poiBrief.getName());
            if (strD == null) {
                strD = "";
            }
            textView.setText(strD);
            C3266h0 c3266h0 = this.this$0;
            TextView tvPoiCardMeta = holder.getBinding().tvPoiCardMeta;
            kotlin.jvm.internal.p.h(tvPoiCardMeta, "tvPoiCardMeta");
            c3266h0.g0(tvPoiCardMeta, poiBrief);
            PoiDetailCardItem detail = poiBrief.getDetail();
            String str = (detail == null || (listF = detail.f()) == null) ? null : (String) Z8.F.s0(listF);
            int i10 = (int) (60 * holder.getBinding().b().getResources().getDisplayMetrics().density);
            com.stepos.ailauncher.common.imageloader.g gVar = com.stepos.ailauncher.common.imageloader.g.INSTANCE;
            ImageView ivPoiCardImage = holder.getBinding().ivPoiCardImage;
            kotlin.jvm.internal.p.h(ivPoiCardImage, "ivPoiCardImage");
            int i11 = R$drawable.ic_map_placeholder;
            com.stepos.ailauncher.common.imageloader.g.s(gVar, ivPoiCardImage, new ImageRequest(str, i11, i11, null, null, 8, 0, i10, i10, true, null, true, true, false, false, null, 0.0f, false, 255064, null), null, null, holder.getBinding().b().getContext().getApplicationContext(), 12, null);
            LinearLayout linearLayoutB = holder.getBinding().b();
            final C3266h0 c3266h02 = this.this$0;
            linearLayoutB.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.i0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C3266h0.b.f(c3266h02, position, poiBrief, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(ViewGroup parent, int viewType) {
            kotlin.jvm.internal.p.i(parent, "parent");
            T5.r rVarC = T5.r.c(LayoutInflater.from(parent.getContext()), parent, false);
            kotlin.jvm.internal.p.h(rVarC, "inflate(...)");
            M m10 = M.INSTANCE;
            LinearLayout linearLayoutB = rVarC.b();
            kotlin.jvm.internal.p.h(linearLayoutB, "getRoot(...)");
            m10.a(linearLayoutB);
            return new a(this, rVarC);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.items.size();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/foundation/appui/card/provider/amap/h0$c", "Landroidx/viewpager2/widget/ViewPager2$i;", "", "position", "LY8/t;", "onPageSelected", "(I)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.h0$c */
    public static final class c extends ViewPager2.i {
        public c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageSelected(int position) {
            C3266h0.this.q0(position);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"com/stepos/ailauncher/foundation/appui/card/provider/amap/h0$d", "Landroidx/recyclerview/widget/RecyclerView$SimpleOnItemTouchListener;", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "Landroid/view/MotionEvent;", "e", "", "onInterceptTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)Z", "", "downX", "F", "downY", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.h0$d */
    public static final class d extends RecyclerView.SimpleOnItemTouchListener {
        final /* synthetic */ int $touchSlop;
        private float downX;
        private float downY;

        public d(int i10) {
            this.$touchSlop = i10;
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
        @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onInterceptTouchEvent(androidx.recyclerview.widget.RecyclerView r6, android.view.MotionEvent r7) {
            /*
                r5 = this;
                java.lang.String r0 = "rv"
                kotlin.jvm.internal.p.i(r6, r0)
                java.lang.String r0 = "e"
                kotlin.jvm.internal.p.i(r7, r0)
                int r0 = r7.getActionMasked()
                r1 = 0
                if (r0 == 0) goto L75
                r2 = 1
                if (r0 == r2) goto L6b
                r3 = 2
                if (r0 == r3) goto L1d
                r5 = 3
                if (r0 == r5) goto L6b
                goto L8a
            L1d:
                float r0 = r7.getX()
                float r3 = r5.downX
                float r0 = r0 - r3
                float r7 = r7.getY()
                float r3 = r5.downY
                float r7 = r7 - r3
                float r3 = java.lang.Math.abs(r0)
                float r7 = java.lang.Math.abs(r7)
                int r4 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
                if (r4 <= 0) goto L5d
                int r5 = r5.$touchSlop
                float r5 = (float) r5
                int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r5 <= 0) goto L5d
                r5 = 0
                int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r7 <= 0) goto L49
                r5 = -1
                boolean r5 = r6.canScrollHorizontally(r5)
                goto L53
            L49:
                int r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r5 >= 0) goto L52
                boolean r5 = r6.canScrollHorizontally(r2)
                goto L53
            L52:
                r5 = r1
            L53:
                android.view.ViewParent r6 = r6.getParent()
                if (r6 == 0) goto L8a
                r6.requestDisallowInterceptTouchEvent(r5)
                goto L8a
            L5d:
                int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
                if (r5 <= 0) goto L8a
                android.view.ViewParent r5 = r6.getParent()
                if (r5 == 0) goto L8a
                r5.requestDisallowInterceptTouchEvent(r1)
                goto L8a
            L6b:
                android.view.ViewParent r5 = r6.getParent()
                if (r5 == 0) goto L8a
                r5.requestDisallowInterceptTouchEvent(r1)
                goto L8a
            L75:
                float r0 = r7.getX()
                r5.downX = r0
                float r7 = r7.getY()
                r5.downY = r7
                android.view.ViewParent r5 = r6.getParent()
                if (r5 == 0) goto L8a
                r5.requestDisallowInterceptTouchEvent(r1)
            L8a:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.amap.C3266h0.d.onInterceptTouchEvent(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent):boolean");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3266h0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.poiItems = C1173v.m();
        this.cardId = "";
        this.markerViews = new ArrayList();
        this.pageChangeCallback = new c();
    }

    public static final void A0(C3266h0 c3266h0, boolean z10) throws Resources.NotFoundException {
        c3266h0.setupPoiCardsPager(z10);
    }

    public static final Y8.t C0(C3266h0 c3266h0) throws Resources.NotFoundException {
        c3266h0.j0();
        return Y8.t.f7040a;
    }

    public static final Y8.t D0(C3266h0 c3266h0, String it) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(it, "it");
        c3266h0.mapVisualReady = false;
        c3266h0.j0();
        return Y8.t.f7040a;
    }

    public static final Y8.t E0(C3266h0 c3266h0) {
        if (c3266h0.isAttachedToWindow()) {
            c3266h0.mapVisualReady = true;
            c3266h0.k0();
            c3266h0.t0();
            c3266h0.x0();
        }
        return Y8.t.f7040a;
    }

    public static final void m0(C3266h0 c3266h0) throws Resources.NotFoundException {
        c3266h0.setupPoiCardsPager(true);
    }

    public static final void p0(C3266h0 c3266h0, int i10, View view) {
        M5.a.INSTANCE.a(c3266h0.cardId, M5.a.CARD_TYPE_OVERVIEW, M5.a.ACTION_OPTION_SELECT, Integer.valueOf(i10));
        T5.t tVar = c3266h0.listBinding;
        if (tVar == null) {
            kotlin.jvm.internal.p.A("listBinding");
            tVar = null;
        }
        tVar.vpPoiCards.m(i10, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6, types: [android.view.View] */
    private final void setupPoiCardsPager(final boolean forceResnap) throws Resources.NotFoundException {
        T5.t tVar = this.listBinding;
        if (tVar == null) {
            kotlin.jvm.internal.p.A("listBinding");
            tVar = null;
        }
        ViewPager2 vpPoiCards = tVar.vpPoiCards;
        kotlin.jvm.internal.p.h(vpPoiCards, "vpPoiCards");
        View childAt = vpPoiCards.getChildAt(0);
        RecyclerView recyclerView = childAt instanceof RecyclerView ? (RecyclerView) childAt : null;
        if (recyclerView == null) {
            vpPoiCards.post(new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.Y
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    C3266h0.A0(this.f27220a, forceResnap);
                }
            });
            return;
        }
        Resources resources = getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.card_map_poi_card_edge);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.card_map_poi_card_peek);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R$dimen.card_map_poi_card_gap);
        boolean z10 = (recyclerView.getPaddingLeft() == dimensionPixelSize && recyclerView.getPaddingRight() == dimensionPixelSize2) ? false : true;
        recyclerView.setPadding(dimensionPixelSize, 0, dimensionPixelSize2, 0);
        recyclerView.setClipToPadding(false);
        recyclerView.setClipChildren(true);
        recyclerView.setOverScrollMode(2);
        Object parent = vpPoiCards.getParent();
        ViewGroup viewGroup = parent instanceof View ? (View) parent : null;
        if (viewGroup != null) {
            ViewGroup viewGroup2 = viewGroup instanceof ViewGroup ? viewGroup : null;
            if (viewGroup2 != null) {
                viewGroup2.setClipChildren(true);
            }
            viewGroup.setClipToOutline(false);
        }
        if (z10 || forceResnap) {
            recyclerView.requestLayout();
            vpPoiCards.k();
            if (vpPoiCards.getAdapter() != null) {
                vpPoiCards.m(vpPoiCards.getCurrentItem(), false);
            }
        }
        if (this.poiCardsPagerTouchInstalled) {
            return;
        }
        this.poiCardsPagerTouchInstalled = true;
        vpPoiCards.setPageTransformer(new androidx.viewpager2.widget.d(dimensionPixelSize3));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.addOnItemTouchListener(new d(ViewConfiguration.get(getContext()).getScaledTouchSlop()));
    }

    public static final void u0(FrameLayout frameLayout, C3266h0 c3266h0, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if (frameLayout.getWidth() <= 0 || frameLayout.getHeight() <= 0) {
            return;
        }
        c3266h0.h0();
        c3266h0.o0();
    }

    public static final void w0(C3266h0 c3266h0) {
        c3266h0.overlayRefreshRunnable = null;
        if (c3266h0.isAttachedToWindow()) {
            c3266h0.k0();
            c3266h0.t0();
        }
    }

    public static final void y0(C3266h0 c3266h0) {
        c3266h0.overlayRepinRunnable = null;
        if (c3266h0.isAttachedToWindow()) {
            c3266h0.k0();
        }
    }

    public static /* synthetic */ void z0(C3266h0 c3266h0, boolean z10, int i10, Object obj) throws Resources.NotFoundException {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        c3266h0.setupPoiCardsPager(z10);
    }

    public final void B0() {
        C3284y c3284y = this.overviewBinder;
        if (c3284y != null) {
            c3284y.q0(new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.Z
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return C3266h0.C0(this.f27222a);
                }
            });
        }
        C3284y c3284y2 = this.overviewBinder;
        if (c3284y2 != null) {
            c3284y2.p0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.a0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return C3266h0.D0(this.f27223a, (String) obj);
                }
            });
        }
        C3284y c3284y3 = this.overviewBinder;
        if (c3284y3 != null) {
            c3284y3.o0(null);
        }
        C3284y c3284y4 = this.overviewBinder;
        if (c3284y4 != null) {
            c3284y4.r0(new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.b0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return C3266h0.E0(this.f27224a);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.stepos.ailauncher.amap.route.x] */
    @Override // N5.d
    public void C(N5.n model) throws Resources.NotFoundException {
        T5.t geoPoint;
        Double lat;
        kotlin.jvm.internal.p.i(model, "model");
        if (model instanceof X) {
            X x10 = (X) model;
            this.cardId = x10.getCardId();
            List<PoiBrief> listB = x10.b();
            ArrayList arrayList = new ArrayList();
            Iterator it = listB.iterator();
            while (true) {
                geoPoint = null;
                if (!it.hasNext()) {
                    break;
                }
                LatLng location = ((PoiBrief) it.next()).getLocation();
                if (location != null && (lat = location.getLat()) != null) {
                    double dDoubleValue = lat.doubleValue();
                    Double lng = location.getLng();
                    if (lng != null) {
                        geoPoint = new GeoPoint(dDoubleValue, lng.doubleValue());
                    }
                }
                if (geoPoint != null) {
                    arrayList.add(geoPoint);
                }
            }
            String str = x10.getCardId() + "|" + arrayList.hashCode() + "|" + x10.b().size();
            if (kotlin.jvm.internal.p.d(str, this.lastSignature)) {
                C3284y c3284y = this.overviewBinder;
                if (c3284y != null) {
                    c3284y.s(x10.getCardId(), arrayList);
                }
                j0();
                return;
            }
            this.lastSignature = str;
            this.poiItems = x10.b();
            this.selectedIndex = 0;
            this.mapVisualReady = false;
            T5.t tVar = this.listBinding;
            if (tVar == null) {
                kotlin.jvm.internal.p.A("listBinding");
                tVar = null;
            }
            tVar.flPoiMarkerOverlay.setVisibility(4);
            this.markerViews.clear();
            T5.t tVar2 = this.listBinding;
            if (tVar2 != null) {
                if (tVar2 == null) {
                    kotlin.jvm.internal.p.A("listBinding");
                } else {
                    geoPoint = tVar2;
                }
                geoPoint.flPoiMarkerOverlay.removeAllViews();
            }
            j0();
            C3284y c3284y2 = this.overviewBinder;
            if (c3284y2 != null) {
                c3284y2.s(x10.getCardId(), arrayList);
            }
        }
    }

    @Override // N5.d
    public void D(CardEnvelope envelope, N5.n model) {
        String taskId;
        kotlin.jvm.internal.p.i(envelope, "envelope");
        M5.a aVar = M5.a.INSTANCE;
        if (model == null || (taskId = model.getCardId()) == null) {
            taskId = envelope.getTaskId();
        }
        aVar.c(taskId, M5.a.CARD_TYPE_OVERVIEW);
    }

    @Override // N5.d
    public void E(FrameLayout container) {
        kotlin.jvm.internal.p.i(container, "container");
        T5.t tVarC = T5.t.c(LayoutInflater.from(getContext()), container, true);
        kotlin.jvm.internal.p.h(tVarC, "inflate(...)");
        this.listBinding = tVarC;
        T5.t tVar = this.listBinding;
        T5.t tVar2 = null;
        if (tVar == null) {
            kotlin.jvm.internal.p.A("listBinding");
            tVar = null;
        }
        MapAspectFrameLayout flPoiListMap = tVar.flPoiListMap;
        kotlin.jvm.internal.p.h(flPoiListMap, "flPoiListMap");
        T5.t tVar3 = this.listBinding;
        if (tVar3 == null) {
            kotlin.jvm.internal.p.A("listBinding");
            tVar3 = null;
        }
        ImageView ivPoiListMap = tVar3.ivPoiListMap;
        kotlin.jvm.internal.p.h(ivPoiListMap, "ivPoiListMap");
        T5.t tVar4 = this.listBinding;
        if (tVar4 == null) {
            kotlin.jvm.internal.p.A("listBinding");
            tVar4 = null;
        }
        IndeterminateSpinnerView vPoiListMapLoading = tVar4.vPoiListMapLoading;
        kotlin.jvm.internal.p.h(vPoiListMapLoading, "vPoiListMapLoading");
        this.overviewBinder = new C3284y(flPoiListMap, ivPoiListMap, vPoiListMapLoading);
        B0();
        C3251a c3251a = C3251a.INSTANCE;
        T5.t tVar5 = this.listBinding;
        if (tVar5 == null) {
            kotlin.jvm.internal.p.A("listBinding");
            tVar5 = null;
        }
        LinearLayout linearLayoutB = tVar5.b();
        kotlin.jvm.internal.p.h(linearLayoutB, "getRoot(...)");
        c3251a.b(linearLayoutB);
        T5.t tVar6 = this.listBinding;
        if (tVar6 == null) {
            kotlin.jvm.internal.p.A("listBinding");
            tVar6 = null;
        }
        tVar6.vpPoiCards.setOffscreenPageLimit(1);
        T5.t tVar7 = this.listBinding;
        if (tVar7 == null) {
            kotlin.jvm.internal.p.A("listBinding");
        } else {
            tVar2 = tVar7;
        }
        tVar2.vpPoiCards.j(this.pageChangeCallback);
    }

    public final void f0(int index) {
        int i10 = 0;
        for (Object obj : this.markerViews) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            k0 k0Var = (k0) obj;
            if (k0Var != null) {
                k0Var.setChosen(i10 == index);
                n0(k0Var);
                if (i10 == index) {
                    k0Var.bringToFront();
                }
            }
            i10 = i11;
        }
    }

    public final void g0(TextView tv, PoiBrief poi) throws Resources.NotFoundException {
        String strH = C3251a.INSTANCE.h(poi.getRating());
        ArrayList arrayList = new ArrayList(4);
        if (strH != null) {
            arrayList.add(strH);
        }
        String strD = N5.j.INSTANCE.d(poi.getDistanceText());
        if (strD != null) {
            arrayList.add(strD);
        }
        List<CardTag> listH = poi.h();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = listH.iterator();
        while (it.hasNext()) {
            String strD2 = N5.j.INSTANCE.d(((CardTag) it.next()).getText());
            if (strD2 != null) {
                arrayList2.add(strD2);
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList.add((String) it2.next());
        }
        if (arrayList.isEmpty()) {
            tv.setVisibility(8);
            C3251a.INSTANCE.f(tv);
            return;
        }
        int color = getResources().getColor(R$color.card_map_poi_meta, null);
        tv.setVisibility(0);
        tv.setTextSize(11.0f);
        tv.setTextColor(color);
        tv.setText(Z8.F.A0(arrayList, " · ", null, null, 0, null, null, 62, null));
        if (strH == null) {
            C3251a.INSTANCE.f(tv);
        } else {
            C3251a.INSTANCE.a(tv, color);
            tv.setCompoundDrawablePadding((int) (getResources().getDisplayMetrics().density * 8.0f));
        }
    }

    public final void h0() {
        View.OnLayoutChangeListener onLayoutChangeListener = this.markerLayoutListener;
        if (onLayoutChangeListener != null) {
            T5.t tVar = this.listBinding;
            if (tVar == null) {
                kotlin.jvm.internal.p.A("listBinding");
                tVar = null;
            }
            tVar.flPoiMarkerOverlay.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
        this.markerLayoutListener = null;
    }

    public final void i0() {
        T5.t tVar = this.listBinding;
        if (tVar == null) {
            return;
        }
        Runnable runnable = this.overlayRepinRunnable;
        if (runnable != null) {
            if (tVar == null) {
                kotlin.jvm.internal.p.A("listBinding");
                tVar = null;
            }
            tVar.flPoiListMap.removeCallbacks(runnable);
        }
        this.overlayRepinRunnable = null;
        Runnable runnable2 = this.overlayRefreshRunnable;
        if (runnable2 != null) {
            T5.t tVar2 = this.listBinding;
            if (tVar2 == null) {
                kotlin.jvm.internal.p.A("listBinding");
                tVar2 = null;
            }
            tVar2.flPoiListMap.removeCallbacks(runnable2);
        }
        this.overlayRefreshRunnable = null;
    }

    public final void j0() throws Resources.NotFoundException {
        C3284y c3284y;
        if (this.poiItems.isEmpty()) {
            return;
        }
        if (!this.mapOverlayShown) {
            this.mapOverlayShown = true;
            T5.t tVar = this.listBinding;
            if (tVar == null) {
                kotlin.jvm.internal.p.A("listBinding");
                tVar = null;
            }
            Object parent = tVar.vpPoiCards.getParent();
            View view = parent instanceof View ? (View) parent : null;
            if (view != null) {
                view.setVisibility(0);
            }
            if (view != null) {
                view.setElevation(getResources().getDisplayMetrics().density * 4.0f);
            }
            ViewParent parent2 = view != null ? view.getParent() : null;
            ViewGroup viewGroup = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
            if (viewGroup != null) {
                viewGroup.bringChildToFront(view);
            }
            T5.t tVar2 = this.listBinding;
            if (tVar2 == null) {
                kotlin.jvm.internal.p.A("listBinding");
                tVar2 = null;
            }
            tVar2.flPoiMarkerOverlay.setVisibility((this.mapVisualReady && (c3284y = this.overviewBinder) != null && c3284y.K()) ? 0 : 4);
            z0(this, false, 1, null);
        }
        l0();
        k0();
        t0();
        v0();
    }

    public final void k0() {
        C3284y c3284y;
        T5.t tVar = this.listBinding;
        if (tVar == null) {
            kotlin.jvm.internal.p.A("listBinding");
            tVar = null;
        }
        MapAspectFrameLayout flPoiListMap = tVar.flPoiListMap;
        kotlin.jvm.internal.p.h(flPoiListMap, "flPoiListMap");
        T5.t tVar2 = this.listBinding;
        if (tVar2 == null) {
            kotlin.jvm.internal.p.A("listBinding");
            tVar2 = null;
        }
        FrameLayout flPoiMarkerOverlay = tVar2.flPoiMarkerOverlay;
        kotlin.jvm.internal.p.h(flPoiMarkerOverlay, "flPoiMarkerOverlay");
        T5.t tVar3 = this.listBinding;
        if (tVar3 == null) {
            kotlin.jvm.internal.p.A("listBinding");
            tVar3 = null;
        }
        Object parent = tVar3.vpPoiCards.getParent();
        View view = parent instanceof View ? (View) parent : null;
        float f10 = getResources().getDisplayMetrics().density;
        int childCount = flPoiListMap.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = flPoiListMap.getChildAt(i10);
            if (childAt instanceof MapView) {
                MapView mapView = (MapView) childAt;
                mapView.setElevation(0.0f);
                mapView.setTranslationZ(0.0f);
                com.stepos.ailauncher.amap.route.K.INSTANCE.a0(mapView);
            }
        }
        flPoiMarkerOverlay.setVisibility((this.mapVisualReady && (c3284y = this.overviewBinder) != null && c3284y.K()) ? 0 : 4);
        float f11 = 16.0f * f10;
        flPoiMarkerOverlay.setElevation(f11);
        flPoiMarkerOverlay.setTranslationZ(f11);
        flPoiListMap.bringChildToFront(flPoiMarkerOverlay);
        if (view != null) {
            float f12 = f10 * 20.0f;
            view.setElevation(f12);
            view.setTranslationZ(f12);
            flPoiListMap.bringChildToFront(view);
        }
        float elevation = flPoiMarkerOverlay.getElevation();
        Float fValueOf = view != null ? Float.valueOf(view.getElevation()) : null;
        int childCount2 = flPoiListMap.getChildCount();
        int iIndexOfChild = flPoiListMap.indexOfChild(flPoiMarkerOverlay);
        Integer numValueOf = view != null ? Integer.valueOf(flPoiListMap.indexOfChild(view)) : null;
        C4148a.k(TAG, "overlayAboveMap overlayElev=" + elevation + " stripElev=" + fValueOf + " slotChildren=" + childCount2 + " overlayIndex=" + iIndexOfChild + " stripIndex=" + numValueOf + " markerChildren=" + flPoiMarkerOverlay.getChildCount(), false, 4, null);
    }

    public final void l0() {
        T5.t tVar = this.listBinding;
        if (tVar == null) {
            kotlin.jvm.internal.p.A("listBinding");
            tVar = null;
        }
        ViewPager2 vpPoiCards = tVar.vpPoiCards;
        kotlin.jvm.internal.p.h(vpPoiCards, "vpPoiCards");
        RecyclerView.Adapter adapter = vpPoiCards.getAdapter();
        b bVar = adapter instanceof b ? (b) adapter : null;
        if (bVar == null || !bVar.d(this.poiItems)) {
            vpPoiCards.setAdapter(new b(this, this.poiItems));
            vpPoiCards.m(C5685n.n(this.selectedIndex, 0, this.poiItems.size() - 1), false);
            vpPoiCards.post(new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.e0
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    C3266h0.m0(this.f27229a);
                }
            });
        }
    }

    public final void n0(k0 marker) {
        T5.t tVar = this.listBinding;
        if (tVar == null) {
            kotlin.jvm.internal.p.A("listBinding");
            tVar = null;
        }
        FrameLayout flPoiMarkerOverlay = tVar.flPoiMarkerOverlay;
        kotlin.jvm.internal.p.h(flPoiMarkerOverlay, "flPoiMarkerOverlay");
        marker.measure(View.MeasureSpec.makeMeasureSpec(C5685n.f(flPoiMarkerOverlay.getWidth(), 1), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(C5685n.f(flPoiMarkerOverlay.getHeight(), 1), Integer.MIN_VALUE));
        marker.layout(0, 0, marker.getMeasuredWidth(), marker.getMeasuredHeight());
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o0() {
        /*
            Method dump skipped, instructions count: 608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.amap.C3266h0.o0():void");
    }

    @Override // N5.d, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() throws Resources.NotFoundException {
        super.onAttachedToWindow();
        this.mapVisualReady = false;
        T5.t tVar = this.listBinding;
        if (tVar != null) {
            if (tVar == null) {
                kotlin.jvm.internal.p.A("listBinding");
                tVar = null;
            }
            tVar.flPoiMarkerOverlay.setVisibility(4);
        }
        B0();
        C3284y c3284y = this.overviewBinder;
        if (c3284y != null) {
            c3284y.Z();
        }
        j0();
    }

    @Override // N5.d, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        T5.t tVar = null;
        if (w()) {
            C3284y c3284y = this.overviewBinder;
            if (c3284y != null) {
                c3284y.F();
            }
            this.lastSignature = null;
        } else {
            C3284y c3284y2 = this.overviewBinder;
            if (c3284y2 != null) {
                c3284y2.W();
            }
        }
        h0();
        i0();
        this.mapVisualReady = false;
        T5.t tVar2 = this.listBinding;
        if (tVar2 != null) {
            if (tVar2 == null) {
                kotlin.jvm.internal.p.A("listBinding");
            } else {
                tVar = tVar2;
            }
            tVar.flPoiMarkerOverlay.setVisibility(4);
        }
        this.mapOverlayShown = false;
        super.onDetachedFromWindow();
    }

    public final void q0(int position) {
        if (position == this.selectedIndex) {
            return;
        }
        this.selectedIndex = position;
        f0(position);
    }

    public final void r0(int index, PoiBrief poi) {
        M5.a.INSTANCE.a(this.cardId, M5.a.CARD_TYPE_OVERVIEW, M5.a.ACTION_OPTION_SELECT, Integer.valueOf(index));
        PoiDetailCardItem detail = poi.getDetail();
        if (detail != null) {
            Context context = getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            V.a(context, detail);
            return;
        }
        CardAction action = poi.getAction();
        String appLink = action != null ? action.getAppLink() : null;
        if (appLink == null || La.H.x0(appLink)) {
            String webLink = action != null ? action.getWebLink() : null;
            if (webLink == null || La.H.x0(webLink)) {
                return;
            }
        }
        N5.d.G(this, action != null ? action.getAppLink() : null, action != null ? action.getWebLink() : null, null, false, false, false, 60, null);
    }

    public final List<PointF> s0(List<GeoPoint> points, int w10, int h10) {
        C3284y c3284y = this.overviewBinder;
        CameraPosition cameraPositionD = c3284y != null ? c3284y.getSettledCamera() : null;
        if (cameraPositionD != null) {
            float f10 = cameraPositionD.zoom;
            if (f10 > 0.0f) {
                com.stepos.ailauncher.amap.route.U u10 = com.stepos.ailauncher.amap.route.U.INSTANCE;
                LatLng latLng = cameraPositionD.target;
                return u10.E(points, latLng.latitude, latLng.longitude, f10, w10, h10, getResources().getDisplayMetrics().density);
            }
        }
        C3270j0 c3270j0 = C3270j0.INSTANCE;
        l0 l0Var = l0.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        return c3270j0.a(points, w10, h10, l0Var.c(context));
    }

    public final void t0() {
        T5.t tVar = this.listBinding;
        if (tVar == null) {
            kotlin.jvm.internal.p.A("listBinding");
            tVar = null;
        }
        final FrameLayout flPoiMarkerOverlay = tVar.flPoiMarkerOverlay;
        kotlin.jvm.internal.p.h(flPoiMarkerOverlay, "flPoiMarkerOverlay");
        h0();
        if (flPoiMarkerOverlay.getWidth() > 0 && flPoiMarkerOverlay.getHeight() > 0) {
            o0();
            return;
        }
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.d0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                C3266h0.u0(flPoiMarkerOverlay, this, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        };
        this.markerLayoutListener = onLayoutChangeListener;
        flPoiMarkerOverlay.addOnLayoutChangeListener(onLayoutChangeListener);
    }

    public final void v0() {
        if (this.listBinding != null && this.overlayRefreshRunnable == null) {
            Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.c0
                @Override // java.lang.Runnable
                public final void run() {
                    C3266h0.w0(this.f27226a);
                }
            };
            this.overlayRefreshRunnable = runnable;
            T5.t tVar = this.listBinding;
            if (tVar == null) {
                kotlin.jvm.internal.p.A("listBinding");
                tVar = null;
            }
            tVar.flPoiListMap.postDelayed(runnable, 350L);
        }
    }

    public final void x0() {
        if (this.listBinding != null && this.overlayRepinRunnable == null) {
            Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.g0
                @Override // java.lang.Runnable
                public final void run() {
                    C3266h0.y0(this.f27233a);
                }
            };
            this.overlayRepinRunnable = runnable;
            T5.t tVar = this.listBinding;
            if (tVar == null) {
                kotlin.jvm.internal.p.A("listBinding");
                tVar = null;
            }
            tVar.flPoiListMap.postDelayed(runnable, 500L);
        }
    }

    public /* synthetic */ C3266h0(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
