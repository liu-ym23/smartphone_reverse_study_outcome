package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.obric.aiagent.plugin.R;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: compiled from: DateItemLayoutBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class an implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OTextView f22757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OTextView f22758b;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private an(OTextView r1, OTextView r2) {
        this.f22758b = r1;
        this.f22757a = r2;
    }

    public OTextView b() {
        return this.f22758b;
    }

    public static an a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.date_item_layout, "layout", "date_item_layout"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static an a(View r4) {
        Objects.requireNonNull(r4, "rootView");
        OTextView r0 = (OTextView) ZeusTransformUtils.preCheckCast(r4, OTextView.class, "com.obric.aiagent.plugin");
        return new an((OTextView) ZeusTransformUtils.preCheckCast(r4, OTextView.class, "com.obric.aiagent.plugin"), r0);
    }
}
