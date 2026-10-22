package com.bytedance.android.livesdk.ceremony.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.widget.EdgeTransparentView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/ceremony/view/StaticBorderView;", "Landroid/widget/FrameLayout;", "", "d", "Z", "isShow", "()Z", "setShow", "(Z)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StaticBorderView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f104954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f104955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f104956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f104957d;

    public StaticBorderView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StaticBorderView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r100 = this.f104956c;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        Disposable r101 = this.f104955b;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    }

    public final View a(int r100) {
        if (this.f104954a != null) goto L5;
        this.f104954a = new LinkedHashMap();
    L5:
        View r101 = this.f104954a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f104954a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void setShow(boolean r100) {
        this.f104957d = r100;
    }

    public StaticBorderView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f104954a = new LinkedHashMap();
        LayoutInflater.from(r100).inflate(R.layout.ttlive_ceremony_static_border_view, this);
        setAlpha(0.0f);
        EdgeTransparentView r103 = (EdgeTransparentView) a(R.id.top_border_container);
        if (r103 == null) goto L5;
        r103.a(12, s1.f(100.0f));
    L5:
        EdgeTransparentView r104 = (EdgeTransparentView) a(R.id.left_border_container);
        if (r104 == null) goto L8;
        r104.a(3, s1.f(100.0f));
    L8:
        EdgeTransparentView r105 = (EdgeTransparentView) a(R.id.right_border_container);
        if (r105 == null) goto L11;
        r105.a(3, s1.f(100.0f));
    L11:
        EdgeTransparentView r106 = (EdgeTransparentView) a(R.id.bottom_border_container);
        if (r106 == null) goto L14;
        r106.a(12, s1.f(100.0f));
    L14:
        EdgeTransparentView r107 = (EdgeTransparentView) a(R.id.top_border_container);
        if (r107 == null) goto L17;
        r107.f160842j = new int[]{-1, -1, 0};
        r107.f160843k = new float[]{0.0f, 0.5f, 1.0f};
    L17:
        EdgeTransparentView r108 = (EdgeTransparentView) a(R.id.left_border_container);
        if (r108 == null) goto L20;
        r108.f160842j = new int[]{-1, -1, 0};
        r108.f160843k = new float[]{0.0f, 0.5f, 1.0f};
    L20:
        EdgeTransparentView r109 = (EdgeTransparentView) a(R.id.right_border_container);
        if (r109 == null) goto L23;
        r109.f160842j = new int[]{-1, -1, 0};
        r109.f160843k = new float[]{0.0f, 0.5f, 1.0f};
    L23:
        EdgeTransparentView r110 = (EdgeTransparentView) a(R.id.bottom_border_container);
        if (r110 == null) goto L27;
        r110.f160842j = new int[]{-1, -1, 0};
        r110.f160843k = new float[]{0.0f, 0.5f, 1.0f};
        return;
    }

    public /* synthetic */ StaticBorderView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
