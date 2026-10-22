package com.bytedanceos.common.tangram.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.tangram.Bind;
import com.bytedanceos.common.tangram.BusRegister;
import com.bytedanceos.common.ui.widget.oui.OUIAppStatusView;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import com.tmall.wireless.tangram.eventbus.Event;
import com.tmall.wireless.tangram.eventbus.EventHandlerWrapper;
import com.tmall.wireless.tangram.eventbus.ReflectedActionFinder;
import com.tmall.wireless.tangram.structure.BaseCell;
import tc.f;
import z8.a;

/* JADX INFO: loaded from: classes2.dex */
public class AppNavigationView extends RelativeLayout implements Bind<AppInfo>, BusRegister {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NetworkImageView f9932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f9933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OUIAppStatusView f9934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public EventHandlerWrapper f9935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AppInfo f9936e;

    static {
        a.a(12, new int[]{250, 251, 252});
    }

    public AppNavigationView(Context r10) {
        this(r10, null);
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(R$layout.app_navigation_item_view, this);
        NetworkImageView r10 = (NetworkImageView) findViewById(R$id.app_icon);
        this.f9932a = r10;
        r10.setDefaultImageResId(R$drawable.oui_default_app_icon);
        this.f9932a.setScaleType(ImageView.ScaleType.FIT_XY);
        TextView r11 = (TextView) findViewById(R$id.app_name);
        this.f9933b = r11;
        r11.setSingleLine();
        this.f9933b.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f9933b.setGravity(3);
        this.f9934c = (OUIAppStatusView) findViewById(R$id.appStatusLay);
        setDescendantFocusability(393216);
    }

    public void a(AppInfo r10, BaseCell r11) {
        this.f9933b.setText(r10.appName);
        this.f9932a.e(r10.appIcon, f.i(30));
        r11.setOnClickListener(this, 250);
        this.f9936e = r10;
        this.f9934c.initClickListener(r11, r10, 251, 252);
        this.f9934c.updateDownloadStatus(r10);
        setTag(R$id.appinfo, r10);
    }

    @Override // com.bytedanceos.common.tangram.Bind
    public /* bridge */ /* synthetic */ void bindData(AppInfo r10, BaseCell r11) {
        a(r10, r11);
    }

    @Override // com.bytedanceos.common.tangram.Bind
    public void bindStyle(Style r10, BaseCell r11) {
    }

    public void execute(Event r10) {
        this.f9934c.updateDownloadStatus(this.f9936e);
    }

    @Override // com.bytedanceos.common.tangram.BusRegister
    public void register(BusSupport r10) {
        if (this.f9935d != null) goto L5;
        this.f9935d = BusSupport.wrapEventHandler("bus_app_download", "bus_app_source_id", this, "");
    L5:
        r10.register(this.f9935d);
    }

    @Override // com.bytedanceos.common.tangram.Bind
    public void unBind() {
        this.f9932a.setImageDrawable(null);
    }

    @Override // com.bytedanceos.common.tangram.BusRegister
    public void unRegister(BusSupport r10) {
        EventHandlerWrapper r11 = this.f9935d;
        if (r11 == null) goto L6;
        r10.unregister(r11);
        ReflectedActionFinder.removeMethod(this);
        this.f9935d = null;
        return;
    }

    public AppNavigationView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public AppNavigationView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        b();
    }
}
