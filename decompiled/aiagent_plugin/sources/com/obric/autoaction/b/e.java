package com.obric.autoaction.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OIconButton;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: GlobalInputWindowBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OIconButton f24603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f24604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f24605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f24606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinearLayout f24607e;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private e(LinearLayout r1, OIconButton r2, c r3, TextView r4, LinearLayout r5) {
        this.f24607e = r1;
        this.f24603a = r2;
        this.f24604b = r3;
        this.f24605c = r4;
        this.f24606d = r5;
    }

    public LinearLayout b() {
        return this.f24607e;
    }

    public static e a(LayoutInflater r2) {
        return a(r2, null, false);
    }

    public static e a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.global_input_window, "layout", "global_input_window"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static e a(View r11) {
        int r0 = ZeusTransformUtils.mapRes(R.id.icon, DbHelper.COL_ID, "icon");
        OIconButton r7 = (OIconButton) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OIconButton.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.input_content, DbHelper.COL_ID, "input_content");
        View r2 = r11.findViewById(r0);
        if (r2 == null) goto L13;
        c r8 = c.a(r2);
        r0 = ZeusTransformUtils.mapRes(R.id.title, DbHelper.COL_ID, DBDefinition.TITLE);
        TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), TextView.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.title_layout, DbHelper.COL_ID, "title_layout");
        LinearLayout r10 = (LinearLayout) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L13;
        return new e((LinearLayout) ZeusTransformUtils.preCheckCast(r11, LinearLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r11, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
