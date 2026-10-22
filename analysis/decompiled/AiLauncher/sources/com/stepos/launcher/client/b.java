package com.stepos.launcher.client;

import android.app.PendingIntent;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f30188a;

    /* renamed from: b, reason: collision with root package name */
    public final AppWidgetProviderInfo f30189b;

    /* renamed from: c, reason: collision with root package name */
    public final PendingIntent f30190c;

    /* renamed from: d, reason: collision with root package name */
    public final Intent f30191d;

    /* renamed from: e, reason: collision with root package name */
    public final Bitmap f30192e;

    /* renamed from: f, reason: collision with root package name */
    public final Bitmap f30193f;

    /* renamed from: g, reason: collision with root package name */
    public final RectF f30194g;

    /* renamed from: h, reason: collision with root package name */
    public final float f30195h;

    /* renamed from: i, reason: collision with root package name */
    public final float f30196i;

    public b(int i10, AppWidgetProviderInfo appWidgetProviderInfo, PendingIntent pendingIntent, Intent intent, Bitmap bitmap, Bitmap bitmap2, RectF rectF, float f10, float f11) {
        this.f30188a = i10;
        this.f30189b = appWidgetProviderInfo;
        this.f30190c = pendingIntent;
        this.f30191d = intent;
        this.f30192e = bitmap;
        this.f30193f = bitmap2;
        this.f30194g = rectF;
        this.f30195h = f10;
        this.f30196i = f11;
    }

    public static b a(Bundle bundle) {
        try {
            int i10 = bundle.getInt("key:widgetId", -1);
            AppWidgetProviderInfo appWidgetProviderInfo = (AppWidgetProviderInfo) bundle.getParcelable("key:widgetInfo", AppWidgetProviderInfo.class);
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("key:pendingIntent", PendingIntent.class);
            Intent intent = (Intent) bundle.getParcelable("key:intent", Intent.class);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("key:fgBitmap", Bitmap.class);
            Bitmap bitmap2 = (Bitmap) bundle.getParcelable("key:bgBitmap", Bitmap.class);
            RectF rectF = (RectF) bundle.getParcelable("key:widgetLocation", RectF.class);
            float f10 = bundle.getFloat("key:cornerRadius", -1.0f);
            float f11 = bundle.getFloat("key:cornerSmoothness", 0.0f);
            a.a(appWidgetProviderInfo);
            a.a(pendingIntent);
            a.a(intent);
            a.a(bitmap);
            a.a(rectF);
            return new b(i10, appWidgetProviderInfo, pendingIntent, intent, bitmap, bitmap2, rectF, f10, f11);
        } catch (Exception e10) {
            Log.e("QuickstepInteraction", "Failed to construct a interaction params from " + bundle, e10);
            return null;
        }
    }

    public String toString() {
        return "QuickstepInteractionParams{widgetId=" + this.f30188a + ", widgetInfo=" + this.f30189b + ", pendingIntent=" + this.f30190c + ", intent=" + this.f30191d + ", fgBitmap=" + this.f30192e + ", bgBitmap=" + this.f30193f + ", location=" + this.f30194g + ", cornerRadius=" + this.f30195h + '}';
    }
}
