package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/ui/SelfDisciplineEndView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelfDisciplineEndView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f79720a;

    public static final class a {
    }

    static {
    }

    public SelfDisciplineEndView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SelfDisciplineEndView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ConstraintLayout r100 = (ConstraintLayout) a(R.id.container);
        if (r100 == null) goto L6;
        r100.setVisibility(8);
        return;
    }

    public static String b(long r100) {
        if (r100 != 0) goto L5;
        return CustomAlbumViewModel.DEFAULT_TAB_ID;
    L5:
        long r101 = 9;
        if (1 > r100) goto L12;
        if (r101 < r100) goto L12;
        return "0" + r100;
    L12:
        return String.valueOf(r100);
    }

    public final View a(int r100) {
        if (this.f79720a != null) goto L5;
        this.f79720a = new LinkedHashMap();
    L5:
        View r101 = this.f79720a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f79720a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public SelfDisciplineEndView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f79720a = new LinkedHashMap();
        LayoutInflater.from(r100).inflate(R.layout.ttlive_self_discipline_end_view, this);
        ConstraintLayout r103 = (ConstraintLayout) a(R.id.container);
        if (r103 == null) goto L6;
        r103.setVisibility(8);
        return;
    }

    public /* synthetic */ SelfDisciplineEndView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
