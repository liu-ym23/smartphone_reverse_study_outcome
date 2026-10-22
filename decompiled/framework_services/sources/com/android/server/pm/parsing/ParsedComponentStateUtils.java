package com.android.server.pm.parsing;

import android.util.Pair;
import com.android.internal.pm.pkg.component.ParsedComponent;
import com.android.server.pm.pkg.PackageStateInternal;

/* JADX INFO: loaded from: classes2.dex */
public class ParsedComponentStateUtils {
    public ParsedComponentStateUtils() {
    }

    public static Pair<CharSequence, Integer> getNonLocalizedLabelAndIcon(ParsedComponent component, PackageStateInternal pkgSetting, int userId) {
        CharSequence label = component.getNonLocalizedLabel();
        int icon = component.getIcon();
        if (pkgSetting != null) goto L5;
        Pair<String, Integer> overrideLabelIcon = null;
    L7:
        if (overrideLabelIcon == null) goto L15;
        if (overrideLabelIcon.first == null) goto L12;
        label = (CharSequence) overrideLabelIcon.first;
    L12:
        if (overrideLabelIcon.second == null) goto L15;
        icon = ((Integer) overrideLabelIcon.second).intValue();
    L15:
        return Pair.create(label, Integer.valueOf(icon));
    L5:
        overrideLabelIcon = pkgSetting.getUserStateOrDefault(userId).getOverrideLabelIconForComponent(component.getComponentName());
        goto L7
    }
}
