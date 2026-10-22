package obric.api;

import android.util.Singleton;

/* JADX INFO: loaded from: classes5.dex */
public class ActionModeSmt {
    public static final int MENU_NO_ADDITIONAL = 255;
    public static final int MENU_NO_DICT = 1;
    public static final int MENU_NO_SEARCH = 2;
    public static final int MENU_NO_SHARE = 4;
    public static final int MENU_NO_SNIPPET = 8;
    static final String TAG = "ActionModeSmt";
    private static final Singleton<ActionModeSmt> sActionModeSmt = null;

    public static int get_MENU_NO_DICT() {
        return 1;
    }

    public static int get_MENU_NO_SEARCH() {
        return 2;
    }

    public static int get_MENU_NO_SHARE() {
        return 4;
    }

    /* synthetic */ ActionModeSmt(AnonymousClass1 r1) {
        this();
    }

    static {
        sActionModeSmt = new AnonymousClass1();
    }

    public static ActionModeSmt getInstance() {
        return (ActionModeSmt) sActionModeSmt.get();
    }

    private ActionModeSmt() {
    }
}
