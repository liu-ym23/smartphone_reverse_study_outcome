package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.uikit.layout.WrapLineFlowLayout;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001bB\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015B\u001b\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0014\u0010\u0018B#\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0019\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/PKRivalsSearchHistoryView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/PKRivalsSearchHistoryView$a;", "cb", "", "setCallBack", "", "", BitableAnalytic.LocationClickType.WORDS, "setData", "", "b", "I", "getMaxHeight", "()I", "setMaxHeight", "(I)V", "maxHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKRivalsSearchHistoryView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f96920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f96921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f96922c;

    public interface a {
        void Sn();

        void v8(String r100);
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PKRivalsSearchHistoryView f96923a;

        public b(PKRivalsSearchHistoryView r100) {
            this.f96923a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ((ImageView) this.f96923a.a(R.id.iv_clear)).setVisibility(8);
            ((TextView) this.f96923a.a(R.id.tv_clear)).setVisibility(0);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PKRivalsSearchHistoryView f96924a;

        public c(PKRivalsSearchHistoryView r100) {
            this.f96924a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f96924a.setVisibility(8);
            a r101 = this.f96924a.f96922c;
            if (r101 == null) goto L6;
            r101.Sn();
            return;
        }
    }

    public final void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_pk_rivals_search_history, this);
        setVisibility(8);
    }

    public final int getMaxHeight() {
        return this.f96921b;
    }

    public PKRivalsSearchHistoryView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f96920a = new LinkedHashMap();
        this.f96921b = -1;
        b();
    }

    public final View a(int r100) {
        if (this.f96920a != null) goto L5;
        this.f96920a = new LinkedHashMap();
    L5:
        View r101 = this.f96920a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f96920a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void setCallBack(a r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        this.f96922c = r100;
    }

    public final void setData(List<String> r100) {
        List<String> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        setVisibility(8);
        ((TextView) a(R.id.tv_title)).setVisibility(8);
        ((ImageView) a(R.id.iv_clear)).setVisibility(8);
    L23:
        ((ImageView) a(R.id.iv_clear)).setOnClickListener(new b(this));
        ((TextView) a(R.id.tv_clear)).setOnClickListener(new c(this));
        return;
    L12:
        setVisibility(0);
        ((TextView) a(R.id.tv_title)).setVisibility(0);
        ((ImageView) a(R.id.iv_clear)).setVisibility(0);
        ((TextView) a(R.id.tv_clear)).setVisibility(8);
        ((WrapLineFlowLayout) a(R.id.fl_search_history)).removeAllViews();
        Iterator<T> r103 = r100.iterator();
    L14:
        if (r103.hasNext() == false) goto L23;
        String r104 = (String) r103.next();
        View r105 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_item_pk_rivals_search_history_chunk, (ViewGroup) a(R.id.fl_search_history), false);
        TextView r106 = (TextView) r105.findViewById(R.id.tv_history_words);
        if (r106 == null) goto L18;
        r106.setTag(r104);
    L18:
        if (r106 == null) goto L20;
        r106.setText(r104);
    L20:
        if (r106 == null) goto L22;
        r106.setOnClickListener(new m(this));
    L22:
        ((WrapLineFlowLayout) a(R.id.fl_search_history)).addView(r105);
        goto L14
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L10
    }

    public final void setMaxHeight(int r100) {
        this.f96921b = r100;
    }

    public PKRivalsSearchHistoryView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f96920a = new LinkedHashMap();
        this.f96921b = -1;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.maxHeight});
        if (r102 != null) goto L13;
    L9:
        if (r102 == null) goto L11;
        r102.recycle();
    L11:
        b();
        return;
    L13:
        this.f96921b = r102.getDimensionPixelSize(0, -1);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        r102.recycle();
        throw th;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = this.f96921b;
        if (r102 < 0) goto L5;
        r101 = View.MeasureSpec.makeMeasureSpec(r102, Integer.MIN_VALUE);
    L5:
        super.onMeasure(r100, r101);
    }

    public PKRivalsSearchHistoryView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f96920a = new LinkedHashMap();
        this.f96921b = -1;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.maxHeight});
        if (r103 != null) goto L13;
    L9:
        if (r103 == null) goto L11;
        r103.recycle();
    L11:
        b();
        return;
    L13:
        this.f96921b = r103.getDimensionPixelSize(0, -1);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        r103.recycle();
        throw th;
    }
}
