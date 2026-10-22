package com.obric.oui.common.style;

import kotlin.Metadata;

/* JADX INFO: compiled from: ODynamicThemeWidget.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/obric/oui/common/style/ODynamicThemeWidget;", "", "applyDynamicTheme", "", "themeStyle", "", "isDarkTheme", "", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ODynamicThemeWidget {
    public static final Companion Companion = null;
    public static final int DARK_THEME = 2;
    public static final int DEFAULT_THEME = 0;
    public static final int LIGHT_THEME = 1;

    /* JADX INFO: compiled from: ODynamicThemeWidget.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/common/style/ODynamicThemeWidget$Companion;", "", "()V", "DARK_THEME", "", "DEFAULT_THEME", "LIGHT_THEME", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int DARK_THEME = 2;
        public static final int DEFAULT_THEME = 0;
        public static final int LIGHT_THEME = 1;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void applyDynamicTheme(int r1);

    boolean isDarkTheme();
}
