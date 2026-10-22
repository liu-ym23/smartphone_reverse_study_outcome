package com.obric.autogui.vdplayer.a;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.vdplayer.components.cursor.CursorPressDownEffectView;
import com.obric.autoaction.vdplayer.components.cursor.CursorThoughtTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VdComponentCursorEffectLayoutBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f31584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f31585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CursorThoughtTextView f31586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CursorPressDownEffectView f31587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConstraintLayout f31588e;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private a(ConstraintLayout r1, ConstraintLayout r2, View r3, CursorThoughtTextView r4, CursorPressDownEffectView r5) {
        this.f31588e = r1;
        this.f31584a = r2;
        this.f31585b = r3;
        this.f31586c = r4;
        this.f31587d = r5;
    }

    public ConstraintLayout b() {
        return this.f31588e;
    }

    public static a a(View r8) {
        ConstraintLayout r4 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r8, ConstraintLayout.class, "com.obric.aiagent.plugin");
        int r0 = ZeusTransformUtils.mapRes(R.id.cursor, DbHelper.COL_ID, "cursor");
        View r5 = r8.findViewById(r0);
        if (r5 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.cursor_text, DbHelper.COL_ID, "cursor_text");
        CursorThoughtTextView r6 = (CursorThoughtTextView) ZeusTransformUtils.preCheckCast(r8.findViewById(r0), CursorThoughtTextView.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.iv_press_effect, DbHelper.COL_ID, "iv_press_effect");
        CursorPressDownEffectView r7 = (CursorPressDownEffectView) ZeusTransformUtils.preCheckCast(r8.findViewById(r0), CursorPressDownEffectView.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L11;
        return new a((ConstraintLayout) ZeusTransformUtils.preCheckCast(r8, ConstraintLayout.class, "com.obric.aiagent.plugin"), r4, r5, r6, r7);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r8, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
