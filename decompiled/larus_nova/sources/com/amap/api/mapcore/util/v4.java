package com.amap.api.mapcore.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapActivity;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class v4 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<OfflineMapCity> f28181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private OfflineMapManager f28182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Activity f28183c;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f28184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OfflineMapCity f28185b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ v4 f28186c;

        @Override // android.view.View.OnClickListener
        public void onClick(View r100) {
            this.f28184a.f28190d.setVisibility(8);
            this.f28184a.f28189c.setVisibility(0);
            this.f28184a.f28189c.setText(p0.a(2131034141));
            v4.a(this.f28186c).downloadByCityName(this.f28185b.getCity());     // Catch: AMapException -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }

        public a(v4 r100, b r101, OfflineMapCity r102) {
            this.f28186c = r100;
            this.f28184a = r101;
            this.f28185b = r102;
        }
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f28187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TextView f28188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TextView f28189c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ImageView f28190d;

        public b(v4 r100) {
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int r100) {
        return r100;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f28181a.size();
    }

    public static /* synthetic */ OfflineMapManager a(v4 r100) {
        return r100.f28182b;
    }

    @Override // android.widget.Adapter
    public Object getItem(int r100) {
        return ListProtector.get(this.f28181a, r100);
    }

    public void a(List<OfflineMapCity> r100) {
        this.f28181a = r100;
    }

    public v4(OfflineMapManager r100, OfflineMapActivity r101) {
        this.f28181a = new ArrayList();
        this.f28182b = r100;
        this.f28183c = r101;
    }

    @Override // android.widget.Adapter
    public View getView(int r100, View r101, ViewGroup r102) {
        OfflineMapCity r103 = (OfflineMapCity) ListProtector.get(this.f28181a, r100);     // Catch: Exception -> L28
        if (r101 != null) goto L5;
        b r104 = new b(this);     // Catch: Exception -> L28
        r101 = b5.a(this.f28183c, R.array.audio2text_option_array, null);     // Catch: Exception -> L28
        TextView r105 = (TextView) r101.findViewById(2147479566);     // Catch: Exception -> L28
        r104.f28187a = r105;     // Catch: Exception -> L28
        r105.setText(p0.a(2131034188));     // Catch: Exception -> L28
        TextView r106 = (TextView) r101.findViewById(2147479570);     // Catch: Exception -> L28
        r104.f28188b = r106;     // Catch: Exception -> L28
        r106.setText(p0.a(2131034189));     // Catch: Exception -> L28
        r104.f28189c = (TextView) r101.findViewById(2147479568);     // Catch: Exception -> L28
        r104.f28190d = (ImageView) r101.findViewById(2147479569);     // Catch: Exception -> L28
        r101.setTag(r104);     // Catch: Exception -> L28
    L6:
        r104.f28190d.setOnClickListener(new a(this, r104, r103));     // Catch: Exception -> L28
        r104.f28189c.setVisibility(0);     // Catch: Exception -> L28
        r104.f28187a.setText(r103.getCity());     // Catch: Exception -> L28
        double r107 = ((double) ((int) (((r103.getSize() / 1024.0d) / 1024.0d) * 100.0d))) / 100.0d;     // Catch: Exception -> L28
        r104.f28188b.setText(String.valueOf(r107) + " M");     // Catch: Exception -> L28
        int r108 = r103.getState();     // Catch: Exception -> L28
        if (r108 != 6) goto L9;
        r104.f28190d.setVisibility(0);     // Catch: Exception -> L28
        r104.f28189c.setVisibility(8);     // Catch: Exception -> L28
    L30:
        return r101;
    L9:
        if (r108 == (-1)) goto L25;
        if (r108 != 0) goto L12;
    L24:
        r104.f28190d.setVisibility(8);     // Catch: Exception -> L28
        r104.f28189c.setText(p0.a(2131034141));     // Catch: Exception -> L28
        goto L30
    L12:
        if (r108 == 1) goto L24;
        if (r108 != 2) goto L16;
        r104.f28190d.setVisibility(8);     // Catch: Exception -> L28
        r104.f28189c.setText("等待下载");     // Catch: Exception -> L28
        goto L30
    L16:
        if (r108 != 3) goto L18;
        r104.f28190d.setVisibility(8);     // Catch: Exception -> L28
        r104.f28189c.setText(p0.a(2131034190));     // Catch: Exception -> L28
        goto L30
    L18:
        if (r108 == 4) goto L21;
        switch(r108) {
            case 101: goto L25;
            case 102: goto L25;
            case 103: goto L25;
            default: goto L30;
        };     // Catch: Exception -> L28
    L21:
        r104.f28190d.setVisibility(8);     // Catch: Exception -> L28
        r104.f28189c.setText(p0.a(2131034143));     // Catch: Exception -> L28
    L25:
        r104.f28190d.setVisibility(8);     // Catch: Exception -> L28
        r104.f28189c.setText(p0.a(2131034191));     // Catch: Exception -> L28
        goto L30
    L5:
        r104 = (b) r101.getTag();     // Catch: Exception -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
        goto L30
    }
}
