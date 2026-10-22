package com.airbnb.lottie.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.MutablePair;
import com.airbnb.lottie.utils.Logger;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class FontAssetManager {
    private final AssetManager assetManager;
    private String defaultFontFileExtension;
    private FontAssetDelegate delegate;
    private final Map<String, Typeface> fontFamilies;
    private final Map<MutablePair<String>, Typeface> fontMap;
    private final MutablePair<String> tempPair;

    public FontAssetManager(Drawable.Callback r2, FontAssetDelegate r3) {
        this.tempPair = new MutablePair();
        this.fontMap = new HashMap();
        this.fontFamilies = new HashMap();
        this.defaultFontFileExtension = ".ttf";
        this.delegate = r3;
        if ((r2 instanceof View) == true) goto L6;
        Logger.warning("LottieDrawable must be inside of a view for images to work.");
        this.assetManager = null;
        return;
    L6:
        this.assetManager = ((View) r2).getContext().getAssets();
    }

    public void setDelegate(FontAssetDelegate r1) {
        this.delegate = r1;
    }

    public void setDefaultFontFileExtension(String r1) {
        this.defaultFontFileExtension = r1;
    }

    public Typeface getTypeface(Font r4) {
        this.tempPair.set(r4.getFamily(), r4.getStyle());
        Typeface r0 = this.fontMap.get(this.tempPair);
        if (r0 == null) goto L5;
        return r0;
    L5:
        Typeface r5 = typefaceForStyle(getFontFamily(r4), r4.getStyle());
        this.fontMap.put(this.tempPair, r5);
        return r5;
    }

    private Typeface getFontFamily(Font r6) {
        String r0 = r6.getFamily();
        Typeface r1 = this.fontFamilies.get(r0);
        if (r1 == null) goto L5;
        return r1;
    L5:
        String r2 = r6.getStyle();
        String r3 = r6.getName();
        FontAssetDelegate r4 = this.delegate;
        if (r4 == null) goto L10;
        Typeface r5 = r4.fetchFont(r0, r2, r3);
        if (r5 != null) goto L11;
        r5 = this.delegate.fetchFont(r0);
    L11:
        FontAssetDelegate r7 = this.delegate;
        if (r7 == null) goto L20;
        if (r5 != null) goto L20;
        String r8 = r7.getFontPath(r0, r2, r3);
        if (r8 != null) goto L17;
        r8 = this.delegate.getFontPath(r0);
    L17:
        if (r8 == null) goto L20;
        r5 = Typeface.createFromAsset(this.assetManager, r8);
    L20:
        if (r6.getTypeface() != null) goto L22;
        if (r5 != null) goto L25;
        r5 = Typeface.createFromAsset(this.assetManager, "fonts/" + r0 + this.defaultFontFileExtension);
    L25:
        this.fontFamilies.put(r0, r5);
        return r5;
    L22:
        return r6.getTypeface();
    L10:
        r5 = null;
        goto L11
    }

    private Typeface typefaceForStyle(Typeface r2, String r3) {
        boolean r1 = r3.contains("Italic");
        boolean r4 = r3.contains("Bold");
        if (r1 == false) goto L6;
        if (r4 == false) goto L6;
        int r5 = 3;
    L12:
        if (r2.getStyle() != r5) goto L15;
        return r2;
    L15:
        return Typeface.create(r2, r5);
    L6:
        if (r1 == false) goto L8;
        r5 = 2;
        goto L12
    L8:
        if (r4 == false) goto L10;
        r5 = 1;
        goto L12
    L10:
        r5 = 0;
        goto L12
    }
}
