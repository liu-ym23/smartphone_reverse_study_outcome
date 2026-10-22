package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f161791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f161792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f161793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f161794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f161795e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f161796f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f161797g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f161798h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f161799i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f161800j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f161801k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FrameLayout f161802l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LinearLayout f161803m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RelativeLayout f161804n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RelativeLayout f161805o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f161806p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f161807q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f161808r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f161809s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f161810t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final DialogInterface.OnClickListener f161811u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final DialogInterface.OnClickListener f161812v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f161813w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f161814x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public AlertDialog f161815y;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f161816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f161817b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f161818c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public DialogInterface.OnClickListener f161819d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public DialogInterface.OnClickListener f161820e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Context f161821f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f161822g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f161823h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public View f161824i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f161825j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f161826k;

        public a(Context r100) {
            this.f161821f = r100;
            this.f161822g = ContextCompat.getColor(r100, R.color.uikit_dialog_title);
            this.f161823h = ContextCompat.getColor(r100, R.color.uikit_dialog_title);
        }
    }

    public m(a r100) {
        Context r101 = r100.f161821f;
        this.f161791a = r101;
        this.f161810t = r100.f161818c;
        this.f161807q = r100.f161817b;
        this.f161806p = r100.f161816a;
        this.f161811u = r100.f161819d;
        this.f161812v = r100.f161820e;
        this.f161799i = r100.f161824i;
        this.f161814x = r100.f161826k;
        this.f161813w = r100.f161825j;
        this.f161808r = r100.f161823h;
        this.f161809s = r100.f161822g;
        View r102 = LayoutInflater.from(r101).inflate(R.layout.ttlive_dialog_layout_dmt, null);
        this.f161798h = r102;
        this.f161792b = (TextView) r102.findViewById(R.id.tv_title);
        this.f161793c = (TextView) this.f161798h.findViewById(R.id.tv_content);
        TextView r103 = (TextView) this.f161798h.findViewById(R.id.tv_second_content);
        this.f161797g = (ImageView) this.f161798h.findViewById(R.id.ic_img);
        this.f161794d = (TextView) this.f161798h.findViewById(R.id.tv_negative);
        this.f161795e = (TextView) this.f161798h.findViewById(R.id.tv_positive);
        this.f161796f = (TextView) this.f161798h.findViewById(R.id.tv_line);
        this.f161804n = (RelativeLayout) this.f161798h.findViewById(R.id.ttlive_rootview);
        this.f161805o = (RelativeLayout) this.f161798h.findViewById(R.id.rl_custom_view);
        this.f161802l = (FrameLayout) this.f161798h.findViewById(R.id.rl_top);
        this.f161803m = (LinearLayout) this.f161798h.findViewById(R.id.ll_below_top);
        this.f161800j = this.f161798h.findViewById(R.id.divider_line);
        this.f161801k = this.f161798h.findViewById(R.id.close_iv);
    }
}
