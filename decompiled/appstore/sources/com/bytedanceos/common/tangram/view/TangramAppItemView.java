package com.bytedanceos.common.tangram.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.p;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.network.ads.AdsReportManager;
import com.bytedanceos.common.tangram.Bind;
import com.bytedanceos.common.tangram.BusRegister;
import com.bytedanceos.common.ui.widget.oui.OUIAppItemView;
import com.tmall.wireless.tangram.core.service.ServiceManager;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import com.tmall.wireless.tangram.eventbus.Event;
import com.tmall.wireless.tangram.eventbus.EventHandlerWrapper;
import com.tmall.wireless.tangram.eventbus.ReflectedActionFinder;
import com.tmall.wireless.tangram.structure.BaseCell;
import z8.a;
import z8.b;

/* JADX INFO: loaded from: classes2.dex */
public class TangramAppItemView extends OUIAppItemView implements Bind<AppInfo>, BusRegister {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EventHandlerWrapper f9963b;

    static {
        a.a(2, new int[]{200, 201, 202});
    }

    public TangramAppItemView(Context r10) {
        super(r10);
        this.f9962a = true;
    }

    @Override // com.bytedanceos.common.tangram.Bind
    public /* bridge */ /* synthetic */ void bindData(AppInfo r10, BaseCell r11) {
        g(r10, r11);
    }

    @Override // com.bytedanceos.common.tangram.Bind
    public void bindStyle(Style r10, BaseCell r11) {
    }

    public void execute(Event r10) {
        AppInfo r11 = getAppInfo();
        if (r11 != null) goto L5;
        return;
    L5:
        getAppStatusView().updateDownloadStatus(r11);
    }

    public void g(AppInfo r10, BaseCell r11) {
        h(r10, r11);
        updateItemView(r10);
        showLine(false);
        if (this.f9962a == false) goto L6;
        AdsReportManager.h().k(r10);
        return;
    }

    public final void h(AppInfo r10, BaseCell r11) {
        r11.setOnClickListener(this, 200);
        ServiceManager r12 = r11.serviceManager;
        Integer r13 = null;
        if (r12 != null) goto L10;
        getAppStatusView().initClickListener(r11, r10, 201, 202);
        if (r11.extras.optInt("hasnum") == 0) goto L8;
        r13 = Integer.valueOf(r11.extras.optInt("hasnum"));
    L8:
        setNumber(r13);
        return;
    L10:
        p.a(r12.getService(b.class));
        throw null;
    }

    @Override // com.bytedanceos.common.tangram.BusRegister
    public void register(BusSupport r10) {
        if (this.f9963b != null) goto L5;
        this.f9963b = BusSupport.wrapEventHandler("bus_download", "bus_source_id", this, "");
    L5:
        r10.register(this.f9963b);
    }

    @Override // com.bytedanceos.common.tangram.Bind
    public void unBind() {
    }

    @Override // com.bytedanceos.common.tangram.BusRegister
    public void unRegister(BusSupport r10) {
        EventHandlerWrapper r11 = this.f9963b;
        if (r11 == null) goto L6;
        r10.unregister(r11);
        ReflectedActionFinder.removeMethod(this);
        this.f9963b = null;
        return;
    }

    public TangramAppItemView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f9962a = true;
    }

    public TangramAppItemView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f9962a = true;
    }
}
