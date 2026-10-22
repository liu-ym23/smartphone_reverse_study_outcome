package com.bytedanceos.common.tangram.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.p;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle;
import tc.f;

/* JADX INFO: loaded from: classes2.dex */
public class AtmosphereMapView extends RelativeLayout implements ITangramViewLifeCycle {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f9937c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NetworkImageView f9938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f9939b;

    public static /* synthetic */ class a {
    }

    public static class b extends RecyclerView.ItemDecoration {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect r10, View r11, RecyclerView r12, RecyclerView.State r13) {
            r10.left = f.i(2);
            r10.right = f.i(2);
        }

        public /* synthetic */ b(a r10) {
            this();
        }
    }

    static {
        f9937c = BaseApplication.c().getResources().getDimensionPixelOffset(R$dimen.oui_atmosphere_recycle_item_margin_left);
    }

    public AtmosphereMapView(Context r10) {
        this(r10, null);
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R$layout.atmosphere_map_view, this);
        NetworkImageView r10 = (NetworkImageView) findViewById(R$id.atmosphere_bg);
        this.f9938a = r10;
        r10.setDefaultImageResId(R$drawable.oui_default_banner);
        RecyclerView r11 = (RecyclerView) findViewById(R$id.app_container);
        this.f9939b = r11;
        r11.setNestedScrollingEnabled(false);
        GridLayoutManager r12 = new GridLayoutManager(getContext(), 4);
        this.f9939b.addItemDecoration(new b(null));
        this.f9939b.setLayoutManager(r12);
    }

    @Override // com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void cellInited(BaseCell r10) {
        p.a(r10);
    }

    @Override // com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void postBindView(BaseCell r10) {
        throw null;
    }

    @Override // com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void postUnBindView(BaseCell r10) {
        throw null;
    }

    public AtmosphereMapView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public AtmosphereMapView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        a();
    }
}
