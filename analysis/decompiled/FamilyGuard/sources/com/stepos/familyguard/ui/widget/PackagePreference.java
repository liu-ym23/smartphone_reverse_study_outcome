package com.stepos.familyguard.ui.widget;

import D2.r;
import D2.v;
import D2.z;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.h;
import androidx.preference.Preference;
import androidx.preference.l;
import com.stepos.familyguard.R;

/* loaded from: classes.dex */
public class PackagePreference extends Preference {

    /* renamed from: T, reason: collision with root package name */
    private String f15182T;

    /* renamed from: U, reason: collision with root package name */
    private r f15183U;

    /* renamed from: V, reason: collision with root package name */
    private r f15184V;

    /* renamed from: W, reason: collision with root package name */
    private a f15185W;

    /* renamed from: X, reason: collision with root package name */
    private b f15186X;

    /* renamed from: Y, reason: collision with root package name */
    private v<String> f15187Y;

    static class a implements z<Drawable> {

        /* renamed from: a, reason: collision with root package name */
        ImageView f15188a;

        a() {
        }

        @Override // D2.z
        public void b() {
            Context context = this.f15188a.getContext();
            this.f15188a.setImageDrawable(h.f(context.getResources(), R.drawable.us_ic_default_app, context.getTheme()));
            this.f15188a.setVisibility(0);
            ((View) this.f15188a.getParent()).setVisibility(0);
        }

        @Override // D2.z
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Drawable drawable) {
            Context context = this.f15188a.getContext();
            Resources resources = context.getResources();
            if (drawable == null) {
                drawable = h.f(resources, R.drawable.us_ic_default_app, context.getTheme());
            }
            h.f(resources, R.drawable.us_image_bg_radius_mini, context.getTheme());
            this.f15188a.setImageDrawable(drawable);
            this.f15188a.setVisibility(0);
            ((View) this.f15188a.getParent()).setVisibility(0);
        }
    }

    static class b implements z<String> {

        /* renamed from: a, reason: collision with root package name */
        TextView f15189a;

        b() {
        }

        @Override // D2.z
        public void b() {
            this.f15189a.setText(R.string.fg_ui_loading);
            this.f15189a.setVisibility(0);
        }

        @Override // D2.z
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            this.f15189a.setText(str);
            this.f15189a.setVisibility(0);
        }
    }

    public PackagePreference(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String S0() {
        return this.f15182T;
    }

    public void T0(String str) {
        this.f15182T = str;
    }

    @Override // androidx.preference.Preference
    public void W(l lVar) {
        super.W(lVar);
        lVar.itemView.setBackgroundColor(0);
        RoundedImageView roundedImageView = (RoundedImageView) lVar.a(R.id.icon);
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        roundedImageView.setScaleType(scaleType);
        TextView textView = (TextView) lVar.a(R.id.title);
        roundedImageView.setScaleType(scaleType);
        if (this.f15185W == null) {
            this.f15185W = new a();
        }
        this.f15185W.f15188a = roundedImageView;
        if (this.f15186X == null) {
            this.f15186X = new b();
        }
        this.f15186X.f15189a = textView;
        if (this.f15187Y == null) {
            this.f15187Y = new v() { // from class: x2.e
                @Override // D2.v
                public final Object get() {
                    return this.f23802a.S0();
                }
            };
        }
        this.f15184V.d(this.f15187Y, this.f15186X);
        this.f15183U.d(this.f15187Y, this.f15185W);
    }

    @Override // androidx.preference.Preference
    public void w0(Drawable drawable) {
        super.w0(drawable);
    }

    public PackagePreference(Context context, AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, 0);
    }

    public PackagePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PackagePreference(Context context, r rVar, r rVar2) {
        super(context);
        this.f15183U = rVar;
        this.f15184V = rVar2;
        z0(R.layout.category_app_preference_layout);
    }
}
