package C;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f264a;

    /* renamed from: b, reason: collision with root package name */
    public final Configuration f265b;

    /* renamed from: c, reason: collision with root package name */
    public final int f266c;

    public l(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
        this.f264a = colorStateList;
        this.f265b = configuration;
        this.f266c = theme == null ? 0 : theme.hashCode();
    }
}
