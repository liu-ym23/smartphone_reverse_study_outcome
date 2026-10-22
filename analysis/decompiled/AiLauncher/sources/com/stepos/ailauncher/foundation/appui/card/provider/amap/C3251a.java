package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.ailauncher.foundation.R$color;
import com.stepos.ailauncher.foundation.R$drawable;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import f.C4027a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import u0.C5566a;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/a;", "", "<init>", "()V", "Landroid/widget/TextView;", "tv", "", UxipConstants.f30680s, "LY8/t;", "e", "(Landroid/widget/TextView;Ljava/lang/String;)V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/b;", "tag", Const.INTENT_KEY_UMID, "(Landroid/widget/TextView;Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/b;)V", "c", "Landroid/view/View;", Parameters.ROOT, Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;)V", "raw", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)Ljava/lang/String;", "", "tintColor", Const.INTENT_KEY_APIKEY, "(Landroid/widget/TextView;I)V", "f", "(Landroid/widget/TextView;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Ljava/lang/Integer;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3251a {
    public static final C3251a INSTANCE = new C3251a();

    public final void a(TextView tv, int tintColor) {
        kotlin.jvm.internal.p.i(tv, "tv");
        Drawable drawableB = C4027a.b(tv.getContext(), R$drawable.ic_card_hotel_rating);
        if (drawableB == null) {
            return;
        }
        Drawable drawableR = C5566a.r(drawableB.mutate());
        kotlin.jvm.internal.p.h(drawableR, "wrap(...)");
        C5566a.n(drawableR, tintColor);
        C5566a.p(drawableR, PorterDuff.Mode.SRC_IN);
        int i10 = (int) (tv.getResources().getDisplayMetrics().density * 3.0f);
        tv.setCompoundDrawablesRelativeWithIntrinsicBounds(drawableR, (Drawable) null, (Drawable) null, (Drawable) null);
        tv.setCompoundDrawablePadding(i10);
        androidx.core.widget.i.e(tv, ColorStateList.valueOf(tintColor));
    }

    public final void b(View root) {
        kotlin.jvm.internal.p.i(root, "root");
        root.setClipToOutline(true);
        root.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        root.invalidateOutline();
    }

    public final void c(TextView tv, CardTag tag) {
        kotlin.jvm.internal.p.i(tv, "tv");
        String strD = N5.j.INSTANCE.d(tag != null ? tag.getText() : null);
        if (strD == null) {
            tv.setVisibility(8);
            return;
        }
        tv.setVisibility(0);
        tv.setText(strD);
        tv.setBackground(null);
        Integer numG = g(tag != null ? tag.getTextColor() : null);
        tv.setTextColor(numG != null ? numG.intValue() : tv.getResources().getColor(R$color.card_map_tag_text_default, null));
    }

    public final void d(TextView tv, CardTag tag) {
        kotlin.jvm.internal.p.i(tv, "tv");
        CharSequence charSequenceD = N5.j.INSTANCE.d(tag != null ? tag.getText() : null);
        if (charSequenceD == null) {
            tv.setVisibility(8);
            return;
        }
        tv.setVisibility(0);
        tv.setText(charSequenceD);
        Integer numG = g(tag != null ? tag.getTextColor() : null);
        tv.setTextColor(numG != null ? numG.intValue() : tv.getResources().getColor(R$color.card_map_tag_text_default, null));
        Integer numG2 = g(tag != null ? tag.getBgColor() : null);
        int iIntValue = numG2 != null ? numG2.intValue() : tv.getResources().getColor(R$color.card_map_tag_bg_default, null);
        float f10 = tv.getResources().getDisplayMetrics().density * 4.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f10);
        gradientDrawable.setColor(iIntValue);
        tv.setBackground(gradientDrawable);
    }

    public final void e(TextView tv, String value) {
        kotlin.jvm.internal.p.i(tv, "tv");
        String strD = N5.j.INSTANCE.d(value);
        if (strD == null) {
            tv.setVisibility(8);
        } else {
            tv.setText(strD);
            tv.setVisibility(0);
        }
    }

    public final void f(TextView tv) {
        kotlin.jvm.internal.p.i(tv, "tv");
        tv.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        tv.setCompoundDrawablePadding(0);
        androidx.core.widget.i.e(tv, null);
    }

    public final Integer g(String raw) {
        Object objB;
        String strD = N5.j.INSTANCE.d(raw);
        if (strD == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Integer.valueOf(Color.parseColor(strD)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (Integer) (Result.g(objB) ? null : objB);
    }

    public final String h(String raw) {
        String strD = N5.j.INSTANCE.d(raw);
        if (strD == null) {
            return null;
        }
        String string = La.H.D1(La.H.w1(La.H.D1(La.D.T(La.D.T(La.D.T(strD, "★", "", false, 4, null), "☆", "", false, 4, null), "分", "", false, 4, null)).toString(), JsonPointer.SEPARATOR, null, 2, null)).toString();
        if (string.length() > 0) {
            return string;
        }
        return null;
    }
}
