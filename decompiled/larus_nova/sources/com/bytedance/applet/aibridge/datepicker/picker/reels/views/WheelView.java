package com.bytedance.applet.aibridge.datepicker.picker.reels.views;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kv3.e;
import kv3.h;
import kv3.i;
import kv3.j;
import kv3.k;
import kv3.l;
import kv3.m;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\r\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b#\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001M\u0018\u0000 \u0091\u00012\u00020\u0001:\u0006\u0091\u0001\u0092\u0001\u0093\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010O\u001a\u00020P2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010j\u001a\u0004\u0018\u0001042\u0006\u0010k\u001a\u00020\u0007J\u0018\u0010n\u001a\u00020P2\u0006\u0010k\u001a\u00020\u00072\b\b\u0002\u0010q\u001a\u00020\u001fJ\u001f\u0010r\u001a\u00020P2\u0012\u0010s\u001a\n\u0012\u0006\b\u0001\u0012\u00020u0t\"\u00020u¢\u0006\u0002\u0010vJ\u0016\u0010r\u001a\u00020P2\u000e\u0010s\u001a\n\u0012\u0004\u0012\u00020u\u0018\u00010wJ\u000e\u0010x\u001a\u00020P2\u0006\u0010y\u001a\u000204J\b\u0010z\u001a\u00020PH\u0002J\b\u0010{\u001a\u00020PH\u0002J\u0016\u0010|\u001a\u00020P2\f\u0010}\u001a\b\u0012\u0004\u0012\u0002040wH\u0002J\u0016\u0010~\u001a\u00020P2\u0006\u0010k\u001a\u00020\u00072\u0006\u0010\u007f\u001a\u00020\u001fJ\u001a\u0010\u0080\u0001\u001a\u00020P2\u0007\u0010\u0081\u0001\u001a\u00020\u00072\u0006\u0010\u007f\u001a\u00020\u001fH\u0002J\t\u0010\u0082\u0001\u001a\u00020\u0007H\u0002J\u0012\u0010\u0083\u0001\u001a\u00020\u00072\u0007\u0010\u0084\u0001\u001a\u00020\u0007H\u0002J\u0011\u0010\u0085\u0001\u001a\u00020\u001f2\u0006\u0010k\u001a\u00020\u0007H\u0002J\u001b\u0010\u0086\u0001\u001a\u00020P2\u0007\u0010\u0087\u0001\u001a\u00020\u00072\u0007\u0010\u0088\u0001\u001a\u00020\u0007H\u0014J\t\u0010\u0089\u0001\u001a\u00020PH\u0002J\u0012\u0010\u008a\u0001\u001a\u00020P2\u0007\u0010\u008b\u0001\u001a\u00020\u0007H\u0002J\t\u0010\u008c\u0001\u001a\u00020PH\u0002J\f\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0002J\t\u0010\u008f\u0001\u001a\u00020\u0007H\u0002J\t\u0010\u0090\u0001\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00060\u0013R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00101\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u001f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010(\"\u0004\b2\u0010*R\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R*\u0010:\u001a\u0004\u0018\u00010\u00072\b\u00109\u001a\u0004\u0018\u00010\u0007@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010?\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010@\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010-\"\u0004\bB\u0010/R$\u0010C\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010-\"\u0004\bE\u0010/R\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0010\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0004\n\u0002\u0010NR$\u0010Q\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bR\u0010-\"\u0004\bS\u0010/R$\u0010T\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bU\u0010-\"\u0004\bV\u0010/R$\u0010W\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bX\u0010-\"\u0004\bY\u0010/R$\u0010Z\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b[\u0010-\"\u0004\b\\\u0010/R$\u0010]\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR$\u0010b\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bc\u0010-\"\u0004\bd\u0010/R$\u0010e\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bf\u0010_\"\u0004\bg\u0010aR\u0011\u0010h\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bi\u0010-R$\u0010l\u001a\u00020\u00072\u0006\u0010k\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bm\u0010-\"\u0004\bn\u0010/R\u0013\u0010o\u001a\u0004\u0018\u0001048F¢\u0006\u0006\u001a\u0004\bp\u00106¨\u0006\u0094\u0001"}, d2 = {"Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/WheelView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "tvTag", "Landroid/widget/TextView;", "layoutManager", "Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/WheelLayoutManager;", "snapHelper", "Landroidx/recyclerview/widget/LinearSnapHelper;", "adapter", "Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/WheelView$WheelAdapter;", "itemHeight", "maxTextWidth", "", "visibleRowCount", "wheelTextSizePx", "normalTextSizePx", "selectedTextSizePx", "lastHapticIndex", "lastCenterIndex", "lastChangedDataIndex", "userScrolling", "", "programmaticScrolling", "pendingInitialIndex", "pendingInitialScrollPosition", "pendingVerifyCenterAdapterPosition", "suppressNextSnapOnce", "pendingUserStoppedCallback", "showDivider", "getShowDivider", "()Z", "setShowDivider", "(Z)V", "highlightConorRadiusPx", "getHighlightConorRadiusPx", "()I", "setHighlightConorRadiusPx", "(I)V", "cyclic", "isCyclic", "setCyclic", "wheelTagText", "", "getWheelTagText", "()Ljava/lang/CharSequence;", "setWheelTagText", "(Ljava/lang/CharSequence;)V", "value", "tagGap", "getTagGap", "()Ljava/lang/Integer;", "setTagGap", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "selectedTextColor", "getSelectedTextColor", "setSelectedTextColor", "normalTextColor", "getNormalTextColor", "setNormalTextColor", "onWheelChangedListener", "Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/OnWheelChangedListener;", "getOnWheelChangedListener", "()Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/OnWheelChangedListener;", "setOnWheelChangedListener", "(Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/OnWheelChangedListener;)V", "scrollListener", "com/bytedance/applet/aibridge/datepicker/picker/reels/views/WheelView$scrollListener$1", "Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/WheelView$scrollListener$1;", "initAttrs", "", "startIndex", "getStartIndex", "setStartIndex", "itemCount", "getItemCount", "setItemCount", "itemHeightPx", "getItemHeightPx", "setItemHeightPx", "selectedItemHeightPx", "getSelectedItemHeightPx", "setSelectedItemHeightPx", "textSizePx", "getTextSizePx", "()F", "setTextSizePx", "(F)V", "textColor", "getTextColor", "setTextColor", "selectedTextSizePxProp", "getSelectedTextSizePxProp", "setSelectedTextSizePxProp", "itemSize", "getItemSize", "getItem", "index", "currentIndex", "getCurrentIndex", "setCurrentIndex", "currentItem", "getCurrentItem", GXTemplateKey.GAIAX_LAYER_PROGRESS_ANIMATED, "setEntries", "entries", "", "", "([Ljava/lang/String;)V", "", "setTagText", "tag", "scheduleInitialSelectionIfNeeded", "applyPendingInitialSelection", "setItems", "items", "setSelectedIndex", "animate", "centerToPosition", "position", "halfRows", "adapterToDataIndex", "adapterPos", "isValidDataIndex", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "snapToNearestCenter", "animateMove", "delta", "updateRecyclerPaddingForCenter", "findCenterChild", "Landroid/view/View;", "findNearestCenterIndex", "recyclerCenterY", "Companion", "WheelAdapter", "WheelVH", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WheelView extends FrameLayout {
    public static final /* synthetic */ int C = 0;
    public int A;
    public e B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f191061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f191062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WheelLayoutManager f191063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f191064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f191065e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f191066f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f191067g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f191068h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f191069i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f191070j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f191071k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f191072l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f191073m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f191074n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f191075o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f191076p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f191077q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f191078r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f191079s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f191080t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f191081u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f191082v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f191083w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CharSequence f191084x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Integer f191085y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f191086z;

    public static final class a {
    }

    public final class b extends RecyclerView.Adapter<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<CharSequence> f191087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WheelView f191088b;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            int r100 = this.f191087a.size();
            if (r100 != 0) goto L6;
            return 0;
        L6:
            WheelView r101 = this.f191088b;
            if (r101.f191083w == false) goto L10;
            return r100 * 1000;
        L10:
            return r100 + (r101.g() * 2);
        }

        public b(WheelView r100) {
            this.f191088b = r100;
            this.f191087a = new ArrayList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            final c r102 = (c) r100;
            Intrinsics.checkNotNullParameter(r102, "holder");
            WheelView r103 = this.f191088b;
            int r104 = WheelView.C;
            int r105 = r103.c(r101);
            WheelView r106 = this.f191088b;
            if (r106.f191083w == false) goto L6;
            r102.f191089a.setAlpha(1.0f);
            r102.f191089a.setTextSize(0, this.f191088b.f191068h);
            r102.f191089a.setText((CharSequence) ListProtector.get(this.f191087a, r105));
            View r107 = r102.itemView;
            final WheelView r108 = this.f191088b;
            r107.setOnClickListener(new l(r102, r108));
            return;
        L6:
            if (r106.h(r105) == false) goto L8;
            r102.f191089a.setAlpha(1.0f);
            r102.f191089a.setTextSize(0, this.f191088b.f191068h);
            r102.f191089a.setText((CharSequence) ListProtector.get(this.f191087a, r105));
            View r109 = r102.itemView;
            final WheelView r110 = this.f191088b;
            r109.setOnClickListener(new m(r102, r110));
            return;
        L8:
            r102.f191089a.setAlpha(0.0f);
            r102.f191089a.setText("");
            r102.itemView.setOnClickListener(null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            TextView r102 = new TextView(r100.getContext());
            WheelView r103 = this.f191088b;
            r102.setId(R.id.text1);
            r102.setLayoutParams(new RecyclerView.LayoutParams(-1, r103.f191065e));
            r102.setGravity(17);
            r102.setTextSize(0, r103.f191068h);
            r102.setIncludeFontPadding(false);
            return new c(r102);
        }
    }

    public static final class c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f191089a;

        public c(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f191089a = (TextView) r100.findViewById(R.id.text1);
        }
    }

    static {
    }

    public WheelView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public WheelView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public static /* synthetic */ void a(WheelView r100) {
        setItems$lambda$4(r100);
    }

    public final void d() {
        int r100 = this.f191077q;
        if (r100 != (-1)) goto L6;
        return;
    L6:
        if (this.f191064d.f191087a.size() != 0) goto L9;
        return;
    L9:
        if (this.f191061a.getChildCount() != 0) goto L11;
        return;
    L11:
        this.f191077q = -1;
        e(r100, false);
        this.f191061a.post(new i(this));
    }

    public final int f() {
        WheelLayoutManager r100 = this.f191063c;
        int r101 = 0;
        if (r100.f191056i != 0) goto L5;
    L11:
        int r102 = -1;
    L12:
        if (r102 == (-1)) goto L14;
        return r102;
    L14:
        int r103 = ((this.f191061a.getPaddingTop() + this.f191061a.getHeight()) - this.f191061a.getPaddingBottom()) / 2;
        int r104 = this.f191061a.getChildCount();
        View r105 = null;
        float r106 = Float.MAX_VALUE;
    L15:
        if (r101 >= r104) goto L23;
        View r107 = this.f191061a.getChildAt(r101);
        if (r107 == null) goto L22;
        float r108 = Math.abs(((r107.getTop() + r107.getBottom()) / 2.0f) - r103);
        if (r108 >= r106) goto L22;
        r105 = r107;
        r106 = r108;
    L22:
        r101 = r101 + 1;
        goto L15
    L23:
        if (r105 != null) goto L26;
        return -1;
    L26:
        return this.f191061a.getChildAdapterPosition(r105);
    L5:
        if (r100.getItemCount() == 0) goto L11;
        int r109 = MathKt.roundToInt(r100.f191057j / r100.f191056i);
        if (r100.f191059l == false) goto L10;
        r102 = RangesKt.coerceIn(r109, 0, r100.getItemCount() - 1);
        goto L12
    L10:
        int r110 = r100.f191060m;
        r102 = RangesKt.coerceIn(r109, r110, RangesKt.coerceAtLeast((r100.getItemCount() - r100.f191060m) - 1, r110));
        goto L12
    }

    public final int g() {
        return RangesKt.coerceAtLeast((this.f191067g + 2) / 2, 1);
    }

    public final int getItemSize() {
        return this.f191064d.f191087a.size();
    }

    public final void i() {
        int r100 = this.f191064d.f191087a.size();
        if (r100 != 0) goto L5;
        return;
    L5:
        int r101 = RangesKt.coerceIn(this.f191076p, 0, r100 - 1);
        if (this.f191083w == false) goto L8;
        int r102 = ((r100 * 1000) / 2) + r101;
    L9:
        this.f191077q = r102;
        if (this.f191061a.getChildCount() <= 0) goto L13;
        d();
        return;
    L13:
        return;
    L8:
        r102 = g() + r101;
        goto L9
    }

    public final void k() {
        this.f191061a.stopScroll();
        WheelLayoutManager r100 = this.f191063c;
        if (r100.f191056i != 0) goto L5;
    L15:
        int r101 = 0;
    L16:
        if (r101 == 0) goto L21;
        this.f191079s = true;
        if (r101 == 0) goto L22;
        this.f191075o = true;
        this.f191061a.smoothScrollBy(0, r101, new jv3.a(), 400);
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (r100.getChildCount() == 0) goto L15;
        if (r100.getItemCount() <= 0) goto L15;
        float r102 = r100.f191057j / r100.f191056i;
        if (r100.f191059l == false) goto L13;
        int r103 = RangesKt.coerceIn(MathKt.roundToInt(r102), 0, r100.getItemCount() - 1);
    L14:
        r101 = MathKt.roundToInt((r103 * r100.f191056i) - r100.f191057j);
        goto L16
    L13:
        int r104 = r100.f191060m;
        r103 = RangesKt.coerceIn(MathKt.roundToInt(r102), r104, RangesKt.coerceAtLeast((r100.getItemCount() - r100.f191060m) - 1, r104));
        goto L14
    }

    public final int getCurrentIndex() {
        int r100 = f();
        if (r100 != (-1)) goto L5;
        return 0;
    L5:
        int r101 = c(r100);
        if (h(r101) == true) goto L8;
        return 0;
    L8:
        return r101;
    }

    public final CharSequence getCurrentItem() {
        int r100 = getCurrentIndex();
        return (CharSequence) CollectionsKt.getOrNull(this.f191064d.f191087a, r100);
    }

    public final int getHighlightConorRadiusPx() {
        return this.f191082v;
    }

    public final int getItemCount() {
        return this.f191067g;
    }

    public final int getItemHeightPx() {
        return this.f191065e;
    }

    public final int getNormalTextColor() {
        return this.A;
    }

    public final e getOnWheelChangedListener() {
        return this.B;
    }

    public final int getSelectedItemHeightPx() {
        return this.f191065e;
    }

    public final int getSelectedTextColor() {
        return this.f191086z;
    }

    public final float getSelectedTextSizePxProp() {
        return this.f191070j;
    }

    public final boolean getShowDivider() {
        return this.f191081u;
    }

    public final int getStartIndex() {
        return this.f191076p;
    }

    public final Integer getTagGap() {
        return this.f191085y;
    }

    public final int getTextColor() {
        return this.A;
    }

    public final float getTextSizePx() {
        return this.f191069i;
    }

    public final CharSequence getWheelTagText() {
        return this.f191084x;
    }

    public static DisplayMetrics b(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private final void setItems(List<? extends CharSequence> r100) {
        this.f191078r = -1;
        b r101 = this.f191064d;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "data");
        r101.f191087a.clear();
        r101.f191087a.addAll(r100);
        r101.notifyDataSetChanged();
        TextView r102 = new TextView(getContext());
        r102.setTextSize(22.0f);
        TextPaint r103 = r102.getPaint();
        this.f191066f = 0.0f;
        Iterator<? extends CharSequence> r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        float r105 = r103.measureText(r104.next().toString());
        if (r105 <= this.f191066f) goto L4;
        this.f191066f = r105;
        goto L4
    L8:
        ViewGroup.LayoutParams r106 = this.f191062b.getLayoutParams();
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
        int r108 = (int) (this.f191066f / 2.0f);
        Integer r109 = this.f191085y;
        if (r109 == null) goto L13;
        int r110 = r109.intValue();
    L14:
        r107.setMarginStart(r108 + r110);
        this.f191062b.setLayoutParams(r106);
        goto L15
    L13:
        r110 = 0;
    L15:
        post(new h(this));
    }

    private static final void setItems$lambda$4(WheelView r100) {
        r100.requestLayout();
        if (r100.f191061a.getHeight() <= 0) goto L7;
        RecyclerView r101 = r100.f191061a;
        r101.setPadding(r101.getPaddingLeft(), 0, r100.f191061a.getPaddingRight(), 0);
    L7:
        if (r100.f191077q == (-1)) goto L9;
        r100.d();
        return;
    L9:
        r100.i();
    }

    public final int c(int r100) {
        int r101 = this.f191064d.f191087a.size();
        if (r101 != 0) goto L7;
        return -1;
    L7:
        if (this.f191083w == false) goto L12;
        int r102 = r100 % r101;
        if (r102 < 0) goto L14;
        return r102;
    L14:
        return r102 + r101;
    L12:
        return r100 - g();
    }

    public final boolean h(int r100) {
        if (r100 >= 0) goto L5;
        return false;
    L5:
        if (r100 >= this.f191064d.f191087a.size()) goto L9;
        return true;
    L9:
        return false;
    }

    public final void setCurrentIndex(int r100) {
        j(r100, false);
    }

    public final void setCyclic(boolean r100) {
        this.f191083w = r100;
        WheelLayoutManager r101 = this.f191063c;
        r101.f191059l = r100;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.f191060m = r102;
        requestLayout();
        return;
    L5:
        r102 = g();
        goto L6
    }

    public final void setEntries(List<String> r100) {
        if (r100 == null) goto L7;
        List<String> r101 = r100;
        List<? extends CharSequence> r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L5:
        if (r103.hasNext() == false) goto L8;
        r102.add((String) r103.next());
    L8:
        setItems(r102);
        return;
    L7:
        r102 = CollectionsKt.emptyList();
        goto L8
    }

    public final void setHighlightConorRadiusPx(int r100) {
        this.f191082v = r100;
    }

    public final void setItemCount(int r100) {
        this.f191067g = r100;
        WheelLayoutManager r101 = this.f191063c;
        if (this.f191083w == false) goto L5;
        int r102 = 0;
    L6:
        r101.f191060m = r102;
        requestLayout();
        return;
    L5:
        r102 = g();
        goto L6
    }

    public final void setItemHeightPx(int r100) {
        this.f191065e = r100;
        this.f191064d.notifyDataSetChanged();
        requestLayout();
    }

    public final void setNormalTextColor(int r100) {
        this.A = r100;
        this.f191063c.f191052e = r100;
        this.f191061a.requestLayout();
    }

    public final void setOnWheelChangedListener(e r100) {
        this.B = r100;
    }

    public final void setSelectedItemHeightPx(int r100) {
        this.f191065e = r100;
        this.f191064d.notifyDataSetChanged();
        requestLayout();
    }

    public final void setSelectedTextColor(int r100) {
        this.f191086z = r100;
        this.f191063c.f191051d = r100;
        this.f191061a.requestLayout();
    }

    public final void setSelectedTextSizePxProp(float r100) {
        this.f191070j = r100;
        this.f191068h = Math.max(this.f191069i, r100);
        this.f191064d.notifyDataSetChanged();
        requestLayout();
    }

    public final void setShowDivider(boolean r100) {
        this.f191081u = r100;
    }

    public final void setStartIndex(int r100) {
        this.f191076p = r100;
        if (this.f191064d.f191087a.size() <= 0) goto L6;
        j(RangesKt.coerceIn(r100, 0, this.f191064d.f191087a.size() - 1), false);
        return;
    }

    public final void setTagGap(Integer r100) {
        this.f191085y = r100;
        requestLayout();
    }

    public final void setTagText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.f191084x = r100;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        this.f191062b.setVisibility(8);
        return;
    L11:
        this.f191062b.setVisibility(0);
        this.f191062b.setText(this.f191084x);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void setTextColor(int r100) {
        setNormalTextColor(r100);
    }

    public final void setTextSizePx(float r100) {
        this.f191069i = r100;
        this.f191068h = Math.max(r100, this.f191070j);
        this.f191064d.notifyDataSetChanged();
        requestLayout();
    }

    public final void setWheelTagText(CharSequence r100) {
        this.f191084x = r100;
    }

    public final void setEntries(String... r100) {
        Intrinsics.checkNotNullParameter(r100, "entries");
        setItems(ArraysKt.toList(r100));
    }

    public final void e(final int r100, boolean r101) {
        this.f191061a.stopScroll();
        if (r101 == false) goto L18;
        this.f191075o = true;
        this.f191078r = r100;
        WheelLayoutManager r102 = this.f191063c;
        if (r102.f191056i != 0) goto L7;
    L14:
        int r103 = 0;
    L15:
        if (r103 == 0) goto L20;
        if (r103 == 0) goto L21;
        this.f191075o = true;
        this.f191061a.smoothScrollBy(0, r103, new jv3.a(), 400);
        return;
    L21:
        return;
    L20:
        return;
    L7:
        if (r102.getItemCount() == 0) goto L14;
        if (r102.f191059l == false) goto L12;
        int r104 = RangesKt.coerceIn(r100, 0, r102.getItemCount() - 1);
    L13:
        r103 = MathKt.roundToInt((r104 * r102.f191056i) - r102.f191057j);
        goto L15
    L12:
        int r105 = r102.f191060m;
        r104 = RangesKt.coerceIn(r100, r105, RangesKt.coerceAtLeast((r102.getItemCount() - r102.f191060m) - 1, r105));
        goto L13
    L18:
        this.f191075o = true;
        this.f191061a.scrollToPosition(r100);
        post(new k(this, r100));
    }

    public final void j(int r110, boolean r111) {
        this.f191077q = -1;
        this.f191078r = -1;
        int r100 = this.f191064d.f191087a.size();
        if (r100 != 0) goto L6;
        this.f191076p = r110;
        return;
    L6:
        boolean r101 = false;
        int r112 = RangesKt.coerceIn(r110, 0, r100 - 1);
        if (this.f191083w == false) goto L30;
        int r102 = f();
        if (this.f191061a.getChildCount() <= 0) goto L29;
        if (r102 == (-1)) goto L29;
        int r103 = this.f191064d.getItemCount();
        int r104 = (r102 - (r102 % r100)) + r112;
        Ref.IntRef r113 = new Ref.IntRef();
        r113.element = r104;
        Ref.IntRef r105 = new Ref.IntRef();
        r105.element = Math.abs(r104 - r102);
        int r106 = r104 - r100;
        if (r106 < 0) goto L15;
        if (r106 >= r103) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L20;
        int r108 = Math.abs(r106 - r102);
        if (r108 >= r105.element) goto L20;
        r113.element = r106;
        r105.element = r108;
    L20:
        int r109 = r104 + r100;
        if (r109 < 0) goto L24;
        if (r109 >= r103) goto L24;
        r101 = true;
    L24:
        if (r101 == false) goto L28;
        int r114 = Math.abs(r109 - r102);
        if (r114 >= r105.element) goto L28;
        r113.element = r109;
        r105.element = r114;
    L28:
        int r115 = r113.element;
    L31:
        e(r115, r111);
        return;
    L15:
        r107 = false;
    L29:
        r115 = r112 + ((r100 * 1000) / 2);
        goto L31
    L30:
        r115 = r112 + g();
        goto L31
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.makeMeasureSpec((((int) (((this.f191065e / ((float) Math.tan(0.5235988f))) * 2.0f) + this.f191065e)) + getPaddingTop()) + getPaddingBottom(), 1073741824);
        int r103 = View.MeasureSpec.getMode(r100);
        int r104 = View.MeasureSpec.getSize(r100);
        int r105 = Math.max((int) (this.f191066f + MathKt.roundToInt(TypedValue.applyDimension(1, 28, b(Resources.getSystem())))), getMinimumWidth());
        if (r103 == Integer.MIN_VALUE) goto L6;
        if (r103 == 1073741824) goto L7;
        r104 = r105;
    L7:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r104, 1073741824), r102);
        return;
    L6:
        r104 = Math.min(r105, r104);
        goto L7
    }

    public WheelView(Context r110, AttributeSet r111, int r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r210);
        WheelLayoutManager r100 = new WheelLayoutManager(r110);
        this.f191063c = r100;
        LinearSnapHelper r101 = new LinearSnapHelper();
        b r102 = new b(this);
        this.f191064d = r102;
        this.f191065e = MathKt.roundToInt(TypedValue.applyDimension(1, 50.0f, b(Resources.getSystem())));
        this.f191067g = 5;
        this.f191068h = TypedValue.applyDimension(1, 22.0f, b(Resources.getSystem()));
        this.f191069i = TypedValue.applyDimension(1, 22.0f, b(Resources.getSystem()));
        this.f191070j = TypedValue.applyDimension(1, 22.0f, b(Resources.getSystem()));
        this.f191071k = -1;
        this.f191072l = -1;
        this.f191073m = -1;
        this.f191077q = -1;
        this.f191078r = -1;
        this.f191082v = MathKt.roundToInt(TypedValue.applyDimension(1, 8, b(Resources.getSystem())));
        this.f191086z = ContextCompat.getColor(r110, com.larus.nova.R.color.larus_picker_accent_6_bg);
        this.A = ContextCompat.getColor(r110, com.larus.nova.R.color.larus_picker_basic_text_1);
        RecyclerView.OnScrollListener r112 = new WheelView$scrollListener$1(this);
        FrameLayout.inflate(r110, com.larus.nova.R.layout.larus_applet_wheel_view, this);
        RecyclerView r103 = (RecyclerView) findViewById(com.larus.nova.R.id.recycler);
        this.f191061a = r103;
        this.f191062b = (TextView) findViewById(com.larus.nova.R.id.tv_tag);
        r103.setLayoutManager(r100);
        r100.f191060m = g();
        r103.setAdapter(r102);
        r103.setClipToPadding(false);
        r103.setOverScrollMode(0);
        r101.attachToRecyclerView(r103);
        r103.addOnScrollListener(r112);
        r103.getViewTreeObserver().addOnGlobalLayoutListener(new j(this));
        TypedArray r104 = getContext().obtainStyledAttributes(r111, new int[]{com.larus.nova.R.attr.applet_ui_wheelCyclic, com.larus.nova.R.attr.applet_ui_wheelEntries, com.larus.nova.R.attr.applet_ui_wheelHighlightColor, com.larus.nova.R.attr.applet_ui_wheelHighlightConorRadius, com.larus.nova.R.attr.applet_ui_wheelItemCount, com.larus.nova.R.attr.applet_ui_wheelItemHeight, com.larus.nova.R.attr.applet_ui_wheelItemWidth, com.larus.nova.R.attr.applet_ui_wheelSelectedTextColor, com.larus.nova.R.attr.applet_ui_wheelSelectedTextSize, com.larus.nova.R.attr.applet_ui_wheelShowDivider, com.larus.nova.R.attr.applet_ui_wheelStartIndex, com.larus.nova.R.attr.applet_ui_wheelTextColor, com.larus.nova.R.attr.applet_ui_wheelTextSize});
        boolean r105 = r104.getBoolean(0, false);
        int r106 = r104.getInt(10, 0);
        int r113 = r104.getInt(4, 5);
        int r107 = r104.getDimensionPixelOffset(5, MathKt.roundToInt(TypedValue.applyDimension(1, 50, b(Resources.getSystem()))));
        int r114 = r104.getDimensionPixelSize(12, MathKt.roundToInt(TypedValue.applyDimension(1, 22.0f, b(Resources.getSystem()))));
        int r115 = r104.getDimensionPixelSize(12, MathKt.roundToInt(TypedValue.applyDimension(1, 14.0f, b(Resources.getSystem()))));
        int r116 = r104.getColor(11, ContextCompat.getColor(getContext(), com.larus.nova.R.color.larus_picker_basic_text_1));
        int r108 = r104.getColor(7, ContextCompat.getColor(getContext(), com.larus.nova.R.color.larus_picker_accent_6_bg));
        int r109 = r104.getDimensionPixelSize(8, MathKt.roundToInt(TypedValue.applyDimension(1, 22.0f, b(Resources.getSystem()))));
        CharSequence[] r117 = r104.getTextArray(1);
        if (r117 == null) goto L7;
        ArrayList r118 = new ArrayList(r117.length);
        int r119 = r117.length;
        int r120 = 0;
    L5:
        if (r120 >= r119) goto L8;
        r118.add(r117[r120].toString());
        r120 = r120 + 1;
    L8:
        r104.recycle();
        setCyclic(r105);
        this.f191076p = r106;
        this.f191067g = r113;
        this.f191065e = r107;
        float r121 = r114;
        this.f191069i = r121;
        float r122 = r109;
        this.f191070j = r122;
        this.f191068h = RangesKt.coerceAtLeast(r122, r121);
        setSelectedTextColor(r108);
        this.f191062b.setTextSize(0, r115);
        this.f191062b.setTextColor(r116);
        if (r118 == null) goto L11;
        setItems(r118);
        return;
    L11:
        i();
        return;
    L7:
        r118 = null;
        goto L8
    }

    public /* synthetic */ WheelView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
