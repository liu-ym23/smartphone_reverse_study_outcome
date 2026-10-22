package w;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f6056a;

    /* renamed from: b, reason: collision with root package name */
    public final Configuration f6057b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6058c;

    public h(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
        this.f6056a = colorStateList;
        this.f6057b = configuration;
        this.f6058c = theme == null ? 0 : theme.hashCode();
    }
}
