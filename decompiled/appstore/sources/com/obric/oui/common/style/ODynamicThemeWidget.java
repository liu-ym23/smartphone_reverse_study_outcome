package com.obric.oui.common.style;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u0000 \n2\u00020\u0001:\u0001\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/obric/oui/common/style/ODynamicThemeWidget;", "", "", "themeStyle", "", "applyDynamicTheme", "(I)V", "", "isDarkTheme", "()Z", "Companion", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ODynamicThemeWidget {

    @NotNull
    public static final a Companion = null;
    public static final int DARK_THEME = 2;
    public static final int DEFAULT_THEME = 0;
    public static final int LIGHT_THEME = 1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f12964a = null;

        static {
            f12964a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f12964a;
    }

    void applyDynamicTheme(int r10);

    boolean isDarkTheme();
}
